package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.converter.PVUEmployeHigherPayScaleEventConverter;
import gov.ifms.pvu.dto.PVUEmployeHigherPayScaleEventDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVUEmployeHigherPayScaleEventEntity;
import gov.ifms.pvu.entity.PVUMsReasonEntity;
import gov.ifms.pvu.repository.PVUEmployeHigherPayScaleEventRepository;
import gov.ifms.pvu.repository.PVUEventRemarksRepository;
import gov.ifms.pvu.repository.PVUMsEventRepository;
import gov.ifms.pvu.repository.PVUMsReasonRepository;
import gov.ifms.pvu.service.PVUEmployeHigherPayScaleEventServiceImpl;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;

class PVUEmployeHigherPayScaleEventServiceImplTest {

	@InjectMocks
	private PVUEmployeHigherPayScaleEventServiceImpl service;
	
	@Mock
	private PageDetails pageDetails;
	
	@Mock
	private PVUEventRemarksRepository remarksRepository;

	@Mock
	private PVUEmployeHigherPayScaleEventRepository repository;

	@Mock
	private PVUEmployeHigherPayScaleEventConverter converter;

	@Mock
	private PVUEmployeHigherPayScaleEventEntity entity;

	@Mock
	private PVUEmployeHigherPayScaleEventDto dto;
	@Mock
	Page<PVUEmployeHigherPayScaleEventEntity> page;

	@Mock
	List<PVUEmployeHigherPayScaleEventEntity> lst;
	@Mock
	PVUPrintEndorsementDto pvuPrintEndorsementDto;

	@Mock
	List<PVUEmployeHigherPayScaleEventDto> list;
	@Mock
	PvuPrintStickerReportDto printStickerReportDto;
	@Mock
	PVUStickerDTO pvuStickerDTO;
	@Mock
	private PVYFacade pvuFacade;
	@Mock
	private WfRepository wfRepository;
	@Mock
	private PVUMsEventRepository msRepository;

	@Mock
	private PVUMsReasonRepository msReasonRepository;
	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;

	@Mock
	List<PVUMsReasonEntity> listEntities;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetEmployeHigherPayScaleEvent() {
		when(repository.findOneById(1L)).thenReturn(entity);
		assertEquals(entity, service.getEmployeHigherPayScaleEvent(1L));
		verify(repository, times(1)).findOneById(1L);

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

		service.generateOutWardNumber(dtos);
	}

	@Test
	void testGetHigherPayById() {
		Long id = 1L;
		PVUEmployeHigherPayScaleEventEntity employeHigherPayScaleEventEntity = new PVUEmployeHigherPayScaleEventEntity();
		when(repository.findOneById(id)).thenReturn(employeHigherPayScaleEventEntity);
		assertNotNull(service.getEmployeHigherPayScaleEvent(id));
	}

	@Test
	void testSubmitHigherpayInward() throws CustomException {
		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		List<PvuWFWrapperDto> listWrapperDto = new ArrayList<PvuWFWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus("printed");
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);
		assertNotNull(when(pvuFacade.callWorkFlowApis(listWrapperDto)).thenReturn(true));
		service.submiHigherPayInward(listWrapperDto);
	}

	@Test
	void testSubmitHPSDistributor() throws CustomException {
		PvuWFWrapperDto wrapperObj = new PvuWFWrapperDto();
		wrapperObj.setActiveStatus(Constant.ACTIVE_STATUS);
		List<PvuWFWrapperDto> wrapperDto = new ArrayList<PvuWFWrapperDto>();
		wrapperDto.add(wrapperObj);

		assertNotNull(pvuFacade.callWorkFlowApis(wrapperDto));
		service.submitHigherpayDistributor(wrapperDto);

	}

	@Test
	void testInsertHPSRemarks_ObjAvailable() throws CustomException{
		List<Object[]> objects = new ArrayList<Object[]>();
		Long transId = 1L;
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.INSERT_IN_HPS_EVNT_ITRS);
		when(repository.callStoredProcedure(procName.toString(), map)).thenReturn(objects);
		service.insertHigherPayRemarks(transId);
		assertNotNull(service.getHPGPrintEndorsementList(pageDetails));
	}

	@Test
	void testAuthorizedHPS_ObjAvailable()  throws CustomException{
		List<Object[]> objects = new ArrayList<Object[]>();
		Long transId = 1L;
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		StringBuilder procName = new StringBuilder();
		procName.append(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF);
		when(repository.callStoredProcedure(procName.toString(), map)).thenReturn(objects);
		service.authorizeHPS(transId);
		assertNotNull(service.getHPGPrintEndorsementList(pageDetails));
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
		assertNotNull(service.pvuOfficeEmployeeSearch(pageDetail));

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
	void testGetHPSDDOList() throws CustomException { // NO SONAR

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageIndex(1);
		List<Object[]> objects = new ArrayList<Object[]>();
		Map<String, String> collect = this.getDdoWFListingSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		Map<String, Object> stringObjectMap = SearchParam.buildPageInMap(null, pageDetail, collect);
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ACP_PVU_EVENT_LIST_SRCH_WF));
		when(repository.callStoredProcedure(sp, stringObjectMap)).thenReturn(objects);
		assertNotNull(service.ddoWFListing(pageDetail));
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
	void testGetHPSInwardList() throws CustomException {

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageIndex(1);
		List<Object[]> objects = new ArrayList<Object[]>();
		Map<String, Object> map = buildPageInMapInwardList(pageDetail);
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_COMMON_INWARD_LIST_WF).toString();
		when(repository.callStoredProcedure(procName, map)).thenReturn(objects);
		assertNotNull(service.getHigherPayInwardList(pageDetail));

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
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS, PVUSearchEnum.SEARCH_FIELD_IN_POU_ID);

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
		assertNotNull(service.getHPSOutWardList(pageDetail));

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
	void testGetHPSPrintEndorsement() throws CustomException {
		PageDetails pageDetail = new PageDetails();
		Map<String, Object> printEndorsementMap = new HashMap<String, Object>();
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_COMMON_PVU_PRINT_ENDORSEMENT_LIST_WF).toString();

		List<Object[]> objects = new ArrayList<Object[]>();
		when(repository.callStoredProcedure(procName, printEndorsementMap)).thenReturn(objects);
		assertNotNull(service.getHPGPrintEndorsementList(pageDetail));

	}

	@Test
	void testgetPVUOfficeName() {
		IdDto idDto = new IdDto();
		idDto.setId(1L);
		Map<String, Object> map = new HashMap<>();
		assertNotNull(idDto);
		map.put("eventId", idDto.getId());
		List<Object[]> objects = new ArrayList<Object[]>();
		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getHPSEmployeeOfficeId(), map)).thenReturn(objects);
		service.getPVUOfficeName(idDto);
	}

}
