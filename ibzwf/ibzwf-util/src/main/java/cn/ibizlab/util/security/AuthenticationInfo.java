package cn.ibizlab.util.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.io.Serializable;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticationInfo implements Serializable {
    private String token;
    private AuthenticationUser user;
    
    public AuthenticationInfo() {

    }
}
