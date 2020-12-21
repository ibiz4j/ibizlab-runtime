import WFTask_en_US_Base from './wftask_en_US_base';

function getLocaleResource(){
    const WFTask_en_US_OwnData = {};
    const targetData = Object.assign(WFTask_en_US_Base(), WFTask_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;