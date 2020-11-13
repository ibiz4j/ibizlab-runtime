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
	private String n_loginname_like;//[登录名]
	public void setN_loginname_like(String n_loginname_like) {
        this.n_loginname_like = n_loginname_like;
        if(!ObjectUtils.isEmpty(this.n_loginname_like)){
            this.getSearchCond().like("loginname", n_loginname_like);
        }
    }
	private String n_mdeptname_like;//[主部门名称]
	public void setN_mdeptname_like(String n_mdeptname_like) {
        this.n_mdeptname_like = n_mdeptname_like;
        if(!ObjectUtils.isEmpty(this.n_mdeptname_like)){
            this.getSearchCond().like("mdeptname", n_mdeptname_like);
        }
    }
	private String n_orgname_like;//[单位名称]
	public void setN_orgname_like(String n_orgname_like) {
        this.n_orgname_like = n_orgname_like;
        if(!ObjectUtils.isEmpty(this.n_orgname_like)){
            this.getSearchCond().like("orgname", n_orgname_like);
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



