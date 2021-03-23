import META_DYNAMICMODEL_en_US_Base from './meta-dynamicmodel_en_US_base';

function getLocaleResource(){
    const META_DYNAMICMODEL_en_US_OwnData = {};
    const targetData = Object.assign(META_DYNAMICMODEL_en_US_Base(), META_DYNAMICMODEL_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;