import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
  const data:any = {
      SysOperator: {
          "empty": commonLogic.appcommonhandle("",null),
      },
  };
  return data;
}
export default getLocaleResourceBase;