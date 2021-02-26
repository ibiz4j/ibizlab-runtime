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
import cn.ibizlab.util.enums.DupCheck;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;
import cn.ibizlab.util.annotation.Audit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * [工作流任务] 对象
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("工作流任务")
public class WFTask extends EntityBase implements Serializable {

    /**
     * 任务标识
     */
    @DEField(name = "taskid", isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty("任务标识")
    private String id;

    /**
     * 状态
     */
    @DEField(name = "taskname")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty("状态")
    private String name;

    /**
     * DefinitionId
     */
    @DEField(name = "definitionid")
    @JSONField(name = "processDefinitionId")
    @JsonProperty("processDefinitionId")
    @ApiModelProperty("DefinitionId")
    private String processdefinitionid;

    /**
     * DefinitionKey
     */
    @DEField(name = "definitionkey")
    @JSONField(name = "processDefinitionKey")
    @JsonProperty("processDefinitionKey")
    @ApiModelProperty("DefinitionKey")
    private String processdefinitionkey;

    /**
     * 流程
     */
    @DEField(name = "definitionname")
    @JSONField(name = "processDefinitionName")
    @JsonProperty("processDefinitionName")
    @ApiModelProperty("流程")
    private String processdefinitionname;

    /**
     * TaskDefinitionKey
     */
    @JSONField(name = "taskDefinitionKey")
    @JsonProperty("taskDefinitionKey")
    @ApiModelProperty("TaskDefinitionKey")
    private String taskdefinitionkey;

    /**
     * 待办事项
     */
    @JSONField(name = "description")
    @JsonProperty("description")
    @ApiModelProperty("待办事项")
    private String description;

    /**
     * 发起时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createTime", format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createTime")
    @ApiModelProperty("发起时间")
    private Timestamp createtime;

    /**
     * 实例标识
     */
    @DEField(name = "instanceid")
    @JSONField(name = "processInstanceId")
    @JsonProperty("processInstanceId")
    @ApiModelProperty("实例标识")
    private String processinstanceid;

    /**
     * 业务键值
     */
    @DEField(name = "businesskey")
    @JSONField(name = "processInstanceBusinessKey")
    @JsonProperty("processInstanceBusinessKey")
    @ApiModelProperty("业务键值")
    private String processinstancebusinesskey;




    /**
     * 格式化日期 [发起时间]
     */
    public String formatCreatetime() {
        if (this.createtime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(createtime);
    }
}


