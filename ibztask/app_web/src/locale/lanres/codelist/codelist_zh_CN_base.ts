import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
  const data:any = {
      CodeListJobStatus: {
          "0": commonLogic.appcommonhandle("ENABLED",null),
          "1": commonLogic.appcommonhandle("DISABLED",null),
          "empty": commonLogic.appcommonhandle("",null),
      },
  };
  return data;
}
export default getLocaleResourceBase;