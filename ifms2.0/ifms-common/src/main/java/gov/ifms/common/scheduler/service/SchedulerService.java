package gov.ifms.common.scheduler.service;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class SchedulerService {


    private static Logger logger = LoggerFactory.getLogger(SchedulerService.class);


    @Scheduled(cron = "#{@scheduler.getCronValue(schedulerConstant.SIMPLE_CRON)}")
    @SchedulerLock(name = "#{@schedulerConstant.SIMPLE_CRON}", lockAtLeastFor = "60S", lockAtMostFor = "75S")
    public void cronScheduler(){
        logger.info("Cron Expression Current time is :: " + Calendar.getInstance().getTime());
    }


    @Scheduled(fixedRateString = "#{@scheduler.getFixedRateValue(schedulerConstant.SIMPLE_FIX_RATE)}")
    @SchedulerLock(name = "#{@schedulerConstant.SIMPLE_FIX_RATE}", lockAtLeastFor = "60S", lockAtMostFor = "75S")
    public void fixedRateScheduler() {
        logger.info("Fixed Rate Current time is :: " + Calendar.getInstance().getTime());
    }

}
