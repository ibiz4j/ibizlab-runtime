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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 实体[字典项]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZDICTOPTION",resultMap = "DictOptionResultMap")
public class DictOption extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @DEField(name = "vkey" , isKeyField=true)
    @TableId(value= "vkey",type=IdType.ASSIGN_UUID)
    @JSONField(name = "value_key")
    @JsonProperty("value_key")
    private String valueKey;
    /**
     * 目录代码
     */
    @DEField(name = "cid")
    @TableField(value = "cid")
    @JSONField(name = "catalog_id")
    @JsonProperty("catalog_id")
    private String catalogId;
    /**
     * 目录
     */
    @DEField(name = "cname")
    @TableField(value = "cname")
    @JSONField(name = "catalog_name")
    @JsonProperty("catalog_name")
    private String catalogName;
    /**
     * 代码值
     */
    @DEField(name = "val")
    @TableField(value = "val")
    @JSONField(name = "value")
    @JsonProperty("value")
    private String value;
    /**
     * 名称
     */
    @TableField(value = "label")
    @JSONField(name = "label")
    @JsonProperty("label")
    private String label;
    /**
     * 父代码值
     */
    @DEField(name = "pval")
    @TableField(value = "pval")
    @JSONField(name = "parent")
    @JsonProperty("parent")
    private String parent;
    /**
     * 过滤项
     */
    @DEField(name = "vfilter")
    @TableField(value = "vfilter")
    @JSONField(name = "filter")
    @JsonProperty("filter")
    private String filter;
    /**
     * 栏目样式
     */
    @DEField(defaultValue = "itemcls" , defaultValueType = DEFieldDefaultValueType.PARAM)
    @TableField(value = "cls")
    @JSONField(name = "cls")
    @JsonProperty("cls")
    private String cls;
    /**
     * 图标
     */
    @DEField(name = "iconcls")
    @TableField(value = "iconcls")
    @JSONField(name = "icon_class")
    @JsonProperty("icon_class")
    private String iconClass;
    /**
     * 是否禁用
     */
    @DEField(defaultValue = "0")
    @TableField(value = "disabled")
    @JSONField(name = "disabled")
    @JsonProperty("disabled")
    private Integer disabled;
    /**
     * 过期/失效
     */
    @DEField(defaultValue = "0")
    @TableField(value = "expired")
    @JSONField(name = "expired")
    @JsonProperty("expired")
    private Integer expired;
    /**
     * 排序
     */
    @TableField(value = "showorder")
    @JSONField(name = "showorder")
    @JsonProperty("showorder")
    private Integer showorder;
    /**
     * 扩展
     */
    @TableField(value = "extension")
    @JSONField(name = "extension")
    @JsonProperty("extension")
    private String extension;
    /**
     * 最后修改时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 目录
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.dict.domain.DictCatalog catalog;



    /**
     * 设置 [目录代码]
     */
    public void setCatalogId(String catalogId){
        this.catalogId = catalogId ;
        this.modify("cid",catalogId);
    }

    /**
     * 设置 [目录]
     */
    public void setCatalogName(String catalogName){
        this.catalogName = catalogName ;
        this.modify("cname",catalogName);
    }

    /**
     * 设置 [代码值]
     */
    public void setValue(String value){
        this.value = value ;
        this.modify("val",value);
    }

    /**
     * 设置 [名称]
     */
    public void setLabel(String label){
        this.label = label ;
        this.modify("label",label);
    }

    /**
     * 设置 [父代码值]
     */
    public void setParent(String parent){
        this.parent = parent ;
        this.modify("pval",parent);
    }

    /**
     * 设置 [过滤项]
     */
    public void setFilter(String filter){
        this.filter = filter ;
        this.modify("vfilter",filter);
    }

    /**
     * 设置 [栏目样式]
     */
    public void setCls(String cls){
        this.cls = cls ;
        this.modify("cls",cls);
    }

    /**
     * 设置 [图标]
     */
    public void setIconClass(String iconClass){
        this.iconClass = iconClass ;
        this.modify("iconcls",iconClass);
    }

    /**
     * 设置 [是否禁用]
     */
    public void setDisabled(Integer disabled){
        this.disabled = disabled ;
        this.modify("disabled",disabled);
    }

    /**
     * 设置 [过期/失效]
     */
    public void setExpired(Integer expired){
        this.expired = expired ;
        this.modify("expired",expired);
    }

    /**
     * 设置 [排序]
     */
    public void setShoworder(Integer showorder){
        this.showorder = showorder ;
        this.modify("showorder",showorder);
    }

    /**
     * 设置 [扩展]
     */
    public void setExtension(String extension){
        this.extension = extension ;
        this.modify("extension",extension);
    }


    /**
     * 获取 [标识]
     */
    public String getValueKey(){
        if(ObjectUtils.isEmpty(valueKey)){
            valueKey=(String)getDefaultKey(true);
        }
        return valueKey;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getCatalogId()))&&(!ObjectUtils.isEmpty(this.getValue())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getCatalogId(),this.getValue()).getBytes());
        return null;
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


