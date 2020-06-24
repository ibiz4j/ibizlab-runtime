import { Http,Util } from '@/utils';
import JobsRegistryServiceBase from './jobs-registry-service-base';


/**
 * 任务注册信息服务对象
 *
 * @export
 * @class JobsRegistryService
 * @extends {JobsRegistryServiceBase}
 */
export default class JobsRegistryService extends JobsRegistryServiceBase {

    /**
     * Creates an instance of  JobsRegistryService.
     * 
     * @param {*} [opts={}]
     * @memberof  JobsRegistryService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}