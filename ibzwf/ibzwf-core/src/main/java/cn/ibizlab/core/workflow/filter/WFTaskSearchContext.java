package cn.ibizlab.core.workflow.filter;

import cn.ibizlab.core.workflow.domain.WFTask;
import cn.ibizlab.util.filter.QueryWrapperContext;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;

/**
 * 关系型数据实体[WFTask] 查询条件对象
 */
@Slf4j
@Data
public class WFTaskSearchContext extends QueryWrapperContext<WFTask> {

    private String n_taskname_like;//[状态]
    public void setN_taskname_like(String n_taskname_like) {
        this.n_taskname_like = n_taskname_like;
        if(!ObjectUtils.isEmpty(this.n_taskname_like)){
            this.getSearchCond().like("taskname", n_taskname_like);
        }
    }
    private String n_definitionid_eq;//[DefinitionId]
    public void setN_definitionid_eq(String n_definitionid_eq) {
        this.n_definitionid_eq = n_definitionid_eq;
        if(!ObjectUtils.isEmpty(this.n_definitionid_eq)){
            this.getSearchCond().eq("definitionid", n_definitionid_eq);
        }
    }
    private String n_definitionkey_eq;//[DefinitionKey]
    public void setN_definitionkey_eq(String n_definitionkey_eq) {
        this.n_definitionkey_eq = n_definitionkey_eq;
        if(!ObjectUtils.isEmpty(this.n_definitionkey_eq)){
            this.getSearchCond().eq("definitionkey", n_definitionkey_eq);
        }
    }
    private String n_definitionkey_leftlike;//[DefinitionKey]
    public void setN_definitionkey_leftlike(String n_definitionkey_leftlike) {
        this.n_definitionkey_leftlike = n_definitionkey_leftlike;
        if(!ObjectUtils.isEmpty(this.n_definitionkey_leftlike)){
            this.getSearchCond().likeRight("definitionkey", n_definitionkey_leftlike);
        }
    }
    private String n_definitionkey_like;//[DefinitionKey]
    public void setN_definitionkey_like(String n_definitionkey_like) {
        this.n_definitionkey_like = n_definitionkey_like;
        if(!ObjectUtils.isEmpty(this.n_definitionkey_like)){
            this.getSearchCond().like("definitionkey", n_definitionkey_like);
        }
    }
    private String n_definitionname_like;//[流程]
    public void setN_definitionname_like(String n_definitionname_like) {
        this.n_definitionname_like = n_definitionname_like;
        if(!ObjectUtils.isEmpty(this.n_definitionname_like)){
            this.getSearchCond().like("definitionname", n_definitionname_like);
        }
    }
    private String n_taskdefinitionkey_eq;//[TaskDefinitionKey]
    public void setN_taskdefinitionkey_eq(String n_taskdefinitionkey_eq) {
        this.n_taskdefinitionkey_eq = n_taskdefinitionkey_eq;
        if(!ObjectUtils.isEmpty(this.n_taskdefinitionkey_eq)){
            this.getSearchCond().eq("taskdefinitionkey", n_taskdefinitionkey_eq);
        }
    }
    private String n_taskdefinitionkey_like;//[TaskDefinitionKey]
    public void setN_taskdefinitionkey_like(String n_taskdefinitionkey_like) {
        this.n_taskdefinitionkey_like = n_taskdefinitionkey_like;
        if(!ObjectUtils.isEmpty(this.n_taskdefinitionkey_like)){
            this.getSearchCond().like("taskdefinitionkey", n_taskdefinitionkey_like);
        }
    }
    private String n_description_like;//[待办事项]
    public void setN_description_like(String n_description_like) {
        this.n_description_like = n_description_like;
        if(!ObjectUtils.isEmpty(this.n_description_like)){
            this.getSearchCond().like("description", n_description_like);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp n_createtime_gtandeq;//[发起时间]
    public void setN_createtime_gtandeq(Timestamp n_createtime_gtandeq) {
        this.n_createtime_gtandeq = n_createtime_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_createtime_gtandeq)){
            this.getSearchCond().ge("createtime", n_createtime_gtandeq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp n_createtime_ltandeq;//[发起时间]
    public void setN_createtime_ltandeq(Timestamp n_createtime_ltandeq) {
        this.n_createtime_ltandeq = n_createtime_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_createtime_ltandeq)){
            this.getSearchCond().le("createtime", n_createtime_ltandeq);
        }
    }
    private String n_businesskey_eq;//[业务键值]
    public void setN_businesskey_eq(String n_businesskey_eq) {
        this.n_businesskey_eq = n_businesskey_eq;
        if(!ObjectUtils.isEmpty(this.n_businesskey_eq)){
            this.getSearchCond().eq("businesskey", n_businesskey_eq);
        }
    }

    /**
     * 启用快速搜索
     */
    public void setQuery(String query)
    {
        this.query=query;
        if(!StringUtils.isEmpty(query)){
            this.getSearchCond().and( wrapper ->
                    wrapper.like("taskname", query)
            );
        }
    }
}



