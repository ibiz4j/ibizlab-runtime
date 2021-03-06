import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("应用标识",null),
		label: commonLogic.appcommonhandle("应用名",null),
		systemid: commonLogic.appcommonhandle("系统标识",null),
		fullname: commonLogic.appcommonhandle("全称",null),
		type: commonLogic.appcommonhandle("类型",null),
		group: commonLogic.appcommonhandle("分组",null),
		icon: commonLogic.appcommonhandle("图标",null),
		visabled: commonLogic.appcommonhandle("可见",null),
		addr: commonLogic.appcommonhandle("地址",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("接入应用",null),
				title: commonLogic.appcommonhandle("接入应用",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("接入应用",null),
				title: commonLogic.appcommonhandle("接入应用",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("应用基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("应用标识",null), 
				srfmajortext: commonLogic.appcommonhandle("应用名",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				pssystemid: commonLogic.appcommonhandle("系统标识",null), 
				appid: commonLogic.appcommonhandle("应用标识",null), 
				appname: commonLogic.appcommonhandle("应用名",null), 
				apptype: commonLogic.appcommonhandle("类型",null), 
				appgroup: commonLogic.appcommonhandle("分组",null), 
				fullname: commonLogic.appcommonhandle("全称",null), 
				icon: commonLogic.appcommonhandle("图标",null), 
				visabled: commonLogic.appcommonhandle("可见",null), 
				addr: commonLogic.appcommonhandle("地址",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				pssystemid: commonLogic.appcommonhandle("系统标识",null),
				appid: commonLogic.appcommonhandle("应用标识",null),
				appname: commonLogic.appcommonhandle("应用名",null),
				appgroup: commonLogic.appcommonhandle("分组",null),
				apptype: commonLogic.appcommonhandle("类型",null),
				fullname: commonLogic.appcommonhandle("全称",null),
				icon: commonLogic.appcommonhandle("图标",null),
				addr: commonLogic.appcommonhandle("地址",null),
				visabled: commonLogic.appcommonhandle("可见",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_pssystemid_eq: commonLogic.appcommonhandle("系统标识(等于(=))",null), 
				n_appname_like: commonLogic.appcommonhandle("应用名(文本包含(%))",null), 
			},
			uiactions: {
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
			tbitem19: {
				caption: commonLogic.appcommonhandle("Filter",null),
				tip: commonLogic.appcommonhandle("Filter",null),
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("Save",null),
				tip: commonLogic.appcommonhandle("Save",null),
			},
			tbitem5: {
				caption: commonLogic.appcommonhandle("Save And Close",null),
				tip: commonLogic.appcommonhandle("Save And Close Window",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem12: {
				caption: commonLogic.appcommonhandle("New",null),
				tip: commonLogic.appcommonhandle("New",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem14: {
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;