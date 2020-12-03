package cn.ibizlab.core.task.filter;

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
import cn.ibizlab.core.task.domain.JobsRegistry;
/**
 * 关系型数据实体[JobsRegistry] 查询条件对象
 */
@Slf4j
@Data
public class JobsRegistrySearchContext extends QueryWrapperContext<JobsRegistry> {

	private String n_app_like;//[服务名]
	public void setN_app_like(String n_app_like) {
        this.n_app_like = n_app_like;
        if(!ObjectUtils.isEmpty(this.n_app_like)){
            this.getSearchCond().like("app", n_app_like);
        }
    }
	private Integer n_status_eq;//[状态]
	public void setN_status_eq(Integer n_status_eq) {
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
                     wrapper.like("app", query)
            );
		 }
	}
}



