
export default {
  fields: {
    id: "标识",
    userid: "用户标识",
    identity_type: "认证类型",
    identifier: "认证标识",
    credential: "凭据",
    username: "人员",
  },
	views: {
		editview: {
			caption: "账号绑定",
      		title: "账号编辑视图",
		},
		gridview: {
			caption: "账号绑定",
      		title: "账号表格视图",
		},
	},
	main_form: {
		details: {
			group1: "实体基本信息", 
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "标识", 
			srfmajortext: "人员", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			username: "人员", 
			identity_type: "认证类型", 
			identifier: "认证标识", 
			credential: "凭据", 
			userid: "用户标识", 
			authid: "标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			username: "人员",
			identity_type: "认证类型",
			identifier: "认证标识",
			credential: "凭据",
		},
		nodata:"",
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_username_eq: "人员", 
			n_userid_eq: "", 
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		deuiaction1: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
		deuiaction2: {
			caption: "关闭",
			tip: "关闭",
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
};