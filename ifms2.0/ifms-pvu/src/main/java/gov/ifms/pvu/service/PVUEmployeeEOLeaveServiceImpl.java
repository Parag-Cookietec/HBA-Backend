package gov.ifms.pvu.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUEmployeeEOLeaveConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeEOLeaveView;
import gov.ifms.pvu.dto.PVUEmployeeEOLeaveDto;
import gov.ifms.pvu.dto.PVUEmployeeWfHSTDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeeEOLeaveEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVUEmployeeEOLeaveRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.util.WatermarkPageEvent;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVUEmployeeEOLeaveServiceImpl.
 */
@Service
public class PVUEmployeeEOLeaveServiceImpl implements PVUEmployeeEOLeaveService {

	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(PVUEmployeeEOLeaveServiceImpl.class.getName());

	/**
	 * The repository.
	 */
	@Autowired
	private PVUEmployeeEOLeaveRepository repository;

	/**
	 * The PVUPromotionRepository repository.
	 */
	@Autowired
	private PVUCommonService commonService;

	/**
	 * The converter.
	 */
	@Autowired
	private PVUEmployeeEOLeaveConverter converter;

	/**
	 * The lookupinforepository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository eDPLuLookUpInfoRepository;

	/**
	 * The pvu facade.
	 */
	@Autowired
	private PVYFacade pvuFacade;

	/**
	 * The lookupinforepository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookupinforepository;

	/**
	 * The pvu employe events service.
	 */
	@Autowired
	private PVUEmployeEventsService pvuEmployeEventsService;

	/**
	 * The pvu employe department repository.
	 */
	@Autowired
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	/**
	 * The pvu employee event status service.
	 */
	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	/**
	 * The EDPMsDesignationRepository depRepository.
	 */
	@Autowired
	private PVUEmployeDepartmentRepository depRepository;

	@Autowired
	private OAuthService authService;

	/**
	 * The PVUEmployeRepository empRepo.
	 */
	@Autowired
	private PVUEmployeRepository empRepo;

	/**
	 * Gets the PVU employee EO leave.
	 *
	 * @param id the id
	 * @return the PVU employee EO leave
	 * @throws CustomException the custom exception
	 */
	@Override
	public Optional<PVUEmployeeEOLeaveEntity> getPVUEmployeeEOLeave(Long id) throws CustomException {
		try {
			return repository.findByEmpEolIdAndActiveStatus(id, Constant.ACTIVE_STATUS);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	/**
	 * Save or update PVU employee EO leave.
	 *
	 * @param dto the dto
	 * @return the PVU employee EO leave entity
	 * @throws CustomException the custom exception
	 */
	@Override
	@ExceptionHandler
	@Transactional(rollbackFor = CustomException.class)
	public PVUEmployeeEOLeaveDto saveOrUpdatePVUEmployeeEOLeave(PVUEmployeeEOLeaveDto dto) throws CustomException {
		PVUEmployeeEOLeaveEntity entity = converter.toEntity(dto);
		if (dto.getStatusId() == 0) {
			pvuEmployeeEventStatusService.inProgressSuspensionEvent(entity.getEmpId().getEmpId());
			entity.setStatusId(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT));
		} else {
			dateValidate(dto);
		}
		entity = repository.save(entity);
		long empNo = dto.getEmployeeNo();
		dto = this.converter.toDTO(entity);
		dto.setEmployeeNo(empNo);

		return dto;
	}

	/**
	 * Gets the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	@Override
	public List<PVUSearchEnum> getPvuSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_END_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_START_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO, PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_FIELD_WORKFLOW,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID);
	}

	/**
	 * Gets the PVU employee EO leaves.
	 *
	 * @param pageDetail the page detail
	 * @return the PVU employee EO leaves
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmployeEOLeaveView> getPVUEmployeeEOLeaves(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMap(pageDetail);
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_EOL_SEARCH));
			List<PVUEmployeEOLeaveView> objStorePro = this.storeProcPvu(procName, map);
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Builds the page in map.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	private Map<String, Object> buildPageInMap(PageDetails pageDetail) {
		Map<String, String> collect = getPvuSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	/**
	 * Store proc pvu.
	 *
	 * @param procName the proc name
	 * @param map      the map
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<PVUEmployeEOLeaveView> storeProcPvu(String procName, Map<String, Object> map) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeEOLeaveView.class)
				: Collections.emptyList();
	}

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Override
	public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException {
		try {
			Map<String, List<PVUEmployeCreationDDLView>> resultMap = null;
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_EOL_LOOKUP_SP));
			List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupEmployeeEOLCreationSp(procName);
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
			return resultMap;
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Lookup employee EOL creation sp.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private List<PVUEmployeCreationDDLView> lookupEmployeeEOLCreationSp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, Collections.emptyMap());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	/**
	 * Gets the employee WF history by emp id.
	 *
	 * @param id the id
	 * @return the employee WF history by emp id
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<PVUEmployeeWfHSTDto> getEmployeeWFHistoryByEmpId(Long id) throws CustomException {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT  WF.T_PVU_EOL_WF_ID  ,US.USER_NAME , POST.POST_NAME ,WF.CREATED_DATE ,  ").append(
				" WMW.WORKFLOW_NAME ,   WF.WF_STATUS ,WF.TRN_STATUS  , WF.REMARKS, OFC.OFFICE_NAME, DESGN.DESIGNATION_NAME, WFROLE.WF_ROLE_NAME ")
				.append(" FROM   ").append(Constant.PVU_SCHEMA).append(".T_PVU_EOL_WF WF   ")
				.append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".MS_USER US ON US.USER_ID = WF.ASSIGN_BY_USER_ID ").append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(".MS_POST POST ON POST.POST_ID = WF.ASSIGN_BY_POST_ID ")
				.append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".WF_MS_WORKFLOW wmw ON WMW.WORKFLOW_ID = WF.CURRENT_WORKFLOW_ID ").append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(".MS_OFFICE OFC ON OFC.OFFICE_ID = WF.ASSIGN_BY_OFFICE_ID ")
				.append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".MS_DESIGNATION DESGN ON DESGN.DESIGNATION_ID = POST.DESIGNATION_ID ")
				.append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".WF_WORKFLOW_ROLE WFROLE ON WFROLE.WF_ROLE_ID = WF.ASSIGN_BY_WF_ROLE_ID ")
				.append(" WHERE WF.TRN_ID = :empId ORDER BY WF.CREATED_DATE DESC");
		HashMap<String, Object> objectMap = new HashMap<>();
		objectMap.put("empId", id);
		List<Object[]> objectPvuSp = repository.executeSQLQuery(sb.toString(), objectMap);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeeWfHSTDto.class)
				: Collections.emptyList();
	}

	/**
	 * Insert employee itr.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the PVU common response
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUEmployeeEOLeaveDto insertWfEolItr(final PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
		PVUEmployeeEOLeaveDto pvuCommonResponse = null;
		Date approvedDate = new Date();
		PVUEmployeeEventStatusEntity statusEntry = null;
		Optional<PVUEmployeeEOLeaveEntity> find = repository.findById(pvuWFWrapperDto.getTrnId());
		EDPLuLookUpInfoEntity empApprovStatsLookupInfo = eDPLuLookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.APPROVED);
		if (find.isPresent()
				&& find.get().getStatusId().getLookUpInfoId() != empApprovStatsLookupInfo.getLookUpInfoId()) {
			PVUEmployeeEOLeaveEntity entity = find.get();
			statusEntry = populateAndValidateStatusEntity(entity);
			if (entity.getTransNo() == null) {
				entity.setTransNo(this.commonService.getTransactionNumber("EOL"));
				statusEntry.setEol(Constant.ACTIVE_STATUS);
				entity.setRefDate(LocalDateTime.now());
				repository.save(entity);
				pvuEmployeeEventStatusService.updateEventInfo(statusEntry, entity.getTransNo());
			}

			Boolean isReturn = pvuFacade.callWorkFlowApis(pvuWFWrapperDto);
			if (isReturn.equals(Boolean.TRUE)) {
				EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = eDPLuLookUpInfoRepository
						.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
								Constant.ACTIVE_STATUS, Constant.SUBMIT);
				if (empSubmitStatusLookupInfo != null) {
					repository.updateStatusIdForPVUEmployeEntity(empSubmitStatusLookupInfo.getLookUpInfoId(),
							pvuWFWrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), approvedDate);
				}
				pvuCommonResponse = converter.toDTO(entity);
				if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
					find.get().setStatusId(empApprovStatsLookupInfo);
					repository.updateStatusIdForPVUEmployeEntity(empApprovStatsLookupInfo.getLookUpInfoId(),
							pvuWFWrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), approvedDate);
					pvuEmployeEventsService.saveOrUpdateEmployeEvents(toEntityOfEmpEvent(pvuCommonResponse));
					updateEmpEventStatus(entity);
				} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
					EDPLuLookUpInfoEntity empRejectStatsLookupInfo = eDPLuLookUpInfoRepository
							.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
									Constant.ACTIVE_STATUS, Constant.REJECTED);
					repository.updateStatusIdForPVUEmployeEntity(empRejectStatsLookupInfo.getLookUpInfoId(),
							pvuWFWrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), approvedDate);
					updateEmpEventStatus(entity);
				}
				insertEmpInITRs(pvuWFWrapperDto);
				return pvuCommonResponse;
			}
		} else {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.EMP_ALREADY_APPROVED, find.get().getEmpId().getEmployeeCode()));
		}
		return pvuCommonResponse;
	}

	/**
	 * Update emp event status.
	 *
	 * @param find the find
	 */
	private void updateEmpEventStatus(PVUEmployeeEOLeaveEntity find) {
		Optional<PVUEmployeeEventStatusEntity> statusEntity;
		statusEntity = pvuEmployeeEventStatusService.findByEmpId(find.getEmpId().getEmpId());
		if (statusEntity.isPresent()) {
			statusEntity.get().setEol(0);
			statusEntity.get().setTransId(null);
			pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(statusEntity.get());
		}
	}

	/**
	 * To entity of emp event.
	 *
	 * @param dto          the dto
	 * @param approvedDate the approved date
	 * @return the PVU employe events entity
	 */
	private PVUEmployeEventsEntity toEntityOfEmpEvent(PVUEmployeeEOLeaveDto dto) {
		PVUEmployeEventsEntity employeEventsEntity = new PVUEmployeEventsEntity();
		PVUEmployeDepartmentEntity department = this.pvuEmployeDepartmentRepository
				.findFirstByPvuEmployeEntityEmpId(dto.getEmpId());
		employeEventsEntity.setTrnNo(dto.getTransNo());
		employeEventsEntity.setEventName(dto.getEventCode());
		employeEventsEntity.setEventDate(LocalDateTime.of(dto.getStartDate(), LocalTime.MIN));
		employeEventsEntity.setEmpId(dto.getEmpId());
		employeEventsEntity.setActiveStatus(dto.getActiveStatus());
		employeEventsEntity.setEmpDesignation(department.getDesignationId().getDesignationId());
		employeEventsEntity.setEmpAutoApprove(LocalDateTime.now());
		employeEventsEntity.setOfficeId(OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId());
		return employeEventsEntity;
	}

	/**
	 * Execute workflow api.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	public void insertEmpInITRs(final PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_EOL_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * Gets the auto employee number.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the auto employee number
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean getAutoEmployeeNumber(final PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_EMP_ID, pvuWFWrapperDto.getTrnId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.GENERATE_EMPLOYEE_NUMBER));
		repository.callStoredProcedure(procName, map);
		return Boolean.TRUE;
	}

	/**
	 * Date validate.
	 *
	 * @param dto               the dto
	 * @param existingEolEntity the existing eol entity
	 * @param compare           the compare
	 * @return true, if successful
	 */
	public void dateValidate(PVUEmployeeEOLeaveDto dto) throws CustomException {
		if (dto.getStartDate() != null && dto.getEndDate() != null) {
			long empId = dto.getEmpId();
			LocalDate startDate = dto.getStartDate();
			LocalDate endDate = dto.getEndDate();
			List<PVUEmployeeEOLeaveEntity> list = repository.findAllByStartDateAndEndDateAndEmpIdEmpId(startDate,
					endDate, empId, PvuConstant.SAVE_AS_DRAFT_ID, Constant.ACTIVE_STATUS);
			for (PVUEmployeeEOLeaveEntity existingEntity : list) {
				if (!existingEntity.getTransNo().equals(dto.getTransNo())) {
					throw new CustomException(HttpStatus.CONFLICT,
							MessageFormat.format(MsgConstant.EOL_ALREADY_APPROVED, existingEntity.getTransNo()));
				}
			}
		}
	}

	/**
	 * Gets the one by trn no.
	 *
	 * @param trnNo the trn no
	 * @return the one by trn no
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUEmployeeEOLeaveEntity getOneByTrnNo(String trnNo) throws CustomException {
		return repository.findOneByTransNo(trnNo)
				.orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
	}

	/**
	 * Update active status by emp eol id.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @throws CustomException the custom exception
	 */
	@Override
	public void updateActiveStatusByEmpEolId(Long id, int activeStatus) throws CustomException {
		try {
			Optional<PVUEmployeeEOLeaveEntity> entity = repository.findByEmpEolIdAndActiveStatus(id,
					Constant.ACTIVE_STATUS);
			if (entity.isPresent()) {
				this.repository.updateActiveStatusByEmpEolId(id, activeStatus, OAuthUtility.getCurrentUserUserId(),
						new Date());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}
	}

	@Override
	public String generatePrintEndorsement(IdDto dto) throws IOException, CustomException, DocumentException {
		return generatePdf(dto);
	}

	public String generatePdf(IdDto dto) throws CustomException {

		PdfWriter pdfWriter = null;
		StringWriter writer = new StringWriter();
		Document document = new Document();
		try {
			String htmltoPdf = null;
			Map<String, Object> map = new HashMap<>();
			document = new Document();
			document.addAuthor("GOG");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("GOG Finance");
			document.addTitle("EOL Event");
			document.setPageSize(PageSize.LETTER);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			pdfWriter = PdfWriter.getInstance(document, baos);

			// open document
			document.open();

			String watermark = null;
			PVUEmployeeEOLeaveEntity entity = repository.getOne(dto.getId());

			if (!Utils.isEmpty(entity.getOfficeId())
					&& entity.getOfficeId().getOfficeId().equals(entity.getOfficeId().getPvuId())
					&& entity.getOfficeId().getOfficeId() != Constant.PVU_OFFICE_ID) {
				watermark = ", Self PVU";
			} else {
				watermark = ", PVU, Gandhinagar";
			}

			pdfWriter.setPageEvent(
					new WatermarkPageEvent(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()), watermark));
			writer.write(generatePrint(dto).toString());

			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));

			// close the document
			document.close();
			map.put("content", writer.toString());
			htmltoPdf = commonService.htmlToPdfRequest(map); // call this method for node js API for html to Base64
			return htmltoPdf;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public StringWriter generatePrint(IdDto dto) {
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		PVUEmployeeEOLeaveEntity entity = repository.getOne(dto.getId());
		VelocityContext context = converter.populateVContext(entity);
		if (entity.getEmpId() != null) {
			PVUEmployeEntity one = empRepo.getOne(entity.getEmpId().getEmpId());
			if (!Utils.isEmpty(one.getOfficeId())) {
				if (!Utils.isEmpty(one.getOfficeId().getOfficeName())) {
					context.put("OFFICE_NAME", one.getOfficeId().getOfficeName());
				}
				if (!Utils.isEmpty(one.getOfficeId().getAddrLine1())) {
					context.put("OFFICE_ADDRESS", one.getOfficeId().getAddrLine1());
				}
			}
		}
		context.put("noOfDays", entity.getNoOfDays());
		context.put("APPROVER_NAME", String.valueOf(authService.getOnlyIdAndName(entity.getUpdatedBy()).getName()));
		Map<String, Object> map = new HashMap<>();
		map.put("userId", entity.getUpdatedBy());
		PVUEmployeDepartmentEntity dep = depRepository.findFirstByPvuEmployeEntityEmpId(entity.getEmpId().getEmpId());
		context.put("DESIGNATION", dep.getDesignationId().getDesignationName());
		setApprover(context, map);
		Template template = getPrintTemplate();
		template.merge(context, writer);

		return writer;
	}

	private void setApprover(VelocityContext context, Map<String, Object> map) {
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getUserDesgnationFromUserId(),
				map);
		if (objects == null || objects.isEmpty()) {
			context.put("APPROVER_DESIGNATION", "");
		} else {
			context.put("APPROVER_DESIGNATION", String.valueOf(objects.get(0)[0]));
		}
	}

	public Template getPrintTemplate() {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		return ve.getTemplate("templates/eol/eol.vm");
	}

	public PVUEmployeeEventStatusEntity populateAndValidateStatusEntity(PVUEmployeeEOLeaveEntity entity)
			throws CustomException {
		if (entity.getTransNo() != null) {
			return pvuEmployeeEventStatusService.inProgressAnyEventByTrnNo(entity.getEmpId().getEmpId(),
					entity.getTransNo());
		} else {
			return pvuEmployeeEventStatusService.inProgressAnyEvent(entity.getEmpId().getEmpId());
		}
	}

	@Override
	public String generateEOLPrintComments(IdDto dto) throws IOException, CustomException, DocumentException {
		return generateEOLCommentsPdf(dto);
	}

	public String generateEOLCommentsPdf(IdDto dto) throws CustomException {

		PdfWriter pdfWriter = null;
		StringWriter writer = new StringWriter();
		// create a new document
		Document document = new Document();
		try {

			document = new Document();
			// document header attributes
			document.addAuthor("GOG");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("GOG Finance");
			document.addTitle("EOL Event");
			document.setPageSize(PageSize.LETTER);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			pdfWriter = PdfWriter.getInstance(document, baos);

			// open document
			document.open();
			writer.write(generatePrintEOLComments(dto).toString());

			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));

			// close the document
			document.close();
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + PvuConstant.EVENT_CODE_EOL + ".pdf");
			header.setContentLength(baos.toByteArray().length);

			logger.info("PDF generated successfully");

			return Base64.getEncoder().encodeToString(baos.toByteArray());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public StringWriter generatePrintEOLComments(IdDto dto) throws ParseException {
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		PVUEmployeeEOLeaveEntity entity = repository.getOne(dto.getId());
		PVUEmployeDepartmentEntity dep = depRepository.findFirstByPvuEmployeEntityEmpId(entity.getEmpId().getEmpId());
		VelocityContext context = converter.populateVContextPrintComments(entity, dep);
		if (entity.getEmpId() != null) {
			PVUEmployeEntity one = empRepo.getOne(entity.getEmpId().getEmpId());
			if (!Utils.isEmpty(one.getOfficeId()) && !Utils.isEmpty(one.getOfficeId().getOfficeName())) {
				context.put("OFFICE_NAME", one.getOfficeId().getOfficeName());
			}
		}
		context.put("PAY_COMMISSION",
				dep.getPayCommissionJoiningTime() != null ? dep.getPayCommissionJoiningTime().getLookUpInfoName() : "");
		Map<String, Object> map = new HashMap<>();
		map.put("trnId", dto.getId());
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getEOLCommentsUserDetails(), map);
		ArrayList<LinkedHashMap<String, Object>> arrayList = new ArrayList<>();
		for (int i = 0; i < objects.size(); i++) {
			LinkedHashMap<String, Object> hashMap = new LinkedHashMap<>();
			hashMap.put("DETAILS", String.valueOf(objects.get(i)[1]) + ", " + String.valueOf(objects.get(i)[2]) + ", "
					+ String.valueOf(objects.get(i)[3]) + ", " + String.valueOf(objects.get(i)[4]));
			hashMap.put("DATE", PvuUtils.getDateToStringDMYHMMSFormatValue((Date) objects.get(i)[5]));
			hashMap.put("REMARKS", String.valueOf(objects.get(i)[6]));
			arrayList.add(hashMap);
		}
		context.put("COMMENTS", arrayList);
		context.put("SYSTEM_DATE_TIME", PvuUtils.getDateToStringDMYFormatValue(new Date()));
		Template template = getEOLCommentsPrintTemplate();
		template.merge(context, writer);
		return writer;
	}

	public Template getEOLCommentsPrintTemplate() {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		return ve.getTemplate("templates/eol/eolComments.vm");
	}

	@Override
	public void getPvuEmployeeEOLeaveValidation(PVUEmployeeEOLeaveDto dto) throws CustomException {
		
		try {
			List<PVUEmployeeEOLeaveEntity> entity = repository.getExistingEOLeaveDate(dto.getStartDate(),
					dto.getEndDate(), dto.getEmpId(), Constant.ACTIVE_STATUS);
			if (!entity.isEmpty() && Constant.APPROVED_STATUS_ID.equals(dto.getStatusId())) {
				List<Long> eolIds = entity.stream().map(PVUEmployeeEOLeaveEntity::getEmpEolId)
						.collect(Collectors.toList());
				if (!eolIds.contains(dto.getEmpEolId()))
					throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
			}
		} catch (CustomException e) {
			logger.error(e.getMessage());
			throw new CustomException(404, "the employee is already on EOL.");
		}
			
	}

	@Override
	public void getPvuEmployeeEOLeaveValidationCreate(PVUEmployeeEOLeaveDto dto) throws CustomException {
		try {
			List<PVUEmployeeEOLeaveEntity> entity = repository.getExistingEOLeaveDateCreate(dto.getStartDate(),dto.getEndDate(),dto.getEmpId(),Constant.ACTIVE_STATUS,Constant.APPROVED_STATUS_ID);
			if (!entity.isEmpty()) {

				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }

		} catch (CustomException e) {
			logger.error(e.getMessage());
			throw new CustomException(404,"the employee is already on EOL.");
		} 
		
	}

}
