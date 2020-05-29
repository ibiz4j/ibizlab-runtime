import { Http,Util } from '@/utils';
import SysRolePermissionServiceBase from './sys-role-permission-service-base';


/**
 * 角色权限关系服务对象
 *
 * @export
 * @class SysRolePermissionService
 * @extends {SysRolePermissionServiceBase}
 */
export default class SysRolePermissionService extends SysRolePermissionServiceBase {

    /**
     * Creates an instance of  SysRolePermissionService.
     * 
     * @param {*} [opts={}]
     * @memberof  SysRolePermissionService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}