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
 * 服务DTO对象[WFProcessDefinitionDTO]
 */
@Data
public class WFProcessDefinitionDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DEFINITIONKEY]
     *
     */
    @JSONField(name = "definitionkey")
    @JsonProperty("definitionkey")
    private String definitionkey;

    /**
     * 属性 [DEFINITIONNAME]
     *
     */
    @JSONField(name = "definitionname")
    @JsonProperty("definitionname")
    private String definitionname;

    /**
     * 属性 [MODELVERSION]
     *
     */
    @JSONField(name = "modelversion")
    @JsonProperty("modelversion")
    private Integer modelversion;

    /**
     * 属性 [MODELENABLE]
     *
     */
    @JSONField(name = "modelenable")
    @JsonProperty("modelenable")
    private Integer modelenable;

    /**
     * 属性 [PSSYSTEMID]
     *
     */
    @JSONField(name = "pssystemid")
    @JsonProperty("pssystemid")
    private String pssystemid;

    /**
     * 属性 [TASKDEFINITIONKEY]
     *
     */
    @JSONField(name = "taskprocessdefinitionkey")
    @JsonProperty("taskprocessdefinitionkey")
    private String taskprocessdefinitionkey;

    /**
     * 属性 [MD5CHECK]
     *
     */
    @JSONField(name = "md5check")
    @JsonProperty("md5check")
    private String md5check;

    /**
     * 属性 [BPMNFILE]
     *
     */
    @JSONField(name = "bpmnfile")
    @JsonProperty("bpmnfile")
    private String bpmnfile;

    /**
     * 属性 [DEPLOYKEY]
     *
     */
    @JSONField(name = "deploykey")
    @JsonProperty("deploykey")
    private String deploykey;


    /**
     * 设置 [DEFINITIONNAME]
     */
    public void setDefinitionname(String  definitionname){
        this.definitionname = definitionname ;
        this.modify("definitionname",definitionname);
    }

    /**
     * 设置 [MODELVERSION]
     */
    public void setModelversion(Integer  modelversion){
        this.modelversion = modelversion ;
        this.modify("modelversion",modelversion);
    }

    /**
     * 设置 [MODELENABLE]
     */
    public void setModelenable(Integer  modelenable){
        this.modelenable = modelenable ;
        this.modify("modelenable",modelenable);
    }

    /**
     * 设置 [PSSYSTEMID]
     */
    public void setPssystemid(String  pssystemid){
        this.pssystemid = pssystemid ;
        this.modify("pssystemid",pssystemid);
    }

    /**
     * 设置 [TASKDEFINITIONKEY]
     */
    public void setTaskprocessdefinitionkey(String  taskprocessdefinitionkey){
        this.taskprocessdefinitionkey = taskprocessdefinitionkey ;
        this.modify("taskdefinitionkey",taskprocessdefinitionkey);
    }

    /**
     * 设置 [MD5CHECK]
     */
    public void setMd5check(String  md5check){
        this.md5check = md5check ;
        this.modify("md5check",md5check);
    }

    /**
     * 设置 [BPMNFILE]
     */
    public void setBpmnfile(String  bpmnfile){
        this.bpmnfile = bpmnfile ;
        this.modify("bpmnfile",bpmnfile);
    }

    /**
     * 设置 [DEPLOYKEY]
     */
    public void setDeploykey(String  deploykey){
        this.deploykey = deploykey ;
        this.modify("deploykey",deploykey);
    }


}

