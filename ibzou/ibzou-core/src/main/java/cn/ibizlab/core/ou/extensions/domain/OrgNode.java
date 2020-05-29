package cn.ibizlab.core.ou.extensions.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrgNode {

    @JSONField(name = "id")
    @JsonProperty("id")
    private String orgid;

    @JSONField(name = "label")
    @JsonProperty("label")
    private String orgname;

    @JSONField(name = "code")
    @JsonProperty("code")
    private String orgcode;

    @JSONField(name = "level")
    @JsonProperty("level")
    private Integer orglevel;

    @JSONField(name = "filter")
    @JsonProperty("filter")
    private List<String> filter = new ArrayList<>();

    private List<OrgNode> children = new ArrayList<>();

    private boolean disabled = false;

    public boolean getIsLeaf()
    {
        return children.size()==0;
    }


}
