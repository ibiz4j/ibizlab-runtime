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
 * 服务DTO对象[WFGroupDTO]
 */
@Data
public class WFGroupDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [GROUPID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 属性 [GROUPNAME]
     *
     */
    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;

    /**
     * 属性 [GROUPSCOPE]
     *
     */
    @JSONField(name = "groupscope")
    @JsonProperty("groupscope")
    private String groupscope;


    /**
     * 设置 [GROUPNAME]
     */
    public void setName(String  name){
        this.name = name ;
        this.modify("groupname",name);
    }

    /**
     * 设置 [GROUPSCOPE]
     */
    public void setGroupscope(String  groupscope){
        this.groupscope = groupscope ;
        this.modify("groupscope",groupscope);
    }


}

