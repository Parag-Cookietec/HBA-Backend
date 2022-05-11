/**
 * 
 */
package gov.ifms.pvu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
/**
 * The BudgetApplication class for start project.
 * 
 * @version 1.0
 * @created 2019/07/26 15:15:39
 */

@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(PVUApplication.class);

	public static void main(String[] args) {
		LOGGER.info("==========BudgetApplication main method execution  ==========");
		SpringApplication.run(PVUApplication.class, args);
	}
	

}
