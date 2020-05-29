import { Http,Util } from '@/utils';
import SysUserRoleServiceBase from './sys-user-role-service-base';


/**
 * 用户角色关系服务对象
 *
 * @export
 * @class SysUserRoleService
 * @extends {SysUserRoleServiceBase}
 */
export default class SysUserRoleService extends SysUserRoleServiceBase {

    /**
     * Creates an instance of  SysUserRoleService.
     * 
     * @param {*} [opts={}]
     * @memberof  SysUserRoleService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}