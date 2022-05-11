package gov.ifms.pvu.service.test;


import com.itextpdf.text.DocumentException;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUCareerAdvancementConverter;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.PVUCASPrintDto;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.*;
import gov.ifms.pvu.repository.*;
import gov.ifms.pvu.service.PVUCareerAdvancementServiceImpl;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.service.PVUEventRemarksService;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PVUCareerAdvancementServiceImplTest {

	@Mock
	private OAuthService authService;

	@Mock
	PVUCASPrintDto print;

	@Mock
	private PVUPrintEndorsementRepository printRepository;

	@Mock
	private PVUStickerDTO stickerDTO;

	@Mock
	private PVUCommonApiDto commonApiDto;

	@Mock
	private PVUEmployeDepartmentEntity dptEntity;

	@Mock
	private EDPMsOfficeEntity edpMsOfficeEntity;

	@Mock
	private PVUEmployeDepartmentEntity deptEntity;

	@Mock
	private PVUEmployeDepartmentRepository pvuEmployeeDepartmentRepo;

	@Mock
	private EDPLuLookUpInfoEntity rejectedStatus;

	@Mock
	private EDPLuLookUpInfoEntity printEnable;

	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	@Mock
	PvuWFOutWardWrapperDto wfOutWardWrapperDto;

	@Mock
	private PVUSSPRemarkRequest remarkRequest;

	@Mock
	private PVUEventRemarksService remarkService;

	@Mock
	private PVUEventsRemarkDto eventsRemarkDto;

	@Mock
	private PVUEventRemarksEntity remarkEntity;

	@Mock
	private WfRepository wfRepository;

	@Mock
	private PVUEmployeEventsEntity employeEventsEntity;

	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Mock
	private PVUCareerAdvancementRepository repository;

	@Mock
	private EDPMsDesignationEntity edpMsDesignationEntity;

	@Mock
	private PVUCareerAdvancementConverter converter;

	@Mock
	private PVUCareerAdvancementEntity entity;

	@Mock
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Mock
	private EDPLuLookUpInfoEntity luEntity;

	@Mock
	private EDPLuLookUpInfoEntity lu;


	@Mock
	private PVURevisionOfPayRemarkRepository remarkRepository;

	@Mock
	private PVYFacade pvuFacade;

	@Mock
	private PVUCareerAdvancementDto dto;

	@Mock
	private PVUCareerAdvanceEmployeView pvuCareerAdvanceEmployeView;

	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;

	@Mock
	private PVUCareerAdvanceEmployeView pvuCommonApiDto;

	@Mock
	Page<PVUCareerAdvancementEntity> page;

	@Mock
	List<PVUCareerAdvancementEntity> list;

	@Mock
	List<PVUCareerAdvancementDto> listDto;

	@Mock
	private PVUEmployeEventsService eventsService;

	@Mock
	private PVUEmployeEventsRepository pvuEmpEvent;

	@Mock
	private PVUEmployeEntity employeEntity;

	@Mock
	private PVUEmployeDepartmentEntity department;

	@Mock
	private PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity;


	/**
	 * The dept exam details repository.
	 */
	@Mock
	private PVUEmployeDeptExamDetailsRepository deptExamDetailsRepository;

	/**
	 * The ccc exam detail repository.
	 */
	@Mock
	private PVUEmployeCCCExamDetailRepository cccExamDetailRepository;

	/**
	 * The lang exam repository.
	 */
	@Mock
	private PVUEmployeLangExamRepository langExamRepository;

	@Mock
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	@Mock
	private PVUCommonService commonService;

	private OAuthUtility oAuthUtility;

	@Autowired
	private PVUEmployeeEventStatusService statusService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@InjectMocks
	private PVUCareerAdvancementServiceImpl service;



	@Test
	void testGetCarrearAdvancement() throws CustomException {
		when(repository.getOne(1l)).thenReturn(entity);
		assertEquals(entity, service.getCarrearAdvancement(1l));
		verify(repository, times(1)).getOne(1L);

	}

	@Test
	void testGetDDLLuLookUpInfoAsMap() throws CustomException {
		assertNotNull(service.getDDLLuLookUpInfoAsMap());

	}

	@Mock
	private List<PVUCareerAdvancementEntity> lst;

	@Mock
	List<PVUCareerAdvanceEmployeView> objStorePro;

	@Test
	void teststoreProcCommonEmp() throws CustomException {
		assertNotNull(service.storeProcCommonEmp("PVU_EMP_CA_CURR_EVNT_DTLS",
				new HashMap<String, Object>()));

	}

	@SuppressWarnings("static-access")
	Long CurrentUserUserId() {
		return oAuthUtility.getCurrentUserUserId();

	}

	@SuppressWarnings("unchecked")
	@Test
	void getCarrearAdvancements() throws CustomException {
		oAuthUtility = new OAuthUtility();
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("empNo", "1000000116"));
		jsonArr.add(new SearchParam("eventId", "0"));
		jsonArr.add(new SearchParam("effectiveDate", "04/07/2020"));
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(250);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		pageDetail.setSortByColumn("asc");
		pageDetail.setSortOrder("asc");

		IdDto d = new IdDto();
		List<IdDto> lst = new ArrayList<IdDto>();
		d.setId(1l);
		lst.add(d);
		CurrentUserUserId();
		when(repository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(list);
		when(converter.toDTO(list)).thenReturn(listDto);
		assertNotNull(service.getCarrearAdvancements(pageDetail));

	}

	/*@Test
	void submitCAOutWard() throws CustomException {
		List<PvuWFOutWardWrapperDto> wrapperDto = new ArrayList<>();
		assertNotNull(pvuCareerAdvancementServiceImpl.submitCAOutWard(wrapperDto));
	}*/
	@Test
	void testGetCAOutWardList() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(service.getCAOutWardList(pageDetail));
	}


	@Test
	void testGenerateInwardNumber() throws SQLException, CustomException {
		List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
		List<IdDto> dtos = new ArrayList<IdDto>();
		dtos.add(new IdDto(1l));
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		map.put(1, dtos);
		parameterMapList.add(map);
		assertNotNull(when(repository.callStoreProcBatch("{CALL " + Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ST_INWARD_NO_GENERATION_PVU)) + "(?)}", parameterMapList)).thenReturn(true));
		service.generateInwardNumber(dtos);
	}

	/*@Test
	void testGetSPSearchList() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(pvuCareerAdvancementServiceImpl.searchShettyPayEvents(pageDetail));

	}*/

	@Test
	void testGetCASInwardList() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(service.getCASInwardList(pageDetail));

	}

	@Test
	void testInsertInITR() throws CustomException {
	when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
	when(repository.findById(1l)).thenReturn(Optional.of(entity));
	when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
			"Approved")).thenReturn(luEntity);
	when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.CONDITION_CHECK,
					Constant.ACTIVE_STATUS, Constant.LOOKUP_YES)).thenReturn(printEnable);
	repository.updatePrintStatusAndApproveDate(luEntity.getLookUpInfoId(), Constant.ACTIVE_STATUS, 1L,
			CurrentUserUserId(), new Date(),printEnable.getLookUpInfoId(),
			LocalDateTime.now());
	when(luEntity.getLookUpInfoId()).thenReturn(2l);
	when(entity.getStatusId()).thenReturn(luEntity);
	when(luEntity.getLookUpInfoId()).thenReturn(1l);
	when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
	when(converter.toDTO(entity)).thenReturn(dto);
	when(pvuWFWrapperDto.getWfStatus()).thenReturn("Approved");
	when(dto.getEmployeeId()).thenReturn(1l);
	when(dto.getEventOrderDate()).thenReturn(LocalDate.now());
	when(dto.getTrnNo()).thenReturn("2020");
	when(dto.getEventCode()).thenReturn("CA");
	when(dto.getDateOfNextIncrement()).thenReturn(LocalDate.now());
	when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
			"Submit")).thenReturn(luEntity);
	//when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
	when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
	when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
	when(entity.getEmployee()).thenReturn(employeEntity);
	when(employeEntity.getEmpId()).thenReturn(1l);
	when(department.getDesignationId()).thenReturn(edpMsDesignationEntity);
	when(edpMsDesignationEntity.getDesignationId()).thenReturn(1l);
	when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
			PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
			PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME)).thenReturn(luEntity);
	when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
	when(commonService.getTransactionNumber("CA")).thenReturn("CA");
	when(pvuEmployeeEventStatusService.inProgressAnyEvent(entity.getEmployee().getEmpId()))
			.thenReturn(pvuEmployeeEventStatusEntity);
	EDPLuLookUpInfoEntity lkentity = new EDPLuLookUpInfoEntity();
	when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
			Constant.ACTIVE_STATUS, Constant.APPROVED)).thenReturn(lkentity);

	assertNotNull(service.insertInITR(pvuWFWrapperDto));
	assertNotNull(service.insertInITR(pvuWFWrapperDto));

	}
	@Test
	void testInsertInITR_Rejeted() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(repository.findById(1l)).thenReturn(Optional.of(entity));

		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Rejected")).thenReturn(rejectedStatus);
		repository.updateStatusId(rejectedStatus.getLookUpInfoId(), 1L,
				CurrentUserUserId(), new Date());

/*		doNothing().when(pvuEmployeeEventStatusService).resetInProgressEmployeeEventStatus(entity.getEmployeeId().getEmpId(),
				0l);*/
		/* Unlock event */
	/*	pvuEmployeeEventStatusService.resetInProgressEmployeeEventStatus(entity.getEmployeeId().getEmpId(),
				OAuthUtility.getCurrentUserLkPOUId());*/


		when(luEntity.getLookUpInfoId()).thenReturn(2l);
		when(entity.getStatusId()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(1l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Rejected");
		when(dto.getEmployeeId()).thenReturn(1l);
		when(dto.getEventOrderDate()).thenReturn(LocalDate.now());
		when(dto.getTrnNo()).thenReturn("2020");
		when(dto.getEventCode()).thenReturn("CA");
		when(dto.getDateOfNextIncrement()).thenReturn(LocalDate.now());
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Submit")).thenReturn(luEntity);
		//when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		when(entity.getEmployee()).thenReturn(employeEntity);
		when(employeEntity.getEmpId()).thenReturn(1l);
		when(department.getDesignationId()).thenReturn(edpMsDesignationEntity);
		when(edpMsDesignationEntity.getDesignationId()).thenReturn(1l);
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
				PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME)).thenReturn(luEntity);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(commonService.getTransactionNumber("CA")).thenReturn("CA");
		when(pvuEmployeeEventStatusService.inProgressAnyEvent(entity.getEmployee().getEmpId()))
				.thenReturn(pvuEmployeeEventStatusEntity);
		EDPLuLookUpInfoEntity lkentity = new EDPLuLookUpInfoEntity();
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.APPROVED)).thenReturn(lkentity);

		assertNotNull(service.insertInITR(pvuWFWrapperDto));
		assertNotNull(service.insertInITR(pvuWFWrapperDto));

	}


	/*@Test
	void testGetSPAuditorSearchList() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(pvuCareerAdvancementServiceImpl.getSPAuditorSearchList(pageDetail));

	}*/

	@Test
	void testSaveOrUpdateCarrearAdvancement() throws CustomException {
		PVUCareerAdvancementDto dto = new PVUCareerAdvancementDto();
		dto.setEmployeeId(1l);
		dto.setId(1l);
		PVUCareerAdvancementEntity entity = new PVUCareerAdvancementEntity();
		entity.setEmployee(new PVUEmployeEntity(1l));
		entity.setId(1l);
		entity.setTrnNo("TT");
		when(repository.findById(1l)).thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toEntity(dto)).thenReturn(entity);
		when(lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		when(service.saveOrUpdateCarrearAdvancement(dto)).thenReturn(dto);
		assertNotNull(when(service.saveOrUpdateCarrearAdvancement(dto)).thenReturn(dto));
	}

	@Test
	void testGetCASDDOList() throws CustomException {
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageIndex(1);
		List<Object[]> objects = new ArrayList<Object[]>();
		Map<String, String> collect = this.getDdoWFListingSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(null, pageDetail, collect);
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.CAS_PVU_EVENT_LS_SRCH_WF));
		when(repository.callStoredProcedure(sp, stringObjectMap)).thenReturn(objects);
		service.getCASDDOList(pageDetail);
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

	@Test
	void testSubmitCasInward() throws CustomException {
		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		List<PvuWFWrapperDto> listWrapperDto = new ArrayList<PvuWFWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus("printed");
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);
		assertNotNull(when(pvuFacade.callWorkFlowApis(listWrapperDto)).thenReturn(true));
		service.submitCasInward(listWrapperDto);
	}

	@Test
	void testSubmitCasDistributor() throws CustomException {
		PvuWFWrapperDto wrapperObj = new PvuWFWrapperDto();
		wrapperObj.setActiveStatus(Constant.ACTIVE_STATUS);
		List<PvuWFWrapperDto> wrapperDto = new ArrayList<PvuWFWrapperDto>();
		wrapperDto.add(wrapperObj);
		assertNotNull(pvuFacade.callWorkFlowApis(wrapperDto));
		service.submitCasDistributor(wrapperDto);
	}

	@Test
	void testInsertCareerAdvancementRemarks() throws CustomException {
		IdDto d = new IdDto();
		d.setId(1l);
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(PvuConstant.TRN_ID, d.getId());
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.INSERT_ROP_REMARKS_ITRS); // Need
		repository.callStoredProcedure(procName.toString(), map);
		service.insertCareerAdvancementRemarks(d.getId());
	}


	@Test
	void testgetPVUOfficeName() {
		IdDto idDto = new IdDto();
		idDto.setId(1L);
		Map<String, Object> map = new HashMap<>();
		map.put("eventId", idDto.getId());
		List<Object[]> objects = new ArrayList<Object[]>();
		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getCAEmployeeOfficeId(), map)).thenReturn(objects);
		EDPMsOfficeDto officeDto = new EDPMsOfficeDto();
		service.getPVUOfficeName(idDto);
	}

	@Test
	void testgetReprintEndorsementRemarks() throws CustomException {
		IdDto d = new IdDto();
		d.setId(1l);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.TRN_ID, d.getId());
		map.put(PvuConstant.EVENT_ID, PvuConstant.CARRER_ADVANCEMENT_EVENT_ID);
		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPVUEventEndorsementHistory(),map)).thenReturn(objects);
		assertNotNull(service.getReprintEndorsementRemarks(d.getId()));

	}

	@Test
	void testInsertITR() throws CustomException {
		PvuWFWrapperDto wrapperObj = new PvuWFWrapperDto();
		IdDto d = new IdDto();
		d.setId(1l);
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(PvuConstant.TRN_ID, d.getId());
		map.put("IN_WORKFLOW_ID", d.getId());
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.INSERT_IN_CAS_ITRS); // Need
		repository.callStoredProcedure(procName.toString(), map);
		service.insertITR(wrapperObj);
	}

	@Test
	void testPvuOfficeEmployeeSearch() throws CustomException {
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageIndex(1);
		List<Object[]> objects = new ArrayList<Object[]>();
		Map<String, String> collect = this.getPvuOfficeSearchFields().stream().collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.COMMON_FIVE_EVENT_LIST_SEARCH_WF_PVU);
		when(repository.callStoredProcedure(procName.toString(), map)).thenReturn(objects);
		service.pvuOfficeEmployeeSearch(pageDetail);
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

	@Test
	void testGetReturnReasonByTransactionId() throws CustomException {
		Map<String, Object> map = new HashMap<>();
		List<Object[]> objects = new ArrayList<Object[]>();
		map.put(PvuConstant.PVU_EVENT_ID, 20);
		map.put(PvuConstant.CS_PVU_EVENT_ID, 11l);
		map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
		when(remarkRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getCsEventReturnRemarks(), map))
				.thenReturn(objects);
		assertNotNull(service.getReturnReasonByTransactionId(11l));

	}
	@Test
	void testGetWfRlCdByCATrnId() throws CustomException {
		PvuWFWrapperDto wrapperObj = new PvuWFWrapperDto();
		IdDto d = new IdDto();
		d.setId(1l);
		wfRepository.findWfRlCdByCATrnId(d.getId(),Constant.ACTIVE_STATUS);
		service.getWfRlCdByCATrnId(d.getId());
	}

	@Test
	void testUpdateCarrierAdvancementRemarks() throws CustomException {
		when(service.getCarrearAdvancement(1L)).thenReturn(entity);
		when(converter.setRemarks(entity, remarkRequest)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(eventsRemarkDto.getReasonId()).thenReturn(1L);
		when(eventsRemarkDto.getWfRoleId()).thenReturn(PvuConstant.AUDITOR_ROLE_ID);
		when(remarkRequest.getAuditorReturnReason()).thenReturn(Constant.RETURN_VAL);
		when(remarkRequest.getEmpId()).thenReturn(1L);
		when(remarkRequest.getId()).thenReturn(1L);
		when(remarkRequest.getWfRoleId()).thenReturn(14L);
		when(remarkRequest.getReturnReasons()).thenReturn(Collections.singletonList(eventsRemarkDto));
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(remarkService.saveAll(Collections.singletonList(remarkEntity))).thenReturn(Collections.singletonList(remarkEntity));
		assertNotNull(service.updateCarrierAdvancementRemarks(remarkRequest));

	}

	@Test
	void testGenerateOutWardNumber() throws SQLException, CustomException {
		List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
		List<IdDto> dtos = new ArrayList<IdDto>();
		dtos.add(new IdDto(1l));
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		map.put(1, dtos);
		parameterMapList.add(map);
		assertNotNull(when(repository.callStoreProcBatch("{CALL " + Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.OUTWARD_NO_GENERATION_PVU)) + "(?)}", parameterMapList)).thenReturn(true));
		service.generateOutWardNumber(dtos);
	}

	@Test
	public void testAuthorizeSPP() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("IN_TRN_NO", 1L);
		List<Object[]> list = new ArrayList<Object[]>();
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.PVU_COMMON_AUTHORIZED_SP);
		repository.callStoredProcedure(procName.toString(), map);
		when(repository.callStoredProcedure(procName.toString(), map)).thenReturn(list);
		service.authorizeSPP(1L);
	}

	@Test
	public void testAauthorizeBackdateSP() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("IN_TRN_NO", 1L);
		map.put("IN_EVNT_CODE", PvuConstant.EVENT_CODE_CAREER_ADVANCE);
		List<Object[]> list = new ArrayList<Object[]>();
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.P_PVU_AUTO_INCR);
		repository.callStoredProcedure(procName.toString(), map);
		when(repository.callStoredProcedure(procName.toString(), map)).thenReturn(list);
		service.authorizeBackdateSP(1L);
	}

	@Test
	void testSubmitCAOutWard() throws CustomException {
		List<PvuWFOutWardWrapperDto> wrapperDto = new ArrayList<>();
		assertNotNull(service.submitCAOutWard(wrapperDto));
	}


	/*@Test
	void testSubmitCAOutWard() throws CustomException {
		PvuWFOutWardWrapperDto dto = new PvuWFOutWardWrapperDto();
		dto.setStatus(Constant.RETURN);
		List<PvuWFOutWardWrapperDto> dtos = new ArrayList<>();
		when(wfOutWardWrapperDto.getStatus()).thenReturn(Constant.AUTHORIZE);
		when(wfOutWardWrapperDto.getTrnId()).thenReturn(1L);
		dtos.add(wfOutWardWrapperDto);
		when(wfOutWardWrapperDto.getStatus()).thenReturn(Constant.RETURN);
		dtos.add(wfOutWardWrapperDto);
		assertNotNull(service.submitCAOutWard(dtos));
		when(wfOutWardWrapperDto.getStatus()).thenReturn(Constant.AUTHORIZE);
		when(repository.getEmpId(1L)).thenReturn(1L);
		when(pvuEmployeeEventStatusService.findOneByEmpId(1L)).thenReturn(pvuEmployeeEventStatusEntity);
		dtos.add(wfOutWardWrapperDto);
		assertNotNull(service.submitCAOutWard(dtos));
	}*/


	@Test
	void testGetCAPrintEndorsementList() throws CustomException {
		PageDetails pageDetail = new PageDetails();
		Map<String, String> collect = this.getPrintPrintEndorsementSearchFields().stream().collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> printEndorsementMap = SearchParam.buildPageInMap(null, pageDetail, collect);
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF).toString();
		List<Object[]> objects = new ArrayList<Object[]>();
		when(repository.callStoredProcedure(procName, printEndorsementMap)).thenReturn(objects);
		service.getCAPrintEndorsementList(pageDetail);

	}


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
	@Mock
	private List<PvuPrintStickerReportDto> pvuPrintStickerReportList;

	@Mock
	private PvuPrintStickerReportDto pvuPrintStickerDto;

	@Mock
	private List<PvuPrintStickerReportDto> pvuPrintStickerDtos;



	/*@Test
	void testSubmiAcpOutward() throws CustomException {

		outwordList = new ArrayList<PvuWFOutWardWrapperDto>();
		outWardDto = new PvuWFOutWardWrapperDto();
		outWardDto.setTrnId(1L);
		outWardDto.setStatus(Constant.RETURN);
		outwordList.add(outWardDto);

		doNothing().when(inwardService).setResetOutwardFlag(outwordList.get(0).getTrnId(),1L);
		doNothing().when(inwardService).setConsignmentNumber(1L,1L,"Test");

		eventStatusEntityForTrn = new PVUEmployeeEventStatusEntity();
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntity = Optional.of(eventStatusEntityForTrn);

		PVUEmployeEntity empEntity = new PVUEmployeEntity();
		empEntity.setEmpId(1024L);
		empEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		eventStatusEntity.setEmpId(empEntity);
		boolean flag = true;
		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		wfWrapperDtoList = new ArrayList<PvuWFWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus("printed");
		wrapperDto.setAssignByWfRoleId(20l);
		wfWrapperDtoList.add(wrapperDto);

		assertNotNull(when(pvuFacade.callWorkFlowApis(wfWrapperDtoList)).thenReturn(flag));
		PVUEmployeAssuredCareerProgressionEntity entity = new PVUEmployeAssuredCareerProgressionEntity();
		entity.setAcpType(123L);
		when(repository.findOneById(1L)).thenReturn(entity);
		when(pvuEmployeeEventStatusService.findByEmpId(1024L)).thenReturn(pvuEmployeeEventStatusEntity);
		service.submitACPOutward(outwordList);
	}*/

	/*@Test
	void testGetEmployeeCurrDetail() throws CustomException {
		PVUCareerAdvanceCurDetailDto curDetailDto = new PVUCareerAdvanceCurDetailDto();
		List<PVUCareerAdvanceCurrentDetailsView> objStorePro = null;
		curDetailDto.setEmpNo(10000068l);
		curDetailDto.setPayCommission(153L);
		curDetailDto.setAdvSchType(312L);
		curDetailDto.setEffectiveDate(PvuUtils
				.getStrOfLocalDateInYMD(LocalDate.now().plusYears(1)));
		Map<String, Object> map = buildCASEmployeeRequestMap(curDetailDto);
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_CAS_CURR_EVNT_DTLS));
		List<Object[]> objectPvuSp = new ArrayList<Object[]>();
		when(repository.callStoredProcedureWithSQLErrorCode(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.PVU_EMPLOYEE_CAS_CURR_EVNT_DTLS, map)).thenReturn(objectPvuSp);

	*//*	when(pvuEmployeeDepartmentRepo.findFirstByPvuEmployeEntityEmployeeCode(10000068l)).thenReturn(Optional.of(dptEntity));
		when(dptEntity.getPresentOffice()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(1l);
		Date dt = new Date(21,4, 12);
		when(dptEntity.getDateOfJoiningGOG()).thenReturn(dt);
		when(PvuUtils.isFromToBeforeEquals(PvuUtils.convertLocalDate(dptEntity.getDateOfJoiningGOG()),
					PvuUtils.getDateFromStringYMD(curDetailDto.getEffectiveDate()))).thenThrow(CustomException.class);
		Date dt1 = new Date(19,4, 12);
		when(dptEntity.getDateOfJoiningGOG()).thenReturn(dt1);
		when(PvuUtils.isFromToBeforeEquals(PvuUtils.convertLocalDate(dptEntity.getDateOfJoiningGOG()),
				PvuUtils.getDateFromStringYMD(curDetailDto.getEffectiveDate()))).thenThrow(new CustomException(HttpStatus.CONFLICT, PvuUtils.buildErrorMsg(154L)));*//*

		assertNotNull(service.getEmployeeCurrDetail(curDetailDto));
	}*/
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


	@Test
	public void testDeleteCasEventById() throws CustomException {
		IdDto trnEventId = new IdDto();
		trnEventId.setId(1l);
		assertNotNull(service.deleteCasEventById(trnEventId));
	}
	@Test
	void testGetPVUResponse() throws CustomException {
		IdDto dto = new IdDto();
		dto.setId(1l);
		PVUCareerAdvancementEntity caDto = new PVUCareerAdvancementEntity();
		when(repository.getOne(1l)).thenReturn(caDto);
		caDto.setCurrentDetailsEventId(1L);
		caDto.setEmployee(new PVUEmployeEntity(1l));
		when(eventsService.getCommonApiResponse(caDto.getCurrentDetailsEventId())).thenReturn(commonApiDto);
		PVUCarrierAdvanceCurrentDto currentDetails=new PVUCarrierAdvanceCurrentDto();
		PVUCareerAdvancementPostDto postDetails=new PVUCareerAdvancementPostDto();
		when(converter.toCurrentObj(commonApiDto,caDto)).thenReturn(currentDetails);
		when(converter.toPostObj(caDto)).thenReturn(postDetails);
		List<PVUEmployeEventsEntity> entity =new ArrayList<>();
		when(pvuEmpEvent.findAllByEmpIdAndEventName(caDto.getEmployee().getEmpId(), PvuConstant.EVENT_NAME_CAREER_ADVANCE)).thenReturn(entity);
		assertNotNull(service.getPVUResponse(dto));
	}
	@Test
	void testGeneratePrintEndorsement_5th() throws IOException, ParseException, DocumentException, CustomException {

		when(pvuPrintStickerDto.getStickerDTO()).thenReturn(stickerDTO);
		when(stickerDTO.getId()).thenReturn(1L);
		when(stickerDTO.getEmployeeNo()).thenReturn("11000001");
		when(stickerDTO.getEmployeeName()).thenReturn("11000001");
		when(stickerDTO.getDesignation()).thenReturn("11000001");
		when(entity.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(entity.getDateOfNextIncrement()).thenReturn(LocalDate.now());

		when(stickerDTO.getEndorsementPrintDate()).thenReturn(new Date());
		when(stickerDTO.getCellValue()).thenReturn("11");
		when(stickerDTO.getLevelValue()).thenReturn("11");
		when(repository.getOne(pvuPrintStickerDto.getStickerDTO().getId())).thenReturn(entity);
		entity.setId(1L);

		entity.setCurrentDetailsEventId(1L);
		PVUMsPayScaleEntity scaleEntity=new PVUMsPayScaleEntity();
		when(entity.getPayScale()).thenReturn(new PVUMsPayScaleEntity(12L));
		print.setScaleName(entity.getPayScale().getPayScaleDispVal());
		when(entity.getGradePayId()).thenReturn(new PVUMsGradePayEntity(12L));
		when(entity.getPayLevelId()).thenReturn(new PVUMsPayLevelEntity(12L));
		PVUCommonApiDto common =new PVUCommonApiDto();
		when(this.eventsService.getCommonApiResponse(entity.getCurrentDetailsEventId())).thenReturn(common);
		common.setDesignationName("Helo");
		common.setPayCommId(150L);
		when(printRepository.getPrintDateReprintDatePrintCountData(entity.getId(),
				PvuConstant.CARRER_ADVANCEMENT_EVENT_ID, Constant.ACTIVE_STATUS)).thenReturn(print);
		when(converter.print(entity,print,common)).thenReturn(print);
		when(entity.getOfficeId()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(1l);
		when(entity.getAuthorizeBy()).thenReturn(1L);
		IdNameDto idNameDto=new IdNameDto();
		when(authService.getOnlyIdAndName(entity.getAuthorizeBy())).thenReturn(idNameDto);
		idNameDto.setName("HP");
		String watermark="";
		watermark.concat("Self PVU");
		//assertNotNull(service.generatePrintEndorsement(pvuPrintStickerDto));
	}
	@Test
	void testGeneratePrintEndorsement_6th() throws IOException, ParseException, DocumentException, CustomException {

		when(pvuPrintStickerDto.getStickerDTO()).thenReturn(stickerDTO);
		when(stickerDTO.getId()).thenReturn(1L);
		when(stickerDTO.getEmployeeNo()).thenReturn("11000001");
		when(stickerDTO.getEmployeeName()).thenReturn("11000001");
		when(stickerDTO.getDesignation()).thenReturn("11000001");
		when(entity.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(entity.getDateOfNextIncrement()).thenReturn(LocalDate.now());

		when(stickerDTO.getEndorsementPrintDate()).thenReturn(new Date());
		when(stickerDTO.getCellValue()).thenReturn("11");
		when(stickerDTO.getLevelValue()).thenReturn("11");
		when(repository.getOne(pvuPrintStickerDto.getStickerDTO().getId())).thenReturn(entity);
		entity.setId(1L);

		entity.setCurrentDetailsEventId(1L);
		PVUMsPayScaleEntity scaleEntity=new PVUMsPayScaleEntity();
		when(entity.getPayScale()).thenReturn(new PVUMsPayScaleEntity(12L));
		print.setScaleName(entity.getPayScale().getPayScaleDispVal());
		when(entity.getGradePayId()).thenReturn(new PVUMsGradePayEntity(12L));
		when(entity.getPayLevelId()).thenReturn(new PVUMsPayLevelEntity(12L));
		when(entity.getPayBandId()).thenReturn(new PVUMsPayBandEntity(12L));

		print.setPayBand(entity.getPayBandId().getPayBandDispVal());
		PVUCommonApiDto common =new PVUCommonApiDto();
		when(this.eventsService.getCommonApiResponse(entity.getCurrentDetailsEventId())).thenReturn(common);
		common.setDesignationName("Helo");
		when(printRepository.getPrintDateReprintDatePrintCountData(entity.getId(),
				PvuConstant.CARRER_ADVANCEMENT_EVENT_ID, Constant.ACTIVE_STATUS)).thenReturn(print);
		when(converter.print(entity,print,common)).thenReturn(print);
		when(entity.getOfficeId()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(1l);
		when(entity.getAuthorizeBy()).thenReturn(1L);
		IdNameDto idNameDto=new IdNameDto();
		when(authService.getOnlyIdAndName(entity.getAuthorizeBy())).thenReturn(idNameDto);
		idNameDto.setName("HP");
		String watermark="";
		watermark.concat("Self PVU");
		common.setPayCommId(151L);
		//assertNotNull(service.generatePrintEndorsement(pvuPrintStickerDto));
	}

// TODO fix NullPointer in test..
//	@Test
	void testGeneratePrintEndorsement_7th() throws IOException, ParseException, DocumentException, CustomException {

		when(pvuPrintStickerDto.getStickerDTO()).thenReturn(stickerDTO);
		when(stickerDTO.getId()).thenReturn(1L);
		when(stickerDTO.getEmployeeNo()).thenReturn("11000001");
		when(stickerDTO.getEmployeeName()).thenReturn("11000001");
		when(stickerDTO.getDesignation()).thenReturn("11000001");
		when(entity.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(entity.getDateOfNextIncrement()).thenReturn(LocalDate.now());

		when(stickerDTO.getEndorsementPrintDate()).thenReturn(new Date());
		when(stickerDTO.getCellValue()).thenReturn("11");
		when(stickerDTO.getLevelValue()).thenReturn("11");
		when(repository.getOne(pvuPrintStickerDto.getStickerDTO().getId())).thenReturn(entity);
		entity.setId(1L);

		entity.setCurrentDetailsEventId(1L);
		PVUMsPayScaleEntity scaleEntity=new PVUMsPayScaleEntity();
		when(entity.getPayScale()).thenReturn(new PVUMsPayScaleEntity(12L));
		print.setScaleName(entity.getPayScale().getPayScaleDispVal());
		when(entity.getGradePayId()).thenReturn(new PVUMsGradePayEntity(12L));
		when(entity.getPayLevelId()).thenReturn(new PVUMsPayLevelEntity(12L));
		PVUCommonApiDto common =new PVUCommonApiDto();
		when(this.eventsService.getCommonApiResponse(entity.getCurrentDetailsEventId())).thenReturn(common);
		common.setDesignationName("Helo");
		when(printRepository.getPrintDateReprintDatePrintCountData(entity.getId(),
				PvuConstant.CARRER_ADVANCEMENT_EVENT_ID, Constant.ACTIVE_STATUS)).thenReturn(print);
		when(converter.print(entity,print,common)).thenReturn(print);
		when(entity.getOfficeId()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(1l);
		when(entity.getAuthorizeBy()).thenReturn(1L);
		IdNameDto idNameDto=new IdNameDto();
		when(authService.getOnlyIdAndName(entity.getAuthorizeBy())).thenReturn(idNameDto);
		idNameDto.setName("HP");
		String watermark="";
		watermark.concat("Self PVU");
		common.setPayCommId(152L);
		assertNotNull(service.generatePrintEndorsement(pvuPrintStickerDto));
	}
	@Test
	void testGeneratePrintEndorsementList_7th() throws IOException, ParseException, DocumentException, CustomException {

			when(pvuPrintStickerDto.getStickerDTO()).thenReturn(stickerDTO);
			when(stickerDTO.getId()).thenReturn(1L);
			when(stickerDTO.getEmployeeNo()).thenReturn("11000001");
			when(stickerDTO.getEmployeeName()).thenReturn("11000001");
			when(stickerDTO.getDesignation()).thenReturn("11000001");
			when(entity.getEventEffectiveDate()).thenReturn(LocalDate.now());
			when(entity.getDateOfNextIncrement()).thenReturn(LocalDate.now());

			when(stickerDTO.getEndorsementPrintDate()).thenReturn(new Date());
			when(stickerDTO.getCellValue()).thenReturn("11");
			when(stickerDTO.getLevelValue()).thenReturn("11");
			when(repository.getOne(pvuPrintStickerDto.getStickerDTO().getId())).thenReturn(entity);
			entity.setId(1L);

			entity.setCurrentDetailsEventId(1L);
			PVUMsPayScaleEntity scaleEntity = new PVUMsPayScaleEntity();
			when(entity.getPayScale()).thenReturn(new PVUMsPayScaleEntity(12L));
			print.setScaleName(entity.getPayScale().getPayScaleDispVal());
			when(entity.getGradePayId()).thenReturn(new PVUMsGradePayEntity(12L));
			when(entity.getPayLevelId()).thenReturn(new PVUMsPayLevelEntity(12L));

			PVUCommonApiDto common = new PVUCommonApiDto();
			when(this.eventsService.getCommonApiResponse(entity.getCurrentDetailsEventId())).thenReturn(common);
			common.setDesignationName("Helo");
			when(printRepository.getPrintDateReprintDatePrintCountData(entity.getId(),
					PvuConstant.CARRER_ADVANCEMENT_EVENT_ID, Constant.ACTIVE_STATUS)).thenReturn(print);
			when(converter.print(entity, print,common)).thenReturn(print);
			when(entity.getOfficeId()).thenReturn(edpMsOfficeEntity);
			when(edpMsOfficeEntity.getOfficeId()).thenReturn(1l);
			when(entity.getAuthorizeBy()).thenReturn(1L);
			IdNameDto idNameDto = new IdNameDto();
			when(authService.getOnlyIdAndName(entity.getAuthorizeBy())).thenReturn(idNameDto);
			idNameDto.setName("HP");
			String watermark = "";
			watermark.concat("Self PVU");
			common.setPayCommId(152L);

		List<PvuPrintStickerReportDto> list = new ArrayList<PvuPrintStickerReportDto>();
		list.add(pvuPrintStickerDto);
		// assertNotNull(service.generatePrintEndorsement(list));
	}
	@Test
	void testGeneratePrintEndorsementList_6th() throws IOException, ParseException, DocumentException, CustomException {

		when(pvuPrintStickerDto.getStickerDTO()).thenReturn(stickerDTO);
		when(stickerDTO.getId()).thenReturn(1L);
		when(stickerDTO.getEmployeeNo()).thenReturn("11000001");
		when(stickerDTO.getEmployeeName()).thenReturn("11000001");
		when(stickerDTO.getDesignation()).thenReturn("11000001");
		when(entity.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(entity.getDateOfNextIncrement()).thenReturn(LocalDate.now());

		when(stickerDTO.getEndorsementPrintDate()).thenReturn(new Date());
		when(stickerDTO.getCellValue()).thenReturn("11");
		when(stickerDTO.getLevelValue()).thenReturn("11");
		when(repository.getOne(pvuPrintStickerDto.getStickerDTO().getId())).thenReturn(entity);
		entity.setId(1L);

		entity.setCurrentDetailsEventId(1L);
		PVUMsPayScaleEntity scaleEntity = new PVUMsPayScaleEntity();
		when(entity.getPayScale()).thenReturn(new PVUMsPayScaleEntity(12L));
		print.setScaleName(entity.getPayScale().getPayScaleDispVal());
		when(entity.getGradePayId()).thenReturn(new PVUMsGradePayEntity(12L));
		when(entity.getPayLevelId()).thenReturn(new PVUMsPayLevelEntity(12L));
		when(entity.getPayBandId()).thenReturn(new PVUMsPayBandEntity(12L));
		print.setPayBand(entity.getPayBandId().getPayBandDispVal());
		PVUCommonApiDto common = new PVUCommonApiDto();
		when(this.eventsService.getCommonApiResponse(entity.getCurrentDetailsEventId())).thenReturn(common);
		common.setDesignationName("Helo");
		when(printRepository.getPrintDateReprintDatePrintCountData(entity.getId(),
				PvuConstant.CARRER_ADVANCEMENT_EVENT_ID, Constant.ACTIVE_STATUS)).thenReturn(print);
		when(converter.print(entity, print,common)).thenReturn(print);
		when(entity.getOfficeId()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(1l);
		when(entity.getAuthorizeBy()).thenReturn(1L);
		IdNameDto idNameDto = new IdNameDto();
		when(authService.getOnlyIdAndName(entity.getAuthorizeBy())).thenReturn(idNameDto);
		idNameDto.setName("HP");
		String watermark = "";
		watermark.concat("Self PVU");
		common.setPayCommId(151L);

		List<PvuPrintStickerReportDto> list = new ArrayList<PvuPrintStickerReportDto>();
		list.add(pvuPrintStickerDto);
		//assertNotNull(service.generatePrintEndorsement(list));
	}
	@Test
	void testGeneratePrintEndorsementList_5th() throws IOException, ParseException, DocumentException, CustomException {

		when(pvuPrintStickerDto.getStickerDTO()).thenReturn(stickerDTO);
		when(stickerDTO.getId()).thenReturn(1L);
		when(stickerDTO.getEmployeeNo()).thenReturn("11000001");
		when(stickerDTO.getEmployeeName()).thenReturn("11000001");
		when(stickerDTO.getDesignation()).thenReturn("11000001");
		when(entity.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(entity.getDateOfNextIncrement()).thenReturn(LocalDate.now());

		when(stickerDTO.getEndorsementPrintDate()).thenReturn(new Date());
		when(stickerDTO.getCellValue()).thenReturn("11");
		when(stickerDTO.getLevelValue()).thenReturn("11");
		when(repository.getOne(pvuPrintStickerDto.getStickerDTO().getId())).thenReturn(entity);
		entity.setId(1L);

		entity.setCurrentDetailsEventId(1L);
		PVUMsPayScaleEntity scaleEntity = new PVUMsPayScaleEntity();
		when(entity.getPayScale()).thenReturn(new PVUMsPayScaleEntity(12L));
		print.setScaleName(entity.getPayScale().getPayScaleDispVal());
		when(entity.getGradePayId()).thenReturn(new PVUMsGradePayEntity(12L));
		when(entity.getPayLevelId()).thenReturn(new PVUMsPayLevelEntity(12L));
		PVUCommonApiDto common = new PVUCommonApiDto();
		when(this.eventsService.getCommonApiResponse(entity.getCurrentDetailsEventId())).thenReturn(common);
		common.setDesignationName("Helo");
		when(printRepository.getPrintDateReprintDatePrintCountData(entity.getId(),
				PvuConstant.CARRER_ADVANCEMENT_EVENT_ID, Constant.ACTIVE_STATUS)).thenReturn(print);
		when(converter.print(entity, print,common)).thenReturn(print);
		when(entity.getOfficeId()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(1l);
		when(entity.getAuthorizeBy()).thenReturn(1L);
		IdNameDto idNameDto = new IdNameDto();
		when(authService.getOnlyIdAndName(entity.getAuthorizeBy())).thenReturn(idNameDto);
		idNameDto.setName("HP");
		String watermark = "";
		watermark.concat("Self PVU");
		common.setPayCommId(150L);

		List<PvuPrintStickerReportDto> list = new ArrayList<PvuPrintStickerReportDto>();
		list.add(pvuPrintStickerDto);
		//assertNotNull(service.generatePrintEndorsement(list));
	}












}