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
import cn.ibizlab.core.ou.domain.IBZOrganization;
/**
 * 关系型数据实体[IBZOrganization] 查询条件对象
 */
@Slf4j
@Data
public class IBZOrganizationSearchContext extends QueryWrapperContext<IBZOrganization> {

	private String n_orgid_like;//[单位标识]
	public void setN_orgid_like(String n_orgid_like) {
        this.n_orgid_like = n_orgid_like;
        if(!ObjectUtils.isEmpty(this.n_orgid_like)){
            this.getSearchCond().like("orgid", n_orgid_like);
        }
    }
	private String n_orgcode_leftlike;//[单位代码]
	public void setN_orgcode_leftlike(String n_orgcode_leftlike) {
        this.n_orgcode_leftlike = n_orgcode_leftlike;
        if(!ObjectUtils.isEmpty(this.n_orgcode_leftlike)){
            this.getSearchCond().likeRight("orgcode", n_orgcode_leftlike);
        }
    }
	private String n_orgname_like;//[名称]
	public void setN_orgname_like(String n_orgname_like) {
        this.n_orgname_like = n_orgname_like;
        if(!ObjectUtils.isEmpty(this.n_orgname_like)){
            this.getSearchCond().like("orgname", n_orgname_like);
        }
    }
	private String n_porgid_eq;//[上级单位]
	public void setN_porgid_eq(String n_porgid_eq) {
        this.n_porgid_eq = n_porgid_eq;
        if(!ObjectUtils.isEmpty(this.n_porgid_eq)){
            this.getSearchCond().eq("porgid", n_porgid_eq);
        }
    }
	private String n_shortname_like;//[单位简称]
	public void setN_shortname_like(String n_shortname_like) {
        this.n_shortname_like = n_shortname_like;
        if(!ObjectUtils.isEmpty(this.n_shortname_like)){
            this.getSearchCond().like("shortname", n_shortname_like);
        }
    }
	private Integer n_orglevel_gtandeq;//[单位级别]
	public void setN_orglevel_gtandeq(Integer n_orglevel_gtandeq) {
        this.n_orglevel_gtandeq = n_orglevel_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_orglevel_gtandeq)){
            this.getSearchCond().ge("orglevel", n_orglevel_gtandeq);
        }
    }
	private Integer n_orglevel_ltandeq;//[单位级别]
	public void setN_orglevel_ltandeq(Integer n_orglevel_ltandeq) {
        this.n_orglevel_ltandeq = n_orglevel_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_orglevel_ltandeq)){
            this.getSearchCond().le("orglevel", n_orglevel_ltandeq);
        }
    }
	private String n_porgname_eq;//[上级单位]
	public void setN_porgname_eq(String n_porgname_eq) {
        this.n_porgname_eq = n_porgname_eq;
        if(!ObjectUtils.isEmpty(this.n_porgname_eq)){
            this.getSearchCond().eq("porgname", n_porgname_eq);
        }
    }
	private String n_porgname_like;//[上级单位]
	public void setN_porgname_like(String n_porgname_like) {
        this.n_porgname_like = n_porgname_like;
        if(!ObjectUtils.isEmpty(this.n_porgname_like)){
            this.getSearchCond().like("porgname", n_porgname_like);
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
                     wrapper.like("orgname", query)   
            );
		 }
	}
}



