export default {
  fields: {
    userid: "用户标识",
    username: "用户全局名",
    personname: "用户姓名",
    password: "密码",
  },
	views: {
		mpickupview: {
			caption: "系统用户",
      		title: "用户表数据多项选择视图",
		},
		pickupview: {
			caption: "系统用户",
      		title: "用户表数据选择视图",
		},
		pickupgridview: {
			caption: "系统用户",
      		title: "用户表选择表格视图",
		},
	},
	main_grid: {
		columns: {
			userid: "用户标识",
			username: "用户全局名",
			personname: "用户姓名",
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
};