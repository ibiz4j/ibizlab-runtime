package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.uaa.domain.SysOpenAccess;
import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.service.ISysOpenAccessService;
import cn.ibizlab.core.uaa.service.ISysUserAuthService;
import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.errors.InternalServerErrorException;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.service.AuthenticationUserService;
import cn.ibizlab.util.service.IBZUSERService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.identify.Base64;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiSnsGetuserinfoBycodeRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiSnsGetuserinfoBycodeResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.sql.Wrapper;
import java.util.Date;

/**
 * 实体[IBZUSER] 钉钉用户注册接口实现
 */
@Service
@Slf4j
public class UserDingtalkRegisterService {

    @Autowired
    private IBZUSERService ibzuserService;

    @Autowired
    private AuthenticationUserService authenticationUserService;

    @Autowired
    private ISysUserAuthService sysUserAuthService;




    private long lastRefreshTime=System.currentTimeMillis()-7200001;
    private String accessToken="";
    public boolean isExpire()
    {
        if(System.currentTimeMillis()<(lastRefreshTime+7200000))
        {
            System.currentTimeMillis();
            return false;
        }
        return true;
    }


    public synchronized String getAccessToken(String appKey,String appSecret)
    {
        if(isExpire()) {
            DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
            OapiGettokenRequest request = new OapiGettokenRequest();
            request.setAppkey("appKey");
            request.setAppsecret("appSecret");
            request.setHttpMethod("GET");
            try {
                OapiGettokenResponse response = client.execute(request);
                if(response.getErrcode()!=0||StringUtils.isEmpty(response.getAccessToken()))
                    throw new BadRequestAlertException("获取access_token失败","UserDingtalkRegisterService",response.getErrmsg());
                lastRefreshTime = System.currentTimeMillis();
                accessToken = response.getAccessToken();
            } catch (ApiException e) {
                e.printStackTrace();
                throw new InternalServerErrorException("获取access_token失败");
            }
        }
        return accessToken;
    }

    @Autowired
    private ISysOpenAccessService sysOpenAccessService;

    public SysOpenAccess getOpenAccess(String id)
    {
        final String accessid = StringUtils.isEmpty(id)?"dingtalk":id;
        SysOpenAccess sysOpenAccess=sysOpenAccessService.getOne(Wrappers.<SysOpenAccess>lambdaQuery().eq(SysOpenAccess::getOpenType,"dingtalk").
                and(wrapper -> wrapper.eq(SysOpenAccess::getAccessKey,accessid).or().eq(SysOpenAccess::getId,accessid)),false);
        if(sysOpenAccess==null|| (sysOpenAccess.getDisabled()!=null && sysOpenAccess.getDisabled()==1))
            throw new BadRequestAlertException("获取接入配置失败","UserDingtalkRegisterService","");

        String accessToken = getAccessToken(sysOpenAccess.getAccessKey(),sysOpenAccess.getSecretKey());
        if(!accessToken.equals(sysOpenAccess.getAccessToken()))
        {
            sysOpenAccess.setAccessToken(accessToken);
            sysOpenAccess.setExpiresTime(new Timestamp(lastRefreshTime));
            sysOpenAccessService.update(sysOpenAccess);
        }

        return sysOpenAccess;
    }



    public AuthenticationUser getUserByToken(String id,String requestAuthCode)
    {
        SysOpenAccess openAccess = getOpenAccess(id);
        if (openAccess==null || (openAccess.getDisabled()!=null && openAccess.getDisabled()==1))
            throw new BadRequestAlertException("未找到配置", "UserDingtalkRegisterService", "");

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/getuserinfo");
        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        request.setCode(requestAuthCode);
        request.setHttpMethod("GET");
        OapiUserGetuserinfoResponse response = null;
        try {
            response = client.execute(request, openAccess.getAccessToken());
            if(response.getErrcode()!=0||StringUtils.isEmpty(response.getUserid()))
                throw new BadRequestAlertException("获取user失败","UserDingtalkRegisterService",response.getErrmsg());
        } catch (ApiException e) {
            e.printStackTrace();
            throw new InternalServerErrorException("获取user失败");
        }
        String userId = response.getUserid();

        //先按userid或者username查
        IBZUSER user = ibzuserService.getOne(Wrappers.<IBZUSER>lambdaQuery().eq(IBZUSER::getUserid,userId).or().eq(IBZUSER::getUsername,userId),false);

        if(user==null)
        {
            //查不到情况下到auth表查真实userId
            SysUserAuth userAuth = sysUserAuthService.getOne(Wrappers.<SysUserAuth>lambdaQuery().eq(SysUserAuth::getIdentityType,"dingtalk").eq(SysUserAuth::getIdentifier, userId),false);
            // 该钉钉用户注册过账号，登录系统
            if (userAuth!=null) {
                user = ibzuserService.getById(userAuth.getUserid());
                if(user==null)
                    throw new BadRequestAlertException("未找到"+userId+"对应系统用户","UserDingtalkRegisterService","");

                AuthenticationUser curUser = authenticationUserService.loadUserByUsername(user.getLoginname()+(StringUtils.isEmpty(user.getDomains())?"":("|"+user.getDomains())));
                return curUser;
            }
        }

        return null;
    }


    /**
     * 钉钉服务端通过临时授权码code获取授权用户的个人信息
     *
     * @return
     */
    public JSONObject getUserBySnsToken(String id,String requestAuthCode) {
        JSONObject returnObj = null;

        SysOpenAccess openAccess = getOpenAccess(id);
        if (openAccess==null || (openAccess.getDisabled()!=null && openAccess.getDisabled()==1))
            throw new BadRequestAlertException("未找到配置", "UserDingtalkRegisterService", "");

        DefaultDingTalkClient  client = new DefaultDingTalkClient("https://oapi.dingtalk.com/sns/getuserinfo_bycode");
        OapiSnsGetuserinfoBycodeRequest req = new OapiSnsGetuserinfoBycodeRequest();
        req.setTmpAuthCode(requestAuthCode);
        try {
            OapiSnsGetuserinfoBycodeResponse response = client.execute(req,openAccess.getAccessKey(),openAccess.getSecretKey());

            if(response.getErrcode()!=0)
            {
                throw new BadRequestAlertException("获取user失败", "UserDingtalkRegisterService", response.getErrmsg());
            }

            returnObj.put("openid", response.getUserInfo().getOpenid());
            returnObj.put("nickname", response.getUserInfo().getNick());
            SysUserAuth userAuth = sysUserAuthService.getOne(Wrappers.<SysUserAuth>lambdaQuery().eq(SysUserAuth::getIdentityType,"dingtalk").eq(SysUserAuth::getIdentifier, response.getUserInfo().getOpenid()),false);

            IBZUSER user = null;
            // 该钉钉用户注册过账号，登录系统
            if (userAuth!=null) {
                user = ibzuserService.getById(userAuth.getUserid());
                if (user == null)
                    user = ibzuserService.getOne(Wrappers.<IBZUSER>lambdaQuery().eq(IBZUSER::getUserid,response.getUserInfo().getOpenid()).or().eq(IBZUSER::getUsername,response.getUserInfo().getOpenid()),false);

                if(user!=null)
                {
                    returnObj.put("username",user.getLoginname()+(StringUtils.isEmpty(user.getDomains())?"":("|"+user.getDomains())));
                }

            }

        } catch (ApiException e) {
            e.printStackTrace();
            throw new InternalServerErrorException("获取user失败");
        }

        return returnObj;
    }


}