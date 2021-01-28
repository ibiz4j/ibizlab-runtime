import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
  const data:any = {
      OpenAccessType: {
          "aliyun": commonLogic.appcommonhandle("阿里云",null),
          "wechat": commonLogic.appcommonhandle("微信开放平台",null),
          "qq": commonLogic.appcommonhandle("QQ互联",null),
          "dingtalk": commonLogic.appcommonhandle("钉钉开放平台",null),
          "empty": commonLogic.appcommonhandle("",null)
      },
      YesNo: {
          "1": commonLogic.appcommonhandle("是",null),
          "0": commonLogic.appcommonhandle("否",null),
          "empty": commonLogic.appcommonhandle("",null)
      },
  };
  return data;
}
export default getLocaleResourceBase;