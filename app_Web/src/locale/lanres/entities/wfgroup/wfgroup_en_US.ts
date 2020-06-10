
export default {
  fields: {
    id: '组标识',
    name: '组名称',
    groupscope: '范围',
  },
	views: {
		pickupgridview: {
			caption: "角色/用户组",
      title: '角色/用户组选择表格视图',
		},
		mpickupview: {
			caption: "角色/用户组",
      title: '角色/用户组数据多项选择视图',
		},
		pickupview: {
			caption: "角色/用户组",
      title: '角色/用户组数据选择视图',
		},
		editview: {
			caption: "角色/用户组",
      title: '角色/用户组编辑视图',
		},
		gridview: {
			caption: "角色/用户组",
      title: '角色/用户组表格视图',
		},
	},
	main_form: {
		details: {
			druipart1: "成员", 
			group1: "角色/用户组基本信息", 
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "组标识", 
			srfmajortext: "组名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			groupname: "组名称", 
			groupscope: "范围", 
			groupid: "组标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			groupid: "组标识",
			groupname: "组名称",
			groupscope: "范围",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_groupname_like: "组名称(文本包含(%))", 
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