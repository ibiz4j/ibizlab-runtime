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
 * 实体[消息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZMSGBODY", resultMap = "MsgBodyResultMap")
@ApiModel("消息")
public class MsgBody extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否出错
     */
    @DEField(defaultValue = "0")
    @TableField(value = "iserror")
    @JSONField(name = "is_error")
    @JsonProperty("is_error")
    @ApiModelProperty("是否出错")
    private Integer isError;
    /**
     * 是否发送
     */
    @DEField(defaultValue = "0")
    @TableField(value = "issend")
    @JSONField(name = "is_send")
    @JsonProperty("is_send")
    @ApiModelProperty("是否发送")
    private Integer isSend;
    /**
     * 消息标识
     */
    @DEField(isKeyField = true)
    @TableId(value = "msgid", type = IdType.ASSIGN_UUID)
    @JSONField(name = "msg_id")
    @JsonProperty("msg_id")
    @ApiModelProperty("消息标识")
    private String msgId;
    /**
     * 目标用户
     */
    @TableField(value = "tousers")
    @JSONField(name = "to_users")
    @JsonProperty("to_users")
    @ApiModelProperty("目标用户")
    private String toUsers;
    /**
     * 消息链接
     */
    @TableField(value = "msglink")
    @JSONField(name = "msg_link")
    @JsonProperty("msg_link")
    @ApiModelProperty("消息链接")
    private String msgLink;
    /**
     * 消息标题
     */
    @TableField(value = "subject")
    @JSONField(name = "subject")
    @JsonProperty("subject")
    @ApiModelProperty("消息标题")
    private String subject;
    /**
     * 消息内容
     */
    @TableField(value = "content")
    @JSONField(name = "content")
    @JsonProperty("content")
    @ApiModelProperty("消息内容")
    private String content;
    /**
     * 消息类型
     */
    @TableField(value = "msgtype")
    @JSONField(name = "msg_type")
    @JsonProperty("msg_type")
    @ApiModelProperty("消息类型")
    private Integer msgType;
    /**
     * 消息名称
     */
    @TableField(value = "msgname")
    @JSONField(name = "msg_name")
    @JsonProperty("msg_name")
    @ApiModelProperty("消息名称")
    private String msgName;
    /**
     * 消息模板标识
     */
    @TableField(value = "templateid")
    @JSONField(name = "template_id")
    @JsonProperty("template_id")
    @ApiModelProperty("消息模板标识")
    private String templateId;
    /**
     * 错误信息
     */
    @TableField(value = "errorinfo")
    @JSONField(name = "error_info")
    @JsonProperty("error_info")
    @ApiModelProperty("错误信息")
    private String errorInfo;
    /**
     * 用户数据
     */
    @TableField(value = "userdata")
    @JSONField(name = "user_data")
    @JsonProperty("user_data")
    @ApiModelProperty("用户数据")
    private String userData;
    /**
     * 消息模板参数
     */
    @DEField(name = "templparams")
    @TableField(value = "templparams")
    @JSONField(name = "template_params")
    @JsonProperty("template_params")
    @ApiModelProperty("消息模板参数")
    private String templateParams;
    /**
     * 用户数据2
     */
    @TableField(value = "userdata2")
    @JSONField(name = "user_data2")
    @JsonProperty("user_data2")
    @ApiModelProperty("用户数据2")
    private String userData2;
    /**
     * 消息链接(PC)
     */
    @DEField(name = "msglink_pc")
    @TableField(value = "msglink_pc")
    @JSONField(name = "msg_link_pc")
    @JsonProperty("msg_link_pc")
    @ApiModelProperty("消息链接(PC)")
    private String msgLinkPc;



    /**
     * 设置 [是否出错]
     */
    public void setIsError(Integer isError) {
        this.isError = isError;
        this.modify("iserror", isError);
    }

    /**
     * 设置 [是否发送]
     */
    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
        this.modify("issend", isSend);
    }

    /**
     * 设置 [目标用户]
     */
    public void setToUsers(String toUsers) {
        this.toUsers = toUsers;
        this.modify("tousers", toUsers);
    }

    /**
     * 设置 [消息链接]
     */
    public void setMsgLink(String msgLink) {
        this.msgLink = msgLink;
        this.modify("msglink", msgLink);
    }

    /**
     * 设置 [消息标题]
     */
    public void setSubject(String subject) {
        this.subject = subject;
        this.modify("subject", subject);
    }

    /**
     * 设置 [消息内容]
     */
    public void setContent(String content) {
        this.content = content;
        this.modify("content", content);
    }

    /**
     * 设置 [消息类型]
     */
    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
        this.modify("msgtype", msgType);
    }

    /**
     * 设置 [消息名称]
     */
    public void setMsgName(String msgName) {
        this.msgName = msgName;
        this.modify("msgname", msgName);
    }

    /**
     * 设置 [消息模板标识]
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
        this.modify("templateid", templateId);
    }

    /**
     * 设置 [错误信息]
     */
    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
        this.modify("errorinfo", errorInfo);
    }

    /**
     * 设置 [用户数据]
     */
    public void setUserData(String userData) {
        this.userData = userData;
        this.modify("userdata", userData);
    }

    /**
     * 设置 [消息模板参数]
     */
    public void setTemplateParams(String templateParams) {
        this.templateParams = templateParams;
        this.modify("templparams", templateParams);
    }

    /**
     * 设置 [用户数据2]
     */
    public void setUserData2(String userData2) {
        this.userData2 = userData2;
        this.modify("userdata2", userData2);
    }

    /**
     * 设置 [消息链接(PC)]
     */
    public void setMsgLinkPc(String msgLinkPc) {
        this.msgLinkPc = msgLinkPc;
        this.modify("msglink_pc", msgLinkPc);
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
        this.reset("msgid");
        return super.copyTo(targetEntity, bIncEmpty);
    }
}


