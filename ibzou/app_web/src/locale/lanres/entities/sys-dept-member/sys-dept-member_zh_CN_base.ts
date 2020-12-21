import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		memberid: commonLogic.appcommonhandle("标识",null),
		deptid: commonLogic.appcommonhandle("部门标识",null),
		deptname: commonLogic.appcommonhandle("部门名称",null),
		userid: commonLogic.appcommonhandle("用户标识",null),
		personname: commonLogic.appcommonhandle("成员",null),
		postid: commonLogic.appcommonhandle("岗位标识",null),
		postname: commonLogic.appcommonhandle("岗位名称",null),
		bcode: commonLogic.appcommonhandle("业务条线",null),
		domains: commonLogic.appcommonhandle("区属",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("部门成员",null),
				title: commonLogic.appcommonhandle("部门成员表格视图",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("部门成员",null),
				title: commonLogic.appcommonhandle("部门成员编辑视图",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("部门成员基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("标识",null), 
				srfmajortext: commonLogic.appcommonhandle("成员",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				deptname: commonLogic.appcommonhandle("部门名称",null), 
				deptid: commonLogic.appcommonhandle("部门标识",null), 
				personname: commonLogic.appcommonhandle("成员",null), 
				userid: commonLogic.appcommonhandle("用户标识",null), 
				memberid: commonLogic.appcommonhandle("标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				deptname: commonLogic.appcommonhandle("部门",null),
				postname: commonLogic.appcommonhandle("岗位名称",null),
				personname: commonLogic.appcommonhandle("成员",null),
				deptid: commonLogic.appcommonhandle("部门标识",null),
				postid: commonLogic.appcommonhandle("岗位标识",null),
				userid: commonLogic.appcommonhandle("用户标识",null),
			},
			nodata:commonLogic.appcommonhandle("",null),
			uiactions: {
			},
		},
		gridviewtoolbar_toolbar: {
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
				caption: commonLogic.appcommonhandle("删除",null),
				tip: commonLogic.appcommonhandle("删除",null),
			},
		},
		editviewtoolbar_toolbar: {
			tbitem3: {
				caption: commonLogic.appcommonhandle("保存",null),
				tip: commonLogic.appcommonhandle("保存",null),
			},
			tbitem6: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem7: {
				caption: commonLogic.appcommonhandle("删除",null),
				tip: commonLogic.appcommonhandle("删除",null),
			},
			tbitem8: {
				caption: commonLogic.appcommonhandle("-",null),
				tip: commonLogic.appcommonhandle("",null),
			},
			tbitem14: {
				caption: commonLogic.appcommonhandle("拷贝",null),
				tip: commonLogic.appcommonhandle("拷贝",null),
			},
		},
	};
	return data;
}
export default getLocaleResourceBase;