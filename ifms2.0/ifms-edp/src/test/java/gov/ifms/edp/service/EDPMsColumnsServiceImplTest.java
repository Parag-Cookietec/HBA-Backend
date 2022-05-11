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
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsColumnsConverter;
import gov.ifms.edp.entity.EDPMsColumnsEntity;
import gov.ifms.edp.repository.EDPMsColumnsRepository;

/**
 * The Class EDPMsColumnsServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsColumnsServiceImplTest {
	
	/** The repository. */
	@Mock
	private EDPMsColumnsRepository repository;
	
	/** The list entity. */
	@Mock
	private List<EDPMsColumnsEntity> listEntity;
	
	/** The entity. */
	@Mock
	private EDPMsColumnsEntity entity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsColumnsEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPMsColumnsEntity> page;
	
	/** The converter. */
	@Mock
	private EDPMsColumnsConverter converter;
	
	/** The service. */
	@InjectMocks
	private EDPMsColumnsServiceImpl service;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms columnss.
	 */
	@Test
	void testGetMsColumnss() {
		when(repository.findAll()).thenReturn(listEntity);
		assertNotNull(service.getMsColumnss());
		verify(repository, times(1)).findAll();
	}

	/**
	 * Test get ms columns.
	 */
	@Test
	void testGetMsColumns() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getMsColumns(JunitConstants.LONG_TYPE));
		verify(repository,times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update ms columns.
	 */
	@Test
	void testSaveOrUpdateMsColumns() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMsColumns(entity));
		verify(repository,times(1)).save(entity);
	}

	/**
	 * Test delete ms columns.
	 */
	@Test
	void testDeleteMsColumns() {
		service.deleteMsColumns(JunitConstants.LONG_TYPE);
		verify(repository,times(1)).deleteById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save ms columnss.
	 */
	@Test
	void testSaveMsColumnss() {
		when(repository.saveAll(listEntity)).thenReturn(listEntity);
		assertNotNull(service.saveMsColumnss(listEntity));
		verify(repository,times(1)).saveAll(listEntity);
	}
	
	/**
	 * Test edp ms columns as method name search.
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testEdpMsColumnsAsMethodNameSearch() {
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
		assertNotNull(service.edpMsColumnsAsMethodNameSearch(pageDetail));
	}

}
