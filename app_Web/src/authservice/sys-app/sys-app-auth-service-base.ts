import AuthService from '../auth-service';

/**
 * 应用权限服务对象基类
 *
 * @export
 * @class SysAppAuthServiceBase
 * @extends {AuthService}
 */
export default class SysAppAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  SysAppAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysAppAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof SysAppAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}