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
			caption: "保存",
			tip: "保存",
		},
		deuiaction1: {
			caption: "保存并关闭",
			tip: "保存并关闭",
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
			caption: "拷贝",
			tip: "拷贝",
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "新建",
			tip: "新建",
		},
		tbitem4: {
			caption: "编辑",
			tip: "编辑",
		},
		tbitem6: {
			caption: "拷贝",
			tip: "拷贝",
		},
		tbitem7: {
			caption: "-",
			tip: "",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		tbitem9: {
			caption: "-",
			tip: "",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
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
			caption: "导出数据模型",
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
			caption: "过滤",
			tip: "过滤",
		},
	},
};