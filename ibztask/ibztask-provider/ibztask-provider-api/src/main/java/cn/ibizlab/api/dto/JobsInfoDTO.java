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
 * 服务DTO对象[JobsInfoDTO]
 */
@Data
public class JobsInfoDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 属性 [TENANT_ID]
     *
     */
    @JSONField(name = "tenant_id")
    @JsonProperty("tenant_id")
    private String tenantId;

    /**
     * 属性 [APP]
     *
     */
    @JSONField(name = "app")
    @JsonProperty("app")
    private String app;

    /**
     * 属性 [CRON]
     *
     */
    @JSONField(name = "cron")
    @JsonProperty("cron")
    private String cron;

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
     * 属性 [TIMEOUT]
     *
     */
    @JSONField(name = "timeout")
    @JsonProperty("timeout")
    private Integer timeout;

    /**
     * 属性 [FAIL_RETRY_COUNT]
     *
     */
    @JSONField(name = "fail_retry_count")
    @JsonProperty("fail_retry_count")
    private Integer failRetryCount;

    /**
     * 属性 [LAST_TIME]
     *
     */
    @JSONField(name = "last_time")
    @JsonProperty("last_time")
    private Long lastTime;

    /**
     * 属性 [NEXT_TIME]
     *
     */
    @JSONField(name = "next_time")
    @JsonProperty("next_time")
    private Long nextTime;

    /**
     * 属性 [AUTHOR]
     *
     */
    @JSONField(name = "author")
    @JsonProperty("author")
    private String author;

    /**
     * 属性 [REMARK]
     *
     */
    @JSONField(name = "remark")
    @JsonProperty("remark")
    private String remark;

    /**
     * 属性 [STATUS]
     *
     */
    @JSONField(name = "status")
    @JsonProperty("status")
    private Integer status;

    /**
     * 属性 [UPDATE_TIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "update_time" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    private Timestamp updateTime;

    /**
     * 属性 [CREATE_TIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "create_time" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    private Timestamp createTime;


    /**
     * 设置 [TENANT_ID]
     */
    public void setTenantId(String  tenantId){
        this.tenantId = tenantId ;
        this.modify("tenant_id",tenantId);
    }

    /**
     * 设置 [APP]
     */
    public void setApp(String  app){
        this.app = app ;
        this.modify("app",app);
    }

    /**
     * 设置 [CRON]
     */
    public void setCron(String  cron){
        this.cron = cron ;
        this.modify("cron",cron);
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
     * 设置 [TIMEOUT]
     */
    public void setTimeout(Integer  timeout){
        this.timeout = timeout ;
        this.modify("timeout",timeout);
    }

    /**
     * 设置 [FAIL_RETRY_COUNT]
     */
    public void setFailRetryCount(Integer  failRetryCount){
        this.failRetryCount = failRetryCount ;
        this.modify("fail_retry_count",failRetryCount);
    }

    /**
     * 设置 [LAST_TIME]
     */
    public void setLastTime(Long  lastTime){
        this.lastTime = lastTime ;
        this.modify("last_time",lastTime);
    }

    /**
     * 设置 [NEXT_TIME]
     */
    public void setNextTime(Long  nextTime){
        this.nextTime = nextTime ;
        this.modify("next_time",nextTime);
    }

    /**
     * 设置 [AUTHOR]
     */
    public void setAuthor(String  author){
        this.author = author ;
        this.modify("author",author);
    }

    /**
     * 设置 [REMARK]
     */
    public void setRemark(String  remark){
        this.remark = remark ;
        this.modify("remark",remark);
    }

    /**
     * 设置 [STATUS]
     */
    public void setStatus(Integer  status){
        this.status = status ;
        this.modify("status",status);
    }

    /**
     * 设置 [UPDATE_TIME]
     */
    public void setUpdateTime(Timestamp  updateTime){
        this.updateTime = updateTime ;
        this.modify("update_time",updateTime);
    }

    /**
     * 设置 [CREATE_TIME]
     */
    public void setCreateTime(Timestamp  createTime){
        this.createTime = createTime ;
        this.modify("create_time",createTime);
    }


}

