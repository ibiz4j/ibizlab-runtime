package cn.ibizlab.core.uaa.service.logic.impl;

import java.util.Map;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieContainer;
import cn.ibizlab.core.uaa.service.logic.ISysUsersaveSysUserLogic;
import cn.ibizlab.core.uaa.domain.SysUser;

/**
 * 关系型数据实体[saveSysUser] 对象
 */
@Slf4j
@Service
public class SysUsersaveSysUserLogicImpl implements ISysUsersaveSysUserLogic {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.core.uaa.service.ISysUserService sysuserservice;

    public cn.ibizlab.core.uaa.service.ISysUserService getSysuserService() {
        return this.sysuserservice;
    }


    @Autowired
    private cn.ibizlab.core.uaa.service.ISysUserService iBzSysDefaultService;

    public cn.ibizlab.core.uaa.service.ISysUserService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    @Override
    public void execute(SysUser et) {

        KieSession kieSession = null;
        try {
            kieSession = kieContainer.newKieSession();
            kieSession.insert(et); 
            kieSession.setGlobal("sysusersavesysuserdefault", et);
            kieSession.setGlobal("sysuserservice", sysuserservice);
            kieSession.setGlobal("iBzSysSysuserDefaultService", iBzSysDefaultService);
            kieSession.setGlobal("curuser", cn.ibizlab.util.security.AuthenticationUser.getAuthenticationUser());
            kieSession.startProcess("cn.ibizlab.core.uaa.service.logic.sysusersavesysuser");

        } catch (Exception e) {
            throw new RuntimeException("执行[保存用户信息]处理逻辑发生异常" + e);
        } finally {
            if(kieSession != null) {
                kieSession.destroy();
            }
        }
    }
}
