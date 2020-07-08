import JobsLockAuthServiceBase from './jobs-lock-auth-service-base';


/**
 * 任务锁权限服务对象
 *
 * @export
 * @class JobsLockAuthService
 * @extends {JobsLockAuthServiceBase}
 */
export default class JobsLockAuthService extends JobsLockAuthServiceBase {

    /**
     * Creates an instance of  JobsLockAuthService.
     * 
     * @param {*} [opts={}]
     * @memberof  JobsLockAuthService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}