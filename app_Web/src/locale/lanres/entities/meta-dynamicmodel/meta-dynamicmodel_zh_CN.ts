import META_DYNAMICMODEL_zh_CN_Base from './meta-dynamicmodel_zh_CN_base';

function getLocaleResource(){
    const META_DYNAMICMODEL_zh_CN_OwnData = {};
    const targetData = Object.assign(META_DYNAMICMODEL_zh_CN_Base(), META_DYNAMICMODEL_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;