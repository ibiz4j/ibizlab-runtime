package cn.ibizlab.core.dict.domain;

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

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [字典项] 对象
 */
@Data
@ApiModel("字典项")
public class DictOption extends EntityClient implements Serializable {

    /**
     * 标识
     */
    @DEField(name = "vkey" , isKeyField = true)
    @JSONField(name = "value_key")
    @JsonProperty("value_key")
    @ApiModelProperty("标识")
    private String valueKey;

    /**
     * 目录代码
     */
    @DEField(name = "cid")
    @JSONField(name = "catalog_id")
    @JsonProperty("catalog_id")
    @ApiModelProperty("目录代码")
    private String catalogId;

    /**
     * 目录
     */
    @DEField(name = "cname")
    @JSONField(name = "catalog_name")
    @JsonProperty("catalog_name")
    @ApiModelProperty("目录")
    private String catalogName;

    /**
     * 代码值
     */
    @DEField(name = "val")
    @JSONField(name = "value")
    @JsonProperty("value")
    @ApiModelProperty("代码值")
    private String value;

    /**
     * 名称
     */
    @JSONField(name = "label")
    @JsonProperty("label")
    @ApiModelProperty("名称")
    private String label;

    /**
     * 父代码值
     */
    @DEField(name = "pval")
    @JSONField(name = "parent")
    @JsonProperty("parent")
    @ApiModelProperty("父代码值")
    private String parent;

    /**
     * 过滤项
     */
    @DEField(name = "vfilter")
    @JSONField(name = "filter")
    @JsonProperty("filter")
    @ApiModelProperty("过滤项")
    private String filter;

    /**
     * 栏目样式
     */
    @DEField(defaultValue = "itemcls", defaultValueType = DEFieldDefaultValueType.PARAM)
    @JSONField(name = "cls")
    @JsonProperty("cls")
    @ApiModelProperty("栏目样式")
    private String cls;

    /**
     * 图标
     */
    @DEField(name = "iconcls")
    @JSONField(name = "icon_class")
    @JsonProperty("icon_class")
    @ApiModelProperty("图标")
    private String iconClass;

    /**
     * 是否禁用
     */
    @DEField(defaultValue = "0")
    @JSONField(name = "disabled")
    @JsonProperty("disabled")
    @ApiModelProperty("是否禁用")
    private Integer disabled;

    /**
     * 过期/失效
     */
    @DEField(defaultValue = "0")
    @JSONField(name = "expired")
    @JsonProperty("expired")
    @ApiModelProperty("过期/失效")
    private Integer expired;

    /**
     * 排序
     */
    @JSONField(name = "showorder")
    @JsonProperty("showorder")
    @ApiModelProperty("排序")
    private Integer showorder;

    /**
     * 扩展
     */
    @JSONField(name = "extension")
    @JsonProperty("extension")
    @ApiModelProperty("扩展")
    private String extension;

    /**
     * 最后修改时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @ApiModelProperty("最后修改时间")
    private Timestamp updatedate;


    /**
     * 目录
     */
    @JSONField(name = "catalog")
    @JsonProperty("catalog")
    private cn.ibizlab.core.dict.domain.DictCatalog catalog;




    /**
     * 设置 [目录代码]
     */
    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId ;
        this.modify("cid",catalogId);
    }

    /**
     * 设置 [目录]
     */
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName ;
        this.modify("cname",catalogName);
    }

    /**
     * 设置 [代码值]
     */
    public void setValue(String value) {
        this.value = value ;
        this.modify("val",value);
    }

    /**
     * 设置 [名称]
     */
    public void setLabel(String label) {
        this.label = label ;
        this.modify("label",label);
    }

    /**
     * 设置 [父代码值]
     */
    public void setParent(String parent) {
        this.parent = parent ;
        this.modify("pval",parent);
    }

    /**
     * 设置 [过滤项]
     */
    public void setFilter(String filter) {
        this.filter = filter ;
        this.modify("vfilter",filter);
    }

    /**
     * 设置 [栏目样式]
     */
    public void setCls(String cls) {
        this.cls = cls ;
        this.modify("cls",cls);
    }

    /**
     * 设置 [图标]
     */
    public void setIconClass(String iconClass) {
        this.iconClass = iconClass ;
        this.modify("iconcls",iconClass);
    }

    /**
     * 设置 [是否禁用]
     */
    public void setDisabled(Integer disabled) {
        this.disabled = disabled ;
        this.modify("disabled",disabled);
    }

    /**
     * 设置 [过期/失效]
     */
    public void setExpired(Integer expired) {
        this.expired = expired ;
        this.modify("expired",expired);
    }

    /**
     * 设置 [排序]
     */
    public void setShoworder(Integer showorder) {
        this.showorder = showorder ;
        this.modify("showorder",showorder);
    }

    /**
     * 设置 [扩展]
     */
    public void setExtension(String extension) {
        this.extension = extension ;
        this.modify("extension",extension);
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
        this.reset("vkey");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


