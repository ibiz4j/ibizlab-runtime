export default {
  fields: {
    userroleid: "用户角色关系标识",
    roleid: "角色标识",
    rolename: "角色名称",
    userid: "用户标识",
    personname: "用户名称",
    loginname: "登录名",
    orgname: "单位",
    mdeptname: "主部门",
    createdate: "建立时间",
    updatedate: "更新时间",
  },
	views: {
		pickupview: {
			caption: "用户角色关系",
      		title: "用户角色关系表数据选择视图",
		},
		editview2: {
			caption: "用户",
      		title: "用户",
		},
		gridview: {
			caption: "用户角色关系",
      		title: "用户角色关系表表格视图",
		},
		pickupgridview: {
			caption: "用户角色关系",
      		title: "用户角色关系表选择表格视图",
		},
		redirectview: {
			caption: "用户角色关系",
      		title: "用户角色关系表数据重定向视图",
		},
		editview: {
			caption: "用户",
      		title: "用户",
		},
		mpickupview: {
			caption: "用户角色关系",
      		title: "用户角色关系表数据多项选择视图",
		},
	},
	main_form: {
		details: {
			group1: "用户角色关系表基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "用户角色关系标识", 
			srfmajortext: "用户标识", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			sys_roleid: "角色标识", 
			sys_user_roleid: "用户角色关系标识", 
			sys_rolename: "角色名称", 
			sys_username: "用户名称", 
			sys_userid: "用户标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			sys_username: "用户名称",
			loginname: "登录名",
			orgname: "单位",
			mdeptname: "主部门",
			sys_rolename: "角色名称",
		},
		nodata:"",
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_sys_username_like: "用户名称(%)", 
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
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
		tbitem6: {
			caption: "-",
			tip: "",
		},
		tbitem12: {
			caption: "新建",
			tip: "新建",
		},
		tbitem13: {
			caption: "-",
			tip: "",
		},
		tbitem14: {
			caption: "拷贝",
			tip: "拷贝",
		},
	},
	editview2toolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
		tbitem6: {
			caption: "-",
			tip: "",
		},
		tbitem12: {
			caption: "新建",
			tip: "新建",
		},
		tbitem13: {
			caption: "-",
			tip: "",
		},
		tbitem14: {
			caption: "拷贝",
			tip: "拷贝",
		},
	},
};