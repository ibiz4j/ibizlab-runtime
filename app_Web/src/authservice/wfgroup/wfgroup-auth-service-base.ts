import AuthService from '../auth-service';

/**
 * 角色/用户组权限服务对象基类
 *
 * @export
 * @class WFGroupAuthServiceBase
 * @extends {AuthService}
 */
export default class WFGroupAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  WFGroupAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFGroupAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof WFGroupAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = this.getSysOPPrivs();
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}