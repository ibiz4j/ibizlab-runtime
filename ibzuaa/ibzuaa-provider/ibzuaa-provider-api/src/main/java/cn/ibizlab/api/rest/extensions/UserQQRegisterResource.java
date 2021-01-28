package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.uaa.domain.SysOpenAccess;
import cn.ibizlab.core.uaa.domain.SysUser;
import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.extensions.service.UserQQRegisterService;
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
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class UserQQRegisterResource {

    @Autowired
    private UserQQRegisterService userQQRegisterService;
    @Autowired
    private UserRegisterService userRegisterService;
    @Autowired
    private AuthTokenUtil jwtTokenUtil;
    @Autowired
    @Qualifier("UAAUserService")
    private AuthenticationUserService userDetailsService;
    @Autowired
    private ISysOpenAccessService openAccessService;


    /**
     * 获取qq互联平台创建的网站应用appid
     * @param id
     * @return
     */
    @GetMapping(value = {"/uaa/getQQAppId","/uaa/open/qq/access_token","/uaa/open/qq/appid"})
    public ResponseEntity<JSONObject> getQQAppId(@RequestParam(value = "id",required = false) String id) {
        JSONObject obj = new JSONObject();
        SysOpenAccess openAccess = userQQRegisterService.getOpenAccess(id);
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
     * 扫码后查询qq用户
     *  已注册:返回注册用户并登录
     *  未注册:进行注册
     * @param code
     * @param id
     * @return
     */
    @GetMapping(value = "/uaa/open/qq/sns/{code}")
    public ResponseEntity<JSONObject> getUserBySnsToken(@PathVariable(value = "code") String code, @RequestParam(value = "id",required = false) String id) {
        if (StringUtils.isEmpty(code))
            throw new BadRequestAlertException("code为空", "UserQQRegisterResource", "");

        return ResponseEntity.ok().body(getUserBySnsCode(id,code));
    }

    private JSONObject getUserBySnsCode(String id,String code)
    {
        JSONObject object = userQQRegisterService.getUserBySnsToken(id,code);
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
     * 绑定qq并注册
     * @param param
     * @return
     */
    @PostMapping(value = {"/uaa/bindQQtoRegister","/uaa/open/qq/bind"})
    public ResponseEntity<AuthenticationInfo> bindQQToRegister(@RequestBody JSONObject param) {
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
            throw new BadRequestAlertException("用户名为空", "UserQQRegisterResource", "");
        if (StringUtils.isEmpty(password))
            throw new BadRequestAlertException("密码为空", "UserQQRegisterResource", "");
        if (StringUtils.isEmpty(openid))
            throw new BadRequestAlertException("QQ信息openid为空", "UserQQRegisterResource", "");

        // qq用户注册
        SysUser sysUser = new SysUser();
        sysUser.setPassword(password);
        sysUser.setLoginname(loginname);
        sysUser.setPersonname(StringUtils.isEmpty(personname)?nickname:personname);
        sysUser.setNickname(nickname);
        sysUser.setPhone(phone);
        sysUser.setEmail(email);
        sysUser.setDomains(domains);

        SysUserAuth userAuth = new SysUserAuth();
        userAuth.setIdentifier(openid);
        userAuth.setIdentityType("qq");

        userRegisterService.toRegister(sysUser,userAuth);

        //　生成登录token信息
        userDetailsService.resetByUsername(sysUser.getLoginname()+(StringUtils.isEmpty(sysUser.getDomains())?"":("|"+sysUser.getDomains())));
        AuthenticationUser user = userDetailsService.loadUserByUsername(sysUser.getLoginname()+(StringUtils.isEmpty(sysUser.getDomains())?"":("|"+sysUser.getDomains())));
        final String token = jwtTokenUtil.generateToken(user);
        AuthenticationUser user2 = new AuthenticationUser();
        CachedBeanCopier.copy(user, user2);
        user2.setAuthorities(null);
        user2.setPermissionList(null);


        return ResponseEntity.ok().body(new AuthenticationInfo(token,user2));
    }

}
