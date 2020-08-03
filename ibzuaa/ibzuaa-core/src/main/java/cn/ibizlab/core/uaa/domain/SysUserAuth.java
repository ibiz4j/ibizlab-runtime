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
import cn.ibizlab.util.annotation.Audit;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;

/**
 * 实体[实体]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZUSERAUTH",resultMap = "SysUserAuthResultMap")
public class SysUserAuth extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @DEField(name = "authid" , isKeyField=true)
    @TableId(value= "authid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;
    /**
     * 用户标识
     */
    @TableField(value = "userid")
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;
    /**
     * 认证类型
     */
    @DEField(name = "identity_type")
    @TableField(value = "identity_type")
    @JSONField(name = "identity_type")
    @JsonProperty("identity_type")
    private String identityType;
    /**
     * 认证标识
     */
    @TableField(value = "identifier")
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    private String identifier;
    /**
     * 凭据
     */
    @TableField(value = "credential")
    @JSONField(name = "credential")
    @JsonProperty("credential")
    private String credential;

    /**
     * 用户
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.uaa.domain.SysUser user;



    /**
     * 设置 [用户标识]
     */
    public void setUserid(String userid){
        this.userid = userid ;
        this.modify("userid",userid);
    }

    /**
     * 设置 [认证类型]
     */
    public void setIdentityType(String identityType){
        this.identityType = identityType ;
        this.modify("identity_type",identityType);
    }

    /**
     * 设置 [认证标识]
     */
    public void setIdentifier(String identifier){
        this.identifier = identifier ;
        this.modify("identifier",identifier);
    }

    /**
     * 设置 [凭据]
     */
    public void setCredential(String credential){
        this.credential = credential ;
        this.modify("credential",credential);
    }


    /**
     * 获取 [标识]
     */
    public String getId(){
        if(ObjectUtils.isEmpty(id)){
            id=(String)getDefaultKey(true);
        }
        return id;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getUserid()))&&(!ObjectUtils.isEmpty(this.getIdentityType())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getUserid(),this.getIdentityType()).getBytes());
        return null;
    }
}


