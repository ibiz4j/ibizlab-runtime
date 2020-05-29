
export default {
  fields: {
    userid: '用户标识',
    username: '用户全局名',
    personname: '用户姓名',
    password: '密码',
  },
	views: {
		mpickupview: {
			caption: "Internal Error",
      title: 'Condition',
		},
		pickupview: {
			caption: "Internal Error",
      title: 'Workflow',
		},
		pickupgridview: {
			caption: "Internal Error",
      title: 'Please save [{0}] before you manage [{1}]',
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
			formpage1: "Pickup View", 
		},
		uiactions: {
		},
	},
};