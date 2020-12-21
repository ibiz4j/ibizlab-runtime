import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("用户标识",null),
		firstname: commonLogic.appcommonhandle("用户全局名",null),
		displayname: commonLogic.appcommonhandle("用户名称",null),
		mdeptid: commonLogic.appcommonhandle("主部门",null),
		mdeptcode: commonLogic.appcommonhandle("主部门代码",null),
		mdeptname: commonLogic.appcommonhandle("主部门名称",null),
		bcode: commonLogic.appcommonhandle("业务编码",null),
		orgid: commonLogic.appcommonhandle("单位",null),
		orgcode: commonLogic.appcommonhandle("单位代码",null),
		orgname: commonLogic.appcommonhandle("单位名称",null),
	},
		views: {
			pickupview: {
				caption: commonLogic.appcommonhandle("用户",null),
				title: commonLogic.appcommonhandle("用户数据选择视图",null),
			},
			mpickupview: {
				caption: commonLogic.appcommonhandle("用户",null),
				title: commonLogic.appcommonhandle("用户数据多项选择视图",null),
			},
			pickupgridview: {
				caption: commonLogic.appcommonhandle("用户",null),
				title: commonLogic.appcommonhandle("用户选择表格视图",null),
			},
			gridview: {
				caption: commonLogic.appcommonhandle("用户",null),
				title: commonLogic.appcommonhandle("用户表格视图",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("用户",null),
				title: commonLogic.appcommonhandle("用户编辑视图",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("用户基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("用户标识",null), 
				srfmajortext: commonLogic.appcommonhandle("用户名称",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				personname: commonLogic.appcommonhandle("用户名称",null), 
				username: commonLogic.appcommonhandle("用户全局名",null), 
				userid: commonLogic.appcommonhandle("用户标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				userid: commonLogic.appcommonhandle("用户标识",null),
				personname: commonLogic.appcommonhandle("用户名称",null),
				username: commonLogic.appcommonhandle("用户全局名",null),
				orgname: commonLogic.appcommonhandle("单位名称",null),
				mdeptname: commonLogic.appcommonhandle("主部门名称",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		default_searchform: {
			details: {
				formpage1: commonLogic.appcommonhandle("常规条件",null), 
				n_personname_like: commonLogic.appcommonhandle("用户名称(文本包含(%))",null), 
			},
			uiactions: {
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
			tbitem18: {
				caption: commonLogic.appcommonhandle("帮助",null),
				tip: commonLogic.appcommonhandle("帮助",null),
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("保存",null),
				tip: commonLogic.appcommonhandle("保存",null),
			},
			tbitem4: {
				caption: commonLogic.appcommonhandle("保存并新建",null),
				tip: commonLogic.appcommonhandle("保存并新建",null),
			},
			tbitem5: {
				caption: commonLogic.appcommonhandle("保存并关闭",null),
				tip: commonLogic.appcommonhandle("保存并关闭",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("删除并关闭",null),
				tip: commonLogic.appcommonhandle("删除并关闭",null),
			},
			tbitem8: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem12: {
				caption: commonLogic.appcommonhandle("新建",null),
				tip: commonLogic.appcommonhandle("新建",null),
			},
			tbitem13: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem14: {
				caption: commonLogic.appcommonhandle("拷贝",null),
				tip: commonLogic.appcommonhandle("拷贝",null),
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
				caption: commonLogic.appcommonhandle("帮助",null),
				tip: commonLogic.appcommonhandle("帮助",null),
			},
		},
	};
	return data;
}
export default getLocaleResourceBase;