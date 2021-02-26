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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 服务DTO对象[SysDeptMemberDTO]
 */
@Data
@ApiModel("部门成员")
public class SysDeptMemberDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [MEMBERID]
     *
     */
    @JSONField(name = "memberid")
    @JsonProperty("memberid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("标识")
    private String memberid;

    /**
     * 属性 [DEPTID]
     *
     */
    @JSONField(name = "deptid")
    @JsonProperty("deptid")
    @NotBlank(message = "[部门标识]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("部门标识")
    private String deptid;

    /**
     * 属性 [DEPTNAME]
     *
     */
    @JSONField(name = "deptname")
    @JsonProperty("deptname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("部门名称")
    private String deptname;

    /**
     * 属性 [USERID]
     *
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    @NotBlank(message = "[用户标识]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("用户标识")
    private String userid;

    /**
     * 属性 [PERSONNAME]
     *
     */
    @JSONField(name = "personname")
    @JsonProperty("personname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("成员")
    private String personname;

    /**
     * 属性 [POSTID]
     *
     */
    @JSONField(name = "postid")
    @JsonProperty("postid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("岗位标识")
    private String postid;

    /**
     * 属性 [POSTNAME]
     *
     */
    @JSONField(name = "postname")
    @JsonProperty("postname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("岗位名称")
    private String postname;

    /**
     * 属性 [BCODE]
     *
     */
    @JSONField(name = "bcode")
    @JsonProperty("bcode")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("业务条线")
    private String bcode;

    /**
     * 属性 [DOMAINS]
     *
     */
    @JSONField(name = "domains")
    @JsonProperty("domains")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("区属")
    private String domains;


    /**
     * 设置 [DEPTID]
     */
    public void setDeptid(String  deptid){
        this.deptid = deptid ;
        this.modify("deptid",deptid);
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


