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
 * 服务DTO对象[WFProcessInstanceDTO]
 */
@Data
@ApiModel("流程实例")
public class WFProcessInstanceDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [INSTANCEID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("实例标识")
    private String id;

    /**
     * 属性 [INSTANCENAME]
     *
     */
    @JSONField(name = "name")
    @JsonProperty("name")
    @Size(min = 0, max = 300, message = "内容长度必须小于等于[300]")
    @ApiModelProperty("实例名称")
    private String name;

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
     * 属性 [BUSINESSKEY]
     *
     */
    @JSONField(name = "businesskey")
    @JsonProperty("businesskey")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("业务键值")
    private String businesskey;

    /**
     * 属性 [STARTTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "starttime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("starttime")
    @ApiModelProperty("启动时间")
    private Timestamp starttime;

    /**
     * 属性 [ENDTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("endtime")
    @ApiModelProperty("结束时间")
    private Timestamp endtime;

    /**
     * 属性 [STARTUSERID]
     *
     */
    @JSONField(name = "startuserid")
    @JsonProperty("startuserid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("发起人标识")
    private String startuserid;

    /**
     * 属性 [STARTUSERNAME]
     *
     */
    @JSONField(name = "startusername")
    @JsonProperty("startusername")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("发起人")
    private String startusername;

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
     * 属性 [WFUSERS]
     *
     */
    @JSONField(name = "wfusers")
    @JsonProperty("wfusers")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("步骤用户")
    private String wfusers;

    /**
     * 属性 [TASKDEFINITIONKEY]
     *
     */
    @JSONField(name = "taskdefinitionkey")
    @JsonProperty("taskdefinitionkey")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("步骤标记")
    private String taskdefinitionkey;


    /**
     * 设置 [INSTANCENAME]
     */
    public void setName(String  name){
        this.name = name ;
        this.modify("instancename",name);
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
     * 设置 [BUSINESSKEY]
     */
    public void setBusinesskey(String  businesskey){
        this.businesskey = businesskey ;
        this.modify("businesskey",businesskey);
    }

    /**
     * 设置 [STARTTIME]
     */
    public void setStarttime(Timestamp  starttime){
        this.starttime = starttime ;
        this.modify("starttime",starttime);
    }

    /**
     * 设置 [ENDTIME]
     */
    public void setEndtime(Timestamp  endtime){
        this.endtime = endtime ;
        this.modify("endtime",endtime);
    }

    /**
     * 设置 [STARTUSERID]
     */
    public void setStartuserid(String  startuserid){
        this.startuserid = startuserid ;
        this.modify("startuserid",startuserid);
    }

    /**
     * 设置 [STARTUSERNAME]
     */
    public void setStartusername(String  startusername){
        this.startusername = startusername ;
        this.modify("startusername",startusername);
    }

    /**
     * 设置 [DEFINITIONID]
     */
    public void setProcessdefinitionid(String  processdefinitionid){
        this.processdefinitionid = processdefinitionid ;
        this.modify("definitionid",processdefinitionid);
    }


}


