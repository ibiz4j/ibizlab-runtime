import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		userid: commonLogic.appcommonhandle("用户标识",null),
		username: commonLogic.appcommonhandle("用户全局名",null),
		personname: commonLogic.appcommonhandle("用户姓名",null),
		usercode: commonLogic.appcommonhandle("用户工号",null),
		password: commonLogic.appcommonhandle("密码",null),
		loginname: commonLogic.appcommonhandle("登录名",null),
		domains: commonLogic.appcommonhandle("区属",null),
		mdeptid: commonLogic.appcommonhandle("主部门",null),
		mdeptcode: commonLogic.appcommonhandle("主部门代码",null),
		mdeptname: commonLogic.appcommonhandle("主部门名称",null),
		bcode: commonLogic.appcommonhandle("业务编码",null),
		postid: commonLogic.appcommonhandle("岗位标识",null),
		postcode: commonLogic.appcommonhandle("岗位代码",null),
		postname: commonLogic.appcommonhandle("岗位名称",null),
		orgid: commonLogic.appcommonhandle("单位",null),
		orgcode: commonLogic.appcommonhandle("单位代码",null),
		orgname: commonLogic.appcommonhandle("单位名称",null),
		nickname: commonLogic.appcommonhandle("昵称别名",null),
		sex: commonLogic.appcommonhandle("性别",null),
		birthday: commonLogic.appcommonhandle("出生日期",null),
		certcode: commonLogic.appcommonhandle("证件号码",null),
		phone: commonLogic.appcommonhandle("联系方式",null),
		email: commonLogic.appcommonhandle("邮件",null),
		avatar: commonLogic.appcommonhandle("社交账号",null),
		addr: commonLogic.appcommonhandle("地址",null),
		usericon: commonLogic.appcommonhandle("照片",null),
		theme: commonLogic.appcommonhandle("样式",null),
		lang: commonLogic.appcommonhandle("语言",null),
		fontsize: commonLogic.appcommonhandle("字号",null),
		memo: commonLogic.appcommonhandle("备注",null),
		reserver: commonLogic.appcommonhandle("保留",null),
		superuser: commonLogic.appcommonhandle("超级管理员",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("用户",null),
				title: commonLogic.appcommonhandle("用户",null),
			},
			mpickupview: {
				caption: commonLogic.appcommonhandle("系统用户",null),
				title: commonLogic.appcommonhandle("用户表数据多项选择视图",null),
			},
			pickupview: {
				caption: commonLogic.appcommonhandle("系统用户",null),
				title: commonLogic.appcommonhandle("用户表数据选择视图",null),
			},
			editview2: {
				caption: commonLogic.appcommonhandle("系统用户",null),
				title: commonLogic.appcommonhandle("用户表编辑视图",null),
			},
			pickupgridview: {
				caption: commonLogic.appcommonhandle("系统用户",null),
				title: commonLogic.appcommonhandle("用户表选择表格视图",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("用户",null),
				title: commonLogic.appcommonhandle("用户",null),
			},
			redirectview: {
				caption: commonLogic.appcommonhandle("系统用户",null),
				title: commonLogic.appcommonhandle("用户表数据重定向视图",null),
			},
		},
		main_form: {
			details: {
				druipart1: commonLogic.appcommonhandle("",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("用户标识",null), 
				srfmajortext: commonLogic.appcommonhandle("用户姓名",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				userid: commonLogic.appcommonhandle("用户标识",null), 
				username: commonLogic.appcommonhandle("用户全局名",null), 
				personname: commonLogic.appcommonhandle("用户姓名",null), 
				loginname: commonLogic.appcommonhandle("登录名",null), 
				orgname: commonLogic.appcommonhandle("单位名称",null), 
				mdeptname: commonLogic.appcommonhandle("主部门名称",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				userid: commonLogic.appcommonhandle("用户标识",null),
				username: commonLogic.appcommonhandle("用户全局名",null),
				personname: commonLogic.appcommonhandle("用户姓名",null),
				loginname: commonLogic.appcommonhandle("登录名",null),
				orgname: commonLogic.appcommonhandle("单位名称",null),
				mdeptname: commonLogic.appcommonhandle("主部门名称",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_personname_like: commonLogic.appcommonhandle("用户姓名(文本包含(%))",null), 
				n_loginname_like: commonLogic.appcommonhandle("登录名(文本包含(%))",null), 
				n_mdeptname_like: commonLogic.appcommonhandle("主部门名称(文本包含(%))",null), 
				n_orgname_like: commonLogic.appcommonhandle("单位名称(文本包含(%))",null), 
			},
			uiactions: {
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("Save",null),
				tip: commonLogic.appcommonhandle("Save",null),
			},
			tbitem5: {
				caption: commonLogic.appcommonhandle("Save And Close",null),
				tip: commonLogic.appcommonhandle("Save And Close Window",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem12: {
				caption: commonLogic.appcommonhandle("New",null),
				tip: commonLogic.appcommonhandle("New",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem14: {
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
			},
		},
		gridviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("New",null),
				tip: commonLogic.appcommonhandle("New",null),
			},
			tbitem4: {
				caption: commonLogic.appcommonhandle("Edit",null),
				tip: commonLogic.appcommonhandle("Edit {0}",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem8: {
				caption: commonLogic.appcommonhandle("Remove",null),
				tip: commonLogic.appcommonhandle("Remove {0}",null),
			},
			tbitem9: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("Export",null),
				tip: commonLogic.appcommonhandle("Export {0} Data To Excel",null),
			},
			tbitem10: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem19: {
				caption: commonLogic.appcommonhandle("Filter",null),
				tip: commonLogic.appcommonhandle("Filter",null),
			},
		},
		editview2toolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("Save",null),
				tip: commonLogic.appcommonhandle("Save",null),
			},
			tbitem5: {
				caption: commonLogic.appcommonhandle("Save And Close",null),
				tip: commonLogic.appcommonhandle("Save And Close Window",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem12: {
				caption: commonLogic.appcommonhandle("New",null),
				tip: commonLogic.appcommonhandle("New",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem14: {
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;