package cn.ibizlab.core.uaa.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
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


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;


/**
 * 实体[权限/资源]
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "IBZPERMISSION",resultMap = "SysPermissionResultMap")
public class SysPermission extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源标识
     */
    @DEField(name = "sys_permissionid" , isKeyField=true)
    @TableId(value= "sys_permissionid",type=IdType.UUID)
    @JSONField(name = "permissionid")
    @JsonProperty("permissionid")
    private String permissionid;
    /**
     * 资源名称
     */
    @DEField(name = "sys_permissionname")
    @TableField(value = "sys_permissionname")
    @JSONField(name = "permissionname")
    @JsonProperty("permissionname")
    private String permissionname;
    /**
     * 资源类别
     */
    @TableField(value = "permissiontype")
    @JSONField(name = "permissiontype")
    @JsonProperty("permissiontype")
    private String permissiontype;
    /**
     * 系统
     */
    @TableField(value = "pssystemid")
    @JSONField(name = "pssystemid")
    @JsonProperty("pssystemid")
    private String pssystemid;
    /**
     * 逻辑有效
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;



    /**
     * 设置 [资源名称]
     */
    public void setPermissionname(String permissionname){
        this.permissionname = permissionname ;
        this.modify("sys_permissionname",permissionname);
    }
    /**
     * 设置 [资源类别]
     */
    public void setPermissiontype(String permissiontype){
        this.permissiontype = permissiontype ;
        this.modify("permissiontype",permissiontype);
    }
    /**
     * 设置 [系统]
     */
    public void setPssystemid(String pssystemid){
        this.pssystemid = pssystemid ;
        this.modify("pssystemid",pssystemid);
    }

}


