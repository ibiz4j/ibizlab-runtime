import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		roleid: commonLogic.appcommonhandle("角色标识",null),
		rolename: commonLogic.appcommonhandle("角色名称",null),
		memo: commonLogic.appcommonhandle("备注",null),
		proleid: commonLogic.appcommonhandle("父角色标识",null),
		prolename: commonLogic.appcommonhandle("父角色名称",null),
		createdate: commonLogic.appcommonhandle("建立时间",null),
		updatedate: commonLogic.appcommonhandle("更新时间",null),
		createman: commonLogic.appcommonhandle("建立人",null),
		updateman: commonLogic.appcommonhandle("更新人",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("角色",null),
				title: commonLogic.appcommonhandle("角色",null),
			},
			pickupview: {
				caption: commonLogic.appcommonhandle("系统角色",null),
				title: commonLogic.appcommonhandle("角色数据选择视图",null),
			},
			pickupgridview_norepeat: {
				caption: commonLogic.appcommonhandle("系统角色",null),
				title: commonLogic.appcommonhandle("角色选择表格视图",null),
			},
			redirectview: {
				caption: commonLogic.appcommonhandle("系统角色",null),
				title: commonLogic.appcommonhandle("角色数据重定向视图",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("角色",null),
				title: commonLogic.appcommonhandle("角色",null),
			},
			pickupgridview: {
				caption: commonLogic.appcommonhandle("系统角色",null),
				title: commonLogic.appcommonhandle("角色选择表格视图",null),
			},
			editview2: {
				caption: commonLogic.appcommonhandle("角色",null),
				title: commonLogic.appcommonhandle("角色",null),
			},
			mpickupview: {
				caption: commonLogic.appcommonhandle("系统角色",null),
				title: commonLogic.appcommonhandle("角色数据多项选择视图",null),
			},
			pickupview_norepeat: {
				caption: commonLogic.appcommonhandle("系统角色",null),
				title: commonLogic.appcommonhandle("角色数据选择视图",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("角色表基本信息",null), 
				druipart1: commonLogic.appcommonhandle("权限",null), 
				tabpage1: commonLogic.appcommonhandle("权限",null), 
				druipart2: commonLogic.appcommonhandle("用户",null), 
				tabpage2: commonLogic.appcommonhandle("用户",null), 
				tabpanel1: commonLogic.appcommonhandle("",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("更新时间",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("角色标识",null), 
				srfmajortext: commonLogic.appcommonhandle("角色名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				sys_rolename: commonLogic.appcommonhandle("角色名称",null), 
				prolename: commonLogic.appcommonhandle("父角色名称",null), 
				memo: commonLogic.appcommonhandle("备注",null), 
				sys_roleid: commonLogic.appcommonhandle("角色标识",null), 
				proleid: commonLogic.appcommonhandle("父角色标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				sys_roleid: commonLogic.appcommonhandle("角色标识",null),
				sys_rolename: commonLogic.appcommonhandle("角色名称",null),
				prolename: commonLogic.appcommonhandle("父角色名称",null),
				memo: commonLogic.appcommonhandle("备注",null),
				updatedate: commonLogic.appcommonhandle("更新时间",null),
				proleid: commonLogic.appcommonhandle("父角色标识",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_sys_rolename_like: commonLogic.appcommonhandle("角色名称(%)",null), 
			},
			uiactions: {
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("保存",null),
				tip: commonLogic.appcommonhandle("保存",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			deuiaction1: {
				caption: commonLogic.appcommonhandle("关闭",null),
				tip: commonLogic.appcommonhandle("关闭",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem14: {
				caption: commonLogic.appcommonhandle("拷贝",null),
				tip: commonLogic.appcommonhandle("拷贝",null),
			},
		},
		gridviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("新建",null),
				tip: commonLogic.appcommonhandle("新建",null),
			},
			tbitem4: {
				caption: commonLogic.appcommonhandle("编辑",null),
				tip: commonLogic.appcommonhandle("编辑",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("拷贝",null),
				tip: commonLogic.appcommonhandle("拷贝",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem8: {
				caption: commonLogic.appcommonhandle("删除",null),
				tip: commonLogic.appcommonhandle("删除",null),
			},
			tbitem9: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("导出",null),
				tip: commonLogic.appcommonhandle("导出",null),
			},
			tbitem10: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem19: {
				caption: commonLogic.appcommonhandle("过滤",null),
				tip: commonLogic.appcommonhandle("过滤",null),
			},
		},
		editview2toolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("保存",null),
				tip: commonLogic.appcommonhandle("保存",null),
			},
			tbitem5: {
				caption: commonLogic.appcommonhandle("保存并关闭",null),
				tip: commonLogic.appcommonhandle("保存并关闭",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem12: {
				caption: commonLogic.appcommonhandle("新建",null),
				tip: commonLogic.appcommonhandle("新建",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem14: {
				caption: commonLogic.appcommonhandle("拷贝",null),
				tip: commonLogic.appcommonhandle("拷贝",null),
			},
		},
	};
	return data;
}
export default getLocaleResourceBase;