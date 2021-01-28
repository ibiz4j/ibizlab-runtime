import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		deptid: commonLogic.appcommonhandle("部门标识",null),
		deptcode: commonLogic.appcommonhandle("部门代码",null),
		deptname: commonLogic.appcommonhandle("部门名称",null),
		orgid: commonLogic.appcommonhandle("单位",null),
		parentdeptid: commonLogic.appcommonhandle("上级部门",null),
		shortname: commonLogic.appcommonhandle("部门简称",null),
		deptlevel: commonLogic.appcommonhandle("部门级别",null),
		domains: commonLogic.appcommonhandle("区属",null),
		showorder: commonLogic.appcommonhandle("排序",null),
		bcode: commonLogic.appcommonhandle("业务编码",null),
		leaderid: commonLogic.appcommonhandle("分管领导标识",null),
		leadername: commonLogic.appcommonhandle("分管领导",null),
		enable: commonLogic.appcommonhandle("逻辑有效",null),
		orgname: commonLogic.appcommonhandle("单位",null),
		parentdeptname: commonLogic.appcommonhandle("上级部门",null),
		createdate: commonLogic.appcommonhandle("创建时间",null),
		updatedate: commonLogic.appcommonhandle("最后修改时间",null),
		isvalid: commonLogic.appcommonhandle("启用标识",null),
	},
		views: {
			pickupgridview: {
				caption: commonLogic.appcommonhandle("部门",null),
				title: commonLogic.appcommonhandle("部门选择表格视图",null),
			},
			treeexpview: {
				caption: commonLogic.appcommonhandle("人员管理",null),
				title: commonLogic.appcommonhandle("人员管理",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("部门管理",null),
				title: commonLogic.appcommonhandle("部门管理",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("部门",null),
				title: commonLogic.appcommonhandle("部门表格视图",null),
			},
			optionview: {
				caption: commonLogic.appcommonhandle("部门",null),
				title: commonLogic.appcommonhandle("部门选项操作视图",null),
			},
			pickupview: {
				caption: commonLogic.appcommonhandle("部门",null),
				title: commonLogic.appcommonhandle("部门选择视图",null),
			},
			mpickupview: {
				caption: commonLogic.appcommonhandle("部门",null),
				title: commonLogic.appcommonhandle("部门数据多项选择视图",null),
			},
		},
		main_form: {
			details: {
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("最后修改时间",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("部门标识",null), 
				srfmajortext: commonLogic.appcommonhandle("部门名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				deptid: commonLogic.appcommonhandle("部门标识",null), 
				deptcode: commonLogic.appcommonhandle("部门代码",null), 
				deptname: commonLogic.appcommonhandle("部门名称",null), 
				orgname: commonLogic.appcommonhandle("单位",null), 
				pdeptname: commonLogic.appcommonhandle("上级部门",null), 
				orgid: commonLogic.appcommonhandle("单位",null), 
				pdeptid: commonLogic.appcommonhandle("上级部门",null), 
				shortname: commonLogic.appcommonhandle("部门简称",null), 
				bcode: commonLogic.appcommonhandle("业务编码",null), 
				deptlevel: commonLogic.appcommonhandle("部门级别",null), 
				leaderid: commonLogic.appcommonhandle("分管领导标识",null), 
				leadername: commonLogic.appcommonhandle("分管领导",null), 
				showorder: commonLogic.appcommonhandle("排序",null), 
				isvalid: commonLogic.appcommonhandle("启用",null), 
				createdate: commonLogic.appcommonhandle("创建时间",null), 
				updatedate: commonLogic.appcommonhandle("最后修改时间",null), 
			},
			uiactions: {
			},
		},
		newform_form: {
			details: {
				group1: commonLogic.appcommonhandle("部门基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srfupdatedate: commonLogic.appcommonhandle("最后修改时间",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("部门标识",null), 
				srfmajortext: commonLogic.appcommonhandle("部门名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				deptcode: commonLogic.appcommonhandle("部门代码",null), 
				deptname: commonLogic.appcommonhandle("部门名称",null), 
				orgid: commonLogic.appcommonhandle("单位",null), 
				orgname: commonLogic.appcommonhandle("单位",null), 
				pdeptid: commonLogic.appcommonhandle("上级部门",null), 
				pdeptname: commonLogic.appcommonhandle("上级部门",null), 
				enable: commonLogic.appcommonhandle("逻辑有效",null), 
				deptid: commonLogic.appcommonhandle("部门标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				deptcode: commonLogic.appcommonhandle("部门代码",null),
				deptname: commonLogic.appcommonhandle("部门名称",null),
				orgname: commonLogic.appcommonhandle("单位",null),
				pdeptname: commonLogic.appcommonhandle("上级部门",null),
				deptlevel: commonLogic.appcommonhandle("部门级别",null),
				shortname: commonLogic.appcommonhandle("部门简称",null),
				bcode: commonLogic.appcommonhandle("业务编码",null),
				leadername: commonLogic.appcommonhandle("分管领导",null),
				isvalid: commonLogic.appcommonhandle("启用",null),
				showorder: commonLogic.appcommonhandle("排序",null),
				createdate: commonLogic.appcommonhandle("创建时间",null),
				updatedate: commonLogic.appcommonhandle("最后修改时间",null),
				orgid: commonLogic.appcommonhandle("单位",null),
				pdeptid: commonLogic.appcommonhandle("上级部门",null),
				leaderid: commonLogic.appcommonhandle("分管领导标识",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_deptcode_like: commonLogic.appcommonhandle("部门代码(%)",null), 
				n_deptname_like: commonLogic.appcommonhandle("部门名称(%)",null), 
				n_orgid_eq: commonLogic.appcommonhandle("单位(=)",null), 
				n_pdeptid_eq: commonLogic.appcommonhandle("上级部门(=)",null), 
				n_bcode_like: commonLogic.appcommonhandle("业务编码(%)",null), 
			},
			uiactions: {
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("保存",null),
				tip: commonLogic.appcommonhandle("保存",null),
			},
			deuiaction1: {
				caption: commonLogic.appcommonhandle("保存并关闭",null),
				tip: commonLogic.appcommonhandle("保存并关闭",null),
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
				caption: commonLogic.appcommonhandle("拷贝",null),
				tip: commonLogic.appcommonhandle("拷贝",null),
			},
		},
		gridviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("新建",null),
				tip: commonLogic.appcommonhandle("新建",null),
			},
			tbitem4: {
				caption: commonLogic.appcommonhandle("编辑",null),
				tip: commonLogic.appcommonhandle("编辑",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("拷贝",null),
				tip: commonLogic.appcommonhandle("拷贝",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem8: {
				caption: commonLogic.appcommonhandle("删除",null),
				tip: commonLogic.appcommonhandle("删除",null),
			},
			tbitem9: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("导出",null),
				tip: commonLogic.appcommonhandle("导出",null),
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
				caption: commonLogic.appcommonhandle("导出数据模型",null),
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
				caption: commonLogic.appcommonhandle("过滤",null),
				tip: commonLogic.appcommonhandle("过滤",null),
			},
		},
		depttree_treeview: {
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