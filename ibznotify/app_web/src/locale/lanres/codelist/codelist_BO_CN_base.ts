import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
  const data:any = {
      TemplateType: {
          "aliyun-sms": commonLogic.appcommonhandle("阿里云短信",null),
          "aliyun-email": commonLogic.appcommonhandle("阿里云邮件",null),
          "wechat-msg": commonLogic.appcommonhandle("微信消息",null),
          "dingtalk-msg": commonLogic.appcommonhandle("钉钉通知",null),
          "empty": commonLogic.appcommonhandle("",null)
      },
      OpenAccessType: {
          "aliyun": commonLogic.appcommonhandle("阿里云",null),
          "wechat": commonLogic.appcommonhandle("微信开放平台",null),
          "qq": commonLogic.appcommonhandle("QQ互联",null),
          "dingtalk": commonLogic.appcommonhandle("钉钉开放平台",null),
          "empty": commonLogic.appcommonhandle("",null)
      },
  };
  return data;
}
export default getLocaleResourceBase;