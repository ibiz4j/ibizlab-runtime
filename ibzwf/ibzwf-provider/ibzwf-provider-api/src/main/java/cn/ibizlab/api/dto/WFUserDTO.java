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
 * 服务DTO对象[WFUserDTO]
 */
@Data
public class WFUserDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [USERID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 属性 [USERNAME]
     *
     */
    @JSONField(name = "firstname")
    @JsonProperty("firstname")
    private String firstname;

    /**
     * 属性 [PERSONNAME]
     *
     */
    @JSONField(name = "displayname")
    @JsonProperty("displayname")
    private String displayname;


    /**
     * 设置 [USERNAME]
     */
    public void setFirstname(String  firstname){
        this.firstname = firstname ;
        this.modify("username",firstname);
    }

    /**
     * 设置 [PERSONNAME]
     */
    public void setDisplayname(String  displayname){
        this.displayname = displayname ;
        this.modify("personname",displayname);
    }


}

