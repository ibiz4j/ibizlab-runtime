package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.uaa.domain.SysUser;
import cn.ibizlab.core.uaa.service.impl.SysUserServiceImpl;
import cn.ibizlab.util.client.IBZOUFeignClient;
import cn.ibizlab.util.service.AuthenticationUserService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.CachedBeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 实体[IBZUSER] 服务对象接口实现
 */
@Service("UAAUserService")
public class UAAUserService extends SysUserServiceImpl implements AuthenticationUserService {

	@Value("${ibiz.auth.pwencrymode:0}")
	private int pwencrymode;

	@Override
	public AuthenticationUser loadUserByUsername(String username) {
		if(StringUtils.isEmpty(username))
			throw new UsernameNotFoundException("用户名为空");
		QueryWrapper<SysUser> conds=new QueryWrapper<SysUser>();
		String[] data=username.split("[|]");
		String loginname="";
		String domains="";
		if(data.length>0)
			loginname=data[0].trim();
		if(data.length>1)
			domains=data[1].trim();
		if(!StringUtils.isEmpty(loginname))
			conds.eq("loginname",loginname);
		if(!StringUtils.isEmpty(domains))
			conds.eq("domains",domains);
		SysUser user = this.getOne(conds);
		if (user == null) {
			throw new UsernameNotFoundException("用户" + username + "未找到");
		}
		else {
			user.setUsername(username);

			AuthenticationUser curUser = createUserDetails(user);
			if(curUser.getPermissionList()==null)
			{
				setUserPermission(curUser);
				setUserOrgInfo(curUser);
			}

			return curUser;
		}
	}

	@Override
	public AuthenticationUser loadUserByLogin(String username, String password){
		AuthenticationUser authuserdetail = loadUserByUsername(username);
		if(pwencrymode==1)
			password = DigestUtils.md5DigestAsHex(password.getBytes());
		else if(pwencrymode==2)
			password = DigestUtils.md5DigestAsHex(String.format("%1$s||%2$s", username, password).getBytes());
		if(!authuserdetail.getPassword().equals( password )){
			throw new BadRequestAlertException("用户名密码错误","IBZUSER",username);
		}
		return authuserdetail;
	}


	public void resetByUsername(String username) {

	}

	public  AuthenticationUser createUserDetails(SysUser user) {
		AuthenticationUser userdatail = new AuthenticationUser();
		CachedBeanCopier.copy(user,userdatail);
		if(userdatail.getSuperuser()==1){
			userdatail.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_SUPERADMIN"));
		}
		return userdatail;
	}


	@Autowired
	@Lazy
	private UAACoreService uaaCoreService;


	/**
	 * 设置用户权限
	 * 由于GrantedAuthority缺少无参构造，导致无法序列化，暂时通过PermissionList中转
	 * @param user
	 * @return
	 */
	public void setUserPermission(AuthenticationUser user) {
		Collection<GrantedAuthority> userAuthorities=uaaCoreService.getAuthoritiesByUserId(user.getUserid());
		Set<String> authorities = AuthorityUtils.authorityListToSet(userAuthorities);
		if(user.getSuperuser()==1){
			authorities.add("ROLE_SUPERADMIN");
		}
		JSONObject permission =new JSONObject();
		permission.put("authorities",authorities);
		user.setPermissionList(permission);
	}

	@Autowired
	@Lazy
	private IBZOUFeignClient ouFeignClient;

	/**
	 * 设置用户组织相关信息
	 * @param user
	 */
	private void setUserOrgInfo(AuthenticationUser user) {

		Map<String, Set<String>> orgInfo=ouFeignClient.getOUMapsByUserId(user.getUserid());
		if(orgInfo==null)
			orgInfo=new HashMap<>();
		//throw new RuntimeException(String.format("获取用户信息失败，请检查用户中心[IBZOU]中是否存在[%s]用户!",user.getLoginname()));

		user.setOrgInfo(orgInfo);
	}
}