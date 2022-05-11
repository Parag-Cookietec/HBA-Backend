package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.dto.UpdateRolePrmDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.converter.EDPUserRoleMappingConverter;
import gov.ifms.edp.converter.EDPtusrRgMapConverter;
import gov.ifms.edp.converter.EDPtusrRgMapDtlConverter;
import gov.ifms.edp.converter.EDPtusrRgMapDtlItrConverter;
import gov.ifms.edp.converter.EDPtusrRgMapWfDtlConverter;
import gov.ifms.edp.converter.EDPtusrRgMapWfDtlItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPEmpByOffIdDto;
import gov.ifms.edp.dto.EDPMsMenuDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.dto.EDPRightsMappingDataDto;
import gov.ifms.edp.dto.EDPRightsMappingDto;
import gov.ifms.edp.dto.EDPUserRightsGivenRemovalDto;
import gov.ifms.edp.dto.EdpURMHeaderView;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.entity.EDPLkEmpUserEntity;
import gov.ifms.edp.entity.EDPLkModuleOfficeEntity;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLkUserMenuEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.edp.entity.EDPMsModuleEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;
import gov.ifms.edp.entity.EDPMsSubModuleEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPTrnUserMpAttEntity;
import gov.ifms.edp.entity.EDPUserRoleMappingEntity;
import gov.ifms.edp.entity.EDPUserRoleMappingItrEntity;
import gov.ifms.edp.entity.EDPtusrRgMapDtlEntity;
import gov.ifms.edp.entity.EDPtusrRgMapDtlItrEntity;
import gov.ifms.edp.entity.EDPtusrRgMapEntity;
import gov.ifms.edp.entity.EDPtusrRgMapWfDtlEntity;
import gov.ifms.edp.entity.EDPtusrRgMapWfDtlItrEntity;
import gov.ifms.edp.entity.EdpLkSubMenuOfficeTypeEntity;
import gov.ifms.edp.oauth.dto.OAuthTokenPostDTO;
import gov.ifms.edp.repository.EDPLkEmpUserRepository;
import gov.ifms.edp.repository.EDPLkModuleOfficeRepository;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLkPuoMenuRLWFRepository;
import gov.ifms.edp.repository.EDPLkUserMenuRepository;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;
import gov.ifms.edp.repository.EDPMsMenuRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPMsRolePermissionsRepository;
import gov.ifms.edp.repository.EDPTrnUserMnuRolePrmRepository;
import gov.ifms.edp.repository.EDPTrnUserMpAttRepository;
import gov.ifms.edp.repository.EDPUserRoleMappingItrRepository;
import gov.ifms.edp.repository.EDPUserRoleMappingRepository;
import gov.ifms.edp.repository.EDPtusrRgMapDtlItrRepository;
import gov.ifms.edp.repository.EDPtusrRgMapDtlRepository;
import gov.ifms.edp.repository.EDPtusrRgMapRepository;
import gov.ifms.edp.repository.EDPtusrRgMapWfDtlItrRepository;
import gov.ifms.edp.repository.EDPtusrRgMapWfDtlRepository;
import gov.ifms.edp.repository.EdpLkSubMenuOfficeRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.workflow.service.EDPWorkflowRequestHandler;

/**
 * The Class EDPUserRoleMappingServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class EDPUserRoleMappingServiceImplTest {
	
	/** The repository. */
	@Mock
	private EDPUserRoleMappingRepository repository;
	
	/** The converter. */
	@Mock
	private EDPUserRoleMappingConverter converter;
	
	/** The list entity. */
	@Mock
	private List<EDPUserRoleMappingEntity> listEntity;
	
	/** The entity. */
	@Mock
	private EDPUserRoleMappingEntity entity;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPMsUserEntity> page;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsUserEntity> spec;
	
	/** The financial year repository. */
	@Mock
	private EDPMsFinancialYearRepository financialYearRepository;
	
	/** The result entity. */
	@Mock
	private EDPUserRoleMappingEntity resultEntity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The itr entity. */
	@Mock
	private EDPUserRoleMappingItrEntity itrEntity;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The list of EDPU ser. */
	@Mock
	private List<EDPUserRightsGivenRemovalDto> listOfEDPUSer;
	
	/** The edp user role mapping entity. */
	@Mock
	private EDPUserRoleMappingEntity edpUserRoleMappingEntity;
	
	/** The edp lu look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;
	
	/** The itr repository. */
	@Mock
	private EDPUserRoleMappingItrRepository itrRepository;
	
	/** The map. */
	@Mock
	private Map<String, Object> map;
	
	/** The search param. */
	@Mock
	private SearchParam searchParam;
	
	/** The update role prm dto. */
	@Mock
	private UpdateRolePrmDto updateRolePrmDto;
	
	/** The edp trn user mp att entity list. */
	@Mock
	private List<EDPTrnUserMpAttEntity> edpTrnUserMpAttEntityList;
	
	/** The att repository. */
	@Mock
	private EDPTrnUserMpAttRepository attRepository;
	
	@Mock
	private EDPTrnUserMnuRolePrmRepository edpTrnUserMnuRolePrmRepository;
	
	@Mock
	private EDPLkPoOffUserRepository edpLkPoOffUserRepository;
	
	@Mock
	private EDPLkPoOffUserEntity edpLkPoOffUserEntity;
	
	@Mock
	private EDPMsUserEntity edpMsUserEntity;
	
	@Mock
	private EDPLkEmpUserRepository edpLkEmpUserRepository;
	
	@Mock
	private EDPLkEmpUserEntity edpLkEmpUserEntity;
	
	@Mock
	private EDPEmployeEntity edpEmployeEntity;
	
	@Mock
	private EDPEmpByOffIdDto edpEmpByOffIdDto;
	
	@Mock
	private Map<String, Object> paramMap;

	@Mock
	private EDPMsMenuRepository edpMsMenuRepository;
	
	/** The service. */
	@InjectMocks
	private EDPUserRoleMappingServiceImpl service;

	@Mock
	private EDPMsMenuEntity edpMsMenuEntity;
	
	@Mock
	private EDPMsModuleEntity edpMsModuleEntity;

	@Mock
	private EDPMsSubModuleEntity edpMsSubModuleEntity;

	@Mock
	private EDPMsOfficeEntity officeEntity;
	
	@Mock
	private EDPMsOfficeRepository edpMsOfficeRepository;
	
	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	@Mock
	private EDPLkModuleOfficeRepository edpLkModuleOfficeRepository;
	
	@Mock
	private EDPLkModuleOfficeEntity modOfficeEntity;
	
	@Mock
	private EdpLkSubMenuOfficeTypeEntity menuOffTypeEntity;

	@Mock
	private EdpLkSubMenuOfficeRepository edpLkSubMenuOfficeRepository;
	
	@Mock
	private EDPMsDistrictRepository edpMsDistrictRepository;	
	
	@Mock
	private EDPtusrRgMapDtlRepository edptusrRgMapDtlRepository;
	
	@Mock
	private EDPtusrRgMapWfDtlRepository edptusrRgMapWfDtlRepository;
	
	@Mock
	private EDPtusrRgMapRepository edpTusrRgMapRepository;
	
	@Mock
	private EDPRightsMappingDto edpRightsMappingDto;
	
	@Mock
	private EDPRightsMappingDataDto edpRightsMappingDataDto;

	@Mock
	private EDPMsRolePermissionsRepository edpMsRolePermissionsRepository;

	@Mock
	private ClueDto oldWfRole;

	@Mock
	private ClueDto wfRole;

	@Mock
	private EDPtusrRgMapConverter edptusrRgMapConverter;
	
	@Mock
	private EDPtusrRgMapEntity rgMapEntity;
	
	@Mock
	private EDPtusrRgMapWfDtlEntity wfDtlSaveEntity;

	@Mock
	private EDPMsRolePermissionsEntity edpMsRolePermissionsEntity;

	@Mock
	private EDPtusrRgMapDtlConverter edptusrRgMapDtlConverter;

	@Mock
	private EDPtusrRgMapDtlEntity rgMapDtlEntity;

	@Mock
	private EDPtusrRgMapWfDtlConverter edptusrRgMapWfDtlConverter;
	
	@Mock
	private EDPtusrRgMapWfDtlItrConverter edptusrRgMapWfDtlItrConverter;
	
	@Mock
	private EDPtusrRgMapWfDtlItrEntity wfDtlItrEntity;

	@Mock
	private EDPtusrRgMapWfDtlItrRepository edptusrRgMapWfDtlItrRepository;
	
	@Mock
	private EDPtusrRgMapDtlItrConverter edptusrRgMapDtlItrConverter;
	
	@Mock
	private EDPtusrRgMapDtlItrEntity edpTusrRgMapDtlItrEntity;

	@Mock
	private EDPtusrRgMapDtlItrRepository edptusrRgMapDtlItrRepository;
	
	@Mock
	private EDPLkPuoMenuRLWFRepository edpLkPuoMenuRLWFRepository;

	@Mock
	private EDPRightsMappingDataDto edpRightsMappingDataDto1;

	@Mock
	private EDPRightsMappingDataDto edpRightsMappingDataDto2;

	@Mock
	private Map<Long,List<Object[]>> menuWishDetails;
	
	private List<Object[]> viewObjects = new ArrayList<>();

	@Mock
	private EDPMsDistrictEntity districtEntity;
	
	@Mock
	private EDPLkUserMenuRepository edpLkUserMenuRepository;
	
	@Mock
	private EDPLkUserMenuEntity lkUseMenu;

	@Mock
	private EDPMsDistrictRepository districtRepository;

	@Mock
	private EDPMsDistrictConverter districtConverter;
	
	@Mock
	private OAuthTokenPostDTO oAuthDto;

	@Mock
 	private EDPWorkflowRequestHandler wfRequestHandler;
	
	@Mock
 	private EDPMsPostDto postDto;
	
	@Mock
 	private EDPMsMenuDto menuDto;
	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get user role mapping.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetUserRoleMapping() throws CustomException {
		when(repository.getOne(1l)).thenReturn(edpUserRoleMappingEntity);
		assertEquals(edpUserRoleMappingEntity, service.getUserRoleMapping(1l));
		verify(repository, times(1)).getOne(1l);
	}

	/**
	 * Test get user role mappings.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetUserRoleMappings() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam(JunitConstants.TRSN_NO, ""));
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
		PagebleDTO<EdpURMHeaderView> data = service.getUserRoleMappings(pageDetail);
		assertNotNull(data);
	
		
	}
	
	/**
	 * Test get edp given removal rights.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetEdpGivenRemovalRights() throws CustomException {
		Object[] object = new Object[23];
		object[0] = JunitConstants.LONG_TYPE;
		object[1] = JunitConstants.STRING_TYPE;
		object[2] = JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.INTEGER_TYPE;
		object[4] = JunitConstants.LONG_TYPE;
		object[5] = JunitConstants.STRING_TYPE;
		object[6] = JunitConstants.STRING_TYPE;
		object[7] = JunitConstants.LONG_TYPE;
		object[8] = JunitConstants.STRING_TYPE;
		object[9] = JunitConstants.LONG_TYPE;
		object[10] = JunitConstants.STRING_TYPE;
		object[11] = JunitConstants.LONG_TYPE;
		object[12] = JunitConstants.STRING_TYPE;
		object[13] = JunitConstants.LONG_TYPE;
		object[14] = JunitConstants.STRING_TYPE;
		object[15] = JunitConstants.LONG_TYPE;
		object[16] = JunitConstants.STRING_TYPE;
		object[17] = JunitConstants.LONG_TYPE;
		object[18] = JunitConstants.LONG_TYPE;
		object[19] = JunitConstants.STRING_TYPE;
		object[20] = new Date();
		object[21] = JunitConstants.LONG_TYPE;
		object[22] = JunitConstants.STRING_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		List<Integer> list=new ArrayList<>();
		list.add(JunitConstants.INTEGER_TYPE);
		when(repository.checkPreviousSubmittedTransactionExist(JunitConstants.LONG_TYPE)).thenReturn(list);
		//when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
//		assertNotNull(service.getEdpGivenRemovalRights(JunitConstants.LONG_TYPE));
		List<Integer> list1=new ArrayList<>();
		when(repository.checkPreviousSubmittedTransactionExist(JunitConstants.LONG_TYPE)).thenReturn(list1);
//		assertNotNull(service.getEdpGivenRemovalRights(JunitConstants.LONG_TYPE));
	}
	
	@Test
	void testGetEmpByOfficeId() throws CustomException {
		List<EDPLkPoOffUserEntity> edpLkPoOffUserEntityList = new ArrayList<>();
		edpLkPoOffUserEntityList.add(edpLkPoOffUserEntity);
		when(edpLkPoOffUserRepository
				.findByLkPostOfficeIdOfficeEntityOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
				.thenReturn(edpLkPoOffUserEntityList);
		when(edpLkPoOffUserEntity.getUserId()).thenReturn(edpMsUserEntity);
		when(edpMsUserEntity.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		Set<EDPLkEmpUserEntity> edpLkEmpUserEntitySet = new HashSet<>();
		edpLkEmpUserEntitySet.add(edpLkEmpUserEntity);
		when(edpLkEmpUserRepository.findByUserIdUserIdIn(Mockito.anySet())).thenReturn(edpLkEmpUserEntitySet);
		when(edpLkEmpUserEntity.getUserId()).thenReturn(edpMsUserEntity);
		when(edpMsUserEntity.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkEmpUserEntity.getEmpId()).thenReturn(edpEmployeEntity);
		when(converter.toEmpByOffIdDto(edpEmployeEntity)).thenReturn(edpEmpByOffIdDto);
		assertNotNull(service.getEmpByOfficeId(JunitConstants.LONG_TYPE));
	}
	
	@Test
	void testUpdateRgMapByEmpIdAndPoOffId() throws CustomException {
		List<Integer> listInt = new ArrayList<>();
		listInt.add(1);
		listInt.add(2);
		when(repository.getRgMapByEmpIdAndPoOffId(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
			.thenReturn(listInt);
		service.updateRgMapByEmpIdAndPoOffId(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, 
			JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE);
		verify(repository).getRgMapByEmpIdAndPoOffId(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS);
	}
	
	@Test
	void testGetWfByMenuId() throws CustomException {
		Object[] object = new Object[3];
		object[0]=JunitConstants.LONG_TYPE;
		object[1]=JunitConstants.LONG_TYPE;
		object[2]=JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getWfByMenuId(JunitConstants.LONG_TYPE));
	}
	
	@Test
	void testGetPostByMenuOffId() throws CustomException {
		String str = JunitConstants.LONG_ZERO + "," + JunitConstants.LONG_TYPE;
		Object[] object = new Object[10];
		object[5] = str;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(edpMsMenuRepository.getOne(JunitConstants.LONG_TYPE)).thenReturn(edpMsMenuEntity);
		when(edpMsMenuEntity.getModuleId()).thenReturn(edpMsModuleEntity);
		when(edpMsMenuEntity.getSubModuleId()).thenReturn(edpMsSubModuleEntity);
		when(edpMsOfficeRepository.getOne(JunitConstants.LONG_TYPE)).thenReturn(officeEntity);
		when(officeEntity.getOfficeTypeId()).thenReturn(edpLuLookUpInfoEntity);
		when(officeEntity.getOfficeSubType()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLuLookUpInfoRepository.findBylookUpInfoId(Mockito.anyLong())).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn(JunitConstants.STRING_TREASURY_OFFICE);
		when(officeEntity.getOfficeTypeId()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkModuleOfficeRepository.findByModuleIdModuleIDAndOfficeTypeIdLookUpInfoIdAndOfficeCategoryIdLookUpInfoIdIsNullAndActiveStatus(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyInt())).thenReturn(modOfficeEntity);
		when(edpLkModuleOfficeRepository.getOne(Mockito.anyLong())).thenReturn(modOfficeEntity);
		when(modOfficeEntity.getLkModOffId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkSubMenuOfficeRepository.findByModOffTypeIdLkModOffIdAndSubModuleIdSubModuleIdAndMenuIdMenuIdAndActiveStatus(Mockito.anyLong(), Mockito.anyLong(),Mockito.anyLong(), Mockito.anyInt())).thenReturn(menuOffTypeEntity);
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(Collections.emptyList());
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getPostByMenuOffId(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_ZERO.toString()));

		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getPostByMenuOffId(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_ZERO.toString()));
		assertNotNull(service.getPostByMenuOffId(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_STRING));		
		
		when(officeEntity.getOfficeSubType()).thenReturn(EDPConstant.TO_LOOKUP_ID);
		when(edpLkModuleOfficeRepository.findByModuleIdModuleIDAndOfficeTypeIdLookUpInfoIdAndOfficeCategoryIdLookUpInfoIdAndActiveStatus(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyInt())).thenReturn(modOfficeEntity);
		assertNotNull(service.getPostByMenuOffId(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_ZERO.toString()));

		when(officeEntity.getOfficeDivision()).thenReturn(EDPConstant.DAT_OFFICE);
		assertNotNull(service.getPostByMenuOffId(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.LONG_ZERO.toString()));

	}
	
	@Test
	void testGetDistrictByStateId() {

		List<EDPMsDistrictEntity> districts = new ArrayList<>();
		districts.add(districtEntity);
		when(edpMsDistrictRepository.findByActiveStatusAndStateId(Mockito.anyInt(),Mockito.anyLong(), Mockito.any(Sort.class))).thenReturn(districts);
		service.getDistrictByStateId();
		verify(edpMsDistrictRepository, times(1)).findByActiveStatusAndStateId(Mockito.anyInt(),Mockito.anyLong(), Mockito.any(Sort.class));
	}
	
//	@Test
	void testGetModulesForOfficeType() throws CustomException{
		when(edpMsOfficeRepository.getOne(JunitConstants.LONG_TYPE)).thenReturn(officeEntity);
		when(officeEntity.getOfficeTypeId()).thenReturn(edpLuLookUpInfoEntity);
		when(officeEntity.getOfficeSubType()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLuLookUpInfoRepository.findBylookUpInfoId(Mockito.anyLong())).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn(JunitConstants.STRING_TREASURY_OFFICE);
		assertNotNull(service.getModulesForOfficeType(JunitConstants.LONG_TYPE));
		when(officeEntity.getOfficeDivision()).thenReturn(JunitConstants.STRING_DAT);
		assertNotNull(service.getModulesForOfficeType(JunitConstants.LONG_TYPE));
	}

	@Test
	void testGetSubModulesOrMenu() throws CustomException{
		List<EdpLkSubMenuOfficeTypeEntity> listMenuOffTypeEntity = new ArrayList<>();
		listMenuOffTypeEntity.add(menuOffTypeEntity);
		when(edpLkSubMenuOfficeRepository.findByModOffTypeIdLkModOffIdAndActiveStatusAndSubModuleIdNotNull(Mockito.anyLong(), Mockito.anyInt())).thenReturn(Collections.emptyList());
		Object[] object = new Object[3];
		object[0]=JunitConstants.LONG_TYPE;
		object[1]=JunitConstants.STRING_TYPE;
		List<Object> objects = new ArrayList<>();
		objects.add(object);
		when(edpLkSubMenuOfficeRepository.executeNativeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getSubModulesOrMenu(JunitConstants.LONG_TYPE));
		when(edpLkSubMenuOfficeRepository.findByModOffTypeIdLkModOffIdAndActiveStatusAndSubModuleIdNotNull(Mockito.anyLong(), Mockito.anyInt())).thenReturn(listMenuOffTypeEntity);
		when(menuOffTypeEntity.getSubModuleId()).thenReturn(edpMsSubModuleEntity);
		assertNotNull(service.getSubModulesOrMenu(JunitConstants.LONG_TYPE));

	}
	
	@Test
	void testGetMenusForSubmodule() throws CustomException{
		Object[] object = new Object[3];
		object[0]=JunitConstants.LONG_TYPE;
		object[1]=JunitConstants.STRING_TYPE;
		object[2] = JunitConstants.LONG_TYPE;
		List<Object> objects = new ArrayList<>();
		objects.add(object);
		when(edpLkSubMenuOfficeRepository.executeNativeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getMenusForSubmodule(Mockito.anyLong(), Mockito.anyLong()));
	}

	@Test
	void testGetSavedUserRights() throws CustomException{
		Object[] object = new Object[39];
		object[0] = JunitConstants.STRING_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		object[2] = JunitConstants.STRING_TYPE;
		object[3] = JunitConstants.STRING_TYPE;
		object[4] = JunitConstants.LONG_TYPE;
		object[5] = JunitConstants.LONG_TYPE;
		object[6] = JunitConstants.LONG_TYPE;
		object[7] = JunitConstants.LONG_TYPE;
		object[8] = JunitConstants.STRING_TYPE;
		object[9] = JunitConstants.STRING_TYPE;
		object[10] = JunitConstants.LONG_TYPE;
		object[11] = JunitConstants.STRING_TYPE;
		object[12] = JunitConstants.LONG_TYPE;
		object[13] = JunitConstants.STRING_TYPE;
		object[14] = JunitConstants.LONG_TYPE;
		object[15] = JunitConstants.STRING_TYPE;
		object[16] = JunitConstants.LONG_TYPE;
		object[17] = JunitConstants.STRING_TYPE;
		object[18] = JunitConstants.LONG_TYPE;
		object[19] = JunitConstants.STRING_TYPE;
		object[20] = JunitConstants.LONG_TYPE;
		object[21] = JunitConstants.STRING_TYPE;
		object[22] = JunitConstants.STRING_TYPE;
		object[23] = JunitConstants.STRING_TYPE;
		object[24] = JunitConstants.LONG_TYPE;
		object[25] = JunitConstants.LONG_TYPE;
		object[26] = JunitConstants.LONG_TYPE;
		object[27] = JunitConstants.LONG_TYPE;
		object[28] = JunitConstants.STRING_TYPE;
		object[29] = JunitConstants.STRING_TYPE;
		object[30] = JunitConstants.STRING_TYPE;
		object[31] = JunitConstants.STRING_TYPE;
		object[32] = new Date();
		object[33] = JunitConstants.LONG_TYPE;
		object[34] = JunitConstants.LONG_TYPE;
		object[35] = JunitConstants.LONG_TYPE;
		object[36] = JunitConstants.LONG_TYPE;
		object[37] = JunitConstants.LONG_TYPE;
		object[38] = JunitConstants.LONG_TYPE;
		viewObjects.add(object);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(viewObjects);
		assertNotNull(service.getSavedUserRights(JunitConstants.LONG_TYPE));
	}
	
	@Test
	void testDeActiveOldTransctionListbyRgMapId() throws CustomException {
		service.deActiveOldTransctionListbyRgMapId(JunitConstants.LONG_TYPE);
		verify(edptusrRgMapDtlRepository, times(1)).updateActiveStatusByRgMapDtlId(Mockito.anyLong(),Mockito.anyInt(),Mockito.anyLong(),Mockito.anyLong(),Mockito.any(Date.class));
		verify(edptusrRgMapWfDtlRepository, times(1)).updateActiveStatusByRgMapDtlId(Mockito.anyLong(),Mockito.anyInt(),Mockito.anyLong(),Mockito.anyLong(),Mockito.any(Date.class));
	}
	
	@Test
	void testDeleteUserRoleMappings() throws CustomException {
		service.deleteUserRoleMappings(JunitConstants.LONG_TYPE);
		verify(edpTusrRgMapRepository,times(1)).updateActiveStatusByRgMapId(Mockito.anyLong(),Mockito.anyInt(),Mockito.anyLong(),Mockito.anyLong(),Mockito.any(Date.class));
		verify(edptusrRgMapDtlRepository, times(1)).multipalUpdateActiveStatusByRgMapId(Mockito.anyLong(),Mockito.anyInt(),Mockito.anyLong(),Mockito.anyLong(),Mockito.any(Date.class));
		verify(edptusrRgMapWfDtlRepository, times(1)).multipalUpdateActiveStatusByRgMapId(Mockito.anyLong(),Mockito.anyInt(),Mockito.anyLong(),Mockito.anyLong(),Mockito.any(Date.class));
	}
	
//	@Test
	void testSaveUserRoleMapping()  throws CustomException {
		
		Object[] object = new Object[39];
		object[0] = JunitConstants.STRING_TYPE;
		object[1] = JunitConstants.LONG_TYPE;
		object[2] = JunitConstants.STRING_TYPE;
		object[3] = JunitConstants.STRING_TYPE;
		object[4] = JunitConstants.LONG_TYPE;
		object[5] = JunitConstants.LONG_TYPE;
		object[6] = JunitConstants.LONG_TYPE;
		object[7] = JunitConstants.LONG_TYPE;
		object[8] = JunitConstants.STRING_TYPE;
		object[9] = JunitConstants.STRING_TYPE;
		object[10] = JunitConstants.LONG_TYPE;
		object[11] = JunitConstants.STRING_TYPE;
		object[12] = JunitConstants.LONG_TYPE;
		object[13] = JunitConstants.STRING_TYPE;
		object[14] = JunitConstants.LONG_TYPE;
		object[15] = JunitConstants.STRING_TYPE;
		object[16] = JunitConstants.LONG_TYPE;
		object[17] = JunitConstants.STRING_TYPE;
		object[18] = JunitConstants.LONG_TYPE;
		object[19] = JunitConstants.STRING_TYPE;
		object[20] = JunitConstants.LONG_TYPE;
		object[21] = JunitConstants.STRING_TYPE;
		object[22] = JunitConstants.STRING_TYPE;
		object[23] = JunitConstants.STRING_TYPE;
		object[24] = JunitConstants.LONG_TYPE;
		object[25] = JunitConstants.LONG_TYPE;
		object[26] = JunitConstants.LONG_TYPE;
		object[27] = JunitConstants.LONG_TYPE;
		object[28] = JunitConstants.STRING_TYPE;
		object[29] = JunitConstants.STRING_TYPE;
		object[30] = JunitConstants.STRING_TYPE;
		object[31] = JunitConstants.STRING_TYPE;
		object[32] = new Date();
		object[33] = JunitConstants.STRING_TYPE;
		object[34] = JunitConstants.LONG_TYPE;
		object[35] = JunitConstants.STRING_TYPE;
		object[36] = JunitConstants.LONG_TYPE;
		object[37] = JunitConstants.STRING_TYPE;
		object[38] = JunitConstants.LONG_TYPE;
		viewObjects.add(object);
        
		
		List<EDPRightsMappingDataDto> edpRightsMappingDataDtos = new ArrayList<>();
		edpRightsMappingDataDtos.add(edpRightsMappingDataDto);
		List<String> rightsList = new ArrayList<>();
		List<String> oldRightsList = new ArrayList<>();
		rightsList.add(JunitConstants.STRING_TYPE);
		oldRightsList.add(JunitConstants.STRING_OPTIONAL);
		List<ClueDto> oldWfRoleList = new ArrayList<>();
		List<ClueDto> wfRoleList = new ArrayList<>();
		oldWfRoleList.add(oldWfRole);
		wfRoleList.add(wfRole);
		
		Object[] object3 = new Object[1];
		object3[0]=JunitConstants.SET_TRSN_NO;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object3);

		Object[] object1 = new Object[5];
		object1[0]=JunitConstants.LONG_TYPE;
		object1[1]=JunitConstants.LONG_TYPE;
		object1[2]=JunitConstants.LONG_TYPE;
		object1[3] = JunitConstants.LONG_TYPE;
		object1[4]=JunitConstants.LONG_TYPE;
		List<Object[]> objects2 = new ArrayList<>();
		objects2.add(object1);
		paramMap.put(EDPConstant.IN_T_USR_RG_MAP_ID, JunitConstants.LONG_TYPE);
		
		List<EDPtusrRgMapWfDtlEntity> wfDtlSaveEntities = new ArrayList<>();
		wfDtlSaveEntities.add(wfDtlSaveEntity);
		List<EDPMsRolePermissionsEntity> rolePrmList = new ArrayList<>();
		rolePrmList.add(edpMsRolePermissionsEntity);
		List<EDPtusrRgMapWfDtlItrEntity> itrEntity = new ArrayList<>();
		itrEntity.add(wfDtlItrEntity);
		List<EDPtusrRgMapDtlItrEntity> dtlItrEntity = new ArrayList<>();
		dtlItrEntity.add(edpTusrRgMapDtlItrEntity);
		List<EDPtusrRgMapDtlEntity> dtlSaveEntities = new ArrayList<>();
		dtlSaveEntities.add(rgMapDtlEntity);
		EDPtusrRgMapDtlEntity rgMapDtlEntity1 = new EDPtusrRgMapDtlEntity();
			
		when(edpRightsMappingDto.getUiDataList()).thenReturn(edpRightsMappingDataDtos);
		when(edpRightsMappingDto.getDataList()).thenReturn(edpRightsMappingDataDtos);
		when(edpRightsMappingDataDto.getRightsList()).thenReturn(rightsList);
		when(edpRightsMappingDataDto.getOldRightsList()).thenReturn(oldRightsList);
		when(edpRightsMappingDataDto.getOldWfRoleList()).thenReturn(oldWfRoleList);
		when(edpRightsMappingDataDto.getWfRoleList()).thenReturn(wfRoleList);
        when(edpRightsMappingDto.isWfInRequest()).thenReturn(false);
		
		when(edptusrRgMapConverter.edpRightsMappingDtoToEntity(Mockito.any(EDPRightsMappingDto.class))).thenReturn(rgMapEntity);
		when(edpTusrRgMapRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		when(edpTusrRgMapRepository.save(rgMapEntity)).thenReturn(rgMapEntity);
		when(rgMapEntity.getTusrRgMapId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edptusrRgMapWfDtlRepository.findByTusrRgMapDtlIdTusrRgMapIdTusrRgMapId(Mockito.anyLong())).thenReturn(wfDtlSaveEntities);
		when(edpMsRolePermissionsRepository.findByActiveStatus(Constant.ACTIVE_STATUS)).thenReturn(rolePrmList);
		when(edpMsRolePermissionsEntity.getRoleName()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpRightsMappingDto.getTusrRgMapId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edptusrRgMapDtlConverter.rightsMappingDataDtotoEntity(Mockito.any(EDPRightsMappingDataDto.class),Mockito.anyLong())).thenReturn(rgMapDtlEntity);
		when(edptusrRgMapDtlRepository.save(rgMapDtlEntity)).thenReturn(rgMapDtlEntity);
		when(edptusrRgMapWfDtlConverter.rightsMappingDataDtotoEntity(Mockito.anyList(),Mockito.anyList(),Mockito.any(EDPtusrRgMapDtlEntity.class))).thenReturn(wfDtlSaveEntities);
		when(edptusrRgMapWfDtlItrConverter.tusrRgMapWfDtlEntityToEntity(Mockito.anyList())).thenReturn(itrEntity);
		when(edptusrRgMapDtlItrConverter.tusrRgMapDtlEntitytoItrEntity(Mockito.anyList())).thenReturn(dtlItrEntity);
		assertNotNull(service.saveRequest(edpRightsMappingDto));
		
		when(edpRightsMappingDto.getTusrRgMapId()).thenReturn(JunitConstants.LONG_NULL);
		when(edptusrRgMapDtlConverter.rightsMappingDataDtotoEntity(Mockito.any(EDPRightsMappingDataDto.class),Mockito.nullable(Long.class))).thenReturn(rgMapDtlEntity);
		assertNotNull(service.saveRequest(edpRightsMappingDto));

		when(edptusrRgMapDtlRepository.findByTusrRgMapIdTusrRgMapId(Mockito.nullable(Long.class))).thenReturn(dtlSaveEntities);
		when(edptusrRgMapDtlConverter.tusrRgMapDtlSaveEntitytoEntity(Mockito.any(EDPRightsMappingDataDto.class),Mockito.any(EDPtusrRgMapDtlEntity.class))).thenReturn(rgMapDtlEntity);
		assertNotNull(service.saveRequest(edpRightsMappingDto));

		dtlSaveEntities.add(rgMapDtlEntity1);
		assertNotNull(service.saveRequest(edpRightsMappingDto));

		when(edpRightsMappingDto.getDataList()).thenReturn(Collections.emptyList());
		assertNotNull(service.saveRequest(edpRightsMappingDto));
		
		edpRightsMappingDataDtos.add(edpRightsMappingDataDto1);
		edpRightsMappingDataDtos.add(edpRightsMappingDataDto2);
		when(edpRightsMappingDto.getDataList()).thenReturn(edpRightsMappingDataDtos);
		assertNotNull(service.saveRequest(edpRightsMappingDto));
		
		when(edpRightsMappingDto.getFormAction()).thenReturn(Status.SUBMITTED);
		when(edpRightsMappingDto.getTusrRgMapId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(viewObjects);
		when(edpLkUserMenuRepository.save(Mockito.any())).thenReturn(lkUseMenu);
		when(lkUseMenu.getLkUserMenuId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.saveUserRoleMapping(edpRightsMappingDto));

	}

	@Test
	void testGetApproveUserRights() throws CustomException {
		Object[] object = new Object[6];
		object[0]=JunitConstants.LONG_TYPE;
		object[1]=JunitConstants.STRING_TYPE;
		object[2]=JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.STRING_TYPE;
		object[4]=JunitConstants.LONG_TYPE;
		object[5] = JunitConstants.STRING_TYPE;

		List<Object[]> objects = new ArrayList<>();
		objects.add(object);

		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getApproveUserRights(JunitConstants.LONG_TYPE));
	}
	
	@Test
	void testUpdateTrnDtlForSingleRecord() {
		Object[] object = new Object[9];
		object[0]=JunitConstants.LONG_TYPE;
		object[1]=JunitConstants.LONG_TYPE;
		object[2]=JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.LONG_TYPE;
		object[4]=JunitConstants.LONG_TYPE;
		object[5] = JunitConstants.LONG_TYPE;
		object[6]=JunitConstants.LONG_TYPE;
		object[7] = JunitConstants.LONG_TYPE;
		object[8]=JunitConstants.CARDEX_NO;
		service.updateTrnDtlForSingleRecord(object,JunitConstants.LONG_TYPE);
		verify(edpTrnUserMnuRolePrmRepository, times(1)).updateActiveStatusByTrnUsrRolePrmId(Mockito.anyLong(),Mockito.anyInt(),Mockito.anyLong(), Mockito.any(Date.class));

		object[8]=JunitConstants.LONG_TYPE;
		service.updateTrnDtlForSingleRecord(object,JunitConstants.LONG_TYPE);
		verify(edpTrnUserMnuRolePrmRepository, times(1)).updateActiveStatusAndRolePrmIdByTrnUsrRolePrmId(Mockito.anyLong(),Mockito.anyInt(),Mockito.anyLong(), Mockito.any(Date.class),Mockito.anyLong());

	}


	@Test
	void testCreateNewEDPTrnUserMnuRolePrmEntity() {
		assertNotNull(service.createNewEDPTrnUserMnuRolePrmEntity(JunitConstants.LONG_TYPE,JunitConstants.LONG_TYPE));
	}

	@Test
	void testGetMenuWishMap() {
		Object[] object = new Object[5];
		object[0]=JunitConstants.LONG_TYPE;
		object[1]=JunitConstants.LONG_TYPE;
		object[2]=JunitConstants.LONG_TYPE;
		object[3] = JunitConstants.LONG_TYPE;
		object[4]=JunitConstants.LONG_TYPE;
		List<Object[]> objs = new ArrayList<>();
		objs.add(object);
		assertNotNull(service.getMenuWishMap(objs));

	}

	@Test
	public void getListingFilterData() throws CustomException {
		List<EDPMsDistrictEntity> objectList = new ArrayList<>();
		List<Object> obj = new ArrayList<>();
		Object[] objes = new Object[5];
		objes[0] = 1;
		objes[2] = 1;
		objes[3] = 1;
		objes[1] = 1;
		obj.add(objes);
		when(districtRepository.findByActiveStatusAndStateId(Mockito.anyInt(),Mockito.anyLong(),Mockito.any())).thenReturn(objectList);
		when(repository.executeNativeSQLQuery(Mockito.any(),Mockito.any())).thenReturn(obj);
		assertNotNull(service.getListingFilterData());
	}
	
//	@Test
	public void testGetMenuOfficeDetails() {
		Object[] object = new Object[10];
		object[5] = JunitConstants.STRING_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(object);
		List<EDPMsMenuDto> menuDtoList = new ArrayList<>();
		menuDtoList.add(menuDto);
		when(edpLkModuleOfficeRepository.getOne(Mockito.anyLong())).thenReturn(modOfficeEntity);
		when(modOfficeEntity.getLkModOffId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkSubMenuOfficeRepository.findByModOffTypeIdLkModOffIdAndSubModuleIdSubModuleIdAndMenuIdMenuIdAndActiveStatus(Mockito.anyLong(), Mockito.anyLong(),Mockito.anyLong(), Mockito.anyInt())).thenReturn(menuOffTypeEntity);
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(Collections.emptyList());
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		when(oAuthDto.getEdpMsMenuDtoList()).thenReturn(menuDtoList);
		when(menuDto.getMenuDtos()).thenReturn(menuDtoList);
		when(menuDto.getMenuId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.getMenuOfficeDetails(JunitConstants.LONG_TYPE,JunitConstants.LONG_TYPE,JunitConstants.LONG_TYPE,JunitConstants.LONG_TYPE));
	}
	
}
