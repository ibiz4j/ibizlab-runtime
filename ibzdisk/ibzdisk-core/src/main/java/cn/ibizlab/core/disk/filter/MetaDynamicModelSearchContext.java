package cn.ibizlab.core.disk.filter;

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
import cn.ibizlab.core.disk.domain.MetaDynamicModel;
/**
 * 关系型数据实体[MetaDynamicModel] 查询条件对象
 */
@Slf4j
@Data
public class MetaDynamicModelSearchContext extends QueryWrapperContext<MetaDynamicModel> {

	private String n_systemid_eq;//[系统]
	public void setN_systemid_eq(String n_systemid_eq) {
        this.n_systemid_eq = n_systemid_eq;
        if(!ObjectUtils.isEmpty(this.n_systemid_eq)){
            this.getSearchCond().eq("systemid", n_systemid_eq);
        }
    }
	private String n_configname_like;//[配置名称]
	public void setN_configname_like(String n_configname_like) {
        this.n_configname_like = n_configname_like;
        if(!ObjectUtils.isEmpty(this.n_configname_like)){
            this.getSearchCond().like("configname", n_configname_like);
        }
    }
	private String n_pdynainstid_eq;//[父实例]
	public void setN_pdynainstid_eq(String n_pdynainstid_eq) {
        this.n_pdynainstid_eq = n_pdynainstid_eq;
        if(!ObjectUtils.isEmpty(this.n_pdynainstid_eq)){
            this.getSearchCond().eq("pdynainstid", n_pdynainstid_eq);
        }
    }
	private String n_status_eq;//[状态]
	public void setN_status_eq(String n_status_eq) {
        this.n_status_eq = n_status_eq;
        if(!ObjectUtils.isEmpty(this.n_status_eq)){
            this.getSearchCond().eq("status", n_status_eq);
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
                     wrapper.like("configname", query)
            );
		 }
	}
}



