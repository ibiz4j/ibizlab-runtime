import codelist_en_US_Base from './codelist_en_US_base';

function getLocaleResource(){
    const codelist_en_US_OwnData = {};
    const targetData = Object.assign(codelist_en_US_Base(), codelist_en_US_OwnData);
    return targetData;
}
export default getLocaleResource;