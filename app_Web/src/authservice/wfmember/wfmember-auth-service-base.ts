import AuthService from '../auth-service';
import WFMemberUIService from '@/uiservice/wfmember/wfmember-ui-service';

/**
 * 成员权限服务对象基类
 *
 * @export
 * @class WFMemberAuthServiceBase
 * @extends {AuthService}
 */
export default class WFMemberAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof WFMemberAuthServiceBase
     */
    public wfmemberUIService:any;

    /**
     * Creates an instance of  WFMemberAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  WFMemberAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.wfmemberUIService = new WFMemberUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof WFMemberAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.wfmemberUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}