import AuthService from '../auth-service';

/**
 * 系统角色权限服务对象基类
 *
 * @export
 * @class SysRoleAuthServiceBase
 * @extends {AuthService}
 */
export default class SysRoleAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  SysRoleAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysRoleAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof SysRoleAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}