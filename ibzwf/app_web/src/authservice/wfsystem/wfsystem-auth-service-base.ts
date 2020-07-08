import AuthService from '../auth-service';
import WFSystemUIService from '@/uiservice/wfsystem/wfsystem-ui-service';

/**
 * 系统权限服务对象基类
 *
 * @export
 * @class WFSystemAuthServiceBase
 * @extends {AuthService}
 */
export default class WFSystemAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof WFSystemAuthServiceBase
     */
    public wfsystemUIService:any;

    /**
     * Creates an instance of  WFSystemAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFSystemAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.wfsystemUIService = new WFSystemUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof WFSystemAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.wfsystemUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}