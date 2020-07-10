import AuthService from '../auth-service';

/**
 * 任务注册信息权限服务对象基类
 *
 * @export
 * @class JobsRegistryAuthServiceBase
 * @extends {AuthService}
 */
export default class JobsRegistryAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  JobsRegistryAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  JobsRegistryAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof JobsRegistryAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}