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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String id;

    /**
     * 属性 [USERID]
     *
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String userid;

    /**
     * 属性 [IDENTITY_TYPE]
     *
     */
    @JSONField(name = "identity_type")
    @JsonProperty("identity_type")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String identityType;

    /**
     * 属性 [IDENTIFIER]
     *
     */
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @Size(min = 0, max = 200, message = "内容长度必须小于等于[200]")
    private String identifier;

    /**
     * 属性 [CREDENTIAL]
     *
     */
    @JSONField(name = "credential")
    @JsonProperty("credential")
    @Size(min = 0, max = 500, message = "内容长度必须小于等于[500]")
    private String credential;

    /**
     * 属性 [USERNAME]
     *
     */
    @JSONField(name = "username")
    @JsonProperty("username")
    @Size(min = 0, max = 200, message = "内容长度必须小于等于[200]")
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


