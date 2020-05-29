package cn.ibizlab.core.ou.extensions.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DeptNode {

    @JSONField(name = "id")
    @JsonProperty("id")
    private String deptid;

    @JSONField(name = "label")
    @JsonProperty("label")
    private String deptname;

    @JSONField(name = "code")
    @JsonProperty("code")
    private String deptcode;

    @JSONField(name = "level")
    @JsonProperty("level")
    private Integer deptlevel;

    @JSONField(name = "bcode")
    @JsonProperty("bcode")
    private String bcode;

    @JSONField(name = "filter")
    @JsonProperty("filter")
    private List<String> filter = new ArrayList<>();

    private List<DeptNode> children = new ArrayList<>();

    private boolean disabled = false;

    public boolean getIsLeaf()
    {
        return children.size()==0;
    }
}
