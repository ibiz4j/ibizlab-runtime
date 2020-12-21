import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
	const data:any = {
	fields: {
		id: commonLogic.appcommonhandle("主键ID",null),
		name: commonLogic.appcommonhandle("名称",null),
		owner: commonLogic.appcommonhandle("持有者",null),
		create_time: commonLogic.appcommonhandle("创建时间",null),
	},
	};
	return data;
}

export default getLocaleResourceBase;