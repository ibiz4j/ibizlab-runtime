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
import cn.ibizlab.util.helper.DataObject;
import cn.ibizlab.util.enums.DupCheck;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;
import cn.ibizlab.util.annotation.Audit;

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [操作路径] 对象
 */
@Data
public class WFTaskWay extends EntityClient implements Serializable {

    /**
     * 路径标识
     */
    @DEField(name = "wayid" , isKeyField = true)
    @JSONField(name = "sequenceflowid")
    @JsonProperty("sequenceflowid")
    private String sequenceflowid;

    /**
     * 任务标识
     */
    @JSONField(name = "taskid")
    @JsonProperty("taskid")
    private String taskid;

    /**
     * TaskDefinitionKey
     */
    @JSONField(name = "taskdefinitionkey")
    @JsonProperty("taskdefinitionkey")
    private String taskdefinitionkey;

    /**
     * 实例标识
     */
    @DEField(name = "instanceid")
    @JSONField(name = "processinstanceid")
    @JsonProperty("processinstanceid")
    private String processinstanceid;

    /**
     * DefinitionKey
     */
    @DEField(name = "definitionkey")
    @JSONField(name = "processdefinitionkey")
    @JsonProperty("processdefinitionkey")
    private String processdefinitionkey;

    /**
     * 业务键值
     */
    @DEField(name = "businesskey")
    @JSONField(name = "processinstancebusinesskey")
    @JsonProperty("processinstancebusinesskey")
    private String processinstancebusinesskey;

    /**
     * 引用视图
     */
    @JSONField(name = "refviewkey")
    @JsonProperty("refviewkey")
    private String refviewkey;

    /**
     * 路径标识
     */
    @DEField(name = "wayname")
    @JSONField(name = "sequenceflowname")
    @JsonProperty("sequenceflowname")
    private String sequenceflowname;





    /**
     * 设置 [任务标识]
     */
    public void setTaskid(String taskid) {
        this.taskid = taskid ;
        this.modify("taskid",taskid);
    }

    /**
     * 设置 [TaskDefinitionKey]
     */
    public void setTaskdefinitionkey(String taskdefinitionkey) {
        this.taskdefinitionkey = taskdefinitionkey ;
        this.modify("taskdefinitionkey",taskdefinitionkey);
    }

    /**
     * 设置 [实例标识]
     */
    public void setProcessinstanceid(String processinstanceid) {
        this.processinstanceid = processinstanceid ;
        this.modify("instanceid",processinstanceid);
    }

    /**
     * 设置 [DefinitionKey]
     */
    public void setProcessdefinitionkey(String processdefinitionkey) {
        this.processdefinitionkey = processdefinitionkey ;
        this.modify("definitionkey",processdefinitionkey);
    }

    /**
     * 设置 [业务键值]
     */
    public void setProcessinstancebusinesskey(String processinstancebusinesskey) {
        this.processinstancebusinesskey = processinstancebusinesskey ;
        this.modify("businesskey",processinstancebusinesskey);
    }

    /**
     * 设置 [引用视图]
     */
    public void setRefviewkey(String refviewkey) {
        this.refviewkey = refviewkey ;
        this.modify("refviewkey",refviewkey);
    }

    /**
     * 设置 [路径标识]
     */
    public void setSequenceflowname(String sequenceflowname) {
        this.sequenceflowname = sequenceflowname ;
        this.modify("wayname",sequenceflowname);
    }

    /**
     * 复制当前对象数据到目标对象(粘贴重置)
     * @param targetEntity 目标数据对象
     * @param bIncEmpty  是否包括空值
     * @param <T>
     * @return
     */
    @Override
    public <T> T copyTo(T targetEntity, boolean bIncEmpty) {
        this.reset("wayid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


