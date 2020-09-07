import { Http,Util } from '@/utils';
import SysDepartmentServiceBase from './sys-department-service-base';


/**
 * 部门服务对象
 *
 * @export
 * @class SysDepartmentService
 * @extends {SysDepartmentServiceBase}
 */
export default class SysDepartmentService extends SysDepartmentServiceBase {

    /**
     * Creates an instance of  SysDepartmentService.
     * 
     * @param {*} [opts={}]
     * @memberof  SysDepartmentService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}