package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.*;
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
import gov.ifms.common.util.Constant;
import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.converter.EDPMsBillConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsBillEntity;
import gov.ifms.edp.repository.EDPMsBillRepository;

/**
 * The Class EDPMsBillServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsBillServiceImplTest {

	/** The repository. */
	@Mock
	private EDPMsBillRepository repository;

	/** The entity. */
	@Mock
	private EDPMsBillEntity billEntity;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	/** The pageable. */
	@Mock
	private PageRequest pageable;

	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;

	/** The search param. */
	@Mock
	private SearchParam searchParam;

	/** The data spec. */
	@Mock
	private SpecificationImpl<EDPMsBillEntity> dataSpec;

	/** The spec. */
	@Mock
	private Specification<EDPMsBillEntity> spec;

	/** The page. */
	@Mock
	private Page<EDPMsBillEntity> page;

	/** The converter. */
	@Mock
	private EDPMsBillConverter converter;

	/** The edp lu look up info entity. */
	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	/** The service. */
	@InjectMocks
	private EDPMsBillServiceImpl service;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get ms bill.
	 */
	@Test
	void testGetMsBill() {
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(billEntity);
		assertNotNull(service.getMsBill(JunitConstants.LONG_TYPE));
		verify(repository).getOne(JunitConstants.LONG_TYPE);
	}

	/**
	 * Test save or update ms bill.
	 */
	@Test
	void testSaveOrUpdateMsBill() {
		when(repository.save(billEntity)).thenReturn(billEntity);
		assertNotNull(service.saveOrUpdateMsBill(billEntity));
		verify(repository).save(billEntity);
	}



	/**
	 * Test get ms bills.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	void testGetMsBills() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		List<SearchParam> sp = new ArrayList<>();
		sp.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(sp);
		when(searchCriteria.getSpecificationDetails(dataSpec, sp)).thenReturn(spec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		when(page.getContent()).thenReturn(new ArrayList<>());
		assertNotNull(service.getMsBills(pageDetail));
		verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));
	}

	/**
	 * Test find all bills.
	 */
	@Test
	void testFindAllBills() {
		List<EDPMsBillEntity> billEntities = new ArrayList<>();
		billEntities.add(billEntity);
		when(billEntity.getBillId()).thenReturn(JunitConstants.LONG_TYPE);
		when(billEntity.getBillName()).thenReturn(JunitConstants.STRING_TYPE);
		when(billEntity.getBillCode()).thenReturn(JunitConstants.STRING_TYPE);
		when(billEntity.getBillTypeId()).thenReturn(edpLuLookUpInfoEntity);
		when(repository.findByActiveStatus(Constant.ACTIVE_STATUS)).thenReturn(billEntities);
		assertNotNull(service.findAllBills());
		when(billEntity.getBillTypeId()).thenReturn(null);
		assertNotNull(service.findAllBills());
		verify(repository, times(2)).findByActiveStatus(Constant.ACTIVE_STATUS);
	}

}
