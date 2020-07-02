package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.uaa.domain.SysApp;
import cn.ibizlab.core.uaa.domain.SysPermission;
import cn.ibizlab.core.uaa.extensions.domain.PermissionType;
import cn.ibizlab.core.uaa.service.ISysPermissionService;
import cn.ibizlab.core.uaa.service.impl.SysPSSystemServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.core.uaa.domain.SysPSSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 实体[系统] 自定义服务对象
 */
@Slf4j
@Primary
@Service("SysPSSystemExService")
public class SysPSSystemExService extends SysPSSystemServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    @Autowired
    @Lazy
    private ISysPermissionService sysPermissionService;

    @Override
    public boolean create(SysPSSystem et) {
        prepareApps(et);
        if(!super.create(et))
            return false;
        syncPermission(et);
        return true;
    }

    @Override
    public boolean update(SysPSSystem et) {
        Object ignoreSyncPermission=et.get("ignoreSyncPermission");

        prepareApps(et);
        if(!super.update(et))
            return false;
        if(ignoreSyncPermission==null||ignoreSyncPermission.equals(false))
            syncPermission(et);
        return true;
    }

    /**
     * 自定义行为[PrepareApps]用户扩展
     * @param system
     * @return
     */
    @Override
    @Transactional
    public SysPSSystem prepareApps(SysPSSystem system) {
        if (StringUtils.isEmpty(system.getPssystemid()) || system.getSysstructure() == null)
            return system;

        Map<String, SysApp> oldApps = new HashMap<>();
        List<SysApp> newList=new ArrayList<>();
        SysPSSystem old = this.getById(system.getPssystemid());
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
        return system;
    }
    private Object lock=new Object();
    /**
     * 自定义行为[SyncPermission]用户扩展
     * @param system
     * @return
     */
    @Override
    @Transactional
    public SysPSSystem syncPermission(SysPSSystem system)
    {
        if(StringUtils.isEmpty(system.getPssystemid())||system.getSysstructure()==null)
            return system;
        Object ignoreSyncPermission=system.get("ignoreSyncPermission");
        if(ignoreSyncPermission!=null&&ignoreSyncPermission.equals(true))
            return system;

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

        return system;
    }

    private String getIds(Set<String> newIds) {
        String[] strIdArr = newIds.toArray(new String[newIds.size()]);
        return "'" + String.join("','", strIdArr) + "'";
    }


}

