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

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPLuLookUpConverter;
import gov.ifms.edp.entity.EDPLuLookUpEntity;
import gov.ifms.edp.repository.EDPLuLookUpRepository;

/**
 * The Class EDPLuLookUpServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPLuLookUpServiceImplTest {
	
	/** The repository. */
	@Mock
	private EDPLuLookUpRepository repository;
	
	/** The list entity. */
	@Mock
	private List<EDPLuLookUpEntity> listEntity;
	
	/** The entity. */
	@Mock
	private EDPLuLookUpEntity entity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPLuLookUpEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPLuLookUpEntity> page;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The converter. */
	@Mock
	private EDPLuLookUpConverter converter;
	
	/** The service. */
	@InjectMocks
	private EDPLuLookUpServiceImpl service;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get lu look ups.
	 */
	@Test
	void testGetLuLookUps() {
		when(repository.findAll()).thenReturn(listEntity);
		assertNotNull(service.getLuLookUps());
		verify(repository, times(1)).findAll();
	}

	/**
	 * Test get lu look up.
	 */
	@Test
	void testGetLuLookUp() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getLuLookUp(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update lu look up.
	 */
	@Test
	void testSaveOrUpdateLuLookUp() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateLuLookUp(entity));
		verify(repository, times(1)).save(entity);
	}

	/**
	 * Test delete lu look up.
	 */
	@Test
	void testDeleteLuLookUp() {
		service.deleteLuLookUp(JunitConstants.LONG_TYPE);
		verify(repository, times(1)).deleteById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save lu look ups.
	 */
	@Test
	void testSaveLuLookUps() {
		when(repository.saveAll(listEntity)).thenReturn(listEntity);
		assertNotNull(service.saveLuLookUps(listEntity));
		verify(repository, times(1)).saveAll(listEntity);
	}
	
	/**
	 * Test edp lu look up as method name search.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testEdpLuLookUpAsMethodNameSearch() throws CustomException{
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.STRING_TYPE);
		searchParam.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> list = new ArrayList<SearchParam>();
		list.add(searchParam);
		when(searchCriteria.getSpecificationDetails(spec, list)).thenReturn(spec);
		when(repository.findAll(Mockito.nullable(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.edpLuLookUpAsMethodNameSearch(pageDetail));
	}
}