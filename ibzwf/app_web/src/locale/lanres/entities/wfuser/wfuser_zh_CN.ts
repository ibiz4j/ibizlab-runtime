import WFUser_zh_CN_Base from './wfuser_zh_CN_base';

function getLocaleResource(){
    const WFUser_zh_CN_OwnData = {};
    const targetData = Object.assign(WFUser_zh_CN_Base(), WFUser_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;