import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		roleid: commonLogic.appcommonhandle("Normal",null),
		rolename: commonLogic.appcommonhandle("Save",null),
		memo: commonLogic.appcommonhandle("备注",null),
		proleid: commonLogic.appcommonhandle("父角色标识",null),
		prolename: commonLogic.appcommonhandle("父角色名称",null),
		createdate: commonLogic.appcommonhandle(">",null),
		updatedate: commonLogic.appcommonhandle("Upload",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("Start workflow",null),
				title: commonLogic.appcommonhandle("用户角色",null),
			},
			pickupview: {
				caption: commonLogic.appcommonhandle("Start workflow",null),
				title: commonLogic.appcommonhandle("Logic error",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("Start workflow",null),
				title: commonLogic.appcommonhandle("The workflow instance current processing is the end of processing, and there is no interactive operation",null),
			},
			pickupgridview: {
				caption: commonLogic.appcommonhandle("Start workflow",null),
				title: commonLogic.appcommonhandle("Tables Information",null),
			},
			mpickupview: {
				caption: commonLogic.appcommonhandle("Start workflow",null),
				title: commonLogic.appcommonhandle("Others",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("Edit View",null), 
				druipart1: commonLogic.appcommonhandle("权限",null), 
				tabpage1: commonLogic.appcommonhandle("权限",null), 
				druipart2: commonLogic.appcommonhandle("用户",null), 
				tabpage2: commonLogic.appcommonhandle("用户",null), 
				tabpanel1: commonLogic.appcommonhandle("",null), 
				formpage1: commonLogic.appcommonhandle("Message View",null), 
				srfupdatedate: commonLogic.appcommonhandle("Upload",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("Normal",null), 
				srfmajortext: commonLogic.appcommonhandle("Save",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				sys_rolename: commonLogic.appcommonhandle("Save",null), 
				prolename: commonLogic.appcommonhandle("父角色名称",null), 
				memo: commonLogic.appcommonhandle("备注",null), 
				sys_roleid: commonLogic.appcommonhandle("Normal",null), 
				proleid: commonLogic.appcommonhandle("父角色标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				sys_roleid: commonLogic.appcommonhandle("Normal",null),
				sys_rolename: commonLogic.appcommonhandle("Save",null),
				memo: commonLogic.appcommonhandle("备注",null),
				updatedate: commonLogic.appcommonhandle("Upload",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("Enable DataGrid Inline Row Edit Mode",null), 
				n_sys_rolename_like: commonLogic.appcommonhandle("Save",null), 
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
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			deuiaction2: {
				caption: commonLogic.appcommonhandle("关闭",null),
				tip: commonLogic.appcommonhandle("关闭",null),
			},
			tbitem11: {
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