import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		postid: commonLogic.appcommonhandle("岗位标识",null),
		postcode: commonLogic.appcommonhandle("岗位编码",null),
		postname: commonLogic.appcommonhandle("岗位名称",null),
		domains: commonLogic.appcommonhandle("区属",null),
		memo: commonLogic.appcommonhandle("备注",null),
	},
		views: {
			pickupview: {
				caption: commonLogic.appcommonhandle("岗位",null),
				title: commonLogic.appcommonhandle("岗位数据选择视图",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("岗位管理",null),
				title: commonLogic.appcommonhandle("岗位管理",null),
			},
			pickupgridview: {
				caption: commonLogic.appcommonhandle("岗位",null),
				title: commonLogic.appcommonhandle("岗位选择表格视图",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("岗位管理",null),
				title: commonLogic.appcommonhandle("岗位管理",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("岗位基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("岗位标识",null), 
				srfmajortext: commonLogic.appcommonhandle("岗位名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				postcode: commonLogic.appcommonhandle("岗位编码",null), 
				postname: commonLogic.appcommonhandle("岗位名称",null), 
				domains: commonLogic.appcommonhandle("区属",null), 
				memo: commonLogic.appcommonhandle("备注",null), 
				postid: commonLogic.appcommonhandle("岗位标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				postcode: commonLogic.appcommonhandle("岗位编码",null),
				postname: commonLogic.appcommonhandle("岗位名称",null),
				memo: commonLogic.appcommonhandle("备注",null),
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
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("Remove And Close",null),
				tip: commonLogic.appcommonhandle("Remove And Close Window",null),
			},
			tbitem8: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem14: {
				caption: commonLogic.appcommonhandle("Copy",null),
				tip: commonLogic.appcommonhandle("Copy {0}",null),
			},
		},
		gridviewtoolbar_toolbar: {
			deuiaction1: {
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
			tbitem19: {
				caption: commonLogic.appcommonhandle("Filter",null),
				tip: commonLogic.appcommonhandle("Filter",null),
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;