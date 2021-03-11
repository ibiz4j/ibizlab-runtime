import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		userid: commonLogic.appcommonhandle("用户标识",null),
		username: commonLogic.appcommonhandle("用户全局名",null),
		personname: commonLogic.appcommonhandle("姓名",null),
		usercode: commonLogic.appcommonhandle("用户工号",null),
		loginname: commonLogic.appcommonhandle("登录名",null),
		password: commonLogic.appcommonhandle("密码",null),
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
		certcode: commonLogic.appcommonhandle("证件号码",null),
		phone: commonLogic.appcommonhandle("联系方式",null),
		birthday: commonLogic.appcommonhandle("出生日期",null),
		email: commonLogic.appcommonhandle("邮件",null),
		avatar: commonLogic.appcommonhandle("社交账号",null),
		addr: commonLogic.appcommonhandle("地址",null),
		usericon: commonLogic.appcommonhandle("照片",null),
		ipaddr: commonLogic.appcommonhandle("ip地址",null),
		theme: commonLogic.appcommonhandle("样式",null),
		lang: commonLogic.appcommonhandle("语言",null),
		fontsize: commonLogic.appcommonhandle("字号",null),
		memo: commonLogic.appcommonhandle("备注",null),
		reserver: commonLogic.appcommonhandle("保留",null),
		showorder: commonLogic.appcommonhandle("排序",null),
		enable: commonLogic.appcommonhandle("逻辑有效",null),
		createdate: commonLogic.appcommonhandle("创建时间",null),
		updatedate: commonLogic.appcommonhandle("最后修改时间",null),
	},
		views: {
			editgridview: {
				caption: commonLogic.appcommonhandle("人员",null),
				title: commonLogic.appcommonhandle("人员表格视图",null),
			},
			optionview: {
				caption: commonLogic.appcommonhandle("人员快速新建",null),
				title: commonLogic.appcommonhandle("人员快速新建",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("人员",null),
				title: commonLogic.appcommonhandle("人员表格视图",null),
			},
			changepwdview: {
				caption: commonLogic.appcommonhandle("人员",null),
				title: commonLogic.appcommonhandle("人员编辑视图",null),
			},
			pickupview: {
				caption: commonLogic.appcommonhandle("人员",null),
				title: commonLogic.appcommonhandle("人员数据选择视图",null),
			},
			mpickupview: {
				caption: commonLogic.appcommonhandle("人员",null),
				title: commonLogic.appcommonhandle("人员数据多项选择视图",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("人员管理",null),
				title: commonLogic.appcommonhandle("人员管理",null),
			},
			pickupgridview: {
				caption: commonLogic.appcommonhandle("人员",null),
				title: commonLogic.appcommonhandle("人员选择表格视图",null),
			},
		},
		newform_form: {
			details: {
				group1: commonLogic.appcommonhandle("人员基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("最后修改时间",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("用户标识",null), 
				srfmajortext: commonLogic.appcommonhandle("姓名",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				usercode: commonLogic.appcommonhandle("用户工号",null), 
				personname: commonLogic.appcommonhandle("姓名",null), 
				loginname: commonLogic.appcommonhandle("登录名",null), 
				orgname: commonLogic.appcommonhandle("单位",null), 
				orgid: commonLogic.appcommonhandle("单位",null), 
				orgcode: commonLogic.appcommonhandle("单位代码",null), 
				mdeptname: commonLogic.appcommonhandle("部门",null), 
				mdeptcode: commonLogic.appcommonhandle("主部门代码",null), 
				mdeptid: commonLogic.appcommonhandle("主部门",null), 
				enable: commonLogic.appcommonhandle("逻辑有效",null), 
				bcode: commonLogic.appcommonhandle("业务编码",null), 
				userid: commonLogic.appcommonhandle("用户标识",null), 
			},
			uiactions: {
			},
		},
		main_form: {
			details: {
				grouppanel1: commonLogic.appcommonhandle("分组面板",null), 
				grouppanel2: commonLogic.appcommonhandle("分组面板",null), 
				druipart1: commonLogic.appcommonhandle("部门",null), 
				group1: commonLogic.appcommonhandle("人员基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("最后修改时间",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("用户标识",null), 
				srfmajortext: commonLogic.appcommonhandle("姓名",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				usercode: commonLogic.appcommonhandle("用户工号",null), 
				personname: commonLogic.appcommonhandle("姓名",null), 
				loginname: commonLogic.appcommonhandle("登录名",null), 
				password: commonLogic.appcommonhandle("密码",null), 
				orgid: commonLogic.appcommonhandle("单位",null), 
				orgname: commonLogic.appcommonhandle("单位",null), 
				mdeptid: commonLogic.appcommonhandle("主部门",null), 
				pdeptcheck: commonLogic.appcommonhandle("",null), 
				mdeptname: commonLogic.appcommonhandle("部门",null), 
				mdeptcode: commonLogic.appcommonhandle("主部门代码",null), 
				orgcode: commonLogic.appcommonhandle("单位代码",null), 
				bcode: commonLogic.appcommonhandle("业务编码",null), 
				nickname: commonLogic.appcommonhandle("昵称别名",null), 
				sex: commonLogic.appcommonhandle("性别",null), 
				birthday: commonLogic.appcommonhandle("出生日期",null), 
				certcode: commonLogic.appcommonhandle("证件号码",null), 
				phone: commonLogic.appcommonhandle("联系方式",null), 
				avatar: commonLogic.appcommonhandle("社交账号",null), 
				email: commonLogic.appcommonhandle("邮件",null), 
				ipaddr: commonLogic.appcommonhandle("ip地址",null), 
				showorder: commonLogic.appcommonhandle("排序",null), 
				addr: commonLogic.appcommonhandle("地址",null), 
				memo: commonLogic.appcommonhandle("备注",null), 
				theme: commonLogic.appcommonhandle("样式",null), 
				lang: commonLogic.appcommonhandle("语言",null), 
				fontsize: commonLogic.appcommonhandle("字号",null), 
				reserver: commonLogic.appcommonhandle("保留",null), 
				usericon: commonLogic.appcommonhandle("照片",null), 
				userid: commonLogic.appcommonhandle("用户标识",null), 
			},
			uiactions: {
			},
		},
		changepw_form: {
			details: {
				group1: commonLogic.appcommonhandle("密码信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("最后修改时间",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("用户标识",null), 
				srfmajortext: commonLogic.appcommonhandle("姓名",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				oldpasswd: commonLogic.appcommonhandle("原始密码",null), 
				newpasswd: commonLogic.appcommonhandle("新密码",null), 
				cfmpasswd: commonLogic.appcommonhandle("新密码确认",null), 
				userid: commonLogic.appcommonhandle("用户标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				usercode: commonLogic.appcommonhandle("用户工号",null),
				personname: commonLogic.appcommonhandle("姓名",null),
				loginname: commonLogic.appcommonhandle("登录名",null),
				orgcode: commonLogic.appcommonhandle("单位代码",null),
				orgname: commonLogic.appcommonhandle("单位名称",null),
				mdeptcode: commonLogic.appcommonhandle("主部门代码",null),
				mdeptname: commonLogic.appcommonhandle("主部门名称",null),
				sex: commonLogic.appcommonhandle("性别",null),
				phone: commonLogic.appcommonhandle("联系方式",null),
				ipaddr: commonLogic.appcommonhandle("ip地址",null),
				showorder: commonLogic.appcommonhandle("排序",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		editgrid_grid: {
			columns: {
				usercode: commonLogic.appcommonhandle("用户工号",null),
				personname: commonLogic.appcommonhandle("姓名",null),
				loginname: commonLogic.appcommonhandle("登录名",null),
				orgcode: commonLogic.appcommonhandle("单位代码",null),
				orgname: commonLogic.appcommonhandle("单位名称",null),
				mdeptcode: commonLogic.appcommonhandle("主部门代码",null),
				mdeptname: commonLogic.appcommonhandle("主部门名称",null),
				sex: commonLogic.appcommonhandle("性别",null),
				phone: commonLogic.appcommonhandle("联系方式",null),
				ipaddr: commonLogic.appcommonhandle("ip地址",null),
				showorder: commonLogic.appcommonhandle("排序",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_usercode_like: commonLogic.appcommonhandle("工号",null), 
				n_personname_like: commonLogic.appcommonhandle("姓名",null), 
				n_mdeptname_like: commonLogic.appcommonhandle("部门",null), 
			},
			uiactions: {
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("Save",null),
				tip: commonLogic.appcommonhandle("Save",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("Remove And Close",null),
				tip: commonLogic.appcommonhandle("Remove And Close Window",null),
			},
			tbitem8: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem14: {
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
			},
		},
		gridviewtoolbar_toolbar: {
			tbitem1_opennewcreateview: {
				caption: commonLogic.appcommonhandle("快速新建",null),
				tip: commonLogic.appcommonhandle("快速新建",null),
			},
			tbitem2: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			deuiaction1: {
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
			tbitem14_initpwd: {
				caption: commonLogic.appcommonhandle("初始化密码",null),
				tip: commonLogic.appcommonhandle("初始化密码",null),
			},
			tbitem15: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem19: {
				caption: commonLogic.appcommonhandle("Filter",null),
				tip: commonLogic.appcommonhandle("Filter",null),
			},
		},
		editgridviewtoolbar_toolbar: {
			tbitem24: {
				caption: commonLogic.appcommonhandle("行编辑",null),
				tip: commonLogic.appcommonhandle("行编辑",null),
			},
			tbitem25: {
				caption: commonLogic.appcommonhandle("新建行",null),
				tip: commonLogic.appcommonhandle("新建行",null),
			},
			deuiaction1: {
				caption: commonLogic.appcommonhandle("保存行",null),
				tip: commonLogic.appcommonhandle("保存行",null),
			},
			tbitem26: {
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
			tbitem19: {
				caption: commonLogic.appcommonhandle("Filter",null),
				tip: commonLogic.appcommonhandle("Filter",null),
			},
		},
		changepwdviewtoolbar_toolbar: {
			tbitem1: {
				caption: commonLogic.appcommonhandle("Save",null),
				tip: commonLogic.appcommonhandle("Save",null),
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;