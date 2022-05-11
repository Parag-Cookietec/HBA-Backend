package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
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
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.converter.EDPMsPostConverter;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.dto.EDPPostCountDTO;
import gov.ifms.edp.dto.EDPPostHistoryReportView;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPPostItrEntity;
import gov.ifms.edp.oauth.dto.OAuthTokenPostDTO;
import gov.ifms.edp.repository.EDPLkPostOfficeRepository;
import gov.ifms.edp.repository.EDPLkPostUserRepository;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;
import gov.ifms.edp.repository.EDPMsPostRepository;
import gov.ifms.edp.repository.EDPPostItrRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.workflow.service.EDPWorkflowRequestHandler;

/**
 * The Class EDPMsPostServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsPostServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPMsPostServiceImpl service;

	/** The repository. */
	@Mock
	private EDPMsPostRepository repository;

	/** The entity. */
	@Mock
	private EDPMsPostEntity entity;

	/** The dto. */
	@Mock
	private EDPMsPostDto dto;

	/** The entities. */
	@Mock
	private List<EDPMsPostEntity> entities;

	/** The id list. */
	@Mock
	private Set<Long> idList;

	/** The id dto. */
	@Mock
	private IdDto idDto;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;

	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsPostEntity> spec;
	
	@Mock
	private Specification<EDPMsPostEntity> empSpec;

	@Mock
	private Specification<EDPPostHistoryReportView> his;
	
	@Mock
	private Specification<EDPPostHistoryReportView> repo;

	

	/** The pageable. */
	@Mock
	private PageRequest pageable;

	/** The page. */
	@Mock
	private Page<EDPMsPostEntity> page;

	/** The converter. */
	@Mock
	private EDPMsPostConverter converter;

	/** The financial year repository. */
	@Mock
	private EDPMsFinancialYearRepository financialYearRepository;

	/** The financial year entity. */
	@Mock
	private EDPMsFinancialYearEntity financialYearEntity;

	/** The lookupinforepository. */
	@Mock
	private EDPLuLookUpInfoRepository lookupinforepository;

	/** The edp lu look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	/** The edp post itr repository. */
	@Mock
	private EDPPostItrRepository edpPostItrRepository;

	/** The edp lk post office repository. */
	@Mock
	private EDPLkPostOfficeRepository edpLkPostOfficeRepository;

	/** The edp lk post user repository. */
	@Mock
	private EDPLkPostUserRepository edpLkPostUserRepository;

	/** The edp post itr entity. */
	@Mock
	private EDPPostItrEntity edpPostItrEntity;

	/** The edp ms user service. */
	@Mock
	private EDPMsUserService edpMsUserService;

	/** The Id dto. */
	@Mock
	private IdDto IdDto;

	/** The o auth dto. */
	@Mock
	private OAuthTokenPostDTO oAuthDto;

	/** The count dto. */
	@Mock
	private EDPPostCountDTO countDto;

	/** The edp ms office entity. */
	@Mock
	private EDPMsOfficeEntity edpMsOfficeEntity;

	/** The edp ms district entity. */
	@Mock
	private EDPMsDistrictEntity edpMsDistrictEntity;

	/** The edp lk post office entity. */
	@Mock
	private EDPLkPostOfficeEntity edpLkPostOfficeEntity;

	/** The edp ms designation service. */
	@Mock
	private EDPMsDesignationService edpMsDesignationService;

	/** The objects entities. */
	@Mock
	private List<Object[]> objectsEntities;

	/** The edpms designationrepository. */
	@Mock
	private EDPMsDesignationRepository edpmsDesignationrepository;

	/** The edp ms designation entity. */
	@Mock
	private EDPMsDesignationEntity edpMsDesignationEntity;

	@Mock
	private EDPLkPoOffUserEntity eDPLkPoOffUserEntity;
	
	@Mock
	private EDPMsDistrictRepository districtRepository;

	@Mock
	private EDPMsDistrictConverter districtConverter;
	
	@Mock
	private EDPPostHistoryReportView eDPPostHistoryReportView;
	
	@Mock
	private EDPWorkflowRequestHandler wfRequestHandler;

	@Mock
	private EDPMsDistrictRepository edpMsDistrictRepository;
	
	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms posts.
	 */
	@Test
	void testGetMsPosts() {
		when(repository.findAll()).thenReturn(entities);
		assertNotNull(service.getMsPosts());
		verify(repository).findAll();
	}

	/**
	 * Test get ms post.
	 */
	@Test
	void testGetMsPost() {
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(entity));
		when(converter.toDTO(Optional.of(entity).get())).thenReturn(dto);
		List<EDPLkPostOfficeEntity> edpLkPostOfficeEntityList = new ArrayList<EDPLkPostOfficeEntity>();
		when(Optional.of(entity).get().getPostId()).thenReturn(JunitConstants.LONG_TYPE);
		when(Optional.of(entity).get().getInitiatedBy()).thenReturn(eDPLkPoOffUserEntity);
		when(eDPLkPoOffUserEntity.getLkPostOfficeId()).thenReturn(edpLkPostOfficeEntity);
		when(edpLkPostOfficeEntity.getOfficeEntity()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkPostOfficeRepository.findByPostEntityPostIdAndActiveStatus(JunitConstants.LONG_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(edpLkPostOfficeEntity);
		when(edpLkPostOfficeEntity.getOfficeEntity()).thenReturn(edpMsOfficeEntity);
		EDPLkPostOfficeEntity edpLkPostOfficeEntity1 = new EDPLkPostOfficeEntity();
		edpLkPostOfficeEntity1.setPostOfficeId(JunitConstants.LONG_TYPE);
		EDPMsOfficeEntity office = new EDPMsOfficeEntity();
		office.setOfficeId(JunitConstants.LONG_TYPE);
		office.setCardexno(JunitConstants.LONG_TYPE);
		office.setDdoNo(JunitConstants.STRING_TYPE);
		office.setOfficeName(JunitConstants.STRING_TYPE);
		EDPMsDistrictEntity districtEntity = new EDPMsDistrictEntity();
		districtEntity.setDistrictId(5l);
		office.setDistrictId(districtEntity);
		edpLkPostOfficeEntity1.setOfficeEntity(office);
		edpLkPostOfficeEntityList.add(edpLkPostOfficeEntity1);
		when(edpMsOfficeEntity.getCardexno()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsOfficeEntity.getDdoNo()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpMsOfficeEntity.getOfficeName()).thenReturn(JunitConstants.STRING_TYPE);
		when(edpMsDistrictEntity.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.getMsPost(idDto));
		office.setDistrictId(null);
		assertNotNull(service.getMsPost(idDto));
		when(edpMsDistrictEntity.getDistrictId()).thenReturn(JunitConstants.LONG_NULL);
		edpLkPostOfficeEntity1.setOfficeEntity(null);
		assertNotNull(service.getMsPost(idDto));
		assertNotNull(service.getMsPost(idDto));
		when(edpLkPostOfficeRepository.findByActiveStatusAndPostEntityPostId(Constant.ACTIVE_STATUS,
				JunitConstants.LONG_TYPE)).thenReturn(null);
		assertNotNull(service.getMsPost(idDto));

		List<Object> listObject = new ArrayList<Object>();
		Object obj = JunitConstants.INTEGER_TYPE;
		listObject.add(obj);
		
		when(dto.getWfInRequest()).thenReturn(JunitConstants.TRUE);
		when(repository.executeNativeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(listObject);
		assertNotNull(service.getMsPost(idDto));

		when(repository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		assertNull(service.getMsPost(idDto));

		when(idDto.getId()).thenReturn(JunitConstants.LONG_NULL);
		assertNull(service.getMsPost(idDto));

	}

	/**
	 * Test save ms posts.
	 */
	@Test
	void testSaveMsPosts() {
		when(repository.saveAll(entities)).thenReturn(entities);
		assertNotNull(service.saveMsPosts(entities));
		verify(repository).saveAll(entities);
	}

	/**
	 * Test edp ms post as method name search.
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testEdpMsPostAsMethodNameSearch() {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.STRING_TYPE);
		searchParam.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> list = new ArrayList<>();
		list.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(list);
		when(searchCriteria.getSpecificationDetails(spec, list)).thenReturn(empSpec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.edpMsPostAsMethodNameSearch(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

	/**
	 * Test get EDP ms post by post id.
	 */
	@Test
	void testGetEDPMsPostByPostId() {
		when(repository.findByPostIdIn(idList)).thenReturn(entities);
		assertNotNull(service.getEDPMsPostByPostId(idList));
		verify(repository).findByPostIdIn(idList);
	}

	/**
	 * Test save ms post.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSaveMsPost() throws CustomException {
		when(dto.getMenucode()).thenReturn("CNP");
		when(dto.getIsObjectionRequired()).thenReturn(true);
		when(dto.getIsWfSubmit()).thenReturn(true);
		when(dto.getWfInRequest()).thenReturn(true);
		when(dto.getFormAction()).thenReturn(Status.SUBMITTED);
		when(converter.toEntity(dto)).thenReturn(entity);
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(Constant.LOOKUP_TRUE_VALUE))
				.thenReturn(financialYearEntity);
		when(repository.findTopByPostIdAndTransactionNoIsNotNullOrderByPostIdDesc())
				.thenReturn(Optional.of(JunitConstants.SET_TRSN_NO));
		when(financialYearEntity.getFyShort()).thenReturn(JunitConstants.STRING_TYPE);
		when(lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT)).thenReturn(edpLuLookUpInfoEntity);
		when(repository.save(entity)).thenReturn(entity);
		when(entity.getPostId()).thenReturn(JunitConstants.LONG_TYPE);
		when(entity.getStatusId()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(converter.toItrEntity(dto)).thenReturn(edpPostItrEntity);
		when(edpPostItrRepository.save(edpPostItrEntity)).thenReturn(edpPostItrEntity);
		when(dto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(lookupinforepository.findByLookUpInfoName(Constant.LOOKUP_YES)).thenReturn(edpLuLookUpInfoEntity);
		when(edpLkPostOfficeRepository.save(edpLkPostOfficeEntity)).thenReturn(edpLkPostOfficeEntity);
		when(converter.toDTO(entity)).thenReturn(dto);
		List<Object[]> listObject = new ArrayList<Object[]>();
		Object ooo[] = new Object[11];
		ooo[0] = JunitConstants.INTEGER_TYPE;
		ooo[1] = JunitConstants.STRING_TYPE;
		ooo[10] = JunitConstants.INTEGER_TYPE_69;
		ooo[3] = JunitConstants.STRING_TYPE;
		ooo[4] = JunitConstants.STRING_TYPE;
		listObject.add(ooo);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(listObject);
		assertNotNull(service.saveMsPost(dto));
		when(repository.findTopByPostIdAndTransactionNoIsNotNullOrderByPostIdDesc()).thenReturn(Optional.empty());
		assertNotNull(service.saveMsPost(dto));
		when(dto.getFormAction()).thenReturn(Status.SUBMITTED);
		when(lookupinforepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED))
				.thenReturn(edpLuLookUpInfoEntity);
		assertNotNull(service.saveMsPost(dto));
	}

	/**
	 * Test update ms post.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testUpdateMsPost() throws CustomException {
		when(dto.getPostId()).thenReturn(JunitConstants.LONG_TYPE);
		when(entity.getInitiatedBy()).thenReturn(eDPLkPoOffUserEntity);
		when(eDPLkPoOffUserEntity.getLkPoOffUserId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(entity));
		when(Optional.of(entity).get().getStatusId()).thenReturn(edpLuLookUpInfoEntity);
		when(converter.toEntity(dto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(converter.toItrEntity(dto)).thenReturn(edpPostItrEntity);
		when(edpPostItrRepository.save(edpPostItrEntity)).thenReturn(edpPostItrEntity);
		when(converter.toDTO(entity)).thenReturn(dto);
		when(lookupinforepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_SAVAS_DRAFT))
				.thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		List<EDPLkPostOfficeEntity> postOfficeList = new ArrayList<>();
		postOfficeList.add(edpLkPostOfficeEntity);
		when(dto.getPostName()).thenReturn(JunitConstants.STRING_TYPE);
		when(dto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkPostOfficeRepository.findByPostEntityPostNameAndOfficeEntityOfficeId(JunitConstants.STRING_TYPE,
				JunitConstants.LONG_TYPE)).thenReturn(postOfficeList);
		when(dto.getDesignationId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpmsDesignationrepository.findByActiveStatusAndDesignationId(Constant.ACTIVE_STATUS,
				JunitConstants.LONG_TYPE)).thenReturn(Optional.of(edpMsDesignationEntity));
		when(entity.getTransactionNo()).thenReturn(JunitConstants.SET_TRSN_NO);
		when(lookupinforepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED))
				.thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
		when(dto.getFormAction()).thenReturn(Status.SUBMITTED);
		when(edpmsDesignationrepository.getOne(JunitConstants.LONG_TYPE)).thenReturn(edpMsDesignationEntity);
		when(edpMsDesignationEntity.getDesignationName()).thenReturn(JunitConstants.STRING_TYPE);
		when(repository.findPostCoundInItrByThreeDigit(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE,
				JunitConstants.STRING_TYPE + EDPConstant.ARG_LIKE_OPER)).thenReturn(JunitConstants.LONG_TYPE);
		when(countDto.getCount()).thenReturn(JunitConstants.LONG_TYPE);
		when(entity.getPostId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkPostOfficeRepository.findByActiveStatusAndPostEntityPostId(Constant.ACTIVE_STATUS,
				JunitConstants.LONG_TYPE)).thenReturn(postOfficeList);
		when(edpLkPostOfficeRepository.deleteLkPostOffice(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyLong(),
				Mockito.any(Date.class))).thenReturn(JunitConstants.INTEGER_TYPE);
		when(lookupinforepository.findByLookUpInfoName(Constant.LOOKUP_YES)).thenReturn(edpLuLookUpInfoEntity);
		when(edpLkPostOfficeRepository.save(edpLkPostOfficeEntity)).thenReturn(edpLkPostOfficeEntity);
		when(dto.getWfInRequest()).thenReturn(JunitConstants.TRUE);
		assertNotNull(service.updateMsPost(dto));

		when(dto.getFormAction()).thenReturn(Status.DRAFT);
		assertNotNull(service.updateMsPost(dto));
		
		when(dto.getWfInRequest()).thenReturn(JunitConstants.FALSE);
		when(dto.getFormAction()).thenReturn(Status.SUBMITTED);
		when(dto.getCurMenuId()).thenReturn(JunitConstants.LONG_TYPE);
		when(dto.getPostId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.updateMsPost(dto));
		
	}

	/**
	 * Test delete ms post.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testDeleteMsPost() throws CustomException {
		when(repository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.of(entity));
		List<EDPLkPostOfficeEntity> list = new ArrayList<>();
		list.add(edpLkPostOfficeEntity);
		when(edpLkPostOfficeRepository.findByActiveStatusAndPostEntityPostId(Constant.ACTIVE_STATUS,
				JunitConstants.LONG_TYPE)).thenReturn(list);
		when(Optional.of(entity).get().getActiveStatus()).thenReturn(JunitConstants.INTEGER_TYPE);
		service.deleteMsPost(JunitConstants.LONG_TYPE);
		when(edpLkPostOfficeRepository.findByActiveStatusAndPostEntityPostId(Constant.ACTIVE_STATUS,
				JunitConstants.LONG_TYPE)).thenReturn(null);
		when(repository.findById(JunitConstants.LONG_TYPE)).thenReturn(Optional.empty());
		service.deleteMsPost(JunitConstants.LONG_TYPE);
		verify(repository, times(1)).save(Optional.of(entity).get());
	}

	/**
	 * Test getpost andofficedetails.
	 */
	@Test
	void testGetpostAndofficedetails() {
		when(edpMsDistrictRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(edpMsDistrictEntity));
		when(edpMsDistrictEntity.getDistrictId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpMsDistrictEntity.getDistrictName()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(service.getpostAndofficedetails());
	}

	/**
	 * Test search listfor posts.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSearchListforPosts() throws CustomException {
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.TRSN_NO);
		searchParam.setValue(JunitConstants.LONG_STRING_VALUE);
		List<SearchParam> searchParams = new ArrayList<SearchParam>();
		searchParams.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(searchParams);
		when(financialYearRepository.findByIsCurrentYearLookUpInfoValue(Constant.LOOKUP_TRUE_VALUE))
				.thenReturn(financialYearEntity);
		when(financialYearEntity.getFyShort()).thenReturn(JunitConstants.FYSHORT);
		assertNotNull(service.searchListforPosts(pageDetail));
		when(pageDetail.getJsonArr()).thenReturn(Collections.emptyList());
		assertNotNull(service.searchListforPosts(pageDetail));
	}

	/**
	 * Test get post count.
	 */
	@Test
	void testGetPostCount() {
		when(countDto.getDesignationId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpmsDesignationrepository.getOne(countDto.getDesignationId())).thenReturn(edpMsDesignationEntity);
		when(edpMsDesignationEntity.getDesignationName()).thenReturn(JunitConstants.STRING_TYPE);
		when(countDto.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findPostCoundInItrByThreeDigit(JunitConstants.LONG_TYPE, countDto.getOfficeId(),
				edpMsDesignationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER))
						.thenReturn(JunitConstants.LONG_TYPE);
		when(countDto.getPostId()).thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findPostCountBasedOnPost(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(JunitConstants.STRING_OPTIONAL));
		when(repository.findPostCountBasedOnPostItr(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(JunitConstants.STRING_OPTIONAL));
		List<EDPPostItrEntity> postItrEntityList = new ArrayList<>();
		postItrEntityList.add(edpPostItrEntity);
		when(edpPostItrRepository.findByPostIdAndDesignationIdDesignationIdAndOfficeId(JunitConstants.LONG_TYPE,
				JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE)).thenReturn(postItrEntityList);
		when(edpPostItrEntity.getPostName()).thenReturn(JunitConstants.STRING_OPTIONAL);
		List<EDPLkPostOfficeEntity> poOfficeEntityList = new ArrayList<>();
		poOfficeEntityList.add(edpLkPostOfficeEntity);
		when(edpLkPostOfficeRepository.findByPostEntityPostId(JunitConstants.LONG_TYPE)).thenReturn(poOfficeEntityList);
		when(edpLkPostOfficeEntity.getOfficeEntity()).thenReturn(edpMsOfficeEntity);
		when(edpMsOfficeEntity.getOfficeId()).thenReturn(JunitConstants.LONG_TYPE);
		assertNotNull(service.getPostCount(countDto));
		when(repository.findPostCoundInItrByThreeDigit(countDto.getDesignationId(), countDto.getOfficeId(),
				edpMsDesignationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER))
						.thenReturn(JunitConstants.LONG_ZERO);
		when(repository.findPostCoundInItrByTwoDigit(JunitConstants.LONG_TYPE, countDto.getOfficeId(),
				edpMsDesignationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER))
						.thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findPostNameInItr(countDto.getDesignationId(), countDto.getOfficeId(),
				edpMsDesignationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER))
						.thenReturn(JunitConstants.STRING_TYPE);
		when(repository.findPostCoundInByTwoDigit(countDto.getDesignationId(), countDto.getOfficeId(),
				edpMsDesignationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER))
						.thenReturn(JunitConstants.LONG_NULL);
		assertNotNull(service.getPostCount(countDto));
		when(repository.findPostCoundInItrByTwoDigit(JunitConstants.LONG_TYPE, countDto.getOfficeId(),
				edpMsDesignationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER))
						.thenReturn(JunitConstants.LONG_NULL);
		when(repository.findPostCoundInByTwoDigit(countDto.getDesignationId(), countDto.getOfficeId(),
				edpMsDesignationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER))
						.thenReturn(JunitConstants.LONG_TYPE);
		when(repository.findPostNameInItr(countDto.getDesignationId(), countDto.getOfficeId(),
				edpMsDesignationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER))
						.thenReturn(JunitConstants.STRING_NULL);
		when(repository.findPostCountBasedOnPost(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.of(JunitConstants.STRING_TYPE));
		when(repository.findPostCountBasedOnPostItr(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.empty());
		when(countDto.getPostId()).thenReturn(JunitConstants.LONG_NULL);
		assertNotNull(service.getPostCount(countDto));
		when(repository.findPostNameInItr(countDto.getDesignationId(), countDto.getOfficeId(),
				edpMsDesignationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER))
						.thenReturn(JunitConstants.STRING_TYPE);
		when(repository.findPostCountBasedOnPost(JunitConstants.LONG_TYPE, JunitConstants.LONG_TYPE))
				.thenReturn(Optional.empty());
		when(countDto.getPostId()).thenReturn(JunitConstants.DESIGNATION_ID);
		when(repository.findPostCoundInItrByTwoDigit(JunitConstants.LONG_TYPE, countDto.getOfficeId(),
				edpMsDesignationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER))
						.thenReturn(JunitConstants.LONG_NULL);
		when(repository.findPostCoundInByTwoDigit(countDto.getDesignationId(), countDto.getOfficeId(),
				edpMsDesignationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER))
						.thenReturn(JunitConstants.LONG_NULL);
		assertNotNull(service.getPostCount(countDto));
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
	
	@Test 
	void testSearchForPostHistoryReport() throws CustomException
	{
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
		PagebleDTO<EDPPostHistoryReportView> data = service.searchForPostHistoryReport(pageDetail);
		assertNotNull(data);
	
	}
	
	@Test
	void testAvilableVacantPost()
	{
		when(idDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(edpLkPostUserRepository.findVacantPost(JunitConstants.LONG_TYPE,
				EDPConstant.ARG_POST_VACANT_YES, Constant.ACTIVE_STATUS, EDPConstant.STATUS_APPROVED_ID)).thenReturn(objectsEntities);
        assertNotNull(service.avilableVacantPost(IdDto));
	}
	
}