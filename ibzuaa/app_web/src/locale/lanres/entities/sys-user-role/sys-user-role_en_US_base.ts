import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		userroleid: commonLogic.appcommonhandle("用户角色关系标识",null),
		roleid: commonLogic.appcommonhandle("角色标识",null),
		rolename: commonLogic.appcommonhandle("角色名称",null),
		userid: commonLogic.appcommonhandle("用户标识",null),
		personname: commonLogic.appcommonhandle("用户名称",null),
		loginname: commonLogic.appcommonhandle("登录名",null),
		orgname: commonLogic.appcommonhandle("单位",null),
		mdeptname: commonLogic.appcommonhandle("主部门",null),
		createdate: commonLogic.appcommonhandle("建立时间",null),
		updatedate: commonLogic.appcommonhandle("更新时间",null),
	},
		views: {
			pickupview: {
				caption: commonLogic.appcommonhandle("用户角色关系",null),
				title: commonLogic.appcommonhandle("用户角色关系表数据选择视图",null),
			},
			editview2: {
				caption: commonLogic.appcommonhandle("用户",null),
				title: commonLogic.appcommonhandle("用户",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("用户角色关系",null),
				title: commonLogic.appcommonhandle("用户角色关系表表格视图",null),
			},
			pickupgridview: {
				caption: commonLogic.appcommonhandle("用户角色关系",null),
				title: commonLogic.appcommonhandle("用户角色关系表选择表格视图",null),
			},
			redirectview: {
				caption: commonLogic.appcommonhandle("用户角色关系",null),
				title: commonLogic.appcommonhandle("用户角色关系表数据重定向视图",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("用户",null),
				title: commonLogic.appcommonhandle("用户",null),
			},
			mpickupview: {
				caption: commonLogic.appcommonhandle("用户角色关系",null),
				title: commonLogic.appcommonhandle("用户角色关系表数据多项选择视图",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("用户角色关系表基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("更新时间",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("用户角色关系标识",null), 
				srfmajortext: commonLogic.appcommonhandle("用户标识",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				sys_roleid: commonLogic.appcommonhandle("角色标识",null), 
				sys_user_roleid: commonLogic.appcommonhandle("用户角色关系标识",null), 
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
				loginname: commonLogic.appcommonhandle("登录名",null),
				orgname: commonLogic.appcommonhandle("单位",null),
				mdeptname: commonLogic.appcommonhandle("主部门",null),
				sys_rolename: commonLogic.appcommonhandle("角色名称",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
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