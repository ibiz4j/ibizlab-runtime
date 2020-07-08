import AuthService from '../auth-service';
import SysRoleUIService from '@/uiservice/sys-role/sys-role-ui-service';

/**
 * 系统角色权限服务对象基类
 *
 * @export
 * @class SysRoleAuthServiceBase
 * @extends {AuthService}
 */
export default class SysRoleAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof SysRoleAuthServiceBase
     */
    public sysroleUIService:any;

    /**
     * Creates an instance of  SysRoleAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysRoleAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.sysroleUIService = new SysRoleUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof SysRoleAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.sysroleUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}