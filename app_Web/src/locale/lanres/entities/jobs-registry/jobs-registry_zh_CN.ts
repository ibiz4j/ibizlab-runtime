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
			caption: "任务注册信息",
      		title: "任务注册信息表格视图",
		},
		editview: {
			caption: "任务注册信息",
      		title: "任务注册信息编辑视图",
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
			caption: "新建",
			tip: "新建",
		},
		tbitem19: {
			caption: "编辑",
			tip: "编辑",
		},
		tbitem22: {
			caption: "-",
			tip: "",
		},
		tbitem6: {
			caption: "拷贝",
			tip: "拷贝",
		},
		tbitem7: {
			caption: "-",
			tip: "",
		},
		tbitem9: {
			caption: "删除",
			tip: "删除",
		},
		tbitem10: {
			caption: "-",
			tip: "",
		},
		tbitem11: {
			caption: "导出",
			tip: "导出",
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
			caption: "导出数据模型",
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
			caption: "过滤",
			tip: "过滤",
		},
		tbitem4: {
			caption: "-",
			tip: "",
		},
		tbitem5: {
			caption: "帮助",
			tip: "帮助",
		},
	},
	editviewtoolbar_toolbar: {
	},
};