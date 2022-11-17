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
 * 服务DTO对象[WFProcessNodeDTO]
 */
@Data
@ApiModel("流程定义节点")
public class WFProcessNodeDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [NODEID]
     *
     */
    @JSONField(name = "usertaskid")
    @JsonProperty("usertaskid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("节点标识")
    private String usertaskid;

    /**
     * 属性 [NODENAME]
     *
     */
    @JSONField(name = "usertaskname")
    @JsonProperty("usertaskname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("节点名称")
    private String usertaskname;

    /**
     * 属性 [DEFINITIONKEY]
     *
     */
    @JSONField(name = "processdefinitionkey")
    @JsonProperty("processdefinitionkey")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("DefinitionKey")
    private String processdefinitionkey;

    /**
     * 属性 [DEFINITIONNAME]
     *
     */
    @JSONField(name = "processdefinitionname")
    @JsonProperty("processdefinitionname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("流程定义名称")
    private String processdefinitionname;

    /**
     * 属性 [VERSION]
     *
     */
    @JSONField(name = "version")
    @JsonProperty("version")
    @ApiModelProperty("版本")
    private Integer version;

    /**
     * 属性 [CNT]
     *
     */
    @JSONField(name = "cnt")
    @JsonProperty("cnt")
    @ApiModelProperty("数量")
    private Integer cnt;

    /**
     * 属性 [DEFINITIONID]
     *
     */
    @JSONField(name = "processdefinitionid")
    @JsonProperty("processdefinitionid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("DefinitionId")
    private String processdefinitionid;


    /**
     * 设置 [NODENAME]
     */
    public void setUsertaskname(String  usertaskname){
        this.usertaskname = usertaskname ;
        this.modify("nodename",usertaskname);
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
     * 设置 [VERSION]
     */
    public void setVersion(Integer  version){
        this.version = version ;
        this.modify("version",version);
    }

    /**
     * 设置 [CNT]
     */
    public void setCnt(Integer  cnt){
        this.cnt = cnt ;
        this.modify("cnt",cnt);
    }

    /**
     * 设置 [DEFINITIONID]
     */
    public void setProcessdefinitionid(String  processdefinitionid){
        this.processdefinitionid = processdefinitionid ;
        this.modify("definitionid",processdefinitionid);
    }


}


