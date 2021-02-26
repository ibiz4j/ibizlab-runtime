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
 * 服务DTO对象[JobsRegistryDTO]
 */
@Data
@ApiModel("任务注册信息")
public class JobsRegistryDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("主键ID")
    private String id;

    /**
     * 属性 [APP]
     *
     */
    @JSONField(name = "app")
    @JsonProperty("app")
    @NotBlank(message = "[服务名]不允许为空!")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("服务名")
    private String app;

    /**
     * 属性 [ADDRESS]
     *
     */
    @JSONField(name = "address")
    @JsonProperty("address")
    @NotBlank(message = "[执行地址]不允许为空!")
    @Size(min = 0, max = 255, message = "内容长度必须小于等于[255]")
    @ApiModelProperty("执行地址")
    private String address;

    /**
     * 属性 [STATUS]
     *
     */
    @JSONField(name = "status")
    @JsonProperty("status")
    @NotNull(message = "[状态]不允许为空!")
    @ApiModelProperty("状态")
    private Integer status;

    /**
     * 属性 [UPDATE_TIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "update_time" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @NotNull(message = "[更新时间]不允许为空!")
    @ApiModelProperty("更新时间")
    private Timestamp updateTime;


    /**
     * 设置 [APP]
     */
    public void setApp(String  app){
        this.app = app ;
        this.modify("app",app);
    }

    /**
     * 设置 [ADDRESS]
     */
    public void setAddress(String  address){
        this.address = address ;
        this.modify("address",address);
    }

    /**
     * 设置 [STATUS]
     */
    public void setStatus(Integer  status){
        this.status = status ;
        this.modify("status",status);
    }

    /**
     * 设置 [UPDATE_TIME]
     */
    public void setUpdateTime(Timestamp  updateTime){
        this.updateTime = updateTime ;
        this.modify("update_time",updateTime);
    }


}


