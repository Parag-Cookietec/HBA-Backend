/**
 * 
 */
package gov.ifms.edp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * The EDPApplication class for start project.
 * 
 * @version 1.0
 * @created 2019/07/26 15:15:38
 */

@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(EDPApplication.class);

	public static void main(String[] args) {
		LOGGER.info("==========EDPApplication main method execution  ==========");
		SpringApplication.run(EDPApplication.class, args);
	}

}