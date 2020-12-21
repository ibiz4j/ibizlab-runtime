import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("开放平台接入标识",null),
		name: commonLogic.appcommonhandle("开放平台",null),
		open_type: commonLogic.appcommonhandle("开放平台类型",null),
		access_key: commonLogic.appcommonhandle("AccessKey(AppId)",null),
		secret_key: commonLogic.appcommonhandle("SecretKey(AppSecret)",null),
		region_id: commonLogic.appcommonhandle("RegionId",null),
		access_token: commonLogic.appcommonhandle("管理账号token",null),
		expires_time: commonLogic.appcommonhandle("管理账号token过期时间",null),
		disabled: commonLogic.appcommonhandle("是否禁用",null),
		redirect_uri: commonLogic.appcommonhandle("RedirectURI",null),
		notify_url: commonLogic.appcommonhandle("NotifyUrl",null),
		agent_id: commonLogic.appcommonhandle("AGENT_ID",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("第三方认证平台",null),
				title: commonLogic.appcommonhandle("第三方认证平台",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("第三方认证平台",null),
				title: commonLogic.appcommonhandle("第三方认证平台",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("第三方认证平台基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("开放平台接入标识",null), 
				srfmajortext: commonLogic.appcommonhandle("开放平台",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				accessname: commonLogic.appcommonhandle("开放平台",null), 
				open_type: commonLogic.appcommonhandle("开放平台类型",null), 
				access_key: commonLogic.appcommonhandle("AccessKey(AppId)",null), 
				secret_key: commonLogic.appcommonhandle("SecretKey(AppSecret)",null), 
				redirect_uri: commonLogic.appcommonhandle("RedirectURI",null), 
				region_id: commonLogic.appcommonhandle("RegionId",null), 
				access_token: commonLogic.appcommonhandle("管理账号token",null), 
				expires_time: commonLogic.appcommonhandle("管理账号token过期时间",null), 
				notify_url: commonLogic.appcommonhandle("NotifyUrl",null), 
				agent_id: commonLogic.appcommonhandle("AGENT_ID",null), 
				disabled: commonLogic.appcommonhandle("是否禁用",null), 
				accessid: commonLogic.appcommonhandle("开放平台接入标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				accessid: commonLogic.appcommonhandle("开放平台接入标识",null),
				open_type: commonLogic.appcommonhandle("开放平台类型",null),
				accessname: commonLogic.appcommonhandle("开放平台",null),
				access_key: commonLogic.appcommonhandle("AccessKey(AppId)",null),
				disabled: commonLogic.appcommonhandle("是否禁用",null),
				region_id: commonLogic.appcommonhandle("RegionId",null),
				redirect_uri: commonLogic.appcommonhandle("RedirectURI",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_accessname_like: commonLogic.appcommonhandle("开放平台(文本包含(%))",null), 
				n_open_type_eq: commonLogic.appcommonhandle("开放平台类型(等于(=))",null), 
			},
			uiactions: {
			},
		},
		gridviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("新建",null),
				tip: commonLogic.appcommonhandle("新建",null),
			},
			tbitem4: {
				caption: commonLogic.appcommonhandle("编辑",null),
				tip: commonLogic.appcommonhandle("编辑",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("拷贝",null),
				tip: commonLogic.appcommonhandle("拷贝",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem8: {
				caption: commonLogic.appcommonhandle("删除",null),
				tip: commonLogic.appcommonhandle("删除",null),
			},
			tbitem9: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("导出",null),
				tip: commonLogic.appcommonhandle("导出",null),
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
				caption: commonLogic.appcommonhandle("导出数据模型",null),
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
				caption: commonLogic.appcommonhandle("过滤",null),
				tip: commonLogic.appcommonhandle("过滤",null),
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("保存",null),
				tip: commonLogic.appcommonhandle("保存",null),
			},
			deuiaction1: {
				caption: commonLogic.appcommonhandle("保存并关闭",null),
				tip: commonLogic.appcommonhandle("保存并关闭",null),
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
				caption: commonLogic.appcommonhandle("拷贝",null),
				tip: commonLogic.appcommonhandle("拷贝",null),
			},
		},
	};
	return data;
}
export default getLocaleResourceBase;