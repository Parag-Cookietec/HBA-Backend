package gov.ifms.edp.oauth.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.constant.JunitConstants;
import gov.ifms.edp.oauth.entity.OAuthMsUserSessionsEntity;
import gov.ifms.edp.oauth.repository.OAuthMsUserSessionsRepository;

/**
 * The Class OAuthMsUserSessionServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class OAuthMsUserSessionServiceImplTest {

	/** The oauth ms user sessions repository. */
	@Mock
	private OAuthMsUserSessionsRepository oauthMsUserSessionsRepository;

	/** The oauth ms user sessions entity. */
	@Mock
	private OAuthMsUserSessionsEntity oauthMsUserSessionsEntity;

	/** The service. */
	@InjectMocks
	private OAuthMsUserSessionServiceImpl service;

	/**
	 * Sets the up.
	 */
	@BeforeAll
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get session by session id.
	 */
	@Test
	void testGetSessionBySessionId() {
		when(oauthMsUserSessionsRepository.findBySessionId(JunitConstants.STRING_TYPE))
				.thenReturn(Optional.of(oauthMsUserSessionsEntity));
		assertNotNull(service.getSessionBySessionId(JunitConstants.STRING_TYPE));
		when(oauthMsUserSessionsRepository.findBySessionId(JunitConstants.STRING_TYPE)).thenReturn(Optional.empty());
		assertNull(service.getSessionBySessionId(JunitConstants.STRING_TYPE));
		verify(oauthMsUserSessionsRepository, times(2)).findBySessionId(JunitConstants.STRING_TYPE);
	}

	/**
	 * Test save or update session.
	 */
	@Test
	void testSaveOrUpdateSession() {
		when(oauthMsUserSessionsRepository.save(oauthMsUserSessionsEntity)).thenReturn(oauthMsUserSessionsEntity);
		assertNotNull(service.saveOrUpdateSession(oauthMsUserSessionsEntity));
		verify(oauthMsUserSessionsRepository).save(oauthMsUserSessionsEntity);
	}

}
