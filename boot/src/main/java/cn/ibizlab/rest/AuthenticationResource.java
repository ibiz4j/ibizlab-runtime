
package cn.ibizlab.rest;

import cn.ibizlab.core.uaa.domain.SysUser;
import cn.ibizlab.core.uaa.extensions.service.UAACoreService;
import cn.ibizlab.core.uaa.service.ISysUserService;
import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.Sm3Util;
import cn.ibizlab.util.security.AuthTokenUtil;
import cn.ibizlab.util.security.AuthenticationInfo;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.security.AuthorizationLogin;
import cn.ibizlab.util.service.AuthenticationUserService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequestMapping("/")
public class AuthenticationResource
{

    @Value("${ibiz.jwt.header:Authorization}")
    private String tokenHeader;

    @Autowired
    private AuthTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationUserService userDetailsService;

    @Autowired
    private UAACoreService uaaCoreService;

    @Autowired
    private ISysUserService userService;

    @Value("${ibiz.auth.pwencrymode:0}")
    private int pwencrymode;

    @PostMapping(value = "v7/login")
    public ResponseEntity<AuthenticationInfo> login(@Validated @RequestBody AuthorizationLogin authorizationLogin){
        userDetailsService.resetByUsername(authorizationLogin.getUsername());
        AuthenticationUser user = userDetailsService.loadUserByLogin(authorizationLogin.getUsername(),authorizationLogin.getPassword());

        final String token = jwtTokenUtil.generateToken(user);
        // 返回 token
        return ResponseEntity.ok().body(new AuthenticationInfo(token,user));
    }

    /**
     * token续期
     * @param oldToken 业务系统即将到期的token
     * @return 新token
     */
    @PostMapping(value = "uaa/refreshToken")
    public ResponseEntity<String> refreshToken(@Validated @RequestBody @NotNull(message = "token不能为空") String oldToken) {
        return ResponseEntity.ok().body(uaaCoreService.refreshToken(oldToken));

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
        else if(pwencrymode==3&&oldpwd.length()!=64)
            oldpwd = Sm3Util.encrypt(oldpwd).toUpperCase();
        if(!sysUser.getPassword().equals( oldpwd )){
            throw new BadRequestAlertException("用户名密码错误","IBZUSER",authenticationUser.getUsername());
        }
        // 加密新密码
        if(pwencrymode==1)
            newpwd = DigestUtils.md5DigestAsHex(newpwd.getBytes());
        else if(pwencrymode==2)
            newpwd = DigestUtils.md5DigestAsHex(String.format("%1$s||%2$s", authenticationUser.getUsername(), newpwd).getBytes());
        else if(pwencrymode==3&&newpwd.length()!=64)
            newpwd = Sm3Util.encrypt(newpwd).toUpperCase();
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
