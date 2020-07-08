
export default {
  fields: {
    id: "应用标识",
    label: "应用名",
    systemid: "系统标识",
    fullname: "全称",
    type: "类型",
    group: "分组",
    icon: "图标",
    visabled: "可见",
    addr: "地址",
  },
	views: {
		gridview: {
			caption: "接入应用",
      		title: "接入应用",
		},
		editview: {
			caption: "应用",
      		title: "应用编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "应用基本信息", 
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "应用标识", 
			srfmajortext: "应用名", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pssystemid: "系统标识", 
			appid: "应用标识", 
			appname: "应用名", 
			apptype: "类型", 
			appgroup: "分组", 
			fullname: "全称", 
			icon: "图标", 
			visabled: "可见", 
			addr: "地址", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			pssystemid: "系统标识",
			appid: "应用标识",
			appname: "应用名",
			appgroup: "分组",
			apptype: "类型",
			fullname: "全称",
			icon: "图标",
			addr: "地址",
			visabled: "可见",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_pssystemid_eq: "系统标识(等于(=))", 
			n_appname_like: "应用名(文本包含(%))", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
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
		tbitem24: {
			caption: "行编辑",
			tip: "行编辑",
		},
		tbitem25: {
			caption: "新建行",
			tip: "新建行",
		},
		deuiaction1: {
			caption: "保存行",
			tip: "保存行",
		},
		tbitem26: {
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
};