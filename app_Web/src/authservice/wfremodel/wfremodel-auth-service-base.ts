import AuthService from '../auth-service';
import WFREModelUIService from '@/uiservice/wfremodel/wfremodel-ui-service';

/**
 * 流程模型权限服务对象基类
 *
 * @export
 * @class WFREModelAuthServiceBase
 * @extends {AuthService}
 */
export default class WFREModelAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof WFREModelAuthServiceBase
     */
    public wfremodelUIService:any;

    /**
     * Creates an instance of  WFREModelAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFREModelAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.wfremodelUIService = new WFREModelUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof WFREModelAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.wfremodelUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}