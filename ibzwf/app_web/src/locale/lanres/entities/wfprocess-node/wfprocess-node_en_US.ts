import WFProcessNode_en_US_Base from './wfprocess-node_en_US_base';

function getLocaleResource(){
    const WFProcessNode_en_US_OwnData = {};
    const targetData = Object.assign(WFProcessNode_en_US_Base(), WFProcessNode_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;