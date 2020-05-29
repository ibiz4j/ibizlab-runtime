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
 * 服务DTO对象[IBZTeamDTO]
 */
@Data
public class IBZTeamDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [TEAMID]
     *
     */
    @JSONField(name = "teamid")
    @JsonProperty("teamid")
    private String teamid;

    /**
     * 属性 [TEAMNAME]
     *
     */
    @JSONField(name = "teamname")
    @JsonProperty("teamname")
    private String teamname;


    /**
     * 设置 [TEAMNAME]
     */
    public void setTeamname(String  teamname){
        this.teamname = teamname ;
        this.modify("teamname",teamname);
    }


}

