import { Http,Util } from '@/utils';
import MsgUserAccountServiceBase from './msg-user-account-service-base';


/**
 * 绑定消息账号服务对象
 *
 * @export
 * @class MsgUserAccountService
 * @extends {MsgUserAccountServiceBase}
 */
export default class MsgUserAccountService extends MsgUserAccountServiceBase {

    /**
     * Creates an instance of  MsgUserAccountService.
     * 
     * @param {*} [opts={}]
     * @memberof  MsgUserAccountService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}