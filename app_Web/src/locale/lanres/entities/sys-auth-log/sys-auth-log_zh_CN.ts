export default {
  fields: {
    logid: "标识",
    username: "用户全局名",
    personname: "用户名称",
    domain: "域",
    authtime: "认证时间",
    ipaddr: "IP地址",
    macaddr: "MAC地址",
    useragent: "客户端",
    authcode: "认证结果",
  },
	views: {
		gridview: {
			caption: "认证日志",
      		title: "认证日志表格视图",
		},
	},
	main_grid: {
		columns: {
			username: "用户全局名",
			personname: "用户名称",
			authtime: "认证时间",
			authcode: "认证结果",
			ipaddr: "IP地址",
			macaddr: "MAC地址",
			useragent: "客户端",
			domain: "域",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			rawitem1: "", 
			formpage1: "常规条件", 
			n_username_like: "用户全局名", 
			n_personname_like: "用户名称", 
			n_authcode_eq: "认证结果", 
			n_domain_like: "域", 
			n_authtime_gtandeq: "认证时间", 
			n_authtime_ltandeq: "", 
		},
		uiactions: {
		},
	},
};