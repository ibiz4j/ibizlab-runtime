import WFREModel_BO_CN_Base from './wfremodel_BO_CN_base';

function getLocaleResource(){
    const WFREModel_BO_CN_OwnData = {};
    const targetData = Object.assign(WFREModel_BO_CN_Base(), WFREModel_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;