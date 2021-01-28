import WFSystem_BO_CN_Base from './wfsystem_BO_CN_base';

function getLocaleResource(){
    const WFSystem_BO_CN_OwnData = {};
    const targetData = Object.assign(WFSystem_BO_CN_Base(), WFSystem_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;