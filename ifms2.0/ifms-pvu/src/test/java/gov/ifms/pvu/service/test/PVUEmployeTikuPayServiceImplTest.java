package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.velocity.VelocityContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUEmployeTikuPayConverter;
import gov.ifms.pvu.converter.PVUPrintEndorsementItrConverter;
import gov.ifms.pvu.dto.PVUEmployeTikuPayCurrentDto;
import gov.ifms.pvu.dto.PVUEmployeTikuPayDto;
import gov.ifms.pvu.dto.PVUEmployeTikuPayPostDetailsDto;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUSourceUserDetails;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.PVUWfTableInfo;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.response.PVUTikuPayApiDto;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeTikuPayEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementItrEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVUEmployeTikuPayRepository;
import gov.ifms.pvu.repository.PVUInwardRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.repository.PVURevisionOfPayRemarkRepository;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeTikuPayServiceImpl;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.service.PVUEventRemarksService;
import gov.ifms.pvu.service.PVUMsReasonService;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;

class PVUEmployeTikuPayServiceImplTest {
	@InjectMocks
	private PVUEmployeTikuPayServiceImpl tikuPayServiceImpl;

	@Mock
	private PVUEmployeTikuPayRepository tikuPayrepository;

	@Mock
	private PVUEmployeTikuPayEntity tikuPayEntity;

	@Mock
	private PVUEmployeTikuPayDto tikuPaydto;

	@Mock
	private PVUEmployeTikuPayCurrentDto tikuPayCurrentDto;

	@Mock
	private PVUEmployeTikuPayPostDetailsDto tikuPayPostDetailsDto;

	@Mock
	private PVUEmployeTikuPayConverter tikuPayconverter;

	@Mock
	private EDPLuLookUpInfoRepository edpLookupinforepository;

	@Mock
	private PVYFacade pvuFacade;

	@Mock
	private List<PvuWFWrapperDto> wrapperDto;

	@Mock
	private PVUEmployeeEventStatusService statusService;

	@Mock
	private PVUEmployeeEventStatusEntity statusEntity;

	@Mock
	private EDPLuLookUpInfoEntity luEntity;

	@Mock
	private PVUEmployeEventsEntity employeEventsEntity;

	@Mock
	private PVUEmployeEventsService pvuEmployeEventsService;

	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;

	@Mock
	private PVUEmployeDepartmentEntity department;

	@Mock
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	@Mock
	private PVUEmployeEntity employeEntity;

	@Mock
	private EDPMsDesignationEntity edpMsDesignationEntity;

	@Mock
	private PVUCommonService pvuCommonService;

	@Mock
	private PageDetails pageDetails;
	@Mock
	private WfRepository wfRepository;
	@Mock
	List<IdDto> listDto;
	@Mock
	List<PvuWFWrapperDto> pvuWFWrapperDtos;
	@Mock
	private IdDto idDto;
	@Mock
	private PVUEventRemarksService eventRemarksService;
	@Mock
	private GenericDao genericDao;
	@Mock
	private VelocityContext velocityContext;
	@Mock
	PvuWFOutWardWrapperDto wfOutWardWrapperDto;
	@Mock
	
	private PVUMsReasonService pvuMsReasonService;
	@Mock
	PVUEmployeeEventStatusEntity employeeEventStatusEntity;
	@Mock
	PVUPrintEndorsementEntity pvuPrintEndorsementEntity;
	@Mock
	PVUPrintEndorsementRepository pvuPrintEndorsementRepository;
	@Mock
	PVUPrintEndorsementDto pvuPrintEndorsementDto;
	@Mock
	PVUPrintEndorsementItrConverter pvuPrintEndorsementItrConverter;
	@Mock
	PVUPrintEndorsementItrEntity pvuPrintEndorsementItrEntity;
	@Mock
	PVUPrintEndorsementItrRepository pvuPrintEndorsementItrRepository;
	@Mock
	private PVUInwardRepository pvuInwardRepository;
	@Mock
	private PVURevisionOfPayRemarkRepository remarkRepository;
	@Mock
	private PVUStickerDTO stickerDTO;
	@Mock
	private Date date;
	@Mock
	private EDPMsOfficeEntity edpMsOfficeEntity;
	@Mock
	private EDPLuLookUpInfoEntity lookupEntity;

	@Mock
	private List<PVUTikuPayApiDto> pvuTikuPayApiDto;
	@Mock
	private PVUEmployeRepository pvumployeRepository;
	
	@Mock 
    private PVUEmployeDepartmentRepository pvuEmployeeDepartmentRepo;
	@Mock 
	private EDPMsDepartmentEntity edpMsDepartmentEntity;
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	@Mock 
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;
	@Mock
	private PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity;

	@Test
	void test_getEmployeeTikuPay() {
		tikuPayEntity.setId(1L);
		when(tikuPayrepository.getOne(1L)).thenReturn(tikuPayEntity);
		assertNotNull(tikuPayServiceImpl.getEmployeTikuPay(1L));
	}

	@Test
	void testgetLookUpInfoAsMap() throws CustomException {
		assertNotNull(tikuPayServiceImpl.getLookUpInfoAsMap("PVU_TIKUPAY_LOOKUP_SP"));
	}
	// Save
	// ITR

	@Test
	void testsaveOrUpdateEmployeTikuPay() throws CustomException {
		tikuPaydto.setStatusId(0L);
		tikuPaydto.setEmployeeNo(1L);
		when(tikuPayconverter.toEntity(tikuPaydto)).thenReturn(tikuPayEntity);
		when(edpLookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		when(tikuPayrepository.save(tikuPayEntity)).thenReturn(tikuPayEntity);
		when(tikuPayconverter.toDTO(tikuPayEntity)).thenReturn(tikuPaydto);
		when(tikuPayEntity.getEmployeeId()).thenReturn(employeEntity);
		when(statusService.inProgressSuspensionEvent(employeEntity.getEmpId())).thenReturn(pvuEmployeeEventStatusEntity);
		tikuPayServiceImpl.saveOrUpdateEmployeTikuPay(tikuPaydto);
	}

	@Test
	void testGetDDOListingSearchList() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(tikuPayServiceImpl.getTikuPayDDOList(pageDetail));
	}

	@Test
	void testGetSPInwardSearchList() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(tikuPayServiceImpl.getTikypayInwardList(pageDetail));
	}

	@Test
	void testGetSPAuditorSearchList() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(tikuPayServiceImpl.pvuAuditorList(pageDetail));
	}

	@Test
	void testGetSPOutwardList() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(tikuPayServiceImpl.getOutwardList(pageDetail));
	}

	@Test
	void test_submitSPOutward() throws CustomException {
		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		List<PvuWFWrapperDto> listWrapperDto = new ArrayList<PvuWFWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus("printed");
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		List<PvuWFOutWardWrapperDto> wrapperDtos = new ArrayList<PvuWFOutWardWrapperDto>();
		assertNotNull(tikuPayServiceImpl.submitOutward(wrapperDtos));
	}

	@Test
	void testGetSPPrintEndorsements() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<>();
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		assertNotNull(tikuPayServiceImpl.getPrintEndorsementsList(pageDetail));
	}

	@Test
	void test_getPvuOfficeReasonCode() {
		assertNotNull(pvuMsReasonService.getEventsReasons());
	}

	@Test
	void test_getWfRlCdByTikuPayTrnId() {
		when(this.wfRepository.findWfRlCdByTikuPayTrnId(1L, Constant.ACTIVE_STATUS)).thenReturn("STR");
		assertNotNull(tikuPayServiceImpl.getWfRoleCodeByTrnId(1L));
	}

	@Test
	void test_generateInwardNumber() throws CustomException {
		assertNotNull(tikuPayServiceImpl.generateInwardNumber(listDto));
	}

	@Test
	void test_getTikupayReasons() {
		List<PVUMsReasonDto> list = new ArrayList<>();
		when(tikuPayServiceImpl.getTikupayReasons()).thenReturn(list);
	}

	@Test
	void submiTikuPayInward() throws CustomException {
		assertNotNull(tikuPayServiceImpl.submiTikuPayInward(pvuWFWrapperDtos));
	}

	@Test
	void test_submitTikupayDistributor() throws CustomException {
		assertNotNull(tikuPayServiceImpl.submitTikupayDistributor(pvuWFWrapperDtos));
	}

	@Test
	void test_getPVUOfficeName() {
		String officeName = "pqr";
		IdDto idDto = new IdDto();
		idDto.setId(1L);
		Map<String, Object> map = new HashMap<>();
		map.put("eventId", idDto.getId());
		List<Object[]> lstObjects = new ArrayList<>();
		Object[] objectArray = new Object[1];
		objectArray[0] = officeName;
		lstObjects.add(objectArray);
		when(tikuPayrepository.executeSQLQuery(PVUNativeSqlQueryConstant.getTikuPayEmpOfficeId(), map))
				.thenReturn(lstObjects);
		EDPMsOfficeDto dto = tikuPayServiceImpl.getTikuPayEmpOfficeName(idDto);
		assertEquals(dto.getOfficeName(), officeName);
	}

	@Test
	void test_deleteTikuPayNotNull() throws CustomException {
		IdDto idDto = new IdDto(Constant.LONG_ONE_VALUE);
		Date updatedDate = new Date();
		tikuPayEntity.setStatus(luEntity);
		when(tikuPayEntity.getStatus()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(Constant.SAVE_AS_DRAFT_STATUS_ID);
		when(tikuPayrepository.findById(1l)).thenReturn(Optional.of(tikuPayEntity));
		when(edpLookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		doNothing().when(tikuPayrepository).deleteTikuPayEventIdBy(Constant.IN_ACTIVE_STATUS, idDto.getId(), Constant.LONG_ONE_VALUE, updatedDate);
		when(tikuPayEntity.getEmployeeId()).thenReturn(employeEntity);
		when(employeEntity.getEmpId()).thenReturn(1l);
		doNothing().when(pvuEmployeeEventStatusService).resetInProgressEmployeeEventStatus(Constant.LONG_ONE_VALUE,Constant.LONG_ONE_VALUE);
		assertTrue(tikuPayServiceImpl.deleteTikuPayEventById(idDto));
	}
	@Test
	void test_deleteTikuPayNull() throws CustomException {
		Optional<PVUEmployeTikuPayEntity> tikuPayEntity = null;
		when(tikuPayrepository.findById(1L)).thenReturn(tikuPayEntity);
		assertFalse(tikuPayServiceImpl.deleteTikuPayEventById(idDto));
	}
	
	
	@Test
	void testSubmitPEWFNotNull() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		PVUPrintEndorsementEntity printEntity = new PVUPrintEndorsementEntity();
		printEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		printEntity.setPrintCnt(Constant.LONG_ONE_VALUE);

		when(pvuPrintEndorsementDto.getId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);

		PvuPrintStickerReportDto dto = new PvuPrintStickerReportDto();
		dto.setPvuWFWrapperDto(pvuWFWrapperDto);
		dto.setPrintEndorsementDto(pvuPrintEndorsementDto);

		when(pvuPrintEndorsementRepository.findByIdAndActiveStatus(Constant.LONG_ONE_VALUE, Constant.ACTIVE_STATUS))
				.thenReturn(printEntity);
		when(tikuPayconverter.toPrintEntity(pvuPrintEndorsementDto)).thenReturn(printEntity);
		when(pvuPrintEndorsementRepository.save(printEntity)).thenReturn(printEntity);
		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrEntity))
				.thenReturn(pvuPrintEndorsementItrEntity);
		when(tikuPayconverter.toPrintDTO(printEntity)).thenReturn(pvuPrintEndorsementDto);
		assertNotNull(tikuPayServiceImpl.submitPEWF(dto));

	}

	@Test
	void testSubmitPEWFNull() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		PVUPrintEndorsementEntity printEntity = new PVUPrintEndorsementEntity();
		printEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		printEntity.setPrintCnt(Constant.LONG_ONE_VALUE);

		when(pvuPrintEndorsementDto.getId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getPrintCnt()).thenReturn(Constant.LONG_ONE_VALUE);

		PvuPrintStickerReportDto dto = new PvuPrintStickerReportDto();
		dto.setPvuWFWrapperDto(pvuWFWrapperDto);
		dto.setPrintEndorsementDto(pvuPrintEndorsementDto);

		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		doNothing().when(pvuInwardRepository).updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
				PvuConstant.TIKU_PAY_EVENT_ID, 1L, Constant.OUTWARD_FLAG_ONE, Constant.ACTIVE_STATUS);
		when(pvuPrintEndorsementRepository.findByIdAndActiveStatus(Constant.LONG_ONE_VALUE, Constant.ACTIVE_STATUS))
				.thenReturn(null);
		when(tikuPayconverter.toPrintEntity(pvuPrintEndorsementDto)).thenReturn(printEntity);
		when(pvuPrintEndorsementRepository.save(printEntity)).thenReturn(printEntity);
		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrEntity))
				.thenReturn(pvuPrintEndorsementItrEntity);
		when(tikuPayconverter.toPrintDTO(printEntity)).thenReturn(pvuPrintEndorsementDto);
		assertNotNull(tikuPayServiceImpl.submitPEWF(dto));
	}

	@Test
	void testProcessAuthorizedOutWardsEmpty() {
		List<PvuWFOutWardWrapperDto> dtos = new ArrayList<PvuWFOutWardWrapperDto>();
		tikuPayServiceImpl.processAuthorizedOutWards(dtos);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testProcessAuthorizedOutWardsTikuPay1() {
		PvuWFOutWardWrapperDto pvuWFWrapperDto = new PvuWFOutWardWrapperDto();
		pvuWFWrapperDto.setWfStatus(Constant.APPROVED);
		pvuWFWrapperDto.setTrnId(1l);
		pvuWFWrapperDto.setUpdatedDate(new Date());
		pvuWFWrapperDto.setEventId(12L);
		List<PvuWFOutWardWrapperDto> dtos = new ArrayList<PvuWFOutWardWrapperDto>();
		dtos.add(pvuWFWrapperDto);

		PVUEmployeTikuPayEntity tk = new PVUEmployeTikuPayEntity();
		tk.setActiveStatus(1);
		tk.setPayCommId(luEntity);
		tk.setEmployeeId(employeEntity);

		PVUEmployeTikuPayDto tikuPayDto = new PVUEmployeTikuPayDto();
		tikuPayDto.setId(1L);
		tikuPayDto.setWfRoleId(1L);
		tikuPayDto.setTikuPay1(LocalDate.now());
		tikuPayDto.setAuditorReturnReason(Constant.RETURN_VAL);
		tikuPayDto.setTikuType(PvuConstant.TIKU_PAY_ONE);

		pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
				PvuConstant.TIKU_PAY_EVENT_ID, 1L, Constant.OUTWARD_FLAG_ONE, Constant.ACTIVE_STATUS);

		when(tikuPayrepository.getOne(pvuWFWrapperDto.getTrnId())).thenReturn(tk);
		when(tikuPayconverter.toDTO(tk)).thenReturn(tikuPayDto);
		when(tikuPayrepository.save(tk)).thenReturn(tk);

		when(pvuFacade.callWorkFlowApis(PvuWFOutWardWrapperDto.createSuper(dtos))).thenReturn(true);

		tikuPayServiceImpl.processAuthorizedOutWards(dtos);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testProcessAuthorizedOutWardsTikuPay2() {
		PvuWFOutWardWrapperDto pvuWFWrapperDto = new PvuWFOutWardWrapperDto();
		pvuWFWrapperDto.setWfStatus(Constant.APPROVED);
		pvuWFWrapperDto.setTrnId(1l);
		pvuWFWrapperDto.setUpdatedDate(new Date());
		pvuWFWrapperDto.setEventId(12L);
		List<PvuWFOutWardWrapperDto> dtos = new ArrayList<PvuWFOutWardWrapperDto>();
		dtos.add(pvuWFWrapperDto);

		PVUEmployeTikuPayEntity tk = new PVUEmployeTikuPayEntity();
		tk.setActiveStatus(1);
		tk.setPayCommId(luEntity);
		tk.setEmployeeId(employeEntity);

		PVUEmployeTikuPayDto tikuPayDto = new PVUEmployeTikuPayDto();
		tikuPayDto.setId(1L);
		tikuPayDto.setWfRoleId(1L);
		tikuPayDto.setTikuPay1(LocalDate.now());
		tikuPayDto.setAuditorReturnReason(Constant.RETURN_VAL);
		tikuPayDto.setTikuType(PvuConstant.TIKU_PAY_TWO);

		pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
				PvuConstant.TIKU_PAY_EVENT_ID, 1L, Constant.OUTWARD_FLAG_ONE, Constant.ACTIVE_STATUS);

		when(tikuPayrepository.getOne(pvuWFWrapperDto.getTrnId())).thenReturn(tk);
		when(tikuPayconverter.toDTO(tk)).thenReturn(tikuPayDto);
		when(tikuPayrepository.save(tk)).thenReturn(tk);

		when(pvuFacade.callWorkFlowApis(PvuWFOutWardWrapperDto.createSuper(dtos))).thenReturn(true);

		tikuPayServiceImpl.processAuthorizedOutWards(dtos);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testAuthorizeTP() {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(tikuPayrepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		tikuPayServiceImpl.authorize(Constant.LONG_ONE_VALUE);
		verify(tikuPayrepository, times(1)).callStoredProcedure(Mockito.anyString(), Mockito.anyMap());
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testInsertAutoIncr() {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(tikuPayrepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		tikuPayServiceImpl.insertAutoIncr(Constant.APPROVAL_IN_PROGESS);
		verify(tikuPayrepository, times(1)).callStoredProcedure(Mockito.anyString(), Mockito.anyMap());
		assertTrue(Boolean.TRUE);
	}

	@Test
	void test_ProcessReturnOutWards() throws CustomException {
		PvuWFOutWardWrapperDto wrapperDto = new PvuWFOutWardWrapperDto();
		wrapperDto.setStatus(null);
		wrapperDto.setTrnId(6L);
		List<PvuWFOutWardWrapperDto> dtos = new ArrayList<>();
		dtos.add(wrapperDto);
		String officeName = "abc";

		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.MENU_ID, dtos.get(0).getMenuId());
		map.put(PvuConstant.EVENT_ID, PvuConstant.EVENT_ID_STEPPIN_UP);
		map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);

		List<Object[]> objects = new ArrayList<Object[]>();
		Object objectArray[] = new Object[1];
		objectArray[0] = officeName;
		objects.add(objectArray);

		List<PvuWFWrapperDto> returnList = new ArrayList<PvuWFWrapperDto>();
		returnList.add(wrapperDto);

		when(tikuPayrepository.executeSQLQuery(PVUNativeSqlQueryConstant.getWfTable(), map)).thenReturn(objects);
		assertNotNull(objects);
		when(pvuFacade.callWorkFlowApis(returnList)).thenReturn(true);

		tikuPayServiceImpl.processReturnOutWards(dtos);
	}

	@Test
	void testSetDDOApprover() throws CustomException {
		PvuWFOutWardWrapperDto wrapperDto = new PvuWFOutWardWrapperDto();
		wrapperDto.setStatus(null);
		wrapperDto.setTrnId(6L);
		List<PvuWFOutWardWrapperDto> dtos = new ArrayList<>();
		dtos.add(wrapperDto);
		String officeName = "abc";
		List<Object[]> objects = new ArrayList<Object[]>();
		Object objectArray[] = new Object[1];
		objectArray[0] = officeName;
		objects.add(objectArray);

		List<PvuWFWrapperDto> returnList = new ArrayList<PvuWFWrapperDto>();
		returnList.add(wrapperDto);

		PVUWfTableInfo ti = new PVUWfTableInfo();
		ti.setSchemaName("x");
		ti.setTableName("st");

		List<PVUWfTableInfo> tableList = new ArrayList<PVUWfTableInfo>();
		tableList.add(ti);

		PVUSourceUserDetails user = new PVUSourceUserDetails();
		user.setAssignByOfficeId(2L);
		user.setAssignByPostId(1L);
		user.setAssignByPouId(1L);
		user.setAssignByUserId(1L);
		List<PVUSourceUserDetails> userList = new ArrayList<PVUSourceUserDetails>();
		userList.add(user);

		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put(PvuConstant.TRN_ID, 12L);

		when(tikuPayrepository.executeSQLQuery(PVUNativeSqlQueryConstant
				.getWfSourceUserDetail(tableList.get(0).getSchemaName(), tableList.get(0).getTableName()), returnMap))
						.thenReturn(objects);
		assertNotNull(objects);
		assertNotNull(tikuPayServiceImpl.setDDOApprover(dtos, tableList));
	}

	@Test
	public void testGetPrintEndorsementHistoryNotEmpty() throws CustomException {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(tikuPayrepository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(tikuPayServiceImpl.getPrintEndorsementHistory(Constant.LONG_ONE_VALUE));
	}

	@Test
	public void testGetPrintEndorsementHistoryEmpty() throws CustomException {
		when(tikuPayrepository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(Collections.emptyList());
		assertNotNull(tikuPayServiceImpl.getPrintEndorsementHistory(Constant.LONG_ONE_VALUE));
	}

	@Test
	void testInsertITR() throws CustomException {
		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		wrapperDto.setActiveStatus(1);
		wrapperDto.setAssignByActionLevel(1);

		Map<String, Object> map = new LinkedHashMap<>();
		map.put("IN_TRN_ID", wrapperDto.getTrnId());
		map.put("IN_WORKFLOW_ID", wrapperDto.getCurrentWorkflowId());
		String procName = "test";
		assertNotNull(tikuPayrepository.callStoredProcedure(procName, map));
		tikuPayServiceImpl.insertITR(wrapperDto);
	}

	@Test
	void testUpdateStatus() throws CustomException {
		when(luEntity.getLookUpInfoId()).thenReturn(1L);
		assertEquals(1L, luEntity.getLookUpInfoId());
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1L);
		tikuPayrepository.updateStatusId(luEntity.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), new Date());
		tikuPayServiceImpl.updateStatus(pvuWFWrapperDto, new Date(), luEntity);
	}

	@Test
	void testWorkflowStatusUpdate4() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(6L);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("NOA");
		assertEquals("NOA", pvuWFWrapperDto.getWfStatus());

		when(pvuWFWrapperDto.getTrnStatus()).thenReturn(Constant.FORWARD_TO_PVU);
		assertEquals("Forwarded to PVU", pvuWFWrapperDto.getTrnStatus());
		tikuPayServiceImpl.insertInwardTable(pvuWFWrapperDto);
		tikuPayServiceImpl.workflowStatusUpdate(pvuWFWrapperDto, date, tikuPayEntity);
	}

	@Test
	void testInsertRemarksItr() throws CustomException {
		Long val = 74L;
		when(pvuWFWrapperDto.getAssignByWfRoleId()).thenReturn(74L);
		assertEquals(val, pvuWFWrapperDto.getAssignByWfRoleId());
		when(pvuWFWrapperDto.getTrnId()).thenReturn(7L);
		tikuPayServiceImpl.insertTikuPayRemarksITR(pvuWFWrapperDto.getTrnId());
		tikuPayServiceImpl.insertRemarksITRInAuditorVerifierClassIandClassII(pvuWFWrapperDto);
	}

	@Test
	public void testSubmitPrintHistory() throws CustomException {

		when(pvuWFWrapperDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		PVUPrintEndorsementEntity printEntity = new PVUPrintEndorsementEntity();
		printEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		printEntity.setPrintCnt(Constant.LONG_ONE_VALUE);

		when(pvuPrintEndorsementDto.getId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getPrintDate()).thenReturn(new Date());
		when(pvuPrintEndorsementDto.getReprintDate()).thenReturn(new Date());
		when(pvuPrintEndorsementDto.getPrintCnt()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getRemark()).thenReturn(Constant.ROP);

		PvuPrintStickerReportDto dto = new PvuPrintStickerReportDto();

		dto.setStickerDTO(stickerDTO);
		dto.setPvuWFWrapperDto(pvuWFWrapperDto);
		dto.setPrintEndorsementDto(pvuPrintEndorsementDto);

		when(pvuPrintEndorsementRepository.findByIdAndActiveStatus(Constant.LONG_ONE_VALUE, Constant.ACTIVE_STATUS))
				.thenReturn(printEntity);
		when(tikuPayconverter.toPrintEntity(pvuPrintEndorsementDto)).thenReturn(printEntity);
		when(pvuPrintEndorsementRepository.save(printEntity)).thenReturn(printEntity);
		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrEntity))
				.thenReturn(pvuPrintEndorsementItrEntity);
		when(tikuPayconverter.toPrintDTO(printEntity)).thenReturn(pvuPrintEndorsementDto);

		assertNotNull(tikuPayServiceImpl.submitPrintHistory(dto));
	}

	@Test
	public void getPrintTemplate() {
		when(tikuPayEntity.getPayCommId()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
		assertNotNull(tikuPayServiceImpl.getPrintTemplate(tikuPayEntity));
	}

	@Test
	void testGetReturnReasonByTransactionIdNotEmpty() throws CustomException {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(remarkRepository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(tikuPayServiceImpl.getReturnReasonByTransactionId(Constant.LONG_ONE_VALUE));
	}

	@Test
	void testGetReturnReasonByTransactionIdEmpty() throws CustomException {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(remarkRepository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(Collections.emptyList());
		assertNotNull(tikuPayServiceImpl.getReturnReasonByTransactionId(Constant.LONG_ONE_VALUE));
	}

	/*@Test
	void testGeneratePdf() throws CustomException {
		String html = "<h1>Hello</h1>";
		assertNotNull(tikuPayServiceImpl.generatePdf(html));
	}
	 */
	@Test
	void testGetPrintTemplate7Pay() throws CustomException {
		PVUEmployeTikuPayEntity tk = new PVUEmployeTikuPayEntity();
		tk.setActiveStatus(1);
		tk.setPayCommId(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(152L);

		assertNotNull(tikuPayServiceImpl.getPrintTemplate(tk));

	}

	@Test
	void testGetPrintTemplate6Pay() throws CustomException {
		PVUEmployeTikuPayEntity tk = new PVUEmployeTikuPayEntity();
		tk.setActiveStatus(1);
		tk.setPayCommId(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(151L);

		assertNotNull(tikuPayServiceImpl.getPrintTemplate(tk));

	}

	@Test
	void testGetPrintTemplate5Pay() throws CustomException {
		PVUEmployeTikuPayEntity tk = new PVUEmployeTikuPayEntity();
		tk.setActiveStatus(1);
		tk.setPayCommId(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(150L);

		assertNotNull(tikuPayServiceImpl.getPrintTemplate(tk));

	}

	@Test
	public void testGeneratePrintEndorsements() throws CustomException {
		List<PvuPrintStickerReportDto> dtos = new ArrayList<>();
		when(pvuWFWrapperDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		PVUPrintEndorsementEntity printEntity = new PVUPrintEndorsementEntity();
		printEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		printEntity.setPrintCnt(Constant.LONG_ONE_VALUE);

		when(pvuPrintEndorsementDto.getId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getPrintDate()).thenReturn(new Date());
		when(pvuPrintEndorsementDto.getReprintDate()).thenReturn(new Date());
		when(pvuPrintEndorsementDto.getPrintCnt()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getRemark()).thenReturn(Constant.ROP);

		PvuPrintStickerReportDto dto = new PvuPrintStickerReportDto();

		dto.setStickerDTO(stickerDTO);
		dto.setPvuWFWrapperDto(pvuWFWrapperDto);
		dto.setPrintEndorsementDto(pvuPrintEndorsementDto);
		dtos.add(dto);

		when(stickerDTO.getId()).thenReturn(Constant.LONG_ONE_VALUE);

		when(pvuPrintEndorsementRepository.findByIdAndActiveStatus(Constant.LONG_ONE_VALUE, Constant.ACTIVE_STATUS))
				.thenReturn(printEntity);
		when(tikuPayconverter.toPrintEntity(pvuPrintEndorsementDto)).thenReturn(printEntity);
		when(pvuPrintEndorsementRepository.save(printEntity)).thenReturn(printEntity);
		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrEntity))
				.thenReturn(pvuPrintEndorsementItrEntity);
		when(tikuPayconverter.toPrintDTO(printEntity)).thenReturn(pvuPrintEndorsementDto);
		when(tikuPayEntity.getPayCommId()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);

		when(tikuPayrepository.getOne(dto.getStickerDTO().getId())).thenReturn(tikuPayEntity);
		when(tikuPayconverter.toEntity(tikuPaydto)).thenReturn(tikuPayEntity);
		when(tikuPayconverter.toDTO(tikuPayEntity)).thenReturn(tikuPaydto);
		when(tikuPayconverter.populateVContext(stickerDTO, tikuPayEntity, tikuPaydto)).thenReturn(velocityContext);
		when(velocityContext.get("employeeName")).thenReturn("EMP");

		// assertNotNull(tikuPayServiceImpl.generatePrintEndorsement(dtos));
	}

	@Test
	public void testGeneratePrintEndorsement() throws CustomException, ParseException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		PVUPrintEndorsementEntity printEntity = new PVUPrintEndorsementEntity();
		printEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		printEntity.setPrintCnt(Constant.LONG_ONE_VALUE);

		when(pvuPrintEndorsementDto.getId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getPrintDate()).thenReturn(new Date());
		when(pvuPrintEndorsementDto.getReprintDate()).thenReturn(new Date());
		when(pvuPrintEndorsementDto.getPrintCnt()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementDto.getRemark()).thenReturn(Constant.ROP);

		PvuPrintStickerReportDto dto = new PvuPrintStickerReportDto();
		dto.setStickerDTO(stickerDTO);
		dto.setPvuWFWrapperDto(pvuWFWrapperDto);
		dto.setPrintEndorsementDto(pvuPrintEndorsementDto);

		when(stickerDTO.getId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuPrintEndorsementRepository.findByIdAndActiveStatus(Constant.LONG_ONE_VALUE, Constant.ACTIVE_STATUS))
				.thenReturn(printEntity);
		when(tikuPayconverter.toPrintEntity(pvuPrintEndorsementDto)).thenReturn(printEntity);
		when(pvuPrintEndorsementRepository.save(printEntity)).thenReturn(printEntity);
		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrEntity))
				.thenReturn(pvuPrintEndorsementItrEntity);
		when(tikuPayconverter.toPrintDTO(printEntity)).thenReturn(pvuPrintEndorsementDto);
		when(tikuPayEntity.getPayCommId()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);

		when(tikuPayrepository.getOne(dto.getStickerDTO().getId())).thenReturn(tikuPayEntity);
		when(tikuPayconverter.toEntity(tikuPaydto)).thenReturn(tikuPayEntity);
		when(tikuPayconverter.toDTO(tikuPayEntity)).thenReturn(tikuPaydto);
		when(tikuPayconverter.populateVContext(stickerDTO, tikuPayEntity, tikuPaydto)).thenReturn(velocityContext);
		when(velocityContext.get("employeeName")).thenReturn("EMP");

		// assertNotNull(tikuPayServiceImpl.generatePrintEndorsement(dto));
	}

	@Test
	void test_generateOutWardNumber() throws CustomException {
		List<IdDto> dtos = new ArrayList<IdDto>();
		IdDto dto = new IdDto();
		dto.setId(1L);
		dtos.add(dto);
		assertNotNull(tikuPayServiceImpl.generateInwardNumber(dtos));
		assertNotNull(tikuPayServiceImpl.generateOutwardNumber(dtos));
	}

	@Test
	void testUpdateSPRemarks() throws CustomException {
		PVUEventRemarksDto dto = new PVUEventRemarksDto();
		dto.setId(1L);
		dto.setWorkFlowRoleId(1L);
		dto.setEmpId(1L);
		dto.setRemarks(Constant.ACP);
		dto.setRemarksType(Constant.ACP);
		dto.setReasonName(Constant.ACP);
		dto.setReasonId(Constant.LONG_ONE_VALUE);
		dto.setTrnNo(Constant.LONG_ONE_VALUE);
		dto.setEventID(Constant.LONG_ONE_VALUE);

		List<PVUEventRemarksDto> listROPRemarks = new ArrayList<PVUEventRemarksDto>();
		listROPRemarks.add(dto);

		PVUEmployeTikuPayDto tikuPayDto = new PVUEmployeTikuPayDto();
		tikuPayDto.setId(1L);
		tikuPayDto.setReturnReasons(listROPRemarks);
		tikuPayDto.setWfRoleId(1L);
		tikuPayDto.setReturnReasons(listROPRemarks);
		tikuPayDto.setAuditorReturnReason(Constant.RETURN_VAL);

		when(tikuPayrepository.findById(tikuPayDto.getId())).thenReturn(Optional.of(tikuPayEntity));
		when(tikuPayconverter.updateTikyPayRemarks(tikuPayEntity, tikuPayDto)).thenReturn(tikuPayEntity);
		when(tikuPayrepository.save(tikuPayEntity)).thenReturn(tikuPayEntity);
		when(tikuPayconverter.toDTO(tikuPayEntity)).thenReturn(tikuPayDto);
		doNothing().when(eventRemarksService).deactiveOldReason(PvuConstant.TIKU_PAY_EVENT_ID, tikuPayDto.getId(),
				Constant.IN_ACTIVE_STATUS);

		List<PVUEventRemarksEntity> lstEventRemarks = new ArrayList<PVUEventRemarksEntity>();
		PVUEventRemarksEntity pvuEventRemarksEntity = new PVUEventRemarksEntity();
		pvuEventRemarksEntity.setTrnNo(tikuPayDto.getId());
		pvuEventRemarksEntity.setEventID(PvuConstant.TIKU_PAY_EVENT_ID);
		pvuEventRemarksEntity.setWfRoleId(tikuPayDto.getWfRoleId());

		when(tikuPayEntity.getEmployeeId()).thenReturn(employeEntity);
		when(employeEntity.getEmpId()).thenReturn(Constant.LONG_ONE_VALUE);

		pvuEventRemarksEntity.setEmpId(1L);
		pvuEventRemarksEntity.setRemarks(dto.getRemarks());
		pvuEventRemarksEntity.setRemarksType(dto.getRemarksType());
		pvuEventRemarksEntity.setReason(dto.getReasonId());
		pvuEventRemarksEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		lstEventRemarks.addAll(lstEventRemarks);

		assertNotNull(tikuPayServiceImpl.updateTikupayRemarks(tikuPayDto));
	}

	@Test
	void testGetPVUResponseNotNull() throws CustomException {

		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);

		when(idDto.getId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(tikuPayrepository.getOne(idDto.getId())).thenReturn(tikuPayEntity);

		when(tikuPayEntity.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(tikuPayEntity.getPayType()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(tikuPayEntity.getEmployeeId()).thenReturn(employeEntity);
		when(employeEntity.getEmployeeCode()).thenReturn(Constant.LONG_ONE_VALUE);
		when(tikuPayEntity.getOfficeId()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(tikuPayEntity.getPayCommId()).thenReturn(lookupEntity);
		when(lookupEntity.getLookUpInfoId()).thenReturn(Constant.LONG_ONE_VALUE);

		when(pvumployeRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);

		assertNotNull(tikuPayServiceImpl.getPVUResponse(idDto));
	}

	@Test
	void testGetPVUResponseNull() throws CustomException {
		EDPMsOfficeEntity edpMsOfficeEntity1 = new EDPMsOfficeEntity();
		edpMsOfficeEntity1.setOfficeId(Constant.LONG_ONE_VALUE);
		
		PVUEmployeDepartmentEntity departmentEntity = new PVUEmployeDepartmentEntity();
		departmentEntity.setPresentOffice(edpMsOfficeEntity1);
		departmentEntity.setDateOfJoiningGOG(new Date());
		
		Object[] object = new Object[1];
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		
		when(idDto.getId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(tikuPayrepository.getOne(idDto.getId())).thenReturn(tikuPayEntity);

		when(tikuPayEntity.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(tikuPayEntity.getPayType()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(tikuPayEntity.getEmployeeId()).thenReturn(employeEntity);
		when(employeEntity.getEmployeeCode()).thenReturn(Constant.LONG_ONE_VALUE);
		when(tikuPayEntity.getOfficeId()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(tikuPayEntity.getPayCommId()).thenReturn(lookupEntity);
		when(lookupEntity.getLookUpInfoId()).thenReturn(Constant.LONG_ONE_VALUE);

		when(pvumployeRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(Collections.emptyList());
		// when(pvuEmployeeDepartmentRepo.findFirstByPvuEmployeEntityEmployeeCode(Constant.LONG_ONE_VALUE)).thenReturn(Optional.of(departmentEntity));
		//PVUEmployeDepartmentEntity entity = pvuEmployeeDepartmentRepo.findFirstByPvuEmployeEntityEmployeeCode(employeeCode).orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
	
		// assertNotNull(tikuPayServiceImpl.getPVUResponse(idDto));
	}
	@Test
	void testGetCommonDetailsBasedOnEventDate() throws CustomException {
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmployeeCode(Constant.LONG_ONE_VALUE)).thenReturn(Optional.of(department));
		
		when(department.getEmpPayType()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(department.getParentHeadDept()).thenReturn(edpMsDepartmentEntity);
		when(edpMsDepartmentEntity.getDepartmentCode()).thenReturn(Constant.ACP);
		when(department.getDateOfJoiningGOG()).thenReturn(new Date());
		
		//assertNotNull(tikuPayServiceImpl.getCommonDetailsBasedOnEventDate(Mockito.anyMap()));
	}
	
	@Test
	void testTikuPayTypeValidation() throws CustomException {
		EDPLuLookUpInfoEntity edpLuLookUpInfoEntity = new EDPLuLookUpInfoEntity();
		edpLuLookUpInfoEntity.setLookUpInfoId(Constant.APPROVER_CLASS_ONE);
		
		EDPMsDepartmentEntity  departmentEntity1 = new EDPMsDepartmentEntity();
		departmentEntity1.setDepartmentId(Constant.APPROVER_CLASS_ONE);
		
		PVUEmployeDepartmentEntity departmentEntity = new PVUEmployeDepartmentEntity();
		departmentEntity.setEmpPayType(edpLuLookUpInfoEntity);
		departmentEntity.setParentHeadDept(departmentEntity1);
		departmentEntity.setDateOfJoiningGOG(new Date());
		
		when(department.getEmpPayType()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(department.getParentHeadDept()).thenReturn(edpMsDepartmentEntity);
		when(edpMsDepartmentEntity.getDepartmentCode()).thenReturn(Constant.ACP);
		when(department.getDateOfJoiningGOG()).thenReturn(new Date());
		// tikuPayServiceImpl.tikuPayTypeValidation(Mockito.anyMap(),department);
	}
	
	
	

}
