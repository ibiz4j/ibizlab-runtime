package cn.ibizlab.util.service;


import cn.ibizlab.util.client.IBZUAAFeignClient;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.security.AuthorizationLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnExpression("'${spring.application.name}'.startsWith('ibzuaa-web')")
public class SimulUserService implements AuthenticationUserService {

	@Autowired
	private IBZUAAFeignClient uaaFeignClient;

	@Override
	public AuthenticationUser loadUserByUsername(String username) {

		AuthenticationUser user=uaaFeignClient.loginByUsername(username);
		if(user==null)
			throw new BadRequestAlertException("登录失败","IBZUAAUser",username)	;
		return user;
	}

	@Override
	public AuthenticationUser loadUserByLogin(String username, String password) {
		String[] data=username.split("[|]");
		String loginname=username;
		String domains="";

		if(data.length==2) {
			loginname=data[0].trim();
			domains=data[1].trim();
		}
		AuthorizationLogin logininfo = new AuthorizationLogin();
		logininfo.setDomain(domains);
		logininfo.setLoginname(loginname);
		logininfo.setPassword(password);
		AuthenticationUser user=uaaFeignClient.login(logininfo);
		if(user==null)
			throw new BadRequestAlertException("登录失败","IBZUAAUser",username);
		return user;
	}


	@Override
	public void resetByUsername(String username) {

	}
}