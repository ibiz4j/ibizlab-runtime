
export default {
  fields: {
    deptid: "decimal",
    deptcode: "Cancel",
    deptname: "{0}/P",
    orgid: "单位",
    parentdeptid: "上级部门",
    shortname: "Others",
    deptlevel: "部门级别",
    domains: "区属",
    showorder: "Audit",
    bcode: "Condition",
    leaderid: "分管领导标识",
    leadername: "分管领导",
    enable: "After the [{0}] is executed, no subsequent nodes are specified",
    orgname: "单位",
    parentdeptname: "上级部门",
    createdate: "{0}[{1}] relational data [{2}] cannot be deleted!",
    updatedate: "The [{0}] value is not a character type",
  },
	views: {
		pickupview: {
			caption: "Help",
      		title: "Upload file.",
		},
		gridview: {
			caption: "Help",
      		title: "部门表格视图",
		},
		editview: {
			caption: "Help",
      		title: "部门编辑视图",
		},
		mpickupview: {
			caption: "Help",
      		title: "Data save failed,{0}",
		},
		optionview: {
			caption: "Help",
      		title: "部门选项操作视图",
		},
		treeexpview: {
			caption: "Help",
      		title: "部门树导航视图",
		},
		pickupgridview: {
			caption: "Help",
      		title: "Restart workflow",
		},
	},
	newform_form: {
		details: {
			group1: "部门基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "The [{0}] value is not a character type", 
			srforikey: "", 
			srfkey: "decimal", 
			srfmajortext: "{0}/P", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			deptcode: "Cancel", 
			deptname: "{0}/P", 
			orgid: "单位", 
			orgname: "单位", 
			pdeptid: "上级部门", 
			pdeptname: "上级部门", 
			enable: "After the [{0}] is executed, no subsequent nodes are specified", 
			deptid: "decimal", 
		},
		uiactions: {
		},
	},
	main_form: {
		details: {
			formpage1: "Grid View", 
			srfupdatedate: "The [{0}] value is not a character type", 
			srforikey: "", 
			srfkey: "decimal", 
			srfmajortext: "{0}/P", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			deptid: "decimal", 
			deptcode: "Cancel", 
			deptname: "{0}/P", 
			orgname: "单位", 
			pdeptname: "上级部门", 
			orgid: "单位", 
			pdeptid: "上级部门", 
			shortname: "Others", 
			bcode: "Condition", 
			deptlevel: "部门级别", 
			leaderid: "分管领导标识", 
			leadername: "分管领导", 
			showorder: "Audit", 
			createdate: "{0}[{1}] relational data [{2}] cannot be deleted!", 
			updatedate: "The [{0}] value is not a character type", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			deptcode: "Cancel",
			deptname: "{0}/P",
			orgname: "单位",
			pdeptname: "上级部门",
			deptlevel: "部门级别",
			shortname: "Others",
			bcode: "Condition",
			leadername: "分管领导",
			showorder: "Audit",
			createdate: "{0}[{1}] relational data [{2}] cannot be deleted!",
			updatedate: "The [{0}] value is not a character type",
			orgid: "单位",
			pdeptid: "上级部门",
			leaderid: "分管领导标识",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_deptcode_like: "Workflow Explore View", 
			n_deptname_like: "Input error", 
			n_orgid_eq: "单位(=)", 
			n_pdeptid_eq: "上级部门(=)", 
			n_bcode_like: "Please save [{0}] before you manage [{1}]", 
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		tbitem6: {
			caption: "-",
			tip: "",
		},
		tbitem14: {
			caption: "Copy",
			tip: "Copy {0}",
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem1_opennewcreateview: {
			caption: "新建",
			tip: "新建",
		},
		tbitem2: {
			caption: "-",
			tip: "",
		},
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem4: {
			caption: "Edit",
			tip: "Edit {0}",
		},
		tbitem6: {
			caption: "Copy",
			tip: "Copy {0}",
		},
		tbitem7: {
			caption: "-",
			tip: "",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem9: {
			caption: "-",
			tip: "",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		tbitem10: {
			caption: "-",
			tip: "",
		},
		tbitem16: {
			caption: "其它",
			tip: "其它",
		},
		tbitem21: {
			caption: "Export Data Model",
			tip: "导出数据模型",
		},
		tbitem23: {
			caption: "数据导入",
			tip: "数据导入",
		},
		tbitem17: {
			caption: "-",
			tip: "",
		},
		tbitem19: {
			caption: "Filter",
			tip: "Filter",
		},
	},
	depttree_treeview: {
		nodes: {
			root: "默认根节点",
		},
		uiactions: {
		},
	},
};