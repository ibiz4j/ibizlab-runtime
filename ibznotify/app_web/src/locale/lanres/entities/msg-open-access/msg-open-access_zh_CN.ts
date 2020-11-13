export default {
  fields: {
    id: "开放平台接入标识",
    name: "开放平台",
    open_type: "开放平台类型",
    access_key: "AccessKey(AppId)",
    secret_key: "SecretKey(AppSecret)",
    region_id: "RegionId（CorpId)",
    access_token: "管理账号token",
    expires_time: "管理账号token过期时间",
    disabled: "是否禁用",
    redirect_uri: "RedirectURI",
    notify_url: "NotifyUrl",
    agent_id: "AGENT_ID",
  },
	views: {
		pickupgridview: {
			caption: "接入开放平台",
      		title: "接入开放平台选择表格视图",
		},
		gridview: {
			caption: "接入开放平台",
      		title: "接入开放平台表格视图",
		},
		pickupview: {
			caption: "接入开放平台",
      		title: "接入开放平台数据选择视图",
		},
		editview: {
			caption: "接入开放平台",
      		title: "接入开放平台编辑视图",
		},
	},
	main_form: {
		details: {
			group1: "接入开放平台基本信息", 
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "开放平台接入标识", 
			srfmajortext: "开放平台", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			accessname: "开放平台", 
			open_type: "开放平台类型", 
			access_key: "AccessKey(AppId)", 
			secret_key: "SecretKey(AppSecret)", 
			region_id: "RegionId（CorpId)", 
			access_token: "管理账号token", 
			expires_time: "管理账号token过期时间", 
			accessid: "开放平台接入标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			accessname: "开放平台",
			open_type: "开放平台类型",
			access_key: "AccessKey(AppId)",
			region_id: "RegionId（CorpId)",
		},
		nodata:"",
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_accessname_like: "开放平台(%)", 
			n_open_type_eq: "开放平台类型(=)", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "新建",
			tip: "新建",
		},
		tbitem4: {
			caption: "编辑",
			tip: "编辑",
		},
		tbitem6: {
			caption: "拷贝",
			tip: "拷贝",
		},
		tbitem7: {
			caption: "-",
			tip: "",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		tbitem9: {
			caption: "-",
			tip: "",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
		},
		tbitem10: {
			caption: "-",
			tip: "",
		},
		tbitem16: {
			caption: "其它",
			tip: "其它",
		},
		tbitem21: {
			caption: "导出数据模型",
			tip: "导出数据模型",
		},
		tbitem23: {
			caption: "数据导入",
			tip: "数据导入",
		},
		tbitem17: {
			caption: "-",
			tip: "",
		},
		tbitem19: {
			caption: "过滤",
			tip: "过滤",
		},
		tbitem18: {
			caption: "帮助",
			tip: "帮助",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem4: {
			caption: "保存并新建",
			tip: "保存并新建",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
		tbitem6: {
			caption: "-",
			tip: "",
		},
		tbitem7: {
			caption: "删除并关闭",
			tip: "删除并关闭",
		},
		tbitem8: {
			caption: "-",
			tip: "",
		},
		tbitem12: {
			caption: "新建",
			tip: "新建",
		},
		tbitem13: {
			caption: "-",
			tip: "",
		},
		tbitem14: {
			caption: "拷贝",
			tip: "拷贝",
		},
		tbitem16: {
			caption: "-",
			tip: "",
		},
		tbitem23: {
			caption: "第一个记录",
			tip: "第一个记录",
		},
		tbitem24: {
			caption: "上一个记录",
			tip: "上一个记录",
		},
		tbitem25: {
			caption: "下一个记录",
			tip: "下一个记录",
		},
		tbitem26: {
			caption: "最后一个记录",
			tip: "最后一个记录",
		},
		tbitem21: {
			caption: "-",
			tip: "",
		},
		tbitem22: {
			caption: "帮助",
			tip: "帮助",
		},
	},
};