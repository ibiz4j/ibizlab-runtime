package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.uaa.domain.SysOpenAccess;
import cn.ibizlab.core.uaa.domain.SysUser;
import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.service.ISysOpenAccessService;
import cn.ibizlab.core.uaa.service.ISysUserAuthService;
import cn.ibizlab.core.uaa.service.ISysUserService;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.errors.InternalServerErrorException;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.service.AuthenticationUserService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiSnsGetuserinfoBycodeRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiSnsGetuserinfoBycodeResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 实体[IBZUSER] 钉钉用户注册接口实现
 */
@Service
@Slf4j
public class UserDingtalkRegisterService {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private AuthenticationUserService authenticationUserService;

    @Autowired
    private ISysUserAuthService sysUserAuthService;

    @Autowired
    @Lazy
    DingTalkTokenService dingTalkTokenService;

    @Autowired
    private ISysOpenAccessService sysOpenAccessService;

    public SysOpenAccess getOpenAccess(String id)
    {
        return getOpenAccess(id,true);
    }

    public SysOpenAccess getOpenAccess(String id, boolean throwEx)
    {
        final String accessid = StringUtils.isEmpty(id)?"dingtalk":id;
        SysOpenAccess sysOpenAccess=sysOpenAccessService.getOne(Wrappers.<SysOpenAccess>lambdaQuery().eq(SysOpenAccess::getOpenType,"dingtalk").
                and(wrapper -> wrapper.eq(SysOpenAccess::getAccessKey,accessid).or().eq(SysOpenAccess::getId,accessid)),false);
        if((sysOpenAccess==null|| (sysOpenAccess.getDisabled()!=null && sysOpenAccess.getDisabled()==1))&&throwEx)
            throw new BadRequestAlertException("获取接入配置失败","UserDingtalkRegisterService","");

        try {
            String accessToken =dingTalkTokenService.getAccessToken(sysOpenAccess.getAccessKey(),sysOpenAccess.getSecretKey());
            sysOpenAccess.setAccessToken(accessToken);
        }
        catch (Exception ex)
        {

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
        SysUser user = sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUserid,userId).or().eq(SysUser::getUsername,userId),false);

        if(user==null)
        {
            //查不到情况下到auth表查真实userId
            SysUserAuth userAuth = sysUserAuthService.getOne(Wrappers.<SysUserAuth>lambdaQuery().eq(SysUserAuth::getIdentityType,openAccess.getId()).eq(SysUserAuth::getIdentifier, userId),false);

            if(userAuth==null)
                userAuth = sysUserAuthService.getOne(Wrappers.<SysUserAuth>lambdaQuery().eq(SysUserAuth::getIdentityType,"dingtalk").eq(SysUserAuth::getIdentifier, userId),false);

            // 该钉钉用户注册过账号，登录系统
            if (userAuth!=null) {
                user = sysUserService.getById(userAuth.getUserid());
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
        JSONObject returnObj = new JSONObject();
        final String accessid = StringUtils.isEmpty(id)?"dingtalk":id;
        SysOpenAccess openAccess=sysOpenAccessService.getOne(Wrappers.<SysOpenAccess>lambdaQuery().eq(SysOpenAccess::getOpenType,"dingtalk").
                and(wrapper -> wrapper.eq(SysOpenAccess::getAccessKey,accessid).or().eq(SysOpenAccess::getId,accessid)),false);

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
            returnObj.put("unionid", response.getUserInfo().getUnionid());
            SysUserAuth userAuth = sysUserAuthService.getOne(Wrappers.<SysUserAuth>lambdaQuery().eq(SysUserAuth::getIdentityType,openAccess.getId())
                    .and(wrapper -> wrapper.eq(SysUserAuth::getIdentifier, response.getUserInfo().getOpenid()).or().eq(SysUserAuth::getIdentifier, response.getUserInfo().getUnionid())
                    ),false);

            if(userAuth==null)
                userAuth = sysUserAuthService.getOne(Wrappers.<SysUserAuth>lambdaQuery().eq(SysUserAuth::getIdentityType,"dingtalk")
                        .and(wrapper -> wrapper.eq(SysUserAuth::getIdentifier, response.getUserInfo().getOpenid()).or().eq(SysUserAuth::getIdentifier, response.getUserInfo().getUnionid())
                        ),false);

            SysUser user = null;
            // 该钉钉用户注册过账号，登录系统
            if (userAuth!=null) {
                user = sysUserService.getById(userAuth.getUserid());
                if (user == null)
                    user = sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUserid,response.getUserInfo().getOpenid()).or().eq(SysUser::getUsername,response.getUserInfo().getOpenid()),false);

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