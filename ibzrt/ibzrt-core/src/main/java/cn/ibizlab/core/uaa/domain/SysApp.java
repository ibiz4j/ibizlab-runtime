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
import cn.ibizlab.util.helper.DataObject;
import cn.ibizlab.util.enums.DupCheck;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;
import cn.ibizlab.util.annotation.Audit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [应用] 对象
 */
@Data
@ApiModel("应用")
public class SysApp extends EntityClient implements Serializable {

    /**
     * 应用标识
     */
    @DEField(name = "appid" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty("应用标识")
    private String id;

    /**
     * 应用名
     */
    @DEField(name = "appname")
    @JSONField(name = "label")
    @JsonProperty("label")
    @ApiModelProperty("应用名")
    private String label;

    /**
     * 系统标识
     */
    @DEField(name = "pssystemid")
    @JSONField(name = "systemid")
    @JsonProperty("systemid")
    @ApiModelProperty("系统标识")
    private String systemid;

    /**
     * 全称
     */
    @JSONField(name = "fullname")
    @JsonProperty("fullname")
    @ApiModelProperty("全称")
    private String fullname;

    /**
     * 类型
     */
    @DEField(name = "apptype")
    @JSONField(name = "type")
    @JsonProperty("type")
    @ApiModelProperty("类型")
    private String type;

    /**
     * 分组
     */
    @DEField(name = "appgroup")
    @JSONField(name = "group")
    @JsonProperty("group")
    @ApiModelProperty("分组")
    private String group;

    /**
     * 图标
     */
    @JSONField(name = "icon")
    @JsonProperty("icon")
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 可见
     */
    @JSONField(name = "visabled")
    @JsonProperty("visabled")
    @ApiModelProperty("可见")
    private Integer visabled;

    /**
     * 地址
     */
    @JSONField(name = "addr")
    @JsonProperty("addr")
    @ApiModelProperty("地址")
    private String addr;


    /**
     * 
     */
    @JSONField(name = "system")
    @JsonProperty("system")
    private cn.ibizlab.core.uaa.domain.SysPSSystem system;




    /**
     * 设置 [应用名]
     */
    public void setLabel(String label) {
        this.label = label ;
        this.modify("appname",label);
    }

    /**
     * 设置 [系统标识]
     */
    public void setSystemid(String systemid) {
        this.systemid = systemid ;
        this.modify("pssystemid",systemid);
    }

    /**
     * 设置 [全称]
     */
    public void setFullname(String fullname) {
        this.fullname = fullname ;
        this.modify("fullname",fullname);
    }

    /**
     * 设置 [类型]
     */
    public void setType(String type) {
        this.type = type ;
        this.modify("apptype",type);
    }

    /**
     * 设置 [分组]
     */
    public void setGroup(String group) {
        this.group = group ;
        this.modify("appgroup",group);
    }

    /**
     * 设置 [图标]
     */
    public void setIcon(String icon) {
        this.icon = icon ;
        this.modify("icon",icon);
    }

    /**
     * 设置 [可见]
     */
    public void setVisabled(Integer visabled) {
        this.visabled = visabled ;
        this.modify("visabled",visabled);
    }

    /**
     * 设置 [地址]
     */
    public void setAddr(String addr) {
        this.addr = addr ;
        this.modify("addr",addr);
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
        this.reset("appid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


