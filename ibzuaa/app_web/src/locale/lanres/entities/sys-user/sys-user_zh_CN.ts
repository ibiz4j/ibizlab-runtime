export default {
  fields: {
    userid: "用户标识",
    username: "用户全局名",
    personname: "用户姓名",
    password: "密码",
    usercode: "用户工号",
    loginname: "登录名",
    domains: "区属",
    mdeptid: "主部门",
    mdeptcode: "主部门代码",
    mdeptname: "主部门名称",
    bcode: "业务编码",
    postid: "岗位标识",
    postcode: "岗位代码",
    postname: "岗位名称",
    orgid: "单位",
    orgcode: "单位代码",
    orgname: "单位名称",
    nickname: "昵称别名",
    sex: "性别",
    birthday: "出生日期",
    certcode: "证件号码",
    phone: "联系方式",
    email: "邮件",
    avatar: "社交账号",
    addr: "地址",
    usericon: "照片",
    theme: "样式",
    lang: "语言",
    fontsize: "字号",
    memo: "备注",
    reserver: "保留",
    superuser: "超级管理员",
  },
	views: {
		mpickupview: {
			caption: "系统用户",
      		title: "用户表数据多项选择视图",
		},
		editview2: {
			caption: "系统用户",
      		title: "用户表编辑视图",
		},
		redirectview: {
			caption: "系统用户",
      		title: "用户表数据重定向视图",
		},
		pickupgridview: {
			caption: "系统用户",
      		title: "用户表选择表格视图",
		},
		editview: {
			caption: "系统用户",
      		title: "用户表编辑视图",
		},
		gridview: {
			caption: "系统用户",
      		title: "用户表格视图",
		},
		pickupview: {
			caption: "系统用户",
      		title: "用户表数据选择视图",
		},
	},
	main_form: {
		details: {
			druipart1: "", 
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "用户标识", 
			srfmajortext: "用户姓名", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			userid: "用户标识", 
			username: "用户全局名", 
			personname: "用户姓名", 
			loginname: "登录名", 
			orgname: "单位名称", 
			mdeptname: "主部门名称", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			userid: "用户标识",
			username: "用户全局名",
			personname: "用户姓名",
			loginname: "登录名",
			orgname: "单位名称",
			mdeptname: "主部门名称",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_personname_like: "用户姓名(文本包含(%))", 
			n_loginname_like: "登录名(文本包含(%))", 
			n_mdeptname_like: "主部门名称(文本包含(%))", 
			n_orgname_like: "单位名称(文本包含(%))", 
		},
		uiactions: {
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