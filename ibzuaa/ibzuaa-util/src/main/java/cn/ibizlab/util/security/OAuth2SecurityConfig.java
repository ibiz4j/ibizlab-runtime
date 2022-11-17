package cn.ibizlab.util.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * oauth资源服务器配置
 */
@Configuration
@EnableResourceServer
@Slf4j
@ConditionalOnProperty(name = "ibiz.oauth2.enable", havingValue = "true")
public class OAuth2SecurityConfig extends ResourceServerConfigurerAdapter {

    @Value("${ibiz.oauth2.header:Access-Token}")
    private String authorization;

    @Value("${ibiz.oauth2.signkey:oauth2}")
    private  String SignKey;

    /**
     * token存储、解析，校验
     * @param resources
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenExtractor(new OAuth2TokenExtractor());
        resources.tokenStore(getTokenStore()).stateless(true);
    }

    /**
     * 校验策略，只校验oauth2颁发的token（特定请求头）
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(new OAuth2RequestMatcher());
        http.authorizeRequests().anyRequest().authenticated();
    }

    /**
     * token存储器
     * @return
     */
    @Bean
    public TokenStore getTokenStore() {
        return new JwtTokenStore(accessTokenConverter());
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

    /**
     * 匹配特定oauth2请求头token，其余请求交由spring security处理
     */
    public class OAuth2RequestMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            String header = request.getHeader(authorization);
            if (!StringUtils.isEmpty(header)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * token请求头处理
     */
    public class OAuth2TokenExtractor implements TokenExtractor {

        @Override
        public Authentication extract(HttpServletRequest request) {
            String tokenValue = this.extractToken(request);
            if (tokenValue != null) {
                PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(tokenValue, "");
                return authentication;
            } else {
                return null;
            }
        }

        protected String extractToken(HttpServletRequest request) {
            String token = this.extractHeaderToken(request);
            if (token == null) {
                log.debug("Token not found in headers. Trying request parameters.");
                token = request.getParameter("access_token");
                if (token == null) {
                    log.debug("Token not found in request parameters.  Not an OAuth2 request.");
                } else {
                    request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE, "Bearer");
                }
            }

            return token;
        }

        protected String extractHeaderToken(HttpServletRequest request) {
            Enumeration headers = request.getHeaders(authorization);

            String value;
            do {
                if (!headers.hasMoreElements()) {
                    return null;
                }

                value = (String) headers.nextElement();
            } while (!value.toLowerCase().startsWith("Bearer".toLowerCase()));

            String authHeaderValue = value.substring("Bearer".length()).trim();
            request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE, value.substring(0, "Bearer".length()).trim());
            int commaIndex = authHeaderValue.indexOf(44);
            if (commaIndex > 0) {
                authHeaderValue = authHeaderValue.substring(0, commaIndex);
            }

            return authHeaderValue;
        }

    }

}
