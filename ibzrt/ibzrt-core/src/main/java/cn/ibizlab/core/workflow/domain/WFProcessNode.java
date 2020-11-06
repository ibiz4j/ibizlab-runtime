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
 * ServiceApi [流程定义节点] 对象
 */
@Data
public class WFProcessNode extends EntityClient implements Serializable {

    /**
     * 节点标识
     */
    @DEField(name = "nodeid" , isKeyField=true)
    @JSONField(name = "usertaskid")
    @JsonProperty("usertaskid")
    private String usertaskid;

    /**
     * 节点名称
     */
    @DEField(name = "nodename")
    @JSONField(name = "usertaskname")
    @JsonProperty("usertaskname")
    private String usertaskname;

    /**
     * DefinitionKey
     */
    @DEField(name = "definitionkey")
    @JSONField(name = "processdefinitionkey")
    @JsonProperty("processdefinitionkey")
    private String processdefinitionkey;

    /**
     * 流程定义名称
     */
    @DEField(name = "definitionname")
    @JSONField(name = "processdefinitionname")
    @JsonProperty("processdefinitionname")
    private String processdefinitionname;

    /**
     * 版本
     */
    @JSONField(name = "version")
    @JsonProperty("version")
    private Integer version;

    /**
     * 数量
     */
    @JSONField(name = "cnt")
    @JsonProperty("cnt")
    private Integer cnt;





    /**
     * 设置 [节点名称]
     */
    public void setUsertaskname(String usertaskname){
        this.usertaskname = usertaskname ;
        this.modify("nodename",usertaskname);
    }

    /**
     * 设置 [DefinitionKey]
     */
    public void setProcessdefinitionkey(String processdefinitionkey){
        this.processdefinitionkey = processdefinitionkey ;
        this.modify("definitionkey",processdefinitionkey);
    }

    /**
     * 设置 [流程定义名称]
     */
    public void setProcessdefinitionname(String processdefinitionname){
        this.processdefinitionname = processdefinitionname ;
        this.modify("definitionname",processdefinitionname);
    }

    /**
     * 设置 [版本]
     */
    public void setVersion(Integer version){
        this.version = version ;
        this.modify("version",version);
    }

    /**
     * 设置 [数量]
     */
    public void setCnt(Integer cnt){
        this.cnt = cnt ;
        this.modify("cnt",cnt);
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
        this.reset("nodeid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


