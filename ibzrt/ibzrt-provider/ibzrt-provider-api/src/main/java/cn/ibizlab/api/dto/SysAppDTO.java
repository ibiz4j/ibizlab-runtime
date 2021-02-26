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
 * 服务DTO对象[SysAppDTO]
 */
@Data
@ApiModel("应用")
public class SysAppDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [APPID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("应用标识")
    private String id;

    /**
     * 属性 [APPNAME]
     *
     */
    @JSONField(name = "label")
    @JsonProperty("label")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("应用名")
    private String label;

    /**
     * 属性 [PSSYSTEMID]
     *
     */
    @JSONField(name = "systemid")
    @JsonProperty("systemid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("系统标识")
    private String systemid;

    /**
     * 属性 [FULLNAME]
     *
     */
    @JSONField(name = "fullname")
    @JsonProperty("fullname")
    @Size(min = 0, max = 200, message = "内容长度必须小于等于[200]")
    @ApiModelProperty("全称")
    private String fullname;

    /**
     * 属性 [APPTYPE]
     *
     */
    @JSONField(name = "type")
    @JsonProperty("type")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("类型")
    private String type;

    /**
     * 属性 [APPGROUP]
     *
     */
    @JSONField(name = "group")
    @JsonProperty("group")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("分组")
    private String group;

    /**
     * 属性 [ICON]
     *
     */
    @JSONField(name = "icon")
    @JsonProperty("icon")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 属性 [VISABLED]
     *
     */
    @JSONField(name = "visabled")
    @JsonProperty("visabled")
    @ApiModelProperty("可见")
    private Integer visabled;

    /**
     * 属性 [ADDR]
     *
     */
    @JSONField(name = "addr")
    @JsonProperty("addr")
    @Size(min = 0, max = 300, message = "内容长度必须小于等于[300]")
    @ApiModelProperty("地址")
    private String addr;


    /**
     * 设置 [APPNAME]
     */
    public void setLabel(String  label){
        this.label = label ;
        this.modify("appname",label);
    }

    /**
     * 设置 [PSSYSTEMID]
     */
    public void setSystemid(String  systemid){
        this.systemid = systemid ;
        this.modify("pssystemid",systemid);
    }

    /**
     * 设置 [FULLNAME]
     */
    public void setFullname(String  fullname){
        this.fullname = fullname ;
        this.modify("fullname",fullname);
    }

    /**
     * 设置 [APPTYPE]
     */
    public void setType(String  type){
        this.type = type ;
        this.modify("apptype",type);
    }

    /**
     * 设置 [APPGROUP]
     */
    public void setGroup(String  group){
        this.group = group ;
        this.modify("appgroup",group);
    }

    /**
     * 设置 [ICON]
     */
    public void setIcon(String  icon){
        this.icon = icon ;
        this.modify("icon",icon);
    }

    /**
     * 设置 [VISABLED]
     */
    public void setVisabled(Integer  visabled){
        this.visabled = visabled ;
        this.modify("visabled",visabled);
    }

    /**
     * 设置 [ADDR]
     */
    public void setAddr(String  addr){
        this.addr = addr ;
        this.modify("addr",addr);
    }


}


