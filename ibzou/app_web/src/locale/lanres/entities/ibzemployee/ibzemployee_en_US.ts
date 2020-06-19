
export default {
  fields: {
    userid: "用户标识",
    username: "用户全局名",
    personname: "姓名",
    usercode: "用户工号",
    loginname: "登录名",
    password: "密码",
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
    certcode: "证件号码",
    phone: "联系方式",
    birthday: "出生日期",
    email: "邮件",
    avatar: "社交账号",
    addr: "地址",
    usericon: "照片",
    ipaddr: "ip地址",
    theme: "样式",
    lang: "语言",
    fontsize: "字号",
    memo: "备注",
    reserver: "保留",
    showorder: "排序",
    enable: "逻辑有效",
    createdate: "创建时间",
    updatedate: "最后修改时间",
  },
	views: {
		editgridview: {
			caption: "人员",
      		title: "人员表格视图",
		},
		editview: {
			caption: "人员",
      		title: "人员编辑视图",
		},
		gridview: {
			caption: "人员",
      		title: "人员表格视图",
		},
		mpickupview: {
			caption: "人员",
      		title: "人员数据多项选择视图",
		},
		optionview: {
			caption: "人员",
      		title: "人员选项操作视图",
		},
		changepwdview: {
			caption: "人员",
      		title: "人员编辑视图",
		},
		pickupview: {
			caption: "人员",
      		title: "人员数据选择视图",
		},
		pickupgridview: {
			caption: "人员",
      		title: "人员选择表格视图",
		},
	},
	main_form: {
		details: {
			grouppanel1: "分组面板", 
			grouppanel2: "分组面板", 
			druipart1: "部门", 
			group1: "人员基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "最后修改时间", 
			srforikey: "", 
			srfkey: "用户标识", 
			srfmajortext: "姓名", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			usercode: "用户工号", 
			personname: "姓名", 
			loginname: "登录名", 
			orgid: "单位", 
			orgname: "单位", 
			mdeptid: "主部门", 
			mdeptname: "部门", 
			mdeptcode: "主部门代码", 
			orgcode: "单位代码", 
			bcode: "业务编码", 
			nickname: "昵称别名", 
			sex: "性别", 
			birthday: "出生日期", 
			certcode: "证件号码", 
			phone: "联系方式", 
			avatar: "社交账号", 
			email: "邮件", 
			ipaddr: "ip地址", 
			showorder: "排序", 
			addr: "地址", 
			memo: "备注", 
			theme: "样式", 
			lang: "语言", 
			fontsize: "字号", 
			reserver: "保留", 
			usericon: "照片", 
			userid: "用户标识", 
		},
		uiactions: {
		},
	},
	newform_form: {
		details: {
			group1: "人员基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "最后修改时间", 
			srforikey: "", 
			srfkey: "用户标识", 
			srfmajortext: "姓名", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			usercode: "用户工号", 
			personname: "姓名", 
			loginname: "登录名", 
			orgname: "单位", 
			orgid: "单位", 
			orgcode: "单位代码", 
			mdeptname: "部门", 
			mdeptcode: "主部门代码", 
			mdeptid: "主部门", 
			enable: "逻辑有效", 
			bcode: "业务编码", 
			userid: "用户标识", 
		},
		uiactions: {
		},
	},
	changepw_form: {
		details: {
			group1: "密码信息", 
			formpage1: "基本信息", 
			srfupdatedate: "最后修改时间", 
			srforikey: "", 
			srfkey: "用户标识", 
			srfmajortext: "姓名", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			oldpasswd: "原始密码", 
			newpasswd: "新密码", 
			cfmpasswd: "新密码确认", 
			userid: "用户标识", 
		},
		uiactions: {
		},
	},
	editgrid_grid: {
		columns: {
			usercode: "用户工号",
			personname: "姓名",
			loginname: "登录名",
			orgcode: "单位代码",
			orgname: "单位名称",
			mdeptcode: "主部门代码",
			mdeptname: "主部门名称",
			sex: "性别",
			phone: "联系方式",
			ipaddr: "ip地址",
			showorder: "排序",
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			usercode: "用户工号",
			personname: "姓名",
			loginname: "登录名",
			orgcode: "单位代码",
			orgname: "单位名称",
			mdeptcode: "主部门代码",
			mdeptname: "主部门名称",
			sex: "性别",
			phone: "联系方式",
			ipaddr: "ip地址",
			showorder: "排序",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_usercode_like: "工号", 
			n_personname_like: "姓名", 
			n_mdeptname_like: "部门", 
		},
		uiactions: {
		},
	},
	editgridviewtoolbar_toolbar: {
		tbitem24: {
			caption: "行编辑",
			tip: "行编辑",
		},
		tbitem25: {
			caption: "新建行",
			tip: "新建行",
		},
		tbitem26: {
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
	gridviewtoolbar_toolbar: {
		tbitem1_opennewcreateview: {
			caption: "新建",
			tip: "新建",
		},
		tbitem2: {
			caption: "-",
			tip: "",
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
		tbitem14_initpwd: {
			caption: "初始化密码",
			tip: "初始化密码",
		},
		tbitem15: {
			caption: "-",
			tip: "",
		},
		tbitem19: {
			caption: "Filter",
			tip: "Filter",
		},
	},
	changepwdviewtoolbar_toolbar: {
		tbitem1: {
			caption: "Save",
			tip: "Save",
		},
	},
};