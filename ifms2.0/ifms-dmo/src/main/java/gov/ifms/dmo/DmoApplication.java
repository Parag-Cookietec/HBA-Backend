package gov.ifms.dmo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * The ReceiptApplication class for start project.
 * 
 * @version 1.0
 * @created 2019/07/26 15:15:39
 */

@SpringBootApplication
@ConfigurationProperties
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DmoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DmoApplication.class);

	public static void main(String[] args) {
		LOGGER.info("==========ReceiptApplication main method execution  ==========");
		SpringApplication.run(DmoApplication.class);
	}

	@Bean
	public LocalValidatorFactoryBean validator(MessageSource messageSource) {
		LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
		validatorFactoryBean.setValidationMessageSource(messageSource);
		return validatorFactoryBean;
	}

}
