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
 * 实体[用户]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZUSER", resultMap = "WFUserResultMap")
public class WFUser extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户标识
     */
    @DEField(name = "userid", isKeyField = true)
    @TableId(value = "userid", type = IdType.ASSIGN_UUID)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;
    /**
     * 用户全局名
     */
    @DEField(name = "username")
    @TableField(value = "username")
    @JSONField(name = "firstname")
    @JsonProperty("firstname")
    private String firstname;
    /**
     * 用户名称
     */
    @DEField(name = "personname")
    @TableField(value = "personname")
    @JSONField(name = "displayname")
    @JsonProperty("displayname")
    private String displayname;
    /**
     * 主部门
     */
    @TableField(value = "mdeptid")
    @JSONField(name = "mdeptid")
    @JsonProperty("mdeptid")
    private String mdeptid;
    /**
     * 主部门代码
     */
    @TableField(value = "mdeptcode")
    @JSONField(name = "mdeptcode")
    @JsonProperty("mdeptcode")
    private String mdeptcode;
    /**
     * 主部门名称
     */
    @TableField(value = "mdeptname")
    @JSONField(name = "mdeptname")
    @JsonProperty("mdeptname")
    private String mdeptname;
    /**
     * 业务编码
     */
    @TableField(value = "bcode")
    @JSONField(name = "bcode")
    @JsonProperty("bcode")
    private String bcode;
    /**
     * 单位
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @TableField(value = "orgid")
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 单位代码
     */
    @TableField(value = "orgcode")
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;
    /**
     * 单位名称
     */
    @DEField(preType = DEPredefinedFieldType.ORGNAME)
    @TableField(value = "orgname")
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;



    /**
     * 设置 [用户全局名]
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
        this.modify("username", firstname);
    }

    /**
     * 设置 [用户名称]
     */
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
        this.modify("personname", displayname);
    }

    /**
     * 设置 [主部门]
     */
    public void setMdeptid(String mdeptid) {
        this.mdeptid = mdeptid;
        this.modify("mdeptid", mdeptid);
    }

    /**
     * 设置 [主部门代码]
     */
    public void setMdeptcode(String mdeptcode) {
        this.mdeptcode = mdeptcode;
        this.modify("mdeptcode", mdeptcode);
    }

    /**
     * 设置 [主部门名称]
     */
    public void setMdeptname(String mdeptname) {
        this.mdeptname = mdeptname;
        this.modify("mdeptname", mdeptname);
    }

    /**
     * 设置 [业务编码]
     */
    public void setBcode(String bcode) {
        this.bcode = bcode;
        this.modify("bcode", bcode);
    }

    /**
     * 设置 [单位代码]
     */
    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
        this.modify("orgcode", orgcode);
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
        this.reset("userid");
        return super.copyTo(targetEntity, bIncEmpty);
    }
}


