package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsModuleInfoConverter;
import gov.ifms.edp.entity.EDPMsModuleInfoEntity;
import gov.ifms.edp.repository.EDPMsModuleInfoRepository;

/**
 * The Class EDPMsModuleInfoServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsModuleInfoServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPMsModuleInfoServiceImpl service;
	
	/** The repository. */
	@Mock
	private EDPMsModuleInfoRepository repository;
	
	/** The entity. */
	@Mock
	private EDPMsModuleInfoEntity entity;
	
	/** The entities. */
	@Mock
	private List<EDPMsModuleInfoEntity> entities;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsModuleInfoEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPMsModuleInfoEntity> page;
	
	/** The converter. */
	@Mock
	private EDPMsModuleInfoConverter converter;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms module infos.
	 */
	@Test
	void testGetMsModuleInfos() {
		when(repository.findAll()).thenReturn(entities);
		assertNotNull(service.getMsModuleInfos());
		verify(repository).findAll();
	}

	/**
	 * Test get ms module info.
	 */
	@Test
	void testGetMsModuleInfo() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getMsModuleInfo(JunitConstants.LONG_TYPE));
		verify(repository).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update ms module info.
	 */
	@Test
	void testSaveOrUpdateMsModuleInfo() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMsModuleInfo(entity));
		verify(repository).save(entity);
	}

	/**
	 * Test delete ms module info.
	 */
	@Test
	void testDeleteMsModuleInfo() {
		service.deleteMsModuleInfo(JunitConstants.LONG_TYPE);
		verify(repository).deleteById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save ms module infos.
	 */
	@Test
	void testSaveMsModuleInfos() {
		when(repository.saveAll(entities)).thenReturn(entities);
		assertNotNull(service.saveMsModuleInfos(entities));
		verify(repository).saveAll(entities);
	}

	/**
	 * Test edp ms module info as method name search.
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testEdpMsModuleInfoAsMethodNameSearch() {
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
		assertNotNull(service.edpMsModuleInfoAsMethodNameSearch(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

	/**
	 * Test get ms module info by module id.
	 */
	@Test
	void testGetMsModuleInfoByModuleId() {
		when(repository.findByParentModuleIdModuleID(JunitConstants.LONG_TYPE)).thenReturn(entities);
		assertNotNull(service.getMsModuleInfoByModuleId(JunitConstants.LONG_TYPE));
		verify(repository).findByParentModuleIdModuleID(JunitConstants.LONG_TYPE);
	}

}
