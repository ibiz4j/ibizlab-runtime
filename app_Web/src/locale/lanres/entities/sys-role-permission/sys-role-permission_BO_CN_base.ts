import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		rolepermissionid: commonLogic.appcommonhandle("角色权限关系表标识",null),
		roleid: commonLogic.appcommonhandle("角色表标识",null),
		rolename: commonLogic.appcommonhandle("角色名称",null),
		permissionid: commonLogic.appcommonhandle("权限表标识",null),
		permissionname: commonLogic.appcommonhandle("权限名称",null),
		permissiontype: commonLogic.appcommonhandle("权限类型",null),
		permissionenable: commonLogic.appcommonhandle("权限类型",null),
		createdate: commonLogic.appcommonhandle("建立时间",null),
		updatedate: commonLogic.appcommonhandle("更新时间",null),
	},
		views: {
			customview: {
				caption: commonLogic.appcommonhandle("角色权限关系",null),
				title: commonLogic.appcommonhandle("角色权限关系自定义视图",null),
			},
		},
	};
	return data;
}
export default getLocaleResourceBase;