export default {
  fields: {
    memberid: '标识',
    deptid: '部门标识',
    deptname: '部门名称',
    userid: '用户标识',
    personname: '成员',
  },
	views: {
		gridview: {
			caption: '部门成员',
      title: '部门成员表格视图',
		},
		editview: {
			caption: '部门成员',
      title: '部门成员编辑视图',
		},
	},
	main_form: {
		details: {
			group1: '部门成员基本信息', 
			formpage1: '基本信息', 
			srforikey: '', 
			srfkey: '标识', 
			srfmajortext: '成员', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			deptname: '部门名称', 
			deptid: '部门标识', 
			personname: '成员', 
			userid: '用户标识', 
			memberid: '标识', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			deptname: '部门',
			personname: '成员',
			deptid: '部门标识',
		},
		uiactions: {
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
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: '保存',
			tip: '保存',
		},
		tbitem6: {
			caption: '-',
			tip: '',
		},
		tbitem14: {
			caption: '拷贝',
			tip: '拷贝',
		},
	},
};