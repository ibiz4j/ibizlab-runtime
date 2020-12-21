import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
  const data:any = {
      CLSYS_Sex: {
          "男": commonLogic.appcommonhandle("男性",null),
          "女": commonLogic.appcommonhandle("女性",null),
          "性别不详": commonLogic.appcommonhandle("性别不详",null),
          "empty": commonLogic.appcommonhandle("",null),
      },
  };
  return data;
}
export default getLocaleResourceBase;