import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		permissionid: commonLogic.appcommonhandle("资源标识",null),
		permissionname: commonLogic.appcommonhandle("资源名称",null),
		permissiontype: commonLogic.appcommonhandle("资源类别",null),
		pssystemid: commonLogic.appcommonhandle("系统",null),
		enable: commonLogic.appcommonhandle("逻辑有效",null),
		createdate: commonLogic.appcommonhandle("建立时间",null),
		updatedate: commonLogic.appcommonhandle("更新时间",null),
	},
		views: {
			editview2: {
				caption: commonLogic.appcommonhandle("权限/资源",null),
				title: commonLogic.appcommonhandle("权限表编辑视图",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("权限/资源",null),
				title: commonLogic.appcommonhandle("权限表表格视图",null),
			},
			pickupview: {
				caption: commonLogic.appcommonhandle("权限/资源",null),
				title: commonLogic.appcommonhandle("权限表数据选择视图",null),
			},
			mpickupview: {
				caption: commonLogic.appcommonhandle("权限/资源",null),
				title: commonLogic.appcommonhandle("权限表数据多项选择视图",null),
			},
			pickupgridview: {
				caption: commonLogic.appcommonhandle("权限/资源",null),
				title: commonLogic.appcommonhandle("权限表选择表格视图",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("权限/资源",null),
				title: commonLogic.appcommonhandle("权限表编辑视图",null),
			},
			redirectview: {
				caption: commonLogic.appcommonhandle("权限/资源",null),
				title: commonLogic.appcommonhandle("权限表数据重定向视图",null),
			},
		},
		main_form: {
			details: {
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("更新时间",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("资源标识",null), 
				srfmajortext: commonLogic.appcommonhandle("资源名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				sys_permissionname: commonLogic.appcommonhandle("资源名称",null), 
				sys_permissionid: commonLogic.appcommonhandle("资源标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				sys_permissionid: commonLogic.appcommonhandle("资源标识",null),
				sys_permissionname: commonLogic.appcommonhandle("资源名称",null),
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
		editviewtoolbar_toolbar: {
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