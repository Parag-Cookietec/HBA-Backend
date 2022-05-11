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
import gov.ifms.edp.converter.EDPOfficeBillMapItrConverter;
import gov.ifms.edp.entity.EDPOfficeBillMapItrEntity;
import gov.ifms.edp.repository.EDPOfficeBillMapItrRepository;

/**
 * The Class EDPOfficeBillMapItrServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPOfficeBillMapItrServiceImplTest {
	
	/** The repository. */
	@Mock
	private EDPOfficeBillMapItrRepository repository;
	
	/** The entity. */
	@Mock
	private EDPOfficeBillMapItrEntity entity;
	
	/** The service. */
	@InjectMocks
	private EDPOfficeBillMapItrServiceImpl service;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPOfficeBillMapItrEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPOfficeBillMapItrEntity> page;
	
	/** The converter. */
	@Mock
	private EDPOfficeBillMapItrConverter converter;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get office bill map itr.
	 */
	@Test
	void testGetOfficeBillMapItr() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getOfficeBillMapItr(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update office bill map itr.
	 */
	@Test
	void testSaveOrUpdateOfficeBillMapItr() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateOfficeBillMapItr(entity));
		verify(repository, times(1)).save(entity);
	}

	/**
	 * Test delete office bill map itr.
	 */
	// @Test
	void testDeleteOfficeBillMapItr() {

	}

	/**
	 * Test get office bill map itrs.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetOfficeBillMapItrs() throws Exception {
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
		assertNotNull(service.getOfficeBillMapItrs(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

}
