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
import cn.ibizlab.core.ou.domain.IBZPost;
/**
 * 关系型数据实体[IBZPost] 查询条件对象
 */
@Slf4j
@Data
public class IBZPostSearchContext extends QueryWrapperContext<IBZPost> {

	private String n_postcode_like;//[岗位编码]
	public void setN_postcode_like(String n_postcode_like) {
        this.n_postcode_like = n_postcode_like;
        if(!ObjectUtils.isEmpty(this.n_postcode_like)){
            this.getSearchCond().like("postcode", n_postcode_like);
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
                     wrapper.like("postname", query)   
            );
		 }
	}
}




