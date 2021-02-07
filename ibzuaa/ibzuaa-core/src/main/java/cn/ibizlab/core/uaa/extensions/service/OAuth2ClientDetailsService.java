package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.uaa.domain.SysOpenAccess;
import cn.ibizlab.core.uaa.service.ISysOpenAccessService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;

/**
 * oauth2客户端管理
 */
@Service
@ConditionalOnProperty(name = "ibiz.oauth2.enable", havingValue = "true")
public class OAuth2ClientDetailsService implements ClientDetailsService {

    @Autowired
    ISysOpenAccessService openAccessService;

    private static final String scope = "all";

    private static final String authority="ROLE_SUPERADMIN";

    @Override
    public ClientDetails loadClientByClientId(String clientId)
            throws ClientRegistrationException {
        QueryWrapper<SysOpenAccess> conds = new QueryWrapper();
        conds.eq("access_key",clientId);
        SysOpenAccess openAccess = openAccessService.getOne(conds);
        if (openAccess == null) {
            throw new UsernameNotFoundException("用户" + clientId + "未找到");
        }
        String appSecret=openAccess.getSecretKey();
        if(ObjectUtils.isEmpty(appSecret)){
            throw new UsernameNotFoundException("获取" + clientId + "应用秘钥失败");
        }
        BaseClientDetails client = new BaseClientDetails();
        String secret = "{bcrypt}" + new BCryptPasswordEncoder().encode(openAccess.getSecretKey());
        client.setScope(new ArrayList(){{add(scope);}});
        client.setClientId(clientId);
        client.setClientSecret(secret);
        client.setAuthorities(new ArrayList(){{add(new SimpleGrantedAuthority(authority));}});
        return client;
    }
}
