import DictCatalog_zh_CN_Base from './dict-catalog_zh_CN_base';

function getLocaleResource(){
    const DictCatalog_zh_CN_OwnData = {};
    const targetData = Object.assign(DictCatalog_zh_CN_Base(), DictCatalog_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;