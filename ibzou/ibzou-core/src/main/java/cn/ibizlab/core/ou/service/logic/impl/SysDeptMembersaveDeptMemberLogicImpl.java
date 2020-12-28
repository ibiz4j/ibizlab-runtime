package cn.ibizlab.core.ou.service.logic.impl;

import java.util.Map;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieContainer;
import cn.ibizlab.core.ou.service.logic.ISysDeptMembersaveDeptMemberLogic;
import cn.ibizlab.core.ou.domain.SysDeptMember;

/**
 * 关系型数据实体[saveDeptMember] 对象
 */
@Slf4j
@Service
public class SysDeptMembersaveDeptMemberLogicImpl implements ISysDeptMembersaveDeptMemberLogic {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.core.ou.service.ISysDeptMemberService sysdeptmemberservice;

    public cn.ibizlab.core.ou.service.ISysDeptMemberService getSysdeptmemberService() {
        return this.sysdeptmemberservice;
    }


    @Autowired
    private cn.ibizlab.core.ou.service.ISysDeptMemberService iBzSysDefaultService;

    public cn.ibizlab.core.ou.service.ISysDeptMemberService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    @Override
    public void execute(SysDeptMember et) {

        KieSession kieSession = null;
        try {
            kieSession = kieContainer.newKieSession();
            kieSession.insert(et); 
            kieSession.setGlobal("sysdeptmembersavedeptmemberdefault", et);
            kieSession.setGlobal("sysdeptmemberservice", sysdeptmemberservice);
            kieSession.setGlobal("iBzSysSysdeptmemberDefaultService", iBzSysDefaultService);
            kieSession.setGlobal("curuser", cn.ibizlab.util.security.AuthenticationUser.getAuthenticationUser());
            kieSession.startProcess("cn.ibizlab.core.ou.service.logic.sysdeptmembersavedeptmember");

        } catch (Exception e) {
            throw new RuntimeException("执行[保存部门成员]处理逻辑发生异常" + e);
        } finally {
            if(kieSession != null) {
                kieSession.destroy();
            }
        }
    }
}
