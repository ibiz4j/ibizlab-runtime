import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("标识",null),
		name: commonLogic.appcommonhandle("名称",null),
		file_path: commonLogic.appcommonhandle("路径",null),
		folder: commonLogic.appcommonhandle("特定目录",null),
		file_size: commonLogic.appcommonhandle("文件大小",null),
		extension: commonLogic.appcommonhandle("扩展名",null),
		owner_type: commonLogic.appcommonhandle("所属类型",null),
		owner_id: commonLogic.appcommonhandle("所属主体",null),
		memo: commonLogic.appcommonhandle("备注",null),
		digest_code: commonLogic.appcommonhandle("签名",null),
		createman: commonLogic.appcommonhandle("创建人",null),
		createdate: commonLogic.appcommonhandle("创建日期",null),
		updateman: commonLogic.appcommonhandle("更新人",null),
		updatedate: commonLogic.appcommonhandle("更新时间",null),
	},
		views: {
			editview: {
				caption: commonLogic.appcommonhandle("文件",null),
				title: commonLogic.appcommonhandle("文件编辑视图",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("文件",null),
				title: commonLogic.appcommonhandle("文件表格视图",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("文件基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("更新时间",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("标识",null), 
				srfmajortext: commonLogic.appcommonhandle("名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				filename: commonLogic.appcommonhandle("名称",null), 
				filepath: commonLogic.appcommonhandle("路径",null), 
				filesize: commonLogic.appcommonhandle("文件大小",null), 
				fileext: commonLogic.appcommonhandle("扩展名",null), 
				folder: commonLogic.appcommonhandle("特定目录",null), 
				digestcode: commonLogic.appcommonhandle("签名",null), 
				ownerid: commonLogic.appcommonhandle("所属主体",null), 
				ownertype: commonLogic.appcommonhandle("所属类型",null), 
				memo: commonLogic.appcommonhandle("备注",null), 
				createman: commonLogic.appcommonhandle("创建人",null), 
				createdate: commonLogic.appcommonhandle("创建日期",null), 
				updateman: commonLogic.appcommonhandle("更新人",null), 
				updatedate: commonLogic.appcommonhandle("更新时间",null), 
				fileid: commonLogic.appcommonhandle("标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				fileid: commonLogic.appcommonhandle("标识",null),
				filename: commonLogic.appcommonhandle("名称",null),
				filepath: commonLogic.appcommonhandle("路径",null),
				filesize: commonLogic.appcommonhandle("文件大小",null),
				fileext: commonLogic.appcommonhandle("扩展名",null),
				folder: commonLogic.appcommonhandle("特定目录",null),
				ownertype: commonLogic.appcommonhandle("所属类型",null),
				ownerid: commonLogic.appcommonhandle("所属主体",null),
				createdate: commonLogic.appcommonhandle("创建日期",null),
				updatedate: commonLogic.appcommonhandle("更新时间",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_filename_like: commonLogic.appcommonhandle("名称(文本包含(%))",null), 
			},
			uiactions: {
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
			tbitem18: {
				caption: commonLogic.appcommonhandle("Help",null),
				tip: commonLogic.appcommonhandle("Help",null),
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;