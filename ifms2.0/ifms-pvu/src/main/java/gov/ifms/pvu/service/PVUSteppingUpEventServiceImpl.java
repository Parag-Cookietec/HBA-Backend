package gov.ifms.pvu.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.lang3.StringUtils;
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
import org.springframework.util.CollectionUtils;
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
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUPrintEndorsementItrConverter;
import gov.ifms.pvu.converter.PVUSteppingUpEventConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PVUSourceUserDetails;
import gov.ifms.pvu.dto.PVUSteppingUpEventDto;
import gov.ifms.pvu.dto.PVUSteppingUpEventView;
import gov.ifms.pvu.dto.PVUSteppingUpInwardView;
import gov.ifms.pvu.dto.PVUSteppingUpOfficeSearchView;
import gov.ifms.pvu.dto.PVUSteppingUpOutwardView;
import gov.ifms.pvu.dto.PVUSteppingUpPostDetailDto;
import gov.ifms.pvu.dto.PVUSteppingUpPrintEndorsementView;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.PVUWfTableInfo;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.dto.response.PVUEventSteppingUpDDOView;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;
import gov.ifms.pvu.entity.PVUMsEventEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUSteppingUpEventEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeEventsRepository;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVUInwardRepository;
import gov.ifms.pvu.repository.PVUMsEventRepository;
import gov.ifms.pvu.repository.PVUMsGradePayRepository;
import gov.ifms.pvu.repository.PVUMsPayBandRepository;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import gov.ifms.pvu.repository.PVUMsPayLevelRepository;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.repository.PVURevisionOfPayRemarkRepository;
import gov.ifms.pvu.repository.PVUSteppingUpEventRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.util.WatermarkPageEvent;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;

/**
 * The Class PVUStEventController.
 * 
 * @version v 1.0
 * @created 2019/12/17 18:44:21
 */
@Service
public class PVUSteppingUpEventServiceImpl implements PVUSteppingUpEventService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUStEventAsMethodName repository. */
	@Autowired
	private PVUSteppingUpEventRepository repository;

	/** The pvu common service. */
	@Autowired
	private PVUCommonService pvuCommonService;

	/** The pvu pvuMsReason Service. */
	@Autowired
	private PVUMsReasonService pvuMsReasonService;

	/** The eventStatusService. */
	@Autowired
	PVUEmployeeEventStatusService eventStatusService;
	/** The employeEventsService. */
	@Autowired
	PVUEmployeEventsService employeEventsService;
	/** The remarkRepository. */
	@Autowired
	private PVURevisionOfPayRemarkRepository remarkRepository;

	/**
	 * The PVUEmployeRepository repository.
	 */
	@Autowired
	private PVUEmployeRepository empRepository;
	/** The converter. */
	@Autowired
	private PVUSteppingUpEventConverter converter;

	/** The PVUEmployeeEventStatusService. */
	@Autowired
	private PVUEmployeeEventStatusService statusService;

	/** The PVYFacade. */
	@Autowired
	private PVYFacade pvuFacade;

	/** The PVUEmployeDepartmentRepository. */
	@Autowired
	private PVUEmployeDepartmentRepository pvuEmployeeDepartmentRepo;

	/** The EDPLuLookUpInfoRepository. */
	@Autowired
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	/** The PVUEmployeEventsService. */
	@Autowired
	private PVUEmployeEventsService pvuEmployeEventsService;

	/**
	 * The PVUMsPayCellRepository cellRepository.
	 */
	@Autowired
	private PVUMsPayCellRepository cellRepository;

	/**
	 * The PVUMsPayCellRepository cellRepository.
	 */
	@Autowired
	private PVUMsGradePayRepository gradePayRepository;

	/**
	 * The PVUMsPayCellRepository cellRepository.
	 */
	@Autowired
	private PVUMsPayBandRepository bandRepository;

	/**
	 * The PVUMsPayCellRepository cellRepository.
	 */
	@Autowired
	private PVUMsPayLevelRepository levelRepository;

	/**
	 * The PVUMsPayCellRepository cellRepository.
	 */
	@Autowired
	private PVUMsPayScaleRepository scaleRepository;

	/**
	 * The PVUEmployeEventsAsMethodName repository.
	 */
	@Autowired
	private PVUEmployeEventsRepository empEventRepository;

	/**
	 * The EDPMsDesignationRepository empRepo.
	 */
	@Autowired
	private EDPMsDesignationRepository designationRepository;
	/**
	 * The PVUMsEventRepository msEventRepository.
	 */

	@Autowired
	private PVUMsEventRepository msEventRepository;
	/**
	 * The PVUEventRemarksService eventRemarksService.
	 */

	@Autowired
	private PVUEventRemarksService eventRemarksService;
	/**
	 * The WfRepository wfRepository.
	 */

	@Autowired
	private WfRepository wfRepository;

	/** The pvu inward service. */
	@Autowired
	private PVUInwardRepository pvuInwardRepository;

	/** The pvu print repo. */
	@Autowired
	PVUPrintEndorsementRepository pvuPrintEndorsementRepository;
	/** The pvu print itr repo. */
	@Autowired
	PVUPrintEndorsementItrRepository pvuPrintEndorsementItrRepository;
	/** The pvu print itr Converter. */
	@Autowired
	PVUPrintEndorsementItrConverter pvuPrintEndorsementItrConverter;
	@Autowired
	EncryptDecryptUtil securityUtil;
	@Autowired
	private OAuthService authService;

	@Autowired
	private PVUInwardService inwardService;

	/**
	 * Gets the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	public List<PVUSearchEnum> getPvuSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM);
	}

	/**
	 * Retrieves an PVUStEventEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUStEventEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUSteppingUpEventEntity getStEvent(Long id) {
		Optional<PVUSteppingUpEventEntity> pvuStEventEntity = repository.findById(id);
		if (pvuStEventEntity.isPresent()) {
			return pvuStEventEntity.get();
		} else {
			logger.error(MsgConstant.RECORD_NOT_FOUND);
			throw new EntityNotFoundException(MsgConstant.RECORD_NOT_FOUND);
		}
	}

	/**
	 * Saves a given PVUStEventEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUStEventEntity
	 * @throws CustomException
	 */
	@Override
	public PVUSteppingUpEventEntity saveOrUpdateStEvent(PVUSteppingUpEventEntity entity) throws CustomException {
		PVUSteppingUpEventEntity save = null;
		try {
			save = repository.save(entity);
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
		return save;
	}

	/**
	 * Store proc pvu.
	 *
	 * @param procName the proc name
	 * @param map      the map
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<PVUSteppingUpEventView> storeProcPvu(String procName, Map<String, Object> map) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUSteppingUpEventView.class)
				: Collections.emptyList();
	}

	/**
	 * Fetch all the PVUStEvent items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUStEventDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUSteppingUpEventView> getStEvents(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMap(pageDetail);
			String procName = Constant.PVU_SCHEMA
					.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_STEPPING_UP_SEARCH));
			List<PVUSteppingUpEventView> objStorePro = this.storeProcPvu(procName, map);
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
		} catch (Exception ex) {
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
		IdDto idDto = new IdDto();
		idDto.setId(OAuthUtility.getCurrentUserUserId());
		List<IdDto> lst = new ArrayList<>();
		lst.add(idDto);

		StringBuilder stringBuilder = new StringBuilder();
		for (IdDto dto : lst) {
			stringBuilder.append((dto.getId().toString())).append(Constant.COMMA);
		}
		Map<String, String> collect = getPvuSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(stringBuilder, pageDetail, collect);
	}

	/**
	 * Delete st events details.
	 *
	 * @param stEventId      the st event id
	 * @param inactiveStatus the inactive status
	 * @throws CustomException the custom exception
	 */
	@Override
	public void deleteStEventsDetails(Long stEventId, int inactiveStatus) throws CustomException {
		try {
			this.repository.updateActiveStatus(stEventId, inactiveStatus, OAuthUtility.getCurrentUserUserId(),
					new Date());
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE_ACTIVESTATUS);
		}
	}

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	/*
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * 
	 * @throws CustomException the custom exception
	 */
	@Override
	public Map<String, List<PVUEmployeCreationDDLView>> getLookUpInfoAsMap(String procedureName)
			throws CustomException {
		try {
			Map<String, List<PVUEmployeCreationDDLView>> resultMap = null;
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(procedureName));
			List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupSteppingUpSp(procName);
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
			return resultMap;
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Lookup stepping up sp.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<PVUEmployeCreationDDLView> lookupSteppingUpSp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	@Override
	public void submitValidation(PVUSteppingUpEventDto dto) throws CustomException {

		// Same Employees searched in Senior Employee and Junior Employee Not allowed
		if (dto.getEmployeeNo() == dto.getJrEmpNo()) {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.STEPPING_UP_SAME_EMP_SEARCH_VALIDATION);
		}

	}

	/**
	 * Checks Senior&Junior employee validations
	 *
	 * @param PageDetails pageDetail
	 * @return error msg
	 * @throws CustomException the custom exception
	 */
	@Override
	public boolean chkSrJrValidation(PageDetails pageDetail) throws CustomException {

		String employeeNo = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getKey());
		String eventEffDate = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getKey());
		Long empId = null;

		/*
		 * validation for Only Regular employee should be eligible for the Steeping up
		 */
		Optional<PVUEmployeDepartmentEntity> required = this.pvuEmployeeDepartmentRepo
				.findFirstByPvuEmployeEntityEmployeeCode(Long.valueOf(employeeNo));
		if (!(required.isPresent()
				&& required.get().getEmpPayType().getLookUpInfoId() == PvuConstant.REGULAR_PAY_TYPE_ID)) {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_EMPLOYEE_ONLY_REGULAR);
		}

		Optional<PVUEmployeEntity> empEntity = empRepository.findByEmployeeCodeAndActiveStatus(Long.valueOf(employeeNo),Constant.ACTIVE_STATUS);

		if (empEntity.isPresent()) {
			empId = empEntity.get().getEmpId();
		} else {
			throw new CustomException(HttpStatus.CONFLICT, "Employee Not Found");
		}

		/*
		 * validation for f Employee is processed for Any event, he/she cannot be
		 * requested for Steeping up.
		 */

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		LocalDate eventEff = LocalDate.parse(eventEffDate, format);

		/*
		 * validation for If Processed for or if he/she has undergone Promotion Forgo
		 * Event within 1 year from effective date.
		 **/
		boolean forgoExists = employeEventsService.existsFromTo(empId, PvuConstant.EVENT_CODE_FORGO,
				PvuUtils.startDay(eventEff.minusYears(1L)), PvuUtils.endDay(eventEff));
		if (forgoExists) {
			throw new CustomException(HttpStatus.CONFLICT, "Employee has forgo in last one year!");
		}

		return true;

	}

	/**
	 * Use for ddo office Senior scale PVU.
	 *
	 * @param pageDetails page details
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEventSteppingUpDDOView> ddoWFListing(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, String> collect = this.getDdoWFListingSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(null, pageDetail, collect);
			String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.STEPPINGUP_PVU_EVENT_LS_SRCH_WF));
			List<PVUEventSteppingUpDDOView> list = this.callSSPVUDDOListing(sp, stringObjectMap);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, list.size(), list);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getDdoWFListingSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_START_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_END_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_FIELD_GPF_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_PPAN_NO, PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO, PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_FIELD_EMPLOYEE_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID, PVUSearchEnum.SEARCH_FIELD_IN_POU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_REF_NO);
	}

	public List<PVUEventSteppingUpDDOView> callSSPVUDDOListing(String sp, Map<String, Object> parameters)
			throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(sp, parameters);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEventSteppingUpDDOView.class)
				: Collections.emptyList();
	}

	public void chkTranInProcessOrNot(PVUSteppingUpEventEntity entity) throws CustomException {
		PVUEmployeeEventStatusEntity statusEntry;
		statusEntry = statusService.inProgressAnyEvent(entity.getCurEmpId().getEmpId());
		entity.setTrnNo(this.pvuCommonService.getTransactionNumber(Constant.ST));
		entity.setRefDate(LocalDateTime.now());
		statusEntry.setSteppingUp(Constant.ACTIVE_STATUS);
		repository.save(entity);
		statusService.updateEventInfo(statusEntry, entity.getTrnNo());
	}

	public void updateStatus(EDPLuLookUpInfoEntity empSubmitStatusLookupInfo, PvuWFWrapperDto wrapperDto,
			Date approvedDate) {
		if (empSubmitStatusLookupInfo != null) {
			repository.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate);
		}
	}

	public void workflowStatusUpdate(EDPLuLookUpInfoEntity empApprovStatsLookupInfo, PvuWFWrapperDto wrapperDto,
			PVUSteppingUpEventEntity entity, Date approvedDate) {

		Long trnId = wrapperDto.getTrnId();

		if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
			entity.setStatusId(empApprovStatsLookupInfo);
			repository.updateStatusId(empApprovStatsLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate);
		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.PULLED_BACK)) {
			updateForPulledBack(wrapperDto, entity);/* Inactive inward row */
		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
			/* Update Reject Status for Any User Rejected */

			EDPLuLookUpInfoEntity empRejectStatsLookupInfo = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.REJECTED);
			repository.updateStatusId(empRejectStatsLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate);
			/* Unlock event */
			statusService.resetInProgressEmployeeEventStatus(entity.getCurEmpId().getEmpId(),
					OAuthUtility.getCurrentUserLkPOUId());

		} else if (wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)
				|| wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_I)) {
			String authorizerRemark;
			if (wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)) {
				authorizerRemark = entity.getClassTwoRemarks();
			} else {
				authorizerRemark = entity.getClassOneRemarks();
			}

			/* Update Status ApproverClass II Authorization */
			EDPLuLookUpInfoEntity authorizationStatus = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.RECOMMENDATION_FOR,
							Constant.ACTIVE_STATUS, Constant.AUTHORIZE);

			repository.updateStatusId(authorizationStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate);

			Long userId = Long.valueOf(securityUtil.decrypt(wrapperDto.getAssignByUserId()));

			repository.updateStatusIdAndAuthorizer(authorizationStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate, approvedDate, userId, authorizerRemark);

			pvuInwardRepository.setAuthorizeDateAndFlag(trnId, PvuConstant.EVENT_ID_STEPPIN_UP,
					OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(), Constant.OUTWARD_FLAG_ZERO,
					Constant.ACTIVE_STATUS);

		} else if (wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_II)
				|| wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_I)) {
			/* Update Status ApproverClass II Return */
			EDPLuLookUpInfoEntity returnStatus = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.RECOMMENDATION_FOR,
							Constant.ACTIVE_STATUS, Constant.RETURN);
			/* Unlock event */
			repository.updateStatusId(returnStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), new Date());

			pvuInwardRepository.setReturnDateAndFlag(trnId, PvuConstant.EVENT_ID_STEPPIN_UP,
					OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(), Constant.OUTWARD_FLAG_ONE,
					Constant.ACTIVE_STATUS);

		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.FORWARD_TO_PVU)) { // Forward to PVU
			this.insertInwardTable(wrapperDto);
		}
	}

	public void insertRemarksItr(PvuWFWrapperDto wrapperDto) {
		if (wrapperDto.getAssignByWfRoleId() == Constant.AUDITOR
				|| Objects.equals(wrapperDto.getAssignByWfRoleId(), Constant.VERIFIER)
				|| wrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_TWO
				|| Objects.equals(wrapperDto.getAssignByWfRoleId(), Constant.APPROVER_CLASS_ONE)) {
			this.insertSteepingUpPayRemarksITR(wrapperDto.getTrnId());
		}
	}

	/**
	 * Insert in itr response entity.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@ExceptionHandler
	@Transactional(rollbackFor = { CustomException.class, Exception.class })
	@Override
	public PVUSteppingUpEventDto insertInITR(PvuWFWrapperDto wrapperDto) throws CustomException {

		Date approvedDate = new Date();

		Optional<PVUSteppingUpEventEntity> find = repository.findById(wrapperDto.getTrnId());
		PVUSteppingUpEventEntity entity;
		if (find.isPresent()) {

			entity = find.get();

			if (entity.getTrnNo() == null) {
				this.chkTranInProcessOrNot(entity);
			}

			EDPLuLookUpInfoEntity empApprovStatsLookupInfo = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.APPROVED);

			PVUSteppingUpEventDto stDto;
			if (entity.getStatusId() != null) {
				Boolean isReturn = pvuFacade.callWorkFlowApis(wrapperDto);
				if (isReturn.equals(Boolean.TRUE)) {
					EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = edpLuLookUpInfoRepository
							.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
									Constant.ACTIVE_STATUS, Constant.SUBMIT);

					updateStatus(empSubmitStatusLookupInfo, wrapperDto, approvedDate);
					stDto = converter.toDTO(entity);
					this.workflowStatusUpdate(empApprovStatsLookupInfo, wrapperDto, entity, approvedDate);

					this.insertRemarksItr(wrapperDto);
					this.insertITR(wrapperDto);
					return stDto;
				}
				throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
			} else {
				throw new CustomException(HttpStatus.CONFLICT, MsgConstant.TRN_ALREADY_APPROVED);
			}
		} else {
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		}

	}

	/**
	 * Insert in Inward Table.
	 *
	 * @param wrapperDto the wrapper dto @return @throws
	 */
	public void insertInwardTable(PvuWFWrapperDto wrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, wrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_CREATED_BY, OAuthUtility.getCurrentUserUserId());
		map.put(Constant.IN_CREATED_BY_POST, wrapperDto.getAssignByPostId());
		map.put(Constant.IN_POU_ID, wrapperDto.getAssignByPOUId());
		map.put(Constant.IN_OFFICE_ID, wrapperDto.getAssignByOfficeId());
		map.put(Constant.IN_EVENT_CODE, PvuConstant.EVENT_CODE_STEPPIN_UP);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_INWARD_INSERT));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * Insert in PayRemarks ITR.
	 *
	 * @param wrapperDto the wrapper dto @return @throws
	 */
	public void insertSteepingUpPayRemarksITR(Long transId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		map.put(Constant.IN_EVENT_CODE, PvuConstant.EVENT_CODE_STEPPIN_UP);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.INSERT_PVU_EVNT_RMKS_ITR);
		repository.callStoredProcedure(procName.toString(), map);
	}

	public void reset(Long empId, String eventCode) {
		Optional<PVUEmployeeEventStatusEntity> employeeStatus = statusService.findByEmpId(empId);
		if (employeeStatus.isPresent() && eventCode.equalsIgnoreCase(PvuConstant.EVENT_STATUS_STEPPING_UP)) {
			employeeStatus.get().setSteppingUp(0);
			employeeStatus.get().setTransId(null);

			statusService.saveOrUpdateEmployeeEventStatus(employeeStatus.get());
		}
	}

	public void insertITR(final PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("IN_TRN_ID", pvuWFWrapperDto.getTrnId());
		map.put("IN_WORKFLOW_ID", pvuWFWrapperDto.getCurrentWorkflowId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_ST_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	@Override
	public EDPMsOfficeDto getSteppingUpOfficeName(IdDto idDto) {

		Map<String, Object> map = new HashMap<>();
		map.put("eventId", idDto.getId());
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getSteppingUpEmpOfficeId(), map);
		if (!Utils.isEmpty(objects)) {
			EDPMsOfficeDto officeDto = new EDPMsOfficeDto();
			officeDto.setOfficeName(String.valueOf(objects.get(0)[0]));
			return officeDto;
		}
		return null;

	}

	/**
	 * Store proc pvu.
	 *
	 * @param procName the proc name
	 * @param map      the map
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public <T> List<T> storeProcPvu(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, view) : Collections.emptyList();
	}

	// Start Inward
	@Override
	public PagebleDTO<PVUSteppingUpInwardView> getSteppingUpInwardList(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapInwardList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_INWARD_LIST_WF).toString();
			List<PVUSteppingUpInwardView> objStorePro = this.storeProcPvu(procName, map, PVUSteppingUpInwardView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public Map<String, Object> buildPageInMapInwardList(PageDetails pageDetail) {
		Map<String, String> collect = getInwardSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	public List<PVUSearchEnum> getInwardSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO, PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_PAN,
				PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX, PVUSearchEnum.PVU_SEARCH_DDO,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_FIELD_INW_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID);
	}

	@Override
	public Boolean generateInwardNumber(List<IdDto> dtos) throws CustomException {
		try {
			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();

			dtos.forEach(dto -> {
				Map<Integer, Object> map = new HashMap<>();
				map.put(1, Constant.ST);
				map.put(2, dto.getId());
				parameterMapList.add(map);
			});

			return repository.callStoreProcBatch(
					"{CALL " + Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ST_INWARD_NO_GENERATION_PVU))
							+ "(?,?)}",
					parameterMapList);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public Boolean submiSteppingUpInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}
	// End Inward

	// Start Distributer
	@Override
	public Boolean submitSteppingUpDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}
	// End Distributer

	@Override
	public PagebleDTO<PVUSteppingUpOfficeSearchView> pvuOfficeEmployeeSearch(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = this.getPvuOfficeSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			StringBuilder procName = new StringBuilder();
			procName.append(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.COMMON_FIVE_EVENT_LIST_SEARCH_WF_PVU);
			List<Object[]> objStorePro = repository.callStoredProcedure(procName.toString(), map);
			if (!Utils.isEmpty(objStorePro)) {
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(),
						NativeQueryResultsMapper.map(objStorePro, PVUSteppingUpOfficeSearchView.class));
			}
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, 0, Collections.emptyList());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getPvuOfficeSearchFields() {

		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_PVU_OFFICE, PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_CARDEX,
				PVUSearchEnum.PVU_SEARCH_FIELD_PAN_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMPLOYEE_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_NO, PVUSearchEnum.PVU_SEARCH_DISTRICT,
				PVUSearchEnum.PVU_SEARCH_DDO, PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO);
//			                PVUSearchEnum.PVU_SEARCH_FIELD_GPF_NO
	}

	@Override
	public Map<String, Object> getPVUResponse(IdDto dto) throws CustomException {
		IdNameDto val;

		PVUSteppingUpEventEntity steppingUpEventEntity = getStEvent(dto.getId());
		PVUSteppingUpEventDto stpDto = converter.toDTO(steppingUpEventEntity);

		PVUSteppingUpPostDetailDto postDetailDto = new PVUSteppingUpPostDetailDto();

		PVUEmployeEntity empEntity = this.empRepository.getOne(stpDto.getEmployeeId());
		postDetailDto.setOfficeId(String.valueOf(empEntity.getOfficeId().getOfficeName()));
		postDetailDto.setEventOrderNo(stpDto.getEventOrderNo());
		postDetailDto.setEventOrderDate(stpDto.getEventOrderDate().toString());
		postDetailDto.setEventEffectiveDate(stpDto.getEventEffectiveDate().toString());

		if (stpDto.getPayCommId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			postDetailDto.setPayCommId(PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME);
		} else if (stpDto.getPayCommId() == PvuConstant.SIXTH_COMMISSION_ID) {
			postDetailDto.setPayCommId(PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME);
		} else if (stpDto.getPayCommId() == PvuConstant.FIFTH_COMMISSION_ID) {
			postDetailDto.setPayCommId(PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME);
		}
		postDetailDto.setEvent(PvuConstant.EVENT_CODE_STEPPIN_UP);
		postDetailDto.setEventCode(
				stpDto.getEventCode().equalsIgnoreCase(PvuConstant.EVENT_CODE_STEPPIN_UP) ? "Stepping Up" : null);

		EDPLuLookUpInfoEntity stpTypeLookUp = edpLuLookUpInfoRepository
				.findBylookUpInfoId(stpDto.getSteppingUpTypeId());
		postDetailDto.setType(String.valueOf(stpTypeLookUp.getLookUpInfoName()));
		postDetailDto.setSteppingUpTypeId(String.valueOf(stpTypeLookUp.getLookUpInfoName()));
		postDetailDto.setEmployeeNo(String.valueOf(stpDto.getEmployeeNo()));
		if (steppingUpEventEntity != null && steppingUpEventEntity.getCurrentDetailsEventId() != null) {
			Map<String, Object> response = new HashMap<>();

			PVUCommonApiDto commonCurrEmpDto = this.pvuEmployeEventsService
					.getCommonApiResponse(steppingUpEventEntity.getCurrentDetailsEventId());

			response.put("currentDetails", commonCurrEmpDto);

			if (!Utils.isEmpty(stpDto.getJrEmpId())) {

				response.put("steppingUpJnr", getJrEmpInfo(stpDto));

				if (stpDto.getPayCommId() == PvuConstant.SEVENTH_COMMISSION_ID) {

					val = this.cellRepository.getOnlyIdAndName(steppingUpEventEntity.getChCellId().getId());
					postDetailDto.setCellId(val.getName());
					val = this.levelRepository.getOnlyIdAndName(steppingUpEventEntity.getChPayLevel().getId());
					postDetailDto.setPayLevelId(val.getName());

				} else if (stpDto.getPayCommId() == PvuConstant.SIXTH_COMMISSION_ID) {

					val = this.gradePayRepository.getOnlyIdAndName(steppingUpEventEntity.getChGradePay().getId());
					postDetailDto.setGradePayId(val.getName());
					postDetailDto.setPayBandValue(String.valueOf(stpDto.getPayBandValue()));
					val = this.bandRepository.getOnlyIdAndName(steppingUpEventEntity.getChPayBand().getId());
					postDetailDto.setPayBandId(val.getName());

				} else if (stpDto.getPayCommId() == PvuConstant.FIFTH_COMMISSION_ID) {

					val = scaleRepository.getOnlyIdAndName(stpDto.getPayScale());
					postDetailDto.setPayScale(val.getName());
				}

				postDetailDto.setBasicPay(String.valueOf(stpDto.getBasicPay()));

				postDetailDto.setDateOfNextIncrement(stpDto.getDateOfNextIncrSrJnr().toString());
				postDetailDto.setBenefitEffectiveDate(stpDto.getChBeneEffDate().toString());

				val = edpLuLookUpInfoRepository
						.getOnlyIdAndName(steppingUpEventEntity.getCurEmpClass().getLookUpInfoId());
				postDetailDto.setEmployeeClassId(val.getName());

				val = designationRepository.getOnlyIdAndName(steppingUpEventEntity.getCurEmpDsgn().getDesignationId());
				postDetailDto.setDesignationId(val.getName());
				postDetailDto.setTrnNo(stpDto.getTrnNo());

			}
			response.put("postDetails", postDetailDto);

			return response;

		}
		throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);

	}

	public PVUCommonApiDto getJrEmpInfo(PVUSteppingUpEventDto stpDto) {
		PVUCommonApiDto commonJrEmpDto = null;
		LocalDate date = stpDto.getEventEffectiveDate();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.of(date, time);

		PVUEmployeEventsEntity jrEventEntity = empEventRepository
				.findTopByEmpIdAndPayCommissionAndActiveStatusAndEventDateLessThanEqualOrderByEmpEventIdDesc(
						stpDto.getJrEmpId(), stpDto.getPayCommId(), Constant.ACTIVE_STATUS, dateTime);

		if (!Utils.isEmpty(jrEventEntity)) {
			commonJrEmpDto = this.pvuEmployeEventsService.getCommonApiResponse(jrEventEntity.getEmpEventId());
		}

		return commonJrEmpDto;
	}

	public PVUSteppingUpPostDetailDto setPostAndEventDetails(PVUSteppingUpEventDto dto,
			PVUSteppingUpEventEntity entity) {

		IdNameDto val;

		PVUSteppingUpPostDetailDto postDetailDto = new PVUSteppingUpPostDetailDto();

		if (dto.getPayCommId() == PvuConstant.SEVENTH_COMMISSION_ID) {

			val = this.cellRepository.getOnlyIdAndName(entity.getChCellId().getId());
			postDetailDto.setCellId(val.getName());
			val = this.levelRepository.getOnlyIdAndName(entity.getChPayLevel().getId());
			postDetailDto.setPayLevelId(val.getName());

		} else if (dto.getPayCommId() == PvuConstant.SIXTH_COMMISSION_ID) {

			val = this.gradePayRepository.getOnlyIdAndName(entity.getChGradePay().getId());
			postDetailDto.setGradePayId(val.getName());
			postDetailDto.setPayBandValue(String.valueOf(dto.getPayBandValue()));
			val = this.bandRepository.getOnlyIdAndName(entity.getChPayBand().getId());
			postDetailDto.setPayBandId(val.getName());

		} else if (dto.getPayCommId() == PvuConstant.FIFTH_COMMISSION_ID) {

			val = scaleRepository.getOnlyIdAndName(dto.getPayScale());
			postDetailDto.setPayScale(val.getName());
		}

		postDetailDto.setBasicPay(String.valueOf(dto.getBasicPay()));

		postDetailDto.setDateOfNextIncrement(dto.getDateOfNextIncrSrJnr().toString());
		postDetailDto.setBenefitEffectiveDate(dto.getChBeneEffDate().toString());

		val = edpLuLookUpInfoRepository.getOnlyIdAndName(entity.getCurEmpClass().getLookUpInfoId());
		postDetailDto.setEmployeeClassId(val.getName());

		val = designationRepository.getOnlyIdAndName(entity.getCurEmpDsgn().getDesignationId());
		postDetailDto.setDesignationId(val.getName());

		PVUEmployeEntity empEntity = this.empRepository.getOne(dto.getEmployeeId());
		postDetailDto.setOfficeId(String.valueOf(empEntity.getOfficeId().getOfficeName()));
		postDetailDto.setEventOrderNo(dto.getEventOrderNo());
		postDetailDto.setEventOrderDate(dto.getEventOrderDate().toString());
		postDetailDto.setEventEffectiveDate(dto.getEventEffectiveDate().toString());

		if (dto.getPayCommId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			postDetailDto.setPayCommId(PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME);
		} else if (dto.getPayCommId() == PvuConstant.SIXTH_COMMISSION_ID) {
			postDetailDto.setPayCommId(PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME);
		} else if (dto.getPayCommId() == PvuConstant.FIFTH_COMMISSION_ID) {
			postDetailDto.setPayCommId(PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME);
		}
		postDetailDto.setEvent(PvuConstant.EVENT_CODE_STEPPIN_UP);
		postDetailDto.setEventCode(
				dto.getEventCode().equalsIgnoreCase(PvuConstant.EVENT_CODE_STEPPIN_UP) ? "Stepping Up" : null);

		EDPLuLookUpInfoEntity stpTypeLookUp = edpLuLookUpInfoRepository.findBylookUpInfoId(dto.getSteppingUpTypeId());
		postDetailDto.setType(String.valueOf(stpTypeLookUp.getLookUpInfoName()));
		postDetailDto.setSteppingUpTypeId(String.valueOf(stpTypeLookUp.getLookUpInfoName()));
		postDetailDto.setEmployeeNo(String.valueOf(dto.getEmployeeNo()));
		postDetailDto.setTrnNo(dto.getTrnNo());

		return postDetailDto;
	}

	// Start Auditor
	@Override
	public List<PVUMsReasonDto> getSteppingUpReasons() {
		return pvuMsReasonService.getEventsReasons();
	}

	@Override
	public List<PVUEventRemarksDto> getReturnReasonByTransactionId(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.CS_PVU_EVENT_ID, id);
		map.put(PvuConstant.PVU_EVENT_ID, PvuConstant.EVENT_ID_STEPPIN_UP);
		map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
		List<Object[]> objects = remarkRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getSTPEventReturnRemarks(),
				map);
		return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PVUEventRemarksDto.class)
				: Collections.emptyList();
	}

	@Override
	@Transactional(rollbackFor = { CustomException.class, Exception.class })
	public PVUSteppingUpEventDto updateRemarks(PVUSteppingUpEventDto dto) throws CustomException {

		PVUSteppingUpEventEntity entity = converter.updateSteppingUpRemarks(getSteppingUpById(dto.getId()), dto);
		PVUSteppingUpEventEntity updateSteppingUpEntity = saveOrUpdateStEvent(entity);

		if (!Utils.isEmpty(dto.getReturnReasons())) {
			Long wfRoleId = dto.getWfRoleId();
			String remarkType = null;

			if (dto.getWfRoleId().equals(Constant.AUDITOR)) {
				remarkType = Constant.AUDITOR_NAME;
			} else if (dto.getWfRoleId().equals(Constant.VERIFIER)) {
				remarkType = Constant.VERIFIER_NAME;
			} else if (dto.getWfRoleId().equals(Constant.APPROVER_CLASS_ONE)) {
				remarkType = Constant.AUTHORIZE_CLASS_I;
			} else if (dto.getWfRoleId().equals(Constant.APPROVER_CLASS_TWO)) {
				remarkType = Constant.APPROVER_CLASS_TWO_NAME;
			}

			boolean isReturnReason = false;

			if (dto.getWfRoleId().equals(Constant.AUDITOR)) {
				remarkType = Constant.AUDITOR_NAME;
			} else if (dto.getWfRoleId().equals(Constant.VERIFIER)) {
				remarkType = Constant.VERIFIER_NAME;
			} else if (dto.getWfRoleId().equals(Constant.APPROVER_CLASS_ONE)) {
				remarkType = Constant.AUTHORIZE_CLASS_I;
			} else if (dto.getWfRoleId().equals(Constant.APPROVER_CLASS_TWO)) {
				remarkType = Constant.APPROVER_CLASS_TWO_NAME;
			}

			isReturnReason = checkIsReturmReason(dto);

			if (isReturnReason) {
				this.returnReason(dto, wfRoleId, remarkType);
			}
		}
		return converter.toDTO(updateSteppingUpEntity);
	}

	public boolean checkIsReturmReason(PVUSteppingUpEventDto dto) {

		boolean isReturnReason = false;
		if (((!Utils.isEmpty(dto.getAuditorReturnReason())) && dto.getAuditorReturnReason() == Constant.RETURN_VAL)
				|| ((!Utils.isEmpty(dto.getVerifierReturnReason()))
						&& dto.getVerifierReturnReason() == Constant.RETURN_VAL)
				|| ((!Utils.isEmpty(dto.getClassTwoReturnReason()))
						&& dto.getClassTwoReturnReason() == Constant.RETURN_VAL)
				|| ((!Utils.isEmpty(dto.getClassOneReturnReason()))
						&& dto.getClassOneReturnReason() == Constant.RETURN_VAL)) {

			isReturnReason = dto.getAuditorReturnReason() == Constant.RETURN_VAL
					|| dto.getVerifierReturnReason() == Constant.RETURN_VAL
					|| dto.getClassOneReturnReason() == Constant.RETURN_VAL
					|| dto.getClassTwoReturnReason() == Constant.RETURN_VAL;
		}
		return isReturnReason;

	}

	@Transactional(rollbackFor = { Exception.class })
	public void returnReason(PVUSteppingUpEventDto dto, Long wfRoleId, String remarkType) {
		Optional<PVUMsEventEntity> msEvent = msEventRepository.findByEventCode(PvuConstant.EVENT_CODE_STEPPIN_UP);
		// Need to deactive old reason
		if (msEvent.isPresent()) {
			eventRemarksService.deactiveOldReason(msEvent.get().getId(), dto.getId(), Constant.IN_ACTIVE_STATUS);
		}

		// Need to insert new reason
		List<PVUEventRemarksEntity> lstRopRemarks = dto.getReturnReasons().stream().map(remarkDto -> {
			PVUEventRemarksEntity pvuEventRemarksEntity = new PVUEventRemarksEntity();
			pvuEventRemarksEntity.setTrnNo(dto.getId());
			pvuEventRemarksEntity.setEventID(PvuConstant.EVENT_ID_STEPPIN_UP);
			pvuEventRemarksEntity.setWfRoleId(wfRoleId);
			pvuEventRemarksEntity.setEmpId(dto.getEmployeeId());
			pvuEventRemarksEntity.setRemarks(remarkDto.getRemarks());
			pvuEventRemarksEntity.setRemarksType(remarkType);
			pvuEventRemarksEntity.setReason(remarkDto.getReasonId());
			pvuEventRemarksEntity.setActiveStatus(Constant.ACTIVE_STATUS);
			return pvuEventRemarksEntity;
		}).collect(Collectors.toList());
		eventRemarksService.saveOrUpdateRemarksAll(lstRopRemarks);

	}

	public PVUSteppingUpEventEntity getSteppingUpById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(MsgConstant.RECORD_NOT_FOUND));
	}

	// End Auditor

	@Override
	public PagebleDTO<PVUSteppingUpOutwardView> getSteppingUpOutwardList(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapOutwardList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_OUTWARD_LIST_WF).toString();

			List<PVUSteppingUpOutwardView> objStorePro = this.storeProcPvu(procName, map,
					PVUSteppingUpOutwardView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public Map<String, Object> buildPageInMapOutwardList(PageDetails pageDetail) {
		Map<String, String> collect = getOutwardSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	public List<PVUSearchEnum> getOutwardSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_INW_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_OUTWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_OUTWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_OUTWARD_NO, PVUSearchEnum.PVU_SEARCH_FIELD_IN_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_IN_APPROVER_POU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME, PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
				PVUSearchEnum.PVU_SEARCH_PAN, PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX,
				PVUSearchEnum.PVU_SEARCH_DDO, PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO, PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE, PVUSearchEnum.SEARCH_FIELD_IN_POU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_SEA_OFFICE_ID);
	}

	@Override
	public Boolean generateOutwardNumber(List<IdDto> dtos) throws CustomException {
		try {
			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();

			dtos.forEach(dto -> {
				Map<Integer, Object> map = new LinkedHashMap<>();
				map.put(1, Constant.ST);
				map.put(2, dto.getId());
				parameterMapList.add(map);
			});

			return repository.callStoreProcBatch("{CALL "
					+ Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.OUTWARD_NO_GENERATION_PVU)) + "(?,?)}",
					parameterMapList);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	@Transactional
	public Boolean submiSteppingUpOutward(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException {
		try {

			wrapperDto.forEach(dto -> pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(),
					new Date(), PvuConstant.EVENT_ID_STEPPIN_UP, dto.getTrnId(), Constant.OUTWARD_FLAG_ZERO,
					Constant.ACTIVE_STATUS));

			wrapperDto.forEach(dto -> inwardService.setConsignmentNumber(dto.getTrnId(),
					PvuConstant.EVENT_ID_STEPPIN_UP, dto.getPostConsignmentNumber()));

			List<PvuWFOutWardWrapperDto> authList = wrapperDto.stream()
					.filter(e -> Objects.nonNull(e.getStatus()) && e.getStatus().equalsIgnoreCase(Constant.AUTHORIZE))
					.collect(Collectors.toList());

			List<PvuWFOutWardWrapperDto> rWFlist = wrapperDto.stream()
					.filter(e -> Objects.nonNull(e.getStatus()) && e.getStatus().equalsIgnoreCase(Constant.RETURN))
					.collect(Collectors.toList());

			return (processReturnOutWards(rWFlist) && processAuthorizedOutWards(authList));

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}

	}

	@Transactional
	public boolean processReturnOutWards(List<PvuWFOutWardWrapperDto> rWFlist) throws CustomException {
		if (rWFlist.isEmpty())
			return true;
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.MENU_ID, rWFlist.get(0).getMenuId());
		map.put(PvuConstant.EVENT_ID, PvuConstant.EVENT_ID_STEPPIN_UP);
		map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getWfTable(), map);
		List<PVUWfTableInfo> tableList = !Utils.isEmpty(objects)
				? NativeQueryResultsMapper.map(objects, PVUWfTableInfo.class)
				: Collections.emptyList();

		if (tableList.isEmpty())
			return false;
		List<PvuWFWrapperDto> returnList = setDDOApprover(rWFlist, tableList);
		return pvuFacade.callWorkFlowApis(returnList);
	}

	public List<PvuWFWrapperDto> setDDOApprover(List<PvuWFOutWardWrapperDto> rWFlist, List<PVUWfTableInfo> tableList)
			throws CustomException {
		List<PvuWFWrapperDto> returnList = new ArrayList<>();
		for (PvuWFWrapperDto dto : rWFlist) {
			Map<String, Object> returnMap = new HashMap<>();
			returnMap.put(PvuConstant.TRN_ID, dto.getTrnId());
			List<Object[]> returnObjects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getWfSourceUserDetail(
					tableList.get(0).getSchemaName(), tableList.get(0).getTableName()), returnMap);
			List<PVUSourceUserDetails> users = !Utils.isEmpty(returnObjects)
					? NativeQueryResultsMapper.map(returnObjects, PVUSourceUserDetails.class)
					: Collections.emptyList();
			PVUSourceUserDetails user;
			if (!CollectionUtils.isEmpty(users)) {
				user = users.get(0);
				dto.setAssignToOfficeId(user.getAssignByOfficeId());
				dto.setAssignToPOUId(user.getAssignByPouId());
				dto.setAssignByPostId(user.getAssignByPostId());
				dto.setAssignToUserId(user.getAssignByUserId());
				dto.setAssignToWfRoleId(3L);
				dto.setWfStatus(PvuConstant.RETURNED);
				returnList.add(dto);
			}
		}
		return returnList;
	}

	@Transactional
	public boolean processAuthorizedOutWards(List<PvuWFOutWardWrapperDto> authList) {

		if (authList.isEmpty())
			return true;
		authList.forEach(authDto -> {
			pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
					PvuConstant.EVENT_ID_STEPPIN_UP, authDto.getTrnId(), Constant.OUTWARD_FLAG_ZERO,
					Constant.ACTIVE_STATUS);
			PVUSteppingUpEventEntity entity = repository.getOne(authDto.getTrnId());

			insertForAuthorization(authDto.getTrnId());
			insertSteppingUpAutoIncr(entity.getTrnNo());
			reset(entity.getCurEmpId().getEmpId(), PvuConstant.EVENT_STATUS_STEPPING_UP);
		});
		authList.forEach(e -> e.setWfStatus(PvuConstant.AUTHORIZED));
		return pvuFacade.callWorkFlowApis(PvuWFOutWardWrapperDto.createSuper(authList));
	}

	@Transactional
	public void insertSteppingUpAutoIncr(String trnId) {

		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnId);
		map.put(Constant.IN_EVNT_CODE, PvuConstant.EVENT_CODE_STEPPIN_UP);

		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map);
	}

	@Transactional
	public void insertForAuthorization(Long trnId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnId);
		map.put(Constant.IN_EVENT_CODE, PvuConstant.EVENT_CODE_STEPPIN_UP);
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.PVU_COMMON_AUTHORIZED_SP, map);
	}

	@Override
	public PagebleDTO<PVUSteppingUpPrintEndorsementView> getSteppingUpPrintEndorsement(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapPrintEndorsementList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF).toString();

			List<PVUSteppingUpPrintEndorsementView> objStorePro = this.storeProcPvu(procName, map,
					PVUSteppingUpPrintEndorsementView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public Map<String, Object> buildPageInMapPrintEndorsementList(PageDetails pageDetail) {
		Map<String, String> collect = getPrintEndorsementSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	public List<PVUSearchEnum> getPrintEndorsementSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO, PVUSearchEnum.PVU_SEARCH_FIELD_AUTHORIZATION_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_AUTHORIZATION_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_PAN,
				PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX, PVUSearchEnum.PVU_SEARCH_DDO,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_PVU_OFFICE, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID, PVUSearchEnum.PVU_SEARCH_PRINT_STATUS);
	}

	@Override
	public List<PVUPrintEndorsementRemarkHistoryDto> getReprintEndorsementRemarks(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.TRN_ID, id);
		map.put(PvuConstant.EVENT_ID, PvuConstant.EVENT_ID_STEPPIN_UP);
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getCommonEndorsementHistory(),
				map);
		return !Utils.isEmpty(objects)
				? NativeQueryResultsMapper.map(objects, PVUPrintEndorsementRemarkHistoryDto.class)
				: Collections.emptyList();
	}

	/**
	 * Submit print history.
	 *
	 * @param dto        the dto
	 * @param pvuRopView
	 * @return the sticker DTO
	 * @throws CustomException the custom exception
	 */
	public PVUStickerDTO submitPrintHistory(PvuPrintStickerReportDto dto) throws CustomException {
		PVUStickerDTO stickerDTO = dto.getStickerDTO();
		PVUPrintEndorsementDto printEndorsementDto = submitPEWF(dto);
		if (printEndorsementDto != null) {
			dto.setPrintEndorsementDto(printEndorsementDto);
			if (printEndorsementDto.getPrintDate() != null) {
				stickerDTO.setEndorsementPrintDate(printEndorsementDto.getPrintDate());
			}
			if (printEndorsementDto.getReprintDate() != null) {
				stickerDTO.setEndorsementReprintDate(printEndorsementDto.getReprintDate());
			}
			if (printEndorsementDto.getPrintCnt() != null) {
				stickerDTO.setRePrintCount(printEndorsementDto.getPrintCnt());
			}
			if (printEndorsementDto.getRemark() != null) {
				stickerDTO.setRePrintRemark(printEndorsementDto.getRemark());
			}
		}
		return stickerDTO;
	}

	/**
	 * Submit PEWF.
	 *
	 * @param PvuPrintStickerReportDto the dto
	 * @return the PVU rop print endorsement dto
	 * @throws CustomException the custom exception
	 */
	public PVUPrintEndorsementDto submitPEWF(PvuPrintStickerReportDto dto) throws CustomException {
		PVUPrintEndorsementEntity printEntity = null;
		try {
			if (dto.getPrintEndorsementDto() != null) {
				printEntity = pvuPrintEndorsementRepository
						.findByIdAndActiveStatus(dto.getPrintEndorsementDto().getId(), Constant.ACTIVE_STATUS);

				if (printEntity != null) {
					dto.getPrintEndorsementDto().setReprintDate(new Date());
					dto.getPrintEndorsementDto().setPrintDate(printEntity.getPrintDate());
					dto.getPrintEndorsementDto().setPrintCnt(printEntity.getPrintCnt() + 1l);
					dto.getPrintEndorsementDto().setTrnId(dto.getPvuWFWrapperDto().getTrnId());
					dto.getPrintEndorsementDto().setEventId(PvuConstant.EVENT_ID_STEPPIN_UP);

				} else {
					/** For authorized case, and final reflection done by this */
					Boolean result = pvuFacade.callWorkFlowApis(dto.getPvuWFWrapperDto());

					if (result.equals(Boolean.TRUE)) {
						pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
								PvuConstant.EVENT_ID_STEPPIN_UP, dto.getPvuWFWrapperDto().getTrnId(),
								Constant.OUTWARD_FLAG_ONE, Constant.ACTIVE_STATUS);
						dto.getPrintEndorsementDto().setPrintCnt((dto.getPrintEndorsementDto().getPrintCnt() + 1l));
						dto.getPrintEndorsementDto().setPrintDate(new Date());
						dto.getPrintEndorsementDto().setTrnId(dto.getPvuWFWrapperDto().getTrnId());
						dto.getPrintEndorsementDto().setEventId(PvuConstant.EVENT_ID_STEPPIN_UP);
					}
				}

				printEntity = pvuPrintEndorsementRepository.save(converter.toEntity(dto.getPrintEndorsementDto()));

				pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrConverter.toEntity(printEntity));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return printEntity != null ? converter.toDTO(printEntity) : null;
	}

	@Override
	@Transactional
	public String generatePrintEndorsement(PvuPrintStickerReportDto dto) throws IOException, CustomException {
		List<PvuPrintStickerReportDto> list = new ArrayList<>();
		list.add(dto);
		return generatePdf(list);
	}

	@Override
	@Transactional
	public String generatePrintEndorsementList(List<PvuPrintStickerReportDto> dto) throws CustomException {
		return generatePdf(dto);
	}

	public StringWriter generatePrint(PvuPrintStickerReportDto dto) throws CustomException {
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		PVUStickerDTO stickerDTO = null;
		try {
			stickerDTO = submitPrintHistory(dto);

			PVUSteppingUpEventEntity entity = repository.getOne(dto.getStickerDTO().getId());
			PVUSteppingUpEventDto stdto = converter.toDTO(entity);
			VelocityContext context = populateVContext(stickerDTO, entity, stdto);

			Template template = getPrintTemplate(stdto);

			template.merge(context, writer);

			return writer;
		} catch (CustomException e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public VelocityContext populateVContext(PVUStickerDTO stickerDTO, PVUSteppingUpEventEntity entity,
			PVUSteppingUpEventDto stdto) {
		VelocityContext context = new VelocityContext();

		context.put("empNo", stdto.getEmployeeNo());

		context.put("basicPay", String.valueOf(stdto.getBasicPay()));
		context.put("effectiveDate", PvuUtils.getStrOfLocalDateInDDMMYYYY(stdto.getChBeneEffDate()));
		context.put("dateofnxtinc", PvuUtils.getStrOfLocalDateInDDMMYYYY(stdto.getDateOfNextIncrSrJnr()));

		context.put("printDate",
				!Utils.isEmpty(stickerDTO.getEndorsementPrintDate())
						? Utils.getDateString(stickerDTO.getEndorsementPrintDate())
						: "");
		context.put("rePrintDate",
				!Utils.isEmpty(stickerDTO.getEndorsementReprintDate())
						? Utils.getDateString(stickerDTO.getEndorsementReprintDate())
						: "");
		context.put("rePrintCount", stickerDTO.getRePrintCount());
		context.put("rePrintRemarks",
				!Utils.isEmpty(stickerDTO.getRePrintRemark()) ? stickerDTO.getRePrintRemark() : "");

		if (stdto.getPayCommId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			context.put("cell", entity.getChCellId().getCellId());
			context.put("payLevel", entity.getChPayLevel().getPayLevelValue());

		} else if (stdto.getPayCommId() == PvuConstant.SIXTH_COMMISSION_ID) {

			context.put("gradePay", entity.getChGradePay().getGradePayValue());
			context.put("payBand", entity.getChPayBand().getPayBandDispVal());
			context.put("payBandValue", stdto.getPayBandValue());

		} else if (stdto.getPayCommId() == PvuConstant.FIFTH_COMMISSION_ID) {

			context.put("payScale", entity.getChScale().getScaleValue());
		}

		context.put("empDesgn", entity.getCurEmpDsgn().getDesignationName());
		context.put("jrEmpDesgn", entity.getCurEmpDsgn().getDesignationName()); // jr emp desg must be same as Sr

		context.put("ddoOfficeAddress", stickerDTO.getOfficeName());
		context.put("jrDdoOfficeAddress", stickerDTO.getOfficeName()); // jr emp office must be same as Sr
		context.put("eventDate", PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getEventEffectiveDate()));

		context.put("remarks", !Utils.isEmpty(entity.getAuthorizerRemark()) ? entity.getAuthorizerRemark() : "");
		if (entity.getAuthorizeBy() != null) {
			context.put("authorizeBy", String.valueOf(authService.getOnlyIdAndName(entity.getAuthorizeBy()).getName()));
		}

		PVUEmployeEntity empEntity = this.empRepository.getOne(stdto.getEmployeeId());

		String gender;
		EDPLuLookUpInfoEntity srGender = edpLuLookUpInfoRepository
				.findBylookUpInfoId(empEntity.getGender().getLookUpInfoId());

		gender = srGender.getLookUpInfoName();

		if (gender.equalsIgnoreCase("Male")) {
			context.put("gender", "His");
		} else {
			context.put("gender", "Her");
		}

		String sr = "";
		if (!Utils.isEmpty(empEntity.getSalutation())) {
			EDPLuLookUpInfoEntity srSaluation = edpLuLookUpInfoRepository
					.findBylookUpInfoId(empEntity.getSalutation().getLookUpInfoId());
			sr = srSaluation.getLookUpInfoName();
		}

		context.put("empName",
				String.valueOf(sr + " " + StringUtils.defaultString(empEntity.getEmployeeName()) + " "
						+ StringUtils.defaultString(empEntity.getEmployeeMiddleName()) + " "
						+ StringUtils.defaultString(empEntity.getEmployeeSurname())));

		PVUEmployeEntity jrEmpEntity = this.empRepository.getOne(stdto.getJrEmpId());

		EDPLuLookUpInfoEntity jrGender = edpLuLookUpInfoRepository
				.findBylookUpInfoId(jrEmpEntity.getGender().getLookUpInfoId());

		gender = jrGender.getLookUpInfoName();

		if (gender.equalsIgnoreCase("Male")) {
			context.put("jrGender", "His");
		} else {
			context.put("jrGender", "Her");
		}

		String jr = "";
		if (!Utils.isEmpty(jrEmpEntity.getSalutation())) {
			EDPLuLookUpInfoEntity jrSaluation = edpLuLookUpInfoRepository
					.findBylookUpInfoId(jrEmpEntity.getSalutation().getLookUpInfoId());
			jr = jrSaluation.getLookUpInfoName();
		}
		context.put("jrEmpName",
				String.valueOf(jr + " " + StringUtils.defaultString(jrEmpEntity.getEmployeeName()) + " "
						+ StringUtils.defaultString(jrEmpEntity.getEmployeeMiddleName()) + " "
						+ StringUtils.defaultString(jrEmpEntity.getEmployeeSurname())));

		EDPLuLookUpInfoEntity stpTypeLookUp = edpLuLookUpInfoRepository.findBylookUpInfoId(stdto.getSteppingUpTypeId());
		context.put("steppingUpType", String.valueOf(stpTypeLookUp.getLookUpInfoName()));

		return context;
	}

	public Template getPrintTemplate(PVUSteppingUpEventDto stdto) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template tempName = new Template();
		if (stdto.getPayCommId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/steppingUp/SteppingUp7thPay.vm");
		} else if (stdto.getPayCommId() == PvuConstant.SIXTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/steppingUp/SteppingUp6thPay.vm");
		} else if (stdto.getPayCommId() == PvuConstant.FIFTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/steppingUp/SteppingUp5thPay.vm");
		}
		return tempName;
	}

	public String generatePdf(List<PvuPrintStickerReportDto> dto) throws CustomException {
		int count = 1;
		PdfWriter pdfWriter = null;
		StringWriter writer = new StringWriter();
		// create a new document
		Document document = new Document();
		StringBuilder sb = new StringBuilder();
		try {
			String watermark = null;
			Map<String, Object> map = new HashMap<>();
			document = new Document();
			// document header attributes
			document.addAuthor("GOG");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("GOG Finance");
			document.addTitle("Stepping Up Event");
			document.setPageSize(PageSize.LETTER);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			pdfWriter = PdfWriter.getInstance(document, baos);

			// open document
			document.open();

			for (PvuPrintStickerReportDto printStickerReportDto : dto) {
				
				PVUSteppingUpEventEntity spentity = repository.getOne(printStickerReportDto.getStickerDTO().getId());
				if (spentity.getOfficeId().getOfficeId().equals(spentity.getOfficeId().getPvuId())
						&& spentity.getOfficeId().getOfficeId() != Constant.PVU_OFFICE_ID) {
					watermark = ", Self PVU";
				} else {
					watermark = ", PVU, Gandhinagar";
				}

				pdfWriter.setPageEvent(
						new WatermarkPageEvent(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()), watermark));
				writer.write(generatePrint(printStickerReportDto).toString());
				if (count < dto.size()) {
					writer.append("<p style=\"page-break-after: always;\">&nbsp;</p>");
				}
				count++;
				map.put("content", writer.toString()); 
				sb.append(pvuCommonService.base64toPDFWithWaterMark(map, watermark));
				XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
				xmlWorkerHelper.getDefaultCssResolver(true);
				xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));
				document.newPage();

			}

			// close the document
			document.close();
			map.put("content", writer.toString());
			
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=" + PvuConstant.EVENT_CODE_STEPPIN_UP + ".pdf");
			header.setContentLength(baos.toByteArray().length);

			logger.info("PDF generated successfully");
			return sb.toString();// call this method for node js API for
			// html with watermark
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	@Override
	public String getWfRoleCodeByTrnId(Long trnId) {
		return this.wfRepository.findWfRlCdBySteppingUpTrnId(trnId, Constant.ACTIVE_STATUS);
	}

	@Override
	public String generateComparisionReport(IdDto dto) throws IOException, CustomException, DocumentException {
		return generateComparisionPdf(dto);
	}

	public String generateComparisionPdf(IdDto dto) throws CustomException {

		PdfWriter pdfWriter = null;
		StringWriter writer = new StringWriter();
		// create a new document
		Document document = new Document();
		try {
			String htmltoPdf = null;
			Map<String, Object> map = new HashMap<>();
			document = new Document();
			// document header attributes
			document.addAuthor("GOG");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("GOG Finance");
			document.addTitle("Stepping Up Event Comparision Report");
			document.setPageSize(PageSize.LETTER);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			pdfWriter = PdfWriter.getInstance(document, baos);

			// open document
			document.open();

			writer.write(generateComparisionPrint(dto).toString());

			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));

			// close the document
			document.close();
			
			map.put("content", writer.toString());
			htmltoPdf = pvuCommonService.htmlToPdfRequest(map); // call this method for node js API for html to Base64
			
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=" + PvuConstant.EVENT_STATUS_STEPPING_UP + ".pdf");
			header.setContentLength(baos.toByteArray().length);

			logger.info("PDF generated successfully");

			return htmltoPdf;
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}

	}

	public StringWriter generateComparisionPrint(IdDto dto) throws CustomException {
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		PVUCommonApiDto pvuCommonApiDto = new PVUCommonApiDto();
		PVUEmployeDepartmentEntity dep = new PVUEmployeDepartmentEntity();
		PVUSteppingUpEventEntity entity = this.getStEvent(dto.getId());

		if (!Utils.isEmpty(entity.getJrEmpId())) {
			Map<String, Object> map1 = new HashMap<>();
			map1.put("IN_PAGE_INDEX", 0);
			map1.put("IN_PAGE_SIZE", 10);
			map1.put("IN_EFFECTIVE_DATE", PvuUtils.getStrOfLocalDateInYMD(entity.getChBeneEffDate()));
			map1.put("IN_PAY_COMM", entity.getPayComm().getLookUpInfoId());
			map1.put("IN_EVENT_ID", 0);
			map1.put("IN_EMPLOYEE_NO", entity.getJrEmpId().getEmployeeCode());
			map1.put("IN_OFFICE_ID", entity.getOfficeId().getOfficeId());
			pvuCommonApiDto = pvuCommonService.getCommonDetailsBasedOnEventDate(map1);

			dep = pvuEmployeeDepartmentRepo.findFirstByPvuEmployeEntityEmpId(entity.getJrEmpId().getEmpId());

		}

		PVUEmployeDepartmentEntity currentEmployeedep = pvuEmployeeDepartmentRepo
				.findFirstByPvuEmployeEntityEmpId(entity.getCurEmpId().getEmpId());
		PVUEmployeEventsEntity employeEventsEntity = pvuEmployeEventsService
				.findLatestEvent(entity.getCurEmpId().getEmpId());

		if (employeEventsEntity != null && entity.getLastPfDate() == null) {
			entity.setLastPfDate(employeEventsEntity.getEventDate().toLocalDate());
		}

		VelocityContext context = converter.comparisionReport(entity, pvuCommonApiDto);

		context.put("sr_last_pay_fixation_date",
				!Utils.isEmpty(entity.getLastPfDate()) ? PvuUtils.getStrOfLocalDateInDMY(entity.getLastPfDate()) : "");

		context.put("jn_emp_designation",
				!Utils.isEmpty(dep.getDesignationId()) ? dep.getDesignationId().getDesignationName() : "");
		context.put("sr_emp_doj",
				!Utils.isEmpty(currentEmployeedep.getDateOfJoiningGOG())
						? PvuUtils.getDateToStringDMYFormatValue(currentEmployeedep.getDateOfJoiningGOG())
						: "");

		Map<String, Object> map = new HashMap<>();
		map.put("trnId", dto.getId());
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getSteppingUpApproverRemarks(),
				map);

		if (objects != null && !objects.isEmpty() && objects.get(0) != null) {
			context.put("sr_other_details",
					(objects.get(0).length != 0 && String.valueOf(objects.get(0)[0]) != null)
							? String.valueOf(objects.get(0)[0])
							: "");
		} else {
			context.put("sr_other_details", "");
		}

		Template template = getComparisionPrintTemplate();
		template.merge(context, writer);
		return writer;
	}

	public Template getComparisionPrintTemplate() {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		return ve.getTemplate("templates/steppingUp/SteppingUpComparision.vm");
	}

	/**
	 * Update for pulled back.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @param pvuEntity       the pvu entity
	 */
	private void updateForPulledBack(PvuWFWrapperDto pvuWFWrapperDto, PVUSteppingUpEventEntity pvuEntity) {
		inwardService.updateStatusId(Constant.INACTIVE_STATUS, pvuEntity.getStEventId(), new Date(),
				pvuWFWrapperDto.getEventId());
	}

}
