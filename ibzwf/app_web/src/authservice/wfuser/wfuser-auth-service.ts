import WFUserAuthServiceBase from './wfuser-auth-service-base';


/**
 * 用户权限服务对象
 *
 * @export
 * @class WFUserAuthService
 * @extends {WFUserAuthServiceBase}
 */
export default class WFUserAuthService extends WFUserAuthServiceBase {

    /**
     * Creates an instance of  WFUserAuthService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFUserAuthService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}