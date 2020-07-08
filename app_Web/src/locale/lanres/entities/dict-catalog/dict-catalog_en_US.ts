
export default {
  fields: {
    id: "标识",
    code: "代码",
    name: "名称",
    group: "分组",
    memo: "备注",
    enable: "是否有效",
    updatedate: "最后修改时间",
  },
	views: {
		gridview: {
			caption: "目录",
      		title: "目录",
		},
		pickupgridview: {
			caption: "字典",
      		title: "字典选择表格视图",
		},
		pickupview: {
			caption: "字典",
      		title: "字典数据选择视图",
		},
		editview: {
			caption: "字典",
      		title: "字典编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "字典基本信息", 
			druipart1: "字典项", 
			formpage1: "基本信息", 
			srfupdatedate: "最后修改时间", 
			srforikey: "", 
			srfkey: "标识", 
			srfmajortext: "名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			ccode: "代码", 
			cname: "名称", 
			cgroup: "分组", 
			memo: "备注", 
			cid: "标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			ccode: "代码",
			cname: "名称",
			cgroup: "分组",
			memo: "备注",
			updatedate: "最后修改时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ccode_like: "代码", 
			n_cname_like: "名称", 
			n_cgroup_like: "分组", 
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