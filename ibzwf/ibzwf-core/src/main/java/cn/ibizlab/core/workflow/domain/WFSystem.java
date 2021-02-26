package cn.ibizlab.core.workflow.domain;

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
 * 实体[系统]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZPSSYSTEM", resultMap = "WFSystemResultMap")
@ApiModel("系统")
public class WFSystem extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系统标识
     */
    @DEField(isKeyField = true)
    @TableId(value = "pssystemid", type = IdType.ASSIGN_UUID)
    @JSONField(name = "pssystemid")
    @JsonProperty("pssystemid")
    @ApiModelProperty("系统标识")
    private String pssystemid;
    /**
     * 系统名称
     */
    @TableField(value = "pssystemname")
    @JSONField(name = "pssystemname")
    @JsonProperty("pssystemname")
    @ApiModelProperty("系统名称")
    private String pssystemname;



    /**
     * 设置 [系统名称]
     */
    public void setPssystemname(String pssystemname) {
        this.pssystemname = pssystemname;
        this.modify("pssystemname", pssystemname);
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
        this.reset("pssystemid");
        return super.copyTo(targetEntity, bIncEmpty);
    }
}


