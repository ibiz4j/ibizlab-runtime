package cn.ibizlab.core.task.domain;

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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;

/**
 * 实体[任务调度日志]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "JOBS_LOG",resultMap = "JobsLogResultMap")
public class JobsLog extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @DEField(isKeyField=true)
    @TableId(value= "id",type=IdType.ASSIGN_ID)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;
    /**
     * 任务ID
     */
    @DEField(name = "job_id")
    @TableField(value = "job_id")
    @JSONField(name = "job_id")
    @JsonProperty("job_id")
    private String jobId;
    /**
     * 执行地址
     */
    @TableField(value = "address")
    @JSONField(name = "address")
    @JsonProperty("address")
    private String address;
    /**
     * 执行器任务HANDLER
     */
    @TableField(value = "handler")
    @JSONField(name = "handler")
    @JsonProperty("handler")
    private String handler;
    /**
     * 执行器任务参数
     */
    @TableField(value = "param")
    @JSONField(name = "param")
    @JsonProperty("param")
    private String param;
    /**
     * 失败重试次数
     */
    @DEField(defaultValue = "0")
    @TableField(value = "fail_retry_count")
    @JSONField(name = "fail_retry_count")
    @JsonProperty("fail_retry_count")
    private Integer failRetryCount;
    /**
     * 触发器调度返回码
     */
    @DEField(defaultValue = "0")
    @TableField(value = "trigger_code")
    @JSONField(name = "trigger_code")
    @JsonProperty("trigger_code")
    private Integer triggerCode;
    /**
     * 触发器调度类型
     */
    @DEField(name = "trigger_type")
    @TableField(value = "trigger_type")
    @JSONField(name = "trigger_type")
    @JsonProperty("trigger_type")
    private String triggerType;
    /**
     * 触发器调度信息
     */
    @DEField(name = "trigger_msg")
    @TableField(value = "trigger_msg")
    @JSONField(name = "trigger_msg")
    @JsonProperty("trigger_msg")
    private String triggerMsg;
    /**
     * 创建时间
     */
    @DEField(name = "create_time")
    @TableField(value = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "create_time" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    private Timestamp createTime;



    /**
     * 设置 [任务ID]
     */
    public void setJobId(String jobId){
        this.jobId = jobId ;
        this.modify("job_id",jobId);
    }

    /**
     * 设置 [执行地址]
     */
    public void setAddress(String address){
        this.address = address ;
        this.modify("address",address);
    }

    /**
     * 设置 [执行器任务HANDLER]
     */
    public void setHandler(String handler){
        this.handler = handler ;
        this.modify("handler",handler);
    }

    /**
     * 设置 [执行器任务参数]
     */
    public void setParam(String param){
        this.param = param ;
        this.modify("param",param);
    }

    /**
     * 设置 [失败重试次数]
     */
    public void setFailRetryCount(Integer failRetryCount){
        this.failRetryCount = failRetryCount ;
        this.modify("fail_retry_count",failRetryCount);
    }

    /**
     * 设置 [触发器调度返回码]
     */
    public void setTriggerCode(Integer triggerCode){
        this.triggerCode = triggerCode ;
        this.modify("trigger_code",triggerCode);
    }

    /**
     * 设置 [触发器调度类型]
     */
    public void setTriggerType(String triggerType){
        this.triggerType = triggerType ;
        this.modify("trigger_type",triggerType);
    }

    /**
     * 设置 [触发器调度信息]
     */
    public void setTriggerMsg(String triggerMsg){
        this.triggerMsg = triggerMsg ;
        this.modify("trigger_msg",triggerMsg);
    }

    /**
     * 设置 [创建时间]
     */
    public void setCreateTime(Timestamp createTime){
        this.createTime = createTime ;
        this.modify("create_time",createTime);
    }

    /**
     * 格式化日期 [创建时间]
     */
    public String formatCreateTime(){
        if (this.createTime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(createTime);
    }

}


