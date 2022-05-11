package gov.ifms.edp.oauth.service;

import gov.ifms.edp.oauth.entity.OAuthMsUserSessionsEntity;


/**
 * The Interface OAuthMsUserSessionService.
 */
public interface OAuthMsUserSessionService {
	
	
	/**
	 * Save or update session.
	 *
	 * @param oauthMsUserSessionsEntity the oauth ms user sessions entity
	 * @return the o auth ms user sessions entity
	 */
	OAuthMsUserSessionsEntity saveOrUpdateSession(OAuthMsUserSessionsEntity oauthMsUserSessionsEntity);
	
	
	/**
	 * Gets the session by session id.
	 *
	 * @param sessionId the session id
	 * @return the session by session id
	 */
	OAuthMsUserSessionsEntity getSessionBySessionId(String sessionId);
	
	/**
	 * Gets the o auth current user session.
	 *
	 * @return the o auth current user session
	 */
	OAuthMsUserSessionsEntity getOAuthCurrentUserSession();
}
