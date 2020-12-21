import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("主键ID",null),
		job_id: commonLogic.appcommonhandle("任务ID",null),
		address: commonLogic.appcommonhandle("执行地址",null),
		handler: commonLogic.appcommonhandle("执行器任务HANDLER",null),
		param: commonLogic.appcommonhandle("执行器任务参数",null),
		fail_retry_count: commonLogic.appcommonhandle("失败重试次数",null),
		trigger_code: commonLogic.appcommonhandle("触发器调度返回码",null),
		trigger_type: commonLogic.appcommonhandle("触发器调度类型",null),
		trigger_msg: commonLogic.appcommonhandle("触发器调度信息",null),
		create_time: commonLogic.appcommonhandle("创建时间",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("日志",null),
				title: commonLogic.appcommonhandle("日志",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("日志",null),
				title: commonLogic.appcommonhandle("日志",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("任务调度日志基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("主键ID",null), 
				srfmajortext: commonLogic.appcommonhandle("执行器任务HANDLER",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				job_id: commonLogic.appcommonhandle("任务ID",null), 
				handler: commonLogic.appcommonhandle("执行器任务HANDLER",null), 
				param: commonLogic.appcommonhandle("执行器任务参数",null), 
				fail_retry_count: commonLogic.appcommonhandle("失败重试次数",null), 
				trigger_code: commonLogic.appcommonhandle("触发器调度返回码",null), 
				trigger_type: commonLogic.appcommonhandle("触发器调度类型",null), 
				trigger_msg: commonLogic.appcommonhandle("触发器调度信息",null), 
				address: commonLogic.appcommonhandle("执行地址",null), 
				create_time: commonLogic.appcommonhandle("创建时间",null), 
				id: commonLogic.appcommonhandle("主键ID",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				id: commonLogic.appcommonhandle("主键ID",null),
				job_id: commonLogic.appcommonhandle("任务ID",null),
				handler: commonLogic.appcommonhandle("执行器任务HANDLER",null),
				address: commonLogic.appcommonhandle("执行地址",null),
				trigger_code: commonLogic.appcommonhandle("触发器调度返回码",null),
				trigger_type: commonLogic.appcommonhandle("触发器调度类型",null),
				fail_retry_count: commonLogic.appcommonhandle("失败重试次数",null),
				create_time: commonLogic.appcommonhandle("创建时间",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_job_id_eq: commonLogic.appcommonhandle("任务ID(等于(=))",null), 
				n_handler_like: commonLogic.appcommonhandle("执行器任务HANDLER(文本包含(%))",null), 
				n_trigger_code_eq: commonLogic.appcommonhandle("触发器调度返回码(等于(=))",null), 
			},
			uiactions: {
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;