import AuthService from '../auth-service';

/**
 * 系统用户权限服务对象基类
 *
 * @export
 * @class SysUserAuthServiceBase
 * @extends {AuthService}
 */
export default class SysUserAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  SysUserAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysUserAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof SysUserAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}