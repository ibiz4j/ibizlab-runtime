
package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.uaa.extensions.service.UAACoreService;
import cn.ibizlab.util.client.IBZOUFeignClient;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
        // 返回 token
        return ResponseEntity.ok().body(new AuthenticationInfo(token,user));
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
