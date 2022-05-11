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
import gov.ifms.edp.converter.EDPLkPostOfficeConverter;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.repository.EDPLkPostOfficeRepository;

/**
 * The Class EDPLkPostOfficeServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPLkPostOfficeServiceImplTest {
	
	/** The repository. */
	@Mock
	private EDPLkPostOfficeRepository repository;
	
	/** The entity. */
	@Mock
	private EDPLkPostOfficeEntity entity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPLkPostOfficeEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPLkPostOfficeEntity> page;
	
	/** The converter. */
	@Mock
	private EDPLkPostOfficeConverter converter;
	
	/** The service. */
	@InjectMocks
	private EDPLkPostOfficeServiceImpl service;
	
	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Test get lk post office.
	 */
	@Test
	void testGetLkPostOffice() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getLkPostOffice(JunitConstants.LONG_TYPE));
		verify(repository,times(1)).getOne(1l);
	}

	/**
	 * Test save or update lk post office.
	 */
	@Test
	void testSaveOrUpdateLkPostOffice() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateLkPostOffice(entity));
		verify(repository,times(1)).save(entity);
	}

	/**
	 * Test delete lk post office.
	 */
	@Test
	void testDeleteLkPostOffice() {
		service.deleteLkPostOffice(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
		verify(repository,times(1)).deleteLkPostOffice(Mockito.any(Long.class), Mockito.any(Integer.class), Mockito.any(Long.class),Mockito.any(java.util.Date.class));
	}
	
	/**
	 * Test get lk post offices.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetLkPostOffices() throws CustomException {
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
		assertNotNull(service.getLkPostOffices(pageDetail));
	}

}
