
export default {
  fields: {
    teamid: "组标识",
    teamname: "组名称",
    memo: "备注",
    domains: "区属",
  },
	views: {
		gridview: {
			caption: "组管理",
      		title: "组管理",
		},
		editview: {
			caption: "组管理",
      		title: "组管理",
		},
	},
	main_form: {
		details: {
			group1: "组基本信息", 
			druipart1: "", 
			grouppanel1: "组成员", 
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "组标识", 
			srfmajortext: "组名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			teamname: "组名称", 
			memo: "备注", 
			domains: "区属", 
			teamid: "组标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			teamname: "组名称",
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
	gridviewtoolbar_toolbar: {
		deuiaction1: {
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
		tbitem7: {
			caption: "Remove And Close",
			tip: "Remove And Close Window",
		},
		tbitem8: {
			caption: "-",
			tip: "",
		},
		tbitem14: {
			caption: "Copy",
			tip: "Copy {0}",
		},
	},
};