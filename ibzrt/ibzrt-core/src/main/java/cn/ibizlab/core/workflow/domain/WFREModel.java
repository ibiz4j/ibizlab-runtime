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
 * ServiceApi [流程模型] 对象
 */
@Data
public class WFREModel extends EntityClient implements Serializable {

    /**
     * ID
     */
    @DEField(name = "modelid" , isKeyField=true)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 名称
     */
    @DEField(name = "modelname")
    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;

    /**
     * BPMN
     */
    @JSONField(name = "bpmnfile")
    @JsonProperty("bpmnfile")
    private String bpmnfile;





    /**
     * 设置 [名称]
     */
    public void setName(String name){
        this.name = name ;
        this.modify("modelname",name);
    }

    /**
     * 设置 [BPMN]
     */
    public void setBpmnfile(String bpmnfile){
        this.bpmnfile = bpmnfile ;
        this.modify("bpmnfile",bpmnfile);
    }


}


