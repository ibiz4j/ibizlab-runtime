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
			disabled: "是否禁用", 
			lic: "授权", 
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
		tbitem19: {
			caption: "过滤",
			tip: "过滤",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
		tbitem6: {
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
	},
};