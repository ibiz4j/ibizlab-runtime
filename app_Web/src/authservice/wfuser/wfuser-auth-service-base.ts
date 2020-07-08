import AuthService from '../auth-service';
import WFUserUIService from '@/uiservice/wfuser/wfuser-ui-service';

/**
 * 用户权限服务对象基类
 *
 * @export
 * @class WFUserAuthServiceBase
 * @extends {AuthService}
 */
export default class WFUserAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof WFUserAuthServiceBase
     */
    public wfuserUIService:any;

    /**
     * Creates an instance of  WFUserAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFUserAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.wfuserUIService = new WFUserUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof WFUserAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.wfuserUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}