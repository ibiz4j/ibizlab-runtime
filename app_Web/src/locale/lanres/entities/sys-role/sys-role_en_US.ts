
export default {
  fields: {
    roleid: "Normal",
    rolename: "Save",
    memo: "备注",
    createdate: ">",
    updatedate: "Upload",
  },
	views: {
		gridview: {
			caption: "Start workflow",
      		title: "角色表格视图",
		},
		pickupview: {
			caption: "Start workflow",
      		title: "Logic error",
		},
		editview: {
			caption: "Start workflow",
      		title: "The workflow instance current processing is the end of processing, and there is no interactive operation",
		},
		pickupgridview: {
			caption: "Start workflow",
      		title: "Tables Information",
		},
		mpickupview: {
			caption: "Start workflow",
      		title: "Others",
		},
	},
	main_form: {
		details: {
			group1: "Edit View", 
			druipart1: "权限", 
			tabpage1: "权限", 
			druipart2: "用户", 
			tabpage2: "用户", 
			tabpanel1: "", 
			formpage1: "Message View", 
			srfupdatedate: "Upload", 
			srforikey: "", 
			srfkey: "Normal", 
			srfmajortext: "Save", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			sys_rolename: "Save", 
			memo: "备注", 
			sys_roleid: "Normal", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			sys_rolename: "Save",
			memo: "备注",
			updatedate: "Upload",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "Enable DataGrid Inline Row Edit Mode", 
			n_sys_rolename_like: "Save", 
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