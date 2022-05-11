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

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPLkPostOfficeDesignationLocationConverter;
import gov.ifms.edp.dto.EDPLkPostOfficeDesignationLocationDto;
import gov.ifms.edp.entity.EDPLkPostOfficeDesignationLocationEntity;
import gov.ifms.edp.repository.EDPLkPostOfficeDesignationLocationRepository;

/**
 * The Class EDPLkPostOfficeDesignationLocationServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPLkPostOfficeDesignationLocationServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPLkPostOfficeDesignationLocationServiceImpl service;
	
	/** The repository. */
	@Mock
	private EDPLkPostOfficeDesignationLocationRepository repository;
	
	/** The entity. */
	@Mock
	private EDPLkPostOfficeDesignationLocationEntity entity;
	
	/** The entities. */
	@Mock
	private List<EDPLkPostOfficeDesignationLocationEntity> entities;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPLkPostOfficeDesignationLocationEntity> spec;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The page. */
	@Mock
	private Page<EDPLkPostOfficeDesignationLocationEntity> page;
	
	/** The pageble dto. */
	@Mock
	private PagebleDTO<EDPLkPostOfficeDesignationLocationDto> pagebleDto;
	
	/** The converter. */
	@Mock
	private EDPLkPostOfficeDesignationLocationConverter converter;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get lk post office designation locations.
	 */
	@Test
	void testGetLkPostOfficeDesignationLocations() {
		when(repository.findAll()).thenReturn(entities);
		assertNotNull(service.getLkPostOfficeDesignationLocations());
		verify(repository).findAll();
	}

	/**
	 * Test get lk post office designation location.
	 */
	@Test
	void testGetLkPostOfficeDesignationLocation() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getLkPostOfficeDesignationLocation(JunitConstants.LONG_TYPE));
		verify(repository).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update lk post office designation location.
	 */
	@Test
	void testSaveOrUpdateLkPostOfficeDesignationLocation() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateLkPostOfficeDesignationLocation(entity));
		verify(repository).save(entity);
	}

	/**
	 * Test delete lk post office designation location.
	 */
	@Test
	void testDeleteLkPostOfficeDesignationLocation() {
		service.deleteLkPostOfficeDesignationLocation(JunitConstants.LONG_TYPE);
		verify(repository).deleteById(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save lk post office designation locations.
	 */
	@Test
	void testSaveLkPostOfficeDesignationLocations() {
		when(repository.saveAll(entities)).thenReturn(entities);
		assertNotNull(service.saveLkPostOfficeDesignationLocations(entities));
		verify(repository).saveAll(entities);
	}
	
	/**
	 * Test edp lk post office designation location as method name search.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testEdpLkPostOfficeDesignationLocationAsMethodNameSearch() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.STRING_TYPE);
		searchParam.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> list = new ArrayList<SearchParam>();
		list.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(list);
		when(searchCriteria.getSpecificationDetails(spec, list)).thenReturn(spec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		assertNotNull(service.edpLkPostOfficeDesignationLocationAsMethodNameSearch(pageDetail));
	}

}
