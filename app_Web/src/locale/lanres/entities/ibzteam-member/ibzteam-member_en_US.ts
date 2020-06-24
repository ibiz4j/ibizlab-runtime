
export default {
  fields: {
    teammemberid: "组成员标识",
    teamid: "组标识",
    teamname: "组名称",
    userid: "用户标识",
    personname: "姓名",
    postid: "岗位标识",
    postname: "岗位标识",
    domains: "区属",
  },
	views: {
		gridview: {
			caption: "组成员",
      		title: "组成员表格视图",
		},
		editview: {
			caption: "组成员",
      		title: "组成员编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "组成员基本信息", 
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "组成员标识", 
			srfmajortext: "姓名", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			personname: "姓名", 
			postname: "岗位标识", 
			domains: "区属", 
			teamid: "组标识", 
			postid: "岗位标识", 
			userid: "用户标识", 
			teammemberid: "组成员标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			personname: "姓名",
			postname: "岗位标识",
			domains: "区属",
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