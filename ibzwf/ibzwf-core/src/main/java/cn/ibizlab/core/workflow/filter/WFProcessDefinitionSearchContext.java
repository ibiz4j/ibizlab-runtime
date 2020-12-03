package cn.ibizlab.core.workflow.filter;

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
import cn.ibizlab.core.workflow.domain.WFProcessDefinition;
/**
 * 关系型数据实体[WFProcessDefinition] 查询条件对象
 */
@Slf4j
@Data
public class WFProcessDefinitionSearchContext extends QueryWrapperContext<WFProcessDefinition> {

	private String n_definitionname_like;//[流程定义名称]
	public void setN_definitionname_like(String n_definitionname_like) {
        this.n_definitionname_like = n_definitionname_like;
        if(!ObjectUtils.isEmpty(this.n_definitionname_like)){
            this.getSearchCond().like("definitionname", n_definitionname_like);
        }
    }
	private String n_deploykey_like;//[DeployKey]
	public void setN_deploykey_like(String n_deploykey_like) {
        this.n_deploykey_like = n_deploykey_like;
        if(!ObjectUtils.isEmpty(this.n_deploykey_like)){
            this.getSearchCond().like("deploykey", n_deploykey_like);
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
                     wrapper.like("definitionname", query)
            );
		 }
	}
}



