import { Http,Util } from '@/utils';
import SysRoleServiceBase from './sys-role-service-base';


/**
 * 系统角色服务对象
 *
 * @export
 * @class SysRoleService
 * @extends {SysRoleServiceBase}
 */
export default class SysRoleService extends SysRoleServiceBase {

    /**
     * Creates an instance of  SysRoleService.
     * 
     * @param {*} [opts={}]
     * @memberof  SysRoleService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}