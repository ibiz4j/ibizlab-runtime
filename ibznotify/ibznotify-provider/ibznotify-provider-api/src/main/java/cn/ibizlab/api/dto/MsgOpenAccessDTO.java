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
 * 服务DTO对象[MsgOpenAccessDTO]
 */
@Data
public class MsgOpenAccessDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ACCESSID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 属性 [ACCESSNAME]
     *
     */
    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;

    /**
     * 属性 [OPEN_TYPE]
     *
     */
    @JSONField(name = "open_type")
    @JsonProperty("open_type")
    private String openType;

    /**
     * 属性 [ACCESS_KEY]
     *
     */
    @JSONField(name = "access_key")
    @JsonProperty("access_key")
    private String accessKey;

    /**
     * 属性 [SECRET_KEY]
     *
     */
    @JSONField(name = "secret_key")
    @JsonProperty("secret_key")
    private String secretKey;

    /**
     * 属性 [REGION_ID]
     *
     */
    @JSONField(name = "region_id")
    @JsonProperty("region_id")
    private String regionId;

    /**
     * 属性 [ACCESS_TOKEN]
     *
     */
    @JSONField(name = "access_token")
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 属性 [EXPIRES_TIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "expires_time" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("expires_time")
    private Timestamp expiresTime;

    /**
     * 属性 [DISABLED]
     *
     */
    @JSONField(name = "disabled")
    @JsonProperty("disabled")
    private Integer disabled;

    /**
     * 属性 [REDIRECT_URI]
     *
     */
    @JSONField(name = "redirect_uri")
    @JsonProperty("redirect_uri")
    private String redirectUri;


    /**
     * 设置 [ACCESSNAME]
     */
    public void setName(String  name){
        this.name = name ;
        this.modify("accessname",name);
    }

    /**
     * 设置 [OPEN_TYPE]
     */
    public void setOpenType(String  openType){
        this.openType = openType ;
        this.modify("open_type",openType);
    }

    /**
     * 设置 [ACCESS_KEY]
     */
    public void setAccessKey(String  accessKey){
        this.accessKey = accessKey ;
        this.modify("access_key",accessKey);
    }

    /**
     * 设置 [SECRET_KEY]
     */
    public void setSecretKey(String  secretKey){
        this.secretKey = secretKey ;
        this.modify("secret_key",secretKey);
    }

    /**
     * 设置 [REGION_ID]
     */
    public void setRegionId(String  regionId){
        this.regionId = regionId ;
        this.modify("region_id",regionId);
    }

    /**
     * 设置 [ACCESS_TOKEN]
     */
    public void setAccessToken(String  accessToken){
        this.accessToken = accessToken ;
        this.modify("access_token",accessToken);
    }

    /**
     * 设置 [EXPIRES_TIME]
     */
    public void setExpiresTime(Timestamp  expiresTime){
        this.expiresTime = expiresTime ;
        this.modify("expires_time",expiresTime);
    }

    /**
     * 设置 [DISABLED]
     */
    public void setDisabled(Integer  disabled){
        this.disabled = disabled ;
        this.modify("disabled",disabled);
    }

    /**
     * 设置 [REDIRECT_URI]
     */
    public void setRedirectUri(String  redirectUri){
        this.redirectUri = redirectUri ;
        this.modify("redirect_uri",redirectUri);
    }


}

