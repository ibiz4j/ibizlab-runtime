package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.uaa.extensions.helper.DingTalkHelper;
import cn.ibizlab.util.domain.TokenInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class DingTalkTokenService {

    @Autowired
    @Lazy
    DingTalkTokenService proxyService;

    /**
     * 通过api获取token及ticket并缓存
     * @param appKey
     * @param appSecret
     * @return
     */
    @Cacheable(value="accesstoken",key = "'appid:'+#p0+'||'+#p1")
    public TokenInfo getTokenInfoByCache(String appKey, String appSecret){
        String ticket = null;
        String token =DingTalkHelper.getAccessToken(appKey,appSecret);
        if(!StringUtils.isEmpty(token)){
            ticket=DingTalkHelper.getJsapiTicket(token);
        }
        return  TokenInfo.builder().accessToken(token).lastRefreshTime(System.currentTimeMillis()).ticket(ticket).build();
    }
    /**
     * 清除token.ticket缓存
     * @param appKey
     * @param appSecret
     */
    @CacheEvict( value="accesstoken",key = "'appid:'+#p0+'||'+#p1")
    public void resetToken(String appKey,String appSecret){

    }
    /**
     * 获取token
     * @param appKey
     * @param appSecret
     * @return
     */
    public String getAccessToken(String appKey,String appSecret){
        String token="";
        TokenInfo tokenInfo=proxyService.getTokenInfo(appKey, appSecret);
        if(!ObjectUtils.isEmpty(tokenInfo)){
            return tokenInfo.getAccessToken();
        }
        return token;
    }
    /**
     * 获取ticket
     * @param appKey
     * @param appSecret
     * @return
     */
    public String getJSTicket(String appKey,String appSecret){
        String ticket="";
        TokenInfo tokenInfo=proxyService.getTokenInfo(appKey, appSecret);
        if(!ObjectUtils.isEmpty(tokenInfo)){
            return tokenInfo.getTicket();
        }
        return ticket;
    }
    /**
     * 获取token信息
     * @param appKey
     * @param appSecret
     * @return
     */
    public synchronized TokenInfo getTokenInfo(String appKey,String appSecret){
        TokenInfo tokenInfo = proxyService.getTokenInfoByCache(appKey,appSecret);
        if(!ObjectUtils.isEmpty(tokenInfo)){
            if (System.currentTimeMillis() < tokenInfo.getLastRefreshTime() + 7100000) {//缓存是否过期
                return tokenInfo;
            }
            else{
                proxyService.resetToken(appKey,appSecret);//清除缓存
                return proxyService.getTokenInfoByCache(appKey,appSecret);//重新进缓存
            }
        }
        return null;
    }
}
