import WFProcessNode_BO_CN_Base from './wfprocess-node_BO_CN_base';

function getLocaleResource(){
    const WFProcessNode_BO_CN_OwnData = {};
    const targetData = Object.assign(WFProcessNode_BO_CN_Base(), WFProcessNode_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;