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

import gov.ifms.common.util.Constant;
import gov.ifms.edp.converter.EDPMsSubModuleConverter;
import gov.ifms.edp.entity.EDPMsSubModuleEntity;
import gov.ifms.edp.repository.EDPMsSubModuleRepository;

/**
 * The Class EDPMsSubModuleServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsSubModuleServiceImplTest {

	
	/** The repository. */
	@Mock
	private EDPMsSubModuleRepository repository;
	
	/** The converter. */
	@Mock
	private EDPMsSubModuleConverter converter;
	
	/** The list entity. */
	@Mock
	private List<EDPMsSubModuleEntity> listEntity;
	
	/** The entity. */
	@Mock
	private EDPMsSubModuleEntity entity;
	
	/** The service. */
	@InjectMocks
	private EDPMsSubModuleServiceImpl service;
	
	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Test get ms sub module.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testGetMsSubModule()throws Exception {
		when(repository.findByModuleIdModuleIDAndActiveStatus(1l ,Constant.ACTIVE_STATUS)).thenReturn(listEntity);
		assertNotNull(service.getMsSubModule(1l));
		verify(repository,times(1)).findByModuleIdModuleIDAndActiveStatus(1l ,Constant.ACTIVE_STATUS);
		
	}

	/**
	 * Test get ms sub modules.
	 */
	@Test
	void testGetMsSubModules() {
		when(repository.findAll()).thenReturn(listEntity);
		assertNotNull(service.getMsSubModules());
		verify(repository, times(1)).findAll();
	}

}
