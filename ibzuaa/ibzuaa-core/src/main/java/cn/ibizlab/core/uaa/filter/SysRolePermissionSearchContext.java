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
import cn.ibizlab.core.uaa.domain.SysRolePermission;
/**
 * 关系型数据实体[SysRolePermission] 查询条件对象
 */
@Slf4j
@Data
public class SysRolePermissionSearchContext extends QueryWrapperContext<SysRolePermission> {

	private String n_sys_roleid_eq;//[角色表标识]
	public void setN_sys_roleid_eq(String n_sys_roleid_eq) {
        this.n_sys_roleid_eq = n_sys_roleid_eq;
        if(!ObjectUtils.isEmpty(this.n_sys_roleid_eq)){
            this.getSearchCond().eq("sys_roleid", n_sys_roleid_eq);
        }
    }
	private String n_sys_rolename_eq;//[角色名称]
	public void setN_sys_rolename_eq(String n_sys_rolename_eq) {
        this.n_sys_rolename_eq = n_sys_rolename_eq;
        if(!ObjectUtils.isEmpty(this.n_sys_rolename_eq)){
            this.getSearchCond().eq("sys_rolename", n_sys_rolename_eq);
        }
    }
	private String n_sys_rolename_like;//[角色名称]
	public void setN_sys_rolename_like(String n_sys_rolename_like) {
        this.n_sys_rolename_like = n_sys_rolename_like;
        if(!ObjectUtils.isEmpty(this.n_sys_rolename_like)){
            this.getSearchCond().like("sys_rolename", n_sys_rolename_like);
        }
    }
	private String n_sys_permissionid_eq;//[权限表标识]
	public void setN_sys_permissionid_eq(String n_sys_permissionid_eq) {
        this.n_sys_permissionid_eq = n_sys_permissionid_eq;
        if(!ObjectUtils.isEmpty(this.n_sys_permissionid_eq)){
            this.getSearchCond().eq("sys_permissionid", n_sys_permissionid_eq);
        }
    }
	private String n_sys_permissionname_eq;//[权限名称]
	public void setN_sys_permissionname_eq(String n_sys_permissionname_eq) {
        this.n_sys_permissionname_eq = n_sys_permissionname_eq;
        if(!ObjectUtils.isEmpty(this.n_sys_permissionname_eq)){
            this.getSearchCond().eq("sys_permissionname", n_sys_permissionname_eq);
        }
    }
	private String n_sys_permissionname_like;//[权限名称]
	public void setN_sys_permissionname_like(String n_sys_permissionname_like) {
        this.n_sys_permissionname_like = n_sys_permissionname_like;
        if(!ObjectUtils.isEmpty(this.n_sys_permissionname_like)){
            this.getSearchCond().like("sys_permissionname", n_sys_permissionname_like);
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
                     wrapper.like("sys_permissionid", query)   
            );
		 }
	}
}



