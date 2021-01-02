import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		deptid: commonLogic.appcommonhandle("decimal",null),
		deptcode: commonLogic.appcommonhandle("Cancel",null),
		deptname: commonLogic.appcommonhandle("{0}/P",null),
		orgid: commonLogic.appcommonhandle("单位",null),
		parentdeptid: commonLogic.appcommonhandle("上级部门",null),
		shortname: commonLogic.appcommonhandle("Others",null),
		deptlevel: commonLogic.appcommonhandle("部门级别",null),
		domains: commonLogic.appcommonhandle("区属",null),
		showorder: commonLogic.appcommonhandle("排序",null),
		bcode: commonLogic.appcommonhandle("Condition",null),
		leaderid: commonLogic.appcommonhandle("分管领导标识",null),
		leadername: commonLogic.appcommonhandle("分管领导",null),
		enable: commonLogic.appcommonhandle("After the [{0}] is executed, no subsequent nodes are specified",null),
		orgname: commonLogic.appcommonhandle("单位",null),
		parentdeptname: commonLogic.appcommonhandle("上级部门",null),
		createdate: commonLogic.appcommonhandle("{0}[{1}] relational data [{2}] cannot be deleted!",null),
		updatedate: commonLogic.appcommonhandle("The [{0}] value is not a character type",null),
		isvalid: commonLogic.appcommonhandle("启用标识",null),
	},
		views: {
			pickupgridview: {
				caption: commonLogic.appcommonhandle("Help",null),
				title: commonLogic.appcommonhandle("Restart workflow",null),
			},
			treeexpview: {
				caption: commonLogic.appcommonhandle("Help",null),
				title: commonLogic.appcommonhandle("人员管理",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("Help",null),
				title: commonLogic.appcommonhandle("部门管理",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("Help",null),
				title: commonLogic.appcommonhandle("部门表格视图",null),
			},
			optionview: {
				caption: commonLogic.appcommonhandle("Help",null),
				title: commonLogic.appcommonhandle("部门选项操作视图",null),
			},
			pickupview: {
				caption: commonLogic.appcommonhandle("Help",null),
				title: commonLogic.appcommonhandle("Upload file.",null),
			},
			mpickupview: {
				caption: commonLogic.appcommonhandle("Help",null),
				title: commonLogic.appcommonhandle("Data save failed,{0}",null),
			},
		},
		main_form: {
			details: {
				formpage1: commonLogic.appcommonhandle("Grid View",null), 
				srfupdatedate: commonLogic.appcommonhandle("The [{0}] value is not a character type",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("decimal",null), 
				srfmajortext: commonLogic.appcommonhandle("{0}/P",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				deptid: commonLogic.appcommonhandle("decimal",null), 
				deptcode: commonLogic.appcommonhandle("Cancel",null), 
				deptname: commonLogic.appcommonhandle("{0}/P",null), 
				orgname: commonLogic.appcommonhandle("单位",null), 
				pdeptname: commonLogic.appcommonhandle("上级部门",null), 
				orgid: commonLogic.appcommonhandle("单位",null), 
				pdeptid: commonLogic.appcommonhandle("上级部门",null), 
				shortname: commonLogic.appcommonhandle("Others",null), 
				bcode: commonLogic.appcommonhandle("Condition",null), 
				deptlevel: commonLogic.appcommonhandle("部门级别",null), 
				leaderid: commonLogic.appcommonhandle("分管领导标识",null), 
				leadername: commonLogic.appcommonhandle("分管领导",null), 
				showorder: commonLogic.appcommonhandle("排序",null), 
				isvalid: commonLogic.appcommonhandle("启用",null), 
				createdate: commonLogic.appcommonhandle("{0}[{1}] relational data [{2}] cannot be deleted!",null), 
				updatedate: commonLogic.appcommonhandle("The [{0}] value is not a character type",null), 
			},
			uiactions: {
			},
		},
		newform_form: {
			details: {
				group1: commonLogic.appcommonhandle("部门基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("The [{0}] value is not a character type",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("decimal",null), 
				srfmajortext: commonLogic.appcommonhandle("{0}/P",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				deptcode: commonLogic.appcommonhandle("Cancel",null), 
				deptname: commonLogic.appcommonhandle("{0}/P",null), 
				orgid: commonLogic.appcommonhandle("单位",null), 
				orgname: commonLogic.appcommonhandle("单位",null), 
				pdeptid: commonLogic.appcommonhandle("上级部门",null), 
				pdeptname: commonLogic.appcommonhandle("上级部门",null), 
				enable: commonLogic.appcommonhandle("After the [{0}] is executed, no subsequent nodes are specified",null), 
				deptid: commonLogic.appcommonhandle("decimal",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				deptcode: commonLogic.appcommonhandle("Cancel",null),
				deptname: commonLogic.appcommonhandle("{0}/P",null),
				orgname: commonLogic.appcommonhandle("单位",null),
				pdeptname: commonLogic.appcommonhandle("上级部门",null),
				deptlevel: commonLogic.appcommonhandle("部门级别",null),
				shortname: commonLogic.appcommonhandle("Others",null),
				bcode: commonLogic.appcommonhandle("Condition",null),
				leadername: commonLogic.appcommonhandle("分管领导",null),
				isvalid: commonLogic.appcommonhandle("启用",null),
				showorder: commonLogic.appcommonhandle("排序",null),
				createdate: commonLogic.appcommonhandle("{0}[{1}] relational data [{2}] cannot be deleted!",null),
				updatedate: commonLogic.appcommonhandle("The [{0}] value is not a character type",null),
				orgid: commonLogic.appcommonhandle("单位",null),
				pdeptid: commonLogic.appcommonhandle("上级部门",null),
				leaderid: commonLogic.appcommonhandle("分管领导标识",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_deptcode_like: commonLogic.appcommonhandle("Workflow Explore View",null), 
				n_deptname_like: commonLogic.appcommonhandle("Input error",null), 
				n_orgid_eq: commonLogic.appcommonhandle("单位(=)",null), 
				n_pdeptid_eq: commonLogic.appcommonhandle("上级部门(=)",null), 
				n_bcode_like: commonLogic.appcommonhandle("Please save [{0}] before you manage [{1}]",null), 
			},
			uiactions: {
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
		depttree_treeview: {
			nodata:commonLogic.appcommonhandle("",null),
			nodes: {
				root: commonLogic.appcommonhandle("默认根节点",null),
			},
			uiactions: {
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;