export default {
  fields: {
    definitionkey: 'DefinitionKey',
    definitionname: '流程定义名称',
    modelversion: '模型版本',
    modelenable: '模型是否启用',
    pssystemid: '系统标识',
    md5check: '校验',
    bpmnfile: 'BPMN',
    deploykey: 'DeployKey',
  },
	views: {
		editview: {
			caption: '流程定义',
      title: '实体编辑视图',
		},
		gridview: {
			caption: '流程定义',
      title: '实体表格视图',
		},
	},
	main_form: {
		details: {
			group1: '模型基本信息', 
			formpage1: '基本信息', 
			srforikey: '', 
			srfkey: 'DefinitionKey', 
			srfmajortext: '流程定义名称', 
			srftempmode: '', 
			srfuf: '', 
			srfdeid: '', 
			srfsourcekey: '', 
			definitionkey: 'DefinitionKey', 
			deploykey: 'DefinitionKey', 
			definitionname: '流程定义名称', 
			pssystemid: '系统标识', 
			modelversion: '模型版本', 
			modelenable: '模型是否启用', 
			bpmnfile: 'BPMN', 
			md5check: '校验', 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			definitionkey: 'DefinitionKey',
			definitionname: '流程定义名称',
			pssystemid: '系统标识',
			modelversion: '模型版本',
			modelenable: '模型是否启用',
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: '常规条件', 
			n_deploykey_like: 'DefinitionKey', 
			n_definitionname_like: '流程定义名称', 
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
		tbitem14: {
			caption: '拷贝',
			tip: '拷贝',
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
	},
};