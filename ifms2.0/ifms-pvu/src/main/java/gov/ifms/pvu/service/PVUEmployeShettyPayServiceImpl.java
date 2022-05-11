package gov.ifms.pvu.service;

import static gov.ifms.pvu.util.PvuConstant.EVENT_CODE_SHETTY_PAY;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
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
import javax.transaction.Transactional;

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
import gov.ifms.pvu.converter.PVUEmployeShettyPayConverter;
import gov.ifms.pvu.converter.PVUPrintEndorsementItrConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeShettyPayDto;
import gov.ifms.pvu.dto.PVUEmployeeShettyPayAuditViewDto;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUSPPrintEndorsementView;
import gov.ifms.pvu.dto.PVUShettyPayInwardView;
import gov.ifms.pvu.dto.PVUShettyPayListView;
import gov.ifms.pvu.dto.PVUShettyPayOutwardView;
import gov.ifms.pvu.dto.PVUShettyPayPVUOfficeSearchDto;
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
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeShettyPayEntity;
import gov.ifms.pvu.entity.PVUEmployeSuspensionEntity;
import gov.ifms.pvu.entity.PVUEmployeeEOLeaveEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;
import gov.ifms.pvu.entity.PVUMsEventEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementItrEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeEventsRepository;
import gov.ifms.pvu.repository.PVUEmployeShettyPayRepository;
import gov.ifms.pvu.repository.PVUInwardRepository;
import gov.ifms.pvu.repository.PVUMsEventRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.util.WatermarkPageEvent;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;

@Service
public class PVUEmployeShettyPayServiceImpl implements PVUEmployeShettyPayService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUEmployeShettyPayAsMethodName repository. */
	@Autowired
	private PVUEmployeShettyPayRepository repository;

	/** The PVUEmployeShettyPayAsMethodName helper. */
	@Autowired
	private PVUEmployeShettyPayConverter converter;

	@Autowired
	private PVUPrintEndorsementItrRepository printItrRepository;

	/** The lookupinforepository. */
	@Autowired
	private EDPLuLookUpInfoRepository lookupinforepository;

	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Autowired
	private PVUCommonService pvuCommonService;

	@Autowired
	private PVUEmployeDepartmentRepository empDeptRepository;

	@Autowired
	private PVYFacade pvuFacade;

	@Autowired
	private PVUMsEventRepository msRepository;

	@Autowired
	private WfRepository wfRepository;

	@Autowired
	private PVUEventRemarksService eventRemarksService;

	@Autowired
	private PVUInwardRepository pvuInwardRepository;

	@Autowired
	private PVUPrintEndorsementRepository printRepository;

	@Autowired
	private PVUPrintEndorsementItrConverter printItrConverter;

	@Autowired
	private OAuthService authService;

	@Autowired
	private EncryptDecryptUtil securityUtil;
	@Autowired
	private PVUEmployeEventsRepository eventRepostory;
	@Autowired
	private PVUInwardService inwardService;

	@Autowired
	private PVUEmployeEventsService eventsService;

	@Autowired
	private PVUEmployeeEOLeaveService eoLeaveService;

	@Autowired
	private PVUEmployeSuspensionService suspensionService;

	/**
	 * Gets the employe shetty pay.
	 *
	 * @param id the id
	 * @return the employe shetty pay
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUEmployeShettyPayEntity getEmployeShettyPay(Long id) throws CustomException {
		try {
			return repository.getOne(id);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Saves a given PVUEmployeShettyPayEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param dto the dto
	 * @return the saved PVUEmployeShettyPayEntity
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public PVUEmployeShettyPayDto saveOrUpdateEmployeShettyPay(PVUEmployeShettyPayDto dto) throws CustomException {
		PVUEmployeShettyPayEntity entity = converter.toEntity(dto);
		if (dto.getStatusId() == 0) {
			pvuEmployeeEventStatusService.inProgressSuspensionEvent(entity.getEmpId().getEmpId());
			entity.setStatusId(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT));
		}
		return converter.toDTO(saveOrUpdate(entity));
	}

	/**
	 * @param entity
	 * @return
	 * @throws CustomException
	 */
	private PVUEmployeShettyPayEntity saveOrUpdate(PVUEmployeShettyPayEntity entity) throws CustomException {
		PVUEmployeShettyPayEntity save = null;
		try {
			save = repository.save(entity);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
		return save;

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
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_SHETTY_PAY_LOOKUP_SP));
			List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupShettyPaySp(procName);
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
			return resultMap;
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Lookup shetty pay sp.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private List<PVUEmployeCreationDDLView> lookupShettyPaySp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, Collections.emptyMap());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	/**
	 * @param request
	 * @return
	 * @throws CustomException
	 */
	@Override
	public boolean checkEligibleforShettyPay(PvuCommonRequest request) throws CustomException {
		Map<String, Object> data = request.getData();
		Long employeeId = Long.valueOf(data.get(PvuConstant.EMPLOYEE_ID).toString());
		String employeeNo = data.get(PvuConstant.EMPLOYEE_NO).toString();
		Object dateOfNextIncrement = data.get(PvuConstant.DATE_OF_NEXT_INC);
		if (Objects.isNull(dateOfNextIncrement)) {
			throw new CustomException(1008, "Date Of Next Increment should not be null");
		}
		LocalDate effectiveDate = PvuUtils.getStrToLocalDate(data.get(PvuConstant.EFFECTIVE_DATE).toString());
		LocalDate dateOfNextInc = PvuUtils.getStrToLocalDate(dateOfNextIncrement.toString());
		validateDates(effectiveDate, dateOfNextInc);
		Date dateOfJoining = validateDepartment(employeeId);
		validateShettyPayCriteria(effectiveDate, dateOfJoining, employeeId);
		return isShettyPayGivenToEmp(employeeId, employeeNo);
	}

	/**
	 * 
	 * @param effectiveDate
	 */
	private void validateShettyPayCriteria(LocalDate effectiveDate, Date dateofJoining, Long employeeId)
			throws CustomException {
		LocalDate originalEffDate = LocalDate.of(2003, Month.APRIL, 1);
		if (ChronoUnit.DAYS.between(convertToLocalDateViaSqlDate(dateofJoining), originalEffDate) <= 0) {
			originalEffDate = convertToLocalDateViaSqlDate(dateofJoining);
		}
		LocalDate newDateOfJoining = validateEOL(employeeId, originalEffDate);
		newDateOfJoining = (newDateOfJoining == null ? validateSuspension(employeeId, originalEffDate)
				: newDateOfJoining);
		long noOfDaysTotal = ChronoUnit.DAYS.between(effectiveDate,
				newDateOfJoining == null ? originalEffDate : newDateOfJoining);
		if (noOfDaysTotal != 0) {
			throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(MsgConstant.SHP_EEFFDATE_MSG,
					PvuUtils.getStrOfLocalDateInDMY(newDateOfJoining == null ? originalEffDate : newDateOfJoining)));
		}

	}

	private LocalDate validateEOL(Long employeeId, LocalDate effectiveDate) throws CustomException {
		List<PVUEmployeEventsEntity> eolEventEntity = eventsService
				.findAllByEmpIdAndEventNameAndActiveStatus(employeeId, PvuConstant.EVENT_CODE_EOL);
		if (!CollectionUtils.isEmpty(eolEventEntity)) {
			for (PVUEmployeEventsEntity eolEventList : eolEventEntity) {
				PVUEmployeeEOLeaveEntity eol = this.eoLeaveService.getOneByTrnNo(eolEventList.getTrnNo());
				long noOfDaysBetween = ChronoUnit.DAYS.between(eol.getStartDate(), effectiveDate);
				long noOfDaysTotal = ChronoUnit.DAYS.between(eol.getStartDate(), eol.getEndDate());
				if (noOfDaysTotal >= noOfDaysBetween && noOfDaysBetween >= 0) {
					return eol.getEndDate().plusDays(1l);
				}
			}
		}
		return null;
	}

	private LocalDate validateSuspension(Long employeeId, LocalDate effectiveDate) throws CustomException {
		List<PVUEmployeEventsEntity> suspEventEntity = eventsService
				.findAllByEmpIdAndEventNameAndActiveStatus(employeeId, PvuConstant.EVENT_CODE_SUSPENSION);
		if (!CollectionUtils.isEmpty(suspEventEntity)) {
			for (PVUEmployeEventsEntity susEventList : suspEventEntity) {
				PVUEmployeSuspensionEntity suspension = this.suspensionService.getOneByTrnNo(susEventList.getTrnNo());
				long noOfDaysBetween = ChronoUnit.DAYS.between(suspension.getSusStartDate(), effectiveDate);
				if (suspension.getSusEndDate() == null)
					continue;
				long noOfDaysTotal = ChronoUnit.DAYS.between(suspension.getSusStartDate(), suspension.getSusEndDate());
				if (noOfDaysTotal >= noOfDaysBetween && noOfDaysBetween >= 0) {
					return suspension.getSusEndDate().plusDays(1l);
				}
			}
		}
		return null;
	}

	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
		return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}

	/**
	 * Validate dates.
	 *
	 * @param effectiveDate the effective date
	 * @param dateOfNextInc the date of next inc
	 * @throws CustomException the custom exception
	 */
	private void validateDates(LocalDate effectiveDate, LocalDate dateOfNextInc) throws CustomException {
		if (effectiveDate == null || dateOfNextInc == null) {
			throw new CustomException(1008, "Effective date && Date Of Next Increment should not be null");
		}
	}

	/**
	 * Validate department.
	 *
	 * @param employeeId the employee id
	 * @throws CustomException the custom exception
	 */
	private Date validateDepartment(Long employeeId) throws CustomException {

		PVUEmployeDepartmentEntity departmentEntity = empDeptRepository.findOneByPvuEmployeEntityEmpId(employeeId);
		if (!Utils.isEmpty(departmentEntity) && !departmentEntity.getParentHeadDept().getDepartmentCode()
				.equalsIgnoreCase(PvuConstant.SP_HEAD_DEPT_CODE)) {
			throw new CustomException(1008, "Employee does not belong to Legal Department");
		}
		return departmentEntity.getDateOfJoiningGOG();
	}

	/**
	 * Checks whether emp have shetty pay but not on same day then
	 *
	 * @param employeeId
	 * @param effectiveDate
	 * @return
	 */
	private boolean isShettyPayGivenToEmp(Long empId, String employeeNo) throws CustomException {
		PVUEmployeEventsEntity event = eventRepostory.findOneByEmpIdAndEventNameAndActiveStatus(empId,
				PvuConstant.EVENT_NAME_SHETTY_PAY, 1);
		if (event != null) {
			throw new CustomException(HttpStatus.CONFLICT, PvuConstant.SP_EXISTS + employeeNo);
		}
		return true;

	}

	/**
	 * Search shetty pay events.
	 *
	 * @param pageDetails the page details
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUShettyPayListView> searchShettyPayEvents(PageDetails pageDetails) throws CustomException {
		Map<String, String> collect = this.getDdoWFListingSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(null, pageDetails, collect);
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.SHP_PVU_EVENT_LS_SRCH_WF));
		List<PVUShettyPayListView> list = this.callListingSP(sp, stringObjectMap);
		return new PagebleDTO<>(pageDetails.getPageElement(), 0, list.size(), list);
	}

	/**
	 * Gets the ddo WF listing search fields.
	 *
	 * @return the ddo WF listing search fields
	 */
	private List<PVUSearchEnum> getDdoWFListingSearchFields() {
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

	/**
	 * @param sp
	 * @param parameters
	 * @return
	 * @throws CustomException
	 */
	public List<PVUShettyPayListView> callListingSP(String sp, Map<String, Object> parameters) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(sp, parameters);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUShettyPayListView.class)
				: Collections.emptyList();
	}

	/**
	 * Gets the shetty pay event.
	 *
	 * @param id the id
	 * @return the shetty pay event
	 */
	public PVUEmployeShettyPayEntity getShettyPayEvent(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(MsgConstant.RECORD_NOT_FOUND));
	}

	/**
	 * Insert shetty pay itr.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the PVU employe shetty pay dto
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public PVUEmployeShettyPayDto insertShettyPayItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
		PVUEmployeShettyPayDto pvuCommonResponse = null;

		PVUEmployeeEventStatusEntity statusEntry = null;
		PVUEmployeShettyPayEntity pvuShettyPayEntity = getShettyPayEvent(pvuWFWrapperDto.getTrnId());

		if (pvuShettyPayEntity != null) {
			if (pvuShettyPayEntity.getTrnNo() != null) {
				statusEntry = pvuEmployeeEventStatusService.inProgressAnyEventByTrnNo(
						pvuShettyPayEntity.getEmpId().getEmpId(), pvuShettyPayEntity.getTrnNo());
			} else {
				statusEntry = pvuEmployeeEventStatusService
						.inProgressAnyEvent(pvuShettyPayEntity.getEmpId().getEmpId());
			}
			if (pvuShettyPayEntity.getTrnNo() == null) {
				pvuShettyPayEntity
						.setTrnNo(this.pvuCommonService.getTransactionNumber(PvuConstant.TranNo.STP.toString()));
				pvuShettyPayEntity.setRefDate(LocalDateTime.now());
				statusEntry.setShettyPay(Constant.ACTIVE_STATUS);
				repository.save(pvuShettyPayEntity);
				pvuEmployeeEventStatusService.updateEventInfo(statusEntry, pvuShettyPayEntity.getTrnNo());
			}
			EDPLuLookUpInfoEntity empApprovStatsLookupInfo = getLookupByName(Constant.STATUS_ID, Constant.APPROVED);
			if (pvuShettyPayEntity.getStatusId().getLookUpInfoId() == empApprovStatsLookupInfo.getLookUpInfoId()) {
				throw new CustomException(ErrorResponse.TRN_ALREADY_APPROVED);
			}
			return createWorkFlow(pvuWFWrapperDto, pvuShettyPayEntity, empApprovStatsLookupInfo);

		}
		return pvuCommonResponse;

	}

	/**
	 * Creates the work flow.
	 *
	 * @param pvuWFWrapperDto          the pvu WF wrapper dto
	 * @param pvuShettyPayEntity       the pvu shetty pay entity
	 * @param empApprovStatsLookupInfo the emp approv stats lookup info
	 * @return the PVU employe shetty pay dto
	 * @throws CustomException the custom exception
	 */
	private PVUEmployeShettyPayDto createWorkFlow(PvuWFWrapperDto pvuWFWrapperDto,
			PVUEmployeShettyPayEntity pvuShettyPayEntity, EDPLuLookUpInfoEntity empApprovStatsLookupInfo)
			throws CustomException {
		PVUEmployeShettyPayDto spDto;
		if (pvuFacade.callWorkFlowApis(pvuWFWrapperDto)) {
			EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = getLookupByName(Constant.STATUS_ID, Constant.SUBMIT);
			if (empSubmitStatusLookupInfo != null) {
				repository.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
						OAuthUtility.getCurrentUserUserId(), getApprovedDate());
			}
			spDto = converter.toDTO(pvuShettyPayEntity);
			updateStatusOnBasedOnWFStatus(pvuWFWrapperDto, pvuShettyPayEntity, empApprovStatsLookupInfo);
			if (pvuWFWrapperDto.getAssignByWfRoleId() == Constant.AUDITOR
					|| Objects.equals(pvuWFWrapperDto.getAssignByWfRoleId(), Constant.VERIFIER)
					|| pvuWFWrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_TWO
					|| pvuWFWrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_ONE) {
				this.insertRemarksITR(pvuWFWrapperDto.getTrnId());
			}
			insertSPInITRs(pvuWFWrapperDto);
		} else {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
		}
		return spDto;
	}

	private void updateStatusOnBasedOnWFStatus(PvuWFWrapperDto pvuWFWrapperDto,
			PVUEmployeShettyPayEntity pvuShettyPayEntity, EDPLuLookUpInfoEntity empApprovStatsLookupInfo) {
		if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
			pvuShettyPayEntity.setStatusId(empApprovStatsLookupInfo);
		} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
			updateForRejected(pvuWFWrapperDto, pvuShettyPayEntity, getApprovedDate());/* Update Status Rejected */
		} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.PULLED_BACK)) {
			updateForPulledBack(pvuWFWrapperDto, pvuShettyPayEntity);/* Inactive inward row */
		} else if (pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)
				|| pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_I)) {
			updateForAuthorised(pvuWFWrapperDto, getApprovedDate(),
					pvuShettyPayEntity);/* Update Status ApproverClass II Authorization */
		} else if (pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_II)
				|| pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_I)) {
			updateForReturnByApprover(pvuWFWrapperDto); /* Update Status ApproverClass II Return */
		} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.FORWARD_TO_PVU)) { // Forward to PVU
			this.insertInwardTable(pvuWFWrapperDto);
		}
		if (pvuWFWrapperDto.getAssignByWfRoleId() == Constant.AUDITOR
				|| Objects.equals(pvuWFWrapperDto.getAssignByWfRoleId(), Constant.VERIFIER)
				|| pvuWFWrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_TWO
				|| pvuWFWrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_ONE) {
			this.insertRemarksITR(pvuWFWrapperDto.getTrnId());
		}
	}

	/**
	 * Update for rejected.
	 *
	 * @param pvuWFWrapperDto    the pvu WF wrapper dto
	 * @param pvuShettyPayEntity the pvu shetty pay entity
	 * @param approvedDate       the approved date
	 */
	private void updateForRejected(PvuWFWrapperDto pvuWFWrapperDto, PVUEmployeShettyPayEntity pvuShettyPayEntity,
			Date approvedDate) {
		EDPLuLookUpInfoEntity empRejectStatsLookupInfo = getLookupByName(Constant.STATUS_ID, Constant.REJECTED);
		repository.updateStatusId(empRejectStatsLookupInfo.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), approvedDate);
		updateEmpEventStatusReset(pvuShettyPayEntity);
	}

	private void updateForAuthorised(PvuWFWrapperDto pvuWFWrapperDto, Date approvedDate,
			PVUEmployeShettyPayEntity pvuShettyPayEntity) {
		String authorizerRemark;
		if (pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)) {
			authorizerRemark = pvuShettyPayEntity.getClassTwoRemarks();
		} else {
			authorizerRemark = pvuShettyPayEntity.getClassOneRemarks();
		}

		EDPLuLookUpInfoEntity authorizationStatus = getLookupByName(Constant.RECOMMENDATION_FOR, Constant.AUTHORIZE);
		repository.updateStatusIdAndAuthorizer(authorizationStatus.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), approvedDate, LocalDateTime.now(),
				Long.parseLong(securityUtil.decrypt(pvuWFWrapperDto.getAssignByUserId())), authorizerRemark,
				getUpdatedPaybandValue(pvuShettyPayEntity));
		pvuInwardRepository.setAuthDate(pvuWFWrapperDto.getTrnId(), PvuConstant.SHETTY_PAY_PVU_EVENT_ID,
				OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(), Constant.ACTIVE_STATUS);
	}

	private static long getUpdatedPaybandValue(PVUEmployeShettyPayEntity pvuShettyPayEntity) {
		if (pvuShettyPayEntity.getPayBandValue() == null)
			return 0L;

		int payband = (pvuShettyPayEntity.getPayBandValue().intValue());
		int gradePay = Integer.parseInt(pvuShettyPayEntity.getGradePay().getGradePayValue());
		long updatedPayBand = (long) (Math.ceil((payband + gradePay) * 0.03) / 10) * 10 + 10;
		return payband + updatedPayBand;
	}

	/**
	 * Update for approver.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 */
	private void updateForReturnByApprover(PvuWFWrapperDto pvuWFWrapperDto) {
		/* Unlock event */
		EDPLuLookUpInfoEntity returnStatus = getLookupByName(Constant.RECOMMENDATION_FOR, Constant.RETURN);
		repository.updateStatusId(returnStatus.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date());
		pvuInwardRepository.setReturnDateAndFlag(pvuWFWrapperDto.getTrnId(), PvuConstant.SHETTY_PAY_PVU_EVENT_ID,
				OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(), Constant.OUTWARD_FLAG_ONE,
				Constant.ACTIVE_STATUS);

	}

	/**
	 * Gets the lookup by name.
	 *
	 * @param lookupType the lookup type
	 * @param lkpName    the lkp name
	 * @return the lookup by name
	 */
	private EDPLuLookUpInfoEntity getLookupByName(String lookupType, String lkpName) {
		return lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(lookupType,
				Constant.ACTIVE_STATUS, lkpName);
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
		map.put(Constant.IN_EVENT_CODE, EVENT_CODE_SHETTY_PAY);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_INWARD_INSERT)); // SP
		repository.callStoredProcedure(procName, map);

	}

	/**
	 * Update emp event status.
	 *
	 * @param find the find
	 */
	private void updateEmpEventStatusReset(PVUEmployeShettyPayEntity find) {
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntity;
		pvuEmployeeEventStatusEntity = pvuEmployeeEventStatusService.findByEmpId(find.getEmpId().getEmpId());
		if (pvuEmployeeEventStatusEntity.isPresent()) {
			pvuEmployeeEventStatusEntity.get().setShettyPay(0);
			pvuEmployeeEventStatusEntity.get().setTransId(null);
			pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity.get());
		}
	}

	/**
	 * Insert SP in IT rs.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 */
	private void insertSPInITRs(PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_WORKFLOW_ROLE_ID, pvuWFWrapperDto.getAssignToWfRoleId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_SP_EVNT_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * Gets the PVU office name.
	 *
	 * @param idDto the id dto
	 * @return the PVU office name
	 */
	@Override
	public EDPMsOfficeDto getPVUOfficeName(IdDto idDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("eventId", idDto.getId());
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getSHPEmployeeOfficeId(), map);
		if (!Utils.isEmpty(objects)) {
			EDPMsOfficeDto officeDto = new EDPMsOfficeDto();
			officeDto.setOfficeName(String.valueOf(objects.get(0)[0]));
			return officeDto;
		}
		return null;
	}

	/**
	 * Delete SP events details.
	 *
	 * @param stEventId      the st event id
	 * @param inactiveStatus the inactive status
	 * @throws CustomException the custom exception
	 */
	@Override
	public boolean deleteSPEventsDetails(IdDto idDto) throws CustomException {
		try {
			Optional<PVUEmployeShettyPayEntity> spEntity = repository.findById(idDto.getId());
			if (spEntity.isPresent()) {
				PVUEmployeShettyPayEntity entity = spEntity.get();
				EDPLuLookUpInfoEntity saveAsDraft = lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
				if (entity.getStatusId().getLookUpInfoId() == saveAsDraft.getLookUpInfoId()) {
					repository.deleteShettyPayByEventId(Constant.IN_ACTIVE_STATUS, idDto.getId(),
							OAuthUtility.getCurrentUserUserId(), new Date());
					return Boolean.TRUE;
				} else {
					throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
				}
			}
			return Boolean.FALSE;

		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE_ACTIVESTATUS);
		}
	}

	/**
	 * Builds the page in map inward list.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	private Map<String, Object> buildPageInMapInwardList(PageDetails pageDetail) {
		Map<String, String> collect = getInwardSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	/**
	 * Gets the inward search fields.
	 *
	 * @return the inward search fields
	 */
	public List<PVUSearchEnum> getInwardSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO, PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_PAN,
				PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_FIELD_INW_NO,
				PVUSearchEnum.PVU_SEARCH_CARDEX, PVUSearchEnum.PVU_SEARCH_DDO,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS, PVUSearchEnum.SEARCH_FIELD_IN_POU_ID);

	}

	/**
	 * Gets the shetty pay inward list.
	 *
	 * @param pageDetail the page detail
	 * @return the shetty pay inward list
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUShettyPayInwardView> getShettyPayInwardList(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapInwardList(pageDetail);
			map.put(Constant.IN_EVENT_CODE, EVENT_CODE_SHETTY_PAY);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_INWARD_LIST_WF).toString();
			List<PVUShettyPayInwardView> objStorePro = this.storeProcPvu(procName, map, PVUShettyPayInwardView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Store proc pvu.
	 *
	 * @param <T>      the generic type
	 * @param procName the proc name
	 * @param map      the map
	 * @param view     the view
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private <T> List<T> storeProcPvu(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, view) : Collections.emptyList();
	}

	/**
	 * Generate inward number.
	 *
	 * @param dtos the dtos
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	public Boolean generateInwardNumber(List<IdDto> dtos) throws CustomException {
		try {

			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
			dtos.forEach(dto -> {
				Map<Integer, Object> map = new HashMap<>();
				map.put(1, Constant.STP);
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

	/**
	 * Submit shetty pay inward.and Distributor as well
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackOn = CustomException.class)
	public Boolean submitShettyPayInwardOrDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Gets the SP auditor search list.
	 *
	 * @param pageDetail the page detail
	 * @return the SP auditor search list
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUShettyPayPVUOfficeSearchDto> getSPAuditorSearchList(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapList(pageDetail, getPvuSPSearchFields());
			StringBuilder procName = new StringBuilder();
			procName.append(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.COMMON_FIVE_EVENT_LIST_SEARCH_WF_PVU);

			List<PVUShettyPayPVUOfficeSearchDto> objStorePro = this.storeProcPvu(procName.toString(), map,
					PVUShettyPayPVUOfficeSearchDto.class);
			if (!Utils.isEmpty(objStorePro)) {
				objStorePro.forEach(e -> e.setEventCode(EVENT_CODE_SHETTY_PAY));
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
			}
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, 0, Collections.emptyList());
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the pvu SP search fields.
	 *
	 * @return the pvu SP search fields
	 */
	private List<PVUSearchEnum> getPvuSPSearchFields() {
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
	 * Builds the page in map list.
	 *
	 * @param pageDetail   the page detail
	 * @param lstPVUSearch the lst PVU search
	 * @return the map
	 */
	private Map<String, Object> buildPageInMapList(PageDetails pageDetail, List<PVUSearchEnum> lstPVUSearch) {
		Map<String, String> collect = lstPVUSearch.stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(new StringBuilder(), pageDetail, collect);
	}

	public void insertRemarksITR(Long transId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		map.put(Constant.IN_EVENT_CODE, EVENT_CODE_SHETTY_PAY);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.INSERT_PVU_EVNT_RMKS_ITR);
		repository.callStoredProcedure(procName.toString(), map);
	}

	@Override
	public PVUEmployeeShettyPayAuditViewDto getPVUResponse(IdDto dto) throws CustomException {
		PVUEmployeeShettyPayAuditViewDto viewDto = new PVUEmployeeShettyPayAuditViewDto();
		PVUEmployeShettyPayEntity pvuShettyPay = getShettyPayEvent(dto.getId());
		Map<String, Object> map = new HashMap<>();
		map.put(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getValue(), pvuShettyPay.getEmpId().getEmployeeCode());
		map.put(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getValue(), pvuShettyPay.getPayCommission().getLookUpInfoId());
		map.put(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getValue(),
				PvuUtils.getStrOfLocalDateInYMD(pvuShettyPay.getEventEffectiveDate()));
		map.put("IN_OFFICE_ID", pvuShettyPay.getOfficeId().getOfficeId());
		map.put("IN_PAGE_SIZE", 10);
		map.put("IN_PAGE_INDEX", 0);
		map.put("IN_EVENT_ID", 0);

		PVUCommonApiDto pvuCommonApiDto = pvuCommonService.getCommonDetailsBasedOnEventDate(map);
		viewDto.setCurrentDetails(converter.toPVUObjCommon(pvuCommonApiDto, pvuShettyPay));
		viewDto.setPostDetails(converter.toPVUObj(pvuShettyPay));
		return viewDto;
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
			PVUMsEventEntity msEvent = getShettyPayEventEntity();
			map.put(PvuConstant.SHP_EVENT_ID, msEvent.getId());
			map.put(PvuConstant.PVU_EVENT_ID, id);
			map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
			List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getShettyPayReturnRemarks(),
					map);
			return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PVUEventRemarksDto.class)
					: Collections.emptyList();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the wf code by shetty pay trn id.
	 *
	 * @param trnId the trn id
	 * @return the wf code by shetty pay trn id
	 */
	@Override
	public String getWfCodeByShettyPayTrnId(Long trnId) {
		return this.wfRepository.findWfRlCdByShettyPayTrnId(trnId, Constant.ACTIVE_STATUS);
	}

	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public PVUEmployeShettyPayDto updateSPRemarks(PVUEmployeShettyPayDto dto) throws CustomException {
		try {
			PVUEmployeShettyPayEntity entity = converter.updateSPRemarks(getShettyPayEvent(dto.getId()), dto);
			PVUEmployeShettyPayEntity updateEntity = saveOrUpdate(entity);
			if (!Utils.isEmpty(dto.getReturnReasons())) {

				String remarkType = PvuUtils.buildRemarkType(dto.getWfRoleId());
				boolean isReturnReason = false;
				if (((!Utils.isEmpty(dto.getAuditorReturnReason()))
						&& dto.getAuditorReturnReason() == Constant.RETURN_VAL)
						|| ((!Utils.isEmpty(dto.getClassTwoReturnReason()))
								&& dto.getClassTwoReturnReason() == Constant.RETURN_VAL)
						|| ((!Utils.isEmpty(dto.getClassTwoReturnReason()))
								&& dto.getClassOneReturnReason() == Constant.RETURN_VAL)) {
					isReturnReason = dto.getAuditorReturnReason() == Constant.RETURN_VAL
							|| dto.getClassTwoReturnReason() == Constant.RETURN_VAL;
				}
				if (isReturnReason) {
					saveEventRemarks(remarkType, dto);
				}
			}
			return converter.toDTO(updateEntity);
		} catch (CustomException ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE);
		}
	}

	private void saveEventRemarks(String remarkType, PVUEmployeShettyPayDto dto) throws CustomException {
		PVUMsEventEntity msEvent = getShettyPayEventEntity();
		eventRemarksService.deactiveOldReason(msEvent.getId(), dto.getId(), Constant.IN_ACTIVE_STATUS);
		List<PVUEventRemarksEntity> lstEventRemarks = dto.getReturnReasons().stream().map(remarkDto -> {
			PVUEventRemarksEntity pvuEventRemarksEntity = new PVUEventRemarksEntity();
			pvuEventRemarksEntity.setEventID(msEvent.getId());
			pvuEventRemarksEntity.setTrnNo(dto.getId());
			pvuEventRemarksEntity.setWfRoleId(dto.getWfRoleId());
			pvuEventRemarksEntity.setEmpId(dto.getEmployeeId());
			pvuEventRemarksEntity.setRemarks(remarkDto.getRemarks());
			pvuEventRemarksEntity.setRemarksType(remarkType);
			pvuEventRemarksEntity.setReason(remarkDto.getReasonId());
			pvuEventRemarksEntity.setActiveStatus(Constant.ACTIVE_STATUS);
			return pvuEventRemarksEntity;
		}).collect(Collectors.toList());
		eventRemarksService.saveOrUpdateRemarksAll(lstEventRemarks);
	}

	private PVUMsEventEntity getShettyPayEventEntity() throws CustomException {
		Optional<PVUMsEventEntity> msEvent = msRepository.findByEventCode(EVENT_CODE_SHETTY_PAY);
		if (!msEvent.isPresent())
			throw new CustomException(1008, "Shetty pay event not found");
		return msEvent.get();
	}

	/**
	 * Gets the SP outward list.
	 *
	 * @param pageDetail the page detail
	 * @return the SP outward list
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUShettyPayOutwardView> getSPOutwardList(PageDetails pageDetail) throws CustomException {

		try {
			Map<String, Object> map = buildPageInMaps(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_OUTWARD_LIST_WF).toString();
			List<PVUShettyPayOutwardView> objStorePro = this.storeProcPvu(procName, map, PVUShettyPayOutwardView.class);
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
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_INW_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_OUTWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_OUTWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_OUTWARD_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_IN_STATUS, PVUSearchEnum.PVU_SEARCH_FIELD_IN_APPROVER_POU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_PAN,
				PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX, PVUSearchEnum.PVU_SEARCH_DDO,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO,
				PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE, PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS,
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
				map.put(1, Constant.STP);
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
	@Transactional(rollbackOn = CustomException.class)
	public Boolean submitSPOutward(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException {
		try {
			wrapperDto.forEach(dto -> pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(),
					new Date(), PvuConstant.SHETTY_PAY_PVU_EVENT_ID, dto.getTrnId(), Constant.OUTWARD_FLAG_ZERO,
					Constant.ACTIVE_STATUS));
			wrapperDto.forEach(e -> inwardService.setConsignmentNumber(e.getTrnId(),
					PvuConstant.SHETTY_PAY_PVU_EVENT_ID, e.getPostConsignmentNumber()));

			List<PvuWFWrapperDto> authList = wrapperDto.stream()
					.filter(e -> Objects.nonNull(e.getStatus()) && e.getStatus().equalsIgnoreCase(Constant.AUTHORIZE))
					.collect(Collectors.toList());

			List<PvuWFWrapperDto> rWFlist = wrapperDto.stream()
					.filter(e -> Objects.nonNull(e.getStatus()) && e.getStatus().equalsIgnoreCase(Constant.RETURN))
					.collect(Collectors.toList());
			return (processReturnOutWards(rWFlist) && processAuthorizedOutWards(authList));

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	private boolean processReturnOutWards(List<PvuWFWrapperDto> rWFlist) throws CustomException {
		if (rWFlist.isEmpty())
			return true;
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.MENU_ID, rWFlist.get(0).getMenuId());
		map.put(PvuConstant.EVENT_ID, PvuConstant.SHETTY_PAY_PVU_EVENT_ID);
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

	private List<PvuWFWrapperDto> setDDOApprover(List<PvuWFWrapperDto> rWFlist, List<PVUWfTableInfo> tableList)
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

	private boolean processAuthorizedOutWards(List<PvuWFWrapperDto> authList) {
		if (authList.isEmpty())
			return true;
		authList.forEach(authDto -> {
			pvuInwardRepository.setAuthorizeDateAndFlag(authDto.getTrnId(), PvuConstant.SHETTY_PAY_PVU_EVENT_ID,
					OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(), Constant.OUTWARD_FLAG_ZERO,
					Constant.ACTIVE_STATUS);
			authorizeSP(authDto.getTrnId());
			PVUEmployeShettyPayEntity entity = getShettyPayEvent(authDto.getTrnId());
			insertSPAutoIncr(entity.getTrnNo());
			updateEmpEventStatusReset(getShettyPayEvent(authDto.getTrnId()));
		});
		authList.forEach(e -> e.setWfStatus(PvuConstant.AUTHORIZED));
		return pvuFacade.callWorkFlowApis(authList);
	}

	private void authorizeSP(Long trnId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnId);
		map.put(Constant.IN_EVENT_CODE, PvuConstant.EVENT_CODE_SHETTY_PAY);
		repository.callStoredProcedure(
				Constant.PVU_SCHEMA.concat(Constant.DOT).concat(PvuConstant.PVU_COMMON_AUTHORIZED_SP), map);
	}

	private void insertSPAutoIncr(String trnNo) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		map.put(Constant.IN_EVNT_CODE, PvuConstant.EVENT_CODE_SHETTY_PAY);
		repository.callStoredProcedure(Constant.PVU_SCHEMA.concat(Constant.DOT).concat(PvuConstant.P_PVU_AUTO_INCR),
				map);
	}

	/**
	 * Gets the SP print endorsements.
	 *
	 * @param pageDetail the page detail
	 * @return the SP print endorsements
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUSPPrintEndorsementView> getSPPrintEndorsements(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPagesInMap(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF).toString();
			List<PVUSPPrintEndorsementView> objList = this.storeProcPvu(procName, map, PVUSPPrintEndorsementView.class);
			if (!Utils.isEmpty(objList)) {
				objList.forEach(e -> e.setEventCode(PvuConstant.EVENT_CODE_SHETTY_PAY));
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, objList.size(), objList);
			}
			int totalPages = objList.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objList);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Builds the pages in map.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	private Map<String, Object> buildPagesInMap(PageDetails pageDetail) {
		Map<String, String> collect = getPrintSPSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	/**
	 * Gets the prints the SP search fields.
	 *
	 * @return the prints the SP search fields
	 */
	private List<PVUSearchEnum> getPrintSPSearchFields() {
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

	@Override
	public String generatePrintEndorsement(PvuPrintStickerReportDto dto) throws CustomException {
		try {
			return generatePdf(Arrays.asList(dto));
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CustomException(1008, "Error occured while generating file");
		}
	}

	/**
	 * Generate print endorsement.
	 *
	 * @param dto the dto
	 * @return the http entity
	 * @throws CustomException the custom exception
	 */
	@Override
	public String generatePrintEndorsement(List<PvuPrintStickerReportDto> dto) throws CustomException {
		try {
			return generatePdf(dto);
		} catch (Exception e) {
			throw new CustomException(1008, "Error occured while generating file");
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
	private PVUStickerDTO submitPrintHistory(PvuPrintStickerReportDto dto) throws CustomException {
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

	/**
	 * Submit PEWF.
	 *
	 * @param dto        the dto
	 * @param pvuRopView the pvu rop view
	 * @return the PVU rop print endorsement dto
	 * @throws CustomException the custom exception
	 */

	private PVUPrintEndorsementDto submitPrintWF(PvuPrintStickerReportDto dto) throws CustomException {
		PVUPrintEndorsementEntity printEntity = null;
		try {
			if (dto.getPrintEndorsementDto() != null) {
				printEntity = printRepository.findOneByTrnIdAndEventIdAndActiveStatus(
						dto.getPvuWFWrapperDto().getTrnId(), PvuConstant.SHETTY_PAY_PVU_EVENT_ID,
						Constant.ACTIVE_STATUS);
				if (printEntity != null) {
					printEntity.setReprintDate(new Date());
					printEntity.setPrintCnt(printEntity.getPrintCnt() + 1l);
				} else {
					printEntity = new PVUPrintEndorsementEntity();
					/** For authorized case, and final reflection done by this */
					dto.getPvuWFWrapperDto().setEventId(PvuConstant.SHETTY_PAY_PVU_EVENT_ID);
					Boolean result = pvuFacade.callWorkFlowApis(dto.getPvuWFWrapperDto());
					if (result.equals(Boolean.TRUE)) {
						pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
								PvuConstant.SHETTY_PAY_PVU_EVENT_ID, dto.getPvuWFWrapperDto().getTrnId(),
								Constant.OUTWARD_FLAG_ONE, Constant.ACTIVE_STATUS);
						printEntity.setPrintCnt((dto.getPrintEndorsementDto().getPrintCnt() + 1l));
						printEntity.setPrintDate(new Date());
						printEntity.setEventId(PvuConstant.SHETTY_PAY_PVU_EVENT_ID);
						printEntity.setTrnId(dto.getPrintEndorsementDto().getTrnId());

					}
				}
				printEntity.setPrintDocType(dto.getPrintEndorsementDto().getPrintDocType());
				printEntity.setRemark(dto.getPrintEndorsementDto().getRemark());
				printEntity.setPrintDocType(dto.getPrintEndorsementDto().getPrintDocType());
				printEntity = printRepository.save(printEntity);
				PVUPrintEndorsementItrEntity itrEntity = printItrConverter.toEntity(printEntity);
				printItrRepository.save(itrEntity);
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CustomException(1008, "Error occured while performing submit print workflow.");
		}
		return printEntity != null ? converter.toDTO(printEntity) : null;
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
		map.put(PvuConstant.EVENT_ID, PvuConstant.SHETTY_PAY_PVU_EVENT_ID);
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getCommonEndorsementHistory(),
				map);
		return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PrintEndorsementRemarkHistoryDto.class)
				: Collections.emptyList();
	}

	/**
	 * Generate shetty pay pdf.
	 *
	 * @param dto the dto
	 * @return the string writer
	 * @throws CustomException the custom exception
	 */
	private StringWriter generateShettyPayPdf(PvuPrintStickerReportDto dto, PVUEmployeShettyPayEntity spentity)
			throws CustomException {

		PVUStickerDTO stickerDTO = null;
		try {
			stickerDTO = submitPrintHistory(dto);
			/* create a context and add data */

			VelocityContext context = populateVContext(stickerDTO, spentity);
			StringWriter writer = new StringWriter();
			Template template = getPrintTemplate(spentity.getPayCommission().getLookUpInfoId());
			template.merge(context, writer);
			return writer;
		} catch (CustomException e) {
			throw new CustomException(1008, "Error occured while reading content for file.");
		}
	}

	/**
	 * Populate V context.
	 *
	 * @param stickerDTO the sticker DTO
	 * @param spDto      the sp dto
	 * @return the velocity context
	 */
	private VelocityContext populateVContext(PVUStickerDTO stickerDTO, PVUEmployeShettyPayEntity spentity) {
		VelocityContext context = new VelocityContext();
		context.put("employeeno", stickerDTO.getEmployeeNo()); // Employee Number
		context.put("employeeName", stickerDTO.getEmployeeName()); // Department Name
		context.put("designation", stickerDTO.getDesignation());
		context.put("officeName", stickerDTO.getOfficeName());
		context.put("effectiveDate", PvuUtils.getStrOfLocalDateInDMY(spentity.getEventEffectiveDate()));
		context.put("nextIncDate", PvuUtils.getStrOfLocalDateInDMY(spentity.getDateOfNextIncrement()));
		context.put("endorsementPrintDate",
				PvuUtils.getDateToStringDMYFormatValue(stickerDTO.getEndorsementPrintDate()));
		context.put("cellIdValue", stickerDTO.getCellValue());
		context.put("levelValue", stickerDTO.getLevelValue());

		context.put("authBy",
				spentity.getAuthorizeBy() != null ? authService.getOnlyIdAndName(spentity.getAuthorizeBy()).getName()
						: "");
		context.put("salutation", spentity.getEmpId().getSalutation() == null ? ""
				: getSalutationName(spentity.getEmpId().getSalutation().getLookUpInfoId()));
		context.put("firstName", spentity.getEmpId().getEmployeeName());
		context.put("middleName", getName(spentity.getEmpId().getEmployeeMiddleName()));
		context.put("surname", getName(spentity.getEmpId().getEmployeeSurname()));
		context.put("designation", stickerDTO.getDesignation());
		context.put("officeName", stickerDTO.getOfficeName() + " " + stickerDTO.getOfficeAddress());
		context.put("remark", spentity.getAuthorizerRemark() != null ? spentity.getAuthorizerRemark() : "");
		populatePayDetail(context, spentity);
		return populateReprintDetail(context, stickerDTO);
	}

	private String getName(String name) {
		if (name == null || name.equals("0"))
			return "";
		else
			return name;
	}

	/**
	 * Gets the salutation name.
	 *
	 * @param lkInfoId the lk info id
	 * @return the salutation name
	 */
	private String getSalutationName(Long lkInfoId) {
		EDPLuLookUpInfoEntity saluationLKEntity = lookupinforepository.findBylookUpInfoId(lkInfoId);
		return saluationLKEntity != null ? saluationLKEntity.getLookUpInfoName() : "";
	}

	/**
	 * Populate reprint detail.
	 *
	 * @param context    the context
	 * @param stickerDTO the sticker DTO
	 * @return the velocity context
	 */
	private VelocityContext populateReprintDetail(VelocityContext context, PVUStickerDTO stickerDTO) {
		if (stickerDTO.getEndorsementReprintDate() != null) {
			context.put("endorsementReprintDateLabel", "Reprint Date: ");
			context.put("endorsementReprintCountLabel", "Reprint Count: ");
			context.put("endorsementReprintRemarkLabel", "Reprint Remarks: ");
			context.put("endorsementReprintDate",
					PvuUtils.getDateToStringDMYFormatValue(stickerDTO.getEndorsementReprintDate()));
			context.put("endorsementReprintCount",
					(stickerDTO.getRePrintCount() != null && stickerDTO.getRePrintCount() > 1)
							? stickerDTO.getRePrintCount() - 1
							: stickerDTO.getRePrintCount());
			context.put("endorsementReprintRemark", stickerDTO.getRePrintRemark());
		} else {
			context.put("endorsementReprintDateLabel", "");
			context.put("endorsementReprintCountLabel", "");
			context.put("endorsementReprintRemarkLabel", "");
			context.put("endorsementReprintDate", "");
			context.put("endorsementReprintCount", "");
			context.put("endorsementReprintRemark", "");

		}
		return context;
	}

	/**
	 * Populate pay detail.
	 *
	 * @param context  the context
	 * @param spentity the spentity
	 * @return the velocity context
	 */
	private VelocityContext populatePayDetail(VelocityContext context, PVUEmployeShettyPayEntity spentity) {
		if (spentity.getEmpId().getGender().getLookUpInfoId() == PvuConstant.EMP_GENDER_FEMALE_ID) {
			context.put("gender", "her");
		} else {
			context.put("gender", "his");
		}
		if (spentity.getPayCommission().getLookUpInfoId() == PvuConstant.PREM_FIFTH_COMMISSION_ID) {
			context.put("last5thPayCommissionScale", spentity.getcPayScale().getPayScaleDispVal());
			context.put("last5thPayCommissionBasic", spentity.getBasicPay());
		} else {
			context.put("last6thPayBand", spentity.getPayBandValue());
			context.put("last6thPayBandValue", spentity.getPayBandValue());
			context.put("last6thPayGradePay", spentity.getcGradePayId().getGradePayValue());
		}
		return context;
	}

	/**
	 * Gets the prints the template.
	 *
	 * @param paycomm the paycomm
	 * @return the prints the template
	 */
	private Template getPrintTemplate(Long paycomm) {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.init();
		if (paycomm.equals(PvuConstant.FIFTH_COMMISSION_ID)) {
			return velocityEngine.getTemplate("templates/shetty_pay_5thpay.vm");
		} else {
			return velocityEngine.getTemplate("templates/shetty_pay_6thpay.vm");
		}

	}

	/**
	 * Generate pdf.
	 *
	 * @param dto the dto
	 * @return the http entity
	 * @throws CustomException the custom exception
	 */
	private String generatePdf(List<PvuPrintStickerReportDto> dto) throws CustomException {
		int count = 1;
		Document document = new Document();
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
			document.addTitle("Shetty Pay");
			document.setPageSize(PageSize.LETTER);
			PdfWriter pdfWriter = PdfWriter.getInstance(document, baos);

			document.open();
			for (PvuPrintStickerReportDto printStickerReportDto : dto) {
				
				PVUEmployeShettyPayEntity spentity = getEmployeShettyPay(
						printStickerReportDto.getPvuWFWrapperDto().getTrnId());
				if (spentity.getOfficeId().getOfficeId().equals(spentity.getOfficeId().getPvuId())
						&& spentity.getOfficeId().getOfficeId() != Constant.PVU_OFFICE_ID) {
					watermark = ", Self PVU";
				} else {
					watermark = ", PVU, Gandhinagar";
				}
				pdfWriter.setPageEvent(new WatermarkPageEvent(
						new SimpleDateFormat(PvuConstant.PRINT_DATE_FORMAT).format(new Date()), watermark));
				writer.write(generateShettyPayPdf(printStickerReportDto, spentity).toString());
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
	 * Update for pulled back.
	 *
	 * @param pvuWFWrapperDto    the pvu WF wrapper dto
	 * @param pvuShettyPayEntity the pvu shetty pay entity
	 */
	private void updateForPulledBack(PvuWFWrapperDto pvuWFWrapperDto, PVUEmployeShettyPayEntity pvuShettyPayEntity) {
		inwardService.updateStatusId(Constant.INACTIVE_STATUS, pvuShettyPayEntity.getId(), new Date(),
				pvuWFWrapperDto.getEventId());
	}

	/**
	 * Gets the approved date.
	 *
	 * @return the approved date
	 */
	private Date getApprovedDate() {
		return new Date();
	}
}
