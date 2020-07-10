import AuthService from '../auth-service';

/**
 * 流程定义权限服务对象基类
 *
 * @export
 * @class WFProcessDefinitionAuthServiceBase
 * @extends {AuthService}
 */
export default class WFProcessDefinitionAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  WFProcessDefinitionAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFProcessDefinitionAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof WFProcessDefinitionAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}