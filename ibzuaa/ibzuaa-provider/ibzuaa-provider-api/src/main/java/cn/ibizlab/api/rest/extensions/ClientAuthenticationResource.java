
package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.uaa.extensions.service.SysAppService;
import cn.ibizlab.core.uaa.extensions.service.UAACoreService;
import cn.ibizlab.util.client.IBZOUFeignClient;
import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.security.AuthTokenUtil;
import cn.ibizlab.util.security.AuthenticationInfo;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.security.AuthorizationLogin;
import cn.ibizlab.util.service.AuthenticationUserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

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

    @Autowired
    private SysAppService sysAppService;

    @GetMapping(value = "uaa/access-center/app-switcher/{id}")
    public ResponseEntity<JSONObject> appswitcher(@PathVariable("id") String id)
    {
        return ResponseEntity.ok(sysAppService.getAppSwitcher(id,AuthenticationUser.getAuthenticationUser().getUserid()));
    }

}
