package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.repository.PVUEmployeeEventStatusRepository;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.converter.EDPMsDesignationConverter;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.converter.EDPMsOfficeConverter;
import gov.ifms.edp.dto.EDPMsDesignationDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.pvu.converter.PVUTransferConverter;
//import gov.ifms.pvu.entity.PVUTransferEmployeeEntity;
import gov.ifms.pvu.entity.PVUTransferEntity;
//import gov.ifms.pvu.repository.PVUTransferEmployeeRepository;
import gov.ifms.pvu.repository.PVUTransferRepository;
import gov.ifms.pvu.service.PVUTransferServiceImpl;

class PVUTransferServiceImplTest {

	@Mock
	PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto;

	@Mock
	private PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity;

	@Mock
	PVUEmployeeEventStatusRepository repositoryStatus;

	@InjectMocks
	private PVUTransferServiceImpl service;
	@Mock
	private List<PVUSearchEnum> pvuSearchEnums;


	@Mock
	private PVUEmployeEntity pvuEmployeEntity;

	@Mock
	private PVUTransferRepository repository;

	@Mock
	private PVUTransferEntity entity;

	@Mock
	private PVUTransferConverter converter;
	
	@Mock
	private PVUTransferDto dto;

    @Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Mock
	private EDPLuLookUpInfoRepository eDPLuLookUpInfoRepository;

	@Mock
	private EDPMsOfficeRepository officeRepository;

    @Mock
    List<EDPMsOfficeEntity> officeList;
 
    @Mock
    private EDPMsOfficeConverter officeConverter;
    
    @Mock
    List<EDPMsOfficeDto> edpMsOfficeDtos;
    

   @Mock
   private EDPMsDistrictRepository districtRepository;
	
   @Mock
   private List<EDPMsDistrictEntity> lst;
   
   @Mock
   List<EDPSDTDto> dlst;
   
   @Mock
   private EDPMsDistrictConverter districtConverter;
	
   @Mock
   private EDPMsDesignationRepository eDPMsDesignationRepository;
   
   @Mock
   List<EDPMsDesignationEntity> edpen;
   
   @Mock
   List<EDPMsDesignationDto> edpdto;
   
   @Mock
   private EDPMsDesignationConverter eDPMsDesignationConverter;
   
	@Mock
	Page<PVUTransferEntity> page;
	
	@Mock
	List<PVUTransferEntity> tlst;
	
	@Mock
	List<PVUTransferDto> list;

	@Mock
	private EDPLuLookUpInfoEntity transferSubmitStatusLookupInfo;

	@Mock
	private PVUEmployeEventsService pvuEmployeEventsService;

	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;

	@Mock
	private PVYFacade pvuFacade;
	@Mock
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Mock
	private EDPLuLookUpInfoEntity fwdTargetLocation;

   @BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testSaveOrUpdateTransfer() throws CustomException {
		when(converter.toEntity(dto)).thenReturn(entity);
		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Transfer_Status_id", 1,
				"Submit")).thenReturn(transferSubmitStatusLookupInfo);
		when(entity.getStatus()).thenReturn(transferSubmitStatusLookupInfo);
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(dto.getEmployeeNo()).thenReturn(10000000L);
		assertEquals(dto, service.saveOrUpdateTransfer(dto));
	}


	@Test
	void testGetTransferById() {
		when(repository.getOne(1L)).thenReturn(entity);
		assertNotNull(service.getTransferById(1L));
		verify(repository, times(1)).getOne(1L);
	}

	@Test
	void testReset() throws CustomException {
		when(pvuEmployeeEventStatusService.findOneByEmpId(1L)).thenReturn(pvuEmployeeEventStatusEntity);
		when(pvuEmployeeEventStatusEntity.getTransfer()).thenReturn(0L);
		when(pvuEmployeeEventStatusEntity.getTransId()).thenReturn(null);
		when(pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity)).thenReturn(pvuEmployeeEventStatusEntity);
	}
    @Test
	 void testGetJoiningTransferList()throws CustomException {
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
		PagebleDTO<PVUTransferEmployeeView> data = service.getJoiningTransferList(pageDetail);
		assertNotNull(data);
}
	@Test
	void testGetPvuSearchFields() {
		pvuSearchEnums=service.getPvuSearchFields();
		assertNotNull(pvuSearchEnums);
	}

	@Test
	void testStoreProcPvu() throws CustomException {
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);

	}
	@Test
	void testGetTransferList() throws CustomException {
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
		PagebleDTO<PVUTransferEmployeeView> data = service.getTransferList(pageDetail);
		assertNotNull(data);
	}

	@Test
	void testGetTransferSearchFieldsList() {
		pvuSearchEnums=service.getTransferSearchFieldsList();
		assertNotNull(pvuSearchEnums);
	}
	@Test
	void testGetAllLuLookUpInfoAsMap() throws CustomException {
		assertNotNull(service.getAllLuLookUpInfoAsMap());
	}

	@Test
	void testLookupTransferCreationSp() throws CustomException {
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
	}

	@Test
	void testGetOfficeByDistrict() throws CustomException {
		when(officeRepository.findByDistrictIdDistrictIdAndActiveStatusAndIsVerified(1l, Constant.ACTIVE_STATUS, Constant.IS_VERIFIED)).thenReturn(officeList);
		when(officeConverter.toDTO(officeList)).thenReturn(edpMsOfficeDtos);
		assertEquals(edpMsOfficeDtos, service.getOfficeByDistrict(1l));
	}

	@Test
	void testGetLookupDetails() throws CustomException {
		when(districtRepository.findByActiveStatus(Constant.ACTIVE_STATUS)).thenReturn(lst);
		when(districtConverter.toEDPSDTDto(lst)).thenReturn(dlst);
		when(eDPMsDesignationRepository.findByActiveStatusEquals(Constant.ACTIVE_STATUS)).thenReturn(edpen);
		when(eDPMsDesignationConverter.toEDPSDTDto(edpen)).thenReturn(dlst);
	    service.getLookupDetails();

	}
	@Test
	void testGetTransactionNumber() throws CustomException {
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
	}
	@Test
	public void testSaveEmpEvent() {
		repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap());
		PVUEmployeEventsEntity employeeEventsEntity = new PVUEmployeEventsEntity();
		employeeEventsEntity.setTrnNo(dto.getTrnNo());
		employeeEventsEntity.setEventType(PvuConstant.MANUAL);
		employeeEventsEntity.setOfficeId(dto.getOfficeId());
		employeeEventsEntity.setEventName(dto.getEventCode());
		employeeEventsEntity.setEmpId(1L);
		employeeEventsEntity.setActiveStatus(dto.getActiveStatus());
		employeeEventsEntity.setEmpAutoApprove(LocalDateTime.now());
		employeeEventsEntity.setEventId(PvuConstant.TRANSFER_EVENT_ID);
		employeeEventsEntity.setSourceId(PvuConstant.TRANSFER_EVENT_ID);
		employeeEventsEntity.setEmpAutoApprove(LocalDateTime.now());
		employeeEventsEntity.setOfficeId(dto.getCurOfficeId());
		pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeeEventsEntity);
		service.saveEmpEvent(dto,pvuEmployeEntity,"Approved");
	}

	@Test
	void insertInITR() throws CustomException {
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(entity.getPvuEmployeEntity()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(entity.getTrnNo()).thenReturn("Tran1");
		when(pvuEmployeeEventStatusService.getEventStatus(pvuEmployeeEventStatusEntity))
				.thenReturn(pvuEmployeeEventStatusDto);
		when(pvuEmployeeEventStatusService.inProgressAnyEvent(2L)).thenReturn(pvuEmployeeEventStatusEntity);
		when(pvuEmployeeEventStatusDto.getTransfer()).thenReturn(1L);
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1L);
		EDPLuLookUpInfoEntity submitLookupInfo = lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.TRANSFER_STATUS_ID, Constant.ACTIVE_STATUS, Constant.SUBMIT);
/*		when(converter.toDTO(entity)).thenReturn(dto);
		when(dto.getStatusId()).thenReturn(1L);
		when(dto.getEmployeeId()).thenReturn(2L);
		assertEquals(dto,
				service.saveOrUpdateTransfer(dto));
		verify(repository, times(1)).save(entity);*/
		testSaveOrUpdateTransfer();



		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Pending for Joining Date");
		when(lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.TRANSFER_STATUS_ID, Constant.ACTIVE_STATUS, Constant.FORWARD_TARGET_LOCATION)).thenReturn(fwdTargetLocation);
		when(entity.getStatus()).thenReturn(fwdTargetLocation);
		repository.updateStatusId(fwdTargetLocation.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), 	new Date());


		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Pulled Back");
		when(lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.TRANSFER_STATUS_ID, Constant.ACTIVE_STATUS, Constant.PULLBACK_BY_PF_APPROVER)).thenReturn(fwdTargetLocation);
		when(entity.getStatus()).thenReturn(fwdTargetLocation);
		repository.updateStatusId(fwdTargetLocation.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), 	new Date());


		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Approved");
		when(lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.TRANSFER_STATUS_ID, Constant.ACTIVE_STATUS, Constant.DDO_APPROVED)).thenReturn(fwdTargetLocation);
		when(entity.getStatus()).thenReturn(fwdTargetLocation);
		repository.updateStatusId(fwdTargetLocation.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), 	new Date());
		testReset();
		when(converter.toDTO(entity)).thenReturn(dto);
		when(dto.getTrnNo()).thenReturn("TEST1");
		testSaveEmpEvent();


		when(pvuWFWrapperDto.getWfStatus()).thenReturn("REJECTED");
		when(lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.TRANSFER_STATUS_ID, Constant.ACTIVE_STATUS, Constant.REJECTED_BY_TAR_LOC)).thenReturn(fwdTargetLocation);
		when(entity.getStatus()).thenReturn(fwdTargetLocation);
		repository.updateStatusId(fwdTargetLocation.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
				OAuthUtility.getCurrentUserUserId(), 	new Date());





		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);

		assertNotNull(service.insertInITR(pvuWFWrapperDto));
	}


/*

	@Test
	void testDeleteEmpByEmpTransferById() {
		service.deleteEmpByEmpTransferById(1l);
	}

	@Test
	void testGetTransferByEmployee() {
		
		when(employeeRepository.findById(1l)).thenReturn(java.util.Optional.of(pvTransferEmployeeEntity));
		
		service.getTransferByEmployee(1l);
		
		
	}
*//*


	@SuppressWarnings("unchecked")
	//@Test
	void testGetTransfersList() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPvuSearchFields() {
		service.getPvuSearchFields(); 
	}
	@Test
	void testGetTransferSearchFieldsList() {
		service.getTransferSearchFieldsList();
	}


	@Test
	void testGetAllLuLookUpInfoAsMap() throws CustomException {
		service.getAllLuLookUpInfoAsMap();
	}

	*/
/*@Test
	void testGetTransferEmployee() {
		when(employeeRepository.getOne(1l)).thenReturn(pvuTransferEmployeeEntity);
		service.getTransferEmployee(1l);
	}

	@Test
	void testSaveOrUpdateTransferEmployee() {
		when(employeeRepository.save(pvuTransferEmployeeEntity)).thenReturn(pvuTransferEmployeeEntity);
		service.saveOrUpdateTransferEmployee(pvuTransferEmployeeEntity);
	}*//*


	@Test
	void testGetOfficeByDistrict() {
		when(officeRepository.findByDistrictIdDistrictIdAndActiveStatusAndIsVerified(1l, Constant.ACTIVE_STATUS, Constant.IS_VERIFIED)).thenReturn(officeList);
		when(officeConverter.toDTO(officeList)).thenReturn(officeLis);
	}

	@Test
	void testGetEmployeDetails() throws CustomException {
		when(districtRepository.findByActiveStatus(Constant.ACTIVE_STATUS)).thenReturn(lst);
		when(districtConverter.toEDPSDTDto(lst)).thenReturn(dlst);
		when(eDPMsDesignationRepository.findByActiveStatusEquals(Constant.ACTIVE_STATUS)).thenReturn(edpen);
		when(eDPMsDesignationConverter.toEDPSDTDto(edpen)).thenReturn(dlst);
		service.getLookupDetails();
		}
*/

}
