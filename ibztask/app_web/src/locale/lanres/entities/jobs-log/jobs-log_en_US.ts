
export default {
  fields: {
    id: "主键ID",
    job_id: "任务ID",
    address: "执行地址",
    handler: "执行器任务HANDLER",
    param: "执行器任务参数",
    fail_retry_count: "失败重试次数",
    trigger_code: "触发器调度返回码",
    trigger_type: "触发器调度类型",
    trigger_msg: "触发器调度信息",
    create_time: "创建时间",
  },
	views: {
		editview: {
			caption: "任务调度日志",
      		title: "任务调度日志编辑视图",
		},
		gridview: {
			caption: "任务调度日志",
      		title: "任务调度日志表格视图",
		},
	},
	main_form: {
		details: {
			group1: "任务调度日志基本信息", 
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "主键ID", 
			srfmajortext: "执行器任务HANDLER", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			job_id: "任务ID", 
			handler: "执行器任务HANDLER", 
			param: "执行器任务参数", 
			fail_retry_count: "失败重试次数", 
			trigger_code: "触发器调度返回码", 
			trigger_type: "触发器调度类型", 
			trigger_msg: "触发器调度信息", 
			address: "执行地址", 
			create_time: "创建时间", 
			id: "主键ID", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			id: "主键ID",
			job_id: "任务ID",
			handler: "执行器任务HANDLER",
			address: "执行地址",
			trigger_code: "触发器调度返回码",
			trigger_type: "触发器调度类型",
			fail_retry_count: "失败重试次数",
			create_time: "创建时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_job_id_eq: "任务ID(等于(=))", 
			n_handler_like: "执行器任务HANDLER(文本包含(%))", 
			n_trigger_code_eq: "触发器调度返回码(等于(=))", 
		},
		uiactions: {
		},
	},
};