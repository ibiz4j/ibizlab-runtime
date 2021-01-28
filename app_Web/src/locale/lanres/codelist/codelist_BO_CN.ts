import codelist_BO_CN_Base from './codelist_BO_CN_base';

function getLocaleResource(){
    const codelist_BO_CN_OwnData = {};
    const targetData = Object.assign(codelist_BO_CN_Base(), codelist_BO_CN_OwnData);
    return targetData;
}
export default getLocaleResource;