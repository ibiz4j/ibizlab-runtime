import { Http,Util } from '@/utils';
import WFGroupServiceBase from './wfgroup-service-base';


/**
 * 角色/用户组服务对象
 *
 * @export
 * @class WFGroupService
 * @extends {WFGroupServiceBase}
 */
export default class WFGroupService extends WFGroupServiceBase {

    /**
     * Creates an instance of  WFGroupService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFGroupService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}