package gov.ifms.pvu.service;

import static gov.ifms.pvu.entity.PVUEmployeEventsEntity.distinctByKey;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

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
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;

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
import gov.ifms.common.exception.ValidationUtil;
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
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.util.WatermarkPageEvent;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUCareerAdvancementConverter;
import gov.ifms.pvu.converter.PVUPrintEndorsementItrConverter;
import gov.ifms.pvu.dto.PVUCASDDOView;
import gov.ifms.pvu.dto.PVUCASInwardView;
import gov.ifms.pvu.dto.PVUCareerAdvanceCurDetailDto;
import gov.ifms.pvu.dto.PVUCareerAdvanceCurrentDetailsView;
import gov.ifms.pvu.dto.PVUCareerAdvanceEmployeView;
import gov.ifms.pvu.dto.PVUCareerAdvancementDto;
import gov.ifms.pvu.dto.PVUCareerAdvancementOfficeSearchView;
import gov.ifms.pvu.dto.PVUCareerAdvancementPostDto;
import gov.ifms.pvu.dto.PVUCarrierAdvanceCurrentDto;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUOutwardView;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementView;
import gov.ifms.pvu.dto.PVUSSPRemarkRequest;
import gov.ifms.pvu.dto.PVUSourceUserDetails;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.PVUWfTableInfo;
import gov.ifms.pvu.dto.PrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.request.CASValidationRequest;
import gov.ifms.pvu.dto.response.PVUCASPrintDto;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUCareerAdvancementEntity;
import gov.ifms.pvu.entity.PVUEmployeCCCExamDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeDeptExamDetailsEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeLangExamEntity;
import gov.ifms.pvu.entity.PVUEmployeQualificationEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;
import gov.ifms.pvu.entity.PVUMsCourseEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.repository.PVUCareerAdvancementRepository;
import gov.ifms.pvu.repository.PVUEmployeCCCExamDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeDeptExamDetailsRepository;
import gov.ifms.pvu.repository.PVUEmployeEventsRepository;
import gov.ifms.pvu.repository.PVUEmployeLangExamRepository;
import gov.ifms.pvu.repository.PVUEmployeQualificationRepository;
import gov.ifms.pvu.repository.PVUInwardRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.repository.PVURevisionOfPayRemarkRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;

/**
 * The Class PVUCareerAdvancementService.
 *
 * @version v 1.0
 * @created 2020/01/09 11:46:59
 */
@Service
public class PVUCareerAdvancementServiceImpl implements PVUCareerAdvancementService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private OAuthService authService;

	@Autowired
	EncryptDecryptUtil securityUtil;

	@Autowired
	private PVUPrintEndorsementItrConverter printEndorsementItrConverter;

	@Autowired
	private PVUPrintEndorsementItrRepository printITRRepo;

	@Autowired
	private PVUPrintEndorsementRepository printRepository;

	/** The PVUCarrearAdvancementAsMethodName repository. */
	@Autowired
	private PVUCareerAdvancementRepository repository;

	/** The PVUCarrearAdvancementAsMethodName helper. */
	@Autowired
	private PVUCareerAdvancementConverter converter;

	/**
	 * The dept exam details repository.
	 */
	@Autowired
	private PVUEmployeDeptExamDetailsRepository deptExamDetailsRepository;

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

	@Autowired
	private PVUEmployeQualificationRepository pvuEmployeQualificationRepository;

	@Autowired
	private PVUCommonService commonService;

	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	/**
	 * The e DP lu look up info repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Autowired
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	@Autowired
	private PVYFacade pvuFacade;

	@Autowired
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	@Autowired
	private PVUEmployeEventsService pvuEmployeEventsService;

	@Autowired
	private PVUEmployeDepartmentRepository pvuEmployeeDepartmentRepo;

	@Autowired
	private PVURevisionOfPayRemarkRepository remarkRepository;

	@Autowired
	private WfRepository wfRepository;

	@Autowired
	private PVUEmployeEventsService eventsService;

	@Autowired
	private PVUEmployeEventsRepository pvuEmpEvent;

	@Autowired
	private PVUEventRemarksService remarkService;
	@Autowired
	private PVUInwardService inwardService;
	@Autowired
	PVUPrintEndorsementRepository pvuPrintEndorsementRepository;
	@Autowired
	PVUInwardRepository pvuInwardRepository;

	@Autowired
	PVUEmployeService pvuEmployeService;

	@Autowired
	private PVUEmployePayDetailService empPayDetailService;

	/**
	 * Retrieves an PVUCarearAdvancementEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUCarearAdvancementEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUCareerAdvancementEntity getCarrearAdvancement(Long id) {
		logger.info("Start getCarrearAdvancement");
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUCarearAdvancementEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUCarearAdvancementEntity
	 * @throws CustomException
	 */
	@Override
	public PVUCareerAdvancementDto saveOrUpdateCarrearAdvancement(PVUCareerAdvancementDto dto) throws CustomException {
		logger.info("Start saveOrUpdateCarrearAdvancement");
		PVUCareerAdvancementEntity entity = converter.toEntity(dto);
		if (dto.getStatusId() == 0) {
			pvuEmployeeEventStatusService.inProgressSuspensionEvent(entity.getEmployee().getEmpId());
			entity.setStatusId(lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT));
		}
		entity = repository.save(entity);
		dto = this.converter.toDTO(entity);
		return dto;
	}

	/**
	 * Fetch all the PVUCarrearAdvancement items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUCarearAdvancementDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUCareerAdvancementDto> getCarrearAdvancements(PageDetails pageDetail) throws CustomException {
		try {
			logger.info("Start getCarrearAdvancements");
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUCareerAdvancementEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUCareerAdvancementEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUCareerAdvancementEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the DDL lu look up info as map.
	 *
	 * @return the DDL lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Override
	public Map<String, List<PVUEmployeCreationDDLView>> getDDLLuLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> resultMap = null;
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMP_CAS_LOOKUP_SP));
		List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupEmployeeCreationSp(procName);
		resultMap = lstPVUEmployeCreationDDLView.stream()
				.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
		return resultMap;
	}

	/**
	 * Lookup employee creation sp.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private List<PVUEmployeCreationDDLView> lookupEmployeeCreationSp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, Collections.emptyMap());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	/**
	 * Lookup employee creation sp.
	 *
	 * @param procName the proc name
	 * @param map      the map
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<PVUCareerAdvanceEmployeView> storeProcCommonEmp(String procName, Map<String, Object> map)
			throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUCareerAdvanceEmployeView.class)
				: Collections.emptyList();
	}

	@Override
	public Map<String, Object> getEmployeeCurrDetail(PVUCareerAdvanceCurDetailDto curDetailDto)
			throws CustomException, ParseException {
		
		PVUEmployeDepartmentEntity entity = pvuEmployeeDepartmentRepo
				.findFirstByPvuEmployeEntityEmployeeCode(curDetailDto.getEmpNo())
				.orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
		
		if (!entity.getPresentOffice().getOfficeId()
				.equals(OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId())) {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.ERROR_EMPLOYEE_NOT_IN_OFFICE, curDetailDto.getEmpNo().toString()));
		}
		
		commonService.validateBackDatedEffDateForEmpType(entity, PvuUtils.getDateFromStringYMD(curDetailDto.getEffectiveDate()));
		
		Map<String, Object> main = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> map = buildCASEmployeeRequestMap(curDetailDto);
		List<PVUCareerAdvanceCurrentDetailsView> objStorePro = getPvuCareerAdvanceCurrentDetailsProc(map);
		
		validatePayCommision(map, objStorePro, curDetailDto.getIsViewPage(), entity);
		if (!CollectionUtils.isEmpty(objStorePro)) {
			PVUCareerAdvanceCurrentDetailsView advanceCurrentDetailsView = objStorePro.get(0);
			main.put(PvuConstant.EMPLOYEE, advanceCurrentDetailsView);
			if (advanceCurrentDetailsView != null) {
				long id = Long.parseLong(advanceCurrentDetailsView.getEmpId());

				getQualifications(response, id);
				getDeptExams(response, id);
				getCCCExamDetails(response, id);

				List<PVUEmployeLangExamEntity> lanExam = langExamRepository
						.findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(id, Constant.ACTIVE_STATUS);
				List<PVUCommonApiDto.EXAMDto> langExams = lanExam.stream().map(e -> {
					EDPLuLookUpInfoEntity examName = e.getLangName();
					Date dateOfPassing = e.getDateOfPassing();
					EDPLuLookUpInfoEntity lookUpInfoName = e.getExamStatus();
					return PVUCommonApiDto.EXAMDto.create(examName != null ? examName.getLookUpInfoName() : null,
							e.getExamBody(), dateOfPassing,
							lookUpInfoName != null ? lookUpInfoName.getLookUpInfoName() : null);
				}).collect(Collectors.toList());
				response.put(PvuConstant.LANG_EXAMS, langExams);
			}
			main.put(PvuConstant.EXAMS, response);
		}

		return main;
	}

	private void getCCCExamDetails(Map<String, Object> response, long id) {
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
	}

	private void getDeptExams(Map<String, Object> response, long id) {
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
			if (e.getPercentageCGPA() != null)
				percentage = e.getPercentageCGPA().toString();
			if (e.getCourseName() != null)
				courseName = e.getCourseName().getCourseName();
			if (e.getDegree() != null)
				exam = e.getDegree().getCourseName();
			Date passingDate = null;
			try {
				passingDate = getDate(dateOfPassing);
			} catch (CustomException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return PVUCommonApiDto.EXAMDto.create(exam != null ? exam : null,
					universityBoard != null ? universityBoard : null, passingDate,
					percentage != null ? percentage : null, courseName);
		}).collect(Collectors.toList());
		response.put(PvuConstant.MAST_EXAMS, qualification);
	}

	private Date getDate(EDPMsFinancialYearEntity dateOfPassing) throws CustomException {
		String sDate1 = "01/04/2019";
		if (dateOfPassing.getFy() != null)
			sDate1 = "01/04/" + dateOfPassing.getFyStart();
		Date passingDate = new Date();
		try {
			passingDate = PvuUtils.getStringToDate(sDate1);
		} catch (ParseException ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(HttpStatus.CONFLICT, ex.getMessage());
		}
		return passingDate;
	}

	private List<PVUCareerAdvanceCurrentDetailsView> getPvuCareerAdvanceCurrentDetailsProc(Map<String, Object> map)
			throws CustomException {
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.PVU_EMPLOYEE_CAS_CURR_EVNT_DTLS);
		try {
			List<Object[]> objectPvuSp = repository.callStoredProcedureWithSQLErrorCode(procName.toString(), map);
			return !objectPvuSp.isEmpty()
					? NativeQueryResultsMapper.map(objectPvuSp, PVUCareerAdvanceCurrentDetailsView.class)
					: Collections.emptyList();
		}

		catch (PersistenceException ex) {
			String s = ex.getCause().getCause().getMessage();
			int start = s.indexOf("xxx");
			int end = s.lastIndexOf("xxx");
			String errorMSg = "";
			if (start > 0 && end > 3) {
				errorMSg = s.substring(start + 3, end);
				throw new CustomException(HttpStatus.CONFLICT, errorMSg);
			}
		} catch (Exception ex) {
			throw new CustomException(HttpStatus.CONFLICT, ex.getMessage());
		}
		throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
	}

	private void validatePayCommision(Map<String, Object> map, List<PVUCareerAdvanceCurrentDetailsView> objStorePro,
			boolean isViewPage, PVUEmployeDepartmentEntity entity) throws CustomException, ParseException {
		if (!CollectionUtils.isEmpty(objStorePro)) {
			Long payCommission = Long.valueOf(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_PAY_COMM.getValue()).toString());
			LocalDate eventDate = PvuUtils
					.getDateFromStringYMD(map.get(PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getValue()).toString());			
			validatePayCommApplicability(entity.getPvuEmployeEntity().getEmpId(), eventDate, payCommission,
					entity.getDateOfJoiningGOG(), isViewPage);
		}
	}

	/**
	 * Builds the cas employee request map.
	 *
	 * @param curDetailDto the cas employee request
	 * @return the map
	 */
	private Map<String, Object> buildCASEmployeeRequestMap(PVUCareerAdvanceCurDetailDto curDetailDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("IN_PAGE_INDEX", String.valueOf(0));
		map.put("IN_PAGE_SIZE", String.valueOf(250));
		map.put(PvuConstant.IN_EFFECTIVE_DATE, curDetailDto.getEffectiveDate());
		map.put(PvuConstant.IN_EVENT_ID, String.valueOf(0));
		map.put(Constant.IN_EMPLOYEE_NO, curDetailDto.getEmpNo());
		map.put(PvuConstant.IN_OFFICE_ID, OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId());
		map.put(PvuConstant.IN_PAY_COMM, curDetailDto.getPayCommission());
		map.put(PvuConstant.IN_CAS_TYPE, curDetailDto.getAdvSchType());

		return map;
	}

	@Override
	public boolean validateCAS(CASValidationRequest request) {
		List<FieldError> errors = new ArrayList<>();
		if ((!PvuUtils.isTest) && (!CollectionUtils.isEmpty(errors))) {
			ValidationUtil.throwErrors(errors);
		}
		return true;
	}

	public PVUEmployeeEventStatusEntity inProgressAnyEvent(Long employeeId, String trnNo) throws CustomException {
		Optional<PVUEmployeeEventStatusEntity> progress = pvuEmployeeEventStatusService.findByEmpId(employeeId);
		if (progress.isPresent()) {
			if (trnNo.equalsIgnoreCase(progress.get().getTransId())) {
				return progress.get();
			}
			PVUEmployeeEventStatusDto eventStatus = pvuEmployeeEventStatusService.getEventStatus(progress.get());
			if (eventStatus.isInProgress()) {
				throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(MsgConstant.EVENT_IN_PROGRESS,
						eventStatus.getTransId(), eventStatus.getEmployeeCode().toString()));
			}
			return progress.get();
		}
		throw new CustomException(500, "Please select valid employee.");
	}

	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public PVUCareerAdvancementDto insertInITR(PvuWFWrapperDto wrapperDto) throws CustomException {
		Date approvedDate = new Date();
		PVUEmployeeEventStatusEntity statusEntry;
		Optional<PVUCareerAdvancementEntity> optional = repository.findById(wrapperDto.getTrnId());
		PVUCareerAdvancementEntity entity;
		if (optional.isPresent()) {
			entity = optional.get();
			if (entity.getTrnNo() != null) {
				statusEntry = inProgressAnyEvent(entity.getEmployee().getEmpId(), entity.getTrnNo());
			} else {
				statusEntry = pvuEmployeeEventStatusService.inProgressAnyEvent(entity.getEmployee().getEmpId());
			}

			if (entity.getTrnNo() == null) {
				entity.setTrnNo(this.commonService.getTransactionNumber("CA"));
				statusEntry.setCareerAdvancement(Constant.ACTIVE_STATUS);
				entity.setRefDate(LocalDateTime.now());
				repository.save(entity);
				pvuEmployeeEventStatusService.updateEventInfo(statusEntry, entity.getTrnNo());
			}
			EDPLuLookUpInfoEntity empApprovStatsLookupInfo = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.APPROVED);
			PVUCareerAdvancementDto casDto;
			Boolean isReturn = pvuFacade.callWorkFlowApis(wrapperDto);
			if (isReturn.equals(Boolean.TRUE)) {
				casDto = executeWorkflowAction(wrapperDto, approvedDate, entity, empApprovStatsLookupInfo);
				insertITR(wrapperDto);
				return casDto;
			}
			throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);

		} else {
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		}
	}

	@Transactional(rollbackOn = { CustomException.class })
	private PVUCareerAdvancementDto executeWorkflowAction(PvuWFWrapperDto wrapperDto, Date approvedDate,
			PVUCareerAdvancementEntity entity, EDPLuLookUpInfoEntity empApprovStatsLookupInfo) {
		PVUCareerAdvancementDto casDto;
		EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = edpLuLookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.SUBMIT);
		if (empSubmitStatusLookupInfo != null) {
			repository.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate);
		}
		if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVAL_IN_PROGRESS)
				&& empSubmitStatusLookupInfo != null) {
			repository.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
					OAuthUtility.getCurrentUserUserId(), approvedDate);
		}
		casDto = converter.toDTO(entity);
		if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) { // Approved
			updateApprovedStatus(wrapperDto);
		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.PULLED_BACK)) {
			updateForPulledBack(wrapperDto, entity);/* Inactive inward row */
		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) { // Rejected
			updateRejectedStatus(wrapperDto, entity);
		} else if (wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_II)
				|| wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.AUTHORIZE_BY_CLASS_I)) {
			updateAuthorizedClassIAndII(wrapperDto, entity);
		} else if (wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_II)
				|| wrapperDto.getTrnStatus().equalsIgnoreCase(Constant.RETURN_BY_APPROVER_CLASS_I)) {
			updateReturnedClassIAndII(wrapperDto);
			/* Unlock event */
		} else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.FORWARD_TO_PVU)) { // Forward to PVU
			this.insertInwardTable(wrapperDto);
		}
		if (wrapperDto.getAssignByWfRoleId() == Constant.AUDITOR
				|| wrapperDto.getAssignByWfRoleId() == Constant.APPROVER_CLASS_TWO
				|| Objects.equals(wrapperDto.getAssignByWfRoleId(), Constant.APPROVER_CLASS_ONE)) {
			this.insertCareerAdvancementRemarks(wrapperDto.getTrnId());
		}
		return casDto;
	}

	public void insertITR(final PvuWFWrapperDto pvuWFWrapperDto) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("IN_TRN_ID", pvuWFWrapperDto.getTrnId());
		map.put("IN_WORKFLOW_ID", pvuWFWrapperDto.getCurrentWorkflowId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_CAS_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	public void toEntityOfEmpEvent(PVUCareerAdvancementDto casDto, PVUCareerAdvancementEntity entity, String wfStatus) {
		PVUEmployeEventsEntity employeeEventsEntity = new PVUEmployeEventsEntity();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, casDto.getTrnNo());
		map.put(Constant.IN_STATUS_ID, wfStatus);

		PVUEmployeDepartmentEntity department = this.pvuEmployeDepartmentRepository
				.findFirstByPvuEmployeEntityEmpId(casDto.getEmployeeId());
		if (department != null) {
			employeeEventsEntity.setEmployeeClassId(department.getEmpClass().getLookUpInfoId());
			employeeEventsEntity.setDepartmentCategoryId(department.getDepartmentalCategory().getDeptCategoryId());
			employeeEventsEntity.setEmpDesignation(department.getDesignationId().getDesignationId());
		}

		employeeEventsEntity.setTrnNo(casDto.getTrnNo());
		employeeEventsEntity.setEmpBasicPay(casDto.getBasicPay());
		employeeEventsEntity.setEventDate(LocalDateTime.of(casDto.getEventEffectiveDate(), LocalTime.MIN));
		employeeEventsEntity.setEmpOption(0L);
		employeeEventsEntity.setEventDate(LocalDateTime.of(casDto.getEventEffectiveDate(), LocalTime.MIN));
		employeeEventsEntity.setEmpNextIncrDate(LocalDateTime.of(casDto.getDateOfNextIncrement(), LocalTime.MIN));
		employeeEventsEntity.setPayCommission(casDto.getPayCommId());
		employeeEventsEntity.setOfficeId(casDto.getOfficeId());
		employeeEventsEntity.setEventId(PvuConstant.EVENT_ID_STEPPIN_UP);
		employeeEventsEntity.setSourceId(PvuConstant.EVENT_ID_STEPPIN_UP);

		if (casDto.getPayCommId() == PvuConstant.FIFTH_COMMISSION_ID) {
			employeeEventsEntity.setPayScale(casDto.getPayScale());
		}

		if (casDto.getPayCommId() == PvuConstant.SIXTH_COMMISSION_ID) {
			employeeEventsEntity.setEmpPayBand(casDto.getPayBandId());
			employeeEventsEntity.setEmpGrdPay(casDto.getGradePayId());
			employeeEventsEntity.setPayBandValue(casDto.getPayBandValue());
		}
		if (casDto.getPayCommId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			employeeEventsEntity.setCellId(casDto.getCellId());
			employeeEventsEntity.setEmpPaylevel(casDto.getPayLevelId());
		}
		employeeEventsEntity.setEventName(casDto.getEventCode());
		employeeEventsEntity.setEmpId(entity.getEmployee().getEmpId());
		employeeEventsEntity.setActiveStatus(casDto.getActiveStatus());
		employeeEventsEntity.setEmpAutoApprove(LocalDateTime.now());
		pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeeEventsEntity);
	}

	private void reset(Long empId) throws CustomException {
		PVUEmployeeEventStatusEntity employeeStatus = pvuEmployeeEventStatusService.findOneByEmpId(empId);
		employeeStatus.setCareerAdvancement(0);
		employeeStatus.setTransId(null);
		pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(employeeStatus);
	}

	@Override
	public PagebleDTO<PVUCASDDOView> getCASDDOList(PageDetails pageDetail) throws CustomException {
		Map<String, String> collect = this.getDdoWFListingSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(null, pageDetail, collect);
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.CAS_PVU_EVENT_LS_SRCH_WF));
		List<PVUCASDDOView> list = this.callCASPVUDDOListing(sp, stringObjectMap);
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

	private List<PVUCASDDOView> callCASPVUDDOListing(String sp, Map<String, Object> parameters) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(sp, parameters);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUCASDDOView.class)
				: Collections.emptyList();
	}

	@Override
	public PagebleDTO<PVUCASInwardView> getCASInwardList(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMapInwardList(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_INWARD_LIST_WF).toString();
			List<PVUCASInwardView> objStorePro = this.storeProcPvu(procName, map, PVUCASInwardView.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
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
				PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX, PVUSearchEnum.PVU_SEARCH_DDO,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS, PVUSearchEnum.SEARCH_FIELD_IN_POU_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_INW_NO);

	}

	public <T> List<T> storeProcPvu(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
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
	@Override
	public Boolean generateInwardNumber(List<IdDto> dtos) throws CustomException {
		try {
			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
			dtos.forEach(dto -> {
				Map<Integer, Object> map = new HashMap<>();
				map.put(1, Constant.CAS);
				map.put(2, dto.getId());
				parameterMapList.add(map);
			});
			return repository.callStoreProcBatch(
					"{CALL " + Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ST_INWARD_NO_GENERATION_PVU))
							+ "(?,?)}",
					parameterMapList);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Submit cas inward.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean submitCasInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Submit cas distributor.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean submitCasDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
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
		map.put(Constant.IN_EVENT_CODE, PvuConstant.EVENT_CODE_CAREER_ADVANCE);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_COMMON_INWARD_INSERT));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * Insert career advancement remarks.
	 *
	 * @param transId the trans id
	 */
	public void insertCareerAdvancementRemarks(Long transId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		map.put(Constant.IN_EVENT_CODE, PvuConstant.CARRER_ADVANCEMENT_EVENT_ID);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.INSERT_PVU_EVNT_RMKS_ITR); // Need
		repository.callStoredProcedure(procName.toString(), map);
	}

	/**
	 * Delete cas event by id.
	 *
	 * @param trnEventId the trn event id
	 * @return true, if successful
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public boolean deleteCasEventById(IdDto trnEventId) throws CustomException {
		try {
			this.repository.updateActiveStatus(trnEventId.getId(), Constant.INACTIVE_STATUS,
					OAuthUtility.getCurrentUserUserId(), new Date());

		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE_ACTIVESTATUS);

		}
		return Boolean.TRUE;
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
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getCAEmployeeOfficeId(), map);
		if (!Utils.isEmpty(objects)) {
			EDPMsOfficeDto officeDto = new EDPMsOfficeDto();
			officeDto.setOfficeName(String.valueOf(objects.get(0)[0]));
			return officeDto;
		}
		return null;
	}

	/**
	 * Pvu office employee search.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUCareerAdvancementOfficeSearchView> pvuOfficeEmployeeSearch(PageDetails pageDetail)
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
				List<PVUCareerAdvancementOfficeSearchView> list = NativeQueryResultsMapper.map(objStorePro,
						PVUCareerAdvancementOfficeSearchView.class);
				list.forEach(e -> e.setEventCode(PvuConstant.EVENT_CODE_CAREER_ADVANCE));
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), list);
			}
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, 0, Collections.emptyList());
		} catch (Exception ex) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the pvu office search fields.
	 *
	 * @return the pvu office search fields
	 */
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
		map.put(PvuConstant.PVU_EVENT_ID, PvuConstant.CARRER_ADVANCEMENT_EVENT_ID);
		map.put(PvuConstant.CS_PVU_EVENT_ID, id);
		map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
		List<Object[]> objects = remarkRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getCsEventReturnRemarks(),
				map);
		return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PVUEventRemarksDto.class)
				: Collections.emptyList();
	}

	/**
	 * Gets the wf rl cd by CA trn id.
	 *
	 * @param trnId the trn id
	 * @return the wf rl cd by CA trn id
	 */
	@Override
	public String getWfRlCdByCATrnId(Long trnId) {
		return this.wfRepository.findWfRlCdByCATrnId(trnId, Constant.ACTIVE_STATUS);
	}

	/**
	 * Gets the PVU response.
	 *
	 * @param dto the dto
	 * @return the PVU response
	 * @throws CustomException the custom exception
	 */
	@Override
	public Map<String, Object> getPVUResponse(IdDto dto) throws CustomException {
		PVUCareerAdvancementEntity caDto = getCarrearAdvancement(dto.getId());
		if (caDto != null && caDto.getCurrentDetailsEventId() != null) {
			PVUCommonApiDto commonApiDto = this.eventsService.getCommonApiResponse(caDto.getCurrentDetailsEventId());
			PVUCarrierAdvanceCurrentDto currentDetails = converter.toCurrentObj(commonApiDto, caDto);
			PVUCareerAdvancementPostDto postDetails = converter.toPostObj(caDto);
			List<PVUEmployeEventsEntity> entity = pvuEmpEvent
					.findAllByEmpIdAndEventName(caDto.getEmployee().getEmpId(), PvuConstant.EVENT_NAME_CAREER_ADVANCE)
					.stream().filter(distinctByKey(PVUEmployeEventsEntity::getTrnNo)).collect(Collectors.toList());
			if (!CollectionUtils.isEmpty(entity)) {
				for (PVUEmployeEventsEntity eventExist : entity) {
					if (eventExist.getTrnNo() != null && !eventExist.getTrnNo().equals("")) {
						PVUCareerAdvancementEntity entityCA = repository.findOneByTrnNo(eventExist.getTrnNo());
						setScaleDate(caDto, currentDetails, entityCA);
					}
				}

			}
			Map<String, Object> response = new HashMap<>();
			response.put("currentDetails", currentDetails);
			response.put("postDetails", postDetails);
			return response;
		} else {
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		}
	}

	/**
	 * Sets the senior scale.
	 *
	 * @param currentDetails the current details
	 * @param entityCA       the entity CA
	 */
	void setSeniorScale(PVUCarrierAdvanceCurrentDto currentDetails, PVUCareerAdvancementEntity entityCA) {
		if (entityCA.getUniAppLectType() != null) {
			currentDetails.setUniAppLectType(entityCA.getUniAppLectType().getLookUpInfoDescription());
		}
		if (entityCA.getOriCertDate() != null) {
			currentDetails.setOriCertDate(entityCA.getOriCertDate().toString());
		}
		if (entityCA.getEventEffectiveDate() != null) {
			currentDetails.setSsEffDate(entityCA.getEventEffectiveDate().toString());
		}
		if (entityCA.getRefCertDate() != null) {
			currentDetails.setSsrefCertDate(entityCA.getRefCertDate().toString());
		}
	}

	/**
	 * Sets the selection grade.
	 *
	 * @param currentDetails the current details
	 * @param entityCA       the entity CA
	 */
	private void setSelectionGrade(PVUCarrierAdvanceCurrentDto currentDetails, PVUCareerAdvancementEntity entityCA) {
		if (entityCA.getUniAppLectType() != null) {
			currentDetails.setUniAppLectType(entityCA.getUniAppLectType().getLookUpInfoDescription());
		}
		if (entityCA.getOriCertDate() != null) {
			currentDetails.setOriCertDate(entityCA.getOriCertDate().toString());
		}
		if (entityCA.getEventEffectiveDate() != null) {
			currentDetails.setSgEffDate(entityCA.getEventEffectiveDate().toString());
		}
		if (entityCA.getRefCertDate() != null) {
			currentDetails.setSgrefCertDate(entityCA.getRefCertDate().toString());
		}
	}

	/**
	 * Sets the selection grade 3 yrs.
	 *
	 * @param currentDetails the current details
	 * @param entityCA       the entity CA
	 */
	private void setSelectionGrade3Yrs(PVUCarrierAdvanceCurrentDto currentDetails,
			PVUCareerAdvancementEntity entityCA) {
		if (entityCA.getUniAppLectType() != null) {
			currentDetails.setUniAppLectType(entityCA.getUniAppLectType().getLookUpInfoDescription());
		}
		if (entityCA.getOriCertDate() != null) {
			currentDetails.setOriCertDate(entityCA.getOriCertDate().toString());
		}
		if (entityCA.getEventEffectiveDate() != null) {
			currentDetails.setSgEffDate3yr(entityCA.getEventEffectiveDate().toString());
		}
		if (entityCA.getRefCertDate() != null) {
			currentDetails.setSgrefCertDate3yr(entityCA.getRefCertDate().toString());
		}
	}

	/**
	 * Sets the scale date.
	 *
	 * @param caDto          the ca dto
	 * @param currentDetails the current details
	 * @param entityCA       the entity CA
	 */
	private void setScaleDate(PVUCareerAdvancementEntity caDto, PVUCarrierAdvanceCurrentDto currentDetails,
			PVUCareerAdvancementEntity entityCA) {

		if (entityCA.getAdvSchType() != null
				&& entityCA.getAdvSchType().getLookUpInfoId() == PvuConstant.CAS_TYPE_SENIOR_SCALE
				&& entityCA.getAdvSchType().getLookUpInfoId() != caDto.getAdvSchType().getLookUpInfoId()) {
			setSeniorScale(currentDetails, entityCA);

		}

		if (entityCA.getAdvSchType() != null
				&& entityCA.getAdvSchType().getLookUpInfoId() == PvuConstant.CAS_TYPE_SELECTION_GRADE
				&& entityCA.getAdvSchType().getLookUpInfoId() != caDto.getAdvSchType().getLookUpInfoId()) {
			setSelectionGrade(currentDetails, entityCA);
		}

		if (entityCA.getAdvSchType() != null
				&& entityCA.getAdvSchType().getLookUpInfoId() == PvuConstant.CAS_TYPE_SELECTION_GRADE_3YRS
				&& entityCA.getAdvSchType().getLookUpInfoId() != caDto.getAdvSchType().getLookUpInfoId()) {
			setSelectionGrade3Yrs(currentDetails, entityCA);
		}
	}

	/**
	 * Update carrier advancement remarks.
	 *
	 * @param dto the dto
	 * @return the PVU career advancement dto
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUCareerAdvancementDto updateCarrierAdvancementRemarks(PVUSSPRemarkRequest dto) throws CustomException {
		PVUCareerAdvancementEntity entity = converter.setRemarks(getCarrearAdvancement(dto.getId()), dto);
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
				remarkService.deActivateOldReason(dto.getId(), PvuConstant.CARRER_ADVANCEMENT_EVENT_ID);
				List<PVUEventRemarksEntity> remarks = dto.getReturnReasons().stream().map(remarkDto -> {
					PVUEventRemarksEntity remark = new PVUEventRemarksEntity();
					remark.setEventID(PvuConstant.CARRER_ADVANCEMENT_EVENT_ID);
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

	/**
	 * Gets the CA out ward list.
	 *
	 * @param pageDetail the page detail
	 * @return the CA out ward list
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUOutwardView> getCAOutWardList(PageDetails pageDetail) throws CustomException {
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

	/**
	 * Gets the outward pvu search fields.
	 *
	 * @return the outward pvu search fields
	 */
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
	 * Generate out ward number.
	 *
	 * @param dtos the dtos
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean generateOutWardNumber(List<IdDto> dtos) throws CustomException {
		try {

			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
			dtos.forEach(dto -> {
				Map<Integer, Object> map = new HashMap<>();
				map.put(1, Constant.CAS);
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

	/**
	 * Submit CA out ward.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional
	public Boolean submitCAOutWard(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException {
		try {
			wrapperDto.forEach(
					e -> inwardService.setResetOutwardFlag(e.getTrnId(), PvuConstant.CARRER_ADVANCEMENT_EVENT_ID));
			wrapperDto.forEach(e -> inwardService.setConsignmentNumber(e.getTrnId(),
					PvuConstant.CARRER_ADVANCEMENT_EVENT_ID, e.getPostConsignmentNumber()));
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
				map.put(PvuConstant.EVENT_ID, PvuConstant.CARRER_ADVANCEMENT_EVENT_ID);
				map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
				List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getWfTable(), map);
				List<PVUWfTableInfo> tableList = !Utils.isEmpty(objects)
						? NativeQueryResultsMapper.map(objects, PVUWfTableInfo.class)
						: Collections.emptyList();
				tableInfo = CollectionUtils.isEmpty(tableList) ? null : tableList.get(0);
			}
			List<PvuWFWrapperDto> returnList = new ArrayList<>();
			if (tableInfo != null) {
				return updateOutward(list, tableInfo, returnList);
			}
			authorize(wrapperDto, authList);
			return true;
		} catch (Exception e) {

			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Update outward.
	 *
	 * @param list       the list
	 * @param tableInfo  the table info
	 * @param returnList the return list
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Transactional(rollbackOn = { CustomException.class })
	public Boolean updateOutward(List<PvuWFOutWardWrapperDto> list, PVUWfTableInfo tableInfo,
			List<PvuWFWrapperDto> returnList) throws CustomException {
		for (PvuWFOutWardWrapperDto dto : list) {
			Map<String, Object> map = new HashMap<>();
			map.put(PvuConstant.TRN_ID, dto.getTrnId());
			List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant
					.getWfSourceUserDetail(tableInfo.getSchemaName(), tableInfo.getTableName()), map);
			List<PVUSourceUserDetails> users = !Utils.isEmpty(objects)
					? NativeQueryResultsMapper.map(objects, PVUSourceUserDetails.class)
					: Collections.emptyList();
			PVUSourceUserDetails user = null;
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
		return pvuFacade.callWorkFlowApis(returnList);
	}

	/**
	 * Authorize.
	 *
	 * @param wrapperDto the wrapper dto
	 * @param authList   the auth list
	 * @throws CustomException the custom exception
	 */
	private void authorize(List<PvuWFOutWardWrapperDto> wrapperDto, List<PvuWFOutWardWrapperDto> authList)
			throws CustomException {
		if (!authList.isEmpty()) {
			wrapperDto.forEach(e -> authorizeSPP(e.getTrnId()));
			wrapperDto.forEach(e -> authorizeBackdateSP(e.getTrnId()));
			authList.forEach(e -> e.setWfStatus(PvuConstant.AUTHORIZED));
			pvuFacade.callWorkFlowApis(PvuWFOutWardWrapperDto.createSuper(authList));
			for (PvuWFOutWardWrapperDto e : authList) {
				reset(repository.getEmpId(e.getTrnId()));
			}

		}
	}

	/**
	 * Authorize SPP.
	 *
	 * @param trnId the trn id
	 */
	public void authorizeSPP(Long trnId) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnId);
		map.put(Constant.IN_EVENT_CODE, PvuConstant.EVENT_CODE_CAREER_ADVANCE);
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.PVU_COMMON_AUTHORIZED_SP, map);
	}

	public void authorizeBackdateSP(Long trnId) {
		String trnNo = repository.getTrnNo(trnId);
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		map.put(Constant.IN_EVNT_CODE, PvuConstant.EVENT_CODE_CAREER_ADVANCE);
		repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map);
	}

	/**
	 * Gets the CA print endorsement list.
	 *
	 * @param pageDetail the page detail
	 * @return the CA print endorsement list
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUPrintEndorsementView> getCAPrintEndorsementList(PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail,
				this.getPrintPrintEndorsementSearchFields().stream()
						.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue)));
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF).toString();
		List<PVUPrintEndorsementView> objStorePro = this.storeProcPvu(procName, map, PVUPrintEndorsementView.class);
		objStorePro.forEach(e -> e.setEventCode(PvuConstant.EVENT_CODE_CAREER_ADVANCE));
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, objStorePro.size(), objStorePro);
	}

	/**
	 * Gets the prints the print endorsement search fields.
	 *
	 * @return the prints the print endorsement search fields
	 */
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
	 * Generate print endorsement.
	 *
	 * @param dto the dto
	 * @return the string
	 * @throws CustomException   the custom exception
	 * @throws IOException       Signals that an I/O exception has occurred.
	 * @throws DocumentException the document exception
	 */
	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public String generatePrintEndorsement(PvuPrintStickerReportDto dto)
			throws CustomException, IOException, DocumentException, ParseException {
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

	private StringWriter generateCASPayPdf(PvuPrintStickerReportDto dto) throws CustomException {
		PVUStickerDTO stickerDTO = null;
		try {
			stickerDTO = submitPrintHistory(dto);
			PVUCareerAdvancementEntity entity = repository.getOne(dto.getStickerDTO().getId());
			PVUCommonApiDto common = this.eventsService.getCommonApiResponse(entity.getCurrentDetailsEventId());
			PVUCASPrintDto print = printRepository.getPrintDateReprintDatePrintCountData(entity.getId(),
					PvuConstant.CARRER_ADVANCEMENT_EVENT_ID, Constant.ACTIVE_STATUS);
			print = converter.print(entity, print, common);
			print.setDesignation(common.getDesignationName());
			if (!Utils.isEmpty(stickerDTO.getRePrintRemark())) {
				print.setRePrintRemark(stickerDTO.getRePrintRemark());
			} else {
				print.setRePrintRemark("");
			}
			if (common.getDateJoining() != null && entity.getEventEffectiveDate() != null) {
				LocalDate dtOfJoining = LocalDate.parse(common.getDateJoining());
				print.setYears(Utils.noOfyears(dtOfJoining, entity.getEventEffectiveDate()));
			}
			print.setAuthorizedBy(authService.getOnlyIdAndName(entity.getAuthorizeBy()).getName());
			VelocityContext context = new VelocityContext();
			context.put("data", print);
			StringWriter writer = new StringWriter();
			Template template = getPrintTemplateforPVU(entity);
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
			document.addTitle("Senior Scale");
			document.setPageSize(PageSize.LETTER);
			PdfWriter pdfWriter = PdfWriter.getInstance(document, baos);
			document.open();
			for (PvuPrintStickerReportDto printStickerReportDto : dto) {
				PVUCareerAdvancementEntity entity = repository.getOne(printStickerReportDto.getStickerDTO().getId());
				if (entity.getOfficeId().getOfficeId().equals(entity.getOfficeId().getPvuId())
						&& entity.getOfficeId().getOfficeId() != Constant.PVU_OFFICE_ID) {
					watermark = ", Self PVU";
				} else {
					watermark = ", PVU, Gandhinagar";
				}
				pdfWriter.setPageEvent(
						new WatermarkPageEvent(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()), watermark));
				writer.write(generateCASPayPdf(printStickerReportDto).toString());
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
			return sb.toString();// call this method for node js API for
			// html with watermark
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	public Template getPrintTemplateforPVU(PVUCareerAdvancementEntity entity) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template t = new Template();
		if (!Utils.isEmpty(entity.getPayCommId())) {
			if (entity.getPayCommId().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
				t = ve.getTemplate("/templates/careerAdvancement/CAS_7thPay.vm");
			} else if (entity.getPayCommId().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
				t = ve.getTemplate("/templates/careerAdvancement/CAS_6thPay.vm");
			} else if (entity.getPayCommId().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
				t = ve.getTemplate("/templates/careerAdvancement/CAS_5thPay.vm");
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
						PvuConstant.CARRER_ADVANCEMENT_EVENT_ID, Constant.ACTIVE_STATUS);
				if (printEntity == null) {
					inwardService.setOutwardFlag(dto.getPvuWFWrapperDto().getTrnId(),
							PvuConstant.CARRER_ADVANCEMENT_EVENT_ID);
					printEntity = new PVUPrintEndorsementEntity();
					printEntity.setTrnId(printDto.getTrnId());
					printEntity.setEventId(PvuConstant.CARRER_ADVANCEMENT_EVENT_ID);
					printEntity.setPrintDate(new Date());
					printEntity.setPrintCnt(1L);
					pvuFacade.callWorkFlowApis(dto.getPvuWFWrapperDto());
				} else {
					printEntity.setId(printEntity.getId());
					printEntity.setPrintCnt((printEntity.getPrintCnt() + 1L));
					printEntity.setReprintDate(new Date());
					printEntity.setEventId(PvuConstant.CARRER_ADVANCEMENT_EVENT_ID);
					printEntity.setRemark(printDto.getRemark());
				}
				printEntity = printRepository.save(printEntity);
				printITRRepo.save(printEndorsementItrConverter.toEntity(printEntity));
			}
		} catch (Exception e) {
			logger.info(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return printEntity != null ? converter.toPrintEndorsementDto(printEntity) : null;
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

	@Override
	@Transactional(rollbackOn = { CustomException.class })
	public List<PrintEndorsementRemarkHistoryDto> getReprintEndorsementRemarks(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.TRN_ID, id);
		map.put(PvuConstant.EVENT_ID, PvuConstant.CARRER_ADVANCEMENT_EVENT_ID);
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPVUEventEndorsementHistory(),
				map);
		return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PrintEndorsementRemarkHistoryDto.class)
				: Collections.emptyList();
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
	private void validatePayCommApplicability(Long empId, LocalDate eventDate, Long payCommId, Date doj,
			Boolean isViewPage) throws CustomException, ParseException {
		if (Boolean.FALSE.equals(isViewPage))
			empPayDetailService.validatePayCommision(empId, Utils.convertToDate(eventDate), payCommId, doj);
	}

	/**
	 * Update for pulled back.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @param pvuEntity       the pvu cs event entity
	 */
	private void updateForPulledBack(PvuWFWrapperDto pvuWFWrapperDto, PVUCareerAdvancementEntity pvuEntity) {
		inwardService.updateStatusId(Constant.INACTIVE_STATUS, pvuEntity.getId(), new Date(),
				pvuWFWrapperDto.getEventId());
	}

	/**
	 * Update rejected status.
	 *
	 * @param wrapperDto the wrapper dto
	 * @param entity     the entity
	 */
	private void updateRejectedStatus(PvuWFWrapperDto wrapperDto, PVUCareerAdvancementEntity entity) {
		/* Update Reject Status for Any User Rejected */
		EDPLuLookUpInfoEntity rejectedStatus = lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.REJECTED);
		repository.updateStatusId(rejectedStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date());
		/* Unlock event */
		pvuEmployeeEventStatusService.resetInProgressEmployeeEventStatus(entity.getEmployee().getEmpId(),
				OAuthUtility.getCurrentUserLkPOUId());
	}

	/**
	 * Update approved status.
	 *
	 * @param wrapperDto the wrapper dto
	 */
	private void updateApprovedStatus(PvuWFWrapperDto wrapperDto) {
		EDPLuLookUpInfoEntity printEnable = lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.CONDITION_CHECK,
						Constant.ACTIVE_STATUS, Constant.LOOKUP_YES);
		EDPLuLookUpInfoEntity approve = lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.APPROVED);
		repository.updatePrintStatusAndApproveDate(approve.getLookUpInfoId(), Constant.ACTIVE_STATUS,
				wrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), new Date(), printEnable.getLookUpInfoId(),
				LocalDateTime.now());
	}

	/**
	 * Update authorized class I and II.
	 *
	 * @param wrapperDto the wrapper dto
	 * @param entity     the entity
	 */
	private void updateAuthorizedClassIAndII(PvuWFWrapperDto wrapperDto, PVUCareerAdvancementEntity entity) {

		/* Update Status ApproverClass II Or I Authorization */
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
		inwardService.setAuthDate(wrapperDto.getTrnId(), PvuConstant.CARRER_ADVANCEMENT_EVENT_ID, LocalDateTime.now());
	}

	/**
	 * Update returned class I and II.
	 *
	 * @param wrapperDto the wrapper dto
	 */
	private void updateReturnedClassIAndII(PvuWFWrapperDto wrapperDto) {
		EDPLuLookUpInfoEntity authorizationStatus = lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.RECOMMENDATION_FOR,
						Constant.ACTIVE_STATUS, Constant.RETURN);
		repository.updateStatusId(authorizationStatus.getLookUpInfoId(), wrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date());
		inwardService.setReturnDate(wrapperDto.getTrnId(), PvuConstant.CARRER_ADVANCEMENT_EVENT_ID,
				LocalDateTime.now());

	}
}
