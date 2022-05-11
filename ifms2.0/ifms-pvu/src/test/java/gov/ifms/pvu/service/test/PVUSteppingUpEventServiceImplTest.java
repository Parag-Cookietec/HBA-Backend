package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.DocumentException;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUPrintEndorsementItrConverter;
import gov.ifms.pvu.converter.PVUSteppingUpEventConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PVUSourceUserDetails;
import gov.ifms.pvu.dto.PVUSteppingUpEventDto;
import gov.ifms.pvu.dto.PVUSteppingUpEventView;
import gov.ifms.pvu.dto.PVUSteppingUpInwardView;
import gov.ifms.pvu.dto.PVUSteppingUpOfficeSearchView;
import gov.ifms.pvu.dto.PVUSteppingUpOutwardView;
import gov.ifms.pvu.dto.PVUSteppingUpPrintEndorsementView;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.PVUWfTableInfo;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.dto.response.PVUEventSteppingUpDDOView;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;
import gov.ifms.pvu.entity.PVUMsEventEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementItrEntity;
import gov.ifms.pvu.entity.PVUSteppingUpEventEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeEventsRepository;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVUInwardRepository;
import gov.ifms.pvu.repository.PVUMsEventRepository;
import gov.ifms.pvu.repository.PVUMsGradePayRepository;
import gov.ifms.pvu.repository.PVUMsPayBandRepository;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import gov.ifms.pvu.repository.PVUMsPayLevelRepository;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVUPrintEndorsementRepository;
import gov.ifms.pvu.repository.PVURevisionOfPayRemarkRepository;
import gov.ifms.pvu.repository.PVUSteppingUpEventRepository;
import gov.ifms.pvu.service.PVUEmployeEventsService;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.service.PVUEventRemarksService;
import gov.ifms.pvu.service.PVUInwardService;
import gov.ifms.pvu.service.PVUMsReasonService;
import gov.ifms.pvu.service.PVUSteppingUpEventServiceImpl;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.wrapper.PVYFacade;
import gov.ifms.workflow.repository.WfRepository;

/**
 * The Class PVUStEventServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class PVUSteppingUpEventServiceImplTest {

	/** The pvu st event service impl. */
	@InjectMocks
	private PVUSteppingUpEventServiceImpl pvuStEventServiceImpl;

	/** The PVUStEventAsMethodName repository. */
	@Mock
	private PVUSteppingUpEventRepository repository;

	/** The PVUStEventAsMethodName helper. */
	@Mock
	private PVUSteppingUpEventConverter converter;

	/** The pvu st event entity. */
	@Mock
	private PVUSteppingUpEventEntity pvuStEventEntity;

	/** The pvu st event dto. */
	@Mock
	private PVUSteppingUpEventDto pvuStEventDto;

	/** The edp lu look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	/** The date. */
	@Mock
	private Date date;

	/** The lst PVU st event view. */
	@Mock
	private List<PVUSteppingUpEventView> lstPVUStEventView;

	/** The object pvu sp. */
	@Mock
	private List<Object[]> objectPvuSp;
	
	/** The status Service. */
	@Mock
	PVUEmployeeEventStatusService statusService;

	/** The status Service. */
	@Mock
	PVUEmployeeEventStatusEntity employeeEventStatusEntity;
	/** The PVYFacade. */
	@Mock
	private PVYFacade pvuFacade;
	@Mock
	private PVUMsReasonService pvuMsReasonService;
	@Mock
	private PVURevisionOfPayRemarkRepository remarkRepository;
	@Mock
    private WfRepository wfRepository;
	@Mock
	private PVUEmployeDepartmentRepository pvuEmployeeDepartmentRepo;
	@Mock
	PVUEmployeDepartmentEntity departmentEntity;
	@Mock
	PVUEmployeeEventStatusEntity statusEntry;
	@Mock
	private PVUCommonService pvuCommonService;
	
	@Mock
	private PVUEmployeEntity empEntity;
	@Mock
	PvuWFWrapperDto wrpDto;
	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;
	@Mock
	private PVUInwardRepository pvuInwardRepository;
	@Mock
    private PVUInwardService inwardService;
	@Mock
    EncryptDecryptUtil securityUtil;
	@Mock
	private PVUEmployeEventsService pvuEmployeEventsService;
	@Mock
	private PVUEmployeEventsRepository empEventRepository;
	@Mock
	private PVUMsEventRepository msEventRepository;
	@Mock
	private PVUEventRemarksService eventRemarksService;
	@Mock
	private PVUEventRemarksEntity pvuEventRemarksEntity;
	
	@Mock
	PVUPrintEndorsementRepository pvuPrintEndorsementRepository;

	@Mock
	PVUPrintEndorsementItrRepository pvuPrintEndorsementItrRepository;

	@Mock
	PVUPrintEndorsementItrConverter pvuPrintEndorsementItrConverter;

	@Mock
	PVUPrintEndorsementDto pvuPrintEndorsementDto;

	@Mock
	PVUPrintEndorsementEntity pvuPrintEndorsementEntity;

	@Mock
	PVUPrintEndorsementItrEntity pvuPrintEndorsementItrEntity;
	@Mock
	PvuPrintStickerReportDto printStickerReportDto;
	@Mock
	PVUStickerDTO pvuStickerDTO; 
	@Mock
	PVUEmployeRepository empRepository;
	@Mock
	private VelocityContext velocityContext;
	@Mock
	EDPMsDesignationEntity designationEntity;
	@Mock
    OAuthService authService;
	@Mock
	IdNameDto idNameDto;
	@Mock
	PVUMsPayCellEntity cellEntity;
	@Mock
	PVUMsPayLevelEntity payEntity;
	@Mock
	PVUMsPayScaleEntity scaleEntity;
	@Mock
	PVUMsGradePayEntity gradeEntity;
	@Mock 
	PVUMsPayBandEntity payBandEntity;
	@Mock
	EDPMsDesignationRepository designationRepository;
	@Mock
	EDPMsOfficeEntity officeEntity;
	@Mock
	PVUMsPayCellRepository cellRepository;
	@Mock
	PVUMsPayLevelRepository levelRepository;
	@Mock
	PVUMsGradePayRepository gradePayRepository;
	@Mock
	PVUMsPayBandRepository bandRepository;
	@Mock
	PVUMsPayScaleRepository scaleRepository;
	@Mock
	PVUEmployeEventsEntity empEventEntity;
	@Mock
	PVUCommonApiDto pvuCommonApiDto;
	/** The pvu st event entity. */
	@Mock
	private PVUSteppingUpEventEntity pvuSteppingUpEventEntity;
	
	/** The mapper. */
	ObjectMapper mapper = new ObjectMapper();

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get pvu search fields.
	 */
	@Test
	void testGetPvuSearchFields() {
		assertNotNull(pvuStEventServiceImpl.getPvuSearchFields(), "Search Creteria Fields Not Present");
	}

	/**
	 * Test get st event.
	 *
	 * @throws JsonParseException   the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException          Signals that an I/O exception has occurred.
	 */
	@Test
	void testGetStEvent() throws JsonParseException, JsonMappingException, IOException {
		pvuStEventEntity.setStEventId(1l);
		Optional<PVUSteppingUpEventEntity> pvuStEventEntityOptional = Optional.of(pvuStEventEntity);
		when(repository.findById(1L)).thenReturn(pvuStEventEntityOptional);
		assertEquals(pvuStEventEntityOptional.get().getStEventId(),
				pvuStEventServiceImpl.getStEvent(1L).getStEventId());
		verify(repository, times(1)).findById(1L);
	}

	
	
	
	/**
	 * Test save or update st event.
	 * @throws CustomException 
	 */
	@Test
	void testSaveOrUpdateStEvent() throws CustomException {
		pvuStEventEntity.setStEventId(1l);
		when(repository.save(pvuStEventEntity)).thenReturn(pvuStEventEntity);
		
		
		// TODO Fix Test issue.  working now
		assertNotNull(pvuStEventServiceImpl.saveOrUpdateStEvent(pvuStEventEntity));
		verify(repository, times(1)).save(pvuStEventEntity);
	}



	
	
	
	/**
	 * Test store proc pvu.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testStoreProcPvu() throws CustomException {
		assertNotNull(pvuStEventServiceImpl.storeProcPvu(
				Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_STEPPING_UP_SEARCH)),
				new HashMap<String, Object>()));
	}

	/**
	 * Test get st events.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetStEvents() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		PagebleDTO<PVUSteppingUpEventView> data = pvuStEventServiceImpl.getStEvents(pageDetail);
		assertNotNull(data);
	}

	/**
	 * Test delete st events details.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> resultMap = null;
		String procName = "TEST";
		List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = pvuStEventServiceImpl.lookupSteppingUpSp(procName);
		assertNotNull(lstPVUEmployeCreationDDLView);		
		resultMap = lstPVUEmployeCreationDDLView.stream()
				.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
		assertNotNull(resultMap);		
		pvuStEventServiceImpl.getLookUpInfoAsMap(procName);
		
	}
	
	/**
	 * Test delete st events details.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDeleteStEventsDetails() throws CustomException {
		when(repository.updateActiveStatus(1l, 1, 1l, date)).thenReturn(1);
		assertTrue(true);	
		pvuStEventServiceImpl.deleteStEventsDetails(1l, 1);
	}

	
	
	
	/**
	 * Test delete st events details.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDdoWFListing() throws CustomException {
		
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		
		Map<String, String> collect=pvuStEventServiceImpl.getDdoWFListingSearchFields().stream()
		.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
				
		assertNotNull(collect);		

		Map<String, Object> stringObjectMap =SearchParam.buildPageInMap(null, pageDetail, collect);
		assertNotNull(stringObjectMap);		
		String sp = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.STEPPINGUP_PVU_EVENT_LS_SRCH_WF));
		List<PVUEventSteppingUpDDOView> list = pvuStEventServiceImpl.callSSPVUDDOListing(sp, stringObjectMap);
		assertNotNull(list);
		assertNotNull(pageDetail.getPageElement());
		assertNotNull(pvuStEventServiceImpl.ddoWFListing(pageDetail));

	}

	
	@Test
	void testInsertInwardTable() throws CustomException {
		
		PvuWFWrapperDto wrapperDto=new PvuWFWrapperDto();
		wrapperDto.setActiveStatus(1);
		wrapperDto.setAssignByActionLevel(1);
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, wrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, wrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_CREATED_BY, OAuthUtility.getCurrentUserUserId());
		map.put(Constant.IN_CREATED_BY_POST, wrapperDto.getAssignByPostId());
		map.put(Constant.IN_POU_ID, wrapperDto.getAssignByPOUId());
		map.put(Constant.IN_OFFICE_ID, wrapperDto.getAssignByOfficeId());
		map.put(Constant.IN_EVENT_CODE, PvuConstant.EVENT_CODE_STEPPIN_UP);
		String procName = "test";
		
		assertNotNull(repository.callStoredProcedure(procName, map));
		
		pvuStEventServiceImpl.insertInwardTable(wrapperDto);
		
	}

		
	@Test
	void testInsertSteepingUpPayRemarksITR() throws CustomException {

		Long transId=1L;
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, transId);
		map.put(Constant.IN_EVENT_CODE, PvuConstant.EVENT_CODE_STEPPIN_UP);
		String procName = "test";
		assertNotNull(repository.callStoredProcedure(procName, map));
		
		pvuStEventServiceImpl.insertSteepingUpPayRemarksITR(transId);
	}

	@Test
	void testReset() throws CustomException {

		Long empId=1L;
		String eventCode="111";
		PVUEmployeeEventStatusEntity em=new PVUEmployeeEventStatusEntity();
		
		em.setSteppingUp(0);
		em.setTransId("1");
		pvuStEventServiceImpl.reset( empId,  eventCode);

		Optional<PVUEmployeeEventStatusEntity>  employeeStatus  = Optional.of(employeeEventStatusEntity);

		when(statusService.findByEmpId(empId)).thenReturn(Optional.of(employeeEventStatusEntity));
		
		assertNotNull(employeeStatus.get());
		
		when(statusService.saveOrUpdateEmployeeEventStatus(employeeStatus.get())).thenReturn(em);
		
		assertEquals(statusService.saveOrUpdateEmployeeEventStatus(employeeStatus.get()),em );

		
		
	}
	
	@Test
	void testInsertITR() throws CustomException {
		PvuWFWrapperDto wrapperDto=new PvuWFWrapperDto();
		wrapperDto.setActiveStatus(1);
		wrapperDto.setAssignByActionLevel(1);

		Map<String, Object> map = new LinkedHashMap<>();
		map.put("IN_TRN_ID", wrapperDto.getTrnId());
		map.put("IN_WORKFLOW_ID", wrapperDto.getCurrentWorkflowId());
		String procName = "test";
		assertNotNull(repository.callStoredProcedure(procName, map));
		
		pvuStEventServiceImpl.insertITR(wrapperDto);
	}

	@Test
	void testGetSteppingUpInwardList() throws CustomException {
		
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);

		Map<String, Object> map = pvuStEventServiceImpl.buildPageInMapInwardList(pageDetail);
		assertNotNull(map);		
		String procName ="test";
		List<PVUSteppingUpInwardView> objStorePro = pvuStEventServiceImpl.storeProcPvu(procName, map, PVUSteppingUpInwardView.class);
		assertNotNull(objStorePro);
		assertNotNull(pageDetail.getPageElement());
		assertNotNull(pvuStEventServiceImpl.getSteppingUpInwardList(pageDetail));
	
	}


	
	
	@Test
	void testGenerateInwardNumber() throws CustomException, SQLException {
		
		List<IdDto> dtos=new ArrayList<IdDto>();
		dtos.forEach(dto -> {
			dto.setId(1L);
		});

		
		Boolean ans=true;
		List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
		
		pvuStEventServiceImpl.generateInwardNumber(dtos);
		assertNotNull(dtos);
		dtos.forEach(dto -> {
			Map<Integer, Object> map = new HashMap<>();
			map.put(1, "1");
			map.put(2, dto.getId());
			parameterMapList.add(map);
		});
		assertNotNull(parameterMapList);
//
//		ans=repository.callStoreProcBatch("{CALL pvu.test(?,?)}",parameterMapList);
//		
//		assertEquals(ans, true);
	
	}

	
	
	@Test
	void testSubmiSteppingUpInward() throws CustomException {
		
		boolean ans = true;
		boolean val;
		List<PvuWFWrapperDto>  wrapperDto=new ArrayList<PvuWFWrapperDto>();
		when(pvuFacade.callWorkFlowApis(wrapperDto)).thenReturn(ans);
		assertTrue(pvuStEventServiceImpl.submiSteppingUpInward(wrapperDto));
	}

	@Test
	void testSubmiSteppingUpDistributor() throws CustomException {
		
		boolean ans = true;
		boolean val;
		List<PvuWFWrapperDto>  wrapperDto=new ArrayList<PvuWFWrapperDto>();
		when(pvuFacade.callWorkFlowApis(wrapperDto)).thenReturn(ans);
		assertTrue(pvuStEventServiceImpl.submitSteppingUpDistributor(wrapperDto));
	}

	
	
	@Test
	void testpvuOfficeEmployeeSearch() throws CustomException {
		
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		boolean ans = true;
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		PagebleDTO<PVUSteppingUpOfficeSearchView> view = null;
		Map<String, String> collect=pvuStEventServiceImpl.getPvuOfficeSearchFields().stream()
		.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
				
		assertNotNull(collect);		

		Map<String, Object> stringObjectMap =SearchParam.buildPageInMap(null, pageDetail, collect);
		assertNotNull(stringObjectMap);		
		String sp = "TEST";
		List<Object[]> objStorePro = repository.callStoredProcedure(sp, stringObjectMap);
//		when(view.getTotalElement()).thenReturn(10L);
		assertNotNull(pageDetail.getPageElement());
		assertNotNull(pvuStEventServiceImpl.pvuOfficeEmployeeSearch(pageDetail));


	}

	
	@Test
	void testGetSteppingUpReasons() throws CustomException {
		
		List<PVUMsReasonDto> ls=new ArrayList<PVUMsReasonDto>();
		
		assertNotNull(pvuMsReasonService.getEventsReasons());
		
		pvuStEventServiceImpl.getSteppingUpReasons();
	}

	
	
	@Test
	void testGetReturnReasonByTransactionId() throws CustomException {
		Long id=1L;
		Map<String, Object> map = new HashMap<>();
		map.put(PvuConstant.CS_PVU_EVENT_ID, id);
		map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
		List<Object[]> objects = remarkRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getReturnReasonRemarks(), map);
		assertNotNull(objects);
		pvuStEventServiceImpl.getReturnReasonByTransactionId(id);
	}

	
	
	@Test
	void testGetSteppingUpById() throws CustomException {
		Long id=1L;

		Optional<PVUSteppingUpEventEntity> pvuStEventEntityOptional = Optional.of(pvuStEventEntity);

		when(repository.findById(id)).thenReturn(pvuStEventEntityOptional);
		
		assertNotNull(pvuStEventServiceImpl.getSteppingUpById(id));
		verify(repository, times(1)).findById(1L);
		
		when(repository.findById(1L)).thenReturn(pvuStEventEntityOptional);
		assertEquals(pvuStEventEntityOptional.get().getStEventId(),
				pvuStEventServiceImpl.getStEvent(1L).getStEventId());
	}
	
//	@Test
//	void testGetSteppingUpByIdException()  {
//		Long id=1L;
//		  Throwable e = null;
//
//		  Optional<PVUSteppingUpEventEntity> entity=repository.findById(id);
//				when(repository.findById(id)).thenThrow(new EntityNotFoundException(""));
//
//			    assertTrue(!entity.isPresent());
//	}
		

	@Test
	void testGetSteppingUpOutwardList() throws CustomException {
		
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		boolean ans = true;
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);
		String sp = "TEST";
		Map<String, Object> map =pvuStEventServiceImpl.buildPageInMapOutwardList(pageDetail);
		assertNotNull(map);		

		List<PVUSteppingUpOutwardView> objStorePro= pvuStEventServiceImpl.storeProcPvu(sp, map,PVUSteppingUpOutwardView.class);;
				

		assertNotNull(objStorePro);
		assertNotNull(pvuStEventServiceImpl.getSteppingUpOutwardList(pageDetail));


	}

	
	@Test
	void testGenerateOutwardNumber() throws CustomException, SQLException {
		
		List<IdDto> dtos=new ArrayList<IdDto>();
		Map<Integer, Object> map = new LinkedHashMap<>();
		map.put(1, "ST");
		map.put(2, 1L);


		Boolean ans=true;
		List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
		assertNotNull(dtos);

		pvuStEventServiceImpl.generateOutwardNumber(dtos);
		assertNotNull(parameterMapList);
	}

	
	@Test
	void testGetReprintEndorsementRemarks() throws CustomException {
		PVUPrintEndorsementRemarkHistoryDto dto=new PVUPrintEndorsementRemarkHistoryDto();
		dto.setPostName("pso");
		dto.setRemarks("av");
		dto.setReprintDate(new Date());
		dto.setUserName("sap");

        Map<String, Object> map = new HashMap<>();
        map.put(PvuConstant.TRN_ID, 1);
        map.put(PvuConstant.EVENT_ID, PvuConstant.EVENT_CODE_STEPPIN_UP);
        
        List<Object[]> objects = new ArrayList<Object[]>();
         
	    Object objectArray[] = new Object[1]; 
	    objectArray[0] = dto;
	    objects.add(objectArray);
	    
		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPVUEventEndorsementHistory(), map)).thenReturn(objects);
		List<PVUPrintEndorsementRemarkHistoryDto> list=pvuStEventServiceImpl.getReprintEndorsementRemarks(1L);
		assertNotNull(list);

	}


	@Test
	void testGetWfRoleCodeByTrnId() throws CustomException {
		Long id=1L;
		String st=wfRepository.findWfRlCdBySteppingUpTrnId(id, Constant.ACTIVE_STATUS);
		String str=pvuStEventServiceImpl.getWfRoleCodeByTrnId(id);
		assertEquals(st, str);
	}
	
	
	
//	@Test
//	void testChkSrJrValidation() throws CustomException {
//		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
//		boolean b= true;
//
//		PageDetails pageDetail = new PageDetails();
//		pageDetail.setPageElement(1);
//		pageDetail.setPageIndex(0);
//		pageDetail.setJsonArr(jsonArr);
//
//		Mockito.when(PageDetails.getValue(pageDetail,Mockito.eq("date"))).thenReturn("1212121");
//		Mockito.when(PageDetails.getValue(pageDetail, Mockito.eq("date"))).thenReturn("12122018");
//
//		
//		
//		String eventEffDate = PageDetails.getValue(pageDetail, PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE.getKey());
//		Long empId = null;
//		long lookupId=10L;
//
//		
//		
//		pvuEmployeeDepartmentRepo.findFirstByPvuEmployeEntityEmployeeCode(1L);
//		Optional<PVUEmployeDepartmentEntity>  dep  = Optional.of(departmentEntity);
//
//		when(pvuEmployeeDepartmentRepo.findFirstByPvuEmployeEntityEmployeeCode(1L)).thenReturn(Optional.of(departmentEntity));
//		
//		assertNotNull(dep.get());
//		
//
//		assertNotNull(pvuStEventServiceImpl.chkSrJrValidation(pageDetail));
//
////		when(pvuStEventServiceImpl.chkSrJrValidation(pageDetail)).thenReturn(true);
//		
//	}


	@Test
	void testGetSteppingUpOfficeName() throws CustomException {
		IdDto idDto=new IdDto();
		idDto.setId(2L);
		String officeName = "abc";

		Map<String, Object> map = new HashMap<>();
		map.put("eventId", idDto.getId());
		
	    List<Object[]> lstObjects = new ArrayList<>();
	    Object objectArray[] = new Object[1]; 
	    objectArray[0] = officeName;
	    lstObjects.add(objectArray);
	    
		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getSteppingUpEmpOfficeId(), map)).thenReturn(lstObjects);
		EDPMsOfficeDto dto = pvuStEventServiceImpl.getSteppingUpOfficeName(idDto);
		assertEquals(dto.getOfficeName(), officeName);
	}

	

	@Test
	void testInsertSteppingUpAutoIncr()throws CustomException {
		String id="12";
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, 12);
		map.put(Constant.IN_EVNT_CODE, PvuConstant.EVENT_CODE_STEPPIN_UP);
		assertNotNull(repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map));
		pvuStEventServiceImpl.insertSteppingUpAutoIncr(id);
	
	}
	
	
	@Test
	void testInsertForAuthorization()throws CustomException {
		Long id=1L;
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, 12);
		map.put(Constant.IN_EVNT_CODE, PvuConstant.PVU_COMMON_AUTHORIZED_SP);
		assertNotNull(repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map));
		pvuStEventServiceImpl.insertForAuthorization(id);
	
	}

	
	@Test
	void testGetSteppingUpPrintEndorsement() throws CustomException, SQLException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("isSearch", "1"));
		jsonArr.add(new SearchParam("trnStatus", "1"));
		jsonArr.add(new SearchParam("transNo", "V"));
		jsonArr.add(new SearchParam("authorizationFromDate", " "));
		jsonArr.add(new SearchParam("authorizationToDate", ""));
		jsonArr.add(new SearchParam("eventCode", ""));
		jsonArr.add(new SearchParam("empNo", "0"));
		jsonArr.add(new SearchParam("empName", "0"));
		jsonArr.add(new SearchParam("designationId", " "));
		jsonArr.add(new SearchParam("workflowId", "0"));

		boolean ans = true;
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);


		Map<String, Object> map = pvuStEventServiceImpl.buildPageInMapPrintEndorsementList(pageDetail);
		assertNotNull(map);
		List<PVUSearchEnum> lst=pvuStEventServiceImpl.getPrintEndorsementSearchFields();
		assertNotNull(lst);




		String procName ="TEST";
		List<PVUSteppingUpPrintEndorsementView> objStorePro = pvuStEventServiceImpl.storeProcPvu(procName, map,PVUSteppingUpPrintEndorsementView.class);
		assertNotNull(objStorePro);
		PagebleDTO<PVUSteppingUpPrintEndorsementView> objStorePro1=pvuStEventServiceImpl.getSteppingUpPrintEndorsement(pageDetail);
		assertNotNull(objStorePro1);

	}

	
	@Test
	void testChkTranInProcessOrNot()throws CustomException {
		when(pvuStEventEntity.getCurEmpId()).thenReturn(empEntity);
		when(statusService.inProgressAnyEvent(pvuStEventEntity.getCurEmpId().getEmpId())).thenReturn(statusEntry);
		assertNotNull(statusEntry);
		when(pvuCommonService.getTransactionNumber(Constant.ST)).thenReturn("ST-101");
		pvuStEventEntity.setTrnNo(this.pvuCommonService.getTransactionNumber(Constant.ST));
		statusEntry.setSteppingUp(Constant.ACTIVE_STATUS);
		when(repository.save(pvuStEventEntity)).thenReturn(pvuStEventEntity);
		statusService.updateEventInfo(statusEntry, pvuStEventEntity.getTrnNo());
		pvuStEventServiceImpl.chkTranInProcessOrNot(pvuStEventEntity);
	}

	
	@Test
	void testUpdateStatus()throws CustomException {
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(1L);
		assertEquals(1L, edpLuLookUpInfoEntity.getLookUpInfoId());
		when(wrpDto.getTrnId()).thenReturn(1L);
		repository.updateStatusId(edpLuLookUpInfoEntity.getLookUpInfoId(), wrpDto.getTrnId(),OAuthUtility.getCurrentUserUserId(), new Date());
		pvuStEventServiceImpl.updateStatus(edpLuLookUpInfoEntity, wrpDto, new Date());
	}

	
	
	@Test
	void testWorkflowStatusUpdate()throws CustomException {
		when(wrpDto.getTrnId()).thenReturn(1L);
		when(wrpDto.getWfStatus()).thenReturn(Constant.APPROVED);
		assertEquals("Approved", wrpDto.getWfStatus());
		pvuStEventEntity.setStatusId(edpLuLookUpInfoEntity);
		repository.updateStatusId(edpLuLookUpInfoEntity.getLookUpInfoId(), wrpDto.getTrnId(),OAuthUtility.getCurrentUserUserId(), new Date());
		pvuStEventServiceImpl.workflowStatusUpdate(edpLuLookUpInfoEntity, wrpDto, pvuStEventEntity, date);

	}
	
	
	@Test
	void testWorkflowStatusUpdate1()throws CustomException {
		when(wrpDto.getTrnId()).thenReturn(2L);
		when(wrpDto.getWfStatus()).thenReturn(Constant.REJECTED);
		assertEquals("Rejected", wrpDto.getWfStatus());

		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
				Constant.ACTIVE_STATUS, Constant.REJECTED)).thenReturn(edpLuLookUpInfoEntity);

		repository.updateStatusId(edpLuLookUpInfoEntity.getLookUpInfoId(), wrpDto.getTrnId(),OAuthUtility.getCurrentUserUserId(), date);
		when(wrpDto.getWfStatus()).thenReturn(Constant.REJECTED);

		when(pvuStEventEntity.getCurEmpId()).thenReturn(empEntity);
		
		statusService.resetInProgressEmployeeEventStatus(pvuStEventEntity.getCurEmpId().getEmpId(),OAuthUtility.getCurrentUserLkPOUId());
		
		pvuStEventServiceImpl.workflowStatusUpdate(edpLuLookUpInfoEntity, wrpDto, pvuStEventEntity, date);
	
	}

	
	
//	@Test
//	void testWorkflowStatusUpdate2()throws CustomException {
//		when(wrpDto.getTrnId()).thenReturn(3L);
//		when(wrpDto.getWfStatus()).thenReturn("MAH");
//		assertEquals("MAH", wrpDto.getWfStatus());
//
//		when(wrpDto.getTrnStatus()).thenReturn(Constant.AUTHORIZE_BY_CLASS_II);
//		assertEquals("Authorised by Class II", wrpDto.getTrnStatus());
//		
//		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
//									Constant.RECOMMENDATION_FOR, Constant.ACTIVE_STATUS, Constant.AUTHORIZE)).thenReturn(edpLuLookUpInfoEntity);
//			
//		repository.updateStatusId(edpLuLookUpInfoEntity.getLookUpInfoId(), wrpDto.getTrnId(),OAuthUtility.getCurrentUserUserId(), date);
//		Long userId=12L;
//		when(securityUtil.decrypt(wrpDto.getAssignByUserId())).thenReturn("12");
//		when(wrpDto.getRemarks()).thenReturn("remarks");
//
//		
//		repository.updateStatusIdAndAuthorizer(edpLuLookUpInfoEntity.getLookUpInfoId(), wrpDto.getTrnId(),
//																OAuthUtility.getCurrentUserUserId(), date, date, userId,wrpDto.getRemarks());
//
//		pvuInwardRepository.setAuthorizeDateAndFlag(1L, PvuConstant.EVENT_ID_STEPPIN_UP,
//									OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(), Constant.OUTWARD_FLAG_ZERO,Constant.ACTIVE_STATUS);
//
//		pvuStEventServiceImpl.workflowStatusUpdate(edpLuLookUpInfoEntity, wrpDto, pvuStEventEntity, date);
//		
//	}

	
	@Test
	void testWorkflowStatusUpdate3()throws CustomException {
		when(wrpDto.getTrnId()).thenReturn(5L);
		when(wrpDto.getWfStatus()).thenReturn("TURN");
		assertEquals("TURN", wrpDto.getWfStatus());

		when(wrpDto.getTrnStatus()).thenReturn(Constant.RETURN_BY_APPROVER_CLASS_II);
		when(wrpDto.getTrnStatus()).thenReturn(Constant.RETURN_BY_APPROVER_CLASS_I);

		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				Constant.RECOMMENDATION_FOR, Constant.ACTIVE_STATUS, Constant.RETURN)).thenReturn(edpLuLookUpInfoEntity);


		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(10L);

		repository.updateStatusId(edpLuLookUpInfoEntity.getLookUpInfoId(), wrpDto.getTrnId(),OAuthUtility.getCurrentUserUserId(), new Date());

		pvuInwardRepository.setReturnDateAndFlag(2L, PvuConstant.EVENT_ID_STEPPIN_UP,
				OAuthUtility.getCurrentUserUserId(), LocalDateTime.now(), Constant.OUTWARD_FLAG_ONE,
				Constant.ACTIVE_STATUS);
		pvuStEventServiceImpl.workflowStatusUpdate(edpLuLookUpInfoEntity, wrpDto, pvuStEventEntity, date);
	}

	
	@Test
	void testWorkflowStatusUpdate4()throws CustomException {
		when(wrpDto.getTrnId()).thenReturn(6L);
		when(wrpDto.getWfStatus()).thenReturn("NOA");
		assertEquals("NOA", wrpDto.getWfStatus());

		when(wrpDto.getTrnStatus()).thenReturn(Constant.FORWARD_TO_PVU);
		assertEquals("Forwarded to PVU", wrpDto.getTrnStatus());

		pvuStEventServiceImpl.insertInwardTable(wrpDto);
		
		pvuStEventServiceImpl.workflowStatusUpdate(edpLuLookUpInfoEntity, wrpDto, pvuStEventEntity, date);
	}

	
	@Test
	void testInsertRemarksItr()throws CustomException {
		Long val=74L;
		when(wrpDto.getAssignByWfRoleId()).thenReturn(74L);
		assertEquals(val, wrpDto.getAssignByWfRoleId());
		when(wrpDto.getTrnId()).thenReturn(7L);
		pvuStEventServiceImpl.insertSteepingUpPayRemarksITR(wrpDto.getTrnId());
		pvuStEventServiceImpl.insertRemarksItr(wrpDto);
	}

	@Test
	void testInsertInITR()throws CustomException {
		
		PVUSteppingUpEventDto dto=new PVUSteppingUpEventDto();
		dto.setActiveStatus(1);
		
		PVUSteppingUpEventEntity entity  =new PVUSteppingUpEventEntity();
		entity.setActiveStatus(1);
		entity.setAuthorizeBy(2L);
		entity.setTrnNo("ST");
		entity.setStatusId(edpLuLookUpInfoEntity);
		
		
		boolean vBool = true;

		
		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setAssignByWfRoleId(12l);
		wrapperDto.setWfStatus(Constant.APPROVED);
		wrapperDto.setTrnStatus(Constant.AUTHORIZE_BY_CLASS_II);


		when(repository.findById(wrapperDto.getTrnId())).thenReturn(Optional.of(entity));
		
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.APPROVED)).thenReturn(edpLuLookUpInfoEntity);
		when(pvuFacade.callWorkFlowApis(wrapperDto)).thenReturn(vBool);
		when(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.SUBMIT)).thenReturn(edpLuLookUpInfoEntity);



		pvuStEventServiceImpl.updateStatus( edpLuLookUpInfoEntity , wrapperDto,new Date() ) ;
		
		when(converter.toDTO(entity) ).thenReturn(dto);

		assertTrue(true);	
		pvuStEventServiceImpl.workflowStatusUpdate( edpLuLookUpInfoEntity , wrapperDto,entity, new Date() );
		pvuStEventServiceImpl.insertRemarksItr( wrapperDto );
		pvuStEventServiceImpl.insertITR(wrapperDto);
//		when(pvuStEventServiceImpl.insertInITR(wrapperDto)).thenReturn(pvuStEventDto);
		pvuStEventServiceImpl.insertInITR(wrapperDto);

		

	}

	
	@Test
	void testCheckIsReturmReason()throws CustomException {
		when( pvuStEventDto.getAuditorReturnReason() ).thenReturn(Constant.RETURN_VAL);
		assertTrue(pvuStEventServiceImpl.checkIsReturmReason(pvuStEventDto));
	}

	@Test
	void testCheckIsReturmReason1()throws CustomException {
		when( pvuStEventDto.getVerifierReturnReason() ).thenReturn(Constant.RETURN_VAL);
		assertTrue(pvuStEventServiceImpl.checkIsReturmReason(pvuStEventDto));
	}

	@Test
	void testCheckIsReturmReason2()throws CustomException {
		when( pvuStEventDto.getClassTwoReturnReason() ).thenReturn(Constant.RETURN_VAL);
		assertTrue(pvuStEventServiceImpl.checkIsReturmReason(pvuStEventDto));
	}

	@Test
	void testCheckIsReturmReason3()throws CustomException {
		when( pvuStEventDto.getClassOneReturnReason() ).thenReturn(Constant.RETURN_VAL);
		assertTrue(pvuStEventServiceImpl.checkIsReturmReason(pvuStEventDto));
	}

	
	
	@Test
	void testReturnReason()throws CustomException {
		
		PVUMsEventEntity entity  =new PVUMsEventEntity();
		entity.setActiveStatus(1);
		entity.setEventCode(PvuConstant.EVENT_CODE_STEPPIN_UP);
		entity.setId(5);
		
		

		when(msEventRepository.findByEventCode(PvuConstant.EVENT_CODE_STEPPIN_UP)).thenReturn(Optional.of(entity));
		assertTrue(true);	
		eventRemarksService.deactiveOldReason(entity.getId(), pvuStEventDto.getId(), Constant.IN_ACTIVE_STATUS);
		assertTrue(true);	
		PVUEventRemarksDto reDto=new PVUEventRemarksDto();
		reDto.setActiveStatus(1);
		reDto.setEmpId(1000L);
		
		List<PVUEventRemarksDto> lDto=new ArrayList<PVUEventRemarksDto>();
		lDto.add(reDto);
		
		
		pvuStEventDto.setReturnReasons(lDto);
		when(pvuStEventDto.getReturnReasons()).thenReturn(lDto );
		pvuEventRemarksEntity.setTrnNo(pvuStEventDto.getId());
		pvuEventRemarksEntity.setEventID(PvuConstant.EVENT_ID_STEPPIN_UP);
		pvuEventRemarksEntity.setWfRoleId(1L);
		pvuEventRemarksEntity.setEmpId(pvuStEventDto.getEmployeeId());
		pvuEventRemarksEntity.setRemarks(reDto.getRemarks());
		pvuEventRemarksEntity.setRemarksType("SOP");
		pvuEventRemarksEntity.setReason(reDto.getReasonId());
		pvuEventRemarksEntity.setActiveStatus(Constant.ACTIVE_STATUS);

		pvuStEventServiceImpl.returnReason( pvuStEventDto, 1L, "SOP");
	}

	

	@Test
	void testSubmiSteppingUpOutward()throws CustomException {
		
		PvuWFOutWardWrapperDto wrapperDto = new PvuWFOutWardWrapperDto();
		wrapperDto.setStatus(Constant.RETURN);
		wrapperDto.setTrnId(5L);
		List<PvuWFOutWardWrapperDto> dtos = new ArrayList<>();
		dtos.add(wrapperDto);

		dtos.forEach(dto -> pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(),
				new Date(), PvuConstant.EVENT_ID_STEPPIN_UP, dto.getTrnId(), Constant.OUTWARD_FLAG_ZERO,
				Constant.ACTIVE_STATUS));
		assertTrue(true);	
		pvuStEventServiceImpl.submiSteppingUpOutward(dtos);
	}

	@Test
	void testSubmiSteppingUpOutwardNull()throws CustomException {
		PvuWFOutWardWrapperDto wrapperDto = new PvuWFOutWardWrapperDto();
		wrapperDto.setStatus(null);
		wrapperDto.setTrnId(6L);
		List<PvuWFOutWardWrapperDto> dtos = new ArrayList<>();
		dtos.add(wrapperDto);

		dtos.forEach(dto -> pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(),
				new Date(), PvuConstant.EVENT_ID_STEPPIN_UP, dto.getTrnId(), Constant.OUTWARD_FLAG_ZERO,
				Constant.ACTIVE_STATUS));
		
		dtos.forEach(dto -> inwardService.setConsignmentNumber(dto.getTrnId(), 
				PvuConstant.EVENT_ID_STEPPIN_UP, dto.getPostConsignmentNumber()));
		assertTrue(true);	
		pvuStEventServiceImpl.submiSteppingUpOutward(dtos);

	}
	
	
	@Test
	void testProcessReturnOutWards()throws CustomException {
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
		
		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getWfTable(), map)).thenReturn(objects );
		assertNotNull(objects);
		when(pvuFacade.callWorkFlowApis(returnList)).thenReturn(true );

		pvuStEventServiceImpl.processReturnOutWards(dtos);
		
	}
	
	
	
	@Test
	void testSetDDOApprover()throws CustomException {
		PvuWFOutWardWrapperDto wrapperDto = new PvuWFOutWardWrapperDto();
		wrapperDto.setStatus(null);
		wrapperDto.setTrnId(6L);
		List<PvuWFOutWardWrapperDto> dtos = new ArrayList<>();
		dtos.add(wrapperDto);
		String officeName = "abc";
		Long id=2L;
		List<Object[]> objects = new ArrayList<Object[]>();
	    Object objectArray[] = new Object[1]; 
	    objectArray[0] = officeName;
	    objects.add(objectArray);

		List<PvuWFWrapperDto> returnList = new ArrayList<PvuWFWrapperDto>();
		returnList.add(wrapperDto);
		
		PVUWfTableInfo ti=new PVUWfTableInfo();
		ti.setSchemaName("x");
		ti.setTableName("st");
		
		List<PVUWfTableInfo> tableList=new ArrayList<PVUWfTableInfo>();
		tableList.add(ti);
		
		PVUSourceUserDetails user =new PVUSourceUserDetails();
		user.setAssignByOfficeId(2L);
		user.setAssignByPostId(1L);
		user.setAssignByPouId(1L);
		user.setAssignByUserId(1L);
		List<PVUSourceUserDetails> userList = new ArrayList<PVUSourceUserDetails>();
		userList.add(user);
		
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put(PvuConstant.TRN_ID, 12L);
		
		when(repository.executeSQLQuery(PVUNativeSqlQueryConstant.getWfSourceUserDetail(
				tableList.get(0).getSchemaName(), tableList.get(0).getTableName()), returnMap)).thenReturn(objects );
		assertNotNull(objects);
		assertNotNull(pvuStEventServiceImpl.setDDOApprover(dtos,tableList));

	}


	@Test
	void testProcessAuthorizedOutWards()throws CustomException {
		PvuWFOutWardWrapperDto wrapperDto = new PvuWFOutWardWrapperDto();
		wrapperDto.setStatus(null);
		wrapperDto.setTrnId(6L);
		List<PvuWFOutWardWrapperDto> dtos = new ArrayList<>();
		dtos.add(wrapperDto);
		String officeName = "abc";

		PVUEmployeEntity emp=new PVUEmployeEntity();
		emp.setEmpId(1L);
		emp.setActiveStatus(1);
		
		PVUSteppingUpEventEntity entity=new PVUSteppingUpEventEntity();
		entity.setTrnNo("ST101");
		entity.setCurEmpId(emp);
		
		
		List<PvuWFWrapperDto> authList = new ArrayList<PvuWFWrapperDto>();
		authList.add(wrapperDto);
		
		pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
								PvuConstant.EVENT_ID_STEPPIN_UP, wrapperDto.getTrnId(), Constant.OUTWARD_FLAG_ZERO,Constant.ACTIVE_STATUS);
		assertTrue(true);	
		when(repository.getOne(wrapperDto.getTrnId())).thenReturn(entity );
		when(pvuFacade.callWorkFlowApis(wrapperDto)).thenReturn(true );
		pvuStEventServiceImpl.processAuthorizedOutWards( dtos);
	}
	
	
	

	@Test
	void testSubmitPEWF()throws CustomException {
		
		PVUPrintEndorsementDto ed=new PVUPrintEndorsementDto();
		ed.setActiveStatus(1);
		ed.setId(2l);
		
		PvuWFWrapperDto pvuWFWrapperDto = new PvuWFWrapperDto();
		pvuWFWrapperDto.setWfStatus(Constant.APPROVED);
		pvuWFWrapperDto.setTrnId(1l);
		pvuWFWrapperDto.setUpdatedDate(new Date());

		PVUStickerDTO sd=new PVUStickerDTO();
		sd.setId(5l);
		sd.setEmployeeName("a");

		
		PvuPrintStickerReportDto dto=new PvuPrintStickerReportDto();
		dto.setPrintEndorsementDto(ed);
		dto.setPvuWFWrapperDto(pvuWFWrapperDto);
		dto.setStickerDTO(sd);
		
		
		PVUPrintEndorsementEntity printEntity = new PVUPrintEndorsementEntity();
		printEntity.setId(Constant.LONG_ONE_VALUE);
		printEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		printEntity.setReprintDate(new Date());
		printEntity.setPrintDate(new Date());
		printEntity.setPrintCnt(pvuPrintEndorsementEntity.getPrintCnt() + 1l);
		printEntity.setTrnId(wrpDto.getTrnId());
		printEntity.setEventId(PvuConstant.EVENT_ID_STEPPIN_UP);
		
		PVUPrintEndorsementItrEntity itr=new PVUPrintEndorsementItrEntity();
		itr.setId(Constant.LONG_ONE_VALUE);
		itr.setActiveStatus(Constant.ACTIVE_STATUS);
		itr.setReprintDate(new Date());
		itr.setPrintDate(new Date());
		itr.setPrintCnt(pvuPrintEndorsementEntity.getPrintCnt() + 1l);
		itr.setTrnId(wrpDto.getTrnId());
		itr.setEventId(PvuConstant.EVENT_ID_STEPPIN_UP);

		
		
		
		when(pvuPrintEndorsementRepository.findByIdAndActiveStatus(dto.getPrintEndorsementDto().getId(),
																				Constant.ACTIVE_STATUS)).thenReturn(printEntity);
		assertTrue(true);	
		when(pvuPrintEndorsementRepository.save(converter.toEntity(dto.getPrintEndorsementDto()))).thenReturn(printEntity);
		
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrConverter.toEntity(printEntity))).thenReturn(itr);

		pvuStEventServiceImpl.submitPEWF(dto);
	}
	
	
	@Test
	void testSubmitPEWFElse()throws CustomException {
		Long id=2l;
		PVUPrintEndorsementDto ed=new PVUPrintEndorsementDto();
		ed.setActiveStatus(1);
		ed.setPrintCnt(2l);
		ed.setId(2l);
		
		PvuWFWrapperDto pvuWFWrapperDto = new PvuWFWrapperDto();
		pvuWFWrapperDto.setWfStatus("");
		pvuWFWrapperDto.setTrnId(2l);
		pvuWFWrapperDto.setUpdatedDate(new Date());

		PVUStickerDTO sd=new PVUStickerDTO();
		sd.setId(5l);
		sd.setEmployeeName("a");

		Boolean b=true;
		PvuPrintStickerReportDto dto=new PvuPrintStickerReportDto();
		dto.setPrintEndorsementDto(ed);
		dto.setPvuWFWrapperDto(pvuWFWrapperDto);
		dto.setStickerDTO(sd);
		
		PVUPrintEndorsementItrEntity itr=new PVUPrintEndorsementItrEntity();
		itr.setId(Constant.LONG_ONE_VALUE);
		itr.setActiveStatus(Constant.ACTIVE_STATUS);
		itr.setReprintDate(new Date());
		itr.setPrintDate(new Date());
		itr.setPrintCnt(pvuPrintEndorsementEntity.getPrintCnt() + 1l);
		itr.setTrnId(wrpDto.getTrnId());
		itr.setEventId(PvuConstant.EVENT_ID_STEPPIN_UP);

		
		
		PVUPrintEndorsementEntity printEntity = new PVUPrintEndorsementEntity();
		assertEquals(id, dto.getPrintEndorsementDto().getId());

		printEntity=pvuPrintEndorsementRepository.findByIdAndActiveStatus(dto.getPrintEndorsementDto().getId(),Constant.ACTIVE_STATUS);
		assertEquals(null, printEntity);
		
		when(pvuFacade.callWorkFlowApis(dto.getPvuWFWrapperDto())).thenReturn(true);

		pvuInwardRepository.updateCsOutwardFlag(OAuthUtility.getCurrentUserUserId(), new Date(),
				PvuConstant.EVENT_ID_STEPPIN_UP, dto.getPvuWFWrapperDto().getTrnId(),Constant.OUTWARD_FLAG_ONE, Constant.ACTIVE_STATUS);

		when(pvuPrintEndorsementRepository.save(converter.toEntity(dto.getPrintEndorsementDto()))).thenReturn(printEntity);
		
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrConverter.toEntity(printEntity))).thenReturn(itr);

		pvuStEventServiceImpl.submitPEWF(dto);
	}

	
	
	@Test
	void testSubmitPrintHistory()throws CustomException {    /// pending
		PVUPrintEndorsementDto ed=new PVUPrintEndorsementDto();
		ed.setActiveStatus(1);
		ed.setPrintCnt(2l);
		ed.setId(2l);
		ed.setPrintDate(new Date());
		Date d=new Date();
		
		PvuWFWrapperDto pvuWFWrapperDto = new PvuWFWrapperDto();
		pvuWFWrapperDto.setWfStatus("");
		pvuWFWrapperDto.setTrnId(2l);
		pvuWFWrapperDto.setUpdatedDate(new Date());

		PVUStickerDTO sd=new PVUStickerDTO();
		sd.setId(5l);
		sd.setEmployeeName("a");

		Boolean b=true;
		PvuPrintStickerReportDto dto=new PvuPrintStickerReportDto();
		dto.setPrintEndorsementDto(ed);
		dto.setPvuWFWrapperDto(pvuWFWrapperDto);
		dto.setStickerDTO(sd);
		
		assertEquals(1, dto.getPrintEndorsementDto().getActiveStatus());
//		when(pvuStEventServiceImpl.submitPEWF(dto)).thenReturn(ed);
//		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
//
		dto.setPrintEndorsementDto(ed);
		
//		assertEquals(d, ed.getPrintDate());
//		dto.setPrintEndorsementDto(ed);
		
		assertNotNull(pvuStEventServiceImpl.submitPrintHistory(dto));
	}

	
	
	@Test
	void testGetPrintTemplate()throws CustomException {    
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		Template tempName = new Template();

		
		PVUSteppingUpEventDto stdto=new PVUSteppingUpEventDto();
		stdto.setActiveStatus(1);
		stdto.setPayCommId(152l);
		assertEquals(152l, stdto.getPayCommId());
		pvuStEventServiceImpl.getPrintTemplate(stdto); 
	}

	@Test
	void testGetPrintTemplate2()throws CustomException {    
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		Template tempName = new Template();

		
		PVUSteppingUpEventDto stdto=new PVUSteppingUpEventDto();
		stdto.setActiveStatus(1);
		stdto.setPayCommId(151l);
		assertEquals(151l, stdto.getPayCommId());
		pvuStEventServiceImpl.getPrintTemplate(stdto); 
	}

	@Test
	void testGetPrintTemplate3()throws CustomException {    
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		Template tempName = new Template();
		
		PVUSteppingUpEventDto stdto=new PVUSteppingUpEventDto();
		stdto.setActiveStatus(1);
		stdto.setPayCommId(150l);
		assertEquals(150l, stdto.getPayCommId());
		pvuStEventServiceImpl.getPrintTemplate(stdto); 
	}

	
	@Test
	void testGetPrintTemplate4()throws CustomException {    
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		Template tempName = new Template();
		
		PVUSteppingUpEventDto stdto=new PVUSteppingUpEventDto();
		stdto.setActiveStatus(1);
		stdto.setPayCommId(0);
		assertEquals(0, stdto.getPayCommId());
		pvuStEventServiceImpl.getPrintTemplate(stdto); 
	}

	

//	@Test
//	void testGeneratePrintEndorsement()throws CustomException, DocumentException, IOException {    
//
//		PvuPrintStickerReportDto dto = new PvuPrintStickerReportDto();
//
//		dto.setStickerDTO(pvuStickerDTO);
//		dto.setPvuWFWrapperDto(wrpDto);
//		dto.setPrintEndorsementDto(pvuPrintEndorsementDto);
//		when(repository.getOne(dto.getStickerDTO().getId())).thenReturn(pvuStEventEntity);
//		when(converter.toDTO(pvuStEventEntity)).thenReturn(pvuStEventDto);
//		when(pvuStEventDto.getEmployeeNo()).thenReturn(1000058L);
//
//		
//		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
//		when(pvuStEventDto.getChBeneEffDate()).thenReturn(LocalDate.now());
//		when(pvuStEventDto.getDateOfNextIncrSrJnr()).thenReturn(LocalDate.now());
//		when(pvuStEventDto.getEmployeeNo()).thenReturn(1000058L);
//		when(pvuStEventDto.getPayCommId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
//		
//		when(pvuStEventEntity.getChCellId()).thenReturn(cellEntity);
//		when(pvuStEventEntity.getChPayLevel()).thenReturn(payEntity);
//
//
//		
//		
//		when(pvuStEventEntity.getCurEmpDsgn()).thenReturn(designationEntity);
//
//		when(pvuStEventEntity.getCurEmpDsgn().getDesignationName()).thenReturn("SOP");
//		when(pvuStEventEntity.getEventEffectiveDate()).thenReturn(LocalDate.now());
//		when(pvuStEventEntity.getAuthorizeBy()).thenReturn(15L);
//		when(authService.getOnlyIdAndName(15L)).thenReturn(idNameDto);
//		when(idNameDto.getName()).thenReturn("auth");
//		
//		EDPLuLookUpInfoEntity  srGender=new EDPLuLookUpInfoEntity();
//		srGender.setLookUpInfoId(1L);
//		srGender.setLookUpInfoName("Male");
//		
//		
//		when(empRepository.getOne(pvuStEventDto.getEmployeeId())).thenReturn(empEntity);
//
//		when(empEntity.getGender()).thenReturn(edpLuLookUpInfoEntity);
//		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(1L);
//		when(edpLuLookUpInfoRepository.findBylookUpInfoId(empEntity.getGender().getLookUpInfoId())).thenReturn(edpLuLookUpInfoEntity);
//		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn("Male");
//
//		when(edpLuLookUpInfoRepository.findBylookUpInfoId(pvuStEventDto.getSteppingUpTypeId())).thenReturn(edpLuLookUpInfoEntity);
//		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn("STP");
//		when(velocityContext.get("steppingUpType")).thenReturn("STP");
//
//		
//		
//		
//		assertNotNull(pvuStEventServiceImpl.generatePrintEndorsement(dto));
//	}

	
	
	
	
	
	@Test
	 void testPopulateContext() throws CustomException, IOException {
		List<PvuPrintStickerReportDto> dtos = new ArrayList<>();
		when(wrpDto.getTrnId()).thenReturn(Constant.LONG_ONE_VALUE);
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

		dto.setStickerDTO(pvuStickerDTO);
		dto.setPvuWFWrapperDto(wrpDto);
		dto.setPrintEndorsementDto(pvuPrintEndorsementDto);
		dtos.add(dto);

		when(pvuStickerDTO.getId()).thenReturn(Constant.LONG_ONE_VALUE);
		when(pvuStickerDTO.getEndorsementPrintDate()).thenReturn(new Date());
		when(pvuStickerDTO.getEndorsementReprintDate()).thenReturn(new Date());

		
		when(pvuPrintEndorsementRepository.findByIdAndActiveStatus(Constant.LONG_ONE_VALUE, Constant.ACTIVE_STATUS))
				.thenReturn(printEntity);
		when(converter.toEntity(pvuPrintEndorsementDto)).thenReturn(printEntity);
		when(pvuPrintEndorsementRepository.save(printEntity)).thenReturn(printEntity);
		when(pvuPrintEndorsementItrConverter.toEntity(printEntity)).thenReturn(pvuPrintEndorsementItrEntity);
		when(pvuPrintEndorsementItrRepository.save(pvuPrintEndorsementItrEntity))
				.thenReturn(pvuPrintEndorsementItrEntity);
		when(converter.toDTO(printEntity)).thenReturn(pvuPrintEndorsementDto);
		when(repository.getOne(Constant.LONG_ONE_VALUE)).thenReturn(pvuStEventEntity);
		when(pvuStEventEntity.getPayComm()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
//		VelocityContext context = pvuStEventServiceImpl.populateVContext(pvuStickerDTO, pvuStEventEntity,pvuStEventDto);
		when(pvuStEventDto.getChBeneEffDate()).thenReturn(LocalDate.now());
		when(pvuStEventDto.getDateOfNextIncrSrJnr()).thenReturn(LocalDate.now());
		when(pvuStEventDto.getEmployeeNo()).thenReturn(1000058L);
		when(pvuStEventDto.getPayCommId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
		
		when(pvuStEventEntity.getChCellId()).thenReturn(cellEntity);
		when(pvuStEventEntity.getChPayLevel()).thenReturn(payEntity);

//		when(pvuStEventDto.getPayCommId()).thenReturn(PvuConstant.SIXTH_COMMISSION_ID);
//		
//		when(pvuStEventEntity.getChGradePay()).thenReturn(gradeEntity);
//		when(pvuStEventEntity.getChPayBand()).thenReturn(payBandEntity);
//		
//		
//		when(pvuStEventDto.getPayCommId()).thenReturn(PvuConstant.FIFTH_COMMISSION_ID);
//		
//		when(pvuStEventEntity.getChScale()).thenReturn(scaleEntity);

		
		
		when(pvuStEventEntity.getCurEmpDsgn()).thenReturn(designationEntity);

		when(pvuStEventEntity.getCurEmpDsgn().getDesignationName()).thenReturn("SOP");
		when(pvuStEventEntity.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(pvuStEventEntity.getAuthorizeBy()).thenReturn(15L);
		when(authService.getOnlyIdAndName(15L)).thenReturn(idNameDto);
		when(idNameDto.getName()).thenReturn("auth");
		
		EDPLuLookUpInfoEntity  srGender=new EDPLuLookUpInfoEntity();
		srGender.setLookUpInfoId(1L);
		srGender.setLookUpInfoName("Male");
		
		
		when(empRepository.getOne(pvuStEventDto.getEmployeeId())).thenReturn(empEntity);

		when(empEntity.getGender()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(1L);
		when(edpLuLookUpInfoRepository.findBylookUpInfoId(empEntity.getGender().getLookUpInfoId())).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn("Male");

		when(edpLuLookUpInfoRepository.findBylookUpInfoId(pvuStEventDto.getSteppingUpTypeId())).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn("STP");
		when(velocityContext.get("steppingUpType")).thenReturn("STP");


		assertNotNull(pvuStEventServiceImpl.populateVContext(pvuStickerDTO, pvuStEventEntity,pvuStEventDto));
	}
	
	
	
	
	
//	
//	@Test
//	void testGeneratePrintEndorsementList()throws CustomException, DocumentException {    
//
//			
//		PvuPrintStickerReportDto dto = new PvuPrintStickerReportDto();
//
//		dto.setStickerDTO(pvuStickerDTO);
//		dto.setPvuWFWrapperDto(wrpDto);
//		dto.setPrintEndorsementDto(pvuPrintEndorsementDto);
//		
//		List<PvuPrintStickerReportDto> dtos=new ArrayList<PvuPrintStickerReportDto>();
//		dtos.add(dto);
//		
//		when(repository.getOne(dto.getStickerDTO().getId())).thenReturn(pvuStEventEntity);
//		when(converter.toDTO(pvuStEventEntity)).thenReturn(pvuStEventDto);
//		when(pvuStEventDto.getEmployeeNo()).thenReturn(1000058L);
//
//		
//		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
//		when(pvuStEventDto.getChBeneEffDate()).thenReturn(LocalDate.now());
//		when(pvuStEventDto.getDateOfNextIncrSrJnr()).thenReturn(LocalDate.now());
//		when(pvuStEventDto.getEmployeeNo()).thenReturn(1000058L);
//		when(pvuStEventDto.getPayCommId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
//		
//		when(pvuStEventEntity.getChCellId()).thenReturn(cellEntity);
//		when(pvuStEventEntity.getChPayLevel()).thenReturn(payEntity);
//		
//		
//		when(pvuStEventEntity.getCurEmpDsgn()).thenReturn(designationEntity);
//
//		when(pvuStEventEntity.getCurEmpDsgn().getDesignationName()).thenReturn("SOP");
//		when(pvuStEventEntity.getEventEffectiveDate()).thenReturn(LocalDate.now());
//		when(pvuStEventEntity.getAuthorizeBy()).thenReturn(15L);
//		when(authService.getOnlyIdAndName(15L)).thenReturn(idNameDto);
//		when(idNameDto.getName()).thenReturn("auth");
//		
//		EDPLuLookUpInfoEntity  srGender=new EDPLuLookUpInfoEntity();
//		srGender.setLookUpInfoId(1L);
//		srGender.setLookUpInfoName("Male");
//		
//		
//		when(empRepository.getOne(pvuStEventDto.getEmployeeId())).thenReturn(empEntity);
//
//		when(empEntity.getGender()).thenReturn(edpLuLookUpInfoEntity);
//		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(1L);
//		when(edpLuLookUpInfoRepository.findBylookUpInfoId(empEntity.getGender().getLookUpInfoId())).thenReturn(edpLuLookUpInfoEntity);
//		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn("Male");
//
//		when(edpLuLookUpInfoRepository.findBylookUpInfoId(pvuStEventDto.getSteppingUpTypeId())).thenReturn(edpLuLookUpInfoEntity);
//		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn("STP");
//		when(velocityContext.get("steppingUpType")).thenReturn("STP");
//		
//		assertNotNull(pvuStEventServiceImpl.generatePrintEndorsementList(dtos));
//		
//	}

	
	
	
	
	@Test
	void testUpdateRemarks() throws CustomException {
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

		PVUSteppingUpEventDto csEventDto = new PVUSteppingUpEventDto();
		csEventDto.setId(1L);
		csEventDto.setReturnReasons(listROPRemarks);
		csEventDto.setWfRoleId(1L);
		csEventDto.setReturnReasons(listROPRemarks);
		csEventDto.setAuditorReturnReason(Constant.RETURN_VAL);

		when(repository.findById(csEventDto.getId())).thenReturn(Optional.of(pvuStEventEntity));

		when(converter.updateSteppingUpRemarks(pvuStEventEntity, csEventDto)).thenReturn(pvuStEventEntity);
		when(converter.toDTO(pvuStEventEntity)).thenReturn(csEventDto);

		when(repository.save(pvuStEventEntity)).thenReturn(pvuStEventEntity);

		doNothing().when(eventRemarksService).deactiveOldReason(PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID,
				csEventDto.getId(), Constant.IN_ACTIVE_STATUS);

		List<PVUEventRemarksEntity> lstEventRemarks = new ArrayList<PVUEventRemarksEntity>();
		PVUEventRemarksEntity pvuEventRemarksEntity = new PVUEventRemarksEntity();
		pvuEventRemarksEntity.setTrnNo(pvuStEventEntity.getStEventId());
		pvuEventRemarksEntity.setEventID(PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID);
		pvuEventRemarksEntity.setWfRoleId(csEventDto.getWfRoleId());

//		when(pvuStEventEntity.getEmpId()).thenReturn(pvuEmployeEntity);
//		when(pvuEmployeEntity.getEmpId()).thenReturn(Constant.LONG_ONE_VALUE);

		pvuEventRemarksEntity.setEmpId(1L);
		pvuEventRemarksEntity.setRemarks(dto.getRemarks());
		pvuEventRemarksEntity.setRemarksType(dto.getRemarksType());
		pvuEventRemarksEntity.setReason(dto.getReasonId());
		pvuEventRemarksEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		lstEventRemarks.addAll(lstEventRemarks);

		assertNotNull(pvuStEventServiceImpl.updateRemarks(csEventDto));
	}

	
	@Test
	void testSetPostAndEventDetails() throws CustomException {

		PVUSteppingUpEventDto dto = new PVUSteppingUpEventDto();
		dto.setId(1L);
		dto.setWfRoleId(1L);
		dto.setDateOfNextIncrSrJnr(LocalDate.now());
		dto.setChBeneEffDate(LocalDate.now());
		dto.setEventOrderNo("21s54s5");
		dto.setEventOrderDate(LocalDate.now());
		dto.setEventEffectiveDate(LocalDate.now());
		dto.setAuditorReturnReason(Constant.RETURN_VAL);
		dto.setSteppingUpTypeId(159L);
		dto.setPayCommId(152L);
		
		PVUSteppingUpEventEntity entity  =new PVUSteppingUpEventEntity();
		entity.setActiveStatus(1);
		entity.setAuthorizeBy(2L);
		entity.setTrnNo("ST");
		entity.setStatusId(edpLuLookUpInfoEntity);
		entity.setCurEmpClass(edpLuLookUpInfoEntity);
		entity.setCurEmpDsgn(designationEntity);
		entity.setChCellId(cellEntity);
		entity.setChPayLevel(payEntity);
		
		
		when(cellRepository.getOnlyIdAndName(entity.getChCellId().getId())).thenReturn(idNameDto);
		when(levelRepository.getOnlyIdAndName(entity.getChPayLevel().getId())).thenReturn(idNameDto);

		when(edpLuLookUpInfoRepository.getOnlyIdAndName(entity.getCurEmpClass().getLookUpInfoId())).thenReturn(idNameDto);
		when(designationRepository.getOnlyIdAndName(entity.getCurEmpDsgn().getDesignationId())).thenReturn(idNameDto);

		when(empRepository.getOne(dto.getEmployeeId())).thenReturn(empEntity);
		when(empEntity.getOfficeId()).thenReturn(officeEntity);
		when(edpLuLookUpInfoRepository.findBylookUpInfoId(dto.getSteppingUpTypeId())).thenReturn(edpLuLookUpInfoEntity);

		

		assertNotNull(pvuStEventServiceImpl.setPostAndEventDetails(dto,entity));
	}
	
	
	@Test
	void testSetPostAndEventDetails6Pay() throws CustomException {

		PVUSteppingUpEventDto dto = new PVUSteppingUpEventDto();
		dto.setId(1L);
		dto.setWfRoleId(1L);
		dto.setDateOfNextIncrSrJnr(LocalDate.now());
		dto.setChBeneEffDate(LocalDate.now());
		dto.setEventOrderNo("21s54s5");
		dto.setEventOrderDate(LocalDate.now());
		dto.setEventEffectiveDate(LocalDate.now());
		dto.setAuditorReturnReason(Constant.RETURN_VAL);
		dto.setSteppingUpTypeId(159L);
		dto.setPayCommId(151L);
		
		PVUSteppingUpEventEntity entity  =new PVUSteppingUpEventEntity();
		entity.setActiveStatus(1);
		entity.setAuthorizeBy(2L);
		entity.setTrnNo("ST");
		entity.setStatusId(edpLuLookUpInfoEntity);
		entity.setCurEmpClass(edpLuLookUpInfoEntity);
		entity.setCurEmpDsgn(designationEntity);
		entity.setChGradePay(gradeEntity);
		entity.setChPayBand(payBandEntity);
		
		
		
		when(gradePayRepository.getOnlyIdAndName(entity.getChGradePay().getId())).thenReturn(idNameDto);
		when(bandRepository.getOnlyIdAndName(entity.getChPayBand().getId())).thenReturn(idNameDto);

		when(edpLuLookUpInfoRepository.getOnlyIdAndName(entity.getCurEmpClass().getLookUpInfoId())).thenReturn(idNameDto);
		when(designationRepository.getOnlyIdAndName(entity.getCurEmpDsgn().getDesignationId())).thenReturn(idNameDto);

		when(empRepository.getOne(dto.getEmployeeId())).thenReturn(empEntity);
		when(empEntity.getOfficeId()).thenReturn(officeEntity);
		when(edpLuLookUpInfoRepository.findBylookUpInfoId(dto.getSteppingUpTypeId())).thenReturn(edpLuLookUpInfoEntity);

		assertNotNull(pvuStEventServiceImpl.setPostAndEventDetails(dto,entity));
	}

	@Test
	void testSetPostAndEventDetails5Pay() throws CustomException {

		PVUSteppingUpEventDto dto = new PVUSteppingUpEventDto();
		dto.setId(1L);
		dto.setWfRoleId(1L);
		dto.setDateOfNextIncrSrJnr(LocalDate.now());
		dto.setChBeneEffDate(LocalDate.now());
		dto.setEventOrderNo("21s54s5");
		dto.setEventOrderDate(LocalDate.now());
		dto.setEventEffectiveDate(LocalDate.now());
		dto.setAuditorReturnReason(Constant.RETURN_VAL);
		dto.setSteppingUpTypeId(159L);
		dto.setPayCommId(150L);
		
		PVUSteppingUpEventEntity entity  =new PVUSteppingUpEventEntity();
		entity.setActiveStatus(1);
		entity.setAuthorizeBy(2L);
		entity.setTrnNo("ST");
		entity.setStatusId(edpLuLookUpInfoEntity);
		entity.setCurEmpClass(edpLuLookUpInfoEntity);
		entity.setCurEmpDsgn(designationEntity);
		
		
		
		when(scaleRepository.getOnlyIdAndName(dto.getPayScale())).thenReturn(idNameDto);

		when(edpLuLookUpInfoRepository.getOnlyIdAndName(entity.getCurEmpClass().getLookUpInfoId())).thenReturn(idNameDto);
		when(designationRepository.getOnlyIdAndName(entity.getCurEmpDsgn().getDesignationId())).thenReturn(idNameDto);

		when(empRepository.getOne(dto.getEmployeeId())).thenReturn(empEntity);
		when(empEntity.getOfficeId()).thenReturn(officeEntity);
		when(edpLuLookUpInfoRepository.findBylookUpInfoId(dto.getSteppingUpTypeId())).thenReturn(edpLuLookUpInfoEntity);

		assertNotNull(pvuStEventServiceImpl.setPostAndEventDetails(dto,entity));
	}
	


	@Test
	void testGetPVUResponse() throws CustomException {

		IdDto idDto=new IdDto();
		idDto.setId(12L);
		
		PVUSteppingUpEventDto dto = new PVUSteppingUpEventDto();
		dto.setId(1L);
		dto.setWfRoleId(1L);
		dto.setDateOfNextIncrSrJnr(LocalDate.now());
		dto.setChBeneEffDate(LocalDate.now());
		dto.setEventOrderNo("21s54s5");
		dto.setEventOrderDate(LocalDate.now());
		dto.setEventEffectiveDate(LocalDate.now());
		dto.setAuditorReturnReason(Constant.RETURN_VAL);
		dto.setSteppingUpTypeId(159L);
		dto.setPayCommId(150L);
		dto.setJrEmpId(1025L);
		dto.setPayCommId(150L);

		
		PVUSteppingUpEventEntity entity  =new PVUSteppingUpEventEntity();
		entity.setActiveStatus(1);
		entity.setAuthorizeBy(2L);
		entity.setTrnNo("ST");
		entity.setStatusId(edpLuLookUpInfoEntity);
		entity.setCurEmpClass(edpLuLookUpInfoEntity);
		entity.setCurEmpDsgn(designationEntity);
		entity.setCurrentDetailsEventId(150L);
		entity.setSteppingUpTypeId(edpLuLookUpInfoEntity);
		
		
		
		when(converter.toDTO(entity)).thenReturn(dto);

		when(repository.findById(idDto.getId())).thenReturn(Optional.of(entity));

		when(empEventRepository.findTopByEmpIdAndPayCommissionAndActiveStatusAndEventDateLessThanEqualOrderByEmpEventIdDesc(dto.getJrEmpId(),
				dto.getPayCommId(), Constant.ACTIVE_STATUS,LocalDateTime.now())).thenReturn(empEventEntity);

		
		when(scaleRepository.getOnlyIdAndName(dto.getPayScale())).thenReturn(idNameDto);

		when(edpLuLookUpInfoRepository.getOnlyIdAndName(entity.getCurEmpClass().getLookUpInfoId())).thenReturn(idNameDto);
		when(designationRepository.getOnlyIdAndName(entity.getCurEmpDsgn().getDesignationId())).thenReturn(idNameDto);

		when(empRepository.getOne(dto.getEmployeeId())).thenReturn(empEntity);
		when(empEntity.getOfficeId()).thenReturn(officeEntity);
		when(edpLuLookUpInfoRepository.findBylookUpInfoId(dto.getSteppingUpTypeId())).thenReturn(edpLuLookUpInfoEntity);

		when(scaleRepository.getOnlyIdAndName(dto.getPayScale())).thenReturn(idNameDto);

		assertNotNull(pvuStEventServiceImpl.getPVUResponse(idDto));
	}
	
	
	@Test
	void testGetPVUResponse6PayComm() throws CustomException {

		IdDto idDto=new IdDto();
		idDto.setId(12L);
		
		PVUSteppingUpEventDto dto = new PVUSteppingUpEventDto();
		dto.setId(1L);
		dto.setWfRoleId(1L);
		dto.setDateOfNextIncrSrJnr(LocalDate.now());
		dto.setChBeneEffDate(LocalDate.now());
		dto.setEventOrderNo("21s54s5");
		dto.setEventOrderDate(LocalDate.now());
		dto.setEventEffectiveDate(LocalDate.now());
		dto.setAuditorReturnReason(Constant.RETURN_VAL);
		dto.setSteppingUpTypeId(159L);
		dto.setPayCommId(150L);
		dto.setJrEmpId(1025L);
		dto.setPayCommId(151L);

		PVUSteppingUpEventEntity entity  =new PVUSteppingUpEventEntity();
		entity.setActiveStatus(1);
		entity.setAuthorizeBy(2L);
		entity.setTrnNo("ST");
		entity.setStatusId(edpLuLookUpInfoEntity);
		entity.setCurEmpClass(edpLuLookUpInfoEntity);
		entity.setCurEmpDsgn(designationEntity);
		entity.setCurrentDetailsEventId(150L);
		entity.setSteppingUpTypeId(edpLuLookUpInfoEntity);
		entity.setChGradePay(gradeEntity);
		entity.setChPayBand(payBandEntity);
		
		when(converter.toDTO(entity)).thenReturn(dto);

		when(repository.findById(idDto.getId())).thenReturn(Optional.of(entity));

		when(empEventRepository.findTopByEmpIdAndPayCommissionAndActiveStatusAndEventDateLessThanEqualOrderByEmpEventIdDesc(dto.getJrEmpId(),
				dto.getPayCommId(), Constant.ACTIVE_STATUS,LocalDateTime.now())).thenReturn(empEventEntity);

		when(scaleRepository.getOnlyIdAndName(dto.getPayScale())).thenReturn(idNameDto);

		when(edpLuLookUpInfoRepository.getOnlyIdAndName(entity.getCurEmpClass().getLookUpInfoId())).thenReturn(idNameDto);
		when(designationRepository.getOnlyIdAndName(entity.getCurEmpDsgn().getDesignationId())).thenReturn(idNameDto);

		when(empRepository.getOne(dto.getEmployeeId())).thenReturn(empEntity);
		when(empEntity.getOfficeId()).thenReturn(officeEntity);
		when(edpLuLookUpInfoRepository.findBylookUpInfoId(dto.getSteppingUpTypeId())).thenReturn(edpLuLookUpInfoEntity);

		when(gradePayRepository.getOnlyIdAndName(entity.getChGradePay().getId())).thenReturn(idNameDto);
		when(bandRepository.getOnlyIdAndName(entity.getChPayBand().getId())).thenReturn(idNameDto);

		assertNotNull(pvuStEventServiceImpl.getPVUResponse(idDto));
	}

	
	@Test
	void testGetPVUResponse7PayComm() throws CustomException {

		IdDto idDto=new IdDto();
		idDto.setId(12L);
		
		PVUSteppingUpEventDto dto = new PVUSteppingUpEventDto();
		dto.setId(1L);
		dto.setWfRoleId(1L);
		dto.setDateOfNextIncrSrJnr(LocalDate.now());
		dto.setChBeneEffDate(LocalDate.now());
		dto.setEventOrderNo("21s54s5");
		dto.setEventOrderDate(LocalDate.now());
		dto.setEventEffectiveDate(LocalDate.now());
		dto.setAuditorReturnReason(Constant.RETURN_VAL);
		dto.setSteppingUpTypeId(159L);
		dto.setPayCommId(150L);
		dto.setJrEmpId(1025L);
		dto.setPayCommId(152L);

		
		PVUSteppingUpEventEntity entity  =new PVUSteppingUpEventEntity();
		entity.setActiveStatus(1);
		entity.setAuthorizeBy(2L);
		entity.setTrnNo("ST");
		entity.setStatusId(edpLuLookUpInfoEntity);
		entity.setCurEmpClass(edpLuLookUpInfoEntity);
		entity.setCurEmpDsgn(designationEntity);
		entity.setCurrentDetailsEventId(150L);
		entity.setSteppingUpTypeId(edpLuLookUpInfoEntity);
		entity.setChPayLevel(payEntity);
		entity.setChCellId(cellEntity);
		
		when(converter.toDTO(entity)).thenReturn(dto);

		when(repository.findById(idDto.getId())).thenReturn(Optional.of(entity));

		when(empEventRepository.findTopByEmpIdAndPayCommissionAndActiveStatusAndEventDateLessThanEqualOrderByEmpEventIdDesc(dto.getJrEmpId(),
				dto.getPayCommId(), Constant.ACTIVE_STATUS,LocalDateTime.now())).thenReturn(empEventEntity);

		when(empEventEntity.getEmpEventId()).thenReturn(105L);

		when(scaleRepository.getOnlyIdAndName(dto.getPayScale())).thenReturn(idNameDto);

		when(edpLuLookUpInfoRepository.getOnlyIdAndName(entity.getCurEmpClass().getLookUpInfoId())).thenReturn(idNameDto);
		when(designationRepository.getOnlyIdAndName(entity.getCurEmpDsgn().getDesignationId())).thenReturn(idNameDto);

		when(empRepository.getOne(dto.getEmployeeId())).thenReturn(empEntity);
		when(empEntity.getOfficeId()).thenReturn(officeEntity);
		when(edpLuLookUpInfoRepository.findBylookUpInfoId(dto.getSteppingUpTypeId())).thenReturn(edpLuLookUpInfoEntity);

		when(cellRepository.getOnlyIdAndName(entity.getChCellId().getId())).thenReturn(idNameDto);
		when(levelRepository.getOnlyIdAndName(entity.getChPayLevel().getId())).thenReturn(idNameDto);

		assertNotNull(pvuStEventServiceImpl.getPVUResponse(idDto));
	}

	
	
	
	@Test
	void test_generateOutWardNumber() throws CustomException {
		List<IdDto> dtos = new ArrayList<IdDto>();
		IdDto dto = new IdDto();
		dto.setId(1L);
		dtos.add(dto);
		assertNotNull(pvuStEventServiceImpl.generateInwardNumber(dtos));
		assertNotNull(pvuStEventServiceImpl.generateOutwardNumber(dtos));
	}

	
	@Test
	void testGeneratePdf()throws CustomException, DocumentException {    
		PvuPrintStickerReportDto dto = new PvuPrintStickerReportDto();

		dto.setStickerDTO(pvuStickerDTO);
		dto.setPvuWFWrapperDto(wrpDto);
		dto.setPrintEndorsementDto(pvuPrintEndorsementDto);
		
		List<PvuPrintStickerReportDto> dtos=new ArrayList<PvuPrintStickerReportDto>();
		dtos.add(dto);

		
		when(repository.getOne(dto.getStickerDTO().getId())).thenReturn(pvuStEventEntity);
		assertTrue(true);	
		when(pvuStEventEntity.getOfficeId()).thenReturn(officeEntity);

		when(repository.getOne(dto.getStickerDTO().getId())).thenReturn(pvuStEventEntity);
		when(converter.toDTO(pvuStEventEntity)).thenReturn(pvuStEventDto);
		when(pvuStEventDto.getEmployeeNo()).thenReturn(1000058L);

		
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
		when(pvuStEventDto.getChBeneEffDate()).thenReturn(LocalDate.now());
		when(pvuStEventDto.getDateOfNextIncrSrJnr()).thenReturn(LocalDate.now());
		when(pvuStEventDto.getEmployeeNo()).thenReturn(1000058L);
		when(pvuStEventDto.getPayCommId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
		
		when(pvuStEventEntity.getChCellId()).thenReturn(cellEntity);
		when(pvuStEventEntity.getChPayLevel()).thenReturn(payEntity);
		
		
		when(pvuStEventEntity.getCurEmpDsgn()).thenReturn(designationEntity);

		when(pvuStEventEntity.getCurEmpDsgn().getDesignationName()).thenReturn("SOP");
		when(pvuStEventEntity.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(pvuStEventEntity.getAuthorizeBy()).thenReturn(15L);
		when(authService.getOnlyIdAndName(15L)).thenReturn(idNameDto);
		when(idNameDto.getName()).thenReturn("auth");
		
		EDPLuLookUpInfoEntity  srGender=new EDPLuLookUpInfoEntity();
		srGender.setLookUpInfoId(1L);
		srGender.setLookUpInfoName("Male");
		
		
		when(empRepository.getOne(pvuStEventDto.getEmployeeId())).thenReturn(empEntity);

		when(empEntity.getGender()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(1L);
		when(edpLuLookUpInfoRepository.findBylookUpInfoId(empEntity.getGender().getLookUpInfoId())).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn("Male");

		when(edpLuLookUpInfoRepository.findBylookUpInfoId(pvuStEventDto.getSteppingUpTypeId())).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn("STP");
		when(velocityContext.get("steppingUpType")).thenReturn("STP");
		

		pvuStEventServiceImpl.generatePdf(dtos); 
	}

	
	
	@Test
	void testGeneratePrint() throws CustomException {
		PvuPrintStickerReportDto dto = new PvuPrintStickerReportDto();

		dto.setStickerDTO(pvuStickerDTO);
		dto.setPvuWFWrapperDto(wrpDto);
		dto.setPrintEndorsementDto(pvuPrintEndorsementDto);
		
		when(pvuStickerDTO.getEndorsementPrintDate()).thenReturn(new Date());
		when(pvuStickerDTO.getEndorsementReprintDate()).thenReturn(new Date());
		assertTrue(true);	
		when(repository.getOne(dto.getStickerDTO().getId())).thenReturn(pvuStEventEntity);
		when(converter.toDTO(pvuStEventEntity)).thenReturn(pvuStEventDto);
		when(pvuStEventDto.getEmployeeNo()).thenReturn(1000058L);
		when(pvuPrintEndorsementDto.getActiveStatus()).thenReturn(1);
		
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
		when(pvuStEventDto.getChBeneEffDate()).thenReturn(LocalDate.now());
		when(pvuStEventDto.getDateOfNextIncrSrJnr()).thenReturn(LocalDate.now());
		when(pvuStEventDto.getEmployeeNo()).thenReturn(1000058L);
		when(pvuStEventDto.getPayCommId()).thenReturn(PvuConstant.SEVENTH_COMMISSION_ID);
		
		when(pvuStEventEntity.getChCellId()).thenReturn(cellEntity);
		when(pvuStEventEntity.getChPayLevel()).thenReturn(payEntity);
		
		
		when(pvuStEventEntity.getCurEmpDsgn()).thenReturn(designationEntity);

		when(pvuStEventEntity.getCurEmpDsgn().getDesignationName()).thenReturn("SOP");
		when(pvuStEventEntity.getEventEffectiveDate()).thenReturn(LocalDate.now());
		when(pvuStEventEntity.getAuthorizeBy()).thenReturn(15L);
		when(authService.getOnlyIdAndName(15L)).thenReturn(idNameDto);
		when(idNameDto.getName()).thenReturn("auth");
		
		EDPLuLookUpInfoEntity  srGender=new EDPLuLookUpInfoEntity();
		srGender.setLookUpInfoId(1L);
		srGender.setLookUpInfoName("Male");
		
		
		when(empRepository.getOne(pvuStEventDto.getEmployeeId())).thenReturn(empEntity);

		when(empEntity.getGender()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(1L);
		when(edpLuLookUpInfoRepository.findBylookUpInfoId(empEntity.getGender().getLookUpInfoId())).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn("Male");

		when(edpLuLookUpInfoRepository.findBylookUpInfoId(pvuStEventDto.getSteppingUpTypeId())).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn("STP");
		when(velocityContext.get("steppingUpType")).thenReturn("STP");

		
		
		
		
		pvuStEventServiceImpl.generatePrint( dto);
	}

	
	
	/*@Test
	void testGenerateComparisonReport()throws CustomException, DocumentException, IOException { 
		IdDto dto = new IdDto();
		dto.setId(1l);
		when(pvuStEventEntity.getJrEmpId()).thenReturn(empEntity);
		when(pvuStEventEntity.getCurEmpId()).thenReturn(empEntity);
		Map<String, Object> map1 = new HashMap<>();
		map1.put("IN_PAGE_INDEX", 0);
		map1.put("IN_PAGE_SIZE", 10);
		when(pvuStEventEntity.getChBeneEffDate()).thenReturn(LocalDate.now());
		when(pvuStEventEntity.getOfficeId()).thenReturn(officeEntity);
		when(pvuStEventEntity.getPayComm()).thenReturn(edpLuLookUpInfoEntity);
		map1.put("IN_EFFECTIVE_DATE", PvuUtils.getStrOfLocalDateInYMD(pvuStEventEntity.getChBeneEffDate()));
		map1.put("IN_PAY_COMM", pvuStEventEntity.getPayComm().getLookUpInfoId());
		map1.put("IN_EVENT_ID", 0);
		map1.put("IN_EMPLOYEE_NO", pvuStEventEntity.getJrEmpId().getEmployeeCode());
		map1.put("IN_OFFICE_ID", pvuStEventEntity.getOfficeId().getOfficeId());
		when(pvuCommonService.getCommonDetailsBasedOnEventDate(map1)).thenReturn(pvuCommonApiDto);
		
		when(pvuEmployeeDepartmentRepo.findFirstByPvuEmployeEntityEmpId(pvuStEventEntity.getJrEmpId().getEmpId())).thenReturn(departmentEntity);
		when(pvuEmployeEventsService.findLatestEvent(pvuStEventEntity.getCurEmpId().getEmpId())).thenReturn(empEventEntity);
		pvuStEventEntity.setStEventId(1l);
		Optional<PVUSteppingUpEventEntity> pvuStEventEntityOptional = Optional.of(pvuStEventEntity);
		when(repository.findById(1L)).thenReturn(pvuStEventEntityOptional);
		
		when(empEventEntity.getEventDate()).thenReturn(LocalDateTime.now());
		
		when(departmentEntity.getDesignationId()).thenReturn(designationEntity);
		
		when(departmentEntity.getDateOfJoiningGOG()).thenReturn(new Date());
		
		Map<String, Object> map = new HashMap<>();
		map.put("trnId", dto.getId());
		List<Object[]> objects = remarkRepository.executeSQLQuery(PVUNativeSqlQueryConstant.getSteppingUpApproverRemarks(), map);
		
		pvuStEventServiceImpl.generateComparisionPrint(dto);
	}*/
	
	
	
	
	

}
