package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.converter.EDPMsDesignationConverter;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.dto.PVURopInwardView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVURopInwardEntity;
import gov.ifms.pvu.repository.PVURopInwardRepository;
import gov.ifms.pvu.service.PVURopInwardServiceImpl;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVURopInwardServiceImplTest.
 */
class PVURopInwardServiceImplTest {

	/** The service. */
	@InjectMocks
	private PVURopInwardServiceImpl service;

	/** The repository. */
	@Mock
	private PVURopInwardRepository repository;

	/** The entity. */
	@Mock
	private PVURopInwardEntity entity;

	/** The emp status lookup info. */
	@Mock
	private EDPLuLookUpInfoEntity empStatusLookupInfo;

	/** The designation repository. */
	@Mock
	private EDPMsDesignationRepository designationRepository;

	/** The designation list. */
	@Mock
	private List<EDPMsDesignationEntity> designationList;

	/** The district repository. */
	@Mock
	private EDPMsDistrictRepository districtRepository;

	/** The district list. */
	@Mock
	private List<EDPMsDistrictEntity> districtList;

	/** The pvu WF wrapper dto. */
	@Mock
	private List<PvuWFWrapperDto> pvuWFWrapperDto;

	/** The pvu facade. */
	@Mock
	private PVYFacade pvuFacade;

	@Mock
	private EDPMsDistrictConverter districtConverter;
	
	@Mock
	private EDPMsDesignationRepository eDPMsDesignationRepository;
	
	@Mock
	private EDPMsDesignationConverter eDPMsDesignationConverter;
	

	/**
	 * Setup.
	 */
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	/**
	 * Test get pvu search fields.
	 */
	@Test
	void testGetPvuSearchFields() {
		assertNotNull(service.getPvuSearchFields());
	}

	/**
	 * Test save or update rop inward.
	 */
	@Test
	void testSaveOrUpdateRopInward() {
		assertNotNull(when(repository.save(entity)).thenReturn(entity));
		service.saveOrUpdateRopInward(entity);
	}

	/**
	 * Test get rop inwards.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetRopInwards() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("isSearch", "0"));
		jsonArr.add(new SearchParam("forwardToDate", ""));
		jsonArr.add(new SearchParam("forwardFromDate", ""));
		jsonArr.add(new SearchParam("eventName", ""));
		jsonArr.add(new SearchParam("empNo", ""));
		jsonArr.add(new SearchParam("empName", ""));
		jsonArr.add(new SearchParam("designationId", ""));
		jsonArr.add(new SearchParam("caseNo", ""));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("retirementDate", ""));
		jsonArr.add(new SearchParam("panNo", ""));
		jsonArr.add(new SearchParam("districtId", "0"));
		jsonArr.add(new SearchParam("cardexNo", " "));
		jsonArr.add(new SearchParam("ddoCode", "0"));
		jsonArr.add(new SearchParam("employeeTypeId", "0"));
		jsonArr.add(new SearchParam("inwardFromDate", ""));
		jsonArr.add(new SearchParam("inwardToDate", ""));
		jsonArr.add(new SearchParam("transNo", ""));
		jsonArr.add(new SearchParam("trnStatus", "Forwarded to PVU"));
		jsonArr.add(new SearchParam("wfStatus", ""));
		jsonArr.add(new SearchParam("postId", "289"));
		jsonArr.add(new SearchParam("menuId", "62"));
		jsonArr.add(new SearchParam("officeId", "38"));
		jsonArr.add(new SearchParam("lkPoOffUserId", "544"));
		jsonArr.add(new SearchParam("wfRoleIds", "12"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);

		service.getRopInwards(pageDetail);
		PagebleDTO<PVURopInwardView> data = service.getRopInwards(pageDetail);
		assertNotNull(data);
	}

	/**
	 * Gets the rop inward.
	 *
	 * @return the rop inward
	 */
	@Test
	void getRopInward() {
		when(repository.getOne(1l)).thenReturn(entity);
		assertEquals(entity, service.getRopInward(1l));
		verify(repository, times(1)).getOne(1L);
	}

	/**
	 * Test get inward lookup search.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetInwardLookupSearch() throws CustomException {
		assertNotNull(service.getInwardLookupSearch());
	}

	/**
	 * Teststore proc common emp.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testStoreProcCommonEmp() throws CustomException {
		assertNotNull(service.storeProcPvu("PVU_EMP_RP_INWARD_LIST_WF", new HashMap<String, Object>(),
				PVURopInwardView.class));
	}

	/**
	 * Gets the inward lu look up info.
	 *
	 * @return the inward lu look up info
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetInwardLuLookUpInfo() throws CustomException {
		List<EDPMsDistrictEntity> lstEDPMsDistrictEntity = new ArrayList<EDPMsDistrictEntity>();
		List<EDPMsDesignationEntity> lstEDPMsDesignationEntity = new ArrayList<EDPMsDesignationEntity>();
		List<EDPSDTDto> lstEDPSDTDto = new ArrayList<EDPSDTDto>();
		
		List<Object[]> objectPvuSp = new ArrayList<Object[]>();
		Object[] lookUpObject = new Object[3];
		lookUpObject[0] = "ropType";
		lookUpObject[1] = 1;
		lookUpObject[2] =  "ropType";
		objectPvuSp.add(lookUpObject);
		
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMP_ROP_INWARD_LK_SP));
		when(repository.callStoredProcedure(procName, Collections.emptyMap())).thenReturn(objectPvuSp);
		when(districtRepository.findByActiveStatusAndStateId(Constant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ,
				EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC))).thenReturn(lstEDPMsDistrictEntity);
		when(districtConverter.toEDPSDTDto(lstEDPMsDistrictEntity)).thenReturn(lstEDPSDTDto);
		when(eDPMsDesignationRepository.findByActiveStatusEquals(Constant.ACTIVE_STATUS)).thenReturn(lstEDPMsDesignationEntity);
		when(eDPMsDesignationConverter.toEDPSDTDto(lstEDPMsDesignationEntity)).thenReturn(lstEDPSDTDto);
		assertNotNull(service.getInwardLuLookUpInfo());
		service.getInwardLuLookUpInfo();
	}

	/**
	 * Test submit rop inward.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSubmitRopInward() throws CustomException {
		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		List<PvuWFWrapperDto> listWrapperDto = new ArrayList<PvuWFWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus("printed");
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);
		assertNotNull(when(pvuFacade.callWorkFlowApis(listWrapperDto)).thenReturn(true));
		service.submitRopInward(listWrapperDto);
	}
	
	/**
	 * Test submit rop distributor.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSubmitRopDistributor() throws CustomException {
		PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
		List<PvuWFWrapperDto> listWrapperDto = new ArrayList<PvuWFWrapperDto>();
		wrapperDto.setTrnId(1L);
		wrapperDto.setCurrentWorkflowId(1L);
		wrapperDto.setWfStatus("");
		wrapperDto.setTrnStatus("printed");
		wrapperDto.setAssignByWfRoleId(20l);
		listWrapperDto.add(wrapperDto);
		assertNotNull(when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true));
		service.submitRopDistributor(pvuWFWrapperDto);
	} 

	@Test
	void testGenerateInwardNumber() throws SQLException, CustomException {
		List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
		List<IdDto> dtos = new ArrayList<IdDto>();
		dtos.add(new IdDto(1l));
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		map.put(1, dtos);
		parameterMapList.add(map);
        assertNotNull(when(repository.callStoreProcBatch("{CALL " + Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INWARD_NO_GENERATION)) + "(?)}", parameterMapList)).thenReturn(true));
        service.generateInwardNumber(dtos);
	}
}
