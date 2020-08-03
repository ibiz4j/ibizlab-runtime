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
 * ServiceApi数据实体[SysRole] 查询条件对象
 */
@Slf4j
@Data
public class SysRoleSearchContext extends SearchContextBase {
	private String n_sys_rolename_isnotnull;//[角色名称]

	private String n_sys_rolename_isnull;//[角色名称]

	private String n_sys_rolename_like;//[角色名称]

	private String n_proleid_eq;//[父角色标识]

	private String n_prolename_eq;//[父角色名称]

	private String n_prolename_like;//[父角色名称]

}


