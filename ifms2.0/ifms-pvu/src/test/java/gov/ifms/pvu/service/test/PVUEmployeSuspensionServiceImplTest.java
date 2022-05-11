package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.*;

import gov.ifms.pvu.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.converter.PVUEmployeSuspensionConverter;
import gov.ifms.pvu.dto.PVUEmployeSuspensionDto;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeSuspensionRepository;
import gov.ifms.pvu.repository.PVUSuspensionPayDetailsRepository;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeSuspensionServiceImpl;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.wrapper.PVYFacade;

class PVUEmployeSuspensionServiceImplTest {

	@InjectMocks
	private PVUEmployeSuspensionServiceImpl service;

	@Mock
	private PVUEmployeSuspensionRepository repository;

	@Mock
	private PVUEmployeSuspensionEntity entity;

	@Mock
	private PVUEmployeSuspensionDto dto;

	@Mock
	private PVUEmployeEntity pvuEmployeEntity;

	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Mock
	private PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity;

	@Mock
	private PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto;


	@Mock
	private EDPLuLookUpInfoEntity empApprovStatsLookupInfo;

	@Mock
	private EDPLuLookUpInfoEntity diff;

	@Mock
	private PvuWFWrapperDto wrapperDto;

	@Mock
	private PVYFacade pvuFacade;

	@Mock
	private PVUSuspensionPayDetailsEntity payDetailsEntity;

	@Mock
	private PVUEmployeSuspensionConverter converter;

	@Mock
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	@Mock
	private PVUEmployeDepartmentEntity department;

	@Mock
	private PVUEmployeEventsEntity employeEventsEntity;

	@Mock
	private PVUEmployeEventsService pvuEmployeEventsService;

	@Mock
	private EDPLuLookUpInfoRepository eDPLuLookUpInfoRepository;

	@Mock
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Mock
	private EDPMsDesignationEntity edpMsDesignationEntity;

	@Mock
	private PVUSuspensionPayDetailsRepository pvuSuspensionPayDetailsRepository;




	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetPVUEmployeSuspension() throws CustomException {
		when(repository.getOne(1L)).thenReturn(entity);
		service.getPVUEmployeSuspension(1L);
		verify(repository, times(1)).getOne(1L);
	}

	@Test
	@Disabled
	void testSaveOrUpdatePVUEmployeSuspension() throws CustomException {
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(entity.getId()).thenReturn(0l);
		when(entity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(pvuEmployeeEventStatusService.getEventStatus(pvuEmployeeEventStatusEntity))
				.thenReturn(pvuEmployeeEventStatusDto);
		when(pvuEmployeeEventStatusDto.getEol()).thenReturn(1L);
		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Approved")).thenReturn(empApprovStatsLookupInfo);
		when(dto.getSusStartDate()).thenReturn(LocalDate.now());
		when(dto.getSusEndDate()).thenReturn(LocalDate.now());
		when(dto.getSusEventDate()).thenReturn(LocalDate.now());
		when(dto.getPayCommission()).thenReturn(152l);
		when(dto.getEmpId()).thenReturn(1l);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		service.saveOrUpdatePVUEmployeSuspension(entity);
		verify(repository, times(1)).save(entity);

		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(entity.getId()).thenReturn(3l);
		when(entity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(pvuEmployeeEventStatusService.getEventStatus(pvuEmployeeEventStatusEntity))
				.thenReturn(pvuEmployeeEventStatusDto);

		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Approved")).thenReturn(empApprovStatsLookupInfo);
		when(dto.getSusStartDate()).thenReturn(LocalDate.now());
		when(dto.getSusEndDate()).thenReturn(LocalDate.now());
		service.saveOrUpdatePVUEmployeSuspension(entity);

	}

	@Test
	void testGetPVUEmployeSuspensions() throws CustomException {
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
		assertNotNull(service.getPVUEmployeSuspensions(pageDetail));

	}

	@Test
	void testGetAllLuLookUpInfoAsMap() throws CustomException {
		service.getAllLuLookUpInfoAsMap();
	}
	@Test
	void testInsertInITR() throws CustomException {
		when(wrapperDto.getTrnId()).thenReturn(1L);
		when(repository.findWithPayDetailsEntityById(1L)).thenReturn(Optional.of(entity));
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1, "Approved"))
                .thenReturn(empApprovStatsLookupInfo);
		when(wrapperDto.getWfStatus()).thenReturn("Approved");
		when(empApprovStatsLookupInfo.getLookUpInfoId()).thenReturn(1L);
		when(entity.getStatus()).thenReturn(empApprovStatsLookupInfo);
		when(dto.getEmpId()).thenReturn(1L);
		when(pvuFacade.callWorkFlowApis(wrapperDto)).thenReturn(true);
		when(empApprovStatsLookupInfo.getLookUpInfoId()).thenReturn(1L);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Submit")).thenReturn(empApprovStatsLookupInfo);
		when(empApprovStatsLookupInfo.getLookUpInfoId()).thenReturn(3L);
		when(diff.getLookUpInfoId()).thenReturn(2L);
		when(payDetailsEntity.getStatus()).thenReturn(diff);
		List<PVUSuspensionPayDetailsEntity> list = Collections.singletonList(payDetailsEntity);

        when(entity.getPayDetailsEntity()).thenReturn(list);
		when(entity.getUpdatedDate()).thenReturn(new Date());
		when(edpMsDesignationEntity.getDesignationId()).thenReturn(1L);
		when(department.getDesignationId()).thenReturn(edpMsDesignationEntity);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);

		when(dto.getSusStartDate()).thenReturn(LocalDate.now());
		when(dto.getTrnNo()).thenReturn("2020");
		when(pvuEmployeEntity.getEmpId()).thenReturn(1L);
        when(entity.getEmployee()).thenReturn(pvuEmployeEntity);
        when(entity.isSuspensionClosure()).thenReturn(true);
        when(pvuEmployeeEventStatusService.findByEmpId(1L)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
        when(lookUpInfoRepository
                .findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
                        Constant.ACTIVE_STATUS, Constant.REJECTED)).thenReturn(empApprovStatsLookupInfo);
     // TODO Fix Test issue.
//        when(service.insertInITR(wrapperDto)).thenReturn(dto);


		when(entity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.REJECTED)).thenReturn(empApprovStatsLookupInfo);
		when(department.getDesignationId()).thenReturn(edpMsDesignationEntity);
		when(edpMsDesignationEntity.getDesignationId()).thenReturn(1l);

//		assertNotNull(service.insertInITR(wrapperDto));


		when(wrapperDto.getTrnId()).thenReturn(1l);
		when(repository.findWithPayDetailsEntityById(1l)).thenReturn(Optional.of(entity));
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1, "Approved")).thenReturn(empApprovStatsLookupInfo);
		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1, "Approved")).thenReturn(empApprovStatsLookupInfo);
		when(wrapperDto.getWfStatus()).thenReturn("Approval in Progess");
		when(empApprovStatsLookupInfo.getLookUpInfoId()).thenReturn(1l);
		when(entity.getStatus()).thenReturn(empApprovStatsLookupInfo);
		when(empApprovStatsLookupInfo.getLookUpInfoId()).thenReturn(2l);
		when(dto.getEmpId()).thenReturn(1l);
		when(pvuFacade.callWorkFlowApis(wrapperDto)).thenReturn(true);
		when(empApprovStatsLookupInfo.getLookUpInfoId()).thenReturn(1L);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Submit")).thenReturn(empApprovStatsLookupInfo);
		when(entity.getUpdatedDate()).thenReturn(new Date());
		when(converter.toDTO(entity)).thenReturn(dto);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);

		when(dto.getSusStartDate()).thenReturn(LocalDate.now());
		when(dto.getTrnNo()).thenReturn("2020");

		when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
		when(entity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));

//		assertNotNull(service.insertInITR(wrapperDto));


		when(wrapperDto.getTrnId()).thenReturn(1l);
		when(repository.findWithPayDetailsEntityById(1l)).thenReturn(Optional.of(entity));
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1, "Rejected")).thenReturn(empApprovStatsLookupInfo);
//				when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1, "Approved")).thenReturn(empApprovStatsLookupInfo);
		when(wrapperDto.getWfStatus()).thenReturn("Rejected");
		when(empApprovStatsLookupInfo.getLookUpInfoId()).thenReturn(1l);
		when(entity.getStatus()).thenReturn(empApprovStatsLookupInfo);
		when(empApprovStatsLookupInfo.getLookUpInfoId()).thenReturn(2l);
		when(dto.getEmpId()).thenReturn(1l);
		when(pvuFacade.callWorkFlowApis(wrapperDto)).thenReturn(true);
		when(empApprovStatsLookupInfo.getLookUpInfoId()).thenReturn(1L);
		when(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Submit")).thenReturn(empApprovStatsLookupInfo);
		when(entity.getUpdatedDate()).thenReturn(new Date());
		when(converter.toDTO(entity)).thenReturn(dto);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);

		when(dto.getSusStartDate()).thenReturn(LocalDate.now());
		when(dto.getTrnNo()).thenReturn("2020");

		when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
		when(entity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));

//		assertNotNull(service.insertInITR(wrapperDto));
	}

	@Test
	void deletePayDetail() {
		service.deletePayDetail(1l);
	}

	@Test
	public void testSuspensionCriteriaPayCommissionCheck(){
		when(dto.getSusEventDate()).thenReturn(LocalDate.now());
		when(dto.getPayCommission()).thenReturn(1L);
		when(dto.getEmpId()).thenReturn(1L);
		Object[] object = new Object[1];
		object[0] = "false";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		service.suspensionCriteriaPayCommisionCheck(dto);

		object[0] = "true";
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		service.suspensionCriteriaPayCommisionCheck(dto);
	}


	@Test
	public void testGetOneByTrnNo() throws CustomException {
		when(repository.findOneByTrnNo("AAA")).thenReturn(Optional.of(entity));
		service.getOneByTrnNo("AAA");
	}

}
