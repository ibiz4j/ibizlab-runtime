import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		tid: commonLogic.appcommonhandle("模板标识",null),
		template_name: commonLogic.appcommonhandle("模板标题",null),
		template_type: commonLogic.appcommonhandle("模板类型",null),
		content: commonLogic.appcommonhandle("模板内容",null),
		template_id: commonLogic.appcommonhandle("模板标识",null),
		template_url: commonLogic.appcommonhandle("URL",null),
		access_id: commonLogic.appcommonhandle("开放平台接入标识",null),
		access_name: commonLogic.appcommonhandle("接入平台",null),
		open_type: commonLogic.appcommonhandle("接入平台类型",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("消息模板",null),
				title: commonLogic.appcommonhandle("消息模板表格视图",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("消息模板",null),
				title: commonLogic.appcommonhandle("消息模板编辑视图",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("消息模板基本信息",null), 
				grouppanel1: commonLogic.appcommonhandle("分组面板",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("模板标识",null), 
				srfmajortext: commonLogic.appcommonhandle("模板标题",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				accessid: commonLogic.appcommonhandle("开放平台接入标识",null), 
				accessname: commonLogic.appcommonhandle("接入平台",null), 
				open_type: commonLogic.appcommonhandle("接入平台类型",null), 
				template_type: commonLogic.appcommonhandle("模板类型",null), 
				template_name: commonLogic.appcommonhandle("模板标题",null), 
				template_id: commonLogic.appcommonhandle("模板标识",null), 
				content: commonLogic.appcommonhandle("模板内容",null), 
				template_url: commonLogic.appcommonhandle("URL",null), 
				tid: commonLogic.appcommonhandle("模板标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				template_type: commonLogic.appcommonhandle("模板类型",null),
				template_id: commonLogic.appcommonhandle("模板标识",null),
				template_name: commonLogic.appcommonhandle("模板标题",null),
				open_type: commonLogic.appcommonhandle("接入平台类型",null),
				accessname: commonLogic.appcommonhandle("接入平台",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_accessname_like: commonLogic.appcommonhandle("接入平台(%)",null), 
				n_template_name_like: commonLogic.appcommonhandle("模板标题(文本包含(%))",null), 
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
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("Save",null),
				tip: commonLogic.appcommonhandle("Save",null),
			},
			deuiaction1: {
				caption: commonLogic.appcommonhandle("Save And Close",null),
				tip: commonLogic.appcommonhandle("Save And Close Window",null),
			},
			deuiaction2: {
				caption: commonLogic.appcommonhandle("关闭",null),
				tip: commonLogic.appcommonhandle("关闭",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem14: {
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;