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
 * 实体[任务锁]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "JOBS_LOCK",resultMap = "JobsLockResultMap")
public class JobsLock extends EntityMP implements Serializable {

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
     * 名称
     */
    @TableField(value = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;
    /**
     * 持有者
     */
    @TableField(value = "owner")
    @JSONField(name = "owner")
    @JsonProperty("owner")
    private String owner;
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
     * 设置 [名称]
     */
    public void setName(String name){
        this.name = name ;
        this.modify("name",name);
    }

    /**
     * 设置 [持有者]
     */
    public void setOwner(String owner){
        this.owner = owner ;
        this.modify("owner",owner);
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


