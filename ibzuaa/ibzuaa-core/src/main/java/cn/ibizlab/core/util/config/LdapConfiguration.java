package cn.ibizlab.core.util.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

import java.util.HashMap;
import java.util.Map;

/**
 * Ldap配置
 * 用于远程调用平台用户验证（用户名、密码）
 */
@Configuration
public class LdapConfiguration {

    private LdapTemplate ldapTemplate;
    
    @Value("${ldap.url:}")
    private String url ;

    @Value("${ldap.base:}")
    private String base ;
    
    @Value("${ldap.userdn:}")
    private String userdn ;

    @Value("${ldap.password:}")
    private String password ;

    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        Map<String, Object> config = new HashMap();
        contextSource.setUrl(url);
        contextSource.setBase(base);
        contextSource.setUserDn(userdn);
        contextSource.setPassword(password);
        config.put("java.naming.ldap.attributes.binary", "objectGUID");
        contextSource.setPooled(true);
        contextSource.setBaseEnvironmentProperties(config);
        return contextSource;
    }
 
    @Bean
    public LdapTemplate ldapTemplate() {
        if (null == ldapTemplate)
            ldapTemplate = new LdapTemplate(contextSource());
        return ldapTemplate;
    }

}