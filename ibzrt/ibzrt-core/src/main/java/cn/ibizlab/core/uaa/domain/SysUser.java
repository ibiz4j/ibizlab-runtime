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
 * ServiceApi [系统用户] 对象
 */
@Data
public class SysUser extends EntityClient implements Serializable {

    /**
     * 用户标识
     */
    @DEField(isKeyField=true)
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 用户全局名
     */
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;

    /**
     * 用户姓名
     */
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;

    /**
     * 密码
     */
    @JSONField(name = "password")
    @JsonProperty("password")
    private String password;





    /**
     * 设置 [用户全局名]
     */
    public void setUsername(String username){
        this.username = username ;
        this.modify("username",username);
    }

    /**
     * 设置 [用户姓名]
     */
    public void setPersonname(String personname){
        this.personname = personname ;
        this.modify("personname",personname);
    }

    /**
     * 设置 [密码]
     */
    public void setPassword(String password){
        this.password = password ;
        this.modify("password",password);
    }


}


