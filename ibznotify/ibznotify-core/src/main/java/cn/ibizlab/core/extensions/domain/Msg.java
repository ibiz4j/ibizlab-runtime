package cn.ibizlab.core.extensions.domain;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * 消息对象：title.content.url参数只适用于钉钉消息，
 * 以传入的参数内容覆盖模板中的内容；
 * 其余类型消息则以模板内容为准。
 */
@Data
@Builder
public class Msg {

    /**
     * 模板标识
     */
    @NotBlank(message="模板标识不能为空")
    private String templateid;
    /**
     * 发送消息类型
     */
    @NotNull(message="模板类型不能为空")
    private int msgtypes;
    /**
     * 消息接收用户
     */
    @NotBlank(message="用户标识不能为空")
    private String userids;
    /**
     * 消息标题
      */
    private String title;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息链接
     */
    private String url;
    /**
     * 待办标识
     */
    private String recordid;
    /**
     * 消息模板参数
     */
    private Map templparams;
}
