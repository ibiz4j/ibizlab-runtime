package cn.ibizlab.api.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import cn.ibizlab.util.domain.DTOBase;
import cn.ibizlab.util.domain.DTOClient;
import lombok.Data;

/**
 * 服务DTO对象[SysTeamMemberDTO]
 */
@Data
public class SysTeamMemberDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [TEAMMEMBERID]
     *
     */
    @JSONField(name = "teammemberid")
    @JsonProperty("teammemberid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String teammemberid;

    /**
     * 属性 [TEAMID]
     *
     */
    @JSONField(name = "teamid")
    @JsonProperty("teamid")
    @NotBlank(message = "[组标识]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String teamid;

    /**
     * 属性 [TEAMNAME]
     *
     */
    @JSONField(name = "teamname")
    @JsonProperty("teamname")
    @NotBlank(message = "[组名称]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String teamname;

    /**
     * 属性 [USERID]
     *
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    @NotBlank(message = "[用户标识]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String userid;

    /**
     * 属性 [PERSONNAME]
     *
     */
    @JSONField(name = "personname")
    @JsonProperty("personname")
    @NotBlank(message = "[姓名]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String personname;

    /**
     * 属性 [POSTID]
     *
     */
    @JSONField(name = "postid")
    @JsonProperty("postid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String postid;

    /**
     * 属性 [POSTNAME]
     *
     */
    @JSONField(name = "postname")
    @JsonProperty("postname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String postname;

    /**
     * 属性 [DOMAINS]
     *
     */
    @JSONField(name = "domains")
    @JsonProperty("domains")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String domains;


    /**
     * 设置 [TEAMID]
     */
    public void setTeamid(String  teamid){
        this.teamid = teamid ;
        this.modify("teamid",teamid);
    }

    /**
     * 设置 [USERID]
     */
    public void setUserid(String  userid){
        this.userid = userid ;
        this.modify("userid",userid);
    }

    /**
     * 设置 [POSTID]
     */
    public void setPostid(String  postid){
        this.postid = postid ;
        this.modify("postid",postid);
    }

    /**
     * 设置 [DOMAINS]
     */
    public void setDomains(String  domains){
        this.domains = domains ;
        this.modify("domains",domains);
    }


}


