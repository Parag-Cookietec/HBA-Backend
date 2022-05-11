/*
 *
 */
package gov.ifms.edp.oauth.config;
import static gov.ifms.edp.oauth.util.OAuthConstant.RESOURCE_ID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import gov.ifms.edp.oauth.util.OAuthConstant;

/**
 * The Class ResourceServerConfig.
 *
 * @Description: ResourceServerconfiguration for any request mapping and role
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	 private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	/** The environment. */
	@Autowired
	private Environment environment;
	
	

	/**
	 * Configure.
	 *
	 * @param resources the resources
	 */
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	/**
	 * Configure. URL Configure For Access
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		String oauthEnabled = environment.getProperty(OAuthConstant.SPRING_OAUTH_ENABLED);
		http.headers().frameOptions().sameOrigin();
		if (OAuthConstant.TRUE.equalsIgnoreCase(oauthEnabled) || oauthEnabled == null) {
			http.authorizeRequests()
					.antMatchers("edp/oauth/token/**", "/v2/*", "/swagger-ui.html", "/actuator/*", "/configuration/ui",
							"/swagger-resources", "/configuration/security", "/webjars/**",
							"/swagger-resources/configuration/ui", "/swagger-resources/configuration/security",
							"/edp/oauth/forgotpassword", "/edp/oauth/verifypasstoken", "/edp/oauth/newpassword",
							"/edp/oauth/captcha")
					.permitAll().anyRequest().authenticated().and().formLogin().and().httpBasic().disable();
		} else {
			http.sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry()).and()
					.sessionCreationPolicy(SessionCreationPolicy.NEVER).and().authorizeRequests().anyRequest()
					.permitAll().and().formLogin().and().httpBasic().disable();
		}
	}

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@SuppressWarnings("rawtypes")
	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		logger.info("####Environment Details - " + System.getProperty("spring.profiles.active"));
		if (StringUtils.isEmpty(System.getProperty("spring.profiles.active"))
				|| StringUtils.equals("", "spring.profiles.active")) {
			config.addAllowedOrigin("*");
		} else {
			logger.info("####Not added header parameters");
		}
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		@SuppressWarnings("unchecked")
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	 
}

