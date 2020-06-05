package cn.ibizlab.core.uaa.extensions.service;


import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.domain.SysPermission;
import cn.ibizlab.core.uaa.domain.SysRole;
import cn.ibizlab.core.uaa.domain.SysRolePermission;
import cn.ibizlab.core.uaa.extensions.domain.PermissionNode;
import cn.ibizlab.core.uaa.extensions.domain.PermissionType;
import cn.ibizlab.core.uaa.extensions.domain.SysApp;
import cn.ibizlab.core.uaa.filter.SysPSSystemSearchContext;
import cn.ibizlab.core.uaa.filter.SysRolePermissionSearchContext;
import cn.ibizlab.core.uaa.service.ISysPSSystemService;
import cn.ibizlab.core.uaa.service.ISysRolePermissionService;
import cn.ibizlab.core.uaa.service.ISysRoleService;
import cn.ibizlab.core.uaa.service.ISysUserRoleService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.ObjectUtils;

import java.io.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
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
            PermissionNode appnode=system.getSysstructure().getPermissionTree(PermissionType.APPMENU);
            if(appnode.getChildren().size()>0)
                apps.add(appnode);
            PermissionNode uniresnode=system.getSysstructure().getPermissionTree(PermissionType.UNIRES);
            if(uniresnode.getChildren().size()>0)
                uniResIds.add(uniresnode);
            PermissionNode opprivnode=system.getSysstructure().getPermissionTree(PermissionType.OPPRIV);
            if(opprivnode.getChildren().size()>0)
                oppirvs.add(opprivnode);
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

            Set<String> apps=new HashSet<>();

            rolePermissionService.searchDefault(context).forEach(sysRolePermission -> {
                if(PermissionType.APPMENU.toString().equals(sysRolePermission.getPermissiontype()))
                {
                    //补充应用访问权
                    String appid = sysRolePermission.getPermissionid().split("-")[0].toLowerCase()+"-app-"+sysRolePermission.getPermissionid().split("-")[1].toLowerCase();
                    if(!apps.contains(appid)){
                        apps.add(appid);
                        authorities.add(new SimpleGrantedAuthority(sysRolePermission.getPermissiontype()+"_"+appid));
                    }
                }
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

    @Cacheable( value="syspssystem",key = "'row:all-apps'")
    public LinkedHashMap<String,SysApp> getApps() {
        LinkedHashMap<String,SysApp> appNode=new LinkedHashMap<>();
        Page<SysPSSystem> page = sysPSSystemService.searchDefault(new SysPSSystemSearchContext());
        page.getContent().forEach(system -> {
            if (system.getSysstructure() == null)
            {
                return;
            }
            if (system.getApps() == null)
            {
                system.setApps(system.getSysstructure().getSysApps(true));
                sysPSSystemService.update(system);
            }
            system.getApps().forEach(app-> {
                appNode.put(app.getId(),app);
            });
        });
        return appNode;
    }

    @CacheEvict( value="syspssystem",key = "'row:all-apps'")
    public void resetApps()
    {

    }


    @SneakyThrows
    public boolean genKeyPair()
    {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(1024);

        // 随机生成一对密钥（包含公钥和私钥）
        KeyPair keyPair = gen.generateKeyPair();

        // 获取 公钥 和 私钥
        PublicKey pubKey = keyPair.getPublic();
        PrivateKey priKey = keyPair.getPrivate();


        String usrHome = System.getProperty("user.home")+"/.ibzrt";
        File dir=new File(usrHome);
        if(!dir.exists())
            dir.mkdirs();


        byte[] pubEncBytes = pubKey.getEncoded();
        byte[] priEncBytes = priKey.getEncoded();
        String pubEncBase64 = Base64Utils.encodeToString(pubEncBytes);
        String priEncBase64 = Base64Utils.encodeToString(priEncBytes);

        OutputStream out = null;
        try {
            out = new FileOutputStream(new File(dir,"ibzrt_rsa.pub"));
            IOUtils.write(pubEncBase64,out);
        } finally {
            IOUtils.closeQuietly(out);
        }
        try {
            out = new FileOutputStream(new File(dir,"ibzrt_rsa"));
            IOUtils.write(priEncBase64,out);
        } finally {
            IOUtils.closeQuietly(out);
        }

        return true;
    }

    @SneakyThrows
    public String getPublicKey()
    {
        String key="";
        String usrHome = System.getProperty("user.home")+"/.ibzrt";
        File pubKeyFile=new File(usrHome,"ibzrt_rsa.pub");
        if(!pubKeyFile.exists())
        {
            key = IOUtils.toString(this.getClass().getResourceAsStream("/keypair/ibzrt_rsa.pub"));
        }
        else{
            key = IOUtils.toString(new FileInputStream(pubKeyFile));
        }
        return key;
    }



}
