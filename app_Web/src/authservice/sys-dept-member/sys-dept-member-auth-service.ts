import SysDeptMemberAuthServiceBase from './sys-dept-member-auth-service-base';


/**
 * 部门成员权限服务对象
 *
 * @export
 * @class SysDeptMemberAuthService
 * @extends {SysDeptMemberAuthServiceBase}
 */
export default class SysDeptMemberAuthService extends SysDeptMemberAuthServiceBase {

    /**
     * Creates an instance of  SysDeptMemberAuthService.
     * 
     * @param {*} [opts={}]
     * @memberof  SysDeptMemberAuthService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}