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


import cn.ibizlab.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.core.uaa.domain.SysAuthLog;
/**
 * 关系型数据实体[SysAuthLog] 查询条件对象
 */
@Slf4j
@Data
public class SysAuthLogSearchContext extends QueryWrapperContext<SysAuthLog> {

	private String n_username_like;//[用户全局名]
	public void setN_username_like(String n_username_like) {
        this.n_username_like = n_username_like;
        if(!ObjectUtils.isEmpty(this.n_username_like)){
            this.getSearchCond().like("username", n_username_like);
        }
    }
	private String n_personname_like;//[用户名称]
	public void setN_personname_like(String n_personname_like) {
        this.n_personname_like = n_personname_like;
        if(!ObjectUtils.isEmpty(this.n_personname_like)){
            this.getSearchCond().like("personname", n_personname_like);
        }
    }
	private String n_domains_like;//[域]
	public void setN_domains_like(String n_domains_like) {
        this.n_domains_like = n_domains_like;
        if(!ObjectUtils.isEmpty(this.n_domains_like)){
            this.getSearchCond().like("domains", n_domains_like);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp n_authtime_gtandeq;//[认证时间]
	public void setN_authtime_gtandeq(Timestamp n_authtime_gtandeq) {
        this.n_authtime_gtandeq = n_authtime_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_authtime_gtandeq)){
            this.getSearchCond().ge("authtime", n_authtime_gtandeq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp n_authtime_ltandeq;//[认证时间]
	public void setN_authtime_ltandeq(Timestamp n_authtime_ltandeq) {
        this.n_authtime_ltandeq = n_authtime_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_authtime_ltandeq)){
            this.getSearchCond().le("authtime", n_authtime_ltandeq);
        }
    }
	private String n_ipaddr_like;//[IP地址]
	public void setN_ipaddr_like(String n_ipaddr_like) {
        this.n_ipaddr_like = n_ipaddr_like;
        if(!ObjectUtils.isEmpty(this.n_ipaddr_like)){
            this.getSearchCond().like("ipaddr", n_ipaddr_like);
        }
    }
	private String n_authcode_eq;//[认证结果]
	public void setN_authcode_eq(String n_authcode_eq) {
        this.n_authcode_eq = n_authcode_eq;
        if(!ObjectUtils.isEmpty(this.n_authcode_eq)){
            this.getSearchCond().eq("authcode", n_authcode_eq);
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
                     wrapper.like("username", query)
            );
		 }
	}
}



