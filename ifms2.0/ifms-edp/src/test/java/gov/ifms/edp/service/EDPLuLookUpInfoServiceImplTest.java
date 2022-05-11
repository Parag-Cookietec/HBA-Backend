package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPLuLookUpInfoConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.entity.EDPLuLookUpEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPLuLookUpRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPLuLookUpInfoServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPLuLookUpInfoServiceImplTest {

	/** The list entity. */
	@Mock
	private List<EDPLuLookUpInfoEntity> listEntity;

	/** The entity. */
	@Mock
	private EDPLuLookUpInfoEntity entity;

	/** The repository. */
	@Mock
	private EDPLuLookUpInfoRepository repository;

	/** The look up entity. */
	@Mock
	private EDPLuLookUpInfoEntity lookUpEntity;

	/** The e DP lu look up repository. */
	@Mock
	private EDPLuLookUpRepository eDPLuLookUpRepository;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	/** The spec. */
	@Mock
	private SpecificationImpl<EDPLuLookUpInfoEntity> spec;

	/** The emp spec. */
	@Mock
	private Specification<EDPLuLookUpInfoEntity> empSpec;

	/** The pageable. */
	@Mock
	private PageRequest pageable;

	/** The page. */
	@Mock
	private Page<EDPLuLookUpInfoEntity> page;

	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;

	/** The clue dtos. */
	@Mock
	private List<ClueDto> clueDtos;

	/** The clue dto. */
	@Mock
	private ClueDto clueDto;

	/** The converter. */
	@Mock
	private EDPLuLookUpInfoConverter converter;

	/** The service. */
	@InjectMocks
	private EDPLuLookUpInfoServiceImpl service;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get lu look up infos.
	 */
	@Test
	void testGetLuLookUpInfos() {
		when(repository.findAll()).thenReturn(listEntity);
		assertNotNull(service.getLuLookUpInfos());
		verify(repository, times(1)).findAll();
	}

	/**
	 * Test get lu look up info.
	 */
	@Test
	void testGetLuLookUpInfo() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getLuLookUpInfo(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update lu look up info.
	 */
	@Test
	void testSaveOrUpdateLuLookUpInfo() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateLuLookUpInfo(entity));
		verify(repository, times(1)).save(entity);
	}

	/**
	 * Test delete lu look up info.
	 */
	@Test
	void testDeleteLuLookUpInfo() {
		service.deleteLuLookUpInfo(JunitConstants.LONG_TYPE);
		verify(repository, times(1)).deleteById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save lu look up infos.
	 */
	@Test
	void testSaveLuLookUpInfos() {
		when(repository.saveAll(listEntity)).thenReturn(listEntity);
		assertNotNull(service.saveLuLookUpInfos(listEntity));
		verify(repository, times(1)).saveAll(listEntity);
	}

	/**
	 * Test edp lu look up info as method name search.
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testEdpLuLookUpInfoAsMethodNameSearch() {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam seachParam = new SearchParam();
		seachParam.setKey(JunitConstants.STRING_TYPE);
		seachParam.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> list = new ArrayList<SearchParam>();
		list.add(seachParam);
		when(pageDetail.getJsonArr()).thenReturn(list);
		when(searchCriteria.getSpecificationDetails(spec, list)).thenReturn(empSpec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.edpLuLookUpInfoAsMethodNameSearch(pageDetail));
		;
	}

	/**
	 * Test find by look up id.
	 */
	@Test
	void testFindByLookUpId() {
		EDPLuLookUpEntity eDPLuLookUpEntity = new EDPLuLookUpEntity();
		List<EDPLuLookUpInfoEntity> eDPLuLookUpInfoEntities = new ArrayList<EDPLuLookUpInfoEntity>();
		when(eDPLuLookUpRepository.findByLookUpName(Constant.LOOKUP_NAME_OBJECT_TYPE)).thenReturn(eDPLuLookUpEntity);
		eDPLuLookUpInfoEntities.add(lookUpEntity);
		when(repository.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(eDPLuLookUpEntity.getLookUpId(),
				Constant.ACTIVE_STATUS)).thenReturn(eDPLuLookUpInfoEntities);
		when(clueDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
		when(clueDto.getName()).thenReturn(JunitConstants.STRING_TYPE);
		when(clueDto.getCode()).thenReturn(JunitConstants.STRING_TYPE);
		when(clueDto.getCodeName()).thenReturn(JunitConstants.STRING_TYPE);
		clueDtos.add(clueDto);
		service.findByLookUpId();
		verify(eDPLuLookUpRepository).findByLookUpName(Constant.LOOKUP_NAME_OBJECT_TYPE);
	}

	/**
	 * Test find by look up name.
	 */
	@Test
	void testFindByLookUpName() {
		when(repository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(JunitConstants.STRING_TYPE,
				Constant.ACTIVE_STATUS, EDPUtility.getJpaSort(EDPConstant.LOOKUP_INFO_ID, EDPConstant.ORDER_ASC)))
						.thenReturn(listEntity);
		assertNotNull(service.findByLookUpName(JunitConstants.STRING_TYPE));
		verify(repository, times(1)).findByEdpLuLookUpEntityLookUpNameAndActiveStatus(JunitConstants.STRING_TYPE,
				Constant.ACTIVE_STATUS, EDPUtility.getJpaSort(EDPConstant.LOOKUP_INFO_ID, EDPConstant.ORDER_ASC));
	}

	/**
	 * Test find by edp lu look up entity look up id and active status.
	 */
	@Test
	void testFindByEdpLuLookUpEntityLookUpIdAndActiveStatus() {
		when(repository.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(JunitConstants.LONG_TYPE,
				Constant.ACTIVE_STATUS)).thenReturn(listEntity);
		assertNotNull(service.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(JunitConstants.LONG_TYPE));
		verify(repository).findByEdpLuLookUpEntityLookUpIdAndActiveStatus(JunitConstants.LONG_TYPE,
				Constant.ACTIVE_STATUS);
	}

	/**
	 * Test find by look up names.
	 */
	@Test
	void testFindByLookUpNames() {
		assertNotNull(service.findByLookUpName(JunitConstants.STRING_TYPE, JunitConstants.STRING_TYPE,
				JunitConstants.INTEGER_TYPE));
		verify(repository, times(1)).findByEdpLuLookUpEntityLookUpNameAndActiveStatus(JunitConstants.STRING_TYPE,
				Constant.ACTIVE_STATUS, EDPUtility.getJpaSort(EDPConstant.LOOKUP_INFO_ID, EDPConstant.ORDER_ASC));
	}
	
	@Test
	void testFindIdAndNameByLookUpName() {
		listEntity.add(entity);
		when(repository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(Mockito.anyString(), Mockito.anyInt())).thenReturn(listEntity);
		assertNotNull(service.findIdAndNameByLookUpName(JunitConstants.STRING_TYPE));
	}
	
	@Test
	void testGetLookUpInfoByParentName() {
		Set<String> lookTypes = new HashSet<>();
		service.getLookUpInfoByParentName(lookTypes);
		verify(repository, times(1)).getLookUpByParentName(lookTypes);
	}
}