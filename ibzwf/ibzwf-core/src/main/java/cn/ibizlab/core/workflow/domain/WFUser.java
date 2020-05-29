package cn.ibizlab.core.workflow.domain;

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
 * 实体[用户]
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "IBZUSER",resultMap = "WFUserResultMap")
public class WFUser extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户标识
     */
    @DEField(name = "userid" , isKeyField=true)
    @TableId(value= "userid",type=IdType.UUID)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;
    /**
     * 用户全局名
     */
    @DEField(name = "username")
    @TableField(value = "username")
    @JSONField(name = "firstname")
    @JsonProperty("firstname")
    private String firstname;
    /**
     * 用户名称
     */
    @DEField(name = "personname")
    @TableField(value = "personname")
    @JSONField(name = "displayname")
    @JsonProperty("displayname")
    private String displayname;



    /**
     * 设置 [用户全局名]
     */
    public void setFirstname(String firstname){
        this.firstname = firstname ;
        this.modify("username",firstname);
    }
    /**
     * 设置 [用户名称]
     */
    public void setDisplayname(String displayname){
        this.displayname = displayname ;
        this.modify("personname",displayname);
    }

}


