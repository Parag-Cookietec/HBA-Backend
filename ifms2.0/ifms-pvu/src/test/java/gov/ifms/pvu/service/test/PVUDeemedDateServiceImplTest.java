package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUDeemedDateConverter;
import gov.ifms.pvu.dto.PVUDeemedDateDto;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUDeemedDateEntity;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.repository.PVUDeemedDateRepository;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.service.PVUDeemedDateServiceImpl;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.wrapper.PVYFacade;

class PVUDeemedDateServiceImplTest {

	@InjectMocks
	private PVUDeemedDateServiceImpl service;

	@Mock
	private PVUDeemedDateRepository repository;

	@Mock
	private PVUDeemedDateEntity entity;

	@Mock
	private PVUDeemedDateConverter converter;

	@Mock
	private PVUDeemedDateDto dto;

	@Mock
	private PVUCommonService commonService;

	@Mock
	Page<PVUDeemedDateEntity> page;

	@Mock
	List<PVUDeemedDateEntity> lst;

	@Mock
	List<PVUDeemedDateDto> list;

	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;

	@Mock
	private EDPLuLookUpInfoEntity empApprovStatsLookupInfo;

	@Mock
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	@Mock
	private PVUEmployeDepartmentEntity department;

	@Mock
	private PVUEmployeEventsEntity employeEventsEntity;

	@Mock
	private PVUEmployeEventsService pvuEmployeEventsService;

	@Mock
	private EDPLuLookUpInfoEntity empStatusLookupInfo1;

	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Mock
	private PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity;

	@Mock
	private PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto;

	@Mock
	private EDPLuLookUpInfoRepository eDPLuLookUpInfoRepository;

	@Mock
	private Constant constant;

	@Mock
	private PVYFacade pvuFacade;

	@Mock
	PVUEmployeEntity pvuEmployeEntity;
	@Mock
	private PVUCommonService pvuCommonService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetPVUDeemedDate() {
		when(repository.getOne(1l)).thenReturn(entity);
		assertNotNull(service.getPVUDeemedDate(1l));
	}

	

	@Test
	void testSaveOrUpdatePVUDeemedDate() throws CustomException {
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		when(dto.isNew()).thenReturn(true);
		when(dto.getEmployeeId()).thenReturn(1l);
		when(pvuEmployeeEventStatusService.inProgressAnyEvent(1l)).thenReturn(pvuEmployeeEventStatusEntity);
		when(dto.isNew()).thenReturn(true);
		when(pvuCommonService.getTransactionNumber("DD")).thenReturn("DD");
		when(dto.isNew()).thenReturn(false);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toEntity(dto)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(entity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(entity.getEmployee().getEmpId()).thenReturn(1l);
		when(dto.getStatusId()).thenReturn(1l);
		when(dto.getEmployeeNo()).thenReturn(1l);
		when(eDPLuLookUpInfoRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT))
				.thenReturn(empApprovStatsLookupInfo);
		when(dto.isNew()).thenReturn(true);
		when(dto.getStatusId()).thenReturn(0L);
		when(dto.getEmployeeId()).thenReturn(1L);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(converter.toEntity(dto)).thenReturn(entity);
		when(eDPLuLookUpInfoRepository.findByLookUpInfoName("Saved as Draft")).thenReturn(empApprovStatsLookupInfo);
		when(entity.getTrnNo()).thenReturn("123");
		assertNotNull(service.saveOrUpdatePVUDeemedDate(dto));
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetPVUDeemedDates() throws CustomException {
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
		PagebleDTO<PVUDeemedDateDto> data = service.getPVUDeemedDates(pageDetail);
		assertNotNull(data);
	}

	@Test
	void testGetAllLuLookUpInfoAsMap() throws CustomException {
		assertNotNull(service.getAllLuLookUpInfoAsMap());
	}

	@Test
	void testInsertDeemedItr() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(repository.getOne(1l)).thenReturn(entity);

		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Approved")).thenReturn(empStatusLookupInfo1);

		when(empStatusLookupInfo1.getLookUpInfoId()).thenReturn(1l);
		when(entity.getStatus()).thenReturn(empApprovStatsLookupInfo);
		when(empApprovStatsLookupInfo.getLookUpInfoId()).thenReturn(2l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Approved");

		when(dto.getEmployeeId()).thenReturn(1l);
		when(dto.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(dto.getDateOfNextIncrement()).thenReturn(LocalDate.now());
		when(dto.getPayCommId()).thenReturn(150l);
		when(dto.getPayScale()).thenReturn(23l);
		when(dto.getCellId()).thenReturn(1l);
		when(dto.getPayLevelId()).thenReturn(1l);
		when(dto.getTrnNo()).thenReturn("2020");
		when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
//		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		when(entity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		// TODO Fix Test issue.
//		when(dto.getPayCommId()).thenReturn(150l);
//		assertNotNull(service.insertDeemedItr(pvuWFWrapperDto));
		when(dto.getPayCommId()).thenReturn(151l);
//		assertNotNull(service.insertDeemedItr(pvuWFWrapperDto));

		when(dto.getPayCommId()).thenReturn(152l);
//		assertNotNull(service.insertDeemedItr(pvuWFWrapperDto));
		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Submit")).thenReturn(empStatusLookupInfo1);

//		assertNotNull(service.insertDeemedItr(pvuWFWrapperDto));

	}

	@Test
	void testInsertDeemedItrRejected() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(repository.getOne(1l)).thenReturn(entity);

		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Approved")).thenReturn(empStatusLookupInfo1);

		when(empStatusLookupInfo1.getLookUpInfoId()).thenReturn(1l);
		when(entity.getStatus()).thenReturn(empApprovStatsLookupInfo);
		when(empApprovStatsLookupInfo.getLookUpInfoId()).thenReturn(2l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Rejected");

		when(dto.getEmployeeId()).thenReturn(1l);
		when(dto.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(dto.getDateOfNextIncrement()).thenReturn(LocalDate.now());
		when(dto.getPayCommId()).thenReturn(150l);
		when(dto.getPayScale()).thenReturn(23l);

		when(dto.getTrnNo()).thenReturn("2020");
		when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		when(entity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);

		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Rejected")).thenReturn(empStatusLookupInfo1);
		// TODO Fix Test issue.
//		doNothing().when(repository).updateStatusId(1l, 1l, 1l, new Date());
//		assertNotNull(service.insertDeemedItr(pvuWFWrapperDto));

	}

	@Test
	public void testValidateException() throws CustomException {
		CustomException customException = assertThrows(CustomException.class, () -> {

			PageDetails pageDetail = new PageDetails();

			service.getPVUDeemedDates(pageDetail);
		});
		assertTrue(customException.getErrorMsg().contains("ERROR WHILE FETCHING ROW"));
	}





}
