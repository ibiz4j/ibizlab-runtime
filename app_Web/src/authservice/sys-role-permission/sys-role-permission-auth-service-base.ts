import AuthService from '../auth-service';

/**
 * 角色权限关系权限服务对象基类
 *
 * @export
 * @class SysRolePermissionAuthServiceBase
 * @extends {AuthService}
 */
export default class SysRolePermissionAuthServiceBase extends AuthService {

    /**
     * Creates an instance of  SysRolePermissionAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysRolePermissionAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} mainSateOPPrivs 传入数据操作标识
     * @returns {any}
     * @memberof SysRolePermissionAuthServiceBase
     */
    public getOPPrivs(mainSateOPPrivs:any):any{
        let curDefaultOPPrivs:any = this.getSysOPPrivs();
        let copyDefaultOPPrivs:any = JSON.parse(JSON.stringify(curDefaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        // 统一资源优先
        Object.keys(curDefaultOPPrivs).forEach((name:string) => {
            if(this.sysOPPrivsMap.get(name) && copyDefaultOPPrivs[name] === 0){
                curDefaultOPPrivs[name] = copyDefaultOPPrivs[name];
            }
        });
        return curDefaultOPPrivs;
    }

}