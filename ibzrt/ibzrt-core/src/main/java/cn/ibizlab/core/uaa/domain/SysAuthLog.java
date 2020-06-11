package cn.ibizlab.core.uaa.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
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

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [认证日志] 对象
 */
@Data
public class SysAuthLog extends EntityClient implements Serializable {

    /**
     * 标识
     */
    @DEField(isKeyField=true)
    @JSONField(name = "logid")
    @JsonProperty("logid")
    private String logid;

    /**
     * 用户全局名
     */
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;

    /**
     * 用户名称
     */
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;

    /**
     * 域
     */
    @JSONField(name = "domain")
    @JsonProperty("domain")
    private String domain;

    /**
     * 认证时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "authtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("authtime")
    private Timestamp authtime;

    /**
     * IP地址
     */
    @JSONField(name = "ipaddr")
    @JsonProperty("ipaddr")
    private String ipaddr;

    /**
     * MAC地址
     */
    @JSONField(name = "macaddr")
    @JsonProperty("macaddr")
    private String macaddr;

    /**
     * 客户端
     */
    @JSONField(name = "useragent")
    @JsonProperty("useragent")
    private String useragent;

    /**
     * 认证结果
     */
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

}


