package gov.ifms.pvu.common;

import static gov.ifms.pvu.entity.PVUEmployeEventsEntity.distinctByKey;
import static gov.ifms.pvu.util.PvuConstant.NOT_FOUND_BASIC_PAY_FOR_PAY_LEVEL_AND_CELL;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import gov.ifms.pvu.dto.request.PVUOptAvDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPLuLookUpResponse;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.entity.EDPMsSubOfficeEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsSubOfficeRepository;
import gov.ifms.edp.service.EDPLuLookUpInfoService;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.converter.PVUMsPayCellConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeForgoDto;
import gov.ifms.pvu.dto.PVUEmployeSevenPayDetailDto;
import gov.ifms.pvu.dto.PVUEventScreenEightView;
import gov.ifms.pvu.dto.PVUHigherPayView;
import gov.ifms.pvu.dto.PVUMsPayCellDto;
import gov.ifms.pvu.dto.PVUPayDetailsView;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.dto.response.PVUCommonHigherPayDto;
import gov.ifms.pvu.dto.response.PVUEventApiResponseDto;
import gov.ifms.pvu.dto.response.PVUInwardLookupResponse;
import gov.ifms.pvu.dto.response.PVUMsGradePayFormatDto;
import gov.ifms.pvu.dto.response.PVUMsPayCellFormatDto;
import gov.ifms.pvu.dto.response.PVUMsSevenPayFormatDto;
import gov.ifms.pvu.dto.response.PVUMsSixPayFormatDto;
import gov.ifms.pvu.dto.response.PVUOfficeApprover;
import gov.ifms.pvu.dto.response.PVUOutwardLookupResponse;
import gov.ifms.pvu.entity.PVUDepartmentCategoryEntity;
import gov.ifms.pvu.entity.PVUEmployeCCCExamDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeDeptExamDetailsEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeFixPayDetailsEntity;
import gov.ifms.pvu.entity.PVUEmployeHigherPayScaleEventEntity;
import gov.ifms.pvu.entity.PVUEmployeLangExamEntity;
import gov.ifms.pvu.entity.PVUEmployeQualificationEntity;
import gov.ifms.pvu.entity.PVUEmployeSixPayDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeSuspensionEntity;
import gov.ifms.pvu.entity.PVUEmployeeEOLeaveEntity;
import gov.ifms.pvu.entity.PVUFixToRegularPayConEntity;
import gov.ifms.pvu.entity.PVUMsCourseEntity;
import gov.ifms.pvu.entity.PVUMsEventEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUPromotionEntity;
import gov.ifms.pvu.repository.PVUDepartmentCategoryRepository;
import gov.ifms.pvu.repository.PVUEmployeCCCExamDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeDeptExamDetailsRepository;
import gov.ifms.pvu.repository.PVUEmployeEventsRepository;
import gov.ifms.pvu.repository.PVUEmployeFixPayDetailsRepository;
import gov.ifms.pvu.repository.PVUEmployeHigherPayScaleEventRepository;
import gov.ifms.pvu.repository.PVUEmployeLangExamRepository;
import gov.ifms.pvu.repository.PVUEmployeQualificationRepository;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVUEmployeSixPayDetailRepository;
import gov.ifms.pvu.repository.PVUFixToRegularPayConRepository;
import gov.ifms.pvu.repository.PVUMsGradePayRepository;
import gov.ifms.pvu.repository.PVUMsPayBandRepository;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import gov.ifms.pvu.repository.PVUMsPayLevelRepository;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.repository.PVUPromotionRepository;
import gov.ifms.pvu.service.PVUEmployeDepartmentService;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployePayDetailService;
import gov.ifms.pvu.service.PVUEmployeService;
import gov.ifms.pvu.service.PVUEmployeSevenPayDetailService;
import gov.ifms.pvu.service.PVUEmployeSuspensionService;
import gov.ifms.pvu.service.PVUEmployeeEOLeaveService;
import gov.ifms.pvu.service.PVUMsEventService;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuMsgConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.workflow.service.MsWorkflowService;

/**
 * The type Pvu common service.
 */
@Service
public class PVUCommonService {

	/**
	 * The logger.
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * The dept exam details repository.
	 */
	@Autowired
	private PVUEmployeDeptExamDetailsRepository deptExamDetailsRepository;

	@Autowired
	private PVUEmployeEventsRepository pvuEmpEvent;

	@Autowired
	private PVUEmployeService employeService;

	@Autowired
	private MsWorkflowService workflowService;

	/**
	 * The PVUEmployeSuspensionRepository suspensionRepository.
	 */
	@Autowired
	private PVUEmployeSuspensionService suspensionService;

	/**
	 * The PVUEmployeSuspensionRepository suspensionRepository.
	 */
	@Autowired
	private PVUEmployeeEOLeaveService eoLeaveService;

	/**
	 * The dept exam details repository.
	 */
	@Autowired
	private PVUEmployeEventsRepository eventsRepository;

	/**
	 * The PVUMsPayBandRepository payBandRepository.
	 */
	@Autowired
	private PVUMsPayBandRepository payBandRepository;

	/**
	 * The PVUMsPayCellRepository payCellRepository.
	 */
	@Autowired
	private PVUMsPayCellRepository payCellRepository;

	/**
	 * The PVUMsPayCellConverter payCellConverter.
	 */
	@Autowired
	private PVUMsPayCellConverter payCellConverter;

	/**
	 * The PVUGradePayRepository repository.
	 */
	@Autowired
	private EDPMsDesignationRepository designationRepository;

	@Autowired
	private PVUEmployeHigherPayScaleEventRepository higherPayScaleEventRepository;

	@Autowired
	private PVUPromotionRepository promotionRepository;
	/**
	 * The ccc exam detail repository.
	 */
	@Autowired
	private PVUEmployeCCCExamDetailRepository cccExamDetailRepository;

	/**
	 * The lang exam repository.
	 */
	@Autowired
	private PVUEmployeLangExamRepository langExamRepository;

	/**
	 * The EDPLuLookUpInfoRepository repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/**
	 * The EDPLuLookUpInfoService repository.
	 */
	@Autowired
	private EDPLuLookUpInfoService lookUpInfoService;

	/**
	 * The e DP ms designation repository.
	 */
	@Autowired
	private EDPMsDesignationRepository eDPMsDesignationRepository;

	/**
	 * The district repository.
	 */
	@Autowired
	private EDPMsDistrictRepository districtRepository;

	/**
	 * The PVUEmployeRepository repository.
	 */
	@Autowired
	private PVUEmployeRepository repository;

	/**
	 * The PVUEmployeQualificationRepository pvuEmployeQualificationRepository.
	 */
	@Autowired
	private PVUEmployeQualificationRepository pvuEmployeQualificationRepository;

	/**
	 * The PVUEmployeRepository repository.
	 */
	@Autowired
	private PVUMsPayScaleRepository scaleRepository;

	/**
	 * The PVUMsGradePayRepository repository.
	 */
	@Autowired
	private PVUMsGradePayRepository gradePayRepository;

	@Autowired
	private EDPMsSubOfficeRepository edpMsSubOfficeRepository;

	@Autowired
	private PVUEmployeDepartmentRepository pvuEmployeeDepartmentRepo;

	@Autowired
	private PVUDepartmentCategoryRepository pvuDepartmentCategoryRepository;

	@Autowired
	private PVUEmployeDepartmentService pvuEmployeDepartmentService;

	@Autowired
	private PVUEmployeSevenPayDetailService pvuEmployeSevenPayDetailService;

	@Autowired
	private PVUMsEventService service;

	@Autowired
	private PVUEmployeRepository pvuEmployeRepository;

	@Autowired
	private PVUEmployeEventsService eventsService;

	@Autowired
	private PVUEmployeSixPayDetailRepository employeSixPayDetailsRepository;

	@Autowired
	private PVUPrintEndorsementItrRepository printItrRepository;

	@Autowired
	private PVUPrintEndorsementRepository printRepository;

	@Autowired
	private PVUEmployePayDetailService empPayDetailService;

	@Autowired
	private PVUEmployeFixPayDetailsRepository fixPayDetailsRepository;

	@Autowired
	private PVUMsPayLevelRepository payLevelRepository;
	
	@Autowired
	private PVUFixToRegularPayConRepository fixToRegularPayConRepository;
	
	

	/** The node js api url. */
	@Value("${node.url}")
	private String nodeUrl;

	private static final Font CAT_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 50, Font.NORMAL, BaseColor.LIGHT_GRAY);

	/**
	 * Gets all pay commission.
	 *
	 * @return the all pay commission
	 */
	public List<EDPLuLookUpInfoEntity> getAllPayCommission() {
		return lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(
				PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS);
	}

	/**
	 * To map list.
	 *
	 * @param events the events
	 * @return the list
	 */
	public List<Map<String, Object>> toMap(List<EDPLuLookUpInfoEntity> events) {
		return events.stream().map(e -> this.toObj(e.getLookUpInfoId(), e.getLookUpInfoName()))
				.collect(Collectors.toList());
	}

	private Map<String, Object> toObj(long id, String name) {
		Map<String, Object> response = new HashMap<>();
		response.put(PvuConstant.ID, id);
		response.put(PvuConstant.NAME, name);
		return response;
	}

	/**
	 * Gets pay master.
	 *
	 * @param request PvuCommonRequest
	 * @return the pay master
	 */
	public Map<Object, Object> getPayMaster(PvuCommonRequest request) {
		Map<Object, Object> elseResponse = new HashMap<>();
		if (request != null && request.getRequest() != null) {
			Map<String, Long> map = request.getRequest();
			Long departmentCategoryId = map.get("departmentCategoryId");
			Long payCommissionId = map.get("payCommissionId");
			if (departmentCategoryId != null && payCommissionId != null) {
				getPMByDeptCatAndPayCom(elseResponse, departmentCategoryId, payCommissionId);
			} else if (departmentCategoryId != null) {
				getPayCommByDeptCatId(elseResponse, departmentCategoryId);
			}
		} else {
			elseResponse.put(PvuConstant.SEVENTH_COMMISSION_ID, getSevenPayCommissionMaster(null));
			elseResponse.put(PvuConstant.SIXTH_COMMISSION_ID, getSixPayCommissionMaster(null));
			Map<Integer, List<Map<String, Object>>> collect = this.scaleRepository
					.findAllByPayCommissionIn(Arrays.asList(PvuConstant.FIVE_COMMISSION, PvuConstant.FOURTH_COMMISSION))
					.stream().collect(Collectors.groupingBy(PVUMsPayScaleEntity::getPayCommission, Collectors
							.mapping(e -> this.toObj(e.getPayScaleId(), e.getScaleValue()), Collectors.toList())));
			elseResponse.put(PvuConstant.FIFTH_COMMISSION_ID, collect.get(PvuConstant.FIVE_COMMISSION));
			elseResponse.put(PvuConstant.FOURTH_COMMISSION_ID, collect.get(PvuConstant.FOURTH_COMMISSION));
		}
		return elseResponse;
	}

	public Map<Object, Object> getPayMasterCommission(PvuCommonRequest request) {
		Map<Object, Object> elseResponse = new HashMap<>();
		if (request != null && request.getData() != null) {
			Map<String, Object> data = request.getData();
			Long departmentCategoryId = Long.valueOf(data.get("departmentCategoryId").toString());
			Long payCommissionId = Long.valueOf(data.get("payCommissionId").toString());
			Long employeeId = Long.valueOf(data.get("employeeId").toString());
			String effectiveDate = data.get(PvuConstant.EFFECTIVE_DATE).toString();
			if (departmentCategoryId != null && payCommissionId != null) {
				getPMByDeptCatAndPayCommission(elseResponse, departmentCategoryId, payCommissionId, employeeId,
						effectiveDate);
			}
		}
		return elseResponse;
	}

	/**
	 * Gets the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	public List<PVUSearchEnum> getPvuSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_ID, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM, PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE);
	}

	/**
	 * Gets pvu search fields for higer pay.
	 *
	 * @return the pvu search fields for higer pay
	 */
	public List<PVUSearchEnum> getPvuSearchFieldsForHigerPay() {
		return Collections.singletonList(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO);
	}

	/**
	 * Builds the page in map.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	public Map<String, Object> buildPageInMap(PageDetails pageDetail) {
		Map<String, String> collect = getPvuSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(new StringBuilder(), pageDetail, collect);
	}

	public Map<String, Object> buildPageInMapEmpSearch(PageDetails pageDetail) {
		Map<String, String> collect = getPvuSearchFieldsNew().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(new StringBuilder(), pageDetail, collect);
	}

	/**
	 * Fetch all the employee details.
	 *
	 * @param pageDetail the page detail
	 * @return List<> search common details
	 * @throws CustomException the custom exception
	 */
	public Map<String, Object> getSearchCommonDetails(PageDetails pageDetail) throws CustomException, ParseException {
		Map<String, Object> main = new HashMap<>();
		Map<String, Object> map = buildPageInMap(pageDetail);
		PVUEmployeDepartmentEntity deptEntity = validateEmployeeType(
				PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getKey()),
				PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_MENU_ID.getKey()));
		PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getKey());
		
		if (!(PvuConstant.SUSPENSION.equals(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_MENU_ID.getKey())) &&
				PvuConstant.FIX_PAY_COMMISSION_ID.equals(Long.parseLong(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getValue()).toString())))) {
			
				validatePayCommision(deptEntity.getPvuEmployeEntity().getEmpId(),
				PvuUtils.getDateFromStringYMD(
						map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getValue()).toString()),
				Long.parseLong(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getValue()).toString()),
				deptEntity.getDateOfJoiningGOG(),
				Boolean.valueOf(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_VIEW_PAGE.getKey())));
		} else {
			
			if (PvuConstant.SUSPENSION.equals(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_MENU_ID.getKey()))) {
				map.put(PVUSearchEnum.PVU_SEARCH_FIELD_IN_MENU_ID.getKey(), PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_IN_MENU_ID.getKey()));
			}
			
			if (PvuUtils.getDateFromStringYMD(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getValue()).toString()).
					isBefore(PvuUtils.convertLocalDate(deptEntity.getDateOfJoiningGOG()))) {
				throw new CustomException(HttpStatus.CONFLICT, MsgConstant.COMMON_PAYCOMM_DOJ);
			}
		}
		
		this.includeCurrentOffice(map);
		PVUCommonApiDto pvuCommonApiDto = this.getCommonDetailsBasedOnEventDate(map);
		fetchExamDetail(main, pvuCommonApiDto.getEmployeeId());
		main.put(PvuConstant.EMPLOYEE, pvuCommonApiDto);
		return main;
	}

	public void includeCurrentOffice(Map<String, Object> map) {
		map.put("IN_OFFICE_ID", OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId());
	}

	private void fetchExamDetail(Map<String, Object> main, Long employeeId) {
		Map<String, Object> response = new HashMap<>();
		List<PVUEmployeDeptExamDetailsEntity> deptExam = deptExamDetailsRepository
				.findPVUEmployeDeptExamDetailsEntityBypvuEmployeEntityEmpIdAndActiveStatus(employeeId,
						Constant.ACTIVE_STATUS);
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
				.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(employeeId,
						Constant.ACTIVE_STATUS);
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
				.findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(employeeId, Constant.ACTIVE_STATUS);
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

	/**
	 * Gets common details based on event date.
	 *
	 * @param map sp search parameter
	 * @return the common details based on event date
	 * @throws CustomException the custom exception
	 */
	public PVUCommonApiDto getCommonDetailsBasedOnEventDate(Map<String, Object> map) throws CustomException {
		String menuId = null ;
		
		if (map.containsKey(PVUSearchEnum.PVU_SEARCH_FIELD_IN_MENU_ID.getKey())) {
			menuId = (String) map.get(PVUSearchEnum.PVU_SEARCH_FIELD_IN_MENU_ID.getKey());
			if (PvuConstant.SUSPENSION.equals(menuId)) {
				map.remove(PVUSearchEnum.PVU_SEARCH_FIELD_IN_MENU_ID.getKey());
			}
		}
		
		List<PVUCommonApiDto> objStorePro = this
				.callSp(Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_SP)), map);
		if (CollectionUtils.isEmpty(objStorePro)) {
			validateOffice(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getValue()).toString());

			if (PvuConstant.SUSPENSION.equals(menuId) &&
					PvuConstant.FIX_PAY_COMMISSION_ID.equals(Long.parseLong(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getValue()).toString()))) {
				throw new CustomException(HttpStatus.CONFLICT, PvuMsgConstant.ERROR_MSG_SELECT_FIX_PAY_EMP);
			}
		}
		return objStorePro.get(0);
	}

	private Map<String, Object> buildPageInMapForHigerPay(PageDetails pageDetail) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append((OAuthUtility.getCurrentUserUserId())).append(Constant.COMMA);
		Map<String, String> collect = getPvuSearchFieldsForHigerPay().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(new StringBuilder(), pageDetail, collect);
	}

	/**
	 * Lookup employee reversion sp.
	 *
	 * @param procName the proc name
	 * @return the list
	 */
	private List<PVUCommonApiDto> callSp(String procName, Map<String, Object> objectMap) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, objectMap);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUCommonApiDto.class)
				: Collections.emptyList();
	}

	/**
	 * Gets all active designations.
	 *
	 * @return the all active designations
	 */
	public List<Map<String, Object>> getAllActiveDesignations() {
		List<EDPMsDesignationEntity> all = designationRepository.findByActiveStatusEquals(Constant.ACTIVE_STATUS);
		return all.stream().map(e -> this.toObj(e.getDesignationId(), e.getDesignationName()))
				.collect(Collectors.toList());
	}

	/**
	 * Gets all sub office.
	 *
	 * @param id the id
	 * @return the all sub office
	 */
	public List<Map<String, Object>> getAllSubOffice(long id) {
		List<EDPMsSubOfficeEntity> all = edpMsSubOfficeRepository.findByOfficeIdOfficeIdAndActiveStatus(id,
				Constant.ACTIVE_STATUS);
		return all.stream().map(e -> this.toObj(e.getSubOfficeId(), e.getSubOfficeName())).collect(Collectors.toList());
	}

	/**
	 * Gets all dept category.
	 *
	 * @return the all dept category
	 */
	public List<Map<String, Object>> getAllDeptCategory() {
		List<PVUDepartmentCategoryEntity> all = pvuDepartmentCategoryRepository.findAll();
		return all.stream().map(e -> this.toObj(e.getDeptCategoryId(), e.getDepartmentCategoryName()))
				.collect(Collectors.toList());
	}

	/**
	 * Gets pvu events search fields.
	 *
	 * @return the pvu events search fields
	 */
	public List<PVUSearchEnum> getPVUEventsSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_START_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_END_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENTS_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME, PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
				PVUSearchEnum.PVU_SEARCH_FIELD_GPF_NO, PVUSearchEnum.PVU_SEARCH_FIELD_PPAN_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMPLOYEE_TYPE, PVUSearchEnum.PVU_SEARCH_FIELD_WORKFLOW,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID);
	}

	/**
	 * Gets common details pvu event list.
	 *
	 * @param details the details
	 * @return the common details pvu event list
	 * @throws CustomException the custom exception
	 */
	public Object getCommonDetailsPVUEventList(PageDetails details) throws CustomException {
		Map<String, String> collect = getPVUEventsSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		StringBuilder builder = new StringBuilder();
		builder.append(OAuthUtility.getCurrentUserUserId());
		Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(builder, details, collect);
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_PVU_SP));
		return this.callPVUSp(sp, stringObjectMap);
	}

	private List<PVUEventApiResponseDto> callPVUSp(String sp, Map<String, Object> parameters) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(sp, parameters);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEventApiResponseDto.class)
				: Collections.emptyList();
	}

	/**
	 * Gets pf events search fields.
	 *
	 * @return the pf events search fields
	 */
	public List<PVUSearchEnum> getPFEventsSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_START_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_END_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EVENTS_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME, PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
				PVUSearchEnum.PVU_SEARCH_FIELD_GPF_NO, PVUSearchEnum.PVU_SEARCH_FIELD_PPAN_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMPLOYEE_TYPE, PVUSearchEnum.PVU_SEARCH_FIELD_WORKFLOW,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_TRNS_NO);
	}

	/**
	 * Gets common details pf event list.
	 *
	 * @param details the details
	 * @return the common details pf event list
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUEventScreenEightView> getCommonDetailsPFEventList(PageDetails details) throws CustomException {
		Map<String, String> collect = getPFEventsSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		StringBuilder builder = new StringBuilder();
		builder.append(OAuthUtility.getCurrentUserUserId());
		Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(builder, details, collect);
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_PF_SP));
		List<PVUEventScreenEightView> objStorePro = this.callPFSp(sp, stringObjectMap);
		return new PagebleDTO<>(details.getPageElement(), 0, objStorePro.size(), objStorePro);
	}

	private List<PVUEventScreenEightView> callPFSp(String sp, Map<String, Object> parameters) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(sp, parameters);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEventScreenEightView.class)
				: Collections.emptyList();
	}

	/**
	 * Gets all promotion detail.
	 *
	 * @param pageDetail the page detail
	 * @return the all promotion detail
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUHigherPayView> getAllPromotionDetail(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapForHigerPay(pageDetail);
			map.put("in_user_list", 0);
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.GET_PR_EVNT_BY_EMP_ID));
			List<PVUHigherPayView> objStorePro = this.storeProcPvuHigherPay(procName, map);
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Fetch all the employee details.
	 *
	 * @param procName procName
	 * @param map      the page detail
	 * @return List<>
	 * @throws CustomException the custom exception
	 */
	private List<PVUHigherPayView> storeProcPvuHigherPay(String procName, Map<String, Object> map)
			throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUHigherPayView.class)
				: Collections.emptyList();
	}

	/**
	 * Gets transaction number.
	 *
	 * @param eventName the event name
	 * @return the transaction number
	 * @throws CustomException the custom exception
	 */
	public String getTransactionNumber(String eventName) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.TRN_SCREEN, eventName);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.TRANSACTION_NO_GENERATION));
		List<Object[]> nextSequanceNumber = repository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequanceNumber)) {
			return (String) nextSequanceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.TRN_GENERATION_FAILED);
		}
	}

	/**
	 * Validate class level by emp id.
	 *
	 * @param empId           the emp id
	 * @param employeeClassId the employee class id
	 */
	public boolean validateClassLevelByEmpId(long empId, long employeeClassId) {
		boolean status = true;
		long classId = pvuEmployeDepartmentService.getClassIdByEmpId(empId);
		if (classId > employeeClassId) {
			status = false;
		}
		return status;
	}

	/**
	 * Validate not less from doj.
	 *
	 * @param empId the emp id
	 * @param payId the pay id
	 * @throws CustomException the custom exception
	 */
	public void validateNotLessFromDoj(Long empId, long payId) throws CustomException {
		PVUEmployeSevenPayDetailDto dto = pvuEmployeSevenPayDetailService.getEmpByEmpId(empId);
		if (dto.getPayLevel() > payId) {
			throw new CustomException(ErrorResponse.LEVEL_NOT_ALLOWED);
		}
	}

	/**
	 * Gets all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException {
		try {
			Map<String, List<PVUEmployeCreationDDLView>> resultMap;
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EVENT_SEARCH_LOOKUP_SP));
			List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupEmployeeCommonSp(procName);
			List<PVUMsEventEntity> entities = service.getPayFixationEvents();
			List<PVUEmployeCreationDDLView> list = entities.stream().map(entity -> {
				PVUEmployeCreationDDLView pvuEmployeCreationDDLView = new PVUEmployeCreationDDLView();
				pvuEmployeCreationDDLView.setLookupInfoId(entity.getId());
				pvuEmployeCreationDDLView.setLookupInfoName(entity.getEventName());
				pvuEmployeCreationDDLView.setLookupType("event_name");
				return pvuEmployeCreationDDLView;
			}).collect(Collectors.toList());
			lstPVUEmployeCreationDDLView.addAll(list);
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));

			return resultMap;
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Lookup employee reversion sp.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private List<PVUEmployeCreationDDLView> lookupEmployeeCommonSp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, Collections.emptyMap());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	/**
	 * Gets six basic and pay band value.
	 *
	 * @param pvuCommonRequest the pvu common request
	 * @return the six basic and pay band value
	 * @throws CustomException the custom exception
	 */
	public Map<String, Long> getSixBasicAndPayBandValue(PvuCommonRequest pvuCommonRequest) throws CustomException {
		Map<String, Long> response = new HashMap<>();
		Map<String, Long> req = pvuCommonRequest.getRequest();
		Long oldPayBandValue = req.get(PvuConstant.OLD_PAY_BAND_VALUE); // 8800
		Long oldBasic = req.get(PvuConstant.OLD_BASIC); // 11600
		Long optionalAvail = req.get(PvuConstant.OPTIONAL_AVAIL);
		boolean optAvail = optionalAvail != 0;

		Long selectedPayBandId = req.get(PvuConstant.SELECTED_PAY_BAND_ID); // 3

		Long newPayBandValue;
		if (!optAvail) {
			double basic = Math.ceil(oldBasic * 0.03);
			double mod = basic % 10;
			double roundOfTen = mod == 0 ? basic : (basic - mod) + 10;
			newPayBandValue = oldPayBandValue + (long) roundOfTen;
		} else {
			newPayBandValue = oldPayBandValue;
		}

		if (selectedPayBandId != null && selectedPayBandId > 0) {
			PVUMsPayBandEntity selectedPayBand = this.payBandRepository.findById(selectedPayBandId)
					.orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
			if (selectedPayBand.getStartingValue() > newPayBandValue) {
				// set new pay band value to this 9300
				newPayBandValue = selectedPayBand.getStartingValue();
			}
		}
		response.put(PvuConstant.PAY_BAND_VALUE, newPayBandValue);
		return response;
	}

	/**
	 * Gets seven basic and cell.
	 *
	 * @param pvuRequest the pvu request
	 * @return the seven basic and cell
	 * @throws CustomException the custom exception
	 */
	public PVUMsPayCellDto getSevenBasicAndCell(PvuCommonRequest pvuRequest) throws CustomException {
		Map<String, Long> request = pvuRequest.getRequest();
		Long oldPayLevelId = Long.valueOf(String.valueOf(request.get(PvuConstant.OLD_PAY_LEVEL_ID)));// 12
		Long basicValue = Long.valueOf(String.valueOf(request.get(PvuConstant.OLD_CELL_VALUE)));// 73400
		Long payLevelId = Long.valueOf(String.valueOf(request.get(PvuConstant.PAY_LEVEL_ID)));// 15
		Long optionalAvail = request.get(PvuConstant.OPTIONAL_AVAIL);
		boolean optAvail = optionalAvail != 0;
		Optional<PVUMsPayCellEntity> currentState = this.payCellRepository
				.findOneByPayLevelIdAndCellValue(oldPayLevelId, basicValue);
		if (currentState.isPresent()) {
			PVUMsPayCellEntity current = currentState.get();
			if (!optAvail) {
				int currentCellId = current.getCellId();
				currentCellId = currentCellId + 1;
				Optional<PVUMsPayCellEntity> optValue = this.payCellRepository
						.findOneByPayLevelIdAndCellId(oldPayLevelId, currentCellId);
				if (optValue.isPresent()) {
					Long newCellValue = optValue.get().getCellValue();
					Optional<PVUMsPayCellEntity> newBasic = payCellRepository
							.findTop1ByPayLevelIdAndCellValueGreaterThanEqualOrderByCellValue(payLevelId, newCellValue);
					return newBasic.map(e -> payCellConverter.toDTO(e)).orElse(null);
				} else {
					throw new CustomException(200, String.format(
							"Not Found Basic Pay For PayLevel %s and currentCellId %s ", payLevelId, currentCellId));
				}
			} else {
				PVUMsPayCellEntity currentStateCellId = this.payCellRepository
						.findTop1ByPayLevelIdAndCellValueGreaterThanEqualOrderByCellValue(payLevelId, basicValue)
						.orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
				return payCellConverter.toDTO(currentStateCellId);
			}
		} else {
			throw new CustomException(200,
					String.format("Not Found Basic Pay For PayLevel %s and basicValue %s ", payLevelId, basicValue));
		}
	}

	public Map<String, Long> getSevenBasicAndCellPVU(PvuCommonRequest pvuRequest) throws CustomException {

		Map<String, Long> request = pvuRequest.getRequest();
		Map<String, Long> response = new HashMap<>();
		Long oldPayLevelId = request.get(PvuConstant.OLD_PAY_LEVEL_ID);
		Long basicValue = request.get(PvuConstant.OLD_CELL_VALUE);
		Long payLevelId = request.get(PvuConstant.PAY_LEVEL_ID);

		Optional<PVUMsPayCellEntity> currentState = this.payCellRepository
				.findOneByPayLevelIdAndCellValue(oldPayLevelId, basicValue);
		int currentCellId = 0;
		if (currentState.isPresent()) {
			PVUMsPayCellEntity current = currentState.get();
			currentCellId = current.getCellId();
			Optional<PVUMsPayCellEntity> newBasic = payCellRepository
					.findTop1ByPayLevelIdAndCellValueLessThanEqualOrderByCellValueDesc(payLevelId,
							current.getCellValue());
			if (newBasic.isPresent()) {
				Long basicValueNew = newBasic.get().getCellValue();
				long personalPay = 0L;
				if (basicValue > basicValueNew) {
					personalPay = basicValue - basicValueNew;
				}
				response.put(PvuConstant.BASIC_PAY, (basicValue - personalPay));
				response.put(PvuConstant.PERSONAL_PAY, personalPay);
				response.put(PvuConstant.CELL_ID, newBasic.get().getId());
				response.put(PvuConstant.CHANGE_DNI, 0L);
				return response;
			} else {
				Optional<PVUMsPayCellEntity> first = payCellRepository.findOneByPayLevelIdAndCellId(payLevelId,
						Constant.ACTIVE_STATUS);
				if (first.isPresent()) {
					response.put(PvuConstant.CHANGE_DNI, 1L);
					response.put(PvuConstant.BASIC_PAY, first.get().getCellValue());
					response.put(PvuConstant.PERSONAL_PAY, 0L);
					response.put(PvuConstant.CELL_ID, first.get().getId());
					return response;
				} else {
					throw new CustomException(1008,
							String.format(NOT_FOUND_BASIC_PAY_FOR_PAY_LEVEL_AND_CELL, payLevelId, currentCellId));
				}
			}
		} else {
			throw new CustomException(1008,
					String.format(NOT_FOUND_BASIC_PAY_FOR_PAY_LEVEL_AND_CELL, payLevelId, currentCellId));
		}
	}

	/**
	 * Check eligible boolean. To check if available for promotion::: means 180 days
	 * checking
	 *
	 * @param request the request
	 * @return the boolean
	 */
	public boolean checkEligible(PvuCommonRequest request) throws CustomException {
		Map<String, Object> data = request.getData();
		Long employeeId = Long.valueOf(data.get(PvuConstant.EMPLOYEE_ID).toString());
		long count = 0;
		Object dateOfNextIncrement = data.get(PvuConstant.DATE_OF_NEXT_INC);
		if (Objects.isNull(dateOfNextIncrement)) {
			throw new CustomException(1008, "Date Of Next Increment should not be null");
		}
		LocalDate effectiveDate = PvuUtils.getStrToLocalDate(data.get(PvuConstant.EFFECTIVE_DATE).toString());// MM/dd/yyyy
		LocalDate dateOfNextInc = PvuUtils.getStrToLocalDate(dateOfNextIncrement.toString());// MM/dd/yyyy
		if (effectiveDate == null || dateOfNextInc == null) {
			throw new CustomException(1008, "Effective date && Date Of Next Increment should not be null");
		}

		if (PvuUtils.validateDays(effectiveDate, dateOfNextInc, PvuConstant.CHECK_ELIGIBLE_DAYS)) {
			List<PVUEmployeEventsEntity> eventExists = eventsService.getEventListFromEffectiveAndToEffectiveEventsIn(
					employeeId, effectiveDate, dateOfNextInc,
					Arrays.asList(PvuConstant.EVENT_CODE_EOL, PvuConstant.EVENT_CODE_SUSPENSION));
			if (!CollectionUtils.isEmpty(eventExists)) {
				for (PVUEmployeEventsEntity eventExist : eventExists) {
					if (eventExist.getEventName().equalsIgnoreCase(PvuConstant.EVENT_CODE_EOL)) {
						PVUEmployeeEOLeaveEntity eol = this.eoLeaveService.getOneByTrnNo(eventExist.getTrnNo());
						count = count + eol.getNoOfDays();

					} else if (eventExist.getEventName().equalsIgnoreCase(PvuConstant.EVENT_CODE_SUSPENSION)) {
						PVUEmployeSuspensionEntity suspension = this.suspensionService
								.getOneByTrnNo(eventExist.getTrnNo());
						count = count + suspension.getNoOfDayInSus();
					}
				}
				long actual = PvuUtils.countDays(effectiveDate, dateOfNextInc);
				actual = actual - count;
				return actual >= PvuConstant.CHECK_ELIGIBLE_DAYS;
			}
			return true;
		}
		return false;
	}

	public Map<String, List<PVUEmployeCreationDDLView>> getLookUpInfoAsMap(String procedureName)
			throws CustomException {
		try {
			Map<String, List<PVUEmployeCreationDDLView>> resultMap;
			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(procedureName));
			List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = repository.storeProc(procName,
					PVUEmployeCreationDDLView.class);
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
			return resultMap;
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public PVUCommonApiDto getValidEligleEmployeeForDeemedDate(PvuCommonRequest pvuCommonRequest)
			throws CustomException {
		Map<String, Object> data = pvuCommonRequest.getData();
		String employeeNo = data.get(PvuConstant.EMPLOYEE_NO).toString();
		String employeSenior = data.get(PvuConstant.EMPLOYEE_SENIOR_NO).toString();
		Long payCommId = Long.valueOf(data.get("payCommissionId").toString());
		Long empNo = Long.parseLong(employeeNo);
		LocalDate effectiveDate = PvuUtils.getDateFromStringYMD(data.get(PvuConstant.EFFECTIVE_DATE).toString());
		PVUEmployeEntity pvuEmployeEntity = pvuEmployeRepository
				.findByEmployeeCodeAndActiveStatus(empNo, Constant.ACTIVE_STATUS)
				.orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
		PVUEmployeEventsEntity pvuEmployeEventsEntity = eventsRepository
				.findTop1ByEmpIdAndEventDateAndEventNameOrderByEmpEventIdDesc(pvuEmployeEntity.getEmpId(),
						LocalDateTime.of(effectiveDate, LocalTime.MIN), PvuConstant.EVENT_CODE_PROMOTION);
		if (pvuEmployeEventsEntity != null) {
			if (pvuEmployeEventsEntity.getEventName().equals(PvuConstant.EVENT_CODE_PROMOTION)) {
				if (pvuEmployeEventsEntity.getPayCommission().equals(payCommId)) {
					PVUCommonApiDto junior = payDetail(data, employeeNo, payCommId);
					PVUCommonApiDto senior = payDetail(data, employeSenior, payCommId);
					if (isSeniorHasMoreSalary(junior, senior, payCommId)) {
						throw new CustomException(1009,
								"Junior must have more salary than senior to perform deemed date");
					}
					return junior;
				} else {
					throw new CustomException(1008, "Different Pay commission employees deemed date cannot be given");

				}
			} else {
				throw new CustomException(1008, "deemed date can't given against this employee");
			}
		}
		throw new CustomException(1008, "Employee is Not eligible for deemed date.");
	}

	private boolean isSeniorHasMoreSalary(PVUCommonApiDto junior, PVUCommonApiDto senior, Long payCommId)
			throws CustomException {
		if (Utils.isEmpty(junior) || Utils.isEmpty(senior)) {
			return true;
		}

		if (payCommId.equals(PvuConstant.SEVENTH_COMMISSION_ID) && senior.getPayLevelId() > junior.getPayLevelId()) {
			throw new CustomException(1009, "Junior must have more pay level than senior to perform deemed date");
		} else if (payCommId.equals(PvuConstant.SIXTH_COMMISSION_ID)
				&& Long.parseLong(senior.getGradePayName()) > Long.parseLong(junior.getGradePayName())) {
			throw new CustomException(1009, "Junior must have more grade pay than senior to perform deemed date");
		}

		return senior.getEmpBasicPay() >= junior.getEmpBasicPay();
	}

	private PVUCommonApiDto payDetail(Map<String, Object> data, String employeeNo, Long payCommId)
			throws CustomException {
		PageDetails getOne = PageDetails.createSingleRecordObj();
		List<SearchParam> jsonArr = new ArrayList<>();
		jsonArr.add(SearchParam.create(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getKey(), employeeNo));
		jsonArr.add(SearchParam.create(PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_ID.getKey(), String.valueOf(0)));
		jsonArr.add(SearchParam.create(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getKey(),
				data.get(PvuConstant.EFFECTIVE_DATE).toString()));
		jsonArr.add(SearchParam.create(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getKey(), payCommId.toString()));
		getOne.setJsonArr(jsonArr);
		Map<String, Object> map = this.buildPageInMap(getOne);
		this.includeCurrentOffice(map);
		return this.getCommonDetailsBasedOnEventDate(map);
	}

	public void validatePromotionForgo(PVUEmployeForgoDto forgoDto) throws CustomException {
		long classId = pvuEmployeDepartmentService.getClassIdByEmpId(forgoDto.getEmployeeId());
		if (!Utils.isEmpty(classId) && classId > forgoDto.getEmployeeClassId()) {
			throw new CustomException(ErrorResponse.CLASS_NOT_ALLOWED);
		}
		EDPLuLookUpInfoEntity payCommissionLookup = lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
						PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
						PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME);

		if (validatePromotionForgoErrorLevelNotAllowed(forgoDto, payCommissionLookup)) {
			throw new CustomException(ErrorResponse.LEVEL_NOT_ALLOWED);
		}

		payCommissionLookup = lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
				PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME);

		if (payCommissionLookup != null && payCommissionLookup.getLookUpInfoId() == forgoDto.getPayCommId()) {
			Optional<PVUEmployeSixPayDetailEntity> sixPayDetailDto = employeSixPayDetailsRepository
					.findOneByPvuEmployeEntityEmpId(forgoDto.getEmployeeId());
			if (sixPayDetailDto.isPresent()) {
				if (validatePromotionForgoErrorPayBandNotAllowed(forgoDto, sixPayDetailDto)) {
					throw new CustomException(ErrorResponse.PAY_BAND_NOT_ALLOWED);
				}
				if (validatePromotionForgoErrorGradePayNotAllowed(forgoDto, sixPayDetailDto)) {
					throw new CustomException(ErrorResponse.GRADE_PAY_NOT_ALLOWED);
				}
			}
		}

	}

	/**
	 * @param forgoDto        PVUEmployeForgoDto
	 * @param sixPayDetailDto Optional<PVUEmployeSixPayDetailEntity>
	 * @return boolean
	 */
	private boolean validatePromotionForgoErrorGradePayNotAllowed(PVUEmployeForgoDto forgoDto,
			Optional<PVUEmployeSixPayDetailEntity> sixPayDetailDto) {
		return sixPayDetailDto.isPresent() && null != sixPayDetailDto.get().getGradePay()
				&& sixPayDetailDto.get().getGradePay().getId() < forgoDto.getGradePayId();
	}

	/**
	 * @param forgoDto        PVUEmployeForgoDto
	 * @param sixPayDetailDto Optional<PVUEmployeSixPayDetailEntity>
	 * @return boolean
	 */
	private boolean validatePromotionForgoErrorPayBandNotAllowed(PVUEmployeForgoDto forgoDto,
			Optional<PVUEmployeSixPayDetailEntity> sixPayDetailDto) {
		return sixPayDetailDto.isPresent() && null != sixPayDetailDto.get().getRevisedPayBand()
				&& sixPayDetailDto.get().getRevisedPayBand().getId() < forgoDto.getPayBandId();
	}

	/**
	 * @param forgoDto            PVUEmployeForgoDto
	 * @param payCommissionLookup EDPLuLookUpInfoEntity
	 * @return boolean
	 * @throws CustomException CustomException
	 */
	private boolean validatePromotionForgoErrorLevelNotAllowed(PVUEmployeForgoDto forgoDto,
			EDPLuLookUpInfoEntity payCommissionLookup) throws CustomException {
		return payCommissionLookup != null && payCommissionLookup.getLookUpInfoId() == forgoDto.getPayCommId()
				&& !Utils.isEmpty(pvuEmployeSevenPayDetailService.getEmpByEmpId(forgoDto.getEmployeeId()).getPayLevel())
				&& pvuEmployeSevenPayDetailService.getEmpByEmpId(forgoDto.getEmployeeId()).getPayLevel() < forgoDto
						.getPayLevelId();
	}

	public Map<String, List<PVUEmployeCreationDDLView>> getPayCommisionDetails() throws CustomException {
		List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = getPayCommisionDetailQuery();
		return lstPVUEmployeCreationDDLView.stream()
				.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
	}

	public List<PVUEmployeCreationDDLView> getPayCommisionDetailQuery() throws CustomException {
		HashMap<String, Object> objectMap = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		list.add(150);
		list.add(151);
		list.add(152);
		objectMap.put("ids", list);
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT l.LOOKUP_NAME AS c0 , inf.LOOKUP_INFO_ID AS c1, inf.LOOKUP_INFO_NAME AS c2   ")
				.append(" FROM   ").append(Constant.PVU_SCHEMA_MASTER).append(".LU_LOOKUP_INFO inf ")
				.append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER).append(".LU_LOOKUP l ")
				.append(" ON l.LOOKUP_ID = inf.PARENT_LOOKUP_ID ")
				.append("WHERE inf.LOOKUP_INFO_ID IN (150,151,152) AND l.ACTIVE_STATUS = 1 AND inf.ACTIVE_STATUS = 1 ");
		if (logger.isInfoEnabled()) {
			logger.info(sb.toString());
		}
		List<Object[]> objectPvuSp = repository.executeSQLQueryOnly(sb.toString());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	public Map<String, Object> getCommonDetailsForRegularEmployee(PageDetails pageDetails) throws CustomException {
		Map<String, Object> main = new HashMap<>();

		String isRegularRequired = PageDetails.getValue(pageDetails,
				PVUSearchEnum.PVU_SEARCH_FIELD_IS_IN_REGULAR.getKey());
		String examDetailRequired = PageDetails.getValue(pageDetails,
				PVUSearchEnum.PVU_SEARCH_FIELD_REQUIRED_EXAM.getKey());
		String employeeNo = PageDetails.getValue(pageDetails, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getKey());
		if (isRegularRequired.equalsIgnoreCase(PvuConstant.STR_ONE)) {
			validateEmployeeType(employeeNo);
		}
		Map<String, Object> map = this.buildPageInMap(pageDetails);
		this.includeCurrentOffice(map);
		PVUCommonApiDto pvuCommonApiDto = this.getCommonDetailsBasedOnEventDate(map);
		main.put(PvuConstant.EMPLOYEE, pvuCommonApiDto);
		if (examDetailRequired.equalsIgnoreCase(PvuConstant.STR_ONE)) {
			fetchExamDetail(main, pvuCommonApiDto.getEmployeeId());
		}
		return main;
	}

	private PVUEmployeDepartmentEntity getEmployeeDepartment(String employeeNo) throws CustomException {
		Optional<PVUEmployeDepartmentEntity> required = this.pvuEmployeeDepartmentRepo
				.findFirstByPvuEmployeEntityEmployeeCode(Long.valueOf(employeeNo));
		if (required.isPresent()) {
			return required.get();
		}
		throw new CustomException(HttpStatus.CONFLICT, MsgConstant.RECORD_NOT_FOUND);
	}

	public Map<String, Object> getSearchCommonDetailsEmployee(PageDetails pageDetail)
			throws CustomException, ParseException {
		Map<String, Object> main = new HashMap<>();
		PVUCommonApiDto pvuCommonApiDto = this.getCommonDetailsOnEventDate(pageDetail);
		fetchExamDetail(main, pvuCommonApiDto.getEmployeeId());
		validatePayCommision(pvuCommonApiDto.getEmployeeId(),
				PvuUtils.getDateFromStringYMD(pvuCommonApiDto.getEventDate()), pvuCommonApiDto.getPayCommId(),
				PvuUtils.changeDateFormat(PvuUtils.getStrToDate(pvuCommonApiDto.getDateJoining())),
				Boolean.valueOf(PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_VIEW_PAGE.getKey())));
		main.put(PvuConstant.EMPLOYEE, pvuCommonApiDto);
		return main;
	}

	public PVUCommonApiDto getCommonDetailsOnEventDate(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = buildPageInMapEmpSearch(pageDetail);
		map.put("IN_OFFICE_ID", OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_EMPLOYEE_SP));
		List<PVUCommonApiDto> objStorePro = this.callSp(procName, map);
		if (CollectionUtils.isEmpty(objStorePro)) {
			String employeeCode = map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getValue()).toString();
			PVUEmployeDepartmentEntity entity = getEmployeeDepartment(employeeCode);
			if (!entity.getPresentOffice().getOfficeId()
					.equals(OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId())) {
				throw new CustomException(HttpStatus.CONFLICT,
						MessageFormat.format(MsgConstant.ERROR_EMPLOYEE_NOT_IN_OFFICE, employeeCode));
			}
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.ERROR_EMPLOYEE_JOINING_DATE, entity.getDateOfJoiningGOG()));
		}
		return objStorePro.get(0);
	}

	public List<PVUSearchEnum> getPvuSearchFieldsNew() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_ID, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM);
	}

	private List<PVUPayDetailsView> fivePayCommission(Long dptCat, Long payComm) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(PvuConstant.IN_DPT_ID, dptCat);
		map.put(PvuConstant.IN_PAY_COMM, payComm);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_DEPT_CAT_PAY_COMM));
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUPayDetailsView.class)
				: Collections.emptyList();
	}

	/**
	 * Gets the pay comm by dept cat id.
	 *
	 * @param elseResponse         the else response
	 * @param departmentCategoryId the department category id
	 */
	private void getPayCommByDeptCatId(Map<Object, Object> elseResponse, Long departmentCategoryId) {
		// 3th pay commission
		Map<Integer, List<Map<String, Object>>> collectData = this.scaleRepository
				.findAllByPayCommissionIn(Collections.singletonList(PvuConstant.THIRD_COMMISSION)).stream()
				.collect(Collectors.groupingBy(PVUMsPayScaleEntity::getPayCommission,
						Collectors.mapping(
								e -> this.toObj(e.getPayScaleId(), e.getPayScaleDispVal(), e.getScaleValue()),
								Collectors.toList())));
		elseResponse.put(PvuConstant.THIRD_COMMISSION_ID, collectData.get(PvuConstant.THIRD_COMMISSION));

		// 4th pay commission
		Map<Integer, List<Map<String, Object>>> collect = this.scaleRepository
				.findAllByPayCommissionIn(Collections.singletonList(PvuConstant.FOURTH_COMMISSION)).stream()
				.collect(Collectors.groupingBy(PVUMsPayScaleEntity::getPayCommission,
						Collectors.mapping(
								e -> this.toObj(e.getPayScaleId(), e.getPayScaleDispVal(), e.getScaleValue()),
								Collectors.toList())));
		elseResponse.put(PvuConstant.FOURTH_COMMISSION_ID, collect.get(PvuConstant.FOURTH_COMMISSION));

		// 5th Pending
		List<Long> payScalesIds = this.scaleRepository.getPayScaleIdByDepartmentCategory(departmentCategoryId,
				Constant.ACTIVE_STATUS);
		Map<Integer, List<Map<String, Object>>> fifthPayCommList = this.scaleRepository
				.findAllByPayScaleIdIn(payScalesIds).stream()
				.collect(Collectors.groupingBy(PVUMsPayScaleEntity::getPayCommission,
						Collectors.mapping(
								e -> this.toObj(e.getPayScaleId(), e.getPayScaleDispVal(), e.getScaleValue()),
								Collectors.toList())));

		elseResponse.put(PvuConstant.FIFTH_COMMISSION_ID, fifthPayCommList.get(PvuConstant.FIVE_COMMISSION));
		elseResponse.put(PvuConstant.SIXTH_COMMISSION_ID, getSixPayCommissionMaster(departmentCategoryId));
		elseResponse.put(PvuConstant.SEVENTH_COMMISSION_ID, getSevenPayCommissionMaster(departmentCategoryId));
	}

	private List<PVUMsSevenPayFormatDto> getSevenPayCommissionMaster(Long departmentCategoryId) {
		List<PVUMsPayCellEntity> sevenCommission;
		if (departmentCategoryId != null) {
			List<Long> payCells = this.payCellRepository.getIdByDepartmentCategory(departmentCategoryId);
			sevenCommission = this.payCellRepository.findAllByPayLevelIdIn(payCells);
		} else {
			sevenCommission = this.payCellRepository.findAll();
		}
		List<PVUMsSevenPayFormatDto> seven = new ArrayList<>();
		sevenCommission.stream().collect(Collectors.groupingBy(PVUMsPayCellEntity::getPayLevel))
				.forEach((k, v) -> seven.add(PVUMsSevenPayFormatDto.create(k, v)));
		seven.sort(Comparator.comparing(PVUMsSevenPayFormatDto::getOrder));
		return seven.stream().sorted(Comparator.comparingInt(PVUMsSevenPayFormatDto::getOrder)).peek(f -> {
			List<PVUMsPayCellFormatDto> grads = f.getCells().stream()
					.sorted(Comparator.comparing(PVUMsPayCellFormatDto::getCellValue)).collect(Collectors.toList());
			f.setCells(grads);
		}).collect(Collectors.toList());
	}

	private List<PVUMsSevenPayFormatDto> getSevenPayCommissionMasterEmp(Long departmentCategoryId, Long employeeId,String effectiveDate) {
		List<PVUMsSevenPayFormatDto> sevenCommissionData = new ArrayList<>();
		if(null != departmentCategoryId) {

			Map<String, Object> map = new LinkedHashMap<>();
			map.put(PvuConstant.IN_DPT_ID, departmentCategoryId);
			map.put(Constant.IN_EMP_ID, employeeId.toString());
			map.put(PvuConstant.IN_EFFECTIVE_DATE, effectiveDate);

			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_DEPT_CAT_PAY_COMM_7TH));
			List<Long> payLevelId = repository.callStoredProcedureLong(procName,map);
			
			
			List<Object[]> objectPvuSp = this.payCellRepository.getCellsByLevel(payLevelId);
			List<Object[]> cellData = objectPvuSp.stream().filter(distinctByKey(obj -> EDPUtility.convertObjectToLong(obj[0]))).collect(Collectors.toList());
			
            if (!Utils.isEmpty(cellData)) {
				for (Object[] obj : cellData) {
					PVUMsSevenPayFormatDto sevenFormatDto = new PVUMsSevenPayFormatDto();
					List<PVUMsPayCellFormatDto> listCellPay = new ArrayList<>();

					Long levelId = EDPUtility.convertObjectToLong(obj[0]);
					sevenFormatDto.setId(levelId);
					sevenFormatDto.setOrder(EDPUtility.convertObjectToInt(obj[1]));
					sevenFormatDto.setPayLevelValue(obj[2].toString());

					List<Object[]> gradeData = objectPvuSp.stream().filter(object -> levelId.equals(EDPUtility.convertObjectToLong(object[0]))).collect(Collectors.toList());
					gradeData.forEach(o->{
						PVUMsPayCellFormatDto cellDto = new PVUMsPayCellFormatDto();
						cellDto.setId(EDPUtility.convertObjectToLong(o[3]));
						cellDto.setCellId(EDPUtility.convertObjectToInt(o[4]));
						cellDto.setCellValue(EDPUtility.convertObjectToLong(o[5]));
						cellDto.setDisplayName("Cell - "+cellDto.getCellId());
						listCellPay.add(cellDto);					
					});
					sevenFormatDto.setCells(listCellPay);
					sevenCommissionData.add(sevenFormatDto);
				}
			}
		
		}
		return sevenCommissionData;
	}

	/**
	 * Gets the PM by dept cat and pay com.
	 *
	 * @param elseResponse         the else response
	 * @param departmentCategoryId the department category id
	 * @param payCommissionId      the pay commission id
	 */
	private void getPMByDeptCatAndPayCom(Map<Object, Object> elseResponse, Long departmentCategoryId,
			Long payCommissionId) {
		if (payCommissionId.equals(PvuConstant.SIXTH_COMMISSION_ID)) {
			elseResponse.put("data", getSixPayCommissionMaster(departmentCategoryId));
		} else if (payCommissionId.equals(PvuConstant.FIFTH_COMMISSION_ID)) {
			try {
				List<PVUPayDetailsView> five = getFifthPayCommissionMaster(departmentCategoryId, payCommissionId);
				elseResponse.put("data", five);
			} catch (CustomException e) {
			}

		} else if (payCommissionId.equals(PvuConstant.SEVENTH_COMMISSION_ID)) {
			elseResponse.put("data", getSevenPayCommissionMaster(departmentCategoryId));
		}
	}

	private void getPMByDeptCatAndPayCommission(Map<Object, Object> elseResponse, Long departmentCategoryId,
			Long payCommissionId, Long employeeNo, String effectiveDate) {
		if (payCommissionId.equals(PvuConstant.SIXTH_COMMISSION_ID)) {
			elseResponse.put("data", getSixPayCommissionMasterEmp(departmentCategoryId, employeeNo, effectiveDate));
		} else if (payCommissionId.equals(PvuConstant.FIFTH_COMMISSION_ID)) {
			try {
				List<PVUPayDetailsView> five = getFifthPayCommissionMasterEmp(departmentCategoryId, payCommissionId, employeeNo.toString(), effectiveDate);
				elseResponse.put("data", five);
			} catch (CustomException e) {
			}

		} else if (payCommissionId.equals(PvuConstant.SEVENTH_COMMISSION_ID)) {
			elseResponse.put("data", getSevenPayCommissionMasterEmp(departmentCategoryId, employeeNo,effectiveDate));
		}
	}

	private List<PVUPayDetailsView> getFifthPayCommissionMaster(Long departmentCategoryId, Long payCommissionId)
			throws CustomException {
		List<PVUPayDetailsView> five = fivePayCommission(departmentCategoryId, payCommissionId);
		return five.stream().filter(e -> e.getOrder() != null).sorted(Comparator.comparing(PVUPayDetailsView::getOrder))
				.collect(Collectors.toList());
	}

	private List<PVUMsSixPayFormatDto> getSixPayCommissionMaster(Long departmentCategoryId) {
		List<PVUMsSixPayFormatDto> six = new ArrayList<>();

		List<PVUMsGradePayEntity> sixCommission;
		if (departmentCategoryId != null && departmentCategoryId == 17) {
			return getDataforjudiciaryDept();
		} else if (departmentCategoryId != null) {
			List<Long> payScalesIds = this.gradePayRepository.getIdByDepartmentCategory(departmentCategoryId);
			sixCommission = this.gradePayRepository.findAllByIdIn(payScalesIds, Sort.by("gradePayValue"));
		} else {
			sixCommission = this.gradePayRepository.findAll();
		}
		sixCommission.stream().collect(Collectors.groupingBy(PVUMsGradePayEntity::getPayBand))
				.forEach((k, v) -> six.add(PVUMsSixPayFormatDto.create(k, v)));
		List<PVUMsSixPayFormatDto> collect = six.stream()
				.sorted(Comparator.comparing(PVUMsSixPayFormatDto::getPayBandName)).collect(Collectors.toList());
		return collect.stream().sorted(Comparator.comparingInt(PVUMsSixPayFormatDto::getOrder)).peek(f -> {
			List<PVUMsGradePayFormatDto> grads = f.getGradePays().stream()
					.sorted(Comparator.comparing(PVUMsGradePayFormatDto::getGradePayValueInLong))
					.collect(Collectors.toList());
			f.setGradePays(grads);
		}).collect(Collectors.toList());
	}

	private List<PVUMsSixPayFormatDto> getSixPayCommissionMasterEmp(Long departmentCategoryId, Long employeeId,String effectiveDate) {

		List<PVUMsSixPayFormatDto> six = new ArrayList<>();
		if (departmentCategoryId != null && departmentCategoryId == 17) {
			return getDataforjudiciaryDept();
		} else {
			Map<String, Object> map = new LinkedHashMap<>();
			map.put(PvuConstant.IN_DPT_ID, departmentCategoryId);
			map.put(Constant.IN_EMP_ID, employeeId.toString());
			map.put(PvuConstant.IN_EFFECTIVE_DATE, effectiveDate);

			String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_DEPT_CAT_PAY_COMM_6TH));
			List<Long> gradePayId = repository.callStoredProcedureLong(procName,map);
			List<Object[]> objectPvuSp = this.gradePayRepository.getSixPayCommission(gradePayId, departmentCategoryId);
			List<Object[]> bandData = objectPvuSp.stream().filter(distinctByKey(obj -> EDPUtility.convertObjectToLong(obj[2]))).collect(Collectors.toList());
			
            if (!Utils.isEmpty(bandData)) {
				for (Object[] obj : bandData) {
					PVUMsSixPayFormatDto sixDto = new PVUMsSixPayFormatDto();
					List<PVUMsGradePayFormatDto> listGradPay = new ArrayList<>();

					Long bandId = EDPUtility.convertObjectToLong(obj[2]);
					sixDto.setId(bandId);
					sixDto.setPayBandName(obj[1].toString());
					sixDto.setStartingValue(EDPUtility.convertObjectToLong(obj[4]));
					sixDto.setEndValue(EDPUtility.convertObjectToLong(obj[5]));
					List<Object[]> gradeData = objectPvuSp.stream().filter(object -> bandId.equals(EDPUtility.convertObjectToLong(object[2]))).collect(Collectors.toList());
					gradeData.forEach(o->{
						PVUMsGradePayFormatDto dtoGrade = new PVUMsGradePayFormatDto();
						dtoGrade.setId(Long.parseLong(o[0].toString()));
						dtoGrade.setGradePayValue(o[3].toString());
						listGradPay.add(dtoGrade);					
					});
					sixDto.setGradePays(listGradPay);				
					six.add(sixDto);
				}
			}
			return six;
		}
	}

	/**
	 * To obj.
	 *
	 * @param payScaleId      the pay scale id
	 * @param payScaleDispVal the pay scale disp val
	 * @param scaleValue      the scale value
	 * @return the object
	 */
	private Map<String, Object> toObj(Long payScaleId, String payScaleDispVal, String scaleValue) {
		Map<String, Object> response = new HashMap<>();
		response.put(PvuConstant.ID, payScaleId);
		response.put(PvuConstant.NAME, payScaleDispVal);
		response.put(PvuConstant.SCALE_VALUE, scaleValue);
		return response;
	}

	public Map<String, Object> getRegularEmployeeCommonDetails(PageDetails pageDetails)
			throws CustomException, ParseException {
		Map<String, Object> main = new HashMap<>();
		PVUEmployeDepartmentEntity deptEntity = validateEmployeeType(
				PageDetails.getValue(pageDetails, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getKey()));
		Map<String, Object> map = this.buildPageInMap(pageDetails);
		LocalDate eventDate = PvuUtils
				.getDateFromStringYMD(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getValue()).toString());
		
		this.validateBackDatedEffDateForEmpType(deptEntity, eventDate);
		
		Long empId = deptEntity.getPvuEmployeEntity().getEmpId();
		validateEOL(empId, eventDate);
		validateSuspension(empId, eventDate);
		validatePayCommision(empId, eventDate,
				Long.parseLong(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getValue()).toString()),
				deptEntity.getDateOfJoiningGOG(),
				Boolean.valueOf(PageDetails.getValue(pageDetails, PVUSearchEnum.PVU_SEARCH_FIELD_VIEW_PAGE.getKey())));
		this.includeCurrentOffice(map);
		PVUCommonApiDto pvuCommonApiDto = this.getCommonDetailsBasedOnEventDate(map);
		fetchExamDetail(main, pvuCommonApiDto.getEmployeeId());
		main.put(PvuConstant.EMPLOYEE, pvuCommonApiDto);
		return main;
	}

	public void validateEOL(Long employeeId, LocalDate effectiveDate) throws CustomException {
		List<PVUEmployeEventsEntity> eolEventEntity = eventsService
				.findAllByEmpIdAndEventNameAndActiveStatus(employeeId, PvuConstant.EVENT_CODE_EOL);
		if (!CollectionUtils.isEmpty(eolEventEntity)) {
			for (PVUEmployeEventsEntity eolEventList : eolEventEntity) {
				PVUEmployeeEOLeaveEntity eol = this.eoLeaveService.getOneByTrnNo(eolEventList.getTrnNo());
				long noOfDaysBetween = ChronoUnit.DAYS.between(eol.getStartDate(), effectiveDate);
				long noOfDaysTotal = ChronoUnit.DAYS.between(eol.getStartDate(), eol.getEndDate());
				if (noOfDaysTotal >= noOfDaysBetween && noOfDaysBetween >= 0) {
					throw new CustomException(HttpStatus.CONFLICT,
							MessageFormat.format(MsgConstant.COMMON_EOL_MSG,
									PvuUtils.getStrOfLocalDateInDMY(eol.getStartDate()),
									PvuUtils.getStrOfLocalDateInDMY(eol.getEndDate())));
				}
			}
		}
	}

	public void validateSuspension(Long employeeId, LocalDate effectiveDate) throws CustomException {
		List<PVUEmployeEventsEntity> suspEventEntity = eventsService
				.findAllByEmpIdAndEventNameAndActiveStatus(employeeId, PvuConstant.EVENT_CODE_SUSPENSION);
		if (!CollectionUtils.isEmpty(suspEventEntity)) {
			for (PVUEmployeEventsEntity susEventList : suspEventEntity) {
				PVUEmployeSuspensionEntity suspension = this.suspensionService.getOneByTrnNo(susEventList.getTrnNo());
				if (suspension.getSusEndDate() == null)
					return;
				long noOfDaysBetween = ChronoUnit.DAYS.between(suspension.getSusStartDate(), effectiveDate);
				long noOfDaysTotal = ChronoUnit.DAYS.between(suspension.getSusStartDate(), suspension.getSusEndDate());
				if (noOfDaysTotal >= noOfDaysBetween && noOfDaysBetween >= 0) {
					throw new CustomException(HttpStatus.CONFLICT,
							MessageFormat.format(MsgConstant.COMMON_SUSPENSION_MSG,
									PvuUtils.getStrOfLocalDateInDMY(suspension.getSusStartDate()),
									PvuUtils.getStrOfLocalDateInDMY(suspension.getSusEndDate())));
				}
			}
		}
	}

	public Map<String, Long> getSevenHigherBasicAndCellPVU(PvuCommonRequest pvuRequest) throws CustomException {

		Map<String, Long> request = pvuRequest.getRequest();
		Map<String, Long> response = new HashMap<>();
		Long oldPayLevelId = request.get(PvuConstant.OLD_PAY_LEVEL_ID);
		Long basicValue = request.get(PvuConstant.OLD_CELL_VALUE);
		Long payLevelId = request.get(PvuConstant.PAY_LEVEL_ID);

		Optional<PVUMsPayCellEntity> currentState = this.payCellRepository
				.findOneByPayLevelIdAndCellValue(oldPayLevelId, basicValue);
		int currentCellId = 0;
		if (currentState.isPresent()) {
			PVUMsPayCellEntity current = currentState.get();
			currentCellId = current.getCellId();
			Optional<PVUMsPayCellEntity> newBasic = payCellRepository
					.findTop1ByPayLevelIdAndCellValueGreaterThanEqualOrderByCellValueAsc(payLevelId,
							current.getCellValue());
			if (newBasic.isPresent()) {
				Long basicValueNew = newBasic.get().getCellValue();
				response.put(PvuConstant.BASIC_PAY, basicValueNew);
				response.put(PvuConstant.CELL_ID, newBasic.get().getId());
				return response;
			} else {
				Optional<PVUMsPayCellEntity> first = payCellRepository.findOneByPayLevelIdAndCellId(payLevelId,
						Constant.ACTIVE_STATUS);
				if (first.isPresent()) {
					response.put(PvuConstant.BASIC_PAY, first.get().getCellValue());
					response.put(PvuConstant.CELL_ID, first.get().getId());
					return response;
				} else {
					throw new CustomException(1008,
							String.format(NOT_FOUND_BASIC_PAY_FOR_PAY_LEVEL_AND_CELL, payLevelId, currentCellId));
				}
			}
		} else {
			throw new CustomException(1008,
					String.format(NOT_FOUND_BASIC_PAY_FOR_PAY_LEVEL_AND_CELL, payLevelId, currentCellId));
		}
	}

	private void fetchPromotionDetails(Map<String, Object> main, PVUCommonHigherPayDto pvuCommonApiDto) {
		Map<String, Object> response = new HashMap<>();
		Long employeeId = Long.valueOf(pvuCommonApiDto.getEmployeeId());
		response.put(PvuConstant.DEPT_EXAMS, getPromotionDepartmentExams(employeeId));

		List<PVUEmployeCCCExamDetailEntity> cccExamEntity = cccExamDetailRepository
				.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(employeeId,
						Constant.ACTIVE_STATUS);

		response.put(PvuConstant.CCC_EXAMS, getPromotionCCCExams(cccExamEntity));
		response.put(PvuConstant.LANG_EXAMS, getPromotionLanguageExams(employeeId));

		PVUPromotionEntity promotionEntity = promotionRepository
				.findTopByEmployeeEmpIdAndPayCommLookUpInfoIdAndStatusLookUpInfoIdOrderByCreatedDateDesc(employeeId,
						pvuCommonApiDto.getPayCommId(), 327L);
		Map<String, Object> newRsponse = new HashMap<>();
		if (promotionEntity != null) {
			if (promotionEntity.getDesignation() != null) {
				newRsponse.put("promotionDesignation", promotionEntity.getDesignation().getDesignationName());
			}
			newRsponse.put("promotionEventdate", promotionEntity.getEventEffectiveDate());
			response.put("promotion", newRsponse);
			if (pvuCommonApiDto.getPayCommId().equals(PvuConstant.FIFTH_COMMISSION_ID)) {
				newRsponse.put("promotionScale", promotionEntity.getPayScale());
			} else if (pvuCommonApiDto.getPayCommId().equals(PvuConstant.SEVENTH_COMMISSION_ID)) {
				newRsponse.put("promotionCell", promotionEntity.getCell().getCellId());
				newRsponse.put("promotionPayLevel", promotionEntity.getPayLevel().getPayLevelValue());
			} else if (pvuCommonApiDto.getPayCommId().equals(PvuConstant.SIXTH_COMMISSION_ID)) {
				newRsponse.put("promotionGradePay", promotionEntity.getGradePay().getGradePayValue());

				newRsponse.put("promotionPayBandValue", promotionEntity.getPayBandValue());
			}
		}
		List<PVUEmployeEventsEntity> employeeEventEntity = pvuEmpEvent
				.findAllByEmpIdAndEventName(employeeId, PvuConstant.EVENT_CODE_HP).stream()
				.filter(distinctByKey(PVUEmployeEventsEntity::getTrnNo)).collect(Collectors.toList());

		if (!CollectionUtils.isEmpty(employeeEventEntity)) {
			response.put("higherPayDate", getHigherPayEventDetails(employeeEventEntity));
		}
		response.put("examCondition", getPromotionExamsCondition(cccExamEntity));
		main.put(PvuConstant.EXAMS, response);
	}

	/**
	 * @param cccExamEntity cccExamEntity
	 * @param cccExamDetail cccExamDetail
	 * @return Map<String, Boolean>
	 */
	private Map<String, Boolean> getPromotionExamsCondition(List<PVUEmployeCCCExamDetailEntity> cccExamEntity) {
		Map<String, Boolean> responseCCC = new HashMap<>();
		if (!CollectionUtils.isEmpty(cccExamEntity)) {
			Optional<PVUEmployeCCCExamDetailEntity> ccT = cccExamEntity.stream()
					.filter(e -> null != e.getCccExamName() && e.getCccExamName().getLookUpInfoId() == 140L)
					.findFirst();
			Optional<PVUEmployeCCCExamDetailEntity> ccP = cccExamEntity.stream()
					.filter(e -> null != e.getCccExamName() && e.getCccExamName().getLookUpInfoId() == 141L)
					.findFirst();
			Optional<PVUEmployeCCCExamDetailEntity> ccPP = cccExamEntity.stream()
					.filter(e -> null != e.getCccExamName() && e.getCccExamName().getLookUpInfoId() == 142L)
					.findFirst();
			Optional<PVUEmployeCCCExamDetailEntity> ccPT = cccExamEntity.stream()
					.filter(e -> null != e.getCccExamName() && e.getCccExamName().getLookUpInfoId() == 143L)
					.findFirst();
			responseCCC.put("cccExams", (ccT.isPresent() && ccP.isPresent()));
			responseCCC.put("cccPlusExams", (ccPT.isPresent() && ccPP.isPresent()));
		} else {
			responseCCC.put("cccExams", false);
			responseCCC.put("cccPlusExams", false);
		}
		return responseCCC;
	}

	/**
	 * @param employeeEventEntity List<PVUEmployeEventsEntity>
	 * @return Map<String, Object>
	 */
	private Map<String, Object> getHigherPayEventDetails(List<PVUEmployeEventsEntity> employeeEventEntity) {
		Map<String, Object> responseHigher = new HashMap<>();
		for (PVUEmployeEventsEntity eventExist : employeeEventEntity) {
			PVUEmployeHigherPayScaleEventEntity entityHp = higherPayScaleEventRepository
					.findOneByTrnNo(eventExist.getTrnNo());
			if (entityHp.getHpScaleType() != null && entityHp.getHpScaleType().getLookUpInfoId() == 328L) {
				responseHigher.put("firstHigherpayDate", entityHp.getHgEffDate());
			}

			if (entityHp.getHpScaleType() != null && entityHp.getHpScaleType().getLookUpInfoId() == 329L) {
				responseHigher.put("secondHigherpayDate", entityHp.getHgEffDate());
			}

			if (entityHp.getHpScaleType() != null && entityHp.getHpScaleType().getLookUpInfoId() == 330L) {
				responseHigher.put("thirdHigherpayDate", entityHp.getHgEffDate());
			}
		}
		return responseHigher;
	}

	/**
	 * @param employeeId employeeId
	 * @return List<PVUCommonHigherPayDto.EXAMDto>
	 */
	private List<PVUCommonHigherPayDto.EXAMDto> getPromotionLanguageExams(Long employeeId) {
		List<PVUEmployeLangExamEntity> lanExam = langExamRepository
				.findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(employeeId, Constant.ACTIVE_STATUS);
		return lanExam.stream().map(e -> {
			EDPLuLookUpInfoEntity examName = e.getLangName();
			Date dateOfPassing = e.getDateOfPassing();
			EDPLuLookUpInfoEntity lookUpInfoName = e.getExamStatus();
			return PVUCommonHigherPayDto.EXAMDto.create(examName != null ? examName.getLookUpInfoName() : null,
					e.getExamBody(), dateOfPassing, lookUpInfoName != null ? lookUpInfoName.getLookUpInfoName() : null);
		}).collect(Collectors.toList());
	}

	/**
	 * @param cccExamEntity List<PVUEmployeCCCExamDetailEntity>
	 * @return List<PVUCommonHigherPayDto.EXAMDto>
	 */
	private List<PVUCommonHigherPayDto.EXAMDto> getPromotionCCCExams(
			List<PVUEmployeCCCExamDetailEntity> cccExamEntity) {
		return cccExamEntity.stream().map(e -> {
			PVUMsCourseEntity examBody = e.getExamBody();
			EDPLuLookUpInfoEntity examName = e.getCccExamName();
			Date dateOfPassing = e.getDateOfPassing();
			EDPLuLookUpInfoEntity lookUpInfoName = e.getExamStatus();
			return PVUCommonHigherPayDto.EXAMDto.create(examName != null ? examName.getLookUpInfoName() : null,
					examBody != null ? examBody.getCourseName() : null, dateOfPassing,
					lookUpInfoName != null ? lookUpInfoName.getLookUpInfoName() : null);
		}).collect(Collectors.toList());
	}

	/**
	 * @param employeeId Long
	 * @return List<PVUCommonHigherPayDto.EXAMDto>
	 */
	private List<PVUCommonHigherPayDto.EXAMDto> getPromotionDepartmentExams(Long employeeId) {
		List<PVUEmployeDeptExamDetailsEntity> deptExam = deptExamDetailsRepository
				.findPVUEmployeDeptExamDetailsEntityBypvuEmployeEntityEmpIdAndActiveStatus(employeeId,
						Constant.ACTIVE_STATUS);
		return deptExam.stream().map(e -> {
			EDPLuLookUpInfoEntity examBody = e.getExamBody();
			Date dateOfPassing = e.getDateOfPassing();
			EDPLuLookUpInfoEntity lookUpInfoName = e.getExamStatus();
			return PVUCommonHigherPayDto.EXAMDto.create(e.getDeptExamName(),
					examBody != null ? examBody.getLookUpInfoName() : null, dateOfPassing,
					lookUpInfoName != null ? lookUpInfoName.getLookUpInfoName() : null);
		}).collect(Collectors.toList());
	}

	public Map<String, Object> getSearchCommonDetailsForHigherPay(PageDetails pageDetail) throws CustomException {
		Map<String, Object> main = new HashMap<>();
		Map<String, Object> map = buildPageInMap(pageDetail);
		this.includeCurrentOffice(map);
		PVUCommonHigherPayDto pvuCommonApiDto = this.getCommonDetailsBasedOnEventDates(map);
		fetchPromotionDetails(main, pvuCommonApiDto);
		main.put(PvuConstant.EMPLOYEE, pvuCommonApiDto);
		return main;
	}

	public PVUCommonHigherPayDto getCommonDetailsBasedOnEventDates(Map<String, Object> map) throws CustomException {
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_SP));
		List<PVUCommonHigherPayDto> objStorePro = this.callSpp(procName, map);
		if (CollectionUtils.isEmpty(objStorePro)) {
			validateOffice(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getValue()).toString());
		}
		return objStorePro.get(0);
	}

	private List<PVUCommonHigherPayDto> callSpp(String procName, Map<String, Object> objectMap) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, objectMap);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUCommonHigherPayDto.class)
				: Collections.emptyList();
	}

	public PVUInwardLookupResponse getInwardLuLookUpInfo() {
		PVUInwardLookupResponse pvuEmployeDetailsDto = new PVUInwardLookupResponse();
		pvuEmployeDetailsDto.setLstLuLookUp(getInwardLookupSearch());
		pvuEmployeDetailsDto.setDistrict(districtRepository
				.findByActiveStatusAndStateId(Constant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ,
						EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC))
				.stream().map(e -> toClueDto(e.getDistrictId(), e.getDistrictName(), e.getDistrictCode()))
				.collect(Collectors.toList()));
		pvuEmployeDetailsDto.setDesignation(eDPMsDesignationRepository.findByActiveStatusEquals(Constant.ACTIVE_STATUS)
				.stream().map(e -> toClueDto(e.getDesignationId(), e.getDesignationName(), e.getDesignationCode()))
				.collect(Collectors.toList()));
		pvuEmployeDetailsDto.setPvuEvents(this.service.getPvuEvents().stream()
				.map(entity -> toClueDto(entity.getId(), entity.getEventName(), entity.getEventCode()))
				.collect(Collectors.toList()));
		return pvuEmployeDetailsDto;
	}

	private Map<String, List<PVUEmployeCreationDDLView>> getInwardLookupSearch() {
		List<EDPLuLookUpResponse> lookups = lookUpInfoService
				.getLookUpInfoByParentName(Stream.of("Emp_Type", "Dept_Class").collect(Collectors.toSet()));
		return lookups.stream().collect(Collectors.groupingBy(EDPLuLookUpResponse::getLookupType, Collectors.mapping(
				e -> new PVUEmployeCreationDDLView(e.getLookupType(), e.getLookupInfoId(), e.getLookupInfoName()),
				Collectors.toList())));
	}

	private ClueDto toClueDto(Long id, String name, String code) {
		return new ClueDto(id, name, code);
	}

	/**
	 * Fetch all the employee details.
	 *
	 * @param id id
	 * @return Map<String, Object> search common details
	 */
	public Map<String, Object> getCurrentDetailsById(IdDto id, boolean requiredExamDetails) {
		Map<String, Object> main = new HashMap<>();

		PVUCommonApiDto pvuCommonApiDto = this.eventsService.getCommonApiResponse(id.getId());
		main.put(PvuConstant.EMPLOYEE, pvuCommonApiDto);
		if (requiredExamDetails) {
			fetchExamDetail(main, pvuCommonApiDto.getEmployeeId());
		}
		return main;
	}

	public Map<String, List<Object>> getAuditorEditLookups() {
		List<EDPLuLookUpResponse> lookups = lookUpInfoService
				.getLookUpInfoByParentName(Stream.of("Recommendation For").collect(Collectors.toSet()));
		Map<String, List<Object>> collect = lookups.stream()
				.collect(
						Collectors
								.groupingBy(EDPLuLookUpResponse::getLookupType,
										Collectors.mapping(
												e -> new PVUEmployeCreationDDLView(e.getLookupType(),
														e.getLookupInfoId(), e.getLookupInfoName()),
												Collectors.toList())));
		collect.put("pvuEvents",
				this.service.getPvuEvents().stream()
						.map(entity -> toClueDto(entity.getId(), entity.getEventName(), entity.getEventCode()))
						.collect(Collectors.toList()));
		return collect;
	}

	public PVUOutwardLookupResponse getOutwardLuLookUpInfo() throws CustomException {
		PVUOutwardLookupResponse outward = new PVUOutwardLookupResponse();
		outward.setLstLuLookUp(getInwardLookupSearch());
		outward.setDistrict(districtRepository
				.findByActiveStatusAndStateId(Constant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ,
						EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC))
				.stream().map(e -> toClueDto(e.getDistrictId(), e.getDistrictName(), e.getDistrictCode()))
				.collect(Collectors.toList()));
		outward.setDesignation(eDPMsDesignationRepository.findByActiveStatusEquals(Constant.ACTIVE_STATUS).stream()
				.map(e -> toClueDto(e.getDesignationId(), e.getDesignationName(), e.getDesignationCode()))
				.collect(Collectors.toList()));
		outward.setPvuEvents(this.service.getPvuEvents().stream()
				.map(entity -> toClueDto(entity.getId(), entity.getEventName(), entity.getEventCode()))
				.collect(Collectors.toList()));
		outward.setStatusList(lookUpInfoService
				.getLookUpInfoByParentName(Stream.of("Recommendation For").collect(Collectors.toSet())).stream()
				.map(e -> toClueDto(e.getLookupInfoId(), e.getLookupInfoName(), null)).collect(Collectors.toList()));

		Long officeId = OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId();
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.OFFICE_ID, officeId);
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getApproverList(), map);
		outward.setApproverList(!Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PVUOfficeApprover.class)
				: Collections.emptyList());
		return outward;
	}

	public Map<String, Object> getEmployeeExams(Map<String, Long> employeeId) {
		Map<String, Object> response = new HashMap<>();
		Long casEvent = employeeId.get("casEvent");
		Long id = employeeId.get("id");
		fetchExamDetail(response, id);
		if (casEvent == 1L) {
			getQualifications(response, id);
		}
		return response;
	}

	private void getQualifications(Map<String, Object> response, long id) {
		List<PVUEmployeQualificationEntity> qualifications = pvuEmployeQualificationRepository
				.findPVUEmployeQualificationEntityBypvuEmployeEntityEmpIdAndActiveStatus(id, Constant.ACTIVE_STATUS);
		List<PVUCommonApiDto.EXAMDto> qualification = qualifications.stream().map(e -> {
			String universityBoard = e.getUniversityBoard();
			EDPMsFinancialYearEntity dateOfPassing = e.getPassingYear();
			String percentage = "";
			String courseName = "";
			String exam = "";
			if (e.getPercentageCGPA() != null && e.getPercentageCGPA().isNaN()) {
				percentage = e.getPercentageCGPA().toString();
			}
			if (e.getCourseName() != null) {
				courseName = e.getCourseName().getCourseName();
			}
			if (e.getDegree() != null) {
				exam = e.getDegree().getCourseName();
			}
			String sDate1 = "01/04/2019";
			if (dateOfPassing.getFy() != null) {
				sDate1 = "01/04/" + dateOfPassing.getFyStart();

			}
			Date passingDate = new Date();
			try {
				passingDate = PvuUtils.getStringToDate(sDate1);
			} catch (ParseException ex) {
				ex.printStackTrace();
			}
			return PVUCommonApiDto.EXAMDto.create(exam, universityBoard, passingDate, percentage, courseName);

		}).collect(Collectors.toList());
		response.put(PvuConstant.MAST_EXAMS, qualification);
	}

	public String getWaterMark(Long empId) throws CustomException {
		PVUEmployeEntity pvuEmployeEntity = employeService.getActiveEmployee(empId, Constant.ACTIVE_STATUS);
		String watermark;
		if (pvuEmployeEntity.getOfficeId().getOfficeId().equals(pvuEmployeEntity.getOfficeId().getPvuId())
				&& pvuEmployeEntity.getOfficeId().getOfficeId() != Constant.PVU_OFFICE_ID) {
			watermark = ", Self PVU";
		} else {
			watermark = ", PVU, Gandhinagar";
		}
		return watermark;
	}

	public List<EDPSDTDto> getPvuEventWfStatus(Long menuId) {
		List<EDPSDTDto> list = workflowService.getMsWorkflowStatusV2(menuId);
		return list;
	}

	/**
	 * Roll back reprint count common.
	 *
	 * @param requestMap the request map
	 * @return true, if successful
	 * @throws CustomException the custom exception
	 */
	@Transactional(rollbackFor = CustomException.class)
	public boolean rollBackReprintCountCommon(List<Map<String, String>> requestMapList) throws CustomException {
		try {
			for (Map<String, String> requestMap : requestMapList) {
				Long trnId = Long.parseLong(requestMap.get(PvuConstant.TRN_ID));
				Long eventId = Long.parseLong(requestMap.get(PvuConstant.EVENT_ID));
				PVUPrintEndorsementEntity printEntity = printRepository.findByEventIdAndTrnId(eventId, trnId);
				if (printEntity != null && printEntity.getPrintCnt() > 1) {
					printRepository.updateReprintCount(printEntity.getPrintCnt() - 1, eventId, trnId,
							OAuthUtility.getCurrentUserUserId(), new Date());
					printItrRepository.deleteReprintByPrintCount(Constant.INACTIVE_STATUS, printEntity.getId(),
							printEntity.getPrintCnt(), OAuthUtility.getCurrentUserUserId(), new Date());
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new CustomException(1008, "Error occured while performing rollback reprint count.");

		}
		return true;
	}

	public List<IdNameDto> getAllActiveDesignationsByStatus() {
		return designationRepository.getOnlyIdAndName();
	}

	/**
	 * Validate pay commission.
	 *
	 * @param empId     the emp id
	 * @param eventDate the event date
	 * @param payCommId the pay comm id
	 * @throws CustomException the custom exception
	 * @throws ParseException  the parse exception
	 */
	private void validatePayCommision(Long empId, LocalDate eventDate, Long payCommId, Date doj, Boolean isViewPage)
			throws CustomException, ParseException {
		if (Boolean.FALSE.equals(isViewPage))
			empPayDetailService.validatePayCommision(empId, Utils.convertToDate(eventDate), payCommId, doj);
	}

	/**
	 * Gets the regular employee common details for SHP.
	 *
	 * @param pageDetails the page details
	 * @return the regular employee common details for SHP
	 * @throws CustomException the custom exception
	 */
	public Map<String, Object> getRegularEmployeeCommonDetailsForSHP(PageDetails pageDetails) throws CustomException {
		Map<String, Object> main = new HashMap<>();
		PVUEmployeDepartmentEntity deptEntity = validateEmployeeType(
				PageDetails.getValue(pageDetails, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getKey()));
		Map<String, Object> map = this.buildPageInMap(pageDetails);
		LocalDate eventDate = PvuUtils
				.getDateFromStringYMD(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getValue()).toString());
		Long empId = deptEntity.getPvuEmployeEntity().getEmpId();
		this.validateBackDatedEffDateForEmpType(deptEntity, eventDate);
		validateEOL(empId, eventDate);
		validateSuspension(empId, eventDate);
		this.includeCurrentOffice(map);
		PVUCommonApiDto pvuCommonApiDto = this.getCommonDetailsBasedOnEventDateSHP(map);
		fetchExamDetail(main, pvuCommonApiDto.getEmployeeId());
		main.put(PvuConstant.EMPLOYEE, pvuCommonApiDto);
		return main;
	}

	/**
	 * Validate pay commision SHP.
	 *
	 * @param map the map
	 * @throws CustomException the custom exception
	 */
	public void validatePayCommisionSHP(Map<String, Object> map) throws CustomException {
		String employeeCode = map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getValue()).toString();
		LocalDate eventDate = PvuUtils
				.getDateFromStringYMD(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getValue()).toString());
		Long payCommission = Long.valueOf(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getValue()).toString());
		PVUEmployeDepartmentEntity deptEntity = getEmployeeDepartment(employeeCode);
		if (PvuUtils.isFromToBeforeEquals(PvuUtils.convertLocalDate(deptEntity.getDateOfJoiningGOG()), eventDate)) {
			throw new CustomException(HttpStatus.CONFLICT, PvuUtils.buildErrorMsg(payCommission));
		} else {
			throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(MsgConstant.ERROR_EMPLOYEE_JOINING_DATE,
					PvuUtils.getDateToStringDMYFormatValue(deptEntity.getDateOfJoiningGOG())));
		}
	}

	private PVUEmployeDepartmentEntity validateEmployeeType(String employeeNo, String menuId) throws CustomException {
		PVUEmployeDepartmentEntity deptEntity = getEmployeeDepartment(employeeNo);
		if (PvuConstant.EOL.equals(menuId) || PvuConstant.SUSPENSION.equals(menuId)) {
			if ((deptEntity.getEmpPayType().getLookUpInfoId() == PvuConstant.CONTRACT
					|| deptEntity.getEmpPayType().getLookUpInfoId() == PvuConstant.RE_APPOINTED)) {
				throw new CustomException(HttpStatus.CONFLICT,
						MsgConstant.ERROR_CONTRACTUAL_AND_REAPPOINTED_NOT_ALLOWED);
			}
		} else if (deptEntity.getEmpPayType().getLookUpInfoId() != PvuConstant.REGULAR_PAY_TYPE_ID) {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_EMPLOYEE_ONLY_REGULAR);

		}
		return deptEntity;
	}

	/**
	 * Validate employee type.
	 *
	 * @param employeeNo the employee no
	 * @return the PVU employe department entity
	 * @throws CustomException the custom exception
	 */
	private PVUEmployeDepartmentEntity validateEmployeeType(String employeeNo) throws CustomException {
		PVUEmployeDepartmentEntity deptEntity = getEmployeeDepartment(employeeNo);
		if (deptEntity.getEmpPayType().getLookUpInfoId() != PvuConstant.REGULAR_PAY_TYPE_ID) {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_EMPLOYEE_ONLY_REGULAR);
		}
		return deptEntity;
	}

	/**
	 * Validate employee type.
	 *
	 * @param employeeNo the employee no
	 * @return the PVU employe department entity
	 * @throws CustomException the custom exception
	 */
	private PVUEmployeDepartmentEntity validateEmployeeTypeForFixPayType(String employeeNo,String issubmiited) throws CustomException {
		PVUEmployeDepartmentEntity deptEntity = getEmployeeDepartment(employeeNo);
		if (deptEntity.getEmpPayType().getLookUpInfoId() != PvuConstant.FIX_PAY_TYPE_ID && issubmiited.equals(Constant.ZERO_STR)) {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_EMPLOYEE_ONLY_FIX);
		}
		return deptEntity;
	}

	private String getFixPayValue(long empId) throws CustomException {
		List<PVUEmployeFixPayDetailsEntity> entityList = fixPayDetailsRepository.findByEmpIdEmpId(empId);
		if (!entityList.isEmpty()) {
			IdNameDto dto = lookUpInfoRepository.getOnlyIdAndName(entityList.get(0).getFixPayValue().getLookUpInfoId());
			return dto.getName();
		} else {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERRORRESP_FIX_PAY);
		}

	}

	/**
	 * Gets the common details based on event date SHP.
	 *
	 * @param map the map
	 * @return the common details based on event date SHP
	 * @throws CustomException the custom exception
	 */
	private PVUCommonApiDto getCommonDetailsBasedOnEventDateSHP(Map<String, Object> map) throws CustomException {
		List<PVUCommonApiDto> objStorePro = this
				.callSp(Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_SP)), map);
		if (CollectionUtils.isEmpty(objStorePro)) {
			validateOffice(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getValue()).toString());
			validatePayCommisionSHP(map);
		}
		return objStorePro.get(0);
	}

	/**
	 * Validate office.
	 *
	 * @param employeeCode the employee code
	 * @throws CustomException the custom exception
	 */
	private void validateOffice(String employeeCode) throws CustomException {
		PVUEmployeDepartmentEntity deptEntity = getEmployeeDepartment(employeeCode);
		if (!deptEntity.getPresentOffice().getOfficeId()
				.equals(OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId())) {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.ERROR_EMPLOYEE_NOT_IN_OFFICE, employeeCode));
		}
	}

	/**
	 * Html to Gujarati PDF convert through node serve Url
	 * 
	 * @param html string as map
	 * @return Base64 in response for PDF generate on browser level
	 */
	public String htmlToPdfRequest(Map<String, Object> map) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> request = new HttpEntity<>(map, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(nodeUrl + URLConstant.GENERATE_PVU_PDF, request,
				String.class);
		return response.getBody();
	}

	/**
	 * Html to Gujarati PDF for watermark
	 * 
	 * @param base64 and watermark as string
	 * @return Base64 in response for PDF generate on browser level with watermark
	 */
	public String base64toPDFWithWaterMark(Map<String, Object> map, String watermark)
			throws IOException, DocumentException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] strdec = Base64.getDecoder().decode(htmlToPdfRequest(map));
		PdfReader reader = new PdfReader(strdec);
		int n = reader.getNumberOfPages();
		PdfStamper stamper = new PdfStamper(reader, baos);

		// text water mark
		Phrase p = new Phrase(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()) + "" + watermark, CAT_FONT);

		PdfGState gs1 = new PdfGState();
		gs1.setFillOpacity(0.5f);

		PdfContentByte over;
		for (int i = 1; i <= n; i++) {
			over = stamper.getOverContent(i);
			over.saveState();
			over.setGState(gs1);
			ColumnText.showTextAligned(over, Element.ALIGN_CENTER, p, 307.5f, 370, 45f);
			over.restoreState();
		}
		stamper.close();
		reader.close();
		return Base64.getEncoder().encodeToString(baos.toByteArray());
	}

	private List<PVUMsSixPayFormatDto> getDataforjudiciaryDept() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT  mps.PAY_SCALE_DISP_VAL , mps.SCALE_VAL , mgp.GRADE_PAY_ID , mgp.GRADE_PAY_VALUE ,mpc.PAY_BAND_ID ")
				.append(" FROM ").append(Constant.PVU_SCHEMA_MASTER).append(".MS_PAY_CONVERSION mpc ")
				.append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER).append(".MS_PAY_SCALE mps ")
				.append(" ON mpc.PAY_SCALE_6TH_ID  = mps.PAY_SCALE_ID  ").append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(".MS_GRADE_PAY mgp  ")
				.append(" ON mpc.GRADE_PAY_ID   =  mgp.GRADE_PAY_ID ")
				.append(" WHERE DEPT_ID = 17 AND mpc.ACTIVE_STATUS = 1 AND mgp.ACTIVE_STATUS = 1 AND mps.ACTIVE_STATUS = 1");
		List<Object[]> objectPvuSp = repository.executeSQLQueryOnly(sb.toString());
		return judiciaryExtrac(objectPvuSp);
	}

	private List<PVUMsSixPayFormatDto> judiciaryExtrac(List<Object[]> objectPvuSp) {
		List<PVUMsSixPayFormatDto> six = new ArrayList<>();
		if (!Utils.isEmpty(objectPvuSp)) {
			for (Object[] obj : objectPvuSp) {
				PVUMsGradePayFormatDto dtoGrade = new PVUMsGradePayFormatDto();
				PVUMsSixPayFormatDto sixDto = new PVUMsSixPayFormatDto();
				List<PVUMsGradePayFormatDto> listGradPay = new ArrayList<>();
				sixDto.setScaleValue(obj[0].toString());
				sixDto.setPayBandName(obj[1].toString());
				dtoGrade.setId(Long.parseLong(obj[2].toString()));
				dtoGrade.setGradePayValue(obj[3].toString());
				sixDto.setId(Long.parseLong(obj[4].toString()));
				listGradPay.add(dtoGrade);
				sixDto.setGradePays(listGradPay);
				six.add(sixDto);
			}
		}
		return six;
	}

	/**
	 * Fetch all the employee details.
	 *
	 * @param pageDetail the page detail
	 * @return List<> search common details
	 * @throws CustomException the custom exception
	 */
	public Map<String, Object> getSearchCommonDetailsForFixPayEmployee(PageDetails pageDetail)
			throws CustomException, ParseException {
		Map<String, Object> main = new HashMap<>();
		Map<String, Object> map = buildPageInMap(pageDetail);
		PVUEmployeDepartmentEntity deptEntity = validateEmployeeTypeForFixPayType(
				PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getKey()),
				PageDetails.getValue(pageDetail, PvuConstant.IS_SUBMITTIED));
		LocalDate eventDate = PvuUtils
				.getDateFromStringYMD(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getValue()).toString());
		Long empId = deptEntity.getPvuEmployeEntity().getEmpId();
		if(!(PageDetails.getValue(pageDetail, PvuConstant.ACTION_KEY).equalsIgnoreCase(PvuConstant.EDIT_KEY)||PageDetails.getValue(pageDetail, PvuConstant.ACTION_KEY).equalsIgnoreCase(PvuConstant.VIEW_KEY))) {
			this.checkEmployeeAlreadyinitiated(empId);
		}
		validateEOL(empId, eventDate);
		validateSuspension(empId, eventDate);
		this.includeCurrentOffice(map);
		PVUCommonApiDto pvuCommonApiDto = this.getCommonDetailsBasedOnEventDateForFixPay(map);
		// fetchExamDetail(main, pvuCommonApiDto.getEmployeeId());
		main.put(PvuConstant.EMPLOYEE, pvuCommonApiDto);
		main.put(PvuConstant.FixPAY, this.getFixPayValue(empId));
		return main;
	}
	
	
	/**
	 * Validate back dated eff date for emp type.
	 *
	 * @param pvuEmployeDepartmentEntity the pvu employee department entity
	 * @param effectiveDate the effective date
	 * @throws CustomException the custom exception
	 */
	public void validateBackDatedEffDateForEmpType(PVUEmployeDepartmentEntity pvuEmployeDepartmentEntity,
			LocalDate effectiveDate) throws CustomException {
		Date regularConvDate = pvuEmployeDepartmentEntity.getRegularConvDate();
		Long empPayType = pvuEmployeDepartmentEntity.getEmpPayType().getLookUpInfoId();
		Long joinEmpPayType = pvuEmployeDepartmentEntity.getJoinEmpPayType() != null
				? pvuEmployeDepartmentEntity.getJoinEmpPayType().getLookUpInfoId()
				: null;
		
		if ((PvuConstant.EMP_PAY_TYPE_REGULAR.equals(empPayType) && null != joinEmpPayType)
				&& (PvuConstant.EMP_PAY_TYPE_FIX.equals(joinEmpPayType)
						|| PvuConstant.ADHOC_BONDED_LOOKUP_ID.equals(joinEmpPayType)
						|| PvuConstant.EMP_PAY_TYPE_PROBATION.equals(joinEmpPayType))) {
			
			if (Objects.isNull(effectiveDate)) {
				throw new CustomException(1008, PvuMsgConstant.ERROR_MSG_EFF_DATE_NOT_NULL);
			}
			
			if (null != regularConvDate) {
				LocalDate regularConvLocalDate = PvuUtils.convertLocalDate(regularConvDate);
				if (effectiveDate.isBefore(regularConvLocalDate)) {
					throw new CustomException(HttpStatus.CONFLICT, PvuMsgConstant.ERROR_MSG_NOT_ALLOWED_BACKDATED_EVENTS);
				}
			}
		}
	}
	
	public PVUCommonApiDto getCommonDetailsBasedOnEventDateForFixPay(Map<String, Object> map) throws CustomException {
		validateOffice(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getValue()).toString());
		List<PVUCommonApiDto> objStorePro = this
				.callSp(Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_SP)), map);
		if (CollectionUtils.isEmpty(objStorePro)) {
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.PVU_ERRORRESP_EFFDATE_EMPJOINIG);
		}
		return objStorePro.get(0);

	}
	
	public void checkEmployeeAlreadyinitiated(Long empId) throws CustomException {
		List<PVUFixToRegularPayConEntity> list = fixToRegularPayConRepository.findByEmpIdAndCreatedByAndStatusIdAndActiveStatus(empId,
				OAuthUtility.getCurrentUserUserId(), Constant.SAVE_AS_DRAFT_STATUS_ID,Constant.ACTIVE_STATUS);
		if (!list.isEmpty()) {
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, MsgConstant.ERRORRESP_FTR_EMP_ALREADY_INIT);
		}
	}

	private List<PVUPayDetailsView> getFifthPayCommissionMasterEmp(Long departmentCategoryId, Long payCommissionId, String empNo, String effectiveDate)
			throws CustomException {
		List<PVUPayDetailsView> five = fivePayCommissionEmp(departmentCategoryId, payCommissionId, empNo, effectiveDate);
		return five.stream().filter(e -> e.getOrder() != null).sorted(Comparator.comparing(PVUPayDetailsView::getOrder))
				.collect(Collectors.toList());
	}

	private List<PVUPayDetailsView> fivePayCommissionEmp(Long dptCat, Long payComm, String empNo, String effectiveDate) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(PvuConstant.IN_DPT_ID, dptCat);
		map.put(PvuConstant.IN_PAY_COMM, payComm);
		map.put(EDPConstant.EMP_NO_VALUE, empNo);
		map.put(PvuConstant.IN_EFFECTIVE_DATE, effectiveDate);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_DEPT_CAT_PAY_COMM_REV));
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUPayDetailsView.class)
				: Collections.emptyList();
	}

	public PVUOptAvDto calcOptAvail(PVUOptAvDto dto) throws CustomException {
		if(dto.getPayCommissionId().equals(PvuConstant.FIFTH_COMMISSION_ID)){
			fifthPayCalculation(dto);
		}else if(dto.getPayCommissionId().equals(PvuConstant.SIXTH_COMMISSION_ID)){
			sixthPayCalculation(dto);
		}else if(dto.getPayCommissionId().equals(PvuConstant.SEVENTH_COMMISSION_ID)){
			seventhPayCalculation(dto);
		}
		return dto;
	}

	private void seventhPayCalculation(PVUOptAvDto dto) {
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.SP_OPTION_AVAIL_DETAILS_7PAY).toString();
		Map<String, Object> inParams = new LinkedHashMap<>();
		inParams.put(PvuConstant.P_IN_CUR_PAY_LEVEL_VALUE,dto.getcPayLevelValue());
		inParams.put(PvuConstant.P_IN_CUR_CELL_ID,dto.getcCellIdValue());
		inParams.put(PvuConstant.P_IN_POST_PAY_LEVEL_VALUE,dto.getpPayLevelValue());
		Map<String, Object> outParams = new LinkedHashMap<>();
		outParams.put(PvuConstant.P_OUT_CELL_ID,dto.getpCellIdValue());
		outParams.put(PvuConstant.P_OUT_BASIC_PAY,dto.getOaBasicPayValue());
		outParams.put(PvuConstant.P_OUT_PAY_CELL_ID,dto.getpPayCellId());
		repository.callStoredProcedureOutParams(procName,inParams,outParams);
		dto.setpCellIdValue(Long.parseLong(outParams.get(PvuConstant.P_OUT_CELL_ID).toString()));
		dto.setOaBasicPayValue(Long.parseLong(outParams.get(PvuConstant.P_OUT_BASIC_PAY).toString()));
		dto.setpPayCellId(Long.parseLong(outParams.get(PvuConstant.P_OUT_PAY_CELL_ID).toString()));
		outParams.entrySet().stream().forEach(e -> System.out.println(e.getKey()+" -> "+e.getValue()));
	}

	private void sixthPayCalculation(PVUOptAvDto dto) {
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.SP_OPTION_AVAIL_DETAILS_6PAY).toString();
		Map<String, Object> params = new LinkedHashMap<>();
		params.put(PvuConstant.P_IN_C_PAY_BAND,dto.getcPayBandId());
		params.put(PvuConstant.P_IN_C_GRADE_PAY_ID,dto.getcGradePayId());
		params.put(PvuConstant.P_IN_P_PAY_BAND,dto.getpPayBandId());
		params.put(PvuConstant.P_IN_P_GRADE_PAY_ID,dto.getpGradePayId());
		params.put(PvuConstant.P_IN_P_PAY_BAND_VALUE,dto.getpPayBandValue());
		params.put(PvuConstant.P_IN_DEPT_CAT_ID,dto.getEmpDeptCatId());
		Map<String, Object> outParams = new LinkedHashMap<>();
		outParams.put(PvuConstant.P_OUT_OA_BASIC_PAY_VALUE,dto.getOaBasicPayValue());
		outParams.put(PvuConstant.P_OUT_OA_PAY_BAND_VALUE,dto.getOaPayBandValue());
		repository.callStoredProcedureOutParams(procName,params,outParams);
		dto.setOaBasicPayValue(Long.parseLong(outParams.get(PvuConstant.P_OUT_OA_BASIC_PAY_VALUE).toString()));
		dto.setOaPayBandValue(Long.parseLong(outParams.get(PvuConstant.P_OUT_OA_PAY_BAND_VALUE).toString()));
		outParams.entrySet().stream().forEach(e -> System.out.println(e.getKey()+" -> "+e.getValue()));
	}

	private void fifthPayCalculation(PVUOptAvDto dto) {
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.SP_OPTION_AVAIL_DETAILS_5PAY).toString();
		Map<String, Object> params = new LinkedHashMap<>();
		params.put(PvuConstant.P_IN_CURRENT_PAY_SCALE,dto.getcPayScaleId());
		params.put(PvuConstant.P_IN_POST_BASIC_PAY,dto.getpBasicPayValue());
		params.put(PvuConstant.P_IN_POST_PAY_SCALE,dto.getpPayScaleId());
		String out = (String) repository.callStoredProcedureOutParam(procName,params);
		if(out!=null){
			dto.setOaBasicPayValue(Long.parseLong(out));
		}
	}

}
