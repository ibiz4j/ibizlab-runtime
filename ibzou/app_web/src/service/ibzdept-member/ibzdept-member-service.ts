import { Http,Util } from '@/utils';
import IBZDeptMemberServiceBase from './ibzdept-member-service-base';


/**
 * 部门成员服务对象
 *
 * @export
 * @class IBZDeptMemberService
 * @extends {IBZDeptMemberServiceBase}
 */
export default class IBZDeptMemberService extends IBZDeptMemberServiceBase {

    /**
     * Creates an instance of  IBZDeptMemberService.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZDeptMemberService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}