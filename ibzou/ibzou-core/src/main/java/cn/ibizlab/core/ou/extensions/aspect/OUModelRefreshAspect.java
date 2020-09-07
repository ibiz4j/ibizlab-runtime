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

    @After(value = "execution(* cn.ibizlab.core.ou.service.ISysOrganizationService.creat*(..))")
    public void AfterCreateOrg(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.ISysOrganizationService.updat*(..))")
    public void AfterUpdateOrg(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.ISysOrganizationService.remov*(..))")
    public void AfterRemoveOrg(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.ISysOrganizationService.sav*(..))")
    public void AfterSaveOrg(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }

    @After(value = "execution(* cn.ibizlab.core.ou.service.ISysDepartmentService.creat*(..))")
    public void AfterCreateDept(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.ISysDepartmentService.updat*(..))")
    public void AfterUpdateDept(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.ISysDepartmentService.remov*(..))")
    public void AfterRemoveDept(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.ISysDepartmentService.sav*(..))")
    public void AfterSaveDept(JoinPoint point) throws Exception {
        ouModelService.refreshModel();
    }

}
