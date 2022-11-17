import WFProcessNode_zh_CN_Base from './wfprocess-node_zh_CN_base';

function getLocaleResource(){
    const WFProcessNode_zh_CN_OwnData = {};
    const targetData = Object.assign(WFProcessNode_zh_CN_Base(), WFProcessNode_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;