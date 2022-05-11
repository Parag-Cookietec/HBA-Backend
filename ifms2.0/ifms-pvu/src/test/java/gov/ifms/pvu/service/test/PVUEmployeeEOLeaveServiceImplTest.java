package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUEmployeeEOLeaveConverter;
import gov.ifms.pvu.dto.PVUEmployeEOLeaveView;
import gov.ifms.pvu.dto.PVUEmployeeEOLeaveDto;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeeEOLeaveEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeeEOLeaveRepository;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeeEOLeaveServiceImpl;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVUEmployeeEOLeaveServiceImplTest.
 */
class PVUEmployeeEOLeaveServiceImplTest {

	/** The pvu employee EO leave service impl. */
	@InjectMocks
	private PVUEmployeeEOLeaveServiceImpl pvuEmployeeEOLeaveServiceImpl;

	/** The pvu employee EO leave repository. */
	@Mock
	private PVUEmployeeEOLeaveRepository pvuEmployeeEOLeaveRepository;

	/** The pvu employee EO leave entity. */
	@Mock
	private PVUEmployeeEOLeaveEntity pvuEmployeeEOLeaveEntity;

	/** The converter. */
	@Mock
	private PVUEmployeeEOLeaveConverter converter;

	/** The dto. */
	@Mock
	private PVUEmployeeEOLeaveDto dto;

	/** The list. */
	@Mock
	private List<PVUSearchEnum> list;

	/** The pvu WF wrapper dto. */
	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;

	/** The pvu employe entity. */
	@Mock
	PVUEmployeEntity pvuEmployeEntity;

	/** The edp look up entity. */
	@Mock
	EDPLuLookUpEntity edpLookUpEntity;

	/** The pvu facade. */
	@Mock
	private PVYFacade pvuFacade;

	/** The lu entity. */
	@Mock
	private EDPLuLookUpInfoEntity luEntity;

	/** The lookupinforepository. */
	@Mock
	private EDPLuLookUpInfoRepository lookupinforepository;

	/** The e DP lu look up info repository. */
	@Mock
	private EDPLuLookUpInfoRepository eDPLuLookUpInfoRepository;

	/** The emp status lookup info 1. */
	@Mock
	private EDPLuLookUpInfoEntity empStatusLookupInfo1;

	/** The pvu employee event status service. */
	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

	/** The pvu employee event status entity. */
	@Mock
	private PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity;

	/** The pvu employee event status dto. */
	@Mock
	private PVUEmployeeEventStatusDto pvuEmployeeEventStatusDto;

	/** The emp approv stats lookup info. */
	@Mock
	private EDPLuLookUpInfoEntity empApprovStatsLookupInfo;

	/** The pvu employe department repository. */
	@Mock
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	/** The department. */
	@Mock
	private PVUEmployeDepartmentEntity department;

	/** The employe events entity. */
	@Mock
	private PVUEmployeEventsEntity employeEventsEntity;

	/** The pvu employe events service. */
	@Mock
	private PVUEmployeEventsService pvuEmployeEventsService;
	
	@Mock
	private PVUCommonService pvuCommonService;
	
	@Mock
	private gov.ifms.edp.entity.EDPMsDesignationEntity EDPMsDesignationEntity;
	
	@Mock
    private PVUCommonService commonService;
	
	/**
	 * Setup.
	 */
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get PVU employee EO leave.
	 *
	 * @throws JsonParseException   the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException          Signals that an I/O exception has occurred.
	 * @throws CustomException      the custom exception
	 */
	@Test
	void testGetPVUEmployeeEOLeave() throws JsonParseException, JsonMappingException, IOException, CustomException {

		when(pvuEmployeeEOLeaveRepository.findByEmpEolIdAndActiveStatus(1L,1)).thenReturn(Optional.of(pvuEmployeeEOLeaveEntity));
		 assertNotNull(pvuEmployeeEOLeaveServiceImpl.getPVUEmployeeEOLeave(1L));
		verify(pvuEmployeeEOLeaveRepository, times(1)).findByEmpEolIdAndActiveStatus(1L,1);

	}

	/**
	 * Test save or update PVU employee EO leave.
	 *
	 * @throws JsonParseException   the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException          Signals that an I/O exception has occurred.
	 * @throws CustomException      the custom exception
	 */
//	@Test
	void testSaveOrUpdatePVUEmployeeEOLeave()
			throws JsonParseException, JsonMappingException, IOException, CustomException {
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(pvuEmployeeEOLeaveRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);
		when(converter.toEntity(dto)).thenReturn(pvuEmployeeEOLeaveEntity);
		when(dto.getFormAction()).thenReturn(Status.SUBMITTED);
		when(lookupinforepository.findByLookUpInfoName(Constant.SUBMIT)).thenReturn(luEntity);
		when(converter.toDTO(pvuEmployeeEOLeaveEntity)).thenReturn(dto);
		when(dto.getFormAction()).thenReturn(Status.DRAFT);
		when(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(pvuEmployeeEventStatusService.getEventStatus(pvuEmployeeEventStatusEntity))
				.thenReturn(pvuEmployeeEventStatusDto);
		when(pvuEmployeeEventStatusDto.isInProgress()).thenReturn(false);
		when(pvuEmployeeEOLeaveEntity.getEmpEolId()).thenReturn(1l);
		when(dto.getEmpId()).thenReturn(1l);
		when(pvuEmployeeEOLeaveRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap()))
				.thenReturn(objects);
		when(converter.toEntity(dto)).thenReturn(pvuEmployeeEOLeaveEntity);
		when(dto.getFormAction()).thenReturn(Status.SUBMITTED);
		when(lookupinforepository.findByLookUpInfoName(Constant.SUBMIT)).thenReturn(luEntity);
		when(converter.toDTO(pvuEmployeeEOLeaveEntity)).thenReturn(dto);
		when(dto.getFormAction()).thenReturn(Status.DRAFT);
		when(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(luEntity);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		when(pvuEmployeeEventStatusService.getEventStatus(pvuEmployeeEventStatusEntity))
				.thenReturn(pvuEmployeeEventStatusDto);
		when(pvuEmployeeEventStatusDto.isInProgress()).thenReturn(false);
		when(pvuEmployeeEOLeaveEntity.getEmpEolId()).thenReturn(1l);
		when(dto.getEmpId()).thenReturn(1l);
		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Approved")).thenReturn(empApprovStatsLookupInfo);
		when(dto.getStartDate()).thenReturn(LocalDate.now());
		when(dto.getEndDate()).thenReturn(LocalDate.now());
		when(pvuEmployeeEventStatusDto.getEventStatusId()).thenReturn(1l);
		when(pvuEmployeeEventStatusService.findPVUEmployeeStatusDto(1l)).thenReturn(pvuEmployeeEventStatusDto);
		when(commonService.getTransactionNumber(Constant.EOL)).thenReturn(Constant.EOL);
		when(pvuEmployeeEOLeaveEntity.getTransNo()).thenReturn(Constant.EOL);
		when(pvuEmployeeEOLeaveEntity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		assertNotNull(pvuEmployeeEOLeaveServiceImpl.saveOrUpdatePVUEmployeeEOLeave(dto));
	}

	/**
	 * Test get pvu search fields.
	 */
	@Test
	void testGetPvuSearchFields() {
		assertNotNull(pvuEmployeeEOLeaveServiceImpl.getPvuSearchFields());
	}

	/**
	 * Test get PVU employee EO leaves.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetPVUEmployeeEOLeaves() throws CustomException {
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
		PagebleDTO<PVUEmployeEOLeaveView> data = pvuEmployeeEOLeaveServiceImpl.getPVUEmployeeEOLeaves(pageDetail);
		assertNotNull(data);
	}

	/**
	 * Test store proc pvu.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testStoreProcPvu() throws CustomException {
		assertNotNull(
				pvuEmployeeEOLeaveServiceImpl.storeProcPvu("PVU_EMPLOYEE_EOL_SEARCH", new HashMap<String, Object>()));
	}

	/**
	 * Test get all lu look up info as map.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetAllLuLookUpInfoAsMap() throws CustomException {
		assertNotNull(pvuEmployeeEOLeaveServiceImpl.getAllLuLookUpInfoAsMap());
	}

	/**
	 * Gets the employee WF history by emp id.
	 *
	 * @return the employee WF history by emp id
	 * @throws CustomException the custom exception
	 */
	@Test
	void getEmployeeWFHistoryByEmpId() throws CustomException {
		assertNotNull(pvuEmployeeEOLeaveServiceImpl.getEmployeeWFHistoryByEmpId(1l));
	}

	/**
	 * Insert employee itr.
	 *
	 * @throws CustomException the custom exception
	 */
//	@Test
	public void insertEmployeeItr() throws CustomException {
		when(pvuWFWrapperDto.getTrnId()).thenReturn(1l);
		when(pvuEmployeeEOLeaveRepository.findById(1l)).thenReturn(Optional.of(pvuEmployeeEOLeaveEntity));

		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Approved")).thenReturn(empStatusLookupInfo1);
		when(empStatusLookupInfo1.getLookUpInfoId()).thenReturn(1l);
		when(pvuEmployeeEOLeaveEntity.getStatusId()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(2l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(converter.toDTO(pvuEmployeeEOLeaveEntity)).thenReturn(dto);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Approved");
		when(dto.getEmpId()).thenReturn(1l);
		when(dto.getStartDate()).thenReturn(LocalDate.now());
		when(dto.getTransNo()).thenReturn("2020");
		when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		when(pvuEmployeeEOLeaveEntity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(department.getDesignationId()).thenReturn(EDPMsDesignationEntity);
		when(EDPMsDesignationEntity.getDesignationId()).thenReturn(1l);
		
		assertNotNull(pvuEmployeeEOLeaveServiceImpl.insertWfEolItr(pvuWFWrapperDto));
		
		
		when(eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName("Status_id", 1,
				"Rejected")).thenReturn(empStatusLookupInfo1);
		when(empStatusLookupInfo1.getLookUpInfoId()).thenReturn(1l);
		when(pvuEmployeeEOLeaveEntity.getStatusId()).thenReturn(luEntity);
		when(luEntity.getLookUpInfoId()).thenReturn(2l);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		when(converter.toDTO(pvuEmployeeEOLeaveEntity)).thenReturn(dto);
		when(pvuWFWrapperDto.getWfStatus()).thenReturn("Rejected");
		when(dto.getEmpId()).thenReturn(1l);
		when(dto.getStartDate()).thenReturn(LocalDate.now());
		when(dto.getTransNo()).thenReturn("2020");
		when(pvuEmployeEventsService.saveOrUpdateEmployeEvents(employeEventsEntity)).thenReturn(employeEventsEntity);
		when(pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(1l)).thenReturn(department);
		when(pvuEmployeeEOLeaveEntity.getEmpId()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeeEventStatusService.findByEmpId(1l)).thenReturn(Optional.of(pvuEmployeeEventStatusEntity));
		assertNotNull(pvuEmployeeEOLeaveServiceImpl.insertWfEolItr(pvuWFWrapperDto));
	}
}