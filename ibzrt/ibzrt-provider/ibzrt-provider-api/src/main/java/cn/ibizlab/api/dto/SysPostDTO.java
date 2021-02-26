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
 * 服务DTO对象[SysPostDTO]
 */
@Data
@ApiModel("岗位")
public class SysPostDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [POSTID]
     *
     */
    @JSONField(name = "postid")
    @JsonProperty("postid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("岗位标识")
    private String postid;

    /**
     * 属性 [POSTCODE]
     *
     */
    @JSONField(name = "postcode")
    @JsonProperty("postcode")
    @NotBlank(message = "[岗位编码]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("岗位编码")
    private String postcode;

    /**
     * 属性 [POSTNAME]
     *
     */
    @JSONField(name = "postname")
    @JsonProperty("postname")
    @NotBlank(message = "[岗位名称]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("岗位名称")
    private String postname;

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
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @Size(min = 0, max = 2000, message = "内容长度必须小于等于[2000]")
    @ApiModelProperty("备注")
    private String memo;


    /**
     * 设置 [POSTCODE]
     */
    public void setPostcode(String  postcode){
        this.postcode = postcode ;
        this.modify("postcode",postcode);
    }

    /**
     * 设置 [POSTNAME]
     */
    public void setPostname(String  postname){
        this.postname = postname ;
        this.modify("postname",postname);
    }

    /**
     * 设置 [DOMAINS]
     */
    public void setDomains(String  domains){
        this.domains = domains ;
        this.modify("domains",domains);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }


}


