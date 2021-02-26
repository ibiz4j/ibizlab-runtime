package cn.ibizlab.core.notify.domain;

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
 * ServiceApi [绑定消息账号] 对象
 */
@Data
@ApiModel("绑定消息账号")
public class MsgUserAccount extends EntityClient implements Serializable {

    /**
     * 标识
     */
    @DEField(name = "authid" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty("标识")
    private String id;

    /**
     * 用户标识
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    @ApiModelProperty("用户标识")
    private String userid;

    /**
     * 认证类型
     */
    @DEField(name = "identity_type")
    @JSONField(name = "identity_type")
    @JsonProperty("identity_type")
    @ApiModelProperty("认证类型")
    private String identityType;

    /**
     * 认证标识
     */
    @JSONField(name = "identifier")
    @JsonProperty("identifier")
    @ApiModelProperty("认证标识")
    private String identifier;

    /**
     * 凭据
     */
    @JSONField(name = "credential")
    @JsonProperty("credential")
    @ApiModelProperty("凭据")
    private String credential;





    /**
     * 设置 [用户标识]
     */
    public void setUserid(String userid) {
        this.userid = userid ;
        this.modify("userid",userid);
    }

    /**
     * 设置 [认证类型]
     */
    public void setIdentityType(String identityType) {
        this.identityType = identityType ;
        this.modify("identity_type",identityType);
    }

    /**
     * 设置 [认证标识]
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier ;
        this.modify("identifier",identifier);
    }

    /**
     * 设置 [凭据]
     */
    public void setCredential(String credential) {
        this.credential = credential ;
        this.modify("credential",credential);
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
        this.reset("authid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


