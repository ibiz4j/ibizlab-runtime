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
 * 实体[用户角色关系]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZUSER_ROLE",resultMap = "SysUserRoleResultMap")
public class SysUserRole extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户角色关系标识
     */
    @DEField(name = "sys_user_roleid" , isKeyField=true)
    @TableId(value= "sys_user_roleid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "userroleid")
    @JsonProperty("userroleid")
    private String userroleid;
    /**
     * 角色标识
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
     * 用户标识
     */
    @DEField(name = "sys_userid")
    @TableField(value = "sys_userid")
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;
    /**
     * 用户名称
     */
    @TableField(exist = false)
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;
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
     * 角色
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.uaa.domain.SysRole role;

    /**
     * 用户
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.uaa.domain.SysUser user;



    /**
     * 设置 [角色标识]
     */
    public void setRoleid(String roleid){
        this.roleid = roleid ;
        this.modify("sys_roleid",roleid);
    }

    /**
     * 设置 [用户标识]
     */
    public void setUserid(String userid){
        this.userid = userid ;
        this.modify("sys_userid",userid);
    }


    /**
     * 获取 [用户角色关系标识]
     */
    public String getUserroleid(){
        if(ObjectUtils.isEmpty(userroleid)){
            userroleid=(String)getDefaultKey(true);
        }
        return userroleid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getRoleid()))&&(!ObjectUtils.isEmpty(this.getUserid())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getRoleid(),this.getUserid()).getBytes());
        return null;
    }
}


