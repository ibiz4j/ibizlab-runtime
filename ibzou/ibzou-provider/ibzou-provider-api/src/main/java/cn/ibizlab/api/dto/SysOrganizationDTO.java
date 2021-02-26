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
 * 服务DTO对象[SysOrganizationDTO]
 */
@Data
@ApiModel("单位机构")
public class SysOrganizationDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("单位标识")
    private String orgid;

    /**
     * 属性 [ORGCODE]
     *
     */
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("单位代码")
    private String orgcode;

    /**
     * 属性 [ORGNAME]
     *
     */
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("名称")
    private String orgname;

    /**
     * 属性 [PORGID]
     *
     */
    @JSONField(name = "parentorgid")
    @JsonProperty("parentorgid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("上级单位")
    private String parentorgid;

    /**
     * 属性 [SHORTNAME]
     *
     */
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("单位简称")
    private String shortname;

    /**
     * 属性 [ORGLEVEL]
     *
     */
    @JSONField(name = "orglevel")
    @JsonProperty("orglevel")
    @ApiModelProperty("单位级别")
    private Integer orglevel;

    /**
     * 属性 [SHOWORDER]
     *
     */
    @JSONField(name = "showorder")
    @JsonProperty("showorder")
    @ApiModelProperty("排序")
    private Integer showorder;

    /**
     * 属性 [PORGNAME]
     *
     */
    @JSONField(name = "parentorgname")
    @JsonProperty("parentorgname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("上级单位")
    private String parentorgname;

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
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    @ApiModelProperty("逻辑有效")
    private Integer enable;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @ApiModelProperty("创建时间")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @ApiModelProperty("最后修改时间")
    private Timestamp updatedate;

    /**
     * 属性 [ISVALID]
     *
     */
    @JSONField(name = "isvalid")
    @JsonProperty("isvalid")
    @ApiModelProperty("启用标志")
    private Integer isvalid;


    /**
     * 设置 [ORGCODE]
     */
    public void setOrgcode(String  orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [PORGID]
     */
    public void setParentorgid(String  parentorgid){
        this.parentorgid = parentorgid ;
        this.modify("porgid",parentorgid);
    }

    /**
     * 设置 [SHORTNAME]
     */
    public void setShortname(String  shortname){
        this.shortname = shortname ;
        this.modify("shortname",shortname);
    }

    /**
     * 设置 [ORGLEVEL]
     */
    public void setOrglevel(Integer  orglevel){
        this.orglevel = orglevel ;
        this.modify("orglevel",orglevel);
    }

    /**
     * 设置 [SHOWORDER]
     */
    public void setShoworder(Integer  showorder){
        this.showorder = showorder ;
        this.modify("showorder",showorder);
    }

    /**
     * 设置 [DOMAINS]
     */
    public void setDomains(String  domains){
        this.domains = domains ;
        this.modify("domains",domains);
    }

    /**
     * 设置 [ISVALID]
     */
    public void setIsvalid(Integer  isvalid){
        this.isvalid = isvalid ;
        this.modify("isvalid",isvalid);
    }


}


