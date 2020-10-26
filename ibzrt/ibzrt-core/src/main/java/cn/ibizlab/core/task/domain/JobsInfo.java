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
import cn.ibizlab.util.helper.DataObject;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;
import cn.ibizlab.util.annotation.Audit;

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [任务信息] 对象
 */
@Data
public class JobsInfo extends EntityClient implements Serializable {

    /**
     * 主键ID
     */
    @DEField(isKeyField=true)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 租户ID
     */
    @DEField(name = "tenant_id")
    @JSONField(name = "tenant_id")
    @JsonProperty("tenant_id")
    private String tenantId;

    /**
     * 服务名
     */
    @JSONField(name = "app")
    @JsonProperty("app")
    private String app;

    /**
     * 任务执行CRON
     */
    @JSONField(name = "cron")
    @JsonProperty("cron")
    private String cron;

    /**
     * 执行器任务HANDLER
     */
    @JSONField(name = "handler")
    @JsonProperty("handler")
    private String handler;

    /**
     * 执行器任务参数
     */
    @JSONField(name = "param")
    @JsonProperty("param")
    private String param;

    /**
     * 任务执行超时时间（秒）
     */
    @DEField(defaultValue = "0")
    @JSONField(name = "timeout")
    @JsonProperty("timeout")
    private Integer timeout;

    /**
     * 失败重试次数
     */
    @DEField(defaultValue = "0")
    @JSONField(name = "fail_retry_count")
    @JsonProperty("fail_retry_count")
    private Integer failRetryCount;

    /**
     * 上次调度时间
     */
    @DEField(name = "last_time")
    @JSONField(name = "last_time")
    @JsonProperty("last_time")
    private Long lastTime;

    /**
     * 下次调度时间
     */
    @DEField(name = "next_time")
    @JSONField(name = "next_time")
    @JsonProperty("next_time")
    private Long nextTime;

    /**
     * 所有者
     */
    @JSONField(name = "author")
    @JsonProperty("author")
    private String author;

    /**
     * 备注
     */
    @JSONField(name = "remark")
    @JsonProperty("remark")
    private String remark;

    /**
     * 状态
     */
    @JSONField(name = "status")
    @JsonProperty("status")
    private Integer status;

    /**
     * 更新时间
     */
    @DEField(name = "update_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "update_time" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    private Timestamp updateTime;

    /**
     * 创建时间
     */
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "create_time" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    private Timestamp createTime;





    /**
     * 设置 [租户ID]
     */
    public void setTenantId(String tenantId){
        this.tenantId = tenantId ;
        this.modify("tenant_id",tenantId);
    }

    /**
     * 设置 [服务名]
     */
    public void setApp(String app){
        this.app = app ;
        this.modify("app",app);
    }

    /**
     * 设置 [任务执行CRON]
     */
    public void setCron(String cron){
        this.cron = cron ;
        this.modify("cron",cron);
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
     * 设置 [任务执行超时时间（秒）]
     */
    public void setTimeout(Integer timeout){
        this.timeout = timeout ;
        this.modify("timeout",timeout);
    }

    /**
     * 设置 [失败重试次数]
     */
    public void setFailRetryCount(Integer failRetryCount){
        this.failRetryCount = failRetryCount ;
        this.modify("fail_retry_count",failRetryCount);
    }

    /**
     * 设置 [上次调度时间]
     */
    public void setLastTime(Long lastTime){
        this.lastTime = lastTime ;
        this.modify("last_time",lastTime);
    }

    /**
     * 设置 [下次调度时间]
     */
    public void setNextTime(Long nextTime){
        this.nextTime = nextTime ;
        this.modify("next_time",nextTime);
    }

    /**
     * 设置 [所有者]
     */
    public void setAuthor(String author){
        this.author = author ;
        this.modify("author",author);
    }

    /**
     * 设置 [备注]
     */
    public void setRemark(String remark){
        this.remark = remark ;
        this.modify("remark",remark);
    }

    /**
     * 设置 [状态]
     */
    public void setStatus(Integer status){
        this.status = status ;
        this.modify("status",status);
    }

    /**
     * 设置 [更新时间]
     */
    public void setUpdateTime(Timestamp updateTime){
        this.updateTime = updateTime ;
        this.modify("update_time",updateTime);
    }

    /**
     * 格式化日期 [更新时间]
     */
    public String formatUpdateTime(){
        if (this.updateTime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(updateTime);
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
        this.reset("id");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


