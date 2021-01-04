package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.uaa.domain.SysApp;
import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.domain.SysPermission;
import cn.ibizlab.core.uaa.extensions.domain.PermissionType;
import cn.ibizlab.core.uaa.service.ISysPermissionService;
import cn.ibizlab.core.uaa.service.impl.SysPSSystemServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
//        syncPermission(et);
        return true;
    }

    @Override
    public boolean update(SysPSSystem et) {
        Object ignoreSyncPermission=et.get("ignoreSyncPermission");

        prepareApps(et);
        if(!super.update(et))
            return false;
//        if(ignoreSyncPermission==null||ignoreSyncPermission.equals(false))
//            syncPermission(et);
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
        Map<String, SysApp> newApps = new HashMap<>();
        if(system.getApps()!=null)
            system.getApps().forEach(app->newApps.put(app.getId(),app));

        List<SysApp> newList=new ArrayList<>();
        SysPSSystem old = this.getById(system.getPssystemid());
        if(old!=null&&old.getApps()!=null)
            old.getApps().forEach(app->oldApps.put(app.getId(),app));


        system.getSysstructure().getSysApps(true).forEach(appNode -> {
            if(oldApps.containsKey(appNode.getId())) {
                SysApp sysApp=oldApps.get(appNode.getId());
                if(newApps.containsKey(appNode.getId()))
                {
                    SysApp newApp=newApps.get(appNode.getId());
                    sysApp.setAddr(newApp.getAddr());
                    sysApp.setIcon(newApp.getIcon());
                    sysApp.setFullname(newApp.getFullname());
                    sysApp.setType(newApp.getType());
                    sysApp.setGroup(newApp.getGroup());
                }
                newList.add(sysApp);
            }
            else {
                appNode.setVisabled(1);
                if(newApps.containsKey(appNode.getId()))
                {
                    SysApp newApp=newApps.get(appNode.getId());
                    appNode.setAddr(newApp.getAddr());
                    appNode.setIcon(newApp.getIcon());
                    appNode.setFullname(newApp.getFullname());
                    appNode.setType(newApp.getType());
                    appNode.setGroup(newApp.getGroup());
                }
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

        //查询以往删除过的资源
        String delIds = getDelPermissionIds(list,system.getPssystemid());

        //将当前系统本次资源enable设为1以避免enable=0时，导致saveOrUpdate无法检测到主键存在，最终插入数据导致主键重复
        if(newIds.size()>0 && !StringUtils.isEmpty(delIds))
            sysPermissionService.execute(String.format("update ibzpermission set enable = 1 where sys_permissionid in (%s)",delIds),null);
        //存储或更新资源saveOrUpdate
        if(list.size()>0)
            sysPermissionService.saveBatch(list);

        return system;
    }

    private String getIds(Set<String> newIds) {
        String[] strIdArr = newIds.toArray(new String[newIds.size()]);
        return "'" + String.join("','", strIdArr) + "'";
    }

    /**
     * 查询以往删除过的数据
     * @param list
     * @return
     */
    private String getDelPermissionIds(Set<SysPermission> list , String systemId) {
        String strDelIds = null;
        Map<String, Integer> delPermission = new HashMap<>();
        Map param =new HashMap();
        param.put("systemid",systemId);
        sysPermissionService.select("select sys_permissionid from ibzpermission t where pssystemid = #{et.systemid} and t.enable = 0 ", param).forEach(sysPermission -> delPermission.put(sysPermission.getString("sys_permissionid"), 1));
        if (delPermission.size() == 0)
            return strDelIds;
        Set<String> delIds = new HashSet<>();
        for (SysPermission permission : list) {
            if (!StringUtils.isEmpty(permission.getPermissionid())) {
                if (delPermission.containsKey(permission.getPermissionid())) {
                    delIds.add(permission.getPermissionid());
                }
            }
        }
        if (delIds.size() > 0) {
            strDelIds = getIds(delIds);
        }
        return strDelIds;
    }
}

