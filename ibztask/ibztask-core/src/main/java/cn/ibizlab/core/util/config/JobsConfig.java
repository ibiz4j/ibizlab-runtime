package cn.ibizlab.core.util.config;

import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.WaitStrategy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobsConfig {

    @Bean
    public WaitStrategy waitStrategy() {
        return new SleepingWaitStrategy(200,1000*1000*10);
    }
}
