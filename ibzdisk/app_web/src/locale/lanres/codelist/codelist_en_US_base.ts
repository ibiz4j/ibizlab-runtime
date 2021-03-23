import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
  const data:any = {
      DynamicModelStatus: {
          "0": commonLogic.appcommonhandle("未激活",null),
          "1": commonLogic.appcommonhandle("已激活",null),
          "empty": commonLogic.appcommonhandle("",null)
      },
      SysOperator: {
          "empty": commonLogic.appcommonhandle("",null),
      },
  };
  return data;
}
export default getLocaleResourceBase;