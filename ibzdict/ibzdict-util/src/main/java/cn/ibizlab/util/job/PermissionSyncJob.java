package cn.ibizlab.util.job;

import cn.ibizlab.util.client.IBZUAAFeignClient;
import cn.ibizlab.util.client.IBZLiteFeignClient;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
import java.io.InputStream;
import java.util.*;

/**
 * 权限：向uaa同步当前系统菜单、权限资源任务类
 */
@Slf4j
@Component
@ConditionalOnProperty( name = "ibiz.enablePermissionValid", havingValue = "true")
public class PermissionSyncJob implements ApplicationRunner {

    @Value("${ibiz.systemid:ibzdict}")
    private String systemId;
    
    @Value("${ibiz.systemname:ibzdict}")
    private String systemName;

    @Autowired
    @Lazy
    private IBZUAAFeignClient uaaClient;

    @Autowired
    @Lazy
    IBZLiteFeignClient liteClient;

    @Override
    public void run(ApplicationArguments args) {
        try {
            Thread.sleep(10000);
            InputStream permission = this.getClass().getResourceAsStream("/permission/systemResource.json"); //权限资源
            if (!ObjectUtils.isEmpty(permission)) {
                String strPermission = IOUtils.toString(permission, "UTF-8");
                JSONObject system = new JSONObject() {{
                    put("pssystemid", systemId);
                    put("pssystemname", systemName);
                    put("sysstructure", JSONObject.parseObject(strPermission));
                    put("md5check", DigestUtils.md5DigestAsHex(strPermission.getBytes()));
                }};
                if (uaaClient.syncSysAuthority(system)) {
                    log.info("向[uaa]同步系统资源成功");
                } else {
                    log.error("向[uaa]同步系统资源失败");
                }
            }
        } catch (Exception ex) {
            log.error("向[uaa]同步系统资源失败，请检查[uaa]服务是否正常运行! {}", ex.getMessage());
        }

        try {
            InputStream model = this.getClass().getResourceAsStream("/sysmodel/ibzdict.json"); //系统模型
            if (!ObjectUtils.isEmpty(model)) {
                String strModel = IOUtils.toString(model, "UTF-8");
                if (liteClient.syncSysModel(JSONObject.parseObject(strModel))) {
                    log.info("向[lite]同步模型成功");
                } else {
                    log.error("向[lite]同步模型失败");
                }
            }
        } catch (Exception ex) {
            log.error("向[lite]同步系统模型失败，请检查[lite]服务是否正常运行! {}", ex.getMessage());
        }
    }
}