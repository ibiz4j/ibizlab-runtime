import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("任务标识",null),
		name: commonLogic.appcommonhandle("状态",null),
		processdefinitionid: commonLogic.appcommonhandle("DefinitionId",null),
		processdefinitionkey: commonLogic.appcommonhandle("DefinitionKey",null),
		processdefinitionname: commonLogic.appcommonhandle("流程",null),
		taskdefinitionkey: commonLogic.appcommonhandle("TaskDefinitionKey",null),
		description: commonLogic.appcommonhandle("待办事项",null),
		createtime: commonLogic.appcommonhandle("发起时间",null),
		processinstanceid: commonLogic.appcommonhandle("实例标识",null),
		processinstancebusinesskey: commonLogic.appcommonhandle("业务键值",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("我的待办",null),
				title: commonLogic.appcommonhandle("我的待办",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("工作流任务",null),
				title: commonLogic.appcommonhandle("工作流任务编辑视图",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("工作流任务基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				group2: commonLogic.appcommonhandle("操作信息",null), 
				formpage2: commonLogic.appcommonhandle("其它",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("任务标识",null), 
				srfmajortext: commonLogic.appcommonhandle("状态",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				taskid: commonLogic.appcommonhandle("任务标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				definitionname: commonLogic.appcommonhandle("流程",null),
				taskname: commonLogic.appcommonhandle("状态",null),
				description: commonLogic.appcommonhandle("事项",null),
				createtime: commonLogic.appcommonhandle("时间",null),
				businesskey: commonLogic.appcommonhandle("业务键值",null),
				definitionid: commonLogic.appcommonhandle("DefinitionId",null),
				definitionkey: commonLogic.appcommonhandle("DefinitionKey",null),
				instanceid: commonLogic.appcommonhandle("实例标识",null),
				taskdefinitionkey: commonLogic.appcommonhandle("TaskDefinitionKey",null),
				taskid: commonLogic.appcommonhandle("任务标识",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_description_like: commonLogic.appcommonhandle("事项",null), 
				n_definitionkey_leftlike: commonLogic.appcommonhandle("系统",null), 
				n_definitionname_like: commonLogic.appcommonhandle("流程",null), 
				n_taskname_like: commonLogic.appcommonhandle("状态",null), 
			},
			uiactions: {
			},
		},
		gridviewtoolbar_toolbar: {
			tbitem5: {
				caption: commonLogic.appcommonhandle("查看",null),
				tip: commonLogic.appcommonhandle("查看",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("导出",null),
				tip: commonLogic.appcommonhandle("导出",null),
			},
			tbitem10: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem16: {
				caption: commonLogic.appcommonhandle("其它",null),
				tip: commonLogic.appcommonhandle("其它",null),
			},
			tbitem21: {
				caption: commonLogic.appcommonhandle("导出数据模型",null),
				tip: commonLogic.appcommonhandle("导出数据模型",null),
			},
			tbitem23: {
				caption: commonLogic.appcommonhandle("数据导入",null),
				tip: commonLogic.appcommonhandle("数据导入",null),
			},
			tbitem17: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem19: {
				caption: commonLogic.appcommonhandle("过滤",null),
				tip: commonLogic.appcommonhandle("过滤",null),
			},
			tbitem18: {
				caption: commonLogic.appcommonhandle("帮助",null),
				tip: commonLogic.appcommonhandle("帮助",null),
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("保存",null),
				tip: commonLogic.appcommonhandle("保存",null),
			},
			tbitem4: {
				caption: commonLogic.appcommonhandle("保存并新建",null),
				tip: commonLogic.appcommonhandle("保存并新建",null),
			},
			tbitem5: {
				caption: commonLogic.appcommonhandle("保存并关闭",null),
				tip: commonLogic.appcommonhandle("保存并关闭",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("删除并关闭",null),
				tip: commonLogic.appcommonhandle("删除并关闭",null),
			},
			tbitem8: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem12: {
				caption: commonLogic.appcommonhandle("新建",null),
				tip: commonLogic.appcommonhandle("新建",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem14: {
				caption: commonLogic.appcommonhandle("拷贝",null),
				tip: commonLogic.appcommonhandle("拷贝",null),
			},
			tbitem16: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem23: {
				caption: commonLogic.appcommonhandle("第一个记录",null),
				tip: commonLogic.appcommonhandle("第一个记录",null),
			},
			tbitem24: {
				caption: commonLogic.appcommonhandle("上一个记录",null),
				tip: commonLogic.appcommonhandle("上一个记录",null),
			},
			tbitem25: {
				caption: commonLogic.appcommonhandle("下一个记录",null),
				tip: commonLogic.appcommonhandle("下一个记录",null),
			},
			tbitem26: {
				caption: commonLogic.appcommonhandle("最后一个记录",null),
				tip: commonLogic.appcommonhandle("最后一个记录",null),
			},
			tbitem21: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem22: {
				caption: commonLogic.appcommonhandle("帮助",null),
				tip: commonLogic.appcommonhandle("帮助",null),
			},
		},
	};
	return data;
}
export default getLocaleResourceBase;