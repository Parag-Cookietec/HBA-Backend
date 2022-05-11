package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUEmployeForgoConverter;
import gov.ifms.pvu.converter.PVUMsPayCellConverter;
import gov.ifms.pvu.dto.PVUEmployeForgoDto;
import gov.ifms.pvu.dto.PVUForgoView;
import gov.ifms.pvu.dto.PVUMsPayCellDto;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeForgoEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeForgoRepository;
import gov.ifms.pvu.repository.PVUMsGradePayRepository;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeForgoServiceImpl;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;

class PVUEmployeForgoServiceImplTest {
	@InjectMocks
	private PVUEmployeForgoServiceImpl service;

	@Mock
	private PVUEmployeForgoRepository repository;

	@Mock
	private PVUEmployeForgoEntity entity;

	@Mock
	private PVUEmployeForgoDto dto;

	@Mock
	private PVUEmployeForgoConverter converter;

	@Mock
	private PVUMsPayCellRepository payCellRepository;

	@Mock
	private PVUMsPayCellConverter payCellConverter;

	@Mock
	private PVUMsGradePayRepository gradePayRepository;

	@Mock
	private PVUMsPayCellEntity pvuMsPayCellEntity;

	@Mock
	private PVUMsPayCellDto pvuMsPayCellDto;

	@Mock
	private PvuCommonRequest comReq;

	@Mock
	Map<String, Long> request;

	@Mock
	Map<String, Object> response;

	@Mock
	private PVUMsPayLevelEntity payLevelEntity;

	@Mock
	private PVUMsPayCellEntity payCellEntity;

	@Mock
	List<PVUMsPayCellEntity> lst;

	@Mock
	private PVUMsGradePayEntity gradePayEntity;

	@Mock
	PVUMsPayBandEntity payBandEntity;

	@Mock
	List<PVUMsGradePayEntity> masterGradePayEntityList;
	
	@Mock
	private EDPLuLookUpInfoRepository lookupinforepository;
	
	@Mock
	private EDPLuLookUpInfoEntity luEntity;

	@Mock
	private PVUCommonService pvuCommonService;
	
	
	@Mock
	Page<PVUEmployeForgoEntity> page;
	
	@Mock
	List<PVUEmployeForgoEntity> elst;
	
	@Mock
	List<PVUEmployeForgoDto> employeeForgoList;
	

	
	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;
	
    @Mock
    private EDPLuLookUpInfoEntity lu;
    

	@Mock
	private PVUEmployeDepartmentEntity department;
	
    @Mock
    private PVUEmployeEventsEntity employeEventsEntity;
    
    @Mock
    private PVUEmployeEventsService pvuEmployeEventsService;
    
   
	@Mock
    private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;
	
	@Mock
	private PVUEmployeEntity pvuEmployeEntity;
	
	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;
	
	@Mock
	private PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity;
   
    @Mock
    private EDPMsDesignationEntity edpMsDesignationEntity;
	
	@Mock
	 private PVYFacade pvuFacade;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetForgoEvent() throws CustomException {
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		assertNotNull(service.getForgoEvent(1L));
		verify(repository, times(1)).findById(1L);

	}

      @Test
	void testSaveOrUpdateForgoEvent() throws CustomException {
  		Object[] object = new Object[1];
  		 object[0] = "";
  		 List<Object[]> objects = new ArrayList<Object[]>();
  		 objects.add(object);
  		 when(repository.callStoredProcedure(Mockito.anyString(),
  				 Mockito.anyMap())).thenReturn(objects);
		when(converter.toEntity(dto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(dto.getFormAction()).thenReturn(Status.SUBMITTED);
		when(lookupinforepository.findByLookUpInfoName(Constant.SUBMIT)).thenReturn(luEntity);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(dto.getPromoDate()).thenReturn(LocalDate.now());
		when(dto.getPromoForgoDate()).thenReturn(LocalDate.now());
		when(entity.getId()).thenReturn(0l);
		when(pvuCommonService.getTransactionNumber("PRFG")).thenReturn("PRFG");
		when(entity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeeEventStatusService.inProgressSuspensionEvent(pvuEmployeEntity.getEmpId())).thenReturn(pvuEmployeeEventStatusEntity);
		assertNotNull(service.saveOrUpdateForgoEvent(dto));
		verify(repository, times(1)).save(entity);

	}

	@Test
	void testGetPvuSearchFields() {
		assertNotNull(service.getPvuSearchFields());
	}

	@Test
	void testGetForgoEvents() throws CustomException {
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
		PagebleDTO<PVUForgoView> data = service.getForgoEvents(pageDetail);
		assertNotNull(data);
	}

	
	@Test
	void testGetAllLuLookUpInfoAsMap() throws CustomException
	{
		assertNotNull(service.getAllLuLookUpInfoAsMap());
	}
	

	@Test
	void insertEmployeeItr() throws CustomException
	{
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(repository.findById(1l)).thenReturn(Optional.of(entity));
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id",1, "Approved")).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(2l);
		when(entity.getStatusId()).thenReturn(lu);
		when(lu.getLookUpInfoId()).thenReturn(1l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Approved");
		when(dto.getEmployeeId()).thenReturn(1l);
		when(dto.getEventOrderDate()).thenReturn(LocalDate.now());
		when(dto.getTrnNo()).thenReturn("2020");
		when(dto.getEventCode()).thenReturn("Forgo");
		when(dto.getDateOfNextIncrement()).thenReturn(LocalDate.now());
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id",1, "Submit")).thenReturn(luEntity);
		when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		when(entity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(department.getDesignationId()).thenReturn(edpMsDesignationEntity);
		when(edpMsDesignationEntity.getDesignationId()).thenReturn(1l);
		when(lookupinforepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
				PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME)).thenReturn(luEntity);
		
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
	    assertNotNull(service.insertEmployeeItr(pvuWFWrapperDto));
	}
}