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

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPPostItrConverter;
import gov.ifms.edp.entity.EDPPostItrEntity;
import gov.ifms.edp.repository.EDPPostItrRepository;

/**
 * The Class EDPPostItrServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPPostItrServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPPostItrServiceImpl service;
	
	/** The repository. */
	@Mock
	private EDPPostItrRepository repository;
	
	/** The entity. */
	@Mock
	private EDPPostItrEntity entity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPPostItrEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPPostItrEntity> page;
	
	/** The converter. */
	@Mock
	private EDPPostItrConverter converter;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get post itr.
	 */
	@Test
	void testGetPostItr() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getPostItr(JunitConstants.LONG_TYPE));
		verify(repository).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update post itr.
	 */
	@Test
	void testSaveOrUpdatePostItr() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdatePostItr(entity));
		verify(repository).save(entity);
	}

	/**
	 * Test delete post itr.
	 */
	@Test
	void testDeletePostItr() {
		service.deletePostItr(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
		verify(repository).deletePostItr(Mockito.any(Long.class), Mockito.any(Integer.class), Mockito.any(Long.class),
				Mockito.any(java.util.Date.class));
	}

	/**
	 * Test get post itrs.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetPostItrs() throws CustomException {
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
		assertNotNull(service.getPostItrs(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

}