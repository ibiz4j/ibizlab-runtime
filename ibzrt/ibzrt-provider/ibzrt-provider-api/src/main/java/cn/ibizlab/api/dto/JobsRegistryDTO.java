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
 * 服务DTO对象[JobsRegistryDTO]
 */
@Data
public class JobsRegistryDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 属性 [APP]
     *
     */
    @JSONField(name = "app")
    @JsonProperty("app")
    private String app;

    /**
     * 属性 [ADDRESS]
     *
     */
    @JSONField(name = "address")
    @JsonProperty("address")
    private String address;

    /**
     * 属性 [STATUS]
     *
     */
    @JSONField(name = "status")
    @JsonProperty("status")
    private Integer status;

    /**
     * 属性 [UPDATE_TIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "update_time" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
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

