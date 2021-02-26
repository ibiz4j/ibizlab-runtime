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
 * ServiceApi [角色权限关系] 对象
 */
@Data
@ApiModel("角色权限关系")
public class SysRolePermission extends EntityClient implements Serializable {

    /**
     * 角色权限关系表标识
     */
    @DEField(name = "sys_role_permissionid" , isKeyField = true)
    @JSONField(name = "rolepermissionid")
    @JsonProperty("rolepermissionid")
    @ApiModelProperty("角色权限关系表标识")
    private String rolepermissionid;

    /**
     * 角色表标识
     */
    @DEField(name = "sys_roleid")
    @JSONField(name = "roleid")
    @JsonProperty("roleid")
    @ApiModelProperty("角色表标识")
    private String roleid;

    /**
     * 角色名称
     */
    @JSONField(name = "rolename")
    @JsonProperty("rolename")
    @ApiModelProperty("角色名称")
    private String rolename;

    /**
     * 权限表标识
     */
    @DEField(name = "sys_permissionid")
    @JSONField(name = "permissionid")
    @JsonProperty("permissionid")
    @ApiModelProperty("权限表标识")
    private String permissionid;

    /**
     * 权限名称
     */
    @JSONField(name = "permissionname")
    @JsonProperty("permissionname")
    @ApiModelProperty("权限名称")
    private String permissionname;

    /**
     * 权限类型
     */
    @JSONField(name = "permissiontype")
    @JsonProperty("permissiontype")
    @ApiModelProperty("权限类型")
    private String permissiontype;

    /**
     * 权限类型
     */
    @JSONField(name = "permissionenable")
    @JsonProperty("permissionenable")
    @ApiModelProperty("权限类型")
    private Integer permissionenable;

    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @ApiModelProperty("建立时间")
    private Timestamp createdate;

    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @ApiModelProperty("更新时间")
    private Timestamp updatedate;


    /**
     * 资源
     */
    @JSONField(name = "permission")
    @JsonProperty("permission")
    private cn.ibizlab.core.uaa.domain.SysPermission permission;

    /**
     * 角色
     */
    @JSONField(name = "role")
    @JsonProperty("role")
    private cn.ibizlab.core.uaa.domain.SysRole role;




    /**
     * 设置 [角色表标识]
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid ;
        this.modify("sys_roleid",roleid);
    }

    /**
     * 设置 [权限表标识]
     */
    public void setPermissionid(String permissionid) {
        this.permissionid = permissionid ;
        this.modify("sys_permissionid",permissionid);
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
        this.reset("sys_role_permissionid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


