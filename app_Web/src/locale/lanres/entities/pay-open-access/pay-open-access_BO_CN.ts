import PayOpenAccess_BO_CN_Base from './pay-open-access_BO_CN_base';

function getLocaleResource(){
    const PayOpenAccess_BO_CN_OwnData = {};
    const targetData = Object.assign(PayOpenAccess_BO_CN_Base(), PayOpenAccess_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;