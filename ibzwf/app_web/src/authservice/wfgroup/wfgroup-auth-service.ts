import WFGroupAuthServiceBase from './wfgroup-auth-service-base';


/**
 * 角色/用户组权限服务对象
 *
 * @export
 * @class WFGroupAuthService
 * @extends {WFGroupAuthServiceBase}
 */
export default class WFGroupAuthService extends WFGroupAuthServiceBase {

    /**
     * Creates an instance of  WFGroupAuthService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFGroupAuthService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}