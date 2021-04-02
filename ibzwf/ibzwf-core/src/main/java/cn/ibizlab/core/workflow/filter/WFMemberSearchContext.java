package cn.ibizlab.core.workflow.filter;

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
import cn.ibizlab.core.workflow.domain.WFMember;
/**
 * 关系型数据实体[WFMember] 查询条件对象
 */
@Slf4j
@Data
public class WFMemberSearchContext extends QueryWrapperContext<WFMember> {

	private String n_membername_like;//[组成员名称]
	public void setN_membername_like(String n_membername_like) {
        this.n_membername_like = n_membername_like;
        if(!ObjectUtils.isEmpty(this.n_membername_like)){
            this.getSearchCond().like("membername", n_membername_like);
        }
    }
	private String n_groupid_eq;//[组标识]
	public void setN_groupid_eq(String n_groupid_eq) {
        this.n_groupid_eq = n_groupid_eq;
        if(!ObjectUtils.isEmpty(this.n_groupid_eq)){
            this.getSearchCond().eq("groupid", n_groupid_eq);
        }
    }
	private String n_groupname_eq;//[用户组]
	public void setN_groupname_eq(String n_groupname_eq) {
        this.n_groupname_eq = n_groupname_eq;
        if(!ObjectUtils.isEmpty(this.n_groupname_eq)){
            this.getSearchCond().eq("groupname", n_groupname_eq);
        }
    }
	private String n_groupname_like;//[用户组]
	public void setN_groupname_like(String n_groupname_like) {
        this.n_groupname_like = n_groupname_like;
        if(!ObjectUtils.isEmpty(this.n_groupname_like)){
            this.getSearchCond().like("groupname", n_groupname_like);
        }
    }
	private String n_userid_eq;//[用户标识]
	public void setN_userid_eq(String n_userid_eq) {
        this.n_userid_eq = n_userid_eq;
        if(!ObjectUtils.isEmpty(this.n_userid_eq)){
            this.getSearchCond().eq("userid", n_userid_eq);
        }
    }
	private String n_personname_eq;//[用户]
	public void setN_personname_eq(String n_personname_eq) {
        this.n_personname_eq = n_personname_eq;
        if(!ObjectUtils.isEmpty(this.n_personname_eq)){
            this.getSearchCond().eq("personname", n_personname_eq);
        }
    }
	private String n_personname_like;//[用户]
	public void setN_personname_like(String n_personname_like) {
        this.n_personname_like = n_personname_like;
        if(!ObjectUtils.isEmpty(this.n_personname_like)){
            this.getSearchCond().like("personname", n_personname_like);
        }
    }
	private String n_orgid_eq;//[单位]
	public void setN_orgid_eq(String n_orgid_eq) {
        this.n_orgid_eq = n_orgid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgid_eq)){
            this.getSearchCond().eq("orgid", n_orgid_eq);
        }
    }
	private String n_mdeptid_eq;//[主部门]
	public void setN_mdeptid_eq(String n_mdeptid_eq) {
        this.n_mdeptid_eq = n_mdeptid_eq;
        if(!ObjectUtils.isEmpty(this.n_mdeptid_eq)){
            this.getSearchCond().eq("mdeptid", n_mdeptid_eq);
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
                     wrapper.like("membername", query)
            );
		 }
	}
}



