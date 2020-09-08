package cn.ibizlab.core.notify.filter;

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
import cn.ibizlab.core.notify.domain.MsgUserAccount;
/**
 * 关系型数据实体[MsgUserAccount] 查询条件对象
 */
@Slf4j
@Data
public class MsgUserAccountSearchContext extends QueryWrapperContext<MsgUserAccount> {

	private String n_userid_like;//[用户标识]
	public void setN_userid_like(String n_userid_like) {
        this.n_userid_like = n_userid_like;
        if(!ObjectUtils.isEmpty(this.n_userid_like)){
            this.getSearchCond().like("userid", n_userid_like);
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
                     wrapper.like("identifier", query)   
            );
		 }
	}
}



