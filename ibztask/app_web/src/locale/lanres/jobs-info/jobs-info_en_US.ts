
export default {
  fields: {
    id: '主键ID',
    tenant_id: '租户ID',
    app: '服务名',
    cron: '任务执行CRON',
    handler: '执行器任务HANDLER',
    param: '执行器任务参数',
    timeout: '任务执行超时时间（秒）',
    fail_retry_count: '失败重试次数',
    last_time: '上次调度时间',
    next_time: '下次调度时间',
    author: '所有者',
    remark: '备注',
    status: '状态',
    update_time: '更新时间',
    create_time: '创建时间',
  },
	views: {
		editview: {
			caption: "任务信息",
      title: '任务信息',
		},
		gridview: {
			caption: "任务信息",
      title: '任务信息',
		},
	},
	main_form: {
		details: {
			group1: "任务信息基本信息", 
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "主键ID", 
			srfmajortext: "执行器任务HANDLER", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			app: "服务名", 
			handler: "执行器任务HANDLER", 
			cron: "任务执行CRON", 
			param: "执行器任务参数", 
			last_time: "上次调度时间", 
			next_time: "下次调度时间", 
			timeout: "任务执行超时时间（秒）", 
			fail_retry_count: "失败重试次数", 
			author: "所有者", 
			remark: "备注", 
			status: "状态", 
			tenant_id: "租户ID", 
			create_time: "创建时间", 
			update_time: "更新时间", 
			id: "主键ID", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			id: "主键ID",
			app: "服务名",
			handler: "执行器任务HANDLER",
			cron: "任务执行CRON",
			last_time: "上次调度时间",
			next_time: "下次调度时间",
			status: "状态",
			timeout: "任务执行超时时间（秒）",
			update_time: "更新时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_app_like: "服务名(文本包含(%))", 
			n_handler_like: "执行器任务HANDLER(文本包含(%))", 
			n_status_eq: "状态(等于(=))", 
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		deuiaction1: {
			caption: "关闭",
			tip: "关闭",
		},
	},
	gridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "启动",
			tip: "启动",
		},
		deuiaction2: {
			caption: "停止",
			tip: "停止",
		},
		deuiaction3: {
			caption: "执行",
			tip: "执行",
		},
		deuiaction4: {
			caption: "New",
			tip: "New",
		},
		deuiaction5: {
			caption: "Edit",
			tip: "Edit {0}",
		},
		deuiaction6: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		deuiaction7: {
			caption: "Filter",
			tip: "Filter",
		},
	},
};