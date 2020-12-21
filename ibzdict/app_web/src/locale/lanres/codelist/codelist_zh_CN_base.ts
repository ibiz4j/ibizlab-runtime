import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
  const data:any = {
      YesNo: {
          "1": commonLogic.appcommonhandle("是",null),
          "0": commonLogic.appcommonhandle("否",null),
          "empty": commonLogic.appcommonhandle("",null),
      },
  };
  return data;
}
export default getLocaleResourceBase;