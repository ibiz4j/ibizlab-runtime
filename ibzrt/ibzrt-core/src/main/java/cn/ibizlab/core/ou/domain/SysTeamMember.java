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
 * ServiceApi [组成员] 对象
 */
@Data
public class SysTeamMember extends EntityClient implements Serializable {

    /**
     * 组成员标识
     */
    @DEField(isKeyField = true)
    @JSONField(name = "teammemberid")
    @JsonProperty("teammemberid")
    private String teammemberid;

    /**
     * 组标识
     */
    @JSONField(name = "teamid")
    @JsonProperty("teamid")
    private String teamid;

    /**
     * 组名称
     */
    @JSONField(name = "teamname")
    @JsonProperty("teamname")
    private String teamname;

    /**
     * 用户标识
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 姓名
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
     * 岗位
     */
    @JSONField(name = "postname")
    @JsonProperty("postname")
    private String postname;

    /**
     * 区属
     */
    @JSONField(name = "domains")
    @JsonProperty("domains")
    private String domains;

    /**
     * 登录名
     */
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;


    /**
     * 
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
     * 
     */
    @JSONField(name = "team")
    @JsonProperty("team")
    private cn.ibizlab.core.ou.domain.SysTeam team;




    /**
     * 设置 [组标识]
     */
    public void setTeamid(String teamid) {
        this.teamid = teamid ;
        this.modify("teamid",teamid);
    }

    /**
     * 设置 [用户标识]
     */
    public void setUserid(String userid) {
        this.userid = userid ;
        this.modify("userid",userid);
    }

    /**
     * 设置 [岗位标识]
     */
    public void setPostid(String postid) {
        this.postid = postid ;
        this.modify("postid",postid);
    }

    /**
     * 设置 [区属]
     */
    public void setDomains(String domains) {
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
        this.reset("teammemberid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


