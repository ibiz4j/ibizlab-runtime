import MsgOpenAccess_BO_CN_Base from './msg-open-access_BO_CN_base';

function getLocaleResource(){
    const MsgOpenAccess_BO_CN_OwnData = {};
    const targetData = Object.assign(MsgOpenAccess_BO_CN_Base(), MsgOpenAccess_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;