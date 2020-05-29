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
import lombok.Data;

/**
 * 服务DTO对象[SysPermissionDTO]
 */
@Data
public class SysPermissionDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SYS_PERMISSIONID]
     *
     */
    @JSONField(name = "permissionid")
    @JsonProperty("permissionid")
    private String permissionid;

    /**
     * 属性 [SYS_PERMISSIONNAME]
     *
     */
    @JSONField(name = "permissionname")
    @JsonProperty("permissionname")
    private String permissionname;

    /**
     * 属性 [PERMISSIONTYPE]
     *
     */
    @JSONField(name = "permissiontype")
    @JsonProperty("permissiontype")
    private String permissiontype;

    /**
     * 属性 [PSSYSTEMID]
     *
     */
    @JSONField(name = "pssystemid")
    @JsonProperty("pssystemid")
    private String pssystemid;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;


    /**
     * 设置 [SYS_PERMISSIONNAME]
     */
    public void setPermissionname(String  permissionname){
        this.permissionname = permissionname ;
        this.modify("sys_permissionname",permissionname);
    }

    /**
     * 设置 [PERMISSIONTYPE]
     */
    public void setPermissiontype(String  permissiontype){
        this.permissiontype = permissiontype ;
        this.modify("permissiontype",permissiontype);
    }

    /**
     * 设置 [PSSYSTEMID]
     */
    public void setPssystemid(String  pssystemid){
        this.pssystemid = pssystemid ;
        this.modify("pssystemid",pssystemid);
    }


}

