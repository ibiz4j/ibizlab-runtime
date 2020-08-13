import AuthService from '../auth-service';

/**
 * 工作流任务权限服务对象基类
 *
 * @export
 * @class WFTaskAuthServiceBase
 * @extends {AuthService}
 */
export default class WFTaskAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  WFTaskAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFTaskAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof WFTaskAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = this.getSysOPPrivs();
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}