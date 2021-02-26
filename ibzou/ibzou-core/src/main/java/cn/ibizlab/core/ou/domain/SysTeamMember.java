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
 * 实体[组成员]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZTEAMMEMBER", resultMap = "SysTeamMemberResultMap")
@ApiModel("组成员")
public class SysTeamMember extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组成员标识
     */
    @DEField(isKeyField = true)
    @TableId(value = "teammemberid", type = IdType.ASSIGN_UUID)
    @JSONField(name = "teammemberid")
    @JsonProperty("teammemberid")
    @ApiModelProperty("组成员标识")
    private String teammemberid;
    /**
     * 组标识
     */
    @TableField(value = "teamid")
    @JSONField(name = "teamid")
    @JsonProperty("teamid")
    @ApiModelProperty("组标识")
    private String teamid;
    /**
     * 组名称
     */
    @TableField(exist = false)
    @JSONField(name = "teamname")
    @JsonProperty("teamname")
    @ApiModelProperty("组名称")
    private String teamname;
    /**
     * 用户标识
     */
    @TableField(value = "userid")
    @JSONField(name = "userid")
    @JsonProperty("userid")
    @ApiModelProperty("用户标识")
    private String userid;
    /**
     * 姓名
     */
    @TableField(exist = false)
    @JSONField(name = "personname")
    @JsonProperty("personname")
    @ApiModelProperty("姓名")
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
     * 岗位
     */
    @TableField(exist = false)
    @JSONField(name = "postname")
    @JsonProperty("postname")
    @ApiModelProperty("岗位")
    private String postname;
    /**
     * 区属
     */
    @TableField(value = "domains")
    @JSONField(name = "domains")
    @JsonProperty("domains")
    @ApiModelProperty("区属")
    private String domains;
    /**
     * 登录名
     */
    @TableField(exist = false)
    @JSONField(name = "username")
    @JsonProperty("username")
    @ApiModelProperty("登录名")
    private String username;

    /**
     * 
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
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.ou.domain.SysTeam team;



    /**
     * 设置 [组标识]
     */
    public void setTeamid(String teamid) {
        this.teamid = teamid;
        this.modify("teamid", teamid);
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
     * 获取 [组成员标识]
     */
    public String getTeammemberid() {
        if(ObjectUtils.isEmpty(teammemberid)) {
            teammemberid=(String)getDefaultKey(true);
        }
        return teammemberid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getTeamid()))&&(!ObjectUtils.isEmpty(this.getUserid())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getTeamid(),this.getUserid()).getBytes());
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
        this.reset("teammemberid");
        return super.copyTo(targetEntity, bIncEmpty);
    }
}


