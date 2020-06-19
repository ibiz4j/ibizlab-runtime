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
import cn.ibizlab.core.task.domain.JobsLog;
/**
 * 关系型数据实体[JobsLog] 查询条件对象
 */
@Slf4j
@Data
public class JobsLogSearchContext extends QueryWrapperContext<JobsLog> {

	private String n_job_id_eq;//[任务ID]
	public void setN_job_id_eq(String n_job_id_eq) {
        this.n_job_id_eq = n_job_id_eq;
        if(!ObjectUtils.isEmpty(this.n_job_id_eq)){
            this.getSearchCond().eq("job_id", n_job_id_eq);
        }
    }
	private String n_handler_like;//[执行器任务HANDLER]
	public void setN_handler_like(String n_handler_like) {
        this.n_handler_like = n_handler_like;
        if(!ObjectUtils.isEmpty(this.n_handler_like)){
            this.getSearchCond().like("handler", n_handler_like);
        }
    }
	private Integer n_trigger_code_eq;//[触发器调度返回码]
	public void setN_trigger_code_eq(Integer n_trigger_code_eq) {
        this.n_trigger_code_eq = n_trigger_code_eq;
        if(!ObjectUtils.isEmpty(this.n_trigger_code_eq)){
            this.getSearchCond().eq("trigger_code", n_trigger_code_eq);
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
                     wrapper.like("handler", query)   
            );
		 }
	}
}




