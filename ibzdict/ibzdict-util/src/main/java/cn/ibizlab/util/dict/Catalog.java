package cn.ibizlab.util.dict;


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
public class Catalog
{
	private String code;
	private String name;

	@JSONField(name = "items")
	@JsonProperty("items")
	private List<Option> options = new ArrayList<>();

}
