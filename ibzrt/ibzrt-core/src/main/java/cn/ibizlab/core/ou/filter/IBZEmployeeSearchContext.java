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
import cn.ibizlab.core.ou.domain.IBZEmployee;
/**
 * 关系型数据实体[IBZEmployee] 查询条件对象
 */
@Slf4j
@Data
public class IBZEmployeeSearchContext extends QueryWrapperContext<IBZEmployee> {

	private String n_personname_like;//[姓名]
	public void setN_personname_like(String n_personname_like) {
        this.n_personname_like = n_personname_like;
        if(!ObjectUtils.isEmpty(this.n_personname_like)){
            this.getSearchCond().like("personname", n_personname_like);
        }
    }
	private String n_usercode_like;//[用户工号]
	public void setN_usercode_like(String n_usercode_like) {
        this.n_usercode_like = n_usercode_like;
        if(!ObjectUtils.isEmpty(this.n_usercode_like)){
            this.getSearchCond().like("usercode", n_usercode_like);
        }
    }
	private String n_mdeptid_eq;//[主部门]
	public void setN_mdeptid_eq(String n_mdeptid_eq) {
        this.n_mdeptid_eq = n_mdeptid_eq;
        if(!ObjectUtils.isEmpty(this.n_mdeptid_eq)){
            this.getSearchCond().eq("mdeptid", n_mdeptid_eq);
        }
    }
	private String n_mdeptname_like;//[主部门名称]
	public void setN_mdeptname_like(String n_mdeptname_like) {
        this.n_mdeptname_like = n_mdeptname_like;
        if(!ObjectUtils.isEmpty(this.n_mdeptname_like)){
            this.getSearchCond().like("mdeptname", n_mdeptname_like);
        }
    }
	private String n_bcode_like;//[业务编码]
	public void setN_bcode_like(String n_bcode_like) {
        this.n_bcode_like = n_bcode_like;
        if(!ObjectUtils.isEmpty(this.n_bcode_like)){
            this.getSearchCond().like("bcode", n_bcode_like);
        }
    }
	private String n_postid_eq;//[岗位标识]
	public void setN_postid_eq(String n_postid_eq) {
        this.n_postid_eq = n_postid_eq;
        if(!ObjectUtils.isEmpty(this.n_postid_eq)){
            this.getSearchCond().eq("postid", n_postid_eq);
        }
    }
	private String n_postname_eq;//[岗位名称]
	public void setN_postname_eq(String n_postname_eq) {
        this.n_postname_eq = n_postname_eq;
        if(!ObjectUtils.isEmpty(this.n_postname_eq)){
            this.getSearchCond().eq("postname", n_postname_eq);
        }
    }
	private String n_postname_like;//[岗位名称]
	public void setN_postname_like(String n_postname_like) {
        this.n_postname_like = n_postname_like;
        if(!ObjectUtils.isEmpty(this.n_postname_like)){
            this.getSearchCond().like("postname", n_postname_like);
        }
    }
	private String n_orgid_eq;//[单位]
	public void setN_orgid_eq(String n_orgid_eq) {
        this.n_orgid_eq = n_orgid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgid_eq)){
            this.getSearchCond().eq("orgid", n_orgid_eq);
        }
    }
	private String n_orgcode_leftlike;//[单位代码]
	public void setN_orgcode_leftlike(String n_orgcode_leftlike) {
        this.n_orgcode_leftlike = n_orgcode_leftlike;
        if(!ObjectUtils.isEmpty(this.n_orgcode_leftlike)){
            this.getSearchCond().likeRight("orgcode", n_orgcode_leftlike);
        }
    }
	private String n_sex_eq;//[性别]
	public void setN_sex_eq(String n_sex_eq) {
        this.n_sex_eq = n_sex_eq;
        if(!ObjectUtils.isEmpty(this.n_sex_eq)){
            this.getSearchCond().eq("sex", n_sex_eq);
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
                     wrapper.like("personname", query)   
            );
		 }
	}
}




