package cn.ibizlab.core.ou.service.logic.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieContainer;

import cn.ibizlab.core.ou.service.logic.ISysEmployeesaveDeptMemberLogic;
import cn.ibizlab.core.ou.domain.SysEmployee;

/**
 * 关系型数据实体[saveDeptMember] 对象
 */
@Slf4j
@Service
public class SysEmployeesaveDeptMemberLogicImpl implements ISysEmployeesaveDeptMemberLogic {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.core.ou.service.ISysDeptMemberService sysdeptmemberservice;

    public cn.ibizlab.core.ou.service.ISysDeptMemberService getSysdeptmemberService() {
        return this.sysdeptmemberservice;
    }


    @Autowired
    private cn.ibizlab.core.ou.service.ISysEmployeeService iBzSysDefaultService;

    public cn.ibizlab.core.ou.service.ISysEmployeeService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    @Override
    public void execute(SysEmployee et) {

          KieSession kieSession = null;
        try{
           kieSession = kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("sysemployeesavedeptmemberdefault", et);
           cn.ibizlab.core.ou.domain.SysDeptMember sysemployeesavedeptmembermember = new cn.ibizlab.core.ou.domain.SysDeptMember();
           kieSession.insert(sysemployeesavedeptmembermember); 
           kieSession.setGlobal("sysemployeesavedeptmembermember", sysemployeesavedeptmembermember);
           kieSession.setGlobal("sysdeptmemberservice", sysdeptmemberservice);
           kieSession.setGlobal("iBzSysSysemployeeDefaultService", iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.core.ou.service.logic.sysemployeesavedeptmember");

        }catch(Exception e) {
            throw new RuntimeException("执行[保存人事关系]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null) {
                kieSession.destroy();
            }
        }
    }

}
