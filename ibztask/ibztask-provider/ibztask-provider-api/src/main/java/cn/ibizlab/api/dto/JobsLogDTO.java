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
 * 服务DTO对象[JobsLogDTO]
 */
@Data
@ApiModel("任务调度日志")
public class JobsLogDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("主键ID")
    private String id;

    /**
     * 属性 [JOB_ID]
     *
     */
    @JSONField(name = "job_id")
    @JsonProperty("job_id")
    @NotBlank(message = "[任务ID]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("任务ID")
    private String jobId;

    /**
     * 属性 [ADDRESS]
     *
     */
    @JSONField(name = "address")
    @JsonProperty("address")
    @Size(min = 0, max = 255, message = "内容长度必须小于等于[255]")
    @ApiModelProperty("执行地址")
    private String address;

    /**
     * 属性 [HANDLER]
     *
     */
    @JSONField(name = "handler")
    @JsonProperty("handler")
    @Size(min = 0, max = 255, message = "内容长度必须小于等于[255]")
    @ApiModelProperty("执行器任务HANDLER")
    private String handler;

    /**
     * 属性 [PARAM]
     *
     */
    @JSONField(name = "param")
    @JsonProperty("param")
    @Size(min = 0, max = 512, message = "内容长度必须小于等于[512]")
    @ApiModelProperty("执行器任务参数")
    private String param;

    /**
     * 属性 [FAIL_RETRY_COUNT]
     *
     */
    @JSONField(name = "fail_retry_count")
    @JsonProperty("fail_retry_count")
    @NotNull(message = "[失败重试次数]不允许为空!")
    @ApiModelProperty("失败重试次数")
    private Integer failRetryCount;

    /**
     * 属性 [TRIGGER_CODE]
     *
     */
    @JSONField(name = "trigger_code")
    @JsonProperty("trigger_code")
    @NotNull(message = "[触发器调度返回码]不允许为空!")
    @ApiModelProperty("触发器调度返回码")
    private Integer triggerCode;

    /**
     * 属性 [TRIGGER_TYPE]
     *
     */
    @JSONField(name = "trigger_type")
    @JsonProperty("trigger_type")
    @NotBlank(message = "[触发器调度类型]不允许为空!")
    @Size(min = 0, max = 30, message = "内容长度必须小于等于[30]")
    @ApiModelProperty("触发器调度类型")
    private String triggerType;

    /**
     * 属性 [TRIGGER_MSG]
     *
     */
    @JSONField(name = "trigger_msg")
    @JsonProperty("trigger_msg")
    @Size(min = 0, max = 1048576, message = "内容长度必须小于等于[1048576]")
    @ApiModelProperty("触发器调度信息")
    private String triggerMsg;

    /**
     * 属性 [CREATE_TIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "create_time" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @NotNull(message = "[创建时间]不允许为空!")
    @ApiModelProperty("创建时间")
    private Timestamp createTime;


    /**
     * 设置 [JOB_ID]
     */
    public void setJobId(String  jobId){
        this.jobId = jobId ;
        this.modify("job_id",jobId);
    }

    /**
     * 设置 [ADDRESS]
     */
    public void setAddress(String  address){
        this.address = address ;
        this.modify("address",address);
    }

    /**
     * 设置 [HANDLER]
     */
    public void setHandler(String  handler){
        this.handler = handler ;
        this.modify("handler",handler);
    }

    /**
     * 设置 [PARAM]
     */
    public void setParam(String  param){
        this.param = param ;
        this.modify("param",param);
    }

    /**
     * 设置 [FAIL_RETRY_COUNT]
     */
    public void setFailRetryCount(Integer  failRetryCount){
        this.failRetryCount = failRetryCount ;
        this.modify("fail_retry_count",failRetryCount);
    }

    /**
     * 设置 [TRIGGER_CODE]
     */
    public void setTriggerCode(Integer  triggerCode){
        this.triggerCode = triggerCode ;
        this.modify("trigger_code",triggerCode);
    }

    /**
     * 设置 [TRIGGER_TYPE]
     */
    public void setTriggerType(String  triggerType){
        this.triggerType = triggerType ;
        this.modify("trigger_type",triggerType);
    }

    /**
     * 设置 [TRIGGER_MSG]
     */
    public void setTriggerMsg(String  triggerMsg){
        this.triggerMsg = triggerMsg ;
        this.modify("trigger_msg",triggerMsg);
    }

    /**
     * 设置 [CREATE_TIME]
     */
    public void setCreateTime(Timestamp  createTime){
        this.createTime = createTime ;
        this.modify("create_time",createTime);
    }


}


