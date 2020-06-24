import { Http,Util } from '@/utils';
import JobsInfoServiceBase from './jobs-info-service-base';


/**
 * 任务信息服务对象
 *
 * @export
 * @class JobsInfoService
 * @extends {JobsInfoServiceBase}
 */
export default class JobsInfoService extends JobsInfoServiceBase {

    /**
     * Creates an instance of  JobsInfoService.
     * 
     * @param {*} [opts={}]
     * @memberof  JobsInfoService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}