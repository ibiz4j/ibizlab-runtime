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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [流程定义] 对象
 */
@Data
@ApiModel("流程定义")
public class WFProcessDefinition extends EntityClient implements Serializable {

    /**
     * DefinitionKey
     */
    @DEField(defaultValue = "deploykey", defaultValueType = DEFieldDefaultValueType.PARAM , isKeyField = true)
    @JSONField(name = "definitionkey")
    @JsonProperty("definitionkey")
    @ApiModelProperty("DefinitionKey")
    private String definitionkey;

    /**
     * 流程定义名称
     */
    @JSONField(name = "definitionname")
    @JsonProperty("definitionname")
    @ApiModelProperty("流程定义名称")
    private String definitionname;

    /**
     * 模型版本
     */
    @JSONField(name = "modelversion")
    @JsonProperty("modelversion")
    @ApiModelProperty("模型版本")
    private Integer modelversion;

    /**
     * 模型是否启用
     */
    @JSONField(name = "modelenable")
    @JsonProperty("modelenable")
    @ApiModelProperty("模型是否启用")
    private Integer modelenable;

    /**
     * 系统标识
     */
    @JSONField(name = "pssystemid")
    @JsonProperty("pssystemid")
    @ApiModelProperty("系统标识")
    private String pssystemid;

    /**
     * 校验
     */
    @JSONField(name = "md5check")
    @JsonProperty("md5check")
    @ApiModelProperty("校验")
    private String md5check;

    /**
     * BPMN
     */
    @JSONField(name = "bpmnfile")
    @JsonProperty("bpmnfile")
    @ApiModelProperty("BPMN")
    private String bpmnfile;

    /**
     * DeployKey
     */
    @JSONField(name = "deploykey")
    @JsonProperty("deploykey")
    @ApiModelProperty("DeployKey")
    private String deploykey;

    /**
     * WebServiceIds
     */
    @JSONField(name = "webserviceids")
    @JsonProperty("webserviceids")
    @ApiModelProperty("WebServiceIds")
    private String webserviceids;

    /**
     * MobileServiceIds
     */
    @JSONField(name = "mobileserviceids")
    @JsonProperty("mobileserviceids")
    @ApiModelProperty("MobileServiceIds")
    private String mobileserviceids;





    /**
     * 设置 [流程定义名称]
     */
    public void setDefinitionname(String definitionname) {
        this.definitionname = definitionname ;
        this.modify("definitionname",definitionname);
    }

    /**
     * 设置 [模型版本]
     */
    public void setModelversion(Integer modelversion) {
        this.modelversion = modelversion ;
        this.modify("modelversion",modelversion);
    }

    /**
     * 设置 [模型是否启用]
     */
    public void setModelenable(Integer modelenable) {
        this.modelenable = modelenable ;
        this.modify("modelenable",modelenable);
    }

    /**
     * 设置 [系统标识]
     */
    public void setPssystemid(String pssystemid) {
        this.pssystemid = pssystemid ;
        this.modify("pssystemid",pssystemid);
    }

    /**
     * 设置 [校验]
     */
    public void setMd5check(String md5check) {
        this.md5check = md5check ;
        this.modify("md5check",md5check);
    }

    /**
     * 设置 [BPMN]
     */
    public void setBpmnfile(String bpmnfile) {
        this.bpmnfile = bpmnfile ;
        this.modify("bpmnfile",bpmnfile);
    }

    /**
     * 设置 [DeployKey]
     */
    public void setDeploykey(String deploykey) {
        this.deploykey = deploykey ;
        this.modify("deploykey",deploykey);
    }

    /**
     * 设置 [WebServiceIds]
     */
    public void setWebserviceids(String webserviceids) {
        this.webserviceids = webserviceids ;
        this.modify("webserviceids",webserviceids);
    }

    /**
     * 设置 [MobileServiceIds]
     */
    public void setMobileserviceids(String mobileserviceids) {
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


