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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 实体[部门成员]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZDEPTMEMBER", resultMap = "SysDeptMemberResultMap")
@ApiModel("部门成员")
public class SysDeptMember extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @DEField(isKeyField = true)
    @TableId(value = "memberid", type = IdType.ASSIGN_UUID)
    @JSONField(name = "memberid")
    @JsonProperty("memberid")
    @ApiModelProperty("标识")
    private String memberid;
    /**
     * 部门标识
     */
    @TableField(value = "deptid")
    @JSONField(name = "deptid")
    @JsonProperty("deptid")
    @ApiModelProperty("部门标识")
    private String deptid;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    @JSONField(name = "deptname")
    @JsonProperty("deptname")
    @ApiModelProperty("部门名称")
    private String deptname;
    /**
     * 用户标识
     */
    @TableField(value = "userid")
    @JSONField(name = "userid")
    @JsonProperty("userid")
    @ApiModelProperty("用户标识")
    private String userid;
    /**
     * 成员
     */
    @TableField(exist = false)
    @JSONField(name = "personname")
    @JsonProperty("personname")
    @ApiModelProperty("成员")
    private String personname;
    /**
     * 岗位标识
     */
    @TableField(value = "postid")
    @JSONField(name = "postid")
    @JsonProperty("postid")
    @ApiModelProperty("岗位标识")
    private String postid;
    /**
     * 岗位名称
     */
    @TableField(exist = false)
    @JSONField(name = "postname")
    @JsonProperty("postname")
    @ApiModelProperty("岗位名称")
    private String postname;
    /**
     * 业务条线
     */
    @TableField(exist = false)
    @JSONField(name = "bcode")
    @JsonProperty("bcode")
    @ApiModelProperty("业务条线")
    private String bcode;
    /**
     * 区属
     */
    @TableField(value = "domains")
    @JSONField(name = "domains")
    @JsonProperty("domains")
    @ApiModelProperty("区属")
    private String domains;

    /**
     * 部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.ou.domain.SysDepartment dept;

    /**
     * 人员
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.ou.domain.SysEmployee emp;

    /**
     * 岗位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.ou.domain.SysPost post;



    /**
     * 设置 [部门标识]
     */
    public void setDeptid(String deptid) {
        this.deptid = deptid;
        this.modify("deptid", deptid);
    }

    /**
     * 设置 [用户标识]
     */
    public void setUserid(String userid) {
        this.userid = userid;
        this.modify("userid", userid);
    }

    /**
     * 设置 [岗位标识]
     */
    public void setPostid(String postid) {
        this.postid = postid;
        this.modify("postid", postid);
    }

    /**
     * 设置 [区属]
     */
    public void setDomains(String domains) {
        this.domains = domains;
        this.modify("domains", domains);
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
        return super.copyTo(targetEntity, bIncEmpty);
    }
}


