import { Http,Util } from '@/utils';
import SysEmployeeServiceBase from './sys-employee-service-base';


/**
 * 人员服务对象
 *
 * @export
 * @class SysEmployeeService
 * @extends {SysEmployeeServiceBase}
 */
export default class SysEmployeeService extends SysEmployeeServiceBase {

    /**
     * Creates an instance of  SysEmployeeService.
     * 
     * @param {*} [opts={}]
     * @memberof  SysEmployeeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}