export default {
  fields: {
    teammemberid: "组成员标识",
    teamid: "组标识",
    teamname: "组名称",
    userid: "用户标识",
    personname: "姓名",
    postid: "岗位标识",
    postname: "岗位",
    domains: "区属",
    username: "登录名",
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
			postname: "岗位", 
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
			username: "登录名",
			postname: "岗位",
			postid: "岗位标识",
			userid: "用户标识",
		},
		nodata:"",
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem24: {
			caption: "行编辑",
			tip: "行编辑",
		},
		tbitem25: {
			caption: "新建行",
			tip: "新建行",
		},
		deuiaction1: {
			caption: "保存行",
			tip: "保存行",
		},
		tbitem26: {
			caption: "-",
			tip: "",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
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
		tbitem7: {
			caption: "删除",
			tip: "删除",
		},
		tbitem8: {
			caption: "-",
			tip: "",
		},
		tbitem14: {
			caption: "拷贝",
			tip: "拷贝",
		},
	},
};