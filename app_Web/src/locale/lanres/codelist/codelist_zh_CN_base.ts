import commonLogic from '@/locale/logic/common/common-logic';

function getLocaleResourceBase(){
  const data:any = {
      TemplateType: {
          "aliyun-sms": commonLogic.appcommonhandle("阿里云短信",null),
          "aliyun-email": commonLogic.appcommonhandle("阿里云邮件",null),
          "wechat-msg": commonLogic.appcommonhandle("微信消息",null),
          "dingtalk-msg": commonLogic.appcommonhandle("钉钉通知",null),
          "empty": commonLogic.appcommonhandle("",null),
      },
      DynamicModelStatus: {
          "0": commonLogic.appcommonhandle("未激活",null),
          "1": commonLogic.appcommonhandle("已激活",null),
          "empty": commonLogic.appcommonhandle("",null),
      },
      YesNo: {
          "1": commonLogic.appcommonhandle("是",null),
          "0": commonLogic.appcommonhandle("否",null),
          "empty": commonLogic.appcommonhandle("",null),
      },
      PayOpenAccessType: {
          "aliyun": commonLogic.appcommonhandle("阿里云",null),
          "wechat": commonLogic.appcommonhandle("微信开放平台",null),
          "qq": commonLogic.appcommonhandle("QQ互联",null),
          "dingtalk": commonLogic.appcommonhandle("钉钉开放平台",null),
          "empty": commonLogic.appcommonhandle("",null),
      },
      CLIBZSex: {
          "男": commonLogic.appcommonhandle("男性",null),
          "女": commonLogic.appcommonhandle("女性",null),
          "性别不详": commonLogic.appcommonhandle("性别不详",null),
          "empty": commonLogic.appcommonhandle("",null),
      },
      CodeListJobStatus: {
          "0": commonLogic.appcommonhandle("ENABLED",null),
          "1": commonLogic.appcommonhandle("DISABLED",null),
          "empty": commonLogic.appcommonhandle("",null),
      },
      CLAuthCode: {
          "200": commonLogic.appcommonhandle("成功",null),
          "400": commonLogic.appcommonhandle("用户不存在",null),
          "401.1": commonLogic.appcommonhandle("密码错误",null),
          "401.2": commonLogic.appcommonhandle("配置错误",null),
          "403.6": commonLogic.appcommonhandle("地址被拒绝",null),
          "empty": commonLogic.appcommonhandle("",null),
      },
      AppType: {
          "INNER": commonLogic.appcommonhandle("内置应用",null),
          "THIRD-PARTY": commonLogic.appcommonhandle("第三方应用",null),
          "empty": commonLogic.appcommonhandle("",null),
      },
      NotifyOpenAccessType: {
          "aliyun": commonLogic.appcommonhandle("阿里云",null),
          "wechat": commonLogic.appcommonhandle("微信开放平台",null),
          "qq": commonLogic.appcommonhandle("QQ互联",null),
          "dingtalk": commonLogic.appcommonhandle("钉钉开放平台",null),
          "empty": commonLogic.appcommonhandle("",null),
      },
      UaaOpenAccessType: {
          "aliyun": commonLogic.appcommonhandle("阿里云",null),
          "wechat": commonLogic.appcommonhandle("微信开放平台",null),
          "qq": commonLogic.appcommonhandle("QQ互联",null),
          "dingtalk": commonLogic.appcommonhandle("钉钉开放平台",null),
          "empty": commonLogic.appcommonhandle("",null),
      },
  };
  return data;
}
export default getLocaleResourceBase;