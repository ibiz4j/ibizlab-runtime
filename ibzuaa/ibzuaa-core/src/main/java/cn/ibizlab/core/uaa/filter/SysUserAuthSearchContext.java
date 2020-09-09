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
import cn.ibizlab.core.uaa.domain.SysUserAuth;
/**
 * 关系型数据实体[SysUserAuth] 查询条件对象
 */
@Slf4j
@Data
public class SysUserAuthSearchContext extends QueryWrapperContext<SysUserAuth> {

	private String n_userid_eq;//[用户标识]
	public void setN_userid_eq(String n_userid_eq) {
        this.n_userid_eq = n_userid_eq;
        if(!ObjectUtils.isEmpty(this.n_userid_eq)){
            this.getSearchCond().eq("userid", n_userid_eq);
        }
    }
	private String n_username_eq;//[人员]
	public void setN_username_eq(String n_username_eq) {
        this.n_username_eq = n_username_eq;
        if(!ObjectUtils.isEmpty(this.n_username_eq)){
            this.getSearchCond().eq("username", n_username_eq);
        }
    }
	private String n_username_like;//[人员]
	public void setN_username_like(String n_username_like) {
        this.n_username_like = n_username_like;
        if(!ObjectUtils.isEmpty(this.n_username_like)){
            this.getSearchCond().like("username", n_username_like);
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
                     wrapper.like("username", query)   
            );
		 }
	}
}



