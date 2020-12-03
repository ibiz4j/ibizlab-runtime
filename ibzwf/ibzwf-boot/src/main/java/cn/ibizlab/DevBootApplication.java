package cn.ibizlab;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.util.List;
import cn.ibizlab.util.web.SearchContextHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@EnableDiscoveryClient
@Configuration
@EnableTransactionManagement
@EnableFeignClients(basePackages = {"cn.ibizlab" })
@SpringBootApplication(exclude = {
})
@ComponentScan(basePackages = {"cn.ibizlab"}
//        ,excludeFilters = {
//                @ComponentScan.Filter(type= org.springframework.context.annotation.FilterType.REGEX, pattern="cn.ibizlab.xxx.rest.xxx"),
//        }
)
@Import({
        org.springframework.cloud.openfeign.FeignClientsConfiguration.class
})
@EnableAsync
@EnableScheduling
public class DevBootApplication extends WebMvcConfigurerAdapter {

    @Autowired
    SearchContextHandlerMethodArgumentResolver resolver;

    public static void main(String[] args) {
        SpringApplication.run(DevBootApplication.class, args);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(resolver);
    }
}
