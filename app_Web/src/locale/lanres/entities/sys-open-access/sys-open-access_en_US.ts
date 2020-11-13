
export default {
  fields: {
    id: "开放平台接入标识",
    name: "开放平台",
    open_type: "开放平台类型",
    access_key: "AccessKey(AppId)",
    secret_key: "SecretKey(AppSecret)",
    region_id: "RegionId",
    access_token: "管理账号token",
    expires_time: "管理账号token过期时间",
    disabled: "是否禁用",
    redirect_uri: "RedirectURI",
    notify_url: "NotifyUrl",
    agent_id: "AGENT_ID",
  },
	views: {
		gridview: {
			caption: "第三方认证平台",
      		title: "第三方认证平台",
		},
		editview: {
			caption: "第三方认证平台",
      		title: "第三方认证平台",
		},
	},
	main_form: {
		details: {
			group1: "第三方认证平台基本信息", 
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
			redirect_uri: "RedirectURI", 
			region_id: "RegionId", 
			access_token: "管理账号token", 
			expires_time: "管理账号token过期时间", 
			notify_url: "NotifyUrl", 
			agent_id: "AGENT_ID", 
			disabled: "是否禁用", 
			accessid: "开放平台接入标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			accessid: "开放平台接入标识",
			open_type: "开放平台类型",
			accessname: "开放平台",
			access_key: "AccessKey(AppId)",
			disabled: "是否禁用",
			region_id: "RegionId",
			redirect_uri: "RedirectURI",
		},
		nodata:"",
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_accessname_like: "开放平台(文本包含(%))", 
			n_open_type_eq: "开放平台类型(等于(=))", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem4: {
			caption: "Edit",
			tip: "Edit {0}",
		},
		tbitem6: {
			caption: "Copy",
			tip: "Copy {0}",
		},
		tbitem7: {
			caption: "-",
			tip: "",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem9: {
			caption: "-",
			tip: "",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
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
			caption: "Export Data Model",
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
			caption: "Filter",
			tip: "Filter",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		deuiaction1: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
		deuiaction2: {
			caption: "关闭",
			tip: "关闭",
		},
		tbitem6: {
			caption: "-",
			tip: "",
		},
		tbitem14: {
			caption: "Copy",
			tip: "Copy {0}",
		},
	},
};