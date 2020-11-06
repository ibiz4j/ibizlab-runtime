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

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [用户] 对象
 */
@Data
public class WFUser extends EntityClient implements Serializable {

    /**
     * 用户标识
     */
    @DEField(name = "userid" , isKeyField=true)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 用户全局名
     */
    @DEField(name = "username")
    @JSONField(name = "firstname")
    @JsonProperty("firstname")
    private String firstname;

    /**
     * 用户名称
     */
    @DEField(name = "personname")
    @JSONField(name = "displayname")
    @JsonProperty("displayname")
    private String displayname;

    /**
     * 主部门
     */
    @JSONField(name = "mdeptid")
    @JsonProperty("mdeptid")
    private String mdeptid;

    /**
     * 主部门代码
     */
    @JSONField(name = "mdeptcode")
    @JsonProperty("mdeptcode")
    private String mdeptcode;

    /**
     * 主部门名称
     */
    @JSONField(name = "mdeptname")
    @JsonProperty("mdeptname")
    private String mdeptname;

    /**
     * 业务编码
     */
    @JSONField(name = "bcode")
    @JsonProperty("bcode")
    private String bcode;

    /**
     * 单位
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 单位代码
     */
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;

    /**
     * 单位名称
     */
    @DEField(preType = DEPredefinedFieldType.ORGNAME)
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;





    /**
     * 设置 [用户全局名]
     */
    public void setFirstname(String firstname){
        this.firstname = firstname ;
        this.modify("username",firstname);
    }

    /**
     * 设置 [用户名称]
     */
    public void setDisplayname(String displayname){
        this.displayname = displayname ;
        this.modify("personname",displayname);
    }

    /**
     * 设置 [主部门]
     */
    public void setMdeptid(String mdeptid){
        this.mdeptid = mdeptid ;
        this.modify("mdeptid",mdeptid);
    }

    /**
     * 设置 [主部门代码]
     */
    public void setMdeptcode(String mdeptcode){
        this.mdeptcode = mdeptcode ;
        this.modify("mdeptcode",mdeptcode);
    }

    /**
     * 设置 [主部门名称]
     */
    public void setMdeptname(String mdeptname){
        this.mdeptname = mdeptname ;
        this.modify("mdeptname",mdeptname);
    }

    /**
     * 设置 [业务编码]
     */
    public void setBcode(String bcode){
        this.bcode = bcode ;
        this.modify("bcode",bcode);
    }

    /**
     * 设置 [单位代码]
     */
    public void setOrgcode(String orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
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
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


