import MsgTemplate_BO_CN_Base from './msg-template_BO_CN_base';

function getLocaleResource(){
    const MsgTemplate_BO_CN_OwnData = {};
    const targetData = Object.assign(MsgTemplate_BO_CN_Base(), MsgTemplate_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;