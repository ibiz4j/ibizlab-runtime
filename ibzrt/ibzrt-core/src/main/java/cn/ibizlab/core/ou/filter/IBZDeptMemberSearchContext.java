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


import cn.ibizlab.util.filter.SearchContextBase;

/**
 * ServiceApi数据实体[IBZDeptMember] 查询条件对象
 */
@Slf4j
@Data
public class IBZDeptMemberSearchContext extends SearchContextBase {
	private String n_deptid_eq;//[部门标识]

	private String n_deptname_eq;//[部门名称]

	private String n_deptname_like;//[部门名称]

	private String n_userid_eq;//[用户标识]

	private String n_personname_eq;//[成员]

	private String n_personname_like;//[成员]

	private String n_postid_eq;//[岗位标识]

	private String n_postname_eq;//[岗位名称]

	private String n_postname_like;//[岗位名称]

	private String n_bcode_like;//[业务条线]

}


