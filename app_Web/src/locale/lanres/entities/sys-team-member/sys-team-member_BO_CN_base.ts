import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		teammemberid: commonLogic.appcommonhandle("组成员标识",null),
		teamid: commonLogic.appcommonhandle("组标识",null),
		teamname: commonLogic.appcommonhandle("组名称",null),
		userid: commonLogic.appcommonhandle("用户标识",null),
		personname: commonLogic.appcommonhandle("姓名",null),
		postid: commonLogic.appcommonhandle("岗位标识",null),
		postname: commonLogic.appcommonhandle("岗位",null),
		domains: commonLogic.appcommonhandle("区属",null),
		username: commonLogic.appcommonhandle("登录名",null),
	},
		views: {
			gridview: {
				caption: commonLogic.appcommonhandle("组管理",null),
				title: commonLogic.appcommonhandle("组管理",null),
			},
			editview: {
				caption: commonLogic.appcommonhandle("组成员",null),
				title: commonLogic.appcommonhandle("组成员编辑视图",null),
			},
		},
		main_form: {
			details: {
				group1: commonLogic.appcommonhandle("组成员基本信息",null), 
				formpage1: commonLogic.appcommonhandle("基本信息",null), 
				srforikey: commonLogic.appcommonhandle("",null), 
				srfkey: commonLogic.appcommonhandle("组成员标识",null), 
				srfmajortext: commonLogic.appcommonhandle("姓名",null), 
				srftempmode: commonLogic.appcommonhandle("",null), 
				srfuf: commonLogic.appcommonhandle("",null), 
				srfdeid: commonLogic.appcommonhandle("",null), 
				srfsourcekey: commonLogic.appcommonhandle("",null), 
				personname: commonLogic.appcommonhandle("姓名",null), 
				postname: commonLogic.appcommonhandle("岗位",null), 
				domains: commonLogic.appcommonhandle("区属",null), 
				teamid: commonLogic.appcommonhandle("组标识",null), 
				postid: commonLogic.appcommonhandle("岗位标识",null), 
				userid: commonLogic.appcommonhandle("用户标识",null), 
				teammemberid: commonLogic.appcommonhandle("组成员标识",null), 
			},
			uiactions: {
			},
		},
		main_grid: {
			columns: {
				personname: commonLogic.appcommonhandle("姓名",null),
				username: commonLogic.appcommonhandle("登录名",null),
				postname: commonLogic.appcommonhandle("岗位",null),
				userid: commonLogic.appcommonhandle("用户标识",null),
				postid: commonLogic.appcommonhandle("岗位标识",null),
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
	};
	return data;
}
export default getLocaleResourceBase;