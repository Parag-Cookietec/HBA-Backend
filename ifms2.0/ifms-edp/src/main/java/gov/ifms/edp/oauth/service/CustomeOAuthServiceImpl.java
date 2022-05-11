
package gov.ifms.edp.oauth.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.DefaultOAuth2RefreshToken;
import org.springframework.security.oauth2.common.ExpiringOAuth2RefreshToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.oauth.util.OAuthConstant;

/**
 * The Class CustomeOAuthServiceImpl.
 */
@Service
public class CustomeOAuthServiceImpl implements CustomeOAuthService {

	/** The token store. */
	@Autowired
	private TokenStore tokenStore;

	/** The access token enhancer. */
	@Autowired
	private TokenEnhancer accessTokenEnhancer;

	@Autowired
	private ClientDetailsService clientDetailsService;

	/**
	 * Creates the access token.
	 *
	 * @param authentication the authentication
	 * @return the o auth 2 access token
	 * @throws AuthenticationException the authentication exception
	 */
	@Transactional
	public OAuth2AccessToken createAccessToken(OAuth2Authentication authentication) {

		OAuth2AccessToken existingAccessToken = tokenStore.getAccessToken(authentication);
		OAuth2RefreshToken refreshToken = null;
		
		if (existingAccessToken != null) {
			if (existingAccessToken.isExpired()) {
				if (existingAccessToken.getRefreshToken() != null) {
					refreshToken = existingAccessToken.getRefreshToken();
					// The token store could remove the refresh token when the
					// access token is removed, but we want to
					// be sure...
					tokenStore.removeRefreshToken(refreshToken);
				}
				tokenStore.removeAccessToken(existingAccessToken);
			}
			else {
				// Revoke Old Access Token
				tokenStore.removeRefreshToken(existingAccessToken.getRefreshToken());
				tokenStore.removeAccessToken(existingAccessToken);
			}
		}

		if (refreshToken == null) {
			refreshToken = createRefreshToken(authentication);
		} else if (refreshToken instanceof ExpiringOAuth2RefreshToken) {
			ExpiringOAuth2RefreshToken expiring = (ExpiringOAuth2RefreshToken) refreshToken;
			if (System.currentTimeMillis() > expiring.getExpiration().getTime()) {
				refreshToken = createRefreshToken(authentication);
			}
		}

		OAuth2AccessToken accessToken = createAccessToken(authentication, refreshToken);
		tokenStore.storeAccessToken(accessToken, authentication);
		refreshToken = accessToken.getRefreshToken();
		if (refreshToken != null) {
			tokenStore.storeRefreshToken(refreshToken, authentication);
		}
		return accessToken;
	}

	/**
	 * Creates the refresh token.
	 *
	 * @param authentication the authentication
	 * @return the o auth 2 refresh token
	 */
	@Override
	public OAuth2RefreshToken createRefreshToken(OAuth2Authentication authentication) {
		if (!isSupportRefreshToken(authentication.getOAuth2Request())) {
			return null;
		}
		int validitySeconds = OAuthConstant.REFRESH_TOKEN_VALIDITY_SECONDS;
		String value = UUID.randomUUID().toString();
		if (validitySeconds > 0) {
			return new DefaultExpiringOAuth2RefreshToken(value,
					new Date(System.currentTimeMillis() + (validitySeconds * 1000L)));
		}
		return new DefaultOAuth2RefreshToken(value);
	}

	/**
	 * Checks if is support refresh token.
	 *
	 * @param clientAuth the client auth
	 * @return true, if is support refresh token
	 */
	public boolean isSupportRefreshToken(OAuth2Request clientAuth) {
		if (clientDetailsService != null) {
			ClientDetails client = clientDetailsService.loadClientByClientId(clientAuth.getClientId());
			return client.getAuthorizedGrantTypes().contains("refresh_token");
		}
		return false;
	}

	/**
	 * Creates the access token.
	 *
	 * @param authentication the authentication
	 * @param refreshToken   the refresh token
	 * @return the o auth 2 access token
	 */
	@Override
	public OAuth2AccessToken createAccessToken(OAuth2Authentication authentication, OAuth2RefreshToken refreshToken) {
		DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(UUID.randomUUID().toString());
		int validitySeconds = OAuthConstant.ACCESS_TOKEN_VALIDITY_SECONDS;
		if (validitySeconds > 0) {
			token.setExpiration(new Date(System.currentTimeMillis() + (validitySeconds * 1000L)));
		}
		token.setRefreshToken(refreshToken);
		token.setScope(authentication.getOAuth2Request().getScope());

		return accessTokenEnhancer != null ? accessTokenEnhancer.enhance(token, authentication) : token;
	}

}
