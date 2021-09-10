import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("标识",null),
		code: commonLogic.appcommonhandle("代码",null),
		name: commonLogic.appcommonhandle("名称",null),
		group: commonLogic.appcommonhandle("分组",null),
		memo: commonLogic.appcommonhandle("备注",null),
		enable: commonLogic.appcommonhandle("是否有效",null),
		updatedate: commonLogic.appcommonhandle("最后修改时间",null),
		createdate: commonLogic.appcommonhandle("创建时间",null),
		ext_params: commonLogic.appcommonhandle("扩展参数",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("字典",null),
				title: commonLogic.appcommonhandle("字典表格视图",null),
			},
			pickupgridview: {
				caption: commonLogic.appcommonhandle("字典",null),
				title: commonLogic.appcommonhandle("字典选择表格视图",null),
			},
			pickupview: {
				caption: commonLogic.appcommonhandle("字典",null),
				title: commonLogic.appcommonhandle("字典数据选择视图",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("字典",null),
				title: commonLogic.appcommonhandle("字典编辑视图",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("字典基本信息",null), 
				druipart1: commonLogic.appcommonhandle("字典项",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("最后修改时间",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("标识",null), 
				srfmajortext: commonLogic.appcommonhandle("名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				ccode: commonLogic.appcommonhandle("代码",null), 
				cname: commonLogic.appcommonhandle("名称",null), 
				cgroup: commonLogic.appcommonhandle("分组",null), 
				memo: commonLogic.appcommonhandle("备注",null), 
				cid: commonLogic.appcommonhandle("标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				ccode: commonLogic.appcommonhandle("代码",null),
				cname: commonLogic.appcommonhandle("名称",null),
				cgroup: commonLogic.appcommonhandle("分组",null),
				memo: commonLogic.appcommonhandle("备注",null),
				updatedate: commonLogic.appcommonhandle("最后修改时间",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_ccode_like: commonLogic.appcommonhandle("代码",null), 
				n_cname_like: commonLogic.appcommonhandle("名称",null), 
				n_cgroup_like: commonLogic.appcommonhandle("分组",null), 
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
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("Save",null),
				tip: commonLogic.appcommonhandle("Save",null),
			},
			tbitem4: {
				caption: commonLogic.appcommonhandle("Save And New",null),
				tip: commonLogic.appcommonhandle("Save And New",null),
			},
			tbitem5: {
				caption: commonLogic.appcommonhandle("Save And Close",null),
				tip: commonLogic.appcommonhandle("Save And Close Window",null),
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
			tbitem16: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem23: {
				caption: commonLogic.appcommonhandle("第一个记录",null),
				tip: commonLogic.appcommonhandle("第一个记录",null),
			},
			tbitem24: {
				caption: commonLogic.appcommonhandle("上一个记录",null),
				tip: commonLogic.appcommonhandle("上一个记录",null),
			},
			tbitem25: {
				caption: commonLogic.appcommonhandle("下一个记录",null),
				tip: commonLogic.appcommonhandle("下一个记录",null),
			},
			tbitem26: {
				caption: commonLogic.appcommonhandle("最后一个记录",null),
				tip: commonLogic.appcommonhandle("最后一个记录",null),
			},
			tbitem21: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem22: {
				caption: commonLogic.appcommonhandle("Help",null),
				tip: commonLogic.appcommonhandle("Help",null),
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;