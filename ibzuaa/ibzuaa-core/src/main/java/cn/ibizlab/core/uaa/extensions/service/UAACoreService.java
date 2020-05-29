package cn.ibizlab.core.uaa.extensions.service;


import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.domain.SysPermission;
import cn.ibizlab.core.uaa.domain.SysRole;
import cn.ibizlab.core.uaa.domain.SysRolePermission;
import cn.ibizlab.core.uaa.extensions.domain.PermissionNode;
import cn.ibizlab.core.uaa.extensions.domain.PermissionType;
import cn.ibizlab.core.uaa.filter.SysPSSystemSearchContext;
import cn.ibizlab.core.uaa.filter.SysRolePermissionSearchContext;
import cn.ibizlab.core.uaa.service.ISysPSSystemService;
import cn.ibizlab.core.uaa.service.ISysRolePermissionService;
import cn.ibizlab.core.uaa.service.ISysRoleService;
import cn.ibizlab.core.uaa.service.ISysUserRoleService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
@Slf4j
public class UAACoreService {

    @Autowired
    @Lazy
    private ISysPSSystemService sysPSSystemService;

    @Autowired
    @Lazy
    private ISysRolePermissionService rolePermissionService;

    @Autowired
    @Lazy
    private ISysUserRoleService userRoleService;

    @Autowired
    @Lazy
    private ISysRoleService sysRoleService;

    public Map<String,List<PermissionNode>> getPermissionTree()
    {
        List<PermissionNode> apps = new ArrayList<>();
        List<PermissionNode> uniResIds = new ArrayList<>();
        List<PermissionNode> oppirvs = new ArrayList<>();
        Page<SysPSSystem> page = sysPSSystemService.searchDefault(new SysPSSystemSearchContext());
        page.getContent().forEach(system->{
            if(system.getSysstructure()==null)
                return;
            apps.add(system.getSysstructure().getPermissionTree(PermissionType.APPMENU));
            uniResIds.add(system.getSysstructure().getPermissionTree(PermissionType.UNIRES));
            oppirvs.add(system.getSysstructure().getPermissionTree(PermissionType.OPPRIV));
        });
        Map<String,List<PermissionNode>> map = new HashMap<>();
        map.put(PermissionType.APPMENU.toString(),apps);
        map.put(PermissionType.UNIRES.toString(),uniResIds);
        map.put(PermissionType.OPPRIV.toString(),oppirvs);
        return map;
    }

    public List<PermissionNode> getRolePermissionByRoleId(String roleId)
    {
        List<PermissionNode> rolePermissions = new ArrayList<>();
        List<SysRolePermission> list = rolePermissionService.selectByRoleid(roleId);
        list.forEach(item->{
            rolePermissions.add(PermissionNode.builder().id(item.getPermissionid()).label(item.getPermissionname()).build());
        });
        return rolePermissions;
    }

    public Collection<GrantedAuthority> getAuthoritiesByUserId(String userId)
    {
        Set<GrantedAuthority> authorities = new LinkedHashSet<>();
        Set<String> roleIds = new HashSet<>();
        userRoleService.selectByUserid(userId).forEach(sysUserRole -> roleIds.add(sysUserRole.getRoleid()));
        roleIds.forEach(roleid->authorities.add(new SimpleGrantedAuthority("ROLE_"+roleid)));

        if(roleIds.size()>0){
            SysRolePermissionSearchContext context = new SysRolePermissionSearchContext();
            context.getSelectCond().in("sys_roleid",roleIds).eq("permissionenable",1).orderByAsc("permissiontype","sys_permissionid");
            context.setSize(Integer.MAX_VALUE);
            rolePermissionService.searchDefault(context).forEach(sysRolePermission -> {
                if(PermissionType.OPPRIV.toString().equals(sysRolePermission.getPermissiontype()))
                    authorities.add(new SimpleGrantedAuthority(sysRolePermission.getPermissionid()));
                else
                    authorities.add(new SimpleGrantedAuthority(sysRolePermission.getPermissiontype()+"_"+sysRolePermission.getPermissionid()));
            });
        }

        return authorities;
    }

    public void saveByRoleid(String roleid,List<SysRolePermission> list) {
        if(list==null)
            return;

        SysRole role = sysRoleService.getById(roleid);

        Set<String> delIds=new HashSet<String>();
        List<SysRolePermission> _update=new ArrayList<SysRolePermission>();
        List<SysRolePermission> _create=new ArrayList<SysRolePermission>();
        for(SysRolePermission before:rolePermissionService.selectByRoleid(roleid)){
            delIds.add(before.getRolepermissionid());
        }
        for(SysRolePermission sub:list) {
            SysPermission sysPermission = new SysPermission();
            sysPermission.setEnable(1);
            sysPermission.setPermissiontype(sub.getPermissiontype());
            sysPermission.setPermissionname(sub.getPermissionname());
            sysPermission.setPermissionid(sub.getPermissionid());
            sub.setPermission(sysPermission);
            sub.setRoleid(roleid);
            sub.setRole(role);
            if(ObjectUtils.isEmpty(sub.getRolepermissionid()))
                sub.setRolepermissionid((String)sub.getDefaultKey(true));
            if(delIds.contains(sub.getRolepermissionid())) {
                delIds.remove(sub.getRolepermissionid());
                _update.add(sub);
            }
            else
                _create.add(sub);
        }
        if(_update.size()>0)
            rolePermissionService.updateBatch(_update);
        if(_create.size()>0)
            rolePermissionService.createBatch(_create);
        if(delIds.size()>0)
            rolePermissionService.removeBatch(delIds);
    }

}
