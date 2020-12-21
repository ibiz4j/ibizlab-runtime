import WFREModel_zh_CN_Base from './wfremodel_zh_CN_base';

function getLocaleResource(){
    const WFREModel_zh_CN_OwnData = {};
    const targetData = Object.assign(WFREModel_zh_CN_Base(), WFREModel_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;