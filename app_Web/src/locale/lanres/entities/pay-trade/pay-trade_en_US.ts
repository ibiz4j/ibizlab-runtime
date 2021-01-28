import PayTrade_en_US_Base from './pay-trade_en_US_base';

function getLocaleResource(){
    const PayTrade_en_US_OwnData = {};
    const targetData = Object.assign(PayTrade_en_US_Base(), PayTrade_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;