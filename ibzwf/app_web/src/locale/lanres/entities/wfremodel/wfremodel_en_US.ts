import WFREModel_en_US_Base from './wfremodel_en_US_base';

function getLocaleResource(){
    const WFREModel_en_US_OwnData = {};
    const targetData = Object.assign(WFREModel_en_US_Base(), WFREModel_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;