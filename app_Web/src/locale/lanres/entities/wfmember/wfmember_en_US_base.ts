import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		memberid: commonLogic.appcommonhandle("组成员标识",null),
		membername: commonLogic.appcommonhandle("组成员名称",null),
		groupid: commonLogic.appcommonhandle("组标识",null),
		groupname: commonLogic.appcommonhandle("用户组",null),
		userid: commonLogic.appcommonhandle("用户标识",null),
		personname: commonLogic.appcommonhandle("用户",null),
		orgid: commonLogic.appcommonhandle("单位",null),
		orgname: commonLogic.appcommonhandle("单位",null),
		mdeptid: commonLogic.appcommonhandle("主部门",null),
		mdeptname: commonLogic.appcommonhandle("主部门",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("流程角色",null),
				title: commonLogic.appcommonhandle("流程角色",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("流程角色",null),
				title: commonLogic.appcommonhandle("流程角色",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("成员基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("组成员标识",null), 
				srfmajortext: commonLogic.appcommonhandle("组成员名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				groupid: commonLogic.appcommonhandle("组标识",null), 
				userid: commonLogic.appcommonhandle("用户标识",null), 
				personname: commonLogic.appcommonhandle("用户",null), 
				orgname: commonLogic.appcommonhandle("单位",null), 
				mdeptname: commonLogic.appcommonhandle("主部门",null), 
				groupname: commonLogic.appcommonhandle("用户组",null), 
				memberid: commonLogic.appcommonhandle("组成员标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				personname: commonLogic.appcommonhandle("用户",null),
				orgname: commonLogic.appcommonhandle("单位",null),
				mdeptname: commonLogic.appcommonhandle("主部门",null),
				groupname: commonLogic.appcommonhandle("用户组",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_personname_like: commonLogic.appcommonhandle("用户(文本包含(%))",null), 
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