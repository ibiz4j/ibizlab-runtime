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

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [成员] 对象
 */
@Data
public class WFMember extends EntityClient implements Serializable {

    /**
     * 组成员标识
     */
    @DEField(isKeyField=true)
    @JSONField(name = "memberid")
    @JsonProperty("memberid")
    private String memberid;

    /**
     * 组成员名称
     */
    @JSONField(name = "membername")
    @JsonProperty("membername")
    private String membername;

    /**
     * 组标识
     */
    @JSONField(name = "groupid")
    @JsonProperty("groupid")
    private String groupid;

    /**
     * 用户组
     */
    @JSONField(name = "groupname")
    @JsonProperty("groupname")
    private String groupname;

    /**
     * 用户标识
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 用户
     */
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;


    /**
     * 用户组
     */
    @JSONField(name = "group")
    @JsonProperty("group")
    private cn.ibizlab.core.workflow.domain.WFGroup group;

    /**
     * 用户
     */
    @JSONField(name = "user")
    @JsonProperty("user")
    private cn.ibizlab.core.workflow.domain.WFUser user;




    /**
     * 设置 [组成员名称]
     */
    public void setMembername(String membername){
        this.membername = membername ;
        this.modify("membername",membername);
    }
    /**
     * 设置 [组标识]
     */
    public void setGroupid(String groupid){
        this.groupid = groupid ;
        this.modify("groupid",groupid);
    }
    /**
     * 设置 [用户标识]
     */
    public void setUserid(String userid){
        this.userid = userid ;
        this.modify("userid",userid);
    }

}


