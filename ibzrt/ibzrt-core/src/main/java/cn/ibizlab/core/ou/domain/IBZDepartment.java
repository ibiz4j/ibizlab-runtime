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
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;
import cn.ibizlab.util.annotation.Audit;

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [部门] 对象
 */
@Data
public class IBZDepartment extends EntityClient implements Serializable {

    /**
     * 部门标识
     */
    @DEField(isKeyField=true)
    @JSONField(name = "deptid")
    @JsonProperty("deptid")
    private String deptid;

    /**
     * 部门代码
     */
    @JSONField(name = "deptcode")
    @JsonProperty("deptcode")
    private String deptcode;

    /**
     * 部门名称
     */
    @JSONField(name = "deptname")
    @JsonProperty("deptname")
    private String deptname;

    /**
     * 单位
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 上级部门
     */
    @DEField(name = "pdeptid")
    @JSONField(name = "parentdeptid")
    @JsonProperty("parentdeptid")
    private String parentdeptid;

    /**
     * 部门简称
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    private String shortname;

    /**
     * 部门级别
     */
    @JSONField(name = "deptlevel")
    @JsonProperty("deptlevel")
    private Integer deptlevel;

    /**
     * 区属
     */
    @JSONField(name = "domains")
    @JsonProperty("domains")
    private String domains;

    /**
     * 排序
     */
    @JSONField(name = "showorder")
    @JsonProperty("showorder")
    private Integer showorder;

    /**
     * 业务编码
     */
    @JSONField(name = "bcode")
    @JsonProperty("bcode")
    private String bcode;

    /**
     * 分管领导标识
     */
    @JSONField(name = "leaderid")
    @JsonProperty("leaderid")
    private String leaderid;

    /**
     * 分管领导
     */
    @JSONField(name = "leadername")
    @JsonProperty("leadername")
    private String leadername;

    /**
     * 逻辑有效
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 单位
     */
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;

    /**
     * 上级部门
     */
    @JSONField(name = "parentdeptname")
    @JsonProperty("parentdeptname")
    private String parentdeptname;

    /**
     * 创建时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 最后修改时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;


    /**
     * 
     */
    @JSONField(name = "parentdept")
    @JsonProperty("parentdept")
    private cn.ibizlab.core.ou.domain.IBZDepartment parentdept;

    /**
     * 单位
     */
    @JSONField(name = "org")
    @JsonProperty("org")
    private cn.ibizlab.core.ou.domain.IBZOrganization org;




    /**
     * 设置 [部门代码]
     */
    public void setDeptcode(String deptcode){
        this.deptcode = deptcode ;
        this.modify("deptcode",deptcode);
    }

    /**
     * 设置 [部门名称]
     */
    public void setDeptname(String deptname){
        this.deptname = deptname ;
        this.modify("deptname",deptname);
    }

    /**
     * 设置 [上级部门]
     */
    public void setParentdeptid(String parentdeptid){
        this.parentdeptid = parentdeptid ;
        this.modify("pdeptid",parentdeptid);
    }

    /**
     * 设置 [部门简称]
     */
    public void setShortname(String shortname){
        this.shortname = shortname ;
        this.modify("shortname",shortname);
    }

    /**
     * 设置 [部门级别]
     */
    public void setDeptlevel(Integer deptlevel){
        this.deptlevel = deptlevel ;
        this.modify("deptlevel",deptlevel);
    }

    /**
     * 设置 [区属]
     */
    public void setDomains(String domains){
        this.domains = domains ;
        this.modify("domains",domains);
    }

    /**
     * 设置 [排序]
     */
    public void setShoworder(Integer showorder){
        this.showorder = showorder ;
        this.modify("showorder",showorder);
    }

    /**
     * 设置 [业务编码]
     */
    public void setBcode(String bcode){
        this.bcode = bcode ;
        this.modify("bcode",bcode);
    }

    /**
     * 设置 [分管领导标识]
     */
    public void setLeaderid(String leaderid){
        this.leaderid = leaderid ;
        this.modify("leaderid",leaderid);
    }

    /**
     * 设置 [分管领导]
     */
    public void setLeadername(String leadername){
        this.leadername = leadername ;
        this.modify("leadername",leadername);
    }


}


