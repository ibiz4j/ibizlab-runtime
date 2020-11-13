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
import cn.ibizlab.core.workflow.domain.WFGroup;
/**
 * 关系型数据实体[WFGroup] 查询条件对象
 */
@Slf4j
@Data
public class WFGroupSearchContext extends QueryWrapperContext<WFGroup> {

	private String n_groupname_like;//[组名称]
	public void setN_groupname_like(String n_groupname_like) {
        this.n_groupname_like = n_groupname_like;
        if(!ObjectUtils.isEmpty(this.n_groupname_like)){
            this.getSearchCond().like("groupname", n_groupname_like);
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
                     wrapper.like("groupname", query)   
            );
		 }
	}
}



