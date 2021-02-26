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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import cn.ibizlab.util.domain.DTOBase;
import cn.ibizlab.util.domain.DTOClient;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 服务DTO对象[MsgBodyDTO]
 */
@Data
@ApiModel("消息")
public class MsgBodyDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ISERROR]
     *
     */
    @JSONField(name = "is_error")
    @JsonProperty("is_error")
    @ApiModelProperty("是否出错")
    private Integer isError;

    /**
     * 属性 [ISSEND]
     *
     */
    @JSONField(name = "is_send")
    @JsonProperty("is_send")
    @ApiModelProperty("是否发送")
    private Integer isSend;

    /**
     * 属性 [MSGID]
     *
     */
    @JSONField(name = "msg_id")
    @JsonProperty("msg_id")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("消息标识")
    private String msgId;

    /**
     * 属性 [TOUSERS]
     *
     */
    @JSONField(name = "to_users")
    @JsonProperty("to_users")
    @Size(min = 0, max = 1000, message = "内容长度必须小于等于[1000]")
    @ApiModelProperty("目标用户")
    private String toUsers;

    /**
     * 属性 [MSGLINK]
     *
     */
    @JSONField(name = "msg_link")
    @JsonProperty("msg_link")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("消息链接")
    private String msgLink;

    /**
     * 属性 [SUBJECT]
     *
     */
    @JSONField(name = "subject")
    @JsonProperty("subject")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("消息标题")
    private String subject;

    /**
     * 属性 [CONTENT]
     *
     */
    @JSONField(name = "content")
    @JsonProperty("content")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("消息内容")
    private String content;

    /**
     * 属性 [MSGTYPE]
     *
     */
    @JSONField(name = "msg_type")
    @JsonProperty("msg_type")
    @ApiModelProperty("消息类型")
    private Integer msgType;

    /**
     * 属性 [MSGNAME]
     *
     */
    @JSONField(name = "msg_name")
    @JsonProperty("msg_name")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("消息名称")
    private String msgName;

    /**
     * 属性 [TEMPLATEID]
     *
     */
    @JSONField(name = "template_id")
    @JsonProperty("template_id")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("消息模板标识")
    private String templateId;

    /**
     * 属性 [ERRORINFO]
     *
     */
    @JSONField(name = "error_info")
    @JsonProperty("error_info")
    @Size(min = 0, max = 1048576, message = "内容长度必须小于等于[1048576]")
    @ApiModelProperty("错误信息")
    private String errorInfo;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "user_data")
    @JsonProperty("user_data")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("用户数据")
    private String userData;

    /**
     * 属性 [TEMPLPARAMS]
     *
     */
    @JSONField(name = "template_params")
    @JsonProperty("template_params")
    @Size(min = 0, max = 1048576, message = "内容长度必须小于等于[1048576]")
    @ApiModelProperty("消息模板参数")
    private String templateParams;

    /**
     * 属性 [USERDATA2]
     *
     */
    @JSONField(name = "user_data2")
    @JsonProperty("user_data2")
    @Size(min = 0, max = 2000, message = "内容长度必须小于等于[2000]")
    @ApiModelProperty("用户数据2")
    private String userData2;

    /**
     * 属性 [MSGLINK_PC]
     *
     */
    @JSONField(name = "msg_link_pc")
    @JsonProperty("msg_link_pc")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("消息链接(PC)")
    private String msgLinkPc;


    /**
     * 设置 [ISERROR]
     */
    public void setIsError(Integer  isError){
        this.isError = isError ;
        this.modify("iserror",isError);
    }

    /**
     * 设置 [ISSEND]
     */
    public void setIsSend(Integer  isSend){
        this.isSend = isSend ;
        this.modify("issend",isSend);
    }

    /**
     * 设置 [TOUSERS]
     */
    public void setToUsers(String  toUsers){
        this.toUsers = toUsers ;
        this.modify("tousers",toUsers);
    }

    /**
     * 设置 [MSGLINK]
     */
    public void setMsgLink(String  msgLink){
        this.msgLink = msgLink ;
        this.modify("msglink",msgLink);
    }

    /**
     * 设置 [SUBJECT]
     */
    public void setSubject(String  subject){
        this.subject = subject ;
        this.modify("subject",subject);
    }

    /**
     * 设置 [CONTENT]
     */
    public void setContent(String  content){
        this.content = content ;
        this.modify("content",content);
    }

    /**
     * 设置 [MSGTYPE]
     */
    public void setMsgType(Integer  msgType){
        this.msgType = msgType ;
        this.modify("msgtype",msgType);
    }

    /**
     * 设置 [MSGNAME]
     */
    public void setMsgName(String  msgName){
        this.msgName = msgName ;
        this.modify("msgname",msgName);
    }

    /**
     * 设置 [TEMPLATEID]
     */
    public void setTemplateId(String  templateId){
        this.templateId = templateId ;
        this.modify("templateid",templateId);
    }

    /**
     * 设置 [ERRORINFO]
     */
    public void setErrorInfo(String  errorInfo){
        this.errorInfo = errorInfo ;
        this.modify("errorinfo",errorInfo);
    }

    /**
     * 设置 [USERDATA]
     */
    public void setUserData(String  userData){
        this.userData = userData ;
        this.modify("userdata",userData);
    }

    /**
     * 设置 [TEMPLPARAMS]
     */
    public void setTemplateParams(String  templateParams){
        this.templateParams = templateParams ;
        this.modify("templparams",templateParams);
    }

    /**
     * 设置 [USERDATA2]
     */
    public void setUserData2(String  userData2){
        this.userData2 = userData2 ;
        this.modify("userdata2",userData2);
    }

    /**
     * 设置 [MSGLINK_PC]
     */
    public void setMsgLinkPc(String  msgLinkPc){
        this.msgLinkPc = msgLinkPc ;
        this.modify("msglink_pc",msgLinkPc);
    }


}


