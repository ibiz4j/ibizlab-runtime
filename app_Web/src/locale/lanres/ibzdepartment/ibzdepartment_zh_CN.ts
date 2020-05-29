export default {
  fields: {
    deptid: '部门标识',
    deptcode: '部门代码',
    deptname: '部门名称',
    orgid: '单位',
    parentdeptid: '上级部门',
    shortname: '部门简称',
    deptlevel: '部门级别',
    showorder: '访问审计',
    bcode: '业务编码',
    leaderid: '分管领导标识',
    leadername: '分管领导',
    enable: '逻辑有效',
    orgname: '单位',
    parentdeptname: '上级部门',
    createdate: '创建时间',
    updatedate: '最后修改时间',
  },
	views: {
		pickupview: {
			caption: '部门',
      title: '部门',
		},
		gridview: {
			caption: '部门',
      title: '部门',
		},
		editview: {
			caption: '部门',
      title: '部门',
		},
		mpickupview: {
			caption: '部门',
      title: '部门',
		},
		optionview: {
			caption: '部门',
      title: '部门',
		},
		treeexpview: {
			caption: '人员管理',
      title: '人员管理',
		},
		pickupgridview: {
			caption: '部门',
      title: '部门',
		},
	},
	newform_form: {
		details: {
			group1: '部门基本信息', 
			formpage1: '基本信息', 
			srfupdatedate: '最后修改时间', 
			srforikey: '', 
			srfkey: '部门标识', 
			srfmajortext: '部门名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			deptcode: '部门代码', 
			deptname: '部门名称', 
			orgid: '单位', 
			orgname: '单位', 
			pdeptid: '上级部门', 
			pdeptname: '上级部门', 
			enable: '逻辑有效', 
			deptid: '部门标识', 
		},
		uiactions: {
		},
	},
	main_form: {
		details: {
			formpage1: '基本信息', 
			srfupdatedate: '最后修改时间', 
			srforikey: '', 
			srfkey: '部门标识', 
			srfmajortext: '部门名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			deptid: '部门标识', 
			deptcode: '部门代码', 
			deptname: '部门名称', 
			orgname: '单位', 
			pdeptname: '上级部门', 
			orgid: '单位', 
			pdeptid: '上级部门', 
			shortname: '部门简称', 
			bcode: '业务编码', 
			deptlevel: '部门级别', 
			leaderid: '分管领导标识', 
			leadername: '分管领导', 
			showorder: '访问审计', 
			createdate: '创建时间', 
			updatedate: '最后修改时间', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			deptcode: '部门代码',
			deptname: '部门名称',
			orgname: '单位',
			pdeptname: '上级部门',
			deptlevel: '部门级别',
			shortname: '部门简称',
			bcode: '业务编码',
			leadername: '分管领导',
			showorder: '访问审计',
			createdate: '创建时间',
			updatedate: '最后修改时间',
			orgid: '单位',
			pdeptid: '上级部门',
			leaderid: '分管领导标识',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_deptcode_like: '部门代码(%)', 
			n_deptname_like: '部门名称(%)', 
			n_orgid_eq: '单位(=)', 
			n_pdeptid_eq: '上级部门(=)', 
			n_bcode_like: '业务编码(%)', 
		},
		uiactions: {
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
		tbitem7: {
			caption: '删除',
			tip: '删除',
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
		tbitem22: {
			caption: '帮助',
			tip: '帮助',
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem1_opennewcreateview: {
			caption: '快速新建',
			tip: '快速新建',
		},
		tbitem2: {
			caption: '-',
			tip: '',
		},
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
	depttree_treeview: {
		nodes: {
			root: '默认根节点',
		},
		uiactions: {
		},
	},
};