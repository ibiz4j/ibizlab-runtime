import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		usertaskid: commonLogic.appcommonhandle("节点标识",null),
		usertaskname: commonLogic.appcommonhandle("节点名称",null),
		processdefinitionkey: commonLogic.appcommonhandle("DefinitionKey",null),
		processdefinitionname: commonLogic.appcommonhandle("流程定义名称",null),
		version: commonLogic.appcommonhandle("版本",null),
		cnt: commonLogic.appcommonhandle("数量",null),
		processdefinitionid: commonLogic.appcommonhandle("DefinitionId",null),
	},
		views: {
			processnodepickupgridview: {
				caption: commonLogic.appcommonhandle("流程定义节点",null),
				title: commonLogic.appcommonhandle("流程定义节点选择表格视图",null),
			},
			pickupview: {
				caption: commonLogic.appcommonhandle("流程定义节点",null),
				title: commonLogic.appcommonhandle("流程定义节点数据选择视图",null),
			},
			porcessnodepickupview: {
				caption: commonLogic.appcommonhandle("流程定义节点",null),
				title: commonLogic.appcommonhandle("流程定义节点数据选择视图",null),
			},
			pickupgridview: {
				caption: commonLogic.appcommonhandle("流程定义节点",null),
				title: commonLogic.appcommonhandle("流程定义节点选择表格视图",null),
			},
		},
		main_grid: {
			columns: {
				nodeid: commonLogic.appcommonhandle("节点标识",null),
				nodename: commonLogic.appcommonhandle("节点名称",null),
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
	};
	return data;
}
export default getLocaleResourceBase;