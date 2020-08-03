
export default {
  fields: {
    id: "主键ID",
    app: "服务名",
    address: "执行地址",
    status: "状态",
    update_time: "更新时间",
  },
	views: {
		gridview: {
			caption: "注册",
      		title: "注册",
		},
		editview: {
			caption: "注册",
      		title: "注册",
		},
	},
	main_form: {
		details: {
			group1: "任务注册信息基本信息", 
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "主键ID", 
			srfmajortext: "服务名", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			app: "服务名", 
			address: "执行地址", 
			status: "状态", 
			id: "主键ID", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			id: "主键ID",
			app: "服务名",
			address: "执行地址",
			status: "状态",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_app_like: "服务名(文本包含(%))", 
			n_status_eq: "状态(等于(=))", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem26: {
			caption: "New",
			tip: "New",
		},
		tbitem19: {
			caption: "Edit",
			tip: "Edit {0}",
		},
		tbitem22: {
			caption: "-",
			tip: "",
		},
		tbitem6: {
			caption: "Copy",
			tip: "Copy {0}",
		},
		tbitem7: {
			caption: "-",
			tip: "",
		},
		tbitem9: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem10: {
			caption: "-",
			tip: "",
		},
		tbitem11: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		tbitem12: {
			caption: "-",
			tip: "",
		},
		tbitem17: {
			caption: "其它",
			tip: "其它",
		},
		tbitem29: {
			caption: "Export Data Model",
			tip: "导出数据模型",
		},
		tbitem30: {
			caption: "数据导入",
			tip: "数据导入",
		},
		tbitem2: {
			caption: "-",
			tip: "",
		},
		tbitem3: {
			caption: "Filter",
			tip: "Filter",
		},
		tbitem4: {
			caption: "-",
			tip: "",
		},
		tbitem5: {
			caption: "Help",
			tip: "Help",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		deuiaction1: {
			caption: "关闭",
			tip: "关闭",
		},
	},
};