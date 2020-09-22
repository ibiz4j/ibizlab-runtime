package cn.ibizlab.core.workflow.domain;

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
import cn.ibizlab.util.annotation.Audit;

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [流程实例] 对象
 */
@Data
public class WFProcessInstance extends EntityClient implements Serializable {

    /**
     * 实例标识
     */
    @DEField(name = "instanceid" , isKeyField=true)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 实例名称
     */
    @DEField(name = "instancename")
    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;

    /**
     * DefinitionKey
     */
    @DEField(name = "definitionkey")
    @JSONField(name = "processdefinitionkey")
    @JsonProperty("processdefinitionkey")
    private String processdefinitionkey;

    /**
     * 流程定义名称
     */
    @DEField(name = "definitionname")
    @JSONField(name = "processdefinitionname")
    @JsonProperty("processdefinitionname")
    private String processdefinitionname;

    /**
     * 业务键值
     */
    @JSONField(name = "businesskey")
    @JsonProperty("businesskey")
    private String businesskey;

    /**
     * 启动时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "starttime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("starttime")
    private Timestamp starttime;

    /**
     * 属性
     */
    @JSONField(name = "startuserid")
    @JsonProperty("startuserid")
    private String startuserid;





    /**
     * 设置 [实例名称]
     */
    public void setName(String name){
        this.name = name ;
        this.modify("instancename",name);
    }

    /**
     * 设置 [DefinitionKey]
     */
    public void setProcessdefinitionkey(String processdefinitionkey){
        this.processdefinitionkey = processdefinitionkey ;
        this.modify("definitionkey",processdefinitionkey);
    }

    /**
     * 设置 [流程定义名称]
     */
    public void setProcessdefinitionname(String processdefinitionname){
        this.processdefinitionname = processdefinitionname ;
        this.modify("definitionname",processdefinitionname);
    }

    /**
     * 设置 [业务键值]
     */
    public void setBusinesskey(String businesskey){
        this.businesskey = businesskey ;
        this.modify("businesskey",businesskey);
    }

    /**
     * 设置 [启动时间]
     */
    public void setStarttime(Timestamp starttime){
        this.starttime = starttime ;
        this.modify("starttime",starttime);
    }

    /**
     * 格式化日期 [启动时间]
     */
    public String formatStarttime(){
        if (this.starttime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(starttime);
    }
    /**
     * 设置 [属性]
     */
    public void setStartuserid(String startuserid){
        this.startuserid = startuserid ;
        this.modify("startuserid",startuserid);
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
        this.reset("instanceid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


