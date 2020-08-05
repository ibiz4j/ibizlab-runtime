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
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.util.domain.DTOBase;
import cn.ibizlab.util.domain.DTOClient;
import lombok.Data;

/**
 * 服务DTO对象[WFMemberDTO]
 */
@Data
public class WFMemberDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [MEMBERID]
     *
     */
    @JSONField(name = "memberid")
    @JsonProperty("memberid")
    private String memberid;

    /**
     * 属性 [MEMBERNAME]
     *
     */
    @JSONField(name = "membername")
    @JsonProperty("membername")
    private String membername;

    /**
     * 属性 [GROUPID]
     *
     */
    @JSONField(name = "groupid")
    @JsonProperty("groupid")
    private String groupid;

    /**
     * 属性 [GROUPNAME]
     *
     */
    @JSONField(name = "groupname")
    @JsonProperty("groupname")
    private String groupname;

    /**
     * 属性 [USERID]
     *
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 属性 [PERSONNAME]
     *
     */
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ORGNAME]
     *
     */
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;

    /**
     * 属性 [MDEPTID]
     *
     */
    @JSONField(name = "mdeptid")
    @JsonProperty("mdeptid")
    private String mdeptid;

    /**
     * 属性 [MDEPTNAME]
     *
     */
    @JSONField(name = "mdeptname")
    @JsonProperty("mdeptname")
    private String mdeptname;


    /**
     * 设置 [MEMBERNAME]
     */
    public void setMembername(String  membername){
        this.membername = membername ;
        this.modify("membername",membername);
    }

    /**
     * 设置 [GROUPID]
     */
    public void setGroupid(String  groupid){
        this.groupid = groupid ;
        this.modify("groupid",groupid);
    }

    /**
     * 设置 [USERID]
     */
    public void setUserid(String  userid){
        this.userid = userid ;
        this.modify("userid",userid);
    }


}

