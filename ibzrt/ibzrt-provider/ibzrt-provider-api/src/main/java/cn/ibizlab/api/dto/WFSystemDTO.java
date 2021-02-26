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
 * 服务DTO对象[WFSystemDTO]
 */
@Data
@ApiModel("系统")
public class WFSystemDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PSSYSTEMID]
     *
     */
    @JSONField(name = "pssystemid")
    @JsonProperty("pssystemid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("系统标识")
    private String pssystemid;

    /**
     * 属性 [PSSYSTEMNAME]
     *
     */
    @JSONField(name = "pssystemname")
    @JsonProperty("pssystemname")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("系统名称")
    private String pssystemname;


    /**
     * 设置 [PSSYSTEMNAME]
     */
    public void setPssystemname(String  pssystemname){
        this.pssystemname = pssystemname ;
        this.modify("pssystemname",pssystemname);
    }


}


