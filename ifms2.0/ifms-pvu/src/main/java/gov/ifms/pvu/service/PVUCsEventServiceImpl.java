package gov.ifms.pvu.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
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
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
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
import gov.ifms.pvu.converter.PVUCsEventConverter;
import gov.ifms.pvu.converter.PVUPrintEndorsementItrConverter;
import gov.ifms.pvu.dto.PVUCSPInwardView;
import gov.ifms.pvu.dto.PVUCSPOutwardView;
import gov.ifms.pvu.dto.PVUChangeOfScalePVUOfficeSearchDto;
import gov.ifms.pvu.dto.PVUCsEventDView;
import gov.ifms.pvu.dto.PVUCsEventDto;
import gov.ifms.pvu.dto.PVUCsPrintEndorsementView;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PVUSourceUserDetails;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.PVUWfTableInfo;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.dto.response.PVUDepartmentQueryDto;
import gov.ifms.pvu.dto.response.PVUEventChangeOfScaleDDOView;
import gov.ifms.pvu.entity.PVUCsEventEntity;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.repository.PVUCsEventRepository;
import gov.ifms.pvu.repository.PVUDepartmentCategoryRepository;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVUInwardRepository;
import gov.ifms.pvu.repository.PVUMsGradePayRepository;
import gov.ifms.pvu.repository.PVUMsPayBandRepository;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import gov.ifms.pvu.repository.PVUMsPayLevelRepository;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.repository.PVURevisionOfPayRemarkRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.util.WatermarkPageEvent;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;

/**
 * The Class PVUCsEventController.
 */
@Service
public class PVUCsEventServiceImpl implements PVUCsEventService {

	/**
	 * The logger.
	 */
	private Logger logger = LoggerFactory.getLogger(PVUCsEventServiceImpl.class.getName());

	/**
	 * The PVUCsEventAsMethodName repository.
	 */
	@Autowired
	private PVUCsEventRepository repository;

	@Autowired
	private PVUEmployeEventsService pvuEmployeEventsService;

	/**
	 * The PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository.
	 */
	@Autowired
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	@Autowired
	private PVUEmployeeEventStatusService statusService;
	/**
	 * The PVUPromotionRepository repository.
	 */
	@Autowired
	private PVUCommonService commonService;

	/**
	 * The PVUCsEventAsMethodName helper.
	 */
	@Autowired
	private PVUCsEventConverter converter;

	/**
	 * The e DP lu look up info repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/**
	 * The pvu facade.
	 */
	@Autowired
	private PVYFacade pvuFacade;

	/** The pvu ms reason service. */
	@Autowired
	private PVUMsReasonService pvuMsReasonService;

	/**
	 * The WfRepository wfRepository.
	 */
	@Autowired
	private WfRepository wfRepository;

	/** The remark repository. */
	@Autowired
	private PVURevisionOfPayRemarkRepository remarkRepository;

	/** The pvu event remarks service. */
	@Autowired
	private PVUEventRemarksService eventRemarksService;

	/** The pvu inward service. */
	@Autowired
	private PVUInwardRepository pvuInwardRepository;

	/** The pvu inward service. */
	@Autowired
	PVUPrintEndorsementRepository pvuPrintEndorsementRepository;

	@Autowired
	PVUPrintEndorsementItrRepository pvuPrintEndorsementItrRepository;

	@Autowired
	PVUPrintEndorsementItrConverter pvuPrintEndorsementItrConverter;

	@Autowired
	EncryptDecryptUtil securityUtil;
	/**
	 * The PVUSeniorScaleRepository repository.
	 */
	@Autowired
	private OAuthService authService;

	@Autowired
	private PVUInwardService inwardService;

	@Autowired
	private PVUEmployeEventsServiceImpl pvuEmployeEventsServiceImpl;

	/**
	 * The PVUMsPayCellRepository cellRepository.
	 */
	@Autowired
	private PVUMsPayCellRepository cellRepository;

	/**
	 * The PVUMsPayCellRepository cellRepository.
	 */
	@Autowired
	private PVUMsPayLevelRepository levelRepository;

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
	private PVUMsPayScaleRepository scaleRepository;

	/**
	 * The EDPMsDesignationRepository empRepo.
	 */
	@Autowired
	private EDPMsDesignationRepository designationRepository;

	/**
	 * The PVUEmployeRepository empRepo.
	 */
	@Autowired
	private PVUDepartmentCategoryRepository categoryRepository;

	/**
	 * The PVUEmployeRepository empRepo.
	 */
	@Autowired
	private PVUEmployeRepository empRepo;

	/**
	 * Retrieves an PVUCsEventEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUCsEventEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUCsEventDto getCsEvent(Long id) {
		PVUCsEventDto csEventDto = null;
		PVUCsEventEntity csEventEntity = repository.getOne(id);
		if (!Utils.isEmpty(csEventEntity)) {
			csEventDto = this.converter.toDTO(csEventEntity);
			if (csEventEntity.getEmployee() != null) {
				PVUEmployeDepartmentEntity department = this.pvuEmployeDepartmentRepository
						.findFirstByPvuEmployeEntityEmpId(csEventEntity.getEmployee().getEmpId());
				if (department != null) {
					csEventDto.setcDepartmentCategoryId(department.getDepartmentalCategory().getDeptCategoryId());
				}
				Optional<PVUEmployeDepartmentEntity> departmentEntity = pvuEmployeDepartmentRepository
						.findByPvuEmployeEntityEmpId(csEventEntity.getEmployee().getEmpId());
				if (departmentEntity.isPresent()) {
					csEventDto
							.setcDateOfJoining(PvuUtils.convertLocalDate(departmentEntity.get().getDateOfJoiningGOG()));
				}
			}
		}
		return csEventDto;
	}

	/**
	 * Saves a given PVUCsEventEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved PVUCsEventEntity
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUCsEventDto saveOrUpdateCsEvent(PVUCsEventDto dto) throws CustomException {
		if (dto.getNotionalFromDate() != null && dto.getNotionalToDate() != null && dto.getDuration() != null) {
			Date notionalFromDate = PvuUtils.convertLocalDateToDate(dto.getNotionalFromDate());
			Date notionalToDate = PvuUtils.convertLocalDateToDate(dto.getNotionalToDate());

			if (!PvuUtils.validateNotionalDates(notionalFromDate, notionalToDate)) {
				throw new CustomException(1, "Notional Dates cannot be Future Date...");
			}
			if (!PvuUtils.validateDuration(notionalFromDate, notionalToDate, dto.getDuration())) {
				throw new CustomException(2, "Notional Duration is incorrect...");
			}
		}
		PVUCsEventEntity entity = converter.toEntity(dto);
		if (dto.getStatusId() == 0) {
			statusService.inProgressSuspensionEvent(entity.getEmployee().getEmpId());
			entity.setStatusId(lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT));
		}
		entity = repository.save(entity);
		dto = this.converter.toDTO(entity);
		dto.setEmployeeNo(dto.getEmployeeNo());

		return dto;
	}

	@Override
	public PagebleDTO<PVUEventChangeOfScaleDDOView> getCommonDetailsCspvuddolist(PageDetails pageDetails)
			throws CustomException {
		Map<String, String> collect = this.getDdoWFListingSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(null, pageDetails, collect);
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_CSPVU_DDO_SP));
		List<PVUEventChangeOfScaleDDOView> list = this.callCSPVUDDOListing(sp, stringObjectMap);
		return new PagebleDTO<>(pageDetails.getPageElement(), 0, list.size(), list);
	}

	private List<PVUSearchEnum> getDdoWFListingSearchFields() {
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

	private List<PVUEventChangeOfScaleDDOView> callCSPVUDDOListing(String sp, Map<String, Object> parameters)
			throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(sp, parameters);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEventChangeOfScaleDDOView.class)
				: Collections.emptyList();
	}

	/**
	 * Fetch all the PVUCsEvent items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUCsEventDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUCsEventDto> getCsEvents(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUCsEventEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUCsEventEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUCsEventEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
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
			String procName = Constant.PVU_SCHEMA
					.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_SELECTION_GRADE_LOOKUP_SP));
			List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupCsSp(procName);
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
			return resultMap;
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Lookup cs sp.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private List<PVUEmployeCreationDDLView> lookupCsSp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, Collections.emptyMap());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	/**
	 * Insert cs itr.
	 *
	 * @param wrapperDto the pvu wrapper dto
	 * @return the PVU cs event dto
	 * @throws CustomException the custom exception
	 */
	@ExceptionHandler
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PVUCsEventDto insertCsItr(PvuWFWrapperDto wrapperDto) throws CustomException {
		PVUCsEventDto dto = null;
		PVUEmployeeEventStatusEntity statusEntry = null;
		PVUCsEventEntity entity = repository.getOne(wrapperDto.getTrnId());
		if (!Utils.isEmpty(entity)) {
			if (entity.getEventId() != null && entity.getTrnNo() == null
					&& entity.getStatusId().getLookUpInfoId() == PvuConstant.SAVE_AS_DRAFT_ID) {
				statusEntry = statusService.inProgressAnyEvent(entity.getEmployee().getEmpId());
				if (Objects.equals(entity.getEventId().getId(), PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID)) {
					entity.setTrnNo(this.commonService.getTransactionNumber(PvuConstant.TranNo.CSPVU.toString()));
					statusEntry.setChangeScale(Constant.ACTIVE_STATUS);
				} else if (Objects.equals(entity.getEventId().getId(), PvuConstant.CHANGE_OF_SCALE_EVENT_ID)) {
					entity.setTrnNo(this.commonService.getTransactionNumber(PvuConstant.TranNo.CS.toString()));
					statusEntry.setChangeScaleR13(Constant.ACTIVE_STATUS);
				}
				entity.setRefDate(LocalDateTime.now());
				entity = repository.save(entity);
				statusService.updateEventInfo(statusEntry, entity.getTrnNo());
			}
			converter.toDTO(entity);

			EDPLuLookUpInfoEntity empApprovStatsLookupInfo = lookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.APPROVED);

			if (Objects.nonNull(entity.getEventId())
					&& Objects.equals(entity.getEventId().getId(), PvuConstant.CHANGE_OF_SCALE_EVENT_ID)) {

				return createWorkFlow13(wrapperDto, entity, empApprovStatsLookupInfo);

			} else if (Objects.nonNull(entity.getEventId())
					&& Objects.equals(entity.getEventId().getId(), PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID)) {
				return createWorkFlowPVU(wrapperDto, entity, empApprovStatsLookupInfo);
			}
		}
		return dto;
	}

	public PVUCsEventDto createWorkFlow13(PvuWFWrapperDto wrapperDto, PVUCsEventEntity entity,
			EDPLuLookUpInfoEntity empApprovStatsLookupInfo) throws CustomException {
		Date approvedDate = new Date();
		PVUCsEventDto dto = null;
		if ((entity.getStatusId() != null)
				&& (entity.getStatusId().getLookUpInfoId() != empApprovStatsLookupInfo.getLookUpInfoId())) {
			Boolean isReturn = pvuFacade.callWorkFlowApis(wrapperDto);
			if (isReturn.equals(Boolean.TRUE)) {
				EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = lookUpInfoRepository
						.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
								Constant.ACTIVE_STATUS, Constant.SUBMIT);
				if (empSubmitStatusLookupInfo != null) {
					repository.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
							OAuthUtility.getCurrentUserUserId(), approvedDate);
				}
				dto = converter.toDTO(entity);
				if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
					entity.setStatusId(empApprovStatsLookupInfo);
					repository.updateStatusIdAndAuthDate(empApprovStatsLookupInfo.getLookUpInfoId(),
							wrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), approvedDate,
							LocalDateTime.now());
					toEntityOfEmpEvent(dto, entity.getEmployee().getEmpId(), wrapperDto.getWfStatus());
					updateEmpEventStatus(entity.getEmployee().getEmpId(), wrapperDto.getEventId());
					insertChangeOfScaleAutoIncr(entity.getTrnNo());
				} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
					EDPLuLookUpInfoEntity empRejectStatsLookupInfo = lookUpInfoRepository
							.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
									Constant.ACTIVE_STATUS, Constant.REJECTED);
					if (empRejectStatsLookupInfo != null) {
						repository.updateStatusId(empRejectStatsLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
								OAuthUtility.getCurrentUserUserId(), approvedDate);
					}
					updateEmpEventStatus(entity.getEmployee().getEmpId(), wrapperDto.getEventId());
				}
				insertCsInITRs(wrapperDto);
				return dto;
			}
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
		}
		return dto;
	}

	public PVUCsEventDto createWorkFlowPVU(PvuWFWrapperDto wrapperDto, PVUCsEventEntity entity,
			EDPLuLookUpInfoEntity empApprovStatsLookupInfo) throws CustomException {
		Boolean isReturn1 = pvuFacade.callWorkFlowApis(wrapperDto);
		if (isReturn1.equals(Boolean.TRUE)) {
			EDPLuLookUpInfoEntity saveAsDraft = lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
			if (entity.getStatusId().getLookUpInfoId() == saveAsDraft.getLookUpInfoId()) {
				/* trans Status is Save as Draft To submit */
				updateForSaveAsDraft(wrapperDto);
			} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
				EDPLuLookUpInfoEntity printEnable = lookUpInfoRepository
						.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.CONDITION_CHECK,
								Constant.ACTIVE_STATUS, Constant.LOOKUP_YES);
				entity.setStatusId(empApprovStatsLookupInfo);
				repository.updatePrintStatusAndApproveDate(empApprovStatsLookupInfo.getLookUpInfoId(),
						Constant.ACTIVE_STATUS, wrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), new Date(),
						printEnable.getLookUpInfoId(), LocalDateTime.now());
			} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.PULLED_BACK)) {
				updateForPulledBack(wrapperDto, entity);/* Inactive inward row */
			} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
				updateForRejectedStatus(wrapperDto, entity);
			} else if (wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)
					|| wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_I)) {

				String authorizerRemark;
				if (wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)) {
					authorizerRemark = entity.getClassTwoRemarks();
				} else {
					authorizerRemark = entity.getClassOneRemarks();
				}
				EDPLuLookUpInfoEntity authorizationStatus = lookUpInfoRepository
						.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.RECOMMENDATION_FOR,
								Constant.ACTIVE_STATUS, Constant.AUTHORIZE);

				repository.updateStatusIdAndAuthorizer(authorizationStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
						OAuthUtility.getCurrentUserUserId(), new Date(), LocalDateTime.now(),
						Long.parseLong(securityUtil.decrypt(wrapperDto.getAssignByUserId())), authorizerRemark);

				pvuInwardRepository.setAuthorizeDateAndFlag(wrapperDto.getTrnId(),
						PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID, OAuthUtility.getCurrentUserUserId(),
						LocalDateTime.now(), Constant.OUTWARD_FLAG_ZERO, Constant.ACTIVE_STATUS);
			}
			createWorkFlowAuthorizeAndReturn(wrapperDto);
			this.insertCsPVUInITRs(wrapperDto);
			return converter.toDTO(entity);
		} else {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
		}
	}

	public void createWorkFlowAuthorizeAndReturn(PvuWFWrapperDto wrapperDto) {

		if (wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_II)
				|| wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_I)) {

			EDPLuLookUpInfoEntity returnStatus = lookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.RECOMMENDATION_FOR,
							Constant.ACTIVE_STATUS, Constant.RETURN);

			repository.updateStatusId(returnStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), new Date());

			pvuInwardRepository.setReturnDateAndFlag(wrapperDto.getTrnId(), PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID,
					OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(), Constant.OUTWARD_FLAG_ONE,
					Constant.ACTIVE_STATUS);

		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.FORWARD_TO_PVU)) {
			this.insertInwardTable(wrapperDto);
		}
		if (wrapperDto.getAssignByWfRoleId() == Constant.AUDITOR
				|| Objects.equals(wrapperDto.getAssignByWfRoleId(), Constant.VERIFIER)
				|| wrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_TWO
				|| Objects.equals(wrapperDto.getAssignByWfRoleId(), Constant.APPROVER_CLASS_ONE)) {
			this.insertCSRemarksITR(wrapperDto);
		}
	}

	/**
	 * Insert change of scale remarks ITR.
	 *
	 * @param wrapperDto the trans id
	 */
	public void insertCSRemarksITR(PvuWFWrapperDto wrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map.put(Constant.IN_EVENT_CODE, PvuConstant.EVENT_CODE_CHANGE_OF_SCALE_PVU);
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.INSERT_PVU_EVNT_RMKS_ITR, map);
	}

	/**
	 * To entity of emp event.
	 *
	 * @param dto          the dto
	 * @param employee
	 * @param approvedDate the approved date
	 * @return the PVU employee events entity
	 * @throws CustomException
	 */
	public void toEntityOfEmpEvent(PVUCsEventDto dto, long employee, String wfStatus) throws CustomException {
		PVUEmployeEventsEntity employeeEventsEntity = new PVUEmployeEventsEntity();

		PVUEmployeDepartmentEntity department = this.pvuEmployeDepartmentRepository
				.findFirstByPvuEmployeEntityEmpId(dto.getEmployeeId());
		if (department != null) {
			employeeEventsEntity.setEmployeeClassId(department.getEmpClass().getLookUpInfoId());
			employeeEventsEntity.setDepartmentCategoryId(department.getDepartmentalCategory().getDeptCategoryId());
			employeeEventsEntity.setEmpDesignation(department.getDesignationId().getDesignationId());
			employeeEventsEntity.setEmployeeTypeId(department.getEmpType().getLookUpInfoId());
		}
		employeeEventsEntity.setTrnNo(dto.getTrnNo());
		employeeEventsEntity.setEmpBasicPay(dto.getBasicPay());
		employeeEventsEntity.setEventDate(LocalDateTime.of(dto.getEventEffectiveDate(), LocalTime.MIN));
		employeeEventsEntity.setEventDate(LocalDateTime.of(dto.getEventEffectiveDate(), LocalTime.MIN));
		employeeEventsEntity.setEmpNextIncrDate(LocalDateTime.of(dto.getDateOfNextIncrement(), LocalTime.MIN));
		employeeEventsEntity.setEmpOption(0L);
		employeeEventsEntity.setPayCommission(dto.getPayCommId());
		employeeEventsEntity.setOfficeId(dto.getOfficeId());

		if (dto.getPayCommId().toString().equals(PvuConstant.FIFTH_COMMISSION_ID.toString())) {
			employeeEventsEntity.setPayScale(dto.getPayScale());
		} else if (dto.getPayCommId().toString().equals(PvuConstant.SEVENTH_COMMISSION_ID.toString())) {
			employeeEventsEntity.setCellId(dto.getCellId());
			employeeEventsEntity.setEmpPaylevel(dto.getPayLevelId());
		} else if (dto.getPayCommId().toString().equals(PvuConstant.SIXTH_COMMISSION_ID.toString())) {
			employeeEventsEntity.setEmpPayBand(dto.getPayBandId());
			employeeEventsEntity.setEmpGrdPay(dto.getGradePayId());
			employeeEventsEntity.setPayBandValue(dto.getPayBandValue());
		}
		employeeEventsEntity.setPersonalPay(dto.getPersonalPay());
		employeeEventsEntity.setEventName(PvuConstant.EVENT_NAME_PVU_CHANGE_OF_SCALE);
		employeeEventsEntity.setEmpId(employee);
		employeeEventsEntity.setActiveStatus(dto.getActiveStatus());
		employeeEventsEntity.setEmpAutoApprove(LocalDateTime.now());
		if (dto.getEventId().toString().equals(PvuConstant.CHANGE_OF_SCALE_EVENT_ID.toString())) {
			employeeEventsEntity.setEventId(PvuConstant.CHANGE_OF_SCALE_EVENT_ID);
			employeeEventsEntity.setSourceId(PvuConstant.CHANGE_OF_SCALE_EVENT_ID);
		}
		setRevisionNo(employeeEventsEntity);
		employeeEventsEntity.setEventType(PvuConstant.MANUAL);
		pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeeEventsEntity);
		// Master Data Update for change of scale
		if (dto.getEventId().toString().equals(PvuConstant.CHANGE_OF_SCALE_EVENT_ID.toString())) {
			Map<String, Object> map = new LinkedHashMap<>();
			map.put(Constant.IN_TRN_NO, dto.getTrnNo());
			map.put(Constant.IN_STATUS_ID, wfStatus);
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_APPROVE_CHANGE_OF_SCALE));
			repository.callStoredProcedure(procName, map);
		}

	}

	/**
	 * Update emp event status.
	 *
	 * @param find the find
	 */
	public void updateEmpEventStatus(Long empId, Long eventId) {
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntity = statusService.findByEmpId(empId);
		if (pvuEmployeeEventStatusEntity.isPresent()) {
			if (eventId != null && eventId.toString().equals(PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID.toString())) {
				pvuEmployeeEventStatusEntity.get().setChangeScale(0);
			} else {
				pvuEmployeeEventStatusEntity.get().setChangeScaleR13(0);
			}
			pvuEmployeeEventStatusEntity.get().setTransId(null);
			statusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity.get());
		}

	}

	/**
	 * Insert cs in IT rs.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 */
	public void insertCsPVUInITRs(PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_ID, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_CSPVU_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * Insert cs in IT rs.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 */
	public void insertCsInITRs(PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_EVENT_NAME, PvuConstant.EVENT_NAME_CHANGE_OF_SCALE);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_COMMON_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * Insert inward table.
	 *
	 * @param wrapperDto the wrapper dto
	 */
	public void insertInwardTable(PvuWFWrapperDto wrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, wrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_CREATED_BY, OAuthUtility.getCurrentUserUserId());
		map.put(Constant.IN_CREATED_BY_POST, wrapperDto.getAssignByPostId());
		map.put(Constant.IN_POU_ID, wrapperDto.getAssignByPOUId());
		map.put(Constant.IN_OFFICE_ID, wrapperDto.getAssignByOfficeId());
		map.put(Constant.IN_EVENT_CODE, PvuConstant.EVENT_CODE_CHANGE_OF_SCALE_PVU);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_INWARD_INSERT));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * Gets the cs event by id.
	 *
	 * @param id the id
	 * @return the cs event by id
	 */
	public PVUCsEventDto getCsEventById(Long id) {
		return getCsEvent(id);
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
		map.put("eventId", idDto.getId());
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getCSPEmployeeOfficeId(), map);
		if (!Utils.isEmpty(objects)) {
			EDPMsOfficeDto officeDto = new EDPMsOfficeDto();
			officeDto.setOfficeName(String.valueOf(objects.get(0)[0]));
			return officeDto;
		}
		return null;
	}

	/**
	 * Generate inward number.
	 *
	 * @param dtos dtos
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean generateInwardNumber(List<IdDto> dtos) throws CustomException {
		try {
			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
			dtos.forEach(dto -> {
				Map<Integer, Object> map = new HashMap<>();
				map.put(1, Constant.CS_PVU);
				map.put(2, dto.getId());
				parameterMapList.add(map);
			});
			return repository.callStoreProcBatch("{CALL "
					+ Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INWARD_NO_GENERATION_PVU)) + "(?,?)}",
					parameterMapList);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public Boolean submitCSPInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Submit SSP distributor.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean submitCSPDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Fetch all the SSP Inward items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVURopInwardDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUCSPInwardView> getCSPInwardList(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMap(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_INWARD_LIST_WF).toString();
			List<PVUCSPInwardView> objStorePro = this.storeProcPvu(procName, map, PVUCSPInwardView.class);
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
	private Map<String, Object> buildPageInMap(PageDetails pageDetail) {
		Map<String, String> collect = getInwardPvuSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	/**
	 * Store proc pvu.
	 *
	 * @param <T>      type of Object
	 *
	 * @param procName the proc name
	 * @param map      the map
	 * @param view     type of Class
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public <T> List<T> storeProcPvu(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, view) : Collections.emptyList();

	}

	/**
	 * Gets the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	public List<PVUSearchEnum> getInwardPvuSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME, PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
				PVUSearchEnum.PVU_SEARCH_PAN, PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX,
				PVUSearchEnum.PVU_SEARCH_DDO, PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO, PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID,
				PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_INW_NO, PVUSearchEnum.SEARCH_FIELD_IN_POU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO);
	}

	/**
	 * Gets the wf rl cd by CSP trn id.
	 *
	 * @param trnId the trn id
	 * @return the wf rl cd by csp trn id
	 */
	@Override
	public String getWfRlCdByCSPTrnId(Long trnId) {
		return this.wfRepository.findWfRlCdByCSPTrnId(trnId, Constant.ACTIVE_STATUS);
	}

	// Delete API
	@Override
	@Transactional
	public boolean deleteCsEvent(Long id) throws CustomException {
		Optional<PVUCsEventEntity> csEntity = repository.findById(id);
		if (csEntity.isPresent()) {
			PVUCsEventEntity entity = csEntity.get();
			EDPLuLookUpInfoEntity saveAsDraft = lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
			if (entity.getStatusId().getLookUpInfoId() == saveAsDraft.getLookUpInfoId()) {
				repository.deleteCsEvent(Constant.IN_ACTIVE_STATUS, id, OAuthUtility.getCurrentUserUserId(),
						new Date());
				statusService.resetInProgressEmployeeEventStatus(entity.getEmployee().getEmpId(),
						OAuthUtility.getCurrentUserLkPOUId());
				return Boolean.TRUE;
			} else {
				throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * Gets the CSP search list.
	 *
	 * @param pageDetail the page detail
	 * @return the SSP search list
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUChangeOfScalePVUOfficeSearchDto> getPVUOfficeCSPEmployeeSearch(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, String> collect = this.getPvuOfficeCSPSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			StringBuilder procName = new StringBuilder();
			procName.append(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.COMMON_FIVE_EVENT_LIST_SEARCH_WF_PVU);
			List<PVUChangeOfScalePVUOfficeSearchDto> objStorePro = this.storeProcPvu(procName.toString(), map,
					PVUChangeOfScalePVUOfficeSearchDto.class);
			if (!Utils.isEmpty(objStorePro)) {
				objStorePro.forEach(e -> e.setEventCode(PvuConstant.EVENT_CODE_CHANGE_OF_SCALE_PVU));
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
			}
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, 0, Collections.emptyList());

		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the pvu office SSP search fields.
	 *
	 * @return the pvu office SSP search fields
	 */
	private List<PVUSearchEnum> getPvuOfficeCSPSearchFields() {
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

	@Override
	public List<PVUMsReasonDto> getPvuOfficeCSPReasonCode() {
		return pvuMsReasonService.getEventsReasons();
	}

	@Override
	public Map<String, Object> getPVUResponse(IdDto dto) throws CustomException {
		PVUCsEventEntity event = repository.getOne(dto.getId());
		if (event.getCurrentDetailsEventId() != null) {
			PVUCsEventDView csEventDView = converter.toPVUDTO(event);
			PVUCommonApiDto currentDetails = this.getCommonApiResponse(dto.getId());
			Map<String, Object> response = new HashMap<>();
			response.put("currentDetails", currentDetails);
			response.put("postDetails", csEventDView);
			return response;
		}
		throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
	}

	/**
	 * Gets the common api response for Cs .
	 *
	 * @param id the id
	 * @return the common api response for Cs
	 */
	private PVUCommonApiDto getCommonApiResponse(Long id) {
		PVUCsEventEntity event = repository.getOne(id);
		PVUEmployeEventsEntity eventsEntity = pvuEmployeEventsServiceImpl
				.getEmployeEvents(event.getCurrentDetailsEventId());
		PVUCommonApiDto response = new PVUCommonApiDto(eventsEntity);
		IdNameDto val;
		if (Objects.equals(event.getPayCommission().getLookUpInfoId(), PvuConstant.SEVENTH_COMMISSION_ID)) {
			response.setCellId(Long.valueOf(event.getcCell().getId()));
			val = this.cellRepository.getOnlyIdAndName(Long.valueOf(event.getcCell().getId()));
			response.setCellName(val.getName());
			response.setPayLevelId(event.getcPayLevel().getId());
			val = this.levelRepository.getOnlyIdAndName(event.getcPayLevel().getId());
			response.setPayLevelName(val.getName());
			response.setPayCommName(PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME);
		} else if (Objects.equals(event.getPayCommission().getLookUpInfoId(), PvuConstant.SIXTH_COMMISSION_ID)) {
			response.setPayCommName(PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME);
			response.setPayBandValue(event.getcPayBandValue());
			response.setGradePayId(event.getcGradePay().getId());
			val = this.gradePayRepository.getOnlyIdAndName(event.getcGradePay().getId());
			response.setGradePayName(val.getName());
			response.setPayBandId(event.getcPayBand().getId());
			val = this.bandRepository.getOnlyIdAndName(event.getcPayBand().getId());
			response.setPayBandName(val.getName());
		} else if (Objects.equals(event.getPayCommission().getLookUpInfoId(), PvuConstant.FIFTH_COMMISSION_ID)) {
			val = this.scaleRepository.getOnlyIdAndName(event.getcPayScale().getPayScaleId());
			response.setPayScale(event.getcPayScale().getPayScaleId());
			response.setPayScaleName(val.getName());
			response.setPayCommName(PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME);
		}
		if (event.getcDateOfNextIncrement() != null) {
			response.setDateNxtIncr(event.getcDateOfNextIncrement().toString());
		}
		if (event.getcClass() != null) {
			val = lookUpInfoRepository.getOnlyIdAndName(event.getcClass().getLookUpInfoId());
			response.setEmployeeClass(val.getName());
		}
		if (event.getcDesignation() != null) {
			val = designationRepository.getOnlyIdAndName(event.getcDesignation().getDesignationId());
			response.setDesignationName(val.getName());
		}
		if (event.getDepartmentCategoryId() != null) {
			val = categoryRepository.getOnlyIdAndName(event.getDepartmentCategoryId());
			response.setDepartmentCategoryName(val.getName());
		}
		if (response.getEmployeeId() != null) {
			PVUEmployeEntity one = this.empRepo.getOne(response.getEmployeeId());
			response.setEmployeeNo(one.getEmployeeCode().toString());
			setFullEmployeeName(one, response);
			response.setOfficeName(one.getOfficeId().getOfficeName()); // 25
		}
		PVUDepartmentQueryDto dojAndRetDate = pvuEmployeDepartmentRepository
				.getDateOfJoiningGOGAndDateOfRetirement(response.getEmployeeId());
		response.setDateJoining(dojAndRetDate.getDateOfJoiningGOG().toString());
		response.setRetirementDate(dojAndRetDate.getDateOfRetirement().toString());
		return response;
	}

	private void setFullEmployeeName(PVUEmployeEntity emp, PVUCommonApiDto response) {
		StringBuilder sb = new StringBuilder();
		if (emp.getSalutation() != null) {
			sb.append(getSalutationName(emp.getSalutation().getLookUpInfoId()));
			sb.append(" ");
		}
		sb.append(emp.getEmployeeName());
		if (!(emp.getEmployeeMiddleName() == null || emp.getEmployeeMiddleName().isEmpty())) {
			sb.append(" ");
			sb.append(emp.getEmployeeMiddleName());
		}
		if (!(emp.getEmployeeSurname() == null || emp.getEmployeeSurname().isEmpty())) {
			sb.append(" ");
			sb.append(emp.getEmployeeSurname());
		}
		response.setEmployeeName(sb.toString());
	}

	private String getSalutationName(Long lkInfoId) {
		EDPLuLookUpInfoEntity saluationLKEntity = lookUpInfoRepository.findBylookUpInfoId(lkInfoId);
		return saluationLKEntity != null ? saluationLKEntity.getLookUpInfoName() : "";
	}

	/**
	 * Gets the return reason by transaction id.
	 *
	 * @param id the id
	 * @return the return reason by transaction id
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<PVUEventRemarksDto> getReturnReasonByTransactionId(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.CS_PVU_EVENT_ID, id);
		map.put(PvuConstant.PVU_EVENT_ID, PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID);
		map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
		List<Object[]> objects = remarkRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getCsEventReturnRemarks(),
				map);
		return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PVUEventRemarksDto.class)
				: Collections.emptyList();
	}

	/**
	 * Update rop remarks.
	 *
	 * @param dto the dto
	 * @return the PVU revision of pay dto
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional
	public PVUCsEventDto updateCsRemarks(PVUCsEventDto dto) throws CustomException {
		PVUCsEventEntity csEventEntity = repository.getOne(dto.getId());
		PVUCsEventEntity entity = converter.updateCsRemarks(csEventEntity, dto);
		PVUCsEventEntity updateEntity = repository.save(entity);
		converter.toDTO(updateEntity);
		if (!Utils.isEmpty(dto.getReturnReasons())) {
			Long wfRoleId = dto.getWfRoleId();
			String remarkType = getRemarkType(dto.getWfRoleId());
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

			if (isReturnReason) {
				// Need to deactive old reason
				eventRemarksService.deactiveOldReason(PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID, dto.getId(),
						Constant.IN_ACTIVE_STATUS);

				// Need to insert new reason
				List<PVUEventRemarksEntity> lstEventRemarks = dto.getReturnReasons().stream().map(remarkDto -> {
					PVUEventRemarksEntity pvuEventRemarksEntity = new PVUEventRemarksEntity();
					pvuEventRemarksEntity.setTrnNo(updateEntity.getId());
					pvuEventRemarksEntity.setEventID(PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID);
					pvuEventRemarksEntity.setWfRoleId(wfRoleId);
					pvuEventRemarksEntity.setEmpId(updateEntity.getEmployee().getEmpId());
					pvuEventRemarksEntity.setRemarks(remarkDto.getRemarks());
					pvuEventRemarksEntity.setRemarksType(remarkType);
					pvuEventRemarksEntity.setReason(remarkDto.getReasonId());
					pvuEventRemarksEntity.setActiveStatus(Constant.ACTIVE_STATUS);
					return pvuEventRemarksEntity;
				}).collect(Collectors.toList());

				eventRemarksService.saveOrUpdateRemarksAll(lstEventRemarks);
			}
		}
		return converter.toDTO(updateEntity);
	}

	public String getRemarkType(Long wfRoleId) {
		if (Objects.equals(wfRoleId, Constant.APPROVER_CLASS_ONE))
			return Constant.APPROVER_CLASS_ONE_NAME;
		if (Objects.equals(wfRoleId, Constant.APPROVER_CLASS_TWO))
			return Constant.APPROVER_CLASS_TWO_NAME;
		if (Objects.equals(wfRoleId, Constant.VERIFIER))
			return Constant.VERIFIER_NAME;
		return Constant.AUDITOR_NAME;
	}

	/**
	 * Gets the CSP outward list.
	 *
	 * @param pageDetail the page detail
	 * @return the CSP outward list
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUCSPOutwardView> getCSPOutwardList(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMaps(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_OUTWARD_LIST_WF).toString();
			List<PVUCSPOutwardView> objStorePro = this.storeProcPvu(procName, map, PVUCSPOutwardView.class);
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
	 * Generate inward number.
	 *
	 * @param dtos dtos
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean generateOutwardNumber(List<IdDto> dtos) throws CustomException {
		try {
			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
			dtos.forEach(dto -> {
				Map<Integer, Object> map = new HashMap<>();
				map.put(1, Constant.CS_PVU);
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
	 * Submit CSP outward.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional
	public Boolean submitCSPOutward(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException {
		try {
			wrapperDto.forEach(dto -> pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(),
					new Date(), PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID, dto.getTrnId(), Constant.OUTWARD_FLAG_ZERO,
					Constant.ACTIVE_STATUS));

			wrapperDto.forEach(e -> inwardService.setConsignmentNumber(e.getTrnId(),
					PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID, e.getPostConsignmentNumber()));

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
		map.put(PvuConstant.EVENT_ID, PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID);
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
					PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID, authDto.getTrnId(), Constant.OUTWARD_FLAG_ZERO,
					Constant.ACTIVE_STATUS);
			PVUCsEventEntity entity = repository.getOne(authDto.getTrnId());
			authorizeCs(authDto.getTrnId());
			insertCsAutoIncr(entity.getTrnNo());
			updateEmpEventStatus(entity.getEmployee().getEmpId(), authDto.getEventId());
		});
		authList.forEach(e -> e.setWfStatus(PvuConstant.AUTHORIZED));
		return pvuFacade.callWorkFlowApis(PvuWFOutWardWrapperDto.createSuper(authList));
	}

	public void authorizeCs(Long trnId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnId);
		map.put(Constant.IN_EVENT_CODE, PvuConstant.EVENT_CODE_CHANGE_OF_SCALE_PVU);
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.PVU_COMMON_AUTHORIZED_SP, map);
	}

	public void insertCsAutoIncr(String trnNo) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		map.put(Constant.IN_EVNT_CODE, PvuConstant.EVENT_CODE_CHANGE_OF_SCALE_PVU);
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map);
	}

	/**
	 * Gets the CS print endorsements.
	 *
	 * @param pageDetail the page detail
	 * @return the CS print endorsements
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUCsPrintEndorsementView> getCSPrintEndorsements(PageDetails pageDetail) throws CustomException {
		try {

			Map<String, String> collect = this.getPrintPvuSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			StringBuilder procName = new StringBuilder();
			procName.append(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF);
			List<PVUCsPrintEndorsementView> objStorePro = this.storeProcPvu(procName.toString(), map,
					PVUCsPrintEndorsementView.class);
			if (!Utils.isEmpty(objStorePro)) {
				objStorePro.forEach(e -> e.setEventCode(PvuConstant.EVENT_CODE_CHANGE_OF_SCALE_PVU));
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
			}
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, 0, Collections.emptyList());
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public List<PVUSearchEnum> getPrintPvuSearchFields() {
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

	public Template getPrintTemplate(PVUCsEventEntity entity) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template t = new Template();
		if (!Utils.isEmpty(entity.getPayCommission())) {
			if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
				t = ve.getTemplate("templates/changeOfScale/ChangeofScale7th.vm");
			} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
				t = ve.getTemplate("templates/changeOfScale/ChangeofScale6th.vm");
			} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
				t = ve.getTemplate("templates/changeOfScale/ChangeofScale5th.vm");
			}
		}
		return t;
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
					dto.getPrintEndorsementDto().setEventId(PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID);
				} else {
					/** For authorized case, and final reflection done by this */
					Boolean result = pvuFacade.callWorkFlowApis(dto.getPvuWFWrapperDto());
					if (result.equals(Boolean.TRUE)) {
						pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
								PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID, dto.getPvuWFWrapperDto().getTrnId(),
								Constant.OUTWARD_FLAG_ONE, Constant.ACTIVE_STATUS);
						dto.getPrintEndorsementDto().setPrintCnt((dto.getPrintEndorsementDto().getPrintCnt() + 1l));
						dto.getPrintEndorsementDto().setPrintDate(new Date());
						dto.getPrintEndorsementDto().setTrnId(dto.getPvuWFWrapperDto().getTrnId());
						dto.getPrintEndorsementDto().setEventId(PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID);
					}
				}
				printEntity = pvuPrintEndorsementRepository.save(converter.toEntity(dto.getPrintEndorsementDto()));
				pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrConverter.toEntity(printEntity));
			}
		} catch (Exception e) {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
		}
		return printEntity != null ? converter.toDTO(printEntity) : null;
	}

	/**
	 * Generate print endorsement.
	 *
	 * @param dto the dto
	 * @return the string
	 * @throws CustomException the custom exception
	 */
	@Override
	public String generatePrintEndorsement(PvuPrintStickerReportDto dto) throws CustomException {
		try {
			List<PvuPrintStickerReportDto> list = new ArrayList<>();
			list.add(dto);
			return getFile(list);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);

		}
	}

	/**
	 * Generate print endorsement.
	 *
	 * @param dto the dto
	 * @return the string
	 * @throws CustomException the custom exception
	 */
	@Override
	public String generatePrintEndorsement(List<PvuPrintStickerReportDto> dto) throws CustomException {
		try {
			return getFile(dto);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private String getFile(List<PvuPrintStickerReportDto> dto) throws CustomException {
		return generatePdf(dto);
	}

	private StringWriter generateCSPayPdf(PvuPrintStickerReportDto dto, Long id) throws CustomException {
		PVUStickerDTO stickerDTO = null;
		try {
			stickerDTO = submitPrintHistory(dto);
			PVUCsEventEntity csEventEntity = repository.getOne(id);
			VelocityContext context = this.converter.populateVContext(stickerDTO, csEventEntity);
			if (!Utils.isEmpty(csEventEntity.getAuthorizeBy())) {
				String authorizerName = authService.getOnlyIdAndName(csEventEntity.getAuthorizeBy()).getName();
				context.put("authorizerName", authorizerName);
			}

			StringWriter writer = new StringWriter();
			Template template = getPrintTemplate(csEventEntity);
			template.merge(context, writer);
			return writer;
		} catch (CustomException ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	private String generatePdf(List<PvuPrintStickerReportDto> dto) throws CustomException {
		Document document = new Document();
		int count = 1;
		StringBuilder sb = new StringBuilder();
		try {
			String watermark = null;
			Map<String, Object> map = new HashMap<>();
			StringWriter writer = new StringWriter();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			document.addAuthor("GOG");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("GOG Finance");
			document.addTitle("Change of Scale");
			document.setPageSize(PageSize.LETTER);
			PdfWriter pdfWriter = PdfWriter.getInstance(document, baos);
			document.open();
			for (PvuPrintStickerReportDto printStickerReportDto : dto) {
				
				PVUCsEventEntity csEventEntity = repository
						.getOne(printStickerReportDto.getPvuWFWrapperDto().getTrnId());
				if (csEventEntity.getOfficeId().getOfficeId().equals(csEventEntity.getOfficeId().getPvuId())
						&& csEventEntity.getOfficeId().getOfficeId() != Constant.PVU_OFFICE_ID) {
					watermark = ", Self PVU";
				} else {
					watermark = ", PVU, Gandhinagar";
				}
				pdfWriter.setPageEvent(
						new WatermarkPageEvent(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()), watermark));
				writer.write(generateCSPayPdf(printStickerReportDto, csEventEntity.getId()).toString());
				if (count < dto.size()) {
					writer.append("<p style=\"page-break-after: always;\">&nbsp;</p>");
				}
				count++;
				map.put("content", writer.toString()); 
				sb.append(commonService.base64toPDFWithWaterMark(map, watermark));
				XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
				xmlWorkerHelper.getDefaultCssResolver(true);
				xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));
				document.newPage();
			}
			document.close();
			
			logger.info("PDF generated successfully");
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			String fileName = String.valueOf(System.currentTimeMillis()).concat(".pdf");
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
			return sb.toString();// call this method for node js API for html with watermark to Base64
								
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the prints the endorsement history.
	 *
	 * @param id the id
	 * @return the prints the endorsement history
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<PVUPrintEndorsementRemarkHistoryDto> getPrintEndorsementHistory(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put("trnId", id);
		map.put("eventId", PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID);
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getCommonEndorsementHistory(),
				map);
		return !Utils.isEmpty(objects)
				? NativeQueryResultsMapper.map(objects, PVUPrintEndorsementRemarkHistoryDto.class)
				: Collections.emptyList();
	}

	public void insertChangeOfScaleAutoIncr(String trnNo) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		map.put(Constant.IN_EVNT_CODE, PvuConstant.EVENT_CODE_CHANGE_OF_SCALE);
		try {
			repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Generate print endorsement.
	 *
	 * @param dto the dto
	 * @return the string
	 * @throws IOException       Signals that an I/O exception has occurred.
	 * @throws CustomException   the custom exception
	 * @throws DocumentException the document exception
	 */
	@Override
	public String generatePrintEndorsement(IdDto dto) throws IOException, CustomException, DocumentException {
		return generatePdf(dto);
	}

	public String generatePdf(IdDto dto) throws CustomException {
		String htmltoPdf = null;
		Map<String, Object> map = new HashMap<>();
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
			document.addTitle("Change of scale Event");
			document.setPageSize(PageSize.LETTER);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			// open document
			document.open();

			writer.write(generatePrint(dto).toString());

			map.put("content", writer.toString());
			htmltoPdf = commonService.htmlToPdfRequest(map);

			document.close();
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=" + PvuConstant.EVENT_CODE_CHANGE_OF_SCALE + ".pdf");
			header.setContentLength(baos.toByteArray().length);

			logger.info("PDF generated successfully");

			return htmltoPdf;

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public StringWriter generatePrint(IdDto dto) {
		StringWriter writer = new StringWriter();
		PVUCsEventEntity entity = repository.getOne(dto.getId());
		VelocityContext context = converter.populateVContext(entity);
		if (!Utils.isEmpty(Long.valueOf(entity.getUpdatedBy()))) {
			context.put("APPROVER_NAME",
					authService.getOnlyIdAndName(entity.getUpdatedBy()) != null
							? String.valueOf(authService.getOnlyIdAndName(entity.getUpdatedBy()).getName())
							: "");

		}
		Map<String, Object> map = new HashMap<>();
		map.put("userId", entity.getUpdatedBy());
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getUserDesgnationFromUserId(),
				map);
		if (!objects.isEmpty() && objects.get(0) != null) {
			context.put("APPROVER_DESIGNATION", String.valueOf(objects.get(0)[0]));
		}

		if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {

			Map<String, Object> curPaymap = new HashMap<>();
			curPaymap.put(PvuConstant.FIELD_PAY_LEVEL_ID, entity.getcPayLevel().getPayLevelValue());
			List<Object[]> curobj = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPayLevelRange(), curPaymap);
			context.put("CURRENT_PAY_RANGE", String.valueOf(curobj.get(0)[0]));

			Map<String, Object> chngePaymap = new HashMap<>();
			chngePaymap.put(PvuConstant.FIELD_PAY_LEVEL_ID, entity.getPayLevel().getPayLevelValue());
			List<Object[]> chngobj = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPayLevelRange(),
					chngePaymap);
			context.put("PAY_RANGE", String.valueOf(chngobj.get(0)[0]));

			Map<String, Object> curPayLevel = new HashMap<>();
			curPayLevel.put(PvuConstant.FIELD_PAY_LEVEL_ID, entity.getcPayLevel().getPayLevelValue());
			curPayLevel.put("cellId", entity.getcCell().getCellId());
			List<Object[]> curpayLvl = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPayInPayLevel(),
					curPayLevel);
			context.put("CURRENT_PAY_IN_LEVEL", String.valueOf(curpayLvl.get(0)[0]));

			Map<String, Object> chngePayLevel = new HashMap<>();
			chngePayLevel.put(PvuConstant.FIELD_PAY_LEVEL_ID, entity.getPayLevel().getPayLevelValue());
			chngePayLevel.put("cellId", entity.getCellId().getCellId());
			List<Object[]> chngPayLvl = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPayInPayLevel(),
					chngePayLevel);
			context.put("PAY_IN_LEVEL", String.valueOf(chngPayLvl.get(0)[0]));

		} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			boolean diff = PvuUtils.compareToLocalDate(entity.getEventEffectiveDate(),
					PvuUtils.getDateFromStringYMD(PvuConstant.EVENT_EFFICTED_DATE_5_PAY));
			if (diff) {
				context.put("CIVIL", PvuConstant.G_CIVIL);
				context.put("CIVIL_SUB", PvuConstant.G_CIVIL_SUB);
				context.put("PRA_CIVIL", PvuConstant.G_PRA_CIVIL);
			} else {
				context.put("CIVIL", PvuConstant.B_CIVIL);
				context.put("CIVIL_SUB", PvuConstant.B_CIVIL_SUB);
				context.put("PRA_CIVIL", PvuConstant.B_PRA_CIVIL);
			}
		}
		Template template = getPrintTemplateForPayFixation(entity);
		template.merge(context, writer);

		return writer;
	}

	public Template getPrintTemplateForPayFixation(PVUCsEventEntity entity) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template t = new Template();
		if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			t = ve.getTemplate("templates/changeOfScale/cos7.vm");
		} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			t = ve.getTemplate("templates/changeOfScale/cos6.vm");
		} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			t = ve.getTemplate("templates/changeOfScale/cos5.vm");
		}
		return t;
	}

	/**
	 * Update for pulled back.
	 *
	 * @param pvuWFWrapperDto  the pvu WF wrapper dto
	 * @param pvuCsEventEntity the pvu cs event entity
	 */
	private void updateForPulledBack(PvuWFWrapperDto pvuWFWrapperDto, PVUCsEventEntity pvuCsEventEntity) {
		inwardService.updateStatusId(Constant.INACTIVE_STATUS, pvuCsEventEntity.getId(), new Date(),
				pvuWFWrapperDto.getEventId());
	}

	/**
	 * Update for rejected status.
	 *
	 * @param wrapperDto       the wrapper dto
	 * @param pvuCsEventEntity the pvu cs event entity
	 */
	private void updateForRejectedStatus(PvuWFWrapperDto wrapperDto, PVUCsEventEntity pvuCsEventEntity) {
		EDPLuLookUpInfoEntity rejectedStatus = lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.REJECTED);
		repository.updateStatusId(rejectedStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date());

		statusService.resetInProgressEmployeeEventStatus(pvuCsEventEntity.getEmployee().getEmpId(),
				OAuthUtility.getCurrentUserLkPOUId());
	}

	/**
	 * Update for save as draft.
	 *
	 * @param wrapperDto the wrapper dto
	 */
	private void updateForSaveAsDraft(PvuWFWrapperDto wrapperDto) {
		EDPLuLookUpInfoEntity submitStatus = lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.SUBMIT);
		if (submitStatus != null) {
			repository.updateStatusId(submitStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), new Date());
		}
	}

	/**
	 * Sets the revision no.
	 *
	 * @param employeeEventsEntity the new revision no
	 * @throws CustomException the custom exception
	 */
	private void setRevisionNo(PVUEmployeEventsEntity employeeEventsEntity) throws CustomException {
		try {
			employeeEventsEntity.setRevisionNo(pvuEmployeEventsService
					.getLatestRevisionNo(employeeEventsEntity.getEmpId(), employeeEventsEntity.getPayCommission()));
		} catch (CustomException e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
}
