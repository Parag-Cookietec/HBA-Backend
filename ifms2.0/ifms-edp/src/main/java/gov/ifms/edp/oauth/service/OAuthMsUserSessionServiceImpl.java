package gov.ifms.edp.oauth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import gov.ifms.edp.oauth.entity.OAuthMsUserSessionsEntity;
import gov.ifms.edp.oauth.repository.OAuthMsUserSessionsRepository;
import gov.ifms.edp.oauth.util.OAuthUtility;

/**
 * The Class OAuthMsUserSessionServiceImpl.
 */
@Service
public class OAuthMsUserSessionServiceImpl implements OAuthMsUserSessionService {

	/** The oauth ms user sessions repository. */
	@Autowired
	private OAuthMsUserSessionsRepository oauthMsUserSessionsRepository;

	/**
	 * Gets the session by session id.
	 *
	 * @param sessionId the session id
	 * @return the session by session id
	 */
	@Override
	public OAuthMsUserSessionsEntity getSessionBySessionId(String sessionId) {
		Optional<OAuthMsUserSessionsEntity> entity = oauthMsUserSessionsRepository.findBySessionId(sessionId);
		return entity.isPresent() ? entity.get() : null;
	}

	/**
	 * Save or update session.
	 *
	 * @param oauthMsUserSessionsEntity the oauth ms user sessions entity
	 * @return the o auth ms user sessions entity
	 */
	@Override
	public OAuthMsUserSessionsEntity saveOrUpdateSession(OAuthMsUserSessionsEntity oauthMsUserSessionsEntity) {
		return oauthMsUserSessionsRepository.save(oauthMsUserSessionsEntity);
	}

	/**
	 * Get OAuth User Session Info.
	 *
	 * @return the o auth current user session
	 */
	@Override
	public OAuthMsUserSessionsEntity getOAuthCurrentUserSession() {
		OAuth2AccessToken userToken = OAuthUtility.getCurrentUserOAuthToken();
		return userToken != null ? getSessionBySessionId(userToken.getValue()) : new OAuthMsUserSessionsEntity();
	}

}
