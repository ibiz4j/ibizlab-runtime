import MetaDynamicModel_en_US_Base from './meta-dynamic-model_en_US_base';

function getLocaleResource(){
    const MetaDynamicModel_en_US_OwnData = {};
    const targetData = Object.assign(MetaDynamicModel_en_US_Base(), MetaDynamicModel_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;