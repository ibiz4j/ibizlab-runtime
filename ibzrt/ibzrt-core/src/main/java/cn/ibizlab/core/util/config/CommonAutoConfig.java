package cn.ibizlab.core.util.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 通用配置类
 */
@Configuration
public class CommonAutoConfig {

    @Value("${jbpm.enable.multi.con:true}")
    private  String flag;

    /**
     * 处理逻辑节点支持多来源配置
     */
    @Component
    public class InstallSystemParamsCommandLineRunner implements CommandLineRunner {

        @Override
        public void run(String... var1){
            System.setProperty("jbpm.enable.multi.con", flag);
        }
    }
}
