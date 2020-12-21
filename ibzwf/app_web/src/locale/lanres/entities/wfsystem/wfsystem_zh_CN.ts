import WFSystem_zh_CN_Base from './wfsystem_zh_CN_base';

function getLocaleResource(){
    const WFSystem_zh_CN_OwnData = {};
    const targetData = Object.assign(WFSystem_zh_CN_Base(), WFSystem_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;