import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("ID",null),
		name: commonLogic.appcommonhandle("名称",null),
		bpmnfile: commonLogic.appcommonhandle("BPMN",null),
	},
		views: {
			editview: {
				caption: commonLogic.appcommonhandle("流程模型",null),
				title: commonLogic.appcommonhandle("流程模型编辑视图",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("流程模型",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("ID",null), 
				srfmajortext: commonLogic.appcommonhandle("名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				bpmnfile: commonLogic.appcommonhandle("BPMN",null), 
				modelid: commonLogic.appcommonhandle("ID",null), 
			},
			uiactions: {
			},
		},
		editviewtoolbar_toolbar: {
			tbitem1: {
				caption: commonLogic.appcommonhandle("保存",null),
				tip: commonLogic.appcommonhandle("保存",null),
			},
		},
	};
	return data;
}
export default getLocaleResourceBase;