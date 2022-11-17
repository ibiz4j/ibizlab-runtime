import WFProcessInstance_zh_CN_Base from './wfprocess-instance_zh_CN_base';

function getLocaleResource(){
    const WFProcessInstance_zh_CN_OwnData = {};
    const targetData = Object.assign(WFProcessInstance_zh_CN_Base(), WFProcessInstance_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;