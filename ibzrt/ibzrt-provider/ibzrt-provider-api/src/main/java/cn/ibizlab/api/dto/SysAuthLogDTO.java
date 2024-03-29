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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 服务DTO对象[SysAuthLogDTO]
 */
@Data
@ApiModel("认证日志")
public class SysAuthLogDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [LOGID]
     *
     */
    @JSONField(name = "logid")
    @JsonProperty("logid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("标识")
    private String logid;

    /**
     * 属性 [USERNAME]
     *
     */
    @JSONField(name = "username")
    @JsonProperty("username")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("用户全局名")
    private String username;

    /**
     * 属性 [PERSONNAME]
     *
     */
    @JSONField(name = "personname")
    @JsonProperty("personname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("用户名称")
    private String personname;

    /**
     * 属性 [DOMAINS]
     *
     */
    @JSONField(name = "domain")
    @JsonProperty("domain")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("域")
    private String domain;

    /**
     * 属性 [AUTHTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "authtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("authtime")
    @ApiModelProperty("认证时间")
    private Timestamp authtime;

    /**
     * 属性 [IPADDR]
     *
     */
    @JSONField(name = "ipaddr")
    @JsonProperty("ipaddr")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("IP地址")
    private String ipaddr;

    /**
     * 属性 [MACADDR]
     *
     */
    @JSONField(name = "macaddr")
    @JsonProperty("macaddr")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("MAC地址")
    private String macaddr;

    /**
     * 属性 [USERAGENT]
     *
     */
    @JSONField(name = "useragent")
    @JsonProperty("useragent")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("客户端")
    private String useragent;

    /**
     * 属性 [AUTHCODE]
     *
     */
    @JSONField(name = "authcode")
    @JsonProperty("authcode")
    @Size(min = 0, max = 15, message = "内容长度必须小于等于[15]")
    @ApiModelProperty("认证结果")
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
     * 设置 [DOMAINS]
     */
    public void setDomain(String  domain){
        this.domain = domain ;
        this.modify("domains",domain);
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


