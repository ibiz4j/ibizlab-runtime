import WFMember_BO_CN_Base from './wfmember_BO_CN_base';

function getLocaleResource(){
    const WFMember_BO_CN_OwnData = {};
    const targetData = Object.assign(WFMember_BO_CN_Base(), WFMember_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;