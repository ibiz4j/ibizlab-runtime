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
 * [操作路径] 对象
 */
@Getter
@Setter
@NoArgsConstructor
public class WFTaskWay extends EntityBase implements Serializable {

    /**
     * 路径标识
     */
    @DEField(name = "wayid" , isKeyField=true)
    @JSONField(name = "sequenceFlowId")
    @JsonProperty("sequenceFlowId")
    private String sequenceflowid;

    /**
     * 路径标识
     */
    @DEField(name = "wayname")
    @JSONField(name = "sequenceFlowName")
    @JsonProperty("sequenceFlowName")
    private String sequenceflowname;

    /**
     * 任务标识
     */
    @JSONField(name = "taskId")
    @JsonProperty("taskId")
    private String taskid;

    /**
     * TaskDefinitionKey
     */
    @DEField(name = "taskdefinitionkey")
    @JSONField(name = "taskProcessDefinitionKey")
    @JsonProperty("taskProcessDefinitionKey")
    private String taskprocessdefinitionkey;

    /**
     * 实例标识
     */
    @DEField(name = "instanceid")
    @JSONField(name = "processInstanceId")
    @JsonProperty("processInstanceId")
    private String processinstanceid;

    /**
     * DefinitionKey
     */
    @DEField(name = "definitionkey")
    @JSONField(name = "processDefinitionKey")
    @JsonProperty("processDefinitionKey")
    private String processdefinitionkey;

    /**
     * 业务键值
     */
    @DEField(name = "businesskey")
    @JSONField(name = "processInstanceBusinessKey")
    @JsonProperty("processInstanceBusinessKey")
    private String processinstancebusinesskey;

    /**
     * 引用视图
     */
    @JSONField(name = "refViewKey")
    @JsonProperty("refViewKey")
    private String refviewkey;




}


