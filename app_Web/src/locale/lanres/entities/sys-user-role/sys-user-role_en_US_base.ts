import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		userroleid: commonLogic.appcommonhandle("The major data entity cannot be found",null),
		roleid: commonLogic.appcommonhandle("角色标识",null),
		rolename: commonLogic.appcommonhandle("角色名称",null),
		userid: commonLogic.appcommonhandle("用户标识",null),
		personname: commonLogic.appcommonhandle("用户名称",null),
		loginname: commonLogic.appcommonhandle("登录名",null),
		orgname: commonLogic.appcommonhandle("单位",null),
		mdeptname: commonLogic.appcommonhandle("主部门",null),
		createdate: commonLogic.appcommonhandle(">",null),
		updatedate: commonLogic.appcommonhandle("Upload",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("The workflow instance [{0}] is closed and cannot be submitted for processing",null),
				title: commonLogic.appcommonhandle("datetime",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("The workflow instance [{0}] is closed and cannot be submitted for processing",null),
				title: commonLogic.appcommonhandle("No interaction was found",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("page",null), 
				formpage1: commonLogic.appcommonhandle("PortalView",null), 
				srfupdatedate: commonLogic.appcommonhandle("Upload",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("The major data entity cannot be found",null), 
				srfmajortext: commonLogic.appcommonhandle("用户标识",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				sys_roleid: commonLogic.appcommonhandle("角色标识",null), 
				sys_user_roleid: commonLogic.appcommonhandle("The major data entity cannot be found",null), 
				sys_rolename: commonLogic.appcommonhandle("角色名称",null), 
				sys_username: commonLogic.appcommonhandle("用户名称",null), 
				sys_userid: commonLogic.appcommonhandle("用户标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				sys_username: commonLogic.appcommonhandle("用户名称",null),
				sys_rolename: commonLogic.appcommonhandle("角色名称",null),
				loginname: commonLogic.appcommonhandle("登录名",null),
				orgname: commonLogic.appcommonhandle("单位",null),
				mdeptname: commonLogic.appcommonhandle("主部门",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("In",null), 
				n_sys_username_like: commonLogic.appcommonhandle("用户名称(%)",null), 
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
			tbitem16: {
				caption: commonLogic.appcommonhandle("其它",null),
				tip: commonLogic.appcommonhandle("其它",null),
			},
			tbitem21: {
				caption: commonLogic.appcommonhandle("Export Data Model",null),
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
				caption: commonLogic.appcommonhandle("Filter",null),
				tip: commonLogic.appcommonhandle("Filter",null),
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("Save",null),
				tip: commonLogic.appcommonhandle("Save",null),
			},
			deuiaction1: {
				caption: commonLogic.appcommonhandle("Save And Close",null),
				tip: commonLogic.appcommonhandle("Save And Close Window",null),
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
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;