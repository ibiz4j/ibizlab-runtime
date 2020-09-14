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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import cn.ibizlab.util.domain.DTOBase;
import cn.ibizlab.util.domain.DTOClient;
import lombok.Data;

/**
 * 服务DTO对象[WFUserDTO]
 */
@Data
public class WFUserDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [USERID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String id;

    /**
     * 属性 [USERNAME]
     *
     */
    @JSONField(name = "firstname")
    @JsonProperty("firstname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String firstname;

    /**
     * 属性 [PERSONNAME]
     *
     */
    @JSONField(name = "displayname")
    @JsonProperty("displayname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String displayname;

    /**
     * 属性 [MDEPTID]
     *
     */
    @JSONField(name = "mdeptid")
    @JsonProperty("mdeptid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String mdeptid;

    /**
     * 属性 [MDEPTCODE]
     *
     */
    @JSONField(name = "mdeptcode")
    @JsonProperty("mdeptcode")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String mdeptcode;

    /**
     * 属性 [MDEPTNAME]
     *
     */
    @JSONField(name = "mdeptname")
    @JsonProperty("mdeptname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String mdeptname;

    /**
     * 属性 [BCODE]
     *
     */
    @JSONField(name = "bcode")
    @JsonProperty("bcode")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String bcode;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String orgid;

    /**
     * 属性 [ORGCODE]
     *
     */
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String orgcode;

    /**
     * 属性 [ORGNAME]
     *
     */
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String orgname;


    /**
     * 设置 [USERNAME]
     */
    public void setFirstname(String  firstname){
        this.firstname = firstname ;
        this.modify("username",firstname);
    }

    /**
     * 设置 [PERSONNAME]
     */
    public void setDisplayname(String  displayname){
        this.displayname = displayname ;
        this.modify("personname",displayname);
    }

    /**
     * 设置 [MDEPTID]
     */
    public void setMdeptid(String  mdeptid){
        this.mdeptid = mdeptid ;
        this.modify("mdeptid",mdeptid);
    }

    /**
     * 设置 [MDEPTCODE]
     */
    public void setMdeptcode(String  mdeptcode){
        this.mdeptcode = mdeptcode ;
        this.modify("mdeptcode",mdeptcode);
    }

    /**
     * 设置 [MDEPTNAME]
     */
    public void setMdeptname(String  mdeptname){
        this.mdeptname = mdeptname ;
        this.modify("mdeptname",mdeptname);
    }

    /**
     * 设置 [BCODE]
     */
    public void setBcode(String  bcode){
        this.bcode = bcode ;
        this.modify("bcode",bcode);
    }

    /**
     * 设置 [ORGCODE]
     */
    public void setOrgcode(String  orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }


}


