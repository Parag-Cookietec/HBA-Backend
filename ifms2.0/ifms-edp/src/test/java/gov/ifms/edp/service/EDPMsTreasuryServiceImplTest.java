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

import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsTreasuryConverter;
import gov.ifms.edp.entity.EDPMsTreasuryEntity;
import gov.ifms.edp.repository.EDPMsTreasuryRepository;

/**
 * The Class EDPMsTreasuryServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsTreasuryServiceImplTest {

	/** The service. */
	@InjectMocks
	private EDPMsTreasuryServiceImpl service;
	
	/** The repository. */
	@Mock
	private EDPMsTreasuryRepository repository;
	
	/** The entity. */
	@Mock
	private EDPMsTreasuryEntity entity;
	
	/** The page detail. */
	@Mock
	private PageDetails pageDetail;
	
	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;
	
	/** The spec. */
	@Mock
	private SpecificationImpl<EDPMsTreasuryEntity> spec;
	
	/** The pageable. */
	@Mock
	private PageRequest pageable;
	
	/** The converter. */
	@Mock
	private EDPMsTreasuryConverter converter;
	
	/** The page. */
	@Mock
	private Page<EDPMsTreasuryEntity> page;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms treasury.
	 */
	@Test
	void testGetMsTreasury() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		assertNotNull(service.getMsTreasury(JunitConstants.LONG_TYPE));
		verify(repository).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update ms treasury.
	 */
	@Test
	void testSaveOrUpdateMsTreasury() {
		when(repository.save(entity)).thenReturn(entity);
		assertNotNull(service.saveOrUpdateMsTreasury(entity));
		verify(repository).save(entity);
	}

	/**
	 * Test delete ms treasury.
	 */
	@Test
	void testDeleteMsTreasury() {
		service.deleteMsTreasury(JunitConstants.LONG_TYPE, JunitConstants.INTEGER_TYPE);
		verify(repository).deleteMsTreasury(Mockito.any(Long.class), Mockito.any(Integer.class),
				Mockito.any(Long.class), Mockito.any(java.util.Date.class));
	}

	/**
	 * Test get ms treasurys.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetMsTreasurys() throws Exception {
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
		assertNotNull(service.getMsTreasurys(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}
	
	@Test
	void testGetMsTreasurysByDistrictId() {
		List<EDPMsTreasuryEntity> treasuryEnties=new ArrayList<>();
		treasuryEnties.add(entity);
		when(repository.findByDistrictIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS)).thenReturn(treasuryEnties);
		when(entity.getTreasuryId()).thenReturn(JunitConstants.LONG_TYPE);
		when(entity.getTreasuryCode()).thenReturn(JunitConstants.STRING_TYPE);
		when(entity.getTreasuryName()).thenReturn(JunitConstants.STRING_TYPE);
		assertNotNull(service.getMsTreasurysByDistrictId(JunitConstants.LONG_TYPE));
	}

}
