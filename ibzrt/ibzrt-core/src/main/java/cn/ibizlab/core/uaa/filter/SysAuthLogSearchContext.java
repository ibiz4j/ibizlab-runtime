package cn.ibizlab.core.uaa.filter;

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
 * ServiceApi数据实体[SysAuthLog] 查询条件对象
 */
@Slf4j
@Data
public class SysAuthLogSearchContext extends SearchContextBase {
	private String n_username_like;//[用户全局名]

	private String n_personname_like;//[用户名称]

	private String n_domain_like;//[域]

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp n_authtime_gtandeq;//[认证时间]

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp n_authtime_ltandeq;//[认证时间]

	private String n_ipaddr_like;//[IP地址]

	private String n_authcode_eq;//[认证结果]

}



