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
            if (obj instanceof List)
                ((List<SysPSSystem>) obj).forEach(system -> sysPSSystemService.prepareApps(system));
        }
    }



    @After(value = "execution(* cn.ibizlab.core.uaa.service.ISysPSSystemService.createBatch(..))")
    public void create(JoinPoint point) throws Exception {
        savePermission(point);
    }
    @After(value = "execution(* cn.ibizlab.core.uaa.service.ISysPSSystemService.updateBatch(..))")
    public void update(JoinPoint point) throws Exception {
        savePermission(point);
    }
    @After(value = "execution(* cn.ibizlab.core.uaa.service.ISysPSSystemService.saveBatch(..))")
    public void save(JoinPoint point) throws Exception {
        savePermission(point);
    }
    private void savePermission(JoinPoint point)
    {
        Object[] args = point.getArgs();
        if (args.length > 0) {
            Object obj = args[0];
            if (obj instanceof List)
                ((List<SysPSSystem>) obj).forEach(system -> sysPSSystemService.syncPermission(system));
        }
    }

}
