package cn.ibizlab.core.workflow.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
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

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [操作路径] 对象
 */
@Data
public class WFTaskWay extends EntityClient implements Serializable {

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





    /**
     * 设置 [路径标识]
     */
    public void setSequenceflowname(String sequenceflowname){
        this.sequenceflowname = sequenceflowname ;
        this.modify("wayname",sequenceflowname);
    }
    /**
     * 设置 [任务标识]
     */
    public void setTaskid(String taskid){
        this.taskid = taskid ;
        this.modify("taskid",taskid);
    }
    /**
     * 设置 [TaskDefinitionKey]
     */
    public void setTaskprocessdefinitionkey(String taskprocessdefinitionkey){
        this.taskprocessdefinitionkey = taskprocessdefinitionkey ;
        this.modify("taskdefinitionkey",taskprocessdefinitionkey);
    }
    /**
     * 设置 [实例标识]
     */
    public void setProcessinstanceid(String processinstanceid){
        this.processinstanceid = processinstanceid ;
        this.modify("instanceid",processinstanceid);
    }
    /**
     * 设置 [DefinitionKey]
     */
    public void setProcessdefinitionkey(String processdefinitionkey){
        this.processdefinitionkey = processdefinitionkey ;
        this.modify("definitionkey",processdefinitionkey);
    }
    /**
     * 设置 [业务键值]
     */
    public void setProcessinstancebusinesskey(String processinstancebusinesskey){
        this.processinstancebusinesskey = processinstancebusinesskey ;
        this.modify("businesskey",processinstancebusinesskey);
    }
    /**
     * 设置 [引用视图]
     */
    public void setRefviewkey(String refviewkey){
        this.refviewkey = refviewkey ;
        this.modify("refviewkey",refviewkey);
    }

}


