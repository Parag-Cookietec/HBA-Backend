package gov.ifms.workflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.concurrent.Executor;

/**
 * The WorkflowApplication class for start project.
 * 
 * @version 1.0
 * @created 2019/07/26 15:15:38
 */

@SpringBootApplication
@EnableAsync(proxyTargetClass = true)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WorkflowApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkflowApplication.class);

	public static void main(String[] args) {
		LOGGER.info("==========WorkflowApplication main method execution  ==========");
		SpringApplication.run(WorkflowApplication.class, args);
	}

	@Bean(name = "asyncExecutor")
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);
		executor.setMaxPoolSize(3);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("AsynchThread - ");
		executor.initialize();
		return executor;
	}
}

