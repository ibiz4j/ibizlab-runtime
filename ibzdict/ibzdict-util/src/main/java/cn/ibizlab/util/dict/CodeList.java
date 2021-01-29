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

	public CodeItem findCodeItem(Object value){
		for(CodeItem codeItem : options){
			if(value != null && codeItem.getValue() != null && value.equals(codeItem.getValue()))
				return codeItem;
		}
		return null;
	}

    public CodeItem findChildren(Object value){
        CodeItem resultCodeItem = this.findCodeItem(value);
        List<CodeItem> children = new ArrayList<>();
        for(CodeItem codeItem : options){
            if(value != null && resultCodeItem.getValue() != null && codeItem.getParent() != null && codeItem.getParent().equals(resultCodeItem.getValue()))
                children.add(codeItem);
        }
        resultCodeItem.setChildren(children);
        return resultCodeItem;
    }
}
