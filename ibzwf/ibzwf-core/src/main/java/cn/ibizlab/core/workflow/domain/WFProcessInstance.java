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


/**
 * [流程实例] 对象
 */
@Getter
@Setter
@NoArgsConstructor
public class WFProcessInstance extends EntityBase implements Serializable {

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
    @JSONField(name = "processDefinitionKey")
    @JsonProperty("processDefinitionKey")
    private String processdefinitionkey;

    /**
     * 流程定义名称
     */
    @DEField(name = "definitionname")
    @JSONField(name = "processDefinitionName")
    @JsonProperty("processDefinitionName")
    private String processdefinitionname;

    /**
     * 业务键值
     */
    @JSONField(name = "businessKey")
    @JsonProperty("businessKey")
    private String businesskey;

    /**
     * 启动时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "startTime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("startTime")
    private Timestamp starttime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endTime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("endTime")
    private Timestamp endtime;

    /**
     * 发起人标识
     */
    @JSONField(name = "startUserId")
    @JsonProperty("startUserId")
    private String startuserid;

    /**
     * 发起人
     */
    @JSONField(name = "startUserName")
    @JsonProperty("startUserName")
    private String startusername;




    /**
     * 格式化日期 [启动时间]
     */
    public String formatStarttime(){
        if (this.starttime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("defieldFormatStr");
        return sdf.format(starttime);
    }
    /**
     * 格式化日期 [结束时间]
     */
    public String formatEndtime(){
        if (this.endtime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("defieldFormatStr");
        return sdf.format(endtime);
    }
}


