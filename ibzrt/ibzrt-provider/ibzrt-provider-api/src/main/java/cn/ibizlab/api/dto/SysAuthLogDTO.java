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
 * 服务DTO对象[SysAuthLogDTO]
 */
@Data
public class SysAuthLogDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [LOGID]
     *
     */
    @JSONField(name = "logid")
    @JsonProperty("logid")
    private String logid;

    /**
     * 属性 [USERNAME]
     *
     */
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;

    /**
     * 属性 [PERSONNAME]
     *
     */
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;

    /**
     * 属性 [DOMAIN]
     *
     */
    @JSONField(name = "domain")
    @JsonProperty("domain")
    private String domain;

    /**
     * 属性 [AUTHTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "authtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("authtime")
    private Timestamp authtime;

    /**
     * 属性 [IPADDR]
     *
     */
    @JSONField(name = "ipaddr")
    @JsonProperty("ipaddr")
    private String ipaddr;

    /**
     * 属性 [MACADDR]
     *
     */
    @JSONField(name = "macaddr")
    @JsonProperty("macaddr")
    private String macaddr;

    /**
     * 属性 [USERAGENT]
     *
     */
    @JSONField(name = "useragent")
    @JsonProperty("useragent")
    private String useragent;

    /**
     * 属性 [AUTHCODE]
     *
     */
    @JSONField(name = "authcode")
    @JsonProperty("authcode")
    private String authcode;


    /**
     * 设置 [USERNAME]
     */
    public void setUsername(String  username){
        this.username = username ;
        this.modify("username",username);
    }

    /**
     * 设置 [PERSONNAME]
     */
    public void setPersonname(String  personname){
        this.personname = personname ;
        this.modify("personname",personname);
    }

    /**
     * 设置 [DOMAIN]
     */
    public void setDomain(String  domain){
        this.domain = domain ;
        this.modify("domain",domain);
    }

    /**
     * 设置 [IPADDR]
     */
    public void setIpaddr(String  ipaddr){
        this.ipaddr = ipaddr ;
        this.modify("ipaddr",ipaddr);
    }

    /**
     * 设置 [MACADDR]
     */
    public void setMacaddr(String  macaddr){
        this.macaddr = macaddr ;
        this.modify("macaddr",macaddr);
    }

    /**
     * 设置 [USERAGENT]
     */
    public void setUseragent(String  useragent){
        this.useragent = useragent ;
        this.modify("useragent",useragent);
    }

    /**
     * 设置 [AUTHCODE]
     */
    public void setAuthcode(String  authcode){
        this.authcode = authcode ;
        this.modify("authcode",authcode);
    }


}

