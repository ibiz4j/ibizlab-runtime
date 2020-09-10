import { Http,Util } from '@/utils';
import PayTradeServiceBase from './pay-trade-service-base';


/**
 * 支付交易1服务对象
 *
 * @export
 * @class PayTradeService
 * @extends {PayTradeServiceBase}
 */
export default class PayTradeService extends PayTradeServiceBase {

    /**
     * Creates an instance of  PayTradeService.
     * 
     * @param {*} [opts={}]
     * @memberof  PayTradeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}