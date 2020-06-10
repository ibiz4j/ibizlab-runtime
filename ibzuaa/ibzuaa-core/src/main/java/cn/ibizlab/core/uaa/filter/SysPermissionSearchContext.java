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
import cn.ibizlab.core.uaa.domain.SysPermission;
/**
 * 关系型数据实体[SysPermission] 查询条件对象
 */
@Slf4j
@Data
public class SysPermissionSearchContext extends QueryWrapperContext<SysPermission> {

	private String n_sys_permissionid_like;//[资源标识]
	public void setN_sys_permissionid_like(String n_sys_permissionid_like) {
        this.n_sys_permissionid_like = n_sys_permissionid_like;
        if(!ObjectUtils.isEmpty(this.n_sys_permissionid_like)){
            this.getSearchCond().like("sys_permissionid", n_sys_permissionid_like);
        }
    }
	private String n_sys_permissionname_like;//[资源名称]
	public void setN_sys_permissionname_like(String n_sys_permissionname_like) {
        this.n_sys_permissionname_like = n_sys_permissionname_like;
        if(!ObjectUtils.isEmpty(this.n_sys_permissionname_like)){
            this.getSearchCond().like("sys_permissionname", n_sys_permissionname_like);
        }
    }
	private String n_permissiontype_eq;//[资源类别]
	public void setN_permissiontype_eq(String n_permissiontype_eq) {
        this.n_permissiontype_eq = n_permissiontype_eq;
        if(!ObjectUtils.isEmpty(this.n_permissiontype_eq)){
            this.getSearchCond().eq("permissiontype", n_permissiontype_eq);
        }
    }
	private Integer n_enable_eq;//[逻辑有效]
	public void setN_enable_eq(Integer n_enable_eq) {
        this.n_enable_eq = n_enable_eq;
        if(!ObjectUtils.isEmpty(this.n_enable_eq)){
            this.getSearchCond().eq("enable", n_enable_eq);
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
                     wrapper.like("sys_permissionname", query)   
            );
		 }
	}
}




