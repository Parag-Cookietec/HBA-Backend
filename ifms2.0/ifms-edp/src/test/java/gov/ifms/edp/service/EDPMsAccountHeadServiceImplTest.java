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
import gov.ifms.edp.converter.EDPMsAccountHeadConverter;
import gov.ifms.edp.entity.EDPMsAccountHeadEntity;
import gov.ifms.edp.repository.EDPMsAccountHeadRepository;

/**
 * The Class EDPMsAccountHeadServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsAccountHeadServiceImplTest {
	
	/** The repository. */
	@Mock
	private EDPMsAccountHeadRepository repository;
	
	/** The list entity. */
	@Mock
	List<EDPMsAccountHeadEntity> listEntity;
	
	/** The entity. */
	@Mock
	private EDPMsAccountHeadEntity entity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsAccountHeadEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPMsAccountHeadEntity> page;
	
	/** The converter. */
	@Mock
	private EDPMsAccountHeadConverter converter;
	
	/** The service. */
	@InjectMocks
	private EDPMsAccountHeadServiceImpl service;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms account heads.
	 */
	@Test
	void testGetMsAccountHeads() {
		when(repository.findAll()).thenReturn(listEntity);
		assertNotNull(service.getMsAccountHeads());
		verify(repository, times(1)).findAll();
	}

	/**
	 * Test get ms account head.
	 */
	@Test
	void testGetMsAccountHead() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getMsAccountHead(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update ms account head.
	 */
	@Test
	void testSaveOrUpdateMsAccountHead() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMsAccountHead(entity));
		verify(repository, times(1)).save(entity);
	}

	/**
	 * Test delete ms account head.
	 */
	@Test
	void testDeleteMsAccountHead() {
		service.deleteMsAccountHead(JunitConstants.LONG_TYPE);
		verify(repository, times(1)).deleteById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save ms account heads.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSaveMsAccountHeads() throws CustomException {
		when(repository.saveAll(listEntity)).thenReturn(listEntity);
		assertNotNull(service.saveMsAccountHeads(listEntity));
		verify(repository, times(1)).saveAll(listEntity);
	}
	
	/**
	 * Test edp ms account head as method name search.
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testEdpMsAccountHeadAsMethodNameSearch() {
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
		assertNotNull(service.edpMsAccountHeadAsMethodNameSearch(pageDetail));
	}

}