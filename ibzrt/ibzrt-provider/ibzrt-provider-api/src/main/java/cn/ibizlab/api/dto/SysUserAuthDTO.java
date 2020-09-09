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
import cn.ibizlab.util.domain.DTOClient;
import lombok.Data;

/**
 * 服务DTO对象[SysUserAuthDTO]
 */
@Data
public class SysUserAuthDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [AUTHID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 属性 [USERID]
     *
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 属性 [IDENTITY_TYPE]
     *
     */
    @JSONField(name = "identity_type")
    @JsonProperty("identity_type")
    private String identityType;

    /**
     * 属性 [IDENTIFIER]
     *
     */
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    private String identifier;

    /**
     * 属性 [CREDENTIAL]
     *
     */
    @JSONField(name = "credential")
    @JsonProperty("credential")
    private String credential;

    /**
     * 属性 [USERNAME]
     *
     */
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;


    /**
     * 设置 [USERID]
     */
    public void setUserid(String  userid){
        this.userid = userid ;
        this.modify("userid",userid);
    }

    /**
     * 设置 [IDENTITY_TYPE]
     */
    public void setIdentityType(String  identityType){
        this.identityType = identityType ;
        this.modify("identity_type",identityType);
    }

    /**
     * 设置 [IDENTIFIER]
     */
    public void setIdentifier(String  identifier){
        this.identifier = identifier ;
        this.modify("identifier",identifier);
    }

    /**
     * 设置 [CREDENTIAL]
     */
    public void setCredential(String  credential){
        this.credential = credential ;
        this.modify("credential",credential);
    }


}

