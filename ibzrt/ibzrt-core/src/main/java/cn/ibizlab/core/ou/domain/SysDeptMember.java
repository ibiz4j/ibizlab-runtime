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
import cn.ibizlab.util.helper.DataObject;
import cn.ibizlab.util.enums.DupCheck;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;
import cn.ibizlab.util.annotation.Audit;

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [部门成员] 对象
 */
@Data
public class SysDeptMember extends EntityClient implements Serializable {

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
     * 岗位标识
     */
    @JSONField(name = "postid")
    @JsonProperty("postid")
    private String postid;

    /**
     * 岗位名称
     */
    @JSONField(name = "postname")
    @JsonProperty("postname")
    private String postname;

    /**
     * 业务条线
     */
    @JSONField(name = "bcode")
    @JsonProperty("bcode")
    private String bcode;

    /**
     * 区属
     */
    @JSONField(name = "domains")
    @JsonProperty("domains")
    private String domains;


    /**
     * 部门
     */
    @JSONField(name = "dept")
    @JsonProperty("dept")
    private cn.ibizlab.core.ou.domain.SysDepartment dept;

    /**
     * 人员
     */
    @JSONField(name = "emp")
    @JsonProperty("emp")
    private cn.ibizlab.core.ou.domain.SysEmployee emp;

    /**
     * 岗位
     */
    @JSONField(name = "post")
    @JsonProperty("post")
    private cn.ibizlab.core.ou.domain.SysPost post;




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
     * 复制当前对象数据到目标对象(粘贴重置)
     * @param targetEntity 目标数据对象
     * @param bIncEmpty  是否包括空值
     * @param <T>
     * @return
     */
    @Override
    public <T> T copyTo(T targetEntity, boolean bIncEmpty) {
        this.reset("memberid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


