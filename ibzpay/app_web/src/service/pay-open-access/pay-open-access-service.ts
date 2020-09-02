import { Http,Util } from '@/utils';
import PayOpenAccessServiceBase from './pay-open-access-service-base';


/**
 * 支付平台服务对象
 *
 * @export
 * @class PayOpenAccessService
 * @extends {PayOpenAccessServiceBase}
 */
export default class PayOpenAccessService extends PayOpenAccessServiceBase {

    /**
     * Creates an instance of  PayOpenAccessService.
     * 
     * @param {*} [opts={}]
     * @memberof  PayOpenAccessService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}