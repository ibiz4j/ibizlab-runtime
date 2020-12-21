import codelist_zh_CN_Base from './codelist_zh_CN_base';

function getLocaleResource(){
    const codelist_zh_CN_OwnData = {};
    const targetData = Object.assign(codelist_zh_CN_Base(), codelist_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;