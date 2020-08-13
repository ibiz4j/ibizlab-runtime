export default {
  fields: {
    id: "任务标识",
    name: "状态",
    processdefinitionid: "DefinitionId",
    processdefinitionkey: "DefinitionKey",
    processdefinitionname: "流程",
    taskdefinitionkey: "TaskDefinitionKey",
    description: "待办事项",
    createtime: "发起时间",
    processinstanceid: "实例标识",
    processinstancebusinesskey: "业务键值",
  },
	views: {
		gridview: {
			caption: "我的待办",
      		title: "我的待办",
		},
		editview: {
			caption: "工作流任务",
      		title: "工作流任务编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "工作流任务基本信息", 
			formpage1: "基本信息", 
			group2: "操作信息", 
			formpage2: "其它", 
			srforikey: "", 
			srfkey: "任务标识", 
			srfmajortext: "状态", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			taskid: "任务标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			definitionname: "流程",
			taskname: "状态",
			description: "事项",
			createtime: "时间",
			businesskey: "业务键值",
			definitionid: "DefinitionId",
			definitionkey: "DefinitionKey",
			instanceid: "实例标识",
			taskdefinitionkey: "TaskDefinitionKey",
			taskid: "任务标识",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_description_like: "事项", 
			n_definitionkey_leftlike: "系统", 
			n_definitionname_like: "流程", 
			n_taskname_like: "状态", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem5: {
			caption: "查看",
			tip: "查看",
		},
		tbitem7: {
			caption: "-",
			tip: "",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
		},
		tbitem10: {
			caption: "-",
			tip: "",
		},
		tbitem16: {
			caption: "其它",
			tip: "其它",
		},
		tbitem21: {
			caption: "导出数据模型",
			tip: "导出数据模型",
		},
		tbitem23: {
			caption: "数据导入",
			tip: "数据导入",
		},
		tbitem17: {
			caption: "-",
			tip: "",
		},
		tbitem19: {
			caption: "过滤",
			tip: "过滤",
		},
		tbitem18: {
			caption: "帮助",
			tip: "帮助",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem4: {
			caption: "保存并新建",
			tip: "保存并新建",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
		tbitem6: {
			caption: "-",
			tip: "",
		},
		tbitem7: {
			caption: "删除并关闭",
			tip: "删除并关闭",
		},
		tbitem8: {
			caption: "-",
			tip: "",
		},
		tbitem12: {
			caption: "新建",
			tip: "新建",
		},
		tbitem13: {
			caption: "-",
			tip: "",
		},
		tbitem14: {
			caption: "拷贝",
			tip: "拷贝",
		},
		tbitem16: {
			caption: "-",
			tip: "",
		},
		tbitem23: {
			caption: "第一个记录",
			tip: "第一个记录",
		},
		tbitem24: {
			caption: "上一个记录",
			tip: "上一个记录",
		},
		tbitem25: {
			caption: "下一个记录",
			tip: "下一个记录",
		},
		tbitem26: {
			caption: "最后一个记录",
			tip: "最后一个记录",
		},
		tbitem21: {
			caption: "-",
			tip: "",
		},
		tbitem22: {
			caption: "帮助",
			tip: "帮助",
		},
	},
};