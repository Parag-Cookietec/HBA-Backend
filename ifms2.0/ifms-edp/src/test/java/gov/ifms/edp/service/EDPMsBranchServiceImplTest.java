package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.base.Status;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPLuLookUpInfoConverter;
import gov.ifms.edp.converter.EDPMsBranchConverter;
import gov.ifms.edp.converter.EDPTedpBrCrDtlItrConverter;
import gov.ifms.edp.converter.EDPTedpBrHdrConverter;
import gov.ifms.edp.dto.EDPTedpBrDtlDto;
import gov.ifms.edp.dto.EDPTedpBrHdrDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsBranchEntity;
import gov.ifms.edp.entity.EDPTedpBrCrDtlEntity;
import gov.ifms.edp.entity.EDPTedpBrCrDtlItrEntity;
import gov.ifms.edp.entity.EDPTedpBrDtlEntity;
import gov.ifms.edp.entity.EDPTedpBrHdrEntity;
import gov.ifms.edp.entity.EDPTrnPouBrMapEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsBranchRepository;
import gov.ifms.edp.repository.EDPTedpBrCrDtlItrRepository;
import gov.ifms.edp.repository.EDPTedpBrCrDtlRepository;
import gov.ifms.edp.repository.EDPTedpBrDtlRepository;
import gov.ifms.edp.repository.EDPTedpBrHdrRepository;
import gov.ifms.edp.repository.EDPTrnPouBrMapItrRepository;
import gov.ifms.edp.repository.EDPTrnPouBrMapRepository;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPMsBranchServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsBranchServiceImplTest {
	
	/** The service. */
	@InjectMocks
	private EDPMsBranchServiceImpl service;
	
	/** The repository. */
	@Mock
	private EDPMsBranchRepository repository;
	
	/** The converter. */
	@Mock
	private EDPMsBranchConverter converter;
	
	/** The entity. */
	@Mock
	private EDPMsBranchEntity entity;
	
	/** The list. */
	@Mock
	private List<EDPMsBranchEntity> list;
	
	/** The lookup info service. */
	@Mock
	private EDPLuLookUpInfoService lookupInfoService;
	
	/** The lookupinfoconverter. */
	@Mock
	private EDPLuLookUpInfoConverter lookupinfoconverter;
	
	/** The hdr dto. */
	@Mock
	private EDPTedpBrHdrDto hdrDto;
	
	/** The edp tedp br cr dtl repository. */
	@Mock 
	private EDPTedpBrCrDtlRepository edpTedpBrCrDtlRepository;
	
	/** The edp tedp br hdr converter. */
	@Mock
	private EDPTedpBrHdrConverter edpTedpBrHdrConverter;
	
	/** The edp tedp br hdr repository. */
	@Mock
	private EDPTedpBrHdrRepository edpTedpBrHdrRepository;
	
	/** The edp tedp br cr dtl itr converter. */
	@Mock
	private EDPTedpBrCrDtlItrConverter edpTedpBrCrDtlItrConverter;
	
	/** The edp tedp br cr dtl itr repository. */
	@Mock
	private EDPTedpBrCrDtlItrRepository edpTedpBrCrDtlItrRepository;

	@Mock
	private EDPLuLookUpInfoRepository edpLuLookupInfoRepository;

	@Mock
	private EDPLuLookUpInfoEntity lookupInfoEntity;

	@Mock
	private EDPTedpBrDtlRepository edpTedpBrDtlRepository;

	@Mock
	private EDPTedpBrHdrEntity hdrEntity;
	
	@Mock
	private EDPTedpBrDtlEntity dtlEntity;

	@Mock
	private EDPTrnPouBrMapRepository edpTrnPouBrMapRepository;

	@Mock
	private EDPTrnPouBrMapEntity msBrMapEntity;

	@Mock
	private EDPTrnPouBrMapItrRepository edpTrnPouBrMapItrRepository;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Gets the branch listby branch type.
	 *
	 * @return the branch listby branch type
	 * @throws CustomException the custom exception
	 */
	@Test
	void getBranchListbyBranchType() throws CustomException {
		assertNotNull(service.getBranchListbyBranchType(JunitConstants.LONG_TYPE));
	}

	/**
	 * Find all active branches.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void findAllActiveBranches() throws CustomException {
		assertNotNull(service.findAllActiveBranches());
	}
	
	/**
	 * Gets the branch data.
	 *
	 * @return the branch data
	 * @throws CustomException the custom exception
	 */
	@Test
	void getBranchData() throws CustomException {
		assertNotNull(service.getBranchData());
	}

	/**
	 * Save branch.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void saveBranch() throws CustomException {
		EDPTedpBrHdrDto hdrDto = new EDPTedpBrHdrDto();
		hdrDto.setBranchType(EDPConstant.LOOKUP_INFO_BUDGET_BRANCH_ID);
		hdrDto.setMenuCode("CODE");
		hdrDto.setFormAction(Status.SUBMITTED);
		
		EDPTedpBrHdrEntity hdrEntity = new EDPTedpBrHdrEntity();
		hdrEntity.setTedpBrHdrId(1l);
		hdrEntity.setStatusId(new EDPLuLookUpInfoEntity(1l));
		
		EDPTedpBrCrDtlEntity dtlEntity = new EDPTedpBrCrDtlEntity();
		dtlEntity.setTedpBrCrDtlId(1l);
		
		EDPTedpBrCrDtlItrEntity itrEntity = new EDPTedpBrCrDtlItrEntity();
		itrEntity.setTedpBrCrDtlItrId(1l);
		
		List<Object[]> branchList = new ArrayList<Object[]>();
		Object[] obj = new Object[2];
		obj[0] = "Test";
		branchList.add(obj);
		
		when(repository.getBranchAndBranchTypeByOfficeId(Mockito.anyLong(),Mockito.anyInt())).thenReturn(branchList);
		when(repository.generateTrnNo(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("TEST");
		when(edpTedpBrHdrConverter.hdrDtoToHdrEntity(hdrDto)).thenReturn(hdrEntity);
		when(edpTedpBrHdrRepository.save(hdrEntity)).thenReturn(hdrEntity);
		when(edpTedpBrHdrConverter.hdrDtoToBrCrDtlEntity(hdrDto)).thenReturn(dtlEntity);
		when(edpTedpBrCrDtlRepository.save(dtlEntity)).thenReturn(dtlEntity);
		when(edpTedpBrCrDtlItrConverter.dtlEntityToItrEntity(hdrDto,dtlEntity)).thenReturn(itrEntity);
		assertNotNull(service.saveBranch(hdrDto));
	}
	
	/**
	 * Save branch 1.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void saveBranch1() throws CustomException {
		EDPTedpBrHdrDto hdrDto = new EDPTedpBrHdrDto();
		hdrDto.setTedpBrHdrId(1l);
		hdrDto.setBranchType(EDPConstant.LOOKUP_INFO_BUDGET_BRANCH_ID);
		hdrDto.setMenuCode("CODE");
		hdrDto.setOfficeId(1l);
		hdrDto.setBranchName("TEST");
		hdrDto.setFormAction(Status.SUBMITTED);
		
		EDPTedpBrHdrEntity hdrEntity = new EDPTedpBrHdrEntity();
		hdrEntity.setTedpBrHdrId(1l);
		hdrEntity.setStatusId(new EDPLuLookUpInfoEntity(1l));
		
		EDPTedpBrCrDtlEntity dtlEntity = new EDPTedpBrCrDtlEntity();
		dtlEntity.setTedpBrCrDtlId(1l);
		dtlEntity.setBranchName("EST");
		
		EDPTedpBrCrDtlItrEntity itrEntity = new EDPTedpBrCrDtlItrEntity();
		itrEntity.setTedpBrCrDtlItrId(1l);
		
		List<Object[]> branchList = new ArrayList<Object[]>();
		Object[] obj = new Object[4];
		obj[0] = "Test";
		obj[3] = 1;
		branchList.add(obj);
		
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] obj1 = new Object[5];
		obj1[4] = 1;
		dataList.add(obj1);
		
		when(repository.getBranchAndBranchTypeByOfficeId(Mockito.anyLong(),Mockito.anyInt())).thenReturn(branchList);
		when(repository.generateTrnNo(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("TEST");
		when(edpTedpBrHdrConverter.hdrDtoToHdrEntity(hdrDto)).thenReturn(hdrEntity);
		when(edpTedpBrHdrRepository.save(hdrEntity)).thenReturn(hdrEntity);
		when(edpTedpBrHdrConverter.hdrDtoToBrCrDtlEntity(hdrDto)).thenReturn(dtlEntity);
		when(edpTedpBrCrDtlRepository.save(dtlEntity)).thenReturn(dtlEntity);
		when(edpTedpBrCrDtlItrConverter.dtlEntityToItrEntity(hdrDto,dtlEntity)).thenReturn(itrEntity);
		when(edpTedpBrCrDtlRepository.findByTedpBrHdrIdTedpBrHdrIdAndActiveStatus(Mockito.anyLong(),Mockito.anyInt())).
				thenReturn(dtlEntity);
		
		when(edpTedpBrCrDtlRepository.getBranchDataFromOfficeAndBranchTypeAndBranchName(Mockito.any(),
				Mockito.anyInt(),Mockito.anyLong(),Mockito.anyString(),Mockito.anyLong())).thenReturn(dataList);
		assertNotNull(service.saveBranch(hdrDto));
	}
	
	/**
	 * Save branch 2.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void saveBranch2() throws CustomException {
		EDPTedpBrHdrDto hdrDto = new EDPTedpBrHdrDto();
		hdrDto.setTedpBrHdrId(1l);
		hdrDto.setBranchType(EDPConstant.LOOKUP_INFO_BUDGET_BRANCH_ID);
		hdrDto.setMenuCode("CODE");
		hdrDto.setOfficeId(1l);
		hdrDto.setBranchName("TEST");
		hdrDto.setFormAction(Status.SUBMITTED);
		hdrDto.setBranchId(1l);
		
		EDPTedpBrHdrEntity hdrEntity = new EDPTedpBrHdrEntity();
		hdrEntity.setTedpBrHdrId(1l);
		hdrEntity.setStatusId(new EDPLuLookUpInfoEntity(1l));
		
		EDPTedpBrCrDtlEntity dtlEntity = new EDPTedpBrCrDtlEntity();
		dtlEntity.setTedpBrCrDtlId(1l);
		dtlEntity.setBranchName("EST");
		
		EDPTedpBrCrDtlItrEntity itrEntity = new EDPTedpBrCrDtlItrEntity();
		itrEntity.setTedpBrCrDtlItrId(1l);
		
		List<Object[]> branchList = new ArrayList<Object[]>();
		Object[] obj = new Object[4];
		obj[0] = "Test";
		obj[3] = 1;
		branchList.add(obj);
		
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] obj1 = new Object[5];
		obj1[4] = 1;
		dataList.add(obj1);
		
		EDPMsBranchEntity branch = new EDPMsBranchEntity();
		Optional<EDPMsBranchEntity> branchEntity = Optional.of(branch);
		
		when(repository.getBranchAndBranchTypeByOfficeId(Mockito.anyLong(),Mockito.anyInt())).thenReturn(branchList);
		when(repository.generateTrnNo(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("TEST");
		when(edpTedpBrHdrConverter.hdrDtoToHdrEntity(hdrDto)).thenReturn(hdrEntity);
		when(edpTedpBrHdrRepository.save(hdrEntity)).thenReturn(hdrEntity);
		when(edpTedpBrHdrConverter.hdrDtoToBrCrDtlEntity(hdrDto)).thenReturn(dtlEntity);
		when(edpTedpBrCrDtlRepository.save(dtlEntity)).thenReturn(dtlEntity);
		when(repository.findById(1l)).thenReturn(branchEntity);
		when(edpTedpBrCrDtlItrConverter.dtlEntityToItrEntity(hdrDto,dtlEntity)).thenReturn(itrEntity);
		when(edpTedpBrCrDtlRepository.findByTedpBrHdrIdTedpBrHdrIdAndActiveStatus(Mockito.anyLong(),Mockito.anyInt())).
		thenReturn(dtlEntity);
		
		when(edpTedpBrCrDtlRepository.getBranchDataFromOfficeAndBranchTypeAndBranchName(Mockito.any(),
				Mockito.anyInt(),Mockito.anyLong(),Mockito.anyString(),Mockito.anyLong())).thenReturn(dataList);
		assertNotNull(service.saveBranch(hdrDto));
	}
	
	/**
	 * Save branch 3.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void saveBranch3() throws CustomException {
		EDPTedpBrHdrDto hdrDto = new EDPTedpBrHdrDto();
		hdrDto.setTedpBrHdrId(1l);
		hdrDto.setBranchType(EDPConstant.LOOKUP_INFO_BUDGET_BRANCH_ID);
		hdrDto.setMenuCode("CODE");
		hdrDto.setOfficeId(1l);
		hdrDto.setBranchName("TEST");
		hdrDto.setFormAction(Status.DRAFT);
		hdrDto.setBranchId(1l);
		
		EDPTedpBrHdrEntity hdrEntity = new EDPTedpBrHdrEntity();
		hdrEntity.setTedpBrHdrId(1l);
		hdrEntity.setStatusId(new EDPLuLookUpInfoEntity(1l));
		
		EDPTedpBrCrDtlEntity dtlEntity = new EDPTedpBrCrDtlEntity();
		dtlEntity.setTedpBrCrDtlId(1l);
		dtlEntity.setBranchName("EST");
		
		EDPTedpBrCrDtlItrEntity itrEntity = new EDPTedpBrCrDtlItrEntity();
		itrEntity.setTedpBrCrDtlItrId(1l);
		
		List<Object[]> branchList = new ArrayList<Object[]>();
		Object[] obj = new Object[4];
		obj[0] = "Test";
		obj[3] = 1;
		branchList.add(obj);
		
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] obj1 = new Object[5];
		obj1[4] = 1;
		dataList.add(obj1);
		
		EDPMsBranchEntity branch = new EDPMsBranchEntity();
		Optional<EDPMsBranchEntity> branchEntity = Optional.of(branch);
		
		when(repository.getBranchAndBranchTypeByOfficeId(Mockito.anyLong(),Mockito.anyInt())).thenReturn(branchList);
		when(repository.generateTrnNo(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("TEST");
		when(edpTedpBrHdrConverter.hdrDtoToHdrEntity(hdrDto)).thenReturn(hdrEntity);
		when(edpTedpBrHdrRepository.save(hdrEntity)).thenReturn(hdrEntity);
		when(edpTedpBrHdrConverter.hdrDtoToBrCrDtlEntity(hdrDto)).thenReturn(dtlEntity);
		when(edpTedpBrCrDtlRepository.save(dtlEntity)).thenReturn(dtlEntity);
		when(repository.findById(1l)).thenReturn(branchEntity);
		when(edpTedpBrCrDtlItrConverter.dtlEntityToItrEntity(hdrDto,dtlEntity)).thenReturn(itrEntity);
		when(edpTedpBrCrDtlRepository.findByTedpBrHdrIdTedpBrHdrIdAndActiveStatus(Mockito.anyLong(),Mockito.anyInt())).
		thenReturn(dtlEntity);
		
		when(edpTedpBrCrDtlRepository.getBranchDataFromOfficeAndBranchTypeAndBranchName(Mockito.any(),
				Mockito.anyInt(),Mockito.anyLong(),Mockito.anyString(),Mockito.anyLong())).thenReturn(dataList);
		assertNotNull(service.saveBranch(hdrDto));
	}
	
	/**
	 * Listing cre.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	public void listingCre() throws CustomException {
		PageDetails pageDetail = new PageDetails();
		assertNotNull(service.searchList(pageDetail));
	}
	
	/**
	 * Delete branch cr request.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	public void deleteBranchCrRequest() throws CustomException{
		service.deleteBranchCrRequest(1l);
	}
	
	@Test
	void testGetBranchRequestType() {
		List<EDPLuLookUpInfoEntity> lookupEntities = new ArrayList<>();
		lookupEntities.add(lookupInfoEntity);
		
		List<Integer> lookupInfoValue = new ArrayList<>();
		lookupInfoValue.add(Constant.INT_ONE_VALUE);
		lookupInfoValue.add(Constant.INT_TWO_VALUE);	

		when(edpLuLookupInfoRepository.findByEdpLuLookUpEntityLookUpIdAndLookUpInfoValueInAndActiveStatus(EDPConstant.EDP_BRANCH_REQUEST_TYPE,lookupInfoValue, Constant.ACTIVE_STATUS)).thenReturn(lookupEntities);
		when(lookupInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(lookupInfoEntity.getLookUpInfoName()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(service.getBranchRequestType());
	}
	
	@Test
	void testGetEmpPostInOffice() throws CustomException {
		List<Object[]> objArr = new ArrayList<>();
		Object[] obj = new Object[4];
		obj[0] = JunitConstants.LONG_TYPE;
		obj[1] = JunitConstants.STRING_TYPE;
		obj[2] = JunitConstants.STRING_TYPE;
		obj[3] = JunitConstants.STRING_TYPE;
		objArr.add(obj);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objArr);
		assertNotNull(service.getEmpPostInOffice(JunitConstants.LONG_TYPE));
	}
	
	@Test
	void testGetBranchesForOffice() {
		List<EDPMsBranchEntity> officeBranches = new ArrayList();
		officeBranches.add(entity);
		when(repository.findByEdpMsOfficeOfficeIdAndActiveStatus(Mockito.anyLong(), Mockito.anyInt())).thenReturn(officeBranches);
		when(entity.getBranchId()).thenReturn(JunitConstants.LONG_TYPE);
		when(entity.getBranchName()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(service.getBranchesForOffice());		
	}
	
	@Test
	void testGetEmpMappedBranches() throws CustomException {
		List<Object[]> objArr = new ArrayList<>();
		Object[] obj = new Object[5];
		obj[0] = JunitConstants.LONG_TYPE;
		obj[1] = JunitConstants.STRING_TYPE;
		obj[2] = JunitConstants.STRING_TYPE;
		obj[3] = JunitConstants.STRING_TYPE;
		obj[4] = JunitConstants.LONG_TYPE;
		objArr.add(obj);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objArr);
		assertNotNull(service.getEmpMappedBranches(JunitConstants.LONG_TYPE));
	}
	
	@Test
	void testGetSearchFilter() {
		List<EDPLuLookUpInfoEntity> lookupEntities = new ArrayList<>();
		lookupEntities.add(lookupInfoEntity);
		
		List<Integer> lookupInfoValue = new ArrayList<>();
		lookupInfoValue.add(Constant.INT_ONE_VALUE);
		lookupInfoValue.add(Constant.INT_TWO_VALUE);	

		when(edpLuLookupInfoRepository.findByEdpLuLookUpEntityLookUpIdAndLookUpInfoValueInAndActiveStatus(EDPConstant.EDP_BRANCH_REQUEST_TYPE,lookupInfoValue, Constant.ACTIVE_STATUS)).thenReturn(lookupEntities);
		when(lookupInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(lookupInfoEntity.getLookUpInfoName()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(service.getSearchFilter());
	}
	
	@Test
	void testGetBranchMappingList() throws CustomException {
		PageDetails pageDetail = new PageDetails();
		assertNotNull(service.getBranchMappingList(pageDetail));
	}

	@Test
	void testGetBrMapDtlByHdr() throws CustomException {
		List<Object[]> objectSp = new ArrayList<>();
		Object[] obj = new Object[15];
		obj[0] = JunitConstants.STRING_TYPE;
		obj[1] = JunitConstants.STRING_TYPE;
		obj[2] = EDPConstant.BRANCH_TRANSFER_REQ_TYPE_ID;
		obj[3] = JunitConstants.STRING_TYPE;
		obj[4] = JunitConstants.LONG_TYPE;
		obj[5] = JunitConstants.STRING_TYPE;
		obj[6] = JunitConstants.STRING_TYPE;
		obj[7] = JunitConstants.STRING_TYPE;
		obj[8] = JunitConstants.LONG_TYPE;
		obj[9] = JunitConstants.LONG_TYPE;
		obj[10] = JunitConstants.STRING_TYPE;
		obj[11] = JunitConstants.STRING_TYPE;
		obj[12] = JunitConstants.STRING_TYPE;
		obj[13] = JunitConstants.STRING_TYPE;
		obj[14] = JunitConstants.STRING_TYPE;
		objectSp.add(obj);
		when(edpTedpBrHdrRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objectSp);
		assertNotNull(service.getBrMapDtlByHdr(JunitConstants.LONG_TYPE));
	}
	
	@Test
	void testDeleteBrMapRequest() throws CustomException {
		service.deleteBrMapRequest(JunitConstants.LONG_TYPE);
		verify(edpTedpBrHdrRepository, times(1)).updateHdrActiveStatus(Mockito.anyInt(), Mockito.anyLong(),Mockito.anyLong(),Mockito.any(java.util.Date.class), Mockito.anyLong());
		verify(edpTedpBrDtlRepository, times(1)).deactivateByHdrId(Mockito.anyInt(), Mockito.anyLong(),Mockito.anyLong(),Mockito.any(java.util.Date.class), Mockito.anyLong());
	}
	
	@Test
	void testCheckForExistingRequest() throws CustomException {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(Constant.IN_POU_ID,JunitConstants.LONG_TYPE);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.CHECK_BRMAP_REQUEST_EXISTS));
		service.checkForExistingRequest(JunitConstants.LONG_TYPE);
		verify(repository, times(1)).callStoredProcedure(procName,argMap);		
	}

	@Test
	void testSaveBranchMapping() throws CustomException {
		List<Long> brlist = new ArrayList<>();
		brlist.add(JunitConstants.LONG_TYPE);

		EDPTedpBrDtlDto dtlDto = new EDPTedpBrDtlDto();
		dtlDto.setRequestType(EDPConstant.BRANCH_TRANSFER_REQ_TYPE_ID);
		dtlDto.setFromPouId(JunitConstants.LONG_TYPE);
		dtlDto.setToPouId(JunitConstants.LONG_TYPE);
		dtlDto.setBranchesToBeMapped(brlist);
		dtlDto.setFormAction(Status.SUBMITTED);
		
		when(edpTedpBrHdrConverter.brMapDtoToEntity(dtlDto)).thenReturn(hdrEntity);
		when(edpTedpBrHdrRepository.save(hdrEntity)).thenReturn(hdrEntity);
		when(hdrEntity.getTedpBrHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		
		when(edpTedpBrHdrConverter.hdrDtoToBrDtlEntity(dtlDto)).thenReturn(dtlEntity);
		when(edpTrnPouBrMapRepository.save(Mockito.any(EDPTrnPouBrMapEntity.class))).thenReturn(msBrMapEntity);
		
		assertNotNull(service.saveBranchMapping(dtlDto));
	}

	@Test
	void testSaveBranchMapping2() throws CustomException {
		List<Long> brlist = new ArrayList<>();
		brlist.add(JunitConstants.LONG_ZERO);

		EDPTedpBrDtlDto dtlDto = new EDPTedpBrDtlDto();
		dtlDto.setTedpBrHdrId(JunitConstants.LONG_TYPE);
		dtlDto.setRequestType(JunitConstants.LONG_TYPE);
		dtlDto.setFromPouId(JunitConstants.LONG_TYPE);
		dtlDto.setToPouId(JunitConstants.LONG_TYPE);
		dtlDto.setBranchesToBeMapped(brlist);
		dtlDto.setFormAction(Status.SUBMITTED);
		List<EDPTedpBrDtlEntity> dtlEntities = new ArrayList<>();
		EDPTedpBrDtlEntity dtlEntity2 = new EDPTedpBrDtlEntity();
		EDPMsBranchEntity branchEntity = new EDPMsBranchEntity();
		branchEntity.setBranchId(JunitConstants.LONG_ZERO);
		dtlEntity2.setBranchId(branchEntity);
		dtlEntities.add(dtlEntity);
		dtlEntities.add(dtlEntity2);
		
		when(edpTedpBrDtlRepository.findByTedpBrHdrIdTedpBrHdrId(Mockito.anyLong())).thenReturn(dtlEntities);
		when(dtlEntity.getBranchId()).thenReturn(entity);
		when(entity.getBranchId()).thenReturn(JunitConstants.LONG_TYPE);
		
		when(edpTedpBrHdrConverter.brMapDtoToEntity(dtlDto)).thenReturn(hdrEntity);
		when(edpTedpBrHdrRepository.save(hdrEntity)).thenReturn(hdrEntity);
		when(hdrEntity.getTedpBrHdrId()).thenReturn(JunitConstants.LONG_TYPE);
		
		when(edpTedpBrHdrConverter.hdrDtoToBrDtlEntity(dtlDto)).thenReturn(dtlEntity);
		when(edpTrnPouBrMapRepository.save(Mockito.any(EDPTrnPouBrMapEntity.class))).thenReturn(msBrMapEntity);
		
		assertNotNull(service.saveBranchMapping(dtlDto));
	}

	@Test
	void testCheckUserAccess() {
		List<Object[]> objectSp = new ArrayList<>();
		Object[] obj = new Object[8];
		obj[0] = JunitConstants.LONG_TYPE;
		obj[1] = JunitConstants.STRING_TYPE;
		obj[2] = JunitConstants.LONG_TYPE;
		obj[3] = JunitConstants.STRING_TYPE;
		obj[4] = JunitConstants.LONG_TYPE;
		obj[5] = JunitConstants.STRING_TYPE;
		obj[6] = JunitConstants.LONG_TYPE;
		obj[7] = JunitConstants.LONG_TYPE;

		Object[] obj2 = new Object[8];
		obj2[0] = JunitConstants.LONG_TYPE;
		obj2[1] = JunitConstants.STRING_TYPE;
		obj2[2] = JunitConstants.LONG_TYPE;
		obj2[3] = JunitConstants.STRING_TYPE_EDP;
		obj2[4] = JunitConstants.LONG_TYPE;
		obj2[5] = JunitConstants.STRING_TYPE_EDP;
		obj2[6] = JunitConstants.LONG_TYPE;
		obj2[7] = JunitConstants.LONG_TYPE;

		objectSp.add(obj);
		objectSp.add(obj2);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objectSp);
		assertNotNull(service.checkUserAccess(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE));
	}
	
}