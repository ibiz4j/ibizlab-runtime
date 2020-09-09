package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.uaa.domain.SysOpenAccess;
import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.extensions.service.UserDingtalkRegisterService;
import cn.ibizlab.core.uaa.extensions.service.UserRegisterService;
import cn.ibizlab.core.uaa.service.ISysOpenAccessService;
import cn.ibizlab.core.uaa.service.ISysUserAuthService;
import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.security.AuthTokenUtil;
import cn.ibizlab.util.security.AuthenticationInfo;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.service.AuthenticationUserService;
import cn.ibizlab.util.service.IBZUSERService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
public class UserDingtalkRegisterResource {

    @Autowired
    private UserDingtalkRegisterService userDingtalkRegisterService;
    @Autowired
    private UserRegisterService userRegisterService;
    @Autowired
    private IBZUSERService ibzuserService;
    @Autowired
    private ISysUserAuthService sysUserAuthService;
    @Autowired
    private AuthTokenUtil jwtTokenUtil;
    @Autowired
    @Qualifier("UAAUserService")
    private AuthenticationUserService userDetailsService;
    @Autowired
    private ISysOpenAccessService openAccessService;


    /**
     * 获取钉钉开放平台创建的网站应用appid
     * @param id
     * @return
     */
    @GetMapping(value = {"/uaa/getDingtalkAppId","/uaa/open/dingtalk/access_token","/uaa/open/dingtalk/appid"})
    public ResponseEntity<JSONObject> getDingtalkAppId(@RequestParam(value = "id",required = false) String id) {
        JSONObject obj = new JSONObject();
        SysOpenAccess openAccess = userDingtalkRegisterService.getOpenAccess(id,false);
        if (openAccess==null || (openAccess.getDisabled()!=null && openAccess.getDisabled()==1))
            return ResponseEntity.ok(obj);
        String appId = openAccess.getAccessKey();
        if (!StringUtils.isEmpty(appId)) {
            obj.put("appid", appId);
            obj.put("access_token",openAccess.getAccessToken());
            obj.put("corp_id",openAccess.getRegionId());
            obj.put("redirect_uri",openAccess.getRedirectUri());
        }

        return ResponseEntity.ok(obj);
    }

    /**
     * 扫码后查询钉钉用户
     *    已注册:返回注册用户并登录
     *    未注册:进行注册
     * @param code
     * @param id
     * @return
     */
    @GetMapping(value = "/uaa/open/dingtalk/sns/{code}")
    public ResponseEntity<JSONObject> getUserBySnsToken(@PathVariable(value = "code") String code, @RequestParam(value = "id",required = false) String id) {
        if (StringUtils.isEmpty(code))
            throw new BadRequestAlertException("code为空", "UserDingtalkRegisterResource", "");

        return ResponseEntity.ok().body(getUserBySnsCode(id,code));
    }

    private JSONObject getUserBySnsCode(String id,String code)
    {
        JSONObject object = userDingtalkRegisterService.getUserBySnsToken(id,code);
        if (!StringUtils.isEmpty(object.getString("username"))) {
            String username = object.getString("username");
            // 生成登录token信息
            userDetailsService.resetByUsername(username);
            AuthenticationUser user = userDetailsService.loadUserByUsername(username);
            final String token = jwtTokenUtil.generateToken(user);
            AuthenticationUser user2 = new AuthenticationUser();
            CachedBeanCopier.copy(user, user2);
            user2.setAuthorities(null);
            user2.setPermissionList(null);
            object.put("token", token);
            object.put("user", user2);
        }
        return object;
    }


    /**
     * 绑定钉钉并注册
     * @param param
     * @return
     */
    @PostMapping(value = {"/uaa/bindDingtalkToRegister","/uaa/open/dingtalk/bind"})
    public ResponseEntity<AuthenticationInfo> bindDingtalkToRegister(@RequestBody JSONObject param) {
        // 空校验
        String loginname = param.getString("loginname");
        String password = param.getString("password");
        String openid = param.getString("openid");
        String nickname = param.getString("nickname");
        String personname = param.getString("personname");
        String phone = param.getString("phone");
        String email = param.getString("email");
        String domains = param.getString("domains");
        if (StringUtils.isEmpty(loginname))
            throw new BadRequestAlertException("用户名为空", "UserDingtalkRegisterResource", "");
        if (StringUtils.isEmpty(password))
            throw new BadRequestAlertException("密码为空", "UserDingtalkRegisterResource", "");
        if (StringUtils.isEmpty(openid))
            throw new BadRequestAlertException("钉钉信息openid为空", "UserDingtalkRegisterResource", "");

        // 钉钉用户注册
        IBZUSER ibzuser = new IBZUSER();
        ibzuser.setPassword(password);
        ibzuser.setLoginname(loginname);
        ibzuser.setPersonname(StringUtils.isEmpty(personname)?nickname:personname);
        ibzuser.setNickname(nickname);
        ibzuser.setPhone(phone);
        ibzuser.setEmail(email);
        ibzuser.setDomains(domains);

        SysUserAuth userAuth = new SysUserAuth();
        userAuth.setIdentifier(openid);
        userAuth.setIdentityType("dingtalk");

        userRegisterService.toRegister(ibzuser,userAuth);

        //　生成登录token信息
        userDetailsService.resetByUsername(ibzuser.getLoginname()+(StringUtils.isEmpty(ibzuser.getDomains())?"":("|"+ibzuser.getDomains())));
        AuthenticationUser user = userDetailsService.loadUserByUsername(ibzuser.getLoginname()+(StringUtils.isEmpty(ibzuser.getDomains())?"":("|"+ibzuser.getDomains())));
        final String token = jwtTokenUtil.generateToken(user);
        AuthenticationUser user2 = new AuthenticationUser();
        CachedBeanCopier.copy(user, user2);
        user2.setAuthorities(null);
        user2.setPermissionList(null);


        return ResponseEntity.ok().body(new AuthenticationInfo(token,user2));
    }


    @GetMapping(value = {"/uaa/open/dingtalk/auth/{code}"})
    public ResponseEntity<AuthenticationInfo> getUserByToken(@PathVariable(value = "code") String code, @RequestParam(value = "id",required = false) String id) {

        AuthenticationUser user=userDingtalkRegisterService.getUserByToken(id,code);

        final String token = jwtTokenUtil.generateToken(user);

        AuthenticationUser user2=new AuthenticationUser();
        CachedBeanCopier.copy(user,user2);
        user2.setAuthorities(null);
        user2.setPermissionList(null);
        // 返回 token
        return ResponseEntity.ok().body(new AuthenticationInfo(token,user2));

    }


}
