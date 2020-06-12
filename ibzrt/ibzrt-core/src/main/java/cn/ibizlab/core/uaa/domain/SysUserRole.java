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

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [用户角色关系] 对象
 */
@Data
public class SysUserRole extends EntityClient implements Serializable {

    /**
     * 用户角色关系标识
     */
    @DEField(name = "sys_user_roleid" , isKeyField=true)
    @JSONField(name = "userroleid")
    @JsonProperty("userroleid")
    private String userroleid;

    /**
     * 角色标识
     */
    @DEField(name = "sys_roleid")
    @JSONField(name = "roleid")
    @JsonProperty("roleid")
    private String roleid;

    /**
     * 角色名称
     */
    @JSONField(name = "rolename")
    @JsonProperty("rolename")
    private String rolename;

    /**
     * 用户标识
     */
    @DEField(name = "sys_userid")
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 用户名称
     */
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;

    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;


    /**
     * 角色
     */
    @JSONField(name = "role")
    @JsonProperty("role")
    private cn.ibizlab.core.uaa.domain.SysRole role;

    /**
     * 用户
     */
    @JSONField(name = "user")
    @JsonProperty("user")
    private cn.ibizlab.core.uaa.domain.SysUser user;




    /**
     * 设置 [角色标识]
     */
    public void setRoleid(String roleid){
        this.roleid = roleid ;
        this.modify("sys_roleid",roleid);
    }

    /**
     * 设置 [用户标识]
     */
    public void setUserid(String userid){
        this.userid = userid ;
        this.modify("sys_userid",userid);
    }


}


