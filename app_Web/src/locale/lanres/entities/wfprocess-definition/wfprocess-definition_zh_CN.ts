import WFProcessDefinition_zh_CN_Base from './wfprocess-definition_zh_CN_base';

function getLocaleResource(){
    const WFProcessDefinition_zh_CN_OwnData = {};
    const targetData = Object.assign(WFProcessDefinition_zh_CN_Base(), WFProcessDefinition_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;