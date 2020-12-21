import WFUser_en_US_Base from './wfuser_en_US_base';

function getLocaleResource(){
    const WFUser_en_US_OwnData = {};
    const targetData = Object.assign(WFUser_en_US_Base(), WFUser_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;