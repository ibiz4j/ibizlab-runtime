package cn.ibizlab.core.dict.filter;

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
import cn.ibizlab.core.dict.domain.DictOption;
/**
 * 关系型数据实体[DictOption] 查询条件对象
 */
@Slf4j
@Data
public class DictOptionSearchContext extends QueryWrapperContext<DictOption> {

	private String n_cid_eq;//[目录代码]
	public void setN_cid_eq(String n_cid_eq) {
        this.n_cid_eq = n_cid_eq;
        if(!ObjectUtils.isEmpty(this.n_cid_eq)){
            this.getSearchCond().eq("cid", n_cid_eq);
        }
    }
	private String n_cid_in;//[目录代码]
	public void setN_cid_in(String n_cid_in) {
        this.n_cid_in = n_cid_in;
        if(!ObjectUtils.isEmpty(this.n_cid_in)){
			this.getSearchCond().in("cid",this.n_cid_in.split(";"));
        }
    }
	private String n_cid_like;//[目录代码]
	public void setN_cid_like(String n_cid_like) {
        this.n_cid_like = n_cid_like;
        if(!ObjectUtils.isEmpty(this.n_cid_like)){
            this.getSearchCond().like("cid", n_cid_like);
        }
    }
	private String n_cname_eq;//[目录]
	public void setN_cname_eq(String n_cname_eq) {
        this.n_cname_eq = n_cname_eq;
        if(!ObjectUtils.isEmpty(this.n_cname_eq)){
            this.getSearchCond().eq("cname", n_cname_eq);
        }
    }
	private String n_cname_like;//[目录]
	public void setN_cname_like(String n_cname_like) {
        this.n_cname_like = n_cname_like;
        if(!ObjectUtils.isEmpty(this.n_cname_like)){
            this.getSearchCond().like("cname", n_cname_like);
        }
    }
	private String n_val_in;//[代码值]
	public void setN_val_in(String n_val_in) {
        this.n_val_in = n_val_in;
        if(!ObjectUtils.isEmpty(this.n_val_in)){
			this.getSearchCond().in("val",this.n_val_in.split(";"));
        }
    }
	private String n_val_leftlike;//[代码值]
	public void setN_val_leftlike(String n_val_leftlike) {
        this.n_val_leftlike = n_val_leftlike;
        if(!ObjectUtils.isEmpty(this.n_val_leftlike)){
            this.getSearchCond().likeRight("val", n_val_leftlike);
        }
    }
	private String n_val_like;//[代码值]
	public void setN_val_like(String n_val_like) {
        this.n_val_like = n_val_like;
        if(!ObjectUtils.isEmpty(this.n_val_like)){
            this.getSearchCond().like("val", n_val_like);
        }
    }
	private String n_val_notin;//[代码值]
	public void setN_val_notin(String n_val_notin) {
        this.n_val_notin = n_val_notin;
        if(!ObjectUtils.isEmpty(this.n_val_notin)){
			this.getSearchCond().notIn("val",this.n_val_notin.split(";"));
        }
    }
	private String n_label_like;//[名称]
	public void setN_label_like(String n_label_like) {
        this.n_label_like = n_label_like;
        if(!ObjectUtils.isEmpty(this.n_label_like)){
            this.getSearchCond().like("label", n_label_like);
        }
    }
	private String n_pval_eq;//[父代码值]
	public void setN_pval_eq(String n_pval_eq) {
        this.n_pval_eq = n_pval_eq;
        if(!ObjectUtils.isEmpty(this.n_pval_eq)){
            this.getSearchCond().eq("pval", n_pval_eq);
        }
    }
	private String n_pval_in;//[父代码值]
	public void setN_pval_in(String n_pval_in) {
        this.n_pval_in = n_pval_in;
        if(!ObjectUtils.isEmpty(this.n_pval_in)){
			this.getSearchCond().in("pval",this.n_pval_in.split(";"));
        }
    }
	private String n_pval_isnull;//[父代码值]
	public void setN_pval_isnull(String n_pval_isnull) {
        this.n_pval_isnull = n_pval_isnull;
        if(!ObjectUtils.isEmpty(this.n_pval_isnull)){
			if(this.n_pval_isnull.equals("1")){
				this.getSearchCond().isNull("pval");
			}
        }
    }
	private String n_pval_notin;//[父代码值]
	public void setN_pval_notin(String n_pval_notin) {
        this.n_pval_notin = n_pval_notin;
        if(!ObjectUtils.isEmpty(this.n_pval_notin)){
			this.getSearchCond().notIn("pval",this.n_pval_notin.split(";"));
        }
    }
	private String n_vfilter_eq;//[过滤项]
	public void setN_vfilter_eq(String n_vfilter_eq) {
        this.n_vfilter_eq = n_vfilter_eq;
        if(!ObjectUtils.isEmpty(this.n_vfilter_eq)){
            this.getSearchCond().eq("vfilter", n_vfilter_eq);
        }
    }
	private String n_vfilter_in;//[过滤项]
	public void setN_vfilter_in(String n_vfilter_in) {
        this.n_vfilter_in = n_vfilter_in;
        if(!ObjectUtils.isEmpty(this.n_vfilter_in)){
			this.getSearchCond().in("vfilter",this.n_vfilter_in.split(";"));
        }
    }
	private String n_vfilter_leftlike;//[过滤项]
	public void setN_vfilter_leftlike(String n_vfilter_leftlike) {
        this.n_vfilter_leftlike = n_vfilter_leftlike;
        if(!ObjectUtils.isEmpty(this.n_vfilter_leftlike)){
            this.getSearchCond().likeRight("vfilter", n_vfilter_leftlike);
        }
    }
	private String n_vfilter_like;//[过滤项]
	public void setN_vfilter_like(String n_vfilter_like) {
        this.n_vfilter_like = n_vfilter_like;
        if(!ObjectUtils.isEmpty(this.n_vfilter_like)){
            this.getSearchCond().like("vfilter", n_vfilter_like);
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
                     wrapper.like("label", query)
            );
		 }
	}
}



