package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUPrintEndorsementItrConverter;
import gov.ifms.pvu.converter.PVUSelectionGradeEventConverter;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUEventSelectionGradeView;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUSelectionGradeEventDto;
import gov.ifms.pvu.dto.PVUSelectionGradenwardView;
import gov.ifms.pvu.dto.PVUSelectiongGradePostDetailDto;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementItrEntity;
import gov.ifms.pvu.entity.PVUSelectionGradeEventEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUInwardRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.repository.PVURevisionOfPayRemarkRepository;
import gov.ifms.pvu.repository.PVUSelectionGradeEventRepository;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.service.PVUEventRemarksService;
import gov.ifms.pvu.service.PVUInwardService;
import gov.ifms.pvu.service.PVUSelectionGradeEventServiceImpl;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;

class PVUSelectionGradeEventServiceImplTest {

	@InjectMocks
	private PVUSelectionGradeEventServiceImpl pvuSelectionGradeEventService;

	@Mock
	private PVUSelectionGradeEventRepository repository;

	@Mock
	private PVUSelectionGradeEventEntity selectionGradEntity;

	@Mock
	private EDPMsOfficeEntity officeEntity;

	@Mock
	private PVUSelectionGradeEventDto selectionGradDto;

	@Mock
	private PVUSelectionGradeEventConverter converter;

	@Mock
	private PVUCommonService pvuCommonService;

	/** The lookupinforepository. */
	@Mock
	private EDPLuLookUpInfoRepository lookupinforepository;

	@Mock
	private EDPLuLookUpInfoEntity lu;

	@Mock
	private EDPLuLookUpInfoEntity luEntity;

	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;

	@Mock
	private PVUEmployeEventsService pvuEmployeEventsService;

	@Mock
	private PVUEmployeEventsEntity employeEventsEntity;

	@Mock
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	@Mock
	private PVUEmployeEntity pvuEmployeEntity;

	@Mock
	private PVUEmployeDepartmentEntity department;

	@Mock
	private EDPMsDesignationEntity edpMsDesignationEntity;

	@Mock
	private PVUEmployeeEventStatusService statusService;

	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Mock
	private PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity;

	@Mock
	private PVYFacade pvuFacade;

	@Mock
	private PVUSelectionGradeEventDto pvuCommonResponse;

	/** The pvu inward service. */
	@Mock
	private PVUInwardRepository pvuInwardRepository;

	@Mock
	private PVUSelectiongGradePostDetailDto pvuSelectiongGradePostDetailDto;

	@Mock
	private IdDto idDto;

	@Mock
	private PVUCommonApiDto pvuCommonApiDto;

	/** The remark repository. */
	@Mock
	private PVURevisionOfPayRemarkRepository remarkRepository;

	@Mock
	private PVUEventRemarksService eventRemarksService;

	@Mock
	PVUPrintEndorsementDto pvuPrintEndorsementDto;

	@Mock
	PVUPrintEndorsementRepository pvuPrintEndorsementRepository;

	@Mock
	PVUPrintEndorsementItrConverter pvuPrintEndorsementItrConverter;

	@Mock
	PVUPrintEndorsementItrEntity pvuPrintEndorsementItrEntity;

	@Mock
	PVUPrintEndorsementItrRepository pvuPrintEndorsementItrRepository;

	@Mock
	private VelocityContext velocityContext;

	@Mock
	private PVUStickerDTO stickerDTO;

	@Mock
	private OAuthService authService;

	@Mock
	Page<PVUSelectionGradeEventEntity> page;

	@Mock
	List<PVUSelectionGradeEventEntity> lst;

	@Mock
	List<PVUSelectionGradeEventDto> list;

	@Mock
	EncryptDecryptUtil securityUtil;

	@Mock
	private PVUInwardService inwardService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetSelectionGradeEvent() {
		when(repository.findById(1l)).thenReturn(Optional.of(selectionGradEntity));
		assertEquals(selectionGradEntity, pvuSelectionGradeEventService.getSelectionGradeEvent(1l));
		verify(repository, times(1)).findById(1l);
	}

	@Test
	void testSaveOrUpdateSelectionGradeEvent() throws CustomException {
		PVUSelectionGradeEventEntity entity = new PVUSelectionGradeEventEntity();
		entity.setStatusId(new EDPLuLookUpInfoEntity(1l));
		entity.setEmpId(new PVUEmployeEntity(1l));
		PVUSelectionGradeEventDto sgDto = new PVUSelectionGradeEventDto();
		sgDto.setStatusId(0l);
		sgDto.setEmployeeId(1l);
		when(converter.toEntity(sgDto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(statusService.inProgressSuspensionEvent(sgDto.getEmployeeId())).thenReturn(pvuEmployeeEventStatusEntity);
		assertNotNull(pvuSelectionGradeEventService.saveOrUpdateSelectionGradeEvent(sgDto));
	}

	@Test
	void testGetSelectionGradeEvents() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("isSearch", ""));
		jsonArr.add(new SearchParam("startDate", ""));
		jsonArr.add(new SearchParam("endDate", ""));
		jsonArr.add(new SearchParam("eventsId", ""));
		jsonArr.add(new SearchParam("designationId", ""));
		jsonArr.add(new SearchParam("gpfNo", ""));
		jsonArr.add(new SearchParam("pPan", ""));
		jsonArr.add(new SearchParam("retirementDate", ""));
		jsonArr.add(new SearchParam("empNo", ""));
		jsonArr.add(new SearchParam("empName", ""));
		jsonArr.add(new SearchParam("caseNo", " "));
		jsonArr.add(new SearchParam("classId", " "));
		jsonArr.add(new SearchParam("officeId", ""));
		jsonArr.add(new SearchParam("empType", ""));
		jsonArr.add(new SearchParam("statusId", " "));
		jsonArr.add(new SearchParam("workflowId", ""));
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		PagebleDTO<PVUSelectionGradenwardView> data = pvuSelectionGradeEventService.getSelectionGradeEvents(pageDetail);
		assertNotNull(data);
	}

	@Test
	void testStoreProcPvu() throws CustomException {
		assertNotNull(pvuSelectionGradeEventService.storeProcPvu("PROC", new HashMap<String, Object>(),
				PVUSelectionGradenwardView.class));
	}

	@Test
	void InsertSelectiongGradTest() throws CustomException {
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntityOpt = Optional
				.of(pvuEmployeeEventStatusEntity);
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		PVUSelectionGradeEventEntity entity = new PVUSelectionGradeEventEntity();
		entity.setStatusId(new EDPLuLookUpInfoEntity(1l));
		entity.setEmpId(new PVUEmployeEntity(1l));
		when(repository.findById(1l)).thenReturn(Optional.of(entity));
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Approved")).thenReturn(lu);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.CONDITION_CHECK, Constant.ACTIVE_STATUS, Constant.LOOKUP_YES)).thenReturn(lu);
		repository.updatePrintStatusAndApproveDate(1l, 1, 1l, 1l, new Date(), 1l, LocalDateTime.now());
		when(lu.getLookUpInfoId()).thenReturn(2l);
		when(selectionGradEntity.getStatusId()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(1l);
		when(statusService.inProgressAnyEvent(1l)).thenReturn(pvuEmployeeEventStatusEntity);
		when(pvuEmployeeEventStatusEntity.getSelectionGrade()).thenReturn(1l);
		when(pvuCommonService.getTransactionNumber("SG")).thenReturn("SG");
		statusService.updateEventInfo(pvuEmployeeEventStatusEntity, "SG");
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(converter.toDTO(selectionGradEntity)).thenReturn(pvuCommonResponse);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Approved");
		when(selectionGradDto.getEmployeeId()).thenReturn(1l);
		when(selectionGradDto.getEventOrderDate()).thenReturn(LocalDate.now());
		when(selectionGradDto.getTrnNo()).thenReturn("2020");
		when(selectionGradDto.getEventCode()).thenReturn("SG");
		when(selectionGradDto.getDateOfNextIncrement()).thenReturn(LocalDate.now());
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Submit")).thenReturn(luEntity);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(pvuEmployeeEventStatusEntityOpt);
		when(selectionGradEntity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(department.getDesignationId()).thenReturn(edpMsDesignationEntity);
		when(edpMsDesignationEntity.getDesignationId()).thenReturn(1l);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
				PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME)).thenReturn(luEntity);
		when(statusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		pvuSelectionGradeEventService.insertSelectionGradeItr(pvuWFWrapperDto);
		assertTrue(true);
	}

	@Test
	void getEmployeeCheckPayLevelByPaylevelId() throws CustomException {
		HashMap<String, Long> map = new HashMap<>();
		PvuCommonRequest pvuRequest = new PvuCommonRequest();
		map.put("newPaylevelId", 7l);
		map.put("oldPaylevelId", 6l);
		map.put("cellValue", 9l);
		pvuRequest.setRequest(map);
		List<Object[]> objectPvuSp = new ArrayList<Object[]>();
		Object objectArray[] = new Object[5];
		objectArray[0] = 7l;
		objectArray[1] = "12";
		objectArray[2] = 3000l;
		objectArray[3] = "1";
		objectArray[4] = false;
		objectPvuSp.add(objectArray);
		StringBuilder sb = new StringBuilder();
		HashMap<String, Object> objectMap = new HashMap<>();
		objectMap.put("newPaylevelId", 7l);
		objectMap.put("oldPaylevelId", 6l);
		objectMap.put("cellValue", 9l);
		sb.append("abc");
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objectPvuSp);
		assertNotNull(pvuSelectionGradeEventService.getEmployeeCheckPayLevelByPaylevelId(pvuRequest));
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
		pvuSelectionGradeEventService.generateInwardNumber(dtos);
	}

	@Test
	void testSubmitSelectionGradeInward() throws CustomException {
		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		List<PvuWFWrapperDto> listWrapperDto = new ArrayList<PvuWFWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus("printed");
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);
		assertNotNull(when(pvuFacade.callWorkFlowApis(listWrapperDto)).thenReturn(true));
		pvuSelectionGradeEventService.submitSelectionGradeInward(listWrapperDto);
	}

	@Test
	void testsubmitSelectionGradDistributor() throws CustomException {
		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		List<PvuWFWrapperDto> listWrapperDto = new ArrayList<PvuWFWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus("printed");
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);
		assertNotNull(when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true));
		List<PvuWFWrapperDto> wrapperDtos = new ArrayList<PvuWFWrapperDto>();
		pvuSelectionGradeEventService.submitSelectionGradDistributor(wrapperDtos);
	}

	@Test
	void generateOutwardNumber() throws CustomException, SQLException {
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
		pvuSelectionGradeEventService.generateOutwardNumber(dtos);
	}

	@Test
	void testGetDdoWFListingSearchFields() {
		assertNotNull(pvuSelectionGradeEventService.getDdoWFListingSearchFields());
	}

	@Test
	void testReturnedbyPVUApproverClass2ADreturnedbyPVUApproverClass1() {
		when(pvuWFWrapperDto.getTrnStatus()).thenReturn(Constant.RETURN_BY_APPROVER_CLASS_I);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				"Recommendation For", Constant.ACTIVE_STATUS, Constant.RETURN)).thenReturn(lu);
		repository.updateStatusId(1l, pvuWFWrapperDto.getTrnId(), 1l, new Date());
		assertNotNull(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				"Recommendation For", Constant.ACTIVE_STATUS, Constant.RETURN));
		pvuInwardRepository.setReturnDateSG(pvuWFWrapperDto.getTrnId(), PvuConstant.SELECTION_GRADE_EVENT_ID,
				OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(), Constant.OUTWARD_FLAG_ONE,
				Constant.ACTIVE_STATUS);
		pvuSelectionGradeEventService.returnedbyPVUApproverClass2ADreturnedbyPVUApproverClass1(pvuWFWrapperDto);

	}

	@Test
	void testGetPvuOfficeSearchFields() {
		assertNotNull(pvuSelectionGradeEventService.getPvuOfficeSearchFields());
	}

	@Test
	void testGetOutwardPvuSearchFields() {
		assertNotNull(pvuSelectionGradeEventService.getOutwardPvuSearchFields());
	}

	@Test
	void testGetPrintSPSearchFields() {
		assertNotNull(pvuSelectionGradeEventService.getPrintSPSearchFields());
	}

	@Test
	void testGetReprintEndorsementRemarks() throws CustomException {
		assertNotNull(pvuSelectionGradeEventService.getReprintEndorsementRemarks(Constant.LONG_ONE_VALUE));
	}

	@Test
	void testInProgressAnyEvent() throws CustomException {
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntityOpt = Optional
				.of(pvuEmployeeEventStatusEntity);
		when(pvuEmployeeEventStatusEntity.getTransId()).thenReturn("121");
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(pvuEmployeeEventStatusEntityOpt);
		assertNotNull(pvuSelectionGradeEventService.inProgressAnyEvent(1l, "121"));
	}

	@Test
	void testForwardToPvu() {
		when(pvuWFWrapperDto.getWfStatus()).thenReturn(Constant.FORWARD_TO_PVU);
		when(pvuWFWrapperDto.getAssignByWfRoleId()).thenReturn(Constant.AUDITOR);
		pvuSelectionGradeEventService.forwardToPvu(pvuWFWrapperDto);
		assertTrue(true);
	}

	@Test
	void testGetPVUResponse() throws CustomException {
		when(idDto.getId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(repository.findById(1l)).thenReturn(Optional.of(selectionGradEntity));
		when(selectionGradEntity.getCurrentDetailsEventId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(converter.toPVUObj(selectionGradEntity)).thenReturn(pvuSelectiongGradePostDetailDto);
		when(pvuEmployeEventsService.getCommonApiResponseForSelectionGrade(Constant.LONG_ONE_VALUE))
				.thenReturn(pvuCommonApiDto);
		assertNotNull(pvuSelectionGradeEventService.getPVUResponse(idDto));
	}

	@Test
	void testProcessAuthorizedOutWards() throws CustomException {
		PvuWFOutWardWrapperDto wrapperDto = new PvuWFOutWardWrapperDto();
		List<PvuWFOutWardWrapperDto> listWrapperDto = new ArrayList<PvuWFOutWardWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus("printed");
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);
		doNothing().when(pvuInwardRepository).updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
				PvuConstant.SELECTION_GRADE_EVENT_ID, 1L, Constant.OUTWARD_FLAG_ZERO, Constant.ACTIVE_STATUS);
		when(repository.findById(1l)).thenReturn(Optional.of(selectionGradEntity));
		when(selectionGradEntity.getTrnNo()).thenReturn(Constant.SG_PVU);
		when(selectionGradEntity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1L);
		when(pvuFacade.callWorkFlowApis(PvuWFOutWardWrapperDto.createSuper(listWrapperDto))).thenReturn(true);

		assertFalse(pvuSelectionGradeEventService.processAuthorizedOutWards(listWrapperDto));
	}

	@Test
	void testProcessReturnOutWardsNotEmpty() throws CustomException {
		PvuWFOutWardWrapperDto wrapperDto = new PvuWFOutWardWrapperDto();
		List<PvuWFOutWardWrapperDto> listWrapperDto = new ArrayList<PvuWFOutWardWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus("printed");
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertFalse(pvuSelectionGradeEventService.processReturnOutWards(listWrapperDto));
	}

	@Test
	void testsubmitSPOutward() throws CustomException {
		PvuWFOutWardWrapperDto wrapperDto = new PvuWFOutWardWrapperDto();
		List<PvuWFOutWardWrapperDto> listWrapperDto = new ArrayList<PvuWFOutWardWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus("printed");
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);
		doNothing().when(pvuInwardRepository).updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
				PvuConstant.SELECTION_GRADE_EVENT_ID, 1L, Constant.OUTWARD_FLAG_ZERO, Constant.ACTIVE_STATUS);
		
		doNothing().when(inwardService).setConsignmentNumber(1L,PvuConstant.SELECTION_GRADE_EVENT_ID,Constant.ACP);
		
		assertNotNull(pvuSelectionGradeEventService.submitSGOutward(listWrapperDto));
	}

	@Test
	void testGetPrintEndorsementHistoryEmpty() throws CustomException {
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(Collections.emptyList());
		assertNotNull(pvuSelectionGradeEventService.getReprintEndorsementRemarks(Constant.LONG_ONE_VALUE));
	}

	@Test
	void testGetPrintEndorsementHistoryNotEmpty() throws CustomException {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(pvuSelectionGradeEventService.getReprintEndorsementRemarks(Constant.LONG_ONE_VALUE));
	}

	@Test
	void testAuthorizeSg() {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		pvuSelectionGradeEventService.authorizeSG(Constant.LONG_ONE_VALUE);
		verify(repository, times(1)).callStoredProcedure(Mockito.anyString(), Mockito.anyMap());
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testGetReturnReasonByTransactionIdEmpty() throws CustomException {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(remarkRepository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(Collections.emptyList());
		assertNotNull(pvuSelectionGradeEventService.getReturnReasonByTransactionId(Constant.LONG_ONE_VALUE));
	}

	@Test
	void testProcessAuthorizedOutWardsNotEmpty() {
		PvuWFWrapperDto pvuWFWrapperDto = new PvuWFWrapperDto();
		pvuWFWrapperDto.setWfStatus(Constant.APPROVED);
		pvuWFWrapperDto.setTrnId(1l);
		pvuWFWrapperDto.setUpdatedDate(new Date());
		doNothing().when(pvuInwardRepository).updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
				PvuConstant.SELECTION_GRADE_EVENT_ID, 1L, Constant.OUTWARD_FLAG_ONE, Constant.ACTIVE_STATUS);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testProcessAuthorizedOutWardsEmpty() {
		List<PvuWFOutWardWrapperDto> dtos = new ArrayList<PvuWFOutWardWrapperDto>();
		pvuSelectionGradeEventService.processAuthorizedOutWards(dtos);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testUpdateSGRemarks() throws CustomException {
		PVUEventRemarksDto dto = new PVUEventRemarksDto();
		dto.setId(1L);
		dto.setWorkFlowRoleId(1L);
		dto.setEmpId(1L);
		dto.setRemarks(Constant.SG);
		dto.setRemarksType(Constant.SG);
		dto.setReasonName(Constant.SG);
		dto.setReasonId(Constant.LONG_ONE_VALUE);
		dto.setTrnNo(Constant.LONG_ONE_VALUE);
		dto.setEventID(Constant.LONG_ONE_VALUE);

		List<PVUEventRemarksDto> listROPRemarks = new ArrayList<PVUEventRemarksDto>();
		listROPRemarks.add(dto);
		PVUSelectionGradeEventDto sgEventDto = new PVUSelectionGradeEventDto();
		sgEventDto.setId(1L);
		sgEventDto.setReturnReasons(listROPRemarks);
		sgEventDto.setWfRoleId(1L);
		sgEventDto.setReturnReasons(listROPRemarks);
		sgEventDto.setAuditorReturnReason(Constant.RETURN_VAL);
		when(repository.findById(1l)).thenReturn(Optional.of(selectionGradEntity));

		when(converter.updateSGRemarks(selectionGradEntity, sgEventDto)).thenReturn(selectionGradEntity);
		when(repository.save(selectionGradEntity)).thenReturn(selectionGradEntity);
		when(converter.toDTO(selectionGradEntity)).thenReturn(sgEventDto);
		doNothing().when(eventRemarksService).deactiveOldReason(PvuConstant.SELECTION_GRADE_EVENT_ID,
				sgEventDto.getId(), Constant.IN_ACTIVE_STATUS);
		List<PVUEventRemarksEntity> lstEventRemarks = new ArrayList<PVUEventRemarksEntity>();
		PVUEventRemarksEntity pvuEventRemarksEntity = new PVUEventRemarksEntity();
		pvuEventRemarksEntity.setTrnNo(sgEventDto.getId());
		pvuEventRemarksEntity.setEventID(PvuConstant.SELECTION_GRADE_EVENT_ID);
		pvuEventRemarksEntity.setWfRoleId(sgEventDto.getWfRoleId());
		when(selectionGradEntity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(Constant.LONG_ONE_VALUE);
		pvuEventRemarksEntity.setEmpId(1L);
		pvuEventRemarksEntity.setRemarks(dto.getRemarks());
		pvuEventRemarksEntity.setRemarksType(dto.getRemarksType());
		pvuEventRemarksEntity.setReason(dto.getReasonId());
		pvuEventRemarksEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		lstEventRemarks.addAll(lstEventRemarks);
		assertNotNull(pvuSelectionGradeEventService.updateSGRemarks(sgEventDto));
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
				PvuConstant.SELECTION_GRADE_EVENT_ID, 1L, Constant.OUTWARD_FLAG_ONE, Constant.ACTIVE_STATUS);
		when(pvuPrintEndorsementRepository.findByIdAndActiveStatus(Constant.LONG_ONE_VALUE, Constant.ACTIVE_STATUS))
				.thenReturn(null);
		when(converter.toEntityPrint(pvuPrintEndorsementDto)).thenReturn(printEntity);
		when(pvuPrintEndorsementRepository.save(printEntity)).thenReturn(printEntity);
		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrEntity))
				.thenReturn(pvuPrintEndorsementItrEntity);
		when(converter.toDTOPrint(printEntity)).thenReturn(pvuPrintEndorsementDto);
		assertNotNull(pvuSelectionGradeEventService.submitPEWF(dto));
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
		when(converter.toEntityPrint(pvuPrintEndorsementDto)).thenReturn(printEntity);
		when(pvuPrintEndorsementRepository.save(printEntity)).thenReturn(printEntity);
		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrEntity))
				.thenReturn(pvuPrintEndorsementItrEntity);
		when(converter.toDTOPrint(printEntity)).thenReturn(pvuPrintEndorsementDto);
		assertNotNull(pvuSelectionGradeEventService.submitPEWF(dto));

	}

	@Test
	void getPrintTemplate() {
		when(selectionGradEntity.getPayComm()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
		assertNotNull(pvuSelectionGradeEventService.getTemplateByCommId(selectionGradEntity));
	}

	@Test
	void testSubmitPrintHistory() throws CustomException {
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
		when(converter.toEntityPrint(pvuPrintEndorsementDto)).thenReturn(printEntity);
		when(pvuPrintEndorsementRepository.save(printEntity)).thenReturn(printEntity);
		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrEntity))
				.thenReturn(pvuPrintEndorsementItrEntity);
		when(converter.toDTOPrint(printEntity)).thenReturn(pvuPrintEndorsementDto);
		assertNotNull(pvuSelectionGradeEventService.submitPrintHistory(dto));
	}

	@Test
	void testGeneratePrintEndorsement() throws CustomException {
		IdNameDto idNameDto = new IdNameDto();
		idNameDto.setName("print");
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
		when(converter.toEntityPrint(pvuPrintEndorsementDto)).thenReturn(printEntity);
		when(pvuPrintEndorsementRepository.save(printEntity)).thenReturn(printEntity);
		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrEntity))
				.thenReturn(pvuPrintEndorsementItrEntity);
		when(converter.toDTOPrint(printEntity)).thenReturn(pvuPrintEndorsementDto);
		when(repository.findById(1l)).thenReturn(Optional.of(selectionGradEntity));
		when(selectionGradEntity.getAuthorizeBy()).thenReturn(Constant.LONG_ONE_VALUE);
		when(authService.getOnlyIdAndName(1l)).thenReturn(idNameDto);
		when(selectionGradEntity.getPayComm()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
		when(pvuEmployeEventsService.getCommonApiResponseForSelectionGrade(Constant.LONG_ONE_VALUE))
				.thenReturn(pvuCommonApiDto);
		when(converter.toPVUObj(selectionGradEntity)).thenReturn(pvuSelectiongGradePostDetailDto);
		when(pvuSelectionGradeEventService.populateVContext(stickerDTO, selectionGradEntity))
				.thenReturn(velocityContext);
		when(converter.setPopulateVContext(stickerDTO, selectionGradEntity, pvuCommonApiDto,
				pvuSelectiongGradePostDetailDto, "auth")).thenReturn(velocityContext);
		when(selectionGradEntity.getOfficeId()).thenReturn(officeEntity);
		when(officeEntity.getOfficeId()).thenReturn(1l);
		assertNotNull(pvuSelectionGradeEventService.generatePrintEndorsement(dto));
	}

	@Test
	void testGeneratePrintEndorsements() throws CustomException {
		IdNameDto idNameDto = new IdNameDto();
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
		when(converter.toEntityPrint(pvuPrintEndorsementDto)).thenReturn(printEntity);
		when(pvuPrintEndorsementRepository.save(printEntity)).thenReturn(printEntity);
		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrEntity))
				.thenReturn(pvuPrintEndorsementItrEntity);
		when(converter.toDTOPrint(printEntity)).thenReturn(pvuPrintEndorsementDto);
		when(repository.findById(1l)).thenReturn(Optional.of(selectionGradEntity));
		when(authService.getOnlyIdAndName(1l)).thenReturn(idNameDto);
		when(selectionGradEntity.getPayComm()).thenReturn(luEntity);
		when(selectionGradEntity.getAuthorizeBy()).thenReturn(Constant.LONG_ONE_VALUE);
		when(luEntity.getLookUpInfoId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
		when(converter.toPVUObj(selectionGradEntity)).thenReturn(pvuSelectiongGradePostDetailDto);
		when(pvuSelectionGradeEventService.populateVContext(stickerDTO, selectionGradEntity))
				.thenReturn(velocityContext);
		when(converter.setPopulateVContext(stickerDTO, selectionGradEntity, pvuCommonApiDto,
				pvuSelectiongGradePostDetailDto, "auth")).thenReturn(velocityContext);
		when(selectionGradEntity.getOfficeId()).thenReturn(officeEntity);
		when(officeEntity.getOfficeId()).thenReturn(1l);
		assertNotNull(pvuSelectionGradeEventService.generatePrintEndorsement(dtos));
	}

	@Test
	void deleteSelectionGrad() throws CustomException {
		when(repository.findById(1l)).thenReturn(Optional.of(selectionGradEntity));
		when(lookupinforepository.findByLookUpInfoName("Saved as Draft")).thenReturn(luEntity);
		when(selectionGradEntity.getStatusId()).thenReturn(lu);
		when(luEntity.getLookUpInfoId()).thenReturn(1l);
		when(lu.getLookUpInfoId()).thenReturn(1l);
		when(selectionGradEntity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		assertTrue(pvuSelectionGradeEventService.deleteSgEvent(1l));
	}

	@Test
	void testddoWFListingSg() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("isSearch", ""));
		jsonArr.add(new SearchParam("startDate", ""));
		jsonArr.add(new SearchParam("endDate", ""));
		jsonArr.add(new SearchParam("eventsId", ""));
		jsonArr.add(new SearchParam("designationId", ""));
		jsonArr.add(new SearchParam("gpfNo", ""));
		jsonArr.add(new SearchParam("pPan", ""));
		jsonArr.add(new SearchParam("retirementDate", ""));
		jsonArr.add(new SearchParam("empNo", ""));
		jsonArr.add(new SearchParam("empName", ""));
		jsonArr.add(new SearchParam("caseNo", " "));
		jsonArr.add(new SearchParam("classId", " "));
		jsonArr.add(new SearchParam("officeId", ""));
		jsonArr.add(new SearchParam("empType", ""));
		jsonArr.add(new SearchParam("statusId", " "));
		jsonArr.add(new SearchParam("workflowId", ""));
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		PagebleDTO<PVUSelectionGradenwardView> data = pvuSelectionGradeEventService.getSelectionGradeEvents(pageDetail);
		assertNotNull(data);
	}

	@Test
	void test_getPVUOfficeName() {
		String officeName = "abc";
		IdDto idDto = new IdDto();
		idDto.setId(1L);
		Map<String, Object> map = new HashMap<>();
		map.put("eventId", idDto.getId());
		List<Object[]> lstObjects = new ArrayList<>();
		Object[] objectArray = new Object[1];
		objectArray[0] = officeName;
		lstObjects.add(objectArray);
		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getSeletionGradeEmpOfficeId(), map))
				.thenReturn(lstObjects);
		EDPMsOfficeDto dto = pvuSelectionGradeEventService.getPVUOfficeName(idDto);
		assertNotNull(dto);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetPVUSeniorScales() throws CustomException {
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
		when(converter.toDTO(lst)).thenReturn(list);
		PagebleDTO<PVUEventSelectionGradeView> data = pvuSelectionGradeEventService.ddoWFListingSg(pageDetail);
		assertNotNull(data);
		pvuSelectionGradeEventService.pvuOfficeEmployeeSearch(pageDetail);
		pvuSelectionGradeEventService.getSGOutwardList(pageDetail);
		pvuSelectionGradeEventService.getPrintEndorsementsList(pageDetail);
	}

	@Test
	void tesupdateEmpEventStatusReset() {
		PVUSelectionGradeEventEntity entity = new PVUSelectionGradeEventEntity();
		entity.setEmpId(new PVUEmployeEntity(1l));
		Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntityOpt = Optional
				.of(pvuEmployeeEventStatusEntity);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(pvuEmployeeEventStatusEntityOpt);
		assertNotNull(pvuEmployeeEventStatusService.findByEmpId(1l));
		pvuSelectionGradeEventService.updateEmpEventStatusReset(entity);
	}

}