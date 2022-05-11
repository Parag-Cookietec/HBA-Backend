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
import gov.ifms.edp.converter.EDPMsAddressConverter;
import gov.ifms.edp.entity.EDPMsAddressEntity;
import gov.ifms.edp.repository.EDPMsAddressRepository;

/**
 * The Class EDPMsAddressServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsAddressServiceImplTest {
	
	/** The repository. */
	@Mock
	private EDPMsAddressRepository repository;
	
	/** The list entity. */
	@Mock
	private List<EDPMsAddressEntity> listEntity;
	
	/** The entity. */
	@Mock
	private EDPMsAddressEntity entity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsAddressEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPMsAddressEntity> page;
	
	/** The converter. */
	@Mock
	private EDPMsAddressConverter converter;
	
	/** The service. */
	@InjectMocks
	private EDPMsAddressServiceImpl service;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms addresss.
	 */
	@Test
	void testGetMsAddresss() {
		when(repository.findAll()).thenReturn(listEntity);
		assertNotNull(service.getMsAddresss());
		verify(repository, times(1)).findAll();
	}

	/**
	 * Test get ms address.
	 */
	@Test
	void testGetMsAddress() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getMsAddress(JunitConstants.LONG_TYPE));
		verify(repository, times(1)).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update ms address.
	 */
	@Test
	void testSaveOrUpdateMsAddress() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMsAddress(entity));
		verify(repository, times(1)).save(entity);
	}

	/**
	 * Test delete ms address.
	 */
	@Test
	void testDeleteMsAddress() {
		service.deleteMsAddress(JunitConstants.LONG_TYPE);
		verify(repository, times(1)).deleteById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save ms addresss.
	 */
	@Test
	void testSaveMsAddresss() {
		when(repository.saveAll(listEntity)).thenReturn(listEntity);
		assertNotNull(service.saveMsAddresss(listEntity));
		verify(repository, times(1)).saveAll(listEntity);
	}
	
	/**
	 * Test edp ms address as method name search.
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testEdpMsAddressAsMethodNameSearch() {
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
		assertNotNull(service.edpMsAddressAsMethodNameSearch(pageDetail));
	}

}