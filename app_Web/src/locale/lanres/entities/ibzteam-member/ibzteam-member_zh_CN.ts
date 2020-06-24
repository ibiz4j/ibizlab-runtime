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