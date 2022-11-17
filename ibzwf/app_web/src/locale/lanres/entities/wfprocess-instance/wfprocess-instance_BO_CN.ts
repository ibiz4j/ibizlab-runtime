import WFProcessInstance_BO_CN_Base from './wfprocess-instance_BO_CN_base';

function getLocaleResource(){
    const WFProcessInstance_BO_CN_OwnData = {};
    const targetData = Object.assign(WFProcessInstance_BO_CN_Base(), WFProcessInstance_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;