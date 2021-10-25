import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		logid: commonLogic.appcommonhandle("标识",null),
		username: commonLogic.appcommonhandle("用户全局名",null),
		personname: commonLogic.appcommonhandle("用户名称",null),
		domain: commonLogic.appcommonhandle("域",null),
		authtime: commonLogic.appcommonhandle("认证时间",null),
		ipaddr: commonLogic.appcommonhandle("IP地址",null),
		macaddr: commonLogic.appcommonhandle("MAC地址",null),
		useragent: commonLogic.appcommonhandle("客户端",null),
		authcode: commonLogic.appcommonhandle("认证结果",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("认证日志",null),
				title: commonLogic.appcommonhandle("认证日志",null),
			},
		},
		main_grid: {
			columns: {
				username: commonLogic.appcommonhandle("用户全局名",null),
				personname: commonLogic.appcommonhandle("用户名称",null),
				authtime: commonLogic.appcommonhandle("认证时间",null),
				authcode: commonLogic.appcommonhandle("认证结果",null),
				ipaddr: commonLogic.appcommonhandle("IP地址",null),
				macaddr: commonLogic.appcommonhandle("MAC地址",null),
				useragent: commonLogic.appcommonhandle("客户端",null),
				domains: commonLogic.appcommonhandle("域",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_username_like: commonLogic.appcommonhandle("用户全局名(文本包含(%))",null), 
				n_personname_like: commonLogic.appcommonhandle("用户名称(文本包含(%))",null), 
				n_authcode_eq: commonLogic.appcommonhandle("认证结果(等于(=))",null), 
				n_authtime_gtandeq: commonLogic.appcommonhandle("认证时间(大于等于(>=))",null), 
				n_authtime_ltandeq: commonLogic.appcommonhandle("认证时间(小于等于(<=))",null), 
				n_domains_like: commonLogic.appcommonhandle("域(%)",null), 
			},
			uiactions: {
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;