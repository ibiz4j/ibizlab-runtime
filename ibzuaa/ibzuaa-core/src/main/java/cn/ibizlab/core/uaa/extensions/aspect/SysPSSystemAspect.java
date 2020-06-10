package cn.ibizlab.core.uaa.extensions.aspect;

import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.domain.SysPermission;
import cn.ibizlab.core.uaa.extensions.domain.PermissionType;
import cn.ibizlab.core.uaa.domain.SysApp;
import cn.ibizlab.core.uaa.extensions.service.SysAppService;
import cn.ibizlab.core.uaa.extensions.service.UAACoreService;
import cn.ibizlab.core.uaa.service.ISysPSSystemService;
import cn.ibizlab.core.uaa.service.ISysPermissionService;
import cn.ibizlab.util.annotation.DEField;
import cn.ibizlab.util.domain.EntityBase;
import cn.ibizlab.util.enums.DEFieldDefaultValueType;
import cn.ibizlab.util.enums.DEPredefinedFieldType;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import cn.ibizlab.util.security.AuthenticationUser;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.*;

/**
 * 实体属性默认值切面，只有新建（Create）时才会填充默认值
 */
@Aspect
@Order(0)
@Component
public class SysPSSystemAspect
{

    @Autowired
    @Lazy
    private ISysPermissionService sysPermissionService;

    @Autowired
    @Lazy
    private ISysPSSystemService sysPSSystemService;

    @Autowired
    @Lazy
    private UAACoreService uaaCoreService;

    @Autowired
    @Lazy
    private SysAppService sysAppService;

    @Before(value = "execution(* cn.ibizlab.core.uaa.service.ISysPSSystemService.create*(..))")
    public void beforecreate(JoinPoint point) throws Exception {
        saveApps(point);
    }
    @Before(value = "execution(* cn.ibizlab.core.uaa.service.ISysPSSystemService.update*(..))")
    public void beforeupdate(JoinPoint point) throws Exception {
        saveApps(point);
    }
    @Before(value = "execution(* cn.ibizlab.core.uaa.service.ISysPSSystemService.save*(..))")
    public void beforesave(JoinPoint point) throws Exception {
        saveApps(point);
    }
    private void saveApps(JoinPoint point)
    {
        uaaCoreService.resetApps();
        sysAppService.resetAppNavigationBars();
        Object[] args = point.getArgs();
        if (args.length > 0) {
            Object obj = args[0];
            if (obj instanceof SysPSSystem)
                prepairApps((SysPSSystem) obj);
            else if (obj instanceof List)
                ((List<SysPSSystem>) obj).forEach(system -> prepairApps(system));
        }
    }
    private void prepairApps(SysPSSystem system) {
        if (StringUtils.isEmpty(system.getPssystemid()) || system.getSysstructure() == null)
            return;

        Map<String,SysApp> oldApps = new HashMap<>();
        List<SysApp> newList=new ArrayList<>();
        SysPSSystem old = sysPSSystemService.getById(system.getPssystemid());
        if(old!=null&&old.getApps()!=null)
            old.getApps().forEach(app->oldApps.put(app.getId(),app));


        system.getSysstructure().getSysApps(true).forEach(appNode -> {
            if(oldApps.containsKey(appNode.getId()))
                newList.add(oldApps.get(appNode.getId()));
            else {
                appNode.setVisabled(1);
                newList.add(appNode);
            }
        });
        if(old!=null&&old.getApps()!=null)
            old.getApps().forEach(app->{
                if("THIRD-PARTY".equalsIgnoreCase(app.getGroup()))
                    newList.add(app);
            });
        system.setApps(newList);

    }


    @After(value = "execution(* cn.ibizlab.core.uaa.service.ISysPSSystemService.create*(..))")
    public void create(JoinPoint point) throws Exception {
        savePermission(point);
    }
    @After(value = "execution(* cn.ibizlab.core.uaa.service.ISysPSSystemService.update*(..))")
    public void update(JoinPoint point) throws Exception {
        savePermission(point);
    }
    @After(value = "execution(* cn.ibizlab.core.uaa.service.ISysPSSystemService.save*(..))")
    public void save(JoinPoint point) throws Exception {
        savePermission(point);
    }
    private void savePermission(JoinPoint point)
    {
        Object[] args = point.getArgs();
        if (args.length > 0) {
            Object obj = args[0];
            if (obj instanceof SysPSSystem)
                syncPermission((SysPSSystem) obj);
            else if (obj instanceof List)
                ((List<SysPSSystem>) obj).forEach(system -> syncPermission(system));
        }
    }

    private void syncPermission(SysPSSystem system)
    {
        if(StringUtils.isEmpty(system.getPssystemid())||system.getSysstructure()==null)
            return;
        Map<String,Integer> delPermission = new HashMap<>();
        sysPermissionService.list(new QueryWrapper<SysPermission>().select("sys_permissionid").eq("pssystemid",system.getPssystemid())).forEach(sysPermission -> delPermission.put(sysPermission.getPermissionid(),1));
        Set<SysPermission> list = system.getSysstructure().getSysPermissions(PermissionType.OPPRIV);
        list.addAll(system.getSysstructure().getSysPermissions(PermissionType.APPMENU));
        list.addAll(system.getSysstructure().getSysPermissions(PermissionType.UNIRES));
        Set<String> newIds=new HashSet<>();
        list.forEach(sysPermission -> {
            delPermission.remove(sysPermission.getPermissionid());
            newIds.add(sysPermission.getPermissionid());
        });
        //移除无效资源
        if(delPermission.size()>0)
            sysPermissionService.removeBatch(delPermission.keySet());
        //将当前系统本次资源enable设为1以避免enable=0时，导致saveOrUpdate无法检测到主键存在，最终插入数据导致主键重复
        if(newIds.size()>0)
            sysPermissionService.execute(String.format("update ibzpermission set enable = 1 where sys_permissionid in (%s)",getIds(newIds)),null);
        //存储或更新资源saveOrUpdate
        if(list.size()>0)
            sysPermissionService.saveBatch(list);
    }


    private String getIds(Set<String> newIds) {
        String[] strIdArr = newIds.toArray(new String[newIds.size()]);
        return "'" + String.join("','", strIdArr) + "'";
    }
}
