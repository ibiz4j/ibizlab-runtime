import WFProcessInstance_en_US_Base from './wfprocess-instance_en_US_base';

function getLocaleResource(){
    const WFProcessInstance_en_US_OwnData = {};
    const targetData = Object.assign(WFProcessInstance_en_US_Base(), WFProcessInstance_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;