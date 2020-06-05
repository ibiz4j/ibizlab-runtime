package cn.ibizlab.core.ou.domain;

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
 * 实体[部门成员]
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "IBZDEPTMEMBER",resultMap = "IBZDeptMemberResultMap")
public class IBZDeptMember extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "memberid",type=IdType.UUID)
    @JSONField(name = "memberid")
    @JsonProperty("memberid")
    private String memberid;
    /**
     * 部门标识
     */
    @TableField(value = "deptid")
    @JSONField(name = "deptid")
    @JsonProperty("deptid")
    private String deptid;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    @JSONField(name = "deptname")
    @JsonProperty("deptname")
    private String deptname;
    /**
     * 用户标识
     */
    @TableField(value = "userid")
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;
    /**
     * 成员
     */
    @TableField(exist = false)
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;
    /**
     * 岗位标识
     */
    @TableField(value = "postid")
    @JSONField(name = "postid")
    @JsonProperty("postid")
    private String postid;
    /**
     * 岗位名称
     */
    @TableField(exist = false)
    @JSONField(name = "postname")
    @JsonProperty("postname")
    private String postname;
    /**
     * 区属
     */
    @TableField(value = "domains")
    @JSONField(name = "domains")
    @JsonProperty("domains")
    private String domains;

    /**
     * 部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.ou.domain.IBZDepartment dept;

    /**
     * 人员
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.ou.domain.IBZEmployee emp;

    /**
     * 岗位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.ou.domain.IBZPost post;



    /**
     * 设置 [部门标识]
     */
    public void setDeptid(String deptid){
        this.deptid = deptid ;
        this.modify("deptid",deptid);
    }
    /**
     * 设置 [用户标识]
     */
    public void setUserid(String userid){
        this.userid = userid ;
        this.modify("userid",userid);
    }
    /**
     * 设置 [岗位标识]
     */
    public void setPostid(String postid){
        this.postid = postid ;
        this.modify("postid",postid);
    }
    /**
     * 设置 [区属]
     */
    public void setDomains(String domains){
        this.domains = domains ;
        this.modify("domains",domains);
    }

    /**
     * 获取 [标识]
     */
    public String getMemberid(){
        if(ObjectUtils.isEmpty(memberid)){
            memberid=(String)getDefaultKey(true);
        }
        return memberid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getDeptid()))&&(!ObjectUtils.isEmpty(this.getUserid())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getDeptid(),this.getUserid()).getBytes());
        return null;
    }
}


