import { Http,Util } from '@/utils';
import SysOpenAccessServiceBase from './sys-open-access-service-base';


/**
 * 第三方认证平台服务对象
 *
 * @export
 * @class SysOpenAccessService
 * @extends {SysOpenAccessServiceBase}
 */
export default class SysOpenAccessService extends SysOpenAccessServiceBase {

    /**
     * Creates an instance of  SysOpenAccessService.
     * 
     * @param {*} [opts={}]
     * @memberof  SysOpenAccessService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}