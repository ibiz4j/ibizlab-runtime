package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.uaa.domain.SysUser;
import cn.ibizlab.core.uaa.service.impl.SysUserServiceImpl;
import cn.ibizlab.util.client.IBZOUFeignClient;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.service.AuthenticationUserService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 实体[IBZUSER] 服务对象接口实现
 */

@Primary
@Slf4j
@Service("LdapUserService")
@ConditionalOnExpression("'${ibiz.auth.service:SimpleUserService}'.equals('LdapUserService')")
public class LdapUserService extends SysUserServiceImpl implements AuthenticationUserService {

    @Value("${ibiz.auth.pwencrymode:0}")
    private int pwencrymode;
    @Autowired
    private LdapTemplate ldapTemplate;

    @Override
    public AuthenticationUser loadUserByUsername(String username) {
        if (StringUtils.isEmpty(username))
            throw new UsernameNotFoundException("用户名为空");
        QueryWrapper<SysUser> conds = new QueryWrapper<SysUser>();
        String[] data = username.split("[|]");
        String loginname = "";
        String domains = "";
        if (data.length > 0)
            loginname = data[0].trim();
        if (data.length > 1)
            domains = data[1].trim();
        if (!StringUtils.isEmpty(loginname))
            conds.eq("loginname", loginname);
        if (!StringUtils.isEmpty(domains))
            conds.eq("domains", domains);
        SysUser user = this.getOne(conds);
        if (user == null) {
            throw new UsernameNotFoundException("用户" + username + "未找到");
        } else {
            user.setUsername(username);
            AuthenticationUser curUser = createUserDetails(user);

            if (curUser.getPermissionList() == null) {
                setUserPermission(curUser);
                setUserOrgInfo(curUser);
            }

            return curUser;
        }
    }

    @Override
    public AuthenticationUser loadUserByLogin(String username, String password) {
        //获取用户
        AuthenticationUser user = loadUserByUsername(username);

        if (1 == user.getSuperuser()) {
            if (pwencrymode == 1)
                password = DigestUtils.md5DigestAsHex(password.getBytes());
            else if (pwencrymode == 2)
                password = DigestUtils.md5DigestAsHex(String.format("%1$s||%2$s", username, password).getBytes());
            if (!user.getPassword().equals(password)) {
                throw new BadRequestAlertException("用户名密码错误", "IBZUSER", username);
            }
        } else {

            //Ldap 认证。
            authenticateByLdap(username, password);

        }

        return user;
    }

    private void authenticateByLdap(String username, String password) {
        String[] data = username.split("[|]");
        String loginname = username;
        String devslnsysid = "";

        if (data.length == 2) {
            loginname = data[0].trim();
//			devslnsysid=data[1].trim();
        }

        // 查询Ldap人员
        AndFilter filter = new AndFilter();
        if (!StringUtils.isEmpty(loginname)) {
            filter.and(new EqualsFilter("uid", loginname));
        }

        Boolean bAuthenticate = false;
        try {
            // 这个方法可以查询出该用户
            bAuthenticate = ldapTemplate.authenticate("ou=people", filter.encode(), password);
            System.out.println(bAuthenticate);
        } catch (RuntimeException e) {
            bAuthenticate = false;
        }

        if (!bAuthenticate) {
            throw new BadRequestAlertException("用户名或密码错误。", "IBZUSER", username);
        }
    }

    public void resetByUsername(String username) {

    }

    public AuthenticationUser createUserDetails(SysUser user) {
        AuthenticationUser userdatail = new AuthenticationUser();
        CachedBeanCopier.copy(user, userdatail);
        userdatail.setSuperuser(user.getSuperuser()==null?0:user.getSuperuser());
        if (userdatail.getSuperuser() == 1) {
            userdatail.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_SUPERADMIN"));
        }
        return userdatail;
    }


    @Autowired
    @Lazy
    private UAACoreService uaaCoreService;


    /**
     * 设置用户权限
     * 由于GrantedAuthority缺少无参构造，导致无法序列化，暂时通过PermissionList中转
     *
     * @param user
     * @return
     */
    public void setUserPermission(AuthenticationUser user) {
        Collection<GrantedAuthority> userAuthorities = uaaCoreService.getAuthoritiesByUserId(user.getUserid());
        Set<String> authorities = AuthorityUtils.authorityListToSet(userAuthorities);
        if (user.getSuperuser() == 1) {
            authorities.add("ROLE_SUPERADMIN");
        }
        JSONObject permission = new JSONObject();
        permission.put("authorities", authorities);
        user.setPermissionList(permission);
    }

    @Autowired
    @Lazy
    private IBZOUFeignClient ouFeignClient;

    /**
     * 设置用户组织相关信息
     *
     * @param user
     */
    private void setUserOrgInfo(AuthenticationUser user) {
        if( 1==user.getSuperuser())
            return ;

        Map<String, Set<String>> orgInfo = ouFeignClient.getOUMapsByUserId(user.getUserid());
        if (orgInfo == null)
            orgInfo = new HashMap<>();
        //throw new RuntimeException(String.format("获取用户信息失败，请检查用户中心[IBZOU]中是否存在[%s]用户!",user.getLoginname()));

        user.setOrgInfo(orgInfo);
    }
}