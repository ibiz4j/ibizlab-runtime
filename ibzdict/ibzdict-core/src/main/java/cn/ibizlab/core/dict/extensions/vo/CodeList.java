package cn.ibizlab.core.dict.extensions.vo;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CodeList
{
	@JSONField(name = "srfkey")
	@JsonProperty("srfkey")
	private String code;
	private String name;

	@JSONField(name = "emptytext")
	@JsonProperty("emptytext")
	public String getEmptytext()
	{
		return "";
	}

	@JSONField(name = "items")
	@JsonProperty("items")
	private List<CodeItem> options = new ArrayList<>();

}
