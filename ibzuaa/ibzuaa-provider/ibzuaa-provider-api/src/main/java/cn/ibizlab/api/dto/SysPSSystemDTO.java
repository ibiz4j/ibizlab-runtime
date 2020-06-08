package cn.ibizlab.api.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;

import cn.ibizlab.core.uaa.domain.SysApp;
import cn.ibizlab.core.uaa.extensions.domain.SysStructure;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.util.domain.DTOBase;
import lombok.Data;

/**
 * 服务DTO对象[SysPSSystemDTO]
 */
@Data
public class SysPSSystemDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PSSYSTEMID]
     *
     */
    @JSONField(name = "pssystemid")
    @JsonProperty("pssystemid")
    private String pssystemid;

    /**
     * 属性 [PSSYSTEMNAME]
     *
     */
    @JSONField(name = "pssystemname")
    @JsonProperty("pssystemname")
    private String pssystemname;

    /**
     * 属性 [SYSSTRUCTURE]
     *
     */
    @JSONField(name = "sysstructure")
    @JsonProperty("sysstructure")
    private SysStructure sysstructure;

    /**
     * 属性 [APPS]
     *
     */
    @JSONField(name = "apps")
    @JsonProperty("apps")
    private List<SysApp> apps;

    /**
     * 属性 [MD5CHECK]
     *
     */
    @JSONField(name = "md5check")
    @JsonProperty("md5check")
    private String md5check;

    /**
     * 属性 [SHOWORDER]
     *
     */
    @JSONField(name = "showorder")
    @JsonProperty("showorder")
    private Integer showorder;


    /**
     * 设置 [PSSYSTEMNAME]
     */
    public void setPssystemname(String  pssystemname){
        this.pssystemname = pssystemname ;
        this.modify("pssystemname",pssystemname);
    }

    /**
     * 设置 [SYSSTRUCTURE]
     */
    public void setSysstructure(SysStructure  sysstructure){
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


}

