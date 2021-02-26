package cn.ibizlab.core.pay.domain;

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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 实体[支付平台]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZOPENACCESS", resultMap = "PayOpenAccessResultMap")
@ApiModel("支付平台")
public class PayOpenAccess extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 开放平台接入标识
     */
    @DEField(name = "accessid", isKeyField = true)
    @TableId(value = "accessid", type = IdType.ASSIGN_UUID)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty("开放平台接入标识")
    private String id;
    /**
     * 开放平台
     */
    @DEField(name = "accessname")
    @TableField(value = "accessname")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty("开放平台")
    private String name;
    /**
     * 开放平台类型
     */
    @DEField(name = "open_type")
    @TableField(value = "open_type")
    @JSONField(name = "open_type")
    @JsonProperty("open_type")
    @ApiModelProperty("开放平台类型")
    private String openType;
    /**
     * AccessKey(AppId)
     */
    @DEField(name = "access_key")
    @TableField(value = "access_key")
    @JSONField(name = "access_key")
    @JsonProperty("access_key")
    @ApiModelProperty("AccessKey(AppId)")
    private String accessKey;
    /**
     * SecretKey(AppSecret)
     */
    @DEField(name = "secret_key")
    @TableField(value = "secret_key")
    @JSONField(name = "secret_key")
    @JsonProperty("secret_key")
    @ApiModelProperty("SecretKey(AppSecret)")
    private String secretKey;
    /**
     * RegionId
     */
    @DEField(name = "region_id")
    @TableField(value = "region_id")
    @JSONField(name = "region_id")
    @JsonProperty("region_id")
    @ApiModelProperty("RegionId")
    private String regionId;
    /**
     * 管理账号token
     */
    @DEField(name = "access_token")
    @TableField(value = "access_token")
    @JSONField(name = "access_token")
    @JsonProperty("access_token")
    @ApiModelProperty("管理账号token")
    private String accessToken;
    /**
     * 管理账号token过期时间
     */
    @DEField(name = "expires_time")
    @TableField(value = "expires_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "expires_time", format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("expires_time")
    @ApiModelProperty("管理账号token过期时间")
    private Timestamp expiresTime;
    /**
     * 是否禁用
     */
    @DEField(defaultValue = "0")
    @TableField(value = "disabled")
    @JSONField(name = "disabled")
    @JsonProperty("disabled")
    @ApiModelProperty("是否禁用")
    private Integer disabled;
    /**
     * RedirectURI
     */
    @DEField(name = "redirect_uri")
    @TableField(value = "redirect_uri")
    @JSONField(name = "redirect_uri")
    @JsonProperty("redirect_uri")
    @ApiModelProperty("RedirectURI")
    private String redirectUri;
    /**
     * NotifyUrl
     */
    @DEField(name = "notify_url")
    @TableField(value = "notify_url")
    @JSONField(name = "notify_url")
    @JsonProperty("notify_url")
    @ApiModelProperty("NotifyUrl")
    private String notifyUrl;
    /**
     * AGENT_ID
     */
    @DEField(name = "agent_id")
    @TableField(value = "agent_id")
    @JSONField(name = "agent_id")
    @JsonProperty("agent_id")
    @ApiModelProperty("AGENT_ID")
    private Long agentId;



    /**
     * 设置 [开放平台]
     */
    public void setName(String name) {
        this.name = name;
        this.modify("accessname", name);
    }

    /**
     * 设置 [开放平台类型]
     */
    public void setOpenType(String openType) {
        this.openType = openType;
        this.modify("open_type", openType);
    }

    /**
     * 设置 [AccessKey(AppId)]
     */
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
        this.modify("access_key", accessKey);
    }

    /**
     * 设置 [SecretKey(AppSecret)]
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        this.modify("secret_key", secretKey);
    }

    /**
     * 设置 [RegionId]
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
        this.modify("region_id", regionId);
    }

    /**
     * 设置 [管理账号token]
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        this.modify("access_token", accessToken);
    }

    /**
     * 设置 [管理账号token过期时间]
     */
    public void setExpiresTime(Timestamp expiresTime) {
        this.expiresTime = expiresTime;
        this.modify("expires_time", expiresTime);
    }

    /**
     * 格式化日期 [管理账号token过期时间]
     */
    public String formatExpiresTime() {
        if (this.expiresTime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(expiresTime);
    }
    /**
     * 设置 [是否禁用]
     */
    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
        this.modify("disabled", disabled);
    }

    /**
     * 设置 [RedirectURI]
     */
    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        this.modify("redirect_uri", redirectUri);
    }

    /**
     * 设置 [NotifyUrl]
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        this.modify("notify_url", notifyUrl);
    }

    /**
     * 设置 [AGENT_ID]
     */
    public void setAgentId(Long agentId) {
        this.agentId = agentId;
        this.modify("agent_id", agentId);
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
        return super.copyTo(targetEntity, bIncEmpty);
    }
}


