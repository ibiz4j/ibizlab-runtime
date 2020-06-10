export default {
  fields: {
    id: '用户标识',
    firstname: '用户全局名',
    displayname: '用户名称',
  },
	views: {
		mpickupview: {
			caption: '用户',
      title: '用户数据多项选择视图',
		},
		pickupview: {
			caption: '用户',
      title: '用户数据选择视图',
		},
		editview: {
			caption: '用户',
      title: '用户编辑视图',
		},
		pickupgridview: {
			caption: '用户',
      title: '用户选择表格视图',
		},
		gridview: {
			caption: '用户',
      title: '用户表格视图',
		},
	},
	main_form: {
		details: {
			group1: '用户基本信息', 
			formpage1: '基本信息', 
			srforikey: '', 
			srfkey: '用户标识', 
			srfmajortext: '用户名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			personname: '用户名称', 
			username: '用户全局名', 
			userid: '用户标识', 
		},
		uiactions: {
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
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: '保存',
			tip: '保存',
		},
		tbitem4: {
			caption: '保存并新建',
			tip: '保存并新建',
		},
		tbitem5: {
			caption: '保存并关闭',
			tip: '保存并关闭',
		},
		tbitem6: {
			caption: '-',
			tip: '',
		},
		tbitem7: {
			caption: '删除并关闭',
			tip: '删除并关闭',
		},
		tbitem8: {
			caption: '-',
			tip: '',
		},
		tbitem12: {
			caption: '新建',
			tip: '新建',
		},
		tbitem13: {
			caption: '-',
			tip: '',
		},
		tbitem14: {
			caption: '拷贝',
			tip: '拷贝',
		},
		tbitem16: {
			caption: '-',
			tip: '',
		},
		tbitem23: {
			caption: '第一个记录',
			tip: '第一个记录',
		},
		tbitem24: {
			caption: '上一个记录',
			tip: '上一个记录',
		},
		tbitem25: {
			caption: '下一个记录',
			tip: '下一个记录',
		},
		tbitem26: {
			caption: '最后一个记录',
			tip: '最后一个记录',
		},
		tbitem21: {
			caption: '-',
			tip: '',
		},
		tbitem22: {
			caption: '帮助',
			tip: '帮助',
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
		tbitem6: {
			caption: '拷贝',
			tip: '拷贝',
		},
		tbitem7: {
			caption: '-',
			tip: '',
		},
		tbitem8: {
			caption: '删除',
			tip: '删除',
		},
		tbitem9: {
			caption: '-',
			tip: '',
		},
		tbitem13: {
			caption: '导出',
			tip: '导出',
		},
		tbitem10: {
			caption: '-',
			tip: '',
		},
		tbitem16: {
			caption: '其它',
			tip: '其它',
		},
		tbitem21: {
			caption: '导出数据模型',
			tip: '导出数据模型',
		},
		tbitem23: {
			caption: '数据导入',
			tip: '数据导入',
		},
		tbitem17: {
			caption: '-',
			tip: '',
		},
		tbitem19: {
			caption: '过滤',
			tip: '过滤',
		},
		tbitem18: {
			caption: '帮助',
			tip: '帮助',
		},
	},
};