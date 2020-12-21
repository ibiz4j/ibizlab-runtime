import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		definitionkey: commonLogic.appcommonhandle("DefinitionKey",null),
		definitionname: commonLogic.appcommonhandle("流程定义名称",null),
		modelversion: commonLogic.appcommonhandle("模型版本",null),
		modelenable: commonLogic.appcommonhandle("模型是否启用",null),
		pssystemid: commonLogic.appcommonhandle("系统标识",null),
		md5check: commonLogic.appcommonhandle("校验",null),
		bpmnfile: commonLogic.appcommonhandle("BPMN",null),
		deploykey: commonLogic.appcommonhandle("DeployKey",null),
		webserviceids: commonLogic.appcommonhandle("WebServiceIds",null),
		mobileserviceids: commonLogic.appcommonhandle("MobileServiceIds",null),
	},
		views: {
			editview: {
				caption: commonLogic.appcommonhandle("流程定义查看",null),
				title: commonLogic.appcommonhandle("流程定义查看",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("流程定义",null),
				title: commonLogic.appcommonhandle("流程定义",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("模型基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("DefinitionKey",null), 
				srfmajortext: commonLogic.appcommonhandle("流程定义名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				definitionkey: commonLogic.appcommonhandle("DefinitionKey",null), 
				deploykey: commonLogic.appcommonhandle("DefinitionKey",null), 
				definitionname: commonLogic.appcommonhandle("流程定义名称",null), 
				pssystemid: commonLogic.appcommonhandle("系统标识",null), 
				modelversion: commonLogic.appcommonhandle("模型版本",null), 
				modelenable: commonLogic.appcommonhandle("模型是否启用",null), 
				bpmnfile: commonLogic.appcommonhandle("BPMN",null), 
				md5check: commonLogic.appcommonhandle("校验",null), 
				webserviceids: commonLogic.appcommonhandle("WebServiceIds",null), 
				mobileserviceids: commonLogic.appcommonhandle("MobileServiceIds",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				definitionkey: commonLogic.appcommonhandle("DefinitionKey",null),
				definitionname: commonLogic.appcommonhandle("流程定义名称",null),
				pssystemid: commonLogic.appcommonhandle("系统标识",null),
				modelversion: commonLogic.appcommonhandle("模型版本",null),
				modelenable: commonLogic.appcommonhandle("模型是否启用",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_deploykey_like: commonLogic.appcommonhandle("DefinitionKey",null), 
				n_definitionname_like: commonLogic.appcommonhandle("流程定义名称",null), 
			},
			uiactions: {
			},
		},
		gridviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("New",null),
				tip: commonLogic.appcommonhandle("New",null),
			},
			tbitem4: {
				caption: commonLogic.appcommonhandle("Edit",null),
				tip: commonLogic.appcommonhandle("Edit {0}",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem8: {
				caption: commonLogic.appcommonhandle("Remove",null),
				tip: commonLogic.appcommonhandle("Remove {0}",null),
			},
			tbitem9: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("Export",null),
				tip: commonLogic.appcommonhandle("Export {0} Data To Excel",null),
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
				caption: commonLogic.appcommonhandle("Export Data Model",null),
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
				caption: commonLogic.appcommonhandle("Filter",null),
				tip: commonLogic.appcommonhandle("Filter",null),
			},
			tbitem18: {
				caption: commonLogic.appcommonhandle("Help",null),
				tip: commonLogic.appcommonhandle("Help",null),
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("Save",null),
				tip: commonLogic.appcommonhandle("Save",null),
			},
			tbitem4: {
				caption: commonLogic.appcommonhandle("Save And New",null),
				tip: commonLogic.appcommonhandle("Save And New",null),
			},
			tbitem5: {
				caption: commonLogic.appcommonhandle("Save And Close",null),
				tip: commonLogic.appcommonhandle("Save And Close Window",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("Remove And Close",null),
				tip: commonLogic.appcommonhandle("Remove And Close Window",null),
			},
			tbitem8: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem12: {
				caption: commonLogic.appcommonhandle("New",null),
				tip: commonLogic.appcommonhandle("New",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem14: {
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
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
				caption: commonLogic.appcommonhandle("Help",null),
				tip: commonLogic.appcommonhandle("Help",null),
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;