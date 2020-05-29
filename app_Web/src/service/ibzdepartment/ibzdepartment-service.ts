import { Http,Util } from '@/utils';
import IBZDepartmentServiceBase from './ibzdepartment-service-base';


/**
 * 部门服务对象
 *
 * @export
 * @class IBZDepartmentService
 * @extends {IBZDepartmentServiceBase}
 */
export default class IBZDepartmentService extends IBZDepartmentServiceBase {

    /**
     * Creates an instance of  IBZDepartmentService.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZDepartmentService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}