package cn.ibizlab.core.uaa.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;

import cn.ibizlab.core.uaa.extensions.domain.SysStructure;
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

    public SysStructure getSysstructure()
    {
        if (this.sysstructure!=null )
        {
            if (!StringUtils.isEmpty(this.getPssystemid()))
                this.sysstructure.setSystemid(this.getPssystemid());
        }
        return this.sysstructure;
    }

}


