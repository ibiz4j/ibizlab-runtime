package cn.ibizlab.util.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * 消息对象
 */
@Data
public class MsgBody{
    /**
     * 接收用户
     */
    @JSONField(name = "to_users")
    @JsonProperty("to_users")
    private String toUsers;
    /**
     * 标题
     */
    @JSONField(name = "subject")
    @JsonProperty("subject")
    private String subject;
    /**
     * 内容
     */
    @JSONField(name = "content")
    @JsonProperty("content")
    private String content;
    /**
     * 类型
     */
    @JSONField(name = "msg_type")
    @JsonProperty("msg_type")
    private Integer msgType;
    /**
     * 模板标识
     */
    @JSONField(name = "template_id")
    @JsonProperty("template_id")
    private String templateId;
    /**
     * 模板参数
     */
    @JSONField(name = "template_params")
    @JsonProperty("template_params")
    private String templateParams;
    /**
     * 消息链接
     */
    @JSONField(name = "msg_link")
    @JsonProperty("msg_link")
    private String msgLink;
    /**
     * 消息链接（pc）
     */
    @JSONField(name = "msg_link_pc")
    @JsonProperty("msg_link_pc")
    private String msgLinkPc;

}

