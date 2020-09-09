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

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [账号绑定] 对象
 */
@Data
public class SysUserAuth extends EntityClient implements Serializable {

    /**
     * 标识
     */
    @DEField(name = "authid" , isKeyField=true)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 用户标识
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 认证类型
     */
    @DEField(name = "identity_type")
    @JSONField(name = "identity_type")
    @JsonProperty("identity_type")
    private String identityType;

    /**
     * 认证标识
     */
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    private String identifier;

    /**
     * 凭据
     */
    @JSONField(name = "credential")
    @JsonProperty("credential")
    private String credential;

    /**
     * 人员
     */
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;


    /**
     * 用户
     */
    @JSONField(name = "user")
    @JsonProperty("user")
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


}


