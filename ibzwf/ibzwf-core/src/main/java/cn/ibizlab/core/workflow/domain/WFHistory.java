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
import cn.ibizlab.util.helper.DataObject;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;
import cn.ibizlab.util.annotation.Audit;


/**
 * [历史] 对象
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WFHistory extends EntityBase implements Serializable {

    /**
     * 标识
     */
    @DEField(name = "histid" , isKeyField=true)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 操作者标识
     */
    @JSONField(name = "author")
    @JsonProperty("author")
    private String author;

    /**
     * 操作者
     */
    @JSONField(name = "authorName")
    @JsonProperty("authorName")
    private String authorname;

    /**
     * 意见
     */
    @DEField(name = "message")
    @JSONField(name = "fullMessage")
    @JsonProperty("fullMessage")
    private String fullmessage;

    /**
     * 时间
     */
    @DEField(name = "actiontime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "time" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("time")
    private Timestamp time;

    /**
     * 意见类型
     */
    @DEField(name = "actiontype")
    @JSONField(name = "type")
    @JsonProperty("type")
    private String type;

    /**
     * 任务标识
     */
    @JSONField(name = "taskId")
    @JsonProperty("taskId")
    private String taskid;

    /**
     * 实例标识
     */
    @DEField(name = "instanceid")
    @JSONField(name = "processInstanceId")
    @JsonProperty("processInstanceId")
    private String processinstanceid;

    /**
     * 业务键值
     */
    @DEField(name = "businesskey")
    @JSONField(name = "processInstanceBusinessKey")
    @JsonProperty("processInstanceBusinessKey")
    private String processinstancebusinesskey;




    /**
     * 格式化日期 [时间]
     */
    public String formatTime(){
        if (this.time == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(time);
    }
}


