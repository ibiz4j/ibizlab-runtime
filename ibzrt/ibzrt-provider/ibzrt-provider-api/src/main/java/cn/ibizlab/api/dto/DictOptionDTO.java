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
 * 服务DTO对象[DictOptionDTO]
 */
@Data
@ApiModel("字典项")
public class DictOptionDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [VKEY]
     *
     */
    @JSONField(name = "value_key")
    @JsonProperty("value_key")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("标识")
    private String valueKey;

    /**
     * 属性 [CID]
     *
     */
    @JSONField(name = "catalog_id")
    @JsonProperty("catalog_id")
    @NotBlank(message = "[目录代码]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("目录代码")
    private String catalogId;

    /**
     * 属性 [CNAME]
     *
     */
    @JSONField(name = "catalog_name")
    @JsonProperty("catalog_name")
    @NotBlank(message = "[目录]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("目录")
    private String catalogName;

    /**
     * 属性 [VAL]
     *
     */
    @JSONField(name = "value")
    @JsonProperty("value")
    @NotBlank(message = "[代码值]不允许为空!")
    @Size(min = 0, max = 40, message = "内容长度必须小于等于[40]")
    @ApiModelProperty("代码值")
    private String value;

    /**
     * 属性 [LABEL]
     *
     */
    @JSONField(name = "label")
    @JsonProperty("label")
    @NotBlank(message = "[名称]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("名称")
    private String label;

    /**
     * 属性 [PVAL]
     *
     */
    @JSONField(name = "parent")
    @JsonProperty("parent")
    @Size(min = 0, max = 40, message = "内容长度必须小于等于[40]")
    @ApiModelProperty("父代码值")
    private String parent;

    /**
     * 属性 [VFILTER]
     *
     */
    @JSONField(name = "filter")
    @JsonProperty("filter")
    @Size(min = 0, max = 500, message = "内容长度必须小于等于[500]")
    @ApiModelProperty("过滤项")
    private String filter;

    /**
     * 属性 [CLS]
     *
     */
    @JSONField(name = "cls")
    @JsonProperty("cls")
    @Size(min = 0, max = 500, message = "内容长度必须小于等于[500]")
    @ApiModelProperty("栏目样式")
    private String cls;

    /**
     * 属性 [ICONCLS]
     *
     */
    @JSONField(name = "icon_class")
    @JsonProperty("icon_class")
    @Size(min = 0, max = 255, message = "内容长度必须小于等于[255]")
    @ApiModelProperty("图标")
    private String iconClass;

    /**
     * 属性 [DISABLED]
     *
     */
    @JSONField(name = "disabled")
    @JsonProperty("disabled")
    @ApiModelProperty("是否禁用")
    private Integer disabled;

    /**
     * 属性 [EXPIRED]
     *
     */
    @JSONField(name = "expired")
    @JsonProperty("expired")
    @ApiModelProperty("过期/失效")
    private Integer expired;

    /**
     * 属性 [SHOWORDER]
     *
     */
    @JSONField(name = "showorder")
    @JsonProperty("showorder")
    @ApiModelProperty("排序")
    private Integer showorder;

    /**
     * 属性 [EXTENSION]
     *
     */
    @JSONField(name = "extension")
    @JsonProperty("extension")
    @Size(min = 0, max = 1000, message = "内容长度必须小于等于[1000]")
    @ApiModelProperty("扩展")
    private String extension;

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
     * 设置 [CID]
     */
    public void setCatalogId(String  catalogId){
        this.catalogId = catalogId ;
        this.modify("cid",catalogId);
    }

    /**
     * 设置 [CNAME]
     */
    public void setCatalogName(String  catalogName){
        this.catalogName = catalogName ;
        this.modify("cname",catalogName);
    }

    /**
     * 设置 [VAL]
     */
    public void setValue(String  value){
        this.value = value ;
        this.modify("val",value);
    }

    /**
     * 设置 [LABEL]
     */
    public void setLabel(String  label){
        this.label = label ;
        this.modify("label",label);
    }

    /**
     * 设置 [PVAL]
     */
    public void setParent(String  parent){
        this.parent = parent ;
        this.modify("pval",parent);
    }

    /**
     * 设置 [VFILTER]
     */
    public void setFilter(String  filter){
        this.filter = filter ;
        this.modify("vfilter",filter);
    }

    /**
     * 设置 [CLS]
     */
    public void setCls(String  cls){
        this.cls = cls ;
        this.modify("cls",cls);
    }

    /**
     * 设置 [ICONCLS]
     */
    public void setIconClass(String  iconClass){
        this.iconClass = iconClass ;
        this.modify("iconcls",iconClass);
    }

    /**
     * 设置 [DISABLED]
     */
    public void setDisabled(Integer  disabled){
        this.disabled = disabled ;
        this.modify("disabled",disabled);
    }

    /**
     * 设置 [EXPIRED]
     */
    public void setExpired(Integer  expired){
        this.expired = expired ;
        this.modify("expired",expired);
    }

    /**
     * 设置 [SHOWORDER]
     */
    public void setShoworder(Integer  showorder){
        this.showorder = showorder ;
        this.modify("showorder",showorder);
    }

    /**
     * 设置 [EXTENSION]
     */
    public void setExtension(String  extension){
        this.extension = extension ;
        this.modify("extension",extension);
    }


}


