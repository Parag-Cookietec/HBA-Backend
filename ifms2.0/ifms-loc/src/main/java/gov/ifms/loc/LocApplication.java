package gov.ifms.loc;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * The BudgetApplication class for start project.
 * 
 * @version 1.0
 * @created 2019/07/26 15:15:39
 */

@SpringBootApplication
@EnableAsync(proxyTargetClass = true)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(LocApplication.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		LOGGER.info("==========BudgetApplication main method execution  ==========");
		SpringApplication.run(LocApplication.class);
	}
	
	
	/**
	 * Loc async executor.
	 *
	 * @return the executor
	 */
	@Bean(name = "locAsyncExecutor")
	public Executor locAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);
		executor.setMaxPoolSize(3);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("LocAsynchThread - ");
		executor.afterPropertiesSet();
		return new DelegatingSecurityContextAsyncTaskExecutor(executor);
	}


}
