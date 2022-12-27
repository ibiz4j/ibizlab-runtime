package cn.ibizlab.devsimul;

import com.alibaba.nacos.api.PropertyKeyConst;
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
    @Value("${ibiz.ref.service.notify:ibznotify-api}")
    private String notifyapi;
    @Value("${ibiz.ref.service.pay:ibzpay-api}")
    private String payapi;

    @Value("${ibiz.ref.gateway.rt:ibzrt-web}")
    private String rtgw;


    @Value("${spring.cloud.nacos.discovery.group:DEFAULT_GROUP}")
    private String group;

    @Value("${spring.cloud.nacos.discovery.namespace:}")
    private String namespace;

    @Override
    public void run(ApplicationArguments args) {
        try {
            Thread.sleep(10000);
            Properties properties = new Properties();
            properties.setProperty("serverAddr", serverAddr);
            if(StringUtils.hasLength(namespace))
                properties.setProperty(PropertyKeyConst.NAMESPACE, namespace);

            NamingService naming = NamingFactory.createNamingService(properties);

            Instance instance = naming.selectOneHealthyInstance(serviceName,group);
            if(instance!=null&&(!StringUtils.isEmpty(instance.getIp())))
            {
                naming.registerInstance(rtgw, group, instance);
                naming.registerInstance(uaaapi, group, instance);
                naming.registerInstance(ouapi, group, instance);
                naming.registerInstance(wfapi, group, instance);
                naming.registerInstance(taskapi, group, instance);
                naming.registerInstance(dictapi, group, instance);
                naming.registerInstance(diskapi, group, instance);
                naming.registerInstance(notifyapi, group, instance);
                naming.registerInstance(payapi, group, instance);
            }
        }
        catch (Exception ex) {
            log.error(String.format("开发模式模拟微服务注册失败：",ex));
        }
    }
}