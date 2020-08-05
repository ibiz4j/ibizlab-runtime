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
import cn.ibizlab.util.domain.DTOClient;
import lombok.Data;

/**
 * 服务DTO对象[WFREModelDTO]
 */
@Data
public class WFREModelDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [MODELID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 属性 [MODELNAME]
     *
     */
    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;

    /**
     * 属性 [BPMNFILE]
     *
     */
    @JSONField(name = "bpmnfile")
    @JsonProperty("bpmnfile")
    private String bpmnfile;


    /**
     * 设置 [MODELNAME]
     */
    public void setName(String  name){
        this.name = name ;
        this.modify("modelname",name);
    }

    /**
     * 设置 [BPMNFILE]
     */
    public void setBpmnfile(String  bpmnfile){
        this.bpmnfile = bpmnfile ;
        this.modify("bpmnfile",bpmnfile);
    }


}

