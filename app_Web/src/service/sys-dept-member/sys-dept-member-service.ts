import { Http,Util } from '@/utils';
import SysDeptMemberServiceBase from './sys-dept-member-service-base';


/**
 * 部门成员服务对象
 *
 * @export
 * @class SysDeptMemberService
 * @extends {SysDeptMemberServiceBase}
 */
export default class SysDeptMemberService extends SysDeptMemberServiceBase {

    /**
     * Creates an instance of  SysDeptMemberService.
     * 
     * @param {*} [opts={}]
     * @memberof  SysDeptMemberService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}