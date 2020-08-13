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


/**
 * [工作流任务] 对象
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WFTask extends EntityBase implements Serializable {

    /**
     * 任务标识
     */
    @DEField(name = "taskid" , isKeyField=true)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 状态
     */
    @DEField(name = "taskname")
    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;

    /**
     * DefinitionId
     */
    @DEField(name = "definitionid")
    @JSONField(name = "processDefinitionId")
    @JsonProperty("processDefinitionId")
    private String processdefinitionid;

    /**
     * DefinitionKey
     */
    @DEField(name = "definitionkey")
    @JSONField(name = "processDefinitionKey")
    @JsonProperty("processDefinitionKey")
    private String processdefinitionkey;

    /**
     * 流程
     */
    @DEField(name = "definitionname")
    @JSONField(name = "processDefinitionName")
    @JsonProperty("processDefinitionName")
    private String processdefinitionname;

    /**
     * TaskDefinitionKey
     */
    @JSONField(name = "taskDefinitionKey")
    @JsonProperty("taskDefinitionKey")
    private String taskdefinitionkey;

    /**
     * 待办事项
     */
    @JSONField(name = "description")
    @JsonProperty("description")
    private String description;

    /**
     * 发起时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createTime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createTime")
    private Timestamp createtime;

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
     * 格式化日期 [发起时间]
     */
    public String formatCreatetime(){
        if (this.createtime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(createtime);
    }
}


