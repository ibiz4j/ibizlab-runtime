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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;

/**
 * 实体[岗位]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZPOST",resultMap = "IBZPostResultMap")
public class IBZPost extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 岗位标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "postid",type=IdType.UUID)
    @JSONField(name = "postid")
    @JsonProperty("postid")
    private String postid;
    /**
     * 岗位编码
     */
    @TableField(value = "postcode")
    @JSONField(name = "postcode")
    @JsonProperty("postcode")
    private String postcode;
    /**
     * 岗位名称
     */
    @TableField(value = "postname")
    @JSONField(name = "postname")
    @JsonProperty("postname")
    private String postname;
    /**
     * 区属
     */
    @TableField(value = "domains")
    @JSONField(name = "domains")
    @JsonProperty("domains")
    private String domains;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;



    /**
     * 设置 [岗位编码]
     */
    public void setPostcode(String postcode){
        this.postcode = postcode ;
        this.modify("postcode",postcode);
    }

    /**
     * 设置 [岗位名称]
     */
    public void setPostname(String postname){
        this.postname = postname ;
        this.modify("postname",postname);
    }

    /**
     * 设置 [区属]
     */
    public void setDomains(String domains){
        this.domains = domains ;
        this.modify("domains",domains);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }


}


