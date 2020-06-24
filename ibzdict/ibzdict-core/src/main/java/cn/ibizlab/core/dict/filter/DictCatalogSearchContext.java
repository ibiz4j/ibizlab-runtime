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
import cn.ibizlab.core.dict.domain.DictCatalog;
/**
 * 关系型数据实体[DictCatalog] 查询条件对象
 */
@Slf4j
@Data
public class DictCatalogSearchContext extends QueryWrapperContext<DictCatalog> {

	private String n_cid_like;//[标识]
	public void setN_cid_like(String n_cid_like) {
        this.n_cid_like = n_cid_like;
        if(!ObjectUtils.isEmpty(this.n_cid_like)){
            this.getSearchCond().like("cid", n_cid_like);
        }
    }
	private String n_ccode_like;//[代码]
	public void setN_ccode_like(String n_ccode_like) {
        this.n_ccode_like = n_ccode_like;
        if(!ObjectUtils.isEmpty(this.n_ccode_like)){
            this.getSearchCond().like("ccode", n_ccode_like);
        }
    }
	private String n_cname_like;//[名称]
	public void setN_cname_like(String n_cname_like) {
        this.n_cname_like = n_cname_like;
        if(!ObjectUtils.isEmpty(this.n_cname_like)){
            this.getSearchCond().like("cname", n_cname_like);
        }
    }
	private String n_cgroup_like;//[分组]
	public void setN_cgroup_like(String n_cgroup_like) {
        this.n_cgroup_like = n_cgroup_like;
        if(!ObjectUtils.isEmpty(this.n_cgroup_like)){
            this.getSearchCond().like("cgroup", n_cgroup_like);
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
                     wrapper.like("cname", query)   
            );
		 }
	}
}




