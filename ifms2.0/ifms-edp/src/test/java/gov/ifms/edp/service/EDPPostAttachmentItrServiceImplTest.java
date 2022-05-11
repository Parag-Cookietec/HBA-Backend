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
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPPostAttachmentItrConverter;
import gov.ifms.edp.entity.EDPPostAttachmentItrEntity;
import gov.ifms.edp.repository.EDPPostAttachmentItrRepository;

/**
 * The Class EDPPostAttachmentItrServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPPostAttachmentItrServiceImplTest {

	/** The repository. */
	@Mock
	private EDPPostAttachmentItrRepository repository;
	
	/** The entity. */
	@Mock
	private EDPPostAttachmentItrEntity entity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPPostAttachmentItrEntity> spec;
	
	/** The data spec. */
	@Mock
	private Specification<EDPPostAttachmentItrEntity> dataSpec;
	
	/** The page. */
	@Mock
	private Page<EDPPostAttachmentItrEntity> page;
	
	/** The converter. */
	@Mock
	private EDPPostAttachmentItrConverter converter;
	
	/** The service. */
	@InjectMocks
	private EDPPostAttachmentItrServiceImpl service;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get post attachment itr.
	 */
	@Test
	void testGetPostAttachmentItr() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getPostAttachmentItr(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update post attachment itr.
	 */
	@Test
	void testSaveOrUpdatePostAttachmentItr() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdatePostAttachmentItr(entity));
		verify(repository, times(1)).save(entity);
	}

	/**
	 * Test delete post attachment itr.
	 */
	@Test
	void testDeletePostAttachmentItr() {
		service.deletePostAttachmentItr(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
		verify(repository).deletePostAttachmentItr(Mockito.any(Long.class), Mockito.any(Integer.class),
				Mockito.any(Long.class), Mockito.any(java.util.Date.class));
	}

	/**
	 * Test get post attachment itrs.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetPostAttachmentItrs() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		List<SearchParam> searchList = new ArrayList<>();
		SearchParam sp = new SearchParam();
		sp.setKey(JunitConstants.STRING_TYPE);
		sp.setValue(JunitConstants.STRING_TYPE);
		searchList.add(sp);
		when(pageDetail.getJsonArr()).thenReturn(searchList);
		when(searchCriteria.getSpecificationDetails(spec, searchList)).thenReturn(dataSpec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.getPostAttachmentItrs(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

}
