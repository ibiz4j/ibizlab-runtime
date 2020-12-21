import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		pssystemid: commonLogic.appcommonhandle("系统标识",null),
		pssystemname: commonLogic.appcommonhandle("系统名称",null),
	},
	};
	return data;
}

export default getLocaleResourceBase;