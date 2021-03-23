package cn.ibizlab.util.service;


import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.security.AuthenticationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface AuthenticationUserService extends UserDetailsService {


    @Override
    @Cacheable( value="ibzuaa_users", key = "'getByUsername:'+#p0")
    default AuthenticationUser loadUserByUsername(String username){
        return null ;
    }


    @Cacheable( value="ibzuaa_users", key = "'getByUsername:'+#p0")
    AuthenticationUser loadUserByLogin(String username,String password);

    @CacheEvict( value="ibzuaa_users", key = "'getByUsername:'+#p0")
    default void resetByUsername(String username){}


}
