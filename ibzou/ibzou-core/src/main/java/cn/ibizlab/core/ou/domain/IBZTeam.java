package cn.ibizlab.core.ou.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
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


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;


/**
 * 实体[组]
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "IBZTEAM",resultMap = "IBZTeamResultMap")
public class IBZTeam extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * TEAMID
     */
    @DEField(isKeyField=true)
    @TableId(value= "teamid",type=IdType.UUID)
    @JSONField(name = "teamid")
    @JsonProperty("teamid")
    private String teamid;
    /**
     * 组名称
     */
    @TableField(value = "teamname")
    @JSONField(name = "teamname")
    @JsonProperty("teamname")
    private String teamname;



    /**
     * 设置 [组名称]
     */
    public void setTeamname(String teamname){
        this.teamname = teamname ;
        this.modify("teamname",teamname);
    }

}


