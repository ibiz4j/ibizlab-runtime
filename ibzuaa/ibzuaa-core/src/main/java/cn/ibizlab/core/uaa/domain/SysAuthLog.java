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
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 实体[认证日志]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZAUTHLOG",resultMap = "SysAuthLogResultMap")
public class SysAuthLog extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "logid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "logid")
    @JsonProperty("logid")
    private String logid;
    /**
     * 用户全局名
     */
    @TableField(value = "username")
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;
    /**
     * 用户名称
     */
    @TableField(value = "personname")
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;
    /**
     * 域
     */
    @TableField(value = "domain")
    @JSONField(name = "domain")
    @JsonProperty("domain")
    private String domain;
    /**
     * 认证时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "authtime" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "authtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("authtime")
    private Timestamp authtime;
    /**
     * IP地址
     */
    @TableField(value = "ipaddr")
    @JSONField(name = "ipaddr")
    @JsonProperty("ipaddr")
    private String ipaddr;
    /**
     * MAC地址
     */
    @TableField(value = "macaddr")
    @JSONField(name = "macaddr")
    @JsonProperty("macaddr")
    private String macaddr;
    /**
     * 客户端
     */
    @TableField(value = "useragent")
    @JSONField(name = "useragent")
    @JsonProperty("useragent")
    private String useragent;
    /**
     * 认证结果
     */
    @TableField(value = "authcode")
    @JSONField(name = "authcode")
    @JsonProperty("authcode")
    private String authcode;



    /**
     * 设置 [用户全局名]
     */
    public void setUsername(String username){
        this.username = username ;
        this.modify("username",username);
    }

    /**
     * 设置 [用户名称]
     */
    public void setPersonname(String personname){
        this.personname = personname ;
        this.modify("personname",personname);
    }

    /**
     * 设置 [域]
     */
    public void setDomain(String domain){
        this.domain = domain ;
        this.modify("domain",domain);
    }

    /**
     * 设置 [IP地址]
     */
    public void setIpaddr(String ipaddr){
        this.ipaddr = ipaddr ;
        this.modify("ipaddr",ipaddr);
    }

    /**
     * 设置 [MAC地址]
     */
    public void setMacaddr(String macaddr){
        this.macaddr = macaddr ;
        this.modify("macaddr",macaddr);
    }

    /**
     * 设置 [客户端]
     */
    public void setUseragent(String useragent){
        this.useragent = useragent ;
        this.modify("useragent",useragent);
    }

    /**
     * 设置 [认证结果]
     */
    public void setAuthcode(String authcode){
        this.authcode = authcode ;
        this.modify("authcode",authcode);
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
        this.reset("logid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


