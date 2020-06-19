package cn.ibizlab.util.job;

import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.extensions.domain.SysStructure;
import cn.ibizlab.core.uaa.service.ISysPSSystemService;
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
import java.util.ArrayList;

/**
 * 权限：向uaa同步当前系统菜单、权限资源任务类
 */
@Slf4j
@Component
public class PermissionSyncJob implements ApplicationRunner {


    @Autowired
    @Lazy
    private ISysPSSystemService systemService;



    @Override
    public void run(ApplicationArguments args) {
        try {
            Thread.sleep(30000);
            InputStream permission= this.getClass().getResourceAsStream("/permission/systemResource.json"); //获取当前系统所有实体资源能力
            SysStructure permissionResult = JSONObject.parseObject(IOUtils.toString(permission,"UTF-8"),SysStructure.class);
            SysPSSystem system= new SysPSSystem();
            permissionResult.setApps(new ArrayList<>());
            permissionResult.setUniResIds(new ArrayList<>());
            system.setSysstructure(permissionResult);
            system.setPssystemid("ibzuaa");
            system.setPssystemname("ibzuaa");
            if(systemService.save(system)){
                log.info("向[UAA]同步系统资源成功");
            }else{
                log.error("向[UAA]同步系统资源失败");
            }
            permission.close();


            permission= this.getClass().getResourceAsStream("/permission/ibzou/systemResource.json"); //获取当前系统所有实体资源能力
            permissionResult = JSONObject.parseObject(IOUtils.toString(permission,"UTF-8"),SysStructure.class);
            system= new SysPSSystem();
            permissionResult.setApps(new ArrayList<>());
            permissionResult.setUniResIds(new ArrayList<>());
            system.setSysstructure(permissionResult);
            system.setPssystemid("ibzou");
            system.setPssystemname("ibzou");
            if(systemService.save(system)){
                log.info("向[UAA]同步系统资源成功");
            }else{
                log.error("向[UAA]同步系统资源失败");
            }
            permission.close();

            permission= this.getClass().getResourceAsStream("/permission/ibzwf/systemResource.json"); //获取当前系统所有实体资源能力
            permissionResult = JSONObject.parseObject(IOUtils.toString(permission,"UTF-8"),SysStructure.class);
            system= new SysPSSystem();
            permissionResult.setApps(new ArrayList<>());
            permissionResult.setUniResIds(new ArrayList<>());
            system.setSysstructure(permissionResult);
            system.setPssystemid("ibzwf");
            system.setPssystemname("ibzwf");
            if(systemService.save(system)){
                log.info("向[UAA]同步系统资源成功");
            }else{
                log.error("向[UAA]同步系统资源失败");
            }
            permission.close();

            permission= this.getClass().getResourceAsStream("/permission/ibztask/systemResource.json"); //获取当前系统所有实体资源能力
            permissionResult = JSONObject.parseObject(IOUtils.toString(permission,"UTF-8"),SysStructure.class);
            system= new SysPSSystem();
            permissionResult.setApps(new ArrayList<>());
            permissionResult.setUniResIds(new ArrayList<>());
            system.setSysstructure(permissionResult);
            system.setPssystemid("ibztask");
            system.setPssystemname("ibztask");
            if(systemService.save(system)){
                log.info("向[UAA]同步系统资源成功");
            }else{
                log.error("向[UAA]同步系统资源失败");
            }
            permission.close();

            permission= this.getClass().getResourceAsStream("/permission/ibzrt/systemResource.json"); //获取当前系统所有实体资源能力
            permissionResult = JSONObject.parseObject(IOUtils.toString(permission,"UTF-8"),SysStructure.class);
            system= new SysPSSystem();
            permissionResult.setEntities(new ArrayList<>());
            permissionResult.setUniResIds(new ArrayList<>());
            system.setSysstructure(permissionResult);
            system.setPssystemid("ibzrt");
            system.setPssystemname("ibzrt");
            if(systemService.save(system)){
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