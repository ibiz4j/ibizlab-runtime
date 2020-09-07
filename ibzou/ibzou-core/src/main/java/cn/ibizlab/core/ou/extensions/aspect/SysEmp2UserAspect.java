package cn.ibizlab.core.ou.extensions.aspect;

import cn.ibizlab.core.ou.domain.SysDepartment;
import cn.ibizlab.core.ou.domain.SysEmployee;
import cn.ibizlab.core.ou.domain.SysOrganization;
import cn.ibizlab.core.ou.extensions.mapping.SysEmp2UserMapping;
import cn.ibizlab.core.ou.extensions.service.OUCoreService;
import cn.ibizlab.core.ou.service.ISysDepartmentService;
import cn.ibizlab.core.ou.service.ISysEmployeeService;
import cn.ibizlab.core.ou.service.ISysOrganizationService;
import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.service.IBZUSERService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.List;


@Aspect
@Order(0)
@Component
public class SysEmp2UserAspect
{
    @Autowired
    @Lazy
    @Qualifier("userservice")
    private IBZUSERService ibzuserService;

    @Autowired
    @Lazy
    private OUCoreService ouCoreService;

    @Autowired
    @Lazy
    private ISysOrganizationService iibzOrganizationService;

    @Autowired
    @Lazy
    private ISysDepartmentService iibzDepartmentService;

    @Autowired
    @Lazy
    private SysEmp2UserMapping ibzEmp2UserMapping;

    @Value("${ibiz.auth.pwencrymode:0}")
    private int pwencrymode;

    @Value("${ibiz.auth.defaultpasswd:123456}")
    private String defaultPasswd;

    @Before(value = "execution(* cn.ibizlab.core.ou.service.ISysEmployeeService.getDraft*(..))")
    public void BeforeGetDraft(JoinPoint point) throws Exception {
        Object[] args = point.getArgs();
        if (args.length > 0) {
            Object obj = args[0];
            if (obj instanceof SysEmployee) {
                SysEmployee ibzEmployee = (SysEmployee) obj;
                if(StringUtils.isEmpty(ibzEmployee.getOrgid())&&(!StringUtils.isEmpty(ibzEmployee.getMdeptid())))
                {
                    ibzEmployee.setMaindept(iibzDepartmentService.get(ibzEmployee.getMdeptid()));
                    ibzEmployee.setOrgid(ibzEmployee.getMaindept().getOrgid());
                    ibzEmployee.setOrgname(ibzEmployee.getMaindept().getOrgname());
                }
            }
        }
    }

    @Before(value = "execution(* cn.ibizlab.core.ou.service.ISysEmployeeService.creat*(..))")
    public void BeforeCreateEmp(JoinPoint point) throws Exception {
        beforeSaveEmp(point);
    }
    @Before(value = "execution(* cn.ibizlab.core.ou.service.ISysEmployeeService.updat*(..))")
    public void BeforeUpdateEmp(JoinPoint point) throws Exception {
        beforeSaveEmp(point);
    }
    @Before(value = "execution(* cn.ibizlab.core.ou.service.ISysEmployeeService.sav*(..))")
    public void BeforeSaveEmp(JoinPoint point) throws Exception {
        beforeSaveEmp(point);
    }

    @Before(value = "execution(* cn.ibizlab.core.ou.service.ISysOrganizationService.creat*(..))")
    public void BeforeCreateOrg(JoinPoint point) throws Exception {
        beforeSaveOrg(point);
    }

    @Before(value = "execution(* cn.ibizlab.core.ou.service.ISysOrganizationService.updat*(..))")
    public void BeforeUpdateOrg(JoinPoint point) throws Exception {
        beforeSaveOrg(point);
    }

    @Before(value = "execution(* cn.ibizlab.core.ou.service.ISysOrganizationService.sav*(..))")
    public void BeforeSaveOrg(JoinPoint point) throws Exception {
        beforeSaveOrg(point);
    }

    @Before(value = "execution(* cn.ibizlab.core.ou.service.ISysDepartmentService.creat*(..))")
    public void BeforeCreateDept(JoinPoint point) throws Exception {
        beforeSaveDept(point);
    }
    @Before(value = "execution(* cn.ibizlab.core.ou.service.ISysDepartmentService.save(..))")
    public void BeforeSaveDept(JoinPoint point) throws Exception {
        beforeSaveDept(point);
    }
    @Before(value = "execution(* cn.ibizlab.core.ou.service.ISysDepartmentService.updat*(..))")
    public void BeforeUpdateDept(JoinPoint point) throws Exception {
        beforeSaveDept(point);
    }
    @Before(value = "execution(* cn.ibizlab.core.ou.service.ISysDepartmentService.saveBatch(..))")
    public void BeforeSaveBatchDept(JoinPoint point) throws Exception {
        beforeSaveDept(point);
    }

    @After(value = "execution(* cn.ibizlab.core.ou.service.ISysEmployeeService.creat*(..))")
    public void AfterCreateEmp(JoinPoint point) throws Exception {
        saveUser(point);
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.ISysEmployeeService.updat*(..))")
    public void AfterUpdateEmp(JoinPoint point) throws Exception {
        saveUser(point);
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.ISysEmployeeService.remove(..))")
    public void AfterRemoveEmp(JoinPoint point) throws Exception {
        removeUser(point);
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.ISysEmployeeService.removeBatch(..))")
    public void AfterRemoveEmpBatch(JoinPoint point) throws Exception {
        removeUser(point);
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.ISysEmployeeService.sav*(..))")
    public void AfterSaveEmp(JoinPoint point) throws Exception {
        saveUser(point);
    }
    @After(value = "execution(* cn.ibizlab.core.ou.service.ISysEmployeeService.initPwd(..))")
    public void AfterInitPwd(JoinPoint point) throws Exception {
        initPwd(point);
    }

    private void beforeSaveEmp(JoinPoint point)
    {
        Object[] args = point.getArgs();
        if (args.length > 0)
        {
            Object obj = args[0];
            if(obj instanceof SysEmployee)
            {
                prepareEmp((SysEmployee)obj,null);
            }
            else if (obj instanceof List)
            {
                List<SysEmployee> list=(List<SysEmployee>)obj;
                Integer lastOrder = null;
                for(SysEmployee emp:list)
                {
                    prepareEmp(emp,lastOrder);
                    lastOrder=emp.getShoworder();
                }
            }
        }
    }

    private void beforeSaveDept(JoinPoint point)
    {
        Object[] args = point.getArgs();
        if (args.length > 0)
        {
            Object obj = args[0];
            if(obj instanceof SysDepartment)
            {
                prepareDept((SysDepartment)obj,null);
            }
            else if (obj instanceof List)
            {
                List<SysDepartment> list=(List<SysDepartment>)obj;
                Integer lastOrder = null;
                for(SysDepartment dept:list)
                {
                    prepareDept(dept,lastOrder);
                    lastOrder=dept.getShoworder();
                }
            }
        }
    }

    private void beforeSaveOrg(JoinPoint point)
    {
        Object[] args = point.getArgs();
        if (args.length > 0)
        {
            Object obj = args[0];
            if(obj instanceof SysOrganization)
            {
                prepareOrg((SysOrganization)obj,null);
            }
            else if (obj instanceof List)
            {
                List<SysOrganization> list=(List<SysOrganization>)obj;
                Integer lastOrder = null;
                for(SysOrganization org:list)
                {
                    prepareOrg(org,lastOrder);
                    lastOrder=org.getShoworder();
                }
            }
        }
    }

    @Value("${ibiz.emp.defaultidformat:%s-%s}")
    private String empdefaultidformat;

    private void prepareEmp(SysEmployee emp,Integer lastOrder)
    {
        String userName=emp.getUsername();
        if(StringUtils.isEmpty(emp.getUserid())&&(!StringUtils.isEmpty(emp.getUsercode()))&&(!StringUtils.isEmpty(emp.getOrgid())))
        {
            emp.setUserid(String.format(empdefaultidformat,emp.getOrgid(),emp.getUsercode()));
        }
        if(StringUtils.isEmpty(userName))
        {
            if(!StringUtils.isEmpty(emp.getDomains()))
                userName= emp.getLoginname()+"|"+emp.getDomains();
            else
                userName = emp.getLoginname();
            emp.setUsername(userName);
        }
        if((!StringUtils.isEmpty(emp.getMdeptid()))&&(!StringUtils.isEmpty(emp.getOrgid()))&&emp.getShoworder()==null)
        {
            if(lastOrder==null){
                SysEmployee order=iibzEmployeeService.getOne(Wrappers.query(new SysEmployee()).select("max(showorder) as showorder").eq("mdeptid",emp.getMdeptid()).eq("orgid",emp.getOrgid()),false);
                if(order!=null)
                    lastOrder=order.getShoworder();
            }
            if(lastOrder!=null)
                lastOrder+=10;
            else
                lastOrder=10;
            emp.setShoworder(lastOrder);
        }
        String password = emp.getPassword();
        if(StringUtils.isEmpty(password))
        {
            password=defaultPasswd;
            if(pwencrymode==1)
                password = DigestUtils.md5DigestAsHex(password.getBytes());
            else if(pwencrymode==2)
                password = DigestUtils.md5DigestAsHex(String.format("%1$s||%2$s", userName, password).getBytes());
            emp.setPassword(password);
        }
    }

    @Value("${ibiz.dept.defaultidformat:%s%s}")
    private String deptdefaultidformat;

    private void prepareDept(SysDepartment dept,Integer lastOrder)
    {
        if ((!StringUtils.isEmpty(dept.getDeptid()))&&(!StringUtils.isEmpty(dept.getParentdeptid())))
        {
            if(ouCoreService.getDeptModel(dept.getDeptid()).getSub().contains(dept.getParentdeptid()))
                throw new BadRequestAlertException("上级部门选择有误","IBZDepartment",dept.getDeptid());
        }
        if (StringUtils.isEmpty(dept.getDeptid()) && (!StringUtils.isEmpty(dept.getDeptcode())) && (!StringUtils.isEmpty(dept.getOrgid())))
        {
            dept.setDeptid(String.format(deptdefaultidformat,dept.getOrgid() ,dept.getDeptcode()));
        }
        if((!StringUtils.isEmpty(dept.getOrgid()))&&dept.getShoworder()==null)
        {
            if(lastOrder==null){
                SysDepartment order=iibzDepartmentService.getOne(Wrappers.query(new SysDepartment()).select("max(showorder) as showorder").eq("orgid",dept.getOrgid()),false);
                if(order!=null)
                    lastOrder=order.getShoworder();
            }
            if(lastOrder!=null)
                lastOrder+=10;
            else
                lastOrder=10;
            dept.setShoworder(lastOrder);
        }
    }

    private void prepareOrg(SysOrganization org,Integer lastOrder)
    {
        if ((!StringUtils.isEmpty(org.getOrgid()))&&(!StringUtils.isEmpty(org.getParentorgid())))
        {
            if(ouCoreService.getOrgModel(org.getOrgid()).getSub().contains(org.getParentorgid()))
                throw new BadRequestAlertException("上级单位选择有误","IBZOrganization",org.getOrgid());
        }
        if(org.getShoworder()==null)
        {
            if(lastOrder==null)
            {
                SysOrganization order=iibzOrganizationService.getOne((Wrappers.query(new SysOrganization())).select("max(showorder) as showorder"),false);
                if(order!=null)
                    lastOrder=order.getShoworder();
            }
            if(lastOrder!=null)
                lastOrder+=10;
            else
                lastOrder=10;
            org.setShoworder(lastOrder);
        }
    }

    private void saveUser(JoinPoint point)
    {
        Object[] args = point.getArgs();
        if (args.length > 0)
        {
            Object obj = args[0];
            if(obj instanceof SysEmployee)
            {
                IBZUSER ibzuser=ibzEmp2UserMapping.toDto((SysEmployee)obj);
                if(ibzuser.getLoginname().equalsIgnoreCase("ibzadmin"))
                    ibzuser.setSuperuser(1);
                ibzuserService.saveOrUpdate(ibzuser);
            }
            else if (obj instanceof List)
            {
                ibzuserService.saveOrUpdateBatch(ibzEmp2UserMapping.toDto((List<SysEmployee>) obj));
            }
        }
    }

    private void removeUser(JoinPoint point)
    {
        Object[] args = point.getArgs();
        if (args.length > 0)
        {
            Object obj = args[0];
            if(obj instanceof String)
            {
                ibzuserService.removeById((String) obj);
            }
            else if (obj instanceof List)
            {
                ibzuserService.removeByIds((List) obj);
            }
        }
    }

    @Autowired
    private ISysEmployeeService iibzEmployeeService;

    public void initPwd(JoinPoint point) {
        Object[] args = point.getArgs();
        if (args.length > 0)
        {
            Object obj = args[0];
            if (obj instanceof SysEmployee)
            {
                SysEmployee emp= ((SysEmployee)obj);
                if(StringUtils.isEmpty(emp.getUserid()))
                    throw new BadRequestAlertException("没有找到要初始化密码的用户","IBZEMP","");

                SysEmployee oldEmp=iibzEmployeeService.get(emp.getUserid());

                if(StringUtils.isEmpty(oldEmp.getUsername()))
                    throw new BadRequestAlertException("没有找到要初始化密码的用户","IBZEMP","");
                String password=defaultPasswd;
                if(pwencrymode==1)
                    password = DigestUtils.md5DigestAsHex(password.getBytes());
                else if(pwencrymode==2)
                    password = DigestUtils.md5DigestAsHex(String.format("%1$s||%2$s", oldEmp.getUsername(), password).getBytes());
                emp.setPassword(password);
                this.iibzEmployeeService.update(emp);
            }
        }
    }

}
