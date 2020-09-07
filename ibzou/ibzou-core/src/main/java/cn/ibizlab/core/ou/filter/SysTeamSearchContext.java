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
import cn.ibizlab.core.ou.domain.SysTeam;
/**
 * 关系型数据实体[SysTeam] 查询条件对象
 */
@Slf4j
@Data
public class SysTeamSearchContext extends QueryWrapperContext<SysTeam> {

	private String n_teamid_like;//[组标识]
	public void setN_teamid_like(String n_teamid_like) {
        this.n_teamid_like = n_teamid_like;
        if(!ObjectUtils.isEmpty(this.n_teamid_like)){
            this.getSearchCond().like("teamid", n_teamid_like);
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
                     wrapper.like("teamname", query)   
            );
		 }
	}
}



