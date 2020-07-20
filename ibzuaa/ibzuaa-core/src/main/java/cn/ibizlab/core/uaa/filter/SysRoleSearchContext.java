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
import cn.ibizlab.core.uaa.domain.SysRole;
/**
 * 关系型数据实体[SysRole] 查询条件对象
 */
@Slf4j
@Data
public class SysRoleSearchContext extends QueryWrapperContext<SysRole> {

	private String n_sys_rolename_isnotnull;//[角色名称]
	public void setN_sys_rolename_isnotnull(String n_sys_rolename_isnotnull) {
        this.n_sys_rolename_isnotnull = n_sys_rolename_isnotnull;
        if(!ObjectUtils.isEmpty(this.n_sys_rolename_isnotnull)){
			if(this.n_sys_rolename_isnotnull.toString().equals("1")){
				this.getSearchCond().isNotNull("sys_rolename");
			}
        }
    }
	private String n_sys_rolename_isnull;//[角色名称]
	public void setN_sys_rolename_isnull(String n_sys_rolename_isnull) {
        this.n_sys_rolename_isnull = n_sys_rolename_isnull;
        if(!ObjectUtils.isEmpty(this.n_sys_rolename_isnull)){
			if(this.n_sys_rolename_isnull.toString().equals("1")){
				this.getSearchCond().isNull("sys_rolename");
			}
        }
    }
	private String n_sys_rolename_like;//[角色名称]
	public void setN_sys_rolename_like(String n_sys_rolename_like) {
        this.n_sys_rolename_like = n_sys_rolename_like;
        if(!ObjectUtils.isEmpty(this.n_sys_rolename_like)){
            this.getSearchCond().like("sys_rolename", n_sys_rolename_like);
        }
    }
	private String n_proleid_eq;//[父角色标识]
	public void setN_proleid_eq(String n_proleid_eq) {
        this.n_proleid_eq = n_proleid_eq;
        if(!ObjectUtils.isEmpty(this.n_proleid_eq)){
            this.getSearchCond().eq("proleid", n_proleid_eq);
        }
    }
	private String n_prolename_eq;//[父角色名称]
	public void setN_prolename_eq(String n_prolename_eq) {
        this.n_prolename_eq = n_prolename_eq;
        if(!ObjectUtils.isEmpty(this.n_prolename_eq)){
            this.getSearchCond().eq("prolename", n_prolename_eq);
        }
    }
	private String n_prolename_like;//[父角色名称]
	public void setN_prolename_like(String n_prolename_like) {
        this.n_prolename_like = n_prolename_like;
        if(!ObjectUtils.isEmpty(this.n_prolename_like)){
            this.getSearchCond().like("prolename", n_prolename_like);
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
                     wrapper.like("sys_rolename", query)   
            );
		 }
	}
}




