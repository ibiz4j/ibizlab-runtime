package cn.ibizlab.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import cn.ibizlab.util.web.SearchContextHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Slf4j
@Import({
    FeignClientsConfiguration.class
})
@EnableDiscoveryClient
@Configuration
@EnableFeignClients(basePackages = {"cn.ibizlab" })
@EnableZuulProxy
@ComponentScan(basePackages = {"cn.ibizlab.web","cn.ibizlab.util"})
@MapperScan("cn.ibizlab.*.mapper")
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
            com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure.class
})
public class webApplication extends WebMvcConfigurerAdapter {

    @Autowired
    SearchContextHandlerMethodArgumentResolver resolver;

    public static void main(String[] args) {
        SpringApplication.run(webApplication.class, args);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(resolver);
    }
}
