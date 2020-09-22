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
import cn.ibizlab.util.annotation.Audit;

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
     * 状态
     */
    @DEField(name = "taskname")
    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;

    /**
     * DefinitionId
     */
    @DEField(name = "definitionid")
    @JSONField(name = "processdefinitionid")
    @JsonProperty("processdefinitionid")
    private String processdefinitionid;

    /**
     * DefinitionKey
     */
    @DEField(name = "definitionkey")
    @JSONField(name = "processdefinitionkey")
    @JsonProperty("processdefinitionkey")
    private String processdefinitionkey;

    /**
     * 流程
     */
    @DEField(name = "definitionname")
    @JSONField(name = "processdefinitionname")
    @JsonProperty("processdefinitionname")
    private String processdefinitionname;

    /**
     * TaskDefinitionKey
     */
    @JSONField(name = "taskdefinitionkey")
    @JsonProperty("taskdefinitionkey")
    private String taskdefinitionkey;

    /**
     * 待办事项
     */
    @JSONField(name = "description")
    @JsonProperty("description")
    private String description;

    /**
     * 发起时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createtime")
    private Timestamp createtime;

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
     * 设置 [状态]
     */
    public void setName(String name){
        this.name = name ;
        this.modify("taskname",name);
    }

    /**
     * 设置 [DefinitionId]
     */
    public void setProcessdefinitionid(String processdefinitionid){
        this.processdefinitionid = processdefinitionid ;
        this.modify("definitionid",processdefinitionid);
    }

    /**
     * 设置 [DefinitionKey]
     */
    public void setProcessdefinitionkey(String processdefinitionkey){
        this.processdefinitionkey = processdefinitionkey ;
        this.modify("definitionkey",processdefinitionkey);
    }

    /**
     * 设置 [流程]
     */
    public void setProcessdefinitionname(String processdefinitionname){
        this.processdefinitionname = processdefinitionname ;
        this.modify("definitionname",processdefinitionname);
    }

    /**
     * 设置 [TaskDefinitionKey]
     */
    public void setTaskdefinitionkey(String taskdefinitionkey){
        this.taskdefinitionkey = taskdefinitionkey ;
        this.modify("taskdefinitionkey",taskdefinitionkey);
    }

    /**
     * 设置 [待办事项]
     */
    public void setDescription(String description){
        this.description = description ;
        this.modify("description",description);
    }

    /**
     * 设置 [发起时间]
     */
    public void setCreatetime(Timestamp createtime){
        this.createtime = createtime ;
        this.modify("createtime",createtime);
    }

    /**
     * 格式化日期 [发起时间]
     */
    public String formatCreatetime(){
        if (this.createtime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(createtime);
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
     * 复制当前对象数据到目标对象(粘贴重置)
     * @param targetEntity 目标数据对象
     * @param bIncEmpty  是否包括空值
     * @param <T>
     * @return
     */
    @Override
    public <T> T copyTo(T targetEntity, boolean bIncEmpty) {
        this.reset("taskid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


