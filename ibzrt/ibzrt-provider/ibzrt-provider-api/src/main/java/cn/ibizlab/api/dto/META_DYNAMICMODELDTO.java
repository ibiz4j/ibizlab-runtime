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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import cn.ibizlab.util.domain.DTOBase;
import cn.ibizlab.util.domain.DTOClient;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 服务DTO对象[META_DYNAMICMODELDTO]
 */
@Data
@ApiModel("动态模型")
public class META_DYNAMICMODELDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DYNAINSTID]
     *
     */
    @JSONField(name = "dynainstid")
    @JsonProperty("dynainstid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("动态实例")
    private String dynainstid;

    /**
     * 属性 [SYSTEMID]
     *
     */
    @JSONField(name = "system_id")
    @JsonProperty("system_id")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("系统")
    private String systemId;

    /**
     * 属性 [CONFIGID]
     *
     */
    @JSONField(name = "configid")
    @JsonProperty("configid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("配置标识")
    private String configid;

    /**
     * 属性 [CONFIGNAME]
     *
     */
    @JSONField(name = "configname")
    @JsonProperty("configname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("配置名称")
    private String configname;

    /**
     * 属性 [PDYNAINSTID]
     *
     */
    @JSONField(name = "pdynainstid")
    @JsonProperty("pdynainstid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("父实例")
    private String pdynainstid;

    /**
     * 属性 [MODELFILE]
     *
     */
    @JSONField(name = "modelfile")
    @JsonProperty("modelfile")
    @Size(min = 0, max = 1000, message = "内容长度必须小于等于[1000]")
    @ApiModelProperty("文件")
    private String modelfile;

    /**
     * 属性 [STATUS]
     *
     */
    @JSONField(name = "status")
    @JsonProperty("status")
    @Size(min = 0, max = 60, message = "内容长度必须小于等于[60]")
    @ApiModelProperty("状态")
    private String status;


    /**
     * 设置 [DYNAINSTID]
     */
    public void setDynainstid(String  dynainstid){
        this.dynainstid = dynainstid ;
        this.modify("dynainstid",dynainstid);
    }

    /**
     * 设置 [SYSTEMID]
     */
    public void setSystemId(String  systemId){
        this.systemId = systemId ;
        this.modify("systemid",systemId);
    }

    /**
     * 设置 [CONFIGNAME]
     */
    public void setConfigname(String  configname){
        this.configname = configname ;
        this.modify("configname",configname);
    }

    /**
     * 设置 [PDYNAINSTID]
     */
    public void setPdynainstid(String  pdynainstid){
        this.pdynainstid = pdynainstid ;
        this.modify("pdynainstid",pdynainstid);
    }

    /**
     * 设置 [MODELFILE]
     */
    public void setModelfile(String  modelfile){
        this.modelfile = modelfile ;
        this.modify("modelfile",modelfile);
    }

    /**
     * 设置 [STATUS]
     */
    public void setStatus(String  status){
        this.status = status ;
        this.modify("status",status);
    }


}


