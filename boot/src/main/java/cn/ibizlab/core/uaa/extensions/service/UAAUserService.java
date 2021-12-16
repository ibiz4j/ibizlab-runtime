package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.ou.extensions.domain.DeptMap;
import cn.ibizlab.core.ou.extensions.domain.OrgMap;
import cn.ibizlab.core.ou.extensions.service.OUCoreService;
import cn.ibizlab.core.uaa.domain.SysUser;
import cn.ibizlab.core.uaa.extensions.service.UAACoreService;
import cn.ibizlab.core.uaa.mapper.SysUserMapper;
import cn.ibizlab.core.uaa.service.ISysUserService;
import cn.ibizlab.core.uaa.service.impl.SysUserServiceImpl;
import cn.ibizlab.util.helper.Sm3Util;
import cn.ibizlab.util.service.AuthenticationUserService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.CachedBeanCopier;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

import java.util.*;

@Primary
@Service("UAAUserService")
@ConditionalOnExpression("'${ibiz.auth.service:UAAUserService}'.equals('UAAUserService')")
public class UAAUserService implements   AuthenticationUserService {

	@Autowired
	private ISysUserService sysUserService;

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
		SysUser user = sysUserService.getOne(conds);
		if (user == null) {
			throw new BadRequestAlertException("用户名密码错误","IBZUSER",username);
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
		else if(pwencrymode==3&&password.length()!=64)
			password = Sm3Util.encrypt(password).toUpperCase();
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
		userdatail.setSuperuser(user.getSuperuser()==null?0:user.getSuperuser());
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
	private OUCoreService ouCoreService;

	/**
	 * 设置用户组织相关信息
	 * @param user
	 */
	private void setUserOrgInfo(AuthenticationUser user) {
		String orgid="nullorgid";
		if(!StringUtils.isEmpty(user.getOrgid()))
			orgid=user.getOrgid();
		String deptid="nulldeptid";
		if(!StringUtils.isEmpty(user.getMdeptid()))
			deptid=user.getMdeptid();
		Map<String, Set<String>> map=new LinkedHashMap<>();
		OrgMap storemap=ouCoreService.getOrgModel(orgid);
		map.put("parentorg",storemap.getParent());
		map.put("suborg",storemap.getSub());
		map.put("fatherorg",storemap.getFather());

		DeptMap storedeptmap=ouCoreService.getDeptModel(deptid);
		map.put("parentdept",storedeptmap.getParent());
		map.put("subdept",storedeptmap.getSub());
		map.put("fatherdept",storedeptmap.getFather());
		user.setOrgInfo(map);
	}
}