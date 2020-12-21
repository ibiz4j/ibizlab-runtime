import WFMember_zh_CN_Base from './wfmember_zh_CN_base';

function getLocaleResource(){
    const WFMember_zh_CN_OwnData = {};
    const targetData = Object.assign(WFMember_zh_CN_Base(), WFMember_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;