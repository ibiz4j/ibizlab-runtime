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

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [角色/用户组] 对象
 */
@Data
@ApiModel("角色/用户组")
public class WFGroup extends EntityClient implements Serializable {

    /**
     * 组标识
     */
    @DEField(name = "groupid" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty("组标识")
    private String id;

    /**
     * 组名称
     */
    @DEField(name = "groupname")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty("组名称")
    private String name;

    /**
     * 范围
     */
    @JSONField(name = "groupscope")
    @JsonProperty("groupscope")
    @ApiModelProperty("范围")
    private String groupscope;



    /**
     * 成员
     */
    @JSONField(name = "wfmembers")
    @JsonProperty("wfmembers")
    private List<cn.ibizlab.core.workflow.domain.WFMember> wfmember;



    /**
     * 设置 [组名称]
     */
    public void setName(String name) {
        this.name = name ;
        this.modify("groupname",name);
    }

    /**
     * 设置 [范围]
     */
    public void setGroupscope(String groupscope) {
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


