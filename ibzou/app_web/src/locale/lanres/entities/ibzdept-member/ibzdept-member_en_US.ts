
export default {
  fields: {
    memberid: "标识",
    deptid: "部门标识",
    deptname: "部门名称",
    userid: "用户标识",
    personname: "成员",
    postid: "岗位标识",
    postname: "岗位名称",
    domains: "区属",
  },
	views: {
		editview: {
			caption: "部门成员",
      		title: "部门成员编辑视图",
		},
		gridview: {
			caption: "部门成员",
      		title: "部门成员表格视图",
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