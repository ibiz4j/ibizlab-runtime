package cn.ibizlab.core.uaa.domain;

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


/**
 * [应用] 对象
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SysApp extends EntityBase implements Serializable {

    /**
     * 应用标识
     */
    @DEField(name = "appid" , isKeyField=true)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 应用名
     */
    @DEField(name = "appname")
    @JSONField(name = "label")
    @JsonProperty("label")
    private String label;

    /**
     * 系统标识
     */
    @DEField(name = "pssystemid")
    @JSONField(name = "systemId")
    @JsonProperty("systemId")
    private String systemid;

    /**
     * 全称
     */
    @JSONField(name = "fullName")
    @JsonProperty("fullName")
    private String fullname;

    /**
     * 类型
     */
    @DEField(name = "apptype")
    @JSONField(name = "type")
    @JsonProperty("type")
    private String type;

    /**
     * 分组
     */
    @DEField(name = "appgroup")
    @JSONField(name = "group")
    @JsonProperty("group")
    private String group;

    /**
     * 图标
     */
    @JSONField(name = "icon")
    @JsonProperty("icon")
    private String icon;

    /**
     * 可见
     */
    @JSONField(name = "visabled")
    @JsonProperty("visabled")
    private Integer visabled;

    /**
     * 地址
     */
    @JSONField(name = "addr")
    @JsonProperty("addr")
    private String addr;


    /**
     * 
     */
    @JSONField(name = "system")
    @JsonProperty("system")
    private cn.ibizlab.core.uaa.domain.SysPSSystem system;



}


