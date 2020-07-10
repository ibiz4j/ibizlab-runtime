import AuthService from '../auth-service';

/**
 * 系统权限服务对象基类
 *
 * @export
 * @class WFSystemAuthServiceBase
 * @extends {AuthService}
 */
export default class WFSystemAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  WFSystemAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFSystemAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof WFSystemAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}