package cn.ibizlab.core.dict.extensions.vo;


import cn.ibizlab.util.annotation.DEField;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
