import MsgUserAccountAuthServiceBase from './msg-user-account-auth-service-base';


/**
 * 绑定消息账号权限服务对象
 *
 * @export
 * @class MsgUserAccountAuthService
 * @extends {MsgUserAccountAuthServiceBase}
 */
export default class MsgUserAccountAuthService extends MsgUserAccountAuthServiceBase {

    /**
     * Creates an instance of  MsgUserAccountAuthService.
     * 
     * @param {*} [opts={}]
     * @memberof  MsgUserAccountAuthService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}