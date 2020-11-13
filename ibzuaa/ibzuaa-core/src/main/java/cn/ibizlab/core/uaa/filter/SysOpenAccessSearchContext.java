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
import cn.ibizlab.core.uaa.domain.SysOpenAccess;
/**
 * 关系型数据实体[SysOpenAccess] 查询条件对象
 */
@Slf4j
@Data
public class SysOpenAccessSearchContext extends QueryWrapperContext<SysOpenAccess> {

	private String n_accessname_like;//[开放平台]
	public void setN_accessname_like(String n_accessname_like) {
        this.n_accessname_like = n_accessname_like;
        if(!ObjectUtils.isEmpty(this.n_accessname_like)){
            this.getSearchCond().like("accessname", n_accessname_like);
        }
    }
	private String n_open_type_eq;//[开放平台类型]
	public void setN_open_type_eq(String n_open_type_eq) {
        this.n_open_type_eq = n_open_type_eq;
        if(!ObjectUtils.isEmpty(this.n_open_type_eq)){
            this.getSearchCond().eq("open_type", n_open_type_eq);
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
                     wrapper.like("accessname", query)   
            );
		 }
	}
}



