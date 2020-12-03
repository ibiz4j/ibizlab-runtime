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
	private String n_val_like;//[代码值]
	public void setN_val_like(String n_val_like) {
        this.n_val_like = n_val_like;
        if(!ObjectUtils.isEmpty(this.n_val_like)){
            this.getSearchCond().like("val", n_val_like);
        }
    }
	private String n_label_like;//[名称]
	public void setN_label_like(String n_label_like) {
        this.n_label_like = n_label_like;
        if(!ObjectUtils.isEmpty(this.n_label_like)){
            this.getSearchCond().like("label", n_label_like);
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



