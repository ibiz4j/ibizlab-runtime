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
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;
import cn.ibizlab.util.annotation.Audit;

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [第三方认证平台] 对象
 */
@Data
public class SysOpenAccess extends EntityClient implements Serializable {

    /**
     * 开放平台接入标识
     */
    @DEField(defaultValue = "open_type" , defaultValueType = DEFieldDefaultValueType.PARAM , isKeyField=true)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 开放平台
     */
    @DEField(name = "accessname")
    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;

    /**
     * 开放平台类型
     */
    @DEField(name = "open_type")
    @JSONField(name = "open_type")
    @JsonProperty("open_type")
    private String openType;

    /**
     * AccessKey(AppId)
     */
    @DEField(name = "access_key")
    @JSONField(name = "access_key")
    @JsonProperty("access_key")
    private String accessKey;

    /**
     * SecretKey(AppSecret)
     */
    @DEField(name = "secret_key")
    @JSONField(name = "secret_key")
    @JsonProperty("secret_key")
    private String secretKey;

    /**
     * RegionId
     */
    @DEField(name = "region_id")
    @JSONField(name = "region_id")
    @JsonProperty("region_id")
    private String regionId;

    /**
     * 管理账号token
     */
    @DEField(name = "access_token")
    @JSONField(name = "access_token")
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 管理账号token过期时间
     */
    @DEField(name = "expires_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "expires_time" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("expires_time")
    private Timestamp expiresTime;

    /**
     * 是否禁用
     */
    @DEField(defaultValue = "0")
    @JSONField(name = "disabled")
    @JsonProperty("disabled")
    private Integer disabled;

    /**
     * RedirectURI
     */
    @DEField(name = "redirect_uri")
    @JSONField(name = "redirect_uri")
    @JsonProperty("redirect_uri")
    private String redirectUri;





    /**
     * 设置 [开放平台]
     */
    public void setName(String name){
        this.name = name ;
        this.modify("accessname",name);
    }

    /**
     * 设置 [开放平台类型]
     */
    public void setOpenType(String openType){
        this.openType = openType ;
        this.modify("open_type",openType);
    }

    /**
     * 设置 [AccessKey(AppId)]
     */
    public void setAccessKey(String accessKey){
        this.accessKey = accessKey ;
        this.modify("access_key",accessKey);
    }

    /**
     * 设置 [SecretKey(AppSecret)]
     */
    public void setSecretKey(String secretKey){
        this.secretKey = secretKey ;
        this.modify("secret_key",secretKey);
    }

    /**
     * 设置 [RegionId]
     */
    public void setRegionId(String regionId){
        this.regionId = regionId ;
        this.modify("region_id",regionId);
    }

    /**
     * 设置 [管理账号token]
     */
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken ;
        this.modify("access_token",accessToken);
    }

    /**
     * 设置 [管理账号token过期时间]
     */
    public void setExpiresTime(Timestamp expiresTime){
        this.expiresTime = expiresTime ;
        this.modify("expires_time",expiresTime);
    }

    /**
     * 格式化日期 [管理账号token过期时间]
     */
    public String formatExpiresTime(){
        if (this.expiresTime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(expiresTime);
    }
    /**
     * 设置 [是否禁用]
     */
    public void setDisabled(Integer disabled){
        this.disabled = disabled ;
        this.modify("disabled",disabled);
    }

    /**
     * 设置 [RedirectURI]
     */
    public void setRedirectUri(String redirectUri){
        this.redirectUri = redirectUri ;
        this.modify("redirect_uri",redirectUri);
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
        this.reset("accessid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


