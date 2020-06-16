package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.HttpUtils;
import cn.ibizlab.util.service.IBZUSERService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 实体[IBZUSER] 用户注册接口实现
 */
@Service
@Slf4j
public class UserRegisterService{

    @Autowired
    private IBZUSERService ibzuserService;

    @Value("${ibiz.auth.qq.app_id:}")
    private String app_ID;
    @Value("${ibiz.auth.qq.userinfo_uri:}")
    private String getUserInfoURL;

    /**
     * 普通注册
     * @param ibzuser
     * @return
     */
    public IBZUSER commomRegister(IBZUSER ibzuser) {
        // 创建ibzuser
        boolean flag = ibzuserService.save(ibzuser);
        if (!flag) {
            return null;
        }
        return ibzuser;
    }


    /**
     * qq授权注册
     * @param ibzuser　
     * @param openId　用户身份的唯一标识
     * @param accessToken　当前用户在此网站/应用的登录状态与授权信息
     */
    public IBZUSER qqRegister(IBZUSER ibzuser, String openId, String accessToken) {
        // 根据OpenID获取该QQ用户的相关信息
        try {
            // 请求参数进行URL编码
            String openIdEncode = URLEncoder.encode(openId, "UTF-8");
            String accessTokenEncode = URLEncoder.encode(accessToken, "UTF-8");
            String url = getUserInfoURL;
            JSONObject getParamMap = new JSONObject();
            getParamMap.put("access_token", accessToken);
            getParamMap.put("oauth_consumer_key", app_ID);
            getParamMap.put("openid", openId);
            getParamMap.put("format", "json");
            // 将参数进行urlencode编码并发送get请求
            String responseStr = HttpUtils.get(url, null, getParamMap);
            JSONObject responseObj = JSONObject.parseObject(responseStr);
            // 获取qq用户信息成功
            if (responseObj.getInteger("ret")==0) {
                ibzuser.setUsername(responseObj.getString("nickname"));
            }else {
                throw new BadRequestAlertException(responseObj.getString("msg"),"","");
            }
        } catch (UnsupportedEncodingException e) {
            throw new BadRequestAlertException("获取QQ用户相关信息失败!","UserRegisterService-qqRegister","");
        }
        // 保存qq授权用户的唯一标识
        ibzuser.setAvatar(openId);
        // 创建ibzuser，注册
        boolean flag = ibzuserService.save(ibzuser);
        if (flag) {
            return ibzuser;
        }
        return null;
    }
}