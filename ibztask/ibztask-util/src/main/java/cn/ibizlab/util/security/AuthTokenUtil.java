package cn.ibizlab.util.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthTokenUtil {

    String generateToken(UserDetails userDetails);

    Boolean validateToken(String token, UserDetails userDetails);

    String getUsernameFromToken(String token);

}

