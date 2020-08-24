package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.uaa.domain.SysOpenAccess;
import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.extensions.service.UserRegisterService;
import cn.ibizlab.core.uaa.extensions.service.UserWechatRegisterService;
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

import java.util.List;
import java.util.UUID;


@RestController
public class UserWechatRegisterResource {

    @Autowired
    private UserWechatRegisterService userWechatRegisterService;
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
     * 获取微信开放平台创建的网站应用appid
     */
    @GetMapping(value = {"/uaa/getWechatAppId","/uaa/open/wechat/access_token","/uaa/open/wechat/appid"})
    public ResponseEntity<JSONObject> getWechatAppId(@RequestParam(value = "id",required = false) String id) {
        JSONObject obj = new JSONObject();
        SysOpenAccess openAccess = userWechatRegisterService.getOpenAccess(id,false);
        if (openAccess==null || (openAccess.getDisabled()!=null && openAccess.getDisabled()==1))
            return ResponseEntity.ok(obj);
        String appId = openAccess.getAccessKey();// qq互联appid
        if (!StringUtils.isEmpty(appId)) {
            obj.put("appid", appId);
            obj.put("corp_id",openAccess.getRegionId());
            obj.put("redirect_uri",openAccess.getRedirectUri());
        }

        return ResponseEntity.ok(obj);
    }




    /**
     * 根据code查微信用户
     *
     * @param param
     * @return
     */
    @PostMapping(value = "/uaa/queryWechatUserByCode")
    public ResponseEntity<JSONObject> queryWechatUserByCode(@RequestParam(value = "id",required = false) String id,@RequestParam(value = "code",required = false) String tmpcode,@RequestBody JSONObject param) {

        // 空校验
        String code = param.getString("code");
        if (StringUtils.isEmpty(code))
            code = tmpcode;
        if (StringUtils.isEmpty(code))
            throw new BadRequestAlertException("code为空", "UserWechatRegisterResource", "");

        return ResponseEntity.ok().body(getUserBySnsCode(id,code));
    }

    @GetMapping(value = "/uaa/open/wechat/sns/{code}")
    public ResponseEntity<JSONObject> getUserBySnsToken(@PathVariable(value = "code") String code, @RequestParam(value = "id",required = false) String id) {
        if (StringUtils.isEmpty(code))
            throw new BadRequestAlertException("code为空", "UserWechatRegisterResource", "");

        return ResponseEntity.ok().body(getUserBySnsCode(id,code));
    }

    private JSONObject getUserBySnsCode(String id,String code)
    {
        JSONObject object = userWechatRegisterService.getUserBySnsToken(id,code);
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
     * 绑定微信并注册
     *
     * @param param
     * @return
     */
    @PostMapping(value = {"/uaa/bindWechatToRegister","/uaa/open/wechat/bind"})
    public ResponseEntity<AuthenticationInfo> bindWechatToRegister(@RequestBody JSONObject param) {

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
            throw new BadRequestAlertException("用户名为空", "UserWechatRegisterResource", "");
        if (StringUtils.isEmpty(password))
            throw new BadRequestAlertException("密码为空", "UserWechatRegisterResource", "");
        if (StringUtils.isEmpty(openid))
            throw new BadRequestAlertException("微信信息openid为空", "UserWechatRegisterResource", "");


        // 微信用户注册
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
        userAuth.setIdentityType("wechat");

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


}
