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
 * ServiceApi数据实体[SysDepartment] 查询条件对象
 */
@Slf4j
@Data
public class SysDepartmentSearchContext extends SearchContextBase {
	private String n_deptcode_like;//[部门代码]

	private String n_deptname_like;//[部门名称]

	private String n_orgid_eq;//[单位]

	private String n_pdeptid_eq;//[上级部门]

	private String n_bcode_like;//[业务编码]

	private String n_orgname_eq;//[单位]

	private String n_orgname_like;//[单位]

	private String n_pdeptname_eq;//[上级部门]

	private String n_pdeptname_like;//[上级部门]

	private Integer n_isvalid_eq;//[启用标识]

}


