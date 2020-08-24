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



    @Value("${ibiz.ref.service.wf:ibzwf-api}")
    private String wfapi;
    @Value("${ibiz.ref.service.uaa:ibzuaa-api}")
    private String uaaapi;
    @Value("${ibiz.ref.service.ou:ibzou-api}")
    private String ouapi;
    @Value("${ibiz.ref.service.task:ibztask-api}")
    private String taskapi;
    @Value("${ibiz.ref.service.dict:ibzdict-api}")
    private String dictapi;
    @Value("${ibiz.ref.service.disk:ibzdisk-api}")
    private String diskapi;
    @Value("${ibiz.ref.gateway.rt:ibzrt-web}")
    private String rtgw;


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
                naming.registerInstance(rtgw, instance);
                naming.registerInstance(uaaapi, instance);
                naming.registerInstance(ouapi, instance);
                naming.registerInstance(wfapi, instance);
                naming.registerInstance(taskapi, instance);
                naming.registerInstance(dictapi, instance);
                naming.registerInstance(diskapi, instance);
            }
        }
        catch (Exception ex) {
            log.error(String.format("开发模式模拟微服务注册失败：",ex));
        }
    }
}