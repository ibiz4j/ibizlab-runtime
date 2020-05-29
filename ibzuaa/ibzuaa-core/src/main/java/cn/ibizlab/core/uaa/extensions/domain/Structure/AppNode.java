package cn.ibizlab.core.uaa.extensions.domain.Structure;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AppNode
{
	private String appid;
	private String appname;

	@JsonProperty("appmenu")
	@JSONField(name = "appmenu")
	private List<MenuNode> appmenus;
}
