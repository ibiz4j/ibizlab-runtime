package cn.ibizlab.core.uaa.extensions.config;

import cn.ibizlab.core.uaa.extensions.service.OAuth2ClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;


/**
 * oauth2认证服务器配置
 */
@Configuration
@EnableAuthorizationServer
@ConditionalOnProperty(name = "ibiz.oauth2.enable", havingValue = "true")
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${ibiz.jwt.oauth2.signkey:oauth2}")
    private String SignKey;

    @Value("${ibiz.oauth.expiration:7200}")
    private int expiration;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Autowired
    OAuth2ClientDetailsService clientDetailsService;

    /**
     * 客户端配置
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService);
    }

    /**
     * 访问端点、Token存储策略
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .tokenStore(getTokenStore())
                .accessTokenConverter(accessTokenConverter())
                .authenticationManager(authenticationManager)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }

    /**
     * 访问端点权限配置
     * @param oauthServer
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.allowFormAuthenticationForClients().checkTokenAccess("permitAll()");
    }

    /**
     * token存储策略
     * @return
     */
    @Bean
    public TokenStore getTokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    /**
     * 客户端秘钥
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * token存储策略（jwt增强）
     * @return
     */
    @Bean
    public AuthorizationServerTokenServices tokenService() {
        DefaultTokenServices tokenService = new DefaultTokenServices();
        tokenService.setClientDetailsService(clientDetailsService);
        tokenService.setSupportRefreshToken(true);
        tokenService.setTokenStore(getTokenStore());

        TokenEnhancerChain enhancer = new TokenEnhancerChain();
        enhancer.setTokenEnhancers(Arrays.asList(accessTokenConverter()));
        tokenService.setTokenEnhancer(enhancer);
        tokenService.setAccessTokenValiditySeconds(expiration);
        return tokenService;
    }

    /**
     * jwt密签
     * @return
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SignKey);
        return converter;
    }
}


