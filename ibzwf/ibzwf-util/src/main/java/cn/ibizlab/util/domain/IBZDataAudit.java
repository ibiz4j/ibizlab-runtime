package cn.ibizlab.util.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 实体[DataAudit] 数据对象
 */
@TableName(value = "IBZDATAAUDIT")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class IBZDataAudit implements Serializable{

    @TableId(value= "dataauditid",type=IdType.UUID)//指定主键生成策略
    private String dataauditid;
    private String dataauditname;
    private String oppersonid;
    private String oppersonname;
    private String audittype;
    private Timestamp optime;
    private String ipaddress;
    private String auditinfo;
    private Object auditobjectdata;
    private String auditobject;
    private int isdatachanged;

}