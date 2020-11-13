package cn.ibizlab.util.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;
import java.sql.Timestamp;
import java.util.*;
import com.alibaba.fastjson.JSONObject;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticationUser implements UserDetails
{
	public AuthenticationUser(){}
	/**
	 * 用戶标识
	 */
	private String userid;
	/**
	 * 用户全局名
	 */
	private String username;
	/**
	 * 用户姓名
	 */
	private String personname;
	/**
	 * 登录名
	 */
	private String loginname;
	/**
	 * 用户工号
	 */
	private String usercode;
	/**
	 * 登录密码
	 */
	private String password;
	/**
	 * 区属
	 */
	private String domain;
	/**
	 * 部门标识
	 */
	private String mdeptid;
	/**
	 * 部门编码
	 */
	private String mdeptcode;
	/**
	 * 部门名称
	 */
	private String mdeptname;
	/**
	 * 业务编码
	 */
	private String bcode;
	/**
	 * 岗位标识
	 */
	private String postid;
	/**
	 * 岗位代码
	 */
	private String postcode;
	/**
	 * 岗位名称
	 */
	private String postname;
	/**
	 * 单位标识
	 */
	private String orgid;
	/**
	 * 单位编码
	 */
	private String orgcode;
	/**
	 * 单位名称
	 */
	private String orgname;
	/**
	 * 昵称别名
	 */
	private String nickname;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 社交账号
	 */
	private String avatar;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 照片
	 */
	private String usericon;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 出生日期
	 */
	private Timestamp birthday;
	/**
	 * 证件号码
	 */
	private String certcode;
	/**
	 * 地址
	 */
	private String addr;
	/**
	 * 主题
	 */
	private String theme;
	/**
	 * 字号
	 */
	private String fontsize;
	/**
	 * 语言
	 */
	private String lang;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 保留字段
	 */
	private String reserver;
	/**
	 * 用户上下文参数
	 */
	private Map <String,Object> sessionParams;
	/**
	 * 用户权限资源
	 */
	@JsonIgnore
	private Collection<GrantedAuthority> authorities;
    /**
    * 是否为超级管理员
    */
    private int superuser;
    /**
    * 用户权限资源
    */
    private JSONObject permissionList;
    /**
    * 用户上下文参数
    */
    @JsonIgnore
    private Map<String,Object> userSessionParam;
    /**
    * 当前用户上下级组织信息
    */
    private Map<String, Set<String>> orgInfo;
	/**
	* 上级组织
	*/
	private String porg;
	/**
	* 下级组织
	*/
	private String sorg;
	/**
	* 上级部门
	*/
	private String pdept;
	/**
	* 下级部门
	*/
	private String sdept;

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public static AuthenticationUser getAuthenticationUser()
	{
        if(SecurityContextHolder.getContext()==null||SecurityContextHolder.getContext().getAuthentication()==null||SecurityContextHolder.getContext().getAuthentication().getPrincipal()==null){
			return new AuthenticationUser();
		}
    	Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		AuthenticationUser authuserdetail;
		if(userDetails instanceof AuthenticationUser ) {
			authuserdetail= (AuthenticationUser)userDetails;
		}
		else {
			authuserdetail=new AuthenticationUser();
		}
	 	return authuserdetail;
	}

    public Map <String,Object> getSessionParams()
    {
		if(this.sessionParams==null)
		{
			sessionParams = getUserSessionParam();
			sessionParams.put("srfpersonid", this.getUserid());
			sessionParams.put("srfpersonname", this.getPersonname());
			sessionParams.put("srforgsectorid", this.getMdeptid());
			sessionParams.put("srforgsectorcode", this.getMdeptcode());
			sessionParams.put("srforgsectorname", this.getMdeptname());
			sessionParams.put("srforgid", this.getOrgid());
			sessionParams.put("srforgcode", this.getOrgcode());
			sessionParams.put("srforgname", this.getOrgname());
			sessionParams.put("srfuserid", this.getUserid());
			sessionParams.put("srfusername", this.getPersonname());
			sessionParams.put("srfusermode", "");
			sessionParams.put("srforgsectorbc", this.getBcode());
			sessionParams.put("srfloginname", this.getLoginname());
			sessionParams.put("srflocale", this.getLang());
			sessionParams.put("srftimezone", "");
    		sessionParams.put("srfusercode", this.getUsercode());
			sessionParams.put("srfporg", this.getPorg());
			sessionParams.put("srfsorg", this.getSorg());
			sessionParams.put("srfpdept", this.getPdept());
			sessionParams.put("srfsdept", this.getSdept());
		}
		return this.sessionParams;
    }
    private Map<String, Object> getUserSessionParam() {
		if(userSessionParam!=null){
			return userSessionParam;
		}
		else{
			return new HashMap<>();
		}
    }

	public void setOrgInfo(Map<String, Set<String>> orgInfo) {
		this.orgInfo = orgInfo;
		if(!ObjectUtils.isEmpty(orgInfo) && !ObjectUtils.isEmpty(orgInfo.get("parentorg"))){
			porg=(String.format("'%s'",String.join("','",orgInfo.get("parentorg"))));
            this.getSessionParams().put("srfporg",porg);
		}
		if(!ObjectUtils.isEmpty(orgInfo) && !ObjectUtils.isEmpty(orgInfo.get("suborg")) ){
			sorg=(String.format("'%s'",String.join("','",orgInfo.get("suborg"))));
            this.getSessionParams().put("srfsorg",sorg);
		}
		if(!ObjectUtils.isEmpty(orgInfo) && !ObjectUtils.isEmpty(orgInfo.get("parentdept"))){
			pdept=(String.format("'%s'",String.join("','",orgInfo.get("parentdept"))));
            this.getSessionParams().put("srfpdept",pdept);
		}
		if(!ObjectUtils.isEmpty(orgInfo) && !ObjectUtils.isEmpty(orgInfo.get("subdept"))){
			sdept=(String.format("'%s'",String.join("','",orgInfo.get("subdept"))));
            this.getSessionParams().put("srfsdept",sdept);
		}
	}

	public void setPermissionList(JSONObject permissionList) {
		this.permissionList = permissionList;
		if(authorities==null && permissionList !=null){
		if(permissionList.getJSONArray("authorities")!=null){
			authorities=new ArrayList<>();
			permissionList.getJSONArray("authorities").
				forEach(item->authorities.add(new SimpleGrantedAuthority(String.valueOf(item))));
			}
		}
	}
}
