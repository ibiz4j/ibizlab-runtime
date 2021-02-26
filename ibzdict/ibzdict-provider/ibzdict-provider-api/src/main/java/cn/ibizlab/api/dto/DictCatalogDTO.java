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
 * 服务DTO对象[DictCatalogDTO]
 */
@Data
@ApiModel("字典")
public class DictCatalogDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("标识")
    private String id;

    /**
     * 属性 [CCODE]
     *
     */
    @JSONField(name = "code")
    @JsonProperty("code")
    @NotBlank(message = "[代码]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("代码")
    private String code;

    /**
     * 属性 [CNAME]
     *
     */
    @JSONField(name = "name")
    @JsonProperty("name")
    @NotBlank(message = "[名称]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("名称")
    private String name;

    /**
     * 属性 [CGROUP]
     *
     */
    @JSONField(name = "group")
    @JsonProperty("group")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("分组")
    private String group;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @Size(min = 0, max = 255, message = "内容长度必须小于等于[255]")
    @ApiModelProperty("备注")
    private String memo;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    @ApiModelProperty("是否有效")
    private Integer enable;

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
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @ApiModelProperty("创建时间")
    private Timestamp createdate;


    /**
     * 设置 [CCODE]
     */
    public void setCode(String  code){
        this.code = code ;
        this.modify("ccode",code);
    }

    /**
     * 设置 [CNAME]
     */
    public void setName(String  name){
        this.name = name ;
        this.modify("cname",name);
    }

    /**
     * 设置 [CGROUP]
     */
    public void setGroup(String  group){
        this.group = group ;
        this.modify("cgroup",group);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }


}


