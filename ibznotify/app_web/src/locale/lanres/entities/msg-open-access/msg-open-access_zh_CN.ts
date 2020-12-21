import MsgOpenAccess_zh_CN_Base from './msg-open-access_zh_CN_base';

function getLocaleResource(){
    const MsgOpenAccess_zh_CN_OwnData = {};
    const targetData = Object.assign(MsgOpenAccess_zh_CN_Base(), MsgOpenAccess_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;