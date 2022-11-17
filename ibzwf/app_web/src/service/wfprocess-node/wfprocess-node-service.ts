import { Http,Util } from '@/utils';
import WFProcessNodeServiceBase from './wfprocess-node-service-base';


/**
 * 流程定义节点服务对象
 *
 * @export
 * @class WFProcessNodeService
 * @extends {WFProcessNodeServiceBase}
 */
export default class WFProcessNodeService extends WFProcessNodeServiceBase {

    /**
     * Creates an instance of  WFProcessNodeService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFProcessNodeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}