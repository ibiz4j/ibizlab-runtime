import { Http,Util } from '@/utils';
import WFTaskServiceBase from './wftask-service-base';


/**
 * 工作流任务服务对象
 *
 * @export
 * @class WFTaskService
 * @extends {WFTaskServiceBase}
 */
export default class WFTaskService extends WFTaskServiceBase {

    /**
     * Creates an instance of  WFTaskService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFTaskService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}