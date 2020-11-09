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
			caption: "支付交易1",
      		title: "支付交易编辑视图",
		},
		gridview: {
			caption: "支付交易1",
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
		nodata:"",
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
};