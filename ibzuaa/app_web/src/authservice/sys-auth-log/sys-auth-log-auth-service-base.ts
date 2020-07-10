import AuthService from '../auth-service';

/**
 * 认证日志权限服务对象基类
 *
 * @export
 * @class SysAuthLogAuthServiceBase
 * @extends {AuthService}
 */
export default class SysAuthLogAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  SysAuthLogAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysAuthLogAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof SysAuthLogAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}