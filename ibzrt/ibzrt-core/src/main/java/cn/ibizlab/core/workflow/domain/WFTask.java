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

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [工作流任务] 对象
 */
@Data
public class WFTask extends EntityClient implements Serializable {

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
    @JSONField(name = "processdefinitionkey")
    @JsonProperty("processdefinitionkey")
    private String processdefinitionkey;

    /**
     * 实例标识
     */
    @DEField(name = "instanceid")
    @JSONField(name = "processinstanceid")
    @JsonProperty("processinstanceid")
    private String processinstanceid;

    /**
     * 业务键值
     */
    @DEField(name = "businesskey")
    @JSONField(name = "processinstancebusinesskey")
    @JsonProperty("processinstancebusinesskey")
    private String processinstancebusinesskey;

    /**
     * TaskDefinitionKey
     */
    @DEField(name = "taskdefinitionkey")
    @JSONField(name = "taskprocessdefinitionkey")
    @JsonProperty("taskprocessdefinitionkey")
    private String taskprocessdefinitionkey;





    /**
     * 设置 [任务名称]
     */
    public void setName(String name){
        this.name = name ;
        this.modify("taskname",name);
    }

    /**
     * 设置 [DefinitionKey]
     */
    public void setProcessdefinitionkey(String processdefinitionkey){
        this.processdefinitionkey = processdefinitionkey ;
        this.modify("definitionkey",processdefinitionkey);
    }

    /**
     * 设置 [实例标识]
     */
    public void setProcessinstanceid(String processinstanceid){
        this.processinstanceid = processinstanceid ;
        this.modify("instanceid",processinstanceid);
    }

    /**
     * 设置 [业务键值]
     */
    public void setProcessinstancebusinesskey(String processinstancebusinesskey){
        this.processinstancebusinesskey = processinstancebusinesskey ;
        this.modify("businesskey",processinstancebusinesskey);
    }

    /**
     * 设置 [TaskDefinitionKey]
     */
    public void setTaskprocessdefinitionkey(String taskprocessdefinitionkey){
        this.taskprocessdefinitionkey = taskprocessdefinitionkey ;
        this.modify("taskdefinitionkey",taskprocessdefinitionkey);
    }


}


