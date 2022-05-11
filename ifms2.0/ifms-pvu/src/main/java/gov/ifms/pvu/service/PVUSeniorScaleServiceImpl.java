package gov.ifms.pvu.service;

import static gov.ifms.pvu.util.PvuConstant.PVU_SS_PVU_EVENT_CODE;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
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
import gov.ifms.common.dao.GenericDao;
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
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.util.VelocityFormatUtils;
import gov.ifms.edp.util.WatermarkPageEvent;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUPrintEndorsementItrConverter;
import gov.ifms.pvu.converter.PVUSeniorScaleConverter;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUInwardView;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUOutwardView;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementView;
import gov.ifms.pvu.dto.PVUSSPRemarkRequest;
import gov.ifms.pvu.dto.PVUSeniorScaleDto;
import gov.ifms.pvu.dto.PVUSeniorScalePVUOfficeSearchDto;
import gov.ifms.pvu.dto.PVUSourceUserDetails;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.PVUWfTableInfo;
import gov.ifms.pvu.dto.PrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.dto.response.PVUEventSeniorScaleDDOView;
import gov.ifms.pvu.dto.response.PVUSSPPrintDto;
import gov.ifms.pvu.entity.PVUCsEventEntity;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUSeniorScaleEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.repository.PVUSeniorScaleRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;

/**
 * The Class PVUSeniorScaleServiceImpl.
 */
@Service
public class PVUSeniorScaleServiceImpl implements PVUSeniorScaleService {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PVUSeniorScaleServiceImpl.class.getName());

	/**
	 * The PVUSeniorScaleRepository repository.
	 */
	@Autowired
	private PVUSeniorScaleRepository repository;

	/**
	 * The PVUSeniorScaleRepository repository.
	 */
	@Autowired
	private OAuthService authService;

	/**
	 * The PVUSeniorScaleRepository repository.
	 */
	@Autowired
	private PVUInwardService inwardService;

	/**
	 * The PVUSeniorScaleRepository repository.
	 */
	@Autowired
	private PVUPrintEndorsementRepository printRepository;

	@Autowired
	private PVUPrintEndorsementItrRepository printITRRepo;

	/**
	 * The PVUEventsRemarkRepository remarkService.
	 */
	@Autowired
	private PVUEventRemarksService remarkService;

	/**
	 * The pvu ms reason service.
	 */
	@Autowired
	private PVUMsReasonService pvuMsReasonService;

	/**
	 * The WfRepository wfRepository.
	 */
	@Autowired
	private WfRepository wfRepository;

	/**
	 * The e DP lu look up info repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/**
	 * The e DP lu look up info repository.
	 */
	@Autowired
	EncryptDecryptUtil securityUtil;

	/**
	 * The PVYFacade facade.
	 */
	@Autowired
	private PVYFacade pvuFacade;

	/**
	 * The e DP lu look up info repository.
	 */
	@Autowired
	private PVUEmployeEventsService eventsService;

	/**
	 * The PVUEmployeeEventStatusService statusService.
	 */
	@Autowired
	private PVUEmployeeEventStatusService statusService;

	/**
	 * The PVUSeniorScaleConverter converter.
	 */
	@Autowired
	private PVUSeniorScaleConverter converter;

	@Autowired
	private PVUPrintEndorsementItrConverter printEndorsementItrConverter;

	/**
	 * The PVUCommonService PVUCommonService.
	 */
	@Autowired
	private PVUCommonService commonService;
	@Autowired
	private PVUEmployeDepartmentRepository depRepository;

	/**
	 * Retrieves an PVUSeniorScaleEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUSeniorScaleEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUSeniorScaleEntity getPVUSeniorScale(Long id) {
		return repository.getOne(id);
	}

	@Override
	public GenericDao getRepository() {
		return repository;
	}

	/**
	 * Saves a given PVUSeniorScaleEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved PVUSeniorScaleEntity
	 */
	@Override
	public PVUSeniorScaleDto saveOrUpdatePVUSeniorScale(PVUSeniorScaleDto dto) throws CustomException {
		PVUSeniorScaleEntity entity = converter.toEntity(dto);
		if (dto.getStatusId() == 0) {
			statusService.inProgressSuspensionEvent(entity.getEmployee().getEmpId());
			entity.setStatus(lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT));
		}
		entity = repository.save(entity);
		long empNo = dto.getEmployeeNo();
		dto = this.converter.toDTO(entity);
		dto.setEmployeeNo(empNo);
		return dto;
	}

	/**
	 * Fetch all the PVUSeniorScale items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUSeniorScaleDto>
	 */
	@Override
	public PagebleDTO<PVUSeniorScaleDto> getPVUSeniorScales(PageDetails pageDetail) {
		SearchCriteria searchCriteria = new SearchCriteria();
		SpecificationImpl<PVUSeniorScaleEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = pageDetail.getPageDetails(pageDetail);
		Specification<PVUSeniorScaleEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<PVUSeniorScaleEntity> page = repository.findAll(dataSpec, pageable);
		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				converter.toDTO(page.getContent()));
	}

	/**
	 * Insert submit senior scale itr .
	 *
	 * @param wrapperDto the wrapperDto
	 * @return PVUSeniorScaleDto
	 * @throws CustomException the custom exception
	 */
	@ExceptionHandler
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PVUSeniorScaleDto insertInITR(PvuWFWrapperDto wrapperDto) throws CustomException {
		Date approvedDate = new Date();
		Optional<PVUSeniorScaleEntity> find = repository.findById(wrapperDto.getTrnId());
		PVUSeniorScaleEntity entity;
		if (find.isPresent()) {
			entity = find.get();
			generateReferanceNumber(entity);
			if (Objects.nonNull(entity.getEvent())
					&& Objects.equals(entity.getEvent().getId(), PvuConstant.SENIOR_SCALE_PF_EVENT_ID)) {
				EDPLuLookUpInfoEntity empApprovStatsLookupInfo = lookUpInfoRepository
						.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
								Constant.ACTIVE_STATUS, Constant.APPROVED);
				if (entity.getStatus() != null
						&& entity.getStatus().getLookUpInfoId() != empApprovStatsLookupInfo.getLookUpInfoId()) {
					Boolean isReturn = pvuFacade.callWorkFlowApis(wrapperDto);
					if (isReturn.equals(Boolean.TRUE)) {
						return insertITRSeniorScale(wrapperDto, approvedDate, entity, empApprovStatsLookupInfo);
					}
					throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
				} else {
					throw new CustomException(HttpStatus.CONFLICT, MsgConstant.TRN_ALREADY_APPROVED);
				}
			} else if (Objects.equals(entity.getEvent().getId(), PvuConstant.SENIOR_SCALE_PVU_EVENT_ID)) {
				Long trnId = wrapperDto.getTrnId();
				pvuFacade.callWorkFlowApis(wrapperDto);
				EDPLuLookUpInfoEntity saveAsDraft = lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
				insertITRSeniorScalePVU(wrapperDto, entity, trnId, saveAsDraft);
				return converter.toDTO(entity);
			}
			throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
		} else {
			LOGGER.error(ErrorResponse.RECORD_NOT_FOUND.getMessage(), ErrorResponse.RECORD_NOT_FOUND);
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		}
	}

	private void insertITRSeniorScalePVU(PvuWFWrapperDto wrapperDto, PVUSeniorScaleEntity entity, Long trnId,
			EDPLuLookUpInfoEntity saveAsDraft) {
		if (entity.getStatus().getLookUpInfoId() == saveAsDraft.getLookUpInfoId()) {
			EDPLuLookUpInfoEntity submitStatus = lookUpInfoRepository.findBylookUpInfoId(267L);
			repository.updateStatusId(submitStatus.getLookUpInfoId(), trnId, OAuthUtility.getCurrentUserUserId(),
					new Date());
		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
			EDPLuLookUpInfoEntity printEnable = lookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.CONDITION_CHECK,
							Constant.ACTIVE_STATUS, Constant.LOOKUP_YES);
			EDPLuLookUpInfoEntity approve = lookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.APPROVED);
			repository.updatePrintStatusAndApproveDate(approve.getLookUpInfoId(), Constant.ACTIVE_STATUS, trnId,
					OAuthUtility.getCurrentUserUserId(), new Date(), printEnable.getLookUpInfoId(),
					LocalDateTime.now());
		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.PULLED_BACK)) {
			updateForPulledBack(wrapperDto, entity);/* Inactive inward row */
		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
			EDPLuLookUpInfoEntity rejectedStatus = lookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.REJECTED);
			repository.updateStatusId(rejectedStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), new Date());
			statusService.resetInProgressEmployeeEventStatus(entity.getEmployee().getEmpId(),
					OAuthUtility.getCurrentUserLkPOUId());
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
			inwardService.setAuthDate(wrapperDto.getTrnId(), PvuConstant.SENIOR_SCALE_PVU_EVENT_ID,
					LocalDateTime.now());
		} else if (wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_II)
				|| wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_I)) {
			EDPLuLookUpInfoEntity authorizationStatus = lookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.RECOMMENDATION_FOR,
							Constant.ACTIVE_STATUS, Constant.RETURN);
			repository.updateStatusId(authorizationStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), new Date());
			inwardService.setReturnDate(wrapperDto.getTrnId(), PvuConstant.SENIOR_SCALE_PVU_EVENT_ID,
					LocalDateTime.now());
		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.FORWARD_TO_PVU)) {
			this.insertInwardTable(wrapperDto);
		}
		if (wrapperDto.getAssignByWfRoleId() == Constant.AUDITOR
				|| wrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_TWO
				|| Objects.equals(wrapperDto.getAssignByWfRoleId(), Constant.APPROVER_CLASS_ONE)) {
			this.insertSSRemarksITR(wrapperDto);
		}
		this.insertSSPITR(wrapperDto);
	}

	private PVUSeniorScaleDto insertITRSeniorScale(PvuWFWrapperDto wrapperDto, Date approvedDate,
			PVUSeniorScaleEntity entity, EDPLuLookUpInfoEntity empApprovStatsLookupInfo) throws CustomException {
		PVUSeniorScaleDto dto;
		EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.SUBMIT);
		if (empSubmitStatusLookupInfo != null) {
			repository.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate);
		}
		dto = converter.toDTO(entity);
		if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
			entity.setStatus(empApprovStatsLookupInfo);
			repository.updateStatusIdAndAuthDate(empApprovStatsLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate, LocalDateTime.now());
			toEntityOfEmpEvent(dto, entity.getEmployee(), wrapperDto.getWfStatus());
			reset(entity.getEmployee().getEmpId());
			insertSeniorScalAutoIncr(entity.getTrnNo());
		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
			EDPLuLookUpInfoEntity empRejectStatsLookupInfo = lookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.REJECTED);
			repository.updateStatusId(empRejectStatsLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate);
			reset(entity.getEmployee().getEmpId());
		}
		insertITR(wrapperDto, dto.getEventCode());
		return dto;
	}

	private void generateReferanceNumber(PVUSeniorScaleEntity entity) throws CustomException {
		PVUEmployeeEventStatusEntity statusEntry;
		if (entity.getEvent() != null && entity.getTrnNo() == null) {
			statusEntry = statusService.inProgressAnyEvent(entity.getEmployee().getEmpId());
			if (Objects.equals(entity.getEvent().getId(), PvuConstant.SENIOR_SCALE_PF_EVENT_ID)) {
				entity.setTrnNo(this.commonService.getTransactionNumber("SS"));
				statusEntry.setSeniorScale(Constant.ACTIVE_STATUS);
			} else if (Objects.equals(entity.getEvent().getId(), PvuConstant.SENIOR_SCALE_PVU_EVENT_ID)) {
				entity.setTrnNo(this.commonService.getTransactionNumber("SSPVU"));
				statusEntry.setSeniorScalePvu(Constant.ACTIVE_STATUS);
			}
			entity.setRefDate(LocalDateTime.now());
			repository.save(entity);
			statusService.updateEventInfo(statusEntry, entity.getTrnNo());
		}
	}

	public void authorizeSPP(Long trnId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnId);
		map.put(Constant.IN_EVENT_CODE, PVU_SS_PVU_EVENT_CODE);
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.PVU_COMMON_AUTHORIZED_SP, map);
	}

	public void authorizeBackdateSP(Long trnId) {
		String trnNo = repository.getTrnNo(trnId);
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		map.put(Constant.IN_EVNT_CODE, PVU_SS_PVU_EVENT_CODE);
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map);
	}

	public void test(IdDto dto) {
		authorizeSPP(dto.getId());
		authorizeBackdateSP(dto.getId());
	}

	/**
	 * Insert SSP ITR.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 */
	@Override
	public void insertSSPITR(PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_ID, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_SS_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * To entity of emp event.
	 *
	 * @param dto      the dto
	 * @param employee as employee
	 */
	@Transactional
	public void toEntityOfEmpEvent(PVUSeniorScaleDto dto, PVUEmployeEntity employee, String wfStatus)
			throws CustomException {
		PVUEmployeEventsEntity employeeEventsEntity = new PVUEmployeEventsEntity();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, dto.getTrnNo());
		map.put(Constant.IN_STATUS_ID, wfStatus);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_APPROVE_SENIOR_SCALE));
		repository.callStoredProcedure(procName, map);
		PVUEmployeEventsEntity current = this.eventsService.getEmployeEvents(dto.getCurrentDetailsEventId());
		if (current != null) {
			employeeEventsEntity.setEmpDesignation(current.getEmpDesignation());
			employeeEventsEntity.setEmployeeClassId(current.getEmployeeClassId());
		}
		employeeEventsEntity.setEmpBasicPay(dto.getBasicPay());
		employeeEventsEntity.setEventDate(LocalDateTime.of(dto.getEventEffectiveDate(), LocalTime.MIN));
		employeeEventsEntity.setEmpOption(0L);
		employeeEventsEntity.setEmpNextIncrDate(LocalDateTime.of(dto.getDateOfNextIncrement(), LocalTime.MIN));
		employeeEventsEntity.setPayCommission(dto.getPayCommId());
		employeeEventsEntity.setOfficeId(dto.getOfficeId());
		employeeEventsEntity.setPersonalPay(dto.getPersonalPay());
		employeeEventsEntity.setDepartmentCategoryId(dto.getDepartmentCategoryId());
		employeeEventsEntity.setTrnNo(dto.getTrnNo());
		if (dto.getEventCode().equalsIgnoreCase(PvuConstant.PVU_SS_EVENT_CODE)) {
			employeeEventsEntity.setEventId(PvuConstant.SENIOR_SCALE_PF_EVENT_ID);
			employeeEventsEntity.setSourceId(PvuConstant.SENIOR_SCALE_PF_EVENT_ID);
		} else {
			employeeEventsEntity.setEventId(PvuConstant.SENIOR_SCALE_PVU_EVENT_ID);
			employeeEventsEntity.setSourceId(PvuConstant.SENIOR_SCALE_PVU_EVENT_ID);
		}
		if (dto.getPayCommId() == PvuConstant.FIFTH_COMMISSION_ID) {
			employeeEventsEntity.setPayScale(dto.getScaleId());
		}
		if (dto.getPayCommId() == PvuConstant.SIXTH_COMMISSION_ID) {
			employeeEventsEntity.setEmpPayBand(dto.getPayBandId());
			employeeEventsEntity.setEmpGrdPay(dto.getGradePayId());
			employeeEventsEntity.setPayBandValue(dto.getPayBandValue());
		}
		if (dto.getPayCommId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			employeeEventsEntity.setCellId(dto.getCellId());
			employeeEventsEntity.setEmpPaylevel(dto.getPayLevelId());
		}
		employeeEventsEntity.setEventName(PvuConstant.EVENT_NAME_SENIOR_SCALE);
		employeeEventsEntity.setEmpId(employee.getEmpId());
		employeeEventsEntity.setActiveStatus(dto.getActiveStatus());
		employeeEventsEntity.setEmpAutoApprove(LocalDateTime.now());
		setRevisionNo(employeeEventsEntity);
		eventsService.saveOrUpdateEmployeEvents(employeeEventsEntity);
	}

	/**
	 * Execute workflow api.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 */
	public void insertITR(final PvuWFWrapperDto pvuWFWrapperDto, String eventCode) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_EVENT_NAME, eventCode);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_COMMON_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * Insert senior remarks ITR.
	 *
	 * @param wrapperDto the trans id
	 */
	@Override
	public void insertSSRemarksITR(PvuWFWrapperDto wrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map.put(Constant.IN_EVENT_CODE, PvuConstant.PVU_SS_PVU_EVENT_CODE);
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.INSERT_PVU_EVNT_RMKS_ITR, map);
	}

	private void reset(Long empId) throws CustomException {
		PVUEmployeeEventStatusEntity employeeStatus = statusService.findOneByEmpId(empId);
		employeeStatus.setSeniorScale(0);
		employeeStatus.setSeniorScalePvu(0);
		employeeStatus.setTransId(null);
		statusService.saveOrUpdateEmployeeEventStatus(employeeStatus);
	}

	@Override
	public PagebleDTO<PVUEventSeniorScaleDDOView> ddoWFListing(PageDetails pageDetails) throws CustomException {
		Map<String, String> collect = this.getDdoWFListingSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(null, pageDetails, collect);
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.DDO_WF_LISTING_SP));
		List<PVUEventSeniorScaleDDOView> list = this.storeProcPvu(sp, stringObjectMap,
				PVUEventSeniorScaleDDOView.class);
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

	/**
	 * Gets the wf rl cd by SSP trn id.
	 *
	 * @param trnId the trn id
	 * @return the wf rl cd by SSP trn id
	 */
	@Override
	public String getWfRlCdBySSPTrnId(Long trnId) {
		return this.wfRepository.findWfRlCdBySSPTrnId(trnId, Constant.ACTIVE_STATUS);
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
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getSSPEmployeeOfficeId(), map);
		if (!Utils.isEmpty(objects)) {
			EDPMsOfficeDto officeDto = new EDPMsOfficeDto();
			officeDto.setOfficeName(String.valueOf(objects.get(0)[0]));
			return officeDto;
		}
		return null;
	}

	/**
	 * Gets the SSP search list.
	 *
	 * @param pageDetail the page detail
	 * @return the SSP search list
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUSeniorScalePVUOfficeSearchDto> getPVUOfficeSSPEmployeeSearch(PageDetails pageDetail)
			throws CustomException {
		Map<String, String> collect = this.getPvuOfficeSSPSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
		List<PVUSeniorScalePVUOfficeSearchDto> objStorePro = this.storeProcPvu(
				Constant.PVU_SCHEMA.concat(Constant.DOT).concat(PvuConstant.COMMON_FIVE_EVENT_LIST_SEARCH_WF_PVU), map,
				PVUSeniorScalePVUOfficeSearchDto.class);
		if (!CollectionUtils.isEmpty(objStorePro)) {
			objStorePro.forEach(e -> e.setEventCode(PVU_SS_PVU_EVENT_CODE));
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		}
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, 0, Collections.emptyList());
	}

	/**
	 * Gets the pvu office SSP search fields.
	 *
	 * @return the pvu office SSP search fields
	 */
	private List<PVUSearchEnum> getPvuOfficeSSPSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
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

	/**
	 * Insert inward table.
	 *
	 * @param wrapperDto the wrapper dto
	 */
	private void insertInwardTable(PvuWFWrapperDto wrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, wrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_CREATED_BY, OAuthUtility.getCurrentUserUserId());
		map.put(Constant.IN_CREATED_BY_POST, wrapperDto.getAssignByPostId());
		map.put(Constant.IN_POU_ID, wrapperDto.getAssignByPOUId());
		map.put(Constant.IN_OFFICE_ID, wrapperDto.getAssignByOfficeId());
		map.put(Constant.IN_EVENT_CODE, PvuConstant.PVU_SS_PVU_EVENT_CODE);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_INWARD_INSERT));
		repository.callStoredProcedure(procName, map);
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
		return this.generateNumber(dtos, PvuConstant.INWARD_NO_GENERATION_PVU);
	}

	/**
	 * Generate inward number.
	 *
	 * @param dtos dtos
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean generateOutWardNumber(List<IdDto> dtos) throws CustomException {
		return this.generateNumber(dtos, PvuConstant.OUTWARD_NO_GENERATION_PVU);
	}

	@Override
	public Boolean submitSSPInward(List<PvuWFWrapperDto> wrapperDto) {
		return pvuFacade.callWorkFlowApis(wrapperDto);
	}

	/**
	 * Submit SSP distributor.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 */
	@Override
	public Boolean submitSSPDistributor(List<PvuWFWrapperDto> wrapperDto) {
		return pvuFacade.callWorkFlowApis(wrapperDto);
	}

	/**
	 * Submit SSP distributor.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean submitSSPOutWard(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException {
		wrapperDto.forEach(e -> inwardService.setResetOutwardFlag(e.getTrnId(), PvuConstant.SENIOR_SCALE_PVU_EVENT_ID));
		wrapperDto.forEach(e -> inwardService.setConsignmentNumber(e.getTrnId(), PvuConstant.SENIOR_SCALE_PVU_EVENT_ID,
				e.getPostConsignmentNumber()));
		List<PvuWFOutWardWrapperDto> list = wrapperDto.stream()
				.filter(e -> Objects.nonNull(e.getStatus()) && e.getStatus().equalsIgnoreCase(Constant.RETURN))
				.collect(Collectors.toList());
		List<PvuWFOutWardWrapperDto> authList = wrapperDto.stream()
				.filter(e -> Objects.nonNull(e.getStatus()) && e.getStatus().equalsIgnoreCase(Constant.AUTHORIZE))
				.collect(Collectors.toList());
		PVUWfTableInfo tableInfo = null;
		if (!CollectionUtils.isEmpty(list)) {
			Map<String, Object> map = new HashMap<>();
			map.put(PvuConstant.MENU_ID, wrapperDto.get(0).getMenuId());
			map.put(PvuConstant.EVENT_ID, PvuConstant.SENIOR_SCALE_PVU_EVENT_ID);
			map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
			List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getWfTable(), map);
			List<PVUWfTableInfo> tableList = !Utils.isEmpty(objects)
					? NativeQueryResultsMapper.map(objects, PVUWfTableInfo.class)
					: Collections.emptyList();
			tableInfo = CollectionUtils.isEmpty(tableList) ? null : tableList.get(0);
		}
		List<PvuWFWrapperDto> returnList = new ArrayList<>();
		if (tableInfo != null) {
			setSourceUser(list, tableInfo, returnList);
			return pvuFacade.callWorkFlowApis(returnList);
		}
		if (!CollectionUtils.isEmpty(authList)) {
			wrapperDto.forEach(e -> authorizeSPP(e.getTrnId()));
			wrapperDto.forEach(e -> authorizeBackdateSP(e.getTrnId()));
			authList.forEach(e -> e.setWfStatus(PvuConstant.AUTHORIZED));
			pvuFacade.callWorkFlowApis(PvuWFOutWardWrapperDto.createSuper(authList));
			for (PvuWFOutWardWrapperDto e : authList) {
				reset(repository.getEmpId(e.getTrnId()));
			}
		}
		return true;
	}

	private void setSourceUser(List<PvuWFOutWardWrapperDto> list, PVUWfTableInfo tableInfo,
			List<PvuWFWrapperDto> returnList) throws CustomException {
		for (PvuWFOutWardWrapperDto dto : list) {
			Map<String, Object> map = new HashMap<>();
			map.put(PvuConstant.TRN_ID, dto.getTrnId());
			List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant
					.getWfSourceUserDetail(tableInfo.getSchemaName(), tableInfo.getTableName()), map);
			List<PVUSourceUserDetails> users = !Utils.isEmpty(objects)
					? NativeQueryResultsMapper.map(objects, PVUSourceUserDetails.class)
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
	}

	/**
	 * Fetch all the SSP Inward items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUInwardView>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUInwardView> getSSPInwardList(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = buildPageInMap(pageDetail);
		List<PVUInwardView> objStorePro = this.storeProcPvu(
				Constant.PVU_SCHEMA.concat(Constant.DOT).concat(PvuConstant.PVU_COMMON_INWARD_LIST_WF), map,
				PVUInwardView.class);
		int page = 0;
		if (!CollectionUtils.isEmpty(objStorePro)) {
			long recordCount = objStorePro.get(0).getRecordCount();
			if (recordCount > pageDetail.getPageElement()) {
				page = ((int) (recordCount / pageDetail.getPageElement()) + 1);
			}
		}
		return new PagebleDTO<>(pageDetail.getPageElement(), page, objStorePro.size(), objStorePro);
	}

	/**
	 * Fetch all the SSP Inward items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUOutwardView>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUOutwardView> getSSPOutWardList(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, this.getOutwardPvuSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue)));
		List<PVUOutwardView> objStorePro = this.storeProcPvu(
				Constant.PVU_SCHEMA.concat(Constant.DOT).concat(PvuConstant.PVU_COMMON_OUTWARD_LIST_WF), map,
				PVUOutwardView.class);
		int page = 0;
		if (!CollectionUtils.isEmpty(objStorePro)) {
			long recordCount = objStorePro.get(0).getRecordCount();
			if (recordCount > pageDetail.getPageElement()) {
				page = ((int) (recordCount / pageDetail.getPageElement()) + 1);
			}
		}
		return new PagebleDTO<>(pageDetail.getPageElement(), page, objStorePro.size(), objStorePro);
	}

	/**
	 * Gets the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	@Override
	public List<PVUSearchEnum> getInwardPvuSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_PAN,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS, PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID,
				PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE, PVUSearchEnum.SEARCH_FIELD_IN_POU_ID,
				PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS, PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX, PVUSearchEnum.PVU_SEARCH_DDO,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INW_NO);
	}

	/**
	 * Gets outward the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	@Override
	public List<PVUSearchEnum> getPrintPrintEndorsementSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_PAN, PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH,
				PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO, PVUSearchEnum.PVU_SEARCH_FIELD_AUTHORIZATION_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_AUTHORIZATION_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX, PVUSearchEnum.PVU_SEARCH_DDO,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_PVU_OFFICE, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID, PVUSearchEnum.PVU_SEARCH_PRINT_STATUS);
	}

	/**
	 * Gets outward the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	@Override
	public List<PVUSearchEnum> getOutwardPvuSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_IN_STATUS, PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_OUTWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_OUTWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INW_NO, PVUSearchEnum.PVU_SEARCH_FIELD_OUTWARD_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_IN_APPROVER_POU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME, PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
				PVUSearchEnum.PVU_SEARCH_PAN, PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX,
				PVUSearchEnum.PVU_SEARCH_DDO, PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO, PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE, PVUSearchEnum.SEARCH_FIELD_IN_POU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_SEA_OFFICE_ID);
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

	@Override
	public List<PVUMsReasonDto> getPvuOfficeSSPReasonCode() {
		return pvuMsReasonService.getEventsReasons();
	}

	@Override
	public Map<String, Object> getPVUResponse(IdDto dto) throws CustomException {
		PVUSeniorScaleEntity pvuSeniorScale = getPVUSeniorScale(dto.getId());
		if (pvuSeniorScale != null && pvuSeniorScale.getCurrentDetailsEventId() != null) {
			Map<String, String> event = converter.getEventDetails(converter.toDTO(pvuSeniorScale));
			PVUCommonApiDto currentDetails = this.eventsService
					.getCommonApiResponse(pvuSeniorScale.getCurrentDetailsEventId());
			Map<String, Object> response = new HashMap<>();
			response.put(PvuConstant.CURRENT_DETAILS, currentDetails);
			response.put(PvuConstant.POST_DETAILS, event);
			return response;
		}
		throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
	}

	@Override
	public PVUSeniorScaleDto saveOrUpdateRemarks(PVUSSPRemarkRequest dto) {
		PVUSeniorScaleEntity entity = converter.setRemarks(getPVUSeniorScale(dto.getId()), dto);
		entity = repository.save(entity);
		if (!CollectionUtils.isEmpty(dto.getReturnReasons())) {
			Long wfRoleId = dto.getWfRoleId();

			String remarkType = PvuUtils.buildRemarkType(wfRoleId);
			boolean isReturnReason = false;
			if (((Utils.isNonEmpty(dto.getAuditorReturnReason()))
					&& dto.getAuditorReturnReason() == Constant.RETURN_VAL)
					|| ((Utils.isNonEmpty(dto.getClassTwoReturnReason()))
							&& dto.getClassTwoReturnReason() == Constant.RETURN_VAL)
					|| ((Utils.isNonEmpty(dto.getClassOneReturnReason()))
							&& dto.getClassOneReturnReason() == Constant.RETURN_VAL)
					|| ((Utils.isNonEmpty(dto.getVerifierReturnReason()))
							&& dto.getVerifierReturnReason() == Constant.RETURN_VAL)) {
				isReturnReason = dto.getAuditorReturnReason() == Constant.RETURN_VAL
						|| dto.getVerifierReturnReason() == Constant.RETURN_VAL
						|| dto.getClassOneReturnReason() == Constant.RETURN_VAL
						|| dto.getClassTwoReturnReason() == Constant.RETURN_VAL;
			}

			if (isReturnReason) {
				remarkService.deActivateOldReason(dto.getId(), PvuConstant.SENIOR_SCALE_PVU_EVENT_ID);
				List<PVUEventRemarksEntity> remarks = dto.getReturnReasons().stream().map(remarkDto -> {
					PVUEventRemarksEntity remark = new PVUEventRemarksEntity();
					remark.setEventID(PvuConstant.SENIOR_SCALE_PVU_EVENT_ID);
					remark.setTrnNo(dto.getId());
					remark.setWfRoleId(wfRoleId);
					remark.setEmpId(dto.getEmpId());
					remark.setRemarks(remarkDto.getRemarks());
					remark.setRemarksType(remarkType);
					remark.setReason(remarkDto.getReasonId());
					remark.setActiveStatus(Constant.ACTIVE_STATUS);
					return remark;
				}).collect(Collectors.toList());
				remarkService.saveAll(remarks);
			}
		}
		return converter.toDTO(entity);
	}

	@Override
	public List<PVUEventRemarksDto> getReturnRemarks(Long id) throws CustomException {
		return remarkService.getReturnRemarks(id, PvuConstant.SENIOR_SCALE_PVU_EVENT_ID);
	}

	/**
	 * Fetch all the SSP Print Endorsement List.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUInwardView>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUPrintEndorsementView> getSSPPrintEndorsementList(PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail,
				this.getPrintPrintEndorsementSearchFields().stream()
						.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue)));
		List<PVUPrintEndorsementView> objStorePro = this.storeProcPvu(
				Constant.PVU_SCHEMA.concat(Constant.DOT).concat(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF),
				map, PVUPrintEndorsementView.class);
		objStorePro.forEach(e -> e.setEventCode(PVU_SS_PVU_EVENT_CODE));
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
	}

	@Override
	public String generatePrintOrder(PvuPrintStickerReportDto dto)
			throws CustomException, IOException, DocumentException {
		try {
			List<PvuPrintStickerReportDto> list = new ArrayList<>();
			list.add(dto);
			return getFile(list);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);

		}
	}
	
	private String getFile(List<PvuPrintStickerReportDto> dto) throws CustomException {
		return generatePdf(dto);
	}
	
	@Override
	public String generatePrintOrders(List<PvuPrintStickerReportDto> dto) throws CustomException {
		try {
			return getFile(dto);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	private StringWriter generateSSPayPdf(PvuPrintStickerReportDto dto) throws CustomException {
		PVUStickerDTO stickerDTO = null;
		try {
			stickerDTO = submitPrintHistory(dto);
			PVUSeniorScaleEntity entity = repository.getOne(dto.getStickerDTO().getId());
			PVUCommonApiDto common = this.eventsService.getCommonApiResponse(entity.getCurrentDetailsEventId());
			PVUSSPPrintDto printDto = printRepository.getPrintDateReprintDatePrintCount(entity.getId(),
					PvuConstant.SENIOR_SCALE_PVU_EVENT_ID, Constant.ACTIVE_STATUS);
			printDto = converter.print(entity, printDto, common);
			printDto.setDesignation(common.getDesignationName());
			if (!Utils.isEmpty(entity.getAuthorizeBy())) {
				printDto.setAuthorizedBy(authService.getOnlyIdAndName(entity.getAuthorizeBy()).getName());
			} else {
				printDto.setAuthorizedBy("");
			}
			if (!Utils.isEmpty(stickerDTO.getRePrintRemark())) {
				printDto.setRePrintRemark(stickerDTO.getRePrintRemark());
			} else {
				printDto.setRePrintRemark("");
			}
			VelocityContext context = new VelocityContext();
			context.put("data", printDto);
			StringWriter writer = new StringWriter();
			Template template = getPrintTemplateforPVU(entity);
			template.merge(context, writer);
			return writer;
		} catch (CustomException ex) {
			LOGGER.error(ex.getMessage(), ex);
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
			document.addTitle("Senior Scale");
			document.setPageSize(PageSize.LETTER);
			PdfWriter pdfWriter = PdfWriter.getInstance(document, baos);
			document.open();
			for (PvuPrintStickerReportDto printStickerReportDto : dto) {
				PVUSeniorScaleEntity entity = repository
						.getOne(printStickerReportDto.getPvuWFWrapperDto().getTrnId());
				if (entity.getOffice().getOfficeId().equals(entity.getOffice().getPvuId())
						&& entity.getOffice().getOfficeId() != Constant.PVU_OFFICE_ID) {
					watermark = ", Self PVU";
				} else {
					watermark = ", PVU, Gandhinagar";
				}
				pdfWriter.setPageEvent(
						new WatermarkPageEvent(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()), watermark));
				writer.write(generateSSPayPdf(printStickerReportDto).toString());
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
			
			LOGGER.info("PDF generated successfully");
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			String fileName = String.valueOf(System.currentTimeMillis()).concat(".pdf");
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
			return sb.toString();// call this method for node js API for
			// html with watermark
			
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	public Template getPrintTemplateforPVU(PVUSeniorScaleEntity entity) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template t = new Template();
		if (!Utils.isEmpty(entity.getPayComm())) {
			if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
				t = ve.getTemplate("/templates/view/ssp_seven.vm");
			} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
				t = ve.getTemplate("/templates/view/ssp_six.vm");
			} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
				t = ve.getTemplate("/templates/view/ssp_five.vm");
			}
		}
		return t;
	}
	
	public PVUStickerDTO submitPrintHistory(PvuPrintStickerReportDto dto) throws CustomException {
		PVUStickerDTO stickerDTO = dto.getStickerDTO();
		PVUPrintEndorsementDto printEndorsementDto = submitPrintWF(dto);
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

	private PVUPrintEndorsementDto submitPrintWF(PvuPrintStickerReportDto dto) throws CustomException {
		PVUPrintEndorsementEntity printEntity = null;
		try {
			PVUPrintEndorsementDto printDto = dto.getPrintEndorsementDto();
			if (printDto != null) {
				printEntity = printRepository.findOneByTrnIdAndEventIdAndActiveStatus(printDto.getTrnId(),
						PvuConstant.SENIOR_SCALE_PVU_EVENT_ID, Constant.ACTIVE_STATUS);
				if (printEntity == null) {
					inwardService.setOutwardFlag(dto.getPvuWFWrapperDto().getTrnId(),
							PvuConstant.SENIOR_SCALE_PVU_EVENT_ID);
					printEntity = new PVUPrintEndorsementEntity();
					printEntity.setTrnId(printDto.getTrnId());
					printEntity.setEventId(PvuConstant.SENIOR_SCALE_PVU_EVENT_ID);
					printEntity.setPrintDate(new Date());
					printEntity.setPrintCnt(1L);
					pvuFacade.callWorkFlowApis(dto.getPvuWFWrapperDto());
				} else {
					printEntity.setPrintCnt((printEntity.getPrintCnt() + 1L));
					printEntity.setReprintDate(new Date());
					printEntity.setEventId(PvuConstant.SENIOR_SCALE_PVU_EVENT_ID);
					printEntity.setRemark(printDto.getRemark());
				}
				printEntity = printRepository.save(printEntity);
				printITRRepo.save(printEndorsementItrConverter.toEntity(printEntity));
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return printEntity != null ? converter.toPrintEndorsementDto(printEntity) : null;
	}

	@Override
	public List<PrintEndorsementRemarkHistoryDto> getReprintEndorsementRemarks(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.TRN_ID, id);
		map.put(PvuConstant.EVENT_ID, PvuConstant.SENIOR_SCALE_PVU_EVENT_ID);
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPVUEventEndorsementHistory(),
				map);
		return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PrintEndorsementRemarkHistoryDto.class)
				: Collections.emptyList();
	}

	@Override
	public void deleteById(IdDto dto) throws CustomException {
		if (dto.getId() != null) {
			PVUSeniorScaleEntity entity = this.repository.getOne(dto.getId());
			if (entity.getEmployee() != null && entity.getEmployee().getEmpId() != 0) {
				reset(entity.getEmployee().getEmpId());
			}
			repository.deleteById(Constant.IN_ACTIVE_STATUS, dto.getId(), OAuthUtility.getCurrentUserUserId(),
					new Date());
		}
	}

	public void insertSeniorScalAutoIncr(String trnNo) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		map.put(Constant.IN_EVNT_CODE, PvuConstant.PVU_SS_EVENT_CODE);
		try {
			repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
		}
	}

	// For 8 No. screen
	@Override
	public String generatePrintEndorsement(IdDto dto) throws IOException, CustomException, DocumentException {
		return generatePdf(dto);
	}

	public String generatePdf(IdDto dto) throws CustomException {

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
			document.addTitle("Senior Scale Event");
			document.setPageSize(PageSize.LETTER);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			pdfWriter = PdfWriter.getInstance(document, baos);

			// open document
			document.open();
			writer.write(generatePrint(dto).toString());
			
			map.put("content", writer.toString());
			htmltoPdf = commonService.htmlToPdfRequest(map); // call this method for node js API for html to Base64
			
			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));

			// close the document
			document.close();
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=" + PvuConstant.PVU_SS_EVENT_CODE + ".pdf");
			header.setContentLength(baos.toByteArray().length);

			LOGGER.info("PDF generated successfully");

			return htmltoPdf;

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public StringWriter generatePrint(IdDto dto) {
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();

		PVUSeniorScaleEntity entity = this.getPVUSeniorScale(dto.getId());
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
		
		PVUEmployeDepartmentEntity dep = depRepository
				.findFirstByPvuEmployeEntityEmpId(entity.getEmployee().getEmpId());
		context.put("DESIGNATION", dep.getDesignationId().getDesignationName());
		List<Object[]> curpayLvl = null;
		List<Object[]> chngPayLvl = null;
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {

			if (!Utils.isEmpty(entity.getcPayLevel())) {
				Map<String, Object> curPaymap = new HashMap<>();
				curPaymap.put(PvuConstant.FIELD_PAY_LEVEL_ID, entity.getcPayLevel().getPayLevelValue());
				List<Object[]> curobj = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPayLevelRange(),
						curPaymap);
				context.put("CURRENT_PAY_RANGE", String.valueOf(curobj.get(0)[0]));
			} else {
				context.put("CURRENT_PAY_RANGE", "");
			}

			if (!Utils.isEmpty(entity.getPayLevel())) {
				Map<String, Object> chngePaymap = new HashMap<>();
				chngePaymap.put(PvuConstant.FIELD_PAY_LEVEL_ID, entity.getPayLevel().getPayLevelValue());
				List<Object[]> chngobj = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPayLevelRange(),
						chngePaymap);
				context.put("PAY_RANGE", String.valueOf(chngobj.get(0)[0]));
			} else {
				context.put("PAY_RANGE", "");
			}

			if (!Utils.isEmpty(entity.getcPayLevel())) {
				Map<String, Object> curPayLevel = new HashMap<>();
				curPayLevel.put(PvuConstant.FIELD_PAY_LEVEL_ID, entity.getcPayLevel().getPayLevelValue());
				curPayLevel.put("cellId", entity.getcCell().getCellId());
				curpayLvl = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPayInPayLevel(), curPayLevel);
				context.put("CURRENT_PAY_IN_LEVEL", String.valueOf(curpayLvl.get(0)[0]));
			} else {
				context.put("CURRENT_PAY_IN_LEVEL", "");
			}

			if (!Utils.isEmpty(entity.getPayLevel())) {
				Map<String, Object> chngePayLevel = new HashMap<>();
				chngePayLevel.put(PvuConstant.FIELD_PAY_LEVEL_ID, entity.getPayLevel().getPayLevelValue());
				chngePayLevel.put("cellId", entity.getCell().getCellId());
				chngPayLvl = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPayInPayLevel(), chngePayLevel);
				context.put("PAY_IN_LEVEL", String.valueOf(chngPayLvl.get(0)[0]));
			} else {
				context.put("PAY_IN_LEVEL", "");
			}
			context.put("INCREASE_IN_PAY", increateInPay(curpayLvl, chngPayLvl));
		}

		Template template = getPrintTemplate(entity);
		template.merge(context, writer);

		return writer;
	}

	private Integer increateInPay(List<Object[]> curpayLvl, List<Object[]> chngPayLvl) {
		Integer total = 0;
		try {
			BigInteger currentPay = (BigInteger) curpayLvl.get(0)[0];
			BigInteger paylevel = (BigInteger) chngPayLvl.get(0)[0];
			if (currentPay.intValue() < paylevel.intValue()) {
				total = paylevel.intValue() - currentPay.intValue();
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
		}
		return total;
	}

	public Template getPrintTemplate(PVUSeniorScaleEntity entity) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template tempName = new Template();
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/seniorScale/seniorScale7.vm");
		} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/seniorScale/seniorScale6.vm");
		} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/seniorScale/seniorScale5.vm");
		}
		return tempName;
	}

	/**
	 * Update for pulled back.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @param pvuEntity       the pvu entity
	 */
	private void updateForPulledBack(PvuWFWrapperDto pvuWFWrapperDto, PVUSeniorScaleEntity pvuEntity) {
		inwardService.updateStatusId(Constant.INACTIVE_STATUS, pvuEntity.getId(), new Date(),
				pvuWFWrapperDto.getEventId());
	}

	/**
	 * Sets the revision no.
	 *
	 * @param employeeEventsEntity the new revision no
	 * @throws CustomException the custom exception
	 */
	private void setRevisionNo(PVUEmployeEventsEntity employeeEventsEntity) throws CustomException {
		try {
			employeeEventsEntity.setRevisionNo(eventsService.getLatestRevisionNo(employeeEventsEntity.getEmpId(),
					employeeEventsEntity.getPayCommission()));
		} catch (CustomException e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
}
