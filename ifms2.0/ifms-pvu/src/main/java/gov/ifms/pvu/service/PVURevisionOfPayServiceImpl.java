package gov.ifms.pvu.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.text.ParseException;
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

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
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
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVURevisionOfPayConverter;
import gov.ifms.pvu.converter.PVURopEventConfigurationConverter;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVURevisionOfPayDto;
import gov.ifms.pvu.dto.PVURevisionOfPayRemarkHstDto;
import gov.ifms.pvu.dto.PVURevisionOfPaySearchView;
import gov.ifms.pvu.dto.PVURopDetailRequest;
import gov.ifms.pvu.dto.PVURopEmployeView;
import gov.ifms.pvu.dto.PVURopPostDetailView;
import gov.ifms.pvu.dto.PVURopRemarksDto;
import gov.ifms.pvu.dto.PVURopView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.RopEmployeeDetailDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.RopConfigurationDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVURevisionOfPayEntity;
import gov.ifms.pvu.entity.PVURopEventConfigurationEntity;
import gov.ifms.pvu.entity.PVURopRemarksEntity;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVURevisionOfPayRemarkRepository;
import gov.ifms.pvu.repository.PVURevisionOfPayRepository;
import gov.ifms.pvu.repository.PVURopEventConfigurationRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVURevisionOfPayController.
 *
 * @version v 1.0
 * @created 2020/01/09 12:59:56
 */
@Service
public class PVURevisionOfPayServiceImpl implements PVURevisionOfPayService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVURevisionOfPayAsMethodName repository. */
	@Autowired
	private PVURevisionOfPayRepository repository;

	/** The pvu rop event config repository. */
	@Autowired
	private PVURopEventConfigurationRepository pvuRopEventConfigRepository;

	/** The converter. */
	@Autowired
	private PVURevisionOfPayConverter converter;

	/** The pvu common service. */
	@Autowired
	private PVUCommonService pvuCommonService;

	/** The pvu employee event status service. */
	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	/** The look up info repository. */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/** The rop event config conerter. */
	@Autowired
	private PVURopEventConfigurationConverter ropEventConfigConerter;

	/** The pvu facade. */
	@Autowired
	private PVYFacade pvuFacade;

	/** The remark repository. */
	@Autowired
	private PVURevisionOfPayRemarkRepository remarkRepository;

	/** The pvu employe repository. */
	@Autowired
	private PVUEmployeRepository pvuEmployeRepository;

	/** The pvu employe events service. */
	@Autowired
	private PVUEmployeEventsService pvuEmployeEventsService;

	/** The pvu ms reason service. */
	@Autowired
	private PVUMsReasonService pvuMsReasonService;

	/** The pvu rop remarks service. */
	@Autowired
	private PVURopRemarksService pvuRopRemarksService;

	/**
	 * Gets the pvu rop search fields.
	 *
	 * @return the pvu rop search fields
	 */
	private List<PVUSearchEnum> getPvuRopSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO,
				PVUSearchEnum.PVU_SEARCH_ROP_TYPE, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME, PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
				PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO, PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_START_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_END_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_GPF_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_PPAN_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMPLOYEE_TYPE);
	}

	/**
	 * Gets the pvu rop employee search fields.
	 *
	 * @return the pvu rop employee search fields
	 */
	private List<PVUSearchEnum> getPvuRopEmployeeSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_FIELD_PPAN_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO, PVUSearchEnum.PVU_SEARCH_PAN,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EMPLOYEE_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE);
	}

	/**
	 * Gets the pvu office rop search fields.
	 *
	 * @return the pvu office rop search fields
	 */
	private List<PVUSearchEnum> getPvuOfficeRopSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_ROP_TYPE,
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
				PVUSearchEnum.PVU_SEARCH_DDO, PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_GPF_NO);
	}

	/**
	 * Retrieves an PVURevisionOfPayEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVURevisionOfPayEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVURevisionOfPayEntity getRevisionOfPayById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(MsgConstant.RECORD_NOT_FOUND));
	}

	/**
	 * Gets the revision of pays search list.
	 *
	 * @param pageDetail the page detail
	 * @return the revision of pays search list
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVURevisionOfPaySearchView> getRevisionOfPaysSearchList(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapList(pageDetail, getPvuRopSearchFields());
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMP_ROP_LIST));
			List<PVURevisionOfPaySearchView> objStorePro = repository.storeProc(procName, map,
					PVURevisionOfPaySearchView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Save or update.
	 *
	 * @param entity the entity
	 * @return the PVU revision of pay entity
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVURevisionOfPayEntity saveOrUpdate(PVURevisionOfPayEntity entity) throws CustomException {
		PVURevisionOfPayEntity save = null;
		try {
			if (Utils.isEmpty(entity.getTrnNo())) {
				entity.setTrnNo(pvuCommonService.getTransactionNumber(Constant.ROP));
			}
			save = repository.save(entity);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
		return save;

	}

	/**
	 * Save or update revision of pay.
	 *
	 * @param dto the dto
	 * @return the PVU revision of pay dto
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public PVURevisionOfPayDto saveOrUpdateRevisionOfPay(PVURevisionOfPayDto dto) throws CustomException {
		PVURevisionOfPayEntity ropEntity = null;
		PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto = null;
		boolean oldTransaction = isOldTransaction(dto.getId());

		if (oldTransaction) {
			ropEntity = getRevisionOfPayById(dto.getId());

			if (ropEntity.getEmpId().getEmpId() == dto.getEmpId()) {
				ropEntity = converter.updateRopEntity(ropEntity, dto);
				ropEntity = saveOrUpdate(ropEntity);
			} else {
				pvuEmployeeEventStatusDto = validateEmpInProgressEvent(dto.getEmpId());
				pvuEmployeeEventStatusService.resetInProgressEmployeeEventStatus(ropEntity.getEmpId().getEmpId(), 0l);
				ropEntity = converter.updateRopEntity(ropEntity, dto);
				createEmployeeROPEvent(dto.getEmpId(), pvuEmployeeEventStatusDto, ropEntity);
				ropEntity = saveOrUpdate(ropEntity);
			}
		} else {
			pvuEmployeeEventStatusDto = validateEmpInProgressEvent(dto.getEmpId());
			ropEntity = converter.toEntity(dto);
			pvuEmployeeEventStatusService.inProgressSuspensionEvent(ropEntity.getEmpId().getEmpId());
			EDPLuLookUpInfoEntity statusId = lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
			ropEntity.setStatusId(statusId);
			ropEntity = saveOrUpdate(ropEntity);
			createEmployeeROPEvent(ropEntity.getEmpId().getEmpId(), pvuEmployeeEventStatusDto, ropEntity);
		}

		return converter.toDTO(ropEntity);
	}

	/**
	 * Checks if is old transaction.
	 *
	 * @param id the id
	 * @return true, if is old transaction
	 */
	private boolean isOldTransaction(Long id) {
		if (!Utils.isEmpty(id)) {
			return id > Constant.LONG_ZERO_VALUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * Validate emp in progress event.
	 *
	 * @param empId the emp id
	 * @return the PVU employee event status dto
	 * @throws CustomException the custom exception
	 */
	private PVUEmployeeEventStatusDto validateEmpInProgressEvent(Long empId) throws CustomException {
		PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto = pvuEmployeeEventStatusService
				.findPVUEmployeeStatusDto(empId);
		if (Utils.isEmpty(pvuEmployeeEventStatusDto)) {
			logger.error(Constant.EMP_DETAILS_NOT_EXIST);
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, Constant.EMP_DETAILS_NOT_EXIST);
		}
		if (pvuEmployeeEventStatusDto.isInProgress()) {
			throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(MsgConstant.EVENT_IN_PROGRESS,
					pvuEmployeeEventStatusDto.getTransId(), pvuEmployeeEventStatusDto.getEmployeeCode()));
		}
		return pvuEmployeeEventStatusDto;
	}

	/**
	 * Gets the revision of pay.
	 *
	 * @param id the id
	 * @return the revision of pay
	 */
	@Override
	public PVURevisionOfPayDto getRevisionOfPay(Long id) {
		PVURevisionOfPayEntity ropEntity = getRevisionOfPayById(id);
		return converter.toDTO(ropEntity);
	}

	/**
	 * Creates the employee ROP event.
	 *
	 * @param empId                     the emp id
	 * @param pvuEmployeeEventStatusDto the pvu employee event status dto
	 * @param entity                    the entity
	 */
	private void createEmployeeROPEvent(Long empId, PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto,
			PVURevisionOfPayEntity entity) {
		PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity = new PVUEmployeeEventStatusEntity();
		if (!Utils.isEmpty(pvuEmployeeEventStatusDto)) {
			pvuEmployeeEventStatusEntity.setEventStatusId(pvuEmployeeEventStatusDto.getEventStatusId());
		}
		pvuEmployeeEventStatusEntity.setEmpId(new PVUEmployeEntity(empId));
		pvuEmployeeEventStatusEntity.setRop(Constant.ACTIVE_STATUS);
		pvuEmployeeEventStatusEntity.setTransId(entity.getTrnNo());
		pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity);
	}

	/**
	 * Submit rop event.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return true, if successful
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackOn = { CustomException.class, Exception.class })
	public boolean submitRopEvent(PvuWFWrapperDto wrapperDto) throws CustomException {
		boolean vBool = false;
		Long trnId = wrapperDto.getTrnId();
		Optional<PVURevisionOfPayEntity> optionalRopTrn = repository.findById(wrapperDto.getTrnId());
		try {
			if (optionalRopTrn.isPresent()) {
				PVURevisionOfPayEntity pvuRevisionOfPayEntity = optionalRopTrn.get();
				vBool = pvuFacade.callWorkFlowApis(wrapperDto);
				EDPLuLookUpInfoEntity saveAsDraft = lookUpInfoRepository
						.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
								Constant.ACTIVE_STATUS, Constant.SAVE_AS_DRAFT);
				if (pvuRevisionOfPayEntity.getStatusId().getLookUpInfoId() == saveAsDraft.getLookUpInfoId()) {
					/* trans Status is Save as Draft To submit */
					EDPLuLookUpInfoEntity submitStatus = lookUpInfoRepository
							.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
									Constant.ACTIVE_STATUS, Constant.SUBMIT);
					repository.updateStatusId(submitStatus.getLookUpInfoId(), trnId,
							OAuthUtility.getCurrentUserUserId(), new Date());
					/* Insert ITR table */
				} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
					EDPLuLookUpInfoEntity printEnable = lookUpInfoRepository
							.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.CONDITION_CHECK,
									Constant.ACTIVE_STATUS, Constant.LOOKUP_YES);
					repository.updatePrintStatusAndApproveDate(Constant.ACTIVE_STATUS, trnId,
							OAuthUtility.getCurrentUserUserId(), new Date(), printEnable.getLookUpInfoId(), new Date());
					authorizedRop(wrapperDto.getTrnId());
					if (Utils.isNonEmpty(pvuRevisionOfPayEntity.getTrnNo())) {
						submitAutoIncrement(pvuRevisionOfPayEntity.getTrnNo());
					}
				}else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.PULLED_BACK)) {
					if (!Utils.isEmpty(pvuRevisionOfPayEntity.getTrnNo())) {
						rejectROP(pvuRevisionOfPayEntity.getTrnNo());
					}
				}else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
					/* Update Reject Status for Any User Rejected */
					EDPLuLookUpInfoEntity rejectedStatus = lookUpInfoRepository
							.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
									Constant.ACTIVE_STATUS, Constant.REJECTED);
					repository.updateStatusId(rejectedStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
							OAuthUtility.getCurrentUserUserId(), new Date());
					/* Unlock event */
					pvuEmployeeEventStatusService.resetInProgressEmployeeEventStatus(
							pvuRevisionOfPayEntity.getEmpId().getEmpId(), OAuthUtility.getCurrentUserLkPOUId());
					if (!Utils.isEmpty(pvuRevisionOfPayEntity.getTrnNo())
							&& !Utils.isEmpty(pvuRevisionOfPayEntity.getIsPrintAble())) {
						rejectROP(pvuRevisionOfPayEntity.getTrnNo());
					}
				} else if (wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)) {
					/* Update Status ApproverClass II Authorization */
					EDPLuLookUpInfoEntity authorizationStatus = lookUpInfoRepository
							.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
									Constant.RECOMMENDATION_FOR, Constant.ACTIVE_STATUS, Constant.AUTHORIZE);
					repository.updateStatusId(authorizationStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
							OAuthUtility.getCurrentUserUserId(), new Date());

					/* Unlock event */
					repository.updateAutorizedDate(Constant.ACTIVE_STATUS, trnId, OAuthUtility.getCurrentUserUserId(),
							new Date(), new Date());
					/**
					 * pvuEmployeeEventStatusService.resetInProgressEmployeeEventStatus(
					 * pvuRevisionOfPayEntity.getEmpId().getEmpId(),
					 * OAuthUtility.getCurrentUserLkPOUId());
					 */
				} else if (wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_II)) {
					/* Update Status ApproverClass II Return */
					EDPLuLookUpInfoEntity returnStatus = lookUpInfoRepository
							.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
									Constant.RECOMMENDATION_FOR, Constant.ACTIVE_STATUS, Constant.RETURN);
					repository.updateStatusId(returnStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
							OAuthUtility.getCurrentUserUserId(), new Date());

				} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.FORWARD_TO_PVU)) {
					this.insertInwardTable(wrapperDto);
				}

				if (wrapperDto.getAssignByWfRoleId() == Constant.AUDITOR
						|| wrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_TWO) {
					this.insertRopRemarksITR(trnId);
				}
				this.insertRopITR(wrapperDto);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
		return vBool;
	}

	/**
	 * Submit auto increment.
	 *
	 * @param pvuRopView the pvu rop view
	 * @throws CustomException the custom exception
	 */
	public void submitAutoIncrement(String trnNo) throws CustomException {
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.P_PVU_ROP_AUTO_INCR).toString();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("IN_TRN_NO", trnNo);
		Object getResult = repository.callUsingCallableStmt(procName, map);
		if (!getResult.equals(0l)) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public void rejectROP(String trnNo) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.ROP_DDO_REJECTION_CASE);
		repository.callStoredProcedure(procName.toString(), map);
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
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_ROP_INWARD_INS));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * Insert rop remarks ITR.
	 *
	 * @param transId the trans id
	 */
	@Override
	public void insertRopRemarksITR(Long transId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.INSERT_ROP_REMARKS_ITRS);
		repository.callStoredProcedure(procName.toString(), map);
	}

	/**
	 * Insert rop ITR.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 */
	@Override
	public void insertRopITR(PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_ROP_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * Rop post details.
	 *
	 * @param pvuRopDetailRequest the pvu rop detail request
	 * @return the PVU rop post detail view
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVURopPostDetailView ropPostDetails(PVURopDetailRequest pvuRopDetailRequest) throws CustomException {
		Map<String, Object> map = prepareRequestFor(pvuRopDetailRequest);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_ROP_POST_DETAIL_SP));
		List<PVURopPostDetailView> objStorePro = repository.storeProc(procName, map, PVURopPostDetailView.class);
		return objStorePro.stream().findFirst().orElse(new PVURopPostDetailView());
	}

	/**
	 * Prepare request for.
	 *
	 * @param pvuRopDetailRequest the pvu rop detail request
	 * @return the map
	 */
	private Map<String, Object> prepareRequestFor(PVURopDetailRequest pvuRopDetailRequest) {
		Map<String, Object> map = new HashMap<>();
		map.put("ROP_TYPE", pvuRopDetailRequest.getRopType());
		map.put("EMP_NO", pvuRopDetailRequest.getEmpNo());
		map.put("PAY_SCALE", pvuRopDetailRequest.getPayScale());
		map.put("PAY_BAND", pvuRopDetailRequest.getPayBand());
		map.put("PAY_BAND_VALUE", pvuRopDetailRequest.getPayBandValue());
		map.put("GRADE_PAY", pvuRopDetailRequest.getGradePay());
		map.put("BASIC_PAY", pvuRopDetailRequest.getBasicPay());
		map.put("eff_date", pvuRopDetailRequest.getEffectiveDate());
		return map;
	}

	/**
	 * Update rop remarks.
	 *
	 * @param dto the dto
	 * @return the PVU revision of pay dto
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public PVURevisionOfPayDto updateRopRemarks(PVURevisionOfPayDto dto) throws CustomException {
		PVURevisionOfPayEntity entity = converter.updateRopRemarks(getRevisionOfPayById(dto.getId()), dto);
		PVURevisionOfPayEntity updateEntity = saveOrUpdate(entity);
		if (!Utils.isEmpty(dto.getReturnReasons())) {
			Long wfRoleId = dto.getWfRoleId();
			String remarkType = dto.getWfRoleId() == Constant.AUDITOR ? Constant.AUDITOR_NAME
					: Constant.APPROVER_CLASS_TWO_NAME;
			boolean isReturnReason = false;
			if (((!Utils.isEmpty(dto.getAuditorReturnReason())) && dto.getAuditorReturnReason() == Constant.RETURN_VAL)
					|| ((!Utils.isEmpty(dto.getClassTwoReturnReason()))
							&& dto.getClassTwoReturnReason() == Constant.RETURN_VAL)) {
				isReturnReason = dto.getAuditorReturnReason() == Constant.RETURN_VAL
						|| dto.getClassTwoReturnReason() == Constant.RETURN_VAL;
			}

			if (isReturnReason) {
				// Need to deactive old reason
				pvuRopRemarksService.deactiveOldReason(dto.getId(), Constant.IN_ACTIVE_STATUS);

				// Need to insert new reason
				List<PVURopRemarksEntity> lstRopRemarks = dto.getReturnReasons().stream().map(remarkDto -> {
					PVURopRemarksEntity pvuRopRemarksEntity = new PVURopRemarksEntity();
					pvuRopRemarksEntity.setRpEventId(dto.getId());
					pvuRopRemarksEntity.setWorkFlowRoleId(wfRoleId);
					pvuRopRemarksEntity.setEmpId(dto.getEmpId());
					pvuRopRemarksEntity.setRemarks(remarkDto.getRemarks());
					pvuRopRemarksEntity.setRemarksType(remarkType);
					pvuRopRemarksEntity.setReason(remarkDto.getReasonId());
					pvuRopRemarksEntity.setActiveStatus(Constant.ACTIVE_STATUS);
					return pvuRopRemarksEntity;
				}).collect(Collectors.toList());

				pvuRopRemarksService.saveOrUpdateRopRemarksAll(lstRopRemarks);
			}
		}
		return converter.toDTO(updateEntity);
	}

	/**
	 * Gets the revision of pay view.
	 *
	 * @param id the id
	 * @return the revision of pay view
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVURopView getRevisionOfPayView(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.IN_PVU_RP_EVNT_ID, id);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.PVU_EMP_ROP_VIEW_DATA);
		List<Object[]> obj = repository.callStoredProcedure(procName.toString(), map);
		if (!obj.isEmpty())
			return NativeQueryResultsMapper.map(obj, PVURopView.class).get(0);
		else
			return null;
	}

	/**
	 * Delete rop trns.
	 *
	 * @param idDto the id dto
	 * @return true, if successful
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public boolean deleteRopTrns(IdDto idDto) throws CustomException {
		Optional<PVURevisionOfPayEntity> revisionOfPayEntity = repository.findById(idDto.getId());
		if (revisionOfPayEntity.isPresent()) {
			PVURevisionOfPayEntity entity = revisionOfPayEntity.get();
			EDPLuLookUpInfoEntity saveAsDraft = lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
			if (entity.getStatusId().getLookUpInfoId() == saveAsDraft.getLookUpInfoId()) {
				repository.deleteRopEventIdBy(Constant.IN_ACTIVE_STATUS, idDto.getId(),
						OAuthUtility.getCurrentUserUserId(), new Date());
				pvuEmployeeEventStatusService.resetInProgressEmployeeEventStatus(entity.getEmpId().getEmpId(),
						OAuthUtility.getCurrentUserLkPOUId());
				return Boolean.TRUE;
			} else {
				throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * Gets the rop search employes.
	 *
	 * @param pageDetail the page detail
	 * @return the rop search employes
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVURopEmployeView> getRopSearchEmployes(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInRopEmp(pageDetail, getPvuRopEmployeeSearchFields());
			StringBuilder procName = new StringBuilder();
			procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.ROP_EMPLOYEE_SEARCH);
			List<PVURopEmployeView> objStorePro = repository.storeProc(procName.toString(), map,
					PVURopEmployeView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.toString(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Builds the page in rop emp.
	 *
	 * @param pageDetail   the page detail
	 * @param lstSearchEum the lst search eum
	 * @return the map
	 */
	private Map<String, Object> buildPageInRopEmp(PageDetails pageDetail, List<PVUSearchEnum> lstSearchEum) {
		Map<String, String> collect = lstSearchEum.stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		Map<String, Object> map = new LinkedHashMap<>();
		if (!Utils.isEmpty(searchParams)) {
			Map<String, Object> map1 = SearchParam.getMap(searchParams, collect);
			map.putAll(map1);
		} else {
			Map<String, Object> map1 = SearchParam.getDefaultMap(collect);
			map.putAll(map1);
		}
		return map;
	}

	/**
	 * Gets the rop remark history.
	 *
	 * @param idDto the id dto
	 * @return the rop remark history
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<PVURevisionOfPayRemarkHstDto> getRopRemarkHistory(IdDto idDto) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.ROP_EVENT_ID, idDto.getId());
		map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
		List<Object[]> objects = remarkRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getRopRemarkHistory(), map);
		return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PVURevisionOfPayRemarkHstDto.class)
				: Collections.emptyList();
	}

	/**
	 * Gets the rop employee details.
	 *
	 * @param ropEmployeeRequest the rop employee request
	 * @return the rop employee details
	 * @throws CustomException the custom exception
	 * @throws ParseException  the parse exception
	 */
	@Override
	public RopEmployeeDetailDto getRopEmployeeDetails(PVURopDetailRequest ropEmployeeRequest)
			throws CustomException, ParseException {
		Map<String, Object> map = buildRopEmployeeRequestMap(ropEmployeeRequest);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.ROP_EMPLOYEE_DETAIL);
		List<RopEmployeeDetailDto> objStorePro = repository.storeProc(procName.toString(), map,
				RopEmployeeDetailDto.class);
		if (Utils.isEmpty(objStorePro)) {
			if (Constant.ROP_2009 == ropEmployeeRequest.getRopType()) {
				throw new CustomException(HttpStatus.BAD_REQUEST, Constant.EMPLOYEE_NOT_EXIST_IN_5TH_PAY_COMMISSION);
			} else {
				throw new CustomException(HttpStatus.BAD_REQUEST, Constant.EMPLOYEE_NOT_EXIST_IN_6TH_PAY_COMMISSION);
			}
		}
		RopEmployeeDetailDto ropEmployeeDetailDto = objStorePro.get(0);
		validateEmployeeEligableForROP(ropEmployeeDetailDto, ropEmployeeRequest);
		return ropEmployeeDetailDto;
	}

	/**
	 * Validate employee eligable for ROP.
	 *
	 * @param ropEmployeeDetailDto the rop employee detail dto
	 * @param ropEmployeeRequest   the rop employee request
	 * @throws CustomException the custom exception
	 * @throws ParseException  the parse exception
	 */
	private void validateEmployeeEligableForROP(RopEmployeeDetailDto ropEmployeeDetailDto,
			PVURopDetailRequest ropEmployeeRequest) throws CustomException, ParseException {
		String regularConversionDate = repository.findRegularConverstionDate(ropEmployeeDetailDto.getEmployeeId());

		if (!ropEmployeeDetailDto.getEmpType().equals(Constant.RUGULAR_EMPLOYEE)) {
			throw new CustomException(HttpStatus.BAD_REQUEST, Constant.ONLY_REGULAR_EMPLOYEE_ELIGABLE_FOR_ROP);
		}

		if (!ropEmployeeDetailDto.getOfficeId().equals(OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId())) {
			throw new CustomException(HttpStatus.BAD_REQUEST, MessageFormat
					.format(MsgConstant.ERROR_EMPLOYEE_NOT_IN_OFFICE, ropEmployeeDetailDto.getEmployeeNo()));
		}

		if (ropEmployeeDetailDto.isSuspended()) {
			throw new CustomException(HttpStatus.BAD_REQUEST, Constant.ROP_CAN_NOT_BE_PERFORMED_ON_SUSPENDED_EMPLOYEE);
		}

		if (Utils.isAfter(ropEmployeeDetailDto.getDateJoining(), ropEmployeeRequest.getEffectiveDate())) {
			throw new CustomException(HttpStatus.CONFLICT,
					Constant.EVENT_EFFECTIVE_DATE_MUST_BE_GREATER_THAN_DATE_OF_JOINING);
		}
		if (Utils.isAfter(ropEmployeeRequest.getEffectiveDate(), ropEmployeeDetailDto.getRetirementDate())) {
			throw new CustomException(HttpStatus.CONFLICT, Constant.EMPLOYEE_RETIRED);
		}
		if (ropEmployeeDetailDto.isOldEol()) {
			throw new CustomException(HttpStatus.BAD_REQUEST, Constant.EMPLOYEE_WAS_ON_EOL_EFFECTIVE_DATE_MUST_BE_AFTER
					+ Utils.inFormatedDateString(ropEmployeeDetailDto.getEolResumeDate()));
		}

		if (ropEmployeeDetailDto.isOldSuspended()) {
			throw new CustomException(HttpStatus.BAD_REQUEST,
					Constant.EMPLOYEE_WAS_SUSPENDED_EFFECTIVE_DATE_MUST_BE_AFTER
							+ Utils.inFormatedDateString(ropEmployeeDetailDto.getSuspendedResumeDate()));
		}
		if (StringUtils.isNotEmpty(regularConversionDate) && Utils.isAfter(regularConversionDate, ropEmployeeRequest.getEffectiveDate())) {
			throw new CustomException(HttpStatus.CONFLICT,
					Constant.EVENT_EFFECTIVE_DATE_MUST_BE_GREATER_THAN_DATE_OF_REGULAR_CON_DATE);
		}
	}

	/**
	 * Builds the rop employee request map.
	 *
	 * @param ropEmployeeRequest the rop employee request
	 * @return the map
	 */
	private Map<String, Object> buildRopEmployeeRequestMap(PVURopDetailRequest ropEmployeeRequest) {
		Map<String, Object> map = new HashMap<>();
		map.put(Constant.IN_EMPLOYEE_NO, ropEmployeeRequest.getEmpNo());
		map.put(PvuConstant.IN_EFFECTIVE_DATE, ropEmployeeRequest.getEffectiveDate());
		map.put(PvuConstant.IN_ROP_TYPE, ropEmployeeRequest.getRopType());
		return map;
	}

	/**
	 * Get pvu Office Name for rop event.
	 *
	 * @param idDto the id dto
	 * @return the PVU office name
	 */
	@Override
	public EDPMsOfficeDto getPVUOfficeName(IdDto idDto) {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.ROP_EVENT_ID, idDto.getId());
		List<Object[]> objects = remarkRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getRopEmployeeOfficeId(),
				map);
		if (!Utils.isEmpty(objects)) {
			EDPMsOfficeDto officeDto = new EDPMsOfficeDto();
			officeDto.setOfficeName(String.valueOf(objects.get(0)[0]));
			return officeDto;
		}
		return null;
	}

	/**
	 * Gets the PVU revision of pays search list.
	 *
	 * @param pageDetail the page detail
	 * @return the PVU revision of pays search list
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVURevisionOfPaySearchView> getPVURevisionOfPaysSearchList(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapList(pageDetail, getPvuOfficeRopSearchFields());
			StringBuilder procName = new StringBuilder();
			procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.PVU_EMP_ROP_PVU_OFFICE_LIST);
			List<Object[]> objStorePro = repository.callStoredProcedure(procName.toString(), map);
			if (!Utils.isEmpty(objStorePro)) {
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(),
						NativeQueryResultsMapper.map(objStorePro, PVURevisionOfPaySearchView.class));
			}
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, 0, Collections.emptyList());
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Builds the page in map list.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	private Map<String, Object> buildPageInMapList(PageDetails pageDetail, List<PVUSearchEnum> lstPVUSearch) {
		Map<String, String> collect = lstPVUSearch.stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(new StringBuilder(), pageDetail, collect);
	}

	/**
	 * Gets the return reason by transaction id.
	 *
	 * @param id the id
	 * @return the return reason by transaction id
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<PVURopRemarksDto> getReturnReasonByTransactionId(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.ROP_EVENT_ID, id);
		map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
		List<Object[]> objects = remarkRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getRopReturnRemarks(), map);
		return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PVURopRemarksDto.class)
				: Collections.emptyList();
	}

	/**
	 * Gets the rop reasons.
	 *
	 * @return the rop reasons
	 */
	@Override
	public List<PVUMsReasonDto> getRopReasons() {
		return pvuMsReasonService.getRopReasons();
	}

	/**
	 * Authorized rop.
	 *
	 * @param transId the trans id
	 */
	@Override
	public void authorizedRop(Long transId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.PVU_AUTHORIZED_ROP);
		repository.callStoredProcedure(procName.toString(), map);
	}

	/**
	 * Rop given previous.
	 *
	 * @param pvuRopDetailRequest the pvu rop detail request
	 * @return the boolean
	 * @throws CustomException the custom exception
	 * @throws ParseException  the parse exception
	 */
	@Override
	public Boolean ropGivenPrevious(PVURopDetailRequest pvuRopDetailRequest) throws CustomException, ParseException {
		PVUEmployeEntity employeeEntity = pvuEmployeRepository
				.findByEmployeeCodeAndActiveStatus(pvuRopDetailRequest.getEmpNo(), Constant.ACTIVE_STATUS)
				.orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
		String eventName = Constant.ROP_2009 == pvuRopDetailRequest.getRopType() ? Constant.ROP_2009_EVENT
				: Constant.ROP_2016_EVENT;
		PVUEmployeEventsEntity pvuEmployeEventsEntity = pvuEmployeEventsService
				.findOneByEmpIdAndEventName(employeeEntity.getEmpId(), eventName);
		if (Utils.isEmpty(pvuEmployeEventsEntity)) {
			return Boolean.FALSE;
		} else {
			if (!Utils.isSame(pvuEmployeEventsEntity.getEventDate(), pvuRopDetailRequest.getEffectiveDate())) {
				throw new CustomException(HttpStatus.BAD_REQUEST, Constant.ROP_ALREADY_GIVEN_PROVIDE_EFFECTIVE_DATE_AS
						+ Utils.inFormatedDateString(pvuEmployeEventsEntity.getEventDate()));
			}
			return Boolean.TRUE;
		}
	}

	/**
	 * Rop configuration list.
	 *
	 * @return the list
	 */
	@Override
	public List<RopConfigurationDto> ropConfigurationList() {
		List<PVURopEventConfigurationEntity> lstRopConfiguration = pvuRopEventConfigRepository
				.findByActiveStatus(Constant.ACTIVE_STATUS);
		return ropEventConfigConerter.toDTO(lstRopConfiguration);
	}

	@Override
	public String generateDdoApprovalCertificate(IdDto dto) throws IOException, CustomException, DocumentException {
		return generateDdoApprovalCertificatePDF(dto);
	}

	public String generateDdoApprovalCertificatePDF(IdDto dto) throws CustomException {
		String htmltoPdf = null;
		Map<String, Object> map = new HashMap<>();
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
			document.addTitle("DDO Approval Certificate");
			document.setPageSize(PageSize.LETTER);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			pdfWriter = PdfWriter.getInstance(document, baos);

			// open document
			document.open();

			writer.write(generateDDOApprovalPrint(dto).toString());

			map.put("content", writer.toString());
			htmltoPdf = pvuCommonService.htmlToPdfRequest(map); // call this method for node js API for html to Base64

			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));

			// close the document
			document.close();
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + PvuConstant.ROP_EVENT_ID + ".pdf");
			header.setContentLength(baos.toByteArray().length);

			return htmltoPdf;
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}

	}

	public StringWriter generateDDOApprovalPrint(IdDto dto) throws CustomException {
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		PVURevisionOfPayEntity entity = repository.getOne(dto.getId());

		VelocityContext context = converter.ddoApprovalCertificate(entity);
		Map<String, Object> map = new HashMap<>();
		map.put("userId", entity.getUpdatedBy());
		List<Object[]> objects = repository
				.executeSQLQuery(PVUNativeSqlQueryConstant.getDDONameAndDesignationAndLocation(), map);

		Map<String, Object> map1 = new HashMap<>();
		map1.put("trnId", dto.getId());
		List<Object[]> object = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getRopApprovedDate(), map1);

		context = converter.ddoApprovalCertificateObject(objects, object, context);

		Template template = generateDdoApprovalCertificate();
		template.merge(context, writer);
		return writer;
	}

	public Template generateDdoApprovalCertificate() {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		return ve.getTemplate("templates/rop/ddoApprovalCertificate.vm");
	}
}
