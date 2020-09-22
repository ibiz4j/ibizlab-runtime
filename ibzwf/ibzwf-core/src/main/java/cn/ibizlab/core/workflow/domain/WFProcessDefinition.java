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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 实体[流程定义]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZWFDEFINITION",resultMap = "WFProcessDefinitionResultMap")
public class WFProcessDefinition extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * DefinitionKey
     */
    @DEField(defaultValue = "deploykey" , defaultValueType = DEFieldDefaultValueType.PARAM , isKeyField=true)
    @TableId(value= "definitionkey",type=IdType.ASSIGN_UUID)
    @JSONField(name = "definitionkey")
    @JsonProperty("definitionkey")
    private String definitionkey;
    /**
     * 流程定义名称
     */
    @TableField(value = "definitionname")
    @JSONField(name = "definitionname")
    @JsonProperty("definitionname")
    private String definitionname;
    /**
     * 模型版本
     */
    @TableField(value = "modelversion")
    @JSONField(name = "modelversion")
    @JsonProperty("modelversion")
    private Integer modelversion;
    /**
     * 模型是否启用
     */
    @TableField(value = "modelenable")
    @JSONField(name = "modelenable")
    @JsonProperty("modelenable")
    private Integer modelenable;
    /**
     * 系统标识
     */
    @TableField(value = "pssystemid")
    @JSONField(name = "pssystemid")
    @JsonProperty("pssystemid")
    private String pssystemid;
    /**
     * 校验
     */
    @TableField(value = "md5check")
    @JSONField(name = "md5check")
    @JsonProperty("md5check")
    private String md5check;
    /**
     * BPMN
     */
    @TableField(value = "bpmnfile")
    @JSONField(name = "bpmnfile")
    @JsonProperty("bpmnfile")
    private String bpmnfile;
    /**
     * DeployKey
     */
    @TableField(value = "deploykey")
    @JSONField(name = "deploykey")
    @JsonProperty("deploykey")
    private String deploykey;
    /**
     * WebServiceIds
     */
    @TableField(value = "webserviceids")
    @JSONField(name = "webserviceids")
    @JsonProperty("webserviceids")
    private String webserviceids;
    /**
     * MobileServiceIds
     */
    @TableField(value = "mobileserviceids")
    @JSONField(name = "mobileserviceids")
    @JsonProperty("mobileserviceids")
    private String mobileserviceids;



    /**
     * 设置 [流程定义名称]
     */
    public void setDefinitionname(String definitionname){
        this.definitionname = definitionname ;
        this.modify("definitionname",definitionname);
    }

    /**
     * 设置 [模型版本]
     */
    public void setModelversion(Integer modelversion){
        this.modelversion = modelversion ;
        this.modify("modelversion",modelversion);
    }

    /**
     * 设置 [模型是否启用]
     */
    public void setModelenable(Integer modelenable){
        this.modelenable = modelenable ;
        this.modify("modelenable",modelenable);
    }

    /**
     * 设置 [系统标识]
     */
    public void setPssystemid(String pssystemid){
        this.pssystemid = pssystemid ;
        this.modify("pssystemid",pssystemid);
    }

    /**
     * 设置 [校验]
     */
    public void setMd5check(String md5check){
        this.md5check = md5check ;
        this.modify("md5check",md5check);
    }

    /**
     * 设置 [BPMN]
     */
    public void setBpmnfile(String bpmnfile){
        this.bpmnfile = bpmnfile ;
        this.modify("bpmnfile",bpmnfile);
    }

    /**
     * 设置 [DeployKey]
     */
    public void setDeploykey(String deploykey){
        this.deploykey = deploykey ;
        this.modify("deploykey",deploykey);
    }

    /**
     * 设置 [WebServiceIds]
     */
    public void setWebserviceids(String webserviceids){
        this.webserviceids = webserviceids ;
        this.modify("webserviceids",webserviceids);
    }

    /**
     * 设置 [MobileServiceIds]
     */
    public void setMobileserviceids(String mobileserviceids){
        this.mobileserviceids = mobileserviceids ;
        this.modify("mobileserviceids",mobileserviceids);
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
        this.reset("definitionkey");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


