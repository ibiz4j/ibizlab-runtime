import { Http,Util } from '@/utils';
import WFProcessInstanceServiceBase from './wfprocess-instance-service-base';


/**
 * 流程实例服务对象
 *
 * @export
 * @class WFProcessInstanceService
 * @extends {WFProcessInstanceServiceBase}
 */
export default class WFProcessInstanceService extends WFProcessInstanceServiceBase {

    /**
     * Creates an instance of  WFProcessInstanceService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFProcessInstanceService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}