package gov.ifms.common.scheduler.util;

import org.springframework.context.annotation.Configuration;

@Configuration("schedulerConstant")
public class SchedulerConstant {

    public static final String SIMPLE_CRON = "simple_cron";

    public static final String SIMPLE_FIX_RATE = "simple_fix_rate";
    
    public static final String GRANT_COMMON_CRON = "grant_common_cron";

    public static final String GRANT_SURRENDER_CRON = "grant_surrender_cron";
    
    public static final String PAO_RELEASE_COUNTER_CRON = "pao_release_counter_cron";


}
