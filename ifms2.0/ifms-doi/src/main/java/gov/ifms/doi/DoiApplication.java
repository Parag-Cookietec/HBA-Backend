package gov.ifms.doi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * The DoiApplication class for start project.
 * 
 * @version 1.0
 * @created 2021/08/29
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
        )
public class DoiApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DoiApplication.class);

	public static void main(String[] args) {
		LOGGER.info("==========DOI main method execution  ==========");
		SpringApplication.run(DoiApplication.class);
	}

}
