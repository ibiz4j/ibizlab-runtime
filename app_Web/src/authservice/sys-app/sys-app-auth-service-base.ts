import AuthService from '../auth-service';
import SysAppUIService from '@/uiservice/sys-app/sys-app-ui-service';

/**
 * 应用权限服务对象基类
 *
 * @export
 * @class SysAppAuthServiceBase
 * @extends {AuthService}
 */
export default class SysAppAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof SysAppAuthServiceBase
     */
    public sysappUIService:any;

    /**
     * Creates an instance of  SysAppAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysAppAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.sysappUIService = new SysAppUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof SysAppAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.sysappUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}