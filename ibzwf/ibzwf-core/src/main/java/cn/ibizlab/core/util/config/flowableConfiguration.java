package cn.ibizlab.core.util.config;

import org.flowable.ui.common.service.idm.RemoteIdmService;
import org.flowable.ui.modeler.properties.FlowableModelerAppProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@EnableConfigurationProperties(FlowableModelerAppProperties.class)
@ComponentScan(
		basePackages = { "cn.ibizlab",
				"org.flowable.ui.modeler.repository",
				"org.flowable.ui.modeler.service",
				"org.flowable.ui.common.service",
				"org.flowable.ui.common.repository",
				"org.flowable.ui.common.tenant" },
		excludeFilters = { @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = RemoteIdmService.class), }
)
@Configuration
public class flowableConfiguration
{

}
