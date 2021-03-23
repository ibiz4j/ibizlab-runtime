import MetaDynamicModel_BO_CN_Base from './meta-dynamic-model_BO_CN_base';

function getLocaleResource(){
    const MetaDynamicModel_BO_CN_OwnData = {};
    const targetData = Object.assign(MetaDynamicModel_BO_CN_Base(), MetaDynamicModel_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;