package cn.ibizlab;

import lombok.extern.slf4j.Slf4j;
import org.flowable.ui.common.service.idm.RemoteIdmService;
import org.flowable.ui.modeler.properties.FlowableModelerAppProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.List;

@Slf4j
@EnableDiscoveryClient
@Configuration
@EnableTransactionManagement
@EnableFeignClients(basePackages = {"cn.ibizlab" })
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
@SpringBootApplication(exclude = {
            org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration.class,
})
public class DevBootApplication extends WebMvcConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(DevBootApplication.class,args);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new cn.ibizlab.util.web.SearchContextHandlerMethodArgumentResolver());
    }
}
