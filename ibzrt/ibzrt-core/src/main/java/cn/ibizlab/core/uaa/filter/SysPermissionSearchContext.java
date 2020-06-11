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
 * ServiceApi数据实体[SysPermission] 查询条件对象
 */
@Slf4j
@Data
public class SysPermissionSearchContext extends SearchContextBase {
	private String n_sys_permissionid_like;//[资源标识]

	private String n_sys_permissionname_like;//[资源名称]

	private String n_permissiontype_eq;//[资源类别]

	private Integer n_enable_eq;//[逻辑有效]

}



