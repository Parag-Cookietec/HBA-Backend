package gog.ifms;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;

@SpringBootApplication

@ComponentScan(basePackages = { "gov.ifms.common", "gov.ifms.edp", "gov.ifms.workflow", "gov.ifms.pvu","gov.ifms.loc","gov.ifms.dmo","gov.ifms.gst","gov.ifms.doi"})
@EntityScan(basePackages = { "gov.ifms.common", "gov.ifms.edp", "gov.ifms.workflow", "gov.ifms.pvu", "gov.ifms.loc","gov.ifms.dmo","gov.ifms.gst","gov.ifms.doi"})
@EnableJpaRepositories(basePackages = {"gov.ifms.common", "gov.ifms.edp", "gov.ifms.workflow","gov.ifms.pvu","gov.ifms.loc","gov.ifms.dmo","gov.ifms.gst","gov.ifms.doi"})
@EnableCaching
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30M")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Application extends SpringBootServletInitializer {

	
	
	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		LOG.info("************START Web************");
		SpringApplication.run(Application.class);
		LOG.info("************END Web*****************");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}