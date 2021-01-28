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


import cn.ibizlab.util.filter.SearchContextBase;

/**
 * ServiceApi数据实体[PayTrade] 查询条件对象
 */
@Slf4j
@Data
public class PayTradeSearchContext extends SearchContextBase {
	private String n_tradename_like;//[交易名称]

	private String n_tradestatus_eq;//[支付状态]

	private String n_accessname_eq;//[支付平台]

	private String n_accessname_like;//[支付平台]

	private String n_accessid_eq;//[支付平台接入标识]

}


