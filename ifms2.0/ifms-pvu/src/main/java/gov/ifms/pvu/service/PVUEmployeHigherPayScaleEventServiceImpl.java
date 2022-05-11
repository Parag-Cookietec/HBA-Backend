package gov.ifms.pvu.service;

import static gov.ifms.pvu.entity.PVUEmployeEventsEntity.distinctByKey;
import static java.time.temporal.ChronoUnit.DAYS;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
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
import gov.ifms.common.logging.annotation.Trace;
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
import gov.ifms.edp.util.WatermarkPageEvent;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUEmployeHigherPayScaleEventConverter;
import gov.ifms.pvu.converter.PVUPrintEndorsementItrConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeHigherPayScaleEventDto;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUHigherPayGradeEventDDOView;
import gov.ifms.pvu.dto.PVUHigherPayInwardView;
import gov.ifms.pvu.dto.PVUHigherPayOfficeSearchView;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUOutwardView;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementView;
import gov.ifms.pvu.dto.PVUSSPRemarkRequest;
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
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeHigherPayScaleEventEntity;
import gov.ifms.pvu.entity.PVUEmployeSuspensionEntity;
import gov.ifms.pvu.entity.PVUEmployeeEOLeaveEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUPromotionEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeEventsRepository;
import gov.ifms.pvu.repository.PVUEmployeHigherPayScaleEventRepository;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.repository.PVUPromotionRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuMsgConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;

/**
 * The Class PVUEmployeHigherPayScaleEventController.
 */
@Service
public class PVUEmployeHigherPayScaleEventServiceImpl implements PVUEmployeHigherPayScaleEventService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	/**
	 * The PVUEmployeHigherPayScaleEventAsMethodName repository.
	 */
	@Autowired
	private PVUEmployeHigherPayScaleEventRepository repository;

	@Autowired
	private PVUEmployeHigherPayScaleEventConverter converter;

	@Autowired
	private EDPLuLookUpInfoRepository eDPLuLookUpInfoRepository;

	@Autowired
	private PVUEmployeRepository pvuEmployeRepository;

	@Autowired
	private PVUEmployeEventsRepository pvuEmployeEventsRepository;

	@Autowired
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	@Autowired
	private PVUCommonService pvuCommonService;

	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Autowired
	private PVUCommonService commonService;

	@Autowired
	private PVUEmployeEventsService eventsService;

	@Autowired
	private PVUEmployeeEOLeaveService eoLeaveService;

	@Autowired
	private PVUEmployeSuspensionService suspensionService;

	@Autowired
	private PVYFacade pvuFacade;

	@Autowired
	private PVUEmployeEventsService pvuEmployeEventsService;

	@Autowired
	private PVUMsReasonService pvuMsReasonService;

	@Autowired
	private WfRepository wfRepository;

	@Autowired
	private PVUEventRemarksService remarkService;

	@Autowired
	private PVUEmployeeEventStatusService statusService;

	@Autowired
	private PVUInwardService inwardService;

	@Autowired
	private PVUPromotionRepository proRepo;

	@Autowired
	private PVUEmployeEventsRepository pvuEmpEvent;

	@Autowired
	private PVUEmployeHigherPayScaleEventRepository higherPayScaleEventRepository;

	@Autowired
	private OAuthService authService;

	@Autowired
	private EncryptDecryptUtil securityUtil;
	@Autowired
	private PVUPrintEndorsementItrRepository printITRRepo;
	@Autowired
	private PVUPrintEndorsementItrConverter printEndorsementItrConverter;
	@Autowired
	private PVUPrintEndorsementRepository printRepository;
	@Autowired
	private PVUEmployePayDetailService empPayDetailService;

	/**
	 * Retrieves an PVUEmployeHigherPayScaleEventEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeHigherPayScaleEventEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeHigherPayScaleEventEntity getEmployeHigherPayScaleEvent(Long id) {
		return repository.findOneById(id);
	}

	/**
	 * Saves a given PVUEmployeHigherPayScaleEventEntity. Use the returned instance
	 * for further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param dto the entity
	 * @return the saved PVUEmployeHigherPayScaleEventEntity
	 */
	@Trace
	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public PVUEmployeHigherPayScaleEventDto saveOrUpdateEmployeHigherPayScaleEvent(PVUEmployeHigherPayScaleEventDto dto)
			throws CustomException {
		PVUEmployeHigherPayScaleEventEntity entity = converter.toEntity(dto);
		if (dto.getStatusId() == 0) {
			pvuEmployeeEventStatusService.inProgressSuspensionEvent(entity.getEmployee().getEmpId());
			entity.setStatus(eDPLuLookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT));
		}
		repository.save(entity);
		dto = this.converter.toDTO(entity);
		dto.setEmployeeNo(dto.getEmployeeNo());
		return dto;
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
					.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_HP_SCALE_LOOKUP_SP));
			List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupEmployeeHigherPaySp(procName);
			resultMap = lstPVUEmployeCreationDDLView.stream()
					.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
			return resultMap;
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the valid eligle employee for higher pay scale.
	 *
	 * @param request the request
	 * @return the valid eligle employee for higher pay scale
	 * @throws CustomException the custom exception
	 * @throws ParseException  the parse exception
	 */
	@Override
	public Map<String, Object> getValidEligleEmployeeForHigherPayScale(PvuCommonRequest request)
			throws CustomException, ParseException {
		Map<String, Object> data = request.getData();
		String employeeNo = data.get(PvuConstant.EMPLOYEE_NO).toString();
		long payCommId = Long.parseLong(data.get("payCommissionId").toString());
		Long empNo = Long.parseLong(employeeNo);
		long higherPayScaleType = Long.parseLong(data.get("higherPayScaleType").toString());
		long higherPayScaleForTeacher = Long.parseLong(data.get("higherPayScaleFor").toString());
		List<Long> teachersList = Arrays.asList(89L, 330L, 499L, 525L, 557L, 631L, 727L, 315L, 500L, 505L, 661L, 1330L,
				315L, 316L);
		LocalDate effectiveDate = PvuUtils.getDateFromStringYMD(data.get(PvuConstant.EFFECTIVE_DATE).toString());
		PVUEmployeEntity pvuEmployeEntity = pvuEmployeRepository.findByEmployeeCodeAndActiveStatus(empNo,Constant.ACTIVE_STATUS)
				.orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));

		boolean forgoExists = pvuEmployeEventsRepository.existsByEmpIdAndEventName(pvuEmployeEntity.getEmpId(),
				PvuConstant.EVENT_CODE_FORGO);
		if (forgoExists) {
			throw new CustomException(HttpStatus.CONFLICT, "This employee has choose forgo in our carrer !");
		}
		PVUEmployeDepartmentEntity pvuEmployeDepartmentEntity = pvuEmployeDepartmentRepository
				.findOneByPvuEmployeEntityEmpId(pvuEmployeEntity.getEmpId());
		long designId = pvuEmployeDepartmentEntity.getDesignationId().getDesignationId();
		long empPayType = pvuEmployeDepartmentEntity.getEmpPayType().getLookUpInfoId();
		
		LocalDate joiningDate = null;
		
		if (empPayType != 156) {
			throw new CustomException(HttpStatus.CONFLICT, PvuMsgConstant.ERROR_MSG_ALLOW_REGULAR_HPS);
		}
		
		pvuCommonService.validateBackDatedEffDateForEmpType(pvuEmployeDepartmentEntity, effectiveDate);
		
		if ((!StringUtils.isEmpty( pvuEmployeEntity.getCaseNo())) && (!pvuEmployeEntity.getCaseNo().equals("0"))) {
			joiningDate = PvuUtils.convertLocalDate(
					null != pvuEmployeDepartmentEntity.getFixPayDate() ? pvuEmployeDepartmentEntity.getFixPayDate()
							: pvuEmployeDepartmentEntity.getDateOfJoiningGOG());
		} else if (null != pvuEmployeDepartmentEntity.getJoinEmpPayType() && PvuConstant.ADHOC_BONDED_LOOKUP_ID
				.equals(pvuEmployeDepartmentEntity.getJoinEmpPayType().getLookUpInfoId())) {
			joiningDate = PvuUtils.convertLocalDate(null != pvuEmployeDepartmentEntity.getRegularConvDate()
					? pvuEmployeDepartmentEntity.getRegularConvDate()
					: pvuEmployeDepartmentEntity.getDateOfJoiningGOG());
		} else {
			joiningDate = PvuUtils.convertLocalDate(pvuEmployeDepartmentEntity.getDateOfJoiningGOG());
		}
		
		long day = DAYS.between(joiningDate, effectiveDate);
		long diffincount = checkEligibleHigherPayScale(joiningDate, effectiveDate, pvuEmployeEntity.getEmpId());
		long actualDays = day - diffincount;


		LocalDate  newLocalDate  =  joiningDate.plusDays(actualDays);
		Period intervalPeriod = Period.between(joiningDate, newLocalDate);
		int actualyear = 0;
		if(intervalPeriod != null){
			actualyear = intervalPeriod.getYears();
		}else {
			actualyear = (int) (actualDays / 365);
		}

		if (higherPayScaleForTeacher == 316 && !teachersList.contains(designId)) {
			throw new CustomException(1008,
					"'For Teachers', Employee designation should be Teacher/HeadMaster/Principal.");
		}
		if (higherPayScaleForTeacher == 317 && teachersList.contains(designId)) {
			throw new CustomException(1008,
					"'For other', Employee designation shouldn't be Teacher/HeadMaster/Principal.");
		}

		// ByPratik for given HPS only one time per employee.
		List<Object[]> objList = this.isGivenHPGList(
				String.valueOf(pvuEmployeDepartmentEntity.getPvuEmployeEntity().getEmpId()), higherPayScaleType);
		this.validateHigherPayScale(higherPayScaleType, objList);
		pvuCommonService.validateEOL(pvuEmployeEntity.getEmpId(), effectiveDate);
		pvuCommonService.validateSuspension(pvuEmployeEntity.getEmpId(), effectiveDate);
		validatePayCommApplicability(pvuEmployeEntity.getEmpId(), Utils.convertToDate(effectiveDate), payCommId,
				pvuEmployeDepartmentEntity.getDateOfJoiningGOG(),
				Boolean.valueOf(data.get(PVUSearchEnum.PVU_SEARCH_FIELD_VIEW_PAGE.getKey()).toString()));
		if (teachersList.contains(designId)) {
			return extractedValidation(data, employeeNo, payCommId, higherPayScaleType, actualyear);
		} else {
			return extractedFlow(data, employeeNo, payCommId, higherPayScaleType, joiningDate, actualyear);
		}
	}



	public static Date convertToDate(LocalDate dateToConvert) {
		return java.util.Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	private List<Object[]> isGivenHPGList(String empId, Long higherPayScaleType) {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.EMP_ID, empId);
		map.put("higherPayScaleType", higherPayScaleType);
		return repository.executeSQLQuery(PVUNativeSqlQueryConstant.isAllReadyGivenHPG(), map);
	}

	private void validateHigherPayScale(Long higherPayScaleType, List<Object[]> objList) throws CustomException {
		if (PvuConstant.PVU_HIGHER_PAY_GRADE_I.equalsIgnoreCase(String.valueOf(higherPayScaleType))
				&& !objList.isEmpty()) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "HigherPay Grade I is already given to this Employee on "
					+ new SimpleDateFormat(PvuConstant.DATE_FORMATE_DDMMYYYY).format((objList.get(0)[1])));

		}
		if (PvuConstant.PVU_HIGHER_PAY_GRADE_II.equalsIgnoreCase(String.valueOf(higherPayScaleType))
				&& !objList.isEmpty()) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "HigherPay Grade II is already given to this Employee on "
					+ new SimpleDateFormat(PvuConstant.DATE_FORMATE_DDMMYYYY).format((objList.get(0)[1])));
		}
		if (PvuConstant.PVU_HIGHER_PAY_GRADE_III.equalsIgnoreCase(String.valueOf(higherPayScaleType))
				&& !objList.isEmpty()) {
			throw new CustomException(HttpStatus.BAD_REQUEST,
					"HigherPay Grade III is already given to this Employee on "
							+ new SimpleDateFormat(PvuConstant.DATE_FORMATE_DDMMYYYY).format((objList.get(0)[1])));
		}
	}

	private Map<String, Object> extractedFlow(Map<String, Object> data, String employeeNo, long payCommId,
			long higherPayScaleType, LocalDate joiningDate, int actualyear) throws CustomException {
		return eligibleOfHps(data, employeeNo, payCommId, higherPayScaleType, joiningDate, actualyear);
	}

	private Map<String, Object> eligibleOfHps(Map<String, Object> data, String employeeNo, long payCommId,
			long higherPayScaleType, LocalDate joiningDate, int actualyear) throws CustomException {
		LocalDate dateCompare = PvuUtils.getDateFromStringYMD(PvuConstant.COM_DATE);
		if (joiningDate.compareTo(dateCompare) > 0) {
			return validHigherPay(data, employeeNo, payCommId, higherPayScaleType, actualyear);
		} else {
			if (higherPayScaleType == 328 && actualyear >= 9 || higherPayScaleType == 329 && actualyear >= 18
					|| higherPayScaleType == 330 && actualyear >= 27) {
				return extractedTeacher(data, employeeNo, payCommId);
			} else {
				throw new CustomException(1008, MsgConstant.EMPLOYEE_MSG_FOR_REGULAR);
			}
		}
	}

	/**
	 * @param data
	 * @param employeeNo
	 * @param payCommId
	 * @param higherPayScaleType
	 * @param actualyear
	 * @return
	 * @throws CustomException
	 */
	private Map<String, Object> validHigherPay(Map<String, Object> data, String employeeNo, long payCommId,
			long higherPayScaleType, int actualyear) throws CustomException {
		if (higherPayScaleType == 328 && actualyear >= 12 || higherPayScaleType == 329 && actualyear >= 24) {
			return extractedTeacher(data, employeeNo, payCommId);
		} else {
			throw new CustomException(1008, "For Others,Regular job years is less than 12 or 24");
		}
	}

	private Map<String, Object> extractedTeacher(Map<String, Object> data, String employeeNo, long payCommId)
			throws CustomException {
		PageDetails getOne = PageDetails.createSingleRecordObj();
		List<SearchParam> jsonArr = new ArrayList<>();
		jsonArr.add(SearchParam.create(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getKey(), employeeNo));
		jsonArr.add(SearchParam.create(PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_ID.getKey(), String.valueOf(0)));
		jsonArr.add(SearchParam.create(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getKey(),
				data.get(PvuConstant.EFFECTIVE_DATE).toString()));
		jsonArr.add(SearchParam.create(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getKey(), Long.toString(payCommId)));
		getOne.setJsonArr(jsonArr);
		return commonService.getSearchCommonDetailsForHigherPay(getOne);
	}

	private Map<String, Object> extractedValidation(Map<String, Object> data, String employeeNo, long payCommId,
			long higherPayScaleType, int actualyear) throws CustomException {
		if (higherPayScaleType == 328 && actualyear >= 9 || higherPayScaleType == 329 && actualyear >= 20
				|| higherPayScaleType == 330 && actualyear >= 31) {
			return extractedTeacher(data, employeeNo, payCommId);
		} else {
			throw new CustomException(1008, "'For Teachers', Regular job years is less than 9 or 20 or 31");
		}
	}

	public Long checkEligibleHigherPayScale(LocalDate to, LocalDate from, Long employeeId) throws CustomException {
		long countsus = 0;
		long counteol = 0;
		if (Objects.isNull(from)) {
			throw new CustomException(1008, "Effective date  should not be null");
		}
		List<PVUEmployeEventsEntity> eventExists = eventsService
				.getEventListFromEffectiveAndToEffectiveEventsIn(employeeId, to, from,
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

	/**
	 * Lookup employee reversion sp.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private List<PVUEmployeCreationDDLView> lookupEmployeeHigherPaySp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, Collections.emptyMap());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	@Override
	public PagebleDTO<PVUHigherPayGradeEventDDOView> ddoWFListing(PageDetails pageDetails) throws CustomException {
		Map<String, String> collect = this.getDdoWFListingSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(null, pageDetails, collect);
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_HIGHER_PAY_SCALE_LIST_WF));
		List<PVUHigherPayGradeEventDDOView> list = this.callHPSUDDOListing(sp, stringObjectMap);
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

	private List<PVUHigherPayGradeEventDDOView> callHPSUDDOListing(String sp, Map<String, Object> parameters)
			throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(sp, parameters);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUHigherPayGradeEventDDOView.class)
				: Collections.emptyList();
	}

	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public PVUEmployeHigherPayScaleEventDto insertHigherPayItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {

		PVUEmployeHigherPayScaleEventEntity find = repository.findOneById(pvuWFWrapperDto.getTrnId());

		if (find != null) {
			return extractedTrasanction(pvuWFWrapperDto, find);
		} else {
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		}
	}

	/**
	 * @param pvuWFWrapperDto
	 * @param find
	 * @return
	 * @throws CustomException
	 */
	private PVUEmployeHigherPayScaleEventDto extractedTrasanction(PvuWFWrapperDto pvuWFWrapperDto,
			PVUEmployeHigherPayScaleEventEntity find) throws CustomException {
		PVUEmployeHigherPayScaleEventEntity entity;
		entity = find;
		if (find.getTrnNo() == null) {
			trnGeneration(entity);
		}
		Long trnId = pvuWFWrapperDto.getTrnId();
		pvuFacade.callWorkFlowApis(pvuWFWrapperDto);
		EDPLuLookUpInfoEntity saveAsDraft = eDPLuLookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
		if (entity.getStatus().getLookUpInfoId() == saveAsDraft.getLookUpInfoId()) {
			extracted(trnId);
		} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
			approvedData(trnId);
		} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.PULLED_BACK)) {
			updateForPulledBack(pvuWFWrapperDto, entity);/* Inactive inward row */
		} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
			rejectedCondition(pvuWFWrapperDto, entity);
		} else if (pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)
				|| pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_I)) {
			authorizeValidation(pvuWFWrapperDto, entity);
		} else if (pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_II)
				|| pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_I)) {
			approverCondition(pvuWFWrapperDto);
		} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.FORWARD_TO_PVU)) {
			this.insertInwardTable(pvuWFWrapperDto);
		}
		if (pvuWFWrapperDto.getAssignByWfRoleId() == Constant.AUDITOR
				|| pvuWFWrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_TWO
				|| Objects.equals(pvuWFWrapperDto.getAssignByWfRoleId(), Constant.APPROVER_CLASS_ONE)) {
			this.insertHigherPayRemarks(pvuWFWrapperDto.getTrnId());
		}
		this.insertHigherPayInITRs(pvuWFWrapperDto);
		return converter.toDTO(entity);
	}

	/**
	 * @param trnId
	 */
	private void approvedData(Long trnId) {
		EDPLuLookUpInfoEntity printEnable = eDPLuLookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.CONDITION_CHECK,
						Constant.ACTIVE_STATUS, Constant.LOOKUP_YES);
		repository.updatePrintStatusAndApproveDate(Constant.ACTIVE_STATUS, trnId, OAuthUtility.getCurrentUserUserId(),
				new Date(), printEnable.getLookUpInfoId(), LocalDateTime.now());
	}

	/**
	 * @param trnId
	 */
	private void extracted(Long trnId) {
		/* trans Status is Save as Draft To submit */
		EDPLuLookUpInfoEntity submitStatus = eDPLuLookUpInfoRepository.findBylookUpInfoId(267L);
		repository.updateStatusId(submitStatus.getLookUpInfoId(), trnId, OAuthUtility.getCurrentUserUserId(),
				new Date());
		/* Insert ITR table */
	}

	/**
	 * @param pvuWFWrapperDto
	 * @param entity
	 */
	private void authorizeValidation(PvuWFWrapperDto pvuWFWrapperDto, PVUEmployeHigherPayScaleEventEntity entity) {
		/* Update Status ApproverClass II Or I Authorization */
		String authorizerRemark;
		if (pvuWFWrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)) {
			authorizerRemark = entity.getClassTwoRemarks();
		} else {
			authorizerRemark = entity.getClassOneRemarks();
		}

		EDPLuLookUpInfoEntity authorizationStatus = eDPLuLookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.RECOMMENDATION_FOR,
						Constant.ACTIVE_STATUS, Constant.AUTHORIZE);
		repository.updateStatusIdAndAuthorizer(authorizationStatus.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date(), LocalDateTime.now(),
				Long.parseLong(securityUtil.decrypt(pvuWFWrapperDto.getAssignByUserId())), authorizerRemark);

		inwardService.setAuthDate(pvuWFWrapperDto.getTrnId(), PvuConstant.HIGHER_PAY_EVENT_ID, LocalDateTime.now());

	}

	/**
	 * @param pvuWFWrapperDto
	 */
	private void approverCondition(PvuWFWrapperDto pvuWFWrapperDto) {
		/* Update Status ApproverClass II Or I Authorization */
		EDPLuLookUpInfoEntity authorizationStatus = eDPLuLookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.RECOMMENDATION_FOR,
						Constant.ACTIVE_STATUS, Constant.RETURN);
		repository.updateStatusId(authorizationStatus.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date());
		inwardService.setReturnDate(pvuWFWrapperDto.getTrnId(), PvuConstant.HIGHER_PAY_EVENT_ID, LocalDateTime.now());
		/* Unlock event */
	}

	/**
	 * @param entity
	 * @throws CustomException
	 */
	private void trnGeneration(PVUEmployeHigherPayScaleEventEntity entity) throws CustomException {
		PVUEmployeeEventStatusEntity statusEntry;
		statusEntry = pvuEmployeeEventStatusService.inProgressAnyEvent(entity.getEmployee().getEmpId());
		entity.setTrnNo(this.pvuCommonService.getTransactionNumber("HIGH"));
		statusEntry.setHighPayScale(Constant.ACTIVE_STATUS);
		entity.setRefDate(LocalDateTime.now());
		repository.save(entity);
		pvuEmployeeEventStatusService.updateEventInfo(statusEntry, entity.getTrnNo());
	}

	/**
	 * @param pvuWFWrapperDto
	 * @param entity
	 */
	private void rejectedCondition(PvuWFWrapperDto pvuWFWrapperDto, PVUEmployeHigherPayScaleEventEntity entity) {
		/* Update Reject Status for Any User Rejected */
		EDPLuLookUpInfoEntity rejectedStatus = eDPLuLookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.REJECTED);
		repository.updateStatusId(rejectedStatus.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date());
		/* Unlock event */
		statusService.resetInProgressEmployeeEventStatus(entity.getEmployee().getEmpId(),
				OAuthUtility.getCurrentUserLkPOUId());
	}

	public void insertHigherPayInITRs(PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_WORKFLOW_ROLE_ID, pvuWFWrapperDto.getAssignByWfRoleId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_HPS_EVNT_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	private void insertInwardTable(PvuWFWrapperDto wrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, wrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_CREATED_BY, OAuthUtility.getCurrentUserUserId());
		map.put(Constant.IN_CREATED_BY_POST, wrapperDto.getAssignByPostId());
		map.put(Constant.IN_POU_ID, wrapperDto.getAssignByPOUId());
		map.put(Constant.IN_OFFICE_ID, wrapperDto.getAssignByOfficeId());
		map.put(Constant.IN_EVENT_CODE, PvuConstant.PVU_HIGHER_PAY_EVENT_CODE);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_INWARD_INSERT));
		repository.callStoredProcedure(procName, map);
	}

	public void insertHigherPayRemarks(Long transId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.INSERT_ROP_REMARKS_ITRS); // Need
		repository.callStoredProcedure(procName.toString(), map);
	}

	@Transactional
	public void toEntityOfEmpEvent(PVUEmployeHigherPayScaleEventDto dto, PVUEmployeEntity entity, String wfStatus) {
		PVUEmployeEventsEntity employeeEventsEntity = new PVUEmployeEventsEntity();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, dto.getId());
		map.put(Constant.IN_EVENT_CODE, dto.getEventCode());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_AUTHORIZED_SP));
		repository.callStoredProcedure(procName, map);
		PVUEmployeDepartmentEntity department = this.pvuEmployeDepartmentRepository
				.findFirstByPvuEmployeEntityEmpId(dto.getEmployeeId());
		if (department != null) {
			employeeEventsEntity.setEmployeeClassId(department.getEmpClass().getLookUpInfoId());
			employeeEventsEntity.setDepartmentCategoryId(department.getDepartmentalCategory().getDeptCategoryId());
			employeeEventsEntity.setEmpDesignation(department.getDesignationId().getDesignationId());

			employeeEventsEntity.setTrnNo(dto.getTrnNo());
			employeeEventsEntity.setEmpBasicPay(dto.getBasicPay());
			employeeEventsEntity.setEventDate(LocalDateTime.of(dto.getEventEffectiveDate(), LocalTime.MIN));
			employeeEventsEntity.setEmpOption(0L);
			employeeEventsEntity.setEventDate(LocalDateTime.of(dto.getEventEffectiveDate(), LocalTime.MIN));
			employeeEventsEntity.setEmpNextIncrDate(LocalDateTime.of(dto.getDateOfNextIncrement(), LocalTime.MIN));
			employeeEventsEntity.setPayCommission(dto.getPayCommId());
			employeeEventsEntity.setOfficeId(dto.getOfficeId());
			employeeEventsEntity.setEventId(PvuConstant.HIGHER_PAY_EVENT_ID);
			employeeEventsEntity.setSourceId(PvuConstant.HIGHER_PAY_EVENT_ID);
			if (dto.getPayCommId() == PvuConstant.FIFTH_COMMISSION_ID) {
				employeeEventsEntity.setPayScale(dto.getPayScale());
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
			employeeEventsEntity.setEventName(dto.getEventCode());
			employeeEventsEntity.setEmpId(entity.getEmpId());
			employeeEventsEntity.setActiveStatus(dto.getActiveStatus());
			employeeEventsEntity.setEmpAutoApprove(LocalDateTime.now());
			pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeeEventsEntity);
		}
	}

	@Override
	public EDPMsOfficeDto getPVUOfficeName(IdDto idDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("eventId", idDto.getId());
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getHPSEmployeeOfficeId(), map);
		if (!Utils.isEmpty(objects)) {
			EDPMsOfficeDto officeDto = new EDPMsOfficeDto();
			officeDto.setOfficeName(String.valueOf(objects.get(0)[0]));
			return officeDto;
		}
		return null;
	}

	@Override
	public PagebleDTO<PVUHigherPayInwardView> getHigherPayInwardList(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapInwardList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_INWARD_LIST_WF).toString();
			List<PVUHigherPayInwardView> objStorePro = this.storeProcPvu(procName, map, PVUHigherPayInwardView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private Map<String, Object> buildPageInMapInwardList(PageDetails pageDetail) {
		Map<String, String> collect = getInwardSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

	public List<PVUSearchEnum> getInwardSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_CODE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
				PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_PAN,
				PVUSearchEnum.PVU_SEARCH_FIELD_INW_NO, PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO, PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID, PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID, PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO, PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_DISTRICT,
				PVUSearchEnum.PVU_SEARCH_CARDEX, PVUSearchEnum.PVU_SEARCH_DDO,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE

		);
	}

	public <T> List<T> storeProcPvu(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, view) : Collections.emptyList();
	}

	public Boolean generateInwardNumber(List<IdDto> dtos) throws CustomException {
		try {
			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
			dtos.forEach(dto -> {
				Map<Integer, Object> map = new HashMap<>();
				map.put(1, Constant.HP);
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
	public Boolean submiHigherPayInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	@Override
	public Boolean submitHigherpayDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	@Override
	public PagebleDTO<PVUHigherPayOfficeSearchView> pvuOfficeEmployeeSearch(PageDetails pageDetail)
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
				List<PVUHigherPayOfficeSearchView> list = NativeQueryResultsMapper.map(objStorePro,
						PVUHigherPayOfficeSearchView.class);
				list.forEach(e -> e.setEventCode(PvuConstant.PVU_HIGHER_PAY_EVENT_CODE));
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), list);
			}
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, 0, Collections.emptyList());
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public List<PVUMsReasonDto> getHigherpayReasons() {
		return pvuMsReasonService.getEventsReasons();
	}

	@Override
	public List<PVUEventRemarksDto> getReturnReasonByTransactionId(Long id) throws CustomException {
		return remarkService.getReturnRemarks(id, PvuConstant.HIGHER_PAY_EVENT_ID);
	}

	@Override
	public PVUEmployeHigherPayScaleEventDto updateHigherpayRemarks(PVUSSPRemarkRequest dto) throws CustomException {
		PVUEmployeHigherPayScaleEventEntity entity = converter.setRemarks(getEmployeHigherPayScaleEvent(dto.getId()),
				dto);
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
						|| dto.getClassTwoReturnReason() == Constant.RETURN_VAL;
			}
			if (isReturnReason) {
				remarkService.deActivateOldReason(dto.getId(), PvuConstant.HIGHER_PAY_EVENT_ID);
				List<PVUEventRemarksEntity> remarks = dto.getReturnReasons().stream().map(remarkDto -> {
					PVUEventRemarksEntity remark = new PVUEventRemarksEntity();
					remark.setEventID(PvuConstant.HIGHER_PAY_EVENT_ID);
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
	public String getWfCodeByHigherPayTrnId(Long trnId) {
		return this.wfRepository.findWfRlCdByHigherPayTrnId(trnId, Constant.ACTIVE_STATUS);
	}

	@Override
	public Map<String, Object> getPVUResponse(IdDto dto) throws CustomException {
		PVUEmployeHigherPayScaleEventEntity pvuHigherScale = getEmployeHigherPayScaleEvent(dto.getId());
		PVUEmployeHigherPayScaleEventDto higherPayDto = converter.toDTO(pvuHigherScale);
		if (pvuHigherScale != null && pvuHigherScale.getCurrentDetailsEventId() != null) {
			Map<String, String> event = converter.getEventDetails(converter.toDTO(pvuHigherScale));
			PVUCommonApiDto currentDetails = this.eventsService
					.getCommonApiResponse(pvuHigherScale.getCurrentDetailsEventId());
			PVUPromotionEntity promotionEntity = proRepo
					.findTopByEmployeeEmpIdAndPayCommLookUpInfoIdAndStatusLookUpInfoIdOrderByCreatedDateDesc(
							higherPayDto.getEmployeeId(), higherPayDto.getPayCommId(), 327L);
			Map<String, Object> newRsponse = new HashMap<>();
			if (promotionEntity != null) {
				promotionResponse(higherPayDto, promotionEntity, newRsponse);
			}
			List<PVUEmployeEventsEntity> entity = pvuEmpEvent
					.findAllByEmpIdAndEventName(higherPayDto.getEmployeeId(), PvuConstant.EVENT_CODE_HP).stream()
					.filter(distinctByKey(PVUEmployeEventsEntity::getTrnNo)).collect(Collectors.toList());
			Map<String, Object> responseHigher = new HashMap<>();
			if (!CollectionUtils.isEmpty(entity)) {
				higherPayResponse(entity, responseHigher);
			}
			Map<String, Object> response = new HashMap<>();
			response.put("currentDetails", currentDetails);
			response.put("postDetails", event);
			response.put("promotion", newRsponse);
			response.put("higherPayDate", responseHigher);
			return response;
		}
		throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
	}

	/**
	 * @param entity
	 * @param responseHigher
	 */
	private void higherPayResponse(List<PVUEmployeEventsEntity> entity, Map<String, Object> responseHigher) {
		for (PVUEmployeEventsEntity eventExist : entity) {
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
	}

	/**
	 * @param higherPayDto
	 * @param promotionEntity
	 * @param newRsponse
	 */
	private void promotionResponse(PVUEmployeHigherPayScaleEventDto higherPayDto, PVUPromotionEntity promotionEntity,
			Map<String, Object> newRsponse) {
		if (promotionEntity.getDesignation() != null) {
			newRsponse.put("promotionDesignation", promotionEntity.getDesignation().getDesignationName());
		}
		newRsponse.put("promotionEventdate", promotionEntity.getEventEffectiveDate());
		if (higherPayDto.getPayCommId() == PvuConstant.FIFTH_COMMISSION_ID) {
			newRsponse.put("promotionScale", promotionEntity.getPayScale());
		} else if (higherPayDto.getPayCommId() == (PvuConstant.SEVENTH_COMMISSION_ID)) {
			newRsponse.put("promotionCell", promotionEntity.getCell().getCellId());
			newRsponse.put("promotionPayLevel", promotionEntity.getPayLevel().getPayLevelValue());
		} else if (higherPayDto.getPayCommId() == (PvuConstant.SIXTH_COMMISSION_ID)) {
			newRsponse.put("promotionGradePay", promotionEntity.getGradePay().getGradePayValue());
			newRsponse.put("promotionPayBandValue", promotionEntity.getPayBandValue());
		}
	}

	@Override
	public PagebleDTO<PVUOutwardView> getHPSOutWardList(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, this.getOutwardPvuSearchFields()
					.stream().collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue)));
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_OUTWARD_LIST_WF).toString();
			List<PVUOutwardView> objStorePro = this.storeProcPvu(procName, map, PVUOutwardView.class);
			int page = 0;
			if (!objStorePro.isEmpty()) {
				long recordCount = objStorePro.get(0).getRecordCount();
				if (recordCount > pageDetail.getPageElement()) {
					page = ((int) (recordCount / pageDetail.getPageElement()) + 1);
				}
			}
			return new PagebleDTO<>(pageDetail.getPageElement(), page, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public Boolean generateOutWardNumber(List<IdDto> dtos) throws CustomException {
		try {
			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
			dtos.forEach(dto -> {
				Map<Integer, Object> map = new HashMap<>();
				map.put(1, Constant.HP);
				map.put(2, dto.getId());
				parameterMapList.add(map);
			});
			return repository.callStoreProcBatch("{CALL "
					+ Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.OUTWARD_NO_GENERATION_PVU)) + "(?,?)}",
					parameterMapList);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public Boolean submitHPSOutWard(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException {
		try {
			wrapperDto.forEach(e -> inwardService.setResetOutwardFlag(e.getTrnId(), PvuConstant.HIGHER_PAY_EVENT_ID));
			wrapperDto.forEach(e -> inwardService.setConsignmentNumber(e.getTrnId(), PvuConstant.HIGHER_PAY_EVENT_ID,
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
				map.put(PvuConstant.EVENT_ID, PvuConstant.HIGHER_PAY_EVENT_ID);
				map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
				List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getWfTable(), map);
				List<PVUWfTableInfo> tableList = !Utils.isEmpty(objects)
						? NativeQueryResultsMapper.map(objects, PVUWfTableInfo.class)
						: Collections.emptyList();
				tableInfo = !tableList.isEmpty() ? tableList.get(0) : null;
			}
			List<PvuWFWrapperDto> returnList = new ArrayList<>();
			if (tableInfo != null) {
				for (PvuWFOutWardWrapperDto dto : list) {
					extractedOutward(tableInfo, returnList, dto);
				}
				return pvuFacade.callWorkFlowApis(returnList);
			}
			if (!authList.isEmpty()) {
				wrapperDto.forEach(e -> authorizeHPS(e.getTrnId()));
				wrapperDto.forEach(e -> authorizeBackdateHPS(e.getTrnId()));
				authList.forEach(e -> e.setWfStatus(PvuConstant.AUTHORIZED));
				pvuFacade.callWorkFlowApis(PvuWFOutWardWrapperDto.createSuper(authList));
				for (PvuWFOutWardWrapperDto e : authList) {
					reset(repository.getEmpId(e.getTrnId()), PvuConstant.EVENT_CODE_HP);
				}
			}
			return true;
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	private void extractedOutward(PVUWfTableInfo tableInfo, List<PvuWFWrapperDto> returnList,
			PvuWFOutWardWrapperDto dto) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.TRN_ID, dto.getTrnId());
		List<Object[]> objects = repository.executeSQLQuery(
				PVUNativeSqlQueryConstant.getWfSourceUserDetail(tableInfo.getSchemaName(), tableInfo.getTableName()),
				map);
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
			dto.setWfStatus(PvuConstant.RETURNED);
			dto.setAssignToWfRoleId(3L);
			returnList.add(dto);
		}
	}

	public void authorizeHPS(Long trnId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnId);
		map.put(Constant.IN_EVENT_CODE, "Higher_Pay_Scale");
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.PVU_COMMON_AUTHORIZED_SP, map);
	}

	public void authorizeBackdateHPS(Long trnId) {
		String trnNo = repository.getTrnNo(trnId);
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		map.put(Constant.IN_EVNT_CODE, "Higher_Pay_Scale");
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map);
	}

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

	@Override
	public PagebleDTO<PVUPrintEndorsementView> getHPGPrintEndorsementList(PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail,
				this.getPrintPrintEndorsementSearchFields().stream()
						.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue)));
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF).toString();
		List<PVUPrintEndorsementView> objStorePro = this.storeProcPvu(procName, map, PVUPrintEndorsementView.class);
		objStorePro.forEach(e -> e.setEventCode(PvuConstant.PVU_HIGHER_PAY_EVENT_CODE));
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
	}

	@Override
	public String generateHPSPrintEndorsement(PvuPrintStickerReportDto dto) throws CustomException {

		try {
			List<PvuPrintStickerReportDto> list = new ArrayList<>();
			list.add(dto);
			return getFile(list);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);

		}

	}
	
	private String getFile(List<PvuPrintStickerReportDto> dto) throws CustomException {
		return generatePdf(dto);
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
			document.addTitle("Higher Pay Scale");
			document.setPageSize(PageSize.LETTER);
			PdfWriter pdfWriter = PdfWriter.getInstance(document, baos);
			document.open();
			for (PvuPrintStickerReportDto printStickerReportDto : dto) {
				
				PVUEmployeHigherPayScaleEventEntity entity = repository.findOneById(printStickerReportDto.getStickerDTO().getId());
				if (entity.getOffice().getOfficeId().equals(entity.getOffice().getPvuId())
						&& entity.getOffice().getOfficeId() != Constant.PVU_OFFICE_ID) {
					watermark = ", Self PVU";
				} else {
					watermark = ", PVU, Gandhinagar";
				}
				pdfWriter.setPageEvent(
						new WatermarkPageEvent(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()), watermark));
				writer.write(generateHPSPayPdf(printStickerReportDto, entity.getId()).toString());
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
			document.close();
			map.put("content", writer.toString());
			
			logger.info("PDF generated successfully");
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			String fileName = String.valueOf(System.currentTimeMillis()).concat(".pdf");
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
			return sb.toString();// call this method for node js API for
			// html with watermark
		
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	private StringWriter generateHPSPayPdf(PvuPrintStickerReportDto dto, Long id) throws CustomException {
		PVUStickerDTO stickerDTO = null;
		try {
			stickerDTO = submitPrintHistory(dto);
			PVUEmployeHigherPayScaleEventEntity entity = repository.findOneById(dto.getStickerDTO().getId());
			VelocityContext context = populateVContext(stickerDTO, entity);
			if (!Utils.isEmpty(entity.getAuthorizeBy())) {
				String authorizerName = authService.getOnlyIdAndName(entity.getAuthorizeBy()).getName();
				context.put("authorizerName", authorizerName);
			}

			StringWriter writer = new StringWriter();
			Template template = getTemplateByCommId(entity);
			template.merge(context, writer);
			return writer;
		} catch (CustomException ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}
	
	@Override
	public String generatePrintEndorsement(List<PvuPrintStickerReportDto> dtos) throws CustomException {
		try {
			return getFile(dtos);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public List<PrintEndorsementRemarkHistoryDto> getReprintEndorsementRemarks(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.TRN_ID, id);
		map.put(PvuConstant.EVENT_ID, PvuConstant.HIGHER_PAY_EVENT_ID);
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPVUEventEndorsementHistory(),
				map);
		return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PrintEndorsementRemarkHistoryDto.class)
				: Collections.emptyList();
	}

	@Override
	public boolean deleteHigherPayEventById(IdDto idDto) throws CustomException {
		PVUEmployeHigherPayScaleEventEntity entity = repository.findOneById(idDto.getId());
		if (entity != null) {

			EDPLuLookUpInfoEntity saveAsDraft = eDPLuLookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT);
			if (entity.getStatus().getLookUpInfoId() == saveAsDraft.getLookUpInfoId()) {
				repository.deleteHigherPayEventIdBy(Constant.IN_ACTIVE_STATUS, idDto.getId(),
						OAuthUtility.getCurrentUserUserId(), new Date());
				pvuEmployeeEventStatusService.resetInProgressEmployeeEventStatus(entity.getEmployee().getEmpId(),
						OAuthUtility.getCurrentUserLkPOUId());
				return Boolean.TRUE;
			} else {
				throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
			}
		}
		return Boolean.FALSE;
	}

	private PVUStickerDTO submitPrintHistory(PvuPrintStickerReportDto dto) throws CustomException {
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
		PVUPrintEndorsementEntity printEntity = null;
		try {
			PVUPrintEndorsementDto printDto = dto.getPrintEndorsementDto();
			if (printDto != null) {
				printEntity = printRepository.findOneByTrnIdAndEventIdAndActiveStatus(printDto.getTrnId(),
						PvuConstant.HIGHER_PAY_EVENT_ID, Constant.ACTIVE_STATUS);
				if (printEntity == null) {
					inwardService.setOutwardFlag(dto.getPvuWFWrapperDto().getTrnId(), PvuConstant.HIGHER_PAY_EVENT_ID);
					printEntity = new PVUPrintEndorsementEntity();
					printEntity.setTrnId(printDto.getTrnId());
					printEntity.setEventId(PvuConstant.HIGHER_PAY_EVENT_ID);
					printEntity.setPrintDate(new Date());
					printEntity.setPrintCnt(1L);
					dto.getPvuWFWrapperDto().setEventId(PvuConstant.HIGHER_PAY_EVENT_ID);
					pvuFacade.callWorkFlowApis(dto.getPvuWFWrapperDto());
				} else {
					printEntity.setPrintCnt((printEntity.getPrintCnt() + 1L));
					printEntity.setReprintDate(new Date());
					printEntity.setEventId(PvuConstant.HIGHER_PAY_EVENT_ID);
					printEntity.setRemark(printDto.getRemark());
				}
				printEntity = printRepository.save(printEntity);
				printITRRepo.save(printEndorsementItrConverter.toEntity(printEntity));
			}
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return printEntity != null ? converter.toPrintEndorsementDto(printEntity) : null;
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

	private void reset(Long empId, String eventCode) throws CustomException {
		PVUEmployeeEventStatusEntity employeeStatus = statusService.findOneByEmpId(empId);
		if (eventCode.equalsIgnoreCase(PvuConstant.EVENT_CODE_HP)) {
			employeeStatus.setHighPayScale(0);
		}
		employeeStatus.setTransId(null);
		statusService.saveOrUpdateEmployeeEventStatus(employeeStatus);
	}

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

	private Template getTemplateByCommId(PVUEmployeHigherPayScaleEventEntity hpEntity) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		/* next, get the Template */
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		Template template = new Template();

		if (!Utils.isEmpty(hpEntity.getPayComm())) {
			if (hpEntity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
				template = ve.getTemplate("templates/higherpay/higherPay7th.vm");
			} else if (hpEntity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
				template = ve.getTemplate("templates/higherpay/higherPay6th.vm");
			} else if (hpEntity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
				template = ve.getTemplate("templates/higherpay/higherPay5th.vm");
			}
		}
		return template;
	}

	private VelocityContext populateVContext(PVUStickerDTO stickerDTO, PVUEmployeHigherPayScaleEventEntity hpEntity) {
		VelocityContext context = new VelocityContext();
		PVUCommonApiDto common = this.eventsService.getCommonApiResponse(hpEntity.getCurrentDetailsEventId());
		Optional<PVUEmployeEntity> employeEntity = pvuEmployeRepository
				.findByEmpIdAndActiveStatus(hpEntity.getEmployee().getEmpId(), Constant.ACTIVE_STATUS);
		if (employeEntity.isPresent()) {
			PVUEmployeDepartmentEntity pvuEmployeDepartmentEntity;
			PVUEmployeEntity pvuEmployeEntity = employeEntity.get();
			String salutation = pvuEmployeEntity.getSalutation() != null
					? pvuEmployeEntity.getSalutation().getLookUpInfoName()
					: "";
			long gId = pvuEmployeEntity.getGender().getLookUpInfoId();
			String authName = authService.getOnlyIdAndName(hpEntity.getAuthorizeBy()).getName();
			long teacherId = hpEntity.getHpScaleFor().getLookUpInfoId();
			pvuEmployeDepartmentEntity = pvuEmployeDepartmentRepository
					.findOneByPvuEmployeEntityEmpId(pvuEmployeEntity.getEmpId());
			LocalDate joiningDate = PvuUtils.convertLocalDate(pvuEmployeDepartmentEntity.getDateOfJoiningGOG());
			String consTeacher = "PGR/1194/45-M";
			String consTeacherDate = "16/08/1994";
			String consOther = "PGR-102007-615-M";
			String consOtherDate = "02/07/2007";
			String consOthers = "PGR/1194/44-M";
			String consOthersDate = "16/08/1994";
			LocalDate dateCompare = PvuUtils.getDateFromStringYMD("2007/07/02");
			context.put("authName", authName); // EmpName Name

			populateContextOne(hpEntity, context, common, teacherId, joiningDate, dateCompare);
			velocityAssignData(stickerDTO, hpEntity, context);
			newAssignData(context, salutation, gId);
			if (teacherId == 316L) {
				context.put(PvuConstant.RES_NO, consTeacher);
				context.put(PvuConstant.REST_DATED, consTeacherDate);
			}
			if (joiningDate.compareTo(dateCompare) > 0 && teacherId != 316) {
				context.put(PvuConstant.RES_NO, consOther);
				context.put(PvuConstant.REST_DATED, consOtherDate);
			} else {
				context.put(PvuConstant.RES_NO, consOthers);
				context.put(PvuConstant.REST_DATED, consOthersDate);
			}
			veloAssignData(stickerDTO, hpEntity, context);
			extracted(hpEntity, context, common);
			velocityContextNew(stickerDTO, hpEntity, context, common);

		}
		return context;

	}

	/**
	 * @param context
	 * @param salutation
	 * @param gId
	 */
	private void newAssignData(VelocityContext context, String salutation, long gId) {
		if (gId == 86) {
			context.put("prefix", "He");
		} else {
			context.put("prefix", "She");
		}
		if (gId == 86) {
			context.put("prefixdata", "his");
			context.put("prefixdataCap", "His");
		} else {
			context.put("prefixdata", "her");
			context.put("prefixdataCap", "Her");
		}

		if (Utils.isNonEmpty(salutation)) {
			context.put("salutation", salutation);
		}
	}

	/**
	 * @param stickerDTO
	 * @param hpEntity
	 * @param context
	 */
	private void veloAssignData(PVUStickerDTO stickerDTO, PVUEmployeHigherPayScaleEventEntity hpEntity,
			VelocityContext context) {
		if (!Utils.isEmpty(hpEntity.getDateOfNextIncrement())) {
			context.put("nextIncDate", PvuUtils.getStrOfLocalDateInDDMMYYYY(hpEntity.getDateOfNextIncrement()));
		}
		if (!Utils.isEmpty(stickerDTO.getEndorsementPrintDate())) {
			context.put("endorsementPrintDate",
					new SimpleDateFormat("dd/MM/yyyy").format(stickerDTO.getEndorsementPrintDate()));
		}
		if (!Utils.isEmpty(stickerDTO.getEndorsementReprintDate())) {
			context.put("endorsementReprintDate",
					new SimpleDateFormat("dd/MM/yyyy").format(stickerDTO.getEndorsementReprintDate()));
		}
		if (!Utils.isEmpty(stickerDTO.getRePrintCount())) {
			context.put("rePrintCount", stickerDTO.getRePrintCount() - 1);
		}
		if (!Utils.isEmpty(hpEntity.getCell())) {
			context.put("cellIdValue", hpEntity.getCell().getCellValue());
		}
		if (hpEntity.getCell() != null && !Utils.isEmpty(hpEntity.getCell().getCellId())) {
			context.put("cellId", hpEntity.getCell().getCellId());
		}
	}

	/**
	 * @param stickerDTO
	 * @param hpEntity
	 * @param context
	 */
	private void velocityAssignData(PVUStickerDTO stickerDTO, PVUEmployeHigherPayScaleEventEntity hpEntity,
			VelocityContext context) {
		if (!Utils.isEmpty(stickerDTO.getEmployeeName())) {
			context.put("employeeName", stickerDTO.getEmployeeName()); // EmpName Name
		}
		if (!Utils.isEmpty(stickerDTO.getEmployeeNo())) {
			context.put("employeeNo", stickerDTO.getEmployeeNo()); // Employee Number
		}
		if (!Utils.isEmpty(stickerDTO.getDesignation())) {
			context.put("designation", stickerDTO.getDesignation());
		}
		if (!Utils.isEmpty(stickerDTO.getOfficeName())) {
			context.put("officeName", stickerDTO.getOfficeName());
		}
		if (!Utils.isEmpty(hpEntity.getHgEffDate())) {
			context.put("effectiveDate", PvuUtils.getStrOfLocalDateInDDMMYYYY(hpEntity.getHgEffDate()));
		}
	}

	/**
	 * @param stickerDTO
	 * @param hpEntity
	 * @param context
	 * @param common
	 */
	private void velocityContextNew(PVUStickerDTO stickerDTO, PVUEmployeHigherPayScaleEventEntity hpEntity,
			VelocityContext context, PVUCommonApiDto common) {
		if (!Utils.isEmpty(stickerDTO.getRePrintRemark())) {
			context.put("remarks", stickerDTO.getRePrintRemark());
		} else {
			context.put("remarks", "");
		}
		if (!Utils.isEmpty(common.getEmpBasicPay())
				&& hpEntity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			context.put("current7thPayBasic", common.getEmpBasicPay());
		}
		if (!Utils.isEmpty(stickerDTO.getLast5thPayCommissionScale())) {
			context.put("last5thPayCommissionScale", stickerDTO.getLast5thPayCommissionScale());
		}
		if (!Utils.isEmpty(hpEntity.getBasicPay())
				&& hpEntity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			context.put("revised5thPayBasic", hpEntity.getBasicPay());
		}
		if (!Utils.isEmpty(common.getEmpBasicPay())
				&& hpEntity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			context.put("current5thPayBasic", common.getEmpBasicPay());
		}
		if (!Utils.isEmpty(stickerDTO.getLast6thPayBand())) {
			context.put("last6thPayBand", stickerDTO.getLast6thPayBand());
		}
		if (!Utils.isEmpty(stickerDTO.getLast6thPayBandValue())) {
			context.put("last6thPayBandValue", stickerDTO.getLast6thPayBandValue());
		}
		if (!Utils.isEmpty(stickerDTO.getLast6thPayGradePay())) {
			context.put("last6thPayGradePay", stickerDTO.getLast6thPayGradePay());
		}
		if (!Utils.isEmpty(hpEntity.getBasicPay())
				&& hpEntity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			context.put("revised6thPayBasic", hpEntity.getBasicPay());
		}
		if (!Utils.isEmpty(common.getEmpBasicPay())
				&& hpEntity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			context.put("current6thPayBasic", common.getEmpBasicPay());
		}
	}

	/**
	 * @param hpEntity
	 * @param context
	 * @param common
	 */
	private void extracted(PVUEmployeHigherPayScaleEventEntity hpEntity, VelocityContext context,
			PVUCommonApiDto common) {
		velocityLevelContext(hpEntity, context, common);
		if (!Utils.isEmpty(hpEntity.getOptionAvailableDate())) {
			context.put("optionDate", PvuUtils.getStrOfLocalDateInDDMMYYYY(hpEntity.getOptionAvailableDate()));
		} else {
			context.put("optionDate", "");
		}
		if (!Utils.isEmpty(hpEntity.getGradePay())) {
			context.put("gradePay", hpEntity.getGradePay().getGradePayValue());
		}
		if (!Utils.isEmpty(common.getGradePayName())) {
			context.put("cGradePay", common.getGradePayName());
		}
		if (!Utils.isEmpty(hpEntity.getGradePay())) {
			context.put("payBand", hpEntity.getPayband().getPayBandDispVal());
		}
		if (!Utils.isEmpty(common.getPayBandName())) {
			context.put("cPayBand", common.getPayBandName());
		}
		if (!Utils.isEmpty(hpEntity.getPayBandValue())) {
			context.put("payBandValue", hpEntity.getPayBandValue());
		}
		if (!Utils.isEmpty(common.getPayBandValue())) {
			context.put("cPayBandValue", common.getPayBandValue());
		}
		if (!Utils.isEmpty(hpEntity.getBasicPay())
				&& hpEntity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			context.put("revised7thPayBasic", hpEntity.getBasicPay());
		}
	}

	/**
	 * @param hpEntity
	 * @param context
	 * @param common
	 */
	private void velocityLevelContext(PVUEmployeHigherPayScaleEventEntity hpEntity, VelocityContext context,
			PVUCommonApiDto common) {
		if (hpEntity.getHpScaleType() != null && hpEntity.getHpScaleType().getLookUpInfoId() == 328) {
			context.put(PvuConstant.HP_TYPE, "1st Higher Pay Scale");
		}
		if (hpEntity.getHpScaleType() != null && hpEntity.getHpScaleType().getLookUpInfoId() == 329) {
			context.put(PvuConstant.HP_TYPE, "2nd Higher Pay Scale");
		}
		if (hpEntity.getHpScaleType() != null && hpEntity.getHpScaleType().getLookUpInfoId() == 330) {
			context.put(PvuConstant.HP_TYPE, "3rd Higher Pay Scale");
		}

		if (!Utils.isEmpty(common.getCellId())) {
			context.put("currentCellIdValue", common.getCellName());
		}
		if (!Utils.isEmpty(hpEntity.getHpScaleType())) {
			context.put("hpscaletype", hpEntity.getHpScaleType().getLookUpInfoName());
		}
		if (!Utils.isEmpty(hpEntity.getPayLevel())) {
			context.put("levelValue", hpEntity.getPayLevel().getPayLevelValue());
		}
		if (!Utils.isEmpty(common.getPayLevelName())) {
			context.put("cLevelValue", common.getPayLevelName());
		}
		if (!Utils.isEmpty(hpEntity.getHpScaleFor())) {
			context.put("hpScaleFor", hpEntity.getHpScaleFor().getLookUpInfoName());
		}
	}

	/**
	 * @param hpEntity
	 * @param context
	 * @param common
	 * @param teacherId
	 * @param joiningDate
	 * @param dateCompare
	 */
	private void populateContextOne(PVUEmployeHigherPayScaleEventEntity hpEntity, VelocityContext context,
			PVUCommonApiDto common, long teacherId, LocalDate joiningDate, LocalDate dateCompare) {
		extraAssignValue(hpEntity, context, common, teacherId, joiningDate, dateCompare);
		if (hpEntity.getHpScaleType().getLookUpInfoId() == 329 && teacherId != 316
				&& joiningDate.compareTo(dateCompare) > 0) {
			context.put(PvuConstant.COMP_YEAR, "24"); // EmpName Name
		}
		if (hpEntity.getHpScaleType().getLookUpInfoId() == 328 && teacherId != 316
				&& joiningDate.compareTo(dateCompare) < 0) {
			context.put(PvuConstant.COMP_YEAR, "9");
			// EmpName Name
		}
		if (hpEntity.getHpScaleType().getLookUpInfoId() == 329 && teacherId != 316
				&& joiningDate.compareTo(dateCompare) < 0) {
			context.put(PvuConstant.COMP_YEAR, "18"); // EmpName Name
		}
		if (hpEntity.getHpScaleType().getLookUpInfoId() == 330 && teacherId != 316
				&& joiningDate.compareTo(dateCompare) < 0) {
			context.put(PvuConstant.COMP_YEAR, "27"); // EmpName Name
		}

		if (hpEntity.getHpScaleType().getLookUpInfoId() == 328 && teacherId != 316
				&& joiningDate.compareTo(dateCompare) == 0) {
			context.put(PvuConstant.COMP_YEAR, "9");
			// EmpName Name
		}
		if (hpEntity.getHpScaleType().getLookUpInfoId() == 329 && teacherId != 316
				&& joiningDate.compareTo(dateCompare) == 0) {
			context.put(PvuConstant.COMP_YEAR, "18"); // EmpName Name
		}
		if (hpEntity.getHpScaleType().getLookUpInfoId() == 330 && teacherId != 316
				&& joiningDate.compareTo(dateCompare) == 0) {
			context.put(PvuConstant.COMP_YEAR, "27"); // EmpName Name
		}
	}

	/**
	 * @param hpEntity
	 * @param context
	 * @param common
	 * @param teacherId
	 * @param joiningDate
	 * @param dateCompare
	 */
	private void extraAssignValue(PVUEmployeHigherPayScaleEventEntity hpEntity, VelocityContext context,
			PVUCommonApiDto common, long teacherId, LocalDate joiningDate, LocalDate dateCompare) {
		if (!Utils.isEmpty(common.getPayScaleName())) {
			context.put("cPayScale", common.getPayScaleName());
		}
		if (!Utils.isEmpty(hpEntity.getPayScale())) {
			context.put("payScale",
					hpEntity.getPayScale() == 0 ? "" : converter.getPayScaleValue(hpEntity.getPayScale()));
		}
		if (!Utils.isEmpty(hpEntity.getBasicPay())
				&& hpEntity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			context.put("fifthBasic", hpEntity.getBasicPay());
		}
		if (!Utils.isEmpty(hpEntity.getAuthorizerRemark())) {
			context.put("authorizerRemark", hpEntity.getAuthorizerRemark());
		} else {
			context.put("authorizerRemark", "");
		}
		if (hpEntity.getHpScaleType().getLookUpInfoId() == 328 && teacherId != 316
				&& joiningDate.compareTo(dateCompare) > 0) {
			context.put(PvuConstant.COMP_YEAR, "12");
		}
		setContextValue(hpEntity, context, teacherId);
	}

	private void setContextValue(PVUEmployeHigherPayScaleEventEntity hpEntity, VelocityContext context,
			long teacherId) {
		if (hpEntity.getHpScaleType().getLookUpInfoId() == 328 && teacherId == 316) {
			context.put(PvuConstant.COMP_YEAR, "9");
		}
		if (hpEntity.getHpScaleType().getLookUpInfoId() == 329 && teacherId == 316) {
			context.put(PvuConstant.COMP_YEAR, "20");
		}
		if (hpEntity.getHpScaleType().getLookUpInfoId() == 330 && teacherId == 316) {
			context.put(PvuConstant.COMP_YEAR, "31");
		}
	}

	/**
	 * Update for pulled back.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @param pvuEntity       the pvu entity
	 */
	private void updateForPulledBack(PvuWFWrapperDto pvuWFWrapperDto, PVUEmployeHigherPayScaleEventEntity pvuEntity) {
		inwardService.updateStatusId(Constant.INACTIVE_STATUS, pvuEntity.getId(), new Date(),
				pvuWFWrapperDto.getEventId());
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
	private void validatePayCommApplicability(long empId, Date eventDate, Long payCommId, Date doj, Boolean isViewPage)
			throws CustomException, ParseException {
		if (Boolean.FALSE.equals(isViewPage))
			empPayDetailService.validatePayCommision(empId, eventDate, payCommId, doj);
	}
}