import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		teamid: commonLogic.appcommonhandle("组标识",null),
		teamname: commonLogic.appcommonhandle("组名称",null),
		memo: commonLogic.appcommonhandle("备注",null),
		domains: commonLogic.appcommonhandle("区属",null),
	},
		views: {
			editview: {
				caption: commonLogic.appcommonhandle("组管理",null),
				title: commonLogic.appcommonhandle("组管理",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("组管理",null),
				title: commonLogic.appcommonhandle("组管理",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("组基本信息",null), 
				druipart1: commonLogic.appcommonhandle("",null), 
				grouppanel1: commonLogic.appcommonhandle("组成员",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("组标识",null), 
				srfmajortext: commonLogic.appcommonhandle("组名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				teamname: commonLogic.appcommonhandle("组名称",null), 
				memo: commonLogic.appcommonhandle("备注",null), 
				domains: commonLogic.appcommonhandle("区属",null), 
				teamid: commonLogic.appcommonhandle("组标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				teamname: commonLogic.appcommonhandle("组名称",null),
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