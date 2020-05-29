package cn.ibizlab.core.uaa.extensions.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionNode
{
	private String id;
	private String label;
	private String systemid;
	private List<PermissionNode> children = new ArrayList<>();

	private String fullName;
	private PermissionType type;

	public PermissionNode setUniKey(String systemid,String id)
	{
		this.systemid=systemid;
		this.id=systemid+"-"+id;
		return this;
	}

	public List<PermissionNode> getChildren()
	{
		if(children == null)
			children = new ArrayList<>();
		return children;
	}
}
