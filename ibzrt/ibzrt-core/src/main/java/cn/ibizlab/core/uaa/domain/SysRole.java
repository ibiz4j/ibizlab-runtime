package cn.ibizlab.core.uaa.domain;

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
 * ServiceApi [系统角色] 对象
 */
@Data
@ApiModel("系统角色")
public class SysRole extends EntityClient implements Serializable {

    /**
     * 角色标识
     */
    @DEField(name = "sys_roleid" , isKeyField = true)
    @JSONField(name = "roleid")
    @JsonProperty("roleid")
    @ApiModelProperty("角色标识")
    private String roleid;

    /**
     * 角色名称
     */
    @DEField(name = "sys_rolename")
    @JSONField(name = "rolename")
    @JsonProperty("rolename")
    @ApiModelProperty("角色名称")
    private String rolename;

    /**
     * 备注
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @ApiModelProperty("备注")
    private String memo;

    /**
     * 父角色标识
     */
    @JSONField(name = "proleid")
    @JsonProperty("proleid")
    @ApiModelProperty("父角色标识")
    private String proleid;

    /**
     * 父角色名称
     */
    @JSONField(name = "prolename")
    @JsonProperty("prolename")
    @ApiModelProperty("父角色名称")
    private String prolename;

    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @ApiModelProperty("建立时间")
    private Timestamp createdate;

    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @ApiModelProperty("更新时间")
    private Timestamp updatedate;


    /**
     * 父角色
     */
    @JSONField(name = "parent")
    @JsonProperty("parent")
    private cn.ibizlab.core.uaa.domain.SysRole parent;




    /**
     * 设置 [角色名称]
     */
    public void setRolename(String rolename) {
        this.rolename = rolename ;
        this.modify("sys_rolename",rolename);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo) {
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [父角色标识]
     */
    public void setProleid(String proleid) {
        this.proleid = proleid ;
        this.modify("proleid",proleid);
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
        this.reset("sys_roleid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


