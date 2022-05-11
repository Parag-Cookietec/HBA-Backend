package gov.ifms.edp.oauth.config;


import gov.ifms.edp.oauth.service.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


/**
 * The Class SecurityConfiguration.
 *
 * @version : 0.01
 * @Description: OAuth2 configuration and filter configuration.
 * @date : 24 JUNE 2019
 */


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{



    /** The client details service. */
    @Autowired
    private ClientDetailsService clientDetailsService;


    /** The oauth service. */
    @Autowired
    private OAuthService oauthService;


    /**
     * Authentication manager bean.
     *
     * @return the authentication manager
     * @throws Exception the exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
    	 return super.authenticationManagerBean();
    }

    /**
     * Global user details.
     *
     * @param auth the auth
     * @throws Exception the exception
     */
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(oauthService).passwordEncoder(encoder());
    }


    /**
     * Configure.
     *
     * @param http the http
     * @throws Exception the exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin();
        http.csrf().
                csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .disable().authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/edp/oauth/token").permitAll()
                .antMatchers("/tokens/**", "/v2/api-docs", "/v2/*", "/swagger-ui.html/*", "/actuator/*", "/configuration/**", "/swagger-resources/**",
                        "/swagger-ui.html", "/webjars/**", "/api-docs/**", "/edp/oauth/forgotpassword", "/edp/oauth/verifypasstoken" ,"/edp/oauth/newpassword", "/edp/oauth/captcha")
                .permitAll();
        http.authorizeRequests().anyRequest().authenticated().and().sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true)
                .and().sessionCreationPolicy(SessionCreationPolicy.NEVER);


    }


    /**
     * Encoder.
     *
     * @return the b crypt password encoder
     */
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * Configure.
     *
     * @param web the web
     * @throws Exception the exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**", "/v2/api-docs", "/configuration/**", "/swagger-resources/**", "/swagger-ui.html",
                "/webjars/**", "/api-docs/**");


    }


    /**
     * User approval handler.
     *
     * @param tokenStore the token store
     * @return the token store user approval handler
     */
    @Bean
    @Autowired
    public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore) {


        TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
        handler.setTokenStore(tokenStore);
        handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
        handler.setClientDetailsService(clientDetailsService);
        return handler;
    }


    /**
     * Approval store.
     *
     * @param tokenStore the token store
     * @return the approval store
     */
    @Bean
    @Autowired
    public ApprovalStore approvalStore(TokenStore tokenStore) {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore);
        return store;
    }


}