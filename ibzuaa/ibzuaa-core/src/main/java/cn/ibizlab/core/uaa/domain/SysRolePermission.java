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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;

/**
 * 实体[角色权限关系]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZROLE_PERMISSION",resultMap = "SysRolePermissionResultMap")
public class SysRolePermission extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色权限关系表标识
     */
    @DEField(name = "sys_role_permissionid" , isKeyField=true)
    @TableId(value= "sys_role_permissionid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "rolepermissionid")
    @JsonProperty("rolepermissionid")
    private String rolepermissionid;
    /**
     * 角色表标识
     */
    @DEField(name = "sys_roleid")
    @TableField(value = "sys_roleid")
    @JSONField(name = "roleid")
    @JsonProperty("roleid")
    private String roleid;
    /**
     * 角色名称
     */
    @TableField(exist = false)
    @JSONField(name = "rolename")
    @JsonProperty("rolename")
    private String rolename;
    /**
     * 权限表标识
     */
    @DEField(name = "sys_permissionid")
    @TableField(value = "sys_permissionid")
    @JSONField(name = "permissionid")
    @JsonProperty("permissionid")
    private String permissionid;
    /**
     * 权限名称
     */
    @TableField(exist = false)
    @JSONField(name = "permissionname")
    @JsonProperty("permissionname")
    private String permissionname;
    /**
     * 权限类型
     */
    @TableField(exist = false)
    @JSONField(name = "permissiontype")
    @JsonProperty("permissiontype")
    private String permissiontype;
    /**
     * 权限类型
     */
    @TableField(exist = false)
    @JSONField(name = "permissionenable")
    @JsonProperty("permissionenable")
    private Integer permissionenable;
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
     * 资源
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.uaa.domain.SysPermission permission;

    /**
     * 角色
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.uaa.domain.SysRole role;



    /**
     * 设置 [角色表标识]
     */
    public void setRoleid(String roleid){
        this.roleid = roleid ;
        this.modify("sys_roleid",roleid);
    }

    /**
     * 设置 [权限表标识]
     */
    public void setPermissionid(String permissionid){
        this.permissionid = permissionid ;
        this.modify("sys_permissionid",permissionid);
    }


    /**
     * 获取 [角色权限关系表标识]
     */
    public String getRolepermissionid(){
        if(ObjectUtils.isEmpty(rolepermissionid)){
            rolepermissionid=(String)getDefaultKey(true);
        }
        return rolepermissionid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getRoleid()))&&(!ObjectUtils.isEmpty(this.getPermissionid())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getRoleid(),this.getPermissionid()).getBytes());
        return null;
    }
}


