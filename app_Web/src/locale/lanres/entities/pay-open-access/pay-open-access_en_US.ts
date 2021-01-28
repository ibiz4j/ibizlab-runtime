import PayOpenAccess_en_US_Base from './pay-open-access_en_US_base';

function getLocaleResource(){
    const PayOpenAccess_en_US_OwnData = {};
    const targetData = Object.assign(PayOpenAccess_en_US_Base(), PayOpenAccess_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;