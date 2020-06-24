import { Http,Util } from '@/utils';
import IBZPostServiceBase from './ibzpost-service-base';


/**
 * 岗位服务对象
 *
 * @export
 * @class IBZPostService
 * @extends {IBZPostServiceBase}
 */
export default class IBZPostService extends IBZPostServiceBase {

    /**
     * Creates an instance of  IBZPostService.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZPostService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}