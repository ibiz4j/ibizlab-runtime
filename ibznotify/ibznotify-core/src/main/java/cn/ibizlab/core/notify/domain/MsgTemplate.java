package cn.ibizlab.core.notify.domain;

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
 * 实体[消息模板]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZMSGTEMPL", resultMap = "MsgTemplateResultMap")
@ApiModel("消息模板")
public class MsgTemplate extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 模板标识
     */
    @DEField(isKeyField = true)
    @TableId(value = "tid", type = IdType.ASSIGN_UUID)
    @JSONField(name = "tid")
    @JsonProperty("tid")
    @ApiModelProperty("模板标识")
    private String tid;
    /**
     * 模板标题
     */
    @DEField(name = "template_name")
    @TableField(value = "template_name")
    @JSONField(name = "template_name")
    @JsonProperty("template_name")
    @ApiModelProperty("模板标题")
    private String templateName;
    /**
     * 模板类型
     */
    @DEField(name = "template_type")
    @TableField(value = "template_type")
    @JSONField(name = "template_type")
    @JsonProperty("template_type")
    @ApiModelProperty("模板类型")
    private String templateType;
    /**
     * 模板内容
     */
    @TableField(value = "content")
    @JSONField(name = "content")
    @JsonProperty("content")
    @ApiModelProperty("模板内容")
    private String content;
    /**
     * 模板标识
     */
    @DEField(name = "template_id")
    @TableField(value = "template_id")
    @JSONField(name = "template_id")
    @JsonProperty("template_id")
    @ApiModelProperty("模板标识")
    private String templateId;
    /**
     * URL
     */
    @DEField(name = "template_url")
    @TableField(value = "template_url")
    @JSONField(name = "template_url")
    @JsonProperty("template_url")
    @ApiModelProperty("URL")
    private String templateUrl;
    /**
     * 开放平台接入标识
     */
    @TableField(value = "accessid")
    @JSONField(name = "access_id")
    @JsonProperty("access_id")
    @ApiModelProperty("开放平台接入标识")
    private String accessId;
    /**
     * 接入平台
     */
    @TableField(value = "accessname")
    @JSONField(name = "access_name")
    @JsonProperty("access_name")
    @ApiModelProperty("接入平台")
    private String accessName;
    /**
     * 接入平台类型
     */
    @DEField(name = "open_type")
    @TableField(value = "open_type")
    @JSONField(name = "open_type")
    @JsonProperty("open_type")
    @ApiModelProperty("接入平台类型")
    private String openType;

    /**
     * 接入平台
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.notify.domain.MsgOpenAccess openaccess;



    /**
     * 设置 [模板标题]
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
        this.modify("template_name", templateName);
    }

    /**
     * 设置 [模板类型]
     */
    public void setTemplateType(String templateType) {
        this.templateType = templateType;
        this.modify("template_type", templateType);
    }

    /**
     * 设置 [模板内容]
     */
    public void setContent(String content) {
        this.content = content;
        this.modify("content", content);
    }

    /**
     * 设置 [模板标识]
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
        this.modify("template_id", templateId);
    }

    /**
     * 设置 [URL]
     */
    public void setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl;
        this.modify("template_url", templateUrl);
    }

    /**
     * 设置 [开放平台接入标识]
     */
    public void setAccessId(String accessId) {
        this.accessId = accessId;
        this.modify("accessid", accessId);
    }

    /**
     * 设置 [接入平台]
     */
    public void setAccessName(String accessName) {
        this.accessName = accessName;
        this.modify("accessname", accessName);
    }

    /**
     * 设置 [接入平台类型]
     */
    public void setOpenType(String openType) {
        this.openType = openType;
        this.modify("open_type", openType);
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
        this.reset("tid");
        return super.copyTo(targetEntity, bIncEmpty);
    }
}


