package cn.ibizlab.core.ou.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import cn.ibizlab.util.helper.DataObject;
import cn.ibizlab.util.enums.DupCheck;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;
import cn.ibizlab.util.annotation.Audit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 实体[组]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZTEAM", resultMap = "SysTeamResultMap")
@ApiModel("组")
public class SysTeam extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组标识
     */
    @DEField(isKeyField = true)
    @TableId(value = "teamid", type = IdType.ASSIGN_UUID)
    @JSONField(name = "teamid")
    @JsonProperty("teamid")
    @ApiModelProperty("组标识")
    private String teamid;
    /**
     * 组名称
     */
    @TableField(value = "teamname")
    @JSONField(name = "teamname")
    @JsonProperty("teamname")
    @ApiModelProperty("组名称")
    private String teamname;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @ApiModelProperty("备注")
    private String memo;
    /**
     * 区属
     */
    @TableField(value = "domains")
    @JSONField(name = "domains")
    @JsonProperty("domains")
    @ApiModelProperty("区属")
    private String domains;



    /**
     * 设置 [组名称]
     */
    public void setTeamname(String teamname) {
        this.teamname = teamname;
        this.modify("teamname", teamname);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
    }

    /**
     * 设置 [区属]
     */
    public void setDomains(String domains) {
        this.domains = domains;
        this.modify("domains", domains);
    }


    /**
     * 复制当前对象数据到目标对象(粘贴重置)
     * @param targetEntity 目标数据对象
     * @param bIncEmpty  是否包括空值
     * @param <T>
     * @return
     */
    @Override
    public <T> T copyTo(T targetEntity, boolean bIncEmpty) {
        this.reset("teamid");
        return super.copyTo(targetEntity, bIncEmpty);
    }
}


