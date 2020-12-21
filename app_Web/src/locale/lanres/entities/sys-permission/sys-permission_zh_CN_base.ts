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
	};
	return data;
}
export default getLocaleResourceBase;