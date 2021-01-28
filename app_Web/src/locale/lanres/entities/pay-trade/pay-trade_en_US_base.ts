import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		subject: commonLogic.appcommonhandle("订单标题",null),
		total_amount: commonLogic.appcommonhandle("订单金额",null),
		trade_name: commonLogic.appcommonhandle("交易名称",null),
		trade_type: commonLogic.appcommonhandle("支付类型",null),
		trade_status: commonLogic.appcommonhandle("支付状态",null),
		out_trade_no: commonLogic.appcommonhandle("订单号",null),
		trade_id: commonLogic.appcommonhandle("交易标识",null),
		app_id: commonLogic.appcommonhandle("AccessKey(AppId)",null),
		access_name: commonLogic.appcommonhandle("支付平台",null),
		access_id: commonLogic.appcommonhandle("支付平台接入标识",null),
	},
		views: {
			editview: {
				caption: commonLogic.appcommonhandle("支付交易",null),
				title: commonLogic.appcommonhandle("支付交易编辑视图",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("支付交易",null),
				title: commonLogic.appcommonhandle("支付交易表格视图",null),
			},
		},
		main_form: {
			details: {
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("交易标识",null), 
				srfmajortext: commonLogic.appcommonhandle("交易名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				tradename: commonLogic.appcommonhandle("交易名称",null), 
				outtradeno: commonLogic.appcommonhandle("订单号",null), 
				subject: commonLogic.appcommonhandle("订单标题",null), 
				totalamount: commonLogic.appcommonhandle("订单金额",null), 
				accessname: commonLogic.appcommonhandle("支付平台",null), 
				tradeid: commonLogic.appcommonhandle("交易标识",null), 
				accessid: commonLogic.appcommonhandle("支付平台接入标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				tradename: commonLogic.appcommonhandle("交易名称",null),
				subject: commonLogic.appcommonhandle("订单标题",null),
				outtradeno: commonLogic.appcommonhandle("订单号",null),
				totalamount: commonLogic.appcommonhandle("订单金额",null),
				accessname: commonLogic.appcommonhandle("支付平台",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
			},
			uiactions: {
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("Save",null),
				tip: commonLogic.appcommonhandle("Save",null),
			},
			deuiaction1: {
				caption: commonLogic.appcommonhandle("Save And Close",null),
				tip: commonLogic.appcommonhandle("Save And Close Window",null),
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
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
			},
		},
		gridviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("New",null),
				tip: commonLogic.appcommonhandle("New",null),
			},
			tbitem4: {
				caption: commonLogic.appcommonhandle("Edit",null),
				tip: commonLogic.appcommonhandle("Edit {0}",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem8: {
				caption: commonLogic.appcommonhandle("Remove",null),
				tip: commonLogic.appcommonhandle("Remove {0}",null),
			},
			tbitem9: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("Export",null),
				tip: commonLogic.appcommonhandle("Export {0} Data To Excel",null),
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
				caption: commonLogic.appcommonhandle("Export Data Model",null),
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
				caption: commonLogic.appcommonhandle("Filter",null),
				tip: commonLogic.appcommonhandle("Filter",null),
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;