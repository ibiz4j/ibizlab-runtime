package cn.ibizlab.core.uaa.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;

import cn.ibizlab.core.uaa.domain.SysApp;
import cn.ibizlab.core.uaa.extensions.domain.SysStructure;
import cn.ibizlab.core.uaa.domain.handlers.SysAppTypeHandler;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
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
import lombok.Data;
import org.springframework.data.annotation.Transient;


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;
import org.springframework.util.StringUtils;

/**
 * 实体[实体]
 */
@Data
@TableName(value = "IBZPSSYSTEM",resultMap = "SysPSSystemResultMap")
public class SysPSSystem extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系统标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pssystemid",type=IdType.UUID)
    @JSONField(name = "pssystemid")
    @JsonProperty("pssystemid")
    private String pssystemid;
    /**
     * 系统名称
     */
    @TableField(value = "pssystemname")
    @JSONField(name = "pssystemname")
    @JsonProperty("pssystemname")
    private String pssystemname;
    /**
     * 结构
     */
    @TableField(value = "sysstructure",typeHandler = JacksonTypeHandler.class)
    @JSONField(name = "sysstructure")
    @JsonProperty("sysstructure")
    private SysStructure sysstructure;


    /**
     * 结构
     */
    @TableField(value = "apps",typeHandler = SysAppTypeHandler.class)
    @JSONField(name = "apps")
    @JsonProperty("apps")
    private List<SysApp> apps;

    /**
     * 属性 [MD5CHECK]
     *
     */
    @TableField(value = "md5check")
    @JSONField(name = "md5check")
    @JsonProperty("md5check")
    private String md5check;

    /**
     * 属性 [SHOWORDER]
     *
     */
    @TableField(value = "showorder")
    @JSONField(name = "showorder")
    @JsonProperty("showorder")
    private Integer showorder;


    /**
     * 设置 [系统名称]
     */
    public void setPssystemname(String pssystemname){
        this.pssystemname = pssystemname ;
        this.modify("pssystemname",pssystemname);
    }
    /**
     * 设置 [结构]
     */
    public void setSysstructure(SysStructure sysstructure){
        this.sysstructure = sysstructure ;
        this.modify("sysstructure",sysstructure);
    }

    /**
     * 设置 [APPS]
     */
    public void setApps(List<SysApp>  apps){
        this.apps = apps ;
        this.modify("apps",apps);
    }

    /**
     * 设置 [MD5CHECK]
     */
    public void setMd5check(String  md5check){
        this.md5check = md5check ;
        this.modify("md5check",md5check);
    }

    /**
     * 设置 [SHOWORDER]
     */
    public void setShoworder(Integer  showorder){
        this.showorder = showorder ;
        this.modify("showorder",showorder);
    }


    public SysStructure getSysstructure()
    {
        if (this.sysstructure!=null )
        {
            if (!StringUtils.isEmpty(this.getPssystemid()))
                this.sysstructure.setSystemid(this.getPssystemid());
            if (!StringUtils.isEmpty(this.getPssystemname()))
                this.sysstructure.setSystemname(this.getPssystemname());
            else
                this.sysstructure.setSystemname(this.getPssystemid());
        }
        return this.sysstructure;
    }

}


