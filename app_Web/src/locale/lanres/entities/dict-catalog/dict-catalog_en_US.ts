import DictCatalog_en_US_Base from './dict-catalog_en_US_base';

function getLocaleResource(){
    const DictCatalog_en_US_OwnData = {};
    const targetData = Object.assign(DictCatalog_en_US_Base(), DictCatalog_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;