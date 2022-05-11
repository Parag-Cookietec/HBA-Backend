package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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

import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsModuleConverter;
import gov.ifms.edp.entity.EDPMsModuleEntity;
import gov.ifms.edp.repository.EDPMsModuleRepository;

/**
 * The Class EDPMsModuleServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsModuleServiceImplTest {
	
	/** The repository. */
	@Mock
	private EDPMsModuleRepository repository;
	
	/** The list entity. */
	@Mock
	private List<EDPMsModuleEntity> listEntity;
	
	/** The entity. */
	@Mock
	private EDPMsModuleEntity entity;
	
	/** The service. */
	@InjectMocks
	private EDPMsModuleServiceImpl service;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsModuleEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPMsModuleEntity> page;
	
	/** The converter. */
	@Mock
	private EDPMsModuleConverter converter;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms modules.
	 */
	@Test
	void testGetMsModules() {
		when(repository.findByActiveStatus(Constant.ACTIVE_STATUS)).thenReturn(listEntity);
		assertNotNull(service.getMsModules());
		verify(repository, times(1)).findByActiveStatus(Constant.ACTIVE_STATUS);
	}

	/**
	 * Test get ms module.
	 */
	@Test
	void testGetMsModule() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getMsModule(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update ms module.
	 */
	@Test
	void testSaveOrUpdateMsModule() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMsModule(entity));
		verify(repository, times(1)).save(entity);
	}

	/**
	 * Test delete ms module.
	 */
	@Test
	void testDeleteMsModule() {
		service.deleteMsModule(JunitConstants.LONG_TYPE);
		verify(repository, times(1)).deleteById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save ms modules.
	 */
	@Test
	void testSaveMsModules() {
		when(repository.saveAll(listEntity)).thenReturn(listEntity);
		assertNotNull(service.saveMsModules(listEntity));
		verify(repository, times(1)).saveAll(listEntity);
	}

	/**
	 * Test edp ms module as method name search.
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testEdpMsModuleAsMethodNameSearch() {
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
		assertNotNull(service.edpMsModuleAsMethodNameSearch(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

}
