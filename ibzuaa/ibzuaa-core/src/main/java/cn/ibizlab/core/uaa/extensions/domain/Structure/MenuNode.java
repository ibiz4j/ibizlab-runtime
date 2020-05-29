package cn.ibizlab.core.uaa.extensions.domain.Structure;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MenuNode
{
	private String menuid;
	private String menuname;

	@JsonProperty("menuitem")
	@JSONField(name = "menuitem")
	private List<FuncItem> menuitems;
}
