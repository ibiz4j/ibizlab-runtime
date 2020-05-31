package cn.ibizlab.devsimul;

import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Properties;

@Slf4j
@Component
public class DevNamingRegister implements ApplicationRunner {

    @Value("${spring.cloud.nacos.discovery.server-addr:127.0.0.1:8848}")
    private String serverAddr;

    @Value("${spring.application.name:ibzrt}")
    private String serviceName;

    @Value("${server.port:10086}")
    private Integer port;

    @Override
    public void run(ApplicationArguments args) {
        try {
            Thread.sleep(10000);
            Properties properties = new Properties();
            properties.setProperty("serverAddr", serverAddr);

            NamingService naming = NamingFactory.createNamingService(properties);

            Instance instance = naming.selectOneHealthyInstance(serviceName);
            if(instance!=null&&(!StringUtils.isEmpty(instance.getIp())))
            {
                naming.registerInstance("ibzuaa-api", instance.getIp(), port);
                naming.registerInstance("ibzou-api", instance.getIp(), port);
                naming.registerInstance("ibzwf-api", instance.getIp(), port);
                naming.registerInstance("ibzdisk-api", instance.getIp(), port);
            }
        }
        catch (Exception ex) {
            log.error(String.format("开发模式模拟微服务注册失败：",ex));
        }
    }
}