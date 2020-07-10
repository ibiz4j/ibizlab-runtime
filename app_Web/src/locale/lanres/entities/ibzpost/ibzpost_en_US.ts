
export default {
  fields: {
    postid: "岗位标识",
    postcode: "岗位编码",
    postname: "岗位名称",
    domains: "区属",
    memo: "备注",
  },
	views: {
		pickupview: {
			caption: "岗位",
      		title: "岗位数据选择视图",
		},
		editview: {
			caption: "岗位管理",
      		title: "岗位管理",
		},
		pickupgridview: {
			caption: "岗位",
      		title: "岗位选择表格视图",
		},
		gridview: {
			caption: "岗位管理",
      		title: "岗位管理",
		},
	},
	main_form: {
		details: {
			group1: "岗位基本信息", 
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "岗位标识", 
			srfmajortext: "岗位名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			postcode: "岗位编码", 
			postname: "岗位名称", 
			domains: "区属", 
			memo: "备注", 
			postid: "岗位标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			postcode: "岗位编码",
			postname: "岗位名称",
			memo: "备注",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
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