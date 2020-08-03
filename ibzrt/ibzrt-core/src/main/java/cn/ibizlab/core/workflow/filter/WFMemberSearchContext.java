package cn.ibizlab.core.workflow.filter;

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
 * ServiceApi数据实体[WFMember] 查询条件对象
 */
@Slf4j
@Data
public class WFMemberSearchContext extends SearchContextBase {
	private String n_membername_like;//[组成员名称]

	private String n_groupid_eq;//[组标识]

	private String n_groupname_eq;//[用户组]

	private String n_groupname_like;//[用户组]

	private String n_userid_eq;//[用户标识]

	private String n_personname_eq;//[用户]

	private String n_personname_like;//[用户]

}


