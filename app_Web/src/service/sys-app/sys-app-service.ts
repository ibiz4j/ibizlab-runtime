import { Http,Util } from '@/utils';
import SysAppServiceBase from './sys-app-service-base';


/**
 * 应用服务对象
 *
 * @export
 * @class SysAppService
 * @extends {SysAppServiceBase}
 */
export default class SysAppService extends SysAppServiceBase {

    /**
     * Creates an instance of  SysAppService.
     * 
     * @param {*} [opts={}]
     * @memberof  SysAppService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}