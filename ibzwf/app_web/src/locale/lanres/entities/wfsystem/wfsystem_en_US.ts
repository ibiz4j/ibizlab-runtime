import WFSystem_en_US_Base from './wfsystem_en_US_base';

function getLocaleResource(){
    const WFSystem_en_US_OwnData = {};
    const targetData = Object.assign(WFSystem_en_US_Base(), WFSystem_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;