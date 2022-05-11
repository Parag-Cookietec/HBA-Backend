package gov.ifms.pvu.service;

import static gov.ifms.pvu.entity.PVUEmployeEventsEntity.distinctByKey;
import static gov.ifms.pvu.util.PvuConstant.PVU_TIKU_PAY_EVENT_CODE;
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
import org.springframework.dao.DataIntegrityViolationException;
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
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUEmployeTikuPayConverter;
import gov.ifms.pvu.converter.PVUPrintEndorsementItrConverter;
import gov.ifms.pvu.dto.PVUCSPOutwardView;
import gov.ifms.pvu.dto.PVUCsPrintEndorsementView;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeTikuPayCurrentDto;
import gov.ifms.pvu.dto.PVUEmployeTikuPayDto;
import gov.ifms.pvu.dto.PVUEmployeTikuPayPostDetailsDto;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PVUSourceUserDetails;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.PVUTikuPayEditListView;
import gov.ifms.pvu.dto.PVUTikuPayInwardView;
import gov.ifms.pvu.dto.PVUTikuPayOfficeSearchView;
import gov.ifms.pvu.dto.PVUWfTableInfo;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.dto.response.PVUTikuPayApiDto;
import gov.ifms.pvu.entity.PVUEmployeCCCExamDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeDeptExamDetailsEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeLangExamEntity;
import gov.ifms.pvu.entity.PVUEmployeSuspensionEntity;
import gov.ifms.pvu.entity.PVUEmployeTikuPayEntity;
import gov.ifms.pvu.entity.PVUEmployeeEOLeaveEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;
import gov.ifms.pvu.entity.PVUMsCourseEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.repository.PVUEmployeCCCExamDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeDeptExamDetailsRepository;
import gov.ifms.pvu.repository.PVUEmployeLangExamRepository;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVUEmployeTikuPayRepository;
import gov.ifms.pvu.repository.PVUInwardRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.repository.PVURevisionOfPayRemarkRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuMsgConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.util.WatermarkPageEvent;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;

@Service
public class PVUEmployeTikuPayServiceImpl implements PVUEmployeTikuPayService {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private PVUEmployeTikuPayRepository pvuEmployeTikuPayRepository;
	@Autowired
	private PVUInwardRepository pvuInwardRepository;
	@Autowired
	private PVUEmployeTikuPayConverter pvuEmployeTikuPayConverter;
	@Autowired
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;
	@Autowired
	private PVUEmployeRepository pvuEmployeRepository;
	@Autowired
	private PVUCommonService pvuCommonService;
	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;
	@Autowired
	private PVUEmployeCCCExamDetailRepository cccExamDetailRepository;
	@Autowired
	private PVUEmployeLangExamRepository langExamRepository;
	@Autowired
	private PVUEmployeDeptExamDetailsRepository deptExamDetailsRepository;
	@Autowired
	private PVUEmployeDepartmentRepository pvuEmployeeDepartmentRepo;
	@Autowired
	private PVUEmployeRepository pvumployeRepository;
	@Autowired
	private PVUEmployeeEventStatusService statusService;
	@Autowired
	private PVYFacade pvuFacade;
	@Autowired
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;
	@Autowired
	private PVUMsReasonService pvuMsReasonService;
	@Autowired
	private PVURevisionOfPayRemarkRepository remarkRepository;
	@Autowired
	private WfRepository wfRepository;
	@Autowired
	private PVUEventRemarksService eventRemarksService;
	@Autowired
	private PVUEmployeEventsService eventsService;
	@Autowired
	private PVUEmployeeEOLeaveService eoLeaveService;
	@Autowired
	private PVUEmployeSuspensionService suspensionService;
	@Autowired
	PVUPrintEndorsementRepository pvuPrintEndorsementRepository;
	@Autowired
	PVUPrintEndorsementItrRepository pvuPrintEndorsementItrRepository;
	@Autowired
	PVUPrintEndorsementItrConverter pvuPrintEndorsementItrConverter;
	@Autowired
	EncryptDecryptUtil securityUtil;
	@Autowired
	private PVUInwardService inwardService;
	@Autowired
	private PVUEmployePayDetailService empPayDetailService;

	@Override
	public PVUEmployeTikuPayEntity getEmployeTikuPay(Long id) {
		return pvuEmployeTikuPayRepository.getOne(id);
	}

	public PVUEmployeTikuPayEntity getTikuPayById(Long id) {
		return pvuEmployeTikuPayRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(MsgConstant.RECORD_NOT_FOUND));
	}

	// Get Lookup Information
	@Override
	public Map<String, List<PVUEmployeCreationDDLView>> getLookUpInfoAsMap(String procedureName)
			throws CustomException {
		try {
			Map<String, List<PVUEmployeCreationDDLView>> resultMap;
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(procedureName));
			List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = pvuEmployeTikuPayRepository
					.storeProc(procName, PVUEmployeCreationDDLView.class);
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
			return resultMap;
		} catch (Exception ex) {
			logger.error(ex.toString(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

// ===================================================   Get TikuPay Current Details  ==========================================================================
	@Override
	public Map<String, Object> getEmployeeCurrentDetails(PageDetails pageDetail)
			throws CustomException, ParseException {
		Map<String, Object> main = new HashMap<>();
		Map<String, Object> map = buildPageInMap(pageDetail);
		this.includeCurrentOffice(map);
		PVUTikuPayApiDto pvuTikuPayApiDto = this.getCommonDetailsBasedOnEventDate(map); // PVUCommonApiDto
																						// pvuCommonApiDto
		fetchExamDetail(main, pvuTikuPayApiDto);

		main.put(PvuConstant.EMPLOYEE, pvuTikuPayApiDto);
		return main;
	}

	public void fetchExamDetail(Map<String, Object> main, PVUTikuPayApiDto pvuTikuPayApiDto) throws CustomException {
		Map<String, Object> response = new HashMap<>();
		Long id = pvuTikuPayApiDto.getEmployeeId();
		List<PVUEmployeDeptExamDetailsEntity> deptExam = deptExamDetailsRepository
				.findPVUEmployeDeptExamDetailsEntityBypvuEmployeEntityEmpIdAndActiveStatus(id, Constant.ACTIVE_STATUS);

		List<PVUCommonApiDto.EXAMDto> collect = deptExam.stream().map(e -> {
			EDPLuLookUpInfoEntity examBody = e.getExamBody();
			Date dateOfPassing = e.getDateOfPassing();
			EDPLuLookUpInfoEntity lookUpInfoName = e.getExamStatus();
			return PVUCommonApiDto.EXAMDto.create(e.getDeptExamName(),
					examBody != null ? examBody.getLookUpInfoName() : null, dateOfPassing,
					lookUpInfoName != null ? lookUpInfoName.getLookUpInfoName() : null);
		}).collect(Collectors.toList());
		response.put(PvuConstant.DEPT_EXAMS, collect);

		List<PVUEmployeCCCExamDetailEntity> cccExam = cccExamDetailRepository
				.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(id, Constant.ACTIVE_STATUS);
		List<PVUCommonApiDto.EXAMDto> cccExams = cccExam.stream().map(e -> {
			PVUMsCourseEntity examBody = e.getExamBody();
			EDPLuLookUpInfoEntity examName = e.getCccExamName();
			Date dateOfPassing = e.getDateOfPassing();
			EDPLuLookUpInfoEntity lookUpInfoName = e.getExamStatus();
			return PVUCommonApiDto.EXAMDto.create(examName != null ? examName.getLookUpInfoName() : null,
					examBody != null ? examBody.getCourseName() : null, dateOfPassing,
					lookUpInfoName != null ? lookUpInfoName.getLookUpInfoName() : null);
		}).collect(Collectors.toList());

		response.put(PvuConstant.CCC_EXAMS, cccExams);

		List<PVUEmployeLangExamEntity> lanExam = langExamRepository
				.findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(id, Constant.ACTIVE_STATUS);
		List<PVUCommonApiDto.EXAMDto> langExams = lanExam.stream().map(e -> {
			EDPLuLookUpInfoEntity examName = e.getLangName();
			Date dateOfPassing = e.getDateOfPassing();
			EDPLuLookUpInfoEntity lookUpInfoName = e.getExamStatus();
			return PVUCommonApiDto.EXAMDto.create(examName != null ? examName.getLookUpInfoName() : null,
					e.getExamBody(), dateOfPassing, lookUpInfoName != null ? lookUpInfoName.getLookUpInfoName() : null);
		}).collect(Collectors.toList());
		response.put(PvuConstant.LANG_EXAMS, langExams);
		main.put(PvuConstant.EXAMS, response);
	}

	public void includeCurrentOffice(Map<String, Object> map) {
		map.put("IN_OFFICE_ID", OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId());
	}

	public Map<String, Object> buildPageInMap(PageDetails pageDetail) {
		Map<String, String> collect = getPvuSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(new StringBuilder(), pageDetail, collect);
	}

	public List<PVUSearchEnum> getPvuSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_ID, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM, PVUSearchEnum.PVU_SEARCH_FIELD_TIKUPAY_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE,PVUSearchEnum.PVU_SEARCH_FIELD_VIEW_PAGE);
	}

	@Override
	public PVUTikuPayApiDto getCommonDetailsBasedOnEventDate(Map<String, Object> map)
			throws CustomException, ParseException {

		Long empCode = Long.valueOf(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getValue()).toString());
		PVUEmployeDepartmentEntity employeDepartmentEntity = pvuEmployeeDepartmentRepo
				.findFirstByPvuEmployeEntityEmployeeCode(empCode)
				.orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
		tikuPayTypeValidation(map, employeDepartmentEntity);
		validatePayCommApplicability(map, employeDepartmentEntity.getPvuEmployeEntity().getEmpId(),
				employeDepartmentEntity.getDateOfJoiningGOG(),Boolean.valueOf(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_VIEW_PAGE.getValue()).toString()));
		map.remove(PVUSearchEnum.PVU_SEARCH_FIELD_VIEW_PAGE.getValue());
		return currentDetailsOfEmployee(map);
	}

	public PVUTikuPayApiDto currentDetailsOfEmployee(Map<String, Object> map) throws CustomException {
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMP_TK_CURR_DTLS_SP)); // PVU_COMMON_SP
		List<PVUTikuPayApiDto> objStorePro = this.callSp(procName, map);

		if (CollectionUtils.isEmpty(objStorePro)) {
			Long employeeCode = Long.valueOf(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getValue()).toString());
			Long payCommission = Long.valueOf(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getValue()).toString());
			PVUEmployeDepartmentEntity entity = pvuEmployeeDepartmentRepo
					.findFirstByPvuEmployeEntityEmployeeCode(employeeCode)
					.orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
			if (!entity.getPresentOffice().getOfficeId()
					.equals(OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId())) {
				throw new CustomException(HttpStatus.CONFLICT,
						MessageFormat.format(MsgConstant.ERROR_EMPLOYEE_NOT_IN_OFFICE, employeeCode.toString()));
			}
			Date dateOfJoiningGOG = entity.getDateOfJoiningGOG();
			LocalDate eventDate = PvuUtils
					.getDateFromStringYMD(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getValue()).toString());
			if (PvuUtils.isFromToBeforeEquals(PvuUtils.convertLocalDate(entity.getDateOfJoiningGOG()), eventDate)) {
				throw new CustomException(HttpStatus.CONFLICT, PvuUtils.buildErrorMsg(payCommission));
			} else {
				throw new CustomException(HttpStatus.CONFLICT,
						MessageFormat.format(MsgConstant.ERROR_EMPLOYEE_JOINING_DATE, dateOfJoiningGOG));
			}
		}
		return objStorePro.get(0);
	}

	public List<PVUTikuPayApiDto> callSp(String procName, Map<String, Object> objectMap) throws CustomException {

		List<Object[]> objectPvuSp = pvumployeRepository.callStoredProcedure(procName, objectMap);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUTikuPayApiDto.class)
				: Collections.emptyList();
	}

	public void tikuPayTypeValidation(Map<String, Object> map, PVUEmployeDepartmentEntity employeDepartmentEntity)
			throws CustomException {

		long employeeId = employeDepartmentEntity.getPvuEmployeEntity().getEmpId();
		Date dOJGOG = employeDepartmentEntity.getDateOfJoiningGOG();
		LocalDate effectiveDate = PvuUtils
				.getDateFromStringYMD(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getValue()).toString());
		
		
		if (Utils.isEmpty(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_IN_TIKU_PAY_TYPE.getValue()))) {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.TIKU_PAY_TYPE);
		}

		// Only Regular Pay_Type need to check with Equals
		if (employeDepartmentEntity.getEmpPayType().getLookUpInfoId() != PvuConstant.REGULAR_PAY_TYPE_ID) { // 156
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_EMPLOYEE_ONLY_REGULAR);
		}
		
		// It is applicable for only Health and Family Welfare Department. //
		if (!employeDepartmentEntity.getParentHeadDept().getDepartmentCode()
				.equalsIgnoreCase(String.valueOf(PvuConstant.TK_HEAD_DEPT_ID))) {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.TIKU_PAY_EMPLOYEE_DEPARTMENT_NOT_VALID, "")); // employeDepartmentEntity.getParentHeadDept().getDepartmentName()
		}
		
		pvuCommonService.validateBackDatedEffDateForEmpType(employeDepartmentEntity, effectiveDate);

		PVUEmployeDepartmentEntity employeDeptEntity = pvuEmployeeDepartmentRepo
				.findFirstByPvuEmployeEntityEmployeeCode(Long.parseLong(OAuthUtility.getCurrentUserCode()))
				.orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
		if (!employeDeptEntity.getParentHeadDept().getDepartmentCode()
				.equalsIgnoreCase(String.valueOf(PvuConstant.TK_HEAD_DEPT_ID))) {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.TIKU_PAY_EMPLOYEE_DEPARTMENT_NOT_VALID, ""));
		}

		// Effective date for TikuPay is 4th September 1991 or after >>
		if (!PvuUtils.isFromToBeforeEquals(LocalDate.parse(PvuConstant.TIKUPAY_VALID_DATE), effectiveDate)) // 1991-09-04
		{
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.TIKU_PAY_EFFDATE_DATE, dOJGOG));
		}

		// Effective Date should be greater than Date of Joining.
		if (!PvuUtils.isFromToBeforeEquals(PvuUtils.convertLocalDate(employeDepartmentEntity.getDateOfJoiningGOG()),
				effectiveDate)) {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.TIKU_PAY_EFFDATE_GREATERTHAN_JOINING_VALIDATION,
							PvuUtils.getDateToStringDMYFormatValue(dOJGOG)));
		}

		// Validation for CCC+ exam required
		boolean isFullExempted = false;
		List<PVUEmployeCCCExamDetailEntity> cccExamDetail = cccExamDetailRepository
				.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(employeeId,
						Constant.ACTIVE_STATUS);
		
		if (CollectionUtils.isEmpty(cccExamDetail)) {
			throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(PvuMsgConstant.ERROR_MSG_EXAM_MANDATORY_TIKU_PAY, ""));
		} else if ((!CollectionUtils.isEmpty(cccExamDetail))) {
			for (PVUEmployeCCCExamDetailEntity cccExamEntity: cccExamDetail) {
				if (cccExamEntity.getExamStatus().getLookUpInfoId() == PvuConstant.EXAM_EXEMPT) {
					isFullExempted = true;				
				}
			}
			if (!isFullExempted) {
				cccExamDetail = cccExamDetail.stream()
						.filter(e -> (e.getExamStatus().getLookUpInfoId() == PvuConstant.EXAM_PASS
						|| e.getExamStatus().getLookUpInfoId() == PvuConstant.EXAM_EXEMPT)
						&& (null != e.getCccExamName()
								&& (e.getCccExamName().getLookUpInfoId() == PvuConstant.CCC_PLUS_PRECTICAL
										|| e.getCccExamName().getLookUpInfoId() == PvuConstant.CCC_PLUS_THEORY)))
				.collect(Collectors.toList());
				if (cccExamDetail.size() < 2 ) {
					throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(MsgConstant.TIKU_PAY_CCC_REQUIRED, ""));
				}
			}
		}		

		tikuPayGivenValidation(map, employeeId);

		LocalDate eventDate = PvuUtils
				.getDateFromStringYMD(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getValue()).toString());
		pvuCommonService.validateEOL(employeeId, eventDate);
		pvuCommonService.validateSuspension(employeeId, eventDate);
	}
	private void tikuPayGivenValidation(Map<String, Object> map, long employeeId) throws CustomException {

		EDPLuLookUpInfoEntity authorizeStatusId = edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.AUTHORIZE);
		List<PVUEmployeTikuPayEntity> tikuPayEntity = pvuEmployeTikuPayRepository
				.findByEmployeeIdEmpIdAndActiveStatusAndStatusLookUpInfoId(employeeId, Constant.ACTIVE_STATUS,
						authorizeStatusId.getLookUpInfoId());
		Long tikuPayType = Long.valueOf(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_TIKUPAY_TYPE.getValue()).toString());
		if (CollectionUtils.isEmpty(tikuPayEntity) && !tikuPayType.equals(PvuConstant.TIKU_PAY_ONE)) {
			throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(MsgConstant.TIKU_PAY_FIRST_SELECT, ""));
		}
		if (tikuPayEntity.size() == 1) {
			if (!tikuPayType.equals(PvuConstant.TIKU_PAY_TWO) && !tikuPayType.equals(PvuConstant.TIKU_PAY_ONE)) {
				throw new CustomException(HttpStatus.CONFLICT,
						MessageFormat.format(MsgConstant.TIKU_PAY_TWO_SELECT, ""));
			}
		}
		if (!CollectionUtils.isEmpty(tikuPayEntity)) {
			for (PVUEmployeTikuPayEntity entityValue : tikuPayEntity) {
				if (entityValue.getPayType().getLookUpInfoId() == tikuPayType) {
					throw new CustomException(HttpStatus.CONFLICT, MessageFormat
							.format(MsgConstant.TIKU_PAY_ALREADY_GIVEN, entityValue.getPayType().getLookUpInfoName()));
				}

				if (entityValue.getPayType().getLookUpInfoId() > tikuPayType) {
					throw new CustomException(HttpStatus.CONFLICT,
							MessageFormat.format(MsgConstant.TIKU_PAY_ALREADY_GOT_HIGHER, ""));
				}
			}
		} 
	}

// ========================================= End Employee common Details=============================================================	
	@Override
	public void postDetailvalidate(PVUEmployeTikuPayDto tikuPayDto) throws CustomException {

		// GPSC NO then Invalid for TikuPay
		if (tikuPayDto.getGpscExamPassedId() == edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.LOOKUP_NO)
				.getLookUpInfoId()) {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.TIKU_PAY_GPSC_EXAM_REQUIRE, ""));
		}

		if (Utils.isEmpty(tikuPayDto.getGpscExamPassedDate())) {
			// MessageFormat.format(MsgConstant.TIKU_PAY_GPSC_EXAM_DATE,
		}

		PVUEmployeEntity pvuEmployeEntity = pvuEmployeRepository.findByEmployeeCodeAndActiveStatus(tikuPayDto.getEmployeeNo(),Constant.ACTIVE_STATUS)
				.orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
		PVUEmployeDepartmentEntity pvuEmployeDepartmentEntity = pvuEmployeDepartmentRepository
				.findOneByPvuEmployeEntityEmpId(pvuEmployeEntity.getEmpId());

		LocalDate regServiceDOJ = PvuUtils.convertLocalDate(pvuEmployeDepartmentEntity.getDateOfJoiningGOG());
		LocalDate effectiveDate = tikuPayDto.getBenEffDate();

		if (tikuPayDto.getTikuType() == PvuConstant.TIKU_PAY_TWO) {
			LocalDate tikuPayOneDate = tikuPayDto.getTikuPay1();
			long dojAndEffDateTotalDays = DAYS.between(tikuPayOneDate, effectiveDate);
			Long countEolSuspension = checkEligibleYearsForTikuPay(tikuPayOneDate, effectiveDate,
					pvuEmployeEntity.getEmpId());
			long diffincount = countEolSuspension;
			long actualDays = dojAndEffDateTotalDays - diffincount;
			int actualyear = (int) (actualDays / PvuConstant.YEAR_DAYS);
			isValidServiceYears(tikuPayDto, actualyear);
		} else if (tikuPayDto.getTikuType() == PvuConstant.TIKU_PAY_THREE) {
			LocalDate tikuPayTwoDate = tikuPayDto.getTikuPay2();
			long dojAndEffDateTotalDays = DAYS.between(tikuPayTwoDate, effectiveDate);
			Long countEolSuspension = checkEligibleYearsForTikuPay(tikuPayTwoDate, effectiveDate,
					pvuEmployeEntity.getEmpId());
			long diffincount = countEolSuspension;
			long actualDays = dojAndEffDateTotalDays - diffincount;
			int actualyear = (int) (actualDays / PvuConstant.YEAR_DAYS);
			isValidServiceYears(tikuPayDto, actualyear);
		} else {
			long dojAndEffDateTotalDays = DAYS.between(regServiceDOJ, effectiveDate);
			// If Adoc No then Validate GPSC date is available or not
			if (tikuPayDto.getAdhocId() == edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.LOOKUP_NO)
					.getLookUpInfoId()) {

				// Which DOJ need to consider
				// Count the Days from Date of Joing Regular Service to Benefit effective Date
				// based in TikyPay Type

				Long countEolSuspension = checkEligibleYearsForTikuPay(regServiceDOJ, effectiveDate,
						pvuEmployeEntity.getEmpId());
				long diffincount = countEolSuspension;
				long actualDays = dojAndEffDateTotalDays - diffincount;
				int actualyear = (int) (actualDays / PvuConstant.YEAR_DAYS);
				isValidServiceYears(tikuPayDto, actualyear);
			}

			// 31. If Adoc Yes, then check fromDate - ToDate is available / if yes then
			// count the days basedon effective date
			if (tikuPayDto.getAdhocId() == edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.LOOKUP_YES)
					.getLookUpInfoId()) {
				// Regular Service Yes
				if (tikuPayDto.getServiceRegularisedId() == edpLuLookUpInfoRepository
						.findByLookUpInfoName(Constant.LOOKUP_YES).getLookUpInfoId()) {
					if (tikuPayDto.getTikuType() == PvuConstant.TIKU_PAY_ONE) {

						isAdocDateRequire(tikuPayDto);
					}

					// Count the Days from AdocFromDate - AdocToDate && DoJ Regular Service -
					// Benefit effective Date based in TikyPay Type
					// Adoc Date
					LocalDate adocFromDate = tikuPayDto.getAdhocFromDate();
					LocalDate adocToDate = tikuPayDto.getAdhocToDate();
					long adocServicedays = DAYS.between(adocFromDate, adocToDate);

					Long countEolSuspension = checkEligibleYearsForTikuPay(regServiceDOJ, effectiveDate,
							pvuEmployeEntity.getEmpId());
					long diffincount = countEolSuspension;
					long actualDays = dojAndEffDateTotalDays - diffincount;
					long totalAdocAndRegularSerDays = adocServicedays + actualDays;
					int validServiceYears = (int) (totalAdocAndRegularSerDays / PvuConstant.YEAR_DAYS);
					isValidServiceYears(tikuPayDto, validServiceYears);
				}

				// Regular Service No
				if (tikuPayDto.getServiceRegularisedId() == edpLuLookUpInfoRepository
						.findByLookUpInfoName(Constant.LOOKUP_NO).getLookUpInfoId()) {
					// Calculate the days based on DOJ Regular Service to Benefit effective Date
					// based in TikyPay Type
					Long countEolSuspension = checkEligibleYearsForTikuPay(regServiceDOJ, effectiveDate,
							pvuEmployeEntity.getEmpId());
					long diffincount = countEolSuspension;
					long actualDays = dojAndEffDateTotalDays - diffincount;
					int actualyear = (int) (actualDays / PvuConstant.YEAR_DAYS); // 365
					isValidServiceYears(tikuPayDto, actualyear);
				}
			}

			if (tikuPayDto.getAdhocId() == Constant.LONG_ZERO_VALUE) {
				Long countEolSuspension = checkEligibleYearsForTikuPay(regServiceDOJ, effectiveDate,
						pvuEmployeEntity.getEmpId());
				long diffincount = countEolSuspension;
				long actualDays = dojAndEffDateTotalDays - diffincount;
				int actualyear = (int) (actualDays / PvuConstant.YEAR_DAYS);
				isValidServiceYears(tikuPayDto, actualyear);
			}
		}
		// If option Alive yes then he will get double increment on option date; one
		// Regular Increment + tikuPay increment
		// If not then employee will get one increment
	}

	private void isAdocDateRequire(PVUEmployeTikuPayDto tikuPayDto) throws CustomException {
		if (Utils.isEmpty(tikuPayDto.getAdhocFromDate())) {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.TIKU_PAY_ADOC_FROM_DATE, ""));
		}
		if (Utils.isEmpty(tikuPayDto.getAdhocToDate())) {
			throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(MsgConstant.TIKU_PAY_ADOC_TO_DATE, ""));
		}
	}

	public void isValidServiceYears(PVUEmployeTikuPayDto tikuPayDto, int actualyear) throws CustomException {
		if (tikuPayDto.getTikuType() == PvuConstant.TIKU_PAY_ONE && actualyear < PvuConstant.TIKU_PAY_ONE_YEAR) { // 6
			throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(MsgConstant.TIKU_PAY_ONE, actualyear));
		}
		if (tikuPayDto.getTikuType() == PvuConstant.TIKU_PAY_TWO && actualyear < PvuConstant.TIKU_PAY_TWO_YEAR) { // 13
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.TIKU_PAY_TWO, actualyear + 6));
		}
		if (tikuPayDto.getTikuType() == PvuConstant.TIKU_PAY_THREE && actualyear < PvuConstant.TIKU_PAY_THREE_YEAR) // 19
		{
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.TIKU_PAY_THREE, actualyear + 13));
		}
	}

	public Long checkEligibleYearsForTikuPay(LocalDate regServiceDOJ, LocalDate effectiveDate, Long employeeId)
			throws CustomException {

		long countsus = 0;
		long counteol = 0;

		LocalDate toLocalDate = regServiceDOJ; // MM/dd/yyyy
		LocalDate fromLocaldate = effectiveDate;// MM/dd/yyyy

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

	@Override // Save Or Update Data
	public PVUEmployeTikuPayDto saveOrUpdateEmployeTikuPay(PVUEmployeTikuPayDto pvuEmployeTikuPayDto)
			throws CustomException {
		try {

			PVUEmployeTikuPayEntity tikuPayEventEntity = pvuEmployeTikuPayConverter.toEntity(pvuEmployeTikuPayDto);
			if (pvuEmployeTikuPayDto.getStatusId() == Constant.LONG_ZERO_VALUE) {
				statusService.inProgressSuspensionEvent(tikuPayEventEntity.getEmployeeId().getEmpId());
				tikuPayEventEntity.setStatus(edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT));
			}
			tikuPayEventEntity = pvuEmployeTikuPayRepository.save(tikuPayEventEntity);
			PVUEmployeTikuPayDto tikuPayDto = this.pvuEmployeTikuPayConverter.toDTO(tikuPayEventEntity);
			tikuPayDto.setEmployeeNo(pvuEmployeTikuPayDto.getEmployeeNo());
			return tikuPayDto;
		} catch (DataIntegrityViolationException e) {
			logger.error(e.toString(), e);
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	@Override // Fetch All Record...
	public PagebleDTO<PVUEmployeTikuPayDto> getTikuPayDetails(PageDetails pageDetail) throws CustomException {
		try {
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmployeTikuPayEntity> spec = new SpecificationImpl<>();
			PageRequest pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUEmployeTikuPayEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUEmployeTikuPayEntity> page = pvuEmployeTikuPayRepository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					pvuEmployeTikuPayConverter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

// ===============================================Insert in ITR =================================================	
	@ExceptionHandler
	@Transactional(rollbackOn = CustomException.class)
	@Override
	public PVUEmployeTikuPayDto insertWorkFlowData(PvuWFWrapperDto wrapperDto) throws CustomException {
		Date approvedDate = new Date();
		PVUEmployeTikuPayDto tikuPayDto;
		PVUEmployeTikuPayEntity tikuPayEntity = pvuEmployeTikuPayRepository.getOne(wrapperDto.getTrnId());
		if (tikuPayEntity != null) {
			checkTxnInProcess(tikuPayEntity);
			if (tikuPayEntity.getStatus() != null) {
				Boolean isReturn = pvuFacade.callWorkFlowApis(wrapperDto);
				if (isReturn.equals(Boolean.TRUE)) {
					EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = edpLuLookUpInfoRepository
							.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
									Constant.ACTIVE_STATUS, Constant.SUBMIT);
					updateStatus(wrapperDto, approvedDate, empSubmitStatusLookupInfo);
					tikuPayDto = pvuEmployeTikuPayConverter.toDTO(tikuPayEntity);
					workflowStatusUpdate(wrapperDto, approvedDate, tikuPayEntity);
					insertRemarksITRInAuditorVerifierClassIandClassII(wrapperDto);
					insertITR(wrapperDto);
					return tikuPayDto;
				}
				throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
			} else {
				throw new CustomException(HttpStatus.CONFLICT, MsgConstant.TRN_ALREADY_APPROVED);
			}
		} else {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
		}
	}

	public void checkTxnInProcess(PVUEmployeTikuPayEntity tikuPayEntity) throws CustomException {
		PVUEmployeeEventStatusEntity statusEntry;
		if (tikuPayEntity.getTrnNo() == null) { // && tikuPayEntity.getStatus().getLookUpInfoId() ==
												// PvuConstant.SAVE_AS_DRAFT_ID
			statusEntry = statusService.inProgressAnyEvent(tikuPayEntity.getEmployeeId().getEmpId()); // Check Employee
																										// in progress
			statusEntry.setTikuPay(Constant.ACTIVE_STATUS);
			tikuPayEntity.setTrnNo(this.pvuCommonService.getTransactionNumber(Constant.TK));
			tikuPayEntity.setRefDate(LocalDateTime.now());
			pvuEmployeTikuPayRepository.save(tikuPayEntity);
			statusService.updateEventInfo(statusEntry, tikuPayEntity.getTrnNo());
		}
	}

	public void updateStatus(PvuWFWrapperDto wrapperDto, Date approvedDate,
			EDPLuLookUpInfoEntity empSubmitStatusLookupInfo) {
		if (empSubmitStatusLookupInfo != null) {
			pvuEmployeTikuPayRepository.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(),
					wrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), approvedDate);
		}
	}

	@Transactional(rollbackOn = CustomException.class)
	public void workflowStatusUpdate(PvuWFWrapperDto wrapperDto, Date approvedDate,
			PVUEmployeTikuPayEntity tikuPayEntity) throws CustomException {

		if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) { // Approved

			EDPLuLookUpInfoEntity printEnable = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.CONDITION_CHECK,
							Constant.ACTIVE_STATUS, Constant.LOOKUP_YES);

			EDPLuLookUpInfoEntity empApprovStatsLookupInfo = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.APPROVED);
			tikuPayEntity.setStatus(empApprovStatsLookupInfo);
			pvuEmployeTikuPayRepository.updateStatusId(empApprovStatsLookupInfo.getLookUpInfoId(),
					wrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), approvedDate);
			pvuEmployeTikuPayRepository.updatePrintStatusAndApproveDate(empApprovStatsLookupInfo.getLookUpInfoId(),
					Constant.ACTIVE_STATUS, wrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), new Date(),
					printEnable.getLookUpInfoId(), LocalDateTime.now());
		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.PULLED_BACK)) {
			updateForPulledBack(wrapperDto, tikuPayEntity);/* Inactive inward row */
		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) { // Rejected
			EDPLuLookUpInfoEntity empRejectStatsLookupInfo = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.REJECTED);
			pvuEmployeTikuPayRepository.updateStatusId(empRejectStatsLookupInfo.getLookUpInfoId(),
					wrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), approvedDate);
			resetInProgressEmployeeEvent(tikuPayEntity.getEmployeeId().getEmpId(), PvuConstant.TIKU_PAY_EVENT_ID);
		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.FORWARD_TO_PVU)) { // Forward to PVU
			this.insertInwardTable(wrapperDto);
		} else if (wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)
				|| wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_I)) {
			/* Update Status ApproverClass II Authorization */
			String authorizerRemark;
			if (wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)) {
				authorizerRemark = tikuPayEntity.getClassTwoRemarks();
			} else {
				authorizerRemark = tikuPayEntity.getClassOneRemarks();
			}

			EDPLuLookUpInfoEntity authorizationStatus = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.RECOMMENDATION_FOR,
							Constant.ACTIVE_STATUS, Constant.AUTHORIZE);
			pvuEmployeTikuPayRepository.updateStatusIdAndAuthorizer(authorizationStatus.getLookUpInfoId(),
					wrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), new Date(), LocalDateTime.now(),
					Long.parseLong(securityUtil.decrypt(wrapperDto.getAssignByUserId())), authorizerRemark);
			pvuInwardRepository.setAuthorizeDateAndFlag(wrapperDto.getTrnId(), PvuConstant.TIKU_PAY_EVENT_ID,
					OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(), Constant.OUTWARD_FLAG_ZERO,
					Constant.ACTIVE_STATUS);
		} else if (wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_II)
				|| wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_I)) {
			/* Update Status ApproverClass II Return */
			EDPLuLookUpInfoEntity returnStatus = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.RECOMMENDATION_FOR,
							Constant.ACTIVE_STATUS, Constant.RETURN);
			pvuEmployeTikuPayRepository.updateStatusId(returnStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), new Date());

			pvuInwardRepository.setReturnDateAndFlag(wrapperDto.getTrnId(), PvuConstant.TIKU_PAY_EVENT_ID,
					OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(), Constant.OUTWARD_FLAG_ONE,
					Constant.ACTIVE_STATUS);

		}
	}

	public void insertRemarksITRInAuditorVerifierClassIandClassII(PvuWFWrapperDto wrapperDto) {
		if (wrapperDto.getAssignByWfRoleId() == Constant.AUDITOR
				|| Objects.equals(wrapperDto.getAssignByWfRoleId(), Constant.VERIFIER)
				|| wrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_TWO
				|| Objects.equals(wrapperDto.getAssignByWfRoleId(), Constant.APPROVER_CLASS_ONE)) {
			this.insertTikuPayRemarksITR(wrapperDto.getTrnId());
		}
	}

	// Inward...
	public void insertInwardTable(PvuWFWrapperDto wrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, wrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_CREATED_BY, OAuthUtility.getCurrentUserUserId());
		map.put(Constant.IN_CREATED_BY_POST, wrapperDto.getAssignByPostId());
		map.put(Constant.IN_POU_ID, wrapperDto.getAssignByPOUId());
		map.put(Constant.IN_OFFICE_ID, wrapperDto.getAssignByOfficeId());
		map.put(Constant.IN_EVENT_CODE, PVU_TIKU_PAY_EVENT_CODE);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_INWARD_INSERT)); // SP
		pvuEmployeTikuPayRepository.callStoredProcedure(procName, map);

	}

	public void insertTikuPayRemarksITR(Long transId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		map.put(Constant.IN_EVENT_CODE, PvuConstant.PVU_TIKU_PAY_EVENT_CODE);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.INSERT_PVU_EVNT_RMKS_ITR);
		pvuEmployeTikuPayRepository.callStoredProcedure(procName.toString(), map);
	}

	public void resetInProgressEmployeeEvent(Long empId, Long eventId) {
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntity;
		pvuEmployeeEventStatusEntity = statusService.findByEmpId(empId);
		if (pvuEmployeeEventStatusEntity.isPresent()) {
			if (eventId != null && eventId.toString().equals(PvuConstant.TIKU_PAY_EVENT_ID.toString())) {
				pvuEmployeeEventStatusEntity.get().setTikuPay(0);
			}
			pvuEmployeeEventStatusEntity.get().setTransId(null);
			statusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity.get());
		}

	}

	public void insertITR(final PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("IN_TRN_NO", pvuWFWrapperDto.getTrnId());
		map.put("IN_WORKFLOW_ID", pvuWFWrapperDto.getCurrentWorkflowId());
		map.put("IN_WORKFLOW_ROLE_ID", pvuWFWrapperDto.getAssignToWfRoleId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_TP_EVNT_ITRS));
		pvuEmployeTikuPayRepository.callStoredProcedure(procName, map);
	}

// =============================== Start DDO WorkFlow List API Details =========================================================================================
	@Override
	public PagebleDTO<PVUTikuPayEditListView> getTikuPayDDOList(PageDetails pageDetails) throws CustomException {
		Map<String, String> collect = this.getDdoWFListingSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(null, pageDetails, collect);
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.TKP_PVU_EVENT_LS_SRCH_WF));
		List<PVUTikuPayEditListView> list = this.callSSPVUDDOListing(sp, stringObjectMap);
		return new PagebleDTO<>(pageDetails.getPageElement(), 0, list.size(), list);
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

	public List<PVUTikuPayEditListView> callSSPVUDDOListing(String sp, Map<String, Object> parameters)
			throws CustomException {
		List<Object[]> objectPvuSp = pvuEmployeTikuPayRepository.callStoredProcedure(sp, parameters);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUTikuPayEditListView.class)
				: Collections.emptyList();
	}

// ======================================End Edit Event List Details ==================================================================================	
	@Override // Delete API
	@Transactional(rollbackOn = { CustomException.class })
	public boolean deleteTikuPayEventById(IdDto idDto) throws CustomException {
		Optional<PVUEmployeTikuPayEntity> tikuPayEntity = pvuEmployeTikuPayRepository.findById(idDto.getId());
		if (tikuPayEntity.isPresent()) {
			PVUEmployeTikuPayEntity entity = tikuPayEntity.get();
			EDPLuLookUpInfoEntity saveAsDraft = edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
			if (entity.getStatus().getLookUpInfoId() == saveAsDraft.getLookUpInfoId()) {
				pvuEmployeTikuPayRepository.deleteTikuPayEventIdBy(Constant.IN_ACTIVE_STATUS, idDto.getId(),
						OAuthUtility.getCurrentUserUserId(), new Date());
				pvuEmployeeEventStatusService.resetInProgressEmployeeEventStatus(entity.getEmployeeId().getEmpId(),
						OAuthUtility.getCurrentUserLkPOUId());
				return Boolean.TRUE;
			} else {
				throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public String getWfRoleCodeByTrnId(Long trnId) {
		return this.wfRepository.findWfRlCdByTikuPayTrnId(trnId, Constant.ACTIVE_STATUS);
	}

	@Override // Get PVU Office Name
	public EDPMsOfficeDto getTikuPayEmpOfficeName(IdDto idDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("eventId", idDto.getId());
		List<Object[]> objects = pvuEmployeTikuPayRepository
				.executeSQLQuery(PVUNativeSqlQueryConstant.getTikuPayEmpOfficeId(), map);
		if (!Utils.isEmpty(objects)) {
			EDPMsOfficeDto officeDto = new EDPMsOfficeDto();
			officeDto.setOfficeName(String.valueOf(objects.get(0)[0]));
			return officeDto;
		}
		return null;
	}

	@Override // Start Inward Listing
	public PagebleDTO<PVUTikuPayInwardView> getTikypayInwardList(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapInwardList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_INWARD_LIST_WF).toString();
			List<PVUTikuPayInwardView> objStorePro = this.storeProcPvu(procName, map, PVUTikuPayInwardView.class);
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
				PVUSearchEnum.PVU_SEARCH_FIELD_INW_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME, PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
				PVUSearchEnum.PVU_SEARCH_PAN, PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX,
				PVUSearchEnum.PVU_SEARCH_DDO, PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO, PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID,
				PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID);
	}

	public <T> List<T> storeProcPvu(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectPvuSp = pvuEmployeTikuPayRepository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, view) : Collections.emptyList();
	}

	@Override
	public Boolean generateInwardNumber(List<IdDto> dtos) throws CustomException {
		try {
			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
			dtos.forEach(dto -> {
				Map<Integer, Object> map = new HashMap<>();
				map.put(1, Constant.TK);
				map.put(2, dto.getId());
				parameterMapList.add(map);
			});
			return pvuEmployeTikuPayRepository.callStoreProcBatch("{CALL "
					+ Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INWARD_NO_GENERATION_PVU)) + "(?,?)}",
					parameterMapList);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public Boolean submiTikuPayInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	} // End Inward

	@Override // Start Distributer
	public Boolean submitTikupayDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	@Override // Auditor Listing
	public PagebleDTO<PVUTikuPayOfficeSearchView> pvuAuditorList(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, String> collect = this.getPvuOfficeSearchFields().stream()
					.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
			StringBuilder procName = new StringBuilder();
			procName.append(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.COMMON_FIVE_EVENT_LIST_SEARCH_WF_PVU);
			List<Object[]> objStorePro = pvuEmployeTikuPayRepository.callStoredProcedure(procName.toString(), map);
			if (!Utils.isEmpty(objStorePro)) {
				List<PVUTikuPayOfficeSearchView> list = NativeQueryResultsMapper.map(objStorePro,
						PVUTikuPayOfficeSearchView.class);
				list.forEach(e -> e.setEventCode(PVU_TIKU_PAY_EVENT_CODE));
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

	@Override
	public Map<String, Object> getPVUResponse(IdDto dto) throws CustomException {
		PVUEmployeTikuPayEntity tikuPayEntity = getEmployeTikuPay(dto.getId());
		Map<String, Object> response = new HashMap<>();

		PVUEmployeTikuPayCurrentDto tikuPayCurrentDto = setAuditorCurrentDetails(tikuPayEntity);
		PVUEmployeTikuPayPostDetailsDto tikuPayPostDetailsDto = pvuEmployeTikuPayConverter
				.setAuditorPostDetails(tikuPayEntity);

		response.put("currentDetails", tikuPayCurrentDto);
		response.put("postDetails", tikuPayPostDetailsDto);
		return response;
	}

	public PVUEmployeTikuPayCurrentDto setAuditorCurrentDetails(PVUEmployeTikuPayEntity tikuPayEntity)
			throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put("IN_PAGE_INDEX", 0);
		map.put("IN_PAGE_SIZE", 250);
		if (!Utils.isEmpty(tikuPayEntity.getEventEffectiveDate())) {
			map.put(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getValue(),
					PvuUtils.getStrOfLocalDateInYMD(tikuPayEntity.getEventEffectiveDate()));
		}
		map.put("IN_EVENT_ID", 0);
		if (!Utils.isEmpty(tikuPayEntity.getPayType())) {
			map.put("IN_TIKU_PAY_TYPE", tikuPayEntity.getPayType().getLookUpInfoId());
		}
		if (!Utils.isEmpty(tikuPayEntity.getEmployeeId())) {
			map.put(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getValue(), tikuPayEntity.getEmployeeId().getEmployeeCode());
		}
		if (!Utils.isEmpty(tikuPayEntity.getOfficeId())) {
			map.put("IN_OFFICE_ID", tikuPayEntity.getOfficeId().getOfficeId());
		}
		if (!Utils.isEmpty(tikuPayEntity.getPayCommId())) {
			map.put(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getValue(), tikuPayEntity.getPayCommId().getLookUpInfoId());
		}

		// Set Current Details
		PVUTikuPayApiDto pvuTikuPayApiDto = this.currentDetailsOfEmployee(map);

		return pvuEmployeTikuPayConverter.auditorCurrentDetails(pvuTikuPayApiDto, tikuPayEntity);
	}

	@Override
	public List<PVUMsReasonDto> getTikupayReasons() {
		return pvuMsReasonService.getEventsReasons();
	}

	@Override
	public List<PVUEventRemarksDto> getReturnReasonByTransactionId(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.PVU_EVENT_ID, PvuConstant.TIKU_PAY_EVENT_ID);
		map.put(PvuConstant.CS_PVU_EVENT_ID, id);
		map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
		List<Object[]> objects = remarkRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getCsEventReturnRemarks(),
				map);
		return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PVUEventRemarksDto.class)
				: Collections.emptyList();
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

	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public PVUEmployeTikuPayDto updateTikupayRemarks(PVUEmployeTikuPayDto tikuPayDto) throws CustomException {
		PVUEmployeTikuPayEntity entity = pvuEmployeTikuPayConverter
				.updateTikyPayRemarks(getTikuPayById(tikuPayDto.getId()), tikuPayDto);
		PVUEmployeTikuPayEntity updateTikuEntity = pvuEmployeTikuPayRepository.save(entity);
		if (!Utils.isEmpty(tikuPayDto.getReturnReasons())) {
			Long wfRoleId = tikuPayDto.getWfRoleId();
			String remarkType = getRemarkType(tikuPayDto.getWfRoleId());
			boolean isReturnReason = false;

			if (((!Utils.isEmpty(tikuPayDto.getAuditorReturnReason()))
					&& tikuPayDto.getAuditorReturnReason() == Constant.RETURN_VAL)
					|| ((!Utils.isEmpty(tikuPayDto.getVerifierReturnReason()))
							&& tikuPayDto.getVerifierReturnReason() == Constant.RETURN_VAL)
					|| ((!Utils.isEmpty(tikuPayDto.getClassTwoReturnReason()))
							&& tikuPayDto.getClassTwoReturnReason() == Constant.RETURN_VAL)
					|| ((!Utils.isEmpty(tikuPayDto.getClassOneReturnReason()))
							&& tikuPayDto.getClassOneReturnReason() == Constant.RETURN_VAL)) {
				isReturnReason = tikuPayDto.getAuditorReturnReason() == Constant.RETURN_VAL
						|| tikuPayDto.getVerifierReturnReason() == Constant.RETURN_VAL
						|| tikuPayDto.getClassOneReturnReason() == Constant.RETURN_VAL
						|| tikuPayDto.getClassTwoReturnReason() == Constant.RETURN_VAL;
			}
			if (isReturnReason) {
				// Need to deactive old reason
				eventRemarksService.deactiveOldReason(PvuConstant.TIKU_PAY_EVENT_ID, tikuPayDto.getId(),
						Constant.IN_ACTIVE_STATUS);
				// Need to insert new reason
				List<PVUEventRemarksEntity> lstRopRemarks = tikuPayDto.getReturnReasons().stream().map(remarkDto -> {
					PVUEventRemarksEntity pvuEventRemarksEntity = new PVUEventRemarksEntity();
					pvuEventRemarksEntity.setTrnNo(tikuPayDto.getId());
					pvuEventRemarksEntity.setEventID(PvuConstant.TIKU_PAY_EVENT_ID);
					pvuEventRemarksEntity.setWfRoleId(wfRoleId);
					pvuEventRemarksEntity.setEmpId(tikuPayDto.getEmpId());
					pvuEventRemarksEntity.setRemarks(remarkDto.getRemarks());
					pvuEventRemarksEntity.setRemarksType(remarkType);
					pvuEventRemarksEntity.setReason(remarkDto.getReasonId());
					pvuEventRemarksEntity.setActiveStatus(Constant.ACTIVE_STATUS);
					return pvuEventRemarksEntity;
				}).collect(Collectors.toList());
				eventRemarksService.saveOrUpdateRemarksAll(lstRopRemarks);
			}
		}
		return pvuEmployeTikuPayConverter.toDTO(updateTikuEntity);
	}

	@Override
	public PagebleDTO<PVUCSPOutwardView> getOutwardList(PageDetails pageDetail) throws CustomException {
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

	public Map<String, Object> buildPageInMaps(PageDetails pageDetail) {
		Map<String, String> collect = getOutwardSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	public List<PVUSearchEnum> getOutwardSearchFields() {

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

	@Override
	public Boolean generateOutwardNumber(List<IdDto> dtos) throws CustomException {
		try {
			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
			dtos.forEach(dto -> {
				Map<Integer, Object> map = new HashMap<>();
				map.put(1, Constant.TK);
				map.put(2, dto.getId());
				parameterMapList.add(map);
			});
			return pvuEmployeTikuPayRepository.callStoreProcBatch("{CALL "
					+ Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.OUTWARD_NO_GENERATION_PVU)) + "(?,?)}",
					parameterMapList);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	@Transactional
	public Boolean submitOutward(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException {
		try {
			wrapperDto.forEach(dto -> pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(),
					new Date(), PvuConstant.TIKU_PAY_EVENT_ID, dto.getTrnId(), Constant.OUTWARD_FLAG_ZERO,
					Constant.ACTIVE_STATUS));
			wrapperDto.forEach(e -> inwardService.setConsignmentNumber(e.getTrnId(), PvuConstant.TIKU_PAY_EVENT_ID,
					e.getPostConsignmentNumber()));

			List<PvuWFOutWardWrapperDto> authList = wrapperDto.stream()
					.filter(e -> Objects.nonNull(e.getStatus()) && e.getStatus().equalsIgnoreCase(Constant.AUTHORIZE))
					.collect(Collectors.toList());

			List<PvuWFOutWardWrapperDto> rWFlist = wrapperDto.stream()
					.filter(e -> Objects.nonNull(e.getStatus()) && e.getStatus().equalsIgnoreCase(Constant.RETURN))
					.collect(Collectors.toList());
			return processReturnOutWards(rWFlist) && processAuthorizedOutWards(authList);

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
		map.put(PvuConstant.EVENT_ID, PvuConstant.TIKU_PAY_EVENT_ID);
		map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
		List<Object[]> objects = pvuEmployeTikuPayRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getWfTable(),
				map);
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
			List<Object[]> returnObjects = pvuEmployeTikuPayRepository.executeSQLQuery(PVUNativeSqlQueryConstant
					.getWfSourceUserDetail(tableList.get(0).getSchemaName(), tableList.get(0).getTableName()),
					returnMap);
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
					PvuConstant.TIKU_PAY_EVENT_ID, authDto.getTrnId(), Constant.OUTWARD_FLAG_ZERO,
					Constant.ACTIVE_STATUS);

			PVUEmployeTikuPayEntity tikuPayEntity = pvuEmployeTikuPayRepository.getOne(authDto.getTrnId());
			PVUEmployeTikuPayDto tikuPayDto = pvuEmployeTikuPayConverter.toDTO(tikuPayEntity);

			// Update TikuPay Dates
			if (tikuPayDto.getTikuType() == PvuConstant.TIKU_PAY_ONE) {
				tikuPayEntity.setTikuPayDateOne(tikuPayDto.getBenEffDate());
				pvuEmployeTikuPayRepository.save(tikuPayEntity);
			}
			if (tikuPayDto.getTikuType() == PvuConstant.TIKU_PAY_TWO) {
				tikuPayEntity.setTikuPayDateOne(tikuPayDto.getTikuPay1());
				tikuPayEntity.setTikuPayDateTwo(tikuPayDto.getBenEffDate());
				pvuEmployeTikuPayRepository.save(tikuPayEntity);
			}
			if (tikuPayDto.getTikuType() == PvuConstant.TIKU_PAY_THREE) {
				tikuPayEntity.setTikuPayDateOne(tikuPayDto.getTikuPay1());
				tikuPayEntity.setTikuPayDateTwo(tikuPayDto.getTikuPay2());
				pvuEmployeTikuPayRepository.save(tikuPayEntity);
			}

			authorize(authDto.getTrnId());
			insertAutoIncr(tikuPayEntity.getTrnNo());
			resetInProgressEmployeeEvent(tikuPayEntity.getEmployeeId().getEmpId(), authDto.getEventId());

		});
		authList.forEach(e -> e.setWfStatus(PvuConstant.AUTHORIZED));
		return pvuFacade.callWorkFlowApis(PvuWFOutWardWrapperDto.createSuper(authList));
	}

	public void authorize(Long trnId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnId);
		map.put(Constant.IN_EVENT_CODE, PvuConstant.PVU_TIKU_PAY_EVENT_CODE);
		pvuEmployeTikuPayRepository
				.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.PVU_COMMON_AUTHORIZED_SP, map);
	}

	public void insertAutoIncr(String trnNo) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		map.put(Constant.IN_EVNT_CODE, PvuConstant.PVU_TIKU_PAY_EVENT_CODE);
		pvuEmployeTikuPayRepository
				.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map);
	}

	@Override
	public PagebleDTO<PVUCsPrintEndorsementView> getPrintEndorsementsList(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapPrint(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF).toString();
			List<PVUCsPrintEndorsementView> objStorePro = this.storeProcPvu(procName, map,
					PVUCsPrintEndorsementView.class);
			int totalPages = objStorePro.size();
			if (!Utils.isEmpty(objStorePro)) {
				objStorePro.forEach(e -> e.setEventCode(PvuConstant.PVU_TIKU_PAY_EVENT_CODE));
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
			}
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public Map<String, Object> buildPageInMapPrint(PageDetails pageDetail) {
		Map<String, String> collect = getPrintSPSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

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
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID, PVUSearchEnum.PVU_SEARCH_PRINT_STATUS);
	}

	public Template getPrintTemplate(PVUEmployeTikuPayEntity tikuPayEntity) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template template = new Template();
		if (!Utils.isEmpty(tikuPayEntity.getPayCommId())) {
			if (tikuPayEntity.getPayCommId().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
				template = ve.getTemplate("templates/tikupay/tikupay7th.vm");
			} else if (tikuPayEntity.getPayCommId().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
				template = ve.getTemplate("templates/tikupay/tikupay6th.vm");
			} else if (tikuPayEntity.getPayCommId().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
				template = ve.getTemplate("templates/tikupay/tikupay5th.vm");
			}
		}
		return template;
	}

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
					dto.getPrintEndorsementDto().setEventId(PvuConstant.TIKU_PAY_EVENT_ID);
				} else {
					/** For authorized case, and final reflection done by this */
					Boolean result = pvuFacade.callWorkFlowApis(dto.getPvuWFWrapperDto());
					isWorkflowResponse(dto, result);
				}
				printEntity = pvuPrintEndorsementRepository
						.save(pvuEmployeTikuPayConverter.toPrintEntity(dto.getPrintEndorsementDto()));
				pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrConverter.toEntity(printEntity));
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return printEntity != null ? pvuEmployeTikuPayConverter.toPrintDTO(printEntity) : null;
	}

	public void isWorkflowResponse(PvuPrintStickerReportDto dto, Boolean result) {
		if (result.equals(Boolean.TRUE)) {
			pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
					PvuConstant.TIKU_PAY_EVENT_ID, dto.getPvuWFWrapperDto().getTrnId(), Constant.OUTWARD_FLAG_ONE,
					Constant.ACTIVE_STATUS);
			dto.getPrintEndorsementDto().setPrintCnt(dto.getPrintEndorsementDto().getPrintCnt() + 1l);
			dto.getPrintEndorsementDto().setPrintDate(new Date());
			dto.getPrintEndorsementDto().setTrnId(dto.getPvuWFWrapperDto().getTrnId());
			dto.getPrintEndorsementDto().setEventId(PvuConstant.TIKU_PAY_EVENT_ID);
		}
	}

	@Override
	public List<PVUPrintEndorsementRemarkHistoryDto> getPrintEndorsementHistory(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put("trnId", id);
		map.put("eventId", PvuConstant.TIKU_PAY_EVENT_ID);
		List<Object[]> objects = pvuEmployeTikuPayRepository
				.executeSQLQuery(PVUNativeSqlQueryConstant.getCommonEndorsementHistory(), map);
		return !Utils.isEmpty(objects)
				? NativeQueryResultsMapper.map(objects, PVUPrintEndorsementRemarkHistoryDto.class)
				: Collections.emptyList();
	}

// ==========================================================================================================================================	
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
			document.addTitle("TikuPay");
			document.setPageSize(PageSize.LETTER);
			PdfWriter pdfWriter = PdfWriter.getInstance(document, baos);

			document.open();
			for (PvuPrintStickerReportDto printStickerReportDto : dto) {
				

				PVUEmployeTikuPayEntity tikuPayEntity = pvuEmployeTikuPayRepository
						.getOne(printStickerReportDto.getPvuWFWrapperDto().getTrnId());

				if (tikuPayEntity.getOfficeId().getOfficeId().equals(tikuPayEntity.getOfficeId().getPvuId())
						&& tikuPayEntity.getOfficeId().getOfficeId() != Constant.PVU_OFFICE_ID) {
					watermark = ", Self PVU";
				} else {
					watermark = ", PVU, Gandhinagar";
				}
				pdfWriter.setPageEvent(
						new WatermarkPageEvent(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()), watermark));
				writer.write(generateTikyPayPdf(printStickerReportDto).toString());
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
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private StringWriter generateTikyPayPdf(PvuPrintStickerReportDto dto) throws CustomException {

		PVUStickerDTO stickerDTO = null;
		try {
			stickerDTO = submitPrintHistory(dto);

			PVUEmployeTikuPayEntity tikuPayEntity = pvuEmployeTikuPayRepository
					.getOne(dto.getPvuWFWrapperDto().getTrnId());
			pvuEmployeTikuPayConverter.toDTO(tikuPayEntity);

			PVUEmployeTikuPayDto tikuPayDto = pvuEmployeTikuPayConverter.toDTO(tikuPayEntity);

			VelocityContext context = pvuEmployeTikuPayConverter.populateVContext(stickerDTO, tikuPayEntity,
					tikuPayDto);
			StringWriter writer = new StringWriter();
			Template template = getPrintTemplate(tikuPayEntity);
			template.merge(context, writer);
			return writer;
		} catch (CustomException ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	/**
	 * Validate pay commission applicability. Whether selected Pay commission is
	 * applicable for given effective date or not
	 *
	 * @param empId     the emp id
	 * @param eventDate the event date
	 * @param payCommId the pay comm id
	 * @throws CustomException the custom exception
	 * @throws ParseException  the parse exception
	 */
	private void validatePayCommApplicability(Map<String, Object> map, Long empId, Date doj, Boolean isViewPage)
			throws CustomException, ParseException {
		if (Boolean.TRUE.equals(isViewPage))
				 return;
		LocalDate eventDate = PvuUtils
				.getDateFromStringYMD(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getValue()).toString());
		Long payCommission = Long.valueOf(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getValue()).toString());
		
		empPayDetailService.validatePayCommision(empId, Utils.convertToDate(eventDate), payCommission, doj);
	}

	/**
	 * Update for pulled back.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @param pvuEntity       the pvu entity
	 */
	private void updateForPulledBack(PvuWFWrapperDto pvuWFWrapperDto, PVUEmployeTikuPayEntity pvuEntity) {
		inwardService.updateStatusId(Constant.INACTIVE_STATUS, pvuEntity.getId(), new Date(),
				pvuWFWrapperDto.getEventId());
	}
}
