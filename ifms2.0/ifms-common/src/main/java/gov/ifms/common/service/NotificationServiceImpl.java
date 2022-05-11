package gov.ifms.common.service;

import com.filenet.api.core.Document;
import com.filenet.api.util.Id;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.CommonConstant;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.*;
import gov.ifms.common.email.dto.Email;
import gov.ifms.common.email.service.EmailService;
import gov.ifms.common.entity.*;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;

import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.repository.*;
import gov.ifms.common.util.*;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.LinkedCaseInsensitiveMap;

import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import static java.util.stream.Collectors.*;

@Service
public class NotificationServiceImpl implements NotificationService {

	private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

	@Value("${workflow.url}")
	private String workflowApiUrl;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private NotificationTodoRepository ntfTodoRepository;

	@Autowired
	private NotificationPreferenceRepository ntfPreferenceRepository;

	@Autowired
	private SystemNotificationRepository snRepository;

	@Autowired
	private NotificationTemplateRepository nTemplateRepository;

	@Autowired
	private NotificationTransactionRepository nTransactionRepository;

	@Autowired
	private EmailService emailService;

	@Autowired
	private SMSServices smsServices;

	@Autowired
	private EncryptDecryptUtil securityUtil;

	@Value("classpath:/mail-logo.png")
	Resource resourceFile;

	@Value("${sms.service.enable}")
	private boolean isSmsServiceEnable;

	/**
	 * setEntityManager
	 *
	 * @param entityManager
	 */
	@PersistenceContext
	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * getEntityManager
	 *
	 * @return EntityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param notificationFatchDTO
	 * @return Map of snList and todoCountList.
	 */
	@Override
	public Map<String, Object> getNotification(NotificationFatchDTO notificationFatchDTO) {
		logger.info("Inside getNotification Method Input {}", notificationFatchDTO);
		Map<String, Object> resultMap = new HashMap<>();
		logger.info("Inside getNotification Method listOfUserIdList {}", notificationFatchDTO.getUserId());
		logger.info("Inside getNotification Method : Call Notification Preference");
		NotificationPreferenceEntity ntfPreferenceEntity = ntfPreferenceRepository
				.getPreferenceByUserId(decryptUserId(notificationFatchDTO.getUserId()));// Need to check.for UserId.
		// Fetch Data From SN Table.
		logger.info("Inside getNotification Method : Call System Notification");
		if (ntfPreferenceEntity == null || ntfPreferenceEntity.getIsSn() == 1) {
			List<SystemNotificationEntity> snList = snRepository.getSNByPOUList(notificationFatchDTO.getListOfMenu(), notificationFatchDTO.getPouId());
			resultMap.put("snList", snList);
		}
		logger.info("Inside getNotification Method : Call Notification Todo");
		List<CountBaseOnMenuDTO> todoCountList = ntfTodoRepository.getCountBaseOnMenu(notificationFatchDTO.getListOfMenu(),  notificationFatchDTO.getPouId());
		resultMap.put("todoCountList", todoCountList);
		return resultMap;
	}

	/**
	 * @param notificationPostDTO
	 * @throws CustomException
	 */
	@Async
	@Transactional
	@Override
	public void postNotification(NotificationPostDTO notificationPostDTO, String token) throws CustomException, UnsupportedEncodingException, NoSuchAlgorithmException {
		logger.info("Inside postNotification Method Input {}", notificationPostDTO);

		// Fetch Data from Template Table as per Menu_ID,Event_Category,Event_Name
		NotificationTemplate notificationTemplate = nTemplateRepository.getTemplate(notificationPostDTO.getMenuId(),
				notificationPostDTO.getEventCategory(), notificationPostDTO.getEventName());

		// call Sp with notificationpostDto. Remove Map
		logger.info("Inside postNotification Method : Call Stored Procedure");
		Map<String, Object> outputMap = callStoredProcedure(notificationPostDTO,
				notificationTemplate.getProcedureName());

		// Call Preference Table base on UserId.List of User Id.
		// Need to call from SP Otherwise need to pass AssignToUserId.
		logger.info("Inside postNotification Method : Check Notification Preference");
		NotificationPreferenceEntity ntfPreferenceEntity = ntfPreferenceRepository
				.getPreferenceByUserId((Long) outputMap.get("UserId"));

		// Call Attachment Services take file base on Document_Id or File system Path.
		logger.info("Inside postNotification Method : Download Attachment");
		File file = downloadAttachment((String) outputMap.get(Constant.FILE_ATTACHMENT_ID),
				(String) outputMap.get(Constant.FILE_NAME), token);

		// Convert Email and MSG Template into String.
		logger.info("Inside postNotification Method : Convert String Into Template");
		String snBody = converTemplateToString(outputMap, notificationTemplate.getSnBody());

		// Call Email Services
		logger.info("Inside postNotification Method : Email Service Call");
		if (ntfPreferenceEntity == null || ntfPreferenceEntity.getIsEmail() == 1) {
			sendEmail(notificationTemplate, outputMap, notificationPostDTO, file);// ntfPreferenceEntity.getIsEmail()
		}

		// Call SMS Services.
		logger.info("Inside postNotification Method : SMS Service Call");
		if (ntfPreferenceEntity == null || ntfPreferenceEntity.getIsSms() == 1) {
			sendSms(notificationTemplate, outputMap);// ntfPreferenceEntity.getIsSms()
		}

		Date createDate = new Date();

		NotificationTodoEntity notificationTodoEntity = new NotificationTodoEntity();
		notificationTodoEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		notificationTodoEntity.setListingMenuId(notificationPostDTO.getMenuId());
		notificationTodoEntity.setAssignByPouId(Long.valueOf(String.valueOf(outputMap.get(Constant.ASSIGN_BY_POU_ID))));
		notificationTodoEntity.setAssignToPouId(Long.valueOf(String.valueOf(outputMap.get(Constant.ASSIGN_TO_POU_ID))));
		notificationTodoEntity.setEventCategory(notificationPostDTO.getEventCategory());
		notificationTodoEntity.setEventName(notificationPostDTO.getEventName());
		notificationTodoEntity.setBranchId(notificationPostDTO.getBranchId());
		notificationTodoEntity.setCreatedBy(notificationPostDTO.getCreatedBy());
		notificationTodoEntity.setCreatedByPost(notificationPostDTO.getPouId());
		notificationTodoEntity.setTrnId(notificationPostDTO.getTrnId());
		notificationTodoEntity.setUpdatedByPost(notificationPostDTO.getPouId());
		notificationTodoEntity.setTrnNo(String.valueOf(outputMap.get(Constant.TRN_NO)));
		notificationTodoEntity.setCreatedDate(createDate);
		notificationTodoEntity.setUpdatedDate(createDate);
		notificationTodoEntity.setAssignDate(new Date());
		notificationTodoEntity.setOfficeId(notificationPostDTO.getOfficeId());
		notificationTodoEntity.setWfRole(notificationPostDTO.getRoleId());
		ntfTodoRepository.save(notificationTodoEntity);

		logger.info("Inside postNotification Method : Save System Notification");
		if (outputMap.containsKey(Constant.TO_SN_POU_IDS) && outputMap.get(Constant.TO_SN_POU_IDS) != null) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 1);
			Date expireDate = cal.getTime();
			String toSnPOUIds = (String) outputMap.get(Constant.TO_SN_POU_IDS);
			for (String snPOUId : converteStringIntoStringArray(toSnPOUIds)) {
				SystemNotificationEntity systemNotificationEntity = new SystemNotificationEntity();
				systemNotificationEntity.setTrnId(notificationPostDTO.getTrnId());
				systemNotificationEntity.setTrnNo(String.valueOf(outputMap.get(Constant.TRN_NO)));
				systemNotificationEntity.setActiveStatus(Constant.ACTIVE_STATUS);
				systemNotificationEntity.setMenuId(notificationPostDTO.getMenuId());
				systemNotificationEntity.setEventCategory(notificationPostDTO.getEventCategory());
				systemNotificationEntity.setEventName(notificationPostDTO.getEventName());
				systemNotificationEntity.setStatus(Constant.UN_READ);
				systemNotificationEntity.setSnMsg(snBody);
				systemNotificationEntity.setExpireDate(notificationPostDTO.getExpiredDate() != null ? notificationPostDTO.getExpiredDate() : expireDate);
				systemNotificationEntity.setAssignByPouId(Long.valueOf(String.valueOf(outputMap.get(Constant.ASSIGN_BY_POU_ID))));
				systemNotificationEntity.setAssignToPouId(Long.valueOf(snPOUId.trim()));
				systemNotificationEntity.setCreatedBy(notificationPostDTO.getCreatedBy());
				systemNotificationEntity.setCreatedByPost(notificationPostDTO.getPouId());
				systemNotificationEntity.setUpdatedBy(notificationPostDTO.getCreatedBy());
				systemNotificationEntity.setUpdatedByPost(notificationPostDTO.getPouId());
				systemNotificationEntity.setCreatedDate(createDate);
				systemNotificationEntity.setUpdatedDate(createDate);
				systemNotificationEntity.setOfficeId(notificationPostDTO.getOfficeId());
				snRepository.save(systemNotificationEntity);
			}
		}
		// Store Data in Notification Transaction Table.
		logger.info("Inside postNotification Method : Save Notification Transaction");
		NotificationTransactionEntity notificationTransactionEntity = new NotificationTransactionEntity();
		notificationTransactionEntity.setTrnId(notificationPostDTO.getTrnId());
		notificationTransactionEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		notificationTransactionEntity.setTrnNo(String.valueOf(outputMap.get(Constant.TRN_NO)));
		notificationTransactionEntity.setEventCategory(notificationPostDTO.getEventCategory());
		notificationTransactionEntity.setEventName(notificationPostDTO.getEventName());
		notificationTransactionEntity.setMenuId(notificationPostDTO.getMenuId());
		notificationTransactionEntity.setToEmailIds(String.valueOf(outputMap.get(Constant.TO_EMAIL_IDS)));
		notificationTransactionEntity.setCcEmailIds(String.valueOf(outputMap.get(Constant.CC_EMAIL_IDS)));
		notificationTransactionEntity.setBccEmailIds(String.valueOf(outputMap.get(Constant.BCC_EMAIL_IDS)));
		notificationTransactionEntity.setToMobiles(String.valueOf(outputMap.get(Constant.TO_MOBILES)));
		notificationTransactionEntity.setToSnPOUIds(String.valueOf(outputMap.get(Constant.TO_SN_POU_IDS)));
		notificationTransactionEntity.setFileName(String.valueOf(outputMap.get(Constant.FILE_NAME)));
		notificationTransactionEntity.setFileAttachmentId(String.valueOf(outputMap.get(Constant.FILE_ATTACHMENT_ID)));
		notificationTransactionEntity.setUploadedFilePath(null);
		notificationTransactionEntity.setAssignToPouId(Long.valueOf(String.valueOf(outputMap.get(Constant.ASSIGN_TO_POU_ID))));
		notificationTransactionEntity.setAssignByPouId(Long.valueOf(String.valueOf(outputMap.get(Constant.ASSIGN_BY_POU_ID))));
		notificationTransactionEntity.setCreatedBy(notificationPostDTO.getCreatedBy());
		notificationTransactionEntity.setCreatedByPost(notificationPostDTO.getPouId());
		notificationTransactionEntity.setCreatedDate(createDate);
		notificationTransactionEntity.setUpdatedBy(notificationPostDTO.getCreatedBy());
		notificationTransactionEntity.setUpdatedByPost(notificationPostDTO.getPouId());
		notificationTransactionEntity.setUpdatedDate(createDate);
		nTransactionRepository.save(notificationTransactionEntity);
	}

	/**
	 * @param notificationPostDTO
	 * @param procedureName
	 * @return Map of mandatory parameter(ASSIGN_TO_POU_ID,ASSIGN_BY_POU_ID,
	 *         TRN_NO,TO_EMAIL_IDS,TO_MOBILES,TO_SN_POU_IDS,FILE_NAME,FILE_ATTACHMENT_ID)
	 *         and Dynamic Parameter name and value Required for all SMS,Email and
	 *         SN
	 */
	public Map<String, Object> callStoredProcedure(NotificationPostDTO notificationPostDTO, String procedureName) {
		logger.info("Inside callStoredProcedure Method Input ProcedureName Name {}", procedureName);
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("IN_TRN_ID", notificationPostDTO.getTrnId());
		inputMap.put("IN_MENU_ID", notificationPostDTO.getMenuId());
		inputMap.put("IN_EVENT_CATEGORY", notificationPostDTO.getEventCategory());
		inputMap.put("IN_EVENT_NAME", notificationPostDTO.getEventName());
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(procedureName);

		for (Map.Entry<String, Object> entry : inputMap.entrySet()) {
			checkInstance(entry, query);
			query.setParameter(entry.getKey(), entry.getValue());
		}

		query.registerStoredProcedureParameter("getResult", Class.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter(Constant.ASSIGN_TO_POU_ID, Integer.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter(Constant.ASSIGN_BY_POU_ID, Integer.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter(Constant.TRN_NO, String.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter(Constant.TO_EMAIL_IDS, String.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter(Constant.TO_MOBILES, String.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter(Constant.TO_SN_POU_IDS, String.class, ParameterMode.OUT);

		// execute SP
		query.execute();

		// Set Sp output into Map.
		Map<String, Object> outputMap = new HashMap<>();

		outputMap.put(Constant.ASSIGN_TO_POU_ID,  query.getOutputParameterValue(Constant.ASSIGN_TO_POU_ID));
		outputMap.put(Constant.ASSIGN_BY_POU_ID,  query.getOutputParameterValue(Constant.ASSIGN_BY_POU_ID));
		outputMap.put(Constant.TRN_NO, query.getOutputParameterValue(Constant.TRN_NO).toString());
		outputMap.put(Constant.TO_EMAIL_IDS, query.getOutputParameterValue(Constant.TO_EMAIL_IDS).toString());
		outputMap.put(Constant.TO_MOBILES, query.getOutputParameterValue(Constant.TO_MOBILES).toString());
		outputMap.put(Constant.TO_SN_POU_IDS, query.getOutputParameterValue(Constant.TO_SN_POU_IDS).toString());
		outputMap.put(Constant.FILE_NAME, "sc.png;PFNominationsforms.pdf");// Dummy Set For Testing
		// .30B63672-0000-CD29-AB3A-D5CB9A577B60
		outputMap.put(Constant.FILE_ATTACHMENT_ID,
				"30B63672-0000-CD29-AB3A-D5CB9A577B60;0007BB71-0000-CC15-8466-084E8152704F");// Dummy Set For Testing
		// .0007BB71-0000-CC15-8466-084E8152704F
		List<Object[]> list = query.getResultList();

		for (Object[] obj : list) {
			outputMap.put((String) obj[0], obj[1]);
		}
		logger.info("Inside callStoredProcedure Method Output {}", outputMap);
		return outputMap;
	}

	/**
	 * @param documentDataKey : Pass Comma Separated Document Id(Filenate Id)
	 * @param fileName        : Pass Comma Separated File Name
	 * @param token
	 * @return Downloaded file from filenate Server.
	 * @throws CustomException
	 */
	public File downloadAttachment(String documentDataKey, String fileName, String token) throws CustomException {
		logger.info("Inside downloadAttachment Method Input Document Key {}", documentDataKey);
		logger.info("Inside downloadAttachment Method Input File Name {}", fileName);
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = getHeaderDetails(token);
			Map<String, Object> map = new HashMap<>();
			String[] documentDataKeyList = converteStringIntoStringArray(documentDataKey);
			String[] fileNameList = converteStringIntoStringArray(fileName);

			if (documentDataKeyList.length == 1) {
				logger.info(getWfSubmitApi(URLConstant.URL_ATTACHMENT_BASEURL.concat(URLConstant.URL_SLASH)
						.concat(URLConstant.URL_FILENET_DOWNLOADATTACHMENT)));
				map.put("documentDataKey", documentDataKeyList[0]);
				map.put("fileName", fileNameList[0]);
				HttpEntity<Map<String, Object>> request = new HttpEntity<>(map, headers);
				ResponseEntity<Resource> response = restTemplate
						.postForEntity(
								(getWfSubmitApi(
										URLConstant.URL_ATTACHMENT_BASEURL.concat(URLConstant.URL_SLASH)
												.concat(URLConstant.URL_FILENET_DOWNLOADATTACHMENT))),
								request, Resource.class);
				Resource body = response.getBody();
				InputStream inputStream = body !=null ? body.getInputStream() : null;
				File outfile = new File(fileName);
				OutputStream outputStream = new FileOutputStream(outfile);
				IOUtils.copy(inputStream, outputStream);
				return outfile;
			} else {
				// Multiple file Attachment.
				logger.info(getWfSubmitApi( URLConstant.URL_ATTACHMENT_BASEURL.concat(URLConstant.URL_SLASH)
						.concat(URLConstant.URL_FILENET_DOWNLOADATTACHMENT)));
				map.put("documentDataKey", documentDataKeyList);
				map.put("fileName", fileNameList);
				HttpEntity<Map<String, Object>> request = new HttpEntity<>(map, headers);
				ResponseEntity<Resource> response = restTemplate.postForEntity(
						(getWfSubmitApi(URLConstant.URL_ATTACHMENT_BASEURL.concat(URLConstant.URL_SLASH)
								.concat(URLConstant.URL_MULTIPLE_DOWNLOADATTACHMENT))),
						request, Resource.class);
				InputStream inputStream = response.getBody().getInputStream();
				File outputfile = new File("file.zip");
				OutputStream outputStream = new FileOutputStream(outputfile);
				IOUtils.copy(inputStream, outputStream);
				return outputfile;
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(4003, "Error While Download Attachment from Filenet Server");// Need To crete
			// error message in
			// property file.
		}
	}

	/**
	 * @param token
	 * @return Http Header Object for Rest Request.
	 */
	public HttpHeaders getHeaderDetails(String token) {
		logger.info("Inside getHeaderDetails Method");
		HttpServletRequest httprequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(URLConstant.AUTHORIZATION, token);
		Cookie[] cookies = httprequest.getCookies();
		StringBuilder sb = new StringBuilder();
		for (Cookie cookie : cookies) {
			sb.append(cookie.getName()).append("=").append(cookie.getValue()).append("; ");
		}
		headers.set("Cookie", sb.toString());
		return headers;
	}

	/**
	 * @param wfUrl       : Rest Endpoint.
	 * @return
	 */
	public String getWfSubmitApi(String wfUrl) {
		logger.info("Inside getWfSubmitApi Method Input {}", wfUrl);
		return new StringBuilder(workflowApiUrl).append(wfUrl).toString();
	}

	/**
	 * @param notificationTemplate
	 * @param outputMap            : Pass Map of Dyanamic Value for Dynamic Template
	 *                             Variable.
	 * @param notificationPostDTO
	 * @param file                 : Attachment File
	 * @throws CustomException
	 */
	public void sendEmail(NotificationTemplate notificationTemplate, Map<String, Object> outputMap,
						  NotificationPostDTO notificationPostDTO, File file) throws CustomException {
		logger.info("Inside sendEmail Method");
		if (notificationTemplate.getIsEmail() == 1) {
			// Convert Email and MSG Template into String.
			String emailBody = converTemplateToString(outputMap, notificationTemplate.getEmailBody());
			String emailSub = converTemplateToString(outputMap, notificationTemplate.getEmailSubject());

			Email email = new Email();
			email.setSubject(emailSub);
			email.setMessageText(emailBody);

			if (outputMap.containsKey("EMAIL_ID")) {
				String[] toEmailId = converteStringIntoStringArray((String) outputMap.get("EMAIL_ID"));
				email.setTo(toEmailId);
			} else if (outputMap.containsKey(Constant.TO_EMAIL_IDS)) {
				String toEmailIds = (String) outputMap.get(Constant.TO_EMAIL_IDS);
				String[] toEmailId = converteStringIntoStringArray(toEmailIds);
				email.setTo(toEmailId);
			}
			if (outputMap.get(Constant.CC_EMAIL_IDS) != null) {
				String ccEmailIds = (String) outputMap.get(Constant.CC_EMAIL_IDS);
				email.setCc(converteStringIntoStringArray(ccEmailIds));
			}
			if (outputMap.get(Constant.BCC_EMAIL_IDS) != null) {
				String bccEmailIds = (String) outputMap.get(Constant.BCC_EMAIL_IDS);
				email.setBcc(converteStringIntoStringArray(bccEmailIds));
			}
			File[] attachments = { file };

			try {
				if (outputMap.get(Constant.FILE_NAME) != null) {
					email.setFrom(MsgConstant.SEND_EMAIL_FROM);
					logger.info("Call Email Services Class sendMailWithAttachment method");
					emailService.sendMailWithAttachment(email, attachments);
				} else {
					logger.info("Call Email Services Class sendMailWithLogo method");
					emailService.sendMailWithLogo(email, resourceFile);
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
				throw new CustomException(4002, "Error While Sending Email"); // Need To crete error message in property
				// file.
			}
		}
	}

	/**
	 * @param notificationTemplate
	 * @param outputMap            : Pass Map of Dyanamic Value for Dynamic Template
	 *                             Variable.
	 *
	 */
	public void sendSms(NotificationTemplate notificationTemplate, Map<String, Object> outputMap) throws CustomException, UnsupportedEncodingException, NoSuchAlgorithmException {
		if (notificationTemplate.getIsSms() == 1 ) {
			String smsBody = converTemplateToString(outputMap, notificationTemplate.getSmsBody());
			String toMobiles = (String) outputMap.get("TO_MOBILES");
			String toMobile[] = converteStringIntoStringArray(toMobiles);
			for (String mobileNo : toMobile) {
				smsServices.sendSingleSMS(mobileNo,smsBody);
			}
		}
	}

	/**
	 * @param str : Pass Comma Separated String.
	 * @return Array Of String
	 */
	public String[] converteStringIntoStringArray(String str) {
		logger.info("Inside converteStringIntoStringArray Method Input {}", str);
		return StringUtils.hasLength(str) ? str.split(";") : new String[]{};
	}

	/**
	 * @param outputMap : Pass Map of Dyanamic Value for Dynamic Template Variable.
	 * @param template  : Pass Template String for Email,System Notification,SMS.
	 * @return HTML Template with Dynamic value as String.
	 * @throws CustomException
	 */
	public String converTemplateToString(Map<String, Object> outputMap, String template) throws CustomException {
		// Find Dynamic value from Template using ${} and Replace Dynamic Value of
		// Template.
		// Get your template as a String from the DB
		logger.info("Inside convert TemplateToStringForFree Method Input Template {}", template);
		List<String> dyVar = findDynamicVariable(template);
		for (String var : dyVar) {
			if (!outputMap.containsKey(var)) {
				outputMap.put(var, "");
			}
		}
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
		cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
		String htmlBody = null;
		try {
			Template t = new Template("templateName", new StringReader(template), cfg);
			htmlBody = FreeMarkerTemplateUtils.processTemplateIntoString(t, outputMap);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(4001, "Error While Converting String Into Template");// Need To crete error
			// message in property file.
		}
		logger.info("Inside converTemplateToStringForFree Method Output {}", htmlBody);
		return htmlBody;
	}

	/**
	 * @param str : Pass Template String for Email,System Notification,SMS
	 * @return List of Dynemic Variable.
	 */
	public List<String> findDynamicVariable(String str) {
		logger.info("Inside findDynamicVariable Method Input {}", str);
		Pattern p = Pattern.compile("\\$\\{([^}]+)\\}");
		Matcher m = p.matcher(str);
		List<String> dyVar = new LinkedList<>();
		while (m.find()) {
			String var = m.group();
			var = (String) var.subSequence(2, var.length() - 1);
			dyVar.add(var);
		}
		logger.info("Inside findDynamicVariable Method Output {}", dyVar);
		return dyVar;
	}

	/**
	 * @param preferenceFatchDTO
	 * @return Preference List
	 */
	@Override
	public Map<String, Object> getPreference(PreferenceFatchDTO preferenceFatchDTO) {
		logger.info("Inside getPreference Method");
		Map<String, Object> resultMap = new HashMap<>();
		List<NotificationPreferenceEntity> ntfPreferenceList = null;
		if (preferenceFatchDTO != null && preferenceFatchDTO.getListOfMenu() != null) {
			ntfPreferenceList = ntfPreferenceRepository.getPreference(this.decryptUserId(preferenceFatchDTO.getUserId()),
					preferenceFatchDTO.getListOfMenu());
		}
		resultMap.put("preferenceList", ntfPreferenceList);
		logger.info("Notification Get Preference {}", resultMap);
		return resultMap;
	}

	/**
	 * @param preferencePostDTO
	 */
	@Override
	@Transactional
	public void postPreference(PreferencePostDTO preferencePostDTO) {
		logger.info("Inside postPreference Method");
		Long createdByUserId = decryptUserId(preferencePostDTO.getCreatedByUserId());
		if (preferencePostDTO.getUserId() != null && preferencePostDTO.getPreferenceForMenu() != null) {
			Date date = new Date();
			NotificationPreferenceEntity notificationPreferenceEntity;
			for (PreferenceForMenu preferenceForMenu : preferencePostDTO.getPreferenceForMenu()) {
				notificationPreferenceEntity= new NotificationPreferenceEntity();
				notificationPreferenceEntity.setUserId(preferencePostDTO.getUserId());
				notificationPreferenceEntity.setIsSms(preferenceForMenu.getIsSms());
				notificationPreferenceEntity.setUserId(preferencePostDTO.getUserId());
				notificationPreferenceEntity.setIsEmail(preferenceForMenu.getIsEmail());
				notificationPreferenceEntity.setIsSn(preferenceForMenu.getIsSn());
				notificationPreferenceEntity.setMenuId(preferenceForMenu.getMenuId());
				notificationPreferenceEntity.setActiveStatus(preferenceForMenu.getActiveStatus());
				notificationPreferenceEntity.setCreatedBy(createdByUserId);
				notificationPreferenceEntity.setCreatedByPost(preferencePostDTO.getCreatedByPost());
				notificationPreferenceEntity.setCreatedDate(date);
				notificationPreferenceEntity.setUpdatedBy(createdByUserId);
				notificationPreferenceEntity.setUpdatedByPost(preferencePostDTO.getCreatedByPost());
				notificationPreferenceEntity.setUpdatedDate(date);
				ntfPreferenceRepository.save(notificationPreferenceEntity);
			}
		}
		logger.info("Notification Preference Save Successfully");
	}

	/**
	 * @param templateFatchDTO
	 * @return map of notificationTemplate.
	 */
	@Override
	public Map<String, Object> getTemplate(TemplateFatchDTO templateFatchDTO) {
		logger.info("Inside getTemplate Method");
		Map<String, Object> resultMap = new HashMap<>();
		NotificationTemplate notificationTemplate = null;
		if (templateFatchDTO != null) {
			notificationTemplate = nTemplateRepository.getTemplate(templateFatchDTO.getMenuId(),
					templateFatchDTO.getEventCategory(), templateFatchDTO.getEventName());
		}
		resultMap.put("notificationTemplate", notificationTemplate);
		logger.info("Notification Get Template {}", resultMap);
		return resultMap;
	}

	/**
	 * @param templatePostDTO
	 */
	@Override
	public void postTemplate(TemplatePostDTO templatePostDTO) {
		logger.info("Inside postTemplate Method");
		if (templatePostDTO != null) {
			NotificationTemplate notificationTemplate = new NotificationTemplate();
			BeanUtils.copyProperties(templatePostDTO, notificationTemplate);
			nTemplateRepository.save(notificationTemplate);
		}
		logger.info("Notification Template Save Successfully");
	}

	/**
	 * @param entry : Pass Entry Object of Input Parameter
	 * @param query : Stored Procedure Query
	 * @return StoredProcedureQuery
	 */
	public StoredProcedureQuery checkInstance(Entry<String, Object> entry, StoredProcedureQuery query) {
		if (entry.getValue() instanceof Integer) {
			query.registerStoredProcedureParameter(entry.getKey(), Integer.class, ParameterMode.IN);
		} else if (entry.getValue() instanceof String) {
			query.registerStoredProcedureParameter(entry.getKey(), String.class, ParameterMode.IN);
		} else {
			query.registerStoredProcedureParameter(entry.getKey(), Long.class, ParameterMode.IN);
		}
		return query;
	}

	Long decryptUserId(Object userId) {
		if (userId instanceof Integer || userId instanceof Long) {
			return Long.valueOf(String.valueOf(userId));
		} else if (userId instanceof String) {
			return Long.parseLong(securityUtil.decrypt(String.valueOf(userId)));
		} else {
			return null;
		}
	}





	@Async
	@Transactional
	@Override
	public void v2PostNotificationRequestParam(NotificationPostDTO notificationPostDTO) throws Exception {
		NotificationTemplate notificationTemplate = getNotificationTemplate(notificationPostDTO.getMenuId(), notificationPostDTO.getEventCategory(), notificationPostDTO.getEventName(), Constant.ACTIVE_STATUS);
		String procedureName = notificationTemplate.getProcedureName();
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("IN_TRN_ID", notificationPostDTO.getTrnId());
		inputMap.put("IN_MENU_ID", notificationPostDTO.getMenuId());
		inputMap.put("IN_EVENT_CATEGORY", notificationPostDTO.getEventCategory());
		inputMap.put("IN_EVENT_NAME", notificationPostDTO.getEventName());
		inputMap.put("IN_ASSIGN_TO_POU_ID", notificationPostDTO.getAssignToPOUId());
		Map<String, Object> stringObjectMap = nTemplateRepository.callStoredProcedureMap(procedureName, inputMap);
		List<LinkedHashMap<String, Object>> map = (List<LinkedHashMap<String, Object>>) stringObjectMap.get("#result-set-1");
		Map<String, Object> outPutMap = map.get(0);
		File[] file = null;
		if(outPutMap.containsKey("DOCUMENT_KEY")) {
			String[] documentDataKeyList = converteStringIntoStringArray(String.valueOf(outPutMap.get("DOCUMENT_KEY")));
			String[] fileNameList = converteStringIntoStringArray(String.valueOf(outPutMap.get("FILE_NAME")));
			if (documentDataKeyList.length == 1) {
				Id id = new Id(documentDataKeyList[0]);
				Document document = FilenetUtility.retrieveDocument(id);
				InputStreamResource inputStreamResource = new InputStreamResource(document.accessContentStream(0));
				File outfile = new File(fileNameList[0]);
				OutputStream outputStream = new FileOutputStream(outfile);
				IOUtils.copy(inputStreamResource.getInputStream(), outputStream);
				file = new File[1];
				file[0] = outfile;
			} else {
				ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
				ZipOutputStream zipOutputStream = new ZipOutputStream(byteOutputStream);
				int i = 0;
				for(String documentDataKey : documentDataKeyList) {
					Id id = new Id(documentDataKey);
					final Document document = FilenetUtility.retrieveDocument(id);
					final InputStream inputStream = document.accessContentStream(0);
					zipOutputStream.putNextEntry(new ZipEntry(i+"_"+fileNameList[i]));
					IOUtils.copy(inputStream, zipOutputStream);
					zipOutputStream.closeEntry();
					i++;
				}
				zipOutputStream.close();
				byteOutputStream.toByteArray();
				InputStreamResource inputStreamResource = new InputStreamResource(new ByteArrayInputStream(byteOutputStream.toByteArray()));
				File outPutFile = new File("File.zip");
				OutputStream outputStream = new FileOutputStream(outPutFile);
				IOUtils.copy(inputStreamResource.getInputStream(), outputStream);
				file = new File[1];
				file[0] = outPutFile;
			}
		}
		sendMailUtility(notificationTemplate, outPutMap ,file);
		sendSMSUtility(notificationTemplate, outPutMap);
		String[] toPOUId = notificationPostDTO.getAssignToPOUId().split("\\,");
		for (String assignToPoUID : toPOUId) {
			NotificationPreferenceEntity preferenceByUserId = getNotificationPreferenceEntity(Long.valueOf(assignToPoUID));
			saveTodoEntity(notificationPostDTO, outPutMap, assignToPoUID);
			saveNotificationTransactionEntity(notificationPostDTO, outPutMap ,assignToPoUID);
			if (preferenceByUserId != null) {
				if(preferenceByUserId.getIsSn() == 1) {
					saveSystemNotification(notificationPostDTO, notificationTemplate, outPutMap, assignToPoUID);
				}
			}
		}
	}

	private void saveNotificationTransactionEntity(NotificationPostDTO notificationPostDTO, Map<String, Object> outPutMap, String assignToPoUID) {
		NotificationTransactionEntity notificationTransactionEntity = new NotificationTransactionEntity();
		notificationTransactionEntity.setTrnId(notificationPostDTO.getTrnId());
		notificationTransactionEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		notificationTransactionEntity.setTrnNo(String.valueOf(outPutMap.get(Constant.TRN_NO)));
		notificationTransactionEntity.setEventCategory(notificationPostDTO.getEventCategory());
		notificationTransactionEntity.setEventName(notificationPostDTO.getEventName());
		notificationTransactionEntity.setMenuId(notificationPostDTO.getMenuId());
		notificationTransactionEntity.setToEmailIds(String.valueOf(outPutMap.get(Constant.TO_EMAIL_IDS)));
		notificationTransactionEntity.setCcEmailIds(String.valueOf(outPutMap.get(Constant.CC_EMAIL_IDS)));
		notificationTransactionEntity.setBccEmailIds(String.valueOf(outPutMap.get(Constant.BCC_EMAIL_IDS)));
		notificationTransactionEntity.setToMobiles(String.valueOf(outPutMap.get(Constant.TO_MOBILES)));
		notificationTransactionEntity.setToSnPOUIds(String.valueOf(outPutMap.get(Constant.TO_SN_POU_IDS)));
		notificationTransactionEntity.setFileName(String.valueOf(outPutMap.get(Constant.FILE_NAME)));
		notificationTransactionEntity.setFileAttachmentId(String.valueOf(outPutMap.get(Constant.FILE_ATTACHMENT_ID)));
		notificationTransactionEntity.setUploadedFilePath(null);
		notificationTransactionEntity.setAssignToPouId(Long.valueOf(assignToPoUID));
		notificationTransactionEntity.setAssignByPouId(Long.valueOf(String.valueOf(outPutMap.get(Constant.ASSIGN_BY_POU_ID))));
		notificationTransactionEntity.setCreatedBy(notificationPostDTO.getCreatedBy());
		notificationTransactionEntity.setCreatedByPost(notificationPostDTO.getPouId());
		notificationTransactionEntity.setCreatedDate(new Date());
		notificationTransactionEntity.setUpdatedBy(notificationPostDTO.getCreatedBy());
		notificationTransactionEntity.setUpdatedByPost(notificationPostDTO.getPouId());
		notificationTransactionEntity.setUpdatedDate(new Date());
		nTransactionRepository.save(notificationTransactionEntity);
	}

	private void saveSystemNotification(NotificationPostDTO notificationPostDTO, NotificationTemplate notificationTemplate, Map<String, Object> outPutMap, String assignToPoUID) throws CustomException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, Constant.INT_ONE_VALUE);
		Date expireDate = cal.getTime();
		SystemNotificationEntity systemNotificationEntity = new SystemNotificationEntity();
		systemNotificationEntity.setTrnId(notificationPostDTO.getTrnId());
		systemNotificationEntity.setTrnNo(String.valueOf(outPutMap.get(Constant.TRN_NO)));
		systemNotificationEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		systemNotificationEntity.setMenuId(notificationPostDTO.getMenuId());
		systemNotificationEntity.setEventCategory(notificationPostDTO.getEventCategory());
		systemNotificationEntity.setEventName(notificationPostDTO.getEventName());
		systemNotificationEntity.setStatus(Constant.UN_READ);
		systemNotificationEntity.setSnMsg(converTemplateToString(outPutMap, notificationTemplate.getSnBody()));
		systemNotificationEntity.setExpireDate(notificationPostDTO.getExpiredDate() != null ? notificationPostDTO.getExpiredDate() : expireDate);
		systemNotificationEntity.setAssignByPouId(Long.valueOf(String.valueOf(outPutMap.get(Constant.ASSIGN_BY_POU_ID))));
		systemNotificationEntity.setAssignToPouId(Long.valueOf(assignToPoUID));
		systemNotificationEntity.setCreatedBy(notificationPostDTO.getCreatedBy());
		systemNotificationEntity.setCreatedByPost(notificationPostDTO.getPouId());
		systemNotificationEntity.setUpdatedBy(notificationPostDTO.getCreatedBy());
		systemNotificationEntity.setUpdatedByPost(notificationPostDTO.getPouId());
		systemNotificationEntity.setCreatedDate(new Date());
		systemNotificationEntity.setUpdatedDate(new Date());
		systemNotificationEntity.setOfficeId(notificationPostDTO.getOfficeId());
		snRepository.save(systemNotificationEntity);
	}

	private void saveTodoEntity(NotificationPostDTO notificationPostDTO, Map<String, Object> outPutMap, String assignToPoUID) {
		NotificationTodoEntity notificationTodoEntity = null;
		notificationTodoEntity = ntfTodoRepository.findByTrnIdAndListingMenuIdAndActiveStatus(notificationPostDTO.getTrnId(), notificationPostDTO.getMenuId(), Constant.ACTIVE_STATUS);
		if(notificationTodoEntity == null){
			notificationTodoEntity = new NotificationTodoEntity();
		}
		notificationTodoEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		notificationTodoEntity.setListingMenuId(notificationPostDTO.getMenuId());
		notificationTodoEntity.setAssignByPouId(Long.valueOf(assignToPoUID));
		notificationTodoEntity.setAssignToPouId(Long.valueOf(assignToPoUID));
		notificationTodoEntity.setEventCategory(notificationPostDTO.getEventCategory());
		notificationTodoEntity.setEventName(notificationPostDTO.getEventName());
		notificationTodoEntity.setBranchId(notificationPostDTO.getBranchId());
		notificationTodoEntity.setCreatedBy(notificationPostDTO.getCreatedBy());
		notificationTodoEntity.setCreatedByPost(notificationPostDTO.getPouId());
		notificationTodoEntity.setTrnId(notificationPostDTO.getTrnId());
		notificationTodoEntity.setUpdatedByPost(notificationPostDTO.getPouId());
		notificationTodoEntity.setTrnNo(String.valueOf(outPutMap.get("REFERENCE_NO")));
		notificationTodoEntity.setCreatedDate(new Date());
		notificationTodoEntity.setUpdatedDate(new Date());
		notificationTodoEntity.setAssignDate(new Date());
		notificationTodoEntity.setOfficeId(notificationPostDTO.getOfficeId());
		notificationTodoEntity.setWfRole(notificationPostDTO.getRoleId());
		ntfTodoRepository.save(notificationTodoEntity);
	}


	public NotificationPreferenceEntity getNotificationPreferenceEntity(Long aLong) {
		return ntfPreferenceRepository.getPreferenceByUserId(aLong);
	}


	private void sendMailUtility(NotificationTemplate notificationTemplate, Map<String, Object> outPutMap , File[] file) throws Exception {
		String emailBody = converTemplateToString(outPutMap, notificationTemplate.getEmailBody());
		String emailSub = converTemplateToString(outPutMap, notificationTemplate.getEmailSubject());
		Email email = new Email();
		email.setSubject(emailSub);
		email.setMessageText(emailBody);
		email.setFrom(MsgConstant.SEND_EMAIL_FROM);
		if (outPutMap.containsKey(Constant.TO_EMAIL_IDS) && StringUtils.hasLength(String.valueOf(outPutMap.get(Constant.TO_EMAIL_IDS)))) {
			email.setTo(converteStringIntoStringArray(String.valueOf(outPutMap.get(Constant.TO_EMAIL_IDS))));
		}
		if (StringUtils.hasLength(String.valueOf(outPutMap.get(Constant.CC_EMAIL_IDS))) && Objects.nonNull(outPutMap.get(Constant.CC_EMAIL_IDS))) {
			email.setCc(converteStringIntoStringArray(String.valueOf(outPutMap.get(Constant.CC_EMAIL_IDS))));
		}
		if (StringUtils.hasLength(String.valueOf(outPutMap.get(Constant.BCC_EMAIL_IDS))) && Objects.nonNull(outPutMap.get(Constant.BCC_EMAIL_IDS))) {
			email.setBcc(converteStringIntoStringArray(String.valueOf(outPutMap.get(Constant.BCC_EMAIL_IDS))));
		}
		if (file != null) {
			emailService.sendMailWithAttachment(email, file);
		} else {
			emailService.sendMailWithOutLogo(email);

		}
	}

	private void sendSMSUtility(NotificationTemplate notificationTemplate, Map<String, Object> outPutMap) throws CustomException, UnsupportedEncodingException, NoSuchAlgorithmException {
		if(isSmsServiceEnable) {
			if (notificationTemplate.getIsSms() == 1) {
				String smsBody = converTemplateToString(outPutMap, notificationTemplate.getSmsBody());
				String toMobiles = (String) outPutMap.get("TO_MOBILE_NO");
				String toMobile[] = converteStringIntoStringArray(toMobiles);
				for (String mobileNo : toMobile) {
					smsServices.sendSingleSMS(mobileNo, smsBody);
				}
			}
		}
	}

	private NotificationTemplate getNotificationTemplate(Long menuId, String eventCategory, String eventName, int activeStatus) throws CustomException {
		Optional<NotificationTemplate> notificationTemplate  = nTemplateRepository.findByMenuIdAndEventCategoryAndEventNameAndActiveStatus(menuId, eventCategory, eventName, activeStatus);
		if(notificationTemplate.isPresent()){
			return notificationTemplate.get();
		}
		throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
	}

	@Override
	public void v3postNotificationRequestParam(NotificationDto notificationDto) throws Exception {
		NotificationTemplate notificationTemplate = getNotificationTemplate(notificationDto.getListingMenuId(), notificationDto.getEventCategory(), notificationDto.getEventName(), Constant.ACTIVE_STATUS);
		String procedureName = notificationTemplate.getProcedureName();
		Map<String, Object> inputMap = new HashMap<>();
		inputMap = getCommonNotificationMap(notificationDto, inputMap);
		Map<String, Object> senderMap = nTemplateRepository.callStoredProcedureMap(CommonConstant.SP_NOTIFICATION_COMMON, inputMap);
		List<LinkedHashMap<String, Object>> map = (List<LinkedHashMap<String, Object>>) senderMap.get("#result-set-1");
		Map<String, Object> commonMap = map.get(0);
		inputMap.clear();
		Map<String, Object> moduleMap = new HashMap<>();
		if(org.springframework.util.StringUtils.hasLength(procedureName)){
			moduleMap = callModuleSpecificStoreProcedure(notificationDto, procedureName, inputMap);
		}
		List<LinkedHashMap<String, Object>> dynamicParam = (List<LinkedHashMap<String, Object>>) moduleMap.get("#result-set-1");
		File[] file = null;
		if(moduleMap.size() > 1) {
			List<LinkedCaseInsensitiveMap<String>> attachmentParam = (List<LinkedCaseInsensitiveMap<String>>) moduleMap.get("#result-set-2");
			file = getFileFromStoreProcedure(file, attachmentParam);
			commonMap.put(Constant.FILE_NAME ,attachmentParam.stream().map(e-> e.get(Constant.FILE_NAME)).collect(Collectors.joining(",")));
			commonMap.put(Constant.FILE_ATTACHMENT_ID , attachmentParam.stream().map(e-> e.get(Constant.DOCUMENT_KEY)).collect(Collectors.joining(",")));
		} else {
			file = getModuleInputFiles(notificationDto, file);
			String attachmentId = notificationDto.getFileAttachmentDtos().stream().map(e-> e.getDocumentKey())
					.collect(Collectors.joining(","));
			String fileName = notificationDto.getFileAttachmentDtos().stream().map(e-> e.getFileName())
					.collect(Collectors.joining(","));
			commonMap.put(Constant.FILE_NAME ,fileName);
			commonMap.put(Constant.FILE_ATTACHMENT_ID , attachmentId);
		}

		commonMap.putAll(dynamicParam.get(0));
		commonMap.putAll(notificationDto.getDynamicParam());
		sendMailUtility(notificationTemplate, commonMap ,file);
		sendSMSUtility(notificationTemplate, commonMap);
		saveV3TodoEntity(notificationDto, commonMap, notificationDto.getAssignToPOUId());
		saveV3NotificationTransactionEntity(notificationDto, commonMap ,notificationDto.getAssignToPOUId());
		List<PreferenceForMenu> toEmailSMSId = getPreferences(notificationDto.getListingMenuId(),notificationDto.getToEmailSMSPOUIds());
		for (PreferenceForMenu preferenceForMenu : toEmailSMSId) {
			if(preferenceForMenu.getIsSn() == 1) {
				saveV3SystemNotification(notificationDto, notificationTemplate, commonMap, notificationDto.getAssignToPOUId());
			}
		}
	}


    private void saveV3SystemNotification(NotificationDto notificationPostDTO, NotificationTemplate notificationTemplate, Map<String, Object> outPutMap, Long assignToPOUId) throws CustomException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, Constant.INT_ONE_VALUE);
		Date expireDate = cal.getTime();
		SystemNotificationEntity systemNotificationEntity = new SystemNotificationEntity();
		systemNotificationEntity.setTrnId(notificationPostDTO.getTrnId());
		systemNotificationEntity.setTrnNo(String.valueOf(outPutMap.get(Constant.TRN_NO)));
		systemNotificationEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		systemNotificationEntity.setMenuId(notificationPostDTO.getListingMenuId());
		systemNotificationEntity.setEventCategory(notificationPostDTO.getEventCategory());
		systemNotificationEntity.setEventName(notificationPostDTO.getEventName());
		systemNotificationEntity.setStatus(Constant.UN_READ);
		systemNotificationEntity.setSnMsg(converTemplateToString(outPutMap, notificationTemplate.getSnBody()));
		systemNotificationEntity.setExpireDate(notificationPostDTO.getExpiredDate() != null ? notificationPostDTO.getExpiredDate() : expireDate);
		systemNotificationEntity.setAssignByPouId(Long.valueOf(String.valueOf(outPutMap.get(Constant.ASSIGN_BY_POU_ID))));
		systemNotificationEntity.setAssignToPouId(notificationPostDTO.getAssignToPOUId());
		systemNotificationEntity.setCreatedBy(decryptUserId(notificationPostDTO.getUserId()));
		systemNotificationEntity.setCreatedByPost(notificationPostDTO.getAssignByPOUId());
		systemNotificationEntity.setUpdatedBy(decryptUserId(notificationPostDTO.getUserId()));
		systemNotificationEntity.setUpdatedByPost(notificationPostDTO.getAssignByPOUId());
		systemNotificationEntity.setCreatedDate(new Date());
		systemNotificationEntity.setUpdatedDate(new Date());
		systemNotificationEntity.setOfficeId(notificationPostDTO.getAssignByOfficeId());
		snRepository.save(systemNotificationEntity);

	}

	private void saveV3NotificationTransactionEntity(NotificationDto notificationPostDTO, Map<String, Object> outPutMap, Long assignToPOUId) {
		NotificationTransactionEntity notificationTransactionEntity = new NotificationTransactionEntity();
		notificationTransactionEntity.setTrnId(notificationPostDTO.getTrnId());
		notificationTransactionEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		if(outPutMap.containsKey(Constant.TRN_NO)) {
			notificationTransactionEntity.setTrnNo(String.valueOf(outPutMap.get(Constant.TRN_NO)));
		} else {
			notificationTransactionEntity.setTrnNo(notificationPostDTO.getTrnRefNo());
		}
		notificationTransactionEntity.setEventCategory(notificationPostDTO.getEventCategory());
		notificationTransactionEntity.setEventName(notificationPostDTO.getEventName());
		notificationTransactionEntity.setMenuId(notificationPostDTO.getListingMenuId());
		notificationTransactionEntity.setToEmailIds(String.valueOf(outPutMap.get(Constant.TO_EMAIL_IDS)));
		notificationTransactionEntity.setCcEmailIds(String.valueOf(outPutMap.get(Constant.CC_EMAIL_IDS)));
		notificationTransactionEntity.setBccEmailIds(String.valueOf(outPutMap.get(Constant.BCC_EMAIL_IDS)));
		notificationTransactionEntity.setToMobiles(String.valueOf(outPutMap.get(Constant.TO_MOBILES)));
		notificationTransactionEntity.setToSnPOUIds(String.valueOf(outPutMap.get(Constant.TO_SN_POU_IDS)));
		notificationTransactionEntity.setFileName(String.valueOf(outPutMap.get(Constant.FILE_NAME)));
		notificationTransactionEntity.setFileAttachmentId(String.valueOf(outPutMap.get(Constant.FILE_ATTACHMENT_ID)));
		notificationTransactionEntity.setUploadedFilePath(org.apache.commons.lang3.StringUtils.EMPTY);
		notificationTransactionEntity.setAssignToPouId(notificationPostDTO.getAssignToPOUId());
		notificationTransactionEntity.setAssignByPouId(notificationPostDTO.getAssignByPOUId());
		notificationTransactionEntity.setCreatedBy(decryptUserId(notificationPostDTO.getUserId()));
		notificationTransactionEntity.setCreatedByPost(notificationPostDTO.getAssignByPOUId());
		notificationTransactionEntity.setCreatedDate(new Date());
		notificationTransactionEntity.setUpdatedBy(decryptUserId(notificationPostDTO.getUserId()));
		notificationTransactionEntity.setUpdatedByPost(notificationPostDTO.getAssignByPOUId());
		notificationTransactionEntity.setUpdatedDate(new Date());
		nTransactionRepository.save(notificationTransactionEntity);

	}

	private void saveV3TodoEntity(NotificationDto notificationPostDTO, Map<String, Object> outPutMap, Long assignToPOUId) {
		NotificationTodoEntity notificationTodoEntity = null;
		notificationTodoEntity = ntfTodoRepository.findByListingMenuIdAndTrnIdAndActiveStatus(notificationPostDTO.getListingMenuId(),notificationPostDTO.getTrnId(),Constant.ACTIVE_STATUS);
		if(notificationTodoEntity != null){
			notificationTodoEntity.setTnfTodoId(notificationTodoEntity.getTnfTodoId());
		}else{
			notificationTodoEntity = new NotificationTodoEntity();
		}
		notificationTodoEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		notificationTodoEntity.setListingMenuId(notificationPostDTO.getListingMenuId());
		notificationTodoEntity.setAssignByPouId(notificationPostDTO.getAssignByPOUId());
		notificationTodoEntity.setAssignToPouId(assignToPOUId);
		notificationTodoEntity.setEventCategory(notificationPostDTO.getEventCategory());
		notificationTodoEntity.setEventName(notificationPostDTO.getEventName());
		notificationTodoEntity.setBranchId(notificationPostDTO.getBranchId());
		notificationTodoEntity.setCreatedBy(decryptUserId(notificationPostDTO.getUserId()));
		notificationTodoEntity.setCreatedByPost(notificationPostDTO.getAssignByPOUId());
		notificationTodoEntity.setTrnId(notificationPostDTO.getTrnId());
		notificationTodoEntity.setUpdatedBy(decryptUserId(notificationPostDTO.getUserId()));
		notificationTodoEntity.setUpdatedByPost(notificationPostDTO.getAssignByPOUId());
		if(outPutMap.containsKey(Constant.TRN_NO)) {
			notificationTodoEntity.setTrnNo(String.valueOf(outPutMap.get(Constant.TRN_NO)));
		} else {
			notificationTodoEntity.setTrnNo(notificationPostDTO.getTrnRefNo());
		}
		notificationTodoEntity.setCreatedDate(new Date());
		notificationTodoEntity.setUpdatedDate(new Date());
		notificationTodoEntity.setAssignDate(new Date());
		notificationTodoEntity.setOfficeId(notificationPostDTO.getAssignByOfficeId());
		notificationTodoEntity.setWfRole(notificationPostDTO.getRoleId());
		ntfTodoRepository.save(notificationTodoEntity);
	}

	private List<PreferenceForMenu> getPreferences(long menuId, Set<Long> pouId) throws CustomException {
		StringBuilder preferenceQuery= new StringBuilder();
		preferenceQuery.append(" SELECT POU.LK_PO_OFF_USER_ID AS C0,PF.IS_SMS AS C1 ,");
		preferenceQuery.append(" PF.IS_EMAIL AS C2 ,PF.IS_SN AS C3 , PF.USER_ID AS C4,PF.MENU_ID AS C5 ");
		preferenceQuery.append(" FROM edp.TNF_PREFERENCE pf INNER JOIN  ");
		preferenceQuery.append(" MASTER_V1.LK_PO_OFF_USER pou ON POU.USER_ID  = pf.USER_ID ");
		preferenceQuery.append(" WHERE pf.MENU_ID = :menuId AND POU.LK_PO_OFF_USER_ID in(:pouIds)  AND pf.ACTIVE_STATUS =1 AND POU.ACTIVE_STATUS =1 ");
		Map<String ,Object> map = new HashMap<>();
		map.put("menuId" , menuId);
		map.put("pouIds" , pouId);
		return this.ntfPreferenceRepository.executeSQLQuery(preferenceQuery.toString(), map, PreferenceForMenu.class);
	}

	private Map<String, Object> getCommonNotificationMap(NotificationDto notificationDto, Map<String, Object> inputMap) {
		inputMap.put("IN_TRN_ID" , notificationDto.getTrnId());
		inputMap.put("IN_MENU_ID" , notificationDto.getListingMenuId());
		inputMap.put("IN_OFFICE_ID" , notificationDto.getAssignByOfficeId());
		inputMap.put("IN_ASSIGN_TO_POU_ID" , notificationDto.getAssignToPOUId());
		inputMap.put("IN_ASSIGN_BY_POU_ID" , notificationDto.getAssignByPOUId());
		inputMap.put("IN_ASSIGN_TO_OFFICE_ID" , notificationDto.getAssignToOfficeId());
		inputMap.put("IN_ASSIGN_BY_OFFICE_ID" , notificationDto.getAssignByOfficeId());
		inputMap.put("IN_EVENT_CATEGORY" , notificationDto.getEventCategory());
		inputMap.put("IN_EVENT_NAME" , notificationDto.getEventName());
		inputMap.put("IN_TO_POU_ID" ,org.apache.commons.lang3.StringUtils.join(notificationDto.getToEmailSMSPOUIds(), ","));
		inputMap.put("IN_CC_POU_ID" ,org.apache.commons.lang3.StringUtils.join(notificationDto.getCcEmailPOUIds(), ","));
		inputMap.put("IN_BCC_POU_ID",org.apache.commons.lang3.StringUtils.join(notificationDto.getBccEmailPOUIds(), ","));
		return inputMap;
	}

	private File[] getFileFromStoreProcedure(File[] file, List<LinkedCaseInsensitiveMap<String>> attachmentParam) throws IOException {
		if (attachmentParam.size() == 1) {
			String fileName = attachmentParam.get(0).get(Constant.FILE_NAME);
			Id id = new Id(String.valueOf(attachmentParam.get(0).get(Constant.DOCUMENT_KEY)));
			Document document = FilenetUtility.retrieveDocument(id);
			InputStreamResource inputStreamResource = new InputStreamResource(document.accessContentStream(0));
			File outfile = new File(fileName);
			OutputStream outputStream = new FileOutputStream(outfile);
			IOUtils.copy(inputStreamResource.getInputStream(), outputStream);
			file = new File[1];
			file[0] = outfile;
		} else {
			ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
			ZipOutputStream zipOutputStream = new ZipOutputStream(byteOutputStream);
			int i = 0;
			for (LinkedCaseInsensitiveMap documentDataKey : attachmentParam) {
				Id id = new Id(String.valueOf(documentDataKey.get(Constant.DOCUMENT_KEY)));
				final Document document = FilenetUtility.retrieveDocument(id);
				final InputStream inputStream = document.accessContentStream(0);
				zipOutputStream.putNextEntry(new ZipEntry(i+"_"+ documentDataKey.get(Constant.FILE_NAME)));
				IOUtils.copy(inputStream, zipOutputStream);
				zipOutputStream.closeEntry();
				i++;
			}
			zipOutputStream.close();
			byteOutputStream.toByteArray();
			InputStreamResource inputStreamResource = new InputStreamResource(new ByteArrayInputStream(byteOutputStream.toByteArray()));
			File outPutFile = new File("File.zip");
			OutputStream outputStream = new FileOutputStream(outPutFile);
			IOUtils.copy(inputStreamResource.getInputStream(), outputStream);
			file = new File[1];
			file[0] = outPutFile;
		}
		return file;
	}

	private File[] getModuleInputFiles(NotificationDto notificationDto, File[] file) throws IOException {
		if(Objects.nonNull(notificationDto.getFileAttachmentDtos()) && !notificationDto.getFileAttachmentDtos().isEmpty()){
			if(notificationDto.getFileAttachmentDtos().size() == 1){
				Id id = new Id(notificationDto.getFileAttachmentDtos().get(0).getDocumentKey());
				Document document = FilenetUtility.retrieveDocument(id);
				InputStreamResource inputStreamResource = new InputStreamResource(document.accessContentStream(0));
				File outfile = new File(notificationDto.getFileAttachmentDtos().get(0).getFileName());
				OutputStream outputStream = new FileOutputStream(outfile);
				IOUtils.copy(inputStreamResource.getInputStream(), outputStream);
				file = new File[1];
				file[0] = outfile;
			} else {
				ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
				ZipOutputStream zipOutputStream = new ZipOutputStream(byteOutputStream);
				int i = 0;
				for(FileAttachmentDto fileAttachmentDto: notificationDto.getFileAttachmentDtos()) {
					Id id = new Id(fileAttachmentDto.getDocumentKey());
					final Document document = FilenetUtility.retrieveDocument(id);
					final InputStream inputStream = document.accessContentStream(0);
					zipOutputStream.putNextEntry(new ZipEntry(i+"_"+fileAttachmentDto.getFileName()));
					IOUtils.copy(inputStream, zipOutputStream);
					zipOutputStream.closeEntry();
					i++;
				}
				zipOutputStream.close();
				byteOutputStream.toByteArray();
				InputStreamResource inputStreamResource = new InputStreamResource(new ByteArrayInputStream(byteOutputStream.toByteArray()));
				File outPutFile = new File("File.zip");
				OutputStream outputStream = new FileOutputStream(outPutFile);
				IOUtils.copy(inputStreamResource.getInputStream(), outputStream);
				file = new File[1];
				file[0] = outPutFile;
			}
		}
		return file;
	}


	private Map<String, Object> callModuleSpecificStoreProcedure(NotificationDto notificationDto, String procedureName, Map<String, Object> inputMap) {
		inputMap.put("IN_TRN_ID" , notificationDto.getTrnId());
		inputMap.put("IN_MENU_ID" , notificationDto.getListingMenuId());
		inputMap.put("IN_WF_ID" , notificationDto.getWfId());
		inputMap.put("IN_EVENT_CATEGORY" , notificationDto.getEventCategory());
		inputMap.put("IN_EVENT_NAME" , notificationDto.getEventName());
		return nTemplateRepository.callStoredProcedureMap(procedureName, inputMap);
	}

	@Override
	public Set<NotificationToDoDto> getToDoCount(IdDto idDto) throws CustomException {
		Set<NotificationToDoDto> notificationToDoDtos = new HashSet<>();
		StringBuilder toDoQuery = new StringBuilder();
		toDoQuery.append(" SELECT mm.MODULE_ID AS c0 , mm.MODULE_NAME  AS c1 , mm.MODULE_NAME_GUJ AS c2 , mm.MODULE_DESC_GUJ  AS c3, ");
		toDoQuery.append(" menu.MENU_ID AS c4 ,  MENU.MENU_NAME AS c5, MENU.MENU_NAME_GUJ  AS c6 , MENU.MENU_LINKS AS c7, menu.MENU_DESC AS c8 ,");
		toDoQuery.append(" count(todo.LISTING_MENU_ID) AS c9  FROM ").append(Constant.EDP_SCHEMA).append(".").append("TNF_TODO todo ");
		toDoQuery.append(" INNER JOIN ").append(Constant.EDP_MASTER_SCHEMA).append(".").append("MS_MENU menu ON todo.LISTING_MENU_ID = menu.MENU_ID ");
		toDoQuery.append(" INNER JOIN ").append(Constant.EDP_MASTER_SCHEMA).append(".").append("MS_MODULE mm ON mm.MODULE_ID  = MENU.MODULE_ID ");
		toDoQuery.append(" WHERE todo.ASSIGN_TO_POU_ID = :pouId AND menu.ACTIVE_STATUS =1 AND mm.ACTIVE_STATUS = 1 AND TODO.ACTIVE_STATUS = 1 ");
		toDoQuery.append(" GROUP BY todo.LISTING_MENU_ID , mm.MODULE_ID ,mm.MODULE_NAME ,mm.MODULE_NAME_GUJ ,mm.MODULE_DESC_GUJ  ,menu.MENU_ID , MENU.MENU_NAME  ,MENU.MENU_LINKS ,MENU.MENU_NAME_GUJ ,menu.MENU_DESC ");
		Map<String, Object> toDoMap = new HashMap<>();
		toDoMap.put("pouId",idDto.getId());

		List<NotificationTodoRes> responseMap = NativeQueryResultsMapper.map(ntfTodoRepository.executeNativeSQLQuery(toDoQuery.toString(), toDoMap), NotificationTodoRes.class);
		for (NotificationTodoRes notificationTodoRes : responseMap) {
			NotificationToDoDto notificationToDoDto = new NotificationToDoDto();
			notificationToDoDto.setModuleId(notificationTodoRes.getModuleId());
			notificationToDoDto.setModuleName(notificationTodoRes.getModuleName());
			notificationToDoDto.setModuleNameDesc(notificationTodoRes.getModuleNameDesc());
			notificationToDoDto.setModuleNameGuj(notificationTodoRes.getModuleNameGuj());
			notificationToDoDtos.add(notificationToDoDto);
		}
		Map<Long, List<NotificationMenuCntDto>> collect = responseMap.stream().collect(groupingBy(
				NotificationTodoRes::getModuleId, mapping(this::getMenuDto, toList()))
		);
		Set<NotificationToDoDto> outPut = new HashSet<>();
		for (NotificationToDoDto notificationToDoDto : notificationToDoDtos) {
			notificationToDoDto = notificationToDoDto;
			notificationToDoDto.setNotificationMenuCntDtos(collect.get(notificationToDoDto.getModuleId()));
			outPut.add(notificationToDoDto);
		}
		return notificationToDoDtos;
	}

	public NotificationMenuCntDto getMenuDto(NotificationTodoRes res){
		NotificationMenuCntDto notificationMenuCntDto = new NotificationMenuCntDto();
		notificationMenuCntDto.setMenuId(res.getMenuId());
		notificationMenuCntDto.setMenuName(res.getMenuName());
		notificationMenuCntDto.setMenuNameDesc(res.getMenuNameDesc());
		notificationMenuCntDto.setMenuNameGuj(res.getMenuNameGuj());
		notificationMenuCntDto.setCount(res.getCount());
		return notificationMenuCntDto;
	}


	@Override
	public PagebleDTO<SystemNotificationDto> getSystemNotification(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapList(pageDetail, getNotificationSearchFields());
			List<Object[]> maps = ntfTodoRepository.callStoredProcedure(CommonConstant.SP_NOTI_LIST, map);
			List<SystemNotificationDto> systemNotificationDtos = NativeQueryResultsMapper.map(maps, SystemNotificationDto.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, systemNotificationDtos.size(), systemNotificationDtos);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	private Map<String, Object> buildPageInMapList(PageDetails pageDetail, List<CommonSearchEnum> lstPVUSearch) {
		Map<String, String> collect = lstPVUSearch.stream()
				.collect(Collectors.toMap(CommonSearchEnum::getKey, CommonSearchEnum::getValue));
		return SearchParam.buildPageInMap(new StringBuilder(), pageDetail, collect);
	}

	private List<CommonSearchEnum> getNotificationSearchFields() {
		return Arrays.asList(CommonSearchEnum.COMMON_SEARCH_FIELD_IS_OFFICE_ID,CommonSearchEnum.COMMON_SEARCH_FIELD_IS_POU_ID);
	}

	private List<SystemNotificationDto> toDTO(List<SystemNotificationEntity> content) {
		List<SystemNotificationDto> dtos =	new ArrayList<>();
		for (SystemNotificationEntity systemNotificationEntity : content) {
			SystemNotificationDto systemNotificationDto = new SystemNotificationDto();
			BeanUtils.copyProperties(systemNotificationEntity,systemNotificationDto);
			dtos.add(systemNotificationDto);
		}
		return dtos;
	}

	@Override
	public int getSystemNotificationCount(NotificationDto notificationDto) {
		return snRepository.countByAssignToPouIdAndStatusAndOfficeIdAndActiveStatus(notificationDto.getAssignByPOUId(), Constant.UN_READ, notificationDto.getAssignByOfficeId(), Constant.ACTIVE_STATUS);
	}
}
