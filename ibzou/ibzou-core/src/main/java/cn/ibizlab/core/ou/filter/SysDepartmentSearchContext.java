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
import cn.ibizlab.core.ou.domain.SysDepartment;
/**
 * 关系型数据实体[SysDepartment] 查询条件对象
 */
@Slf4j
@Data
public class SysDepartmentSearchContext extends QueryWrapperContext<SysDepartment> {

	private String n_deptcode_like;//[部门代码]
	public void setN_deptcode_like(String n_deptcode_like) {
        this.n_deptcode_like = n_deptcode_like;
        if(!ObjectUtils.isEmpty(this.n_deptcode_like)){
            this.getSearchCond().like("deptcode", n_deptcode_like);
        }
    }
	private String n_deptname_like;//[部门名称]
	public void setN_deptname_like(String n_deptname_like) {
        this.n_deptname_like = n_deptname_like;
        if(!ObjectUtils.isEmpty(this.n_deptname_like)){
            this.getSearchCond().like("deptname", n_deptname_like);
        }
    }
	private String n_orgid_eq;//[单位]
	public void setN_orgid_eq(String n_orgid_eq) {
        this.n_orgid_eq = n_orgid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgid_eq)){
            this.getSearchCond().eq("orgid", n_orgid_eq);
        }
    }
	private String n_pdeptid_eq;//[上级部门]
	public void setN_pdeptid_eq(String n_pdeptid_eq) {
        this.n_pdeptid_eq = n_pdeptid_eq;
        if(!ObjectUtils.isEmpty(this.n_pdeptid_eq)){
            this.getSearchCond().eq("pdeptid", n_pdeptid_eq);
        }
    }
	private String n_bcode_like;//[业务编码]
	public void setN_bcode_like(String n_bcode_like) {
        this.n_bcode_like = n_bcode_like;
        if(!ObjectUtils.isEmpty(this.n_bcode_like)){
            this.getSearchCond().like("bcode", n_bcode_like);
        }
    }
	private String n_orgname_eq;//[单位]
	public void setN_orgname_eq(String n_orgname_eq) {
        this.n_orgname_eq = n_orgname_eq;
        if(!ObjectUtils.isEmpty(this.n_orgname_eq)){
            this.getSearchCond().eq("orgname", n_orgname_eq);
        }
    }
	private String n_orgname_like;//[单位]
	public void setN_orgname_like(String n_orgname_like) {
        this.n_orgname_like = n_orgname_like;
        if(!ObjectUtils.isEmpty(this.n_orgname_like)){
            this.getSearchCond().like("orgname", n_orgname_like);
        }
    }
	private String n_pdeptname_eq;//[上级部门]
	public void setN_pdeptname_eq(String n_pdeptname_eq) {
        this.n_pdeptname_eq = n_pdeptname_eq;
        if(!ObjectUtils.isEmpty(this.n_pdeptname_eq)){
            this.getSearchCond().eq("pdeptname", n_pdeptname_eq);
        }
    }
	private String n_pdeptname_like;//[上级部门]
	public void setN_pdeptname_like(String n_pdeptname_like) {
        this.n_pdeptname_like = n_pdeptname_like;
        if(!ObjectUtils.isEmpty(this.n_pdeptname_like)){
            this.getSearchCond().like("pdeptname", n_pdeptname_like);
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
                     wrapper.like("deptname", query)   
            );
		 }
	}
}



