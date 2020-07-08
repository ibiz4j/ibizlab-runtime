import AuthService from '../auth-service';
import WFProcessDefinitionUIService from '@/uiservice/wfprocess-definition/wfprocess-definition-ui-service';

/**
 * 流程定义权限服务对象基类
 *
 * @export
 * @class WFProcessDefinitionAuthServiceBase
 * @extends {AuthService}
 */
export default class WFProcessDefinitionAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof WFProcessDefinitionAuthServiceBase
     */
    public wfprocessdefinitionUIService:any;

    /**
     * Creates an instance of  WFProcessDefinitionAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFProcessDefinitionAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.wfprocessdefinitionUIService = new WFProcessDefinitionUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof WFProcessDefinitionAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.wfprocessdefinitionUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}