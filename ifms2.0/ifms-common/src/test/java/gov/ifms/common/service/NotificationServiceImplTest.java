package gov.ifms.common.service;

import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.*;
import gov.ifms.common.email.service.EmailService;
import gov.ifms.common.entity.NotificationPreferenceEntity;
import gov.ifms.common.entity.NotificationTemplate;
import gov.ifms.common.entity.SystemNotificationEntity;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.repository.*;
import gov.ifms.common.util.EncryptDecryptUtil;
import org.apache.commons.collections.map.HashedMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NotificationServiceImplTest {
	
	@Mock
	private EntityManager entityManager;
	
	@Mock
	private StoredProcedureQuery query;
	
	@Mock
	private EmailService emailService;
	
	@Mock
	private Resource resourceFile;
	
	@Mock
	private NotificationTodoRepository ntfTodoRepository;

	@Mock
	private NotificationPreferenceRepository ntfPreferenceRepository;

	@Mock
	private SystemNotificationRepository snRepository;

	@Mock
	private NotificationTemplateRepository nTemplateRepository;

	@Mock
	private NotificationTransactionRepository nTransactionRepository;
	
	@Mock
	private NotificationFatchDTO notificationFatchDTO;
	
	@Mock
	private PreferenceFatchDTO preferenceFatchDTO;
	
	@Mock
	private PreferencePostDTO PreferencePostDTO;
	
	@Mock
	private NotificationPreferenceEntity notificationPreferenceEntity;
	
	@Mock
	private TemplatePostDTO TemplatePostDTO;
	
	@Mock
	private TemplateFatchDTO TemplateFatchDTO;
	
	@Mock
	private NotificationTemplate NotificationTemplate;
	
	@Mock
    private RestTemplate restTemplate;

	@Mock
	private EncryptDecryptUtil securityUtils;
	
	@Spy
	@InjectMocks
	private NotificationServiceImpl notificationFatchServiceImpl;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(notificationFatchServiceImpl, "workflowApiUrl", "http://localhost:8080");
	}
	
	@Test
	void testGetNotification() {
		//HashMap<Object, Object> resultMap = new HashMap<Object, Object>();
		List<Long> menuList = new LinkedList<>();
		NotificationFatchDTO notificationFatchDTO = new NotificationFatchDTO();
		notificationFatchDTO.setUserId(123l);
		notificationFatchDTO.setPouId(125l);
		List<SystemNotificationEntity> snList = new LinkedList<>();
		List<CountBaseOnMenuDTO> todoCountList = new LinkedList<>();
//		EDPLkPoOffUserEntity edpLkPoOffUserEntity = new EDPLkPoOffUserEntity();
//		EDPMsUserEntity edpMsUserEntity = new EDPMsUserEntity();
//		edpMsUserEntity.setUserId(123L);
//		edpLkPoOffUserEntity.setUserId(edpMsUserEntity);
//		List<EDPLkPoOffUserEntity> edpLkPoOffUserList = new LinkedList<>();
//		edpLkPoOffUserList.add(edpLkPoOffUserEntity);
		NotificationPreferenceEntity ntfPreferenceEntity = new NotificationPreferenceEntity();
		ntfPreferenceEntity.setIsSn(1);
//		when(edpLkPoOffUserRepository.findAllById(pouList))
//		.thenReturn(edpLkPoOffUserList);
		when(ntfPreferenceRepository.getPreferenceByUserId(notificationFatchServiceImpl.decryptUserId(notificationFatchDTO.getUserId())))
		.thenReturn(ntfPreferenceEntity);
		when(snRepository.getSNByPOUList(menuList,notificationFatchDTO.getPouId()))
		.thenReturn(snList);
		when(ntfTodoRepository.getCountBaseOnMenu(menuList,notificationFatchDTO.getPouId()))
		.thenReturn(todoCountList);
		assertNotNull(notificationFatchServiceImpl.getNotification(notificationFatchDTO));
	}
	
	@Test
	void testPostNotification() throws CustomException, UnsupportedEncodingException, NoSuchAlgorithmException {
		String token = "test";
		NotificationPostDTO notificationPostDTO = new NotificationPostDTO();
		notificationPostDTO.setTrnId(1316l);
		notificationPostDTO.setMenuId(59l);;
		notificationPostDTO.setEventCategory("WORK_FLOW");;
		notificationPostDTO.setEventName("Trasition");;
		notificationPostDTO.setCreatedBy(100l);;
		NotificationTemplate notificationTemplate  = new NotificationTemplate();
		notificationTemplate.setProcedureName("MASTER_V1.SP_NOTIFICATION_DETAILS_CH");
		notificationTemplate.setIsEmail(1);
		notificationTemplate.setIsSms(1);
		when(nTemplateRepository.getTemplate(notificationPostDTO.getMenuId(), notificationPostDTO.getEventCategory(), notificationPostDTO.getEventName()))
		.thenReturn(notificationTemplate);
		Map<String, Object> outputMap = new HashedMap();
		outputMap.put("ASSIGN_TO_POU_ID","1" );
		outputMap.put("ASSIGN_BY_POU_ID","1" );
		//outputMap.put("TO_SN_POU_IDS","1" );
		//outputMap.put("ASSIGN_TO_POU_ID","1" );
		//outputMap.put("ASSIGN_TO_POU_ID","1" );
		
		when(entityManager.createStoredProcedureQuery(notificationTemplate.getProcedureName())).thenReturn(query);
		assertNotNull(query);
		when(query.getOutputParameterValue("ASSIGN_TO_POU_ID")).thenReturn(1);
		when(query.getOutputParameterValue("ASSIGN_BY_POU_ID")).thenReturn(1);
		when(query.getOutputParameterValue("TRN_NO")).thenReturn("123");
		when(query.getOutputParameterValue("TO_EMAIL_IDS")).thenReturn("d@d.com");
		when(query.getOutputParameterValue("TO_MOBILES")).thenReturn("9988");
		when(query.getOutputParameterValue("TO_SN_POU_IDS")).thenReturn("123");
		
		List<Object[]> list = new LinkedList<>();
		Object[] array = {"Dave","Divyang"};
		list.add(array);
		
		when(query.getResultList()).thenReturn(list);

		doReturn(outputMap).when(notificationFatchServiceImpl)
		.callStoredProcedure(notificationPostDTO,notificationTemplate.getProcedureName());
		NotificationPreferenceEntity ntfPreferenceEntity = new NotificationPreferenceEntity();
		ntfPreferenceEntity.setIsEmail(1);
		ntfPreferenceEntity.setIsSms(1);
		when(ntfPreferenceRepository.getPreferenceByUserId((Long) outputMap.get("UserId"))).thenReturn(ntfPreferenceEntity);
		File file = new File("C:\\Users\\divya\\Downloads\\sc.png");
		doReturn(file).when(notificationFatchServiceImpl)
		.downloadAttachment((String) outputMap.get("FILE_ATTACHMENT_ID"),
				(String) outputMap.get("FILE_NAME"), token);

		String snBody = "";
		doReturn("Transaction 20-21/PVU/INC/002792 of Increment has been Recevied.").when(notificationFatchServiceImpl).converTemplateToString(outputMap, notificationTemplate.getSnBody());
		notificationFatchServiceImpl.postNotification(notificationPostDTO, token);
		verify(nTemplateRepository, times(1)).getTemplate(notificationPostDTO.getMenuId(), notificationPostDTO.getEventCategory(), notificationPostDTO.getEventName());
	}
	
	@Test
	void testPostNotificationForSnPOUIds() throws CustomException, UnsupportedEncodingException, NoSuchAlgorithmException {
		String token = "Test";
		NotificationPostDTO notificationPostDTO = new NotificationPostDTO();
		notificationPostDTO.setTrnId(1316l);
		notificationPostDTO.setMenuId(59l);;
		notificationPostDTO.setEventCategory("WORK_FLOW");;
		notificationPostDTO.setEventName("Trasition");;
		notificationPostDTO.setCreatedBy(100l);;
		NotificationTemplate notificationTemplate  = new NotificationTemplate();
		notificationTemplate.setProcedureName("MASTER_V1.SP_NOTIFICATION_DETAILS_CH");
		notificationTemplate.setIsEmail(1);
		notificationTemplate.setIsSms(1);
		when(nTemplateRepository.getTemplate(notificationPostDTO.getMenuId(), notificationPostDTO.getEventCategory(), notificationPostDTO.getEventName()))
		.thenReturn(notificationTemplate);
		Map<String, Object> outputMap = new HashedMap();
		outputMap.put("ASSIGN_TO_POU_ID","1" );
		outputMap.put("ASSIGN_BY_POU_ID","1" );
		outputMap.put("TO_SN_POU_IDS", "123");
		//outputMap.put("TO_SN_POU_IDS","1" );
		//outputMap.put("ASSIGN_TO_POU_ID","1" );
		//outputMap.put("ASSIGN_TO_POU_ID","1" );
		
		when(entityManager.createStoredProcedureQuery(notificationTemplate.getProcedureName())).thenReturn(query);
		assertNotNull(query);
		when(query.getOutputParameterValue("ASSIGN_TO_POU_ID")).thenReturn(1);
		when(query.getOutputParameterValue("ASSIGN_BY_POU_ID")).thenReturn(1);
		when(query.getOutputParameterValue("TRN_NO")).thenReturn("123");
		when(query.getOutputParameterValue("TO_EMAIL_IDS")).thenReturn("d@d.com");
		when(query.getOutputParameterValue("TO_MOBILES")).thenReturn("9988");
		when(query.getOutputParameterValue("TO_SN_POU_IDS")).thenReturn("123");
		
		List<Object[]> list = new LinkedList<>();
		Object[] array = {"Dave","Divyang"};
		list.add(array);
		
		when(query.getResultList()).thenReturn(list);

		doReturn(outputMap).when(notificationFatchServiceImpl)
		.callStoredProcedure(notificationPostDTO,notificationTemplate.getProcedureName());
		NotificationPreferenceEntity ntfPreferenceEntity = new NotificationPreferenceEntity();
		ntfPreferenceEntity.setIsEmail(1);
		ntfPreferenceEntity.setIsSms(1);
		when(ntfPreferenceRepository.getPreferenceByUserId((Long) outputMap.get("UserId"))).thenReturn(ntfPreferenceEntity);
		File file = new File("C:\\Users\\divya\\Downloads\\sc.png");
		doReturn(file).when(notificationFatchServiceImpl)
		.downloadAttachment((String) outputMap.get("FILE_ATTACHMENT_ID"),
				(String) outputMap.get("FILE_NAME"), token);

		String snBody = "Test";

		doReturn("Transaction 20-21/PVU/INC/002792 of Increment has been Recevied.")
		.when(notificationFatchServiceImpl)
		.converTemplateToString(outputMap, notificationTemplate.getSnBody());
		notificationFatchServiceImpl.postNotification(notificationPostDTO, token);
		verify(nTemplateRepository, times(1))
		.getTemplate(notificationPostDTO.getMenuId(), notificationPostDTO.getEventCategory(), notificationPostDTO.getEventName());
	}
	
	@Test
	void testCallStoredProcedure() {
		String procName = "MASTER_V1.SP_NOTIFICATION_DETAILS_CH";
		NotificationPostDTO notificationPostDTO = new NotificationPostDTO();
		when(entityManager.createStoredProcedureQuery(procName)).thenReturn(query);
		assertNotNull(query);
		query.registerStoredProcedureParameter("IN_TRN_ID", Long.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("IN_MENU_ID", Long.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("IN_EVENT_CATEGORY", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("IN_EVENT_NAME", String.class, ParameterMode.IN);
		
		query.registerStoredProcedureParameter("getResult", Class.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter("ASSIGN_TO_POU_ID", Integer.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter("ASSIGN_BY_POU_ID", Integer.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter("TRN_NO", String.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter("TO_EMAIL_IDS", String.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter("TO_MOBILES", String.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter("TO_SN_POU_IDS", String.class, ParameterMode.OUT);
		
		query.setParameter("IN_TRN_ID", 1l);
		query.setParameter("IN_MENU_ID",1l);
		query.setParameter("IN_EVENT_CATEGORY", 1l);
		query.setParameter("IN_EVENT_NAME", 1l);
		
		when(query.getOutputParameterValue("ASSIGN_TO_POU_ID")).thenReturn(1);
		when(query.getOutputParameterValue("ASSIGN_BY_POU_ID")).thenReturn(1);
		when(query.getOutputParameterValue("TRN_NO")).thenReturn("123");
		when(query.getOutputParameterValue("TO_EMAIL_IDS")).thenReturn("d@d.com");
		when(query.getOutputParameterValue("TO_MOBILES")).thenReturn("9988");
		when(query.getOutputParameterValue("TO_SN_POU_IDS")).thenReturn("123");
		
		List<Object[]> list = new LinkedList<>();
		Object[] array = {"Dave","Divyang"};
		list.add(array);
		
		when(query.getResultList()).thenReturn(list);
		
		query.execute();
		notificationFatchServiceImpl.callStoredProcedure(notificationPostDTO,procName);
	}
	
//	@Test
//	void testSendEmail() throws CustomException, MessagingException  {
//		NotificationTemplate notificationTemplate = new NotificationTemplate();
//		notificationTemplate.setIsEmail(1);
//		Map<String, Object> outputMap = new HashedMap();
//		outputMap.put("TRN_NO", "20-21/PVU/INC/002792");
//		outputMap.put("TRN_NAME","Increment");
//		List<String> dyVar = new LinkedList<String>();
//		dyVar.add("TRN_NO");
//		dyVar.add("TRN_NAME");
////		doReturn(dyVar).when(notificationFatchServiceImpl)
////		.findDynamicVariable("Transaction ${TRN_NO} of ${TRN_NAME} has been Recevied.");
////		when(notificationFatchServiceImpl.findDynamicVariable("Transaction ${TRN_NO} of ${TRN_NAME} has been Recevied."))
////		.thenReturn(dyVar);
//		String template = "Transaction 20-21/PVU/INC/002792 of Increment has been Recevied.";
////		when(notificationFatchServiceImpl.converTemplateToString(outputMap,
////				"Transaction ${TRN_NO} of ${TRN_NAME} has been Recevied.")).
////		thenReturn(template);
//		doReturn(template).when(notificationFatchServiceImpl)
//		.converTemplateToString(outputMap,"Transaction ${TRN_NO} of ${TRN_NAME} has been Recevied.");
//		Email email = new Email();
//		email.setSubject("Transaction 20-21/PVU/INC/002792 of Increment has been Recevied.");
//		email.setMessageText("Transaction 20-21/PVU/INC/002792 of Increment has been Recevied.");
//		String[] toEmailId = {"dd@dave.com"};
//		email.setTo(toEmailId);
//		//doNothing().when(emailService).sendMailWithLogo(email, resourceFile);
//		
//		NotificationPostDTO notificationPostDTO = new NotificationPostDTO();
//		File file = new File("C:\\\\Users\\\\divya\\\\Downloads\\\\sc.png");
//		notificationFatchServiceImpl.sendEmail(notificationTemplate, outputMap, notificationPostDTO, file);
//		verify(emailService, times(1)).sendMailWithLogo(email, resourceFile);
//	}

	@Test
	void testGetPreference() {
		List<NotificationPreferenceEntity> notificationPreferenceList = new LinkedList<>();
		when(ntfPreferenceRepository.getPreference(notificationFatchServiceImpl.decryptUserId(preferenceFatchDTO.getUserId()),preferenceFatchDTO.getListOfMenu()))
		.thenReturn(notificationPreferenceList);
		assertNotNull(notificationFatchServiceImpl.getPreference(preferenceFatchDTO));
	}
	
	@Test
	void testGetPreferenceNullCheck() {
		PreferenceFatchDTO PreferenceFatchDTO = null;
		HashMap<Object, Object> resultMap = new HashMap<Object, Object>();
		List<NotificationPreferenceEntity> ntfPreferenceList = null;
		resultMap.put("preferenceList", ntfPreferenceList);
		assertEquals(resultMap, notificationFatchServiceImpl.getPreference(PreferenceFatchDTO));
	}
	
	@Test
	void testGetPreferenceNullCheckforMenu() {
		PreferenceFatchDTO PreferenceFatchDTO = new PreferenceFatchDTO();
		PreferenceFatchDTO.setListOfMenu(null);
		HashMap<Object, Object> resultMap = new HashMap<Object, Object>();
		List<NotificationPreferenceEntity> ntfPreferenceList = null;
		resultMap.put("preferenceList", ntfPreferenceList);
		assertEquals(resultMap, notificationFatchServiceImpl.getPreference(PreferenceFatchDTO));
	}
	
	@Test
	void testpostPreference() {
		notificationFatchServiceImpl.postPreference(PreferencePostDTO);
		verify(ntfPreferenceRepository, times(PreferencePostDTO.getPreferenceForMenu().size())).save(notificationPreferenceEntity);
		
		when(ntfPreferenceRepository.save(notificationPreferenceEntity)).thenReturn(notificationPreferenceEntity);
		assertEquals(notificationPreferenceEntity, ntfPreferenceRepository
				.save(notificationPreferenceEntity));
	}
	
	@Test
	void testpostPreferenceNullCheck() {
		PreferencePostDTO PreferencePostDTO = new PreferencePostDTO();
		PreferencePostDTO.setUserId(null);
		notificationFatchServiceImpl.postPreference(PreferencePostDTO);
		verify(ntfPreferenceRepository, times(0)).save(notificationPreferenceEntity);
	}
	
	@Test
	void testpostPreferenceNullCheckForMenu() {
		PreferencePostDTO PreferencePostDTO = new PreferencePostDTO();
		PreferencePostDTO.setUserId(123L);
		List<PreferenceForMenu> preferenceForMenu = null;
		PreferencePostDTO.setPreferenceForMenu(preferenceForMenu);
		notificationFatchServiceImpl.postPreference(PreferencePostDTO);
		verify(ntfPreferenceRepository, times(0)).save(notificationPreferenceEntity);
	}
	
	@Test
	void testFindDynamicVariable() {
		String str = "Transaction ${TRN_NO} of ${TRN_NAME} has been Recevied.";
		List<String> dyVar = new LinkedList<String>();
		dyVar.add("TRN_NO");
		dyVar.add("TRN_NAME");
		assertEquals(dyVar,notificationFatchServiceImpl.findDynamicVariable(str));
	}
	
	@Test
	void testConverTemplateToString() throws CustomException {
		String outStr = "Transaction 20-21/PVU/INC/002792 of Increment has been Recevied.";
		String inStr = "Transaction ${TRN_NO} of ${TRN_NAME} has been Recevied.";
		Map<String, Object> outputMap = new HashedMap();
		outputMap.put("TRN_NO", "20-21/PVU/INC/002792");
		outputMap.put("TRN_NAME","Increment");
		assertEquals(outStr,notificationFatchServiceImpl.converTemplateToString
				(outputMap,inStr));
	}
	
	@Test
	void testConverTemplateToStringEmptyRegEx() throws CustomException {
		String outStr = "Transaction 20-21/PVU/INC/002792 of Increment has been Recevied .";
		String inStr = "Transaction ${TRN_NO} of ${TRN_NAME} has been Recevied ${TRN_DEFUALT}.";
		Map<String, Object> outputMap = new HashedMap();
		outputMap.put("TRN_NO", "20-21/PVU/INC/002792");
		outputMap.put("TRN_NAME","Increment");
		assertEquals(outStr,notificationFatchServiceImpl.converTemplateToString
				(outputMap,inStr));
	}
	
//	@Test
//	void testConvertTemplateToStringException() throws IOException {
//		String template = "Transaction ${TRN_NO} of ${TRN_NAME} has been Recevied ${TRN_DEFUALT}.";
//		Configuration cfg = new Configuration();
//		cfg.setObjectWrapper(new DefaultObjectWrapper());
//		Map<String, Object> outputMap = new HashedMap();
//		//Template t = new Template("templateName", new StringReader(template), cfg);
//		when(new Template("templateName", new StringReader(template), cfg)).thenThrow(new RuntimeException("Template Exception"));
//		assertEquals(new CustomException(4001,"Error While Converting String Into Template"),notificationFatchServiceImpl.converTemplateToString
//				(outputMap,template));
//	}
	
	@Test
	void testConverteStringIntoStringArray() {
		String str = "a;b";
		String outStr[] = {"a","b"};
		String outStr1[] = notificationFatchServiceImpl.converteStringIntoStringArray(str);
		assertTrue(Arrays.equals(outStr, outStr1));
	}
	
	@Test
	void testPostTemplate() {
		TemplatePostDTO TemplatePostDTO = null;
//		TemplatePostDTO.setMenuId(59l);
//		TemplatePostDTO.setEventCategory("Workflow");
//		TemplatePostDTO.setEventName("Event");
//		TemplatePostDTO.setIsSms(0);
//		TemplatePostDTO.setIsSn(0);
//		TemplatePostDTO.setIsTodo(0);
//		TemplatePostDTO.setIsEmail(0);
//		TemplatePostDTO.setProcedureName("MASTER_V1.SP_NOTIFICATION_DETAILS_CH");
		notificationFatchServiceImpl.postTemplate(TemplatePostDTO);
		verify(nTemplateRepository, times(0)).save(NotificationTemplate);
	}
	
	@Test
	void testGetTemplate() {
		NotificationTemplate notificationTemplate = new NotificationTemplate();
		when(nTemplateRepository.getTemplate(TemplateFatchDTO.getMenuId(),TemplateFatchDTO.getEventCategory(),
				TemplateFatchDTO.getEventName()))
		.thenReturn(notificationTemplate);
		assertNotNull(notificationFatchServiceImpl.getTemplate(TemplateFatchDTO));
	}
	
	@Test
	void testGetTemplateNullCheck() {
		TemplateFatchDTO TemplateFatchDTO = null;
		HashMap<Object, Object> resultMap = new HashMap<Object, Object>();
		NotificationTemplate notificationTemplate = null;
		resultMap.put("notificationTemplate", notificationTemplate);
		assertEquals(resultMap, notificationFatchServiceImpl.getTemplate(TemplateFatchDTO));
	}
	
	@Test
	void testGetWfSubmitApi() {
		String str = "/common/attachment";
		//String workflowApiUrl = "http://localhost:${server.port}";
		String expStr = "http://localhost:8080/common/attachment";
		String outStr = notificationFatchServiceImpl.getWfSubmitApi(str);
		assertEquals(expStr, outStr);
	}
	
	//@Test
	void testGetHeaderDetails() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(URLConstant.AUTHORIZATION, "abc");
		assertEquals(headers,notificationFatchServiceImpl.getHeaderDetails("abc"));
	}
	
//	@Test
//	void testDownloadAttachment() throws IOException, CustomException {
//		
//		File expfile = new File("C:\\Users\\divya\\Downloads\\sc.png");
//		
//		String[] documentDataKeyList = {"30B63672-0000-CD29-AB3A-D5CB9A577B60"};
//		String[] fileNameList = {"sc.png"};
//		Map<String, Object> map = new HashMap<>();
//		map.put("documentDataKey", documentDataKeyList[0]);
//		map.put("fileName", fileNameList[0]);
//		HttpHeaders headers =  new HttpHeaders();
//		HttpEntity<Map<String, Object>> request = new HttpEntity<>(map, headers);
//		FileInputStream fileStream = new FileInputStream(expfile);
//		InputStream inputStream = fileStream;
//		fileStream.close();
//		InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
//		
//		when(restTemplate.postForEntity("http://localhost:8080/common/attachment/filenet/download/901", request,Resource.class))
//          .thenReturn(ResponseEntity.ok().body(inputStreamResource));
// 
//		File Outfile = notificationFatchServiceImpl.downloadAttachment("30B63672-0000-CD29-AB3A-D5CB9A577B60","sc.png",null);
//	}

}
