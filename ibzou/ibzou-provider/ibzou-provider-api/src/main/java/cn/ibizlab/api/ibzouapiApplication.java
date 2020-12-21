package cn.ibizlab.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import cn.ibizlab.util.web.SearchContextHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Slf4j
@EnableDiscoveryClient
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"cn.ibizlab"}
//        ,excludeFilters={
//                @ComponentScan.Filter(type= org.springframework.context.annotation.FilterType.REGEX,pattern="cn.ibizlab.api.rest.xxx"),
//        }
)
@EnableMongoRepositories(basePackages = {"cn.ibizlab"})
@MapperScan("cn.ibizlab.*.mapper")
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
            org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration.class,
            com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure.class
})
@Import({
        org.springframework.cloud.openfeign.FeignClientsConfiguration.class
})
@EnableFeignClients(basePackages = {"cn.ibizlab" })
@EnableAsync
@EnableScheduling
public class ibzouapiApplication extends WebMvcConfigurerAdapter{

    @Autowired
    SearchContextHandlerMethodArgumentResolver resolver;

    public static void main(String[] args) {
        SpringApplication.run(ibzouapiApplication.class, args);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(resolver);
    }
}
