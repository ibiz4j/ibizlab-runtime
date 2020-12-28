package cn.ibizlab.core.uaa.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.core.uaa.domain.SysUser;
/**
 * 关系型数据实体[SysUser] 查询条件对象
 */
@Slf4j
@Data
public class SysUserSearchContext extends QueryWrapperContext<SysUser> {

	private String n_userid_eq;//[用户标识]
	public void setN_userid_eq(String n_userid_eq) {
        this.n_userid_eq = n_userid_eq;
        if(!ObjectUtils.isEmpty(this.n_userid_eq)){
            this.getSearchCond().eq("userid", n_userid_eq);
        }
    }
	private String n_userid_in;//[用户标识]
	public void setN_userid_in(String n_userid_in) {
        this.n_userid_in = n_userid_in;
        if(!ObjectUtils.isEmpty(this.n_userid_in)){
			this.getSearchCond().in("userid",this.n_userid_in.split(";"));
        }
    }
	private String n_username_like;//[用户全局名]
	public void setN_username_like(String n_username_like) {
        this.n_username_like = n_username_like;
        if(!ObjectUtils.isEmpty(this.n_username_like)){
            this.getSearchCond().like("username", n_username_like);
        }
    }
	private String n_personname_like;//[用户姓名]
	public void setN_personname_like(String n_personname_like) {
        this.n_personname_like = n_personname_like;
        if(!ObjectUtils.isEmpty(this.n_personname_like)){
            this.getSearchCond().like("personname", n_personname_like);
        }
    }
	private String n_usercode_eq;//[用户工号]
	public void setN_usercode_eq(String n_usercode_eq) {
        this.n_usercode_eq = n_usercode_eq;
        if(!ObjectUtils.isEmpty(this.n_usercode_eq)){
            this.getSearchCond().eq("usercode", n_usercode_eq);
        }
    }
	private String n_usercode_like;//[用户工号]
	public void setN_usercode_like(String n_usercode_like) {
        this.n_usercode_like = n_usercode_like;
        if(!ObjectUtils.isEmpty(this.n_usercode_like)){
            this.getSearchCond().like("usercode", n_usercode_like);
        }
    }
	private String n_loginname_like;//[登录名]
	public void setN_loginname_like(String n_loginname_like) {
        this.n_loginname_like = n_loginname_like;
        if(!ObjectUtils.isEmpty(this.n_loginname_like)){
            this.getSearchCond().like("loginname", n_loginname_like);
        }
    }
	private String n_mdeptid_eq;//[主部门]
	public void setN_mdeptid_eq(String n_mdeptid_eq) {
        this.n_mdeptid_eq = n_mdeptid_eq;
        if(!ObjectUtils.isEmpty(this.n_mdeptid_eq)){
            this.getSearchCond().eq("mdeptid", n_mdeptid_eq);
        }
    }
	private String n_mdeptid_in;//[主部门]
	public void setN_mdeptid_in(String n_mdeptid_in) {
        this.n_mdeptid_in = n_mdeptid_in;
        if(!ObjectUtils.isEmpty(this.n_mdeptid_in)){
			this.getSearchCond().in("mdeptid",this.n_mdeptid_in.split(";"));
        }
    }
	private String n_mdeptcode_like;//[主部门代码]
	public void setN_mdeptcode_like(String n_mdeptcode_like) {
        this.n_mdeptcode_like = n_mdeptcode_like;
        if(!ObjectUtils.isEmpty(this.n_mdeptcode_like)){
            this.getSearchCond().like("mdeptcode", n_mdeptcode_like);
        }
    }
	private String n_mdeptname_like;//[主部门名称]
	public void setN_mdeptname_like(String n_mdeptname_like) {
        this.n_mdeptname_like = n_mdeptname_like;
        if(!ObjectUtils.isEmpty(this.n_mdeptname_like)){
            this.getSearchCond().like("mdeptname", n_mdeptname_like);
        }
    }
	private String n_bcode_like;//[业务编码]
	public void setN_bcode_like(String n_bcode_like) {
        this.n_bcode_like = n_bcode_like;
        if(!ObjectUtils.isEmpty(this.n_bcode_like)){
            this.getSearchCond().like("bcode", n_bcode_like);
        }
    }
	private String n_postid_eq;//[岗位标识]
	public void setN_postid_eq(String n_postid_eq) {
        this.n_postid_eq = n_postid_eq;
        if(!ObjectUtils.isEmpty(this.n_postid_eq)){
            this.getSearchCond().eq("postid", n_postid_eq);
        }
    }
	private String n_postid_in;//[岗位标识]
	public void setN_postid_in(String n_postid_in) {
        this.n_postid_in = n_postid_in;
        if(!ObjectUtils.isEmpty(this.n_postid_in)){
			this.getSearchCond().in("postid",this.n_postid_in.split(";"));
        }
    }
	private String n_postname_like;//[岗位名称]
	public void setN_postname_like(String n_postname_like) {
        this.n_postname_like = n_postname_like;
        if(!ObjectUtils.isEmpty(this.n_postname_like)){
            this.getSearchCond().like("postname", n_postname_like);
        }
    }
	private String n_orgid_eq;//[单位]
	public void setN_orgid_eq(String n_orgid_eq) {
        this.n_orgid_eq = n_orgid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgid_eq)){
            this.getSearchCond().eq("orgid", n_orgid_eq);
        }
    }
	private String n_orgid_in;//[单位]
	public void setN_orgid_in(String n_orgid_in) {
        this.n_orgid_in = n_orgid_in;
        if(!ObjectUtils.isEmpty(this.n_orgid_in)){
			this.getSearchCond().in("orgid",this.n_orgid_in.split(";"));
        }
    }
	private String n_orgcode_eq;//[单位代码]
	public void setN_orgcode_eq(String n_orgcode_eq) {
        this.n_orgcode_eq = n_orgcode_eq;
        if(!ObjectUtils.isEmpty(this.n_orgcode_eq)){
            this.getSearchCond().eq("orgcode", n_orgcode_eq);
        }
    }
	private String n_orgcode_leftlike;//[单位代码]
	public void setN_orgcode_leftlike(String n_orgcode_leftlike) {
        this.n_orgcode_leftlike = n_orgcode_leftlike;
        if(!ObjectUtils.isEmpty(this.n_orgcode_leftlike)){
            this.getSearchCond().likeRight("orgcode", n_orgcode_leftlike);
        }
    }
	private String n_orgcode_like;//[单位代码]
	public void setN_orgcode_like(String n_orgcode_like) {
        this.n_orgcode_like = n_orgcode_like;
        if(!ObjectUtils.isEmpty(this.n_orgcode_like)){
            this.getSearchCond().like("orgcode", n_orgcode_like);
        }
    }
	private String n_orgname_like;//[单位名称]
	public void setN_orgname_like(String n_orgname_like) {
        this.n_orgname_like = n_orgname_like;
        if(!ObjectUtils.isEmpty(this.n_orgname_like)){
            this.getSearchCond().like("orgname", n_orgname_like);
        }
    }
	private String n_certcode_like;//[证件号码]
	public void setN_certcode_like(String n_certcode_like) {
        this.n_certcode_like = n_certcode_like;
        if(!ObjectUtils.isEmpty(this.n_certcode_like)){
            this.getSearchCond().like("certcode", n_certcode_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
    @Override
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSearchCond().and( wrapper ->
                     wrapper.like("personname", query)
            );
		 }
	}
}



