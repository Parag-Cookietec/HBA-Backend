package gov.ifms.common.scheduler.config;


import gov.ifms.common.scheduler.entity.MsCMNSchedulerEntity;
import gov.ifms.common.scheduler.repository.MsCMNSchedulerRepository;
import gov.ifms.common.util.Constant;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@Configuration("scheduler")
public class SchedulerConfig implements SchedulingConfigurer {

    @Autowired
    private MsCMNSchedulerRepository msCMNSchedulerRepository;

    private static Map<String ,String> scheduler = new HashMap<>();

    @PostConstruct
    public void getAllScheduler() {
        List<MsCMNSchedulerEntity> msCMNSchedulerEntities = msCMNSchedulerRepository.findByActiveStatus(Constant.ACTIVE_STATUS);
        scheduler = msCMNSchedulerEntities.stream()
                .collect(Collectors.toMap(MsCMNSchedulerEntity::getSchedulerName, MsCMNSchedulerEntity::getConfigVal));

    }


    public String getCronValue(String str) {
        return !StringUtils.isEmpty(scheduler.get(str)) ? scheduler.get(str) :"-";
    }


    public String getFixedRateValue(String str) {
        return !StringUtils.isEmpty(scheduler.get(str)) ?  scheduler.get(str) : "PT23H";
    }



    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);
        scheduler.setThreadNamePrefix("scheduled-task-pool-");
        scheduler.initialize();
        taskRegistrar.setTaskScheduler(scheduler);
    }

    @Bean
    public LockProvider lockProvider(DataSource dataSource) {
        return new JdbcTemplateLockProvider(JdbcTemplateLockProvider.Configuration.builder()
                .withJdbcTemplate(new JdbcTemplate(dataSource)).
                        withTableName("MASTER_V1.SHEDLOCK").build()
        );
    }

}
