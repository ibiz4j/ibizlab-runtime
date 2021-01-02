import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		orgid: commonLogic.appcommonhandle("单位标识",null),
		orgcode: commonLogic.appcommonhandle("单位代码",null),
		orgname: commonLogic.appcommonhandle("名称",null),
		parentorgid: commonLogic.appcommonhandle("上级单位",null),
		shortname: commonLogic.appcommonhandle("单位简称",null),
		orglevel: commonLogic.appcommonhandle("单位级别",null),
		showorder: commonLogic.appcommonhandle("排序",null),
		parentorgname: commonLogic.appcommonhandle("上级单位",null),
		domains: commonLogic.appcommonhandle("区属",null),
		enable: commonLogic.appcommonhandle("逻辑有效",null),
		createdate: commonLogic.appcommonhandle("创建时间",null),
		updatedate: commonLogic.appcommonhandle("最后修改时间",null),
		isvalid: commonLogic.appcommonhandle("启用标志",null),
	},
		views: {
			pickupgridview: {
				caption: commonLogic.appcommonhandle("单位机构",null),
				title: commonLogic.appcommonhandle("单位机构选择表格视图",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("单位管理",null),
				title: commonLogic.appcommonhandle("单位管理",null),
			},
			treeexpview: {
				caption: commonLogic.appcommonhandle("部门管理",null),
				title: commonLogic.appcommonhandle("部门管理",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("单位管理",null),
				title: commonLogic.appcommonhandle("单位管理",null),
			},
			pickupview: {
				caption: commonLogic.appcommonhandle("单位机构",null),
				title: commonLogic.appcommonhandle("单位机构数据选择视图",null),
			},
			optionview: {
				caption: commonLogic.appcommonhandle("单位快速新建",null),
				title: commonLogic.appcommonhandle("单位快速新建",null),
			},
		},
		main_form: {
			details: {
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("最后修改时间",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("单位标识",null), 
				srfmajortext: commonLogic.appcommonhandle("名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				orgid: commonLogic.appcommonhandle("单位标识",null), 
				orgcode: commonLogic.appcommonhandle("单位代码",null), 
				orgname: commonLogic.appcommonhandle("名称",null), 
				porgname: commonLogic.appcommonhandle("上级单位",null), 
				orglevel: commonLogic.appcommonhandle("单位级别",null), 
				shortname: commonLogic.appcommonhandle("单位简称",null), 
				showorder: commonLogic.appcommonhandle("排序",null), 
				isvalid: commonLogic.appcommonhandle("启用",null), 
				porgid: commonLogic.appcommonhandle("上级单位",null), 
				createdate: commonLogic.appcommonhandle("创建时间",null), 
				updatedate: commonLogic.appcommonhandle("最后修改时间",null), 
			},
			uiactions: {
			},
		},
		newform_form: {
			details: {
				group1: commonLogic.appcommonhandle("单位机构基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("最后修改时间",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("单位标识",null), 
				srfmajortext: commonLogic.appcommonhandle("名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				orgcode: commonLogic.appcommonhandle("单位代码",null), 
				orgname: commonLogic.appcommonhandle("名称",null), 
				porgname: commonLogic.appcommonhandle("上级单位",null), 
				porgid: commonLogic.appcommonhandle("上级单位",null), 
				enable: commonLogic.appcommonhandle("逻辑有效",null), 
				orgid: commonLogic.appcommonhandle("单位标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				orgid: commonLogic.appcommonhandle("单位标识",null),
				orgcode: commonLogic.appcommonhandle("单位代码",null),
				orgname: commonLogic.appcommonhandle("名称",null),
				orglevel: commonLogic.appcommonhandle("单位级别",null),
				shortname: commonLogic.appcommonhandle("单位简称",null),
				porgname: commonLogic.appcommonhandle("上级单位",null),
				porgid: commonLogic.appcommonhandle("上级单位",null),
				showorder: commonLogic.appcommonhandle("排序",null),
				createdate: commonLogic.appcommonhandle("创建时间",null),
				updatedate: commonLogic.appcommonhandle("最后修改时间",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				orgcode: commonLogic.appcommonhandle("单位代码(文本左包含(%#))",null), 
				n_orgname_like: commonLogic.appcommonhandle("名称(%)",null), 
				n_porgid_eq: commonLogic.appcommonhandle("上级单位(=)",null), 
				porgname: commonLogic.appcommonhandle("上级单位(等于(=))",null), 
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
			tbitem1_opennewcreateview: {
				caption: commonLogic.appcommonhandle("快速新建",null),
				tip: commonLogic.appcommonhandle("快速新建",null),
			},
			tbitem2: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
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
		orgtree_treeview: {
			nodata:commonLogic.appcommonhandle("",null),
			nodes: {
				root: commonLogic.appcommonhandle("默认根节点",null),
			},
			uiactions: {
			},
		},
	};
	return data;
}

export default getLocaleResourceBase;