import DictOption_zh_CN_Base from './dict-option_zh_CN_base';

function getLocaleResource(){
    const DictOption_zh_CN_OwnData = {};
    const targetData = Object.assign(DictOption_zh_CN_Base(), DictOption_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;