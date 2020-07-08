import AuthService from '../auth-service';
import SysUserUIService from '@/uiservice/sys-user/sys-user-ui-service';

/**
 * 系统用户权限服务对象基类
 *
 * @export
 * @class SysUserAuthServiceBase
 * @extends {AuthService}
 */
export default class SysUserAuthServiceBase extends AuthService {

    /**
     * 所依赖UI服务
     *
     * @memberof SysUserAuthServiceBase
     */
    public sysuserUIService:any;

    /**
     * Creates an instance of  SysUserAuthServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SysUserAuthServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.sysuserUIService = new SysUserUIService(opts);
    }

    /**
     * 根据当前数据获取实体操作标识
     *
     * @param {*} data 传入数据
     * @returns {any}
     * @memberof SysUserAuthServiceBase
     */
    public getOPPrivs(data:any):any{
        let mainSateOPPrivs:any = this.sysuserUIService.getDEMainStateOPPrivs(data);
        let curDefaultOPPrivs:any = JSON.parse(JSON.stringify(this.defaultOPPrivs));
        if(mainSateOPPrivs){
            Object.assign(curDefaultOPPrivs,mainSateOPPrivs);
        }
        return curDefaultOPPrivs;
    }

}