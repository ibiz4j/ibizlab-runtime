import AuthService from '../auth-service';
import JobsLogUIService from '@/uiservice/jobs-log/jobs-log-ui-service';

/**
 * 任务调度日志权限服务对象基类
 *
 * @export
 * @class JobsLogAuthServiceBase
 * @extends {AuthService}
 */
export default class JobsLogAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof JobsLogAuthServiceBase
     */
    public jobslogUIService:any;

    /**
     * Creates an instance of  JobsLogAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  JobsLogAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.jobslogUIService = new JobsLogUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof JobsLogAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.jobslogUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}