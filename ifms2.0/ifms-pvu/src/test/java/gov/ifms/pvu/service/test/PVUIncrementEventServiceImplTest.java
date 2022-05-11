package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import gov.ifms.pvu.util.PvuUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.converter.PVUIncrementEventConverter;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.dto.PVUIncrementCreateListView;
import gov.ifms.pvu.dto.PVUIncrementEditListView;
import gov.ifms.pvu.dto.PVUIncrementEmpDto;
import gov.ifms.pvu.dto.PVUIncrementEventDto;
import gov.ifms.pvu.dto.PVUIncrementEventSummaryDto;
import gov.ifms.pvu.dto.PVUIncrementListView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUIncrementEmpEntity;
import gov.ifms.pvu.entity.PVUIncrementEventEntity;
import gov.ifms.pvu.repository.PVUEmployeeEventStatusRepository;
import gov.ifms.pvu.repository.PVUIncrementEventRepository;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.service.PVUIncrementEmpServiceImpl;
import gov.ifms.pvu.service.PVUIncrementEventServiceImpl;
import gov.ifms.pvu.service.PVUIncrementEventSummaryService;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;

class PVUIncrementEventServiceImplTest {

	@InjectMocks
	private PVUIncrementEventServiceImpl pvuIncrementEventServiceImpl;

	@Mock
	private PVUIncrementEventRepository pvuIncrementEventRepository;

	@Mock
	private PVUIncrementEventEntity pvuIncrementEventEntity;

	@Mock
	private PVUIncrementEventEntity requestedEntity;

	@Mock
	private PVUIncrementEventDto pvuIncrementEventDto;

	@Mock
	private PVUIncrementEventConverter pvuIncrementEventConverter;

	@Mock
	private List<PVUIncrementEmpDto> pvuIncrementEmpDtoList;

	@Mock
	private List<PVUIncrementEmpEntity> pvuIncrementEmpEntityList;

	@Mock
	private PVUIncrementEmpServiceImpl pvuIncrementEmpServiceImpl;

	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	@Mock
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Mock
	EDPLuLookUpInfoEntity edpLuLookUpInfoEntityStatusId;

	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;

	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntityEmpStatus;

	@Mock
	private PVYFacade pvuFacade;

	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Mock
	private PVUIncrementEventSummaryService pvuIncrementEventSummaryService;

	@Mock
	private PVUIncrementEventSummaryDto pvuIncrementEventSummaryDto;

	@Mock
	private PVUIncrementEmpDto pvuIncrementEmpDto;

	@Mock
	List<Long> lstEmpIncludeList;

	@Mock
	private PVUEmployeeEventStatusRepository pvuEmployeeEventStatusRepository;

	@Mock
	List<PVUEmployeeEventStatusDto> pvuEmployeeEventStatusDtoList;

	@Mock
	private EDPMsFinancialYearEntity edpMsFinancialYearEntity;

	@Mock
	private EDPMsDesignationEntity edpMsDesignationEntity;

	@Mock
	private EDPMsDesignationEntity reqEdpMsDesignationEntity;

	@Mock
	private EDPMsFinancialYearEntity reqEdpMsFinancialYearEntity;

	@Mock
	private EDPLuLookUpInfoEntity reqEdpLuLookUpInfoEntity;

	@Mock
	private PVUIncrementEventDto dto;
	@Mock
	private List<PVUIncrementCreateListView> lstIncIncludeExclude;

	@Mock
	private List<Object[]> objects;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testgetPvuSearchFields() {
		assertNotNull(pvuIncrementEventServiceImpl.getPvuSearchFields());
	}

	@Test
	void testgetIncEditSearchFields() {
		assertNotNull(pvuIncrementEventServiceImpl.getIncEditSearchFields());
	}

	@Test
	void testgetPvuSearchFieldsList() {
		assertNotNull(pvuIncrementEventServiceImpl.getPvuSearchFieldsList());
	}

	@Test
	void testgetIncrementEvent() {
		when(pvuIncrementEventRepository.findById(1l)).thenReturn(Optional.of(pvuIncrementEventEntity));
		assertNotNull(pvuIncrementEventServiceImpl.getPvuSearchFieldsList());
	}

	@Test
	void testSaveOrUpdateIncrementEvent() throws CustomException { //
		when(pvuIncrementEventRepository.save(pvuIncrementEventEntity)).thenReturn(pvuIncrementEventEntity);
		assertNotNull(pvuIncrementEventServiceImpl.saveOrUpdateIncrementEvent(pvuIncrementEventEntity));
	}

	@Test
	void testGetIncrementEvents() throws CustomException {
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
		PagebleDTO<PVUIncrementCreateListView> data = pvuIncrementEventServiceImpl
				.getIncrementCreateIncludeExcludeEvents(pageDetail);
		assertNotNull(data);
	}

	@Test
	void testGetIncrementListEvents() throws CustomException {
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

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		pageDetail.setSortByColumn("asc");
		pageDetail.setSortOrder("SD");
		PagebleDTO<PVUIncrementListView> data = pvuIncrementEventServiceImpl.getIncrementListEvents(pageDetail);
		assertNotNull(data);
	}

	@Test
	void testGetLookUpInfoAsMap() throws CustomException {
		assertNotNull(pvuIncrementEventServiceImpl.getLookUpInfoAsMap(Constant.SAVE_AS_DRAFT));
	}

	@Test
	void testGetIncrementEventEmpSummary() {
		when(pvuIncrementEventRepository.findById(1l)).thenReturn(Optional.of(pvuIncrementEventEntity));
		when(pvuIncrementEventConverter.toDTO(pvuIncrementEventEntity)).thenReturn(pvuIncrementEventDto);
		assertNotNull(pvuIncrementEventServiceImpl.getIncrementEventEmpSummary(1l));
	}

	@Test
	void testSaveOrUpdateIncrementEventEmpSummary() throws CustomException {
		List<PVUIncrementEmpDto> list = new ArrayList<>();

		list.add(pvuIncrementEmpDto);
		when(pvuIncrementEmpDto.getEmpId()).thenReturn(1l);
		when(pvuIncrementEventConverter.toEntity(pvuIncrementEventDto)).thenReturn(pvuIncrementEventEntity);
		when(pvuIncrementEventRepository.save(pvuIncrementEventEntity)).thenReturn(pvuIncrementEventEntity);
		when(lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT))
				.thenReturn(edpLuLookUpInfoEntityStatusId);
		when(pvuEmployeeEventStatusService.getEmployeeInProcessByEmpIds(lstEmpIncludeList))
				.thenReturn(pvuEmployeeEventStatusDtoList);
		when(pvuIncrementEventDto.getPvuIncrementEmpDtos()).thenReturn(list);
		when(pvuIncrementEventEntity.getInEventId()).thenReturn(0L);
		when(pvuIncrementEventEntity.getStatusId()).thenReturn(edpLuLookUpInfoEntityStatusId);

		when(pvuIncrementEventConverter.toDTO(pvuIncrementEventEntity)).thenReturn(pvuIncrementEventDto);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(pvuIncrementEventRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);
		when(pvuIncrementEventDto.getPvuIncrementEmpDtos()).thenReturn(list);
		when(pvuIncrementEventDto.getPvuIncrementEventSummaryDto()).thenReturn(pvuIncrementEventSummaryDto);
		when(pvuEmployeeEventStatusRepository.findEmployeeInProgress(lstEmpIncludeList))
				.thenReturn(pvuEmployeeEventStatusDtoList);
		when(pvuIncrementEventEntity.getTrnNo()).thenReturn("SD");
		assertNotNull(pvuIncrementEventServiceImpl.saveOrUpdateIncrementEventEmpSummary(pvuIncrementEventDto));
	}

	@Test
	void testSaveOrUpdateIncrementEventEmpSummaryOldTransaction() throws CustomException {
		List<PVUIncrementEmpDto> list = new ArrayList<>();
		list.add(pvuIncrementEmpDto);
		when(pvuIncrementEventDto.getPvuIncrementEmpDtos()).thenReturn(list);
		when(pvuIncrementEventDto.getPvuIncrementEventSummaryDto()).thenReturn(pvuIncrementEventSummaryDto);
		when(lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT))
				.thenReturn(edpLuLookUpInfoEntityStatusId);
		when(edpLuLookUpInfoEntityStatusId.getLookUpInfoId()).thenReturn(Constant.SAVE_AS_DRAFT_STATUS_ID);
		when(pvuIncrementEventDto.getInEventId()).thenReturn(Constant.ROP_2016);
		when(pvuIncrementEventDto.getStatusId()).thenReturn(Constant.SAVE_AS_DRAFT_STATUS_ID);
		when(pvuIncrementEventConverter.toEntity(pvuIncrementEventDto)).thenReturn(requestedEntity);
		when(pvuIncrementEventRepository.findById(Constant.ROP_2016)).thenReturn(Optional.of(pvuIncrementEventEntity));
		when(pvuIncrementEventEntity.getInEventId()).thenReturn(Constant.ROP_2009);
		when(pvuIncrementEventEntity.getStatusId()).thenReturn(edpLuLookUpInfoEntityStatusId);
		when(edpLuLookUpInfoEntityStatusId.getLookUpInfoId()).thenReturn(Constant.SAVE_AS_DRAFT_STATUS_ID);
		when(requestedEntity.getInEventId()).thenReturn(Constant.ROP_2016);
		when(requestedEntity.getStatusId()).thenReturn(edpLuLookUpInfoEntityStatusId);
		when(pvuIncrementEventRepository.save(requestedEntity)).thenReturn(requestedEntity);
		when(requestedEntity.getStatusId()).thenReturn(edpLuLookUpInfoEntityStatusId);
		doNothing().when(pvuIncrementEmpServiceImpl).deleteIrrelevantEmployeeFromTransaction(Constant.ROP_2009);
		when(pvuIncrementEventConverter.toDTO(requestedEntity)).thenReturn(pvuIncrementEventDto);
		assertNotNull(pvuIncrementEventServiceImpl.saveOrUpdateIncrementEventEmpSummary(pvuIncrementEventDto));
	}

	@Test
	void testGetIncrementEditEvents() throws CustomException {
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

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		pageDetail.setSortByColumn("asc");
		pageDetail.setSortOrder("SD");

		PagebleDTO<PVUIncrementEditListView> data = pvuIncrementEventServiceImpl.getIncrementEditEvents(pageDetail);
		assertNotNull(data);
	}

	@Test
	void testInsertIncrementItrWithTrans() throws CustomException {
		Date updatedDate = new Date();
		pvuWFWrapperDto.setUpdatedDate(updatedDate);

		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(pvuIncrementEventRepository.findById(1l)).thenReturn(Optional.of(pvuIncrementEventEntity));

		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.STATUS_ID, Constant.ACTIVE_STATUS, Constant.APPROVED))
						.thenReturn(edpLuLookUpInfoEntityEmpStatus);
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.STATUS_ID, Constant.ACTIVE_STATUS, Constant.REJECTED))
						.thenReturn(edpLuLookUpInfoEntityEmpStatus);
		when(edpLuLookUpInfoEntityEmpStatus.getLookUpInfoId()).thenReturn(1l);
		when(pvuIncrementEventEntity.getStatusId()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(3l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(pvuIncrementEventConverter.toDTO(pvuIncrementEventEntity)).thenReturn(pvuIncrementEventDto);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Approved");
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(pvuIncrementEventRepository.save(pvuIncrementEventEntity)).thenReturn(pvuIncrementEventEntity);

		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(pvuIncrementEventRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);

		Object resObject = 0l;
		when(pvuIncrementEventRepository.callUsingCallableStmt(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(resObject);
		pvuIncrementEventServiceImpl.submitAutoIncrement(Constant.INC);
		verify(pvuIncrementEventRepository, times(1)).callUsingCallableStmt(Mockito.anyString(), Mockito.anyMap());

		when(pvuIncrementEventSummaryService.getIncCountSummaryByInEventIdDto(1l))
				.thenReturn(pvuIncrementEventSummaryDto);
		when(pvuIncrementEventDto.getPvuIncrementEventSummaryDto()).thenReturn(pvuIncrementEventSummaryDto);
		assertNotNull(pvuIncrementEventServiceImpl.insertIncrementItr(pvuWFWrapperDto));
	}

	@Test
	void testSubmitAutoIncrement() throws CustomException {
		Object resObject = 0l;
		when(pvuIncrementEventRepository.callUsingCallableStmt(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(resObject);
		pvuIncrementEventServiceImpl.submitAutoIncrement(Constant.INC);
		verify(pvuIncrementEventRepository, times(1)).callUsingCallableStmt(Mockito.anyString(), Mockito.anyMap());
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testInsertIncrementInITRs() {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		PvuWFWrapperDto pvuWFWrapperDto = new PvuWFWrapperDto();
		when(pvuIncrementEventRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);
		pvuIncrementEventServiceImpl.insertIncrementInITRs(pvuWFWrapperDto);
		verify(pvuIncrementEventRepository, times(1)).callStoredProcedure(Mockito.anyString(), Mockito.anyMap());
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testApproveRejectIncrementEvent() {
		Object[] object = new Object[1];
		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		PvuWFWrapperDto pvuWFWrapperDto = new PvuWFWrapperDto();
		when(pvuIncrementEventRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);
		assertTrue(pvuIncrementEventServiceImpl.approveRejectIncrementEvent(pvuWFWrapperDto));
	}

	@Test
	void testGetTransactionNumber() throws CustomException {
		Object[] object = new Object[1];

		object[0] = Constant.TRN_SCREEN;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.TRN_SCREEN, "INC");
		when(pvuIncrementEventRepository.callStoredProcedure(
				Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.TRANSACTION_NO_GENERATION)), map))
						.thenReturn(objects);
		assertNotNull(pvuIncrementEventServiceImpl.getTransactionNumber("INC"));
	}

	@Test
	void testApproveRejectIncrement() throws CustomException {
		Object[] objectArray = new Object[1];
		objectArray[0] = "";
		Object object = 0l;
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(objectArray);

		PvuWFWrapperDto pvuWFWrapperDto = new PvuWFWrapperDto();
		pvuWFWrapperDto.setWfStatus(Constant.APPROVED);
		pvuWFWrapperDto.setTrnId(1l);
		pvuWFWrapperDto.setUpdatedDate(new Date());

		when(pvuIncrementEventRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);
		when(pvuIncrementEventRepository.callUsingCallableStmt(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(object);
		pvuIncrementEventServiceImpl.submitAutoIncrement(Constant.INC);
		verify(pvuIncrementEventRepository, times(1)).callUsingCallableStmt(Mockito.anyString(), Mockito.anyMap());
		doNothing().when(pvuEmployeeEventStatusService).resetInProgressEmployeeEventStatus(pvuWFWrapperDto.getTrnId(),
				0l);
		pvuIncrementEventServiceImpl.approveRejectIncrement(pvuWFWrapperDto, Constant.TRN_SCREEN);
		pvuWFWrapperDto.setWfStatus(Constant.REJECTED);
		pvuIncrementEventServiceImpl.approveRejectIncrement(pvuWFWrapperDto, Constant.TRN_SCREEN);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testDeleteIncrementTrns() throws CustomException {
		IdDto idDto = new IdDto(Constant.LONG_ONE_VALUE);
		Date updatedDate = new Date();
		pvuIncrementEventEntity.setStatusId(edpLuLookUpInfoEntity);
		when(pvuIncrementEventEntity.getStatusId()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(Constant.SAVE_AS_DRAFT_STATUS_ID);

		when(pvuIncrementEventRepository.findById(1l)).thenReturn(Optional.of(pvuIncrementEventEntity));
		when(lookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(edpLuLookUpInfoEntity);
		doNothing().when(pvuIncrementEventRepository).deleteIncrementEventIdBy(Constant.IN_ACTIVE_STATUS, idDto.getId(),
				updatedDate, Constant.LONG_ONE_VALUE, Constant.LONG_ONE_VALUE);
		doNothing().when(pvuIncrementEmpServiceImpl).deleteIncrementEmpIdByEventId(Constant.IN_ACTIVE_STATUS,
				idDto.getId(), updatedDate);
		doNothing().when(pvuIncrementEventSummaryService).deleteIncrementSummaryIdByEventId(Constant.IN_ACTIVE_STATUS,
				idDto.getId(), updatedDate);
		assertTrue(pvuIncrementEventServiceImpl.deleteIncrementTrns(idDto));
	}

	@Test
	void testValidateIncrementSubmit() throws CustomException {
		List<PVUEmployeeEventStatusDto> lstPVUEmployeeEventStatusDto = Collections.emptyList();
		List<PVUIncrementEmpDto> lstPVUIncrementEmpDtos = new ArrayList<>();
		PVUIncrementEventDto dto = new PVUIncrementEventDto();
		dto.setDateNextInc(new Date());
		dto.setIncrementEffDate(new Date());
		dto.setEmpNo(Constant.ROP);
		dto.setTrnNo(Constant.ROP);

		PVUIncrementEmpDto empDto = new PVUIncrementEmpDto();
		empDto.setEmpId(Constant.ROP_2009);
		empDto.setIncrementType(Constant.ROP_2009_EVENT);
		empDto.setReasonForExclude(Constant.LONG_ZERO_VALUE);
		lstPVUIncrementEmpDtos.add(empDto);

		List<Long> lstEmpIncludeList = lstPVUIncrementEmpDtos.stream()
				.filter(emp -> (emp.getReasonForExclude() == Constant.LONG_ZERO_VALUE))
				.map(PVUIncrementEmpDto::getEmpId).collect(Collectors.toList());
		when(pvuEmployeeEventStatusService.getEmployeeInProcessByEmpIdsInOtherTrans(lstEmpIncludeList, dto.getTrnNo()))
				.thenReturn(lstPVUEmployeeEventStatusDto);

		List<PVUIncrementCreateListView> lstIncIncludeExclude = new ArrayList<>();
		List<PVUIncrementEmpDto> lstIncrementEmpDto = new ArrayList<>();
		String procName = Constant.PVU_SCHEMA
				.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_INCR_INCLUDE_EXCLUDE));

		PVUIncrementCreateListView view = new PVUIncrementCreateListView();
		view.setEmpId(Constant.ROP_2009);
		view.setIncrementType(Constant.ROP_2009_EVENT);

		lstIncIncludeExclude.add(view);
		lstIncrementEmpDto.add(empDto);
		dto.setPvuIncrementEmpDtos(lstIncrementEmpDto);

		Map<String, Object> map = new HashMap<>();
		map.put("IN_OFFICE_ID", String.valueOf(dto.getOfficeId()));
		map.put("IN_INCR_FOR", String.valueOf(dto.getIncrementFor()));
		map.put("IN_FY", String.valueOf(dto.getFinancialYear()));
		map.put("IN_EMP_TYPE", String.valueOf(dto.getEmpType()));
		map.put("IN_CLASS_ID", String.valueOf(dto.getClassId()));
		map.put("IN_EMP_PAY_TYPE", String.valueOf(dto.getEmpPayType()));
		map.put("IN_DESIGNATION_ID", String.valueOf(dto.getDesignationId()));
		map.put("IN_INCR_EFFECTIVE_DATE", Utils.getDateStr(dto.getIncrementEffDate()));
		map.put("IN_DATE_NXT_INCR", Utils.getDateStr(dto.getDateNextInc()));
		map.put("IN_EMPLOYEE_NO", String.valueOf(dto.getEmpNo().isEmpty() ? "0" : dto.getEmpNo()));
		map.put("IN_PPAN_NO", "");
		map.put(Constant.IN_PAGE_INDEX, 0);
		map.put(Constant.IN_PAGE_SIZE, 250);
		map.put(Constant.IN_USER_LIST, "1");

		when(pvuIncrementEventRepository.storeProc(procName, map, PVUIncrementCreateListView.class))
				.thenReturn(lstIncIncludeExclude);
		assertTrue(pvuIncrementEventServiceImpl.validateIncrementSubmit(dto));
	}

	@Test
	void testValidateAtLeastOneIncludeRecord() throws CustomException {
		List<PVUIncrementEmpDto> lstPVUIncrementEmpDtos = new ArrayList<>();
		PVUIncrementEmpDto empDto = new PVUIncrementEmpDto();
		empDto.setEmpId(Constant.ROP_2009);
		empDto.setIncrementType(Constant.ROP_2009_EVENT);
		empDto.setReasonForExclude(Constant.LONG_ZERO_VALUE);
		lstPVUIncrementEmpDtos.add(empDto);
		pvuIncrementEventServiceImpl.validateAtLeastOneIncludeRecord(lstPVUIncrementEmpDtos);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testValidateNoInProgressEventWithTransNo() throws CustomException {
		List<PVUEmployeeEventStatusDto> lstPVUEmployeeEventStatusDto = Collections.emptyList();
		String transNo = Constant.ROP;
		List<PVUIncrementEmpDto> lstPVUIncrementEmpDtos = new ArrayList<>();
		PVUIncrementEmpDto empDto = new PVUIncrementEmpDto();
		empDto.setEmpId(Constant.ROP_2009);
		empDto.setIncrementType(Constant.ROP_2009_EVENT);
		empDto.setReasonForExclude(Constant.LONG_ZERO_VALUE);
		lstPVUIncrementEmpDtos.add(empDto);

		List<Long> lstEmpIncludeList = lstPVUIncrementEmpDtos.stream()
				.filter(emp -> (emp.getReasonForExclude() == Constant.LONG_ZERO_VALUE))
				.map(PVUIncrementEmpDto::getEmpId).collect(Collectors.toList());

		when(pvuEmployeeEventStatusService.getEmployeeInProcessByEmpIdsInOtherTrans(lstEmpIncludeList, transNo))
				.thenReturn(lstPVUEmployeeEventStatusDto);
		pvuIncrementEventServiceImpl.validateNoInProgressEvent(lstPVUIncrementEmpDtos, transNo);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void validateNoInProgressEventWithOutTransNo() throws CustomException {
		List<PVUEmployeeEventStatusDto> lstPVUEmployeeEventStatusDto = Collections.emptyList();
		List<PVUIncrementEmpDto> lstPVUIncrementEmpDtos = new ArrayList<>();
		PVUIncrementEmpDto empDto = new PVUIncrementEmpDto();
		empDto.setEmpId(Constant.ROP_2009);
		empDto.setIncrementType(Constant.ROP_2009_EVENT);
		empDto.setReasonForExclude(Constant.LONG_ZERO_VALUE);
		lstPVUIncrementEmpDtos.add(empDto);

		List<Long> lstEmpIncludeList = lstPVUIncrementEmpDtos.stream()
				.filter(emp -> (emp.getReasonForExclude() == Constant.LONG_ZERO_VALUE))
				.map(PVUIncrementEmpDto::getEmpId).collect(Collectors.toList());

		when(pvuEmployeeEventStatusService.getEmployeeInProcessByEmpIds(lstEmpIncludeList))
				.thenReturn(lstPVUEmployeeEventStatusDto);
		pvuIncrementEventServiceImpl.validateNoInProgressEvent(lstPVUIncrementEmpDtos, null);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void validateEmpSalaryInSync() throws CustomException {
		List<PVUIncrementEmpDto> lstIncrementEmpDto = new ArrayList<>();
		String procName = Constant.PVU_SCHEMA
				.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_INCR_INCLUDE_EXCLUDE));

		PVUIncrementCreateListView view = new PVUIncrementCreateListView();
		view.setEmpId(Constant.ROP_2009);
		view.setIncrementType(Constant.ROP_2009_EVENT);
		when(dto.getDateNextInc()).thenReturn(new Date());
		when(dto.getIncrementEffDate()).thenReturn(new Date());
		when(dto.getEmpNo()).thenReturn(Constant.ROP);

		PVUIncrementEmpDto empDto = new PVUIncrementEmpDto();
		empDto.setEmpId(Constant.ROP_2009);
		empDto.setIncrementType(Constant.ROP_2009_EVENT);

		lstIncIncludeExclude.add(view);
		lstIncrementEmpDto.add(empDto);
		dto.setPvuIncrementEmpDtos(lstIncrementEmpDto);

		Map<String, Object> map = new HashMap<>();
		map.put("IN_OFFICE_ID", String.valueOf(dto.getOfficeId()));
		map.put("IN_INCR_FOR", String.valueOf(dto.getIncrementFor()));
		map.put("IN_FY", String.valueOf(dto.getFinancialYear()));
		map.put("IN_EMP_TYPE", String.valueOf(dto.getEmpType()));
		map.put("IN_CLASS_ID", String.valueOf(dto.getClassId()));
		map.put("IN_EMP_PAY_TYPE", String.valueOf(dto.getEmpPayType()));
		map.put("IN_DESIGNATION_ID", String.valueOf(dto.getDesignationId()));
		map.put("IN_INCR_EFFECTIVE_DATE", Utils.getDateStr(dto.getIncrementEffDate()));
		map.put("IN_DATE_NXT_INCR", Utils.getDateStr(dto.getDateNextInc()));
		map.put("IN_EMPLOYEE_NO", String.valueOf(dto.getEmpNo().isEmpty() ? "0" : dto.getEmpNo()));
		map.put("IN_PPAN_NO", "");
		map.put(Constant.IN_PAGE_INDEX, 0);
		map.put(Constant.IN_PAGE_SIZE, 250);
		map.put(Constant.IN_USER_LIST, "1");
		when(pvuIncrementEventServiceImpl.getIncrementCreateIncludeExcludeEvent(map)).thenReturn(lstIncIncludeExclude);
		when(pvuIncrementEventRepository.storeProc(procName, map, PVUIncrementCreateListView.class))
				.thenReturn(lstIncIncludeExclude);
		assertTrue(Boolean.TRUE);
	}

	@Test
	void testPrepareIncExcReqestMap() {
		PVUIncrementEventDto dto = new PVUIncrementEventDto();
		dto.setDateNextInc(new Date());
		dto.setIncrementEffDate(new Date());
		dto.setEmpNo("");
		assertNotNull(pvuIncrementEventServiceImpl.prepareIncExcReqestMap(dto));
	}

	@Test
	void testIsSearchCriteriaChangedTrue() {
		when(pvuIncrementEventEntity.getInEventId()).thenReturn(Constant.ROP_2009);
		when(requestedEntity.getInEventId()).thenReturn(Constant.ROP_2016);
		assertTrue(pvuIncrementEventServiceImpl.isSearchCriteriaChanged(pvuIncrementEventEntity, requestedEntity));
	}

	@Test
	void testIsSalaryInSalaryInSynch() {
		List<PVUIncrementCreateListView> lstIncIncludeExclude = new ArrayList<>();
		List<PVUIncrementEmpDto> lstIncrementEmpDto = new ArrayList<>();

		PVUIncrementCreateListView view = new PVUIncrementCreateListView();
		PVUIncrementEmpDto dto = new PVUIncrementEmpDto();

		view.setEmpId(Constant.ROP_2009);
		view.setIncrementType(Constant.ROP_2009_EVENT);

		dto.setEmpId(Constant.ROP_2009);
		dto.setIncrementType(Constant.ROP_2009_EVENT);

		lstIncIncludeExclude.add(view);
		lstIncrementEmpDto.add(dto);

		assertTrue(pvuIncrementEventServiceImpl.isSalaryInSalaryInSynch(lstIncIncludeExclude, lstIncrementEmpDto));
	}

	@Test
	void testIsSalaryInSalaryInSynchFalse() {
		List<PVUIncrementCreateListView> lstIncIncludeExclude = new ArrayList<>();
		List<PVUIncrementEmpDto> lstIncrementEmpDto = new ArrayList<>();

		PVUIncrementCreateListView view = new PVUIncrementCreateListView();
		PVUIncrementEmpDto dto = new PVUIncrementEmpDto();

		view.setEmpId(Constant.ROP_2009);
		view.setIncrementType(Constant.ROP_2009_EVENT);
		view.setClassId(12);

		dto.setEmpId(Constant.ROP_2009);
		dto.setIncrementType(Constant.ROP_2009_EVENT);
		dto.setClassId(13);

		lstIncIncludeExclude.add(view);
		lstIncrementEmpDto.add(dto);

		assertFalse(pvuIncrementEventServiceImpl.isSalaryInSalaryInSynch(lstIncIncludeExclude, lstIncrementEmpDto));
	}

	@Test
	void testIsSearchCriteriaChangedFalse() {
		Date date = new Date();
		when(pvuIncrementEventEntity.getInEventId()).thenReturn(Constant.ROP_2009);
		when(pvuIncrementEventEntity.getTrnNo()).thenReturn(Constant.ROP_2009_EVENT);
		when(pvuIncrementEventEntity.getFinancialYear()).thenReturn(edpMsFinancialYearEntity);
		when(pvuIncrementEventEntity.getIncrementFor()).thenReturn(edpLuLookUpInfoEntity);
		when(pvuIncrementEventEntity.getIncrementType()).thenReturn(edpLuLookUpInfoEntity);
		when(pvuIncrementEventEntity.getEmpPayType()).thenReturn(edpLuLookUpInfoEntity);
		when(pvuIncrementEventEntity.getEmpType()).thenReturn(edpLuLookUpInfoEntity);
		when(pvuIncrementEventEntity.getClassId()).thenReturn(edpLuLookUpInfoEntity);
		when(pvuIncrementEventEntity.getDesignationId()).thenReturn(edpMsDesignationEntity);
		when(pvuIncrementEventEntity.getIncrementEffDate()).thenReturn(date);
		when(pvuIncrementEventEntity.getDateNextInc()).thenReturn(date);
		when(pvuIncrementEventEntity.getEmpNo()).thenReturn(Constant.ROP_2009_EVENT);

		when(requestedEntity.getInEventId()).thenReturn(Constant.ROP_2009);
		when(requestedEntity.getTrnNo()).thenReturn(Constant.ROP_2016_EVENT);
		when(requestedEntity.getFinancialYear()).thenReturn(reqEdpMsFinancialYearEntity);
		when(requestedEntity.getIncrementFor()).thenReturn(reqEdpLuLookUpInfoEntity);
		when(requestedEntity.getIncrementType()).thenReturn(reqEdpLuLookUpInfoEntity);
		when(requestedEntity.getEmpPayType()).thenReturn(reqEdpLuLookUpInfoEntity);
		when(requestedEntity.getEmpType()).thenReturn(reqEdpLuLookUpInfoEntity);
		when(requestedEntity.getClassId()).thenReturn(reqEdpLuLookUpInfoEntity);
		when(requestedEntity.getDesignationId()).thenReturn(reqEdpMsDesignationEntity);
		when(requestedEntity.getIncrementEffDate()).thenReturn(date);
		when(requestedEntity.getDateNextInc()).thenReturn(date);
		when(requestedEntity.getEmpNo()).thenReturn(Constant.ROP_2009_EVENT);

		when(edpMsFinancialYearEntity.getFinancialYearId()).thenReturn(Constant.ROP_2009);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(Constant.ROP_2009);
		when(edpMsDesignationEntity.getDesignationId()).thenReturn(Constant.ROP_2009);

		when(reqEdpMsFinancialYearEntity.getFinancialYearId()).thenReturn(Constant.ROP_2009);
		when(reqEdpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(Constant.ROP_2009);
		when(reqEdpMsDesignationEntity.getDesignationId()).thenReturn(Constant.ROP_2009);

		assertFalse(pvuIncrementEventServiceImpl.isSearchCriteriaChanged(pvuIncrementEventEntity, requestedEntity));
	}
}
