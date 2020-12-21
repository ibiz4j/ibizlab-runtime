package cn.ibizlab.util.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.master")
public class LiquibaseProp{

    private  String url;

    private  String username;

    private  String password;

    private  String isSyncDBSchema;

    private  String defaultSchema;

    private  String  conf;
}