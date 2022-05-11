package gov.ifms.edp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;
import gov.ifms.edp.repository.EDPMsRolePermissionsRepository;

/**
 * The Class EDPMsRolePermissionsServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class EDPMsRolePermissionsServiceImplTest {
	
	/** The edp ms role permissions repository. */
	@Mock
	private EDPMsRolePermissionsRepository edpMsRolePermissionsRepository;
	
	/** The list entity. */
	@Mock
	private List<EDPMsRolePermissionsEntity> listEntity;
	
	/** The service. */
	@InjectMocks
	private EDPMsRolePermissionsServiceImpl service;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get EDP ms R ole activity by role activity id in.
	 */
	@Test
	void testGetEDPMsROleActivityByRoleActivityIdIn() {
		when(edpMsRolePermissionsRepository.findByRolePrmIdIn(new HashSet<Long>())).thenReturn(listEntity);
		assertNotNull(service.getEDPMsROleActivityByRoleActivityIdIn(new HashSet<Long>()));
		verify(edpMsRolePermissionsRepository, times(1)).findByRolePrmIdIn(new HashSet<Long>());
	}
	
	/**
	 * Test get all.
	 */
	@Test
	void testGetAll() {
		when(edpMsRolePermissionsRepository.findByActiveStatus(Constant.ACTIVE_STATUS)).thenReturn(listEntity);
		assertNotNull(service.getAll());
		verify(edpMsRolePermissionsRepository, times(1)).findByActiveStatus(Constant.ACTIVE_STATUS);
	}
}