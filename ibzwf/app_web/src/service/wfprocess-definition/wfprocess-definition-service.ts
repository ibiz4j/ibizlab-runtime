import { Http,Util } from '@/utils';
import WFProcessDefinitionServiceBase from './wfprocess-definition-service-base';


/**
 * 流程定义服务对象
 *
 * @export
 * @class WFProcessDefinitionService
 * @extends {WFProcessDefinitionServiceBase}
 */
export default class WFProcessDefinitionService extends WFProcessDefinitionServiceBase {

    /**
     * Creates an instance of  WFProcessDefinitionService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFProcessDefinitionService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}