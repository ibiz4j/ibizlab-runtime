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


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;


/**
 * 实体[系统用户]
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "IBZUSER",resultMap = "SysUserResultMap")
public class SysUser extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "userid",type=IdType.UUID)
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;
    /**
     * 用户全局名
     */
    @TableField(value = "username")
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;
    /**
     * 用户姓名
     */
    @TableField(value = "personname")
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;
    /**
     * 密码
     */
    @TableField(value = "password")
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


