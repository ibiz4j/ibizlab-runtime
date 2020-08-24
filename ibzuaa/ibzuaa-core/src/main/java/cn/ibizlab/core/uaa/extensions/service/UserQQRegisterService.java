package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.uaa.domain.SysOpenAccess;
import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.service.ISysOpenAccessService;
import cn.ibizlab.core.uaa.service.ISysUserAuthService;
import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.errors.InternalServerErrorException;
import cn.ibizlab.util.helper.HttpUtils;
import cn.ibizlab.util.service.IBZUSERService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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


    @Autowired
    private ISysOpenAccessService sysOpenAccessService;

    public SysOpenAccess getOpenAccess(String id)
    {
        return getOpenAccess(id,true);
    }
    public SysOpenAccess getOpenAccess(String id,boolean throwEx)
    {
        final String accessid = StringUtils.isEmpty(id)?"qq":id;
        SysOpenAccess sysOpenAccess=sysOpenAccessService.getOne(Wrappers.<SysOpenAccess>lambdaQuery().eq(SysOpenAccess::getOpenType,"qq").
                and(wrapper -> wrapper.eq(SysOpenAccess::getAccessKey,accessid).or().eq(SysOpenAccess::getId,accessid)),false);
        if((sysOpenAccess==null|| (sysOpenAccess.getDisabled()!=null && sysOpenAccess.getDisabled()==1))&&throwEx)
            throw new BadRequestAlertException("获取接入配置失败","UserQQRegisterService","");


        return sysOpenAccess;
    }




    /**
     * qq服务端通过临时授权码code获取授权用户的个人信息
     *
     * @return
     */
    public JSONObject getUserBySnsToken(String id,String requestAuthCode) {
        JSONObject returnObj = null;

        SysOpenAccess openAccess = getOpenAccess(id);
        if (openAccess==null || (openAccess.getDisabled()!=null && openAccess.getDisabled()==1))
            throw new BadRequestAlertException("未找到配置", "UserWechatRegisterService", "");


        try {

            // 1.根据code获取access_token
            String getAccessTokenUrl = "https://graph.qq.com/oauth2.0/token?" +
                    "grant_type=authorization_code" +
                    "&client_id=" + openAccess.getAccessKey() +
                    "&client_secret=" + openAccess.getSecretKey() +
                    "&code=" + requestAuthCode +
                    "&redirect_uri=" + openAccess.getRedirectUri();
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

            returnObj.put("access_token",access_token);
            returnObj.put("refresh_token",refresh_token);

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
                    returnObj.put("openid",openid);
                    SysUserAuth userAuth = sysUserAuthService.getOne(Wrappers.<SysUserAuth>lambdaQuery().eq(SysUserAuth::getIdentityType,"qq").eq(SysUserAuth::getIdentifier, openid),false);

                    IBZUSER user = null;
                    // 该qq用户注册过账号，登录系统
                    if (userAuth!=null) {
                        user = ibzuserService.getById(userAuth.getUserid());
                        if (user == null)
                            user = ibzuserService.getOne(Wrappers.<IBZUSER>lambdaQuery().eq(IBZUSER::getUserid,openid).or().eq(IBZUSER::getUsername,openid),false);

                        if(user!=null)
                        {
                            returnObj.put("username",user.getLoginname()+(StringUtils.isEmpty(user.getDomains())?"":("|"+user.getDomains())));
                        }

                    }
                }else {
                    throw new BadRequestAlertException("QQ服务端获取openid失败!", "UserQQRegisterService", "");
                }
            }




        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("获取user失败");
        }

        return returnObj;
    }



}