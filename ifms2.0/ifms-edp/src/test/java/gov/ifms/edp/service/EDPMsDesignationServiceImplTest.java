package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import gov.ifms.common.base.Status;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPDesignationItrConverter;
import gov.ifms.edp.converter.EDPMsDesignationConverter;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.converter.EDPMsPostConverter;
import gov.ifms.edp.converter.EDPTrnUpdDsgnConverter;
import gov.ifms.edp.converter.EDPTrnUpdDsgnItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsDesignationDto;
import gov.ifms.edp.dto.EDPMsMenuDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.dto.EDPTrnUpdDsgnDto;
import gov.ifms.edp.employe.EDPEmployeConverter;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.entity.EDPLkEmpUserEntity;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnItrEntity;
import gov.ifms.edp.oauth.dto.OAuthTokenPostDTO;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPDesignationItrRepository;
import gov.ifms.edp.repository.EDPLkEmpUserRepository;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLkPostOfficeRepository;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;
import gov.ifms.edp.repository.EDPMsPostRepository;
import gov.ifms.edp.repository.EDPTrnUpdDsgnItrRepository;
import gov.ifms.edp.repository.EDPTrnUpdDsgnRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.edp.workflow.service.EDPWorkflowRequestHandler;

/**
 * The Class EDPMsDesignationServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsDesignationServiceImplTest {

	/** The repository. */
	@Mock
	private EDPMsDesignationRepository repository;

	/** The edp ms post repository. */
	@Mock
	private EDPMsPostRepository edpMsPostRepository;

	/** The edp lk po off user repository. */
	@Mock
	private EDPLkPoOffUserRepository edpLkPoOffUserRepository;

	/** The edp lk emp user repository. */
	@Mock
	private EDPLkEmpUserRepository edpLkEmpUserRepository;

	/** The edp trn upd dsgn repository. */
	@Mock
	private EDPTrnUpdDsgnRepository edpTrnUpdDsgnRepository;

	/** The edp trn upd dsgn itr repository. */
	@Mock
	private EDPTrnUpdDsgnItrRepository edpTrnUpdDsgnItrRepository;

	/** The itr repository. */
	@Mock
	private EDPDesignationItrRepository itrRepository;

	/** The financial year repository. */
	@Mock
	private EDPMsFinancialYearRepository financialYearRepository;

	/** The edp lk post office repository. */
	@Mock
	private EDPLkPostOfficeRepository edpLkPostOfficeRepository;

	/** The list entity. */
	@Mock
	private List<EDPMsDesignationEntity> listEntity;

	/** The user entity. */
	@Mock
	private EDPMsUserEntity userEntity;

	/** The trn upd dsgn entity. */
	@Mock
	private EDPTrnUpdDsgnEntity trnUpdDsgnEntity;

	/** The entity. */
	@Mock
	private EDPMsDesignationEntity entity;

	/** The edp lk post office entity. */
	@Mock
	private EDPLkPostOfficeEntity edpLkPostOfficeEntity;

	/** The edp trn upd dsgn itr entity. */
	@Mock
	private EDPTrnUpdDsgnItrEntity edpTrnUpdDsgnItrEntity;

	/** The post entity. */
	@Mock
	private EDPMsPostEntity postEntity;

	/** The financial year entity. */
	@Mock
	private EDPMsFinancialYearEntity financialYearEntity;

	/** The desig dto. */
	@Mock
	private EDPMsDesignationDto desigDto;

	/** The edp ms designation service. */
	@Mock
	private EDPMsDesignationService edpMsDesignationService;

	/** The edp ms post dto. */
	@Mock
	private EDPMsPostDto edpMsPostDto;

	/** The office dto. */
	@Mock
	private EDPMsOfficeDto officeDto;

	/** The dto. */
	@Mock
	private ClueDto dto;

	/** The edp trn upd dsgn dto. */
	@Mock
	private EDPTrnUpdDsgnDto edpTrnUpdDsgnDto;

	/** The converter. */
	@Mock
	private EDPMsDesignationConverter converter;

	/** The itr converter. */
	@Mock
	private EDPDesignationItrConverter itrConverter;

	/** The edp employe converter. */
	@Mock
	private EDPEmployeConverter edpEmployeConverter;

	/** The edp ms post converter. */
	@Mock
	private EDPMsPostConverter edpMsPostConverter;

	/** The edp trn upd dsgn itr converter. */
	@Mock
	private EDPTrnUpdDsgnItrConverter edpTrnUpdDsgnItrConverter;

	/** The edp trn upd dsgn converter. */
	@Mock
	private EDPTrnUpdDsgnConverter edpTrnUpdDsgnConverter;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	/** The pageable. */
	@Mock
	private PageRequest pageable;

	/** The page. */
	@Mock
	private Page<EDPMsDesignationEntity> page;

	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;

	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsDesignationEntity> spec;

	/** The edplu look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity edpluLookUpInfoEntity;

	/** The lookupinforepository. */
	@Mock
	private EDPLuLookUpInfoRepository lookupinforepository;

	/** The edp lk po off user entity. */
	@Mock
	private EDPLkPoOffUserEntity edpLkPoOffUserEntity;

	/** The edp employe entity. */
	@Mock
	private EDPEmployeEntity edpEmployeEntity;

	/** The office entity. */
	@Mock
	private EDPMsOfficeEntity officeEntity;

	/** The edp lk emp user entity. */
	@Mock
	private EDPLkEmpUserEntity edpLkEmpUserEntity;
	
	/** The oauth utility. */
	@Mock
	private OAuthUtility oauthUtility;

	/** The service. */
	@InjectMocks
	private EDPMsDesignationServiceImpl service;
	
	@Mock
	private EDPMsDistrictRepository districtRepository;
	
	@Mock
	private EDPMsDistrictConverter districtConverter;
	
	@Mock
	private List<EDPMsMenuDto> menuDtoList;
	
	@Mock
	private OAuthTokenPostDTO oAuthTokenPostDTO;
	
	@Mock
	private EDPWorkflowRequestHandler wfRequestHandler;
	
	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms designations.
	 */
	@Test
	void testGetMsDesignations() {
		when(repository.findAll()).thenReturn(listEntity);
		assertNotNull(service.getMsDesignations());
		verify(repository, times(1)).findAll();
	}


	/**
	 * Test save designation.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSaveDesignation() throws CustomException {
		
		String updRequestproc = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.CHECK_DESIGNATION_REQUEST_EXISTS));
		String trnNoproc = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_EDP_TRN_NO_GEN));
		HashMap<String, Object> argMap = new HashMap<>();
		argMap.put(Constant.IN_DESIGNATION_NAME,JunitConstants.STRING_TYPE);
		HashMap<String, Object> argsMap = new HashMap<>();
		argsMap.put(Constant.TRN_SCREEN, JunitConstants.STRING_TYPE);
		
		when(desigDto.getDesignationId()).thenReturn(JunitConstants.LONG_NULL);
		when(desigDto.getDesignationName()).thenReturn(JunitConstants.STRING_TYPE);
		when(repository.findByDesignationNameIgnoreCaseAndActiveStatus(JunitConstants.STRING_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(listEntity);
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(Constant.LOOKUP_TRUE_VALUE))
				.thenReturn(financialYearEntity);
		when(listEntity.isEmpty()).thenReturn(JunitConstants.TRUE);
		when(repository.findTopByOrderByDesignationIdDesc()).thenReturn(entity);
		when(financialYearEntity.getFyShort()).thenReturn(JunitConstants.STRING_TYPE);
		when(desigDto.getMenuCode()).thenReturn(JunitConstants.STRING_TYPE);
		when(converter.toEntity(desigDto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(edpluLookUpInfoEntity);
		when(desigDto.isApprovedStatus()).thenReturn(Boolean.FALSE);
		when(desigDto.isWfSaveDrftApiCall()).thenReturn(Boolean.TRUE);
		when(desigDto.isWfInRequest()).thenReturn(Boolean.FALSE);
		when(desigDto.getFormAction()).thenReturn(JunitConstants.STRING_SUBMITTED);
		List<Object[]> listObject = new ArrayList<Object[]>();
		Object ooo[] = new Object[11];
		ooo[0] = JunitConstants.INTEGER_TYPE;
		ooo[1] = JunitConstants.STRING_TYPE;
		ooo[10] = JunitConstants.INTEGER_TYPE_69;
		ooo[3] = JunitConstants.STRING_TYPE;
		ooo[4] = JunitConstants.STRING_TYPE;
		listObject.add(ooo);
		when(repository.callStoredProcedure(updRequestproc, argMap)).thenReturn(new ArrayList<>());		
		when(repository.callStoredProcedure(trnNoproc, argsMap)).thenReturn(listObject);

		assertNotNull(service.saveDesignation(desigDto));
		when(desigDto.getFormAction()).thenReturn(Status.SUBMITTED);
		when(lookupinforepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED))
				.thenReturn(edpluLookUpInfoEntity);
		assertNotNull(service.saveDesignation(desigDto));
		when(desigDto.getDesignationId()).thenReturn(JunitConstants.DESIGNATION_ID);
	//	assertNotNull(service.saveDesignation(desigDto));
		when(repository.findById(JunitConstants.DESIGNATION_ID)).thenReturn(Optional.of(entity));
		when(entity.getDesignationName()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(service.saveDesignation(desigDto));
		when(entity.getDesignationName()).thenReturn(JunitConstants.STRING_TYPE_EDP);
		assertNotNull(service.saveDesignation(desigDto));
		when(desigDto.isApprovedStatus()).thenReturn(Boolean.TRUE);
		when(desigDto.isWfSaveDrftApiCall()).thenReturn(Boolean.TRUE);
		when(desigDto.isWfInRequest()).thenReturn(Boolean.FALSE);
		when(desigDto.getFormAction()).thenReturn(Status.DRAFT);
		assertNotNull(service.saveDesignation(desigDto));
		when(desigDto.getHasObjection()).thenReturn(Boolean.TRUE);
		when(desigDto.isWfInRequest()).thenReturn(Boolean.FALSE);
		when(desigDto.getDesignationId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.saveDesignation(desigDto));

	}

	/**
	 * Test delete ms designation.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDeleteMsDesignation() throws CustomException {
		service.deleteMsDesignation(JunitConstants.LONG_TYPE);
		verify(repository).updateActiveStatusByDesignationId(Mockito.any(Long.class), Mockito.any(Integer.class),
				Mockito.any(Long.class), Mockito.any(java.util.Date.class));
	}

	/**
	 * Test save ms designations.
	 */
	@Test
	void testSaveMsDesignations() {
		when(repository.saveAll(listEntity)).thenReturn(listEntity);
		assertNotNull(service.saveMsDesignations(listEntity));
		verify(repository, times(1)).saveAll(listEntity);
	}

	/**
	 * Test edp ms designation as method name search.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testEdpMsDesignationAsMethodNameSearch() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.STRING_TYPE);
		searchParam.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> list = new ArrayList<>();
		list.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(list);
		when(searchCriteria.getSpecificationDetails(spec, list)).thenReturn(spec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.edpMsDesignationAsMethodNameSearch(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

	/**
	 * Test get update designation details dto.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetUpdateDesignationDetailsDto() throws CustomException {
		
		when(officeDto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPLkPoOffUserEntity> lkPoOffUserEntity = new ArrayList<>();
		EDPLkPoOffUserEntity edpLkPoOffUserEntity = new EDPLkPoOffUserEntity();
		edpLkPoOffUserEntity.setUserId(userEntity);
		edpLkPoOffUserEntity.setLkPostOfficeId(edpLkPostOfficeEntity);
		when(edpLkPostOfficeEntity.getPostEntity()).thenReturn(postEntity);
		when(userEntity.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		lkPoOffUserEntity.add(edpLkPoOffUserEntity);
		
		when(edpLkPoOffUserRepository
				.findByLkPostOfficeIdOfficeEntityOfficeIdAndActiveStatusAndLkPostOfficeIdActiveStatus(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(lkPoOffUserEntity);
		when(userEntity.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		List<Object[]> list = new ArrayList<Object[]>();
		Object[] obj = new Object[3];
		obj[0] = JunitConstants.LONG_TYPE;
		obj[1] = JunitConstants.STRING_TYPE;
		obj[2] = JunitConstants.LONG_STRING;
		list.add(obj);
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(list);
		
		when(edpEmployeConverter.toClueDto(edpEmployeEntity)).thenReturn(new ClueDto());
		when(edpLkPoOffUserRepository.findByLkPostOfficeIdOfficeEntityOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,
				OAuthConstant.ACTIVE_STATUS)).thenReturn(lkPoOffUserEntity);
		Set<EDPLkEmpUserEntity> lkEmpUserList = new HashSet<EDPLkEmpUserEntity>();
		EDPLkEmpUserEntity lkEmpUserEntity = new EDPLkEmpUserEntity();
		lkEmpUserEntity.setUserId(userEntity);
		lkEmpUserEntity.setEmpId(edpEmployeEntity);
		when(userEntity.getUserId()).thenReturn(JunitConstants.LONG_TYPE);
		lkEmpUserList.add(lkEmpUserEntity);
		Set<Long> userId = new HashSet<Long>();
		userId.add(JunitConstants.LONG_TYPE);
		when(edpLkEmpUserRepository.findByUserIdUserIdIn(userId)).thenReturn(lkEmpUserList);
		when(entity.getDesignationId()).thenReturn(JunitConstants.LONG_TYPE);
		when(entity.getDesignationName()).thenReturn(JunitConstants.DESIGNATION_NAME);
		
		
		List<EDPMsDesignationEntity> designationList = new ArrayList<>();
		designationList.add(entity);
		when(repository.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(list);
		when(repository.findByActiveStatusEquals(Constant.ACTIVE_STATUS)).thenReturn(designationList);
		when(entity.getDesignationId()).thenReturn(JunitConstants.LONG_TYPE);
		when(entity.getDesignationName()).thenReturn(JunitConstants.STRING_TYPE);
		
		
		when(repository.findByStatusIdLookUpInfoNameOrStatusIdIsNullAndActiveStatus(EDPConstant.LK_STATUS_VAL_APPROVED,
				OAuthConstant.ACTIVE_STATUS,
				EDPUtility.getJpaSort(EDPConstant.DESIGNATION_NAME, EDPConstant.ORDER_ASC)))
						.thenReturn(designationList);
		assertNotNull(service.getUpdateDesignationDetailsDto(JunitConstants.LONG_TYPE));
		
		
		
	}

	/**
	 * Test findactiveedp ms designation.
	 */
	@Test
	void testFindactiveedpMsDesignation() {
		when(repository.findByActiveStatusEquals(Constant.ACTIVE_STATUS)).thenReturn(listEntity);
		assertNotNull(service.findactiveedpMsDesignation());
		verify(repository, times(1)).findByActiveStatusEquals(Constant.ACTIVE_STATUS);
	}

	/**
	 * Test search listfor upd dsg.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSearchListforUpdDsg() throws CustomException {
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.TRSN_NO);
		searchParam.setValue(JunitConstants.LONG_STRING_VALUE);
		List<SearchParam> searchParams = new ArrayList<>();
		searchParams.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(searchParams);
		when(pageDetail.getPageIndex()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(pageDetail.getPageElement()).thenReturn(JunitConstants.INTEGER_TYPE);
		Object o[] = new Object[11];
		o[0] = JunitConstants.LONG_TYPE;
		o[1] = JunitConstants.STRING_TYPE;
		o[2] = new Date();
		o[3] = JunitConstants.STRING_TYPE;
		o[4] = JunitConstants.STRING_TYPE;
		o[5] = JunitConstants.STRING_TYPE;
		o[6] = JunitConstants.STRING_TYPE;
		o[7] = JunitConstants.STRING_TYPE;
		o[8] = JunitConstants.STRING_TYPE;
		o[10] = JunitConstants.LONG_TYPE;
		List<Object[]> objectSp = new ArrayList<Object[]>();
		objectSp.add(o);
		when(edpTrnUpdDsgnRepository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(objectSp);
		assertNotNull(service.searchListforUpdDsg(pageDetail));
	}

	/**
	 * Test search listfor add designation.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSearchListforAddDesignation() throws CustomException {
		SearchParam sp = new SearchParam();
		sp.setKey(JunitConstants.STRING_TYPE);
		sp.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> spList = new ArrayList<>();
		spList.add(sp);
		when(pageDetail.getJsonArr()).thenReturn(spList);
		when(edpMsPostDto.getLkPoOffUserId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.searchListforAddDesignation(pageDetail));
	}

	/**
	 * Test update dsgn delete.
	 */
	@Test
	void testUpdateDsgnDelete() {
		when(edpTrnUpdDsgnRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(trnUpdDsgnEntity));
		when(edpMsPostDto.getPostId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpTrnUpdDsgnRepository.save(trnUpdDsgnEntity)).thenReturn(trnUpdDsgnEntity);
		assertTrue(service.updateDsgnDelete(JunitConstants.LONG_TYPE));
		when(edpTrnUpdDsgnRepository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		assertFalse(service.updateDsgnDelete(JunitConstants.LONG_TYPE));
	}

	/**
	 * Test update dsgn save.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testUpdateDsgnSave() throws CustomException {
		trnUpdDsgnEntity.setCreatedDate(new Date());
		when(edpTrnUpdDsgnRepository.getOne(Mockito.anyLong())).thenReturn(trnUpdDsgnEntity);
		when(edpTrnUpdDsgnConverter.toEntity(edpTrnUpdDsgnDto)).thenReturn(trnUpdDsgnEntity);
		when(edpTrnUpdDsgnDto.getMenuShCode()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpTrnUpdDsgnDto.getTrnNo()).thenReturn(JunitConstants.STRING_TYPE);
		when(trnUpdDsgnEntity.getDesignationId()).thenReturn(entity);
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(Constant.LOOKUP_TRUE_VALUE))
				.thenReturn(financialYearEntity);
		when(edpTrnUpdDsgnDto.getPostName()).thenReturn(JunitConstants.STRING_TYPE);
		EDPTrnUpdDsgnEntity edpTrnUpdDsgnEntity = new EDPTrnUpdDsgnEntity();
		edpTrnUpdDsgnEntity.setTrnNo(JunitConstants.SET_TRSN_NO);
		when(edpTrnUpdDsgnRepository.findTopByOrderByTedpUpdDsgnIdDesc()).thenReturn(edpTrnUpdDsgnEntity);
		when(financialYearEntity.getFyShort()).thenReturn(JunitConstants.FYSHORT);
		when(dto.getName()).thenReturn(JunitConstants.STRING_TYPE);
		when(dto.getTrnNo()).thenReturn(JunitConstants.STRING_TYPE);
		when(dto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsPostDto.getPostId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpTrnUpdDsgnRepository.save(trnUpdDsgnEntity)).thenReturn(trnUpdDsgnEntity);
		when(edpTrnUpdDsgnItrConverter.edpTrnUpdDsgnEntityToEntity(trnUpdDsgnEntity,edpTrnUpdDsgnDto)).thenReturn(edpTrnUpdDsgnItrEntity);
		when(edpTrnUpdDsgnItrRepository.save(edpTrnUpdDsgnItrEntity)).thenReturn(edpTrnUpdDsgnItrEntity);
		when(edpTrnUpdDsgnDto.getFormAction()).thenReturn(Status.SUBMITTED);
		when(trnUpdDsgnEntity.getPostId()).thenReturn(postEntity);
		when(postEntity.getPostId()).thenReturn(JunitConstants.LONG_TYPE);
		when(trnUpdDsgnEntity.getOfficeId()).thenReturn(officeEntity);
		when(officeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkPostOfficeRepository.save(edpLkPostOfficeEntity)).thenReturn(edpLkPostOfficeEntity);
		when(edpLkPostOfficeEntity.getPostOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkPoOffUserRepository.save(edpLkPoOffUserEntity)).thenReturn(edpLkPoOffUserEntity);
		when(edpLkPoOffUserEntity.getLkPoOffUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkPostOfficeRepository.findByPostEntityPostIdAndOfficeEntityOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,JunitConstants.INTEGER_TYPE))
			.thenReturn(Optional.of(edpLkPostOfficeEntity));
		when(edpLkPoOffUserRepository.findByLkPostOfficeIdPostOfficeId(JunitConstants.LONG_TYPE))
			.thenReturn(edpLkPoOffUserEntity);
		when(trnUpdDsgnEntity.getStatusId()).thenReturn(edpluLookUpInfoEntity);
		when(edpluLookUpInfoEntity.getLookUpInfoName()).thenReturn(EDPConstant.LK_STATUS_VAL_APPROVED);
		when(trnUpdDsgnEntity.getActivePostId()).thenReturn(postEntity);
		when(trnUpdDsgnEntity.getPostId()).thenReturn(postEntity);
		when(edpLkPoOffUserRepository.findByLkPostOfficeIdPostEntityPostIdAndActiveStatus(JunitConstants.LONG_TYPE,Constant.ACTIVE_STATUS))
				.thenReturn(edpLkPoOffUserEntity);
		when(edpLkPoOffUserRepository.findByLkPostOfficeIdPostOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
			.thenReturn(edpLkPoOffUserEntity);
		when(edpTrnUpdDsgnDto.isWfSaveDrftApiCall()).thenReturn(Boolean.FALSE);
		when(edpTrnUpdDsgnDto.getFormAction()).thenReturn(JunitConstants.STRING_SUBMITTED);
		List<Object[]> listObject = new ArrayList<Object[]>();
		Object ooo[] = new Object[11];
		ooo[0] = JunitConstants.INTEGER_TYPE;
		ooo[1] = JunitConstants.STRING_TYPE;
		ooo[10] = JunitConstants.INTEGER_TYPE_69;
		ooo[3] = JunitConstants.STRING_TYPE;
		ooo[4] = JunitConstants.STRING_TYPE;
		listObject.add(ooo);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(listObject);
		when(repository.findById(JunitConstants.DESIGNATION_ID)).thenReturn(Optional.of(entity));
		when(repository.getOne(Mockito.anyLong())).thenReturn(entity);
		when(edpTrnUpdDsgnDto.getCurMenuId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpTrnUpdDsgnDto.getTedpUpdDsgnId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpTrnUpdDsgnConverter.toDTO(trnUpdDsgnEntity)).thenReturn(edpTrnUpdDsgnDto);
		assertNotNull(service.updateDesignation(JunitConstants.TRUE, JunitConstants.TRUE, edpTrnUpdDsgnDto));
	
//		assertNotNull(service.updateDsgnSave(trnUpdDsgnEntity, JunitConstants.TRUE, JunitConstants.TRUE, edpTrnUpdDsgnDto));
		when(dto.getTrnNo()).thenReturn(JunitConstants.STRING_NULL);
		when(edpTrnUpdDsgnRepository.findTopByOrderByTedpUpdDsgnIdDesc()).thenReturn(null);
		when(trnUpdDsgnEntity.getDesignationId()).thenReturn(null);
		when(officeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkPostOfficeRepository.save(Mockito.any(EDPLkPostOfficeEntity.class))).thenReturn(edpLkPostOfficeEntity);
		when(trnUpdDsgnEntity.getEmpId()).thenReturn(edpEmployeEntity);
		when(edpEmployeEntity.getEmpId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkPoOffUserRepository.findByLkPostOfficeIdPostOfficeId(JunitConstants.LONG_TYPE)).thenReturn(null);
		when(edpLkPoOffUserRepository.save(Mockito.any(EDPLkPoOffUserEntity.class))).thenReturn(edpLkPoOffUserEntity);
		when(edpLkEmpUserRepository.findByEmpIdEmpId(JunitConstants.LONG_TYPE)).thenReturn(edpLkEmpUserEntity);
		when(trnUpdDsgnEntity.getStatusId()).thenReturn(edpluLookUpInfoEntity);
		when(edpluLookUpInfoEntity.getLookUpInfoName()).thenReturn(EDPConstant.LK_STATUS_VAL_APPROVED);
		when(edpLkPoOffUserEntity.getLkPoOffUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkPoOffUserRepository.updateActiveStatus(Mockito.any(Long.class), Mockito.any(Integer.class),
				Mockito.any(Long.class), Mockito.any(Date.class))).thenReturn(JunitConstants.INTEGER_TYPE);
		when(edpLkPostOfficeRepository.findByPostEntityPostIdAndOfficeEntityOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE))
			.thenReturn(Optional.of(edpLkPostOfficeEntity));
		assertNotNull(service.updateDsgnSave(trnUpdDsgnEntity, JunitConstants.FALSE, JunitConstants.TRUE, edpTrnUpdDsgnDto));
		when(edpluLookUpInfoEntity.getLookUpInfoName()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpTrnUpdDsgnDto.getFormAction()).thenReturn(Status.DRAFT);
		when(edpTrnUpdDsgnDto.getPostId()).thenReturn(JunitConstants.LONG_NULL);
		assertNotNull(service.updateDsgnSave(trnUpdDsgnEntity, JunitConstants.TRUE, JunitConstants.TRUE, edpTrnUpdDsgnDto));

		when(edpTrnUpdDsgnDto.isWfSaveDrftApiCall()).thenReturn(JunitConstants.TRUE);
		edpTrnUpdDsgnDto.setMenuShCode("ABD");
		assertNotNull(service.updateDesignation(JunitConstants.TRUE, JunitConstants.TRUE, edpTrnUpdDsgnDto));

	}

	/**
	 * Test get post details by designtion id.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testGetPostDetailsByDesigntionId() throws Exception {
		when(dto.getTrnNo()).thenReturn(JunitConstants.STRING_TYPE);
		when(dto.getDesignationId()).thenReturn(JunitConstants.LONG_TYPE);
		when(dto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPTrnUpdDsgnItrEntity> itrEntityList = new ArrayList<>();
		itrEntityList.add(edpTrnUpdDsgnItrEntity);
		when(edpTrnUpdDsgnItrRepository.findByTrnNoAndDesignationIdDesignationId(JunitConstants.STRING_TYPE,
				JunitConstants.LONG_TYPE)).thenReturn(null);
		when(edpMsPostRepository.findPostCountBasedOnPost(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(JunitConstants.STRING_OPTIONAL));
		when(edpMsPostRepository.findPostCountBasedOnPostItr(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(JunitConstants.STRING_OPTIONAL));
		when(edpMsPostRepository.findPostCoundInItrByThreeDigit(JunitConstants.DESIGNATION_ID, JunitConstants.LONG_OFFICE_ID,
				JunitConstants.STRING_TYPE)).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getPostDetailsByDesigntionId(dto));
		when(edpMsPostRepository.findPostCountBasedOnPost(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.empty());
		assertNotNull(service.getPostDetailsByDesigntionId(dto));
		when(edpMsPostRepository.findPostCountBasedOnPost(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(JunitConstants.STRING_OPTIONAL));
		when(edpMsPostRepository.findPostCountBasedOnPostItr(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.empty());
		assertNotNull(service.getPostDetailsByDesigntionId(dto));
		when(edpMsPostRepository.findPostCountBasedOnPost(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(JunitConstants.STRING_OPTIONAL));
		when(edpMsPostRepository.findPostCountBasedOnPostItr(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of("21"));
		assertNotNull(service.getPostDetailsByDesigntionId(dto));
		when(dto.getTrnNo()).thenReturn(JunitConstants.STRING_TYPE);
		when(dto.getDesignationId()).thenReturn(JunitConstants.LONG_TYPE);
		itrEntityList.add(edpTrnUpdDsgnItrEntity);
		when(edpTrnUpdDsgnItrRepository.findByTrnNoAndDesignationIdDesignationIdAndOfficeIdOfficeId(JunitConstants.STRING_TYPE,
				JunitConstants.LONG_TYPE,JunitConstants.LONG_TYPE)).thenReturn(itrEntityList);
		when(edpTrnUpdDsgnItrEntity.getPostId()).thenReturn(postEntity);
		assertNotNull(service.getPostDetailsByDesigntionId(dto));
		when(dto.getTrnNo()).thenReturn(null);
		assertNotNull(service.getPostDetailsByDesigntionId(dto));
		
		when(edpMsPostRepository.findPostCoundInItrByThreeDigit(Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyString())).thenReturn(null);
		when(edpMsPostRepository.findPostCoundInItrByTwoDigit(Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyString())).thenReturn(null);
		when(edpMsPostRepository.findPostNameInItr(Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyString())).thenReturn(null);

		when(edpMsPostRepository.findPostCoundInByThreeDigit(Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyString())).thenReturn(null);
		when(edpMsPostRepository.findPostCoundInByTwoDigit(Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyString())).thenReturn(null);
		when(edpMsPostRepository.findPostNameIn(Mockito.anyLong(), Mockito.anyLong(),
				Mockito.anyString())).thenReturn(null);
		assertNotNull(service.getPostDetailsByDesigntionId(dto));	
		
	}
	
	/**
	 * Test get clue dto for post name.
	 */
	@Test
	void testGetClueDtoForPostName() {
		when(edpTrnUpdDsgnDto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpTrnUpdDsgnDto.getDesignationId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpTrnUpdDsgnDto.getTrnNo()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(service.getClueDtoForPostName(edpTrnUpdDsgnDto));
	}
	
	/**
	 * Test get valid post name.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testGetValidPostName() throws CustomException {
		when(edpTrnUpdDsgnDto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpTrnUpdDsgnDto.getDesignationId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpTrnUpdDsgnDto.getTrnNo()).thenReturn(JunitConstants.STRING_TYPE);
		List<EDPTrnUpdDsgnItrEntity> edpTrnUpdDsgnItrEntityList = new ArrayList<>();
		edpTrnUpdDsgnItrEntityList.add(edpTrnUpdDsgnItrEntity);
		when(edpTrnUpdDsgnItrRepository.findByTrnNoAndDesignationIdDesignationIdAndOfficeIdOfficeId(JunitConstants.STRING_TYPE, 
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE)).thenReturn(edpTrnUpdDsgnItrEntityList);
		when(edpTrnUpdDsgnItrEntity.getPostId()).thenReturn(postEntity);
		when(postEntity.getPostId()).thenReturn(JunitConstants.LONG_TYPE);
		when(postEntity.getPostName()).thenReturn(JunitConstants.STRING_TYPE);
		when(dto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(dto.getName()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(service.getValidPostName(edpTrnUpdDsgnDto));
		
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
		objes[0] = JunitConstants.LONG_NULL;
		objes[2] = JunitConstants.LONG_NULL;
		objes[3] = JunitConstants.LONG_NULL;
		objes[1] = JunitConstants.LONG_NULL;
		obj.add(objes);
		when(districtRepository.findByActiveStatusAndStateId(Mockito.anyInt(),Mockito.anyLong(),Mockito.any())).thenReturn(objectList);
		when(repository.executeNativeSQLQuery(Mockito.any(),Mockito.any())).thenReturn(obj);
		assertNotNull(service.getListingFilterData());
	}
	
	@Test
	public void getListingFilterDataForUpd() throws CustomException {
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
		assertNotNull(service.getListingFilterDataForUpd());
		objes[0] = JunitConstants.LONG_NULL;
		objes[2] = JunitConstants.LONG_NULL;
		objes[3] = JunitConstants.LONG_NULL;
		objes[1] = JunitConstants.LONG_NULL;
		obj.add(objes);
		when(districtRepository.findByActiveStatusAndStateId(Mockito.anyInt(),Mockito.anyLong(),Mockito.any())).thenReturn(objectList);
		when(repository.executeNativeSQLQuery(Mockito.any(),Mockito.any())).thenReturn(obj);
		assertNotNull(service.getListingFilterDataForUpd());
	}
	
//	@Test
	public void updateDesignation() throws CustomException {
		when(edpTrnUpdDsgnDto.getDesignationId()).thenReturn(JunitConstants.LONG_NULL);
		when(edpTrnUpdDsgnDto.getDesignationName()).thenReturn(JunitConstants.STRING_TYPE);
		when(repository.findByDesignationNameIgnoreCaseAndActiveStatus(JunitConstants.STRING_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(listEntity);
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(Constant.LOOKUP_TRUE_VALUE))
				.thenReturn(financialYearEntity);
		when(listEntity.isEmpty()).thenReturn(JunitConstants.TRUE);
		when(repository.findTopByOrderByDesignationIdDesc()).thenReturn(entity);
		when(financialYearEntity.getFyShort()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpTrnUpdDsgnConverter.toEntity(edpTrnUpdDsgnDto)).thenReturn(trnUpdDsgnEntity);
		when(repository.save(entity)).thenReturn(entity);
		when(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(edpluLookUpInfoEntity);
		when(edpTrnUpdDsgnDto.isWfSaveDrftApiCall()).thenReturn(Boolean.FALSE);
		when(edpTrnUpdDsgnDto.getFormAction()).thenReturn(JunitConstants.STRING_SUBMITTED);
		List<Object[]> listObject = new ArrayList<Object[]>();
		Object ooo[] = new Object[11];
		ooo[0] = JunitConstants.INTEGER_TYPE;
		ooo[1] = JunitConstants.STRING_TYPE;
		ooo[10] = JunitConstants.INTEGER_TYPE_69;
		ooo[3] = JunitConstants.STRING_TYPE;
		ooo[4] = JunitConstants.STRING_TYPE;
		listObject.add(ooo);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(listObject);
		when(edpTrnUpdDsgnRepository.save(trnUpdDsgnEntity)).thenReturn(trnUpdDsgnEntity);
		when(edpTrnUpdDsgnDto.getActivePostId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsPostRepository.getOne(JunitConstants.LONG_TYPE)).thenReturn(postEntity);
		when(edpTrnUpdDsgnItrConverter.edpTrnUpdDsgnEntityToEntity(trnUpdDsgnEntity, edpTrnUpdDsgnDto)).thenReturn(edpTrnUpdDsgnItrEntity);
		when(trnUpdDsgnEntity.getActivePostId()).thenReturn(postEntity);
		when(trnUpdDsgnEntity.getPostId()).thenReturn(postEntity);
		when(trnUpdDsgnEntity.getOfficeId()).thenReturn(officeEntity);
		when(officeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(trnUpdDsgnEntity.getActivePostId()).thenReturn(postEntity);
		when(postEntity.getPostId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkPostOfficeRepository.findByPostEntityPostIdAndOfficeEntityOfficeIdAndActiveStatus(JunitConstants.LONG_TYPE,JunitConstants.LONG_TYPE,JunitConstants.INTEGER_TYPE)).thenReturn(Optional.of(edpLkPostOfficeEntity));
		when(trnUpdDsgnEntity.getStatusId()).thenReturn(edpluLookUpInfoEntity);
		when(edpluLookUpInfoEntity.getLookUpInfoName()).thenReturn(JunitConstants.STRING_APPROVED);
		assertNotNull(service.updateDesignation(Boolean.TRUE, Boolean.TRUE, edpTrnUpdDsgnDto));

	}
	

	/**
	 * Gets the upd dsgn by id.
	 *
	 * @return the upd dsgn by id
	 * @throws CustomException the custom exception
	 */
	@Test
	public void getUpdDsgnById() throws CustomException {
		postEntity.setPostId(1l);
		when(edpMsPostRepository.getOne(Mockito.anyLong())).thenReturn(postEntity);
		entity.setDesignationId(1l);
		postEntity.setDesignationId(entity);
		when(postEntity.getDesignationId()).thenReturn(entity);
		when(edpTrnUpdDsgnRepository.getOne(JunitConstants.LONG_TYPE)).thenReturn(trnUpdDsgnEntity);
		when(edpTrnUpdDsgnConverter.toDTO(trnUpdDsgnEntity)).thenReturn(edpTrnUpdDsgnDto);
		List<Object> obj = new ArrayList<>();
		Object[] objes = new Object[5];
		objes[0] = 1;
		objes[2] = 1;
		objes[3] = 1;
		objes[1] = 1;
		obj.add(objes);
		when(edpTrnUpdDsgnRepository.executeNativeSQLQuery(Mockito.any(),Mockito.any())).thenReturn(obj);
		
		List<Object[]> obj1 = new ArrayList<>();
		Object[] objes1 = new Object[5];
		objes1[0] = 1;
		objes1[2] = 1;
		objes1[3] = 1;
		objes1[1] = 1;
		obj.add(objes1);
		when(repository.callStoredProcedure(Mockito.anyString(),Mockito.anyMap())).thenReturn(obj1);
		assertNotNull(service.getUpdDsgnById(JunitConstants.LONG_TYPE));
		
	}

	/**
	 * Test get ms designation.
	 */
	@Test
	void testGetMsDesignation() {
		
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(desigDto);
		when(desigDto.isWfInRequest()).thenReturn(JunitConstants.TRUE);
		List<Object> listObject = new ArrayList<Object>();
		Object obj = JunitConstants.INTEGER_TYPE;
		listObject.add(obj);
		
		when(repository.executeNativeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(listObject);
		assertNotNull(service.getMsDesignation(JunitConstants.LONG_TYPE));
		
		when(desigDto.isWfInRequest()).thenReturn(JunitConstants.FALSE);
		assertNotNull(service.getMsDesignation(JunitConstants.LONG_TYPE));
		
	}
	
	@Test
	void testDesignationNameFromId() {
		when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(entity));
		when(entity.getDesignationName()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(service.designationNameFromId(JunitConstants.LONG_TYPE));
	}
	
	@Test
	void testDeActiveLkPostOffice() {
		when(edpLkPostOfficeRepository.deleteLkPostOffice(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyLong(), Mockito.any(Date.class))).thenReturn(JunitConstants.INTEGER_TYPE);
		assertNotNull(service.deActiveLkPostOffice(JunitConstants.LONG_TYPE));		
	}
	
	@Test
	void testGetDefultEDPLkPostOfficeEntity() {
		when(trnUpdDsgnEntity.getPostId()).thenReturn(postEntity);
		when(trnUpdDsgnEntity.getOfficeId()).thenReturn(officeEntity);
		assertNotNull(service.getDefultEDPLkPostOfficeEntity(trnUpdDsgnEntity));
	}
	
	@Test
	void testCheckUpdateDesignationRequestExists() throws CustomException {
		HashMap<String, Object> argMap = new HashMap<>();
		argMap.put(Constant.IN_POST_ID,JunitConstants.LONG_TYPE);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.CHECK_UPD_DESIGNATION_REQUEST_EXISTS));
		when(repository.callStoredProcedure(procName, argMap)).thenReturn(Collections.emptyList());
		service.checkUpdateDesignationRequestExists(JunitConstants.LONG_TYPE);
		verify(repository, times(1)).callStoredProcedure(procName, argMap);
	}
	
	@Test
	void testInsertOrUpdateDataInLkTabel() {
		when(edpLkPostOfficeRepository.findByPostEntityPostIdAndOfficeEntityOfficeIdAndActiveStatus(Mockito.anyLong(), Mockito.anyLong(),Mockito.anyInt()))
		.thenReturn(Optional.empty());
		when(trnUpdDsgnEntity.getPostId()).thenReturn(postEntity);
		when(trnUpdDsgnEntity.getOfficeId()).thenReturn(officeEntity);
		when(trnUpdDsgnEntity.getStatusId()).thenReturn(edpluLookUpInfoEntity);
		when(edpluLookUpInfoEntity.getLookUpInfoName()).thenReturn(EDPConstant.LK_STATUS_VAL_APPROVED);
		service.insertOrUpdateDataInLkTabel(trnUpdDsgnEntity, edpLkPostOfficeEntity);
		verify(edpLkPostOfficeRepository, times(2)).save(edpLkPostOfficeEntity);
	}
}