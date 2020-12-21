import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		value_key: commonLogic.appcommonhandle("标识",null),
		catalog_id: commonLogic.appcommonhandle("目录代码",null),
		catalog_name: commonLogic.appcommonhandle("目录",null),
		value: commonLogic.appcommonhandle("代码值",null),
		label: commonLogic.appcommonhandle("名称",null),
		parent: commonLogic.appcommonhandle("父代码值",null),
		filter: commonLogic.appcommonhandle("过滤项",null),
		cls: commonLogic.appcommonhandle("栏目样式",null),
		icon_class: commonLogic.appcommonhandle("图标",null),
		disabled: commonLogic.appcommonhandle("是否禁用",null),
		expired: commonLogic.appcommonhandle("过期/失效",null),
		showorder: commonLogic.appcommonhandle("排序",null),
		extension: commonLogic.appcommonhandle("扩展",null),
		updatedate: commonLogic.appcommonhandle("最后修改时间",null),
		createdate: commonLogic.appcommonhandle("创建时间",null),
	},
		views: {
			editview: {
				caption: commonLogic.appcommonhandle("字典项",null),
				title: commonLogic.appcommonhandle("字典项编辑视图",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("字典项",null),
				title: commonLogic.appcommonhandle("字典项表格视图",null),
			},
			grideditview: {
				caption: commonLogic.appcommonhandle("字典项",null),
				title: commonLogic.appcommonhandle("字典项表格视图",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("字典项基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("最后修改时间",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("标识",null), 
				srfmajortext: commonLogic.appcommonhandle("名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				cname: commonLogic.appcommonhandle("目录",null), 
				val: commonLogic.appcommonhandle("代码值",null), 
				label: commonLogic.appcommonhandle("名称",null), 
				pval: commonLogic.appcommonhandle("父代码值",null), 
				showorder: commonLogic.appcommonhandle("排序",null), 
				disabled: commonLogic.appcommonhandle("是否禁用",null), 
				expired: commonLogic.appcommonhandle("过期/失效",null), 
				vfilter: commonLogic.appcommonhandle("过滤项",null), 
				iconcls: commonLogic.appcommonhandle("图标",null), 
				cls: commonLogic.appcommonhandle("栏目样式",null), 
				extension: commonLogic.appcommonhandle("扩展",null), 
				cid: commonLogic.appcommonhandle("目录代码",null), 
				vkey: commonLogic.appcommonhandle("标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				cid: commonLogic.appcommonhandle("目录代码",null),
				val: commonLogic.appcommonhandle("代码值",null),
				label: commonLogic.appcommonhandle("名称",null),
				pval: commonLogic.appcommonhandle("父代码值",null),
				showorder: commonLogic.appcommonhandle("排序",null),
				cname: commonLogic.appcommonhandle("目录",null),
				cls: commonLogic.appcommonhandle("栏目样式",null),
				iconcls: commonLogic.appcommonhandle("图标",null),
				vfilter: commonLogic.appcommonhandle("过滤项",null),
				disabled: commonLogic.appcommonhandle("是否禁用",null),
				expired: commonLogic.appcommonhandle("过期/失效",null),
				extension: commonLogic.appcommonhandle("扩展",null),
				updatedate: commonLogic.appcommonhandle("最后修改时间",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		options_grid: {
			columns: {
				cid: commonLogic.appcommonhandle("目录代码",null),
				val: commonLogic.appcommonhandle("代码值",null),
				label: commonLogic.appcommonhandle("名称",null),
				pval: commonLogic.appcommonhandle("父代码值",null),
				showorder: commonLogic.appcommonhandle("排序",null),
				cname: commonLogic.appcommonhandle("目录",null),
				cls: commonLogic.appcommonhandle("栏目样式",null),
				iconcls: commonLogic.appcommonhandle("图标",null),
				vfilter: commonLogic.appcommonhandle("过滤项",null),
				disabled: commonLogic.appcommonhandle("是否禁用",null),
				expired: commonLogic.appcommonhandle("过期/失效",null),
				extension: commonLogic.appcommonhandle("扩展",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_cname_like: commonLogic.appcommonhandle("目录(文本包含(%))",null), 
				n_val_like: commonLogic.appcommonhandle("代码值(文本包含(%))",null), 
				n_label_like: commonLogic.appcommonhandle("名称(文本包含(%))",null), 
			},
			uiactions: {
			},
		},
		editviewtoolbar_toolbar: {
			tbitem1: {
				caption: commonLogic.appcommonhandle("Save And Close",null),
				tip: commonLogic.appcommonhandle("Save And Close Window",null),
			},
			tbitem2: {
				caption: commonLogic.appcommonhandle("关闭",null),
				tip: commonLogic.appcommonhandle("关闭",null),
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
			tbitem24: {
				caption: commonLogic.appcommonhandle("行编辑",null),
				tip: commonLogic.appcommonhandle("行编辑",null),
			},
			tbitem25: {
				caption: commonLogic.appcommonhandle("新建行",null),
				tip: commonLogic.appcommonhandle("新建行",null),
			},
			deuiaction1: {
				caption: commonLogic.appcommonhandle("保存行",null),
				tip: commonLogic.appcommonhandle("保存行",null),
			},
			tbitem26: {
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
			deuiaction2: {
				caption: commonLogic.appcommonhandle("Filter",null),
				tip: commonLogic.appcommonhandle("Filter",null),
			},
		},
		grideditviewtoolbar_toolbar: {
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
			tbitem24: {
				caption: commonLogic.appcommonhandle("行编辑",null),
				tip: commonLogic.appcommonhandle("行编辑",null),
			},
			tbitem25: {
				caption: commonLogic.appcommonhandle("新建行",null),
				tip: commonLogic.appcommonhandle("新建行",null),
			},
			deuiaction1: {
				caption: commonLogic.appcommonhandle("保存行",null),
				tip: commonLogic.appcommonhandle("保存行",null),
			},
			tbitem26: {
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
			deuiaction2: {
				caption: commonLogic.appcommonhandle("Filter",null),
				tip: commonLogic.appcommonhandle("Filter",null),
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;