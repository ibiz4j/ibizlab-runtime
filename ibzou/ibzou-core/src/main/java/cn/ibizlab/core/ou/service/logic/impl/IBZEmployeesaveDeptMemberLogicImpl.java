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

import cn.ibizlab.core.ou.service.logic.IIBZEmployeesaveDeptMemberLogic;
import cn.ibizlab.core.ou.domain.IBZEmployee;

/**
 * 关系型数据实体[saveDeptMember] 对象
 */
@Slf4j
@Service
public class IBZEmployeesaveDeptMemberLogicImpl implements IIBZEmployeesaveDeptMemberLogic{

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private cn.ibizlab.core.ou.service.IIBZDeptMemberService ibzdeptmemberservice;

    public cn.ibizlab.core.ou.service.IIBZDeptMemberService getIbzdeptmemberService() {
        return this.ibzdeptmemberservice;
    }


    @Autowired
    private cn.ibizlab.core.ou.service.IIBZEmployeeService iBzSysDefaultService;

    public cn.ibizlab.core.ou.service.IIBZEmployeeService getIBzSysDefaultService() {
        return this.iBzSysDefaultService;
    }

    public void execute(IBZEmployee et){

          KieSession kieSession = null;
        try{
           kieSession=kieContainer.newKieSession();
           kieSession.insert(et); 
           kieSession.setGlobal("ibzemployeesavedeptmemberdefault",et);
           cn.ibizlab.core.ou.domain.IBZDeptMember  ibzemployeesavedeptmembermember =new cn.ibizlab.core.ou.domain.IBZDeptMember();
           kieSession.insert(ibzemployeesavedeptmembermember); 
           kieSession.setGlobal("ibzemployeesavedeptmembermember",ibzemployeesavedeptmembermember);
           kieSession.setGlobal("ibzdeptmemberservice",ibzdeptmemberservice);
           kieSession.setGlobal("iBzSysIbzemployeeDefaultService",iBzSysDefaultService);
           kieSession.setGlobal("curuser", cn.ibizlab.util.security.AuthenticationUser.getAuthenticationUser());
           kieSession.startProcess("cn.ibizlab.core.ou.service.logic.ibzemployeesavedeptmember");

        }catch(Exception e){
            throw new RuntimeException("执行[保存人事关系]处理逻辑发生异常"+e);
        }finally {
            if(kieSession!=null)
            kieSession.destroy();
        }
    }

}
