export default {
  fields: {
    memberid: "标识",
    deptid: "部门标识",
    deptname: "部门名称",
    userid: "用户标识",
    personname: "成员",
    postid: "岗位标识",
    postname: "岗位名称",
    bcode: "业务条线",
    domains: "区属",
  },
	views: {
		gridview: {
			caption: "部门成员",
      		title: "部门成员表格视图",
		},
		editview: {
			caption: "部门成员",
      		title: "部门成员编辑视图",
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
			postname: "岗位名称",
			personname: "成员",
			deptid: "部门标识",
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