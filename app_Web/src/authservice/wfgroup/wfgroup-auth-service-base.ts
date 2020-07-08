import AuthService from '../auth-service';
import WFGroupUIService from '@/uiservice/wfgroup/wfgroup-ui-service';

/**
 * 角色/用户组权限服务对象基类
 *
 * @export
 * @class WFGroupAuthServiceBase
 * @extends {AuthService}
 */
export default class WFGroupAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof WFGroupAuthServiceBase
     */
    public wfgroupUIService:any;

    /**
     * Creates an instance of  WFGroupAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFGroupAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.wfgroupUIService = new WFGroupUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof WFGroupAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.wfgroupUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}