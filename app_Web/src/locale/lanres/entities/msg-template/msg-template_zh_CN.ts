import MsgTemplate_zh_CN_Base from './msg-template_zh_CN_base';

function getLocaleResource(){
    const MsgTemplate_zh_CN_OwnData = {};
    const targetData = Object.assign(MsgTemplate_zh_CN_Base(), MsgTemplate_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;