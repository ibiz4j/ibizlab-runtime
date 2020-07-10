import AuthService from '../auth-service';

/**
 * 成员权限服务对象基类
 *
 * @export
 * @class WFMemberAuthServiceBase
 * @extends {AuthService}
 */
export default class WFMemberAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  WFMemberAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFMemberAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof WFMemberAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}