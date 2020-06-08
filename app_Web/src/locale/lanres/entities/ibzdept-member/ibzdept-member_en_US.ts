
export default {
  fields: {
    memberid: '标识',
    deptid: '部门标识',
    deptname: '部门名称',
    userid: '用户标识',
    personname: '成员',
  },
	views: {
		gridview: {
			caption: "部门成员",
      title: '部门成员',
		},
		editview: {
			caption: "部门成员",
      title: '部门成员',
		},
	},
	main_form: {
		details: {
			group1: "部门成员基本信息", 
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "标识", 
			srfmajortext: "成员", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			deptname: "部门名称", 
			deptid: "部门标识", 
			personname: "成员", 
			userid: "用户标识", 
			memberid: "标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			deptname: "部门",
			personname: "成员",
			deptid: "部门标识",
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