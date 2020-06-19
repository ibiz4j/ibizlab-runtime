import { Http,Util } from '@/utils';
import JobsLogServiceBase from './jobs-log-service-base';


/**
 * 任务调度日志服务对象
 *
 * @export
 * @class JobsLogService
 * @extends {JobsLogServiceBase}
 */
export default class JobsLogService extends JobsLogServiceBase {

    /**
     * Creates an instance of  JobsLogService.
     * 
     * @param {*} [opts={}]
     * @memberof  JobsLogService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}