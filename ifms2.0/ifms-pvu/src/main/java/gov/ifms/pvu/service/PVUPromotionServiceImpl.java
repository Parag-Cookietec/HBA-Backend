package gov.ifms.pvu.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.exception.ValidationUtil;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUPromotionConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUPromotionDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.request.PromotionValidationRequest;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUEmployeCCCExamDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeLangExamEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUPromotionEntity;
import gov.ifms.pvu.repository.PVUEmployeCCCExamDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeEventsRepository;
import gov.ifms.pvu.repository.PVUEmployeLangExamRepository;
import gov.ifms.pvu.repository.PVUMsGradePayRepository;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import gov.ifms.pvu.repository.PVUMsPayLevelRepository;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.repository.PVUPromotionRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuMsgConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVUPromotionServiceImpl.
 */
@Service
@Transactional
public class PVUPromotionServiceImpl implements PVUPromotionService {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PVUPromotionServiceImpl.class.getName());

	/**
	 * The PVUPromotionRepository repository.
	 */
	@Autowired
	private PVUPromotionRepository repository;

	/**
	 * The PVUPromotionRepository repository.
	 */
	@Autowired
	private PVUCommonService commonService;

	/**
	 * The pvu facade.
	 */
	@Autowired
	private PVYFacade pvuFacade;

	/**
	 * The e DP lu look up info repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/**
	 * The PVUPromotionConverter converter.
	 */
	@Autowired
	private PVUPromotionConverter converter;

	/** The pvu employe events service. */
	@Autowired
	private PVUEmployeEventsService pvuEmployeEventsService;

	/** The status service. */
	@Autowired
	private PVUEmployeeEventStatusService statusService;

	/** The auth service. */
	@Autowired
	private OAuthService authService;

	/**
	 * The ccc exam detail repository.
	 */
	@Autowired
	private PVUEmployeCCCExamDetailRepository cccExamRepo;

	/**
	 * The lang exam repository.
	 */
	@Autowired
	private PVUEmployeLangExamRepository langRepository;

	/** The scale repository. */
	@Autowired
	private PVUMsPayScaleRepository scaleRepository;

	/** The pvu employe events repository. */
	@Autowired
	private PVUEmployeEventsRepository pvuEmployeEventsRepository;
	
	/**
	 * The PVUMsPayCellRepository cellRepository.
	 */
	@Autowired
	private PVUMsGradePayRepository gradePayRepository;
	
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
	 * Retrieves an PVUPromotionEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUPromotionEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUPromotionEntity getPVUPromotion(Long id) {
		return repository.findOneById(id);
	}

	/**
	 * Saves a given PVUPromotionEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the entity
	 * @return the saved PVUPromotionEntity
	 */
	@Transactional(rollbackFor = CustomException.class)
	@Override
	public PVUPromotionDto saveOrUpdatePVUPromotion(PVUPromotionDto dto) throws CustomException { // NOSONAR
		PVUPromotionEntity entity = converter.toEntity(dto);
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
	public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException {
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_PROMOTION_LOOKUPS_SP));
		List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupPromotionSp(procName);
		return lstPVUEmployeCreationDDLView.stream()
				.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
	}

	/**
	 * Lookup employee EOL creation sp.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private List<PVUEmployeCreationDDLView> lookupPromotionSp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	/**
	 * Insert employee promotion itr.
	 *
	 * @param wrapperDto the wrapperDto
	 * @return PVUPromotionDto
	 * @throws CustomException the custom exception
	 */
	@ExceptionHandler
	@Transactional(rollbackFor = Exception.class)
	@Override
	public PVUPromotionDto insertInITR(PvuWFWrapperDto wrapperDto) throws CustomException {
		Date approvedDate = new Date();
		Optional<PVUPromotionEntity> find = repository.findById(wrapperDto.getTrnId());
		EDPLuLookUpInfoEntity empApprovStatsLookupInfo = lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.APPROVED);
		PVUPromotionDto dto;
		PVUPromotionEntity entity;
		if ((find.isPresent()) && (find.get().getStatus() != null)
				&& (find.get().getStatus().getLookUpInfoId() != empApprovStatsLookupInfo.getLookUpInfoId())) {
			entity = find.get();
			if (entity.getTrnNo() == null) {
				PVUEmployeeEventStatusEntity statusEntry = statusService
						.inProgressAnyEvent(entity.getEmployee().getEmpId());
				entity.setRefDate(LocalDateTime.now());
				entity.setTrnNo(this.commonService.getTransactionNumber("PR"));
				repository.save(entity);
				statusService.updateEventInfo(statusEntry, entity.getTrnNo());
			}
			Boolean isReturn = pvuFacade.callWorkFlowApis(wrapperDto);
			if (isReturn.equals(Boolean.TRUE)) {
				EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = lookUpInfoRepository
						.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
								Constant.ACTIVE_STATUS, Constant.SUBMIT);
				if (empSubmitStatusLookupInfo != null) {
					repository.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
							OAuthUtility.getCurrentUserUserId(), approvedDate);
				}
				dto = converter.toDTO(find.get());
				if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
					find.get().setStatus(empApprovStatsLookupInfo);
					repository.updateStatusId(empApprovStatsLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
							OAuthUtility.getCurrentUserUserId(), approvedDate);
					saveEmpEvent(dto, find.get().getEmployee(), wrapperDto.getWfStatus());
					reset(find.get().getEmployee().getEmpId());

					// PV-1053 fix START
					authorizeBackdateSP(wrapperDto.getTrnId());
					// PV-1053 fix END
				} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
					EDPLuLookUpInfoEntity empRejectStatsLookupInfo = lookUpInfoRepository
							.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
									Constant.ACTIVE_STATUS, Constant.REJECTED);
					repository.updateStatusId(empRejectStatsLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
							OAuthUtility.getCurrentUserUserId(), approvedDate);
					reset(find.get().getEmployee().getEmpId());
				}
				insertITR(wrapperDto);
				return dto;
			}
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
		} else {
			if (find.isPresent()) {
				throw new CustomException(HttpStatus.CONFLICT,
						String.format(MsgConstant.PVU_PROMOTION_ALREADY_APPROVED, find.get().getTrnNo()));
			}
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * Authorize backdate SP.
	 *
	 * @param trnId the trn id
	 */
	public void authorizeBackdateSP(Long trnId) {

		String trnNo = repository.getTrnNo(trnId);
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		map.put(Constant.IN_EVNT_CODE, PvuConstant.EVENT_CODE_PROMOTION);
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map);
	}

	/**
	 * Update emp event status.
	 *
	 * @param empId the empId
	 * @throws CustomException the custom exception
	 */
	private void reset(Long empId) throws CustomException {
		PVUEmployeeEventStatusEntity employeeStatus = statusService.findOneByEmpId(empId);
		employeeStatus.setPromotion(0);
		employeeStatus.setTransId(null);
		statusService.saveOrUpdateEmployeeEventStatus(employeeStatus);
	}

	/**
	 * Execute workflow api.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 */
	private void insertITR(final PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_EVENT_NAME, PvuConstant.EVENT_CODE_PROMOTION);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_COMMON_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * Sets the comparer details.
	 *
	 * @param dto the new comparer details
	 * @throws CustomException the custom exception
	 */
	@Override
	public void setComparerDetails(PVUPromotionDto dto) throws CustomException {
		PageDetails getOne = PageDetails.createSingleRecordObj();
		List<SearchParam> jsonArr = new ArrayList<>();
		jsonArr.add(SearchParam.create(PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO.getKey(),
				String.valueOf(dto.getEmployeeNo())));
		jsonArr.add(SearchParam.create(PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_ID.getKey(), String.valueOf(0)));
		jsonArr.add(SearchParam.create(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getKey(),
				String.valueOf(dto.getPayCommId())));
		jsonArr.add(SearchParam.create(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getKey(),
				PvuUtils.getStrOfLocalDateInYMD(dto.getEventEffectiveDate())));
		getOne.setJsonArr(jsonArr);
		Map<String, Object> map = this.commonService.buildPageInMap(getOne);
		this.commonService.includeCurrentOffice(map);
		PVUCommonApiDto found = this.commonService.getCommonDetailsBasedOnEventDate(map);
		PVUPromotionDto.Exists exists = new PVUPromotionDto.Exists();
		exists.setEmployeeClassId(found.getClassId());
		exists.setDesignationId(found.getDesignationId());
		exists.setBasicPay(found.getEmpBasicPay());
		exists.setPayCommId(found.getPayCommId());
		if (exists.getPayCommId() == PvuConstant.FIFTH_COMMISSION_ID) {
			// 5 pay comm id
			exists.setPayScale(found.getPayScale());
		} else if (exists.getPayCommId() == PvuConstant.SIXTH_COMMISSION_ID) {
			// 6 pay comm id
			exists.setGradePayId(found.getGradePayId());
			exists.setPayBandValue(found.getPayBandValue());
		} else if (exists.getPayCommId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			// 7 pay comm id
			exists.setPayLevelId(found.getPayLevelId());
			exists.setCellId(found.getCellId());
		}
		dto.setExists(exists);
	}

	/**
	 * To entity of emp event.
	 *
	 * @param dto      the dto
	 * @param employee employee
	 * @param wfStatus wfStatus
	 * @throws CustomException the custom exception
	 */
	@Transactional
	public void saveEmpEvent(PVUPromotionDto dto, PVUEmployeEntity employee, String wfStatus) throws CustomException {
		PVUEmployeEventsEntity employeeEventsEntity = new PVUEmployeEventsEntity();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, dto.getTrnNo());
		map.put(Constant.IN_STATUS_ID, wfStatus);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_APPROVE_PROMOTION));
		repository.callStoredProcedure(procName, map);

		if (dto.getEmployeeClassId() == 162 || dto.getEmployeeClassId() == 163) {
			employeeEventsEntity.setEmployeeTypeId(168l);
		}
		if (dto.getEmployeeClassId() == 164 || dto.getEmployeeClassId() == 165) {
			employeeEventsEntity.setEmployeeTypeId(167l);
		}
		employeeEventsEntity.setTrnNo(dto.getTrnNo());
		employeeEventsEntity.setEmployeeClassId(dto.getEmployeeClassId());
		employeeEventsEntity.setDepartmentCategoryId(dto.getDepartmentCategoryId());
		employeeEventsEntity.setEventType(PvuConstant.MANUAL);
		employeeEventsEntity.setEmpBasicPay(dto.getBasicPay());
		employeeEventsEntity.setEventDate(PvuUtils.startDay(dto.getEventEffectiveDate()));
		employeeEventsEntity.setEmpNextIncrDate(PvuUtils.startDay(dto.getDateOfNextIncrement()));
		employeeEventsEntity.setEmpDesignation(dto.getDesignationId());
		employeeEventsEntity.setEmpOption(dto.getOptionAvailableId() == 2L ? 1L : 0L);
		employeeEventsEntity.setEmpOptionAvalDate(dto.getOptionAvailableDate());
		employeeEventsEntity.setPayCommission(dto.getPayCommId());
		employeeEventsEntity.setOfficeId(dto.getOfficeId());
		employeeEventsEntity.setEventName(PvuConstant.EVENT_CODE_PROMOTION);
		employeeEventsEntity.setEmpId(employee.getEmpId());
		employeeEventsEntity.setActiveStatus(dto.getActiveStatus());
		employeeEventsEntity.setEmpAutoApprove(LocalDateTime.now());
		employeeEventsEntity.setEventId(PvuConstant.PROMOTION_EVENT_ID);
		employeeEventsEntity.setSourceId(PvuConstant.PROMOTION_EVENT_ID);
		if (dto.getPayCommId() == PvuConstant.FIFTH_COMMISSION_ID) {
			employeeEventsEntity.setPayScale(dto.getPayScale());
		} else if (dto.getPayCommId() == PvuConstant.SIXTH_COMMISSION_ID) {
			employeeEventsEntity.setEmpPayBand(dto.getPayBandId());
			employeeEventsEntity.setEmpGrdPay(dto.getGradePayId());
			employeeEventsEntity.setPayBandValue(dto.getPayBandValue());
		} else if (dto.getPayCommId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			employeeEventsEntity.setCellId(dto.getCellId());
			employeeEventsEntity.setEmpPaylevel(dto.getPayLevelId());
		}
		setRevisionNo(employeeEventsEntity);
		pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeeEventsEntity);
	}

	/**
	 * Validate promotion.
	 *
	 * @param request the request
	 * @return true, if successful
	 * @throws CustomException the custom exception
	 */
	@Override
	public boolean validatePromotion(PromotionValidationRequest request) throws CustomException { // NOSONAR
		Long employeeId = request.getEmployeeId();
		boolean forgoExists = pvuEmployeEventsService.existsFromTo(employeeId, PvuConstant.EVENT_CODE_FORGO,
				PvuUtils.startDay(request.getEffectiveDate().minusYears(1L)),
				PvuUtils.endDay(request.getEffectiveDate()));
		if (forgoExists) {
			LOGGER.info("This employee has forgo in last one year!");
			throw new CustomException(HttpStatus.CONFLICT, "This employee has forgo in last one year!");
		}

		List<FieldError> errors = new ArrayList<>();
		Long employeeClassId = request.getEmployeeClassId();
		if (employeeClassId != null) {
			boolean isFullExempted = false;
			List<PVUEmployeCCCExamDetailEntity> cccExam = cccExamRepo
					.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(employeeId,
							Constant.ACTIVE_STATUS);
//					.stream().filter(e -> ().collect(Collectors.toList());
			if (!CollectionUtils.isEmpty(cccExam)) {
				for (PVUEmployeCCCExamDetailEntity cccExamEntity: cccExam) {
					if (cccExamEntity.getExamStatus().getLookUpInfoId() == PvuConstant.EXAM_EXEMPT) {
						isFullExempted = true;				
					}
				}
				if (!isFullExempted) {
					Optional<PVUEmployeCCCExamDetailEntity> ccT = cccExam.stream()
							.filter(e -> e.getCccExamName().getLookUpInfoId() == 140L).findFirst();
					Optional<PVUEmployeCCCExamDetailEntity> ccP = cccExam.stream()
							.filter(e -> e.getCccExamName().getLookUpInfoId() == 141L).findFirst();
					Optional<PVUEmployeCCCExamDetailEntity> ccPP = cccExam.stream()
							.filter(e -> e.getCccExamName().getLookUpInfoId() == 142L).findFirst();
					Optional<PVUEmployeCCCExamDetailEntity> ccPT = cccExam.stream()
							.filter(e -> e.getCccExamName().getLookUpInfoId() == 143L).findFirst();

					if (employeeClassId == 164L) {
						if (!((ccP.isPresent() && ccT.isPresent()) || (ccPP.isPresent() && ccPT.isPresent()))) {
							errors.add(PvuUtils.errorField(PVUPromotionDto.class.getSimpleName(),
									PvuConstant.CCC_EXAMS_WORD, "Class III must have CCC/CCC+ "));
						}
					} else if ((employeeClassId == 162L || employeeClassId == 163L)
							&& (!(ccPP.isPresent() && ccPT.isPresent()))) {
						errors.add(PvuUtils.errorField(PVUPromotionDto.class.getSimpleName(),
								PvuConstant.CCC_EXAMS_WORD,
								String.format("Class %s must have CCC+ ", employeeClassId == 162L ? "I" : "II")));
					}
				} 
			} else {
				throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(PvuMsgConstant.ERROR_MSG_EXAM_MANDATORY, ""));
			}

			if (employeeClassId == 162L || employeeClassId == 163L || employeeClassId == 164L
					|| employeeClassId == 165L) {
				List<PVUEmployeLangExamEntity> lanExam = langRepository
						.findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(employeeId,
								Constant.ACTIVE_STATUS);

				List<PVUEmployeLangExamEntity> lanExamList = new ArrayList<>();
				for (PVUEmployeLangExamEntity langExamLocal : lanExam) {
					if (langExamLocal.getLangName() != null && (langExamLocal.getLangName().getLookUpInfoId() == 144L
							|| langExamLocal.getLangName().getLookUpInfoId() == 145L)) {
						lanExamList.add(langExamLocal);
					}
				}

				if (lanExamList.size() < 2) {
					errors.add(PvuUtils.errorField(PVUPromotionDto.class.getSimpleName(), PvuConstant.LANG_EXAMS_WORD,
							PvuConstant.LANG_EXAMS_MSG));
				} else {
					Optional<PVUEmployeLangExamEntity> hindi = lanExam.stream()
							.filter(e -> e.getLangName().getLookUpInfoId() == 144L).findFirst();
					Optional<PVUEmployeLangExamEntity> gujrati = lanExam.stream()
							.filter(e -> e.getLangName().getLookUpInfoId() == 145L).findFirst();
					if (!(hindi.isPresent() && gujrati.isPresent())) {
						errors.add(PvuUtils.errorField(PVUPromotionDto.class.getSimpleName(),
								PvuConstant.LANG_EXAMS_WORD, PvuConstant.LANG_EXAMS_MSG));
					}
				}
			}
		}
		if ((!PvuUtils.isTest) && (!CollectionUtils.isEmpty(errors))) {
			ValidationUtil.throwErrors(errors);
		}
		return true;
	}

	/**
	 * Delete by id.
	 *
	 * @param dto the dto
	 * @throws CustomException the custom exception
	 */
	@Override
	public void deleteById(IdDto dto) throws CustomException {
		if (dto.getId() != null) {
			PVUPromotionEntity entity = this.repository.getOne(dto.getId());
			if (entity.getEmployee() != null && entity.getEmployee().getEmpId() != 0) {
				reset(entity.getEmployee().getEmpId());
			}
			repository.deleteById(Constant.IN_ACTIVE_STATUS, dto.getId(), OAuthUtility.getCurrentUserUserId(),
					new Date());
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

	/**
	 * Generate pdf.
	 *
	 * @param dto the dto
	 * @return the string
	 */
	public String generatePdf(IdDto dto) {
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
			document.addTitle("Promotion Event");
			document.setPageSize(PageSize.LETTER);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			pdfWriter = PdfWriter.getInstance(document, baos);

			// open document
			document.open();
			writer.write(generatePrint(dto).toString());
			
			map.put("content", writer.toString());
			htmltoPdf = commonService.htmlToPdfRequest(map);
			
			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));

			// close the document
			document.close();
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_PDF);
			header.set(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=" + PvuConstant.EVENT_CODE_PROMOTION + ".pdf");
			header.setContentLength(baos.toByteArray().length);

			LOGGER.info("PDF generated successfully");

			return htmltoPdf;

		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Generate print.
	 *
	 * @param dto the dto
	 * @return the string writer
	 * @throws CustomException the custom exception
	 */
	public StringWriter generatePrint(IdDto dto) throws CustomException {
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		PVUPromotionEntity entity = this.getPVUPromotion(dto.getId());
		VelocityContext context = converter.populateVContext(entity);
		context.put("APPROVER_NAME", String.valueOf(authService.getOnlyIdAndName(entity.getUpdatedBy()).getName()));
		Map<String, Object> map = new HashMap<>();
		map.put("userId", entity.getUpdatedBy());
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getUserDesgnationFromUserId(),
				map);
		context.put("APPROVER_DESIGNATION", String.valueOf(objects.get(0)[0]));

		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {

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
			chngePayLevel.put("cellId", entity.getCell().getCellId());
			List<Object[]> chngPayLvl = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPayInPayLevel(),
					chngePayLevel);
			context.put("PAY_IN_LEVEL", String.valueOf(chngPayLvl.get(0)[0]));
			setIncreamentValueForSevenPayCommi(entity, context);
		} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			context.put("PAYSCALE", this.scaleRepository.getOnlyIdAndName(entity.getPayScale()).getName());
			boolean status = PvuUtils.compareToLocalDate(entity.getEventEffectiveDate(),
					PvuUtils.getDateFromStringYMD(PvuConstant.EVENT_EFFICTED_DATE_5_PAY));
			if (status) {
				context.put("CIVIL", PvuConstant.G_CIVIL);
				context.put("CIVIL_SUB", PvuConstant.G_CIVIL_SUB);
				context.put("PRA_CIVIL",
						PvuConstant.G_PRA_CIVIL_OPTION + entity.getOptionAvailable().getLookUpInfoName());
			} else {
				context.put("CIVIL", PvuConstant.B_CIVIL);
				context.put("CIVIL_SUB", PvuConstant.B_CIVIL_SUB);
				context.put("PRA_CIVIL",
						PvuConstant.B_PRA_CIVIL_OPTION + entity.getOptionAvailable().getLookUpInfoName());
			}
			setIncreament(entity, context);
		} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			setIncreamentValueForSixPayCommi(entity, context);
		}

		Template template = getPrintTemplate(entity);
		template.merge(context, writer);
		return writer;
	}

	/**
	 * Sets the increament.
	 *
	 * @param entity  the entity
	 * @param context the context
	 */
	private void setIncreament(PVUPromotionEntity entity, VelocityContext context) {
		List<PVUEmployeEventsEntity> entities = pvuEmployeEventsRepository
				.findAllByEmpIdAndPayCommissionAndActiveStatus(entity.getEmployee().getEmpId(),
						PvuConstant.FIFTH_COMMISSION_ID, 1);
		long total = entity.getcBasicPay();
		for (PVUEmployeEventsEntity eventEntity : entities) {
				if (eventEntity != null && entity.getEventEffectiveDate().getYear() == eventEntity.getEventDate().getYear()
						&& (PvuConstant.REGULAR_INCREMENT_NAME.equalsIgnoreCase(eventEntity.getEventName())
								||	(PvuConstant.AUTO_INCREMENT_NAME.equalsIgnoreCase(eventEntity.getEventName()  )))) {
					total =	total + eventEntity.getEmpBasicPay() - entity.getBasicPay();
					context.put("BASIC_INC_VALUE", eventEntity.getEmpBasicPay() - entity.getBasicPay());
					context.put("NEXT_DATE_INC", PvuUtils.getStrOfLocalDateTimeInDDMMYYYY(eventEntity.getEmpNextIncrDate()));
				}
				
				if (eventEntity != null && entity.getEventEffectiveDate().getYear() == eventEntity.getEventDate().getYear()
						&& PvuConstant.NOTIONAL_INCREMENT_NAME.equalsIgnoreCase(eventEntity.getEventName())) {
					total =	total + eventEntity.getEmpBasicPay() - entity.getBasicPay();
					context.put("N_BASIC_INC_VALUE", eventEntity.getEmpBasicPay() - entity.getBasicPay());
					context.put("N_NEXT_DATE_INC", PvuUtils.getStrOfLocalDateTimeInDDMMYYYY(eventEntity.getEmpNextIncrDate()));
				}
				
			}
	//	context.put("events", list);
		context.put("Total", total);
	}

	/**
	 * Gets the prints the template.
	 *
	 * @param entity the entity
	 * @return the prints the template
	 */
	public Template getPrintTemplate(PVUPromotionEntity entity) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template tempName = new Template();
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/promotion/promotion7.vm");
		} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/promotion/promotion6.vm");
		} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/promotion/promotion5.vm");
		}
		return tempName;
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

	private void setIncreamentValueForSixPayCommi(PVUPromotionEntity entity, VelocityContext context) {
		List<PVUEmployeEventsEntity> entities = pvuEmployeEventsRepository
				.findAllByEmpIdAndPayCommissionAndActiveStatus(entity.getEmployee().getEmpId(),
						PvuConstant.SIXTH_COMMISSION_ID, 1);
		setRegurincrementByEventEntity(entity, context, entities);
	}

	private void setRegurincrementByEventEntity(PVUPromotionEntity entity, VelocityContext context,
			List<PVUEmployeEventsEntity> entities) {
		IdNameDto val;
		for (PVUEmployeEventsEntity eventEntity : entities) {
			if (eventEntity != null && entity.getEventEffectiveDate().getYear() == eventEntity.getEventDate().getYear()
					&& (PvuConstant.REGULAR_INCREMENT_NAME.equalsIgnoreCase(eventEntity.getEventName())
							||	(PvuConstant.AUTO_INCREMENT_NAME.equalsIgnoreCase(eventEntity.getEventName()  )))) {
				context.put("CURRENT_INC_VALUE", eventEntity.getEmpBasicPay());
				val = this.gradePayRepository.getOnlyIdAndName(eventEntity.getEmpGrdPay());
				context.put("INC_VALUE", val.getName());
			}
			notionalIncreament(entity, eventEntity, context);
		}
	}

	private void notionalIncreament(PVUPromotionEntity entity, PVUEmployeEventsEntity eventEntity,
			VelocityContext context) {
		IdNameDto val;
		if (eventEntity != null && entity.getEventEffectiveDate().getYear() == eventEntity.getEventDate().getYear()
				&& PvuConstant.NOTIONAL_INCREMENT_NAME.equalsIgnoreCase(eventEntity.getEventName())) {
			context.put("CURRENT_NOTIONAL_INC_VALUE", eventEntity.getEmpBasicPay());
			val = this.gradePayRepository.getOnlyIdAndName(eventEntity.getEmpGrdPay());
			context.put("INC_GRADE_PAY", val.getName());
		}
	}

	private void setIncreamentValueForSevenPayCommi(PVUPromotionEntity entity, VelocityContext context) {
		List<PVUEmployeEventsEntity> entities = pvuEmployeEventsRepository
				.findAllByEmpIdAndPayCommissionAndActiveStatus(entity.getEmployee().getEmpId(),
						PvuConstant.SEVENTH_COMMISSION_ID, 1);
		setRegurincrementForSevenByEventEntity(entity, context, entities);
	}

	private void setRegurincrementForSevenByEventEntity(PVUPromotionEntity entity, VelocityContext context,
			List<PVUEmployeEventsEntity> entities) {
		IdNameDto val;
		for (PVUEmployeEventsEntity eventEntity : entities) {
			if (eventEntity != null && entity.getEventEffectiveDate().getYear() == eventEntity.getEventDate().getYear()
					&& (PvuConstant.REGULAR_INCREMENT_NAME.equalsIgnoreCase(eventEntity.getEventName())
						||	(PvuConstant.AUTO_INCREMENT_NAME.equalsIgnoreCase(eventEntity.getEventName()  )))) {
				val = this.levelRepository.getOnlyIdAndName(eventEntity.getEmpPaylevel());
				context.put("PAYLAVEL_INC_VALUE", val.getName());
				val = this.cellRepository.getOnlyIdAndName(eventEntity.getCellId());
				context.put("INC_CELL", val.getName());
			}
			notionalIncreamentForSeven(entity, eventEntity, context);
		}
	}

	private void notionalIncreamentForSeven(PVUPromotionEntity entity, PVUEmployeEventsEntity eventEntity,
			VelocityContext context) {
		IdNameDto val;
		if (eventEntity != null && entity.getEventEffectiveDate().getYear() == eventEntity.getEventDate().getYear()
				&& PvuConstant.NOTIONAL_INCREMENT_NAME.equalsIgnoreCase(eventEntity.getEventName())) {
			val = this.levelRepository.getOnlyIdAndName(eventEntity.getEmpPaylevel());
			context.put("N_PAYLAVEL_INC_VALUE", val.getName());
			val = this.cellRepository.getOnlyIdAndName(eventEntity.getCellId());
			context.put("N_INC_CELL", val.getName());
		}
	}

}
