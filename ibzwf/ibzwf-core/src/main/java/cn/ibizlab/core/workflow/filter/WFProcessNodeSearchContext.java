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
 * ServiceApi数据实体[WFProcessNode] 查询条件对象
 */
@Slf4j
@Data
public class WFProcessNodeSearchContext extends SearchContextBase {
	private String n_nodeid_eq;//[节点标识]

	private String n_nodename_like;//[节点名称]

	private String n_definitionkey_eq;//[DefinitionKey]

	private String n_definitionkey_leftlike;//[DefinitionKey]

	private String n_definitionid_eq;//[DefinitionId]

}


