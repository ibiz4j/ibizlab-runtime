import WFProcessDefinition_en_US_Base from './wfprocess-definition_en_US_base';

function getLocaleResource(){
    const WFProcessDefinition_en_US_OwnData = {};
    const targetData = Object.assign(WFProcessDefinition_en_US_Base(), WFProcessDefinition_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;