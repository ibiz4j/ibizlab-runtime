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
 * ServiceApi数据实体[SysUser] 查询条件对象
 */
@Slf4j
@Data
public class SysUserSearchContext extends SearchContextBase {
	private String n_username_like;//[用户全局名]

	private String n_personname_like;//[用户姓名]

	private String n_loginname_like;//[登录名]

	private String n_mdeptname_like;//[主部门名称]

	private String n_orgname_like;//[单位名称]

}


