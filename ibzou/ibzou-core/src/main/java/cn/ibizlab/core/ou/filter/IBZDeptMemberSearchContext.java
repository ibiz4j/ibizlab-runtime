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
import cn.ibizlab.core.ou.domain.IBZDeptMember;
/**
 * 关系型数据实体[IBZDeptMember] 查询条件对象
 */
@Slf4j
@Data
public class IBZDeptMemberSearchContext extends QueryWrapperContext<IBZDeptMember> {

	private String n_deptid_eq;//[部门标识]
	public void setN_deptid_eq(String n_deptid_eq) {
        this.n_deptid_eq = n_deptid_eq;
        if(!ObjectUtils.isEmpty(this.n_deptid_eq)){
            this.getSelectCond().eq("deptid", n_deptid_eq);
        }
    }
	private String n_deptname_eq;//[部门名称]
	public void setN_deptname_eq(String n_deptname_eq) {
        this.n_deptname_eq = n_deptname_eq;
        if(!ObjectUtils.isEmpty(this.n_deptname_eq)){
            this.getSelectCond().eq("deptname", n_deptname_eq);
        }
    }
	private String n_deptname_like;//[部门名称]
	public void setN_deptname_like(String n_deptname_like) {
        this.n_deptname_like = n_deptname_like;
        if(!ObjectUtils.isEmpty(this.n_deptname_like)){
            this.getSelectCond().like("deptname", n_deptname_like);
        }
    }
	private String n_userid_eq;//[用户标识]
	public void setN_userid_eq(String n_userid_eq) {
        this.n_userid_eq = n_userid_eq;
        if(!ObjectUtils.isEmpty(this.n_userid_eq)){
            this.getSelectCond().eq("userid", n_userid_eq);
        }
    }
	private String n_personname_eq;//[成员]
	public void setN_personname_eq(String n_personname_eq) {
        this.n_personname_eq = n_personname_eq;
        if(!ObjectUtils.isEmpty(this.n_personname_eq)){
            this.getSelectCond().eq("personname", n_personname_eq);
        }
    }
	private String n_personname_like;//[成员]
	public void setN_personname_like(String n_personname_like) {
        this.n_personname_like = n_personname_like;
        if(!ObjectUtils.isEmpty(this.n_personname_like)){
            this.getSelectCond().like("personname", n_personname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSelectCond().and( wrapper ->
                     wrapper.like("personname", query)   
            );
		 }
	}
}




