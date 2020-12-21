import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("主键ID",null),
		app: commonLogic.appcommonhandle("服务名",null),
		address: commonLogic.appcommonhandle("执行地址",null),
		status: commonLogic.appcommonhandle("状态",null),
		update_time: commonLogic.appcommonhandle("更新时间",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("注册",null),
				title: commonLogic.appcommonhandle("注册",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("注册",null),
				title: commonLogic.appcommonhandle("注册",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("任务注册信息基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("主键ID",null), 
				srfmajortext: commonLogic.appcommonhandle("服务名",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				app: commonLogic.appcommonhandle("服务名",null), 
				address: commonLogic.appcommonhandle("执行地址",null), 
				status: commonLogic.appcommonhandle("状态",null), 
				id: commonLogic.appcommonhandle("主键ID",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				id: commonLogic.appcommonhandle("主键ID",null),
				app: commonLogic.appcommonhandle("服务名",null),
				address: commonLogic.appcommonhandle("执行地址",null),
				status: commonLogic.appcommonhandle("状态",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_app_like: commonLogic.appcommonhandle("服务名(文本包含(%))",null), 
				n_status_eq: commonLogic.appcommonhandle("状态(等于(=))",null), 
			},
			uiactions: {
			},
		},
		gridviewtoolbar_toolbar: {
			tbitem26: {
				caption: commonLogic.appcommonhandle("新建",null),
				tip: commonLogic.appcommonhandle("新建",null),
			},
			tbitem19: {
				caption: commonLogic.appcommonhandle("编辑",null),
				tip: commonLogic.appcommonhandle("编辑",null),
			},
			tbitem22: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("拷贝",null),
				tip: commonLogic.appcommonhandle("拷贝",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem9: {
				caption: commonLogic.appcommonhandle("删除",null),
				tip: commonLogic.appcommonhandle("删除",null),
			},
			tbitem10: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem11: {
				caption: commonLogic.appcommonhandle("导出",null),
				tip: commonLogic.appcommonhandle("导出",null),
			},
			tbitem12: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem17: {
				caption: commonLogic.appcommonhandle("其它",null),
				tip: commonLogic.appcommonhandle("其它",null),
			},
			tbitem29: {
				caption: commonLogic.appcommonhandle("导出数据模型",null),
				tip: commonLogic.appcommonhandle("导出数据模型",null),
			},
			tbitem30: {
				caption: commonLogic.appcommonhandle("数据导入",null),
				tip: commonLogic.appcommonhandle("数据导入",null),
			},
			tbitem2: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem3: {
				caption: commonLogic.appcommonhandle("过滤",null),
				tip: commonLogic.appcommonhandle("过滤",null),
			},
			tbitem4: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem5: {
				caption: commonLogic.appcommonhandle("帮助",null),
				tip: commonLogic.appcommonhandle("帮助",null),
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("保存",null),
				tip: commonLogic.appcommonhandle("保存",null),
			},
			deuiaction2: {
				caption: commonLogic.appcommonhandle("保存并关闭",null),
				tip: commonLogic.appcommonhandle("保存并关闭",null),
			},
			deuiaction1: {
				caption: commonLogic.appcommonhandle("关闭",null),
				tip: commonLogic.appcommonhandle("关闭",null),
			},
		},
	};
	return data;
}
export default getLocaleResourceBase;