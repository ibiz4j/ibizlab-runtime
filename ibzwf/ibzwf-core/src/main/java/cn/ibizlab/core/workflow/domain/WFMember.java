package cn.ibizlab.core.workflow.domain;

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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 实体[成员]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZWFMEMBER", resultMap = "WFMemberResultMap")
public class WFMember extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组成员标识
     */
    @DEField(isKeyField = true)
    @TableId(value = "memberid", type = IdType.ASSIGN_UUID)
    @JSONField(name = "memberid")
    @JsonProperty("memberid")
    private String memberid;
    /**
     * 组成员名称
     */
    @TableField(value = "membername")
    @JSONField(name = "membername")
    @JsonProperty("membername")
    private String membername;
    /**
     * 组标识
     */
    @TableField(value = "groupid")
    @JSONField(name = "groupid")
    @JsonProperty("groupid")
    private String groupid;
    /**
     * 用户组
     */
    @TableField(exist = false)
    @JSONField(name = "groupname")
    @JsonProperty("groupname")
    private String groupname;
    /**
     * 用户标识
     */
    @TableField(value = "userid")
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;
    /**
     * 用户
     */
    @TableField(exist = false)
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;
    /**
     * 单位
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 单位
     */
    @TableField(exist = false)
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;
    /**
     * 主部门
     */
    @TableField(exist = false)
    @JSONField(name = "mdeptid")
    @JsonProperty("mdeptid")
    private String mdeptid;
    /**
     * 主部门
     */
    @TableField(exist = false)
    @JSONField(name = "mdeptname")
    @JsonProperty("mdeptname")
    private String mdeptname;

    /**
     * 用户组
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.workflow.domain.WFGroup group;

    /**
     * 用户
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.workflow.domain.WFUser user;



    /**
     * 设置 [组成员名称]
     */
    public void setMembername(String membername) {
        this.membername = membername;
        this.modify("membername", membername);
    }

    /**
     * 设置 [组标识]
     */
    public void setGroupid(String groupid) {
        this.groupid = groupid;
        this.modify("groupid", groupid);
    }

    /**
     * 设置 [用户标识]
     */
    public void setUserid(String userid) {
        this.userid = userid;
        this.modify("userid", userid);
    }


    /**
     * 获取 [组成员标识]
     */
    public String getMemberid() {
        if(ObjectUtils.isEmpty(memberid)) {
            memberid=(String)getDefaultKey(true);
        }
        return memberid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getGroupid()))&&(!ObjectUtils.isEmpty(this.getUserid())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getGroupid(),this.getUserid()).getBytes());
        return null;
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


