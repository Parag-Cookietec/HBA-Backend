package gov.ifms.edp.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import gov.ifms.common.constant.URLConstant;
import gov.ifms.edp.oauth.exception.OAuthException;
import gov.ifms.edp.oauth.util.OAuthConstant;


/**
     AuthorizationServerConfig for Oauth-Server 
                   - Client ID, Client Secret, Scope All Config Hear.
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	/** The authentication manager. */
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	/**
	 * Server Seecurity Configurer.
	 *
	 * @param oauthServer the oauth server
	 * @throws Exception the exception
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess(OAuthConstant.PERMIT_ALL).checkTokenAccess(OAuthConstant.IS_AUTHENTICATED);
	}

	/**
	 * OAuth Client Register.
	 *
	 * @param configurer the configurer
	 * @throws Exception the exception
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		configurer.inMemory().withClient(OAuthConstant.CLIENT).secret(OAuthConstant.CLIENT_SECRET)
				.authorizedGrantTypes(OAuthConstant.GRANT_TYPE, OAuthConstant.AUTHORIZATION_CODE,
						OAuthConstant.REFRESH_TOKEN, OAuthConstant.IMPLICIT)
				.scopes(OAuthConstant.SCOPE_READ, OAuthConstant.SCOPE_WRITE, OAuthConstant.TRUST)
				.resourceIds(OAuthConstant.RESOURCE_ID)
				.accessTokenValiditySeconds(OAuthConstant.ACCESS_TOKEN_VALIDITY_SECONDS)
				.refreshTokenValiditySeconds(OAuthConstant.REFRESH_TOKEN_VALIDITY_SECONDS);
	}

	/**
	 * AuthorizationServerEndpointsConfigurer.
	 *
	 * @param endpoints the endpoints
	 * @throws Exception the exception
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
		endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancer());
		endpoints.pathMapping(URLConstant.OAUTH_DEFULT_TOKEN,URLConstant.OAUTH_CREATE_TOKEN);
		endpoints.exceptionTranslator(exception -> {
			if (exception instanceof OAuth2Exception) {
				OAuth2Exception oAuth2Exception = (OAuth2Exception) exception;
				return ResponseEntity.status(oAuth2Exception.getHttpErrorCode())
						.body(new OAuthException(oAuth2Exception.getMessage()));
			} else {
				throw exception;
			}
		});
	}

	/**
	 * TokenEnhancer For OAuth.
	 *
	 * @return the token enhancer
	 */
	@Bean
	public TokenEnhancer tokenEnhancer() {
		return (accessToken, authentication)-> accessToken;
	}

	/**
	 * TokenStore For OAuth.
	 *
	 * @return the token store
	 */
	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	/**
	 * DefaultTokenServices For OAuth.
	 *
	 * @return the default token services
	 */
	@Bean
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setSupportRefreshToken(true);
		defaultTokenServices.setAccessTokenValiditySeconds(OAuthConstant.ACCESS_TOKEN_VALIDITY_SECONDS);
		defaultTokenServices.setRefreshTokenValiditySeconds(OAuthConstant.REFRESH_TOKEN_VALIDITY_SECONDS);
		return defaultTokenServices;
	}

}