import { Http,Util } from '@/utils';
import IBZEmployeeServiceBase from './ibzemployee-service-base';


/**
 * 人员服务对象
 *
 * @export
 * @class IBZEmployeeService
 * @extends {IBZEmployeeServiceBase}
 */
export default class IBZEmployeeService extends IBZEmployeeServiceBase {

    /**
     * Creates an instance of  IBZEmployeeService.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZEmployeeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}