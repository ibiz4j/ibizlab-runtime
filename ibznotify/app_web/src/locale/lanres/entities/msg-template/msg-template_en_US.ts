import MsgTemplate_en_US_Base from './msg-template_en_US_base';

function getLocaleResource(){
    const MsgTemplate_en_US_OwnData = {};
    const targetData = Object.assign(MsgTemplate_en_US_Base(), MsgTemplate_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;