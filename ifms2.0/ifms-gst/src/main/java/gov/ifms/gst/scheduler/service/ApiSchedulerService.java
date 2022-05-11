package gov.ifms.gst.scheduler.service;

import gov.ifms.gst.integration.GSTIntegrationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class ApiSchedulerService {
    private static final Logger logger = LoggerFactory.getLogger(ApiSchedulerService.class);

    private final GSTIntegrationProperties properties;

    public ApiSchedulerService(GSTIntegrationProperties properties) {
        this.properties = properties;
    }

    //@Scheduled(fixedRate = 50000)
    public void readApi(){
        logger.info("Api Expression Current time is :: {} with api key {}." , Calendar.getInstance().getTime(),properties.getAppKey());
    }
}
