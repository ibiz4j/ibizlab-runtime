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
import lombok.Data;

/**
 * 服务DTO对象[DictOptionDTO]
 */
@Data
public class DictOptionDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [VKEY]
     *
     */
    @JSONField(name = "value_key")
    @JsonProperty("value_key")
    private String valueKey;

    /**
     * 属性 [CID]
     *
     */
    @JSONField(name = "catalog_id")
    @JsonProperty("catalog_id")
    private String catalogId;

    /**
     * 属性 [CNAME]
     *
     */
    @JSONField(name = "catalog_name")
    @JsonProperty("catalog_name")
    private String catalogName;

    /**
     * 属性 [VAL]
     *
     */
    @JSONField(name = "value")
    @JsonProperty("value")
    private String value;

    /**
     * 属性 [LABEL]
     *
     */
    @JSONField(name = "label")
    @JsonProperty("label")
    private String label;

    /**
     * 属性 [PVAL]
     *
     */
    @JSONField(name = "parent")
    @JsonProperty("parent")
    private String parent;

    /**
     * 属性 [VFILTER]
     *
     */
    @JSONField(name = "filter")
    @JsonProperty("filter")
    private String filter;

    /**
     * 属性 [CLS]
     *
     */
    @JSONField(name = "cls")
    @JsonProperty("cls")
    private String cls;

    /**
     * 属性 [ICONCLS]
     *
     */
    @JSONField(name = "icon_class")
    @JsonProperty("icon_class")
    private String iconClass;

    /**
     * 属性 [DISABLED]
     *
     */
    @JSONField(name = "disabled")
    @JsonProperty("disabled")
    private Integer disabled;

    /**
     * 属性 [EXPIRED]
     *
     */
    @JSONField(name = "expired")
    @JsonProperty("expired")
    private Integer expired;

    /**
     * 属性 [SHOWORDER]
     *
     */
    @JSONField(name = "showorder")
    @JsonProperty("showorder")
    private Integer showorder;

    /**
     * 属性 [EXTENSION]
     *
     */
    @JSONField(name = "extension")
    @JsonProperty("extension")
    private String extension;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
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

