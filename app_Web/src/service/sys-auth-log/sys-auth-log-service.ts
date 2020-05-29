import { Http,Util } from '@/utils';
import SysAuthLogServiceBase from './sys-auth-log-service-base';


/**
 * 认证日志服务对象
 *
 * @export
 * @class SysAuthLogService
 * @extends {SysAuthLogServiceBase}
 */
export default class SysAuthLogService extends SysAuthLogServiceBase {

    /**
     * Creates an instance of  SysAuthLogService.
     * 
     * @param {*} [opts={}]
     * @memberof  SysAuthLogService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}