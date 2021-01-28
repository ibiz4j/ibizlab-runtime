import WFGroup_BO_CN_Base from './wfgroup_BO_CN_base';

function getLocaleResource(){
    const WFGroup_BO_CN_OwnData = {};
    const targetData = Object.assign(WFGroup_BO_CN_Base(), WFGroup_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;