import AuthService from '../auth-service';
import SysAuthLogUIService from '@/uiservice/sys-auth-log/sys-auth-log-ui-service';

/**
 * 认证日志权限服务对象基类
 *
 * @export
 * @class SysAuthLogAuthServiceBase
 * @extends {AuthService}
 */
export default class SysAuthLogAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof SysAuthLogAuthServiceBase
     */
    public sysauthlogUIService:any;

    /**
     * Creates an instance of  SysAuthLogAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysAuthLogAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.sysauthlogUIService = new SysAuthLogUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof SysAuthLogAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.sysauthlogUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}