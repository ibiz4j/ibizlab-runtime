import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("标识",null),
		userid: commonLogic.appcommonhandle("用户标识",null),
		identity_type: commonLogic.appcommonhandle("认证类型",null),
		identifier: commonLogic.appcommonhandle("认证标识",null),
		credential: commonLogic.appcommonhandle("凭据",null),
		username: commonLogic.appcommonhandle("人员",null),
	},
	};
	return data;
}

export default getLocaleResourceBase;