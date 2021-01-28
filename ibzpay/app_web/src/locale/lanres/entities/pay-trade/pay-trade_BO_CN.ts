import PayTrade_BO_CN_Base from './pay-trade_BO_CN_base';

function getLocaleResource(){
    const PayTrade_BO_CN_OwnData = {};
    const targetData = Object.assign(PayTrade_BO_CN_Base(), PayTrade_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;