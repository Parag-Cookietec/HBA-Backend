package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUPromotionConverter;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.dto.PVUPromotionDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.request.PromotionValidationRequest;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUEmployeCCCExamDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeLangExamEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUPromotionEntity;
import gov.ifms.pvu.repository.PVUEmployeCCCExamDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeLangExamRepository;
import gov.ifms.pvu.repository.PVUPromotionRepository;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.service.PVUPromotionServiceImpl;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuMsgConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.wrapper.PVYFacade;

class PVUPromotionServiceImplTest {
	@InjectMocks
	private PVUPromotionServiceImpl service;

	@Mock
	private PVUPromotionRepository repository;

	@Mock
	private PVUPromotionEntity entity;

	@Mock
	private PVUPromotionDto dto;

	@Mock
	private PromotionValidationRequest validationRequest;

	@Mock
	private PVUEmployeCCCExamDetailRepository cccExamRepo;

	@Mock
	private PVUEmployeLangExamRepository langRepository;

	@Mock
	private EDPLuLookUpInfoEntity langName1;

	@Mock
	private EDPLuLookUpInfoEntity langName2;

	@Mock
	private PVUEmployeLangExamEntity langExam1;

	@Mock
	private PVUEmployeCCCExamDetailEntity cccExam1;

	@Mock
	private PVUEmployeCCCExamDetailEntity cccExam2;

	@Mock
	private List<PVUEmployeCCCExamDetailEntity> cccExams;

	@Mock
	private PVUCommonApiDto apiDto;

	@Mock
	private PVUPromotionConverter converter;

	@Mock
	Page<PVUPromotionEntity> page;

	@Mock
	List<PVUPromotionEntity> lst;

	@Mock
	List<PVUPromotionDto> promotionList;

	@Mock
	private PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity;

	@Mock
	PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto;

	@Mock
	private EDPLuLookUpInfoRepository edpRepository;

	@Mock
	private EDPLuLookUpInfoEntity luEntity;

	@Mock
	private PVUCommonService pvuCommonService;

	@Mock
	List<PVUMsGradePayEntity> masterGradePayEntityList;

	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;

	@Mock
	private EDPLuLookUpInfoEntity lu;

	@Mock
	private PVUEmployeEventsEntity employeEventsEntity;

	@Mock
	private PVUEmployeEventsService pvuEmployeEventsService;

	@Mock
	private PVUEmployeEntity pvuEmployeEntity;

	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Mock
	private PVYFacade pvuFacade;

	//@Mock
	//private List<PVUEmployeLangExamEntity> list;

	@Mock
	private List<PVUEmployeCCCExamDetailEntity> cccExam;

	@Mock
	private MsgConstant pvuMsgConstant;
	
	@BeforeAll
	public static void before() {
		PvuUtils.isTest = Boolean.TRUE;
	}

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetPVUPromotion() {
		when(repository.findOneById(1L)).thenReturn(entity);
		assertNotNull(service.getPVUPromotion(1L));
	}

	@Test
	void testSaveOrUpdatePVUPromotion() throws CustomException {
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		when(converter.toEntity(dto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(pvuEmployeeEventStatusService.getEventStatus(pvuEmployeeEventStatusEntity))
				.thenReturn(pvuEmployeeEventStatusDto);
		when(pvuCommonService.getTransactionNumber("PRFG")).thenReturn("PRFG");
		when(dto.isNew()).thenReturn(true);
		when(edpRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(dto.getEmployeeId()).thenReturn(1L);
		when(pvuEmployeeEventStatusService.findByEmpId(1L)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(dto.getStatusId()).thenReturn(0L);
		when(dto.getEmployeeId()).thenReturn(2L);
		when(pvuEmployeeEventStatusService.inProgressAnyEvent(2L)).thenReturn(pvuEmployeeEventStatusEntity);
		when(entity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeeEventStatusService.inProgressSuspensionEvent(pvuEmployeEntity.getEmpId()))
				.thenReturn(pvuEmployeeEventStatusEntity);
		assertEquals(dto, service.saveOrUpdatePVUPromotion(dto));
		verify(repository, times(1)).save(entity);

		when(dto.isNew()).thenReturn(false);
		when(dto.isSame()).thenReturn(false);
		when(dto.getEmployeeId()).thenReturn(1L);
		when(dto.getId()).thenReturn(1L);
		when(repository.getOne(1L)).thenReturn(entity);
		when(entity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1L);

		when(pvuEmployeeEventStatusService.findOneByEmpId(1L)).thenReturn(pvuEmployeeEventStatusEntity);
		pvuEmployeeEventStatusEntity.setPromotion(0);
		pvuEmployeeEventStatusEntity.setTransId(null);
		when(pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity))
				.thenReturn(pvuEmployeeEventStatusEntity);
		when(pvuEmployeeEventStatusService.inProgressAnyEvent(1L)).thenReturn(pvuEmployeeEventStatusEntity);
		assertEquals(dto, service.saveOrUpdatePVUPromotion(dto));

		when(dto.isNew()).thenReturn(false);
		when(dto.getTrnNo()).thenReturn(null);
		when(dto.isSame()).thenReturn(true);
		when(dto.getEmployeeId()).thenReturn(1L);
		when(converter.toEntity(dto)).thenReturn(entity);
		when(dto.getEmployeeNo()).thenReturn(10000000L);
		when(repository.save(entity)).thenReturn(entity);
		when(pvuEmployeeEventStatusService.getEventStatus(pvuEmployeeEventStatusEntity))
				.thenReturn(pvuEmployeeEventStatusDto);
		when(pvuEmployeeEventStatusService.findByEmpId(1L)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(converter.toDTO(entity)).thenReturn(dto);
		assertEquals(dto, service.saveOrUpdatePVUPromotion(dto));

		when(repository.findById(1L)).thenReturn(Optional.empty());
		assertEquals(dto, service.saveOrUpdatePVUPromotion(dto));

	}

	@Test
	void testGetAllLuLookUpInfoAsMap() throws CustomException {
		assertNotNull(service.getAllLuLookUpInfoAsMap());
	}

	@Test
	void testInsertInITR() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1L);
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Approved")).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(2L);
		when(entity.getStatus()).thenReturn(lu);
		when(lu.getLookUpInfoId()).thenReturn(1L);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Approved");
		when(dto.getEmployeeId()).thenReturn(1L);
		when(dto.getEventOrderDate()).thenReturn(LocalDate.now());
		when(dto.getTrnNo()).thenReturn("2020");
		when(dto.getEventCode()).thenReturn("Forgo");
		when(dto.getDateOfNextIncrement()).thenReturn(LocalDate.now());
		when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1, "Submit"))
				.thenReturn(luEntity);
		when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(entity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1L);
		when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
				PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME)).thenReturn(luEntity);
		when(dto.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(dto.getDateOfNextIncrement()).thenReturn(LocalDate.now());
		when(dto.getPayCommId()).thenReturn(150L);
		when(pvuEmployeeEventStatusService.findByEmpId(1L)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(pvuEmployeeEventStatusService.findOneByEmpId(1L)).thenReturn(pvuEmployeeEventStatusEntity);
		assertNotNull(service.insertInITR(pvuWFWrapperDto));

		when(dto.getPayCommId()).thenReturn(151L);
		assertNotNull(service.insertInITR(pvuWFWrapperDto));

		when(dto.getPayCommId()).thenReturn(152L);
		assertNotNull(service.insertInITR(pvuWFWrapperDto));

		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Rejected");
		when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Rejected")).thenReturn(luEntity);
		assertNotNull(service.insertInITR(pvuWFWrapperDto));
	}

	@Test
	void testGetPVUPromotionsEx() {
		List<SearchParam> jsonArr = new ArrayList<>();
		jsonArr.add(new SearchParam("isSearch", "1"));
		jsonArr.add(new SearchParam("empNo", "1"));
		jsonArr.add(new SearchParam("empName", "V"));
		jsonArr.add(new SearchParam("caseNo", " "));
		jsonArr.add(new SearchParam("startDate", ""));
		jsonArr.add(new SearchParam("endDate", ""));
		jsonArr.add(new SearchParam("officeId", "0"));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("transNo", " "));
		jsonArr.add(new SearchParam("workflowId", "0"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		when(repository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(lst);
		when(converter.toDTO(lst)).thenReturn(promotionList);
//        PagebleDTO<PVUPromotionDto> data = service.getPVUPromotions(pageDetail);
//        assertNotNull(data);
	}

	@Test
	void testSetComparerDetails() throws CustomException {
		when(dto.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(this.pvuCommonService.getCommonDetailsBasedOnEventDate(Mockito.anyMap())).thenReturn(apiDto);
		when(apiDto.getClassId()).thenReturn(1L);
		when(apiDto.getDesignationId()).thenReturn(1L);
		when(apiDto.getEmpBasicPay()).thenReturn(1L);
		when(apiDto.getPayCommId()).thenReturn(150L);
		when(apiDto.getPayScale()).thenReturn(1L);
		service.setComparerDetails(dto);

		when(apiDto.getPayCommId()).thenReturn(151L);
		when(apiDto.getPayBandValue()).thenReturn(1L);
		when(apiDto.getGradePayId()).thenReturn(1L);
		when(apiDto.getPayBandId()).thenReturn(1L);
		service.setComparerDetails(dto);

		when(apiDto.getPayCommId()).thenReturn(152L);
		when(apiDto.getPayLevelId()).thenReturn(1L);
		when(apiDto.getCellId()).thenReturn(1L);
		service.setComparerDetails(dto);
	}

	@Test
	void testValidatePromotion() throws CustomException {
		CustomException customException = assertThrows(CustomException.class, () -> {
			when(validationRequest.getEmployeeId()).thenReturn(1L);
			when(validationRequest.getEffectiveDate()).thenReturn(LocalDate.now());
			when(validationRequest.getEmployeeClassId()).thenReturn(162L);
			when(pvuEmployeEventsService.existsFromTo(1L, PvuConstant.EVENT_CODE_FORGO,
					PvuUtils.startDay(LocalDate.now().minusYears(1L)), PvuUtils.endDay(LocalDate.now())))
							.thenReturn(false);
			when(validationRequest.getEmployeeId()).thenReturn(1L);

			// when(langName2.getLookUpInfoId()).thenReturn(145L);
			when(langExam1.getLangName()).thenReturn(langName1);
			when(langName1.getLookUpInfoId()).thenReturn(144L);
			// when(langExam1.getLangName()).thenReturn(langName2);
			List<PVUEmployeLangExamEntity> list1 = new ArrayList<>();
			list1.add(langExam1);
			// when(langExam1.getLangName()).thenReturn(null);
			when(langRepository.findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(1L,
					Constant.ACTIVE_STATUS)).thenReturn(list1);

			// when(list1.size()).thenReturn(2);

			service.validatePromotion(validationRequest);

			// 2
			when(cccExam1.getExamStatus()).thenReturn(langName1);
			when(langName1.getLookUpInfoId()).thenReturn(10L);
			when(langRepository.findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(1L,
					Constant.ACTIVE_STATUS)).thenReturn(list1);
			// when(list1.size()).thenReturn(0);
			// List<PVUEmployeCCCExamDetailEntity> list1 = Arrays.asList(cccExam1,
			// cccExam2);
			when(cccExamRepo
					.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(162L,
							Constant.ACTIVE_STATUS)
					.stream()
					.filter(e -> null != e.getCccExamName()
							&& (e.getExamStatus().getLookUpInfoId() == PvuConstant.EXAM_PASS
									|| e.getExamStatus().getLookUpInfoId() == PvuConstant.EXAM_EXEMPT))
					.collect(Collectors.toList())).thenReturn(cccExam);

			service.validatePromotion(validationRequest);

			// 3
			when(luEntity.getLookUpInfoId()).thenReturn(144L);
			when(langExam1.getLangName()).thenReturn(luEntity);

			when(langRepository.findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(1L,
					Constant.ACTIVE_STATUS)).thenReturn(list1);

			// when(list1.size()).thenReturn(1);
			service.validatePromotion(validationRequest);

		});
		assertTrue(customException.getErrorMsg().contains(PvuMsgConstant.ERROR_MSG_EXAM_MANDATORY));
	}

	@Test
	void testValidatePromotionException() {
		CustomException customException = assertThrows(CustomException.class, () -> {
			when(validationRequest.getEmployeeId()).thenReturn(1L);
			when(validationRequest.getEffectiveDate()).thenReturn(LocalDate.now());
			when(validationRequest.getEmployeeClassId()).thenReturn(162L);
			when(pvuEmployeEventsService.existsFromTo(1L, PvuConstant.EVENT_CODE_FORGO,
					PvuUtils.startDay(LocalDate.now().minusYears(1L)), PvuUtils.endDay(LocalDate.now())))
							.thenReturn(true);
			service.validatePromotion(validationRequest);
		});
		assertTrue(customException.getErrorMsg().contains("This employee has forgo in last one year!"));
	}

	@Test
	void testValidatePromotionClassWiseExam() throws CustomException {
		when(validationRequest.getEmployeeId()).thenReturn(162L);
		when(validationRequest.getEffectiveDate()).thenReturn(LocalDate.now());
		when(validationRequest.getEmployeeClassId()).thenReturn(162L);
		when(pvuEmployeEventsService.existsFromTo(1L, PvuConstant.EVENT_CODE_FORGO,
				PvuUtils.startDay(LocalDate.now().minusYears(1L)), PvuUtils.endDay(LocalDate.now()))).thenReturn(true);

		when(langName1.getLookUpInfoId()).thenReturn(142L);
		when(langName2.getLookUpInfoId()).thenReturn(143L);
		when(cccExam1.getStatusId()).thenReturn(langName1);
		when(cccExam2.getStatusId()).thenReturn(langName2);

		when(langName1.getLookUpInfoId()).thenReturn(142L);
		when(langName2.getLookUpInfoId()).thenReturn(143L);
		when(cccExam1.getCccExamName()).thenReturn(langName1);
		when(cccExam2.getCccExamName()).thenReturn(langName2);

		List<PVUEmployeCCCExamDetailEntity> list = Arrays.asList(cccExam1, cccExam2);

		when(cccExamRepo.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(162L,
				Constant.ACTIVE_STATUS)).thenReturn(list);
		when(cccExams.size()).thenReturn(2);
		// TODO Fix Test issue.
//        service.validatePromotion(validationRequest);

		when(langName1.getLookUpInfoId()).thenReturn(142L);
		when(langName2.getLookUpInfoId()).thenReturn(143L);
		when(cccExam1.getStatusId()).thenReturn(langName1);
		when(cccExam2.getStatusId()).thenReturn(langName2);

		when(langName1.getLookUpInfoId()).thenReturn(1L);
		when(langName2.getLookUpInfoId()).thenReturn(1L);
		when(cccExam1.getCccExamName()).thenReturn(langName1);
		when(cccExam2.getCccExamName()).thenReturn(langName2);

		when(cccExamRepo.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(162L,
				Constant.ACTIVE_STATUS)).thenReturn(list);

		when(cccExams.size()).thenReturn(0);
//        service.validatePromotion(validationRequest);
	}

	@Test
	void testValidatePromotionClassWiseExamClass3AndClass4() throws CustomException {
		when(validationRequest.getEmployeeId()).thenReturn(165L);
		when(validationRequest.getEffectiveDate()).thenReturn(LocalDate.now());
		when(validationRequest.getEmployeeClassId()).thenReturn(165L);
		when(pvuEmployeEventsService.existsFromTo(1L, PvuConstant.EVENT_CODE_FORGO,
				PvuUtils.startDay(LocalDate.now().minusYears(1L)), PvuUtils.endDay(LocalDate.now()))).thenReturn(true);

		when(langName1.getLookUpInfoId()).thenReturn(140L);
		when(langName2.getLookUpInfoId()).thenReturn(141L);

		when(cccExam1.getStatusId()).thenReturn(langName1);
		when(cccExam2.getStatusId()).thenReturn(langName2);

		when(langName1.getLookUpInfoId()).thenReturn(142L);
		when(langName2.getLookUpInfoId()).thenReturn(143L);
		when(cccExam1.getCccExamName()).thenReturn(langName1);
		when(cccExam2.getCccExamName()).thenReturn(langName2);

		List<PVUEmployeCCCExamDetailEntity> list = Arrays.asList(cccExam1, cccExam2);

		when(cccExamRepo.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(165L,
				Constant.ACTIVE_STATUS)).thenReturn(list);
		// TODO Fix Test issue.
//        when(cccExams.size()).thenReturn(2);
//        service.validatePromotion(validationRequest);

		when(validationRequest.getEmployeeClassId()).thenReturn(164L);
//        service.validatePromotion(validationRequest);
	}

	@Test
	void testValidatePromotionClassWiseExamClass3AndClass4Else() throws CustomException {
		CustomException customException = assertThrows(CustomException.class, () -> {
		when(validationRequest.getEmployeeId()).thenReturn(164L);
		when(validationRequest.getEffectiveDate()).thenReturn(LocalDate.now());
		when(validationRequest.getEmployeeClassId()).thenReturn(164L);
		when(pvuEmployeEventsService.existsFromTo(1L, PvuConstant.EVENT_CODE_FORGO,
				PvuUtils.startDay(LocalDate.now().minusYears(1L)), PvuUtils.endDay(LocalDate.now()))).thenReturn(true);

		when(cccExam1.getStatusId()).thenReturn(langName1);
		when(cccExam2.getStatusId()).thenReturn(langName2);

		when(langName1.getLookUpInfoId()).thenReturn(1L);
		when(langName2.getLookUpInfoId()).thenReturn(1L);
		when(cccExam1.getCccExamName()).thenReturn(langName1);
		when(cccExam2.getCccExamName()).thenReturn(langName2);

		List<PVUEmployeCCCExamDetailEntity> list = Arrays.asList(cccExam1, cccExam2);
		// TODO Fix Test issue.
//        when(cccExamRepo.
//                findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(164L, Constant.ACTIVE_STATUS))
//                .thenReturn(list);
		when(cccExams.size()).thenReturn(2);
		service.validatePromotion(validationRequest);
		});
		
		assertTrue(customException.getErrorMsg().contains(PvuMsgConstant.ERROR_MSG_EXAM_MANDATORY));
	}
}
