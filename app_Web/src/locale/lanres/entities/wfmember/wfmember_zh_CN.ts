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
		nodata:"",
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
			caption: "新建",
			tip: "新建",
		},
		tbitem4: {
			caption: "编辑",
			tip: "编辑",
		},
		tbitem6: {
			caption: "拷贝",
			tip: "拷贝",
		},
		tbitem7: {
			caption: "-",
			tip: "",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		tbitem9: {
			caption: "-",
			tip: "",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
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
			caption: "导出数据模型",
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
			caption: "过滤",
			tip: "过滤",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction1: {
			caption: "保存并关闭",
			tip: "保存并关闭",
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
			caption: "拷贝",
			tip: "拷贝",
		},
	},
};