import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("用户标识",null),
		firstname: commonLogic.appcommonhandle("用户全局名",null),
		displayname: commonLogic.appcommonhandle("用户名称",null),
		mdeptid: commonLogic.appcommonhandle("主部门",null),
		mdeptcode: commonLogic.appcommonhandle("主部门代码",null),
		mdeptname: commonLogic.appcommonhandle("主部门名称",null),
		bcode: commonLogic.appcommonhandle("业务编码",null),
		orgid: commonLogic.appcommonhandle("单位",null),
		orgcode: commonLogic.appcommonhandle("单位代码",null),
		orgname: commonLogic.appcommonhandle("单位名称",null),
	},
		views: {
			pickupview: {
				caption: commonLogic.appcommonhandle("用户",null),
				title: commonLogic.appcommonhandle("用户数据选择视图",null),
			},
			mpickupview: {
				caption: commonLogic.appcommonhandle("用户",null),
				title: commonLogic.appcommonhandle("用户数据多项选择视图",null),
			},
			pickupgridview: {
				caption: commonLogic.appcommonhandle("用户",null),
				title: commonLogic.appcommonhandle("用户选择表格视图",null),
			},
		},
		main_grid: {
			columns: {
				userid: commonLogic.appcommonhandle("用户标识",null),
				personname: commonLogic.appcommonhandle("用户名称",null),
				username: commonLogic.appcommonhandle("用户全局名",null),
				orgname: commonLogic.appcommonhandle("单位名称",null),
				mdeptname: commonLogic.appcommonhandle("主部门名称",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_personname_like: commonLogic.appcommonhandle("用户名称(文本包含(%))",null), 
			},
			uiactions: {
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;