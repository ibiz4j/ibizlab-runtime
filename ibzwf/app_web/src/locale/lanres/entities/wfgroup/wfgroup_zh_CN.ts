import WFGroup_zh_CN_Base from './wfgroup_zh_CN_base';

function getLocaleResource(){
    const WFGroup_zh_CN_OwnData = {};
    const targetData = Object.assign(WFGroup_zh_CN_Base(), WFGroup_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;