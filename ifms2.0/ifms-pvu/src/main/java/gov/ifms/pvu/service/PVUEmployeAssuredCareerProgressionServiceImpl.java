package gov.ifms.pvu.service;

import static gov.ifms.pvu.entity.PVUEmployeEventsEntity.distinctByKey;
import static java.time.temporal.ChronoUnit.DAYS;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
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
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUEmployeAssuredCareerProgressionConverter;
import gov.ifms.pvu.converter.PVUPrintEndorsementItrConverter;
import gov.ifms.pvu.dto.AcpEmployeeDetailDto;
import gov.ifms.pvu.dto.PVUACPDetailRequest;
import gov.ifms.pvu.dto.PVUACPOutwardView;
import gov.ifms.pvu.dto.PVUAcpInwardView;
import gov.ifms.pvu.dto.PVUAcpPayOfficeSearchView;
import gov.ifms.pvu.dto.PVUEmpACPEditListView;
import gov.ifms.pvu.dto.PVUEmployeAssuredCareerProgressionDto;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementView;
import gov.ifms.pvu.dto.PVUSourceUserDetails;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.PVUWfTableInfo;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuSixthPayCommissionResponse;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.PvusixthPayCommissionRequest;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUEmployeAssuredCareerProgressionEntity;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeSuspensionEntity;
import gov.ifms.pvu.entity.PVUEmployeeEOLeaveEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.repository.PVUEmployeAssuredCareerProgressionRepository;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVUEventRemarksRepository;
import gov.ifms.pvu.repository.PVUInwardRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.util.WatermarkPageEvent;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;

@Service
public class PVUEmployeAssuredCareerProgressionServiceImpl implements PVUEmployeAssuredCareerProgressionService {

	/**
	 * The logger.
	 */
	private Logger logger = LoggerFactory.getLogger(PVUEmployeAssuredCareerProgressionServiceImpl.class.getName());

	/**
	 * The PVUEmployeAssuredCareerProgressionAsMethodName repository.
	 */
	@Autowired
	private PVUEmployeAssuredCareerProgressionRepository repository;

	/**
	 * The PVUEmployeAssuredCareerProgressionAsMethodName helper.
	 */
	@Autowired
	private PVUEmployeAssuredCareerProgressionConverter converter;

	@Autowired
	PVUPrintEndorsementRepository printRepository;

	@Autowired
	private PVUEmployeDepartmentRepository pvuEmployeeDepartmentRepo;

	@Autowired
	private PVUInwardRepository pvuInwardRepository;

	@Autowired
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Autowired
	private PVUEmployeeEOLeaveService eoLeaveService;

	@Autowired
	private PVUEmployeSuspensionService suspensionService;

	@Autowired
	private PVUEmployeEventsService eventsService;

	@Autowired
	private PVUCommonService pvuCommonService;

	@Autowired
	private PVYFacade pvuFacade;

	@Autowired
	private PVUInwardService inwardService;

	@Autowired
	private PVUPrintEndorsementItrRepository pvuPrintEndorsementItrRepository;

	/**
	 * The pvu acp remarks service.
	 */

	@Autowired
	private PVUEventRemarksService remarkService;

	@Autowired
	private WfRepository wfRepository;

	@Autowired
	private PVUMsReasonService pvuMsReasonService;

	@Autowired
	private OAuthService authService;

	@Autowired
	private PVUEventRemarksRepository remarksRepository;

	@Autowired
	private PVUPrintEndorsementRepository pvuPrintEndorsementRepository;

	@Autowired
	private PVUPrintEndorsementItrConverter pvuPrintEndorsementItrConverter;

	@Autowired
	private EncryptDecryptUtil securityUtil;

	@Autowired
	private PVUEmployePayDetailService empPayDetailService;

	@Autowired
	private PVUEmployeRepository pvuEmployeRepository;

	/**
	 *
	 * @param id
	 * @return
	 */
	@Override
	public PVUEmployeAssuredCareerProgressionEntity getEmployeAssuredCareerProgression(Long id) {
		logger.info("getEmployeAssuredCareerProgression Method ===== ID ===={}", id);
		return repository.findOneById(id);
	}

	/**
	 *
	 * @param entity
	 * @return
	 */
	@Override
	public PVUEmployeAssuredCareerProgressionEntity saveOrUpdateEmployeAssuredCareerProgression(
			PVUEmployeAssuredCareerProgressionDto dto) throws CustomException {

		logger.info("saveOrUpdateEmployeAssuredCareerProgression   Method ===== Status Id ====  {}", dto.getStatusId());

		if (dto.getStatusId() == 0) {
			pvuEmployeeEventStatusService.inProgressSuspensionEvent(dto.getEmployeeId());
			EDPLuLookUpInfoEntity saveAsDraft = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.SAVE_AS_DRAFT);
			dto.setStatusId(saveAsDraft.getLookUpInfoId());
		}
		PVUEmployeAssuredCareerProgressionEntity assuredCareerProgressionEntity = this.converter.toEntity(dto);

		return repository.save(assuredCareerProgressionEntity);
	}

	/**
	 *
	 * @param pageDetail
	 * @return
	 * @throws CustomException
	 */
	@Override
	public PagebleDTO<PVUEmployeAssuredCareerProgressionDto> getEmployeAssuredCareerProgressions(PageDetails pageDetail)
			throws CustomException {

		logger.info("getEmployeAssuredCareerProgressions   Method =========  {}", pageDetail.getJsonArr().size());

		try {
			PageRequest pageable = pageDetail.getPageDetails(pageDetail);
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmployeAssuredCareerProgressionEntity> spec = new SpecificationImpl<>();
			Specification<PVUEmployeAssuredCareerProgressionEntity> dataSpec = searchCriteria
					.getSpecificationDetails(spec, pageDetail.getJsonArr());
			Page<PVUEmployeAssuredCareerProgressionEntity> page = repository.findAll(dataSpec, pageable);
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 *
	 * @return
	 * @throws CustomException
	 */
	@Override
	public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException {

		logger.info("getAllLuLookUpInfoAsMap   Method  START =========");

		try {
			String procName = Constant.PVU_SCHEMA
					.concat(Constant.DOT.concat(PvuConstant.PVU_EMP_ASS_CAR_PROG_LOOKUP_SP));
			List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupEmployeeAcpSp(procName);
			return lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));

		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 *
	 * @param procName
	 * @return
	 * @throws CustomException
	 */
	private List<PVUEmployeCreationDDLView> lookupEmployeeAcpSp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, Collections.emptyMap());
		return !Utils.isEmpty(objectPvuSp) ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	/**
	 *
	 * @param acpEmployeeDetailRequest
	 * @return
	 * @throws CustomException
	 * @throws ParseException
	 */
	@Override
	public AcpEmployeeDetailDto getAcpEmployeeDetails(PVUACPDetailRequest acpEmployeeDetailRequest)
			throws CustomException, ParseException {
		logger.info("getAcpEmployeeDetails   Method  START =========");
		logger.info("getAcpEmployeeDetails   Method   ========= Employee Number {}",
				acpEmployeeDetailRequest.getEmpNo());
		AcpEmployeeDetailDto acpEmployeeDetailDto = null;
		if (Objects.nonNull(acpEmployeeDetailRequest.getEmpNo())) {
			PVUEmployeDepartmentEntity employeDepartmentEntity = pvuEmployeeDepartmentRepo
					.findFirstByPvuEmployeEntityEmployeeCode(acpEmployeeDetailRequest.getEmpNo())
					.orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
			Map<String, Object> map = buildAcpEmployeeRequestMap(acpEmployeeDetailRequest);
			StringBuilder procName = new StringBuilder();
			procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.ACP_EMPLOYEE_DETAIL);
			List<AcpEmployeeDetailDto> objStorePro = repository.storeProc(procName.toString(), map,
					AcpEmployeeDetailDto.class);
			// EOL and Suspension validation to ACP Effective Date START
			Optional<PVUEmployeDepartmentEntity> required = this.pvuEmployeeDepartmentRepo
					.findFirstByPvuEmployeEntityEmployeeCode(acpEmployeeDetailRequest.getEmpNo());
			if (required.isPresent()) {
				LocalDate eventDate = LocalDate.parse(acpEmployeeDetailRequest.getEffectiveDate());
				Long empId = required.get().getPvuEmployeEntity().getEmpId();
				pvuCommonService.validateBackDatedEffDateForEmpType(required.get(), eventDate);
				pvuCommonService.validateEOL(empId, eventDate);
				pvuCommonService.validateSuspension(empId, eventDate);
				validatePayCommision(empId, eventDate, acpEmployeeDetailRequest.getPayCommission(),
						required.get().getDateOfJoiningGOG(), acpEmployeeDetailRequest.getIsViewPage());
			}

			// EOL and Suspension validation to ACP Effective Date END

			if (objStorePro.isEmpty()) {

				if (acpEmployeeDetailRequest.getPayCommission().equals(PvuConstant.PREM_FIFTH_COMMISSION_ID)) {
					throw new CustomException(HttpStatus.BAD_REQUEST, "Employee's 5th salary details not available");
				} else if (acpEmployeeDetailRequest.getPayCommission().equals(PvuConstant.PREM_SIXTH_COMMISSION_ID)) {
					throw new CustomException(HttpStatus.BAD_REQUEST, "Employee's 6th salary details not available");
				}

			} else {
				acpEmployeeDetailDto = objStorePro.get(0);
				List<Object[]> objList = this.getAcpList(acpEmployeeDetailDto.getEmployeeId(),
						PvuConstant.ACP_TYPE_ONE);
				if (!objList.isEmpty() && PvuConstant.ACP_TYPE_TWO.equals(acpEmployeeDetailRequest.getAcpType())) {
					acpEmployeeDetailDto.setAcpEffDate((String.valueOf(objList.get(0)[1])));
				}
				// validation for ACP Type one or Two Once in Tenure
				this.validateACPTenure(acpEmployeeDetailDto.getEmployeeId(), acpEmployeeDetailRequest.getAcpType(),
						objList);
				validateEmployeeEligableForACP(employeDepartmentEntity, acpEmployeeDetailDto, acpEmployeeDetailRequest); // validations
			}

		}
		return acpEmployeeDetailDto;
	}

	private void validateACPTenure(String empNo, Long acpType, List<Object[]> objList) throws CustomException {
		if (PvuConstant.ACP_TYPE_ONE.equals((acpType)) && !objList.isEmpty()) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "ACP1 is already Done.");
		}
		if (PvuConstant.ACP_TYPE_TWO.equals(acpType) && (!this.getAcpList(empNo, acpType).isEmpty())) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "ACP2 is already Done.");
		}

	}

	/**
	 *
	 * @param acpEmployeeRequest
	 * @return
	 * 
	 */
	private Map<String, Object> buildAcpEmployeeRequestMap(PVUACPDetailRequest acpEmployeeRequest) {
		Map<String, Object> map = new HashMap<>();
		map.put("IN_PAGE_INDEX", String.valueOf(0));
		map.put("IN_PAGE_SIZE", String.valueOf(250));
		map.put(PvuConstant.IN_EFFECTIVE_DATE, acpEmployeeRequest.getEffectiveDate());
		map.put(PvuConstant.IN_EVENT_ID, String.valueOf(0));
		map.put(Constant.IN_EMPLOYEE_NO, acpEmployeeRequest.getEmpNo());
		map.put(PvuConstant.IN_OFFICE_ID, OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId().toString());
		map.put(PvuConstant.IN_PAY_COMM, acpEmployeeRequest.getPayCommission());
		return map;
	}

	/**
	 *
	 * @param employeDepartmentEntity
	 * @param acpEmployeeDetailDto
	 * @param acpEmployeeDetailRequest
	 * @throws CustomException
	 * @throws ParseException
	 * 
	 */
	private void validateEmployeeEligableForACP(PVUEmployeDepartmentEntity employeDepartmentEntity,
			AcpEmployeeDetailDto acpEmployeeDetailDto, PVUACPDetailRequest acpEmployeeDetailRequest)
			throws CustomException, ParseException {
		PVUEmployeEntity pvuEmployeEntity = pvuEmployeRepository
				.findByEmployeeCodeAndActiveStatus(Long.valueOf(acpEmployeeDetailDto.getEmployeeNo()),
						Constant.ACTIVE_STATUS)
				.orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
		if ((StringUtils.isNotEmpty(pvuEmployeEntity.getCaseNo())) && (!pvuEmployeEntity.getCaseNo().equals("0"))) {
			acpEmployeeDetailDto.setDateJoining(Objects.nonNull(employeDepartmentEntity.getFixPayDate())
					? employeDepartmentEntity.getFixPayDate().toString()
					: employeDepartmentEntity.getDateOfJoiningGOG().toString());
		} else if (Objects.nonNull(employeDepartmentEntity.getJoinEmpPayType()) && PvuConstant.ADHOC_BONDED_LOOKUP_ID
				.equals(employeDepartmentEntity.getJoinEmpPayType().getLookUpInfoId())) {
			acpEmployeeDetailDto.setDateJoining(Objects.nonNull(employeDepartmentEntity.getRegularConvDate())
					? employeDepartmentEntity.getRegularConvDate().toString()
					: employeDepartmentEntity.getDateOfJoiningGOG().toString());
		} else {
			acpEmployeeDetailDto.setDateJoining(employeDepartmentEntity.getDateOfJoiningGOG().toString());
		}
		int actualyear = calculateActualYears(acpEmployeeDetailDto, acpEmployeeDetailRequest);
		logger.info("validateEmployeeEligableForACP  ========= actualyear {}", actualyear);

		if (employeDepartmentEntity.getEmpPayType().getLookUpInfoId() != PvuConstant.REGULAR_PAY_TYPE_ID) {
			throw new CustomException(HttpStatus.BAD_REQUEST, MsgConstant.ACP_ERRORRESP_ONLY_REGULAR_EMPLOYEE);
		}
		if (employeDepartmentEntity.getDesignationId().getDesignationId().equals(PvuConstant.SENIOR_CIVIL_JUDGE)
				|| employeDepartmentEntity.getDesignationId().getDesignationId().equals(PvuConstant.CIVIL_JUDGE)
				|| employeDepartmentEntity.getDesignationId().getDesignationId().equals(PvuConstant.DISTRICT_JUDGE)) {
			logger.info("Employee Designation is {}", employeDepartmentEntity.getDesignationId());
		} else {
			throw new CustomException(HttpStatus.BAD_REQUEST, MsgConstant.ACP_ERRORRESP_ONLY_CIVIL_JUDGE);
		}
		if (acpEmployeeDetailDto.isSuspended()) {
			throw new CustomException(HttpStatus.BAD_REQUEST, Constant.ROP_CAN_NOT_BE_PERFORMED_ON_SUSPENDED_EMPLOYEE);
		}
		if (acpEmployeeDetailDto.getPayCommId() != null
				&& acpEmployeeDetailDto.getPayCommId().equals(PvuConstant.SEVENTH_COMMISSION_ID)) {
			throw new CustomException(HttpStatus.BAD_REQUEST, MsgConstant.ACP_ERRORRESP_SEVENTH_COMMISSION_NOT_ALLOWED);
		}
		if (acpEmployeeDetailDto.getOfficeId() != null && !acpEmployeeDetailDto.getOfficeId()
				.equals(OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId())) {
			throw new CustomException(HttpStatus.BAD_REQUEST, MessageFormat
					.format(MsgConstant.ERROR_EMPLOYEE_NOT_IN_OFFICE, acpEmployeeDetailDto.getEmployeeNo()));
		}
		if (Utils.isAfter(acpEmployeeDetailDto.getDateJoining(), acpEmployeeDetailRequest.getEffectiveDate())) {
			throw new CustomException(HttpStatus.CONFLICT,
					Constant.EVENT_EFFECTIVE_DATE_MUST_BE_GREATER_THAN_DATE_OF_JOINING);
		}
		if (acpEmployeeDetailDto.getDateJoining() == null || acpEmployeeDetailRequest.getEffectiveDate() == null) {
			throw new CustomException(1008, MsgConstant.ACP_ERRORRESP_DATE_NULL_NOT_ALLOWED);
		}
		if (Utils.isAfter(acpEmployeeDetailRequest.getEffectiveDate(), acpEmployeeDetailDto.getRetirementDate())) {
			throw new CustomException(HttpStatus.CONFLICT, Constant.EMPLOYEE_RETIRED);
		}
		checkEmpDesignatonValidation(employeDepartmentEntity, acpEmployeeDetailRequest, actualyear);
	}

	private void checkEmpDesignatonValidation(PVUEmployeDepartmentEntity employeDepartmentEntity,
			PVUACPDetailRequest acpEmployeeDetailRequest, int actualyear) throws CustomException {

		logger.info("checkEmpDesignatonValidation  ========= Method ");
		logger.info("checkEmpDesignatonValidation  ========= activeStatus {}",
				employeDepartmentEntity.getActiveStatus());
		logger.info("checkEmpDesignatonValidation  ========= employeeNo {}", acpEmployeeDetailRequest.getEmpNo());

		if (acpEmployeeDetailRequest.getAcpType().equals(PvuConstant.ACP_TYPE_ONE)
				&& actualyear < PvuConstant.FIVE_YEARS) {
			throw new CustomException(HttpStatus.CONFLICT,
					String.format(
							MsgConstant.ACP_EMPLOYEE_NO.concat(String.valueOf(acpEmployeeDetailRequest.getEmpNo()))
									.concat("   ").concat(MsgConstant.ACP_ERRORRESP_FIVE_YEARS)));
		}
		if (acpEmployeeDetailRequest.getAcpType().equals(PvuConstant.ACP_TYPE_TWO)
				&& actualyear < PvuConstant.TEN_YEARS) {
			throw new CustomException(HttpStatus.CONFLICT,
					String.format(
							MsgConstant.ACP_EMPLOYEE_NO.concat(String.valueOf(acpEmployeeDetailRequest.getEmpNo()))
									.concat("   ").concat(MsgConstant.ACP_ERRORRESP_TEN_YEARS)));
		}
	}

	private List<Object[]> getAcpList(String empId, Long acpType) {

		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.EMP_ID, empId);
		map.put("acpType", acpType);
		return repository.executeSQLQuery(PVUNativeSqlQueryConstant.returnAcpList(), map);
	}

	private int calculateActualYears(AcpEmployeeDetailDto acpEmployeeDetailDto,
			PVUACPDetailRequest acpEmployeeDetailRequest) throws ParseException, CustomException {
		SimpleDateFormat formatter = new SimpleDateFormat(PvuConstant.ACP_DATE_FORMAT);
		Date date = formatter.parse(acpEmployeeDetailDto.getDateJoining());
		LocalDate joiningDate = PvuUtils.convertLocalDate(date);
		LocalDate effectiveDate = LocalDate.parse(acpEmployeeDetailRequest.getEffectiveDate());
		long day = DAYS.between(joiningDate, effectiveDate);
		long countEolSuspension = checkEligibleForACP(joiningDate, effectiveDate,
				Long.valueOf(acpEmployeeDetailDto.getEmployeeId()));
		long actualDays = day - countEolSuspension;
		return (int) (actualDays / PvuConstant.YEAR_DAYS);
	}

	public Long checkEligibleForACP(LocalDate toLocalDate, LocalDate fromLocaldate, Long employeeId)
			throws CustomException {

		logger.info("checkEligibleForACP  ========= actualyear {}", employeeId);

		long countsus = 0;
		long counteol = 0;
		if (Objects.isNull(fromLocaldate)) {
			throw new CustomException(1008, "Effective date  should not be null");
		}
		List<PVUEmployeEventsEntity> eventExists = eventsService
				.getEventListFromEffectiveAndToEffectiveEventsIn(employeeId, toLocalDate, fromLocaldate,
						Arrays.asList(PvuConstant.EVENT_CODE_EOL, PvuConstant.EVENT_CODE_SUSPENSION))
				.stream().filter(distinctByKey(PVUEmployeEventsEntity::getTrnNo)).collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(eventExists)) {
			for (PVUEmployeEventsEntity eventExist : eventExists) {
				if (eventExist.getEventName().equalsIgnoreCase(PvuConstant.EVENT_CODE_EOL)) {
					PVUEmployeeEOLeaveEntity eol = this.eoLeaveService.getOneByTrnNo(eventExist.getTrnNo());
					counteol = counteol + eol.getNoOfDays();
				} else if (eventExist.getEventName().equalsIgnoreCase(PvuConstant.EVENT_CODE_SUSPENSION)) {
					PVUEmployeSuspensionEntity suspension = this.suspensionService.getOneByTrnNo(eventExist.getTrnNo());
					countsus = countsus + suspension.getNoOfDayInSus();
				}
			}
		}
		return countsus + counteol;
	}

	public PVUEmployeAssuredCareerProgressionEntity getEmployeeAcpById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(MsgConstant.RECORD_NOT_FOUND));
	}

	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public boolean deleteAcpTrns(IdDto idDto) throws CustomException {

		logger.info("deleteAcpTrns  ========= AssuredCareerProgression ID {}", idDto.getId());

		PVUEmployeAssuredCareerProgressionEntity tempEntity = repository.findOneById(idDto.getId());
		if (tempEntity != null) {
			EDPLuLookUpInfoEntity saveAsDraft = edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
			if (tempEntity.getStatusId().getLookUpInfoId() == saveAsDraft.getLookUpInfoId()) {
				repository.deleteACPEventIdBy(Constant.IN_ACTIVE_STATUS, idDto.getId(),
						OAuthUtility.getCurrentUserUserId(), new Date());
				if (tempEntity.getEmployeeNo() != null) {
					pvuEmployeeEventStatusService.resetInProgressEmployeeEventStatus(
							tempEntity.getEmployeeNo().getEmpId(), OAuthUtility.getCurrentUserLkPOUId());
				}
				return Boolean.TRUE;
			} else {
				throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public List<PvuSixthPayCommissionResponse> getSixthPayComissionScale(PvusixthPayCommissionRequest request)
			throws CustomException {
		List<PvuSixthPayCommissionResponse> scalValue = new LinkedList<>();
		try {
			String sixthPayComm = null;
			if (request.getCommissionId().equals(String.valueOf(PvuConstant.PREM_FIFTH_COMMISSION_ID))) {
				sixthPayComm = "6";
			}
			Map<String, Object> map = new HashMap<>();
			map.put("commisionId", sixthPayComm);
			map.put("deptId", request.getDeptCategoryId());
			StringBuilder sb = new StringBuilder();
			sb.append(
					" SELECT mps.PAY_SCALE_ID,mps.SCALE_VAL FROM MASTER_V1.MS_PAY_SCALE mps,MASTER_V1.MS_PAY_CONVERSION mpc ");
			sb.append(
					" WHERE mps.pay_scale_id = mpc.PAY_SCALE_6TH_ID AND mps.pay_comm = :commisionId AND mpc.dept_id = :deptId ORDER BY mps.SCALE_VAL ASC ");
			scalValue = repository.executeSQLQuery(sb.toString(), map, PvuSixthPayCommissionResponse.class);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return scalValue;
	}

	public PagebleDTO<PVUEmpACPEditListView> getACPDDOList(PageDetails pageDetail) throws CustomException {

		logger.info("getACPDDOList   Method   ========= pageDetail START ");

		Map<String, String> collect = this.getDdoWFListingSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(null, pageDetail, collect);
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ACP_PVU_EVENT_LIST_SRCH_WF));
		List<PVUEmpACPEditListView> list = this.callSSPVUDDOListing(sp, stringObjectMap);
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, list.size(), list);
	}

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

	private List<PVUEmpACPEditListView> callSSPVUDDOListing(String sp, Map<String, Object> parameters)
			throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(sp, parameters);
		return !Utils.isEmpty(objectPvuSp) ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmpACPEditListView.class)
				: Collections.emptyList();
	}

	@Override
	@ExceptionHandler
	@Transactional(rollbackOn = { CustomException.class })
	public PVUEmployeAssuredCareerProgressionDto insertACPItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {

		Date approvedDate = new Date();
		PVUEmployeAssuredCareerProgressionEntity assuredCareerProgressionEntity = repository
				.findOneById(pvuWFWrapperDto.getTrnId());
		if (assuredCareerProgressionEntity != null) {
			if (assuredCareerProgressionEntity.getTrnNo() == null) {
				PVUEmployeeEventStatusEntity statusEntry = pvuEmployeeEventStatusService
						.inProgressAnyEvent(assuredCareerProgressionEntity.getEmployeeNo().getEmpId());
				assuredCareerProgressionEntity.setTrnNo(this.pvuCommonService.getTransactionNumber(Constant.ACP));
				statusEntry.setAssuredCareerProg(Constant.ACTIVE_STATUS);
				assuredCareerProgressionEntity.setRefDate(LocalDateTime.now());
				repository.save(assuredCareerProgressionEntity);
				pvuEmployeeEventStatusService.updateEventInfo(statusEntry, assuredCareerProgressionEntity.getTrnNo());
			}
			EDPLuLookUpInfoEntity empApprovStatsLookupInfo = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.APPROVED);
			PVUEmployeAssuredCareerProgressionDto assuredCareerProgressionDto = null;
			if (assuredCareerProgressionEntity.getStatusId() != null) {
				if (pvuFacade.callWorkFlowApis(pvuWFWrapperDto)) {
					EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = edpLuLookUpInfoRepository
							.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
									Constant.ACTIVE_STATUS, Constant.SUBMIT);
					if (empSubmitStatusLookupInfo != null) {
						repository.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(),
								pvuWFWrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), approvedDate);
					}
					assuredCareerProgressionDto = converter.toDTO(assuredCareerProgressionEntity);
					checkApprovedOrRejected(pvuWFWrapperDto, approvedDate, assuredCareerProgressionEntity,
							empApprovStatsLookupInfo, assuredCareerProgressionDto);
					checkPVUOfficeWorkflow(pvuWFWrapperDto, approvedDate, assuredCareerProgressionEntity);
					addAcpRemarksforAuditor(pvuWFWrapperDto);
					insertACPInITRs(pvuWFWrapperDto);
				}
				return assuredCareerProgressionDto;
			} else {
				throw new CustomException(HttpStatus.CONFLICT, MsgConstant.TRN_ALREADY_APPROVED);
			}
		} else {
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		}
	}

	private void addAcpRemarksforAuditor(PvuWFWrapperDto pvuWFWrapperDto) {

		logger.info("checkApprovedOrRejected  Method START=========  getAssignByWfRoleId ===  {}",
				pvuWFWrapperDto.getAssignByWfRoleId());

		if (pvuWFWrapperDto.getAssignByWfRoleId() == Constant.AUDITOR
				|| Objects.equals(pvuWFWrapperDto.getAssignByWfRoleId(), Constant.VERIFIER)
				|| pvuWFWrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_TWO
				|| pvuWFWrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_ONE) {
			this.insertACPRemarks(pvuWFWrapperDto.getTrnId());
		}
	}

	private void checkPVUOfficeWorkflow(PvuWFWrapperDto pvuWFWrapperDto, Date approvedDate,
			PVUEmployeAssuredCareerProgressionEntity entity) {

		if (pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)
				|| pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_I)) {
			String authorizerRemark = null;
			if (pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)) {
				authorizerRemark = entity.getClassTwoRemarks();
			} else {
				authorizerRemark = entity.getClassOneRemarks();
			}
			EDPLuLookUpInfoEntity authorizationStatus = getLookupByName(Constant.RECOMMENDATION_FOR,
					Constant.AUTHORIZE);
			repository.updateStatusIdAndAuthorizer(authorizationStatus.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), new Date(), LocalDateTime.now(),
					Long.parseLong(securityUtil.decrypt(pvuWFWrapperDto.getAssignByUserId())), authorizerRemark);
			repository.updateAutorizedDate(Constant.ACTIVE_STATUS, pvuWFWrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), new Date(), LocalDateTime.now());
			pvuInwardRepository.setAuthorizeDateAndFlag(pvuWFWrapperDto.getTrnId(), PvuConstant.ACP_PAY_PVU_EVENT_ID,
					OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(), Constant.OUTWARD_FLAG_ONE,
					Constant.ACTIVE_STATUS);
		} else if (pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_II)
				|| pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_I)) {
			/* Update Status ApproverClass II Return */
			EDPLuLookUpInfoEntity authorizationStatus = getLookupByName(Constant.RECOMMENDATION_FOR, Constant.RETURN);
			repository.updateStatusIdAndAuthorizer(authorizationStatus.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate, LocalDateTime.now(),
					Long.parseLong(securityUtil.decrypt(pvuWFWrapperDto.getAssignByUserId())),
					pvuWFWrapperDto.getRemarks());
			pvuInwardRepository.setReturnDateAndFlag(pvuWFWrapperDto.getTrnId(), PvuConstant.ACP_PAY_PVU_EVENT_ID,
					OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(), Constant.OUTWARD_FLAG_ONE,
					Constant.ACTIVE_STATUS);
		} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.FORWARD_TO_PVU)) { // Forward to
			this.insertACPInwardTable(pvuWFWrapperDto);
		}
	}

	private void checkApprovedOrRejected(PvuWFWrapperDto pvuWFWrapperDto, Date approvedDate,
			PVUEmployeAssuredCareerProgressionEntity assuredCareerProgressionEntity,
			EDPLuLookUpInfoEntity empApprovStatsLookupInfo,
			PVUEmployeAssuredCareerProgressionDto assuredCareerProgressionDto) throws CustomException {

		logger.info("checkApprovedOrRejected  Method START=========  WfStatus {}", pvuWFWrapperDto.getWfStatus());

		if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) { // Approved

			logger.info("checkApprovedOrRejected  Method START=========  WfStatus == {APPROVED}");

			EDPLuLookUpInfoEntity printEnable = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.CONDITION_CHECK,
							Constant.ACTIVE_STATUS, Constant.LOOKUP_YES);
			assuredCareerProgressionEntity.setStatusId(empApprovStatsLookupInfo);
			repository.updateStatusId(empApprovStatsLookupInfo.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate);
			repository.updatePrintStatusAndApproveDate(Constant.ACTIVE_STATUS, pvuWFWrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), new Date(), printEnable.getLookUpInfoId(),
					LocalDateTime.now());

		} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) { // Rejected

			logger.info("checkApprovedOrRejected  Method START=========  WfStatus == {REJECTED}");

			EDPLuLookUpInfoEntity empRejectStatsLookupInfo = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.REJECTED);
			repository.updateStatusId(empRejectStatsLookupInfo.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate);
			resetEmployeeStatus(assuredCareerProgressionEntity.getEmployeeNo().getEmpId(),
					assuredCareerProgressionDto.getEventCode());
		} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.PULLED_BACK)) {
			updateForPulledBack(pvuWFWrapperDto, assuredCareerProgressionEntity);/* Inactive inward row */
		}
	}

	private EDPLuLookUpInfoEntity getLookupByName(String lookupType, String lkpName) {
		return edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(lookupType,
				Constant.ACTIVE_STATUS, lkpName);
	}

	private void resetEmployeeStatus(Long empId, String eventCode) throws CustomException {
		PVUEmployeeEventStatusEntity employeeStatus = pvuEmployeeEventStatusService.findOneByEmpId(empId);
		if (eventCode.equalsIgnoreCase(PvuConstant.EVENT_CODE_ACP)) {
			employeeStatus.setAssuredCareerProg(0);
			employeeStatus.setTransId(null);
			pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(employeeStatus);
		}
	}

	public void insertACPRemarks(Long transId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append("INSERT_IN_ACP_EVNT_REMARKS_ITR");
		repository.callStoredProcedure(procName.toString(), map);
	}

	private void insertACPInwardTable(PvuWFWrapperDto wrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, wrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_CREATED_BY, OAuthUtility.getCurrentUserUserId());
		map.put(Constant.IN_CREATED_BY_POST, wrapperDto.getAssignByPostId());
		map.put(Constant.IN_POU_ID, wrapperDto.getAssignByPOUId());
		map.put(Constant.IN_OFFICE_ID, wrapperDto.getAssignByOfficeId());
		map.put(Constant.IN_EVENT_CODE, PvuConstant.EVENT_CODE_ACP);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_INWARD_INSERT));
		repository.callStoredProcedure(procName, map);
	}

	private void insertACPInITRs(PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_ACP_EVNT_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	@Override
	public Boolean generateInwardNumber(List<IdDto> inwardNumberList) throws CustomException {

		logger.info("generateInwardNumber Method START  =============  {}", inwardNumberList.isEmpty());
		try {
			List<Map<Integer, Object>> mapForInwardSP = new ArrayList<>();
			inwardNumberList.forEach(dto -> {
				Map<Integer, Object> map = new HashMap<>();
				map.put(1, Constant.ACP);
				map.put(2, dto.getId());
				mapForInwardSP.add(map);
			});
			return repository.callStoreProcBatch("{CALL "
					+ Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INWARD_NO_GENERATION_PVU)) + "(?,?)}",
					mapForInwardSP);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public boolean submiAcpInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException {

		logger.info("submiAcpInward Method START  =============  {}", wrapperDto.isEmpty());
		logger.info("submiAcpInward Method   ============= Size {}", wrapperDto.size());

		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	@Override
	public PagebleDTO<PVUAcpInwardView> getAcpInwardList(PageDetails pageDetail) throws CustomException {

		logger.info("getAcpInwardList Method START  =============  ");

		try {
			Map<String, Object> map = buildPageInMapInwardList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_INWARD_LIST_WF).toString();
			List<PVUAcpInwardView> objStorePro = this.storeProcPvu(procName, map, PVUAcpInwardView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
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
				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_PAN,
				PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX, PVUSearchEnum.PVU_SEARCH_DDO,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INW_NO, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID);

	}

	public <T> List<T> storeProcPvu(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, view) : Collections.emptyList();
	}

	@Override
	public Boolean submitAcpDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException {

		logger.info("submitAcpDistributor Method START  ============= {} ", wrapperDto.isEmpty());

		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	private List<PVUSearchEnum> getPvuOfficeSearchFields() {
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

	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public PVUEmployeAssuredCareerProgressionDto updateAcpRemarks(PVUEmployeAssuredCareerProgressionDto dto)
			throws CustomException {

		logger.info("updateAcpRemarks Method START  ============= {} ", dto.getTrnNo());

		PVUEmployeAssuredCareerProgressionDto assuredCareerProgressionDto = converter
				.updateACPRemarks(converter.toDTO(getAssuredCareerProgressionById(dto.getId())), dto);
		PVUEmployeAssuredCareerProgressionEntity updateEntity = saveOrUpdateEmployeAssuredCareerProgression(
				assuredCareerProgressionDto);
		if (!Utils.isEmpty(dto.getReturnReasons())) {
			Long wfRoleId = dto.getWfRoleId();

			logger.info("wfRoleId  ============= {} ", wfRoleId);

			String remarkType = getRemarkType(dto.getWfRoleId());
			if (!Utils.isEmpty(dto.getReturnReasons())) {
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
					deactivateReasonAndSaveRemarks(dto, wfRoleId, remarkType);
				}
			}
		}
		return converter.toDTO(updateEntity);
	}

	private void deactivateReasonAndSaveRemarks(PVUEmployeAssuredCareerProgressionDto dto, Long wfRoleId,
			String remarkType) {
		remarkService.deActivateOldReason(dto.getId(), PvuConstant.ACP_PAY_PVU_EVENT_ID);
		List<PVUEventRemarksEntity> remarks = dto.getReturnReasons().stream().map(remarkDto -> {
			PVUEventRemarksEntity remark = new PVUEventRemarksEntity();
			remark.setEventID(PvuConstant.ACP_PAY_PVU_EVENT_ID);
			remark.setTrnNo(dto.getId());
			remark.setWfRoleId(wfRoleId);
			remark.setEmpId(dto.getEmployeeId());
			remark.setRemarks(remarkDto.getRemarks());
			remark.setRemarksType(remarkType);
			remark.setReason(remarkDto.getReasonId());
			remark.setActiveStatus(Constant.ACTIVE_STATUS);
			return remark;
		}).collect(Collectors.toList());
		remarkService.saveAll(remarks);
	}

	private String getRemarkType(Long wfRoleId) {
		String remarkType = "";
		if (wfRoleId == Constant.AUDITOR) {
			remarkType = Constant.AUDITOR_NAME;
		} else if (wfRoleId == Constant.APPROVER_CLASS_TWO) {
			remarkType = Constant.APPROVER_CLASS_TWO_NAME;
		} else if (wfRoleId == Constant.APPROVER_CLASS_ONE) {
			remarkType = Constant.APPROVER_CLASS_ONE_NAME;
		} else if (wfRoleId == Constant.PVU_VERIFIER) {
			remarkType = Constant.PVU_VERIFIER_NAME;
		}
		return remarkType;
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	@Override
	public PVUEmployeAssuredCareerProgressionEntity getAssuredCareerProgressionById(Long id) {
		return repository.findOneById(id);
	}

	@Override
	public EDPMsOfficeDto getPVUOfficeName(IdDto idDto) {

		logger.info("getPVUOfficeName Method  =============PVU Office Name {} ", idDto.getId());

		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.EVENT_ID, idDto.getId());
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getACPPEmployeeOfficeId(), map);
		if (!Utils.isEmpty(objects)) {
			EDPMsOfficeDto officeDto = new EDPMsOfficeDto();
			officeDto.setOfficeName(String.valueOf(objects.get(0)[0]));
			return officeDto;
		}
		return null;
	}

	/**
	 *
	 * @param pageDetail
	 * @return
	 * @throws CustomException
	 */
	@Override
	public PagebleDTO<PVUAcpPayOfficeSearchView> pvuAuditorList(PageDetails pageDetail) throws CustomException {
		try {

			logger.info("pvuAuditorList Method  START=============");

			Map<String, String> collect = this.getPvuOfficeSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			StringBuilder procName = new StringBuilder();
			procName.append(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.COMMON_FIVE_EVENT_LIST_SEARCH_WF_PVU);
			List<Object[]> objStorePro = repository.callStoredProcedure(procName.toString(), map);
			if (!Utils.isEmpty(objStorePro)) {
				List<PVUAcpPayOfficeSearchView> list = NativeQueryResultsMapper.map(objStorePro,
						PVUAcpPayOfficeSearchView.class);
				list.forEach(e -> e.setEventCode(PvuConstant.EVENT_CODE_ACP));
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), list);
			}
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, 0, Collections.emptyList());
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public Map<String, Object> getPVUResponse(IdDto dto) throws CustomException, ParseException {

		logger.info("getPVUResponse   Method  START============={}", dto.getId());

		PVUEmployeAssuredCareerProgressionEntity assuredCareerProgressionById = getAssuredCareerProgressionById(
				dto.getId());
		if (assuredCareerProgressionById != null && assuredCareerProgressionById.getCurrentDetailsEventId() != null) {

			logger.info("PVUEmployeAssuredCareerProgressionEntity    ACP CurrentDetailsEventId============={}",
					assuredCareerProgressionById.getCurrentDetailsEventId());

			PVUCommonApiDto currentDetails = this.eventsService
					.getCommonApiResponse(assuredCareerProgressionById.getCurrentDetailsEventId());
			Map<String, Object> response = new HashMap<>();
			response.put("currentDetails", currentDetails);
			response.put("postDetails", converter.toPVUObj(assuredCareerProgressionById));
			return response;
		}
		throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
	}

	@Override
	public String getWfRoleCodeByTrnId(Long trnId) {

		logger.info("getWfRoleCodeByTrnId   Method  START============={}", trnId);

		return this.wfRepository.findWfRlCdByAcpPayTrnId(trnId, Constant.ACTIVE_STATUS);
	}

	@Override
	public List<PVUMsReasonDto> getAcpPayReasons() {
		return pvuMsReasonService.getEventsReasons();
	}

	/**
	 *
	 * @param id
	 * @return
	 * @throws CustomException
	 */
	public List<PVUEventRemarksDto> getRemarkByeventId(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		try {

			map.put(PvuConstant.TRN_ID, id);
			map.put(PvuConstant.PVU_EVENT_ID, PvuConstant.ACP_PAY_PVU_EVENT_ID);
			map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
			List<Object[]> objects = remarksRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getAcpReturnRemarks(),
					map);
			return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PVUEventRemarksDto.class)
					: Collections.emptyList();
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 *
	 * @param dtos
	 * @return
	 * @throws CustomException
	 */
	@Override
	public boolean generateOutwardNumber(List<IdDto> dtos) throws CustomException {

		logger.info("generateOutwardNumber   Method  START============={}  ", dtos.size());

		try {
			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
			dtos.forEach(dto -> {
				Map<Integer, Object> map = new HashMap<>();
				map.put(1, Constant.ACP);
				map.put(2, dto.getId());
				parameterMapList.add(map);
			});
			return repository
					.callStoreProcBatch(
							"{CALL ".concat(Constant.PVU_SCHEMA
									.concat(Constant.DOT.concat(PvuConstant.OUTWARD_NO_GENERATION_PVU))) + "(?,?)}",
							parameterMapList);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 *
	 * @param wrapperDto
	 * @return
	 * @throws CustomException
	 */
	@Override
	public boolean submitACPOutward(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException {

		wrapperDto.forEach(e -> inwardService.setResetOutwardFlag(e.getTrnId(), PvuConstant.ACP_PAY_PVU_EVENT_ID));
		wrapperDto.forEach(e -> inwardService.setConsignmentNumber(e.getTrnId(), PvuConstant.ACP_PAY_PVU_EVENT_ID,
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
			map.put(PvuConstant.EVENT_ID, PvuConstant.ACP_PAY_PVU_EVENT_ID);
			map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
			List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getWfTable(), map);
			List<PVUWfTableInfo> tableList = !Utils.isEmpty(objects)
					? NativeQueryResultsMapper.map(objects, PVUWfTableInfo.class)
					: Collections.emptyList();
			tableInfo = !tableList.isEmpty() ? tableList.get(0) : null;
		}
		List<PvuWFWrapperDto> returnList = new ArrayList<>();
		if (tableInfo != null) {
			setSourceUser(list, tableInfo, returnList);
			pvuFacade.callWorkFlowApis(returnList);
		}
		if (!authList.isEmpty()) {
			authList.forEach(e -> e.setWfStatus(PvuConstant.AUTHORIZED));
			pvuFacade.callWorkFlowApis(PvuWFOutWardWrapperDto.createSuper(authList));
			wrapperDto.forEach(e -> authorizeSPP(e.getTrnId()));
			wrapperDto.forEach(e -> authorizeBackdateSP(e.getTrnId()));
			for (PvuWFOutWardWrapperDto e : authList) {
				updateEmpEventStatusReset(repository.getEmpId(e.getTrnId()));
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

	public void authorizeBackdateSP(Long trnId) {

		logger.info("authorizeBackdateSP   Method  START============={}  ", trnId);

		String trnNo = repository.getTrnNo(trnId);
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		map.put(Constant.IN_EVNT_CODE, "Assured_Career_Progression");
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map);
	}

	public void authorizeSPP(Long trnId) {

		logger.info("authorizeSPP   Method  START============={}  ", trnId);

		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnId);
		map.put(Constant.IN_EVENT_CODE, "Assured_Career_Progression");
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.PVU_COMMON_AUTHORIZED_SP, map);
	}

	/**
	 *
	 * @param find
	 */
	private void updateEmpEventStatusReset(long empId) {
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntity;
		pvuEmployeeEventStatusEntity = pvuEmployeeEventStatusService.findByEmpId(empId);
		if (pvuEmployeeEventStatusEntity.isPresent()) {
			pvuEmployeeEventStatusEntity.get().setAssuredCareerProg(0);
			pvuEmployeeEventStatusEntity.get().setTransId(null);
			pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity.get());
		}
	}

	/**
	 *
	 * @param pageDetail
	 * @return
	 * @throws CustomException
	 */
	@Override
	public PagebleDTO<PVUACPOutwardView> getACPOutwardList(PageDetails pageDetail) throws CustomException {

		logger.info("getACPOutwardList   Method  START============= ");

		try {
			Map<String, Object> map = buildPageInMaps(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_OUTWARD_LIST_WF).toString();
			List<PVUACPOutwardView> objStorePro = this.storeProcPvu(procName, map, PVUACPOutwardView.class);
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private Map<String, Object> buildPageInMaps(PageDetails pageDetail) {
		Map<String, String> collect = getOutwardPvuSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	/**
	 *
	 * @return
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
	 *
	 * @param pageDetail
	 * @return
	 * @throws CustomException
	 */
	@Override
	public PagebleDTO<PVUPrintEndorsementView> getACPPrintEndorsement(PageDetails pageDetail) throws CustomException {

		logger.info("getACPPrintEndorsement   Method  START============= ");

		try {
			Map<String, Object> map = buildPageInMapPrintEndorsementList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF).toString();
			List<PVUPrintEndorsementView> objStorePro = this.storeProcPvu(procName, map, PVUPrintEndorsementView.class);
			if (!Utils.isEmpty(objStorePro)) {
				objStorePro.forEach(e -> e.setEventCode(PvuConstant.EVENT_CODE_ACP));
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
			}
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private Map<String, Object> buildPageInMapPrintEndorsementList(PageDetails pageDetail) {
		Map<String, String> collect = getPrintEndorsementSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	public List<PVUSearchEnum> getPrintEndorsementSearchFields() {
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

	@Override
	public void authorizedRop(Long transId) {

		logger.info("authorizedRop   Method  START============= {}", transId);

		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF);
		repository.callStoredProcedure(procName.toString(), map);
	}

	@Override
	public List<PVUPrintEndorsementRemarkHistoryDto> getPrintEndorsementHistory(Long id) throws CustomException {

		logger.info("getPrintEndorsementHistory   Method  START============= {}", id);

		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.TRN_ID, id);
		map.put(PvuConstant.EVENT_ID, PvuConstant.ACP_PAY_PVU_EVENT_ID);
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getCommonEndorsementHistory(),
				map);
		return !Utils.isEmpty(objects)
				? NativeQueryResultsMapper.map(objects, PVUPrintEndorsementRemarkHistoryDto.class)
				: Collections.emptyList();
	}

	private Template getPrintTemplate(PVUEmployeAssuredCareerProgressionEntity entity) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template template = new Template();
		if (!Utils.isEmpty(entity.getPayCommission())) {
			logger.info("PayCommission {}", entity.getPayCommission());
			template = ve.getTemplate("templates/acpMenu/ACP_Template.vm");
		}
		return template;
	}

	/**
	 * @param dto
	 * @return
	 * @throws CustomException
	 */
	public PVUStickerDTO submitPrintHistory(PvuPrintStickerReportDto dto) throws CustomException {

		logger.info("submitPrintHistory   Method  START============= ");

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

	private PVUPrintEndorsementDto submitPEWF(PvuPrintStickerReportDto dto) throws CustomException {

		logger.info("submitPEWF   Method  START============= ");

		PVUPrintEndorsementEntity printEntity = null;
		try {
			if (dto.getPrintEndorsementDto() != null) {
				printEntity = pvuPrintEndorsementRepository
						.findByIdAndActiveStatus(dto.getPrintEndorsementDto().getId(), Constant.ACTIVE_STATUS);
				if (printEntity != null) {
					dto.getPrintEndorsementDto().setReprintDate(new Date());
					dto.getPrintEndorsementDto().setPrintDate(printEntity.getPrintDate());
					dto.getPrintEndorsementDto().setPrintCnt(printEntity.getPrintCnt() + 1L);
					dto.getPrintEndorsementDto().setTrnId(dto.getPvuWFWrapperDto().getTrnId());
					dto.getPrintEndorsementDto().setEventId(PvuConstant.ACP_PAY_PVU_EVENT_ID);
				} else {
					/** For authorized case, and final reflection done by this */
					Boolean result = pvuFacade.callWorkFlowApis(dto.getPvuWFWrapperDto());
					if (result.equals(Boolean.TRUE)) {
						pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
								PvuConstant.ACP_PAY_PVU_EVENT_ID, dto.getPvuWFWrapperDto().getTrnId(),
								Constant.OUTWARD_FLAG_ONE, Constant.ACTIVE_STATUS);
						dto.getPrintEndorsementDto().setPrintCnt((dto.getPrintEndorsementDto().getPrintCnt() + 1l));
						dto.getPrintEndorsementDto().setPrintDate(new Date());
						dto.getPrintEndorsementDto().setTrnId(dto.getPvuWFWrapperDto().getTrnId());
						dto.getPrintEndorsementDto().setEventId(PvuConstant.ACP_PAY_PVU_EVENT_ID);
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

	public ByteArrayOutputStream generatePdf(String html) {

		PdfWriter pdfWriter = null;
		// create a new document
		Document document = new Document();
		try {
			document = new Document();
			document.addAuthor("GOG"); // document header attributes
			document.addCreationDate();
			document.addProducer();
			document.addCreator("GOG Finance");
			document.addTitle("Assured Career Progression");
			document.setPageSize(PageSize.LETTER);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);
			document.open(); // open document
			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(html));
			document.close(); // close the document
			document.newPage();
			logger.info("PDF generated successfully");

			return baos;
		} catch (Exception e) {
			return null;
		}

	}

	/*
	 * / START
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

	private String generatePdf(List<PvuPrintStickerReportDto> dto) throws CustomException {

		long printId = 0;
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
			document.addTitle("Assured Career Progression ");
			document.setPageSize(PageSize.LETTER);
			PdfWriter pdfWriter = PdfWriter.getInstance(document, baos);

			document.open();
			for (PvuPrintStickerReportDto printStickerReportDto : dto) {

				if (printStickerReportDto.getPrintEndorsementDto() != null
						&& printStickerReportDto.getPrintEndorsementDto().getId() != null) {
					printId = printStickerReportDto.getPrintEndorsementDto().getId();
				}

				PVUEmployeAssuredCareerProgressionEntity acpPayEntity = repository
						.findOneById(printStickerReportDto.getPvuWFWrapperDto().getTrnId());
				if (acpPayEntity.getOfficeId().getOfficeId().equals(acpPayEntity.getOfficeId().getPvuId())
						&& acpPayEntity.getOfficeId().getOfficeId() != Constant.PVU_OFFICE_ID) {
					watermark = ", Self PVU";
				} else {
					watermark = ", PVU, Gandhinagar";
				}
				pdfWriter.setPageEvent(
						new WatermarkPageEvent(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()), watermark));
				writer.write(generateAcpPayPdf(printStickerReportDto).toString());
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
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
			header.setContentLength(baos.toByteArray().length);
			return sb.toString();// call this method for node js API for
			// html with watermark
		} catch (Exception ex) {

			// Bug 3202 resolved START

			PVUPrintEndorsementEntity printEntity = pvuPrintEndorsementRepository.findByIdAndActiveStatus(printId,
					Constant.ACTIVE_STATUS);
			if (printEntity != null) {
				printEntity.setPrintCnt(printEntity.getPrintCnt() - 1);
			}

			// Bug 3202 resolved END

			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private StringWriter generateAcpPayPdf(PvuPrintStickerReportDto dto) throws CustomException {

		PVUStickerDTO stickerDTO = null;
		try {
			stickerDTO = submitPrintHistory(dto);

			PVUEmployeAssuredCareerProgressionEntity acpPayEntity = repository
					.findOneById(dto.getPvuWFWrapperDto().getTrnId());
			converter.toDTO(acpPayEntity);

			VelocityContext context = converter.populateVContext(stickerDTO, acpPayEntity);
			if (!Utils.isEmpty(acpPayEntity.getAuthorizeBy())) {
				String authorizerName = authService.getOnlyIdAndName(acpPayEntity.getAuthorizeBy()).getName();
				context.put("authorizerName", authorizerName);
			} else {
				context.put("authorizerName", org.apache.commons.lang3.StringUtils.EMPTY);
			}
			StringWriter writer = new StringWriter();
			Template template = getPrintTemplate(acpPayEntity);
			template.merge(context, writer);
			return writer;
		} catch (CustomException ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	/**
	 * Validate pay commision.
	 *
	 * @param empId     the emp id
	 * @param eventDate the event date
	 * @param payCommId the pay comm id
	 * @throws CustomException the custom exception
	 * @throws ParseException  the parse exception
	 */
	private void validatePayCommision(Long empId, LocalDate eventDate, Object payCommId, Date doj, Boolean isViewPage)
			throws CustomException, ParseException {
		if (Boolean.FALSE.equals(isViewPage))
			empPayDetailService.validatePayCommision(empId, Utils.convertToDate(eventDate),
					Long.parseLong(payCommId.toString()), doj);
	}

	/**
	 * Update for pulled back.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @param pvuEntity       the pvu entity
	 */
	private void updateForPulledBack(PvuWFWrapperDto pvuWFWrapperDto,
			PVUEmployeAssuredCareerProgressionEntity pvuEntity) {
		inwardService.updateStatusId(Constant.INACTIVE_STATUS, pvuEntity.getId(), new Date(),
				pvuWFWrapperDto.getEventId());
	}
}
