import AuthService from '../auth-service';

/**
 * 权限/资源权限服务对象基类
 *
 * @export
 * @class SysPermissionAuthServiceBase
 * @extends {AuthService}
 */
export default class SysPermissionAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  SysPermissionAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysPermissionAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof SysPermissionAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}