import { Http,Util } from '@/utils';
import WFMemberServiceBase from './wfmember-service-base';


/**
 * 成员服务对象
 *
 * @export
 * @class WFMemberService
 * @extends {WFMemberServiceBase}
 */
export default class WFMemberService extends WFMemberServiceBase {

    /**
     * Creates an instance of  WFMemberService.
     * 
     * @param {*} [opts={}]
     * @memberof  WFMemberService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}