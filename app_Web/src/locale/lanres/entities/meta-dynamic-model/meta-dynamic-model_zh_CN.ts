import MetaDynamicModel_zh_CN_Base from './meta-dynamic-model_zh_CN_base';

function getLocaleResource(){
    const MetaDynamicModel_zh_CN_OwnData = {};
    const targetData = Object.assign(MetaDynamicModel_zh_CN_Base(), MetaDynamicModel_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;