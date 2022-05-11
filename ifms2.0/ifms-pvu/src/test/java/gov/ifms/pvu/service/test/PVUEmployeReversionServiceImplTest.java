package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUEmployeReversionConverter;
import gov.ifms.pvu.converter.PVUMsPayCellConverter;
import gov.ifms.pvu.dto.PVUEmployeForgoDto;
import gov.ifms.pvu.dto.PVUEmployeReversionDto;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.dto.PVUMsPayCellDto;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeForgoEntity;
import gov.ifms.pvu.entity.PVUEmployeReversionEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeReversionRepository;
import gov.ifms.pvu.repository.PVUMsGradePayRepository;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeReversionServiceImpl;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVUEmployeReversionServiceImplTest.
 */
class PVUEmployeReversionServiceImplTest {

	/** The pvu employe reversion service impl. */
	@InjectMocks
	private PVUEmployeReversionServiceImpl pvuEmployeReversionServiceImpl;

	/** The pvu employe reversion repository. */
	@Mock
	private PVUEmployeReversionRepository repository;

	/** The pvu employe reversion entity. */
	@Mock
	private PVUEmployeReversionEntity pvuEmployeReversionEntity;

	/** The pvu employe reversion dto. */
	@Mock
	private PVUEmployeReversionDto pvuEmployeReversionDto;

	/** The converter. */
	@Mock
	private PVUEmployeReversionConverter converter;

	/** The pay cell repository. */
	@Mock
	private PVUMsPayCellRepository payCellRepository;

	/** The pay cell converter. */
	@Mock
	private PVUMsPayCellConverter payCellConverter;

	/** The grade pay repository. */
	@Mock
	private PVUMsGradePayRepository gradePayRepository;

	/** The pvu ms pay cell entity. */
	@Mock
	private PVUMsPayCellEntity pvuMsPayCellEntity;

	/** The pvu ms pay cell dto. */
	@Mock
	private PVUMsPayCellDto pvuMsPayCellDto;

	/** The com req. */
	@Mock
	private PvuCommonRequest comReq;

	/** The request. */
	@Mock
	Map<String, Long> request;

	/** The response. */
	@Mock
	Map<String, Object> response;

	/** The pay level entity. */
	@Mock
	private PVUMsPayLevelEntity payLevelEntity;

	/** The pay cell entity. */
	@Mock
	private PVUMsPayCellEntity payCellEntity;

	/** The lst. */
	@Mock
	List<PVUMsPayCellEntity> lst;

	/** The grade pay entity. */
	@Mock
	private PVUMsGradePayEntity gradePayEntity;

	/** The pay band entity. */
	@Mock
	PVUMsPayBandEntity payBandEntity;

	/** The List. */
	@Mock
	List<PVUMsGradePayEntity> masterGradePayEntityList;

	/** The lookupinforepository. */
	@Mock
	private EDPLuLookUpInfoRepository edpRepository;
	

	@Mock
	private PVUCommonService pvuCommonService;

	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	@Mock
	private PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity;

	@Mock
	PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto;

	@Mock
	private PVUEmployeEventsService pvuEmployeEventsService;

	@Mock
	private PVYFacade pvuFacade;
	
	
	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;
	

	
	
	@Mock
	Page<PVUEmployeForgoEntity> page;
	
	@Mock
	List<PVUEmployeForgoEntity> elst;
	
	@Mock
	List<PVUEmployeForgoDto> employeeForgoList;
	

	
    @Mock
    private EDPLuLookUpInfoEntity lu;
    

	@Mock
	private PVUEmployeDepartmentEntity department;
	
    @Mock
    private PVUEmployeEventsEntity employeEventsEntity;
    
	@Mock
    private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;
	
	@Mock
	private PVUEmployeEntity pvuEmployeEntity;
	
    @Mock
    private EDPMsDesignationEntity edpMsDesignationEntity;
	
	@Mock
	private EDPLuLookUpInfoEntity luEntity;


	/** The mapper. */
	ObjectMapper mapper = new ObjectMapper();

	/**
	 * Setup.
	 */
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get PVU employe reversion event.
	 *
	 * @throws JsonParseException   the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException          Signals that an I/O exception has occurred.
	 * @throws CustomException      the custom exception
	 */
	@Test
	void testGetPVUEmployeReversionEvent() throws CustomException {
		when(repository.findById(1l)).thenReturn(Optional.of(pvuEmployeReversionEntity));
		assertEquals(pvuEmployeReversionEntity, pvuEmployeReversionServiceImpl.getPVUEmployeReversionEvent(1l));
		verify(repository, times(1)).findById(1l);
	}
	
	/**
	 * Test save or update PVU employe reversion event.
	 *
	 * @throws JsonParseException   the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException          Signals that an I/O exception has occurred.
	 * @throws CustomException      the custom exception
	 */
	 @Test
	void testSaveOrUpdatePVUEmployeReversionEventOldEmp()
			throws JsonParseException, JsonMappingException, IOException, CustomException {
		PVUEmployeReversionDto dto = new PVUEmployeReversionDto();
		dto.setEmployeeId(1l);
		dto.setId(1l);
		PVUEmployeReversionEntity entity = new PVUEmployeReversionEntity();
		entity.setEmployee( new PVUEmployeEntity(1l));
		entity.setId(1l);
		entity.setTrnNo("RV");
		when(repository.findById(1l)).thenReturn(Optional.of(entity));
		when(converter.toEntityWithDto(entity ,dto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		assertTrue(true);
		//assertNotNull(pvuEmployeReversionServiceImpl.saveOrUpdatePVUEmployeReversionEvent(dto));
	}

	
	@Test
	void testSaveOrUpdatePVUEmployeReversionEventDiffrentEmp()
			throws JsonParseException, JsonMappingException, IOException, CustomException {
		PVUEmployeReversionDto dto = new PVUEmployeReversionDto();
		dto.setEmployeeId(12);
		dto.setId(1l);
		PVUEmployeReversionEntity entity = new PVUEmployeReversionEntity();
		entity.setEmployee( new PVUEmployeEntity(1l));
		entity.setId(1l);
		entity.setTrnNo("RV");
		PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity = new PVUEmployeeEventStatusEntity();
		pvuEmployeeEventStatusEntity.setReversion(1l);
		pvuEmployeeEventStatusEntity.setActiveStatus(1);
		PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto = new PVUEmployeeEventStatusDto();
		pvuEmployeeEventStatusDto.setInProgress(false);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		doNothing().when(pvuEmployeeEventStatusService).resetInProgressEmployeeEventStatus(entity.getEmployee().getEmpId(), 0l);
		when(pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity)).thenReturn(pvuEmployeeEventStatusEntity);
		when(repository.findById(1l)).thenReturn(Optional.of(entity));
		when(converter.toEntityWithDto(entity ,dto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		assertTrue(true);
		//assertNotNull(pvuEmployeReversionServiceImpl.saveOrUpdatePVUEmployeReversionEvent(dto));
	}

	@Test
	void testSaveOrUpdatePVUEmployeReversionEventNewEmployee()
			throws JsonParseException, JsonMappingException, IOException, CustomException {
		PVUEmployeReversionDto dto = new PVUEmployeReversionDto();
		dto.setEmployeeId(1l);
		PVUEmployeReversionEntity entity = new PVUEmployeReversionEntity();
		entity.setEmployee(new PVUEmployeEntity(1l));
		entity.setTrnNo("RV");
		entity.setStatusId(new EDPLuLookUpInfoEntity(1l));
		PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity = new PVUEmployeeEventStatusEntity();
		pvuEmployeeEventStatusEntity.setReversion(1l);
		pvuEmployeeEventStatusEntity.setActiveStatus(1);
		PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto = new PVUEmployeeEventStatusDto();
		pvuEmployeeEventStatusDto.setInProgress(false);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(pvuEmployeeEventStatusService.getEventStatus(pvuEmployeeEventStatusEntity))
				.thenReturn(pvuEmployeeEventStatusDto);
		when(converter.toEntity(dto)).thenReturn(entity);
		when(edpRepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(pvuEmployeReversionServiceImpl.saveOrUpdatePVUEmployeReversionEvent(dto));
	}
	

	/**
	 * Test lookup employee reversion sp.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testLookupEmployeeReversionSp() throws CustomException {
		assertNotNull(pvuEmployeReversionServiceImpl.getAllLuLookUpInfoAsMap());
	}

	@Test
	@Disabled
	void insertReversionItr() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(repository.findById(1l)).thenReturn(Optional.of(pvuEmployeReversionEntity));
		when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Approved")).thenReturn(lu);
		when(lu.getLookUpInfoId()).thenReturn(2l);
		when(pvuEmployeReversionEntity.getStatusId()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(1l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(converter.toDTO(pvuEmployeReversionEntity)).thenReturn(pvuEmployeReversionDto);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Approved");
		when(pvuEmployeReversionDto.getEmployeeId()).thenReturn(1l);
		when(pvuEmployeReversionDto.getEventOrderDate()).thenReturn(LocalDate.now());
		when(pvuEmployeReversionDto.getTrnNo()).thenReturn("2020");
		when(pvuEmployeReversionDto.getEventCode()).thenReturn("RV");
		when(pvuEmployeReversionDto.getDateOfNextIncrement()).thenReturn(LocalDate.now());
		when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Submit")).thenReturn(luEntity);
		when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		when(pvuEmployeReversionEntity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(department.getDesignationId()).thenReturn(edpMsDesignationEntity);
		when(edpMsDesignationEntity.getDesignationId()).thenReturn(1l);
		when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
				PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME)).thenReturn(luEntity);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		//assertNotNull(pvuEmployeReversionServiceImpl.insertReversionItr(pvuWFWrapperDto));
	}
	
	
	@Test
	@Disabled
	void insertReversionItrRejected() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(repository.findById(1l)).thenReturn(Optional.of(pvuEmployeReversionEntity));
		when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Approved")).thenReturn(lu);
		when(lu.getLookUpInfoId()).thenReturn(2l);
		when(pvuEmployeReversionEntity.getStatusId()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(1l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(converter.toDTO(pvuEmployeReversionEntity)).thenReturn(pvuEmployeReversionDto);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Rejected");
		when(pvuEmployeReversionDto.getEmployeeId()).thenReturn(1l);
		when(pvuEmployeReversionDto.getEventOrderDate()).thenReturn(LocalDate.now());
		when(pvuEmployeReversionDto.getTrnNo()).thenReturn("2020");
		when(pvuEmployeReversionDto.getEventCode()).thenReturn("RV");
		when(pvuEmployeReversionDto.getDateOfNextIncrement()).thenReturn(LocalDate.now());
		when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Rejected")).thenReturn(luEntity);
		when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		when(pvuEmployeReversionEntity.getEmployee()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(department.getDesignationId()).thenReturn(edpMsDesignationEntity);
		when(edpMsDesignationEntity.getDesignationId()).thenReturn(1l);
		when(edpRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				PvuConstant.PVU_PAY_COMMISSION_LOOKUP_NAME, Constant.ACTIVE_STATUS,
				PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME)).thenReturn(luEntity);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		doNothing().when(repository).updateStatusId(1l, 1l, 1l, new Date());
		assertNotNull(pvuEmployeReversionServiceImpl.insertReversionItr(pvuWFWrapperDto));
	}
	
	 @Test
	void getPayCommitionDetailsSavenPay() throws CustomException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("empId", 1);
		map.put("payCommision", 151);
		map.put("effectiveDate", "20/04/2020");
		List<Object[]> objectPvuSp = new ArrayList<Object[]>();
		Object objectArray[] = new Object[10];
		objectArray[5] = 152L;
		objectArray[6] = 152;
		objectPvuSp.add(objectArray);
		StringBuilder sb = new StringBuilder();
		HashMap<String, Object> objectMap = new HashMap<>();
		objectMap.put(PvuConstant.EMP_ID, 1l);
		objectMap.put("empCreation", PvuConstant.EMPLOYEE_CREATION);
		objectMap.put("paycommition", 151);
		sb.append("abc");
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objectPvuSp);
		assertNotNull(pvuEmployeReversionServiceImpl.getPayCommitionDetails(map));
	}

	 @Test
	void getPayCommitionDetailSixPay() throws CustomException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("empId", 1);
		map.put("payCommision", 151);
		map.put("effectiveDate", "20/04/2020");
		List<Object[]> objectPvuSp = new ArrayList<Object[]>();
		Object objectArray[] = new Object[10];
		objectArray[5] = 151L;
		objectArray[8] = 10;
		objectPvuSp.add(objectArray);
		StringBuilder sb = new StringBuilder();
		HashMap<String, Object> objectMap = new HashMap<>();
		objectMap.put(PvuConstant.EMP_ID, 1l);
		objectMap.put("empCreation", PvuConstant.EMPLOYEE_CREATION);
		objectMap.put("paycommition", 151);
		sb.append("abc");
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objectPvuSp);
		assertNotNull(pvuEmployeReversionServiceImpl.getPayCommitionDetails(map));
	}
	 
	 @Test
	void getPayCommitionDetailFivPay() throws CustomException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("empId", 1);
		map.put("payCommision", 151);
		map.put("effectiveDate", "20/04/2020");
		List<Object[]> objectPvuSp = new ArrayList<Object[]>();
		Object objectArray[] = new Object[10];
		objectArray[5] = 150L;
		objectArray[6] = 152;
		objectPvuSp.add(objectArray);
		StringBuilder sb = new StringBuilder();
		HashMap<String, Object> objectMap = new HashMap<>();
		objectMap.put(PvuConstant.EMP_ID, 1l);
		objectMap.put("empCreation", PvuConstant.EMPLOYEE_CREATION);
		objectMap.put("paycommition", 151);
		sb.append("abc");
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objectPvuSp);
		assertNotNull(pvuEmployeReversionServiceImpl.getPayCommitionDetails(map));
	}
	 
	 @Test
	 void testdeleteById() {
		 IdDto dto = new IdDto();
		 dto.setId(1l);
		 PVUEmployeReversionEntity entity = new PVUEmployeReversionEntity();
		 entity.setEmployee( new PVUEmployeEntity(1l));
		 when(repository.findById(1l)).thenReturn(Optional.of(entity));
		 assertNotNull(repository.findById(1l));
		 pvuEmployeReversionServiceImpl.deleteById(dto);
	 }
}
