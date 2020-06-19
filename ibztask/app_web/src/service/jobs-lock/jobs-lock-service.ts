import { Http,Util } from '@/utils';
import JobsLockServiceBase from './jobs-lock-service-base';


/**
 * 任务锁服务对象
 *
 * @export
 * @class JobsLockService
 * @extends {JobsLockServiceBase}
 */
export default class JobsLockService extends JobsLockServiceBase {

    /**
     * Creates an instance of  JobsLockService.
     * 
     * @param {*} [opts={}]
     * @memberof  JobsLockService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}