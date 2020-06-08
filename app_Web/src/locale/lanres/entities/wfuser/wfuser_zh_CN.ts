export default {
  fields: {
    id: '用户标识',
    firstname: '用户全局名',
    displayname: '用户名称',
  },
	views: {
		pickupview: {
			caption: '用户',
      title: '用户',
		},
		mpickupview: {
			caption: '用户',
      title: '用户',
		},
		pickupgridview: {
			caption: '用户',
      title: '用户',
		},
	},
	main_grid: {
		columns: {
			userid: '用户标识',
			personname: '用户名称',
			username: '用户全局名',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_personname_like: '用户名称(文本包含(%))', 
		},
		uiactions: {
		},
	},
};