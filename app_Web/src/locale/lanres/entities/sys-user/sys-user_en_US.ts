
export default {
  fields: {
    userid: "用户标识",
    username: "用户全局名",
    personname: "用户姓名",
    usercode: "用户工号",
    password: "密码",
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
			caption: "Internal Error",
      		title: "Condition",
		},
		pickupview: {
			caption: "Internal Error",
      		title: "Workflow",
		},
		pickupgridview: {
			caption: "Internal Error",
      		title: "Please save [{0}] before you manage [{1}]",
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
			formpage1: "Pickup View", 
			n_loginname_like: "登录名(文本包含(%))", 
			n_personname_like: "用户姓名(文本包含(%))", 
			n_orgname_like: "单位名称(文本包含(%))", 
			n_mdeptname_like: "主部门名称(文本包含(%))", 
		},
		uiactions: {
		},
	},
};