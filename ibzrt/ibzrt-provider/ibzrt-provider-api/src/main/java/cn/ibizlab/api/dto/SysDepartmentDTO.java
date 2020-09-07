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
 * 服务DTO对象[SysDepartmentDTO]
 */
@Data
public class SysDepartmentDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DEPTID]
     *
     */
    @JSONField(name = "deptid")
    @JsonProperty("deptid")
    private String deptid;

    /**
     * 属性 [DEPTCODE]
     *
     */
    @JSONField(name = "deptcode")
    @JsonProperty("deptcode")
    private String deptcode;

    /**
     * 属性 [DEPTNAME]
     *
     */
    @JSONField(name = "deptname")
    @JsonProperty("deptname")
    private String deptname;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [PDEPTID]
     *
     */
    @JSONField(name = "parentdeptid")
    @JsonProperty("parentdeptid")
    private String parentdeptid;

    /**
     * 属性 [SHORTNAME]
     *
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;

    /**
     * 属性 [DEPTLEVEL]
     *
     */
    @JSONField(name = "deptlevel")
    @JsonProperty("deptlevel")
    private Integer deptlevel;

    /**
     * 属性 [DOMAINS]
     *
     */
    @JSONField(name = "domains")
    @JsonProperty("domains")
    private String domains;

    /**
     * 属性 [SHOWORDER]
     *
     */
    @JSONField(name = "showorder")
    @JsonProperty("showorder")
    private Integer showorder;

    /**
     * 属性 [BCODE]
     *
     */
    @JSONField(name = "bcode")
    @JsonProperty("bcode")
    private String bcode;

    /**
     * 属性 [LEADERID]
     *
     */
    @JSONField(name = "leaderid")
    @JsonProperty("leaderid")
    private String leaderid;

    /**
     * 属性 [LEADERNAME]
     *
     */
    @JSONField(name = "leadername")
    @JsonProperty("leadername")
    private String leadername;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [ORGNAME]
     *
     */
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;

    /**
     * 属性 [PDEPTNAME]
     *
     */
    @JSONField(name = "parentdeptname")
    @JsonProperty("parentdeptname")
    private String parentdeptname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;


    /**
     * 设置 [DEPTCODE]
     */
    public void setDeptcode(String  deptcode){
        this.deptcode = deptcode ;
        this.modify("deptcode",deptcode);
    }

    /**
     * 设置 [DEPTNAME]
     */
    public void setDeptname(String  deptname){
        this.deptname = deptname ;
        this.modify("deptname",deptname);
    }

    /**
     * 设置 [PDEPTID]
     */
    public void setParentdeptid(String  parentdeptid){
        this.parentdeptid = parentdeptid ;
        this.modify("pdeptid",parentdeptid);
    }

    /**
     * 设置 [SHORTNAME]
     */
    public void setShortname(String  shortname){
        this.shortname = shortname ;
        this.modify("shortname",shortname);
    }

    /**
     * 设置 [DEPTLEVEL]
     */
    public void setDeptlevel(Integer  deptlevel){
        this.deptlevel = deptlevel ;
        this.modify("deptlevel",deptlevel);
    }

    /**
     * 设置 [DOMAINS]
     */
    public void setDomains(String  domains){
        this.domains = domains ;
        this.modify("domains",domains);
    }

    /**
     * 设置 [SHOWORDER]
     */
    public void setShoworder(Integer  showorder){
        this.showorder = showorder ;
        this.modify("showorder",showorder);
    }

    /**
     * 设置 [BCODE]
     */
    public void setBcode(String  bcode){
        this.bcode = bcode ;
        this.modify("bcode",bcode);
    }

    /**
     * 设置 [LEADERID]
     */
    public void setLeaderid(String  leaderid){
        this.leaderid = leaderid ;
        this.modify("leaderid",leaderid);
    }

    /**
     * 设置 [LEADERNAME]
     */
    public void setLeadername(String  leadername){
        this.leadername = leadername ;
        this.modify("leadername",leadername);
    }


}

