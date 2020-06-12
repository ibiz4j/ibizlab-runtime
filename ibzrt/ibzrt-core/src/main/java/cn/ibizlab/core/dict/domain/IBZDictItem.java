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
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [字典项目] 对象
 */
@Data
public class IBZDictItem extends EntityClient implements Serializable {

    /**
     * 字典项目标识
     */
    @DEField(name = "ibzdictitemid" , isKeyField=true)
    @JSONField(name = "itemid")
    @JsonProperty("itemid")
    private String itemid;

    /**
     * 栏目显示值
     */
    @DEField(name = "ibzdictitemname")
    @JSONField(name = "itemname")
    @JsonProperty("itemname")
    private String itemname;

    /**
     * 栏目值
     */
    @DEField(name = "dictitemval")
    @JSONField(name = "itemval")
    @JsonProperty("itemval")
    private String itemval;

    /**
     * 字典标识
     */
    @JSONField(name = "dictid")
    @JsonProperty("dictid")
    private String dictid;

    /**
     * 父栏目值
     */
    @JSONField(name = "pitemval")
    @JsonProperty("pitemval")
    private String pitemval;

    /**
     * 过滤项
     */
    @JSONField(name = "itemfilter")
    @JsonProperty("itemfilter")
    private String itemfilter;

    /**
     * 栏目样式
     */
    @DEField(defaultValue = "itemcls" , defaultValueType = DEFieldDefaultValueType.PARAM)
    @JSONField(name = "itemcls")
    @JsonProperty("itemcls")
    private String itemcls;

    /**
     * 图标
     */
    @DEField(defaultValue = "no,png")
    @JSONField(name = "itemicon")
    @JsonProperty("itemicon")
    private String itemicon;

    /**
     * 排序
     */
    @JSONField(name = "showorder")
    @JsonProperty("showorder")
    private Integer showorder;

    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 更新时间
     */
    @DEField(defaultValueType = DEFieldDefaultValueType.CURTIME , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 更新人
     */
    @DEField(defaultValue = "SRFPERSONID" , defaultValueType = DEFieldDefaultValueType.SESSION , preType = DEPredefinedFieldType.UPDATEMAN)
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;


    /**
     * 字典
     */
    @JSONField(name = "dict")
    @JsonProperty("dict")
    private cn.ibizlab.core.dict.domain.IBZDict dict;




    /**
     * 设置 [栏目显示值]
     */
    public void setItemname(String itemname){
        this.itemname = itemname ;
        this.modify("ibzdictitemname",itemname);
    }

    /**
     * 设置 [栏目值]
     */
    public void setItemval(String itemval){
        this.itemval = itemval ;
        this.modify("dictitemval",itemval);
    }

    /**
     * 设置 [字典标识]
     */
    public void setDictid(String dictid){
        this.dictid = dictid ;
        this.modify("dictid",dictid);
    }

    /**
     * 设置 [父栏目值]
     */
    public void setPitemval(String pitemval){
        this.pitemval = pitemval ;
        this.modify("pitemval",pitemval);
    }

    /**
     * 设置 [过滤项]
     */
    public void setItemfilter(String itemfilter){
        this.itemfilter = itemfilter ;
        this.modify("itemfilter",itemfilter);
    }

    /**
     * 设置 [栏目样式]
     */
    public void setItemcls(String itemcls){
        this.itemcls = itemcls ;
        this.modify("itemcls",itemcls);
    }

    /**
     * 设置 [图标]
     */
    public void setItemicon(String itemicon){
        this.itemicon = itemicon ;
        this.modify("itemicon",itemicon);
    }

    /**
     * 设置 [排序]
     */
    public void setShoworder(Integer showorder){
        this.showorder = showorder ;
        this.modify("showorder",showorder);
    }


}


