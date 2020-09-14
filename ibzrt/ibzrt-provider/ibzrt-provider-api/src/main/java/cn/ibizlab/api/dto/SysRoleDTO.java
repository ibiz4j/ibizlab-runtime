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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import cn.ibizlab.util.domain.DTOBase;
import cn.ibizlab.util.domain.DTOClient;
import lombok.Data;

/**
 * 服务DTO对象[SysRoleDTO]
 */
@Data
public class SysRoleDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SYS_ROLEID]
     *
     */
    @JSONField(name = "roleid")
    @JsonProperty("roleid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String roleid;

    /**
     * 属性 [SYS_ROLENAME]
     *
     */
    @JSONField(name = "rolename")
    @JsonProperty("rolename")
    @Size(min = 0, max = 200, message = "内容长度必须小于等于[200]")
    private String rolename;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String memo;

    /**
     * 属性 [PROLEID]
     *
     */
    @JSONField(name = "proleid")
    @JsonProperty("proleid")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    private String proleid;

    /**
     * 属性 [PROLENAME]
     *
     */
    @JSONField(name = "prolename")
    @JsonProperty("prolename")
    @Size(min = 0, max = 200, message = "内容长度必须小于等于[200]")
    private String prolename;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;


    /**
     * 设置 [SYS_ROLENAME]
     */
    public void setRolename(String  rolename){
        this.rolename = rolename ;
        this.modify("sys_rolename",rolename);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [PROLEID]
     */
    public void setProleid(String  proleid){
        this.proleid = proleid ;
        this.modify("proleid",proleid);
    }


}


