import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		rolepermissionid: commonLogic.appcommonhandle("角色权限关系表标识",null),
		roleid: commonLogic.appcommonhandle("角色表标识",null),
		rolename: commonLogic.appcommonhandle("角色名称",null),
		permissionid: commonLogic.appcommonhandle("权限表标识",null),
		permissionname: commonLogic.appcommonhandle("权限名称",null),
		permissiontype: commonLogic.appcommonhandle("权限类型",null),
		permissionenable: commonLogic.appcommonhandle("权限类型",null),
		createdate: commonLogic.appcommonhandle("建立时间",null),
		updatedate: commonLogic.appcommonhandle("更新时间",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("角色权限关系",null),
				title: commonLogic.appcommonhandle("角色权限关系表表格视图",null),
			},
			mpickupview: {
				caption: commonLogic.appcommonhandle("角色权限关系",null),
				title: commonLogic.appcommonhandle("角色权限关系表数据多项选择视图",null),
			},
			pickupgridview: {
				caption: commonLogic.appcommonhandle("角色权限关系",null),
				title: commonLogic.appcommonhandle("角色权限关系表选择表格视图",null),
			},
			editview2: {
				caption: commonLogic.appcommonhandle("角色权限关系",null),
				title: commonLogic.appcommonhandle("角色权限关系表编辑视图",null),
			},
			redirectview: {
				caption: commonLogic.appcommonhandle("角色权限关系",null),
				title: commonLogic.appcommonhandle("角色权限关系表数据重定向视图",null),
			},
			customview: {
				caption: commonLogic.appcommonhandle("角色权限关系",null),
				title: commonLogic.appcommonhandle("角色权限关系自定义视图",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("角色权限关系",null),
				title: commonLogic.appcommonhandle("角色权限关系表编辑视图",null),
			},
			pickupview: {
				caption: commonLogic.appcommonhandle("角色权限关系",null),
				title: commonLogic.appcommonhandle("角色权限关系表数据选择视图",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("角色权限关系表基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("更新时间",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("角色权限关系表标识",null), 
				srfmajortext: commonLogic.appcommonhandle("权限表标识",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				sys_rolename: commonLogic.appcommonhandle("角色名称",null), 
				sys_permissionname: commonLogic.appcommonhandle("权限名称",null), 
				sys_permissionid: commonLogic.appcommonhandle("权限表标识",null), 
				sys_roleid: commonLogic.appcommonhandle("角色表标识",null), 
				sys_role_permissionid: commonLogic.appcommonhandle("角色权限关系表标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				sys_rolename: commonLogic.appcommonhandle("角色名称",null),
				sys_permissionname: commonLogic.appcommonhandle("权限名称",null),
				updatedate: commonLogic.appcommonhandle("更新时间",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
			},
			uiactions: {
			},
		},
		gridviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("New",null),
				tip: commonLogic.appcommonhandle("New",null),
			},
			tbitem4: {
				caption: commonLogic.appcommonhandle("Edit",null),
				tip: commonLogic.appcommonhandle("Edit {0}",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem8: {
				caption: commonLogic.appcommonhandle("Remove",null),
				tip: commonLogic.appcommonhandle("Remove {0}",null),
			},
			tbitem9: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("Export",null),
				tip: commonLogic.appcommonhandle("Export {0} Data To Excel",null),
			},
			tbitem10: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem19: {
				caption: commonLogic.appcommonhandle("Filter",null),
				tip: commonLogic.appcommonhandle("Filter",null),
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("Save",null),
				tip: commonLogic.appcommonhandle("Save",null),
			},
			tbitem5: {
				caption: commonLogic.appcommonhandle("Save And Close",null),
				tip: commonLogic.appcommonhandle("Save And Close Window",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem12: {
				caption: commonLogic.appcommonhandle("New",null),
				tip: commonLogic.appcommonhandle("New",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem14: {
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
			},
		},
		editview2toolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("Save",null),
				tip: commonLogic.appcommonhandle("Save",null),
			},
			tbitem5: {
				caption: commonLogic.appcommonhandle("Save And Close",null),
				tip: commonLogic.appcommonhandle("Save And Close Window",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem12: {
				caption: commonLogic.appcommonhandle("New",null),
				tip: commonLogic.appcommonhandle("New",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem14: {
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;