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
 * [流程定义节点] 对象
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("流程定义节点")
public class WFProcessNode extends EntityBase implements Serializable {

    /**
     * 节点标识
     */
    @DEField(name = "nodeid", isKeyField = true)
    @JSONField(name = "userTaskId")
    @JsonProperty("userTaskId")
    @ApiModelProperty("节点标识")
    private String usertaskid;

    /**
     * 节点名称
     */
    @DEField(name = "nodename")
    @JSONField(name = "userTaskName")
    @JsonProperty("userTaskName")
    @ApiModelProperty("节点名称")
    private String usertaskname;

    /**
     * DefinitionKey
     */
    @DEField(name = "definitionkey")
    @JSONField(name = "processDefinitionKey")
    @JsonProperty("processDefinitionKey")
    @ApiModelProperty("DefinitionKey")
    private String processdefinitionkey;

    /**
     * 流程定义名称
     */
    @DEField(name = "definitionname")
    @JSONField(name = "processDefinitionName")
    @JsonProperty("processDefinitionName")
    @ApiModelProperty("流程定义名称")
    private String processdefinitionname;

    /**
     * 版本
     */
    @JSONField(name = "version")
    @JsonProperty("version")
    @ApiModelProperty("版本")
    private Integer version;

    /**
     * 数量
     */
    @JSONField(name = "cnt")
    @JsonProperty("cnt")
    @ApiModelProperty("数量")
    private Integer cnt;

    /**
     * DefinitionId
     */
    @DEField(name = "definitionid")
    @JSONField(name = "processDefinitionId")
    @JsonProperty("processDefinitionId")
    @ApiModelProperty("DefinitionId")
    private String processdefinitionid;




}


