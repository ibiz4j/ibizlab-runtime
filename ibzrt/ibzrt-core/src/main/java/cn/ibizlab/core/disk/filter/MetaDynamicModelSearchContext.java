package cn.ibizlab.core.disk.filter;

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
 * ServiceApi数据实体[MetaDynamicModel] 查询条件对象
 */
@Slf4j
@Data
public class MetaDynamicModelSearchContext extends SearchContextBase {
	private String n_systemid_eq;//[系统]

	private String n_configname_like;//[配置名称]

	private String n_pdynainstid_eq;//[父实例]

	private String n_status_eq;//[状态]

}


