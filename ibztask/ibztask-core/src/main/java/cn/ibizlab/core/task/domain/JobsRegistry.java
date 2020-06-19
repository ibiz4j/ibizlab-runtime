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
 * 实体[任务注册信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "JOBS_REGISTRY",resultMap = "JobsRegistryResultMap")
public class JobsRegistry extends EntityMP implements Serializable {

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
     * 服务名
     */
    @TableField(value = "app")
    @JSONField(name = "app")
    @JsonProperty("app")
    private String app;
    /**
     * 执行地址
     */
    @TableField(value = "address")
    @JSONField(name = "address")
    @JsonProperty("address")
    private String address;
    /**
     * 状态
     */
    @TableField(value = "status")
    @JSONField(name = "status")
    @JsonProperty("status")
    private Integer status;
    /**
     * 更新时间
     */
    @DEField(name = "update_time")
    @TableField(value = "update_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "update_time" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    private Timestamp updateTime;



    /**
     * 设置 [服务名]
     */
    public void setApp(String app){
        this.app = app ;
        this.modify("app",app);
    }

    /**
     * 设置 [执行地址]
     */
    public void setAddress(String address){
        this.address = address ;
        this.modify("address",address);
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

}


