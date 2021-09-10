package cn.ibizlab.util.dict;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import liquibase.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	@JsonIgnore
	@JSONField(serialize = false)
	private List<CodeItem> children;
	private String iconClass;
	private String filter;
	private Boolean disabled;
	@JSONField(name = "pvalue")
	@JsonProperty("pvalue")
	private String parent;
	private Map<String,Object> extension;

	@JSONField(name = "text")
	@JsonProperty("text")
	public String getText()
	{
		return label;
	}

	@JsonIgnore
	@JSONField(serialize = false)
	public Set<String> getFilterSet()
	{
		Set<String> set=new HashSet<>();
		if(!StringUtils.isEmpty(filter))
			for(String str:filter.split(";|,"))
				set.add(str);
		return set;
	}
}
