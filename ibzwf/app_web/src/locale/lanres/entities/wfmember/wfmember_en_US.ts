import WFMember_en_US_Base from './wfmember_en_US_base';

function getLocaleResource(){
    const WFMember_en_US_OwnData = {};
    const targetData = Object.assign(WFMember_en_US_Base(), WFMember_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;