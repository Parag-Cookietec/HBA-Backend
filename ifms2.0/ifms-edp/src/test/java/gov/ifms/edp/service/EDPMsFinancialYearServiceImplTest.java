package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;

/**
 * The Class EDPMsFinancialYearServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsFinancialYearServiceImplTest {
	
	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/** The repository. */
	@Mock
	private EDPMsFinancialYearRepository repository;
	
	/** The list entity. */
	@Mock
	private List<EDPMsFinancialYearEntity> listEntity;
	
	/** The service. */
	@InjectMocks
	private EDPMsFinancialYearServiceImpl service;

	/**
	 * Test get all.
	 */
	@Test
	void testGetAll() {
		when(repository.findAll()).thenReturn(listEntity);
		assertNotNull(service.getAll());
		verify(repository, times(1)).findAll();
	}

}