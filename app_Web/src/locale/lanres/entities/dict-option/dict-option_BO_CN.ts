import DictOption_BO_CN_Base from './dict-option_BO_CN_base';

function getLocaleResource(){
    const DictOption_BO_CN_OwnData = {};
    const targetData = Object.assign(DictOption_BO_CN_Base(), DictOption_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;