import AuthService from '../auth-service';
import JobsInfoUIService from '@/uiservice/jobs-info/jobs-info-ui-service';

/**
 * 任务信息权限服务对象基类
 *
 * @export
 * @class JobsInfoAuthServiceBase
 * @extends {AuthService}
 */
export default class JobsInfoAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof JobsInfoAuthServiceBase
     */
    public jobsinfoUIService:any;

    /**
     * Creates an instance of  JobsInfoAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  JobsInfoAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.jobsinfoUIService = new JobsInfoUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof JobsInfoAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.jobsinfoUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}