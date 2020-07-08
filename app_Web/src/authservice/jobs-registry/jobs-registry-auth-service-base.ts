import AuthService from '../auth-service';
import JobsRegistryUIService from '@/uiservice/jobs-registry/jobs-registry-ui-service';

/**
 * 任务注册信息权限服务对象基类
 *
 * @export
 * @class JobsRegistryAuthServiceBase
 * @extends {AuthService}
 */
export default class JobsRegistryAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof JobsRegistryAuthServiceBase
     */
    public jobsregistryUIService:any;

    /**
     * Creates an instance of  JobsRegistryAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  JobsRegistryAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.jobsregistryUIService = new JobsRegistryUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof JobsRegistryAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.jobsregistryUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}