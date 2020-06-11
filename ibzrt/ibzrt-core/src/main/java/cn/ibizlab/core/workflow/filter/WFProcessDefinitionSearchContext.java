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
 * ServiceApi数据实体[WFProcessDefinition] 查询条件对象
 */
@Slf4j
@Data
public class WFProcessDefinitionSearchContext extends SearchContextBase {
	private String n_definitionname_like;//[流程定义名称]

	private String n_deploykey_like;//[DeployKey]

}



