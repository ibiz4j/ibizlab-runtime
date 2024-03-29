package cn.ibizlab.util.dict;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Option
{
	private String id;
	private Object value;
	private String label;
	private List<Option> children;
	private String iconClass;
	private String filter;
	private Boolean disabled;
	@JsonIgnore
	@JSONField(serialize = false)
	private String parent;
	private Map<String,Object> extension;

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
