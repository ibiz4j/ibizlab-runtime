import WFProcessDefinition_BO_CN_Base from './wfprocess-definition_BO_CN_base';

function getLocaleResource(){
    const WFProcessDefinition_BO_CN_OwnData = {};
    const targetData = Object.assign(WFProcessDefinition_BO_CN_Base(), WFProcessDefinition_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;