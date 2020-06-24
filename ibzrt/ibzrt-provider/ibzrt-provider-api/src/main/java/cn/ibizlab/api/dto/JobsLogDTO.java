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
import lombok.Data;

/**
 * 服务DTO对象[JobsLogDTO]
 */
@Data
public class JobsLogDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 属性 [JOB_ID]
     *
     */
    @JSONField(name = "job_id")
    @JsonProperty("job_id")
    private String jobId;

    /**
     * 属性 [ADDRESS]
     *
     */
    @JSONField(name = "address")
    @JsonProperty("address")
    private String address;

    /**
     * 属性 [HANDLER]
     *
     */
    @JSONField(name = "handler")
    @JsonProperty("handler")
    private String handler;

    /**
     * 属性 [PARAM]
     *
     */
    @JSONField(name = "param")
    @JsonProperty("param")
    private String param;

    /**
     * 属性 [FAIL_RETRY_COUNT]
     *
     */
    @JSONField(name = "fail_retry_count")
    @JsonProperty("fail_retry_count")
    private Integer failRetryCount;

    /**
     * 属性 [TRIGGER_CODE]
     *
     */
    @JSONField(name = "trigger_code")
    @JsonProperty("trigger_code")
    private Integer triggerCode;

    /**
     * 属性 [TRIGGER_TYPE]
     *
     */
    @JSONField(name = "trigger_type")
    @JsonProperty("trigger_type")
    private String triggerType;

    /**
     * 属性 [TRIGGER_MSG]
     *
     */
    @JSONField(name = "trigger_msg")
    @JsonProperty("trigger_msg")
    private String triggerMsg;

    /**
     * 属性 [CREATE_TIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "create_time" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
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

