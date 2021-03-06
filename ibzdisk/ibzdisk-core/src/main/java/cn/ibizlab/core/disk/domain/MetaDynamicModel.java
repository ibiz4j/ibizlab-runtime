package cn.ibizlab.core.disk.domain;

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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 实体[动态模型]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZDYNAMICMODEL", resultMap = "MetaDynamicModelResultMap")
@ApiModel("动态模型")
public class MetaDynamicModel extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 动态实例
     */
    @TableField(value = "dynainstid")
    @JSONField(name = "dynainstid")
    @JsonProperty("dynainstid")
    @ApiModelProperty("动态实例")
    private String dynainstid;
    /**
     * 系统
     */
    @TableField(value = "systemid")
    @JSONField(name = "system_id")
    @JsonProperty("system_id")
    @ApiModelProperty("系统")
    private String systemId;
    /**
     * 配置标识
     */
    @DEField(isKeyField = true)
    @TableId(value = "configid", type = IdType.ASSIGN_UUID)
    @JSONField(name = "configid")
    @JsonProperty("configid")
    @ApiModelProperty("配置标识")
    private String configid;
    /**
     * 配置名称
     */
    @TableField(value = "configname")
    @JSONField(name = "configname")
    @JsonProperty("configname")
    @ApiModelProperty("配置名称")
    private String configname;
    /**
     * 父实例
     */
    @TableField(value = "pdynainstid")
    @JSONField(name = "pdynainstid")
    @JsonProperty("pdynainstid")
    @ApiModelProperty("父实例")
    private String pdynainstid;
    /**
     * 文件
     */
    @TableField(value = "modelfile")
    @JSONField(name = "modelfile")
    @JsonProperty("modelfile")
    @ApiModelProperty("文件")
    private String modelfile;
    /**
     * 状态
     */
    @DEField(defaultValue = "0")
    @TableField(value = "status")
    @JSONField(name = "status")
    @JsonProperty("status")
    @ApiModelProperty("状态")
    private String status;

    /**
     * 主实例标识
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.disk.domain.MetaDynamicModel pdynamicinstid;



    /**
     * 设置 [动态实例]
     */
    public void setDynainstid(String dynainstid) {
        this.dynainstid = dynainstid;
        this.modify("dynainstid", dynainstid);
    }

    /**
     * 设置 [系统]
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId;
        this.modify("systemid", systemId);
    }

    /**
     * 设置 [配置名称]
     */
    public void setConfigname(String configname) {
        this.configname = configname;
        this.modify("configname", configname);
    }

    /**
     * 设置 [父实例]
     */
    public void setPdynainstid(String pdynainstid) {
        this.pdynainstid = pdynainstid;
        this.modify("pdynainstid", pdynainstid);
    }

    /**
     * 设置 [文件]
     */
    public void setModelfile(String modelfile) {
        this.modelfile = modelfile;
        this.modify("modelfile", modelfile);
    }

    /**
     * 设置 [状态]
     */
    public void setStatus(String status) {
        this.status = status;
        this.modify("status", status);
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
        this.reset("configid");
        return super.copyTo(targetEntity, bIncEmpty);
    }
}


