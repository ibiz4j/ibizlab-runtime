package cn.ibizlab.core.workflow.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
import cn.ibizlab.util.domain.EntityBase;
import cn.ibizlab.util.annotation.DEField;
import cn.ibizlab.util.enums.DEPredefinedFieldType;
import cn.ibizlab.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;


/**
 * [工作流任务] 对象
 */
@Getter
@Setter
@NoArgsConstructor
public class WFTask extends EntityBase implements Serializable {

    /**
     * 任务标识
     */
    @DEField(name = "taskid" , isKeyField=true)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 任务名称
     */
    @DEField(name = "taskname")
    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;

    /**
     * DefinitionKey
     */
    @DEField(name = "definitionkey")
    @JSONField(name = "processDefinitionKey")
    @JsonProperty("processDefinitionKey")
    private String processdefinitionkey;

    /**
     * 实例标识
     */
    @DEField(name = "instanceid")
    @JSONField(name = "processInstanceId")
    @JsonProperty("processInstanceId")
    private String processinstanceid;

    /**
     * 业务键值
     */
    @DEField(name = "businesskey")
    @JSONField(name = "processInstanceBusinessKey")
    @JsonProperty("processInstanceBusinessKey")
    private String processinstancebusinesskey;

    /**
     * TaskDefinitionKey
     */
    @DEField(name = "taskdefinitionkey")
    @JSONField(name = "taskProcessDefinitionKey")
    @JsonProperty("taskProcessDefinitionKey")
    private String taskprocessdefinitionkey;




}


