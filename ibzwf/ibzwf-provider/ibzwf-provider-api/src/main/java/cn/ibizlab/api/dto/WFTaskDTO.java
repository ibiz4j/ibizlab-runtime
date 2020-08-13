package cn.ibizlab.api.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.util.domain.DTOBase;
import cn.ibizlab.util.domain.DTOClient;
import lombok.Data;

/**
 * 服务DTO对象[WFTaskDTO]
 */
@Data
public class WFTaskDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [TASKID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 属性 [TASKNAME]
     *
     */
    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;

    /**
     * 属性 [DEFINITIONID]
     *
     */
    @JSONField(name = "processdefinitionid")
    @JsonProperty("processdefinitionid")
    private String processdefinitionid;

    /**
     * 属性 [DEFINITIONKEY]
     *
     */
    @JSONField(name = "processdefinitionkey")
    @JsonProperty("processdefinitionkey")
    private String processdefinitionkey;

    /**
     * 属性 [DEFINITIONNAME]
     *
     */
    @JSONField(name = "processdefinitionname")
    @JsonProperty("processdefinitionname")
    private String processdefinitionname;

    /**
     * 属性 [TASKDEFINITIONKEY]
     *
     */
    @JSONField(name = "taskdefinitionkey")
    @JsonProperty("taskdefinitionkey")
    private String taskdefinitionkey;

    /**
     * 属性 [DESCRIPTION]
     *
     */
    @JSONField(name = "description")
    @JsonProperty("description")
    private String description;

    /**
     * 属性 [CREATETIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createtime")
    private Timestamp createtime;

    /**
     * 属性 [INSTANCEID]
     *
     */
    @JSONField(name = "processinstanceid")
    @JsonProperty("processinstanceid")
    private String processinstanceid;

    /**
     * 属性 [BUSINESSKEY]
     *
     */
    @JSONField(name = "processinstancebusinesskey")
    @JsonProperty("processinstancebusinesskey")
    private String processinstancebusinesskey;


    /**
     * 设置 [TASKNAME]
     */
    public void setName(String  name){
        this.name = name ;
        this.modify("taskname",name);
    }

    /**
     * 设置 [DEFINITIONID]
     */
    public void setProcessdefinitionid(String  processdefinitionid){
        this.processdefinitionid = processdefinitionid ;
        this.modify("definitionid",processdefinitionid);
    }

    /**
     * 设置 [DEFINITIONKEY]
     */
    public void setProcessdefinitionkey(String  processdefinitionkey){
        this.processdefinitionkey = processdefinitionkey ;
        this.modify("definitionkey",processdefinitionkey);
    }

    /**
     * 设置 [DEFINITIONNAME]
     */
    public void setProcessdefinitionname(String  processdefinitionname){
        this.processdefinitionname = processdefinitionname ;
        this.modify("definitionname",processdefinitionname);
    }

    /**
     * 设置 [TASKDEFINITIONKEY]
     */
    public void setTaskdefinitionkey(String  taskdefinitionkey){
        this.taskdefinitionkey = taskdefinitionkey ;
        this.modify("taskdefinitionkey",taskdefinitionkey);
    }

    /**
     * 设置 [DESCRIPTION]
     */
    public void setDescription(String  description){
        this.description = description ;
        this.modify("description",description);
    }

    /**
     * 设置 [CREATETIME]
     */
    public void setCreatetime(Timestamp  createtime){
        this.createtime = createtime ;
        this.modify("createtime",createtime);
    }

    /**
     * 设置 [INSTANCEID]
     */
    public void setProcessinstanceid(String  processinstanceid){
        this.processinstanceid = processinstanceid ;
        this.modify("instanceid",processinstanceid);
    }

    /**
     * 设置 [BUSINESSKEY]
     */
    public void setProcessinstancebusinesskey(String  processinstancebusinesskey){
        this.processinstancebusinesskey = processinstancebusinesskey ;
        this.modify("businesskey",processinstancebusinesskey);
    }


}

