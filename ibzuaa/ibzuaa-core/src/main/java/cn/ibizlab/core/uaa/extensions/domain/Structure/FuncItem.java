package cn.ibizlab.core.uaa.extensions.domain.Structure;

import lombok.Data;

import java.util.List;

@Data
public class FuncItem
{
	private String id;
	private String name;
	private String type;
	private List<FuncItem> items;
}
