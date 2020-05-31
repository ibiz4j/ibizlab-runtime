package cn.ibizlab.util.job;

import cn.ibizlab.util.client.IBZUAAFeignClient;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.io.InputStream;

/**
 * 权限：向uaa同步当前系统菜单、权限资源任务类
 */
@Slf4j
@Component
public class PermissionSyncJob implements ApplicationRunner {


    @Autowired
    @Lazy
    private IBZUAAFeignClient client;



    @Override
    public void run(ApplicationArguments args) {
        try {
            Thread.sleep(20000);
            InputStream permission= this.getClass().getResourceAsStream("/permission/ibzuaaResource.json"); //获取当前系统所有实体资源能力
            JSONObject permissionResult = JSONObject.parseObject(IOUtils.toString(permission,"UTF-8"));
            JSONObject system= new JSONObject();
            permissionResult.remove("appmenus");
            permissionResult.remove("unires");
            system.put("sysstructure",permissionResult);
            system.put("pssystemid","ibzuaa");
            system.put("pssystemname","ibzuaa");
            if(client.syncSysAuthority(system)){
                log.info("向[UAA]同步系统资源成功");
            }else{
                log.error("向[UAA]同步系统资源失败");
            }
            permission.close();


            permission= this.getClass().getResourceAsStream("/permission/ibzouResource.json"); //获取当前系统所有实体资源能力
            permissionResult = JSONObject.parseObject(IOUtils.toString(permission,"UTF-8"));
            system= new JSONObject();
            permissionResult.remove("appmenus");
            permissionResult.remove("unires");
            system.put("sysstructure",permissionResult);
            system.put("pssystemid","ibzou");
            system.put("pssystemname","ibzou");
            if(client.syncSysAuthority(system)){
                log.info("向[UAA]同步系统资源成功");
            }else{
                log.error("向[UAA]同步系统资源失败");
            }
            permission.close();

            permission= this.getClass().getResourceAsStream("/permission/ibzwfResource.json"); //获取当前系统所有实体资源能力
            permissionResult = JSONObject.parseObject(IOUtils.toString(permission,"UTF-8"));
            system= new JSONObject();
            permissionResult.remove("appmenus");
            permissionResult.remove("unires");
            system.put("sysstructure",permissionResult);
            system.put("pssystemid","ibzwf");
            system.put("pssystemname","ibzwf");
            if(client.syncSysAuthority(system)){
                log.info("向[UAA]同步系统资源成功");
            }else{
                log.error("向[UAA]同步系统资源失败");
            }
            permission.close();


            permission= this.getClass().getResourceAsStream("/permission/ibzrtResource.json"); //获取当前系统所有实体资源能力
            permissionResult = JSONObject.parseObject(IOUtils.toString(permission,"UTF-8"));
            system= new JSONObject();
            permissionResult.remove("entities");
            permissionResult.remove("unires");
            system.put("sysstructure",permissionResult);
            system.put("pssystemid","ibzrt");
            system.put("pssystemname","ibzrt");
            if(client.syncSysAuthority(system)){
                log.info("向[UAA]同步系统资源成功");
            }else{
                log.error("向[UAA]同步系统资源失败");
            }
            permission.close();

        }
        catch (Exception ex) {
            log.error(String.format("向[UAA]同步系统资源失败，请检查[UAA]服务是否正常! [%s]",ex));
        }
    }
}