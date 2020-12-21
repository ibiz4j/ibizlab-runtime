import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("主键ID",null),
		tenant_id: commonLogic.appcommonhandle("租户ID",null),
		app: commonLogic.appcommonhandle("服务名",null),
		cron: commonLogic.appcommonhandle("任务执行CRON",null),
		handler: commonLogic.appcommonhandle("执行器任务HANDLER",null),
		param: commonLogic.appcommonhandle("执行器任务参数",null),
		timeout: commonLogic.appcommonhandle("任务执行超时时间（秒）",null),
		fail_retry_count: commonLogic.appcommonhandle("失败重试次数",null),
		last_time: commonLogic.appcommonhandle("上次调度时间",null),
		next_time: commonLogic.appcommonhandle("下次调度时间",null),
		author: commonLogic.appcommonhandle("所有者",null),
		remark: commonLogic.appcommonhandle("备注",null),
		status: commonLogic.appcommonhandle("状态",null),
		update_time: commonLogic.appcommonhandle("更新时间",null),
		create_time: commonLogic.appcommonhandle("创建时间",null),
	},
		views: {
			editview: {
				caption: commonLogic.appcommonhandle("任务信息",null),
				title: commonLogic.appcommonhandle("任务信息编辑视图",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("任务信息",null),
				title: commonLogic.appcommonhandle("任务信息表格视图",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("任务信息基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("主键ID",null), 
				srfmajortext: commonLogic.appcommonhandle("执行器任务HANDLER",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				app: commonLogic.appcommonhandle("服务名",null), 
				handler: commonLogic.appcommonhandle("执行器任务HANDLER",null), 
				cron: commonLogic.appcommonhandle("任务执行CRON",null), 
				param: commonLogic.appcommonhandle("执行器任务参数",null), 
				last_time: commonLogic.appcommonhandle("上次调度时间",null), 
				next_time: commonLogic.appcommonhandle("下次调度时间",null), 
				timeout: commonLogic.appcommonhandle("任务执行超时时间（秒）",null), 
				fail_retry_count: commonLogic.appcommonhandle("失败重试次数",null), 
				author: commonLogic.appcommonhandle("所有者",null), 
				remark: commonLogic.appcommonhandle("备注",null), 
				status: commonLogic.appcommonhandle("状态",null), 
				tenant_id: commonLogic.appcommonhandle("租户ID",null), 
				create_time: commonLogic.appcommonhandle("创建时间",null), 
				update_time: commonLogic.appcommonhandle("更新时间",null), 
				id: commonLogic.appcommonhandle("主键ID",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				id: commonLogic.appcommonhandle("主键ID",null),
				app: commonLogic.appcommonhandle("服务名",null),
				handler: commonLogic.appcommonhandle("执行器任务HANDLER",null),
				cron: commonLogic.appcommonhandle("任务执行CRON",null),
				last_time: commonLogic.appcommonhandle("上次调度时间",null),
				next_time: commonLogic.appcommonhandle("下次调度时间",null),
				status: commonLogic.appcommonhandle("状态",null),
				timeout: commonLogic.appcommonhandle("任务执行超时时间（秒）",null),
				update_time: commonLogic.appcommonhandle("更新时间",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_app_like: commonLogic.appcommonhandle("服务名(文本包含(%))",null), 
				n_handler_like: commonLogic.appcommonhandle("执行器任务HANDLER(文本包含(%))",null), 
				n_status_eq: commonLogic.appcommonhandle("状态(等于(=))",null), 
			},
			uiactions: {
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("保存",null),
				tip: commonLogic.appcommonhandle("保存",null),
			},
			deuiaction1: {
				caption: commonLogic.appcommonhandle("关闭",null),
				tip: commonLogic.appcommonhandle("关闭",null),
			},
		},
		gridviewtoolbar_toolbar: {
			deuiaction1: {
				caption: commonLogic.appcommonhandle("启动",null),
				tip: commonLogic.appcommonhandle("启动",null),
			},
			deuiaction2: {
				caption: commonLogic.appcommonhandle("停止",null),
				tip: commonLogic.appcommonhandle("停止",null),
			},
			deuiaction3: {
				caption: commonLogic.appcommonhandle("执行",null),
				tip: commonLogic.appcommonhandle("执行",null),
			},
			deuiaction4: {
				caption: commonLogic.appcommonhandle("新建",null),
				tip: commonLogic.appcommonhandle("新建",null),
			},
			deuiaction5: {
				caption: commonLogic.appcommonhandle("编辑",null),
				tip: commonLogic.appcommonhandle("编辑",null),
			},
			deuiaction6: {
				caption: commonLogic.appcommonhandle("删除",null),
				tip: commonLogic.appcommonhandle("删除",null),
			},
			deuiaction7: {
				caption: commonLogic.appcommonhandle("过滤",null),
				tip: commonLogic.appcommonhandle("过滤",null),
			},
		},
	};
	return data;
}
export default getLocaleResourceBase;