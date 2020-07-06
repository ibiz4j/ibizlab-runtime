
package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.uaa.domain.SysUser;
import cn.ibizlab.core.uaa.extensions.service.SysAppService;
import cn.ibizlab.core.uaa.extensions.service.UAACoreService;
import cn.ibizlab.core.uaa.service.ISysUserService;
import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.security.*;
import cn.ibizlab.util.service.AuthenticationUserService;
import cn.ibizlab.util.service.IBZUSERService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 客户端登录认证
 */
@RestController
@RequestMapping("/")
@ConditionalOnExpression("'${spring.application.name:ibzuaa-api}'.startsWith('ibzuaa')")
public class ClientAuthenticationResource
{

    @Value("${ibiz.jwt.header:Authorization}")
    private String tokenHeader;

    @Value("${ibiz.auth.cookie.domain:}")
    private String cookiedomain;

    @Value("${ibiz.jwt.expiration:7200000}")
    private Long expiration;

    @Autowired
    private AuthTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("UAAUserService")
    private AuthenticationUserService userDetailsService;

    @Autowired
    UAACoreService uaaCoreService;

    @Autowired
    private ISysUserService userService;;

    @Value("${ibiz.auth.pwencrymode:0}")
    private int pwencrymode;

    @PostMapping(value = "v7/login")
    public ResponseEntity<AuthenticationInfo> login(@Validated @RequestBody AuthorizationLogin authorizationLogin){
        userDetailsService.resetByUsername(authorizationLogin.getUsername());
        AuthenticationUser user = userDetailsService.loadUserByLogin(authorizationLogin.getUsername(),authorizationLogin.getPassword());

        final String token = jwtTokenUtil.generateToken(user);

        AuthenticationUser user2=new AuthenticationUser();
        CachedBeanCopier.copy(user,user2);
        user2.setAuthorities(null);
        user2.setPermissionList(null);
        // 返回 token
        return ResponseEntity.ok().body(new AuthenticationInfo(token,user2));
    }

    @PostMapping(value = "v7/changepwd")
    public ResponseEntity<Boolean> changepwd(@Validated @RequestBody JSONObject jsonObject){
        String oldpwd = jsonObject.getString("oldPwd");// 旧密码
        String newpwd = jsonObject.getString("newPwd");// 新密码
        // 空校验
        if (StringUtils.isEmpty(oldpwd))
            throw new BadRequestAlertException("旧密码为空", "ClientAuthenticationResource", "");
        if (StringUtils.isEmpty(newpwd))
            throw new BadRequestAlertException("新密码为空", "ClientAuthenticationResource", "");
        // 获取当前登录用户并加密旧密码
        AuthenticationUser authenticationUser = AuthenticationUser.getAuthenticationUser();

        SysUser sysUser = userService.getById(authenticationUser.getUserid());
        if(pwencrymode==1)
            oldpwd = DigestUtils.md5DigestAsHex(oldpwd.getBytes());
        else if(pwencrymode==2)
            oldpwd = DigestUtils.md5DigestAsHex(String.format("%1$s||%2$s", authenticationUser.getUsername(), oldpwd).getBytes());
        if(!sysUser.getPassword().equals( oldpwd )){
            throw new BadRequestAlertException("用户名密码错误","IBZUSER",authenticationUser.getUsername());
        }
        // 加密新密码
        if(pwencrymode==1)
            newpwd = DigestUtils.md5DigestAsHex(newpwd.getBytes());
        else if(pwencrymode==2)
            newpwd = DigestUtils.md5DigestAsHex(String.format("%1$s||%2$s", authenticationUser.getUsername(), newpwd).getBytes());
        // 修改密码

        sysUser.setPassword(newpwd);
        userService.updateById(sysUser);
        return ResponseEntity.ok(true);
    }

    @PostMapping(value = "uaa/login")
    public ResponseEntity<AuthenticationUser> uaalogin(@Validated @RequestBody AuthorizationLogin authorizationLogin){
        userDetailsService.resetByUsername(authorizationLogin.getUsername());
        AuthenticationUser user = userDetailsService.loadUserByLogin(authorizationLogin.getUsername(),authorizationLogin.getPassword());
        return ResponseEntity.ok().body(user);
    }


    @PostMapping(value = "uaa/loginbyusername")
    public ResponseEntity<AuthenticationUser> loginByUsername(@Validated @RequestBody String username){
        AuthenticationUser user = userDetailsService.loadUserByUsername(username);
        return ResponseEntity.ok().body(user);
    }



}
