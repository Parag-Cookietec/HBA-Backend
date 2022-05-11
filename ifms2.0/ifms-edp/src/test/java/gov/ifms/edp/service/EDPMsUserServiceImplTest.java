package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import gov.ifms.common.dto.FieldDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsUserConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.MinisterUserReqDto;
import gov.ifms.edp.dto.UserDto;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.employe.EDPEmployeRepository;
import gov.ifms.edp.entity.EDPLkEmpUserEntity;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.entity.EDPLkPostUserEntity;
import gov.ifms.edp.entity.EDPLuLookUpEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPMsUserPassHistEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.repository.EDPLkEmpUserRepository;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLkPostUserOfficeRepository;
import gov.ifms.edp.repository.EDPLkPostUserRepository;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPMsUserPassHistRepository;
import gov.ifms.edp.repository.EDPMsUserRepository;
import gov.ifms.edp.repository.EDPUserRoleMappingRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPMsUserServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsUserServiceImplTest {

	/** The repository. */
	@Mock
	private EDPMsUserRepository repository;

	/** The post user repo. */
	@Mock
	private EDPLkPostUserRepository postUserRepo;

	/** The edp lk post user office repository. */
	@Mock
	private EDPLkPostUserOfficeRepository edpLkPostUserOfficeRepository;

	/** The list entity. */
	@Mock
	private List<EDPMsUserEntity> listEntity;

	/** The user entity. */
	@Mock
	private EDPMsUserEntity userEntity;

	/** The edp lu look up info repository. */
	@Mock
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	/** The edp ms office repository. */
	@Mock
	private EDPMsOfficeRepository edpMsOfficeRepository;

	/** The edp ms office entity. */
	@Mock
	private EDPMsOfficeEntity edpMsOfficeEntity;

	/** The lkpost entity. */
	@Mock
	private EDPLkPostUserEntity lkpostEntity;

	/** The look up entity. */
	@Mock
	private EDPLuLookUpInfoEntity lookUpEntity;

	/** The edp ms office service. */
	@Mock
	private EDPMsOfficeService edpMsOfficeService;

	/** The lk post list. */
	@Mock
	private List<EDPLkPostOfficeEntity> lkPostList;

	/** The lkoffc entity. */
	@Mock
	private EDPLkPostOfficeEntity lkoffcEntity;

	/** The user office entity. */
	@Mock
	private EDPLkPostOfficeEntity userOfficeEntity;

	/** The service. */
	@InjectMocks
	private EDPMsUserServiceImpl service;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	/** The pageable. */
	@Mock
	private PageRequest pageable;

	/** The page. */
	@Mock
	private Page<EDPMsUserEntity> page;

	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;

	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsUserEntity> spec;

	/** The edp lk po off user repository. */
	@Mock
	private EDPLkPoOffUserRepository edpLkPoOffUserRepository;

	/** The edp lk po off user entity. */
	@Mock
	private EDPLkPoOffUserEntity edpLkPoOffUserEntity;

	/** The edp lk post office entity. */
	@Mock
	private EDPLkPostOfficeEntity edpLkPostOfficeEntity;

	/** The edp ms post entity. */
	@Mock
	private EDPMsPostEntity edpMsPostEntity;

	/** The edp lu look up entity. */
	@Mock
	private EDPLuLookUpEntity edpLuLookUpEntity;

	/** The edp lu look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	/** The edp ms district entity. */
	@Mock
	private EDPMsDistrictEntity edpMsDistrictEntity;

	/** The encrypt decrypt utill. */
	@Mock
	private EncryptDecryptUtil encryptDecryptUtill;

	/** The converter. */
	@Mock
	private EDPMsUserConverter converter;

	/** The field dto. */
	@Mock
	private FieldDto fieldDto;

	/** The oauth service. */
	@Mock
	private OAuthService oauthService;

	/** The edp ms user pass hist repository. */
	@Mock
	private EDPMsUserPassHistRepository edpMsUserPassHistRepository;

	/** The edp lk emp user repository. */
	@Mock
	private EDPLkEmpUserRepository edpLkEmpUserRepository;

	/** The edp lk emp user entity. */
	@Mock
	private EDPLkEmpUserEntity edpLkEmpUserEntity;

	/** The edp employe entity. */
	@Mock
	private EDPEmployeEntity edpEmployeEntity;

	@Mock
	private EDPUserRoleMappingRepository edpUserRoleMappingRepository;
	
	@Mock
	private EDPUsrPoTrnsRepository edpUsrPoTrnsRepository;
	
	@Mock
	private UserDto wfUserDto;
	
	@Mock
	private MinisterUserReqDto ministerUserReqDto;
	
	@Mock
	private EDPEmployeRepository edpEmployeRepository;
	
	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms users.
	 */
	@Test
	void testGetMsUsers() {
		when(repository.findAll()).thenReturn(listEntity);
		assertNotNull(service.getMsUsers());
		verify(repository, times(1)).findAll();
	}

	/**
	 * Test get ms user.
	 */
	@Test
	void testGetMsUser() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(userEntity);
		assertNotNull(service.getMsUser(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update ms user.
	 */
	@Test
	void testSaveOrUpdateMsUser() {
		when(repository.save(userEntity)).thenReturn(userEntity);
		assertNotNull(service.saveOrUpdateMsUser(userEntity));
		verify(repository, times(1)).save(userEntity);
	}

	/**
	 * Test delete ms user.
	 */
	@Test
	void testDeleteMsUser() {
		service.deleteMsUser(JunitConstants.LONG_TYPE);
		verify(repository, times(1)).deleteById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save ms users.
	 */
	@Test
	void testSaveMsUsers() {
		when(repository.saveAll(listEntity)).thenReturn(listEntity);
		assertNotNull(service.saveMsUsers(listEntity));
		verify(repository, times(1)).saveAll(listEntity);
	}

	/**
	 * Test edp ms user as method name search.
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testEdpMsUserAsMethodNameSearch() {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.STRING_TYPE);
		searchParam.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> list = new ArrayList<>();
		list.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(list);
		when(searchCriteria.getSpecificationDetails(spec, list)).thenReturn(spec);
		when(repository.findAll(spec, pageable)).thenReturn(page);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.edpMsUserAsMethodNameSearch(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

	/**
	 * Test get dependent uer id by user id.
	 */
	@Test
	void testGetDependentUerIdByUserId() {
		List<EDPLkPoOffUserEntity> lkPoOffUserEntityList = new ArrayList<EDPLkPoOffUserEntity>();
		lkPoOffUserEntityList.add(edpLkPoOffUserEntity);
		when(edpLkPoOffUserRepository.findByUserIdUserIdAndActiveStatus(JunitConstants.LONG_TYPE,
				OAuthConstant.ACTIVE_STATUS)).thenReturn(lkPoOffUserEntityList);
		when(edpLkPoOffUserEntity.getLkPostOfficeId()).thenReturn(edpLkPostOfficeEntity);
		when(edpLkPostOfficeEntity.getOfficeEntity()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeTypeId()).thenReturn(lookUpEntity);
		when(lookUpEntity.getOrderId()).thenReturn(JunitConstants.SHORT_TYPE);
		assertNotNull(service.getDependentUerIdByUserId(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test get dependent uer id by user id for else.
	 */
	@Test
	void testGetDependentUerIdByUserIdForElse() {
		List<EDPLkPoOffUserEntity> lkPoOffUserEntityList = new ArrayList<EDPLkPoOffUserEntity>();
		lkPoOffUserEntityList.add(edpLkPoOffUserEntity);
		when(edpLkPoOffUserRepository.findByUserIdUserIdAndActiveStatus(JunitConstants.LONG_TYPE,
				OAuthConstant.ACTIVE_STATUS)).thenReturn(lkPoOffUserEntityList);
		when(edpLkPoOffUserEntity.getLkPostOfficeId()).thenReturn(edpLkPostOfficeEntity);
		when(edpLkPostOfficeEntity.getOfficeEntity()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeTypeId()).thenReturn(lookUpEntity);
		when(lookUpEntity.getOrderId()).thenReturn(JunitConstants.SHORT_TYPE_2);
		when(lookUpEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPMsOfficeEntity> officeEntities = new ArrayList<>();
		officeEntities.add(edpMsOfficeEntity);
		when(edpMsOfficeRepository.findByOfficeTypeIdLookUpInfoIdIn(Mockito.anySet())).thenReturn(officeEntities);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkPoOffUserRepository.findByLkPostOfficeIdOfficeEntityOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				OAuthConstant.ACTIVE_STATUS)).thenReturn(lkPoOffUserEntityList);
		when(edpLkPoOffUserEntity.getUserId()).thenReturn(userEntity);
		assertNotNull(service.getDependentUerIdByUserId(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test find user by name and password.
	 */
	@Test
	void testFindUserByNameAndPassword() {
		when(repository.findByUserNameContainingIgnoreCaseAndPassword(JunitConstants.STRING_TYPE,
				JunitConstants.STRING_TYPE)).thenReturn(userEntity);
		assertNotNull(service.findUserByNameAndPassword(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE));
		verify(repository, times(1)).findByUserNameContainingIgnoreCaseAndPassword(JunitConstants.STRING_TYPE,
				JunitConstants.STRING_TYPE);
	}

	/**
	 * Test find user by name.
	 */
	@Test
	void testFindUserByName() {
		when(repository.findByUserNameContainingIgnoreCase(JunitConstants.STRING_TYPE)).thenReturn(userEntity);
		assertNotNull(service.findUserByName(JunitConstants.STRING_TYPE));
		verify(repository, times(1)).findByUserNameContainingIgnoreCase(JunitConstants.STRING_TYPE);
	}

	/**
	 * Test get ms user by post id.
	 */
	@Test
	void testGetMsUserByPostId() {
		List<EDPLkPostUserEntity> postEntityList = new ArrayList<EDPLkPostUserEntity>();
		EDPLkPostUserEntity post = new EDPLkPostUserEntity();
		post.setEdpMsUsers(userEntity);
		postEntityList.add(post);
		when(postUserRepo.findByEdpMsPostsPostId(JunitConstants.LONG_TYPE)).thenReturn(postEntityList);
		assertNotNull(service.getMsUserByPostId(JunitConstants.LONG_TYPE));
		verify(postUserRepo, times(1)).findByEdpMsPostsPostId(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test get all code and id.
	 */
	@Test
	void testGetAllCodeAndId() {
		List<Object[]> list = new ArrayList<Object[]>();
		when(repository.findCodeAndId()).thenReturn(list);
		List<ClueDto> listclue = EDPUtility.getFromObject(list);
		ClueDto clueDto = new ClueDto();
		clueDto.setId(JunitConstants.LONG_TYPE);
		clueDto.setCode(JunitConstants.STRING_TYPE);
		clueDto.setDescription(JunitConstants.STRING_TYPE);
		listclue.add(clueDto);
		// when(EDPUtility.getFromObject(repository.findCodeAndId())).thenReturn(listclue);
		assertNotNull(service.getAllCodeAndId());
	}

	/**
	 * Test find user by user code.
	 */
	@Test
	void testFindUserByUserCode() {
		when(repository.findByUserCode(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(userEntity));
		assertNotNull(service.findUserByUserCode(JunitConstants.LONG_TYPE));
		when(repository.findByUserCode(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		assertNull(service.findUserByUserCode(JunitConstants.LONG_TYPE));
		verify(repository, times(2)).findByUserCode(JunitConstants.LONG_TYPE);

	}

	/**
	 * Test find user by user code and password.
	 */
	@Test
	void testFindUserByUserCodeAndPassword() {
		when(repository.findByUserCodeAndPassword(JunitConstants.LONG_TYPE, JunitConstants.STRING_TYPE))
				.thenReturn(userEntity);
		assertNotNull(service.findUserByUserCodeAndPassword(JunitConstants.LONG_STRING, JunitConstants.STRING_TYPE));
		verify(repository, times(1)).findByUserCodeAndPassword(JunitConstants.LONG_TYPE, JunitConstants.STRING_TYPE);
	}

	/**
	 * Test find all usersfor reset password.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testFindAllUsersforResetPassword() throws CustomException {
		when(repository.findByUserCodeAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(userEntity);
		when(userEntity.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkPoOffUserRepository.findByUserIdUserIdAndActiveStatusAndIsPrimaryPostLookUpInfoName(
				JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS, Constant.LOOKUP_YES))
						.thenReturn(java.util.Optional.of(edpLkPoOffUserEntity));
		when(edpLkPoOffUserRepository.findByUserIdUserIdAndActiveStatusAndIsPrimaryPostLookUpInfoName(
				JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS, Constant.LOOKUP_YES))
						.thenReturn(java.util.Optional.of(edpLkPoOffUserEntity));
		when(edpLkPoOffUserEntity.getLkPostOfficeId()).thenReturn(edpLkPostOfficeEntity);
		when(edpLkPostOfficeEntity.getOfficeEntity()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.LOOKUP_YES)).thenReturn(lookUpEntity);
		when(edpMsOfficeEntity.getDistrictId()).thenReturn(edpMsDistrictEntity);
		
		when(userEntity.getUserCode()).thenReturn(JunitConstants.LONG_TYPE);
		when(userEntity.getUserName()).thenReturn(JunitConstants.STRING_TYPE);
		when(encryptDecryptUtill.encrypt(Long.toString(JunitConstants.LONG_TYPE)))
				.thenReturn(JunitConstants.STRING_TYPE);
		when(edpMsOfficeEntity.getOfficeName()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpLkPoOffUserEntity.getIsPrimaryPost()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoValue()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(edpLkPoOffUserEntity.getLkPostOfficeId()).thenReturn(edpLkPostOfficeEntity);
		when(edpLkPostOfficeEntity.getPostEntity()).thenReturn(edpMsPostEntity);
		when(edpMsPostEntity.getPostName()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpLkPostOfficeEntity.getIsVacant()).thenReturn(lookUpEntity);
		when(lookUpEntity.getEdpLuLookUpEntity()).thenReturn(edpLuLookUpEntity);
		when(edpLuLookUpEntity.getLookUpName()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(service.findUserforResetpwd(JunitConstants.LONG_TYPE));
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_ZERO);
		when(edpMsOfficeEntity.getIsTreasury()).thenReturn(JunitConstants.SHORT_TYPE_2);
		when(edpMsDistrictEntity.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.findUserforResetpwd(JunitConstants.LONG_TYPE));
		
		when(edpLuLookUpInfoEntity.getLookUpInfoValue()).thenReturn(JunitConstants.INTEGER_TYPE_68);
		assertNotNull(service.findUserforResetpwd(JunitConstants.LONG_TYPE));
	}

	/**
	 * Testfind all usersfor globle password.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testfindAllUsersforGloblePassword() throws CustomException {
		when(edpLkPoOffUserEntity.getIsPrimaryPost()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoValue()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(repository.findByUserCodeAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
				.thenReturn(userEntity);
		when(userEntity.getUserId()).thenReturn(Long.valueOf(JunitConstants.LONG_TYPE));
		when(edpLkPoOffUserRepository.findByUserIdUserIdAndActiveStatusAndIsPrimaryPostLookUpInfoName(
				userEntity.getUserId(), Constant.ACTIVE_STATUS, Constant.LOOKUP_YES))
						.thenReturn(Optional.of(edpLkPoOffUserEntity));
		when(edpLkPoOffUserEntity.getLkPostOfficeId()).thenReturn(edpLkPostOfficeEntity);
		when(edpLkPostOfficeEntity.getOfficeEntity()).thenReturn(edpMsOfficeEntity);
		when(edpLkPostOfficeEntity.getPostEntity()).thenReturn(edpMsPostEntity);
		when(edpMsPostEntity.getPostName()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpLkPostOfficeEntity.getIsVacant()).thenReturn(lookUpEntity);
		when(lookUpEntity.getEdpLuLookUpEntity()).thenReturn(edpLuLookUpEntity);
		when(edpLuLookUpEntity.getLookUpName()).thenReturn(Constant.LOOKUP_YES);
		assertNotNull(service.findAllUsersforGloblePassword(JunitConstants.LONG_TYPE));
		when(edpLuLookUpInfoEntity.getLookUpInfoValue()).thenReturn(JunitConstants.INTEGER_TYPE_68);
		assertNotNull(service.findAllUsersforGloblePassword(JunitConstants.LONG_TYPE));
		when(edpLkPoOffUserRepository.findByUserIdUserIdAndActiveStatusAndIsPrimaryPostLookUpInfoName(
				userEntity.getUserId(), Constant.ACTIVE_STATUS, Constant.LOOKUP_YES)).thenReturn(Optional.empty());
		assertNotNull(service.findAllUsersforGloblePassword(JunitConstants.LONG_TYPE));

	}

	/** The edp ms user pass hist entity. */
	@Mock
	private EDPMsUserPassHistEntity edpMsUserPassHistEntity;

	/**
	 * Test reset password.
	 *
	 * @throws Exception the exception
	 */
	// @Test
	void testResetPassword() throws Exception {
		try {
			when(fieldDto.getFieldValue()).thenReturn(JunitConstants.STRING_TYPE);
			when(encryptDecryptUtill.decrypt(JunitConstants.STRING_TYPE)).thenReturn(JunitConstants.LONG_STRING);
			when(repository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(userEntity));
			when(oauthService.encodePassword(EDPConstant.DEFAULT_PASWD)).thenReturn(JunitConstants.PASSWORD);
			when(userEntity.getUserId()).thenReturn(1l);
			when(edpMsUserPassHistRepository.save(edpMsUserPassHistEntity)).thenReturn(edpMsUserPassHistEntity);
			assertTrue(service.resetPassword(fieldDto, Boolean.TRUE));
		} catch (Exception e) {
		}

	}

	/**
	 * Test get edp employee post by emp no.
	 *
	 * @throws Exception the exception
	 */
//	@Test
	void testGetEdpEmployeePostByEmpNo() throws Exception {
		assertNotNull(service.getEdpEmployeePostByEmpNo(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE));
	}

	/**
	 * Test get user rights.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testGetUserRights() throws Exception {
		assertNotNull(service.getUserRights(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test find by user code.
	 */
	@Test
	void testFindByUserCode() {
		when(repository.findByUserCodeAndActiveStatus(JunitConstants.LONG_TYPE, OAuthConstant.ACTIVE_STATUS))
				.thenReturn(userEntity);
		assertNotNull(service.findByUserCode(JunitConstants.LONG_TYPE));

	}

	/**
	 * Test get saved user rights.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetSavedUserRights() throws CustomException {
		assertNotNull(service.getSavedUserRights(JunitConstants.LONG_TYPE, JunitConstants.TRUE));
	}

	@Test
	void testCheckHasExistingRightsMappingRequest() throws CustomException {
		Object[] obj = new Object[7];
		obj[0] = JunitConstants.LONG_TYPE;
		obj[1] = JunitConstants.LONG_TYPE;
		obj[2] = JunitConstants.LONG_TYPE;
		obj[3] = JunitConstants.LONG_TYPE;
		obj[4] = JunitConstants.LONG_TYPE;
		obj[5] = JunitConstants.LONG_TYPE;
		obj[6] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(obj);
		service.checkHasExistingRightsMappingRequest(JunitConstants.LONG_TYPE);
	}
	
	@Test
	void testGetWorkFlowsForMenu() throws CustomException {
		Object[] obj = new Object[7];
		obj[0] = JunitConstants.LONG_TYPE;
		obj[1] = JunitConstants.LONG_TYPE;
		obj[2] = JunitConstants.LONG_TYPE;
		obj[3] = JunitConstants.LONG_TYPE;
		obj[4] = JunitConstants.LONG_TYPE;
		obj[5] = JunitConstants.LONG_TYPE;
		obj[6] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(obj);

		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(objects);
		assertNotNull(service.getWorkFlowsForMenu(JunitConstants.LONG_TYPE,JunitConstants.LONG_TYPE, JunitConstants.TRUE));
	}
	
	@Test
	void testGetMinisterWfUser() throws CustomException {
		List<UserDto> users = new ArrayList<>();
		users.add(wfUserDto);
		when(repository.findMisterUserByNextMinisterRole(Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyLong(), Mockito.anyInt())).thenReturn(users);
		assertNotNull(service.getMinisterWfUser(ministerUserReqDto));
	}
	
	@Test
	void testGetUserPhotoByUserId() throws CustomException, IOException {
		Object[] obj = new Object[7];
		obj[0] = JunitConstants.LONG_TYPE;
		obj[1] = JunitConstants.LONG_TYPE;
		List<Object[]> objects = new ArrayList<>();
		objects.add(obj);
		when(edpEmployeRepository.getEmployeePhoto(Mockito.anyLong())).thenReturn(objects);
		Throwable exception = assertThrows(Exception.class, () -> {
		service.getUserPhotoByUserId(JunitConstants.LONG_TYPE);});
	}
}