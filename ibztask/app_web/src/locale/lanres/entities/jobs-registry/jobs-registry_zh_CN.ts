export default {
  fields: {
    id: '主键ID',
    app: '服务名',
    address: '执行地址',
    status: '状态',
    update_time: '更新时间',
  },
	views: {
		editview: {
			caption: '任务注册信息',
      title: '任务注册信息编辑视图',
		},
		gridview: {
			caption: '任务注册信息',
      title: '任务注册信息表格视图',
		},
	},
	main_form: {
		details: {
			group1: '任务注册信息基本信息', 
			formpage1: '基本信息', 
			srforikey: '', 
			srfkey: '主键ID', 
			srfmajortext: '服务名', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			app: '服务名', 
			address: '执行地址', 
			status: '状态', 
			id: '主键ID', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			id: '主键ID',
			app: '服务名',
			address: '执行地址',
			status: '状态',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_app_like: '服务名(文本包含(%))', 
			n_status_eq: '状态(等于(=))', 
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: '保存',
			tip: '保存',
		},
		deuiaction1: {
			caption: '关闭',
			tip: '关闭',
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: '新建',
			tip: '新建',
		},
		tbitem4: {
			caption: '编辑',
			tip: '编辑',
		},
		tbitem8: {
			caption: '删除',
			tip: '删除',
		},
		deuiaction1: {
			caption: '过滤',
			tip: '过滤',
		},
	},
};