import AuthService from '../auth-service';
import JobsLockUIService from '@/uiservice/jobs-lock/jobs-lock-ui-service';

/**
 * 任务锁权限服务对象基类
 *
 * @export
 * @class JobsLockAuthServiceBase
 * @extends {AuthService}
 */
export default class JobsLockAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof JobsLockAuthServiceBase
     */
    public jobslockUIService:any;

    /**
     * Creates an instance of  JobsLockAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  JobsLockAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.jobslockUIService = new JobsLockUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof JobsLockAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.jobslockUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}