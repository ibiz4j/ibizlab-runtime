package cn.ibizlab.core.util.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;

@ConditionalOnExpression("!'${jobs.admin-address:NA}'.equals('NA')")
@Configuration
public class XxlJobConfig {

}
