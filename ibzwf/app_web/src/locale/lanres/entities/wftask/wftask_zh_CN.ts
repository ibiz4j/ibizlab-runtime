import WFTask_zh_CN_Base from './wftask_zh_CN_base';

function getLocaleResource(){
    const WFTask_zh_CN_OwnData = {};
    const targetData = Object.assign(WFTask_zh_CN_Base(), WFTask_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;