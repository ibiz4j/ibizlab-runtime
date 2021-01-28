import DictCatalog_BO_CN_Base from './dict-catalog_BO_CN_base';

function getLocaleResource(){
    const DictCatalog_BO_CN_OwnData = {};
    const targetData = Object.assign(DictCatalog_BO_CN_Base(), DictCatalog_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;