import DictOption_en_US_Base from './dict-option_en_US_base';

function getLocaleResource(){
    const DictOption_en_US_OwnData = {};
    const targetData = Object.assign(DictOption_en_US_Base(), DictOption_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;