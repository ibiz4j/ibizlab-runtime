package cn.ibizlab.core.uaa.extensions.service;


import cn.ibizlab.core.extensions.service.SysRoleExService;
import cn.ibizlab.core.uaa.domain.*;
import cn.ibizlab.core.uaa.extensions.domain.PermissionNode;
import cn.ibizlab.core.uaa.extensions.domain.PermissionType;
import cn.ibizlab.core.uaa.extensions.helper.DingTalkHelper;
import cn.ibizlab.core.uaa.filter.SysRolePermissionSearchContext;
import cn.ibizlab.core.uaa.filter.SysUserSearchContext;
import cn.ibizlab.core.uaa.service.ISysPSSystemService;
import cn.ibizlab.core.uaa.service.ISysRolePermissionService;
import cn.ibizlab.core.uaa.service.ISysUserRoleService;
import cn.ibizlab.core.uaa.service.ISysUserService;
import cn.ibizlab.util.domain.Token;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.security.AuthTokenUtil;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.service.AuthenticationUserService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.Base64Utils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
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
    private SysRoleExService sysRoleService;

    @Autowired
    private AuthTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationUserService userDetailsService;

    @Autowired
    @Lazy
    private UserDingtalkRegisterService userDingtalkRegisterService;

    @Value("${ibiz.jwt.expiration:7200000}")
    private Long expiration;

    @Autowired
    @Lazy
    private DingTalkTokenService dingTalkTokenService;

    public Map<String,List<PermissionNode>> getPermissionTree()
    {
        List<PermissionNode> apps = new ArrayList<>();
        List<PermissionNode> uniResIds = new ArrayList<>();
        List<PermissionNode> oppirvs = new ArrayList<>();
        sysPSSystemService.list().forEach(system->{
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
        Set<String> roleIds = getRoleByUserId(userId);
        if(roleIds.size()>0){
            roleIds.forEach(roleid->authorities.add(new SimpleGrantedAuthority("ROLE_"+roleid)));
            String ids="";
            for(String id:roleIds){
                if(!StringUtils.isEmpty(ids))ids+=",";
                ids+=("'"+id+"'");
            }
            String sql= " SELECT distinct t21.PERMISSIONTYPE, t1.SYS_PERMISSIONID FROM IBZROLE_PERMISSION t1  INNER JOIN IBZPERMISSION t21 ON t1.SYS_PERMISSIONID = t21.SYS_PERMISSIONID and T21.ENABLE=1  where sys_roleid in ("+ids+")" ;
            Set<String> apps=new HashSet<>();
            rolePermissionService.select(sql,null).forEach(item->{
                String permissiontype=item.getString("PERMISSIONTYPE");
                String permissionid=item.getString("SYS_PERMISSIONID");
                if(StringUtils.isEmpty(permissionid)||StringUtils.isEmpty(permissiontype))return;
                if(PermissionType.APPMENU.toString().equals(permissiontype))
                {
                    //补充应用访问权
                    String appid = permissionid.split("-")[0].toLowerCase()+"-"+permissionid.split("-")[1].toLowerCase();
                    if(!apps.contains(appid)){
                        apps.add(appid);
                        authorities.add(new SimpleGrantedAuthority(permissiontype+"_"+appid));
                    }
                }
                if(PermissionType.OPPRIV.toString().equals(permissiontype))
                    authorities.add(new SimpleGrantedAuthority(permissionid));
                else
                    authorities.add(new SimpleGrantedAuthority(permissiontype+"_"+permissionid));
            });

        }

        return authorities;
    }

    /**
     * 获取用户所属角色
     * @param userId 用户标识
     * @return
     */
    private Set<String> getRoleByUserId(String userId){

        Set<String> roleIds = new HashSet<>();
        List<SysUserRole> userRoles =userRoleService.selectByUserid(userId);
        if(userRoles.size()==0) {
            roleIds.add("ROLE_USERS");
            return roleIds;
        }

        Map<String,SysRole> roleMap=new HashMap();
        List<SysRole> roles=sysRoleService.getAllSysRoles();
        for(SysRole role: roles){
            roleMap.put(role.getRoleid(),role);
        }
        if(roleMap.size()==0){
            roleIds.add("ROLE_USERS");
            return roleIds;
        }

        for(SysUserRole userRole : userRoles){
            String strRoleId=userRole.getRoleid();
            setRoles(strRoleId,roleMap,roleIds);
        }

        roleIds.add("ROLE_USERS");
        return roleIds;
    }

    /**
     * 获取用户角色列表（含父角色）
     * @param roleId
     * @param roles
     * @param roleIds
     */
    private void setRoles(String roleId , Map <String,SysRole> roles,Set<String> roleIds){
        if(roles.containsKey(roleId)){
            SysRole sysRole =roles.get(roleId);
            if(!ObjectUtils.isEmpty(sysRole.getProleid())) {
                setRoles(sysRole.getProleid(),roles,roleIds);
            }
            roleIds.add(sysRole.getRoleid());
        }
    }

    public void saveByRoleid(String roleid,List<SysRolePermission> list) {
        if(list==null)
            return;

        SysRole role = sysRoleService.getById(roleid);

        Set<String> delIds=new HashSet<String>();
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
            }
            else
                _create.add(sub);
        }
        if(_create.size()>0)
            rolePermissionService.createBatch(_create);
        if(delIds.size()>0)
            rolePermissionService.removeBatch(delIds);
    }

    @Cacheable( value="syspssystem",key = "'row:all-apps'")
    public LinkedHashMap<String,SysApp> getApps() {
        LinkedHashMap<String,SysApp> appNode=new LinkedHashMap<>();
        sysPSSystemService.list().forEach(system -> {
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

    @Caching( evict = {
            @CacheEvict( value="syspssystem",key = "'row:all-apps'"),
            @CacheEvict( value="syspssystem",key = "'row:all-dst-apps'"),
            @CacheEvict( value="syspssystem",key = "'row:all-dst-sys-apps'")
    })
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

    /**
     * 获取钉钉jsApi签名
     * @param openAccessId
     * @return
     */
    public JSONObject getDingTalkJSSign(String openAccessId,String url){
        JSONObject sign=new JSONObject();
        SysOpenAccess openAccess = userDingtalkRegisterService.getOpenAccess(openAccessId);
        if (openAccess==null || (openAccess.getDisabled()!=null && openAccess.getDisabled()==1))
            throw new BadRequestAlertException("未找到配置", "UAACoreService", "getOpenAccess");

        String ticket=dingTalkTokenService.getJSTicket(openAccess.getAccessKey(),openAccess.getSecretKey());
        if(StringUtils.isEmpty(ticket)){
            throw new BadRequestAlertException("获取ticket失败","UAACoreService","getJSTicket");
        }
        String nonceStr=(new AlternativeJdkIdGenerator()).generateId().toString().replace("-", "");
        Long timeStamp=System.currentTimeMillis();
        String strSign = DingTalkHelper.sign(ticket, nonceStr,timeStamp , url);
        sign.put("url",url);
        sign.put("nonceStr",nonceStr);
        sign.put("agentId",openAccess.getAgentId());
        sign.put("timeStamp",timeStamp);
        sign.put("corpId",openAccess.getRegionId());
        sign.put("signature",strSign);
        return sign;
    }

    public String refreshToken(String oldToken){
        String username = null;
        String newToken = null;
        try {
            username = jwtTokenUtil.getUsernameFromToken(oldToken);
        } catch (ExpiredJwtException e) {
            log.error(e.getMessage());
        }
        if (!StringUtils.isEmpty(username)) {
            AuthenticationUser user = userDetailsService.loadUserByUsername(username);
            if (jwtTokenUtil.validateToken(oldToken, user)) {
                // 将新token存入缓存，在固定周期内调用接口将返回同一token
                Token tok = getToken(oldToken);
                if (ObjectUtils.isEmpty(tok)) {
                    newToken = jwtTokenUtil.generateToken(user);
                    setToken(oldToken, newToken);
                } else {
                    // 判断缓存中的token是否到期，到期将返回新token
                    if (isExpired(tok, expiration)) {
                        newToken = jwtTokenUtil.generateToken(user);
                        setToken(oldToken, newToken);
                    }else{
                        newToken = tok.getNewToken();
                    }
                }
            }
        }
        if (StringUtils.isEmpty(newToken)) {
            throw new BadRequestAlertException("获取token失败", "", "refreshToken");
        } else {
            return newToken;
        }
    }

    @CachePut(value = "ibzuaa_refreshtoken", key = "'token:'+#p0")
    public Token setToken(String oldToken, String newToken) {
        Token tok = new Token(newToken, oldToken, new Date());
        return tok;
    }

    @Cacheable(value = "ibzuaa_refreshtoken", key = "'token:'+#p0")
    public Token getToken(String oldToken) {
        return null;
    }

    @CacheEvict(value = "ibzuaa_refreshtoken", key = "'token:'+#p0")
    public Token resetToken(String token) {
        return null;
    }

    public boolean isExpired(Token tok,Long expiration){
        if (System.currentTimeMillis() - tok.getDate().getTime() >= (expiration/4)) {
            return true;
        }
        return false;
    }


    @Autowired
    private ISysUserService userService;

    @Cacheable( value="ibzuaa-model",key = "'catalog:SysOperator'")
    public JSONObject getOptions(String catalog) {
        return getOptions(catalog,null);
    }

    public JSONObject getOptions(String catalog, SysUserSearchContext context) {
        JSONObject jo = new JSONObject();
        jo.put("srfkey", catalog);
        jo.put("emptytext", "");
        List<JSONObject> list = new ArrayList<>();

        userService.list(context==null? Wrappers.query():context.getSelectCond()).forEach(item -> {
            JSONObject option = new JSONObject();
            option.put("id", item.getUserid());
            option.put("value", item.getUserid());
            option.put("label", item.getPersonname());
            option.put("text", item.getPersonname());
            option.put("code", item.getUsercode());
            option.put("name", item.getUsername());
            option.put("filter",item.getOrgid());
            list.add(option);
        });

        jo.put("items",list);

        return jo;
    }

}
