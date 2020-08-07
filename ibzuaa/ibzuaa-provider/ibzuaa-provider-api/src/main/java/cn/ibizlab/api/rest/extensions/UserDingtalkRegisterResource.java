package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.uaa.domain.SysOpenAccess;
import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.extensions.service.UserDingtalkRegisterService;
import cn.ibizlab.core.uaa.service.ISysOpenAccessService;
import cn.ibizlab.core.uaa.service.ISysUserAuthService;
import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.security.AuthTokenUtil;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.service.AuthenticationUserService;
import cn.ibizlab.util.service.IBZUSERService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
public class UserDingtalkRegisterResource {

    @Autowired
    private UserDingtalkRegisterService userDingtalkRegisterService;
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
     */
    @GetMapping(value = "/uaa/getDingtalkAppId")
    public ResponseEntity<JSONObject> getDingtalkAppId() {
        JSONObject obj = new JSONObject();
        SysOpenAccess openAccess = openAccessService.getById("dingtalk");
        if (openAccess==null || (openAccess.getDisabled()!=null && openAccess.getDisabled()==1))
            return ResponseEntity.ok(obj);
        String appId = openAccess.getAccessKey();// qq互联appid
        if (!StringUtils.isEmpty(appId)) {
            obj.put("appid", appId);
        }

        return ResponseEntity.ok(obj);
    }


    /**
     * 根据code查钉钉用户
     *
     * @param param
     * @return
     */
    @PostMapping(value = "/uaa/queryDingtalkUserByCode")
    public ResponseEntity<JSONObject> queryDingtalkUserByCode(@RequestBody JSONObject param) {
        JSONObject object = new JSONObject();
        // 空校验
        String code = param.getString("code");
        if (StringUtils.isEmpty(code))
            throw new BadRequestAlertException("code为空", "UserDingtalkRegisterResource", "");

        // 从数据库中获取钉钉授权应用信息
        SysOpenAccess openAccess = openAccessService.getById("dingtalk");
        if (openAccess==null || (openAccess.getDisabled()!=null && openAccess.getDisabled()==1))
            throw new BadRequestAlertException("未找到配置", "UserDingtalkRegisterResource", "");
        String appId = openAccess.getAccessKey();// 个人应用开发过程中的唯一性标识AppId
        String appSecret = openAccess.getSecretKey();// 个人应用AppSecret

        // 通过code获取钉钉用户信息
        String openid = null;
        String nickname = null;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject returnObj = userDingtalkRegisterService.requestDingtalkUserByCode(code, currentTimeMillis, appId, appSecret);
        if (!StringUtils.isEmpty(returnObj) && !returnObj.containsKey("errcode")) {
            openid = returnObj.getString("openid");
            nickname = returnObj.getString("nick");
            object.put("openid", openid);
            object.put("nickname", nickname);
        }

        // 根据openid查用户授权信息
        SysUserAuth userAuth = sysUserAuthService.getOne(Wrappers.<SysUserAuth>query().eq("identifier", openid));
        // 该钉钉用户注册过账号，登录系统
        if (!StringUtils.isEmpty(userAuth)) {
            IBZUSER ibzuser = ibzuserService.getById(userAuth.getUserid());
            JSONObject ibzuserObj = new JSONObject();
            ibzuserObj.put("loginname", ibzuser.getLoginname());
            ibzuserObj.put("password", ibzuser.getPassword());
            object.put("ibzuser", ibzuserObj);

            // 生成登录token信息
            userDetailsService.resetByUsername(ibzuser.getLoginname());
            AuthenticationUser user = userDetailsService.loadUserByLogin(ibzuser.getLoginname(), ibzuser.getPassword());
            final String token = jwtTokenUtil.generateToken(user);
            AuthenticationUser user2 = new AuthenticationUser();
            CachedBeanCopier.copy(user, user2);
            user2.setAuthorities(null);
            user2.setPermissionList(null);
            object.put("token", token);
            object.put("user", user2);
        }

        return ResponseEntity.ok().body(object);
    }


    /**
     * 绑定钉钉并注册
     *
     * @param param
     * @return
     */
    @PostMapping(value = "/uaa/bindDingtalkToRegister")
    public ResponseEntity<JSONObject> bindDingtalkToRegister(@RequestBody JSONObject param) {
        JSONObject object = new JSONObject();
        // 空校验
        String loginname = param.getString("loginname");
        String password = param.getString("password");
        String openid = param.getString("openid");
        String nickname = param.getString("nickname");
        if (StringUtils.isEmpty(loginname))
            throw new BadRequestAlertException("用户名为空", "UserDingtalkRegisterResource", "");
        if (StringUtils.isEmpty(password))
            throw new BadRequestAlertException("密码为空", "UserDingtalkRegisterResource", "");
        if (StringUtils.isEmpty(openid))
            throw new BadRequestAlertException("钉钉信息openid为空", "UserDingtalkRegisterResource", "");
        if (StringUtils.isEmpty(nickname))
            throw new BadRequestAlertException("钉钉信息nickname为空", "UserDingtalkRegisterResource", "");

        // 钉钉用户注册
        IBZUSER ibzuser = new IBZUSER();
        String uuid = UUID.randomUUID().toString();
        ibzuser.setPassword(password);
        ibzuser.setLoginname(loginname);
        ibzuser.setUserid("dingtalk-" + uuid);
        ibzuser.setPersonname(nickname);
        ibzuser.setNickname(nickname);
        userDingtalkRegisterService.toRegister(ibzuser);
        // 创建钉钉用户授权信息
        SysUserAuth userAuth = new SysUserAuth();
        userAuth.setUserid(ibzuser.getUserid());
        userAuth.setIdentifier(openid);
        userAuth.setIdentityType("dingtalk");
        userDingtalkRegisterService.toCreateUserAuth(userAuth);

        // 注册成功，登录系统
        if (!StringUtils.isEmpty(ibzuser)) {
            JSONObject ibzuserObj = new JSONObject();
            ibzuserObj.put("loginname", ibzuser.getLoginname());
            ibzuserObj.put("password", ibzuser.getPassword());
            object.put("ibzuser", ibzuserObj);
        }

        //　生成登录token信息
        userDetailsService.resetByUsername(ibzuser.getLoginname());
        AuthenticationUser user = userDetailsService.loadUserByLogin(ibzuser.getLoginname(), ibzuser.getPassword());
        final String token = jwtTokenUtil.generateToken(user);
        AuthenticationUser user2 = new AuthenticationUser();
        CachedBeanCopier.copy(user, user2);
        user2.setAuthorities(null);
        user2.setPermissionList(null);
        object.put("token", token);
        object.put("user", user2);

        return ResponseEntity.ok().body(object);
    }


}
