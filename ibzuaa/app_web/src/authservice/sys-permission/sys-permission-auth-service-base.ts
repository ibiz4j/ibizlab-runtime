import AuthService from '../auth-service';
import SysPermissionUIService from '@/uiservice/sys-permission/sys-permission-ui-service';

/**
 * 权限/资源权限服务对象基类
 *
 * @export
 * @class SysPermissionAuthServiceBase
 * @extends {AuthService}
 */
export default class SysPermissionAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof SysPermissionAuthServiceBase
     */
    public syspermissionUIService:any;

    /**
     * Creates an instance of  SysPermissionAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysPermissionAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.syspermissionUIService = new SysPermissionUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof SysPermissionAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.syspermissionUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}