package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.ou.domain.SysDeptMember;
import cn.ibizlab.core.ou.domain.SysTeamMember;
import cn.ibizlab.core.ou.extensions.domain.DeptMap;
import cn.ibizlab.core.ou.extensions.domain.OrgMap;
import cn.ibizlab.core.ou.extensions.service.OUCoreService;
import cn.ibizlab.core.ou.extensions.service.OUModelService;
import cn.ibizlab.core.ou.service.ISysDeptMemberService;
import cn.ibizlab.core.ou.service.ISysTeamMemberService;
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
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

import java.util.*;
import java.util.stream.Collectors;

@Primary
@Service("UAAUserService")
@ConditionalOnExpression("'${ibiz.auth.service:UAAUserService}'.equals('UAAUserService')")
public class UAAUserService implements   AuthenticationUserService {

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private UAACoreService uaaCoreService;

	@Autowired
	private OUCoreService ouCoreService;

	@Autowired
	private OUModelService ouModelService;

	@Autowired
	ISysDeptMemberService sysDeptMemberService;

	@Autowired
	ISysTeamMemberService sysTeamMemberService;

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

		Set <String> userDepts = null;
		Set <String> userDepts2 = null;
		Set <String> userTeams = null;

		if(!StringUtils.isEmpty(user.getUserid())){
			List<SysDeptMember> deptMembers = sysDeptMemberService.list(new QueryWrapper<SysDeptMember>().eq("userid",user.getUserid()));
			//设置用户归属部门（含主部门）
			if(!ObjectUtils.isEmpty(deptMembers)){
				userDepts = deptMembers.stream().filter(deptMember -> !ObjectUtils.isEmpty(deptMember.getDeptid()))
												  .map(deptMember -> deptMember.getDeptid())
												  .collect(Collectors.toSet());
				//用户兼职部门
				if(!ObjectUtils.isEmpty(user.getMdeptid()) && !ObjectUtils.isEmpty(userDepts)){
					userDepts2 = userDepts.stream().filter(userDeptId -> !userDeptId.equals(user.getMdeptid())).collect(Collectors.toSet());
				}
			}

			//查询用户组信息
			List<SysTeamMember> sysTeamMembers= sysTeamMemberService.list(new QueryWrapper<SysTeamMember>().eq("userid",user.getUserid()));
			if(!ObjectUtils.isEmpty(sysTeamMembers)){
				userTeams = sysTeamMembers.stream().filter(sysTeamMember -> !ObjectUtils.isEmpty(sysTeamMember.getTeamid()))
													 .map(sysTeamMember -> sysTeamMember.getTeamid()).collect(Collectors.toSet());
			}
		}

		//用户仅包含主部门，无兼职部门
		if(ObjectUtils.isEmpty(userDepts2)){
			DeptMap storedeptmap=ouCoreService.getDeptModel(deptid);
			map.put("parentdept",storedeptmap.getParent());
			map.put("subdept",storedeptmap.getSub());
			map.put("fatherdept",storedeptmap.getFather());
		}
		else{
			//存在兼职部门
			Map<String, DeptMap> deptStore = ouModelService.getDeptModel(ouModelService.getOrgModel());

			Set <String> parents = null;
			Set <String> subDepts = null;
			Set <String> fatherDepts = null;

			//计算兼职部门的上下级部门
			if(!ObjectUtils.isEmpty(deptStore)){
				for(Map.Entry<String, DeptMap> entry : deptStore.entrySet()){

					String deptId = entry.getKey();
					DeptMap deptMap = entry.getValue();

					if(userDepts.contains(deptId) && deptMap != null){
						if(!ObjectUtils.isEmpty(deptMap.getParent())){
							if(parents == null)
								parents = new HashSet<>();

							parents.addAll(deptMap.getParent());
						}

						if(!ObjectUtils.isEmpty(deptMap.getSub())){
							if(subDepts == null)
								subDepts = new HashSet<>();
							subDepts.addAll(deptMap.getSub());
						}

						if(!ObjectUtils.isEmpty(deptMap.getFather())){
							if(fatherDepts == null)
								fatherDepts = new HashSet<>();

							fatherDepts.addAll(deptMap.getFather());
						}
					}
				}
			}
			map.put("parentdept",parents);
			map.put("subdept",subDepts);
			map.put("fatherdept",fatherDepts);
		}

		map.put("curdept",userDepts);
		map.put("curteam",userTeams);
		user.setOrgInfo(map);
	}
}