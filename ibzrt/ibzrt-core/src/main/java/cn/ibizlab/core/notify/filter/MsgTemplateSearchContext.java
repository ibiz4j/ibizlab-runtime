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


import cn.ibizlab.util.filter.SearchContextBase;

/**
 * ServiceApi数据实体[MsgTemplate] 查询条件对象
 */
@Slf4j
@Data
public class MsgTemplateSearchContext extends SearchContextBase {
	private String n_template_name_like;//[模板标题]

	private String n_accessid_eq;//[开放平台接入标识]

	private String n_accessname_eq;//[接入平台]

	private String n_accessname_like;//[接入平台]

}


