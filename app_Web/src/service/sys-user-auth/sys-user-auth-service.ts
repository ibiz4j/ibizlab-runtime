import { Http,Util } from '@/utils';
import SysUserAuthServiceBase from './sys-user-auth-service-base';


/**
 * 账号绑定服务对象
 *
 * @export
 * @class SysUserAuthService
 * @extends {SysUserAuthServiceBase}
 */
export default class SysUserAuthService extends SysUserAuthServiceBase {

    /**
     * Creates an instance of  SysUserAuthService.
     * 
     * @param {*} [opts={}]
     * @memberof  SysUserAuthService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}