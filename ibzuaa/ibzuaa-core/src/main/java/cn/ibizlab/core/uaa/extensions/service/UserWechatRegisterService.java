package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.uaa.domain.SysOpenAccess;
import cn.ibizlab.core.uaa.domain.SysUser;
import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.service.ISysOpenAccessService;
import cn.ibizlab.core.uaa.service.ISysUserAuthService;
import cn.ibizlab.core.uaa.service.ISysUserService;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.errors.InternalServerErrorException;
import cn.ibizlab.util.helper.HttpUtils;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 实体[IBZUSER] 微信用户注册接口实现
 */
@Service
@Slf4j
public class UserWechatRegisterService {

    @Autowired
    private ISysUserService sysUserService;

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
        final String accessid = StringUtils.isEmpty(id)?"wechat":id;
        SysOpenAccess sysOpenAccess=sysOpenAccessService.getOne(Wrappers.<SysOpenAccess>lambdaQuery().eq(SysOpenAccess::getOpenType,"wechat").
                and(wrapper -> wrapper.eq(SysOpenAccess::getAccessKey,accessid).or().eq(SysOpenAccess::getId,accessid)),false);
        if((sysOpenAccess==null|| (sysOpenAccess.getDisabled()!=null && sysOpenAccess.getDisabled()==1))&&throwEx)
            throw new BadRequestAlertException("获取接入配置失败","UserWechatRegisterService","");


        return sysOpenAccess;
    }

    /**
     * 微信服务端通过临时授权码code获取授权用户的个人信息
     *
     * @return
     */
    public JSONObject getUserBySnsToken(String id,String requestAuthCode) {
        JSONObject returnObj = null;

        SysOpenAccess openAccess = getOpenAccess(id);
        if (openAccess==null || (openAccess.getDisabled()!=null && openAccess.getDisabled()==1))
            throw new BadRequestAlertException("未找到配置", "UserWechatRegisterService", "");


        try {

            // 1.根据code获取access_token、openid、refresh_token
            String getAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                    "appid=" + openAccess.getAccessKey() +
                    "&secret=" + openAccess.getSecretKey() +
                    "&code=" + requestAuthCode +
                    "&grant_type=authorization_code";
            returnObj = JSONObject.parseObject(HttpUtils.get(getAccessTokenUrl, null, null));
            if (!returnObj.containsKey("access_token") && !returnObj.containsKey("openid")) {
                throw new BadRequestAlertException("微信服务端获取access_token失败!", "UserWechatRegisterService", "");
            }
            String access_token = returnObj.getString("access_token");
            String openid = returnObj.getString("openid");
            String refresh_token = returnObj.getString("refresh_token");
            String unionid = returnObj.getString("unionid");


            SysUserAuth userAuth = sysUserAuthService.getOne(Wrappers.<SysUserAuth>lambdaQuery().eq(SysUserAuth::getIdentityType,openAccess.getId())
                    .and(wrapper -> wrapper.eq(SysUserAuth::getIdentifier, openid).or().eq(SysUserAuth::getIdentifier, unionid)
                    ),false);

            if(userAuth==null)
                userAuth = sysUserAuthService.getOne(Wrappers.<SysUserAuth>lambdaQuery().eq(SysUserAuth::getIdentityType,"wechat")
                        .and(wrapper -> wrapper.eq(SysUserAuth::getIdentifier, openid).or().eq(SysUserAuth::getIdentifier, unionid)
                        ),false);

            SysUser user = null;
            // 该wechat用户注册过账号，登录系统
            if (userAuth!=null) {
                user = sysUserService.getById(userAuth.getUserid());
                if (user == null)
                    user = sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUserid,openid).or().eq(SysUser::getUsername,openid),false);

                if(user!=null)
                {
                    returnObj.put("username",user.getLoginname()+(StringUtils.isEmpty(user.getDomains())?"":("|"+user.getDomains())));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServerErrorException("获取user失败");
        }

        return returnObj;
    }


}