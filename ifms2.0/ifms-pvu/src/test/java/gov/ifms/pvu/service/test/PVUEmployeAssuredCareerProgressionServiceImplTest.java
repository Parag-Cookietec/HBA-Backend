package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUEmployeAssuredCareerProgressionConverter;
import gov.ifms.pvu.converter.PVUMsReasonConverter;
import gov.ifms.pvu.converter.PVUPrintEndorsementItrConverter;
import gov.ifms.pvu.dto.AcpEmployeeDetailDto;
import gov.ifms.pvu.dto.PVUACPDetailRequest;
import gov.ifms.pvu.dto.PVUEmployeAssuredCareerProgressionDto;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVURopRemarksDto;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuSixthPayCommissionResponse;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.PvusixthPayCommissionRequest;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.dto.response.PVUDepartmentQueryDto;
import gov.ifms.pvu.entity.PVUEmployeAssuredCareerProgressionEntity;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUMsEventEntity;
import gov.ifms.pvu.entity.PVUMsReasonEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementItrEntity;
import gov.ifms.pvu.repository.PVUDepartmentCategoryRepository;
import gov.ifms.pvu.repository.PVUEmployeAssuredCareerProgressionRepository;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeEventsRepository;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVUEmployeeEventStatusRepository;
import gov.ifms.pvu.repository.PVUEventRemarksRepository;
import gov.ifms.pvu.repository.PVUInwardRepository;
import gov.ifms.pvu.repository.PVUMsEventRepository;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import gov.ifms.pvu.repository.PVUMsPayLevelRepository;
import gov.ifms.pvu.repository.PVUMsReasonRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.service.PVUAcpRemarksService;
import gov.ifms.pvu.service.PVUEmployeAssuredCareerProgressionServiceImpl;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployePayDetailService;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.service.PVUInwardService;
import gov.ifms.pvu.service.PVUMsReasonService;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;

class PVUEmployeAssuredCareerProgressionServiceImplTest {

	@InjectMocks
	private PVUEmployeAssuredCareerProgressionServiceImpl service;

	@Mock
	private PVUMsReasonService pvuMsReasonService;

	@Mock
	private PVUEmployeAssuredCareerProgressionRepository repository;

	@Mock
	private PVUEmployeDepartmentRepository pvuEmployeeDepartmentRepo;

	@Mock
	private EDPLuLookUpInfoEntity infoEntity;

	@Mock
	private EDPLuLookUpInfoEntity test;

	@Mock
	private EDPLuLookUpInfoEntity approvedLookupEntity;

	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	@Mock
	private PVUInwardRepository pvuInwardRepository;

	@Mock
	private PVUMsEventRepository msRepository;

	@Mock
	private PVUMsReasonRepository msReasonRepository;

	@Mock
	private PVUEventRemarksRepository remarksRepository;

	@Mock
	private EDPMsDesignationRepository designationRepository;

	@Mock
	private WfRepository wfRepository;

	@Mock
	private PvuWFWrapperDto wrapperDto;

	@Mock
	private EDPLuLookUpInfoEntity testInfoEntity;

	@Mock
	private PVUEmployeAssuredCareerProgressionDto progressionDto;

	@Mock
	private PVYFacade pvuFacade;

	@Mock
	private PVUEmployeAssuredCareerProgressionEntity entity;

	@Mock
	private List<PVUEmployeAssuredCareerProgressionEntity> entityList;

	@Mock
	private PVUMsReasonEntity reasonEntity;

	@Mock
	private PVUEmployeEntity employeeEntity;

	@Mock
	private OAuthUtility oauthUtility;

	@Mock
	private Page<PVUEmployeAssuredCareerProgressionEntity> page;

	@Mock
	private List<PVUEmployeAssuredCareerProgressionEntity> lst;

	@Mock
	private List<PVUEmployeAssuredCareerProgressionDto> list;

	@Mock
	private List<PvuSixthPayCommissionResponse> sixthPayCommissionList;

	@Mock
	private PVUEmployeAssuredCareerProgressionConverter converter;

	@Mock
	private PVUMsReasonConverter reasonConverter;

	@Mock
	private List<PVUMsReasonEntity> listEntities;

	@Mock
	private PVUEmployeeEventStatusEntity eventStatusEntity;

	@Mock
	private PVUEmployeeEventStatusEntity eventStatusEntityForTrn;

	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Mock
	private PVUAcpRemarksService pvuAcpRemarksService;

	@Mock
	private PVUCommonService pvuCommonService;

	@Mock
	private Map<String, Object> map;

	@Mock
	private PVUACPDetailRequest pvuAcpDetailRequest;

	@Mock
	private List<PvuWFWrapperDto> wfWrapperDtoList;

	@Mock
	private PvuPrintStickerReportDto pvuPrintStickerReportDto;

	@Mock
	private List<PvuPrintStickerReportDto> pvuPrintStickerReportList;

	@Mock
	private PVUPrintEndorsementEntity pvuPrintStickerReportEntity;

	@Mock
	private PVUPrintEndorsementItrEntity pvuPrintEndorsementItrEntity;

	@Mock
	PVUPrintEndorsementRepository pvuPrintEndorsementRepository;

	@Mock
	private PvuPrintStickerReportDto pvuPrintStickerDto;

	@Mock
	private PVUPrintEndorsementDto pvuPrintEndoresementDto;

	@Mock
	private PVUStickerDTO pvuStrickerDto;

	@Mock
	private PVUPrintEndorsementItrRepository pvuPrintEndorsementItrRepository;

	@Mock
	private PVUPrintEndorsementItrConverter pvuPrintEndorsementItrConverter;

	@Mock
	private PVUACPDetailRequest acpDetailsRequest;

	@Mock
	private List<AcpEmployeeDetailDto> acpEmployeeDetailsDto;

	@Mock
	private AcpEmployeeDetailDto acpEMployeeDetailDto;

	@Mock
	private PVUEmployeEventsService eventsService;

	@Mock
	private List<String> eventStrList;

	@Mock
	private List<PVUEmployeEventsEntity> empEventEntities;

	@Mock
	private PVUEmployeEventsEntity empEventEntity;

	@Mock
	private PVUEmployeDepartmentRepository departmentRepository;

	@Mock
	private List<PvuWFOutWardWrapperDto> outwordList;

	@Mock
	private PvuWFOutWardWrapperDto outWardDto;

	@Mock
	private PVUInwardService inwardService;

	@Mock
	private PVUCommonApiDto pvuCommonApiDto;

	@Mock
	private PVUEmployeEventsRepository employeEventsRepository;

	@Mock
	private PVUMsPayCellRepository cellRepository;

	@Mock
	private PVUMsPayLevelRepository levelRepository;

	@Mock
	private PVUEmployeRepository empRepo;

	@Mock
	private PVUDepartmentCategoryRepository categoryRepository;

	@Mock
	private PVUDepartmentQueryDto departmentQueryDto;

	@Mock
	private PVUInwardRepository inwardRepository;

	@Mock
	private PVUEmployeeEventStatusRepository empStatusRepo;;

	@Mock
	private PVUEmployePayDetailService pvuEmployePayDetailService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetEmployeAssuredCareerProgression() {
		when(repository.findOneById(1L)).thenReturn(entity);
		assertNotNull(service.getEmployeAssuredCareerProgression(1L));
		verify(repository, times(1)).findOneById(1L);
	}

	@Test
	void testSaveOrUpdateEmployeAssuredCareerProgression() throws CustomException {
		progressionDto.setStatusId(0L);
		progressionDto.setEmployeeNo(1L);
		when(converter.toEntity(progressionDto)).thenReturn(entity);
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.STATUS_ID, Constant.ACTIVE_STATUS, Constant.SAVE_AS_DRAFT)).thenReturn(infoEntity);
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(progressionDto);
		service.saveOrUpdateEmployeAssuredCareerProgression(progressionDto);

	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetEmployeAssuredCareerProgressions() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
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
		when(converter.toDTO(lst)).thenReturn(list);
		PagebleDTO<PVUEmployeAssuredCareerProgressionDto> data = service
				.getEmployeAssuredCareerProgressions(pageDetail);
		assertNotNull(data);
	}

	@Test
	void testGetAllLuLookUpInfoAsMap() throws CustomException {
		assertNotNull(service.getAllLuLookUpInfoAsMap());
	}

	@Test
	void testGenerateInwardNumber() throws SQLException, CustomException {
		List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
		List<IdDto> dtos = new ArrayList<IdDto>();
		dtos.add(new IdDto(1l));
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		map.put(1, dtos);
		parameterMapList.add(map);
		assertNotNull(when(repository.callStoreProcBatch(
				"{CALL " + Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INWARD_NO_GENERATION)) + "(?)}",
				parameterMapList)).thenReturn(true));
		// service.generateInwardNumber(dtos);
		service.generateInwardNumber(dtos);
	}

	@Test
	void testGenerateOutwardNumber() throws SQLException, CustomException {
		List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
		List<IdDto> dtos = new ArrayList<IdDto>();
		dtos.add(new IdDto(1l));
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		map.put(1, dtos);
		parameterMapList.add(map);
		assertNotNull(
				when(repository.callStoreProcBatch(
						"{CALL " + Constant.PVU_SCHEMA
								.concat(Constant.DOT.concat(PvuConstant.OUTWARD_NO_GENERATION_PVU)) + "(?)}",
						parameterMapList)).thenReturn(true));
		// service.generateInwardNumber(dtos);
		service.generateOutwardNumber(dtos);
	}

	@Test
	void testGetAssuredCareerProgressionById() {
		Long id = 1L;
		PVUEmployeAssuredCareerProgressionEntity entity = new PVUEmployeAssuredCareerProgressionEntity();
		entity.setAcpType(new EDPLuLookUpInfoEntity(123L));
		when(repository.findOneById(id)).thenReturn(entity);
		assertNotNull(service.getAssuredCareerProgressionById(id));
	}

	@Test
	void testGetWfRoleCodeByTrnId() {
		Long id = 1L;
		String returnStr = "test";

		when(wfRepository.findWfRlCdByAcpPayTrnId(id, Constant.ACTIVE_STATUS)).thenReturn(returnStr);
		assertNotNull(service.getWfRoleCodeByTrnId(id));

	}

	@Test
	void testSubmiAcpInward() throws CustomException {
		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		List<PvuWFWrapperDto> listWrapperDto = new ArrayList<PvuWFWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus("printed");
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);
		assertNotNull(when(pvuFacade.callWorkFlowApis(listWrapperDto)).thenReturn(true));
		service.submiAcpInward(listWrapperDto);
	}

	@Test
	void testGetRemarkByeventId() throws CustomException {

		Long Id = 1L;
		PVUMsEventEntity pvuMsEntity = new PVUMsEventEntity();
		pvuMsEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		Map<String, Object> map = new HashMap<>();
		List<PVUEventRemarksDto> list = new ArrayList<PVUEventRemarksDto>();
		Optional<PVUMsEventEntity> msEvent = Optional.of(pvuMsEntity);
		when(msRepository.findByEventCode(PvuConstant.EVENT_CODE_ACP)).thenReturn(msEvent);
		assertTrue(msEvent.isPresent());
		map.put("acpPayId", msEvent.get().getId());
		map.put(PvuConstant.PVU_EVENT_ID, Id);
		map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
		when(NativeQueryResultsMapper.map(
				remarksRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getAcpReturnRemarks(), map),
				PVUEventRemarksDto.class)).thenReturn(list);
		service.getRemarkByeventId(Id);

	}

	@Test
	void testGetEmployeeAcpById() {

		Long id = 1L;
		Optional<PVUEmployeAssuredCareerProgressionEntity> obj = Optional.of(entity);
		when(repository.findById(id)).thenReturn(obj);
		service.getEmployeeAcpById(id);

	}

	@Test
	void testSubmitAcpDistributor() throws CustomException {
		PvuWFWrapperDto wrapperObj = new PvuWFWrapperDto();
		wrapperObj.setActiveStatus(Constant.ACTIVE_STATUS);
		List<PvuWFWrapperDto> wrapperDto = new ArrayList<PvuWFWrapperDto>();
		wrapperDto.add(wrapperObj);

		assertNotNull(pvuFacade.callWorkFlowApis(wrapperDto));
		service.submitAcpDistributor(wrapperDto);

	}

	@Test
	void testDeleteAcpTrns() throws SQLException, CustomException {

		Long id = 1L;
		IdDto dto = new IdDto();
		dto.setId(id);
		Long userId = 1L;
		infoEntity = new EDPLuLookUpInfoEntity();
		infoEntity.setLookUpInfoId(1L);
		infoEntity.setActiveStatus(Constant.ACTIVE_STATUS);

		entity = new PVUEmployeAssuredCareerProgressionEntity();
		entity.setStatusId(infoEntity);
		entity.setActiveStatus(Constant.ACTIVE_STATUS);

		employeeEntity.setEmpId(1272L);

		entity.setEmployeeNo(employeeEntity);
		when(repository.findOneById(id)).thenReturn(entity);
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(infoEntity);
		doNothing().when(repository).deleteACPEventIdBy(Constant.ACTIVE_STATUS, id, userId, new Date());
		doNothing().when(pvuEmployeeEventStatusService).resetInProgressEmployeeEventStatus(1L, 1L);
		service.deleteAcpTrns(dto);

	}

	@Test
	void testDeleteAcpTrns_Entity_Null() throws SQLException, CustomException {

		Long id = 1L;
		IdDto dto = new IdDto();
		dto.setId(id);
		Long userId = 1L;
		infoEntity = new EDPLuLookUpInfoEntity();
		infoEntity.setLookUpInfoId(1L);
		infoEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity = null;
		when(repository.findOneById(id)).thenReturn(entity);
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(infoEntity);
		doNothing().when(repository).deleteACPEventIdBy(Constant.ACTIVE_STATUS, id, userId, new Date());
		doNothing().when(pvuEmployeeEventStatusService).resetInProgressEmployeeEventStatus(1L, 1L);
		service.deleteAcpTrns(dto);
	}

	@Test
	void testInsertACPRemarks_ObjAvailable() {
		List<Object[]> objects = new ArrayList<Object[]>();
		Long transId = 1L;
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append("INSERT_IN_ACP_EVNT_REMARKS_ITR");
		when(repository.callStoredProcedure(procName.toString(), map)).thenReturn(objects);
		service.insertACPRemarks(transId);
	}

	@Test
	void testAuthorizedRop_ObjAvailable() {
		List<Object[]> objects = new ArrayList<Object[]>();
		Long transId = 1L;
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append("PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF");
		when(repository.callStoredProcedure(procName.toString(), map)).thenReturn(objects);
		service.authorizedRop(transId);
	}

	@Test
	void testPvuAuditorList() throws CustomException {
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageIndex(1);
		List<Object[]> objects = new ArrayList<Object[]>();
		Map<String, String> collect = this.getPvuOfficeSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> map = SearchParam.buildPageInMap(null, pageDetail, collect);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.COMMON_FIVE_EVENT_LIST_SEARCH_WF_PVU);
		when(repository.callStoredProcedure(procName.toString(), map)).thenReturn(objects);
		service.pvuAuditorList(pageDetail);

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
	void testGetACPDDOList() throws CustomException {

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageIndex(1);
		List<Object[]> objects = new ArrayList<Object[]>();
		Map<String, String> collect = this.getDdoWFListingSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(null, pageDetail, collect);
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ACP_PVU_EVENT_LIST_SRCH_WF));
		when(repository.callStoredProcedure(sp, stringObjectMap)).thenReturn(objects);
		service.getACPDDOList(pageDetail);
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
	void testGetACPInwardList() throws CustomException {

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageIndex(1);
		List<Object[]> objects = new ArrayList<Object[]>();
		Map<String, Object> map = buildPageInMaps(pageDetail);
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_COMMON_INWARD_LIST_WF).toString();
		when(repository.callStoredProcedure(procName, map)).thenReturn(objects);
		service.getAcpInwardList(pageDetail);

	}

	@Test
	void testGetACPOutwardList() throws CustomException {

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageIndex(1);
		List<Object[]> objects = new ArrayList<Object[]>();
		Map<String, Object> map = buildPageInMaps(pageDetail);
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_COMMON_OUTWARD_LIST_WF).toString();
		when(repository.callStoredProcedure(procName, map)).thenReturn(objects);
		service.getACPOutwardList(pageDetail);

	}

	private Map<String, Object> buildPageInMaps(PageDetails pageDetail) {
		Map<String, String> collect = getOutwardPvuSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(null, pageDetail, collect);
	}

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
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.SEARCH_FIELD_IN_POU_ID);
	}

	@Test
	void testgetPVUOfficeName() {
		IdDto idDto = new IdDto();
		idDto.setId(1L);
		Map<String, Object> map = new HashMap<>();
		map.put("eventId", idDto.getId());
		List<Object[]> objects = new ArrayList<Object[]>();
		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getACPPEmployeeOfficeId(), map)).thenReturn(objects);
		service.getPVUOfficeName(idDto);
	}

	@Test
	void testgetPVUOfficeName_Objects_Empty() {
		IdDto idDto = new IdDto();
		idDto.setId(1L);
		Map<String, Object> map = new HashMap<>();
		map.put("eventId", idDto.getId());
		List<Object[]> list = new ArrayList<Object[]>();
		Object[] objects = new Object[] { "Test" };
		list.add(objects);

		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getACPPEmployeeOfficeId(), map)).thenReturn(list);
		service.getPVUOfficeName(idDto);
	}

	@Test
	void testGetEventsReasons() throws CustomException {
		listEntities = new ArrayList<PVUMsReasonEntity>();
		when(msReasonRepository.findByReasonTypeAndActiveStatus("acpType", Constant.ACTIVE_STATUS))
				.thenReturn(listEntities);
		service.getAcpPayReasons();
	}

	@Test
	void testSixthPayComissionScale() throws CustomException {
		sixthPayCommissionList = new LinkedList<>();

		List<Object[]> objects = new ArrayList<Object[]>();
		PvusixthPayCommissionRequest sixthPayReq = new PvusixthPayCommissionRequest();
		sixthPayReq.setCommissionId("151");
		sixthPayReq.setDeptCategoryId("156");
		String sixthPayComm = "6";
		Map<String, Object> map = new HashMap<>();
		map.put("commisionId", sixthPayComm);
		map.put("deptId", sixthPayReq.getDeptCategoryId());
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		service.getSixthPayComissionScale(sixthPayReq);
	}

	@Test
	void testGetACPPrintEndorsement() throws CustomException {
		PageDetails pageDetail = new PageDetails();
		Map<String, Object> printEndorsementMap = new HashMap<String, Object>();
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF).toString();

		List<Object[]> objects = new ArrayList<Object[]>();
		when(repository.callStoredProcedure(procName, printEndorsementMap)).thenReturn(objects);
		service.getACPPrintEndorsement(pageDetail);

	}

//	@Test
	void testGetAcpEmployeeDetails() throws CustomException, ParseException {

		EDPLuLookUpInfoEntity edpLuLookUpInfoEntity = new EDPLuLookUpInfoEntity();
		edpLuLookUpInfoEntity.setLookUpInfoId(156L);

		PVUEmployeEventsEntity empEventEntity = new PVUEmployeEventsEntity();
		List<PVUEmployeEventsEntity> eventExists = new ArrayList<PVUEmployeEventsEntity>();
		eventExists.add(empEventEntity);

		PVUACPDetailRequest acpDetailReq = new PVUACPDetailRequest();
		acpDetailReq.setEmpNo(1000002033L);
		acpDetailReq.setAcpType(323L);
		acpDetailReq.setOfficeId(OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId());
		acpDetailReq.setPayCommission(152L);
		acpDetailReq.setPayScaleId(23L);
		acpDetailReq.setType(1L);
		acpDetailReq.setEmpNo(1000002033L);
		acpDetailReq.setEffectiveDate("2024-05-05");
		acpDetailReq.setIsViewPage(false);
		List<AcpEmployeeDetailDto> detailDtoList = new ArrayList<AcpEmployeeDetailDto>();
		AcpEmployeeDetailDto detailDto = new AcpEmployeeDetailDto();
		detailDto.setCellId("test");
		detailDto.setCellName("cellName");
		detailDto.setDateJoining("2017-05-05");
		detailDto.setEmployeeId("1272");
		detailDto.setIsSuspended(0L);
		detailDto.setOfficeId(OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId());
		detailDto.setPayCommId(151L);
		detailDto.setRetirementDate("2025-05-05");

		detailDtoList.add(detailDto);

		eventStrList.add("EOL");
		eventStrList.add("Suspension");

		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.ACP_EMPLOYEE_DETAIL);
		Map<String, Object> map = buildAcpEmployeeRequestMap(acpDetailReq);

		acpEmployeeDetailsDto.add(detailDto);

		PVUEmployeEntity employeeEntity = new PVUEmployeEntity();
		employeeEntity.setEmpId(1040L);

		map.put(PvuConstant.IN_EVENT_ID, String.valueOf(0));
		PVUEmployeDepartmentEntity deptEntity = new PVUEmployeDepartmentEntity();
		deptEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		deptEntity.setEmpType(edpLuLookUpInfoEntity);
		deptEntity.setEmpPayType(edpLuLookUpInfoEntity);
		deptEntity.setPvuEmployeEntity(employeeEntity);
		EDPMsDesignationEntity designationEntity = new EDPMsDesignationEntity();
		designationEntity.setDesignationId(857L);
		deptEntity.setDesignationId(designationEntity);
		deptEntity.setDateOfJoiningGOG(new Date());
		Optional<PVUEmployeDepartmentEntity> optionalDeptEntity = Optional.of(deptEntity);
		when(pvuEmployeeDepartmentRepo.findFirstByPvuEmployeEntityEmployeeCode(acpDetailReq.getEmpNo()))
				.thenReturn(optionalDeptEntity);
		when(repository.storeProc(procName.toString(), map, AcpEmployeeDetailDto.class)).thenReturn(detailDtoList);
		when(pvuEmployeeDepartmentRepo.findFirstByPvuEmployeEntityEmployeeCode(acpDetailReq.getEmpNo()))
				.thenReturn(optionalDeptEntity);
		when(employeEventsRepository.findAllByEmpIdAndEventDateBetweenAndEventNameIn(1L, LocalDateTime.now(),
				LocalDateTime.now(), eventStrList)).thenReturn(eventExists);
		List<Long> list = new ArrayList<Long>();
		list.add(3l);
		when(employeEventsRepository.findFirstByPVUEmployeEventsEntityByEmpIdAndEventIdAndActiveStatusAndPayCommission(
				1272l, list, 151L, Constant.ACTIVE_STATUS)).thenReturn(eventExists);
		doNothing().when(pvuEmployePayDetailService).validatePayCommision(1l, new Date(), 152l,
				new SimpleDateFormat("dd/MM/yyyy").parse("5/5/2017"));
		when(service.getAcpEmployeeDetails(acpDetailReq)).thenReturn(detailDto);
		assertNotNull(service.getAcpEmployeeDetails(acpDetailReq));
	}

	private Map<String, Object> buildAcpEmployeeRequestMap(PVUACPDetailRequest acpEmployeeRequest) {
		Map<String, Object> map = new HashMap<>();
		map.put("IN_PAGE_INDEX", String.valueOf(0));
		map.put("IN_PAGE_SIZE", String.valueOf(250));
		map.put(PvuConstant.IN_EFFECTIVE_DATE, acpEmployeeRequest.getEffectiveDate());
		map.put(PvuConstant.IN_EVENT_ID, String.valueOf(0));
		map.put(Constant.IN_EMPLOYEE_NO, acpEmployeeRequest.getEmpNo());
		map.put(PvuConstant.IN_OFFICE_ID, OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId().toString());
		map.put(PvuConstant.IN_PAY_COMM, acpEmployeeRequest.getPayCommission());
		map.put(PvuConstant.PVU_SEARCH_FIELD_VIEW_PAGE, acpEmployeeRequest.getIsViewPage());
		return map;
	}

	@Test
	public void testCheckEligibleForACP_NotEmpty() throws CustomException, ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat(PvuConstant.ACP_DATE_FORMAT);
		Date date = formatter.parse("2017-01-01");
		LocalDate joiningDate = PvuUtils.convertLocalDate(date);
		LocalDate effectiveDate = LocalDate.parse("2017-05-07");

		empEventEntity = new PVUEmployeEventsEntity();
		empEventEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		empEventEntity.setEventName("EOL");
		empEventEntity.setTrnNo("1234");

		empEventEntities = new ArrayList<PVUEmployeEventsEntity>();
		empEventEntities.add(empEventEntity);

		eventStrList.add("EOL");
		eventStrList.add("Suspension");

		LocalDateTime to = LocalDateTime.now();
		LocalDateTime from = LocalDateTime.now();
		when(employeEventsRepository.findAllByEmpIdAndEventDateBetweenAndEventNameIn(1L, to, from, eventStrList))
				.thenReturn(empEventEntities);
		when(eventsService.getEventListFromEffectiveAndToEffectiveEventsIn(1272L, joiningDate, effectiveDate,
				eventStrList)).thenReturn(empEventEntities);
		service.checkEligibleForACP(joiningDate, effectiveDate, 1272L);
	}

	@Test
	public void testCheckEligibleForACP_Empty() throws CustomException, ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat(PvuConstant.ACP_DATE_FORMAT);
		Date date = formatter.parse("2017-01-01");
		LocalDate joiningDate = PvuUtils.convertLocalDate(date);
		LocalDate effectiveDate = LocalDate.parse("2017-05-07");
		empEventEntity = new PVUEmployeEventsEntity();
		empEventEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		empEventEntity.setEventName(PvuConstant.EVENT_CODE_SUSPENSION);
		empEventEntity.setEventName(PvuConstant.EVENT_CODE_EOL);
		empEventEntities = new ArrayList<PVUEmployeEventsEntity>();
		when(eventsService.getEventListFromEffectiveAndToEffectiveEventsIn(1272L, joiningDate, effectiveDate,
				eventStrList)).thenReturn(empEventEntities);
		service.checkEligibleForACP(joiningDate, effectiveDate, 1272L);
	}

	@Test
	public void testAuthorizedRop() {
		map.put("IN_TRN_NO", 1L);
		List<Object[]> list = new ArrayList<Object[]>();
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF);
		repository.callStoredProcedure(procName.toString(), map);
		when(repository.callStoredProcedure(procName.toString(), map)).thenReturn(list);
		service.authorizeBackdateSP(1L);
	}

	@Test
	public void testGetPrintEndorsementHistory() throws CustomException {

		map.put("trnId", 1L);
		map.put("eventId", PvuConstant.ACP_PAY_PVU_EVENT_ID);

		List<Object[]> objects = new ArrayList<Object[]>();
		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getCommonEndorsementHistory(), map))
				.thenReturn(objects);
		service.getPrintEndorsementHistory(1L);
	}

	@Test
	public void testAuthorizeSPP() {

		map.put("IN_TRN_NO", 1L);
		List<Object[]> list = new ArrayList<Object[]>();
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF);
		repository.callStoredProcedure(procName.toString(), map);
		when(repository.callStoredProcedure(procName.toString(), map)).thenReturn(list);
		service.authorizeSPP(1L);
	}

	@Test
	void testSubmiAcpOutward() throws CustomException {

		outwordList = new ArrayList<PvuWFOutWardWrapperDto>();
		outWardDto = new PvuWFOutWardWrapperDto();
		outWardDto.setTrnId(1L);
		outWardDto.setStatus(Constant.RETURN);
		outwordList.add(outWardDto);

		doNothing().when(inwardService).setResetOutwardFlag(outwordList.get(0).getTrnId(), 1L);
		doNothing().when(inwardService).setConsignmentNumber(1L, 1L, "Test");

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
		entity.setAcpType(new EDPLuLookUpInfoEntity(123L));
		when(repository.findOneById(1L)).thenReturn(entity);
		when(pvuEmployeeEventStatusService.findByEmpId(1024L)).thenReturn(pvuEmployeeEventStatusEntity);
		service.submitACPOutward(outwordList);
	}

	@Test // TODO
	void testSubmiAcpOutward_Authorise() throws CustomException {

		entity = new PVUEmployeAssuredCareerProgressionEntity();
		outwordList = new ArrayList<PvuWFOutWardWrapperDto>();
		outWardDto = new PvuWFOutWardWrapperDto();
		outWardDto.setTrnId(1L);
		outWardDto.setStatus(Constant.AUTHORIZE);
		outwordList.add(outWardDto);

		doNothing().when(inwardService).setResetOutwardFlag(outwordList.get(0).getTrnId(), 1L);
		doNothing().when(inwardService).setConsignmentNumber(1L, 1L, "Test");

		eventStatusEntityForTrn = new PVUEmployeeEventStatusEntity();
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntity = Optional.of(eventStatusEntityForTrn);
		employeeEntity = new PVUEmployeEntity();
		employeeEntity.setEmpId(1024L);
		employeeEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		eventStatusEntity.setEmpId(employeeEntity);
		entity.setEmployeeNo(employeeEntity);
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
		when(pvuEmployeeEventStatusService.findByEmpId(1L)).thenReturn(pvuEmployeeEventStatusEntity);
		// repository.findOneById(id);
		when(repository.findOneById(1L)).thenReturn(entity);
		when(pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(eventStatusEntity))
				.thenReturn(eventStatusEntity);
		PVUEmployeAssuredCareerProgressionEntity entity = new PVUEmployeAssuredCareerProgressionEntity();
		entity.setAcpType(new EDPLuLookUpInfoEntity(123L));
		entity.setEmployeeNo(employeeEntity);
		// when(repository.findOneById(1L)).thenReturn(entity);
		when(pvuEmployeeEventStatusService.findByEmpId(entity.getEmployeeNo().getEmpId()))
				.thenReturn(pvuEmployeeEventStatusEntity);
		service.submitACPOutward(outwordList);
	}

	@Test
	public void testSubmitACPOutward_pvuEmployeeEventStatusEntity_Present() throws CustomException {

		outwordList = new ArrayList<PvuWFOutWardWrapperDto>();
		outWardDto = new PvuWFOutWardWrapperDto();
		outWardDto.setTrnId(1L);
		outwordList.add(outWardDto);

		Long id = 1L;
		PvuWFWrapperDto wrapperObj = new PvuWFWrapperDto();
		wrapperObj.setActiveStatus(Constant.ACTIVE_STATUS);
		wrapperObj.setTrnId(1L);
		List<PvuWFWrapperDto> wrapperDto = new ArrayList<PvuWFWrapperDto>();
		wrapperDto.add(wrapperObj);
		when(pvuFacade.callWorkFlowApis(wrapperDto)).thenReturn(false);
		PVUEmployeAssuredCareerProgressionEntity entity = new PVUEmployeAssuredCareerProgressionEntity();
		entity.setAcpType(new EDPLuLookUpInfoEntity(123L));
		PVUEmployeEntity empEntity = new PVUEmployeEntity();
		empEntity.setEmpId(1024L);
		entity.setEmployeeNo(empEntity);
		when(repository.findOneById(id)).thenReturn(entity);
		eventStatusEntity = new PVUEmployeeEventStatusEntity();
		Optional<PVUEmployeeEventStatusEntity> empEventStatusEntityList = Optional.of(eventStatusEntity);
		when(pvuEmployeeEventStatusService.findByEmpId(id)).thenReturn(empEventStatusEntityList);
		service.submitACPOutward(outwordList);
	}

	@Test
	void testGetPVUResponse() throws CustomException, ParseException {

		IdNameDto idNameDto = new IdNameDto();
		PVUEmployeEntity empEntity = new PVUEmployeEntity();
		IdDto dto = new IdDto();
		dto.setId(1L);
		entity = new PVUEmployeAssuredCareerProgressionEntity();
		entity.setCurrentDetailsEventId(1L);
		when(repository.findOneById(1L)).thenReturn(entity);

		PVUEmployeEventsEntity empEventEntity = new PVUEmployeEventsEntity();
		empEventEntity.setPayCommission(152L);
		empEventEntity.setCellId(12L);
		empEventEntity.setEmpPaylevel(123L);

		pvuCommonApiDto = new PVUCommonApiDto();
		when(employeEventsRepository.getOne(1L)).thenReturn(empEventEntity);
		when(cellRepository.getOnlyIdAndName(1L)).thenReturn(idNameDto);
		when(levelRepository.getOnlyIdAndName(1L)).thenReturn(idNameDto);
		when(empRepo.getOne(1L)).thenReturn(empEntity);
		when(categoryRepository.getOnlyIdAndName(1L)).thenReturn(idNameDto);
		when(edpLuLookUpInfoRepository.getOnlyIdAndName(1L)).thenReturn(idNameDto);
		when(designationRepository.getOnlyIdAndName(1L)).thenReturn(idNameDto);
		when(departmentRepository.getDateOfJoiningGOGAndDateOfRetirement(1L)).thenReturn(departmentQueryDto);
		when(eventsService.getCommonApiResponse(1L)).thenReturn(pvuCommonApiDto);
		service.getPVUResponse(dto);
	}

	@Test
	void testUpdateAcpRemarks_ReturnReasons_Empty() throws CustomException {

		EDPLuLookUpInfoEntity edpLuLookUpInfoEntity = new EDPLuLookUpInfoEntity();
		edpLuLookUpInfoEntity.setLookUpInfoId(1L);

		List<PVURopRemarksDto> list = new ArrayList<PVURopRemarksDto>();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setApproveDate(LocalDateTime.now());
		entity.setAuditorRemarks("auditorRemarks");
		entity.setAuditorReturnReason(1L);
		entity.setAuthorizeBy(1L);
		entity.setAuthorizeDate(LocalDateTime.now());
		entity.setAuthorizerRemark("authoriseRemarks");
		entity.setBasicPay(1L);
		entity.setBenEffDate(new Date());
   //	entity.setcClass(new EDPLuLookUpInfoEntity(1L));
		entity.setPrintReturnReason("return remarks");
		entity.setTrnNo("104");
		entity.setStatusId(edpLuLookUpInfoEntity);

		progressionDto = new PVUEmployeAssuredCareerProgressionDto();
		progressionDto.setId(1L);

		PVUEmployeAssuredCareerProgressionDto progressionDto = new PVUEmployeAssuredCareerProgressionDto();
		progressionDto.setReturnReasons(list);

		when(repository.findOneById(progressionDto.getId())).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(progressionDto);
		when(converter.updateACPRemarks(progressionDto, progressionDto)).thenReturn(progressionDto);
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.STATUS_ID, Constant.ACTIVE_STATUS, Constant.SAVE_AS_DRAFT)).thenReturn(edpLuLookUpInfoEntity);
		when(converter.toEntity(progressionDto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		service.updateAcpRemarks(progressionDto);
	}

}
