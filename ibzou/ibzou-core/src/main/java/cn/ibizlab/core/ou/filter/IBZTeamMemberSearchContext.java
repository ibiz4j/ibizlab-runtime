package cn.ibizlab.core.ou.filter;

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
import cn.ibizlab.core.ou.domain.IBZTeamMember;
/**
 * 关系型数据实体[IBZTeamMember] 查询条件对象
 */
@Slf4j
@Data
public class IBZTeamMemberSearchContext extends QueryWrapperContext<IBZTeamMember> {

	private String n_teammemberid_like;//[组成员标识]
	public void setN_teammemberid_like(String n_teammemberid_like) {
        this.n_teammemberid_like = n_teammemberid_like;
        if(!ObjectUtils.isEmpty(this.n_teammemberid_like)){
            this.getSearchCond().like("teammemberid", n_teammemberid_like);
        }
    }
	private String n_teamid_eq;//[组标识]
	public void setN_teamid_eq(String n_teamid_eq) {
        this.n_teamid_eq = n_teamid_eq;
        if(!ObjectUtils.isEmpty(this.n_teamid_eq)){
            this.getSearchCond().eq("teamid", n_teamid_eq);
        }
    }
	private String n_teamname_eq;//[组名称]
	public void setN_teamname_eq(String n_teamname_eq) {
        this.n_teamname_eq = n_teamname_eq;
        if(!ObjectUtils.isEmpty(this.n_teamname_eq)){
            this.getSearchCond().eq("teamname", n_teamname_eq);
        }
    }
	private String n_teamname_like;//[组名称]
	public void setN_teamname_like(String n_teamname_like) {
        this.n_teamname_like = n_teamname_like;
        if(!ObjectUtils.isEmpty(this.n_teamname_like)){
            this.getSearchCond().like("teamname", n_teamname_like);
        }
    }
	private String n_userid_eq;//[用户标识]
	public void setN_userid_eq(String n_userid_eq) {
        this.n_userid_eq = n_userid_eq;
        if(!ObjectUtils.isEmpty(this.n_userid_eq)){
            this.getSearchCond().eq("userid", n_userid_eq);
        }
    }
	private String n_personname_eq;//[姓名]
	public void setN_personname_eq(String n_personname_eq) {
        this.n_personname_eq = n_personname_eq;
        if(!ObjectUtils.isEmpty(this.n_personname_eq)){
            this.getSearchCond().eq("personname", n_personname_eq);
        }
    }
	private String n_personname_like;//[姓名]
	public void setN_personname_like(String n_personname_like) {
        this.n_personname_like = n_personname_like;
        if(!ObjectUtils.isEmpty(this.n_personname_like)){
            this.getSearchCond().like("personname", n_personname_like);
        }
    }
	private String n_postid_eq;//[岗位标识]
	public void setN_postid_eq(String n_postid_eq) {
        this.n_postid_eq = n_postid_eq;
        if(!ObjectUtils.isEmpty(this.n_postid_eq)){
            this.getSearchCond().eq("postid", n_postid_eq);
        }
    }
	private String n_postname_eq;//[岗位]
	public void setN_postname_eq(String n_postname_eq) {
        this.n_postname_eq = n_postname_eq;
        if(!ObjectUtils.isEmpty(this.n_postname_eq)){
            this.getSearchCond().eq("postname", n_postname_eq);
        }
    }
	private String n_postname_like;//[岗位]
	public void setN_postname_like(String n_postname_like) {
        this.n_postname_like = n_postname_like;
        if(!ObjectUtils.isEmpty(this.n_postname_like)){
            this.getSearchCond().like("postname", n_postname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
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



