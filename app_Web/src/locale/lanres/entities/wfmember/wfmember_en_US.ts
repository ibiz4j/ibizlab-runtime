
export default {
  fields: {
    memberid: "组成员标识",
    membername: "组成员名称",
    groupid: "组标识",
    groupname: "用户组",
    userid: "用户标识",
    personname: "用户",
    orgid: "单位",
    orgname: "单位",
    mdeptid: "主部门",
    mdeptname: "主部门",
  },
	views: {
		gridview: {
			caption: "流程角色",
      		title: "流程角色",
		},
		editview: {
			caption: "流程角色",
      		title: "流程角色",
		},
	},
	main_form: {
		details: {
			group1: "成员基本信息", 
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "组成员标识", 
			srfmajortext: "组成员名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			groupid: "组标识", 
			userid: "用户标识", 
			personname: "用户", 
			orgname: "单位", 
			mdeptname: "主部门", 
			groupname: "用户组", 
			memberid: "组成员标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			personname: "用户",
			orgname: "单位",
			mdeptname: "主部门",
			groupname: "用户组",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_personname_like: "用户(文本包含(%))", 
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
		deuiaction1: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
		deuiaction2: {
			caption: "关闭",
			tip: "关闭",
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