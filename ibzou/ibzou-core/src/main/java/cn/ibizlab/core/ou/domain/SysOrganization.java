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
 * 实体[单位机构]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZORG", resultMap = "SysOrganizationResultMap")
@ApiModel("单位机构")
public class SysOrganization extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 单位标识
     */
    @DEField(defaultValue = "orgcode", defaultValueType = DEFieldDefaultValueType.PARAM, isKeyField = true)
    @TableId(value = "orgid", type = IdType.ASSIGN_UUID)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    @ApiModelProperty("单位标识")
    private String orgid;
    /**
     * 单位代码
     */
    @TableField(value = "orgcode")
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    @ApiModelProperty("单位代码")
    private String orgcode;
    /**
     * 名称
     */
    @DEField(preType = DEPredefinedFieldType.ORGNAME)
    @TableField(value = "orgname")
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    @ApiModelProperty("名称")
    private String orgname;
    /**
     * 上级单位
     */
    @DEField(name = "porgid")
    @TableField(value = "porgid")
    @JSONField(name = "parentorgid")
    @JsonProperty("parentorgid")
    @ApiModelProperty("上级单位")
    private String parentorgid;
    /**
     * 单位简称
     */
    @TableField(value = "shortname")
    @JSONField(name = "shortname")
    @JsonProperty("shortname")
    @ApiModelProperty("单位简称")
    private String shortname;
    /**
     * 单位级别
     */
    @TableField(value = "orglevel")
    @JSONField(name = "orglevel")
    @JsonProperty("orglevel")
    @ApiModelProperty("单位级别")
    private Integer orglevel;
    /**
     * 排序
     */
    @TableField(value = "showorder")
    @JSONField(name = "showorder")
    @JsonProperty("showorder")
    @ApiModelProperty("排序")
    private Integer showorder;
    /**
     * 上级单位
     */
    @TableField(exist = false)
    @JSONField(name = "parentorgname")
    @JsonProperty("parentorgname")
    @ApiModelProperty("上级单位")
    private String parentorgname;
    /**
     * 区属
     */
    @TableField(value = "domains")
    @JSONField(name = "domains")
    @JsonProperty("domains")
    @ApiModelProperty("区属")
    private String domains;
    /**
     * 逻辑有效
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1", logicdelval = "0")
    @TableLogic(value = "1", delval = "0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    @ApiModelProperty("逻辑有效")
    private Integer enable;
    /**
     * 创建时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate", format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @ApiModelProperty("创建时间")
    private Timestamp createdate;
    /**
     * 最后修改时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate", format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @ApiModelProperty("最后修改时间")
    private Timestamp updatedate;
    /**
     * 启用标志
     */
    @DEField(defaultValue = "1")
    @TableField(value = "isvalid")
    @JSONField(name = "isvalid")
    @JsonProperty("isvalid")
    @ApiModelProperty("启用标志")
    private Integer isvalid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.ou.domain.SysOrganization parentorg;


    /**
     * 部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private List<cn.ibizlab.core.ou.domain.SysDepartment> depts;


    /**
     * 设置 [单位代码]
     */
    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
        this.modify("orgcode", orgcode);
    }

    /**
     * 设置 [上级单位]
     */
    public void setParentorgid(String parentorgid) {
        this.parentorgid = parentorgid;
        this.modify("porgid", parentorgid);
    }

    /**
     * 设置 [单位简称]
     */
    public void setShortname(String shortname) {
        this.shortname = shortname;
        this.modify("shortname", shortname);
    }

    /**
     * 设置 [单位级别]
     */
    public void setOrglevel(Integer orglevel) {
        this.orglevel = orglevel;
        this.modify("orglevel", orglevel);
    }

    /**
     * 设置 [排序]
     */
    public void setShoworder(Integer showorder) {
        this.showorder = showorder;
        this.modify("showorder", showorder);
    }

    /**
     * 设置 [区属]
     */
    public void setDomains(String domains) {
        this.domains = domains;
        this.modify("domains", domains);
    }

    /**
     * 设置 [启用标志]
     */
    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
        this.modify("isvalid", isvalid);
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
        this.reset("orgid");
        return super.copyTo(targetEntity, bIncEmpty);
    }
}


