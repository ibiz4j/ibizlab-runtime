package cn.ibizlab.core.notify.filter;

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
import cn.ibizlab.core.notify.domain.MsgTemplate;
/**
 * 关系型数据实体[MsgTemplate] 查询条件对象
 */
@Slf4j
@Data
public class MsgTemplateSearchContext extends QueryWrapperContext<MsgTemplate> {

	private String n_template_name_like;//[模板标题]
	public void setN_template_name_like(String n_template_name_like) {
        this.n_template_name_like = n_template_name_like;
        if(!ObjectUtils.isEmpty(this.n_template_name_like)){
            this.getSearchCond().like("template_name", n_template_name_like);
        }
    }
	private String n_accessid_eq;//[开放平台接入标识]
	public void setN_accessid_eq(String n_accessid_eq) {
        this.n_accessid_eq = n_accessid_eq;
        if(!ObjectUtils.isEmpty(this.n_accessid_eq)){
            this.getSearchCond().eq("accessid", n_accessid_eq);
        }
    }
	private String n_accessname_eq;//[接入平台]
	public void setN_accessname_eq(String n_accessname_eq) {
        this.n_accessname_eq = n_accessname_eq;
        if(!ObjectUtils.isEmpty(this.n_accessname_eq)){
            this.getSearchCond().eq("accessname", n_accessname_eq);
        }
    }
	private String n_accessname_like;//[接入平台]
	public void setN_accessname_like(String n_accessname_like) {
        this.n_accessname_like = n_accessname_like;
        if(!ObjectUtils.isEmpty(this.n_accessname_like)){
            this.getSearchCond().like("accessname", n_accessname_like);
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
                     wrapper.like("template_name", query)   
            );
		 }
	}
}



