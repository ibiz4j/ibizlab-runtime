import AuthService from '../auth-service';

/**
 * 流程模型权限服务对象基类
 *
 * @export
 * @class WFREModelAuthServiceBase
 * @extends {AuthService}
 */
export default class WFREModelAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  WFREModelAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFREModelAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof WFREModelAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}