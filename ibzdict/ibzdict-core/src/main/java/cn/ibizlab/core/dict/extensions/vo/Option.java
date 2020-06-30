package cn.ibizlab.core.dict.extensions.vo;


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
public class Option
{
	private String id;
	private Object value;
	private String label;
	private List<Option> children;
	private String iconClass;
	private String filter;
	private Boolean disabled;
	private Map<String,Object> extension;
}
