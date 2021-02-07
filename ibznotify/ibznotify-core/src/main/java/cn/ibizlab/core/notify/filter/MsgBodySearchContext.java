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
import cn.ibizlab.core.notify.domain.MsgBody;
/**
 * 关系型数据实体[MsgBody] 查询条件对象
 */
@Slf4j
@Data
public class MsgBodySearchContext extends QueryWrapperContext<MsgBody> {

	private String n_tousers_eq;//[目标用户]
	public void setN_tousers_eq(String n_tousers_eq) {
        this.n_tousers_eq = n_tousers_eq;
        if(!ObjectUtils.isEmpty(this.n_tousers_eq)){
            this.getSearchCond().eq("tousers", n_tousers_eq);
        }
    }
	private String n_tousers_in;//[目标用户]
	public void setN_tousers_in(String n_tousers_in) {
        this.n_tousers_in = n_tousers_in;
        if(!ObjectUtils.isEmpty(this.n_tousers_in)){
			this.getSearchCond().in("tousers",this.n_tousers_in.split(";"));
        }
    }
	private Integer n_msgtype_eq;//[消息类型]
	public void setN_msgtype_eq(Integer n_msgtype_eq) {
        this.n_msgtype_eq = n_msgtype_eq;
        if(!ObjectUtils.isEmpty(this.n_msgtype_eq)){
            this.getSearchCond().eq("msgtype", n_msgtype_eq);
        }
    }
	private String n_msgname_like;//[消息名称]
	public void setN_msgname_like(String n_msgname_like) {
        this.n_msgname_like = n_msgname_like;
        if(!ObjectUtils.isEmpty(this.n_msgname_like)){
            this.getSearchCond().like("msgname", n_msgname_like);
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
                     wrapper.like("msgname", query)
            );
		 }
	}
}



