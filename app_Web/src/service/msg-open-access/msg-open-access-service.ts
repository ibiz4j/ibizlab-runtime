import { Http,Util } from '@/utils';
import MsgOpenAccessServiceBase from './msg-open-access-service-base';


/**
 * 接入开放平台服务对象
 *
 * @export
 * @class MsgOpenAccessService
 * @extends {MsgOpenAccessServiceBase}
 */
export default class MsgOpenAccessService extends MsgOpenAccessServiceBase {

    /**
     * Creates an instance of  MsgOpenAccessService.
     * 
     * @param {*} [opts={}]
     * @memberof  MsgOpenAccessService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}