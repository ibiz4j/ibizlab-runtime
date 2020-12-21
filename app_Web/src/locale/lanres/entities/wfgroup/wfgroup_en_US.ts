import WFGroup_en_US_Base from './wfgroup_en_US_base';

function getLocaleResource(){
    const WFGroup_en_US_OwnData = {};
    const targetData = Object.assign(WFGroup_en_US_Base(), WFGroup_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;