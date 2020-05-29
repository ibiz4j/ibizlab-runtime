import { Http,Util } from '@/utils';
import WFSystemServiceBase from './wfsystem-service-base';


/**
 * 系统服务对象
 *
 * @export
 * @class WFSystemService
 * @extends {WFSystemServiceBase}
 */
export default class WFSystemService extends WFSystemServiceBase {

    /**
     * Creates an instance of  WFSystemService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFSystemService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}