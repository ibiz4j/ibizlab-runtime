import AuthService from '../auth-service';

/**
 * 用户权限服务对象基类
 *
 * @export
 * @class WFUserAuthServiceBase
 * @extends {AuthService}
 */
export default class WFUserAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  WFUserAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFUserAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof WFUserAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}