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
 * ServiceApi [流程定义节点] 对象
 */
@Data
public class WFProcessNode extends EntityClient implements Serializable {

    /**
     * 节点标识
     */
    @DEField(name = "nodeid" , isKeyField=true)
    @JSONField(name = "userTaskId")
    @JsonProperty("userTaskId")
    private String usertaskid;

    /**
     * 节点名称
     */
    @DEField(name = "nodename")
    @JSONField(name = "userTaskName")
    @JsonProperty("userTaskName")
    private String usertaskname;

    /**
     * DefinitionKey
     */
    @DEField(name = "definitionkey")
    @JSONField(name = "processDefinitionKey")
    @JsonProperty("processDefinitionKey")
    private String processdefinitionkey;

    /**
     * 流程定义名称
     */
    @DEField(name = "definitionname")
    @JSONField(name = "processDefinitionName")
    @JsonProperty("processDefinitionName")
    private String processdefinitionname;





    /**
     * 设置 [节点名称]
     */
    public void setUsertaskname(String usertaskname){
        this.usertaskname = usertaskname ;
        this.modify("nodename",usertaskname);
    }
    /**
     * 设置 [DefinitionKey]
     */
    public void setProcessdefinitionkey(String processdefinitionkey){
        this.processdefinitionkey = processdefinitionkey ;
        this.modify("definitionkey",processdefinitionkey);
    }
    /**
     * 设置 [流程定义名称]
     */
    public void setProcessdefinitionname(String processdefinitionname){
        this.processdefinitionname = processdefinitionname ;
        this.modify("definitionname",processdefinitionname);
    }

}


