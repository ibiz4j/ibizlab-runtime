package cn.ibizlab.config;

import cn.ibizlab.util.security.AuthenticationEntryPoint;
import cn.ibizlab.util.security.AuthorizationTokenFilter;
import cn.ibizlab.util.service.AuthenticationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DevBootSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    private AuthenticationUserService userDetailsService;

    /**
     * 自定义基于JWT的安全过滤器
     */
    @Autowired
    AuthorizationTokenFilter authenticationTokenFilter;

    @Value("${ibiz.auth.path:v7/login}")
    private String loginPath;

    @Value("${ibiz.auth.uaaloginpath:uaa/login}")
    private String uaaLoginPath;

    @Value("${ibiz.auth.uaaloginpath2:uaa/loginbyusername}")
    private String uaaLoginPath2;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoderBean());
    }

    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        // Remove the ROLE_ prefix
        return new GrantedAuthorityDefaults("");
    }

    @Bean
    public PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

               httpSecurity
                // 禁用 CSRF
                .csrf().disable()
                // 授权异常
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                // 不创建会话
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 过滤请求
                .authorizeRequests()
                .antMatchers(
                        HttpMethod.GET,
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/**/*.ico",
                        "/**/assets/**",
                        "/**/css/**",
                        "/**/fonts/**",
                        "/**/js/**",
                        "/**/img/**",
                        "/"
                ).permitAll()
                       .antMatchers("/uaa/permission/**").permitAll()
                    //放行登录请求
                   .antMatchers( HttpMethod.POST,"/"+loginPath).permitAll()
                       .antMatchers( HttpMethod.POST,"/"+uaaLoginPath).permitAll()
                       .antMatchers( HttpMethod.POST,"/"+uaaLoginPath2).permitAll()
                       .antMatchers("/syspssystems/**/permissiondata").permitAll()
                       //同步系统权限资源
                       .antMatchers("/syspssystems/save").permitAll()
                       .antMatchers("/uaa/login").permitAll()
                       .antMatchers("/uaa/register").permitAll()

                       .antMatchers("/uaa/responseTokenToWeiXin").permitAll()
                       .antMatchers("/uaa/getWechatAppId").permitAll()
                       .antMatchers("/uaa/queryWechatUserByCode").permitAll()
                       .antMatchers("/uaa/bindWechatToRegister").permitAll()

                       .antMatchers("/uaa/getDingtalkAppId").permitAll()
                       .antMatchers("/uaa/queryDingtalkUserByCode").permitAll()
                       .antMatchers("/uaa/bindDingtalkToRegister").permitAll()

                       .antMatchers("/uaa/getQQAppId").permitAll()
                       .antMatchers("/uaa/queryQQUserByCode").permitAll()
                       .antMatchers("/uaa/bindQQtoRegister").permitAll()
                       .antMatchers("/uaa/publickey").permitAll()
                       .antMatchers("/uaa/dingtalk/jsapi/sign").permitAll()
                .anyRequest().authenticated()
                // 防止iframe 造成跨域
                .and().headers().frameOptions().disable();
        httpSecurity
                .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
