import AuthService from '../auth-service';
import SysRolePermissionUIService from '@/uiservice/sys-role-permission/sys-role-permission-ui-service';

/**
 * 角色权限关系权限服务对象基类
 *
 * @export
 * @class SysRolePermissionAuthServiceBase
 * @extends {AuthService}
 */
export default class SysRolePermissionAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof SysRolePermissionAuthServiceBase
     */
    public sysrolepermissionUIService:any;

    /**
     * Creates an instance of  SysRolePermissionAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysRolePermissionAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.sysrolepermissionUIService = new SysRolePermissionUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof SysRolePermissionAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.sysrolepermissionUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}