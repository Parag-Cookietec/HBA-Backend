package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import gov.ifms.edp.converter.EDPLkPuoMenuRLWFConverter;
import gov.ifms.edp.entity.EDPTrnUsrMnuWfRole;
import gov.ifms.edp.repository.EDPLkPuoMenuRLWFRepository;

/**
 * The Class EDPLkPuoMenuRLWFServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPLkPuoMenuRLWFServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPLkPuoMenuRLWFServiceImpl service;
	
	/** The repository. */
	@Mock
	private EDPLkPuoMenuRLWFRepository repository;
	
	/** The entity. */
	@Mock
	private EDPTrnUsrMnuWfRole entity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPTrnUsrMnuWfRole> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPTrnUsrMnuWfRole> page;
	
	/** The converter. */
	@Mock
	private EDPLkPuoMenuRLWFConverter converter;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get lk puo menu RLWF.
	 */
	@Test
	void testGetLkPuoMenuRLWF() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getLkPuoMenuRLWF(JunitConstants.LONG_TYPE));
		verify(repository).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update lk puo menu RLWF.
	 */
	@Test
	void testSaveOrUpdateLkPuoMenuRLWF() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateLkPuoMenuRLWF(entity));
		verify(repository).save(entity);
	}

/**
 * Test delete lk puo menu RLWF.
 */
//	@Test
	void testDeleteLkPuoMenuRLWF() {
	}
	
	/**
	 * Test get lk puo menu RLW fs.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetLkPuoMenuRLWFs() throws Exception{
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey("key");
		searchParam.setValue("value");
		List<SearchParam> list = new ArrayList<>();
		list.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(list);
		when(searchCriteria.getSpecificationDetails(spec, list)).thenReturn(spec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.getLkPuoMenuRLWFs(pageDetail));
	}

}