package cn.ibizlab.core.uaa.extensions.domain.Structure;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EntityNode
{
	private String dename;
	private String delogicname;

	@JsonProperty("sysmoudle")
	@JSONField(name = "sysmoudle")
	private FuncItem moudle;

	@JsonProperty("dedataset")
	@JSONField(name = "dedataset")
	private List<FuncItem> dataSets;

	@JsonProperty("deaction")
	@JSONField(name = "deaction")
	private List<FuncItem> actions;

	@JsonProperty("datascope")
	@JSONField(name = "datascope")
	private List<FuncItem> scopes;
}
