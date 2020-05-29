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
import cn.ibizlab.core.uaa.domain.SysUserRole;
/**
 * 关系型数据实体[SysUserRole] 查询条件对象
 */
@Slf4j
@Data
public class SysUserRoleSearchContext extends QueryWrapperContext<SysUserRole> {

	private String n_sys_roleid_eq;//[角色标识]
	public void setN_sys_roleid_eq(String n_sys_roleid_eq) {
        this.n_sys_roleid_eq = n_sys_roleid_eq;
        if(!ObjectUtils.isEmpty(this.n_sys_roleid_eq)){
            this.getSelectCond().eq("sys_roleid", n_sys_roleid_eq);
        }
    }
	private String n_sys_userid_eq;//[用户标识]
	public void setN_sys_userid_eq(String n_sys_userid_eq) {
        this.n_sys_userid_eq = n_sys_userid_eq;
        if(!ObjectUtils.isEmpty(this.n_sys_userid_eq)){
            this.getSelectCond().eq("sys_userid", n_sys_userid_eq);
        }
    }
	private String n_sys_username_eq;//[用户名称]
	public void setN_sys_username_eq(String n_sys_username_eq) {
        this.n_sys_username_eq = n_sys_username_eq;
        if(!ObjectUtils.isEmpty(this.n_sys_username_eq)){
            this.getSelectCond().eq("sys_username", n_sys_username_eq);
        }
    }
	private String n_sys_username_like;//[用户名称]
	public void setN_sys_username_like(String n_sys_username_like) {
        this.n_sys_username_like = n_sys_username_like;
        if(!ObjectUtils.isEmpty(this.n_sys_username_like)){
            this.getSelectCond().like("sys_username", n_sys_username_like);
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
                     wrapper.like("sys_userid", query)   
            );
		 }
	}
}




