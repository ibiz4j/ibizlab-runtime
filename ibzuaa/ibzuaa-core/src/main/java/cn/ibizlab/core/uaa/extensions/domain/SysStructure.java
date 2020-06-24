package cn.ibizlab.core.uaa.extensions.domain;

import cn.ibizlab.core.uaa.domain.SysApp;
import cn.ibizlab.core.uaa.domain.SysPermission;
import cn.ibizlab.core.uaa.extensions.domain.Structure.AppNode;
import cn.ibizlab.core.uaa.extensions.domain.Structure.EntityNode;
import cn.ibizlab.core.uaa.extensions.domain.Structure.FuncItem;
import cn.ibizlab.core.uaa.extensions.domain.Structure.UniResNode;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.*;

@Data
public class SysStructure
{
	private String systemid;

	private List<EntityNode> entities;

	@JsonProperty("unires")
	@JSONField(name = "unires")
	private List<UniResNode> uniResIds;

	@JsonProperty("appmenus")
	@JSONField(name = "appmenus")
	private List<AppNode> apps;


	public PermissionNode getPermissionTree(PermissionType type)
	{
		PermissionNode root = PermissionNode.builder().id(systemid).label(systemid).systemid(systemid).build();
		switch (type)
		{
		case OPPRIV:
			Map<String,PermissionNode> moudlemap = new LinkedHashMap<>();
			PermissionNode emptyMoudle = PermissionNode.builder().label("未分类模块").build().setUniKey(systemid,"Ungroup");
			for(EntityNode node:this.entities) {
				PermissionNode moudle = null;
				if(node.getMoudle()!=null ) {
					if (moudlemap.containsKey(systemid+"-"+node.getMoudle().getId()))
						moudle = moudlemap.get(systemid+"-"+node.getMoudle().getId());
					else {
						moudle = PermissionNode.builder()
								.label(node.getMoudle().getName()).build()
								.setUniKey(systemid,node.getMoudle().getId());
						moudlemap.put(moudle.getId(),moudle);
					}
				}
				else {
					moudle = emptyMoudle;
					moudlemap.put("Ungroup",moudle);
				}
				PermissionNode enode = PermissionNode.builder()
						.label(node.getDelogicname()).build()
						.setUniKey(systemid,node.getDename());
				moudle.getChildren().add(enode);
				if(node.getDataSets()!=null)
					node.getDataSets().forEach(dataset->{
						String datasetname=dataset.getName();
						if(datasetname.toUpperCase().equals("DEFAULT"))
							datasetname="";
						datasetname="查询"+datasetname+"数据";
						String fullname = systemid+"/操作能力/"+enode.getLabel()+"/"+datasetname;
						PermissionNode dataSetNode = PermissionNode.builder()
								.label(datasetname).type(PermissionType.OPPRIV).fullName(fullname).build()
								.setUniKey(systemid,node.getDename()+"-search"+dataset.getId()+"-all");
						enode.getChildren().add(dataSetNode);
					});
				if(node.getActions()!=null) {
					node.getActions().forEach(action -> {
						String actionname = action.getName();
						if (action.getId().toUpperCase().equals("CREATE"))
							actionname = "新建";
						else if (action.getId().toUpperCase().equals("UPDATE"))
							actionname = "修改";
						else if (action.getId().toUpperCase().equals("REMOVE"))
							actionname = "删除";
						else if (action.getId().toUpperCase().equals("SAVE"))
							actionname = "保存";
						else if (action.getId().toUpperCase().equals("GET"))
							actionname = "查看";
						else if (action.getId().toUpperCase().equals("CHECKKEY") || action.getId().toUpperCase().equals("GETDRAFT") || action.getId().toUpperCase().indexOf("BATCH") > 0)
							return;

						if (node.getScopes() == null || node.getScopes().size() <= 1) {
							String fullname = systemid+"/操作能力/"+enode.getLabel()+"/"+actionname+"任意数据";
							enode.getChildren().add(
									PermissionNode.builder()
											.label(actionname).type(PermissionType.OPPRIV)
											.fullName(fullname).build()
											.setUniKey(systemid, node.getDename() + "-" + action.getId() + "-all"));
						}
						else {
							PermissionNode actionNode = PermissionNode.builder()
									.label(actionname).build()
									.setUniKey(systemid, enode.getId() + "-" + action.getId());
							final String preFullname = systemid+"/操作能力/"+enode.getLabel()+"/"+actionname;
							node.getScopes().forEach(scope -> {
								String scopename = scope.getName();
								if (scope.getId().equals("all"))
									scopename = "任意数据";
								else if (scope.getId().equals("createman")) {
									if (action.getId().toUpperCase().equals("CREATE"))
										return;
									scopename = "本人创建的数据";
								}
								else if (scope.getId().equals("curorg"))
									scopename = "本单位的数据";
								else if (scope.getId().equals("curorgdept"))
									scopename = "本部门的数据";
								else if (scope.getId().equals("sorg"))
									scopename = "本单位及下辖全部单位数据";
								else if (scope.getId().equals("curorgdept"))
									scopename = "本部门及下辖部门的数据";
								else
									return;
								actionNode.getChildren().add(
										PermissionNode.builder()
												.label(scopename).type(PermissionType.OPPRIV)
												.fullName(preFullname+scopename).build()
												.setUniKey(systemid, node.getDename() + "-" + action.getId() + "-" + scope.getId()));
							});
							enode.getChildren().add(actionNode);
						}
					});
				}

			}
			moudlemap.values().forEach(moudle->root.getChildren().add(moudle));
			break;
		case UNIRES:
			if(this.getUniResIds()!=null)
			{
				this.getUniResIds().forEach(uniRes->{
					root.getChildren().add(PermissionNode.builder()
							.label(uniRes.getUniresname()).type(PermissionType.UNIRES)
							.fullName(systemid+"/自定义资源/"+uniRes.getUniresname()).build()
							.setUniKey(systemid, uniRes.getUnirescode()));
				});
			}
			break;
		case APPMENU:
			if(this.getApps()!=null)
			{
				this.getApps().forEach(app->{


					if(app.getAppmenus()!=null)
					{
						app.getAppmenus().forEach(appmenu->{
							PermissionNode appMenuNode = PermissionNode.builder()
									.label("应用-"+app.getAppname()+"菜单-"+appmenu.getMenuname()).build()
									.setUniKey(systemid, app.getAppid()+"-"+appmenu.getMenuid());

							if(appmenu.getMenuitems()!=null)
							{
								appmenu.getMenuitems().forEach(item->{
									appMenuNode.getChildren().add(loopMenuItem(app.getAppid(),appmenu.getMenuid(),systemid+"/菜单/"+app.getAppname()+appmenu.getMenuname(),item));
								});
							}

							root.getChildren().add(appMenuNode);
						});
					}

				});
			}
			break;
		}


		return root;
	}

	private PermissionNode loopMenuItem(String appId,String menuId,String fullName,FuncItem item)
	{
		fullName=fullName+"/"+item.getName();
		PermissionNode itemNode = PermissionNode.builder().label(item.getName()).fullName(fullName).type(PermissionType.APPMENU).build().setUniKey(systemid,appId+"-"+menuId+"-"+item.getId());

		if(item.getItems()!=null)
		{
			final String fname=fullName;
			item.getItems().forEach(sub->{
				itemNode.getChildren().add(loopMenuItem(appId,menuId,fname,sub));
			});
		}

		return itemNode;
	}

	public Set<SysPermission> getSysPermissions(PermissionType type)
	{
		Set<SysPermission> list = new LinkedHashSet<>();
		PermissionNode root = getPermissionTree(type);
		loopPermissionNode(list,root);
		return list;
	}


	private void loopPermissionNode(Set<SysPermission> list,PermissionNode root)
	{
		if(root.getChildren()!=null){
			root.getChildren().forEach(node->{
				if(node.getType()!=null){
					SysPermission sysPermission = new SysPermission();
					sysPermission.setPermissionid(node.getId());
					sysPermission.setPermissionname(node.getFullName());
					sysPermission.setPssystemid(node.getSystemid());
					sysPermission.setPermissiontype(node.getType().toString());
					sysPermission.setUpdatedate(new Timestamp(new java.util.Date().getTime()));
					sysPermission.setEnable(1);
					list.add(sysPermission);
				}
				loopPermissionNode(list,node);
			});
		}
	}


	public List<SysApp> getSysApps(boolean web) {
		List<SysApp> apps=new ArrayList<>();

			if (this.getApps() == null)
				return apps;
			this.getApps().forEach(app-> {
				SysApp sysApp = SysApp.builder()
						.label(app.getAppname()).systemid(systemid).id(systemid.toLowerCase()+"-"+app.getAppid().toLowerCase()).build();
				apps.add(sysApp);
			});
		return apps;
	}

}
