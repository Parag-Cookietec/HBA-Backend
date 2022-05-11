package gov.ifms.pvu.service;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.itextpdf.text.Document;
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
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUSelectionGradeEventConverter;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUEventSelectionGradeView;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUSGPrintEndorsementView;
import gov.ifms.pvu.dto.PVUSelectionGradOutwardView;
import gov.ifms.pvu.dto.PVUSelectionGradPayLelevView;
import gov.ifms.pvu.dto.PVUSelectionGradeEventDto;
import gov.ifms.pvu.dto.PVUSelectionGradeOfficeSearchView;
import gov.ifms.pvu.dto.PVUSelectionGradenwardView;
import gov.ifms.pvu.dto.PVUSelectiongGradePostDetailDto;
import gov.ifms.pvu.dto.PVUSourceUserDetails;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.PVUWfTableInfo;
import gov.ifms.pvu.dto.PrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUSelectionGradeEventEntity;
import gov.ifms.pvu.repository.PVUEmployeSevenPayDetailRepository;
import gov.ifms.pvu.repository.PVUEventRemarksRepository;
import gov.ifms.pvu.repository.PVUInwardRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.repository.PVURevisionOfPayRemarkRepository;
import gov.ifms.pvu.repository.PVUSelectionGradeEventRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.WatermarkPageEvent;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;

/**
 * The Class PVUSelectionGradeEventController.
 * 
 * @version v 1.0
 * @created 2019/12/18 11:56:47
 */

@Service
public class PVUSelectionGradeEventServiceImpl implements PVUSelectionGradeEventService {

	/** The logger. */

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUSelectionGradeEventAsMethodName repository. */

	@Autowired
	private PVUSelectionGradeEventRepository repository;

	/** The PVUEmployeSevenPayDetailRepository repository. */
	@Autowired
	PVUEmployeSevenPayDetailRepository pvuEmployeSevenPayDetailRepository;

	/** The PVUSelectionGradeEventAsMethodName helper. */

	@Autowired
	private PVUSelectionGradeEventConverter converter;

	@Autowired
	private PVYFacade pvuFacade;

	@Autowired
	private PVUEmployeeEventStatusService statusService;

	@Autowired
	private PVUCommonService pvuCommonService;

	/**
	 * The e DP lu look up info repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Autowired
	private PVUMsReasonService pvuMsReasonService;

	@Autowired
	private PVURevisionOfPayRemarkRepository remarkRepository;

	/** The pvu inward service. */
	@Autowired
	private PVUInwardRepository pvuInwardRepository;

	@Autowired
	private PVUEventRemarksRepository remarksRepository;

	@Autowired
	private PVUEventRemarksService eventRemarksService;

	@Autowired
	private WfRepository wfRepository;

	/** The pvu inward service. */
	@Autowired
	PVUPrintEndorsementRepository pvuPrintEndorsementRepository;

	@Autowired
	PVUPrintEndorsementItrRepository pvuPrintEndorsementItrRepository;

	@Autowired
	EncryptDecryptUtil securityUtil;

	@Autowired
	private OAuthService authService;

	@Autowired
	private PVUInwardService inwardService;

	/**
	 * Retrieves an PVUSelectionGradeEventEntity by its id.
	 *
	 * @return the PVUSelectionGradeEventEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */

	/**
	 * Gets the selection grade event.
	 *
	 * @param id the id
	 * @return the selection grade event
	 */
	@Override
	public PVUSelectionGradeEventEntity getSelectionGradeEvent(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(MsgConstant.RECORD_NOT_FOUND));
	}

	/**
	 * Saves a given PVUSelectionGradeEventEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param dto the dto
	 * @return the saved PVUSelectionGradeEventEntity
	 * @throws CustomException
	 */
	@Override
	public PVUSelectionGradeEventEntity saveOrUpdateSelectionGradeEvent(PVUSelectionGradeEventDto dto)
			throws CustomException {
		PVUSelectionGradeEventEntity sgEntity = converter.toEntity(dto);
		if (dto.getStatusId() == 0) {
			pvuEmployeeEventStatusService.inProgressSuspensionEvent(sgEntity.getEmpId().getEmpId());
			sgEntity.setStatusId(lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT));
		}
		sgEntity = saveOrUpdate(sgEntity);
		return sgEntity;
	}

	/**
	 * Fetch all the PVUSelectionGradeEvent items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUSelectionGradeEventDto>
	 * @throws CustomException the custom exception
	 */

	@Override
	public PagebleDTO<PVUSelectionGradenwardView> getSelectionGradeEvents(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapInwardList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_INWARD_LIST_WF).toString();
			List<PVUSelectionGradenwardView> objStorePro = this.storeProcPvu(procName, map,
					PVUSelectionGradenwardView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.info(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
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

	private Map<String, Object> buildPageInMapInwardList(PageDetails pageDetail) {
		Map<String, String> collect = getInwardSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	public List<PVUSearchEnum> getInwardSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO, PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_INW_NO, PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
				PVUSearchEnum.PVU_SEARCH_PAN, PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX,
				PVUSearchEnum.PVU_SEARCH_DDO, PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO, PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID,
				PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID);
	}

	public PVUSelectionGradeEventEntity saveOrUpdate(PVUSelectionGradeEventEntity entity) throws CustomException {
		PVUSelectionGradeEventEntity save = null;
		try {
			save = repository.save(entity);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
		return save;
	}

	public PVUEmployeeEventStatusEntity inProgressAnyEvent(Long employeeId, String trnNo) throws CustomException {
		Optional<PVUEmployeeEventStatusEntity> progress = pvuEmployeeEventStatusService.findByEmpId(employeeId);
		if (progress.isPresent()) {
			PVUEmployeeEventStatusEntity statis = progress.get();
			if (trnNo.equalsIgnoreCase(statis.getTransId())) {
				return progress.get();
			}
			PVUEmployeeEventStatusDto eventStatus = pvuEmployeeEventStatusService.getEventStatus(progress.get());
			if (eventStatus.isInProgress()) {
				throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(MsgConstant.EVENT_IN_PROGRESS,
						eventStatus.getTransId(), eventStatus.getEmployeeCode().toString()));
			}
			return progress.get();
		}
		throw new CustomException(500, PvuConstant.VALIDATION_MSG);
	}

	@Override
	public PVUSelectionGradeEventDto insertSelectionGradeItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
		PVUSelectionGradeEventDto pvuCommonResponse = null;
		PVUSelectionGradeEventEntity find = getSelectionGradeEvent(pvuWFWrapperDto.getTrnId());
		if (find != null) {
			varifiedTrnStatus(find);
			EDPLuLookUpInfoEntity empApprovStatsLookupInfo = lookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.APPROVED);
			boolean check = pvuFacade.callWorkFlowApis(pvuWFWrapperDto);
			if (check) {
				pvuCommonResponse = converter.toDTO(find);
				approvedORejectedBy(pvuWFWrapperDto, find, empApprovStatsLookupInfo);
				authorisedbyClass2AndauthorisedbyClass1(pvuWFWrapperDto, find);
				returnedbyPVUApproverClass2ADreturnedbyPVUApproverClass1(pvuWFWrapperDto);
				forwardToPvu(pvuWFWrapperDto);
				insertSelectionGradeInITRs(pvuWFWrapperDto);
			} else {
				throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
			}
		}
		return pvuCommonResponse;
	}

	public void forwardToPvu(PvuWFWrapperDto pvuWFWrapperDto) {
		if (pvuWFWrapperDto.getWfStatus() != null
				&& (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.FORWARD_TO_PVU))) { // Forward to PVU
			this.insertInwardTable(pvuWFWrapperDto);
		}
		if (pvuWFWrapperDto.getAssignByWfRoleId() != null && (pvuWFWrapperDto.getAssignByWfRoleId() == Constant.AUDITOR
				|| Objects.equals(pvuWFWrapperDto.getAssignByWfRoleId(), Constant.VERIFIER)
				|| pvuWFWrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_TWO
				|| pvuWFWrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_ONE)) {
			this.insertSelectionGradeRemarks(pvuWFWrapperDto.getTrnId());
		}
	}

	public void varifiedTrnStatus(PVUSelectionGradeEventEntity find) throws CustomException {
		PVUEmployeeEventStatusEntity statusEntry = null;

		if (find.getTrnNo() == null && find.getStatusId().getLookUpInfoId() == PvuConstant.SAVE_AS_DRAFT_ID) {
			statusEntry = statusService.inProgressAnyEvent(find.getEmpId().getEmpId());
			find.setTrnNo(this.pvuCommonService.getTransactionNumber(PvuConstant.TranNo.SG.toString()));
			find.setRefDate(LocalDateTime.now());
			repository.save(find);
			statusEntry.setSelectionGrade(Constant.ACTIVE_STATUS);
			statusService.updateEventInfo(statusEntry, find.getTrnNo());
		}

	}

	public void returnedbyPVUApproverClass2ADreturnedbyPVUApproverClass1(PvuWFWrapperDto pvuWFWrapperDto) {

		if (pvuWFWrapperDto.getTrnStatus() != null
				&& (pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_II)
						|| pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_I))) {
			/* Update Status ApproverClass II Return */
			EDPLuLookUpInfoEntity returnStatus = lookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.RECOMMENDATION_FOR,
							Constant.ACTIVE_STATUS, Constant.RETURN);

			repository.updateStatusId(returnStatus.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), new Date());

			pvuInwardRepository.setReturnDateSG(pvuWFWrapperDto.getTrnId(), PvuConstant.SELECTION_GRADE_EVENT_ID,
					OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(), Constant.OUTWARD_FLAG_ONE,
					Constant.ACTIVE_STATUS);
		}
	}

	public void authorisedbyClass2AndauthorisedbyClass1(PvuWFWrapperDto pvuWFWrapperDto,
			PVUSelectionGradeEventEntity entity) {
		if (pvuWFWrapperDto.getTrnStatus() != null
				&& ((pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II))
						|| (pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_I)))) {
			/* Update Status ApproverClass II Authorization */
			String authorizerRemark;
			if (pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)) {
				authorizerRemark = entity.getClassTwoRemarks();
			} else {
				authorizerRemark = entity.getClassOneRemarks();
			}

			EDPLuLookUpInfoEntity authorizationStatus = lookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.RECOMMENDATION_FOR,
							Constant.ACTIVE_STATUS, Constant.AUTHORIZE);

			repository.updateStatusId(authorizationStatus.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), new Date());
			/* Unlock event */
			repository.updateStatusIdAndAuthorizer(authorizationStatus.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), new Date(), new Date(),
					Long.parseLong(securityUtil.decrypt(pvuWFWrapperDto.getAssignByUserId())), authorizerRemark);

			pvuInwardRepository.setAuthorizeDateAndFlag(pvuWFWrapperDto.getTrnId(),
					PvuConstant.SELECTION_GRADE_EVENT_ID, OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(),
					Constant.OUTWARD_FLAG_ZERO, Constant.ACTIVE_STATUS);
		}
	}

	public void approvedORejectedBy(PvuWFWrapperDto pvuWFWrapperDto, PVUSelectionGradeEventEntity find,
			EDPLuLookUpInfoEntity empApprovStatsLookupInfo) {
		Date approvedDate = new Date();
		EDPLuLookUpInfoEntity submitStatus = lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.SUBMIT);
		if (submitStatus != null) {
			repository.updateStatusId(submitStatus.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate);
		}
		if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
			EDPLuLookUpInfoEntity printEnable = lookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.CONDITION_CHECK,
							Constant.ACTIVE_STATUS, Constant.LOOKUP_YES);
			find.setStatusId(empApprovStatsLookupInfo);
			repository.updatePrintStatusAndApproveDate(empApprovStatsLookupInfo.getLookUpInfoId(),
					Constant.ACTIVE_STATUS, pvuWFWrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), new Date(),
					printEnable.getLookUpInfoId(), LocalDateTime.now());
		} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.PULLED_BACK)) {
			updateForPulledBack(pvuWFWrapperDto, find);/* Inactive inward row */
		} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
			EDPLuLookUpInfoEntity empRejectStatsLookupInfo = lookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.REJECTED);
			repository.updateStatusId(empRejectStatsLookupInfo.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate);
			updateEmpEventStatusReset(find);
		}
	}

	/**
	 * Update emp event status.
	 *
	 * @param find the find
	 */
	public void updateEmpEventStatusReset(PVUSelectionGradeEventEntity find) {
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntity = pvuEmployeeEventStatusService
				.findByEmpId(find.getEmpId().getEmpId());
		if (pvuEmployeeEventStatusEntity.isPresent()) {
			pvuEmployeeEventStatusEntity.get().setSelectionGrade(0);
			pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity.get());
		}
	}

	public void insertSelectionGradeInITRs(PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_WORKFLOW_ROLE_ID, pvuWFWrapperDto.getAssignToWfRoleId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_SG_EVNT_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	@Override
	public PVUSelectionGradPayLelevView getEmployeeCheckPayLevelByPaylevelId(PvuCommonRequest pvuRequest)
			throws CustomException {
		Map<String, Long> request = pvuRequest.getRequest();
		List<PVUSelectionGradPayLelevView> viewResults = getQueryOfSelectionPayLevel(pvuRequest);
		Long cellValue = request.get(PvuConstant.C_VALUE);
		PVUSelectionGradPayLelevView viewDto = viewResults.get(0);
		if (viewDto.getCellValue() > cellValue) {
			viewDto.setFlag(true);
		}
		return viewDto;
	}

	public List<PVUSelectionGradPayLelevView> getQueryOfSelectionPayLevel(PvuCommonRequest pvuRequest)
			throws CustomException {
		HashMap<String, Object> objectMap = new HashMap<>();
		Map<String, Long> request = pvuRequest.getRequest();
		Long newPaylevelId = request.get(PvuConstant.N_P_LELEV);
		Long oldPaylevelId = request.get(PvuConstant.O_P_VALUE);
		Long cellValue = request.get(PvuConstant.C_VALUE);
		objectMap.put(PvuConstant.N_P_LELEV, newPaylevelId);
		objectMap.put(PvuConstant.O_P_VALUE, oldPaylevelId);
		objectMap.put(PvuConstant.C_VALUE, cellValue);
		List<Object[]> objectPvuSp = repository.executeSQLQuery(PVUNativeSqlQueryConstant.queryPayValueByPayCommision(),
				objectMap);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUSelectionGradPayLelevView.class)
				: Collections.emptyList();
	}

	@Override
	public PagebleDTO<PVUEventSelectionGradeView> ddoWFListingSg(PageDetails pageDetails) throws CustomException {
		Map<String, String> collect = this.getDdoWFListingSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(null, pageDetails, collect);
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.SG_PVU_EVENT_LS_SRCH_WF));
		List<PVUEventSelectionGradeView> list = this.callSGPVUDDOListing(sp, stringObjectMap);
		return new PagebleDTO<>(pageDetails.getPageElement(), 0, list.size(), list);
	}

	public List<PVUSearchEnum> getDdoWFListingSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_START_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_END_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_FIELD_GPF_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_PPAN_NO, PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO, PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS, PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMPLOYEE_TYPE, PVUSearchEnum.SEARCH_FIELD_IN_POU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_REF_NO);
	}

	private List<PVUEventSelectionGradeView> callSGPVUDDOListing(String sp, Map<String, Object> parameters)
			throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(sp, parameters);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEventSelectionGradeView.class)
				: Collections.emptyList();
	}

	/**
	 * Get pvu Office Name for SSP event.
	 *
	 * @param idDto the id dto
	 * @return the PVU office name
	 */
	@Override
	public EDPMsOfficeDto getPVUOfficeName(IdDto idDto) {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.EVENT_ID, idDto.getId());
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getSeletionGradeEmpOfficeId(),
				map);
		if (!Utils.isEmpty(objects)) {
			EDPMsOfficeDto officeDto = new EDPMsOfficeDto();
			officeDto.setOfficeName(String.valueOf(objects.get(0)[0]));
			return officeDto;
		}
		return null;
	}

	@Override
	public Boolean generateInwardNumber(List<IdDto> dtos) throws CustomException {
		try {
			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
			dtos.forEach(dto -> {
				Map<Integer, Object> map = new HashMap<>();
				map.put(1, Constant.SG_PVU);
				map.put(2, dto.getId());
				parameterMapList.add(map);
			});
			return repository.callStoreProcBatch("{CALL "
					+ Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INWARD_NO_GENERATION_PVU)) + "(?,?)}",
					parameterMapList);

		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public Boolean submitSelectionGradeInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	// Delete API
	@Override
	@Transactional
	public boolean deleteSgEvent(Long id) throws CustomException {
		Optional<PVUSelectionGradeEventEntity> sgEntity = repository.findById(id);
		if (sgEntity.isPresent()) {
			PVUSelectionGradeEventEntity entity = sgEntity.get();
			EDPLuLookUpInfoEntity saveAsDraft = lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
			if (entity.getStatusId().getLookUpInfoId() == saveAsDraft.getLookUpInfoId()) {
				repository.deleteSgEvent(Constant.IN_ACTIVE_STATUS, id, OAuthUtility.getCurrentUserUserId(),
						new Date());
				statusService.resetInProgressEmployeeEventStatus(entity.getEmpId().getEmpId(),
						OAuthUtility.getCurrentUserLkPOUId());
				return Boolean.TRUE;
			} else {
				throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * Submit SSP distributor.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean submitSelectionGradDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	private void insertInwardTable(PvuWFWrapperDto wrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, wrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_CREATED_BY, OAuthUtility.getCurrentUserUserId());
		map.put(Constant.IN_CREATED_BY_POST, wrapperDto.getAssignByPostId());
		map.put(Constant.IN_POU_ID, wrapperDto.getAssignByPOUId());
		map.put(Constant.IN_OFFICE_ID, wrapperDto.getAssignByOfficeId());
		map.put(Constant.IN_EVENT_CODE, PvuConstant.EVENT_CODE_SELECTION_GRAD);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_INWARD_INSERT));
		repository.callStoredProcedure(procName, map);

	}

	public void insertSelectionGradeRemarks(Long transId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.INSERT_ROP_REMARKS_ITRS); // Need
		repository.callStoredProcedure(procName.toString(), map);
	}

	// Auditor
	@Override
	public PagebleDTO<PVUSelectionGradeOfficeSearchView> pvuOfficeEmployeeSearch(PageDetails pageDetail)
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
				List<PVUSelectionGradeOfficeSearchView> list = NativeQueryResultsMapper.map(objStorePro,
						PVUSelectionGradeOfficeSearchView.class);
				list.forEach(e -> e.setEventCode(PvuConstant.EVENT_CODE_SELECTION_GRAD));
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), list);
			}
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, 0, Collections.emptyList());
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
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
	}

	@Override //
	public List<PVUMsReasonDto> getSelectionGradReasons() {
		return pvuMsReasonService.getRopReasons();
	}

	@Override
	public List<PVUEventRemarksDto> getReturnReasonByTransactionId(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.PVU_EVENT_ID, PvuConstant.SELECTION_GRADE_EVENT_ID);
		map.put(PvuConstant.GS_PVU_EVENT_ID, id);
		map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
		List<Object[]> objects = remarkRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getSgEventReturnRemarks(),
				map);
		return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PVUEventRemarksDto.class)
				: Collections.emptyList();
	}

	/**
	 * The e DP lu look up info repository.
	 */
	@Autowired
	private PVUEmployeEventsService eventsService;

	@Override
	public Map<String, Object> getPVUResponse(IdDto dto) throws CustomException {
		PVUSelectionGradeEventEntity pvuSelectionPay = getSelectionGradeEvent(dto.getId());

		if (pvuSelectionPay != null && pvuSelectionPay.getCurrentDetailsEventId() != null) {
			PVUSelectiongGradePostDetailDto postDetails = converter.toPVUObj(pvuSelectionPay);
			PVUCommonApiDto apiDto = eventsService
					.getCommonApiResponseForSelectionGrade(pvuSelectionPay.getCurrentDetailsEventId());
			Map<String, Object> response = new HashMap<>();
			response.put("currentDetails", apiDto);
			response.put("postDetails", postDetails);
			return response;
		}
		throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
	}

	/**
	 * Gets the remark byevent id.
	 *
	 * @param id the id
	 * @return the remark byevent id
	 * @throws CustomException the custom exception
	 */
	public List<PVUEventRemarksDto> getRemarkByeventId(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		try {
			map.put(PvuConstant.PVU_EVENT_ID, PvuConstant.SELECTION_GRADE_EVENT_ID);
			map.put(PvuConstant.GS_PVU_EVENT_ID, id);
			map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
			List<Object[]> objects = remarksRepository
					.executeSQLQuery(PVUNativeSqlQueryConstant.getReturnReasonRemarks(), map);
			return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PVUEventRemarksDto.class)
					: Collections.emptyList();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PVUSelectionGradeEventDto updateSGRemarks(PVUSelectionGradeEventDto dto) throws CustomException {
		PVUSelectionGradeEventEntity entity = converter.updateSGRemarks(getSelectionGradeEvent(dto.getId()), dto);
		PVUSelectionGradeEventEntity updateEntity = saveOrUpdate(entity);
		if (!Utils.isEmpty(dto.getReturnReasons())) {
			dto.getVerifierRemarks();
			String remarkType = getRemarkType(dto.getWfRoleId());
			boolean isReturnReason = false;
			if (((!Utils.isEmpty(dto.getAuditorReturnReason())) && dto.getAuditorReturnReason() == Constant.RETURN_VAL)
					|| ((!Utils.isEmpty(dto.getClassTwoReturnReason()))
							&& dto.getClassTwoReturnReason() == Constant.RETURN_VAL)
					|| ((!Utils.isEmpty(dto.getClassTwoReturnReason()))
							&& dto.getClassOneReturnReason() == Constant.RETURN_VAL)) {
				isReturnReason = dto.getAuditorReturnReason() == Constant.RETURN_VAL
						|| dto.getClassTwoReturnReason() == Constant.RETURN_VAL;
			}
			if (isReturnReason) {
				// Need to deactive old reason
				eventRemarksService.deactiveOldReason(PvuConstant.SELECTION_GRADE_EVENT_ID, dto.getId(),
						Constant.IN_ACTIVE_STATUS);
				// Need to insert new reason
				List<PVUEventRemarksEntity> lstEventRemarks = dto.getReturnReasons().stream().map(remarkDto -> {
					PVUEventRemarksEntity pvuEventRemarksEntity = new PVUEventRemarksEntity();
					pvuEventRemarksEntity.setEventID(PvuConstant.SELECTION_GRADE_EVENT_ID);
					pvuEventRemarksEntity.setTrnNo(dto.getId());
					pvuEventRemarksEntity.setWfRoleId(dto.getWfRoleId());
					pvuEventRemarksEntity.setEmpId(dto.getEmployeeId());
					pvuEventRemarksEntity.setRemarks(remarkDto.getRemarks());
					pvuEventRemarksEntity.setRemarksType(remarkType);
					pvuEventRemarksEntity.setReason(remarkDto.getReasonId());
					pvuEventRemarksEntity.setActiveStatus(Constant.ACTIVE_STATUS);
					pvuEventRemarksEntity.setEventID(PvuConstant.SELECTION_GRADE_EVENT_ID);

					return pvuEventRemarksEntity;
				}).collect(Collectors.toList());
				eventRemarksService.saveOrUpdateRemarksAll(lstEventRemarks);
			}
		}
		return converter.toDTO(updateEntity);
	}

	private String getRemarkType(Long wfRoleId) {
		if (Objects.equals(wfRoleId, Constant.APPROVER_CLASS_ONE))
			return Constant.APPROVER_CLASS_ONE_NAME;
		if (Objects.equals(wfRoleId, Constant.APPROVER_CLASS_TWO))
			return Constant.APPROVER_CLASS_TWO_NAME;
		if (Objects.equals(wfRoleId, Constant.VERIFIER))
			return Constant.VERIFIER_NAME;
		return Constant.AUDITOR_NAME;
	}

	@Override
	public String getWfCodeBySelectionGradeTrnId(Long trnId) {
		return this.wfRepository.findWfRlCdBySelectionGradeTrnId(trnId, Constant.ACTIVE_STATUS);
	}

	/**
	 * Gets the SP outward list.
	 *
	 * @param pageDetail the page detail
	 * @return the SP outward list
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUSelectionGradOutwardView> getSGOutwardList(PageDetails pageDetail) throws CustomException {

		try {
			Map<String, Object> map = buildPageInMaps(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_OUTWARD_LIST_WF).toString();
			List<PVUSelectionGradOutwardView> objStorePro = this.storeProcPvu(procName, map,
					PVUSelectionGradOutwardView.class);
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Builds the page in map.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	private Map<String, Object> buildPageInMaps(PageDetails pageDetail) {
		Map<String, String> collect = getOutwardPvuSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	/**
	 * Gets the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	public List<PVUSearchEnum> getOutwardPvuSearchFields() {

		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH,

				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,

				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE,

				PVUSearchEnum.PVU_SEARCH_FIELD_INW_NO,

				PVUSearchEnum.PVU_SEARCH_FIELD_OUTWARD_FROM_DATE,

				PVUSearchEnum.PVU_SEARCH_FIELD_OUTWARD_TO_DATE,

				PVUSearchEnum.PVU_SEARCH_FIELD_OUTWARD_NO,

				PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,

				PVUSearchEnum.PVU_SEARCH_FIELD_IN_STATUS,

				PVUSearchEnum.PVU_SEARCH_FIELD_IN_APPROVER_POU_ID,

				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,

				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,

				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,

				PVUSearchEnum.PVU_SEARCH_PAN,

				PVUSearchEnum.PVU_SEARCH_DISTRICT,

				PVUSearchEnum.PVU_SEARCH_CARDEX,

				PVUSearchEnum.PVU_SEARCH_DDO,

				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE,

				PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,

				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID,

				PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO,

				PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE,

				PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS,

				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.SEARCH_FIELD_IN_POU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_SEA_OFFICE_ID);
	}

	/**
	 * Generate outward number.
	 *
	 * @param dtos the dtos
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean generateOutwardNumber(List<IdDto> dtos) throws CustomException {
		try {
			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
			dtos.forEach(dto -> {
				Map<Integer, Object> map = new HashMap<>();
				map.put(1, Constant.SG);
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

	/**
	 * Submit SP outward.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean submitSGOutward(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException {
		try {
			wrapperDto.forEach(dto -> pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(),
					new Date(), PvuConstant.SELECTION_GRADE_EVENT_ID, dto.getTrnId(), Constant.OUTWARD_FLAG_ZERO,
					Constant.ACTIVE_STATUS));
			wrapperDto.forEach(e -> inwardService.setConsignmentNumber(e.getTrnId(),
					PvuConstant.SELECTION_GRADE_EVENT_ID, e.getPostConsignmentNumber()));

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

	public boolean processReturnOutWards(List<PvuWFOutWardWrapperDto> rWFlist) throws CustomException {
		if (rWFlist.isEmpty())
			return true;
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.MENU_ID, rWFlist.get(0).getMenuId());
		map.put(PvuConstant.EVENT_ID, PvuConstant.SELECTION_GRADE_EVENT_ID);
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

	private List<PvuWFWrapperDto> setDDOApprover(List<PvuWFOutWardWrapperDto> rWFlist, List<PVUWfTableInfo> tableList)
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
				dto.setWfStatus(PvuConstant.RETURNED);
				dto.setAssignToWfRoleId(3L);
				returnList.add(dto);
			}
		}
		return returnList;
	}

	public boolean processAuthorizedOutWards(List<PvuWFOutWardWrapperDto> authList) {
		if (authList.isEmpty())
			return true;
		authList.forEach(authDto -> {
			pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
					PvuConstant.SELECTION_GRADE_EVENT_ID, authDto.getTrnId(), Constant.OUTWARD_FLAG_ZERO,
					Constant.ACTIVE_STATUS);
			PVUSelectionGradeEventEntity entity = this.getSelectionGradeEvent(authDto.getTrnId());
			authorizeSG(authDto.getTrnId());
			updateEmpEventStatus(entity);
			insertSGAutoIncr(entity.getTrnNo());
		});
		authList.forEach(e -> e.setWfStatus(PvuConstant.AUTHORIZED));
		return pvuFacade.callWorkFlowApis(PvuWFOutWardWrapperDto.createSuper(authList));
	}

	@Override
	public PagebleDTO<PVUSGPrintEndorsementView> getPrintEndorsementsList(PageDetails pageDetail)
			throws CustomException {
		try {

			Map<String, Object> map = buildPageInMapPrint(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF).toString();
			List<PVUSGPrintEndorsementView> objStorePro = this.storeProcPvu(procName, map,
					PVUSGPrintEndorsementView.class);
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	private Map<String, Object> buildPageInMapPrint(PageDetails pageDetail) {
		Map<String, String> collect = getPrintSPSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	/**
	 * Gets the prints the SP search fields.
	 *
	 * @return the prints the SP search fields
	 */
	public List<PVUSearchEnum> getPrintSPSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO, PVUSearchEnum.PVU_SEARCH_FIELD_AUTHORIZATION_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_AUTHORIZATION_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_PAN,
				PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX, PVUSearchEnum.PVU_SEARCH_DDO,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE,
				PVUSearchEnum.PVU_IN_OFFICE_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID, PVUSearchEnum.PVU_SEARCH_PRINT_STATUS

		);
	}

	public void authorizeSG(Long trnId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnId);
		map.put(Constant.IN_EVENT_CODE, PvuConstant.EVENT_CODE_SELECTION_GRAD);
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.PVU_COMMON_AUTHORIZED_SP, map);
	}

	public void insertSGAutoIncr(String trnNo) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		map.put(Constant.IN_EVNT_CODE, PvuConstant.EVENT_CODE_SELECTION_GRAD);
		try {
			repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	private void updateEmpEventStatus(PVUSelectionGradeEventEntity entity) {
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntity;
		if (entity != null) {
			pvuEmployeeEventStatusEntity = statusService.findByEmpId(entity.getEmpId().getEmpId());
			if (pvuEmployeeEventStatusEntity.isPresent()) {
				pvuEmployeeEventStatusEntity.get().setSelectionGrade(0);
				pvuEmployeeEventStatusEntity.get().setTransId(null);
			}
			PVUEmployeeEventStatusEntity status = pvuEmployeeEventStatusEntity
					.orElse(new PVUEmployeeEventStatusEntity());
			statusService.saveOrUpdateEmployeeEventStatus(status);
		}
	}

	@Override
	public String generatePrintEndorsement(PvuPrintStickerReportDto dto) throws CustomException {

		/* show the World */
		String baos = generatePdf(Arrays.asList(dto));
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_PDF);
		header.set(HttpHeaders.CONTENT_DISPOSITION, PvuConstant.PRINT_ATTACHMENT + PvuConstant.SG_PDF_NAME);
		return baos;

	}

	public VelocityContext populateVContext(PVUStickerDTO stickerDTO, PVUSelectionGradeEventEntity entity) {
		PVUCommonApiDto apiDto = eventsService.getCommonApiResponseForSelectionGrade(entity.getCurrentDetailsEventId());
		PVUSelectiongGradePostDetailDto postDetails = converter.toPVUObj(entity);
		String authorize = !Utils.isEmpty(entity.getAuthorizeBy())
				? authService.getOnlyIdAndName(entity.getAuthorizeBy()).getName()
				: "";
		return converter.setPopulateVContext(stickerDTO, entity, apiDto, postDetails, authorize);
	}

	public Template getTemplateByCommId(PVUSelectionGradeEventEntity entity) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		/* next, get the Template */
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty(PvuConstant.CLASS_LOADER, ClasspathResourceLoader.class.getName());
		ve.init();
		Template template = new Template();

		if (!Utils.isEmpty(entity.getPayComm())) {
			if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
				template = ve.getTemplate(PvuConstant.SG_SEVEN_PRINT);
			} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
				template = ve.getTemplate(PvuConstant.SG_SIX_PRINT);
			} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
				template = ve.getTemplate(PvuConstant.SG_FIVE_PRINT);
			}
		}
		return template;
	}

	@Override
	public String generatePrintEndorsement(List<PvuPrintStickerReportDto> dtos) throws CustomException {
		String baos = generatePdf(dtos);
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_PDF);
		header.set(HttpHeaders.CONTENT_DISPOSITION, PvuConstant.PRINT_ATTACHMENT + PvuConstant.SG_PDF_NAME);
		return baos;
	}

	private StringWriter generateSGPdf(PvuPrintStickerReportDto dto, PVUSelectionGradeEventEntity entity)
			throws CustomException {

		PVUStickerDTO stickerDTO = null;
		try {
			stickerDTO = submitPrintHistory(dto);
			/* create a context and add data */

			VelocityContext context = populateVContext(stickerDTO, entity);
			StringWriter writer = new StringWriter();
			Template template = getTemplateByCommId(entity);
			template.merge(context, writer);
			return writer;
		} catch (CustomException e) {
			throw new CustomException(1008, "Error occured while reading content for file.");
		}
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
	 * @param dto        the dto
	 * @param pvuRopView the pvu rop view
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
					dto.getPrintEndorsementDto().setEventId(PvuConstant.SELECTION_GRADE_EVENT_ID);
				} else {
					/** For authorized case, and final reflection done by this */
					Boolean result = pvuFacade.callWorkFlowApis(dto.getPvuWFWrapperDto());
					if (result.equals(Boolean.TRUE)) {
						pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
								PvuConstant.SELECTION_GRADE_EVENT_ID, dto.getPvuWFWrapperDto().getTrnId(),
								Constant.OUTWARD_FLAG_ONE, Constant.ACTIVE_STATUS);
						dto.getPrintEndorsementDto().setPrintCnt((dto.getPrintEndorsementDto().getPrintCnt() + 1l));
						dto.getPrintEndorsementDto().setPrintDate(new Date());
						dto.getPrintEndorsementDto().setTrnId(dto.getPvuWFWrapperDto().getTrnId());
						dto.getPrintEndorsementDto().setEventId(PvuConstant.SELECTION_GRADE_EVENT_ID);
					}
				}
				printEntity = pvuPrintEndorsementRepository.save(converter.toEntityPrint(dto.getPrintEndorsementDto()));
				pvuPrintEndorsementItrRepository.save(converter.toEntityPrint(printEntity));
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return printEntity != null ? converter.toDTOPrint(printEntity) : null;
	}

	public String generatePdf(List<PvuPrintStickerReportDto> dto) throws CustomException {
		int count = 1;
		// create a new document
		Document document = new Document();
		StringBuilder sb = new StringBuilder();
		try {
			String watermark = null;
			Map<String, Object> map = new HashMap<>();
			document = new Document();
			StringWriter writer = new StringWriter();
			document.addAuthor(PvuConstant.GOG);
			document.addCreationDate();
			document.addProducer();
			document.addCreator(PvuConstant.GOG_FINACE);
			document.addTitle(PvuConstant.EVENT_CODE_SELECTION_NAME);
			document.setPageSize(PageSize.LETTER);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter pdfWriter = PdfWriter.getInstance(document, baos);
			// open document
			document.open();

			for (PvuPrintStickerReportDto printStickerReportDto : dto) {
				PVUSelectionGradeEventEntity entity = this
						.getSelectionGradeEvent(printStickerReportDto.getPvuWFWrapperDto().getTrnId());
				if (entity.getOfficeId().getOfficeId().equals(entity.getOfficeId().getPvuId())
						&& entity.getOfficeId().getOfficeId() != Constant.PVU_OFFICE_ID) {
					watermark = ", Self PVU";
				} else {
					watermark = ", PVU, Gandhinagar";
				}
				pdfWriter.setPageEvent(
						new WatermarkPageEvent(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()), watermark));
				writer.write(generateSGPdf(printStickerReportDto, entity).toString());
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
			logger.info("PDF generated successfully");

			document.close();
			
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			String fileName = String.valueOf(System.currentTimeMillis()).concat(".pdf");
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName); //
			header.setContentLength(baos.toByteArray().length);
			return sb.toString();// call this method for node js API for
			// html with watermark
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CustomException(1008, "Error occured while generate Pdf file");

		}

	}

	/**
	 * Gets the reprint endorsement remarks.
	 *
	 * @param id the id
	 * @return the reprint endorsement remarks
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<PrintEndorsementRemarkHistoryDto> getReprintEndorsementRemarks(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.TRN_ID, id);
		map.put(PvuConstant.EVENT_ID, PvuConstant.SELECTION_GRADE_EVENT_ID);
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getCommonEndorsementHistory(),
				map);
		return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PrintEndorsementRemarkHistoryDto.class)
				: Collections.emptyList();
	}

	/**
	 * Update for pulled back.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @param pvuEntity       the pvu entity
	 */
	private void updateForPulledBack(PvuWFWrapperDto pvuWFWrapperDto, PVUSelectionGradeEventEntity pvuEntity) {
		inwardService.updateStatusId(Constant.INACTIVE_STATUS, pvuEntity.getId(), new Date(),
				pvuWFWrapperDto.getEventId());
	}
}
