import { Http,Util } from '@/utils';
import SysUserServiceBase from './sys-user-service-base';


/**
 * 系统用户服务对象
 *
 * @export
 * @class SysUserService
 * @extends {SysUserServiceBase}
 */
export default class SysUserService extends SysUserServiceBase {

    /**
     * Creates an instance of  SysUserService.
     * 
     * @param {*} [opts={}]
     * @memberof  SysUserService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}