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
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.repository.EDPMsDistrictRepository;

/**
 * The Class EDPMsDistrictServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsDistrictServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPMsDistrictServiceImpl service;
	
	/** The repository. */
	@Mock
	private EDPMsDistrictRepository repository;
	
	/** The entity. */
	@Mock
	private EDPMsDistrictEntity entity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsDistrictEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The page. */
	@Mock
	private Page<EDPMsDistrictEntity> page;
	
	/** The converter. */
	@Mock
	private EDPMsDistrictConverter converter;
	
	/** The list entity. */
	@Mock
	private List<EDPMsDistrictEntity> listEntity;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get district name.
	 */
	@Test
	void testGetDistrictName() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getDistrictName(JunitConstants.LONG_TYPE));
		verify(repository).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update district name.
	 */
	@Test
	void testSaveOrUpdateDistrictName() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateDistrictName(entity));
		verify(repository).save(entity);
	}

	/**
	 * Test get district names.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetDistrictNames() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.STRING_TYPE);
		searchParam.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> list = new ArrayList<>();
		list.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(list);
		when(searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr())).thenReturn(spec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.getDistrictNames(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

	/**
	 * Test get all district.
	 */
	@Test
	void testGetAllDistrict() {
		when(repository.findByActiveStatus(Constant.ACTIVE_STATUS)).thenReturn(listEntity);
		assertNotNull(service.getAllDistrict());
		verify(repository).findByActiveStatus(Constant.ACTIVE_STATUS);
	}

}
