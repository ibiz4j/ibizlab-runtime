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
 * ServiceApi [字典] 对象
 */
@Data
@ApiModel("字典")
public class DictCatalog extends EntityClient implements Serializable {

    /**
     * 标识
     */
    @DEField(defaultValue = "code", defaultValueType = DEFieldDefaultValueType.PARAM , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty("标识")
    private String id;

    /**
     * 代码
     */
    @DEField(name = "ccode")
    @JSONField(name = "code")
    @JsonProperty("code")
    @ApiModelProperty("代码")
    private String code;

    /**
     * 名称
     */
    @DEField(name = "cname")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty("名称")
    private String name;

    /**
     * 分组
     */
    @DEField(name = "cgroup")
    @JSONField(name = "group")
    @JsonProperty("group")
    @ApiModelProperty("分组")
    private String group;

    /**
     * 备注
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @ApiModelProperty("备注")
    private String memo;

    /**
     * 是否有效
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval = "0")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    @ApiModelProperty("是否有效")
    private Integer enable;

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
     * 扩展参数
     */
    @JSONField(name = "ext_params")
    @JsonProperty("ext_params")
    @ApiModelProperty("扩展参数")
    private String extParams;





    /**
     * 设置 [代码]
     */
    public void setCode(String code) {
        this.code = code ;
        this.modify("ccode",code);
    }

    /**
     * 设置 [名称]
     */
    public void setName(String name) {
        this.name = name ;
        this.modify("cname",name);
    }

    /**
     * 设置 [分组]
     */
    public void setGroup(String group) {
        this.group = group ;
        this.modify("cgroup",group);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo) {
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [扩展参数]
     */
    public void setExtParams(String extParams) {
        this.extParams = extParams ;
        this.modify("extparams",extParams);
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
        this.reset("cid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


