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
 * 服务DTO对象[PayOpenAccessDTO]
 */
@Data
public class PayOpenAccessDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ACCESSID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String id;

    /**
     * 属性 [ACCESSNAME]
     *
     */
    @JSONField(name = "name")
    @JsonProperty("name")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String name;

    /**
     * 属性 [OPEN_TYPE]
     *
     */
    @JSONField(name = "open_type")
    @JsonProperty("open_type")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String openType;

    /**
     * 属性 [ACCESS_KEY]
     *
     */
    @JSONField(name = "access_key")
    @JsonProperty("access_key")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String accessKey;

    /**
     * 属性 [SECRET_KEY]
     *
     */
    @JSONField(name = "secret_key")
    @JsonProperty("secret_key")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String secretKey;

    /**
     * 属性 [REGION_ID]
     *
     */
    @JSONField(name = "region_id")
    @JsonProperty("region_id")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String regionId;

    /**
     * 属性 [ACCESS_TOKEN]
     *
     */
    @JSONField(name = "access_token")
    @JsonProperty("access_token")
    @Size(min = 0, max = 1000, message = "内容长度必须小于等于[1000]")
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
    @Size(min = 0, max = 500, message = "内容长度必须小于等于[500]")
    private String redirectUri;

    /**
     * 属性 [NOTIFY_URL]
     *
     */
    @JSONField(name = "notify_url")
    @JsonProperty("notify_url")
    @Size(min = 0, max = 500, message = "内容长度必须小于等于[500]")
    private String notifyUrl;


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

    /**
     * 设置 [NOTIFY_URL]
     */
    public void setNotifyUrl(String  notifyUrl){
        this.notifyUrl = notifyUrl ;
        this.modify("notify_url",notifyUrl);
    }


}


