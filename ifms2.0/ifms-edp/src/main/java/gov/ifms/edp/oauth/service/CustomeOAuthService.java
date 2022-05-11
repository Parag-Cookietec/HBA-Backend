package gov.ifms.edp.oauth.service;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

public interface CustomeOAuthService {
	
	 /**
 	 * Creates the access token.
 	 *
 	 * @param authentication the authentication
 	 * @return the o auth 2 access token
 	 * @throws AuthenticationException the authentication exception
 	 */
 	OAuth2AccessToken createAccessToken(OAuth2Authentication authentication);
 	
 	/**
	  * Creates the refresh token.
	  *
	  * @param authentication the authentication
	  * @return the o auth 2 refresh token
	  */
	 OAuth2RefreshToken createRefreshToken(OAuth2Authentication authentication);
	 
	 
	 /**
 	 * Creates the access token.
 	 *
 	 * @param authentication the authentication
 	 * @param refreshToken the refresh token
 	 * @return the o auth 2 access token
 	 */
 	OAuth2AccessToken createAccessToken(OAuth2Authentication authentication, OAuth2RefreshToken refreshToken);
}
