package cn.ibizlab.core.ou.domain;

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
 * ServiceApi [部门成员] 对象
 */
@Data
public class IBZDeptMember extends EntityClient implements Serializable {

    /**
     * 标识
     */
    @DEField(isKeyField=true)
    @JSONField(name = "memberid")
    @JsonProperty("memberid")
    private String memberid;

    /**
     * 部门标识
     */
    @JSONField(name = "deptid")
    @JsonProperty("deptid")
    private String deptid;

    /**
     * 部门名称
     */
    @JSONField(name = "deptname")
    @JsonProperty("deptname")
    private String deptname;

    /**
     * 用户标识
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 成员
     */
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;


    /**
     * 部门
     */
    @JSONField(name = "dept")
    @JsonProperty("dept")
    private cn.ibizlab.core.ou.domain.IBZDepartment dept;

    /**
     * 人员
     */
    @JSONField(name = "emp")
    @JsonProperty("emp")
    private cn.ibizlab.core.ou.domain.IBZEmployee emp;




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


}


