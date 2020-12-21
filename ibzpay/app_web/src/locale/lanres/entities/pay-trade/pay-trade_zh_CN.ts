import PayTrade_zh_CN_Base from './pay-trade_zh_CN_base';

function getLocaleResource(){
    const PayTrade_zh_CN_OwnData = {};
    const targetData = Object.assign(PayTrade_zh_CN_Base(), PayTrade_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;