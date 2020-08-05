package cn.ibizlab.core.dict.extensions.vo;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CodeItem
{
	private String id;
	private Object value;
	private String label;
	@JSONField(name = "items")
	@JsonProperty("items")
	private List<CodeItem> children;
	private String iconClass;
	private String filter;
	private Boolean disabled;
	@JsonIgnore
	@JSONField(serialize = false)
	private String parent;
	private Map<String,Object> extension;

	@JSONField(name = "text")
	@JsonProperty("text")
	public String getText()
	{
		return label;
	}
}
