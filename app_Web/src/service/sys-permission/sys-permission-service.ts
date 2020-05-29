import { Http,Util } from '@/utils';
import SysPermissionServiceBase from './sys-permission-service-base';


/**
 * 权限/资源服务对象
 *
 * @export
 * @class SysPermissionService
 * @extends {SysPermissionServiceBase}
 */
export default class SysPermissionService extends SysPermissionServiceBase {

    /**
     * Creates an instance of  SysPermissionService.
     * 
     * @param {*} [opts={}]
     * @memberof  SysPermissionService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}