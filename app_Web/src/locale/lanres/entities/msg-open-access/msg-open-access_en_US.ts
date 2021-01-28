import MsgOpenAccess_en_US_Base from './msg-open-access_en_US_base';

function getLocaleResource(){
    const MsgOpenAccess_en_US_OwnData = {};
    const targetData = Object.assign(MsgOpenAccess_en_US_Base(), MsgOpenAccess_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;