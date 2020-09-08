package cn.ibizlab.api.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.util.domain.DTOBase;
import cn.ibizlab.util.domain.DTOClient;
import lombok.Data;

/**
 * 服务DTO对象[MsgTemplateDTO]
 */
@Data
public class MsgTemplateDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [TID]
     *
     */
    @JSONField(name = "tid")
    @JsonProperty("tid")
    private String tid;

    /**
     * 属性 [TEMPLATE_NAME]
     *
     */
    @JSONField(name = "template_name")
    @JsonProperty("template_name")
    private String templateName;

    /**
     * 属性 [TEMPLATE_TYPE]
     *
     */
    @JSONField(name = "template_type")
    @JsonProperty("template_type")
    private String templateType;

    /**
     * 属性 [CONTENT]
     *
     */
    @JSONField(name = "content")
    @JsonProperty("content")
    private String content;

    /**
     * 属性 [TEMPLATE_ID]
     *
     */
    @JSONField(name = "template_id")
    @JsonProperty("template_id")
    private String templateId;

    /**
     * 属性 [TEMPLATE_URL]
     *
     */
    @JSONField(name = "template_url")
    @JsonProperty("template_url")
    private String templateUrl;

    /**
     * 属性 [ACCESSID]
     *
     */
    @JSONField(name = "access_id")
    @JsonProperty("access_id")
    private String accessId;

    /**
     * 属性 [ACCESSNAME]
     *
     */
    @JSONField(name = "access_name")
    @JsonProperty("access_name")
    private String accessName;

    /**
     * 属性 [OPEN_TYPE]
     *
     */
    @JSONField(name = "open_type")
    @JsonProperty("open_type")
    private String openType;


    /**
     * 设置 [TEMPLATE_NAME]
     */
    public void setTemplateName(String  templateName){
        this.templateName = templateName ;
        this.modify("template_name",templateName);
    }

    /**
     * 设置 [TEMPLATE_TYPE]
     */
    public void setTemplateType(String  templateType){
        this.templateType = templateType ;
        this.modify("template_type",templateType);
    }

    /**
     * 设置 [CONTENT]
     */
    public void setContent(String  content){
        this.content = content ;
        this.modify("content",content);
    }

    /**
     * 设置 [TEMPLATE_ID]
     */
    public void setTemplateId(String  templateId){
        this.templateId = templateId ;
        this.modify("template_id",templateId);
    }

    /**
     * 设置 [TEMPLATE_URL]
     */
    public void setTemplateUrl(String  templateUrl){
        this.templateUrl = templateUrl ;
        this.modify("template_url",templateUrl);
    }

    /**
     * 设置 [ACCESSID]
     */
    public void setAccessId(String  accessId){
        this.accessId = accessId ;
        this.modify("accessid",accessId);
    }

    /**
     * 设置 [ACCESSNAME]
     */
    public void setAccessName(String  accessName){
        this.accessName = accessName ;
        this.modify("accessname",accessName);
    }

    /**
     * 设置 [OPEN_TYPE]
     */
    public void setOpenType(String  openType){
        this.openType = openType ;
        this.modify("open_type",openType);
    }


}

