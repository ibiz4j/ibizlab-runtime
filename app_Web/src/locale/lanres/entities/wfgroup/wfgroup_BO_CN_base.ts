import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("组标识",null),
		name: commonLogic.appcommonhandle("组名称",null),
		groupscope: commonLogic.appcommonhandle("范围",null),
	},
		views: {
			pickupgridview: {
				caption: commonLogic.appcommonhandle("角色/用户组",null),
				title: commonLogic.appcommonhandle("角色/用户组选择表格视图",null),
			},
			mpickupview: {
				caption: commonLogic.appcommonhandle("角色/用户组",null),
				title: commonLogic.appcommonhandle("角色/用户组数据多项选择视图",null),
			},
			pickupview: {
				caption: commonLogic.appcommonhandle("角色/用户组",null),
				title: commonLogic.appcommonhandle("角色/用户组数据选择视图",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("流程角色",null),
				title: commonLogic.appcommonhandle("流程角色",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("流程角色",null),
				title: commonLogic.appcommonhandle("流程角色",null),
			},
		},
		main_form: {
			details: {
				druipart1: commonLogic.appcommonhandle("成员",null), 
				group1: commonLogic.appcommonhandle("角色/用户组基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("组标识",null), 
				srfmajortext: commonLogic.appcommonhandle("组名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				groupname: commonLogic.appcommonhandle("组名称",null), 
				groupscope: commonLogic.appcommonhandle("范围",null), 
				groupid: commonLogic.appcommonhandle("组标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				groupid: commonLogic.appcommonhandle("组标识",null),
				groupname: commonLogic.appcommonhandle("组名称",null),
				groupscope: commonLogic.appcommonhandle("范围",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_groupname_like: commonLogic.appcommonhandle("组名称(文本包含(%))",null), 
			},
			uiactions: {
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("保存",null),
				tip: commonLogic.appcommonhandle("保存",null),
			},
			deuiaction1: {
				caption: commonLogic.appcommonhandle("保存并关闭",null),
				tip: commonLogic.appcommonhandle("保存并关闭",null),
			},
			deuiaction2: {
				caption: commonLogic.appcommonhandle("关闭",null),
				tip: commonLogic.appcommonhandle("关闭",null),
			},
			tbitem6: {
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
			tbitem16: {
				caption: commonLogic.appcommonhandle("其它",null),
				tip: commonLogic.appcommonhandle("其它",null),
			},
			tbitem21: {
				caption: commonLogic.appcommonhandle("导出数据模型",null),
				tip: commonLogic.appcommonhandle("导出数据模型",null),
			},
			tbitem23: {
				caption: commonLogic.appcommonhandle("数据导入",null),
				tip: commonLogic.appcommonhandle("数据导入",null),
			},
			tbitem17: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem19: {
				caption: commonLogic.appcommonhandle("过滤",null),
				tip: commonLogic.appcommonhandle("过滤",null),
			},
		},
	};
	return data;
}
export default getLocaleResourceBase;