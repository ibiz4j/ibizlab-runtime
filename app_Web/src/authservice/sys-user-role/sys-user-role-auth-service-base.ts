import AuthService from '../auth-service';
import SysUserRoleUIService from '@/uiservice/sys-user-role/sys-user-role-ui-service';

/**
 * 用户角色关系权限服务对象基类
 *
 * @export
 * @class SysUserRoleAuthServiceBase
 * @extends {AuthService}
 */
export default class SysUserRoleAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof SysUserRoleAuthServiceBase
     */
    public sysuserroleUIService:any;

    /**
     * Creates an instance of  SysUserRoleAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysUserRoleAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.sysuserroleUIService = new SysUserRoleUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof SysUserRoleAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.sysuserroleUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}