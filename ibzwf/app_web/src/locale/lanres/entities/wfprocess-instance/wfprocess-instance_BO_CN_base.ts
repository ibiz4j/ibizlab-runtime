import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("实例标识",null),
		name: commonLogic.appcommonhandle("实例名称",null),
		processdefinitionkey: commonLogic.appcommonhandle("DefinitionKey",null),
		processdefinitionname: commonLogic.appcommonhandle("流程定义名称",null),
		businesskey: commonLogic.appcommonhandle("业务键值",null),
		starttime: commonLogic.appcommonhandle("启动时间",null),
		endtime: commonLogic.appcommonhandle("结束时间",null),
		startuserid: commonLogic.appcommonhandle("发起人标识",null),
		startusername: commonLogic.appcommonhandle("发起人",null),
		processdefinitionid: commonLogic.appcommonhandle("DefinitionId",null),
		wfusers: commonLogic.appcommonhandle("步骤用户",null),
		taskdefinitionkey: commonLogic.appcommonhandle("步骤标记",null),
	},
		views: {
			activeinstancegridview: {
				caption: commonLogic.appcommonhandle("流程实例",null),
				title: commonLogic.appcommonhandle("流程中实例表格视图",null),
			},
			activeinstanceoptionview: {
				caption: commonLogic.appcommonhandle("流程实例",null),
				title: commonLogic.appcommonhandle("流程跳转设置",null),
			},
		},
		jump_form: {
			details: {
				group1: commonLogic.appcommonhandle("流程实例基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("实例标识",null), 
				srfmajortext: commonLogic.appcommonhandle("实例名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				taskdefinitionname: commonLogic.appcommonhandle("流程步骤",null), 
				wfusers: commonLogic.appcommonhandle("操作用户",null), 
				taskdefinitionkey: commonLogic.appcommonhandle("流程步骤标识",null), 
				definitionkey: commonLogic.appcommonhandle("流程定义标识",null), 
				definitionid: commonLogic.appcommonhandle("DefinitionId",null), 
				businesskey: commonLogic.appcommonhandle("业务键值",null), 
				instanceid: commonLogic.appcommonhandle("实例标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				definitionname: commonLogic.appcommonhandle("流程定义名称",null),
				instancename: commonLogic.appcommonhandle("实例名称",null),
				businesskey: commonLogic.appcommonhandle("业务键值",null),
				starttime: commonLogic.appcommonhandle("启动时间",null),
				startuserid: commonLogic.appcommonhandle("发起人标识",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
			},
			uiactions: {
			},
		},
		activeinstancegridviewtoolbar_toolbar: {
			deuiaction1_jump: {
				caption: commonLogic.appcommonhandle("流程跳转",null),
				tip: commonLogic.appcommonhandle("流程跳转",null),
			},
			deuiaction1_restart: {
				caption: commonLogic.appcommonhandle("重启流程",null),
				tip: commonLogic.appcommonhandle("重启流程",null),
			},
		},
	};
	return data;
}
export default getLocaleResourceBase;