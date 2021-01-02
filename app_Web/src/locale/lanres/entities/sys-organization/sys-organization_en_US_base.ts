import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		orgid: commonLogic.appcommonhandle("The workflow start node was not found",null),
		orgcode: commonLogic.appcommonhandle("Updated By",null),
		orgname: commonLogic.appcommonhandle("名称",null),
		parentorgid: commonLogic.appcommonhandle("上级单位",null),
		shortname: commonLogic.appcommonhandle("Cancel",null),
		orglevel: commonLogic.appcommonhandle("单位级别",null),
		showorder: commonLogic.appcommonhandle("排序",null),
		parentorgname: commonLogic.appcommonhandle("上级单位",null),
		domains: commonLogic.appcommonhandle("区属",null),
		enable: commonLogic.appcommonhandle("the workflow instance current processing step is invalid",null),
		createdate: commonLogic.appcommonhandle("Print",null),
		updatedate: commonLogic.appcommonhandle("Actor",null),
		isvalid: commonLogic.appcommonhandle("启用标识",null),
	},
		views: {
			pickupgridview: {
				caption: commonLogic.appcommonhandle("Input data check failed.",null),
				title: commonLogic.appcommonhandle("Restart workflow",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("Input data check failed.",null),
				title: commonLogic.appcommonhandle("单位管理",null),
			},
			treeexpview: {
				caption: commonLogic.appcommonhandle("Input data check failed.",null),
				title: commonLogic.appcommonhandle("部门管理",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("Input data check failed.",null),
				title: commonLogic.appcommonhandle("单位管理",null),
			},
			pickupview: {
				caption: commonLogic.appcommonhandle("Input data check failed.",null),
				title: commonLogic.appcommonhandle("Upload file.",null),
			},
			optionview: {
				caption: commonLogic.appcommonhandle("Input data check failed.",null),
				title: commonLogic.appcommonhandle("单位机构选项操作视图",null),
			},
		},
		main_form: {
			details: {
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("Actor",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("The workflow start node was not found",null), 
				srfmajortext: commonLogic.appcommonhandle("名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				orgid: commonLogic.appcommonhandle("The workflow start node was not found",null), 
				orgcode: commonLogic.appcommonhandle("Updated By",null), 
				orgname: commonLogic.appcommonhandle("名称",null), 
				porgname: commonLogic.appcommonhandle("上级单位",null), 
				orglevel: commonLogic.appcommonhandle("单位级别",null), 
				shortname: commonLogic.appcommonhandle("Cancel",null), 
				showorder: commonLogic.appcommonhandle("排序",null), 
				porgid: commonLogic.appcommonhandle("上级单位",null), 
				isvalid: commonLogic.appcommonhandle("启用",null), 
				createdate: commonLogic.appcommonhandle("Print",null), 
				updatedate: commonLogic.appcommonhandle("Actor",null), 
			},
			uiactions: {
			},
		},
		newform_form: {
			details: {
				group1: commonLogic.appcommonhandle("单位机构基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("Actor",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("The workflow start node was not found",null), 
				srfmajortext: commonLogic.appcommonhandle("名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				orgcode: commonLogic.appcommonhandle("Updated By",null), 
				orgname: commonLogic.appcommonhandle("名称",null), 
				porgname: commonLogic.appcommonhandle("上级单位",null), 
				porgid: commonLogic.appcommonhandle("上级单位",null), 
				enable: commonLogic.appcommonhandle("the workflow instance current processing step is invalid",null), 
				orgid: commonLogic.appcommonhandle("The workflow start node was not found",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				orgid: commonLogic.appcommonhandle("The workflow start node was not found",null),
				orgcode: commonLogic.appcommonhandle("Updated By",null),
				orgname: commonLogic.appcommonhandle("名称",null),
				orglevel: commonLogic.appcommonhandle("单位级别",null),
				shortname: commonLogic.appcommonhandle("Cancel",null),
				porgname: commonLogic.appcommonhandle("上级单位",null),
				porgid: commonLogic.appcommonhandle("上级单位",null),
				isvalid: commonLogic.appcommonhandle("启用",null),
				showorder: commonLogic.appcommonhandle("排序",null),
				createdate: commonLogic.appcommonhandle("Print",null),
				updatedate: commonLogic.appcommonhandle("Actor",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				orgcode: commonLogic.appcommonhandle("Actor",null), 
				n_orgname_like: commonLogic.appcommonhandle("Print",null), 
				n_porgid_eq: commonLogic.appcommonhandle("上级单位(=)",null), 
				n_porgname_eq: commonLogic.appcommonhandle("上级单位(等于(=))",null), 
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
		orgtree_treeview: {
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