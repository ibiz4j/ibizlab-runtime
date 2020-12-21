import PayOpenAccess_zh_CN_Base from './pay-open-access_zh_CN_base';

function getLocaleResource(){
    const PayOpenAccess_zh_CN_OwnData = {};
    const targetData = Object.assign(PayOpenAccess_zh_CN_Base(), PayOpenAccess_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;