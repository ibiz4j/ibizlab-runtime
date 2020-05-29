package cn.ibizlab.core.ou.extensions.aspect;

import cn.ibizlab.core.ou.extensions.service.OUModelService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 实体属性默认值切面，只有新建（Create）时才会填充默认值
 */
@Aspect
@Order(0)
@Component
public class OUModelRefreshAspect
{
    @Autowired
    @Lazy
    private OUModelService ouModelService;

    @After(value = "execution(* cn.ibizlab.core.ou.service.IIBZOrganizationService.creat*(..))")
    public void AfterCreateOrg(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.IIBZOrganizationService.updat*(..))")
    public void AfterUpdateOrg(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.IIBZOrganizationService.remov*(..))")
    public void AfterRemoveOrg(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.IIBZOrganizationService.sav*(..))")
    public void AfterSaveOrg(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }

    @After(value = "execution(* cn.ibizlab.core.ou.service.IIBZDepartmentService.creat*(..))")
    public void AfterCreateDept(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.IIBZDepartmentService.updat*(..))")
    public void AfterUpdateDept(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.IIBZDepartmentService.remov*(..))")
    public void AfterRemoveDept(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.IIBZDepartmentService.sav*(..))")
    public void AfterSaveDept(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }

}
