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
 * 服务DTO对象[SysAppDTO]
 */
@Data
public class SysAppDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [APPID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 属性 [APPNAME]
     *
     */
    @JSONField(name = "label")
    @JsonProperty("label")
    private String label;

    /**
     * 属性 [PSSYSTEMID]
     *
     */
    @JSONField(name = "systemid")
    @JsonProperty("systemid")
    private String systemid;

    /**
     * 属性 [FULLNAME]
     *
     */
    @JSONField(name = "fullname")
    @JsonProperty("fullname")
    private String fullname;

    /**
     * 属性 [APPTYPE]
     *
     */
    @JSONField(name = "type")
    @JsonProperty("type")
    private String type;

    /**
     * 属性 [APPGROUP]
     *
     */
    @JSONField(name = "group")
    @JsonProperty("group")
    private String group;

    /**
     * 属性 [ICON]
     *
     */
    @JSONField(name = "icon")
    @JsonProperty("icon")
    private String icon;

    /**
     * 属性 [VISABLED]
     *
     */
    @JSONField(name = "visabled")
    @JsonProperty("visabled")
    private Integer visabled;

    /**
     * 属性 [ADDR]
     *
     */
    @JSONField(name = "addr")
    @JsonProperty("addr")
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

