package cn.ibizlab.core.workflow.extensions.domain;

import cn.ibizlab.util.security.AuthenticationUser;
import org.flowable.common.engine.api.identity.AuthenticationContext;
import org.flowable.common.engine.impl.identity.Authentication;

import java.security.Principal;

public class FlowUser implements Principal {


    public String getName() {
        return this.user.getUserid();
    }

    private AuthenticationUser user;

    private String token;

    public AuthenticationUser getUser() {
        return user;
    }

    public void setUser(AuthenticationUser user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static FlowUser getCurUser()
    {
        AuthenticationContext context = Authentication.getAuthenticationContext();
        if(context!=null&&context.getPrincipal()!=null&&context.getPrincipal() instanceof FlowUser)
            return (FlowUser)context.getPrincipal();
        else
        {
            FlowUser user = new FlowUser();
            user.setUser(AuthenticationUser.getAuthenticationUser());
            return user;
        }

    }
}
