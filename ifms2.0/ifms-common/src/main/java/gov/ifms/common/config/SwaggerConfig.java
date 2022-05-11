package gov.ifms.common.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gov.ifms.common.constant.URLConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.google.common.collect.Lists;

import gov.ifms.common.constant.CommonConstant;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The SwaggerConfig class for spring configuration.
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableSwagger2
public class SwaggerConfig {

	@Value("${enableSwagger:true}")
	private boolean enableSwagger;

	/**
	 * Swagger Config.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName(CommonConstant.IFMS).enable(enableSwagger).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build()
				.securitySchemes(Lists.newArrayList(apiKey())).securityContexts(Arrays.asList(securityContext()));
	}

	/**
	 * @return
	 */
	@Bean
	public Docket commonWfApiV10() {
		return new Docket(DocumentationType.SWAGGER_2).groupName(CommonConstant.COMMON_WF_API_V10)
				.enable(enableSwagger)
				.select().apis(RequestHandlerSelectors.basePackage("gov.ifms.workflow.controller"))
				.paths(PathSelectors.regex(URLConstant.URL_ACTION_CONFIG_WORKFLOW+"/"+CommonConstant.V10+".*"))
				.build()
				.securitySchemes(Lists.newArrayList(apiKey())).securityContexts(Arrays.asList(securityContext()));
	}

	/**
	 * @return
	 */
	@Bean
	public Docket commonWfApiV30() {
		return new Docket(DocumentationType.SWAGGER_2).groupName(CommonConstant.COMMON_WF_API_V30)
				.enable(enableSwagger)
				.select().apis(RequestHandlerSelectors.basePackage("gov.ifms.workflow.controller"))
				.paths(PathSelectors.regex(URLConstant.URL_ACTION_CONFIG_WORKFLOW+".*/"+CommonConstant.V30+".*"))
				.build()
				.securitySchemes(Lists.newArrayList(apiKey())).securityContexts(Arrays.asList(securityContext()));
	}

	/**
	 * Security For Config.
	 *
	 * @return the security configuration
	 */
	@Bean
	public SecurityConfiguration security() {
		return SecurityConfigurationBuilder.builder().scopeSeparator(CommonConstant.SCOPE_SEPARATOR).additionalQueryStringParams(null)
				.useBasicAuthenticationWithAccessCodeGrant(false).build();
	}

	/**
	 * Security Config For Swagger.
	 *
	 * @return the security context
	 */
	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
	}

	/**
	 * Default auth.
	 *
	 * @return the list
	 */
	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope(CommonConstant.GLOBAL, CommonConstant.ACCESS_EVERYTHING);
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference(CommonConstant.AUTHORIZATION, authorizationScopes));
	}

	/**
	 * Header For Swagger.
	 *
	 * @return the list
	 */
	private List<ApiKey> apiKey() {
		List<ApiKey> apiKeys = new ArrayList<>();
		apiKeys.add(new ApiKey(CommonConstant.AUTHORIZATION,CommonConstant.AUTHORIZATION, CommonConstant.HEADER));
		return apiKeys;
	}

	/**
	 * Message Source Config.
	 *
	 * @return the message source
	 */
	@Bean
	public static MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames(CommonConstant.CLASSPATH_CONFIG_COMMONCONFIG,CommonConstant.CLASSPATH_MESSAGES_LBL,CommonConstant.CLASSPATH_CONFIG_EMAIL,CommonConstant.CLASSPATH_MESSAGES_RECEIPT,CommonConstant.CLASSPATH_MESSAGES_ERA,CommonConstant.CLASSPATH_MESSAGES_PVU);
		messageSource.setDefaultEncoding(CommonConstant.UTF_8);
		return messageSource;
	}

}