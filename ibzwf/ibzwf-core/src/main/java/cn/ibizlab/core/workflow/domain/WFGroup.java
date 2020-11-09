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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 实体[角色/用户组]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZWFGROUP",resultMap = "WFGroupResultMap")
public class WFGroup extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组标识
     */
    @DEField(name = "groupid" , isKeyField=true)
    @TableId(value= "groupid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;
    /**
     * 组名称
     */
    @DEField(name = "groupname")
    @TableField(value = "groupname")
    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;
    /**
     * 范围
     */
    @TableField(value = "groupscope")
    @JSONField(name = "groupscope")
    @JsonProperty("groupscope")
    private String groupscope;


    /**
     * 成员
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private List<cn.ibizlab.core.workflow.domain.WFMember> wfmember;


    /**
     * 设置 [组名称]
     */
    public void setName(String name){
        this.name = name ;
        this.modify("groupname",name);
    }

    /**
     * 设置 [范围]
     */
    public void setGroupscope(String groupscope){
        this.groupscope = groupscope ;
        this.modify("groupscope",groupscope);
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
        this.reset("groupid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


