package cn.ibizlab.core.pay.filter;

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
import cn.ibizlab.core.pay.domain.PayTrade;
/**
 * 关系型数据实体[PayTrade] 查询条件对象
 */
@Slf4j
@Data
public class PayTradeSearchContext extends QueryWrapperContext<PayTrade> {

	private String n_tradename_like;//[交易名称]
	public void setN_tradename_like(String n_tradename_like) {
        this.n_tradename_like = n_tradename_like;
        if(!ObjectUtils.isEmpty(this.n_tradename_like)){
            this.getSearchCond().like("tradename", n_tradename_like);
        }
    }
	private String n_tradestatus_eq;//[支付状态]
	public void setN_tradestatus_eq(String n_tradestatus_eq) {
        this.n_tradestatus_eq = n_tradestatus_eq;
        if(!ObjectUtils.isEmpty(this.n_tradestatus_eq)){
            this.getSearchCond().eq("tradestatus", n_tradestatus_eq);
        }
    }
	private String n_accessname_eq;//[支付平台]
	public void setN_accessname_eq(String n_accessname_eq) {
        this.n_accessname_eq = n_accessname_eq;
        if(!ObjectUtils.isEmpty(this.n_accessname_eq)){
            this.getSearchCond().eq("accessname", n_accessname_eq);
        }
    }
	private String n_accessname_like;//[支付平台]
	public void setN_accessname_like(String n_accessname_like) {
        this.n_accessname_like = n_accessname_like;
        if(!ObjectUtils.isEmpty(this.n_accessname_like)){
            this.getSearchCond().like("accessname", n_accessname_like);
        }
    }
	private String n_accessid_eq;//[支付平台接入标识]
	public void setN_accessid_eq(String n_accessid_eq) {
        this.n_accessid_eq = n_accessid_eq;
        if(!ObjectUtils.isEmpty(this.n_accessid_eq)){
            this.getSearchCond().eq("accessid", n_accessid_eq);
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
                     wrapper.like("tradename", query)   
            );
		 }
	}
}



