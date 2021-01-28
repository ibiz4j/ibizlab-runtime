import WFUser_BO_CN_Base from './wfuser_BO_CN_base';

function getLocaleResource(){
    const WFUser_BO_CN_OwnData = {};
    const targetData = Object.assign(WFUser_BO_CN_Base(), WFUser_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;