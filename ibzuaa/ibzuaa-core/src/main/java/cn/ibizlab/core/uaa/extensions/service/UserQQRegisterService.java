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
 * 实体[IBZUSER] QQ用户注册接口实现
 */
@Service
@Slf4j
public class UserQQRegisterService {

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
            throw new BadRequestAlertException("注册失败", "UserQQRegisterService", "");
        }
    }

    /**
     * 创建QQ用户授权信息
     * @param ibzuser
     */
    public void toCreateUserAuth(SysUserAuth ibzuser) {
        // 创建用户授权信息
        boolean flag = sysUserAuthService.create(ibzuser);
        if (!flag) {
            throw new BadRequestAlertException("保存用户授权信息失败", "UserQQRegisterService", "");
        }
    }

    /**
     * 通过code获取QQ用户信息
     *
     * @param code
     * @param qqRedirectUri
     * @param qqAppid
     * @param qqAppkey
     * @return
     */
    public JSONObject requestQQUserByCode(String code, String qqRedirectUri, String qqAppid, String qqAppkey) {
        JSONObject returnObj = null;
        try {
            // 1.根据code获取access_token
            String getAccessTokenUrl = "https://graph.qq.com/oauth2.0/token?" +
                    "grant_type=authorization_code" +
                    "&client_id=" + qqAppid +
                    "&client_secret=" + qqAppkey +
                    "&code=" + code +
                    "&redirect_uri=" + qqRedirectUri;
            String responserStr = HttpUtils.get(getAccessTokenUrl, null, null);
            JSONObject responseObj = new JSONObject();
            if (StringUtils.isEmpty(responserStr)) {
                throw new BadRequestAlertException("QQ服务端获取access_token失败!", "UserQQRegisterService", "");
            }else {
                String[] split = responserStr.split("&");
                for (int i = 0; i < split.length; i++) {
                    if (split[i].indexOf("=")!=-1){
                        String[] split1 = split[i].split("=");
                        if (split1.length>0) {
                            responseObj.put(split1[0], split1[1]);
                            continue;
                        }
                    }
                }
            }
            String access_token = responseObj.getString("access_token");
            String refresh_token = responseObj.getString("refresh_token");

            // 2.使用access_token来获取用户的OpenID
            String openid = null;
            String getOpenIdUrl = "https://graph.qq.com/oauth2.0/me?access_token=" + access_token;
            String responseStr2 = HttpUtils.get(getOpenIdUrl);
            if (StringUtils.isEmpty(responseStr2)) {
                throw new BadRequestAlertException("QQ服务端请求openid失败!", "UserQQRegisterService", "");
            }else {
                responseStr2 = responseStr2.replace("callback(","").replace(");","");
                JSONObject responseObj2 = JSONObject.parseObject(responseStr2);
                if (responseObj2.containsKey("openid")) {
                    openid = responseObj2.getString("openid");
                }else {
                    throw new BadRequestAlertException("QQ服务端获取openid失败!", "UserQQRegisterService", "");
                }
            }

            // 3.使用access_token以及OpenID来访问和修改用户数据
            String getQQUserInfoUrl = "https://graph.qq.com/user/get_user_info?" +
                    "access_token=" + access_token +
                    "&oauth_consumer_key=" + qqAppid +
                    "&openid=" + openid;
            returnObj = JSONObject.parseObject(HttpUtils.get(getQQUserInfoUrl, null, null));
            if (StringUtils.isEmpty(returnObj)) {
                throw new BadRequestAlertException("QQ服务端返回结果为空!", "UserQQRegisterService", "");
            } else if (returnObj.getInteger("ret")!=0) {
                throw new BadRequestAlertException("获取QQ用户信息失败!", "UserQQRegisterService", "");
            } else {
                returnObj.put("openid", openid);
            }
        } catch (UnsupportedEncodingException e) {
            throw new BadRequestAlertException("连接微信服务端失败!", "UserQQRegisterService", "");
        }

        return returnObj;
    }



}