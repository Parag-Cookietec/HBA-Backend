package gov.ifms.edp.oauth.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.oauth.entity.OAuthMsUserEndpointsEntity;
import gov.ifms.edp.oauth.repository.OAuthMsUserEndpointsRepository;
import gov.ifms.edp.oauth.util.OAuthConstant;

/**
 * The Class OAuthMsUserEndpointsServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class OAuthMsUserEndpointsServiceImplTest {

	/** The service. */
	@InjectMocks
	OAuthMsUserEndpointsServiceImpl service;

	/** The oauth ms user endpoints repository. */
	@Mock
	private OAuthMsUserEndpointsRepository oauthMsUserEndpointsRepository;

	/** The list. */
	@Mock
	private List<OAuthMsUserEndpointsEntity> list;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get all endpoints.
	 */
	@Test
	void testGetAllEndpoints() {
		when(oauthMsUserEndpointsRepository.findAll()).thenReturn(list);
		assertNotNull(service.getAllEndpoints());
		verify(oauthMsUserEndpointsRepository).findAll();
	}

	/**
	 * Test get endpoints by menu id.
	 */
	@Test
	void testGetEndpointsByMenuId() {
		when(oauthMsUserEndpointsRepository.findByActiveStatusAndMenuId(OAuthConstant.ACTIVE_STATUS,
				JunitConstants.LONG_TYPE)).thenReturn(list);
		assertNotNull(service.getEndpointsByMenuId(JunitConstants.LONG_TYPE));
		verify(oauthMsUserEndpointsRepository).findByActiveStatusAndMenuId(OAuthConstant.ACTIVE_STATUS,
				JunitConstants.LONG_TYPE);
	}

}
