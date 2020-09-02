
export default {
  fields: {
    subject: "订单标题",
    total_amount: "订单金额",
    trade_name: "交易名称",
    trade_type: "支付类型",
    trade_status: "支付状态",
    out_trade_no: "订单号",
    trade_id: "交易标识",
    app_id: "AccessKey(AppId)",
    access_name: "支付平台",
    access_id: "支付平台接入标识",
  },
	views: {
		editview: {
			caption: "支付交易",
      		title: "支付交易编辑视图",
		},
		gridview: {
			caption: "支付交易",
      		title: "支付交易表格视图",
		},
	},
	main_form: {
		details: {
			formpage1: "基本信息", 
			srforikey: "", 
			srfkey: "交易标识", 
			srfmajortext: "交易名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			tradename: "交易名称", 
			outtradeno: "订单号", 
			subject: "订单标题", 
			totalamount: "订单金额", 
			accessname: "支付平台", 
			tradeid: "交易标识", 
			accessid: "支付平台接入标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			tradename: "交易名称",
			subject: "订单标题",
			outtradeno: "订单号",
			totalamount: "订单金额",
			accessname: "支付平台",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
		},
		uiactions: {
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		tbitem4: {
			caption: "Save And New",
			tip: "Save And New",
		},
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
		tbitem6: {
			caption: "-",
			tip: "",
		},
		tbitem7: {
			caption: "Remove And Close",
			tip: "Remove And Close Window",
		},
		tbitem8: {
			caption: "-",
			tip: "",
		},
		tbitem12: {
			caption: "New",
			tip: "New",
		},
		tbitem13: {
			caption: "-",
			tip: "",
		},
		tbitem14: {
			caption: "Copy",
			tip: "Copy {0}",
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
			caption: "Help",
			tip: "Help",
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
		tbitem18: {
			caption: "Help",
			tip: "Help",
		},
	},
};