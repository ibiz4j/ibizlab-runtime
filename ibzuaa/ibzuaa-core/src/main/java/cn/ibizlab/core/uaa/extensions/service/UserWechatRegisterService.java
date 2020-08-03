package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.service.ISysUserAuthService;
import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.HttpUtils;
import cn.ibizlab.util.service.IBZUSERService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * 实体[IBZUSER] 微信用户注册接口实现
 */
@Service
@Slf4j
public class UserWechatRegisterService {

    @Autowired
    private IBZUSERService ibzuserService;
    @Autowired
    private ISysUserAuthService sysUserAuthService;

    /**
     * 注册
     *
     * @param ibzuser
     */
    public void toRegister(IBZUSER ibzuser) {
        // 创建ibzuser
        boolean flag = ibzuserService.save(ibzuser);
        if (!flag) {
            throw new BadRequestAlertException("注册失败", "UserWechatRegisterService", "");
        }
    }


    /**
     * 创建微信用户授权信息
     * @param userAuth
     */
    public void toCreateUserAuth(SysUserAuth userAuth) {
        // 创建用户授权信息
        boolean flag = sysUserAuthService.create(userAuth);
        if (!flag) {
            throw new BadRequestAlertException("保存用户授权信息失败", "UserWechatRegisterService", "");
        }
    }

    /**
     * 通过code获取微信用户信息
     *
     * @param code
     * @param state
     * @param wechatAppId
     * @param wechatappsecret
     * @return
     */
    public JSONObject requestWechatUserByCode(String code, String state, String wechatAppId, String wechatappsecret) {
        JSONObject returnObj = null;
        try {
            // 1.根据code获取access_token、openid、refresh_token
            String getAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                    "appid=" + wechatAppId +
                    "&secret=" + wechatappsecret +
                    "&code=" + code +
                    "&grant_type=authorization_code";
            JSONObject responseObj = JSONObject.parseObject(HttpUtils.get(getAccessTokenUrl, null, null));
            if (!responseObj.containsKey("access_token") && !responseObj.containsKey("openid")) {
                throw new BadRequestAlertException("微信服务端获取access_token失败!", "UserWechatRegisterService", "");
            }
            String access_token = responseObj.getString("access_token");
            String openid = responseObj.getString("openid");
            String refresh_token = responseObj.getString("refresh_token");

            // 2.检验授权凭证（access_token）是否有效，无效则需要刷新access_token
            String checkAccessTokenUrl = "https://api.weixin.qq.com/sns/auth?" +
                    "access_token=" + access_token +
                    "&openid=" + openid;
            JSONObject responseObj2 = JSONObject.parseObject(HttpUtils.get(checkAccessTokenUrl, null, null));
            if (responseObj2.getInteger("errcode") != 0) {
                // access_token已失效，使用refresh_token刷新access_token
                String refreshAccess_token = "https://api.weixin.qq.com/sns/oauth2/refresh_token?" +
                        "appid=" + wechatAppId +
                        "&grant_type=refresh_token" +
                        "&refresh_token=" + refresh_token;
                JSONObject responseObj3 = JSONObject.parseObject(HttpUtils.get(refreshAccess_token, null, null));
                if (!responseObj3.containsKey("access_token") || !responseObj3.containsKey("openid")) {
                    throw new BadRequestAlertException("微信服务端刷新access_token失败!", "UserWechatRegisterService", "");
                }
                // 重新拿到access_token、openid、refresh_token
                access_token = responseObj3.getString("access_token");
                openid = responseObj3.getString("openid");
                refresh_token = responseObj3.getString("refresh_token");
            }

            // 3.access_token有效，拉取用户信息
            String getweChatUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?" +
                    "access_token=" + access_token +
                    "&openid=" + openid +
                    "&lang=zh_CN";
            returnObj = JSONObject.parseObject(HttpUtils.get(getweChatUserInfoUrl, null, null));
            if (StringUtils.isEmpty(returnObj)) {
                throw new BadRequestAlertException("微信服务端返回结果为空!", "UserWechatRegisterService", "");
            } else if (!returnObj.containsKey("openid")) {
                throw new BadRequestAlertException("获取微信用户信息失败!", "UserWechatRegisterService", "");
            }
        } catch (UnsupportedEncodingException e) {
            throw new BadRequestAlertException("连接微信服务端失败!", "UserWechatRegisterService", "");
        }

        return returnObj;
    }


}