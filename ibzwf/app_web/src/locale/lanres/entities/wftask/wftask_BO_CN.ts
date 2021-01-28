import WFTask_BO_CN_Base from './wftask_BO_CN_base';

function getLocaleResource(){
    const WFTask_BO_CN_OwnData = {};
    const targetData = Object.assign(WFTask_BO_CN_Base(), WFTask_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;