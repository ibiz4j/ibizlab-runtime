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
 * ServiceApi数据实体[WFTask] 查询条件对象
 */
@Slf4j
@Data
public class WFTaskSearchContext extends SearchContextBase {
	private String n_taskname_like;//[状态]

	private String n_definitionkey_leftlike;//[DefinitionKey]

	private String n_definitionkey_like;//[DefinitionKey]

	private String n_definitionname_like;//[流程]

	private String n_taskdefinitionkey_like;//[TaskDefinitionKey]

	private String n_description_like;//[待办事项]

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp n_createtime_gtandeq;//[发起时间]

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp n_createtime_ltandeq;//[发起时间]

	private String n_businesskey_eq;//[业务键值]

}


