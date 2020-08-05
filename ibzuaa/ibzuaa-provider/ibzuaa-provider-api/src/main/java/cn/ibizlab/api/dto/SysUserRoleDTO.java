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
 * 服务DTO对象[SysUserRoleDTO]
 */
@Data
public class SysUserRoleDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SYS_USER_ROLEID]
     *
     */
    @JSONField(name = "userroleid")
    @JsonProperty("userroleid")
    private String userroleid;

    /**
     * 属性 [SYS_ROLEID]
     *
     */
    @JSONField(name = "roleid")
    @JsonProperty("roleid")
    private String roleid;

    /**
     * 属性 [SYS_ROLENAME]
     *
     */
    @JSONField(name = "rolename")
    @JsonProperty("rolename")
    private String rolename;

    /**
     * 属性 [SYS_USERID]
     *
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 属性 [SYS_USERNAME]
     *
     */
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;

    /**
     * 属性 [LOGINNAME]
     *
     */
    @JSONField(name = "loginname")
    @JsonProperty("loginname")
    private String loginname;

    /**
     * 属性 [ORGNAME]
     *
     */
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;

    /**
     * 属性 [MDEPTNAME]
     *
     */
    @JSONField(name = "mdeptname")
    @JsonProperty("mdeptname")
    private String mdeptname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;


    /**
     * 设置 [SYS_ROLEID]
     */
    public void setRoleid(String  roleid){
        this.roleid = roleid ;
        this.modify("sys_roleid",roleid);
    }

    /**
     * 设置 [SYS_USERID]
     */
    public void setUserid(String  userid){
        this.userid = userid ;
        this.modify("sys_userid",userid);
    }


}

