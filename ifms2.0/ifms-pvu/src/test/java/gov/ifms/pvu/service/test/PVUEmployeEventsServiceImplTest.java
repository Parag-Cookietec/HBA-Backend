package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.pvu.converter.PVUEmployeEventsConverter;
import gov.ifms.pvu.dto.PVUEmployeEventsDto;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUIncrementEventEntity;
import gov.ifms.pvu.repository.PVUEmployeEventsRepository;
import gov.ifms.pvu.repository.PVUIncrementEventRepository;
import gov.ifms.pvu.service.PVUEmployeEventsServiceImpl;
import gov.ifms.pvu.util.PvuConstant;

class PVUEmployeEventsServiceImplTest {
	@InjectMocks
	private PVUEmployeEventsServiceImpl service;

	@Mock
	private PVUEmployeEventsRepository repository;

	@Mock
	private PVUEmployeEventsEntity entity;

	@Mock
	private PVUEmployeEventsDto dto;

	@Mock
	private PVUEmployeEventsConverter converter;

	@Mock
	List<PVUEmployeEventsDto> dtoLst;

	@Mock
	List<PVUEmployeEventsEntity> entityLst;

	@Mock
	Page<PVUEmployeEventsEntity> page;

	@Mock
	List<PVUEmployeEventsEntity> lst;

	@Mock
	List<PVUEmployeEventsDto> list;

	@Mock
	private PVUIncrementEventRepository incrementRepo;

	@Mock
	private PVUIncrementEventEntity incEntity;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetEmployeEvents() {

		when(repository.getOne(1L)).thenReturn(entity);
		assertNotNull(service.getEmployeEvents(1L));
		verify(repository, times(1)).getOne(1L);
	}

	@Test
	void testSaveOrUpdateEmployeEvents() {
		when(repository.save(entity)).thenReturn(entity);
		assertEquals(entity, service.saveOrUpdateEmployeEvents(entity));
		verify(repository, times(1)).save(entity);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetEmployeEventss() throws CustomException {
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
		assertNotNull(service.getEmployeEventss(pageDetail));
	}

	@Test
	void testStoreProcPvu() throws CustomException {
		assertNotNull(service.storeProcPvu("PVU_EMPLOYEE_EVENTS", new HashMap<String, Object>()));
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetEmployeJoinPayEvents() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("eventId", "1"));
		jsonArr.add(new SearchParam("transacNumber", "1"));
		jsonArr.add(new SearchParam("empName", "V"));
		jsonArr.add(new SearchParam("eventDate", " "));
		jsonArr.add(new SearchParam("empPayScalPayBand", ""));
		jsonArr.add(new SearchParam("gradPayPayLevel", ""));
		jsonArr.add(new SearchParam("payGrandValuCellId", "0"));
		jsonArr.add(new SearchParam("empBasicPay", "0"));
		jsonArr.add(new SearchParam("incrementDate", " "));
		jsonArr.add(new SearchParam("designation", "0"));
		jsonArr.add(new SearchParam("approvalDate", ""));
		jsonArr.add(new SearchParam("personalPay", " "));
		jsonArr.add(new SearchParam("status", "0"));
		jsonArr.add(new SearchParam("recored", "0"));
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		when(repository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(lst);
		when(converter.toDTO(lst)).thenReturn(list);
		assertNotNull(service.getEmployeJoinPayEvents(pageDetail));
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetSusEolDetails() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("empEventId", "1"));
		jsonArr.add(new SearchParam("empId", "1"));
		jsonArr.add(new SearchParam("transacNumber", "V"));
		jsonArr.add(new SearchParam("eventName", " "));
		jsonArr.add(new SearchParam("fromDate", ""));
		jsonArr.add(new SearchParam("endDate", ""));
		jsonArr.add(new SearchParam("designationId", "0"));
		jsonArr.add(new SearchParam("designation", ""));
		jsonArr.add(new SearchParam("empBasicPay", " "));
		jsonArr.add(new SearchParam("activeStatus", "0"));
		jsonArr.add(new SearchParam("recored", "0"));
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		when(repository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(lst);
		when(converter.toDTO(lst)).thenReturn(list);
		assertNotNull(service.getSusEolDetails(pageDetail));
	}

	@SuppressWarnings("unchecked")
	@Test
	void getEmpTrnEvent() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("eventId", "1"));
		jsonArr.add(new SearchParam("transacNumber", "1"));
		jsonArr.add(new SearchParam("designationId", "V"));
		jsonArr.add(new SearchParam("designation", " "));
		jsonArr.add(new SearchParam("fromLocation", ""));
		jsonArr.add(new SearchParam("toLocation", ""));
		jsonArr.add(new SearchParam("aprovalDate", "0"));
		jsonArr.add(new SearchParam("status", "0"));
		jsonArr.add(new SearchParam("recored", " "));
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		when(repository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(lst);
		when(converter.toDTO(lst)).thenReturn(list);
		assertNotNull(service.getEmpTrnEvent(pageDetail));
	}

	@SuppressWarnings("unchecked")
	@Test
	void getEmpEventTabRevisedTest() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("eventCode", "EOL"));
		jsonArr.add(new SearchParam("regOrRevType", "0"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		when(repository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(lst);
		when(converter.toDTO(lst)).thenReturn(list);
		assertNotNull(service.getEmpEventTabRevised(pageDetail));
	}

	@SuppressWarnings("unchecked")
	@Test
	void getLatestRevisionNoTest() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("eventCode", "EOL"));
		jsonArr.add(new SearchParam("regOrRevType", "0"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		when(repository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(lst);
		when(converter.toDTO(lst)).thenReturn(list);
		assertNotNull(service.getLatestRevisionNo(1L, 151l));
	}

	@Test
	void findAllByEmpIdAndEventNameAndActiveStatus() throws CustomException {
		assertNotNull(service.findAllByEmpIdAndEventNameAndActiveStatus(1l, "EOL"));
	}

	@SuppressWarnings("unchecked")
	@Test
	void getSusEolDetailsTest() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("eventCode", "EOL"));
		jsonArr.add(new SearchParam("regOrRevType", "0"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		when(repository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(lst);
		when(converter.toDTO(lst)).thenReturn(list);
		assertNotNull(service.getSusEolDetails(pageDetail));
	}

	@SuppressWarnings("unchecked")
	@Test
	void getEmpTrnEventTest() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("eventCode", "EOL"));
		jsonArr.add(new SearchParam("regOrRevType", "0"));
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		when(repository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(lst);
		when(converter.toDTO(lst)).thenReturn(list);
		assertNotNull(service.getEmpTrnEvent(pageDetail));
	}

	@Test
	void getEventIdByEventCodeAndTrnNoTest() throws CustomException {
		when(incrementRepo.findByTrnNo("20-21/PVU/INC/006568")).thenReturn(incEntity);
		when(incEntity.getInEventId()).thenReturn(1l);
		assertNotNull(service.getEventIdByEventCodeAndTrnNo(PvuConstant.EVENT_CODE_INCREMENT, "20-21/PVU/INC/006568"));
	}

}
